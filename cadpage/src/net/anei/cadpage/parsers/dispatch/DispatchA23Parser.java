package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DispatchA23Parser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Dispatch (.*)"); 
  private static final Pattern SUBJECT2_PTN = Pattern.compile("Free (.*)");
  private static final Pattern SUBJECT3_PTN = Pattern.compile("Sta +(.+)");
  private static final Pattern REPORT_ID_PTN = Pattern.compile("\nMI#:(\\d+) *\n");
  private static final Pattern SINGLE_LINE_BRK = Pattern.compile("(?<!\n)\n(?!\n)");
  
  private Properties cityCodes;
  
  public DispatchA23Parser(Properties cityCodes, String defCity, String defState) {
    super(defCity, defState,
           "CALL ADDRCITY/SaXP! #:APT X:X! ZN:MAP? CP:PLACE UNIT MI:ID RES:UNIT");
    this.cityCodes = cityCodes;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) {
      data.strUnit = match.group(1).trim();
    } else {
      match = SUBJECT3_PTN.matcher(subject);
      if (match.matches()) {
        data.strSource = subject.trim();
      } else {
        match = SUBJECT2_PTN.matcher(subject);
        if (!match.matches()) return false;
        data.strCall = "RUN REPORT";
        data.strPlace = body;
        data.strUnit = match.group(1);
        match = REPORT_ID_PTN.matcher(body);
        if (match.find()) data.strCallId = match.group(1);
        return true;
      }
    }
    
    // Search and destroy code messaging double line breaks
    match = SINGLE_LINE_BRK.matcher(body);
    if (!match.find()) body = body.replace("\n\n", "\n");
    
    body = body.replace("MI#:", "MI:").replace("RES#:", "RES:");
    return parseFields(body.split("\n"), data) && data.strAddress.length() > 0;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyAddressCityField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      String place = "";
      int pt = field.lastIndexOf(';');
      if (pt >= 0) {
        place = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      pt = field.lastIndexOf(',');
      if (pt < 0) abort();
      data.strCity = convertCodes(field.substring(pt+1).trim(), cityCodes);
      field = field.substring(0,pt).trim();
      super.parse(field, data);
      data.strPlace = append(data.strPlace, " - ", place);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE"; 
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d{4})-(\\d\\d)-(\\d\\d) (\\d\\d:\\d\\d:\\d\\d)$");
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.find()) {
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
}
