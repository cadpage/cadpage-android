package net.anei.cadpage.parsers.dispatch;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Louisville, KY
 */
public class DispatchA27Parser extends FieldProgramParser {
  
  private static final String PAGE_PREFIX = "Notification from CIS Active 911:";
  private static final Pattern DELIM_PTN = Pattern.compile("\n{2}");
  
  public DispatchA27Parser(String defCity, String defState) {
    super(defCity, defState,
           "ADDRCITY/SC DUP? SRC! Time_reported:DATETIME! Unit(s)_responded:UNIT+");
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!body.startsWith(PAGE_PREFIX)) return false;
    
    body = body.substring(PAGE_PREFIX.length()).trim();      // Remove message prefix
    
    String[] fields = DELIM_PTN.split(body);
    
    // If the body does not have the Time Completed label, process message
    if(!body.contains("Time completed:")) {
      return super.parseFields(fields, data);
    }
    // Otherwise we are a report
    else {
      data.strCall = "RUN REPORT";
      
      // Extract Units
      String units = fields[fields.length-1];
      int colon = units.indexOf(':');
      units = units.substring(colon+1).trim();
      parseUnitField(true, units, data);
      
      // Extract ID
      if (fields.length > 0) {
        int ndx = 1;
        if (fields.length > 1 && fields[0].trim().equals(fields[1].trim())) ndx++;
        if (fields.length > ndx) {
          String[] srcID = fields[ndx].split("-");
          if (srcID.length > 1) data.strCallId = srcID[1].trim();
        }
      }
      
      data.strPlace = body;                                               // Put remaining in Place.
      return true;
    }
    
  }
  
  private static final Pattern PTN_FULL_ADDR = Pattern.compile("(.*, .*), \\d{5}");
  protected class BaseAddressField extends AddressCityField {
    
    @Override 
    public void parse(String field, Data data) {
      Matcher m = PTN_FULL_ADDR.matcher(field);   // This will match address, city, and zip
      if(m.matches()) {                           // If we have a match
        field = m.group(1);                       // Remove the zipcode
      }
      
      int x = field.indexOf("/unincorp");
      if(x >= 0) {
        field = field.substring(0, x) + field.substring(x+9);
      }
      
      super.parse(field, data);
    }
  }

  private class DuplField extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return field.equals(getRelativeField(-1));
    }
  }
  
  private class BaseSrcField extends SourceField {
    
    @Override 
    public void parse(String field, Data data) {

      int delim = field.indexOf(" - ");
      if(delim >= 0) {
        data.strSource = field.substring(0, delim).trim();
        data.strCallId = field.substring(delim+3).trim();
      }
      else super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ID";
    }
  }
  
  private class BaseUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      parseUnitField(false, field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT INFO";
    }
  }
  
  /**
   * Parse unit field for both regular pages and run reports
   * @param runReport true if parsing a run report
   * @param field Unit field to be parsed
   * @param data Data object
   */
  private void parseUnitField(boolean runReport, String field, Data data) {
    boolean info = false;
    for (String token : field.split("\n")) {
      token = token.trim();
      if (token.length() == 0) continue;
      if (!info && !UNIT_PTN.matcher(token).matches()) info = true;
      if (!info) {
        data.strUnit = append(data.strUnit, " ", token);
      } else if (!runReport) {
        data.strSupp = append(data.strSupp, "\n", token);
      }
    }
  }
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+\\d+|\\d{8}");
  
  
  @Override
  public Field getField(String name) {
      if (name.equals("ADDRCITY")) return new BaseAddressField();
      if (name.equals("DUP")) return new DuplField();
      if (name.equals("SRC")) return new BaseSrcField();
      if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa"));
      if (name.equals("UNIT")) return new BaseUnitField();
    return super.getField(name);
  }

}
