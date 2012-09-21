package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Lake County, CA
Contact: Gavin Wells <gwells@lakeportfire.com>
Sender: lakecounty.dispatch@lakecountyca.gov
System: Sun Ridge Systems

475 FOREST DR * * SUNSET DR/TERRACE DR * * LP * FDMA * * 8 YOF FALL W/ BLOODY NOSE, C/A/B
330 9TH * * N HIGH/N BRUSH * * LP * FDMA * * 19 YOM ASSLT VIC W/ HEAD LAC
600 YELLOW HAMMER LN * * OSPREY CT * * LP * FDMA * * MED AID 17 YOM DIFF BREATH ETOH VOMITING POSS ALCOHOL POISONING
644 MARTIN * * S ESTEP/S POLK * 3 * LP * FDMA * * MED AID 49 YOF ASSUALT VICT CODE 2 FACIAL LACERATION
301 S MAIN * EXPRESS MART * MARTIN/C * * LP * FDMA * * POSS STROKE...AT PUMPS
SCOTTS VALLEY RANCHERIA/HARTLEY RD, Lakeport * * HARTLEY RD * * FDWF * * VEGITATION FIRE
[Dispatched Call]  S STATE HWY 29/HIGHLAND SPRINGS RD, Lakeport *  * HIGHLAND SPRINGS RD *  * FDMA *  * BETWEEN ARGONAUT AND HIGHLAND SPRINGS IN
[Dispatched Call]  FINLEY EAST RD/THOMAS, Finley *  * THOMAS *  * FDOE *  * TARP WRAPPED INTO THE PG&E WIRES...RP IS CONCERNED THEY ARE GOING TO
2725 S MAIN, Lakeport * ROTTEN ROBBIE * STATE HWY 175 * * FDMA * * 15YOF FALL VIC WITH HEAD INJ C/A
(Dispatched Call) 6633 EICKHOFF RD, Lakeport * MCGEOCH RESIDENCE * PEAR VIEW RD *  * FDAR * 12 * DIINING ROOM SMOKE

 */


public class CALakeCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("(?<= )\\*(?= )");
  
  public CALakeCountyParser() {
    super(CITY_CODES, "LAKE COUNTY", "CA",
           "ADDR PLACE X APT CITY? CALL! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "lakecounty.dispatch@lakecountyca.gov";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(DELIM.split(body), 5, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  // City field doesn't exist if it was entered as part of the address
  private class MyCityField extends CityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strCity.length() > 0) return false;
      parse(field, data);
      return true;
    }
  }
  
  // Call field expands call codes
  private class MyCallCode extends CallField {
    @Override
    public void parse(String field, Data data) {
      String desc = CALL_CODES.getProperty(field);
      if (desc != null) {
        field = field + " - " + desc;
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("CALL")) return new MyCallCode();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CB", "Cobb",
      "CL", "Clearlake",
      "CO", "Clearlake Oaks",
      "CP", "Clearlake Park",
      "FI", "Finley",
      "GL", "Glenhaven",
      "HV", "Hidden Valley Lake",
      "KV", "Kelseyville",
      "LK", "Lake Pillsbury",
      "LL", "Lower Lake",
      "LO", "Loch Lomond",
      "LP", "Lakeport",
      "LU", "Lucerne",
      "MI", "Middletown",
      "NI", "Nice",
      "UL", "Upper Lake",
      "WP", "Whispering Pines",
      "WS", "Witter Springs",
  });
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "FDAA", "Auto Accident",
      "FDAR", "Alarm Sounding",
      "FDHM", "Haz-Mat",
      "FDMA", "Medical Aid",
      "FDSF", "Structure Fire",
      "FDSC", "Smoke Check",
      "FDPA", "Public Assist",
      "FDLL", "Life Line Alert",
      "FDLD", "Lines Down",
      "FDVF", "Vehicle Fire",
      "FDWF", "Wildland Fire",
      "FDWR", "Water Rescue",
      "FDCF", "Chimney Fire",
      "FDAF", "Appliance Fire",
      "FDOE", "Other Event",
      "FDWI", "Walk-In",
      "FDWC", "Welfare Check",
  });
}
