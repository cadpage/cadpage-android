package net.anei.cadpage.parsers.IL;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ILLakeCountyParser extends FieldProgramParser {
  
  public ILLakeCountyParser() {
    super(CITY_CODES, "LAKE COUNTY", "IL",
          "NEW_CALL! Nat:CALL! Loc:ADDR/y! Apt:APT! Grid:MAP! Trucks:UNIT!");
  } 
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("Apt:", ", Apt:");
    body = body.replace(", Trucks", ", Trucks:");
    return parseFields(body.split(", "), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NEW_CALL")) return new SkipField("New Call", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BA",  "BARRINGTON",
      "BH",  "BARRINGTON HILLS",
      "DP",  "DEER PARK",
      "HW",  "HAWTHORN WOODS",
      "KD",  "KILDEER",
      "LB",  "LAKE BARRINGTON",
      "LG",  "LONG GROVE",
      "LS",  "LINCOLNSHIRE",
      "LZ",  "LAKE ZURICH",
      "LZU", "LAKE ZURICH",
      "MUU", "MUNDELEIN",
      "NB",  "NORTH BARRINGTON",
      "WA",  "WAUCONDA"
  });
}
