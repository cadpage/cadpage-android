package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class COLarimerCountyAParser extends FieldProgramParser {
  
  private static final Pattern TEXT_MARKER_PTN = Pattern.compile("([A-Z]+) +\\(([A-Z]+)\\) +(.*)");
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile(".{30} *(?:- )?([A-Z0-9]+) +\\(TIMES\\) +(?:Rec'd|Received).* Run ?#[- ]+(\\d+)\\b.*");
  
  private static final Pattern SEPARATOR = Pattern.compile(" *// *");

  public COLarimerCountyAParser() {
    super("LARIMER COUNTY", "CO",
           "CALL ADDR APT! Radio:CH! PLACE MAP UNIT");
  }
  
  public String getFilter() {
    return "@notifyall.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Text pages are split into two different messages, with different formats
    // They have a different header that tips us off that a second message should
    // be expected.  Which is duplicated in the second message which must be
    // identified and removed.
    Matcher match = TEXT_MARKER_PTN.matcher(body);
    if (match.matches()) {
      String marker = match.group(1);
      subject = match.group(2);
      body = match.group(3);
      marker = ' ' + marker + ' ';
      int pt = body.indexOf(marker);
      if (pt >= 0) {
        body = body.substring(0,pt) + ' ' + body.substring(pt + marker.length());
      } else {
        data.expectMore = true;
      }
    }

    // Resume normal processing
    Parser p = new Parser(subject);
    data.strSource = p.getOptional('|');
    
    // Check for run report
    match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strUnit = match.group(1);
      data.strCallId = match.group(2);
      return true;
    }
    
    if (!p.get().equals("CFS")) return false;
    if (data.strSource.toLowerCase().startsWith("notifyall")) data.strSource = "";

    String[] flds = SEPARATOR.split(body);
    if (!parseFields(flds, data)) return false;
    if (data.strMap.equals("NOT FOUND")) data.strMap = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new AptField("Apt/Lot\\b *(.*)", true);
    return super.getField(name);
  }
}
