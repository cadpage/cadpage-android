package net.anei.cadpage.parsers.OR;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class ORDeschutesCountyParser extends FieldProgramParser {
  
  public ORDeschutesCountyParser() {
    super("DESCHUTES COUNTY", "OR",
          "CALL PRI UNITSRC ADDR! MAP?");
  }
  
  @Override
  public String getFilter() {
    return "911@deschutes.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Normally broken by dash field separators.
    // but a dash with a space on both side is probably a "REAL" dash and
    // needs to be projected from our parsing breaks
    body = body.replaceAll(" - ", "__");
    String[] flds = body.split("-");
    if (flds.length < 5) return false;
    return parseFields(flds, data);
  }
  
  // Call field, replace double underscores with dash
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field.replace("__", " - "), data);
    }
  }
  
  // Priority has to match form
  private class MyPriorityField extends PriorityField {
    public MyPriorityField() {
      setPattern(Pattern.compile("[A-Z][A-Z0-9]?"), true);
    }
  }
  
  private static final Pattern STATION_PAT = Pattern.compile("STA\\d+");
  private class UnitSourceField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (STATION_PAT.matcher(field).matches()) {
        data.strSource = field;
      } else  {
        data.strUnit = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "SRC UNIT";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      parseAddress(StartType.START_ADDR, field, data);
    }
  }
  
  private class MyMapField extends MapField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("Map ")) return false;
      super.parse(field.substring(4).trim(), data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("UNITSRC")) return new UnitSourceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
}
