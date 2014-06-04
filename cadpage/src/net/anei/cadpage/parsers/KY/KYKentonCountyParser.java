package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class KYKentonCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER1 = Pattern.compile("(.*?) -- (\\d{4}-\\d{8})? +/ *(.*)");
  private static final Pattern MASTER2 = Pattern.compile("(.* - STAGE AT): +/ +(.*)");
  private static final Pattern CASE_BREAK_PTN = Pattern.compile("(.*?) *\\b([^a-z]+)$");
  private static final Pattern PLACE_DEPT_PTN = Pattern.compile("(.*?) *\\b([A-Z]{2}[FP]D\\b.*)");
  
  public KYKentonCountyParser() {
    super(CITY_LIST, "KENTON COUNTY", "KY");
    addRoadSuffixTerms("PI", "XING");
    setupMultiWordStreets(
        "BRACHT PINER",
        "CASTLE HILL",
        "CENTRE VIEW",
        "CLUB HOUSE",
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
        "JACK WOODS",
        "JAMES SIMPSON JR",
        "LICKING STATION",
        "MEADOW GLEN",
        "MEDICAL VILLAGE",
        "MT VERNON",
        "MANOR LAKE",
        "OLD TAYLOR MILL",
        "REGAL RIDGE",
        "ROUND HILL",
        "SLEEPLY HOLLOW",
        "SOUTH LOOP",
        "ST ANTHONY",
        "ST MATTHEWS",
        "ST JAMES",
        "ST JOSEPH",
        "STEEP CREEK",
        "SUGAR TREE",
        "TAYLOR CREEK",
        "TAYLOR MILL",
        "THOMAS MORE",
        "TIMBER RIDGE",
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
    // Sometimes there are double blanks separting the fields
    // and some times they are not.  Just makes life interesting
    
    // Start by checking for a known call description
    // 
    String call = CODE_SET.getCode(addr);
    if (call != null) {
      
      // OK, that takes care of the call
      // just divide the rest into a place and address
      data.strCall = call;
      addr = addr.substring(call.length()).trim();
      
      StartType st = StartType.START_PLACE;
      parseAddress(st, FLAG_IMPLIED_INTERSECT, addr, data);
      data.strApt = append(data.strApt, "-", getLeft());
    }
    
    else {
      
      // No know call description, this make things difficult
      // Split address by double blank separators
      // If more than 3 parts, give up
      String[] flds = addr.split("  +");
      if (flds.length > 3) return false;
      
      // If less than 3, try to break up the first part into 
      // mixed case and upper case parts
      if (flds.length < 3) {
        match = CASE_BREAK_PTN.matcher(flds[0]);
        if (match.matches()) {
          String[] tmp = new String[flds.length+1];
          tmp[0] = match.group(1);
          tmp[1] = match.group(2);
          if (tmp.length > 2) tmp[2] = flds[1];
          flds = tmp;
        }
      }
      
      // This should give us at least 2 parts
      if (flds.length < 2) return false;
      
      data.strCall = flds[0];
      StartType st;
      if (flds.length > 2) {
        data.strPlace = flds[1];
        st = StartType.START_ADDR;
        addr = flds[2];
      } else {
        st = StartType.START_PLACE;
        addr = flds[1];
      }
      parseAddress(st, FLAG_IMPLIED_INTERSECT, addr, data);
      data.strApt = append(data.strApt, "-", getLeft());
    }
    
    fixPlaceDept(data);
     
    return true;

  }

  private void fixPlaceDept(Data data) {
    Matcher match;
    // Place fields come from all kinds of places, but wherever they come from
    // they often contain a department code
    match = PLACE_DEPT_PTN.matcher(data.strPlace);
    if (match.matches()) {
      data.strSource = append(data.strSource, " ", match.group(2));
      data.strPlace = match.group(1);
    }
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
      "Abdominal/Stomach Pain",
      "Accident-Hit Skip",
      "Accident-Train Wreck",
      "Accident-w/Injuries",
      "Accident-No Injuries",
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
      "Elevator/Trapped People",
      "Emotional Crisis",
      "Explosion",
      "Fall",
      "Fire-Alarm",
      "Fire-Alarm",
      "Fire-Arson Investigation",
      "Fire-Auto/Vehicle",
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
      "Ill/Non-Specific",
      "Intoxicated Subject",
      "Investigation/Follow Up",
      "Landing Zone",
      "Lockout Veh/Res",
      "Missing Juvenile",
      "Motorist Assist",
      "Non-Responsive Person",
      "Not Breathing",
      "Overdose/Drug",
      "OI",                      // ???
      "Pump Basement",
      "Seizure",
      "Shooting/Gunshot Wound",
      "Signal 500 1st Alarm",
      "Signal 500 2nd Alarm",
      "Signal 500 3rd Alarm",
      "Signal 500 4th Alarm",
      "Signal 500 5th Alarm",
      "Stabbing",
      "Stroke",
      "Suspicious-Person",
      "SWAT CALL - STAGE AT",
      "Theft",
      "Trouble-Juvenile",
      "TS",                      // ???
      "TX",
      "Vacation/Business Check",
      "Well Being Check",
      "Wires Down"
  );
}
