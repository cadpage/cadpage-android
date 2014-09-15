package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class PADelawareCountyGParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\n|\\|");
  
  public PADelawareCountyGParser() {
    super("DELAWARE COUNTY", "PA",
          "( CALL:CALL! ADDR:ADDR! CITY:CITY? ID:ID? DATE:DATE! TIME:TIME! UNIT:UNIT INFO:INFO+ " + 
          "| ADDR:ADDR! CITY:CITY? CALL:CALL? DATE:DATE? TIME:TIME? ID:ID? INFO:INFO+? UNIT:UNIT )");
  }
  
  @Override
  public String getFilter() {
    return "admin@springfieldems.com,alerts@delcodispatch.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE")) return new DateField("\\d\\d/\\d\\d/\\d{4}", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('~', ' ').trim().replaceAll("  +", " ");
      super.parse(field, data);
    }
  }
}
