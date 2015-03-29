package net.anei.cadpage.parsers.ZCABC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ZCABCMidIslandRegionParser extends FieldProgramParser {
  
  private static final Pattern SRC_PTN = Pattern.compile("(BEAVER CREEK|CAMPBELL RIVER|CHERRY CREEK|COMOX|COURTENAY|CUMBERLAND|DENMAN ISLAND|FANNY BAY|HORNBY ISLAND|OYSTER RIVER|PT ALBERNI|SPROAT LAKE|TOFINO|UNION BAY) *(.*)");
  private static final Pattern GPS_PTN = Pattern.compile("\\(?([-+]?[\\d:\\.]+),([-+]?[\\d:\\.]+)\\)");
  private static final Pattern TRAIL_GPS_PTN = Pattern.compile("(.*)\\{(.*)\\}");
  private static final Pattern GPS_PTN2 = Pattern.compile("([-+]?\\d+)(\\d{6}),([-+]?\\d+)(\\d{6})");

  public ZCABCMidIslandRegionParser() {
    this("", "BC");
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
  }
  
  public ZCABCMidIslandRegionParser(String defCity, String defState) {
    super(defCity, defState, "CALL? ADDR/ZSC CITY DATETIME!");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "BEAVER CREEK",
        "BUENA VISTA",
        "CHERRY CREEK",
        "CHESTERMAN BEACH",
        "COLLEGE CAMPUS",
        "COMOX LAKE",
        "COUGAR SMITH",
        "CROWN ISLE",
        "CROWN ISLAND",
        "DOLLY VARDEN",
        "FORBIDDEN PLATEAU",
        "GLACIER VIEW",
        "HORNE LAKE",
        "INLAND ISLAND",
        "IRON RIVER",
        "LACEY LAKE",
        "LAKE TRAIL",
        "LITTLE RIVER",
        "LITTLE TRIBUNE BAY",
        "MACKENZIE BEACH",
        "MAPLE RIDGE",
        "MARTIN PARK",
        "MCCOY LAKE",
        "MIRACLE BEACH",
        "PACIFIC RIM",
        "PARK ACCESS",
        "PORT ALBERNI",
        "PORT AGUSTA",
        "PT ALBERNI",
        "SALMON POINT",
        "SEA LION",
        "SHINGLE SPIT",
        "ST ANNS",
        "STIRLING ARM",
        "VALLEY VIEW",
        "WALTER GAGE",
        "WILLIAMS BEACH");
  }
  
  @Override
  public String getFilter() {
    return "paging@ni911.ca";
  }
  
  @Override
  public String getLocName() {
    return "Mid-Island Region, BC";
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!subject.equals("Fire Dispatch")) return false;

    // Strip off leading source name
    Matcher match = SRC_PTN.matcher(body);
    if (match.matches()) {
      data.strSource = match.group(1);
      body = match.group(2);
    }
    
    // Clean the body of any email text
    int newLine = body.indexOf('\n');
    if(newLine >= 0) {
      body = body.substring(0, newLine);
    }
    
    // Process trailing GPS coordinates
    match = TRAIL_GPS_PTN.matcher(body);
    if (match.matches()) {
      body = match.group(1).trim();
      String gps = match.group(2).replace(" ", "");
      gps = gps.replace(" ", "");
      match = GPS_PTN2.matcher(gps);
      if (match.matches()) {
        setGPSLoc(match.group(1)+'.'+match.group(2)+','+match.group(3)+'.'+match.group(4), data);
      }
    }

    
    // GPS coordinates contain a comma which must be escaped
    body = GPS_PTN.matcher(body).replaceAll("($1|$2)");
    
    String[] fields = body.split(",");
    return parseFields(fields, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram() + " GPS";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }

  private static final Pattern ADDR_GPS_PTN = Pattern.compile("(.*?) *(\\([^\\)A-Za-z]+\\))");
  private static final Pattern ADDR_SPEC_PTN = Pattern.compile("(.*)\\{(.*)\\}");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_GPS_PTN.matcher(field);
      if (match.matches()) {
        data.strCall = append(data.strCall, " / ", match.group(1));
        data.strAddress = match.group(2).replace('|', ',');
      }
      
      else if ((match = ADDR_SPEC_PTN.matcher(field)).matches()) {
        data.strCall = append(data.strCall, " / ", match.group(1).trim());
        parseAddress(match.group(2).trim(), data);
      }

      else if(data.strCall.length() > 0) {
        parseAddress(field, data);
      }
      else {
        super.parse(field, data);
      }
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(?:BC )?(\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)(?: +(.*))?");
  private class MyDateTimeField extends DateTimeField {
    
    @Override 
    public boolean canFail() {
      return true;
    }
    
    @Override 
    public boolean checkParse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strUnit = getOptGroup(match.group(3));
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if(!checkParse(field, data)) super.abort();
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME UNIT";
    }
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ABANDONED 911",
      "ALARMS NON EMERGENCY",
      "ALARMS",
      "AVIATION INCIDENT",
      "BEACH/BRUSH/MISC OUT EMERG",
      "BEACH/BRUSH/MISC OUT NON EMERG",
      "BEACH/BRUSH/MISC OUT",
      "BOMB THREAT",
      "CARBON MONOXIDE NON EMERG",
      "CARBON MONOXIDE NON EMERGENCY",
      "CARBON MONOXIDE",
      "CHIMNEY FIRE",
      "DUPLICATE",
      "DUTY INVESTIGATION",
      "DUTY OFFICER",
      "FIRST ALARM - A",
      "FIRST ALARM - B",
      "FIRST ALARM - C",
      "FIRST RESP A",
      "FIRST RESP ASSIST D/E",
      "FIRST RESP ASSIST EMERGENCY",
      "FIRST RESP ASSIST ROUTINE",
      "FIRST RESP B",
      "FIRST RESP C",
      "FIRST RESP D",
      "FIRST RESP DELAY B/C",
      "FIRST RESP DELAY D/E",
      "FIRST RESP E",
      "FIRST RESPONDER DELAY B/C",
      "FIRST RESPONDER DELAY D/E",
      "FIRST RESPONDER UNKNOWN",
      "FUEL - LEAK/SPILL/OTH",
      "FUEL - LEAK/SPILL/OTH NON EMER",
      "FUEL - LEAK/SPILL/OTHER NON EMERG",
      "FUEL - LEAK/SPILL/OTHER",
      "GARBAGE CONTAINER",
      "HAZMAT NON EMERGENCY",
      "HAZMAT",
      "HYDRO TROUBLE",
      "MARINE INCIDENT",
      "MARINE",
      "MOTOR VEHICLE ACCIDENT",
      "MOTOR VEHICLE FIRE",
      "MV FIRE",
      "MVI / EXTRICATION",
      "MVI PED STRUCK",
      "MVI PORT",
      "MVI",
      "MVI/EXTRICATION",
      "NATURAL GAS LINE BREAK",
      "NATURAL GAS/PROP NON EMERG",
      "NATURAL GAS/PROPANE EMERGENCY",
      "NATURAL GAS/PROPANE NON EMERG",
      "NATURAL GAS/PROPANE",
      "PUBLIC SERVICE",
      "RESCUE - ROAD",
      "RESCUE -CONFINED",
      "RESCUE -HIGH ANGLE",
      "RESCUE -LOW ANGLE/BCAS ASSIST",
      "RESCUE -MARINE",
      "RESCUE -SWIFT WATER",
      "RESCUE LOW ANGLE/BCAS ASSIST",
      "RESCUE - ROAD",
      "RESCUE ROAD",
      "RESCUE",
      "STRUCTURE  - FIRE",
      "STRUCTURE - ELECTRICAL TROUBLE",
      "STRUCTURE - FIRE",
      "STRUCTURE - SMOKE ODOUR",
      "STRUCTURE - SMOKE",
      "STRUCTURE FIRE",
      "STRUCTURE ODOUR",
      "STRUCTURE SMOKE",
      "TEST",
      "TSUNAMI WARNING"
  );
  
  @Override
  protected String adjustGpsLookupAddress(String address) {
    return address.toUpperCase();
  }

  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "HMCS QUADRA",    "49.662330,-124.914198"
  });
}
