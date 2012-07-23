package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Monroe County, PA
Contact: "Daniel Wade" <danielw@wadeville.com>
Sender: emergin@monroeco911.com

CAD MSG: *D F1 WASHINGTON PL / PRESIDENTIAL DR 203 POCONO FARMS / CALLER REPORTING\n\nWORKING FIRE / NO ONE IN THE RESIDENCE
CAD MSG: *D F1 255 SUMMIT AVE 209 HOUSE FIRE / APPEARS TO BE VACANT / UNK IF ANYONE LIVES THERE OR NOT /
CAD MSG: *D F2 GEISINGER FAMILY PRA / COMMERCE CT 203 GESINGER MT POCONO // BLACK GRAND AM ON FIRE// UNK IF ANYONE IS IN IT/
CAD MSG: *D F1 HATCHERY DR / PARADISE VALLEY RD 208 RTE 940/TROUT HATCHERY// FULLY INVOLVED// NO VEHICLES INT HE D/W DOESN
CAD MSG: *D F2 JACK WILLIAMS TIRE / RTE 940 403 JACK WILLIAMS TIRE 839-8300 OFFICE/BATHROOM SMOKE DET WILL ATEM
CAD MSG: *D E45J S I380 HWY / MM 1 POC SUM HWY 215 ONE VEH OFF THE FEMALE WITH NUMBNESS AND HUSBAND UNABLE TO GET OF THE
CAD MSG: *D F2 FS 33 POCONO SUMMIT 215 SPECIAL ASSIGNMENT AT STATION AT THIS TIME
CAD MSG: *D F2      7021 VISTA DR 203 PCP LOT G61 FIRE ALARM KEEPS GOING OFF / DOES\NOT BELIVE ITS THE BATT
CAD MSG: *D F2      WHITE TAIL DR / FAIRWAY DR 203 FAIRWAY DR//SOMETHING IN THE MIDDLE OF THE STREET IS ON FIRE/UNK WHAT
CAD MSG: *D E45J      RTE 196 / RYANS RD 203 2 CAR MVA WITH INJURY AND ENTRAPMENT//CALLER NOT INVOLVED//CALLER STAT
CAD MSG: *D F1      WINDING WAY / SHADY SIDE DR 203 HOUSE FIRE FLAMES SHOWING  CAR IN DW UNK IF ANYONE HOME    NEAR SHAYS
CAD MSG: *D F2       POCONO MOUNTAIN WEST 215 PANTHER LN          OFFICE EXT 81400  // GENRAL FIRE ALARM\r\n\r

*/

public class NYMonroeCountyBParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("CAD MSG: \\*[DG] ([A-Z0-9]+) +");
  
  public NYMonroeCountyBParser() {
    super(CITY_CODES, "MONROE COUNTY", "PA");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    // Strip off any prefix
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCall = match.group(1);
    body = body.substring(match.start());
    
    parseAddress(StartType.START_ADDR, body, data);
    
    String call = convertCodes(data.strCall, CALL_CODES);
    if (call != null) {
      data.strCode = data.strCall;
      data.strCall = call;
    }
    
    String extra = getLeft();
    data.strSupp = extra.replace('\n', ' ').replaceAll("  +", " ");
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "101",   "Lehman",
      "201",   "Barrett",
      "202",   "Chestnuthill",
      "203",   "Coolbaugh",
      "204",   "Eldred",
      "205",   "Hamilton",
      "206",   "Jackson",
      "207",   "Middle Smithfield",
      "208",   "Paradise",
      "209",   "Pocono",
      "210",   "Polk",
      "211",   "Price",
      "212",   "Ross",
      "213",   "Smithfield",
      "214",   "Stroud",
      "215",   "Tobyhanna",
      "216",   "Tunkhannock",
      "401",   "Delaware Water Gap",
      "402",   "East Stroudsburg",
      "403",   "Mount Pocono",
      "404",   "Stroudsburg"
  });
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "F1",   "Fire & EMS Dispatch",
      "F2",   "Fire Dispatch",
      "F3",   "Fire Officers Dispatch",
      "E1",   "Acute Abdomen",
      "E2",   "Amputation",
      "E3",   "Anaphylazia",
      "E4",   "Burns",
      "E45J", "Motor Vehicle Accident with Entrapment",
      "E5",   "Cardiac",
      "E6",   "Cardiac ARREST",
      "E7",   "Spinal Injury",
      "E8",   "CVA/Stroke",
      "E9",   "Diabetic",
      "E10",  "DOA",
      "E11",  "Fever",
      "E12",  "Dislocation/Fracture",
      "E13",  "GI Bleeding",
      "E14",  "Gunshot Wound",
      "E15",  "Hemmorage",
      "E16",  "Abuse",
      "E17",  "Internal",
      "E18",  "Nausea/Vomiting",
      "E19",  "Obstetrics",
      "E20",  "Overdose",
      "E21",  "Paralysis",
      "E22",  "Penetrating Wounds",
      "E23",  "Poisoning",
      "E24",  "Psychological",
      "E25",  "Respiratory ARREST",
      "E26",  "Respiratory Distress",
      "E27",  "Convulsions/Seizures",
      "E28",  "Shock",
      "E29",  "Sprain/Strain",
      "E30",  "Unconscious/Fainting",
      "E31",  "Minor Trauma",
      "E32",  "Major Trauma",
      "E33",  "Multiple Systems Trauma",
      "E34",  "Unknown/Excited Caller",
      "E35",  "Unknown/General Illness",
      "E36",  "Refused/Cancelled",
      "E37",  "MED-ALERT Alarm",
      "E45",  "Motor Vehicle Accident",
      "E55",  "Fire Scene Standby",
      "E82",  "Emergency Transport",
      "E83",  "Non Emergency Transport"
  });
}
