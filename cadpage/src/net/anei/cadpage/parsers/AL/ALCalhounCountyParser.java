package net.anei.cadpage.parsers.AL;

import java.util.regex.*;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Calhoun County AL
 */
public class ALCalhounCountyParser extends FieldProgramParser {
  
  
  public ALCalhounCountyParser() {
    super(CITY_LIST, "CALHOUN COUNTY", "AL",
           "ADDR/S6 ID TIME CALL! INFO+");
  }

  private static final Pattern DISPATCH_ID_PATTERN
    = Pattern.compile("(?i)^[A-Z]{2}\\d{4}\\:(.*)");
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher m = DISPATCH_ID_PATTERN.matcher(body);
    if (m.matches())
      return super.parseFields(m.group(1).split(","), data);
    return false;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse (String field, Data data) {
      data.strSupp = append(data.strSupp, ", ", field);
    }
  }
  
  private static final String[] CITY_LIST = new String[] {
    "JACKSONVILLE",
    "WELLINGTON",
    "PIEDMONT"
  };
}
