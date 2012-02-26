package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
York County, PA
Contact: William Blackwell <ff2blackwell@gmail.com>
Contact: "Matthew Houck" <gr8tff@comcast.net> (megabytes of text samples)
Contact: "firefighter_24@netzero.net" <firefighter_24@netzero.net>
Sender: FIRE@mantwp.com

NORTH CODORUS TWP \n\n1983 SLAGEL RD STOVERSTOWN RD / VIEW DR FIRE STRUCT RESID Working Fire 12-01 S99-1 RIT1 17:05 
YORK TWP COUNTRY MEADOWS \n\n2760 PINE GROVE RD 2760 PINE GROVE RD LEADER HEIGHTS RD, PINE GROVE CIR / PINE GROVE CMN FIRE AFA HIGH RISK general alm from the Leader Heights Building 19-04 FIRESTA19 E19 E18-1 E89-2 E35-2 TK19 TK34 EMSSTA18 A18 12:22 
PENN TWP \n\n1060 WILSON AVE OLD RIDGE RD / YORK ST, GRANDVIEW RD FIRE VEHICLE HR mulching machine on fire 49-17 FIRESTA49 E49-2 E46-3 E49-1 
YORK CITY \n\n900 E KING ST S TREMONT ST / S CAMBRIDGE ST HAZMAT NO INJ hit gas service outside residence 99-06 FIRESTA99 E99-5 E99-1 TK99-1 DO99 15:23
MANCH TWP METRO BANK MANCH TWP \n\n55 ARSENAL RD I 83X21BARSENALRD NB / I 83 NB VEH ACC INJ CL 2 30/F/leaking fluids 24-07 FIRESTA24 E24-1 R24  13:20
HELLAM TWP \n\n4045 CODORUS FURNACE RD RIVER FARM RD / JENNIFER LN LANDING ZONE Jennifer and Furnace for LZ 21-13 R24  11:08
Fire Incident / YORK TWP I83 SB EXIT 16A\n\nI 83 SB I 83X16ASQUEENST SB FIRE VEHICLE HR cancel call 19-832 UFIRE24 UFIRE25 UEMS24  00:27¿\n\n\n
MANCH TWP CODORUS STONE COMPANY\n\n135 MUNDIS RACE RD EMIG RD, MUNDIS LN / DELLINGER RD FIRE AFA HIGH RISK / 2nd floor smoke /  24-03 FIRESTA24 E24-1 E89-3 TK24 EMSSTA24 A23-2  11:58
MANCH TWP GRAHAM PKG 3280 FARMTRAIL RD\n\n3280 FARMTRAIL RD CHURCH RD / FARMBROOK LN FIRE AFA HIGH RISK general fire alarm 24-10 FIRESTA24 E24-1 E23-1 TK24 EMSSTA24 A24-2  04:41
Fire Incident / MANCH TWP \n\nCHURCH RD BOARD RD DEBRIS REMOVAL veh acc no inj leaking 24-02 FIRESTA24 E24-1  18:17¿\n\n\n
Fire Incident / W MANCHESTER TWP    CARLISLE RD RTE 30 WB VEH ACC INJ CL 2 r24 avail 02-05 UFIRE24  20:27¿\n\n\n

Subject:Fire Incident\nMANCH TWP    975 DETWILER DR BELAIR WAY / STILLMEADOW LN FIRE STRUCT RESID shed on fire 24-14 FIRESTA24 E24-1 E2-1 TK24 R
Subject:Fire Incident\nMANCH TWP CARS PLUS  2008 N  GEORGE ST WOODLAND AVE / I 83 SB, LIGHTNER RD, I 83X22NGEORGEST SB FIRE WIRES 24-07 FIRESTA
Subject:Fire Incident\nMANCH TWP I83 NB EXIT EMIGSVILLE   I 83 NB I 83X24EMIGSVILLE NB DEBRIS REMOVAL non injury accident south of exit    24-83
Subject:Fire Incident\nMANCH TWP    130 HARVEST DR WOODMONT DR / LEAF ST STROKE/CVA CL 1 42 m/cons/yh 24-16 EMSSTA24 FIRESTA24 E24-1 A261 EMSSTA102-2 M102-2  21:05

Contact:Charles Schriver <chuckles494@gmail.com>
Sender: york911alert@comcast.net 
0049000  HANOVER BORO GOLDEN EXCHANGE CONDO ASSOCIATION   9 2ND AVE EXCHANGE PL / W WALNUT ST FIRE AFA HIGH RISK General Alarm  46-02 FIRESTA46 E46-1 E49-1

Contact: "Freistat, Brandon" <brandon.freistat@fairviewfire.net>
FAIRVIEW TWP I83 SB EXIT FISHING CREEK   I 83 SB I 83X36FISHINGCREEK SB VEH ACC INJ CL 2 unk age pt/bleeding from face/unk dest 68-83 FIRESTA68 E68-2 R68  11:36
NEWBERRY TWP    46 MALL RD PRIVET DR / BILL DUGAN DR FIRE STRUCT RESID stove fire reported out still smoking  31-07 FIRESTA31 T31-1 E68-2 T28 T68 TK69 EMSSTA31 MICU31  12:51
(Station 68) FAIRVIEW TWP    426 VALLEY RD SAND SPUR DR / TRAILER PARK FIRE STRUCT RESID Holding box to E69, E68-2,BLS 68-02 UFIRE68 UFIRE28  03:36
(Station 68) FAIRVIEW TWP    56 MEADOWBROOK CT DEAD END / SHAUFFNERTOWN RD, DILLER RD FIRE STRUCT RESID Mobile home fire   68-05 FIRESTA68 E68-2 E69-1 T
(Station 68) FAIRVIEW TWP I83 SB EXIT 39B   I 83 SB I 83X39BPATURNPIKE SB VEH ACC OT NO INJ  Veh OT 68-83 FIRESTA68 E68-2 R68  05:56
(Station 68) FAIRVIEW TWP    768 LEWISBERRY RD IRONSTONE RD, FISHING CREEK RD / CEDARS RD FIRE VEHICLE  WORKING FIRE 68-04 UFIRE68 UEMS68  18:47
(Station 68) NEWBERRY TWP    OLD TRAIL RD PINES RD VEH ACC INJ CL 2 updated locat ion 31-01 UFIRE31 UEMS31 UFIRE68  03:57
(Station 68) FAIRVIEW TWP    02 FOXFIRE LN OLD FORGE RD / WHEATLAND RD FIRE STRUCT RESID fire on back porch 68-04 FIRESTA68 E68-2 CCE24 E69-1 T68 CCT24

*/

public class PAYorkCountyAParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(.*) (\\d{2}-\\d{2,3})(?: (.*?)(?: \\d\\d:\\d\\d.?)?)?", Pattern.DOTALL);
  private static final Pattern DELIM = Pattern.compile("\n\n|    *");
  private static final Pattern ID_PTN = Pattern.compile("^(\\d{7}) ");
  private static final Pattern CITY_PTN = Pattern.compile("^.*? (?:CITY|BORO|TWP)\\b");
  private static final Pattern SRC_PTN = Pattern.compile("^(FIRESTA\\d+) ");
  
  public PAYorkCountyAParser() {
    super("YORK COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "FIRE@mantwp.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Rule out variant C  Otherwise the code might be enought to pass
    if (body.contains("District:")) return false;
    
    if (subject.length() > 0) {
      if (subject.startsWith("Station ")) data.strSource = subject;
    }
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    String sAddr = match.group(1).trim();
    data.strMap = match.group(2).trim();
    String part3 = getOptGroup(match.group(3));
    
    // Hopefully we can find a clear delimiter separating the first message piece 
    // into two parts.  If not, use the smart address parser to break up the 
    // address field
    StartType st = StartType.START_PLACE;
    String part1 = null;
    match = DELIM.matcher(sAddr);
    if (match.find()) {
      // work on the message header
      // May contain a call description followed by slash
      part1 = sAddr.substring(0,match.start()).trim();
      sAddr = sAddr.substring(match.end()).trim();
      st = StartType.START_ADDR;
    } 
    
    sAddr = sAddr.replace(',', ' ');
    parseAddress(st, FLAG_IMPLIED_INTERSECT, sAddr, data);
    if (part1 == null) {
      part1 = data.strPlace;
      data.strPlace = "";
    }
    
    // Now to work on the leader section
    // Strip off averying preceeding a /
    int pt = part1.indexOf(" / ");
    if (pt >= 0) part1 = part1.substring(pt+3).trim();
    
    // See if there is a leading call number
    match = ID_PTN.matcher(part1);
    if (match.find()) {
      data.strCallId = match.group(1);
      part1 = part1.substring(match.end()).trim();
    }
    
    // Rest should be a city name followed by an optional place name
    // City names always end in BORO, CITY or TWP (we hope)
    match = CITY_PTN.matcher(part1);
    if (match.find()) {
      data.strCity = match.group();
      data.strPlace = part1.substring(match.end()).trim();
    } else {
      data.strCity = part1;
    }
    if (data.strCity.equals("MANCH TWP")) data.strCity = "MANCHESTER TWP";

      // The address may be a simple address followed by a cross street
    sAddr = getLeft();
    if (sAddr.startsWith("/")) sAddr = sAddr.substring(1).trim();
    parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, sAddr, data);

    // Anything left should be the call description
    // If we don't find anything, the field we parsed as the cross street must be 
    // the call description
    data.strCall = getLeft();
    if (data.strCall.length() == 0) {
      data.strCall = data.strCross;
      data.strCross = "";
    }
    
    // last part may contain a station in first position.  Everything else is unit
    match = SRC_PTN.matcher(part3);
    if (match.find()) {
      data.strSource = match.group(1);
      part3 = part3.substring(match.end()).trim();
    }
    data.strUnit = part3;
    
    return true;
  }
}
