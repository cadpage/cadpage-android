package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

/**
 * Active911 identifies this vendor as Public Safety Software
 */
public class DispatchA33Parser extends FieldProgramParser {
  
  // Flag indicating all line breaks have been removed and must be restored :(
  public static final int A33_FIX_LINE_BREAKS = 0x1;
  
  private boolean fixLineBreaks; 
  private String times;

  public DispatchA33Parser(String defCity, String defState) {
    this(defCity, defState, 0);
  }

  public DispatchA33Parser(String defCity, String defState, int flags) {
    super(defCity, defState, 
          "Event_No:ID! Status:SKIP! Disposition:SKIP! Category:CALL! CALL+? Address:ADDR! Precinct:SKIP! Sector:MAP! GEO:SKIP! Ward:SKIP! Intersection:X? Open:DATETIME1! Dispatch:DATETIME1! Law_Enf.:SKIP! Enroute:DATETIME2! Fire:SKIP! Arrival:DATETIME2! EMS:SKIP! Departure:DATETIME3? Source:SKIP? Closed:DATETIME3! Source:SKIP? Name_Address_Phone%EMPTY NAME_PHONE Business%EMPTY PLACE Vehicle(s)%EMPTY Incident_Notes:INFO/N+");
    this.fixLineBreaks = (flags & A33_FIX_LINE_BREAKS) != 0;
  }

  private static final Pattern DELIM = Pattern.compile("\n| +(?=Status:|Disposition:|Category:|Precinct:|Sector:|GEO:|ESZ:|Ward:|Law Enf\\.:|Fire:|EMS:|Source:)");

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf("Event No:");
    if (pt < 0) return false;
    if (pt > 0) {
      char chr = body.charAt(pt-1);
      if (chr != '\n' && chr != ' ') return false;
    }
    body = body.substring(pt);

    // delete event logs
    int ei = body.indexOf("\nEvent Log\n");
    if (ei < 0) ei = body.indexOf(" Event Log ");
    if (ei < 0) ei = body.indexOf("\nPage1of1Printed");
    if (ei >= 0) body = body.substring(0, ei).trim();
    
    if (fixLineBreaks) body = fixLineBreaks(body);

    times = "";
    if (!parseFields(DELIM.split(body), data)) return false;
    if (data.msgType == MsgType.RUN_REPORT) data.strSupp = append(times, "\n", data.strSupp);
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram() + " INFO";
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-?\\d{5,8}", true);
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("DATETIME1")) return new BaseDateTimeField(1);
    if (name.equals("DATETIME2")) return new BaseDateTimeField(2);
    if (name.equals("DATETIME3")) return new BaseDateTimeField(3);
    if (name.equals("NAME_PHONE")) return new BaseNamePhoneField();
    if (name.equals("PLACE")) return new BasePlaceField();
    return super.getField(name);
  }

  private class BaseCallField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.equals("Complaint Numbers")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " ", field);
    }
  }

  private class BaseAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (city.length() == 0 || city.length() == 2) {
        if (!city.equals(data.defState)) data.strState = city;
        city = p.getLastOptional(',');
      }
      super.parse(p.get(), data);
      data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY ST";
    }
  }
  
  private class BaseDateTimeField extends DateTimeField {
    private int type;
    
    public BaseDateTimeField(int type) {
      super("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d|", true);
      this.type = type;
    }
    
    @Override
    public void parse(String field, Data data) {
      String line = getRelativeField(0);
      times = append(times, "\n", line);
      if (field.length() == 0) return;
      if (type == 1) {
        super.parse(field, data);
      } else if (type == 3) {
        data.msgType = MsgType.RUN_REPORT;
      }
    }
  }

  private static final Pattern PHONE_PTN = Pattern.compile("(.*?) *(\\(\\d{3}\\) \\d{3}-\\d{4})");
  private class BaseNamePhoneField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.matches()) {
        data.strPhone = match.group(2);
        field = match.group(1);
      }
      data.strName = cleanWirelessCarrier(field);
    }

    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
        
  private class BasePlaceField extends Field {
    @Override
    public void parse(String field, Data data) {
      
      Matcher match = PHONE_PTN.matcher(field);
      if (match.matches()) {
        if (data.strPhone.length() == 0) data.strPhone = match.group(2);
        field = match.group(1);
      }
      
      // Place name sometimes contains a duplicate of address, city and zip
      // which we will try to remove
      if (data.strAddress.length() > 5) {
        int pt = field.indexOf(data.strAddress);
        if (pt >= 0) field = field.substring(0,pt).trim();
      }
      data.strPlace = cleanWirelessCarrier(field);
    }

    @Override
    public String getFieldNames() {
      return "PLACE PHONE";
    }
  }
  
  /**
   * Replace line breaks that are supposed to be in message body
   * @param body message body
   * @return adjusted message body
   */
  private static String fixLineBreaks(String body) {
    LineBreakFixer f = new LineBreakFixer(body);
    f.fixBreak("Complaint Numbers", true);
    f.fixBreak("Address:", false);
    f.fixBreak("Intersection:", false);
    f.fixBreak("Date / Time", true);
    f.fixBreak("Open:", false);
    f.fixBreak("Dispatch:", false);
    f.fixBreak("Enroute:", false);
    f.fixBreak("Arrival:", false);
    f.fixBreak("Departure:", false);
    f.fixBreak("Closed:", false);
    f.fixBreak("Person(s) Involved", true);
    f.fixBreak("Name Address Phone", true);
    f.fixBreak("Business", true);
    f.fixBreak("Vehicle(s)", true);
    f.fixBreak("Incident Notes:", false);
    return f.toString();
  }
  
  private static class LineBreakFixer {
    private String line;
    private StringBuilder sb;
    int pt;
    
    public LineBreakFixer(String line) {
      this.line = line;
      this.sb = new StringBuilder();
      pt = 0;
    }
    
    public void fixBreak(String key, boolean fixTrailBreak) {
      int tpt = pt;
      while (true) {
        tpt = line.indexOf(key, tpt);
        if (tpt < 0) return;
        if (tpt > 0 && !Character.isWhitespace(line.charAt(tpt-1))) continue;
        int ept = tpt+key.length();
        if (ept < line.length() && !Character.isWhitespace(line.charAt(ept))) continue;
        
        if (tpt > pt) {
          sb.append(line.substring(pt,tpt-1));
          sb.append('\n');
          pt = tpt;
        }
        sb.append(key);
        pt += key.length();
        
        if (fixTrailBreak && pt < line.length()) {
          sb.append('\n');
          pt++;
        }
        return;
      }
    }
    
    public String toString() {
      if (pt < line.length()) {
        sb.append(line.substring(pt));
        pt = line.length();
      }
      return sb.toString();
      
    }
  }
}
