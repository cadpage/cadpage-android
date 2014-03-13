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
  private static final Pattern RUN_REPORT_MARKER = Pattern.compile("^(?:was Canceled:| ?(?:CALL:)?\\d\\d:\\d\\d/ ?(?:DISP:)?\\d\\d:\\d\\d/ ?(?:ENR:)?\\d\\d:\\d\\d/ ?(?:ATS:)?\\d\\d:\\d\\d/?)");
  
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
  
  protected class BaseInfoField extends InfoField {
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

  /**
   * General call to clean up ProQA style data when it is handled by other CAD vendors
   * @param forceCall true for force parsing call information from parsed data
   * @param field data field to be parsed
   * @param data data object returning parsed information
   */
  public static void parseProQAData(boolean forceCall, String field, Data data) {
    int lastCol = 0;
    Matcher match = PROQA_TERM_PTN.matcher(field);
    while (match.find()) {
      String term = match.group(1);
      if (term == null) term = match.group(2);
      if (term != null) {
        if (forceCall || data.strCall.length() == 0) data.strCall = term.trim();
      }
      else if ((term = match.group(3)) != null) {
        if (data.strCode.length() == 0) data.strCode = term;
      }
      
      data.strSupp = append(data.strSupp, "\n", field.substring(lastCol, match.start()).trim());
      lastCol = match.end();
    }
    String last = field.substring(lastCol).trim();
    match = PROQA_TRUNC_PTN.matcher(last);
    if (match.find()) last = last.substring(0,match.start()).trim();
    else if ("Disp Dispatch Code:".startsWith(last)) last = "";
    data.strSupp = append(data.strSupp, "\n", last);
  }
  private static final Pattern PROQA_TERM_PTN = Pattern.compile("\\bProblem: (.*?)\\.  Patient Info:|\\bCaller Statement: (.*?)\\.|\\b(?:ProQA d|Reconfigured d|D)ispatch (?:Code|code|Level): +(\\d[^ ;]+);?|\\bProQA (?:(?:Medical|Fire|Police) )?(?:Dispatch Message Sent|Key Questions have been completed|Questionnaire Completed);| New ProQA (?:(?:Medical|Fire|Police) )?Case Number has been assigned;|Dispatch (?:Code|Level): --: -\\d+|\\bE911 Info -.*|Chief Complaint Number: \\d+;|\\*\\* Case number \\d+ has been assigned for \\d+:CNTY \\*\\*|>+ by: [ A-Z]+ on terminal: .*|\\bResponder script:|\\bNew ProQA Case Number has been assigned: -\\d+");
  private static final Pattern PROQA_TRUNC_PTN = Pattern.compile("(?:\\bNew )?ProQA[ A-Za-z]*$"); 

}
