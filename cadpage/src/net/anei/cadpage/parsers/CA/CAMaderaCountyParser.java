package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CAMaderaCountyParser extends FieldProgramParser {
  
  public CAMaderaCountyParser() {
    super("MADERA COUNTY", "CA", 
          "CALL:CALL! PLACE:PLACE! ADDR:ADDR! EVENT_#:ID! PRI:PRI! DATE:DATE! TIME:TIME INFO/N+");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@cityofchowchilla.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n+"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE")) return new DateField("\\d\\d?/\\d\\d?/\\d{4}", true);
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  private static final Pattern TIME_PTN = Pattern.compile("(\\d{2})(\\d{2})");
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strTime = match.group(1) +':' + match.group(2);
    }
  }
}
