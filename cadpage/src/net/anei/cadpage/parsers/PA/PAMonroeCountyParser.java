package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class PAMonroeCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("CAD MSG: \\*[DG] ([A-Z0-9]+) +");
  
  public PAMonroeCountyParser() {
    super(CITY_CODES, "MONROE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "emergin@monroeco911.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    // Strip off any prefix
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCall = match.group(1);
    body = body.substring(match.end()).replaceAll("//+", "/");
    
    parseAddress(StartType.START_ADDR, FLAG_NO_IMPLIED_APT | FLAG_CROSS_FOLLOWS, body, data);
    
    String call = convertCodes(data.strCall, CALL_CODES);
    if (call != null) {
      data.strCode = data.strCall;
      data.strCall = call;
    }
    
    String extra = getLeft();
    extra = extra.replace('\n', ' ').replaceAll("  +", " ");
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, extra);
    if (res.getStatus() > 0) {
      res.getData(data);
      extra = res.getLeft();
    }
    data.strSupp = extra;
    
    // Dispatch has teh unfortunate habbit of coding place names as the first part of what looks like
    // an intersection.  We will try to undo the damage that results
    
    String sAddr = data.strAddress;
    int pt = sAddr.indexOf('&');
    if (pt >= 0) {
      String part1 = sAddr.substring(0,pt).trim();
      String part2 = sAddr.substring(pt+1).trim();
      if (checkAddress(part1) == 0 && checkAddress(part2) > 0) {
        data.strPlace = part1;
        data.strAddress = part2;
      }
    } else if (data.strCross.length() > 0) {
      if (checkAddress(sAddr) == 0) {
        data.strPlace = sAddr;
        data.strAddress = data.strCross;
        data.strCross = "";
      }
    }
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
