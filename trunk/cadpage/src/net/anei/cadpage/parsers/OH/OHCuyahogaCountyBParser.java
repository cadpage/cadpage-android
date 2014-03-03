package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHCuyahogaCountyBParser extends FieldProgramParser {

  public OHCuyahogaCountyBParser() {
    super("CUYAHOGA COUNTY", "OH", 
          "ID UNIT_CALL ADDR EMPTY CITY_ST! Agencies_assigned:SKIP! PHONE");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Dispatch Alert: ")) return false;
    return super.parseFields(body.split("\n"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("CD-\\d{2}-\\d{6}", true);
    if (name.equals("UNIT_CALL")) return new MyCodeCallField();
    if (name.equals("CITY_ST")) return new MyCityStateField();
    return super.getField(name);
  }

  private static Pattern CODE_CALL = Pattern.compile("([A-Z]+\\d+) +(.*?)");

  private class MyCodeCallField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher mat = CODE_CALL.matcher(field);
      if (!mat.matches()) abort();
      data.strCode = mat.group(1);
      data.strCall = mat.group(2);
    }

    @Override
    public String getFieldNames() {
      return "CODE CALL";
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
}
