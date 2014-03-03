package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class WALewisCountyParser extends FieldProgramParser {
  
  private static final Pattern TRAIL_ID_PTN = Pattern.compile("; \\[(D\\d{8})\\] - AlarmMessenger$");
  private static final Pattern DELIM = Pattern.compile(" *[;\n] *");
  
  public WALewisCountyParser() {
    super("LEWIS COUNTY", "WA",
           "SRC FIPO DATETIME CALL ADDR! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@lewiscountywa.gov";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = TRAIL_ID_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(0,match.start()).trim();
    return super.parseFields(DELIM.split(body, -1), 5, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " ID";
  }
  
  private class MySourceField extends SourceField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("_")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern INFO_TIME_DATE_PTN = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d{4}) - .*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_TIME_DATE_PTN.matcher(field);
      if (match.matches()) {
        data.strTime = match.group(1);
        data.strDate = match.group(2);
      } else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("FIPO")) return new SkipField("fipo", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
