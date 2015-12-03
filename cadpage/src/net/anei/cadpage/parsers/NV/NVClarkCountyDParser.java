package net.anei.cadpage.parsers.NV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;



public class NVClarkCountyDParser extends FieldProgramParser {
  
  public NVClarkCountyDParser() {
    super("CLARK COUNTY", "NV",
          "Unit:UNIT! Inc:ID! Pri:PRI! Prob:CALL! Add:ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "sms@pageway.net";
  }
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("Unit:(\\S+)(Rec:.*)");
  private static final Pattern RUN_REPORT_BRK_PTN = Pattern.compile("(?<=\\d\\d:\\d\\d)(?=[A-Z]{3})", Pattern.CASE_INSENSITIVE);
  private static final Pattern MISSING_BLANK_PTN = Pattern.compile("(?<! )(?=Inc:|Pri:|Prob:|Add:)");
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.equals("SMS")) break;
      if (body.startsWith("SMS / ")) {
        body = body.substring(6).trim();
        break;
      }
      return false;
    } while (false);
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT INFO");
      data.msgType = MsgType.RUN_REPORT;
      data.strUnit = match.group(1);
      data.strSupp = RUN_REPORT_BRK_PTN.matcher(match.group(2)).replaceAll("\n");
      return true;
    }
    
    body = MISSING_BLANK_PTN.matcher(body).replaceAll(" ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
  private static final Pattern CODE_CALL_PTN = Pattern.compile("([A-Z0-9]+)-(.*)");
  private class MyCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CODE_CALL_PTN.matcher(field);
      if (match.matches()) {
        data.strCode = match.group(1);
        field = match.group(2).trim();
      }
      data.strCall = field;
    }

    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
}
