package net.anei.cadpage.parsers.GA;

import java.util.regex.*;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Chatham County, GA
 */

public class GAChathamCountyParser extends FieldProgramParser {
  
  public GAChathamCountyParser() {
    super("CHATHAM COUNTY", "GA",
          "UNIT! RESPOND_TO:ADDR! APT:APT! PRI:PRI! COMPLAINT:CALL! CRN:ID! Name:NAME COMMENTS:INFO");
  }

  private static final Pattern CRN_PATTERN
    = Pattern.compile("^(?:(?:YOUR +)?CRN\\s*\\&\\s*TIMES(?: +ARE)?\\:\\s*CRN\\:|"
+                         "COMPLETED +CALL\\s*\\/\\s*REFUSAL TIMES\\:\\s*CRN\\:|"
+                         "COMPLETE\\s*\\/\\s*REFUSAL\\:\\s*CRN\\:)\\s*(\\d{4}(?:\\d|[A-Z])\\d{4}).*");
  private static final Pattern APT_PATTERN
    = Pattern.compile("(.*?)APT\\#?\\:?(.*)");
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher m = CRN_PATTERN.matcher(body);
    if (m.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strCallId = m.group(1);
      return true;
    }
    m = APT_PATTERN.matcher(body);
    if (m.matches())
      body = m.group(1)+" APT: "+m.group(2);
    else
      body = body.replace("PRI:", " APT: PRI:");
    body = body.replace("CRN:", " CRN:");
    body = body.replace("C/O:", "COMPLAINT:");
    return super.parseMsg(body, data);
  }
}
