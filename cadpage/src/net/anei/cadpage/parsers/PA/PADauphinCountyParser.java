package net.anei.cadpage.parsers.PA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Dauphin County, PA
 */
public class PADauphinCountyParser extends FieldProgramParser {
  
  private static final Pattern SRC_PTN = Pattern.compile("^(\\d{7}) +");
  private static final Pattern WEST_HANOVER_PTN = Pattern.compile("(\\d{6}) - (\\d\\d?/\\d\\d?/\\d{4} \\d\\d?:\\d\\d:\\d\\d [AP]M) - (.*) - West Hanover", Pattern.DOTALL);
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  private static final Pattern SPECIAL_PTN = Pattern.compile("([-A-Z0-9]+) +(2ND DISPATCH|ER(?: WITH \\d)?(?!.*BOX:)) (.*)");
  
  private String selectValue = "";
  
  public PADauphinCountyParser() {
    super(CITY_CODES, "DAUPHIN COUNTY", "PA",
           "( SELECT/SPECIAL UNIT CALL ADDR/S! | UNIT_CALL EVENT:ID? Box:BOX! Loc:ADDR/S XSts:X Event_Type:CALL Class:PRI Disp:UNIT )", FLDPROG_IGNORE_CASE);
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] flds = subject.split("\\|");
    if (flds[flds.length-1].equals("!")) {
      if (flds.length > 1) data.strSource = flds[0];
    }
    
    Matcher match = WEST_HANOVER_PTN.matcher(body);
    if (match.matches()) {
      data.strSource = match.group(1);
      setDateTime(DATE_TIME_FMT, match.group(2), data);
      body = match.group(3).trim();
    } 
    
    else {
      match = SRC_PTN.matcher(body);
      if (match.find()) {
        if (data.strSource.length() == 0) data.strSource = match.group(1);
        body = body.substring(match.end());
      }
      
      if (body.endsWith(" - COMPANY 33 ALERT")) {
        body = body.substring(0, body.length()-19).trim();
      }
    }
    
    selectValue = "";
    match = SPECIAL_PTN.matcher(body);
    if (match.matches()) {
      selectValue = "SPECIAL";
      return parseFields(new String[]{match.group(1), match.group(2), match.group(3)}, data);
    }

    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) return false;
    if (data.strAddress.length() == 0) {
      data.strAddress = data.strCross.replace('/', '&');
      data.strCross = "";
    }
    return true;
  }
  
  @Override
  protected String getSelectValue() {
    return selectValue;
  }

  @Override
  public String getProgram() {
    return "SRC DATE TIME " + super.getProgram().replace(" X ", " ADDR X ");
  }
  
  private static Pattern CALL_UNIT_PTN = Pattern.compile("^([A-Z]+[0-9][-0-9]*) +");
  private class UnitCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_UNIT_PTN.matcher(field);
      if (match.find()) {
        data.strUnit = match.group(1);
        field  = field.substring(match.end());
      }
      data.strCall = field;
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CALL";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String apt = "";
      while (true) {
        int pt = field.lastIndexOf(':');
        if (pt < 0) break;
        String place = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        
        if (place.startsWith("APT")) {
          place = place.substring(3).trim();
          pt = place.indexOf('@');
          if (pt >= 0) {
            data.strPlace = append(place.substring(pt+1).trim(), " - ", data.strPlace);
            place = place.substring(0,pt).trim();
          }
          apt = append(place, "-", apt);
        } else {
          if (place.startsWith("@")) place = place.substring(1).trim();
          data.strPlace = append(place, " - ", data.strPlace);
        }
      }
      super.parse(field, data);
      data.strApt = append(data.strApt, "-", apt);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE APT";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" ,", " / ");
      super.parse(field, data);
    }
  }
  
  private static final Pattern PRIORITY_PTN = Pattern.compile("^(\\d)\\b *");
  private class MyPriorityField extends PriorityField {
    @Override
    public void  parse(String field, Data data) {
      Matcher match = PRIORITY_PTN.matcher(field);
      if (match.find()) {
        data.strPriority = match.group(1);
        field = field.substring(match.end());
      }
      data.strSupp = field;
    }
    
    @Override
    public String getFieldNames() {
      return "PRI INFO";
    }
  }
  
  // Sometimes there is some funny stuff at the end of the message that needs to be eliminated
  private static final Pattern UNIT_PTN = Pattern.compile("^([-/A-Z0-9, ]*)");
  private class MyUnitField extends UnitField {
    @Override 
    public void parse(String field, Data data) {
      Matcher match = UNIT_PTN.matcher(field);
      if (match.find()) field = match.group(1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT_CALL"))  return new UnitCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
                   
      "BEB DAUP",  "BERRYSBURG",
      "CWT DAUP",  "CONEWAGO TWP",
      "DAB DAUP",  "DAUPHIN",
      "DRY DAUP",  "DERRY TWP",
      "EHT DAUP",  "EAST HANOVER TWP",
      "ELZ DAUP",  "ELIZABETHVILLE",
      "GRB DAUP",  "GRATZ",
      "HBG DAUP",  "HARRISBURG",
      "HFT DAUP",  "HALIFAX TWP",
      "HFX DAUP",  "HALIFAX",
      "HSP DAUP",  "HIGHSPIRE",
      "HUM DAUP",  "HUMMELSTOWN",
      "JFT DAUP",  "JEFFERSON TWP",
      "JKT DAUP",  "JACKSON TWP",
      "LDT DAUP",  "LONDONDERRY TWP",
      "LPT DAUP",  "LOWER PAXTON TWP",
      "LST DAUP",  "LOWER SWATARA TWP",
      "LYK DAUP",  "LYKENS",
      "LYT DAUP",  "LYKENS TWP",
      "MDT DAUP",  "MIDDLETOWN",
      "MFT DAUP",  "MIFFLIN TWP",
      "MPT DAUP",  "MIDDLE PAXTON TWP",
      "MSB DAUP",  "MILLERSBURG",
      "PAX DAUP",  "PAXTANG",
      "PEN DAUP",  "PENBROOK",
      "PLB DAUP",  "PILLOW",
      "RDT DAUP",  "REED TWP",
      "ROY DAUP",  "ROYALTON",
      "RUS DAUP",  "RUSH TWP",
      "SHT DAUP",  "SOUTH HANOVER TWP",
      "STL DAUP",  "STEELTON",
      "SUS DAUP",  "SUSQUEHANNA TWP",
      "SWT DAUP",  "SWATARA TWP",
      "UPT DAUP",  "UPPER PAXTON TWP",
      "WHT DAUP",  "WEST HANOVER TWP",
      "WIC DAUP",  "WICONISCO",
      "WIL DAUP",  "WILLIAMSTOWN",
      "WLT DAUP",  "WILLIAMS TWP",
      "WST DAUP",  "WASHINTON TWP",
      "WYT DAUP",  "WAYNE TWP",

      // Cumberland County
      "EPEN CUMB", "EAST PENNSBORO TWP",
      "SVSP CUMB", "SILVER SPRING TWP",
      
      // Lancaster County
      "EDON LANC", "EAST DONEGAL TWP",
      "EZAB LANC", "ELIZABETHTOWN",
      "MTJT LANC", "MT JOY TWP",
      
      // Lebanon County
      "ANVL LEBA", "ANNVILLE TWP",
      "CLNA LEBA", "CLEONA",
      "EHAN LEBA", "EAST HANOVER TWP",
      "NLON LEBA", "NORTH LONDONDERRY TWP",
      "SLON LEBA", "SOUTH LONDONDERRY TWP",
      
      "LEBA EHAN", "EAST HANOVER TWP",
      
      // Northumberland County
      "JKST NORT", "JACKSON TWP",
      "JORD NORT", "JORDAN TWP",
      "LMHY NORT", "LOWER MAHANOY TWP",
      "HNDB NORT", "HERNDON",
      
      // Perry County
      "DUNC PERR", "DUNCANNON",
      "RYET PERR", "RYE TWP",
      "WTFD PERR", "WHEATFIELD TWP"

  });
}
