package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA9Parser extends FieldProgramParser {
  
  private static final String START_MARKER = "Rip and Run Report\n\n~\n";
  private static final Pattern CLEAR_DATE_PTN = Pattern.compile("\nClear Date/Time:~\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d\\b");
  
  public DispatchA9Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState,
           "Location:ADDR! Common_Name:PLACE? Venue:CITY! SKIP X Phone:PHONE? Quadrant:MAP! District:MAP! Call_Number:ID! Call_Type:CALL! Priority:PRI Caller:NAME Dispatch_Date/Time:DATETIME SKIP+? Units_Sent:SKIP UNIT Narrative:SKIP INFO+");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("\t", " ");
    int pt = body.indexOf(START_MARKER);
    if (pt < 0) return false;
    if (pt > 0 && body.charAt(pt-1)!='\n') return false;
    
    // If it has a clear date, treat it as a run report
    Matcher match = CLEAR_DATE_PTN.matcher(body);
    if (match.find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    body = body.substring(pt+START_MARKER.length()).trim();
    body = body.replace('~', ' ');
    return parseFields(body.split("\n"), data);
  }
  
  private class BaseCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equalsIgnoreCase("No Cross Streets Found")) return;
      super.parse(field, data);
    }
  }
  
  private class BaseMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals(data.strMap)) return;
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  private static final Pattern INFO_MARKER = Pattern.compile("^\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d:\\d\\d ");
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_MARKER.matcher(field);
      if (!match.find()) return;
      field = field.substring(match.end()).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new BaseCrossField();
    if (name.equals("MAP")) return new BaseMapField();
    if (name.equals("INFO")) return new BaseInfoField();
    return super.getField(name);
  }
}
