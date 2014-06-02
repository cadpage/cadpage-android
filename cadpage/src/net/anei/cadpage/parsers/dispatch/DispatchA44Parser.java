package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA44Parser extends FieldProgramParser {

  protected DispatchA44Parser(String defCity, String defState) {
    super(defCity, defState, 
          "ID UNIT_CALL ADDR X! CITY_ST Agencies_assigned:SKIP! INFO+");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Dispatch Alert: ")) return false;
    return super.parseFields(body.split("\n"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("CD-\\d{2}-\\d+", true);
    if (name.equals("UNIT_CALL")) return new MyUnitCallField();
    if (name.equals("CITY_ST")) return new MyCityStateField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static Pattern UNIT_CALL = Pattern.compile("([A-Z]+\\d*) +(.*?)");

  private class MyUnitCallField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher mat = UNIT_CALL.matcher(field);
      if (!mat.matches()) abort();
      data.strUnit = mat.group(1);
      data.strCall = mat.group(2);
    }

    @Override
    public String getFieldNames() {
      return "UNIT CALL";
    }
  }

  private static Pattern CITY_STATE = Pattern.compile("(.*?) +([A-Z]{2})");

  private class MyCityStateField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher mat = CITY_STATE.matcher(field);
      if (!mat.matches()) abort();
      data.strCity = mat.group(1);
      String ST = mat.group(2);
      if (!ST.equals("OH")) data.strState = mat.group(2);
    }

    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
  private static final Pattern RP_PHONE_PTN = Pattern.compile("RP (?:IS )?(.*)(\\d{3}-\\d{3}-\\d{4})");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (PHONE_PTN.matcher(field).matches()) {
        data.strPhone = field;
        return;
      }
      Matcher match = RP_PHONE_PTN.matcher(field);
      if (match.matches()) {
        data.strName = match.group(1).trim();
        data.strPhone = match.group(2);
        return;
      }
      if (field.startsWith("RP IS ")) {
        data.strName = field.substring(6).trim();
        return;
      }
      if (field.startsWith("APT ")) {
        data.strApt = append(data.strApt, "-", field.substring(4).trim());
        return;
      }
      data.strSupp = append(data.strSupp, "\n", field);
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE INFO";
    }
  }
}
