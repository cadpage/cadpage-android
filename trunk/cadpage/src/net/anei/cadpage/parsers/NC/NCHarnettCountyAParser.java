package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Harnett County, NC
 */
public class NCHarnettCountyAParser extends FieldProgramParser {
  
  public NCHarnettCountyAParser() {
    super(NCHarnettCountyParser.CITY_LIST, "HARNETT COUNTY", "NC",
           "ID ADDR APT UNK CITY X/Z+? EMPTY EMPTY+? CALL!");
  }
  
  @Override
  public String getFilter() {
    return "cadpage@harnett.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    String flds[] = body.split("\\*");
    if (flds.length < 3) return false;
    return parseFields(flds, data);
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{4}-\\d{6}"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }
}
