package net.anei.cadpage.parsers.SD;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class SDUnionCountyParser extends FieldProgramParser {
  
  public SDUnionCountyParser() {
    super(CITY_LIST, "UNION COUNTY", "SD",
           "CALL+? ADDR/SXP X/Z? SRC UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "WCICC3@sioux-city.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("J:")) return false;
    return super.parseFields(body.split("/"), 5, data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "/", field);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("&")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      String city = STATION_CODES.getProperty(field);
      if (city == null) return false;
      data.strSource = field;
      if (data.strCity.length() == 0) data.strCity = city;
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALCESTER",
    "ALSEN",
    "BERESFORD",
    "DAKOTA DUNES",
    "ELK POINT",
    "GARRYOWEN",
    "JEFFERSON",
    "NORA",
    "NORTH SIOUX",
    "RICHLAND",
    "SPINK"
  };
  
  private static final Properties STATION_CODES = buildCodeTable(new String[]{
      "DDUNES", "DAKOTA DUNES",
      "NSIOUX", "NORTH SIOUX"
  });
}
