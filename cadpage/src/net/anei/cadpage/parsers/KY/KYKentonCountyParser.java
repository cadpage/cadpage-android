package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class KYKentonCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER1 = Pattern.compile("(.*?) --? (\\d{4}-\\d{8})? +/ *(.*)");
  private static final Pattern MASTER2 = Pattern.compile("(Administrative .*?) (\\d{4}-\\d{8})? +(.*)");
  private static final Pattern MASTER3 = Pattern.compile("(.* - STAGE AT): +/ +(.*)");
  private static final Pattern EXTRA_BLANK_PTN = Pattern.compile("( [NSEW] ) +");
  private static final Pattern CASE_BREAK_PTN = Pattern.compile(" +([^a-z]+)(?: +|$)");
  private static final Pattern DEPT_PTN = Pattern.compile("(.*?) *\\b([A-Z]{2}[FP]D)\\b *(.*)", Pattern.CASE_INSENSITIVE);
  
  public KYKentonCountyParser() {
    super(CITY_LIST, "KENTON COUNTY", "KY");
    addRoadSuffixTerms("PI", "XING");
    setupMultiWordStreets(
        "ASH GROVE",
        "BRACHT PINER",
        "BRENT SPENCE",
        "CASTLE HILL",
        "CEDAR RIDGE",
        "CENTRE VIEW",
        "CHAMBER CENTER",
        "CLUB HOUSE",
        "COOK BOOK",
        "CRUISE CREEK",
        "DRY RIDGE",
        "FAR HILLS",
        "FORT HENRY",
        "FOWLER CREEK",
        "FRIAR TUCK",
        "FREEDOM PARK",
        "GEORGE STEINFORD",
        "HENRY CLAY",
        "HIGH RIDGE",
        "HOLLY RIDGE",
        "HICKORY GROVE",
        "INDEPENDENCE STATION",
        "JACK WOODS",
        "JAMES SIMPSON JR",
        "KENTON STATION",
        "LICKING STATION",
        "LOOKOUT FARM",
        "MEADOW GLEN",
        "MEDICAL VILLAGE",
        "MT ALLEN",
        "MT VERNON",
        "MANOR LAKE",
        "MARY LAIDLEY",
        "OLD TAYLOR MILL",
        "PARKERS GROVE",
        "PLEASANT RIDGE",
        "REGAL RIDGE",
        "ROCK CRYSTAL",
        "ROUND HILL",
        "SLEEPLY HOLLOW",
        "SOUTH LOOP",
        "ST AGNES",
        "ST ANTHONY",
        "ST CLAIR",
        "ST MATTHEWS",
        "ST JAMES",
        "ST JOSEPH",
        "STEEP CREEK",
        "STONE HILL",
        "SUGAR CAMP",
        "SUGAR TREE",
        "MARBLE CLIFF",
        "TAYLOR CREEK",
        "TAYLOR MILL",
        "THOMAS MORE",
        "TIMBER RIDGE",
        "TOWN CENTER",
        "TUSCANY VALLEY",
        "TWIN LAKES",
        "VALLEY SQUARE",
        "VALLEY TRAILS",
        "VALLEY VIEW",
        "WALTON NICHOLSON"
        );
  }
  
  @Override
  public String getFilter() {
    return "dispatch@kentoncounty.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("From KCECC")) return false;
    
    // There have been three different page formats of late :(
    String addr;
    Matcher match;
    if ((match = MASTER1.matcher(body)).matches()) {
      setFieldList("CALL PLACE SRC ADDR APT CITY ID INFO");
      addr = match.group(1).trim();
      data.strCallId = getOptGroup(match.group(2));
      data.strSupp = match.group(3);
    }
    
    else if ((match = MASTER2.matcher(body)).matches()) {
      setFieldList("CALL PLACE SRC ADDR APT CITY ID INFO");
      addr = match.group(1).trim();
      data.strCallId = match.group(2);
      data.strSupp = match.group(3);
    }
    
    else if ((match = MASTER3.matcher(body)).matches()) {
      setFieldList("CALL ADDR APT CITY");
      data.strCall = match.group(1).trim();
      parseAddress(match.group(2), data);
      return true;
    }
    
    else return false;
    
    // Not things start getting complicated
    // The first part of the page contains 
    // the call description (always mixed case)
    // option place (upper case)
    // address (upper case)
    // Sometimes there are double blanks seperating the fields
    // and some times they are not.  Just makes life interesting
    
    // Start by checking for a known call description
    // 
    String call = CODE_SET.getCode(addr);
    if (call != null) {
      
      // OK, that takes care of the call
      // just divide the rest into a place and address
      data.strCall = call;
      addr = addr.substring(call.length()).trim();
      
      match = DEPT_PTN.matcher(addr);
      if (match.matches()) {
        data.strPlace = match.group(1);
        data.strSource = match.group(2);
        addr = match.group(3);
      }
      
      parseAddress(StartType.START_OTHER, FLAG_IMPLIED_INTERSECT, addr, data);
      if (data.strSource.length() > 0) data.strSource = append(data.strSource, " ", getStart());
      else data.strPlace = getStart();
      data.strApt = append(data.strApt, "-", getLeft());
    }
    
    else {
      
      // No known call description, this make things difficult
      // Get rid of the extraneouis double blanks, then
      // split address by double blank separators
      // If more than 3 parts, give up
      addr = EXTRA_BLANK_PTN.matcher(addr).replaceFirst("$1");
      String[] flds = addr.split("  +");
      if (flds.length > 3) return false;
      
      // If less than 3, try to break up the first part into 
      // mixed case and upper case parts,  If the field length is 1, we
      // have to take a possible mixed case city name at the end of the string
      if (flds.length < 3) {
        match = CASE_BREAK_PTN.matcher(flds[0]);
        int pt = -1;
        if (match.find()) {
          int len = 0;
          do {
            if (flds.length > 1) {
              if (match.end() != flds[0].length()) continue;
            } else {
              if (match.group(1).length() < len) continue;
            }
            pt = match.start();
            len = match.group(1).length();
          } while (match.find());
        }
        if (pt >= 0) {
          String[] tmp = new String[flds.length+1];
          tmp[0] = flds[0].substring(0,pt);
          tmp[1] = flds[0].substring(pt).trim();
          if (tmp.length > 2) tmp[2] = flds[1];
          flds = tmp;
        }
      }
      
      // Hopefully this will give us two parts
      
      StartType st = StartType.START_CALL;
      if (flds.length == 1) {
        match = DEPT_PTN.matcher(flds[0]);
        if (match.matches()) {
          data.strCall = match.group(1);
          data.strSource = match.group(2);
          flds[0] = match.group(3);
          st = StartType.START_OTHER;
        }
      }
      else {
        data.strCall = flds[0];
        st = StartType.START_PLACE;
        
        match = DEPT_PTN.matcher(flds[1]);
        if (match.matches()) {
          data.strPlace = match.group(1);
          data.strSource = match.group(2);
          flds[1] = match.group(3);
          st = StartType.START_OTHER;
        }
        if (flds.length > 2) {
          if (data.strSource.length() > 0) {
            data.strSource = append(data.strSource, " ", flds[1]);
          } else {
            data.strPlace = flds[1];
          }
          st = StartType.START_ADDR;
        }
      }

      parseAddress(st, FLAG_IMPLIED_INTERSECT, flds[flds.length-1], data);
      if (st == StartType.START_OTHER) data.strSource = append(data.strSource, " ", getStart()); 
      data.strApt = append(data.strApt, "-", getLeft());
    }
    
    return true;

  }
  
  @Override
  public CodeSet getCallList() {
    return CODE_SET;
  }

  private static final String[] CITY_LIST = new String[]{
    
    "KENTON COUNTY",

    // Cities
    "BROMLEY",
    "COVINGTON",
    "CRESCENT SPRINGS",
    "CRESTVIEW HILLS",
    "EDGEWOOD",
    "ELSMERE",
    "ERLANGER",
    "FAIRVIEW",
    "FORT MITCHELL",
    "FORT WRIGHT",
    "INDEPENDENCE",
    "KENTON VALE",
    "LAKESIDE PARK",
    "LATONIA LAKES",
    "LUDLOW",
    "PARK HILLS",
    "RYLAND HEIGHTS",
    "TAYLOR MILL",
    "VILLA HILLS",
    "VISALIA",
    "WALTON",

    // Other places
    "LATONIA",
    "NICHOLSON",
    "ATWOOD"
    
  };
  
  private static final CodeSet CODE_SET = new CodeSet(
      "911 Disconnect",
      "Abdominal/Stomach Pain",
      "Accident-Hit Skip",
      "Accident-Pedestrian Struck",
      "Accident-Train Wreck",
      "Accident-w/Injuries",
      "Accident-No Injuries",
      "Administrative",
      "Alarm-Audible",
      "Alarm-Carbon Monoxide Detector",
      "Alarm-Intrusion",
      "Alarm-Medical Emergency",
      "Allergies/Sting Reaction",
      "ANIDW",
      "Animal-Bite/Attack",
      "Animal-Complaint",
      "Arm/Hand Injury",
      "Assist-Fire",
      "Assault",
      "Assault w/Injuries",
      "Assist-Other Agency",
      "Back Pain/Injury",
      "Bleeding/Hemorrhage",
      "Boat-Adrift/Abandoned",
      "Broken/Fractured Bone",
      "Burn/Scalding",
      "Chest Injury/Pains",
      "Childbirth/Labor/Maternity",
      "Choking",
      "Criminal Mischief",
      "Difficulty Breathing",
      "Dizzy",
      "DOA-Death Investigation",
      "Diabetic Reaction",
      "Domestic Trouble",
      "Drug Activity",
      "Drunk Driver/DUI",
      "Elevator/Trapped People",
      "Emotional Crisis",
      "Explosion",
      "Extrication",
      "Fall",
      "Fire-Alarm",
      "Fire-Alarm",
      "Fire-Arson Investigation",
      "Fire-Auto/Vehicle",
      "Fire-Boat",
      "Fire-Brush",
      "Fire-Pump Basement",
      "Fire-Setting Fire Outside",
      "Fire-Smoke/Odor/Chemical",
      "Fire-Investigation",
      "Fire-Gas Spill/Leak",
      "Fire-Outside Structure",
      "Fire-Pump Basement",
      "Fire-Structure Fire",
      "Fire-Trash/Dumpster",
      "General Relay",
      "HAZMAT All",
      "Head Injury",
      "Headache/Ill",
      "Heat Emergency/Problem",
      "Ill/Non-Specific",
      "Intoxicated Subject",
      "Investigation/Follow Up",
      "Landing Zone",
      "Lockout Veh/Res",
      "Mass Casualty Incident",
      "Missing Juvenile",
      "Motorist Assist",
      "Non-Responsive Person",
      "Not Breathing",
      "Overdose/Drug",
      "OI",                      // ???
      "Open Door/Window",
      "Parking Complaint",
      "Property-Lost/Found/Assist",
      "Public Contact/Complaint",
      "Pump Basement",
      "REPO",
      "Seizure",
      "Shooting/Gunshot Wound",
      "Shots Fired",
      "Signal 500 1st Alarm",
      "Signal 500 2nd Alarm",
      "Signal 500 3rd Alarm",
      "Signal 500 4th Alarm",
      "Signal 500 5th Alarm",
      "Special Detail",
      "Speeding/Reckless Vehicle",
      "Stabbing",
      "Stroke",
      "Suspicious-Person",
      "Suspicious-Vehicle",
      "SWAT CALL - STAGE AT",
      "Theft",
      "Traffic Obstruction",
      "Trouble-Employee/Customer",
      "Trouble-Juvenile",
      "Trouble-Unknown",
      "Trouble-with Neighbors",
      "TS",                      // ???
      "TX",
      "Vacation/Business Check",
      "Warrant-Arrest",
      "Well Being Check",
      "Wires Down"
  );
}
