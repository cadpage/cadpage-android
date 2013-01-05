package net.anei.cadpage.parsers.ID;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class IDKootenaiCountyParser extends FieldProgramParser {
  
  public IDKootenaiCountyParser() {
    super("KOOTENAI COUNTY", "ID",
          "SRC CALL ADDR UNIT+? CH! INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("KOOTENAI COUNTY SHERIFF ")) {
      body = body.substring(24).trim();
    }
    int pt = body.indexOf("\nSent by CLI");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    String[] flds = body.split("\n");
    if (flds.length < 5) return false;
    return parseFields(flds, data);
  }
  
  // Radio channel must start with OPS
  private class MyChannelField extends ChannelField {
    public MyChannelField() {
      setPattern(Pattern.compile("OPS.*"));
    }
  }
  
  // INFO field skips anything starting with a date/time
  private static Pattern DATE_TIME_PTN = Pattern.compile("^\\d\\d:\\d\\d:\\d\\d: \\d\\d/\\d\\d/\\d\\d\\d\\d\\b");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (DATE_TIME_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CH")) return new MyChannelField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
