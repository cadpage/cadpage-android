package net.anei.cadpage.parsers.SD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class SDUnionCountyParser extends FieldProgramParser {
  
  public SDUnionCountyParser() {
    super(CITY_LIST, "UNION COUNTY", "SD",
           "ID DATE TIME CALL+? ADDR/Z CITY! PLACE_X/Z+? SRC UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "@sioux-city.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("J:")) return false;
    if (!super.parseFields(body.split("/"), 8, data)) return false;
    if (data.strCity.equals("SIOUX CITY")) data.strState = "IA";
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }
  
  private static final Pattern DATE_PTN = Pattern.compile("\\d\\d-\\d\\d-\\d\\d");
  private class MyDateField extends DateField {
    public MyDateField() {
      setPattern(DATE_PTN);
    }
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace('-', '/');
      super.parse(field, data);
    }
    
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "/", field);
    }
  }
  
  private class PlaceCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      
      if (field.endsWith("&")) field = field.substring(0,field.length()-1).trim();
      
      // The first field, and only the first field, is considered a place name if it
      // is not a legitimate address
      if (data.strPlace.length() == 0 && data.strCross.length() == 0 && checkAddress(field) == 0) {
        data.strPlace = field;
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE X";
    }
  }
  
  private static final Pattern SRC_CODE_PTN = Pattern.compile("([A-Z]+)\\d+");
  private class MySourceField extends SourceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = SRC_CODE_PTN.matcher(field);
      if (!match.matches()) return false;
      String city = STATION_CODES.getProperty(match.group(1));
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
    if (name.equals("ID")) return new IdField("\\d{9}");
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d");
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PLACE_X")) return new PlaceCrossField();
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = INTERSECT_PTN.matcher(address).replaceAll("");
    return address;
  }
  private static final Pattern INTERSECT_PTN = Pattern.compile(" +INTERSECT[A-Z]*$");
  
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
    "SPINK",
    
    "SIOUX CITY"
  };
  
  private static final Properties STATION_CODES = buildCodeTable(new String[]{
      "DDUNES",   "DAKOTA DUNES",
      "NSIOUX",   "NORTH SIOUX",
      "SCFD",     "SIOUX CITY"
  });
}
