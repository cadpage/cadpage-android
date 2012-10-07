package net.anei.cadpage.parsers.DE;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DEWilmingtonParser extends FieldProgramParser {
  
  public DEWilmingtonParser() {
    super("WILMINGTON", "DE",
           "DATE TIME PRI? CALL ADDR! PLACE INFO");
  }
  
  @Override
  public String getFilter() {
    return "brandywinefireco@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("*")) body = body.substring(1);
    return parseFields(body.split("\\*"), data);
  }
  
  private class DateField extends SkipField {
    public DateField() {
      setPattern(Pattern.compile("\\d\\d/\\d\\d/\\d{4}"), true);
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  private class MyPriorityField extends PriorityField {
    public MyPriorityField() {
      setPattern(Pattern.compile("L\\d"));
    }
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      parseAddress(p.get(" btwn "), data);
      data.strCross = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE")) return new DateField();
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}


