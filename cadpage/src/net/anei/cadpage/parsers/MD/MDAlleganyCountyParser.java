package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDAlleganyCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("CAD|Company +([^ ]+)");
  private static final Pattern MARKER = Pattern.compile("(\\d\\d:\\d\\d) #(\\d+) +");
  private static final Pattern MASTER2 = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d?) +(.*) ([A-Z]{2}\\d{10})");
  
  public MDAlleganyCountyParser() {
    super("ALLEGANY COUNTY", "MD",
          "ADDR/SLP! BOX:BOX? DUE:UNIT!");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "ALI GHAN",
        "ASCAR FARM",
        "BEACH VIEW",
        "BEALLS MILL",
        "BEANS COVE",
        "BEDFORD VALLEY",
        "BISHOP MURPHY",
        "BLAN AVON",
        "BLOOMING FIELDS",
        "BLUE VALLEY",
        "BURNING MINES",
        "BURTON PARK",
        "BUSKIRK HOLLOW",
        "CABIN RUN",
        "CANAL FERRY",
        "CANNON RUN",
        "CASH VALLEY",
        "CHESTNUT GROVE",
        "CHURCH HILL",
        "CLEMENT ARMSTRONG",
        "COON CLUB",
        "CREEK BOTTOM",
        "DANS ROCK",
        "DAWSON CEMETERY",
        "DR NANCY S GRASMICK",
        "DRY RIDGE",
        "ECKHART CEMETERY",
        "ECKHART MINES",
        "FIR TREE",
        "FRANTZ HOLLOW",
        "FROSTBURG TRAILHEAD",
        "GEORGES CREEK",
        "HIGH ROCK",
        "HIGHLAND ESTATES",
        "HOFFMAN HOLLOW",
        "IRONS MOUNTAIN",
        "KENNELLS MILL",
        "LAURA LEE",
        "LAUREL RUN",
        "LOG TRAIL",
        "MEXICO FARMS",
        "MILL RUN",
        "MOUNT PLEASANT",
        "MOUNT SAVAGE",
        "NAVES CROSS",
        "OAKLAWN EXT",
        "OCEAN HILL",
        "OLD MINING",
        "ORCHARD MEWS",
        "PALO ALTO",
        "PEA VINE",
        "PINE RIDGE",
        "PINEY MOUNTAIN",
        "POMPEY SMASH",
        "POTOMAC VIEW",
        "QUARRY RIDGE",
        "QUEENS POINT",
        "RED ROCK",
        "ROCKY GAP",
        "ROSE BRIAR",
        "SAINT JOHNS ROCK",
        "SAINT MARYS CHURCH",
        "SANDSPRING RUN",
        "SAVAGE RIVER",
        "SISLER HILL",
        "SMITH HILL",
        "SMOUSES MILL",
        "SPRING HOLLOW",
        "SQUIRREL NECK",
        "STONEY RUN",
        "STRINGTOWN HOLLOW",
        "SUGAR MAPLE",
        "SUGAR ROW",
        "TAR WATER HOLLOW",
        "TIMBER RIDGE",
        "TRAIL RIDGE",
        "UNCONSCIOUS/FAINTING",
        "VALE SUMMIT",
        "VALLEY VIEW",
        "VERNON ESTATES",
        "VICTORY POST",
        "WALNUT BOTTOM",
        "WASHINGTON HOLLOW",
        "WELSH HILL",
        "WHITE CHURCH",
        "WILLOW BROOK",
        "WOOD ROSE",
        "YELLOW ROW"
    );
    setupPlaceAddressPtn(Pattern.compile("(LOWES OF ALLEGANY COUNTY)|(.*) - "), false);
  }
  
  @Override
  public String getFilter() {
    return "acgov_911_cad@allconet.org,cad911@alleganygov.org,messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = getOptGroup(match.group(1));
    
    do {
      match = MARKER.matcher(body);
      if (match.find()) {
        data.strTime = match.group(1);
        data.strCallId = match.group(2);
        body = body.substring(match.end());
        break;
      }
      
      match = MASTER2.matcher(body);
      if (match.matches()) {
        data.strTime = match.group(1);
        body = match.group(2).trim();
        data.strCallId = match.group(3);
        break;
      }
      
      if (body.startsWith("CT:")) {
        body = body.substring(3).trim();
        break;
      }
      
      return false;
      
    } while (false);
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC TIME ID " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  private static final Pattern ROUTE_PERIOD_PTN = Pattern.compile("\\b(US|RT|MD)\\.(\\d+)");
  private static final Pattern CODE_PTN = Pattern.compile("(.*?) (\\d\\d?[A-Z]\\d\\d?[A-Z]?) (.*)");
  private static final Pattern MM_PTN = Pattern.compile("\\bMM\\b");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        String city = field.substring(pt+1).trim();
        if (city.equalsIgnoreCase("PIEDMONT")) {
          data.strCity = city;
          data.strState = "WV";
          field = field.substring(0,pt).trim();
        }
      }
      
      StartType st = StartType.START_CALL_PLACE;
      int flags = FLAG_START_FLD_REQ;
      Matcher match = CODE_PTN.matcher(field);
      if (match.matches()) {
        st = StartType.START_PLACE;
        flags = 0;
        data.strCall = match.group(1).trim();
        data.strCode = match.group(2);
        field = match.group(3).trim();;
      }
      
      field = ROUTE_PERIOD_PTN.matcher(field).replaceAll("$1 $2");
      field = field.replace('€', '@');
      parseAddress(st, flags, field, data);
      
      if (MM_PTN.matcher(data.strPlace).find()) {
        data.strAddress = append(data.strPlace, " ", data.strAddress);
        data.strPlace = "";
      }
      data.strPlace = append(data.strPlace, " - ", getLeft());

      if (data.strAddress.length() == 0) {
        parseAddress(data.strPlace, data);
        data.strPlace = "";
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL CODE PLACE ADDR APT CITY ST";
    }
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "911 TEST CALL TEST PAGE DO NOT RESPOND",
      "ABDOMINAL /BACK PAIN",
      "ACCIDENT NOT LISTED",
      "ACCIDENT PD",
      "ACCIDENT PED STRUCK",
      "ACCIDENT PI",
      "ADDITIONAL 911 CALL NEW/",
      "ALLERGIC /MED REACT",
      "ALTERD LEVEL OF CONS",
      "APARTMENT FIRE",
      "ASSAULT MEDICAL",
      "AUTO ALARM BUSINESS",
      "AUTO ALARM HOUSE",
      "AUTOMOBILE FIRE",
      "BACK PAIN",
      "BARN FIRE",
      "BEHAVORIAL EMERGENCY",
      "BLEEDING NON TRAUMA",
      "BREATHING DIFFICULTY",
      "BRUSH FIRE",
      "BUSINESS FIRE",
      "CARDIAC",
      "CHEST PAINS, HEART",
      "CHOKING",
      "CO DETECTOR RES",
      "DEFAULT EMD",
      "DIABETIC",
      "DIFFICULTY BREATHING",
      "DUMPSTER FIRE THE F BAR",
      "EMS SERVICE CALL",
      "FALL 3 FEET OR GREAT",
      "FLOODING CONDITIONS",
      "FLUE FIRE",
      "FULL ARREST",
      "FRACTURE/EXTREMITY",
      "GARAGE FIRE RESIDENT",
      "GRINDER PUMP ACTIVAT",
      "GROUND LEVEL FALL",
      "HEADACHE",
      "HOUSE FIRE",
      "LACERATION",
      "LINES DOWN",
      "LOCAL OTHER FIRE",
      "MEDICAL ALARM",
      "MEDICAL EMERGENCY",
      "MEDIC ASSIST",
      "NATURAL GAS LEAK OUT",
      "NATURAL GAS RESIDENT",
      "OB, CHILDBIRTH",
      "ODOR IN BUSINESS",
      "ODOR IN RESIDENCE",
      "OTHER HAZMAT",
      "OUTSIDE EXPLOSION",
      "OVERDOSE, POISONING",
      "RESCUE CALL",
      "SEIZURE",
      "SERVICE CALL NOT LIS",
      "SHED FIRE",
      "SMOKE INVESTIGATION",
      "STROKE/CVA",
      "SYNCOPAL EPISODE",
      "TEST PAGE ONLY",
      "TRAILER FIRE",
      "TRANSFORMER ARCING",
      "TRAUMA WITH INJURY",
      "TREE DOWN",
      "TRUCK FIRE",
      "UNABLE TO WALK",
      "UNCONSCIOUS, UNRESPO",
      "UNCONSCIOUS/FAINTING",
      "UTILITIES",
      "VEHICLE BRAKES FIRE",
      "WATER RESCUE"
  );
}
