package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA5Parser extends FieldProgramParser {
  
  public static final String SUBJECT_SIGNATURE = "Automatic R&R Notification";
  
  private static final Pattern TERMINATOR_PTN = Pattern.compile("\n(?:Additional Info|Address Checks|Additional Inc#s:|Narrative|The Call Taker is)");
  private static final Pattern KEYWORD_TRAIL_PTN = Pattern.compile("[ \\.]+:|(?: \\.){2,}(?=\n)");
  private static final Pattern CALL_TIME_DATE_PTN = Pattern.compile("\\bCall Time- ([0-9:]+) +Date- ([0-9/]+) *\n.*?(?=\nArea:)", Pattern.DOTALL);
  private static final Pattern LINE_PTN = Pattern.compile("(.*)(?:\n|$)");
  private static final Pattern TRIM_TRAIL_BLANKS = Pattern.compile(" +$");
  private static final Pattern TRIM_EXTRA_INFO = Pattern.compile("(?:\nAddress Checks *)?(?:\nAdditional Inc#s: *)?$");
  
  public DispatchA5Parser(String defCity, String defState) {
    super(defCity, defState,
           "Incident_Number:ID! ORI:SKIP! Station:SRC! " +
           "Incident_Type:CALL! Priority:PRI! " +
           "Incident_Location:ADDR! Venue:CITY! " +
           "Located_Between:X? Cross_Street:X? Common_Name:PLACE? " +
           "Call_Time:TIME! Call_Date:DATE! " +
           "Area:MAP! Section:MAP! Beat:SKIP! Map:SKIP? " +
           "Grid:SKIP! Quadrant:MAP! District:MAP! " +
           "Phone_Number:PHONE! Call_Source:SKIP! " +
           "Caller:NAME? " +
           "Units_sent:UNIT? " +
           "Nature_of_Call:INFO");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals(SUBJECT_SIGNATURE)) return false;
    if (body.contains("** FINAL REPORT **")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    Matcher match = TERMINATOR_PTN.matcher(body);
    if (!match.find()) return false;
    String extra = body.substring(match.start()+1);
    body = body.substring(0,match.start()).trim();
    
    body = KEYWORD_TRAIL_PTN.matcher(body).replaceAll(":");
    match = CALL_TIME_DATE_PTN.matcher(body);
    if (!match.find()) return false;
    body = match.replaceFirst("Call Time:$1 Call Date:$2 ");
    
    body = body.replace('\n', ' ');
    body = body.replaceAll("  +", " ");
    if (!super.parseMsg(body, data)) return false;
    
    // Add additional information from trailing data
    boolean display = false;
    boolean trimLead = false;
    match = LINE_PTN.matcher(extra);
    while (match.find()) {
      String line = match.group(1);
      boolean skip = false;
      if (line.startsWith("Additional Info")) {
        display = true;
        trimLead = true;
        skip = true;
      } else if (line.startsWith("Address Checks")) {
        display = true;
        trimLead = false;
      } else if (line.startsWith("Narrative") || line.startsWith("The Call Taker is")) {
        display = false;
        trimLead = false;
      }
      if (display && !skip && line.length() > 0) {
        if (trimLead) line = line.trim();
        else line = TRIM_TRAIL_BLANKS.matcher(line).replaceFirst("");
        data.strSupp = append(data.strSupp, "\n", line);
      }
    }
    
    // Trim off any Empty titles from the extra information
    data.strSupp = TRIM_EXTRA_INFO.matcher(data.strSupp).replaceFirst("");
    return true;
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern MAP_TRAIL_PTN = Pattern.compile("[ +]+$");
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      field = MAP_TRAIL_PTN.matcher(field).replaceFirst("");
      data.strMap = append(field, "/", data.strMap);
    }
  }
  
  private class MyPhoneField extends PhoneField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("(000) 000-0000")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("PHONE")) return new MyPhoneField();
    return super.getField(name);
  }
}
