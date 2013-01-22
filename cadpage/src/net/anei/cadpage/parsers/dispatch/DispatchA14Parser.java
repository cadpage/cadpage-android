package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA14Parser extends FieldProgramParser {
  
  private static final Pattern[] MISSING_BLANK_PTNS = new Pattern[]{
    Pattern.compile("([^ ])(CS:|ADTML:|CODE:|TOA:|TYPE:|LOC:)"),
    Pattern.compile("\\b(\\d\\d-\\d\\d-\\d\\d)([^ ])"),
    Pattern.compile("([^ ])(\\d{4}-\\d{6})\\b")
  };
  private static final Pattern ID_PTN = Pattern.compile("^(\\d{4}-\\d{6}) ");
  
  public DispatchA14Parser(String defCity, String defState) {
    this(null, defCity, defState);
  }
  
  public DispatchA14Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
           "ADDR/SP! CS:X? ADTML:CODE? TOA:TIMEDATE TYPE:INFO LOC:SKIP");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Rule out the similar NYNassauCountyA format
    if (body.contains(" c/s:")) return false;
    
    Matcher match = ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(match.end()).trim();
    }
    
    // Call description is in front of text bracketed by three asterisks
    int pt1 = body.indexOf("***");
    if (pt1 < 0) return false;
    int pt2 = body.indexOf("***", pt1+3);
    if (pt2 < 0) return false;
    data.strCall = append(body.substring(0,pt1).trim(), " - ", body.substring(pt1+3, pt2).trim());
    
    body = body.substring(pt2+3).trim();
    for (Pattern ptn : MISSING_BLANK_PTNS) {
      body = ptn.matcher(body).replaceAll("$1 $2");
    }
    if (! super.parseMsg(body, data)) return false;
    return (pt1 == 0 || data.strCross.length() > 0 || data.strTime.length() > 0);
  }

  private static final Pattern TIME_DATE = Pattern.compile("^(\\d\\d:\\d\\d)(?: (\\d\\d[-/]\\d\\d[-/]\\d\\d))?\\b");
  private static final Pattern ANGLE_BKT_PTN = Pattern.compile("<[^<>]*>");
  private static final Pattern ID_PTN2 = Pattern.compile("\\b\\d{4}-\\d{6}\\b");
  private static final Pattern DISTRICT_PTN = Pattern.compile("\\b(?:NORTH BABYLON FC|AMITYVILLE FD|DEER PARK FIRE DISTRICT|PT JEFFERSON)\\b");
  private class MyTimeDateField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = TIME_DATE.matcher(field);
      if (!match.find()) abort();
      data.strTime = match.group(1);
      data.strDate = getOptGroup(match.group(2)).replaceAll("-", "/");
      field = field.substring(match.end()).trim();
      field = ANGLE_BKT_PTN.matcher(field).replaceAll("");
      match = DISTRICT_PTN.matcher(field);
      if (match.find()) {
        data.strSource = match.group();
        field = field.substring(0,match.start()) + field.substring(match.end());
      }
      match = ID_PTN2.matcher(field);
      if (match.find()) {
        data.strCallId = match.group();
        field = field.substring(0,match.start()) + field.substring(match.end());
      }
      field = field.trim().replaceAll("  +", " ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "TIME DATE SRC ID INFO";
    }
  }
  
  private static final Pattern CALL_DELIM_PTN = Pattern.compile("\\(|  ");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.length() <= 2) {
        Matcher match = CALL_DELIM_PTN.matcher(field);
        int pt = match.find() ? match.start() : field.length();
        data.strCall = append(data.strCall, " - ", field.substring(0,pt).trim());
        field = field.substring(pt).trim();
      }
      super.parse(field, data);
    }
  }

  
  @Override
  public Field getField(String name) {
    if (name.equals("TIMEDATE")) return new MyTimeDateField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID CALL " + super.getProgram();
  }
}


