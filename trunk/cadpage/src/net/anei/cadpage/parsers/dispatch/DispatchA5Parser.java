package net.anei.cadpage.parsers.dispatch;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA5Parser extends FieldProgramParser {
  
  public static final String SUBJECT_SIGNATURE = "Automatic R&R Notification";
  public static final Pattern RUN_REPORT_UNIT_PTN = Pattern.compile(" ORI: *(.*?) *Station: *(\\S*)");
  
  private static final Pattern TERMINATOR_PTN = Pattern.compile("\n(?:Additional Info|Address Checks|Additional Inc#s:|Narrative|The Call Taker is)");
  private static final Pattern KEYWORD_TRAIL_PTN = Pattern.compile("[ \\.]+:|(?: \\.){2,}(?=\n)");
  private static final Pattern CALL_TIME_DATE_PTN = Pattern.compile("\\bCall Time- ([0-9:]+) +Date- ([0-9/]+) *\n.*?(?=\nArea:)", Pattern.DOTALL);
  private static final Pattern LINE_PTN = Pattern.compile("(.*)(?:\n|$)");
  private static final Pattern TRIM_TRAIL_BLANKS = Pattern.compile(" +$");
  private static final Pattern TRIM_EXTRA_INFO = Pattern.compile("(?:\nAddress Checks *)?(?:\nAdditional Inc#s: *)?$");
  
  private CodeTable callCodes;
  
  public DispatchA5Parser(String defCity, String defState) {
    this(null, null, defCity, defState);
  }
  
  public DispatchA5Parser(Properties cityCodes, String defCity, String defState) {
    this(cityCodes, null, defCity, defState);
  }
  
  public DispatchA5Parser(Properties cityCodes, CodeTable callCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState,
           "Incident_Number:ID! ORI:UNIT! Station:SRC! " +
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
    this.callCodes = callCodes;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals(SUBJECT_SIGNATURE)) return false;
    if (body.contains("** FINAL REPORT **")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      Matcher match = RUN_REPORT_UNIT_PTN.matcher(body);
      if (match.find()) {
        data.strUnit = match.group(1);
        data.strSource = match.group(2);
      }
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
    
    // Clean up any duplicates in unit field
    StringBuilder sb = new StringBuilder();
    Set<String> unitSet = new HashSet<String>();
    for (String unit : data.strUnit.split(" +")) {
      if (unitSet.add(unit)) {
        if (sb.length() > 0) sb.append(' ');
        sb.append(unit);
      }
    }
    data.strUnit = sb.toString();
    
    return true;
  }
  
  private static final Pattern CALL_CODE_PTN = Pattern.compile("([^ ]+) ([EF] .*)");
  private class MyCallField extends CallField {
    @Override public void parse(String field, Data data) {
      Matcher match = CALL_CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = match.group(2);
        String call = null;
        if (callCodes != null) call = callCodes.getCodeDescription(data.strCode);
        if (call != null) field = call;
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
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
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("PHONE")) return new MyPhoneField();
    if (name.equals("UNIT")) return new  MyUnitField();
    return super.getField(name);
  }
}
