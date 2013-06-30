package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class COLaPlataCountyParser extends FieldProgramParser {
  
  public COLaPlataCountyParser() {
    super("LA PLATA COUNTY", "CO",
           "SRC UNIT CALL ADDR INFO+");
  }
  
  @Override
  public String getFilter() {
    return "hiplink@ci.durango.co.us ";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Message from HipLink")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private static final Pattern ADDR_APT_PTN = Pattern.compile("^(?:RM|ROOM|APT|STE) *([^ ]+)", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String[] flds = field.split(";");
      super.parse(flds[0].trim(), data);
      for (int ndx = 1; ndx < flds.length; ndx++) {
        String fld = flds[ndx].trim();
        
        if (NUMERIC.matcher(fld).matches()) {
          data.strApt = append(data.strApt, "-", fld);
          return;
        }
        
        Matcher match = ADDR_APT_PTN.matcher(fld);
        if (match.find()) {
          data.strApt = append(data.strApt, "-", match.group(1));
          fld = fld.substring(match.end()).trim();
        }
        
        if (checkAddress(fld) > 0) {
          data.strCross = append(data.strCross, " / ", fld);
          continue;
        }
        
        data.strPlace = append(data.strPlace, " - ", fld);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT X PLACE";
    }
  }
  
  private static final Pattern INFO_UNIT_PTN = Pattern.compile("[A-Z]+\\d+(?: [A-Z0-9]+)*");
  private static final Pattern INFO_ID_PTN = Pattern.compile("\\d+[A-Z]{2}-\\d+");
  private static final Pattern INFO_DATE_TIME_PTN = Pattern.compile("^(?:(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d(?::\\d\\d)?)|(\\d\\d:\\d\\d(?::\\d\\d)?) +(\\d\\d/\\d\\d/\\d{4}))\\b *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      // skip empty fields
      if (field.length() == 0) return;
      
      // See if this is a unit field
      if (INFO_UNIT_PTN.matcher(field).matches()) {
        data.strUnit = field;
        return;
      }
      if (field.equals(data.strUnit)) return;
      
      int pt = field.indexOf(' ');
      if (pt >= 0 && field.substring(0,pt).equals(data.strUnit)) {
        data.strUnit = field;
        return;
      }
      
      // Is this a call ID field
      if (data.strCallId.length() == 0 && INFO_ID_PTN.matcher(field).matches()) {
        data.strCallId = field;
        return;
      }
      
      // Check for cross street
      if (checkAddress(field) > 0) {
        data.strCross = append(data.strCross, " / ", field);
        return;
      }
      
      // See if we have a leading Date/time (or Time/Date)
      Matcher match = INFO_DATE_TIME_PTN.matcher(field);
      if (match.find()) {
        if (data.strDate.length() == 0) {
          data.strDate = match.group(1);
          data.strTime = match.group(2);
          if (data.strDate == null) {
            data.strTime = match.group(3);
            data.strDate = match.group(4);
          }
        }
        field = field.substring(match.end());
      }
      
      super.parse(field, data);
    }
    
    @Override 
    public String getFieldNames() {
      return "UNIT ID X DATE TIME INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
