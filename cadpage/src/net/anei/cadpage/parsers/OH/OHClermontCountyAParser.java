package net.anei.cadpage.parsers.OH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

/**
 * Clermont county, OH
 */
public class OHClermontCountyAParser extends DispatchB2Parser {
  
  private static final Pattern RETURN_PHONE_PTN = Pattern.compile("(Return Phone: \\d{10}) +(.*)");

  public OHClermontCountyAParser() {
    super(CITY_LIST, "CLERMONT COUNTY", "OH", B2_CROSS_FOLLOWS);
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "AMELIA OLIVE BRANCH",
        "APPLE FARM",
        "BARDWELL WEST",
        "BARRICK LOW",
        "BATAVIA MEADOWS",
        "BEAR CREEK",
        "BELFAST OWENSVILLE",
        "BETHEL CONCORD",
        "BETHEL HYGIENE",
        "BETHEL NEW RICHMOND",
        "BETHEL PARK",
        "BIG INDIAN",
        "BLUE SKY PARK",
        "BOOTJACK CORNER",
        "BRANCH HILL GUINEA",
        "BRIGHT WATER",
        "BROOKS MALOTT",
        "BRUSHY FORK",
        "CEDAR LAKE",
        "CEDAR RIDGE",
        "CLERMONT CENTER",
        "CLERMONT COLLEGE",
        "CLERMONT MEADOW",
        "CLERMONTVILLE LAUREL",
        "COLONEL MOSBY",
        "COUNTRY LAKE",
        "DELA PALMA",
        "DRY RUN",
        "EAGLE RIDGE",
        "EAST BAUMAN",
        "EAST FILAGER",
        "EAST FORK",
        "EAST FORK HILLS",
        "EDENTON PLEASANT PLAIN",
        "FAIR OAK",
        "FELICITY CEDRON RURAL",
        "FRANKLIN LAUREL",
        "FRANKLIN MEADOWS",
        "FREE SOIL",
        "GARRISON SPURLING",
        "GLANCY CORNER MARATHON",
        "GLEN ECHO",
        "GOLDEN AGE",
        "GOODWIN SCHOOLHOUSE PT ISA",
        "HALF ACRE",
        "HAPPY HOLLOW",
        "HAW TREE",
        "HEALTH PARTNERS",
        "HENNINGS MILL",
        "HERITAGE WOODS",
        "HILL STATION",
        "HOPPER HILL",
        "I275 NB EXIT WARDS CORNER",
        "I275 SB EXIT WARDS CORNER",
        "IRETON TREES",
        "JACOB LIGHT",
        "JAMES E SAULS SR",
        "JENNY LIND",
        "JERRY LEE",
        "JESS THELMA",
        "JETT HILL",
        "JO ELLEN",
        "JONES FLORER",
        "KENNEDY FORD",
        "LAKE PINE",
        "LANTERN POST",
        "LAUREL LINDALE",
        "LAUREL POINT ISABEL",
        "LAUREL PT ISABEL",
        "LAYCOCK CUTOFF",
        "LEGENDARY TRAILS",
        "LIBERTY WOODS",
        "LINDALE MT HOLLY",
        "LINK SIDE",
        "LITTLE RIVER",
        "LOCUST CORNER",
        "LONG LEAF",
        "LOST LAKE",
        "LUCY RUN",
        "MAPLE CREEK",
        "MARATHON EDENTON",
        "MEADOW VIEW",
        "MERWIN TEN MILE",
        "MISS ROYAL PASS",
        "MOORE MARATHON",
        "MOSCOW CEMETERY",
        "MT HOLLY",
        "MT OLIVE PT ISABEL",
        "MT PISGAH",
        "MT VERNON",
        "NEVER REST",
        "NEVILLE PENN SCHOOLHOUSE",
        "NINE MILE TOBASCO",
        "NORFOLK PINE",
        "NUMBER 9",
        "OAK BARK",
        "OAK DALE",
        "OAK LAND",
        "OAKLAND FARM",
        "OTTER CREEK",
        "PAR FORE",
        "PEBBLE BROOKE",
        "PIN OAK",
        "POND RUN",
        "RIVER VALLEY",
        "ROBIN HILL",
        "ROLLING HILLS",
        "ROLLING KNOLL",
        "ROTH RIDGE",
        "SALTAIR CROSSING",
        "SHADOW LAWN",
        "SOUTH TIMBER CREEK",
        "ST ANDREWS",
        "ST LOUIS",
        "STANTON HALL",
        "STONELICK WOODS",
        "STUMPY LANE",
        "SULPHUR SPRINGS",
        "SULPHYR SPRINGS",
        "SWINGS CORNER PT ISABEL",
        "TALL OAKS",
        "TALL TREES",
        "TAYLOR LANE",
        "TODDS RUN FOSTER",
        "TRAVERSE CREEK",
        "TRIPLE 2 FARMS",
        "TWIN BRIDGES",
        "VALLEY FORGE",
        "WARDS CORNER",
        "WATKINS HILL",
        "WEST FORK RIDGE",
        "WHITE OAK",
        "WILD ROSE",
        "WILL O EE",
        "WILSON DUNHAM HILL",
        "WOLFPEN PLEASANT HILL",
        "WOODED RUN"
    );
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@clermontcountyohio.gov,777,888";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace("CAD#","Cad:");

    body = stripFieldStart(body,"/ ");
    body = stripFieldStart(body,"911-CENTER:");
    
    // Check for return phone message pattern
    Matcher match = RETURN_PHONE_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("CALL ADDR APT CITY INFO");
      data.strCall = match.group(1);
      data.strSupp = match.group(2);
      Result res = parseAddress(StartType.START_OTHER, FLAG_IGNORE_AT, data.strSupp);
      if (res.isValid()) res.getData(data);
      return true;
    }
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.length() == 0) {
      if (data.strName.equals("WARCO COMM")) data.strCity = "WARREN COUNTY";
    }
    if (KY_CITY_SET.contains(data.strCity)) data.strState = "KY";
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }

  @Override
  protected boolean isPageMsg(String body) {
    return body.contains(" Cad:") || body.contains("CAD#") && !body.startsWith("EVENT: ");
  }
  
  @Override
  protected boolean parseAddrField(String field, Data data) {
    // Mistyped AT mistaken for ATT carrier name :(
    field = field.replace(" ATT ", " AT ");
    return super.parseAddrField(field, data);
  }
  
  @Override
  public String adjustMapCity(String city) {
    return convertCodes(city, CITY_MAP_TABLE);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ALLERGIES/ENVENOMATIONS",
      "APPLIANCE FIRE",
      "ASSAULT/SEXUAL ASSAULT",
      "BREATHING PROBLEMS",
      "CARDIAC OR RESP ARREST/DEATH",
      "CHECK ON THE WELFARE",
      "CHEST PAIN (NON TRAUMATIC)",
      "CHIMNEY FIRE",
      "CO ALARM",
      "CONVULSIONS/SEIZURES",
      "DIABETIC PROBLEMS",
      "DUMPSTER FIRE",
      "DUMPSTER FIRE W/EXPOSURE",
      "ELECTRICAL FIRE",
      "ELECTRICAL FIRE INSIDE",
      "EMERGENCY TO PROPERTY",
      "FALLS",
      "FIELD FIRE",
      "FIRE ALARM",
      "FIRE ALARM TEST/WORK",
      "FIRE INFORMATION",
      "FIRE OR EMS TRANSFER",
      "FIRE TEST TONE",
      "GAS LEAK INSIDE",
      "GAS LEAK OUTSIDE",
      "HEMORRHAGE/LACERATIONS",
      "MDC TEST",
      "MED GENERIC DO NOT DELETE",
      "MISCELLANEOUS FIRE REQUEST",
      "MUTUAL AID",
      "OVERDOSE/POISONING (INGESTION)",
      "POSSIBLE OPEN BURN",
      "PSYCH/ABNRML BEHVR/SUICIDE",
      "Return Phone: 5137322231",
      "SICK PERSON (SPECIFIC DIAG)",
      "SMOKE IN THE AREA",
      "STRUCTURE FIRE",
      "STRUCTURE FIRE W/ENTRAPMENT",
      "TRAFF OR TRANSPT ACC/MVA W/INJ",
      "TRANSF/INERFC/PALLIATIVE CARE",
      "TRAUMATIC INJURIES, SPECIFIC",
      "UNCONSCIOUS/FAINTING (NEAR)",
      "UNKNOWN PROBLEM (MAN DOWN)",
      "VEHICLE FIRE",
      "WIRES DOWN"
  );

  private static final String[] CITY_LIST = new String[]{
    "BATAVIA TOWNSHIP",
    "BATAVIA TWP",
    "FRANKLIN TOWNSHIP",
    "FRANKLIN TWP",
    "GOSHEN TOWNSHIP", 
    "GOSHEN TWP", 
    "JACKSON TOWNSHIP",
    "JACKSON TWP",
    "MIAMI TOWNSHIP",
    "MIAMI TWP",
    "MONROE TOWNSHIP",
    "MONROE TWP",
    "OHIO TOWNSHIP", 
    "OHIO TWP", 
    "PIERCE TOWNSHIP",
    "PIERCE TWP",
    "STONELICK TOWNSHIP",
    "STONELICK TWP",
    "TATE TOWNSHIP",
    "TATE TWP",
    "UNION TOWNSHIP",
    "UNION TWP",
    "WASHINGTON TOWNSHIP",
    "WASHINGTON TWP",
    "WAYNE TOWNSHIP",
    "WAYNE TWP",
    "WILLIAMSBURG TOWNSHIP",
    "WILLIAMSBURG TWP",
    
    "AFTON",
    "AMELIA",
    "BANTAM",
    "BATAVIA",
    "BELFAST",
    "BETHEL",
    "BLOWVILLE",
    "BRANCH HILL",
    "CHILO",
    "CLERMONTVILLE",
    "CLOVER",
    "DAY HEIGHTS",
    "EAST BATAVIA HEIGHTS",
    "EDENTON",
    "EPWORTH HEIGHTS",
    "FELICITY",
    "GLEN ESTE",
    "GOSHEN",
    "HAMLET",
    "HENNINGS MILLS",  // not mapping
    "HULINGTON",
    "LAUREL",
    "LERADO",
    "LINDALE",
    "LOCUST CORNER",
    "LOCUST LAKE",
    "LOVELAND",
    "MAPLE",           // not mapping
    "MARATHON",
    "MIAMIVILLE",
    "MILFORD",
    "MODEST",
    "MONTEREY",
    "MONTEREY",
    "MOORES FORK",
    "MOSCOW",
    "MOUNT CARMEL",
    "MT CARMEL",
    "MOUNT HOLLY",
    "MT HOLLY",
    "MOUNT OLIVE",
    "MT OLIVE",
    "MOUNT PISGAH",
    "MT PISGAH",
    "MOUNT REPOSE",
    "MT REPOSE",
    "MULBERRY",
    "NEVILLE",
    "NEW PALESTINE",
    "NEW RICHMOND",
    "NEWTONSVILLE",
    "NICHOLSVILLE",
    "OLIVE BRANCH",
    "OWENSVILLE",
    "PALESTINE",
    "PERINTON",          // not mapping
    "PERINTOWN",
    "POINT ISABEL",
    "POINT PLEASANT", 
    "PRINGLE CORNER",    // not mapping
    "RURAL",
    "SALTAIR",
    "SHILOH",            // not mapping
    "SUMMERSIDE",
    "TOBASCO",
    "UTOPIA",
    "WIGGONSVILLE",
    "WILLIAMS CORNER",
    "WILLIAMSBURG",
    "WILLOWVILLE",
    "WITHAMSVILLE",
    "WOODVILLE",
    
    // Brown County
    "FAYETTEVILLE",
 
    "BRACKEN COUNTY",
    "BROWN COUNTY",
    "BRACKEN COUNTY",
    "CLINTON COUNTY",
    "HAMILTON COUNTY",
    "PENDLETON COUNTY",
    "WARREN COUNTY"
  };
  
  private static Set<String> KY_CITY_SET = new HashSet<String>(Arrays.asList(
      "BRACKEN COUNTY",
      "CAMPBELL COUNTY"
  ));
  
  private static final Properties CITY_MAP_TABLE = buildCodeTable(new String[]{
      "EAST BATAVIA HEIGHTS",     "BATAVIA",
      "LOCUST LAKE",              "AMELIA"
  });
}