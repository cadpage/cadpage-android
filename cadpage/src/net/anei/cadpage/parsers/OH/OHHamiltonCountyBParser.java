package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OHHamiltonCountyBParser extends FieldProgramParser {
 
  public OHHamiltonCountyBParser() {
    super("HAMILTON COUNTY", "OH",
          "DATETIME CALL ADDR! CITY INFO/CS+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@norwood-ohio.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatched")) return false;
    return parseFields(body.split(","), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern CALL_PTN = Pattern.compile("([A-Z]{4}) +(.*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCode = match.group(1);
      data.strCall = match.group(2);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private static Pattern INFO_DATE_TIME_PTN = Pattern.compile("\\d{4}/\\d\\d/\\d\\d \\d:\\d\\b *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_DATE_TIME_PTN.matcher(field);
      if (match.lookingAt()) field = field.substring(match.end());
      super.parse(field, data);
    }
  }
}
