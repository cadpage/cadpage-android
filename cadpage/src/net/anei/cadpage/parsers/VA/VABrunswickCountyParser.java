package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class VABrunswickCountyParser extends FieldProgramParser {
    
  
  public VABrunswickCountyParser() {
    super("BRUNSWICK COUNTY", "VA",
           "IDCALL ADDR! X! CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "bcso_dispatch@verizon.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("BCSO CFS Info - DO NOT REPLY")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyIdCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strCallId = field.substring(0,pt);
      data.strCall = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      data.strCity = expandCity(field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("IDCALL")) return new MyIdCallField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  /*
   * Expand a possibly truncated city name to full city name
   */
  private static String expandCity(String city) {
    for (String cty : CITY_LIST) {
      if (cty.startsWith(city)) return cty;
    }
    return "";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALBERTA",
    "BRODNAX",
    "LAWRENCEVILLE"
  };
}
