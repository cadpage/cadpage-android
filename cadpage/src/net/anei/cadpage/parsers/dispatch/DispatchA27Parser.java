package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class DispatchA27Parser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("Notification from (?:CIS )?[A-Za-z0-9 ]+:");
  private static final Pattern DELIM_PTN = Pattern.compile("\n{2}");
  
  private Pattern unitPtn;
  
  private String times;
  
  public DispatchA27Parser(String defCity, String defState, String unitPtn) {
    this(null, defCity, defState, unitPtn);
  }
  
  public DispatchA27Parser(String[] cityList, String defCity, String defState, String unitPtn) {
    super(cityList, defCity, defState,
          "ADDRCITY/SC DUP? SRC! TIMES! TIMES+ Unit(s)_responded:UNIT+");
    this.unitPtn = Pattern.compile(unitPtn);
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.lookingAt()) return false;
    body = body.substring(match.end()).trim();
    times = "";
    if (!super.parseFields(DELIM_PTN.split(body), data)) return false;;
    
    if (data.strTime.length() == 0) return false;
    if (data.msgType == MsgType.RUN_REPORT) {
      data.strSupp = append(times, "\n", data.strSupp);
    }
    return true;
  }
  
  @Override
  public Field getField(String name) {
      if (name.equals("ADDRCITY")) return new BaseAddressField();
      if (name.equals("DUP")) return new DuplField();
      if (name.equals("SRC")) return new BaseSrcField();
      if (name.equals("TIMES")) return new BaseTimesField();
      if (name.equals("UNIT")) return new BaseUnitField();
    return super.getField(name);
  }
  
  private static final Pattern PTN_FULL_ADDR = Pattern.compile("(.*?, [^,]*?),(?: (?:\\d{5}|))?(?:, *([-+]?\\d+\\.\\d{4,}, *[-+]?\\d+\\.\\d{4,}))?");
  protected class BaseAddressField extends AddressCityField {
    
    @Override 
    public void parse(String field, Data data) {
      Matcher m = PTN_FULL_ADDR.matcher(field);   // This will match address, city, and zip
      if(m.matches()) {                           // If we have a match
        field = m.group(1);                       // Remove the zipcode
        setGPSLoc(getOptGroup(m.group(2)), data);
      }
      
      int x = field.indexOf("/unincorp");
      if(x >= 0) {
        field = field.substring(0, x) + field.substring(x+9);
      }
      
      field = field.replace('@',  '&');
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " GPS";
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
      
      field = stripFieldStart(field, getRelativeField(-1)); 

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
  
  private static final Pattern TIMES_PTN = Pattern.compile("([ \\w]+): (\\d\\d/\\d\\d/\\d{4}) +(\\d\\d?:\\d\\d:\\d\\d [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class BaseTimesField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      for (String part : field.split("\n")) {
        Matcher match = TIMES_PTN.matcher(part);
        if (!match.matches()) abort();
        String type = match.group(1);
        if (type.equals("Time reported")) {
          data.strDate = match.group(2);
          setTime(TIME_FMT, match.group(3), data);
        }
        else {
          if (type.equals("Time completed") || type.equals("Incident Time")) {
            data.msgType = MsgType.RUN_REPORT;
          }
        }
        times = append(times, "\n", part);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME INFO";
    }
  }
  
  private class BaseUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      parseUnitField(false, field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT PLACE GPS INFO";
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
    boolean chkGPS = false;
    String gps = null;
    for (String token : field.split("\n")) {
      token = token.trim();
      if (token.length() == 0) continue;
      if (!info) { 
        Matcher match = unitPtn.matcher(token);
        if (match.matches()) {
          if (match.groupCount() == 1) token = match.group(1);
        } else {
          info = true;
        }
      }
      if (!info) {
        data.strUnit = append(data.strUnit, " ", token);
      } else if (!runReport) {
        Matcher match = GPS_PTN.matcher(token);
        if (match.lookingAt()) {
          data.strPlace = append(data.strPlace, " - ", data.strSupp);
          data.strSupp = "";
          gps = match.group(1);
          if (gps != null) { 
            setGPSLoc(gps+','+match.group(2), data);
            gps = null;
          } else {
            chkGPS = true;
          }
          token = token.substring(match.end()).trim();
        }
        else if (chkGPS) {
          if (token.startsWith("LOC: ")) continue;
          if (token.startsWith("LAT: ")) {
            gps = token.substring(5).trim();
            continue;
          }
          if (gps != null && token.startsWith("LON: ")) {
            setGPSLoc(gps+','+token.substring(5).trim(), data);
            continue;
          }
          if ((match = GPS_TRAIL_PTN.matcher(token)).lookingAt()) {
            token = token.substring(match.end()).trim();
            chkGPS = false;
          } else {
            chkGPS = false;
          }
        }
        if (!token.equals(".")) data.strSupp = append(data.strSupp, "\n", token);
      }
    }
  }
  private static final Pattern GPS_PTN = Pattern.compile("E911 CLASS: *[A-Z]{1,4}\\d*(?: *LOC: .*?LAT: ([-+]?\\d+\\.\\d{6})0? *LON: ([-+]?\\d+\\.\\d{6})(?: *Lec:[a-z]{3,4})?)?");
  private static final Pattern GPS_TRAIL_PTN = Pattern.compile("Lec:[a-z]{3,4}");
}
