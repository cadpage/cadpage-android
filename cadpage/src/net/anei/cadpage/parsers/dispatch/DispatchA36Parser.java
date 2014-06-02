package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA36Parser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Disp ([-A-Z0-9]+) Case # [-0-9]+ Call # ([0-9]+)");
  private static final Pattern GPS_PTN = Pattern.compile(" +http://maps\\.google\\.com/maps\\?q=([-+\\d\\.,]+)$");
  
  private int iVersion;
  private String version;
  
  public DispatchA36Parser(String defCity, String defState, int iVersion) {
    super(defCity, defState,
          "DATETIME CALL ( SELECT/2 ( ADDR/Z! ( END | INFO ) | PLACE ( STNO | X/Z STNO | ) APT? ADDR! ) | STNO? ADDR! ) INFO+");
    this.iVersion = iVersion;
    this.version = Integer.toString(iVersion);
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    data.strCallId = match.group(2);
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // Check for GPS coordinates in version 2
    if (iVersion == 2) {
      match = GPS_PTN.matcher(body);
      if (match.find()) {
        body = body.substring(0,match.start());
        setGPSLoc(match.group(1), data);
      }
    }
    
    if (!parseFields(body.split(" /"), data)) return false;
    
    // For the version 2 format, the place field can be, and usually is
    // a restatement of the address
    if (iVersion == 2) {
      if (data.strAddress.contains(data.strPlace)) data.strPlace = "";
      if (data.strPlace.length() > 0 && 
          !data.strPlace.endsWith(" PLACE") &&
          !data.strPlace.endsWith(" MALL")) {
        int sp = checkAddress(data.strPlace);
        if (sp > STATUS_MARGINAL) {
          String place = data.strPlace;
          data.strPlace = "";
          int sa = checkAddress(data.strAddress);
          if (sp > sa) {
            String tmp = place;
            place = data.strAddress;
            data.strAddress = "";
            parseAddress(tmp, data);
            int ii = sp;
            sp = sa;
            sa = ii;
          }
          if (sa < 3) {
            data.strAddress = append(data.strAddress, " & ", place);
          } else {
            data.strCross = append(data.strCross, " & ", place);
          }
        }
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC ID " + super.getProgram().replace("PLACE", "PLACE X") + " GPS";
  }
  
  @Override
  protected String getSelectValue() {
    return version;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("STNO")) return new MyStreetNoField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) +(\\d\\d?:\\d\\d:\\d\\d)( +[AP]M)?");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:dd aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      String qual = match.group(3);
      if (qual == null) {
        data.strTime = match.group(2);
      } else {
        setTime(TIME_FMT, match.group(2) + match.group(3), data);
      }
    }
  }
  
  private static final Pattern STREET_NO_PTN = Pattern.compile("(\\d+)(?: NORTH| SOUTH| EAST |WEST)?", Pattern.CASE_INSENSITIVE);
  private class MyStreetNoField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = STREET_NO_PTN.matcher(field);
      if (! match.matches()) return false;
      data.strAddress = match.group(1);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = STREET_NO_PTN.matcher(field);
      if (match.matches()) field = match.group(1);
      data.strAddress = field;
    }
  }
  
  private class MyAptField extends AptField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() > 4) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String fld, Data data) {
      data.strAddress = append(data.strAddress, " ", fld);
    }
  }
  
  private static final Pattern NOT_ADDRESS_PTN = Pattern.compile("[^ ]/ |\\bFIRE\\b");
  private class MyInfoField extends InfoField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // This is only called to handle one situation where the place name is
      // missing and the address is followed by an information field that we
      // have to identify as not looking even remotely like an address
      if (field.length() < 35 && !NOT_ADDRESS_PTN.matcher(field).find()) return false;
      parse(field, data);
      return true;
      
    }
    
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.length() == 0) {
        data.strCall = field;
      } else {
        data.strSupp = append(data.strSupp, " / ", field);
      }
    }
  }
}
