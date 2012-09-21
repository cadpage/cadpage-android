package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/*
Lawrence County, OH
Contact: Law Co 911 Alert <alert@lawco911.org>
Sender: alert@lawco911.org

alert:[121]- NATURE: F 15B LOCATION: US 52 / CO RD 450 PERRY TW P COMMENTS: +038.420273 -082.572212 CF=100% Example of an intersection call that came from a cell phone.
alert:[121]- NATURE: E 29 LOCATION: 943 MARION PKE COAL GROVE COMMENTS: Example of a call from a address inside a muni cipality.
alert:[121]- NATURE: E 49 LOCATION: 59 PVT DR 7882 CO RD 15 FA YETTE TWP COMMENTS: Example of a call from a private drive . "Fayette Twp" is the name of the township the call is loca ted in
alert:[121]- NATURE: E 10M LOCATION: 6405 STATE RTE 141 LAWRENC E TWP This is an example of a call at an address on a st ate route.
alert:[121]- NATURE: S 72 LOCATION: 2101 N 2 ST IRONTON COMMEN TS: This is an example of a run inside a municipality wi th a street direction. In long form this would be 2101 North 2nd Street Ironton, Ohio
alert:[121]- NATURE: ABD LOCATION: 989 TWP RD 161 FAYETTE TWP COMMENTS: This is an example of a call on a township ro ad.
alert:[121]- NATURE: E 48A LOCATION: 24 TWP RD 1101 W FAYETTE T WP COMMENTS: This is an example of a call on a township wi th a direction. The long form would be 24 Township Road 1101 West

Contact: Active911
Agency name: Fayette Township Fire Department Location: South Point, OH 

alert:[121]- NATURE: E 40 LOCATION: 11024 CO RD 1 UNION TWP CO MMENTS: Test page for Fayete FD
alert:[112]- NATURE: F 33 LOCATION: 264 TWP RD 1030 FAYETTE TW P COMMENTS: +038.404287 -082.540090 CF=100% CALLER REPORT ED A STRUCTURE FIRE AT THIS LOCATION WITH FLAMES VISIBLE
alert:[103]- NATURE: F 15 LOCATION: 389 CO RD 120 S FAYETTE TW P COMMENTS: MVA US 52/MURPHYS GAS UNKNOWN
alert:[103]- NATURE: E 29 LOCATION: 8308 CO RD 1 FAYETTE TWP C OMMENTS: CALLER ADVISES SHE HAD HEART SURGERY A WEEK AGO AND IS HAVING FLUTTERING, CHEST PAIN. WHITE HOUSE, PT WILL BE O N FRONT PORCH. MED 11 ID 168/258T
alert:[107]- NATURE: E 15 LOCATION: 155 CO RD 406 FAYETTE TWP 2 CAR MVC WITH INJURIES
alert:[136]- NATURE: S38 LOCATION: 602 BRUBAKER DR SOUTH POIN T COMMENTS: LCSO REQUESTS FD FOR ASSISTANCE MISSING MAN 72Y /O GREY HOODIE AND BLUE JEANS MISSING SOMETIME BETWEEN 1 AM AND 8 AM THIS MORNING
alert:[121]- NATURE: E 5L LOCATION: 51 PVT DR 1085 TWP RD 135 FAYETTE TWP COMMENTS: MED CARE FROM COLUMBUS REQUESTED LIFT ING WITH PT 600 LBS AQUEDA FINKS CONTACTED SUPRV AND HE S TATED NO LIFTING ASSIT TO CALL PORTSMOUTH AMBULANCE
alert:[103]- NATURE: F 15 LOCATION: 389 CO RD 120 S FAYETTE TW P COMMENTS: MVA WB LANE POSS INJURY MURPHYS GAS /US 52
alert:[107]- NATURE: O 31 LOCATION: 9353 CO RD 1 FAYETTE TWP C OMMENTS: CALLER REPORTS A CAR HIT A POLE NEAR THE AIRPORT . NEGATIVE INJURIES. TRANSFERRED TO THE OSP THIS CAR IS SMOKI NG

Contact: Active911
Agency name: Aid Township Vol. Fire Dept. Location: Willow Wood, OH 

alert:[107]- NATURE: E 59 LOCATION: 40 TWP RD 1001 AID TWP COM MENTS: SHE THINKS VIRGIL MAY HAVE PHENOMONIA. ADVISED MEDIC 51 IDS 306T-116
alert:[120]- NATURE: F 46 LOCATION: 4219 CO RD 16 AID TWP COMM ENTS: CALLER STATES THAT A TREE IS ON FIRE JUST UP FROM HER HOUSE. ALERTED ST 100 ADVISED BUCKEYE POWER CO.

Contact: Active911
Agency name: Coal Grove Fire Dept. Location: Coal Grove, OH 

alert:[136]- NATURE: S38 LOCATION: 602 BRUBAKER DR SOUTH POIN T COMMENTS: LCSO REQUESTS FD FOR ASSISTANCE MISSING MAN 72Y /O GREY HOODIE AND BLUE JEANS MISSING SOMETIME BETWEEN 1 AM AND 8 AM THIS MORNING
alert:[121]- NATURE: E 15 LOCATION: 5400 STATE RTE 141 UPPER T WP COMMENTS: CALLER REPORTS A SINGLE VEHICLE MVC IN THE CREE K, POSSIBLE ENTRAPMENT. THREE PATIENTS. ALERTED ST 400/1500
alert:[121]- NATURE: TEST LOCATION: 8064 CO RD 2 WINDSOR TWP C OMMENTS: ACTIVE911 TEST ALERT FOR COAL GROVE FD
alert:[107]- NATURE: E 52 LOCATION: 613 PIKE ST COAL GROVE

 */


public class OHLawrenceCountyParser extends DispatchEmergitechParser {
  
  public OHLawrenceCountyParser() {
    super("alert:", -26, CITY_LIST, "LAWRENCE COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "alert@lawco911.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    String call = CALL_CODES.getProperty(data.strCall);
    if (call != null) {
      data.strCode = data.strCall;
      data.strCall = call;
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "UNIT CODE " + super.getProgram();
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    Matcher match = PVT_DR_PTN.matcher(sAddress);
    if (match.find()) sAddress = match.group();
    return sAddress;
  }
  private static final Pattern PVT_DR_PTN = Pattern.compile("^.*\\bPVT DR \\d+\\b");
  
  private static final String[] CITY_LIST = new String[]{
    
    "IRONTON",
    
    // Villages
    "ATHALIA",
    "CHESAPEAKE",
    "COAL GROVE",
    "HANGING ROCK",
    "PROCTORVILLE",
    "SOUTH POINT",
    
    // Townships
    "AID TWP",
    "DECATUR TWP",
    "ELIZABETH TWP",
    "FAYETTE TWP",
    "HAMILTON TWP",
    "LAWRENCE TWP",
    "MASON TWP",
    "PERRY TWP",
    "ROME TWP",
    "SYMMES TWP",
    "UNION TWP",
    "UPPER TWP",
    "WASHINGTON TWP",
    "WINDSOR TWP",
    
    // Census- designated place
    "BURLINGTON",
    
    // Other communities
    "ETNA",
    "KITTS HILL",
    "PEDRO",
    "ROCK CAMP",
    "SCOTTOWN",
    "WATERLOO",
    "WILLOW WOOD",
  };
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "F 5",      "Needs assistance",
      "F 6",      "Aero Medical",
      "F 7",      "Take Report",
      "F 8",      "Red Cross",
      "F 9",      "Explosion",
      "F 10",     "Unknown Problem",
      "F 11",     "Smoke Investigation",
      "F 12",     "Carbon Monoxide",
      "F 13",     "Special Detail",
      "F 14",     "Water Rescue",
      "F 15",     "Vehicle Crash",
      "F 15B",    "Motorcycle/ATV Crash",
      "F 15C",    "Train Crash",
      "F 15D",    "Bus Crash",
      "F 15E",    "Aircraft Crash",
      "F 15F",    "Off Road Crash",
      "F 15G",    "Farm Accident",
      "F 16",     "Dead on Arrival",
      "F 16A",    "DOA Suspicious",
      "F 24",     "Haz-Mat/Chemical Leak",
      "F 25",     "Unknown Alarm",
      "F 33",     "Structure Fire",
      "F 33A",    "Fire Alarm",
      "F 33B",    "Brush Fire",
      "F 33C",    "Vehicle Fire",
      "F 33D",    "Chimney Fire",
      "F 38",     "Missing Person",
      "F 40",     "Jaws of Life/Extrication",
      "F 41",     "Arson",
      "F 45",     "Severe Weather",
      "F 46",     "Utility lines Down",
      "F 47",     "Drowning",
      "F 48",     "Bomb Threat",
      "F 50",     "Gas Leak",
      "F 53",     "Evacuation",
      "F 56",     "Victim Trapped",
      "F 100",    "Full Scale Disaster"
  });
}
