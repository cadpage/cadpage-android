package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

/*
 * Base parser for Archonix software out of Mariton, NJ
 */

public class DispatchArchonixParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("(?:Dispatch|Free) (.*)"); 
  private static final Pattern SUBJECT3_PTN = Pattern.compile("Sta +(.+)");
  private static final Pattern SINGLE_LINE_BRK = Pattern.compile("(?<!\n)\n(?!\n)");
  
  private Properties cityCodes;
  private Properties maCityCodes;

  public DispatchArchonixParser(Properties cityCodes, String defCity, String defState) {
    this(cityCodes, null, defCity, defState);
  }

  public DispatchArchonixParser(Properties cityCodes, Properties maCityCodes, String defCity, String defState) {
    super(defCity, defState,
          "( ADDRCITY/ZaSXP! MI#:ID! TIMES! TIMES+? RES#:UNIT " +
          "| CALL ADDRCITY/aSXP! #:APT X:X! BOX:BOX? ZN:MAP? CP:PLACE UNIT Time:DATETIME? MI#:ID Lat/Lon:GPS? RES#:UNIT )");
    this.cityCodes = cityCodes;
    this.maCityCodes = maCityCodes;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) {
      data.strUnit = match.group(1).trim();
    } 
    else if ((match = SUBJECT3_PTN.matcher(subject)).matches()){
      data.strSource = match.group(1).trim();
    }
    
    // Search and destroy code messaging double line breaks
    match = SINGLE_LINE_BRK.matcher(body);
    if (!match.find()) body = body.replace("\n\n", "\n");
    
    if (!parseFields(body.split("\n"), data)) return false;
    
    // Lots of special handling goes into mutual aid calls
    if (data.strCall.startsWith("MUTUAL AID") && data.strAddress.length() <= 3) {
      String addr = data.strPlace;
      String place = data.strPlace = "";
      int pt = addr.indexOf(" - ");
      if (pt >= 0) {
        place = addr.substring(pt+3).trim();
        addr = addr.substring(0,pt).trim();
      }
      data.strAddress = "";
      pt = addr.indexOf(',');
      String city;
      if (pt >= 0) {
        city = addr.substring(0,pt).trim();
        parseAddress(addr.substring(pt+1).trim(), data);
      } else {
        parseAddress(StartType.START_PLACE, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, addr, data);
        city = data.strPlace;
      }
      data.strPlace = place;
      if (data.strAddress.length() == 0) {
        parseAddress(city, data);
      } else {
        if (city.endsWith(" BORO")) {
          city = city.substring(0,city.length()-5).trim();
        } else if (city.startsWith("BORO OF ")) {
          city = city.substring(8).trim();
        } else if (city.startsWith("BORO ")) {
          city = city.substring(5).trim();
        }
        if (maCityCodes != null) city = convertCodes(city, maCityCodes);
        data.strCity = city;
      }
    }

    return (data.strAddress.length() > 0);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new BaseAddressCityField();
    if (name.equals("X")) return new BaseCrossField();
    if (name.equals("PLACE")) return new BasePlaceDateTimeField(true);
    if (name.equals("DATETIME")) return new BasePlaceDateTimeField(false);
    if (name.equals("ID")) return new BaseIdField();
    if (name.equals("TIMES")) return new BaseTimesField();
    if (name.equals("GPS")) return new BaseGPSField();
    return super.getField(name);
  }
  
  protected class BaseAddressCityField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      parse(field, data, true);
    }
    
    public void parse(String field, Data data, boolean cityRequired) {
      String place = "";
      int pt = field.lastIndexOf(';');
      if (pt >= 0) {
        place = field.substring(pt + 1).trim();
        field = field.substring(0, pt).trim();
      }
      pt = field.lastIndexOf(',');
      if (pt >= 0) {
        data.strCity = convertCodes(field.substring(pt + 1).trim(), cityCodes);
        field = field.substring(0, pt).trim();
      } else if (cityRequired) abort();
      super.parse(field, data);
      if (data.strPlace.startsWith("/")) data.strPlace = data.strPlace.substring(1).trim();
      data.strPlace = append(data.strPlace, " - ", place);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE"; 
    }
  }
  
  protected class BaseCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  protected class BaseIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) {
        data.strChannel = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ID CH";
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d{4})-(\\d\\d)-(\\d\\d) (\\d\\d:\\d\\d:\\d\\d)$");
  protected class BasePlaceDateTimeField extends DateTimeField {
    
    private boolean allowPlace;
    
    public BasePlaceDateTimeField(boolean allowPlace) {
      this.allowPlace = allowPlace;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      boolean process;
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (allowPlace) {
        process = match.find();
      } else {
        process = match.matches();
        if (!process) abort();
      }
      if (process) {
        data.strDate = match.group(2) + "/" + match.group(3) + "/" + match.group(1);
        data.strTime = match.group(4);
        field = field.substring(0,match.start()).trim(); 
      }
      data.strPlace = append(data.strPlace, " - ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE DATE TIME";
    }
  }
  
  private static final Pattern DISP_TIME_PTN = Pattern.compile("Disp:(\\d\\d?:\\d\\d:\\d\\d)");
  protected class BaseTimesField extends InfoField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("RES#:") || field.startsWith("Lat/Lon:")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      data.msgType = MsgType.RUN_REPORT;
      if (data.strTime.length() == 0) {
        Matcher match = DISP_TIME_PTN.matcher(field);
        if (match.matches()) data.strTime = match.group(1);
      }
      data.strSupp = append(data.strSupp, "\n", field);
    }
    
    @Override
    public String getFieldNames() {
      return "TIME INFO";
    }
  }
  
  protected class BaseGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", ",");
      super.parse(field, data);
    }
  }
}
