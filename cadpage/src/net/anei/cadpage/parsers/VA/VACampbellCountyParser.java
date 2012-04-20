package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
DAPRO Systems http://www.daprosystems.com/ (This version is different enough that I did not use the builtin dapro
Campbell County, VA 
Contact: efhammermeister@yahoo.com,EFHAMMERMEISTER@vtext.com
MAILBOX:SQ02 MVC/MOTOR VEHICLE CRASH/ACCIDE 002364 WATERLICK RD/LEESVILLE RD CFS# 2010-061119 REF TO A 3 CAR MVA. AT FIRST A REPORT OF NO PI. NO NEED FOR FIRE. VASI ADV THAT T
MAILBOX:SQ02 (3)ACCIDENT 021400 TIMBERLAKE RD CFS# 2010-061105 2 CAR MVA. WITH ENTRAPMENT
MAILBOX:SQ02 STABBING 005450 COLONIAL HWY EVI CFS# 2010-061047 STAGE IN THE AREA, DO NOT GO TO THE SCENE
MAILBOX:SQ02 UNRESPONSIVE 000218 LAKE FOREST DR CFS# 2010-060825
MAILBOX:SQ02 HANGUP 911 000381 HORIZON DR CFS# 2010-060777 FEMALE ADVISED SOMETHING ABOUT THE RESCUE SQ. LINE DISCONNECTED
MAILBOX:CO12 BRUSH/FIELD FIRE 000175 WOODHAVEN DR CFS# 2011-024304

Contact: Nathan McCraw <mccraw44@yahoo.com>
Sender: MAILBOX@ccgvn.net
S: M:MAILBOX:CO13 POWER IN GENERATOR @FIRE STATION IS OUT. DOORS HAVE TO BE OPENED MANUALLY PER CHIEF 13\n

Contact: Mark Moss <mmoss@altavistaems.com>
Sender: MAILBOX@ccgvn.net
MAILBOX:SQ01 HEADACHE 002243 BEDFORD HWY LYN CFS# 2012-018620\r
MAILBOX:SQ01 PAIN 000149 BEALE RD LYN CFS# 2012-018617 76 YO F PAIN IN NECK AND SHOULDER HX HIGH BLOOD PRESSURE BLOCKAGE IN LEFT SIDE PRI 2\r
MAILBOX:SQ01 MENTAL SUBJECT 001011 7TH ST ALT CFS# 2012-018608 ASSIST APD W/ A MENTAL SUBJECT PRIORITY 3\r
MAILBOX:SQ01 MUTUAL AID (OUTSIDE OF COUNTY 000901 N MAIN ST- GRETNA CFS# 2012-018626 MEADOWBROOK TRAILER PARK --LOT 4 33 Y/O F CHEST PAIN pri\r
MAILBOX:SQ01 CHEST PAIN (NO CARDIAC HISTORY 001280 MAIN ST A ALT CFS# 2012-018645\r

*/

public class VACampbellCountyParser extends SmartAddressParser {
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "ALT", "ALTA VISTA",
      
      "EVI", "EVINGTON",
      "LYN", "LYNCH STATION",
  });
  
  
  private static final String[] KEYWORDS = new String[]{"LOC", "CFS"};
  
  private static final Pattern MARKER = Pattern.compile("^MAILBOX:([A-Z]{2}\\d{2}) ");
  private static final Pattern ZERO_FILL_NUMBER = Pattern.compile("\\b0+(\\d+)\\b");
  private static final Pattern OUTSIDE_COUNTY = Pattern.compile("(?<=OUTSIDE OF COUNTY) +(?=\\d)");
  
  public VACampbellCountyParser() {
    super(CITY_CODES, "CAMPBELL COUNTY","VA");
    setup();
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@ccgvn.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    data.defState="VA";
    data.defCity = "CAMPBELL COUNTY";
    
    // Locate the marker to determine where our part of the message starts
    Matcher match = MARKER.matcher(body);
    if (! match.find()) return false;
    data.strSource = match.group(1);
    body = body.substring(match.end()).trim();
    
    // Adjust it a bit and parse out the main fields
    body = "LOC:" + body.replaceAll(" CFS#", " CFS:");
    Properties props = parseMessage(body, KEYWORDS);
    
    // Lets do the easy ones first
    // Need to handle Supp being after the CFS
    Parser p = new Parser( props.getProperty("CFS", ""));
    data.strCallId = p.get(' ');
    data.strSupp = p.get();
    
    data.strCross = props.getProperty("CROSS", "");
    
    
    // OK, now to work out the address field
    String sAddress = props.getProperty("LOC", "");
    String sCity = null;
    int pt = sAddress.lastIndexOf('-');
    if (pt >= 0) {
      sCity = sAddress.substring(pt+1).trim();
      sAddress = sAddress.substring(0,pt).trim();
    }
    sAddress = ZERO_FILL_NUMBER.matcher(sAddress).replaceAll("$1");
    
    StartType st = StartType.START_CALL;
    match = OUTSIDE_COUNTY.matcher(sAddress);
    if (match.find()) {
      data.strCall = sAddress.substring(0,match.start());
      sAddress = sAddress.substring(match.end());
      st = StartType.START_ADDR;
    }
    parseAddress(st, FLAG_ANCHOR_END, sAddress, data);
    if (sCity != null) data.strCity = sCity;
    
    return true;
  }

  private void setup() {
    setupCallList(
        "EMS-OTHER",
        "EMS-OTHER/DEFINE",
        "EMS-ABDOMINAL PAIN",
        "EMS-ALLERGIC REACTION",
        "EMS-ALS ASSIST",
        "EMS-ALTERED LOC",
        "EMS-AMPUTATION",
        "EMS-ASSAULT; INJURIES FROM",
        "EMS-AVULSION",
        "EMS-BACK PAIN",
        "EMS-ANIMAL BITE",
        "EMS-BURNS",
        "EMS-CARDIAC",
        "EMS-CARDIAC CONDITION",
        "EMS-CHEST PAIN",
        "EMS-CHOKING",
        "EMS-CO INHALATION",
        "EMS-CODE BLUE",
        "EMS-DIABETIC EMERGENCY",
        "EMS-DIFFICULTY BREATHING",
        "EMS-PERSON DOWN",
        "EMS-ELECTROCUTION",
        "EMS-EYE PROBLEM",
        "EMS-FALLS",
        "EMS-GUNSHOT",
        "EMS-HEADACHE",
        "EMS-HEAT/COLD EXPOSURE",
        "EMS-HEMORRHAGING",
        "EMS-HIGH BLOOD PRESSURE",
        "EMS-ILLNESS",
        "EMS-LACERATION",
        "EMS-MENTAL PROBLEM",
        "EMS-OB RELATED EVENT",
        "EMS-OVERDOSE/POISONING",
        "EMS-PATIENT FALLEN",
        "EMS-SEIZURES",
        "EMS-STAB WOUND",
        "EMS-STROKE",
        "EMS-TRAUMA INJURIES",
        "EMS-UNCONSCIOUS",
        "EMS-UNKNOWN MADICAL",
        "911 OPEN LINE",
        "HANGUP 911",
        "AUTOMATIC FIRE ALARM",
        "AIRCRAFT INCIDENT",
        "MEDICAL ALARM",
        "ALARM SOUNDING",
        "ATTEMPTED SUICIDE",
        "BOMB THREAT",
        "BRUSH FIRE",
        "BRUSH FIRE THREATENING A STRUC",
        "CHIMNEY FIRE",
        "CO DETECTOR ACTIVATION",
        "POSSIBLE CO EVENT",
        "STRUCTURE COLLAPSE",
        "CONSTRUCTION ACCIDENT",
        "CONTROLLED BURN",
        "TRAFFIC CRASH",
        "TRAFFIC CRASH INVOLVING A BUS",
        "TRAFFIC CRASH W/PEDESTRIAN",
        "TRAFFIC CRASH INVOLVING A STRU",
        "DUMPSTER FIRE",
        "ELEVATOR ENTRAPMENT",
        "EXPLOSION",
        "FARM ACCIDENT",
        "FILL QUARTERS",
        "FORREST FIRE",
        "GRASS FIRE",
        "GRASS FIRE THREATENING A STRUC",
        "HAZMAT INCIDENT",
        "HAZMAT LEVEL 3 INCIDENT",
        "HOSTAGE/BARRICADE",
        "INDUSTRIAL ACCIDENT",
        "LANDING ZONE",
        "LINES DOWN",
        "LOCK OUT SERVICE",
        "MENTAL CASE",
        "MULCH FIRE",
        "MULCH FIRE THREATENING A STRUC",
        "ODOR INVESTIGATION",
        "ODOR INVESTIGATION IN STRUCTUR",
        "OFFICER INVOLVED SHOOTING",
        "SUSPICIOUS PACKAGE",
        "PUBLIC SERVICE CALL",
        "RAPE",
        "REKINDLE",
        "GROUND RESCUE",
        "GROUND SEARCH",
        "SMOKE INVESTIGATION",
        "LARGE SPILL",
        "SMALL SPILL",
        "STAND-BY",
        "POSSIBLE STRUCTURE FIRE",
        "STRUCTURE FIRE",
        "SUICIDE",
        "TECHNICAL RESCUE",
        "TRAIN CRASH",
        "TRAIN FIRE",
        "TRANSFORMER FIRE",
        "TRASH FIRE",
        "TREE FIRE",
        "TREE FIRE THREATENING A STRUCTUR",
        "UNAUTHORIZED BURN",
        "UNKNOWN SITUATION",
        "UNKNOWN FIRE",
        "VEHICLE FIRE",
        "VEHICLE FIRE THREATENING A STRUCTURE",
        "WATER EVENT",
        "WATER REMOVAL"
        );
  }
}
