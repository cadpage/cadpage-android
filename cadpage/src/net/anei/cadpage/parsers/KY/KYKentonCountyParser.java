package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class KYKentonCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER1 = Pattern.compile("(.*?) -- (\\d{4}-\\d{8}) +/ *(.*)");
  private static final Pattern MASTER2 = Pattern.compile("((?:\\d{3,} +)+) ([A-Z]+\\d+) +(.*?) +(\\d{4}-\\d{8})");
  private static final Pattern MASTER3 = Pattern.compile("(.*) / (\\d{4}-\\d{8}) (.*)");
  private static final Pattern CASE_BREAK_PTN = Pattern.compile("(.*?) *\\b([^a-z]+)$");
  private static final Pattern DISPATCH_UNIT_PTN = Pattern.compile("^Dispatch received by unit ([^ ]+) *");
  private static final Pattern MISSED_CROSS_ST_PTN = Pattern.compile(" *([^ ]+) */$");
  private static final Pattern PLACE_DEPT_PTN = Pattern.compile("(.*?) *\\b([A-Z]{2}[FP]D\\b.*)");
  
  public KYKentonCountyParser() {
    super(CITY_LIST, "KENTON COUNTY", "KY");
    addRoadSuffixTerms("PI");
    setupMultiWordStreets(
        "GEORGE STEINFORD",
        "TWIN LAKES",
        "WALTON NICHOLSON"
        );
  }
  
  @Override
  public String getFilter() {
    return "dispatch@kentoncounty.org";
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return SCOTT_ST_PTN.matcher(addr).replaceAll("SCOTT BLVD");
  }
  private static final Pattern SCOTT_ST_PTN = Pattern.compile("\\bSCOTT +ST\\b", Pattern.CASE_INSENSITIVE);
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("From KCECC")) return false;
    
    // There have been three different page formats of late :(
    String addr;
    Matcher match;
    if ((match = MASTER1.matcher(body)).matches()) {
      setFieldList("CALL PLACE SRC ADDR APT ID INFO");
      addr = match.group(1).trim();
      data.strCallId = match.group(2);
      data.strSupp = match.group(3);
    }
    
    else if ((match = MASTER2.matcher(body)).matches()) {
      setFieldList("UNIT SRC ADDR APT PLACE CITY CALL ID");
      data.strUnit = match.group(1).trim();
      data.strSource = match.group(2);
      parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD, match.group(3).trim(), data);
      if (data.strCity.length() == 0) return false;
      if (data.strCity.equalsIgnoreCase("KENTON COUNTY")) data.strCity = "";
      data.strPlace = getPadField();
      data.strCall = getLeft();
      data.strCallId = match.group(4);
      
      fixPlaceDept(data);
      return true;
    }
    
    else if ((match = MASTER3.matcher(body)).matches()) {
      setFieldList("CALL PLACE SRC ADDR APT ID CITY UNIT INFO X");
      addr = match.group(1);
      data.strCallId = match.group(2);
      String info = match.group(3);
      
      // Next we work on the trailing info section
      // There is a consistent city name followed by a double blank
      Parser p = new Parser(info);
      data.strCity = p.get("  ");
      if (data.strCity.equalsIgnoreCase("KENTON COUNTY")) data.strCity = "";
      info = p.get();
      
      // This may be followed by one or more dispatched units
      while ((match = DISPATCH_UNIT_PTN.matcher(info)).find()) {
        data.strUnit = append(data.strUnit, " ", match.group(1).trim());
        info = info.substring(match.end());
      }
      
      // This is followed by an general info section which may be mixed case or upper case
      // and usually by a set of cross streets.  Which are always upper case and may or may
      // not be separated by double blanks.  But we can't count on the double blanks,
      // sometimes there are spurious double blanks in the info section.
      
      // There is one easy case, where the message ends with a "No Cross Streets Found" msg
      if (info.endsWith("No Cross Streets Found")) {
        data.strSupp = info.substring(0,info.length()-22).trim();
      }
      
      // Second slightly easy case is a double blank followed by truncated No Cross Streets msg
      else {
        int pt = info.lastIndexOf("  ");
        pt = (pt < 0 ? pt = 0 : pt+2);
        if ("No Cross Streets Found".startsWith(info.substring(pt))) {
          data.strSupp = info.substring(0,pt).trim();
        }
        
        // First find the last case break or double blank delimiter in the string
        else {
          pt = 0;
          match = CASE_BREAK_PTN.matcher(info);
          if (match.matches()) pt = match.start(2);
          int pt2 = info.lastIndexOf("  ");
          if (pt2 > pt) pt = pt2+2;
          
          data.strSupp = info.substring(0,pt).trim();
          String cross = info.substring(pt).trim();
          
          // OK, we have a good candidate for the cross street
          // But since we still are not sure, use the smart parser
          // to try to pick out the cross street info
          
          // We already have used both the start fields, so we will have to save and restore one of them
          String place = data.strPlace;
          data.strPlace = "";
          parseAddress(StartType.START_PLACE, FLAG_ONLY_CROSS, cross, data);
          data.strSupp = append(data.strSupp, "  ", data.strPlace);
          data.strPlace = place;
          data.strCross = append(data.strCross, " ", getLeft());
          
          // One last check for things that should have been cross streets but are not
          // recognized by the smart address parser
          match = MISSED_CROSS_ST_PTN.matcher(data.strSupp);
          if (match.find()) {
            data.strCross = append(match.group(1), " / ", data.strCross);
            data.strSupp = data.strSupp.substring(0,match.start());
          }
        }
      }
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
      "Accident-Train Wreck",
      "Accident-w/Injuries",
      "Alarm-Carbon Monoxide Detector",
      "Alarm-Medical Emergency",
      "Allergies/Sting Reaction",
      "Animal-Bite/Attack",
      "Arm/Hand Injury",
      "Assist-Fire",
      "Assault w/Injuries",
      "Back Pain/Injury",
      "Bleeding/Hemorrhage",
      "Broken/Fractured Bone",
      "Burn/Scalding",
      "Chest Injury/Pains",
      "Childbirth/Labor/Maternity",
      "Choking",
      "Difficulty Breathing",
      "Dizzy",
      "DOA-Death Investigation",
      "Diabetic Reaction",
      "Elevator/Trapped People",
      "Emotional Crisis",
      "Fall",
      "Fire-Alarm",
      "Fire-Alarm",
      "Fire-Arson Investigation",
      "Fire-Auto/Vehicle",
      "Fire-Brush",
      "Fire-Setting Fire Outside",
      "Fire-Smoke/Odor/Chemical",
      "Fire-Investigation",
      "Fire-Gas Spill/Leak",
      "Fire-Outside Structure",
      "Fire-Pump Basement",
      "Fire-Structure Fire",
      "Fire-Trash/Dumpster",
      "HAZMAT All",
      "Head Injury",
      "Ill/Non-Specific",
      "Landing Zone",
      "Non-Responsive Person",
      "Not Breathing",
      "Overdose/Drug",
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
      "Wires Down"
  );
}
