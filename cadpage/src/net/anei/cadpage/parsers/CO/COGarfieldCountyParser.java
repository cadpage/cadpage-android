package net.anei.cadpage.parsers.CO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;

public class COGarfieldCountyParser extends SmartAddressParser {
  
  private static final Pattern ID_PTN = Pattern.compile(" +(\\d{4}[- ]\\d{8})$");
  
  public COGarfieldCountyParser() {
    super(CITY_CODES, "GARFIELD COUNTY", "CO");
    setFieldList("ADDR APT PLACE MAP CITY X CALL ID");
    setupMultiWordStreets(
        "BAKER HILL",
        "BENT CREEK",
        "BLACK SULPHUR",
        "CASTLE VALLEY",
        "CHAIR BAR",
        "COAL MINE",
        "D J",
        "EAGLES NEST",
        "EL DIENTE",
        "FOREST SERVICE",
        "GRAND VALLEY",
        "GREEN MESA",
        "HIDDEN VALLEY",
        "LITTLE ECHO",
        "MEADOW CREEK",
        "MEL RAY",
        "MINERAL SPRINGS",
        "MOUNT SOPRIS",
        "QUEEN CITY",
        "RED MOUNTAIN",
        "RIVER FRONTAGE",
        "RIVER VIEW",
        "SILVER OAK",
        "SOCCER FIELD",
        "SPRING WAGON",
        "ST JOHN",
        "STONE QUARRY",
        "WILLOW CREEK",
        "WILLOW VIEW"
    );
  }
  
  @Override
  public String getFilter() {
    return "GCECA@call3n.com,@everbridge.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page") && !subject.equals("EverBridge CAD Page")) return false;
    
    // Remove the  no longer optional call ID
    Matcher match = ID_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(0,match.start());
    
    // The last thing in the line now is the call description.
    // See if we can pick it out with our call list
    String call = CALL_LIST.getCode(body, true);
    if (call != null) {
      data.strCall = call;
      body = body.substring(0,body.length()-call.length()).trim();
    }
    
    // We have to count on the SAP to figure everything else out
    parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT | FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS, body, data);
    
    // There is almost always one or two city codes, which makes things easier
    // But occasionally there is no city and we have to deal with that
    if (data.strCity.length() == 0) {
      String left = getLeft();
      if (data.strCall.length() > 0) {
        data.strPlace = left;
      } else {
        data.strCall = left;
        if (data.strCall.length() == 0) return false;
      }
      return true;
    }

    // We do have a city code
    // See if it is really a map code
    if (MAP_CODES.contains(data.strCity.toUpperCase())) {
      data.strMap = data.strCity;
      data.strCity = "";
    }
    
    // Any pad field is a place name, or possibly an apt
    String place = getPadField();
    if (place.length() > 0) {
      if (place.length() <= 2) {
        data.strApt = append(data.strApt, "-", place);
      } else {
        data.strPlace = place;
      }
    }
    
    body = getLeft();
    
    int flags = FLAG_ONLY_CROSS | FLAG_ONLY_CITY;
    if (data.strCall.length() > 0) {
      flags |= FLAG_ANCHOR_END;
    } else {
      if (body.length() == 0) return false;
    }
    if (body.length() > 0) {
      Result res = parseAddress(StartType.START_ADDR, flags, body);
      if (data.strCall.length() > 0 || res.getCity().length() > 0) {
        String saveCity = data.strCity;
        res.getData(data);
        if (MAP_CODES.contains(data.strCity.toUpperCase())) {
          data.strMap = data.strCity;
          data.strCity = saveCity;
        }
        body = res.getLeft();
      }
      if (data.strCall.length() == 0) data.strCall = body;
    }
    return true;
  }
  
  @Override
  public CodeSet getCallList() {
    return CALL_LIST;
  }
  
  private static final CodeSet CALL_LIST = new ReverseCodeSet(
      "Accident",
      "AsstCit",
      "AsstOA",
      "Code",
      "Fraud Forgery",
      "Mutual Aid Request",
      "Shots Fired",
      "Suicidal Subject",
      "Transient",
      "Transport",
      "Warrant",
      "Welfare Check",
      
      "EAbdominal",
      "EAllergic Reaction",
      "EAnimal Bites",
      "EAssault",
      "EBack Pain",
      "EBleeding Non traumatic",
      "EBleeding/Non traumatic",
      "EBreathing Difficulty",
      "EChest Pain",
      "EChoking",
      "EDiabetic",
      "EEnvironmental Emergencies",
      "EEye Problems Injury",
      "EEye Problems/Injury",
      "EFalls",
      "EGynecology Childbirth",
      "EGynecology/Childbirth",
      "EHeadache",
      "EMedical Alarm",
      "EMental Emotional Psych",
      "EMental/Emotional/Psych",
      "ENeurological/Head Injuries",
      "EOverdose Poisoning",
      "EOverdose/Poisoning",
      "ESeizures",
      "ESick Unknown",
      "ESick/Unknown",
      "EStabbing Gunshot",
      "EStabbing/Gunshot",
      "EStroke",
      "ETrauma with Injury",
      "EUnconscious Syncope",
      "EUnconscious/Syncope",
      "EUnresponsive",
      
      "FAlarm",
      "FBrush",
      "FGas Leak",
      "FElevator Alarm",
      "FFuel Leak",
      "FGas Well Fire",
      "FHazMat Incident",
      "FOdor Check",
      "FPower Pole",
      "FRescue Assignment",
      "FRiver Rescue",
      "FSmoke Check",
      "FStructure",
      "FVehicle Fire"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CARB", "CARBONDALE",
      "GS",   "GLENWOOD SPRINGS",
      "NC",   "NEW CASTLE",
      "PARA", "PARACHUTE",
      "RIF",  "RIFLE",
      "SIL",  "SILT",
      "SILT", "SILT",
      "Z1",   "Z1",
      "Z2",   "Z2",
      "Z3",   "Z3"
  });
  
  private static final Set<String> MAP_CODES = new HashSet<String>(Arrays.asList(
      "Z1",
      "Z2",
      "Z3"
  ));
}
