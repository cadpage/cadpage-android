package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDAlleganyCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("CAD|Company +([^ ]+)");
  private static final Pattern MARKER = Pattern.compile("(\\d\\d:\\d\\d) #(\\d+) +");
  private static final Pattern MASTER2 = Pattern.compile("(\\d\\d?:\\d\\d?:\\d\\d?) +(.*) ([A-Z]{2}\\d{10})");
  
  public MDAlleganyCountyParser() {
    super("ALLEGANY COUNTY", "MD",
          "ADDR/SLP! BOX:BOX? DUE:UNIT!");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(MWORD_STREET_LIST);
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

  private static final Pattern CITY_PTN1 = Pattern.compile("(.*); *([A-Z]+)");
  private static final Pattern CITY_PTN2 = Pattern.compile("(.*), *(PIEDMONT)");
  private static final Pattern APT_PTN = Pattern.compile("(.*)\\b(?:APT|(FLR?)) +([^ ]+)");
  private static final Pattern ROUTE_PERIOD_PTN = Pattern.compile("\\b(US|RT|MD)\\.(\\d+)");
  private static final Pattern CODE_PTN = Pattern.compile("(.*?) (\\d\\d?[A-Z]\\d\\d?[A-Z]?) (.*)");
  private static final Pattern MM_PTN = Pattern.compile("\\bMM\\b");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
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
      
      match = CITY_PTN1.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strCity = convertCodes(match.group(2), CITY_CODES);
      }
      
      String apt = "";
      match = APT_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        String tmp = match.group(2);
        apt = match.group(3);
        if (tmp != null) apt = tmp + ' ' + apt;
      }
      
      if (!field.endsWith("*")) {
        int pt = field.indexOf('@');
        if (pt >= 0) {
          st = st == StartType.START_CALL_PLACE ? StartType.START_CALL : StartType.START_ADDR;
          data.strPlace = field.substring(pt+1).trim();
          field = field.substring(0,pt).trim();
          field = stripFieldEnd(field, "[");
        }
      }
      
      // Sometimes the address / place is enclosed in asterisks
      // Sometimes the place name is inside the asterisks leading or following
      // the address.  Sometimes it preceeds the asterisks.  Just have to be
      // flexible
      if (field.endsWith("*")) {
        field = field.substring(0,field.length()-1).trim();
        int pt = field.lastIndexOf('*');
        if (pt >= 0) {
          String callPlace = field.substring(0,pt).trim();
          callPlace = stripFieldEnd(callPlace, "@");
          field = field.substring(pt+1).trim();
          
          if (st == StartType.START_PLACE) {
            data.strPlace = callPlace;
          } else if (st == StartType.START_CALL){
            data.strCall = callPlace;
          } else {
            data.strCall = CALL_LIST.getCode(callPlace, true);
            if (data.strCall != null) {
              data.strPlace = callPlace.substring(data.strCall.length()).trim();
            } else {
              data.strCall = callPlace;
            }
          }
          
          boolean foundCity = false;
          match = CITY_PTN2.matcher(field);
          if (match.matches()) {
            foundCity = true;
            field = match.group(1).trim();
            data.strCity = match.group(2);
          }
          
          pt = -1;
          if (data.strPlace.length() == 0) pt = field.indexOf("  ");
          if (pt >=0) {
            String fld1 = field.substring(0,pt).trim();
            String fld2 = field.substring(pt+2).trim();
            Result res1 = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, fld1);
            Result res2 = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, fld2);
            if (!foundCity && res1.getStatus() > res2.getStatus()) {
              res2 = res1;
              fld1 = fld2;
            }
            data.strPlace = fld1;
            res2.getData(data);
          } else {
            parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
          }
          
          if (data.strAddress.length() == 0) abort();
        }
      }
      
      if (data.strAddress.length() == 0) {
        field = ROUTE_PERIOD_PTN.matcher(field).replaceAll("$1 $2");
        field = field.replace('€', '@');
        match = CITY_PTN2.matcher(field);
        if (match.matches()) {
          field = match.group(1).trim();
          data.strCity = match.group(2);
        }
        parseAddress(st, flags, field, data);
        
        if (st == StartType.START_CALL_PLACE || st == StartType.START_PLACE) {
          if (MM_PTN.matcher(data.strPlace).find()) {
            data.strAddress = append(data.strPlace, " ", data.strAddress);
            data.strPlace = "";
          }
        }
        data.strPlace = append(data.strPlace, " - ", getLeft());
  
        if (data.strAddress.length() == 0) {
          parseAddress(data.strPlace, data);
          data.strPlace = "";
        }
      }
      
      data.strApt = append(data.strApt, "-", apt);
      
      if (data.strCity.equals("PIEDMONT")) data.strState = "WV";
    }
    
    @Override
    public String getFieldNames() {
      return "CALL CODE PLACE ADDR APT CITY ST";
    }
  }
  
  private static final String[] MWORD_STREET_LIST = new String[]{
      "AARON RUN",
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
      "GEORGES CREEK SOUTH MILL",
      "GEORGES CREEK",
      "GRAVEL HILL",
      "HAMPTON INN",
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
      "SAMPSON ROCK",
      "SANDSPRING RUN",
      "SAVAGE RIVER",
      "SCIENCE PARK",
      "SIRES MOUNTAIN",
      "SISLER HILL",
      "SMITH HILL",
      "SMOUSES MILL",
      "SOUTH CRANBERRY SWAMP",
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
  };
  
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
      "ELECTROCUTION",
      "EMS SERVICE CALL",
      "FALL 3 FEET OR GREAT",
      "FALL INJURY",
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
      "MVC ENTRAPMENT",
      "NATURAL GAS BUSINESS",
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
      "TEST PAGE TEST TEST",
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
      "WATER LEAK",
      "WATER RESCUE",
      "XFER MINERAL"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "FRO",  "FROSTBURG"
  });
}
