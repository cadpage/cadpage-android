package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Parser for ProQA Dispatch software
 */
public class DispatchProQAParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("\\bRun#");
  private static final Pattern RUN_REPORT_MARKER = Pattern.compile("^(?:was Canceled:|(?:CALL:)?\\d\\d:\\d\\d/(?:DISP:)?\\d\\d:\\d\\d/(?:ENR:)?\\d\\d:\\d\\d/(?:ATS:)?\\d\\d:\\d\\d/?)");
  
  protected DispatchProQAParser(String defCity, String defState, String program) {
    super(defCity, defState, program);
  }
  
  protected DispatchProQAParser(Properties cityCodes, String defCity, String defState, String program) {
    super(cityCodes, defCity, defState, program);
  }
  
  protected DispatchProQAParser(String[] cityList, String defCity, String defState, String program) {
    super(cityList, defCity, defState, program);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Parse run number from first field
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    int pt = match.end();
    int pt2 = body.indexOf("/", pt);
    if (pt2 < 0) return false;
    
    data.strCallId = body.substring(pt, pt2).trim();
    do { pt2++; } while (pt2 < body.length() && body.charAt(pt2) == '/');
    body = body.substring(pt2).trim();
    if (RUN_REPORT_MARKER.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    body = body.replace("ProQA comments:", "/");

    // Everything else is variable
    String[] lines = body.split("/+");
    return parseFields(lines, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram() + " CALL PLACE";
  }
  
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("<PROQA_DET>")) return;
      if (field.equals("<PROQA_SCRIPT>")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new BaseInfoField();
    return super.getField(name);
  }
}
