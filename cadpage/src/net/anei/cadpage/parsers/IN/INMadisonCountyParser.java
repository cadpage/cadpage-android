package net.anei.cadpage.parsers.IN;

import java.util.Properties;

/**
 * Madison County (Alexandria), IN
 */
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INMadisonCountyParser extends FieldProgramParser {
  
  public INMadisonCountyParser() {
    super(CITY_CODES, "MADISON COUNTY", "IN",
          "Unit:UNIT UnitSts:SKIP Loc:ADDR! Venue:CITY! Inc:CALL! Date:DATE! Time:TIME Addtl:INFO");
  }
  
  @Override
  public String getFilter() {
    return "Mplus@madisoncty.com";
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get(' '), data);
      data.strSupp = p.get();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CHESTERFIE", "CHESTERFIELD",
      "CHESTERFIE STATION 50", "CHESTERFIELD",
      "COUNTRY CL", "COUNTRY CLUB HEIGHTS",
      "MARKLEVILL", "MARKLEVILLE",
      "RIVER FORE", "RIVER FOREST",
      "WOODLAWN H", "WOODLAWN HEIGHTS",
      "ANDERS TWP", "ANDERSON TWP",
      "DUCK C TWP", "DUCK CREEK TWP",
      "FALL C TWP", "FALL CREEK TWP",
      "JACKSO TWP", "JACKSON TWP",
      "LAFAYE TWP", "LAFAYETTE TWP",
      "PIPE C TWP", "PIPE CREEK TWP",
      "RICHLA TWP", "RICHLAND TWP",
      "STONEY TWP", "STONEY CREEK TWP",
      "VAN BU TWP", "VAN BUREN TWP"
  });
}
