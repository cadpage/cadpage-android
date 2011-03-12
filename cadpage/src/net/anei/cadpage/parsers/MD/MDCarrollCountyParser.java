package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Carroll County, MD
Contact: Shawn <countryfireman@gmail.com>
Contact: Brett Pearce <brett.a.pearce@gmail.com>
Sender: @c-msg.net

(Co12) [!] CT:UC 6513 CARROLL HIGHLANDS RD SYKE BOX:1211 DUE:X127 E123 [66]
(Co12) [!] CT:BLS SHOPPERS FOOD WHSE @6300 GEORGETOWN BLVD SYKE BOX:1224 DUE:X128 [69]
(Co12) [!] CT:BLS 5584 COMPTON LA SYKE BOX:1214 DUE:X129 [70]
[Co12] [!] CT:INVEST KABIK CT / RAILROAD DR E WOOD BOX:1204 DUE:B125 [68]
(Co12) [!] CT:ALS 1820 VINCENZA DR @MARVIN GARDENS APT C SYKE BOX:1232 DUE:X128 [71]
[Co14] [!] CT:SERVICE 3215 HOOPERS DELIGHT RD NWIN BOX:1411 DUE:U14 [18]
[Co14] [!] CT:BLS 5401 ENTERPRISE ST ; ALLEGRA PRINT SYKE BOX:1416 DUE:X149 [33]
(Co12) [!] CT:CHIM 811 DAVID AV WEST BOX:0316 DUE:TO12 [13]
(Co12) [!] CT:LOCAL HENRYTON RD / MARRIOTTSVILLE RD ONE MARR BOX:1208 DUE:E123 [12]

*/

public class MDCarrollCountyParser extends FieldProgramParser {

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MARR", "MARRIOTTSVILLE",
      "NWIN", "NEW WINDSOR",
      "SYKE", "SYKESVILLE",
      "WEST", "WESTMINISTER",
      "WOOD", "WOODBINE"
  });
  
  private static final Pattern TRAIL_SEQ = Pattern.compile(" \\[\\d+\\]$");
  private static final Pattern APT_PTN = Pattern.compile("(?:\\bAPT\\b|#) *([^ ]+)$");
  
  public MDCarrollCountyParser() {
    super(CITY_CODES, "CARROLL COUNTY", "MD",
           "CT:ADDR! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.endsWith("|!")) return false;
    data.strSource = subject.substring(0,subject.length()-2);
    
    Matcher match = TRAIL_SEQ.matcher(body);
    if (!match.find()) return false;
    body = body.substring(0,match.start()).trim();
    
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends Field {
    
    @Override
    public void parse(String fld, Data data) {
      Parser p = new Parser(fld);
      
      // First word is always the call desc
      // last word is the city code
      data.strCall = p.get(' ');
      data.strCity = convertCodes(p.getLast(' '), CITY_CODES);
      fld = p.get();
      
      // Rest of address could include a place name separated by a ; or @
      // Unfortunately, the two fields might be in either order :(
      // And the place name might contain an apartment
      int pt = fld.indexOf('@');
      if (pt < 0) pt = fld.indexOf(';');
      if (pt < 0) {
        parseAddress(fld, data);
      }
      else {
        String fld1 = fld.substring(0,pt).trim();
        String fld2 = fld.substring(pt+1).trim();
        if (checkAddress(fld2) > checkAddress(fld1)) {
          String tmp = fld1;
          fld1 = fld2;
          fld2 = tmp;
        }
        parseAddress(fld1, data);
        Matcher match = APT_PTN.matcher(fld2);
        if (match.find()) {
          data.strApt = match.group(1);
          fld2 = fld2.substring(0,match.start()).trim();
        }
        data.strPlace = fld2;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL PLACE ADDR APT CITY";
    }
    
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
