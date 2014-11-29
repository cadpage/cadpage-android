package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Mendocino County, CA
 */
public class CAMendocinoCountyParser extends FieldProgramParser {
  
  public CAMendocinoCountyParser() {
    super(CITY_CODES, "MENDOCINO COUNTY", "CA",
           "CALL ADDR! Inc:IDGPSUNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "meucad@fire.ca.gov,@albionfire.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA | MAP_FLG_PREFER_GPS;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace(" Inc# ", " Inc: ");
    return parseFields(body.split(";"), data);
  }
  
  private static final Pattern TRAIL_PARENS = Pattern.compile("\\(([^\\(]*?)\\)$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = TRAIL_PARENS.matcher(field);
      if (match.find()) {
        data.strPlace = match.group(1);
        field = field.substring(0,match.start()).trim();
      }
      Parser p = new Parser(field);
      data.strPlace = append(p.getOptional('@'), " / ", data.strPlace);
      data.strCity = convertCodes(p.getLastOptional(','), CITY_CODES);
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR CITY";
    }
  }
  
  private static final Pattern ID_GPS_UNIT_PTN =
    Pattern.compile("(\\d*) *X: ([- 0-9.]+) Y: ([- 0-9.]+)(.*)");
  private class IdGpsUnitField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_GPS_UNIT_PTN.matcher(field);
      if (match.matches()) {
        data.strCallId = match.group(1).trim();
        // GPS coordinates have to be reversed, Google expects Latitude first.
        String gpsLoc = match.group(3) + ',' + match.group(2);
        setGPSLoc(gpsLoc, data);
        data.strUnit = match.group(4).trim();
      }
    }
    
    @Override
    public String  getFieldNames() {
      return "ID GPS UNIT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("IDGPSUNIT")) return new IdGpsUnitField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALBI", "ALBION",
      "ANCB", "ANCHOR BAY",
      "ARENA", "POINT ARENA",
      "BOON", "BOONVILLE",
      "BRANSB", "BRANSCOMB",
      "BROOK", "BROOKTRAILS",
      "CALP", "UKIAH",
      "CASP", "MENDOCINO",
      "CLEON", "FORT BRAGG",
      "COMP", "COMPTCHE",
      "COVL", "COVELO",
      "DOSR", "DOS RIOS",
      "ELK", "ELK",
      "FORTB", "FORT BRAGG",
      "GUALA", "GUALALA",
      "HALESG", "HALES GROVE",
      "HOPL", "HOPLAND",
      "HOPR", "HOPLAND",
      "INGL", "INGLENOOK",
      "IRISH", "MANCHESTER",
      "LAYT", "LAYTONVILLE",
      "LEGG", "LEGGETT",
      "LITR", "LITTLE RIVER",
      "LONV", "LONGVALE",
      "MANC", "MANCHESTER",
      "MCNR", "HOPLAND",
      "MENDO", "MENDOCINO",
      "NAVA", "NAVARRO",
      "OOJ", "OUT OF JURISDICTION",
      "ORR", "UKIAH",
      "PHILO", "PHILO",
      "PIERC", "PIERCY",
      "PILS", "LAKE PILLSBURY",
      "POTV", "POTTER VALLEY",
      "REDV", "REDWOOD VALLEY",
      "ROCKP", "ROCKPORT",
      "ROGH", "UKIAH",
      "SHER", "WILLITS",
      "TALM", "UKIAH",
      "TRIN", "Mendocino National Forest, Mad River, CA",
      "UKH", "UKIAH",
      "UKV", "UKIAH",
      "VICHY", "UKIAH",
      "VNAR", "POTTER VALLY",
      "WESTP", "WESTPORT",
      "WHALG", "WHALE GULCH",
      "WILL", "WILLITS",
      "YORK", "YORKVILLE"
  });
}
