package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Bell County, TX
 */
public class TXBellCountyParser extends FieldProgramParser {
  
  public TXBellCountyParser() {
    super(CITY_CODES, "BELL COUNTY", "TX",
        "PRI LOC:ADDR/S TYPE_CODE:CALL! SubType:CALL CALLER_NAME:NAME! CLRNUM:PHONE! TIME:TIME! Comments:INFO");
    setupGpsLookupTable(GPS_TABLE);
  }
  
  public String getFilter() {
    return "930010";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PRI")) return new PriorityField("P(\\d)");
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static final Pattern PLACE_MARKER = Pattern.compile(": ?[@:]");
  private static final Pattern ADDR_APT_PTN = Pattern.compile("(.*), *([^ ]+)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      while (field.endsWith(": EST")) field = field.substring(0,field.length()-5).trim();
      field = field.replace("CHAPPARAL", "CHAPARRAL");
      if (field.startsWith("@")) {
        data.strAddress = field;
      } else {
        String apt = "";
        Matcher match = PLACE_MARKER.matcher(field);
        if (match.find()) {
          data.strPlace = field.substring(match.end()).trim();
          field = field.substring(0,match.start()).trim();
        }
        match = ADDR_APT_PTN.matcher(field);
        if (match.matches()) {
          field = match.group(1).trim();
          apt = match.group(2);
        }
        super.parse(field, data);
        data.strApt = append(data.strApt, "-", apt);
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private static final Pattern INFO_PHONE_GPS_PTN = Pattern.compile("(\\d{10}) ([-+]\\d{3}\\.\\d{6} [-+]\\d{3}\\.\\d{6})\\b *(.*)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_PHONE_GPS_PTN.matcher(field);
      if (match.matches()) {
        data.strPhone = match.group(1);
        setGPSLoc(match.group(2), data);
        field = match.group(3);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PHONE GPS INFO";
    }
  }
  
  @Override
  protected String adjustGpsLookupAddress(String address) {
    if (!address.startsWith("@")) return null;
    int pt = address.indexOf(':');
    if (pt >= 0) address = address.substring(0,pt);
    return address;
  }

  private static final Properties GPS_TABLE = buildCodeTable(new String[]{
      "@305",   "31.153174,-97.324602",
      "@306",   "31.166908,-97.319074",
      "@307",   "31.180577,-97.313935",
      "@308",   "31.192139,-97.309398",
      "@309",   "31.208031,-97.302668",
      "@310",   "31.221252,-97.295544",
      "@311",   "31.233926,-97.288221",
      "@312",   "31.243887,-97.282241",
      "@313",   "31.256592,-97.275016",
      "@314",   "31.272733,-97.265484",
      "@315",   "31.284852,-97.256454"
  });
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BART", "BARTLETT",
      "BELL", "",         // Bell County
      "HLND", "HOLLAND",
      "HKRH", "HARKER HEIGHTS",
      "NOLN", "NOLANVILLE",
      "TROY", "TROY"
  });
  
}
