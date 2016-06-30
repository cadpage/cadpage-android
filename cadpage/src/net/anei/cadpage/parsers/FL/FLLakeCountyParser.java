package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class FLLakeCountyParser extends FieldProgramParser {
  
  public FLLakeCountyParser() {
    super(CITY_LIST, "LAKE COUNTY", "FL",
        "BOX? CH? SRC CALL UNK? ADDR/S! ( SELECT_NOCITY MISC+? CITY! | ) PRI GPS1 GPS2 INFO+");
    removeWords("PARK");
  }
  
  public String getFilter() {
    return "CAD@lakeems.org";
  }
  
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    if (!body.startsWith("CAD:")) return false;
    body = body.substring(4).trim();
    if (!parseFields(body.split("\\*"), data)) return false;
    return data.strCity.length() > 0;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("BOX")) return new BoxField("\\d{3}", true);
    if (name.equals("CH")) return new ChannelField("PS.*|", true);
    if (name.equals("UNK")) return new SkipField("UNKNOWN", true);
    if (name.equals("SELECT_NOCITY")) return new MySelectNoCityField();
    if (name.equals("MISC")) return new MyMiscField();
    return super.getField(name);
  }
  
  private class MySelectNoCityField extends SelectField {
    @Override
    public boolean checkParse(String field, Data data) {
      return data.strCity.length() == 0;
    }
  }
  
  private class MyMiscField extends Field {

    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("APT ")) {
        data.strApt = append(data.strApt, "-", field.substring(4).trim());
      } else {
        data.strPlace = append(data.strPlace, "/", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE APT";
    }
  }
  
  private static final String[] CITY_LIST = new String[] {
    "ASTATULA",
    "CLERMONT",
    "EUSTIS",
    "FRUITLAND PARK",
    "GROVELAND",
    "HOWEY-IN-THE-HILLS",
    "LADY LAKE",
    "LEESBURG",
    "MASCOTTE",
    "MINNEOLA",
    "MONTVERDE",
    "MOUNT DORA",
    "TAVARES",
    "UMATILLA",
    "ALTOONA",
    "ASTOR",
    "BASSVILLE PARK",
    "CITRUS RIDGE",
    "FERNDALE",
    "GRAND ISLAND",
    "LAKE KATHRYN",
    "LAKE MACK-FOREST HILLS",
    "LANIER",
    "LISBON",
    "MOUNT PLYMOUTH",
    "OKAHUMPKA",
    "ORANGE BEND",
    "PAISLEY",
    "PINE LAKES",
    "PITTMAN",
    "SILVER LAKE",
    "SORRENTO",
    "YALAHA"
  };
}
