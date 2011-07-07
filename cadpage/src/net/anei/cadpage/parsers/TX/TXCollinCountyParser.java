package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/* 
Collin County, TX
Contact: Jeremy Sexton <jeremy80xx@yahoo.com>
Contact: Chris Herbst <cherbstlcfd@gmail.com>
Sender: ccsodispatch@co.collin.tx.us

11048794  FIRE PUBLIC ASSIST  2701 ASPEN CT IN COLLIN COUNTY  COUNTY ROAD 392  [LCFD DIST: LCF1 GRID: 1322]  UNITS: LCF1  ST RMK: 7K4  CFS RMK 22:10 REQ FD TO CHECK BP...40 YRO FEMALE.   {CAD001 22:13}
11031079 First Responders 3274 Almeta LN in Collin County FM 546 [LCFD DIST: LCF1 GRID: 1331]
11047502 INJURED PERSON 3610 FM 546 IN COLLIN COUNTY COUNTY ROAD 398 / COUNTY RO;16AD 394 [LCFD DIST: LCF1 GRID: 1322] UNITS: AMRP LCF1 ST RMK: <NONE> CFS RMK 19:16 MALE SUB BLEEDING FROM HIS THROAT {CAD004 19:17} 
11047405 FISRT RESPONDERS 2897 COUNTY ROAD 914 IN COLLIN COUNTY COUNTY ROAD 392 [LCFD DIST: LCF1 GRID: 1322] UNITS: LCF1 AMRP ST RMK: DUTCH ACRES CFS RMK 12:59 68 YOA FALLEN IN FRONT YARD UNABLE T {CAD001 13:00}
11046597 MAJOR ACCIDENT 10/50 COUNTY ROAD 393 / FM 546 IN COLLIN COUNTY [LCFD DIST: LCF1 GRID: 1322] UNITS: LCF1 ST RMK: 8J1 CFS RMK 21:40 SOMEONE HAS FALLEN OUT OF A TRUCK {CAD004 21:40}
11044587 FIRST RESPONDERS 730 CROSS TIMBERS DR IN LOWRY CROSSING CROSS TRAIL LN [LCFD DIST: LCF1 GRID: 3100] UNITS: LCF1 AMRP ST RMK: <NONE> CFS RMK 13:14 37 YOA MALE / FELL YESTERDAY AND IS {CAD004 13:14}
11056387  TRASH FIRE  2701 PECAN CT IN COLLIN COUNTY  COUNTY ROAD 392  [LCFD DIST: LCF1 GRID: 1322]  UNITS: LCF1  ST RMK: <NONE>  CFS RMK 15:09 8 HOUSES DOWN  ITEMS LEFT OVER FR A   {CAD004 15:09}
11055307  MEDICATION OVERDOSE  415 S BRIDGEFARMER RD IN LOWRY CROSSING  E US HIGHWAY 380 / COUNTY ROAD 403  [LCFD DIST: LCF1 GRID: 3100]  UNITS: LCF2  ST RMK: 10J3  CFS RMK 19:34 36 YOA FEMALE TOOK SOMETYPE OF SLEEP  {CAD004 19:35}
11044930  FIRST RESPONDERS  3737 E UNIVERSITY DR IN COLLIN COUNTY  COUNTY ROAD 407 / COUNTY ROAD 404  [LCFD DIST: LCF1 GRID: 1211]  UNITS: LCF1  ST RMK: <NONE>  CFS RMK 17:52 7 YOA FEMALE WITH ABDOMINAL PAINS///  {CAD004 17:52}
11046597  MAJOR ACCIDENT 10/50  COUNTY ROAD 393  /  FM 546 IN COLLIN COUNTY [LCFD DIST: LCF1 GRID: 1322]  UNITS: LCF1  ST RMK: 8J1  CFS RMK 21:40 SOMEONE HAS FALLEN OUT OF A TRUCK  {CAD004 21:40}

11056128  GRASS FIRE  10753 COUNTY ROAD 903 IN COLLIN COUNTY  COUNTY ROAD 902  UNITS: BRF1  ST RMK: <NONE>  CFS RMK 21:52 RIGHT ON

Message From Dispatch 11043265  MAJOR ACCIDENT 10/50  COUNTY ROAD 398  / COUNTY ROAD 447 IN COLLIN COUNTY  [CCSO DIST: 131 GRID: 1322]  UNITS: 1206 131B AMRF LCF1  ST RMK: 8K4  CFS RMK 16:24 CAR ON IT'S ROOF ON CR 398....UNK IF  {C (01/02)
Message From Dispatch 11039781  INJURED PERSON  2665 BRIAR TR IN COLLIN COUNTY  COUNTY ROAD 324  [CCSO DIST: 131 GRID: 1331]  UNITS: AMRP LCF1  ST RMK: 8H2  CFS RMK 13:54 RP HAS FALLEN AND AND INJURIED BOTH   {CAD003 14:01}

*/

public class TXCollinCountyParser extends FieldProgramParser {
  
  private static final Pattern DIST_GRID_PTN = Pattern.compile("\\[([A-Z]+) DIST: .* GRID: (\\d+) *\\]");
  
  private static final String[] DOUBLE_CITY_LIST = new String[] {
    "COLLIN COUNTY",
    "BLUE RIDGE",
    "LOWRY CROSSING",
    "ROYSE CITY",
    "ST PAUL",
    "VAN ALSTYNE",
  };
  
  public TXCollinCountyParser() {
    super("COLLIN COUNTY", "TX",
        "( ID CALL ADDR+? X | MASH ) UNITS:UNIT ST_RMK:INFO CFS_RMK:INFO");
  }
  
  @Override
  public String getFilter() {
    return "ccsodispatch@co.collin.tx.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.startsWith("Message From Dispatch ")) body = body.substring(22).trim();

    // Remove trailing ID
    int pt = body.lastIndexOf('{');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // Some variants include the source and map code in square brackets
    // If this is one of those, extract that information and remove the
    // square bracket construct
    Matcher match = DIST_GRID_PTN.matcher(body);
    if (match.find()) {
      data.strSource = match.group(1).trim();
      data.strMap = match.group(2).trim();
      body = body.substring(0,match.start()) + body.substring(match.end());
    }
    
    // It seems that the original dispatch message uses double blanks as field
    // delimiters, but that some helpful? forwarding services are eliminating
    // the redundant blanks.  If this text message has the original double
    // blank delimiters, we can call parseFields to finsh things off
    sAddress = "";
    body = body.replace("CFS RMK ", "CFS RMK: ");
    String[] flds = body.split("  +");
    if (flds.length >= 5) {
      if (!parseFields(flds, data)) return false;
    } else {
      if (!super.parseMsg(body, data)) return false;
    }
    
    if (data.strCity.equals("COLLIN COUNTY")) data.strCity = "";
    return data.strAddress.length() > 0;
  }
  
  private static final Pattern ID_PTN = Pattern.compile("\\d{8}");
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(ID_PTN);
    }
  }

  private String sAddress;
  private class MyAddressField extends AddressField {
    
    
    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      
      // This is a repeating field that should accumulate an address field
      // until it contains the " IN " marker
      if (data.strAddress.length() > 0) return false;
      sAddress = append(sAddress, " ", field);
      int pt = sAddress.indexOf(" IN ");
      if (pt < 0) return true;
      
      parseAddress(sAddress.substring(0,pt).trim(), data);
      data.strCity = sAddress.substring(pt+4).trim();
      return true;
    }
  }
  
  // Parse a mashup of ID, CALL, ADDR, CITY, and Cross streets in which the
  // double blank delimiters have been removed
  private static final Pattern MASH_PTN = Pattern.compile("(\\d{8}) +(.*)(?: IN | in )(.*)");
  private class MashField extends Field {
    @Override
    public void parse(String field, Data data) {
      
      // Start with easy stuff.  ID is always the first token
      // and call/address and city/cross are separated with a " IN " marker
      Matcher match = MASH_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      
      // Use smart parser to separate call and address
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, match.group(2).trim(), data);
      
      String sTail = match.group(3).toUpperCase();
      for (String tc : DOUBLE_CITY_LIST) {
        if (sTail.startsWith(tc)) {
          data.strCity = tc;
          data.strCross = sTail.substring(tc.length()).trim();
          return;
        }
      }
      
      Parser p = new Parser(sTail);
      data.strCity = p.get(' ');
      data.strCross = p.get();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MASH")) return new MashField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID CALL ADDR CITY X SRC MAP UNIT INFO";
  }
  
//  
//  private static final String[] CITY_LIST = new String[] {
//    "COLLIN COUNTY",
//    "ALLEN",
//    "ANNA",
//    "BLUE RIDGE",
//    "CARROLLTON",
//    "CELINA",
//    "COPEVILLE ",
//    "DALLAS",
//    "FAIRVIEW",
//    "FARMERSVILLE",
//    "FRISCO",
//    "GARLAND",
//    "JOSEPHINE",
//    "LAVON",
//    "LOWRY CROSSING",
//    "LUCAS",
//    "MCKINNEY",
//    "MELISSA",
//    "MURPHY",
//    "NEVADA",
//    "NEW HOPE",
//    "PARKER",
//    "PLANO",
//    "PRINCETON",
//    "PROSPER",
//    "RICHARDSON",
//    ROYSE CITY",
//    "SACHSE",
//    "ST PAUL",
//    "VAN ALSTYNE",
//    "WESTMINSTER ",
//    "WESTON",
//    "WYLIE"
//  };
}
