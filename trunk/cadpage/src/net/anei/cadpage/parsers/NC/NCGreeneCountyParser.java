
package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCGreeneCountyParser extends DispatchSouthernParser {
  
  private static final Pattern CALL_CODE_PTN1 = Pattern.compile("(.*?)\\b10-(\\d\\d\\b.*)");
  private static final Pattern CALL_CODE_PTN2 = Pattern.compile("(\\d\\d(?:0\\d\\d)?) +(.*)");
  private static final Pattern MAP_PTN = Pattern.compile("(.*?)((\\bCELL .* )?\\b(?:[NSEW]|[NS][EW]) SECTOR)");
  private static final Pattern ADDR_DIR_PTN = Pattern.compile("(.*?) +([NSEW]|[NS][EW])");
  private static final Pattern START_DIGIT_PTN = Pattern.compile("(\\d+) +(.*)");

  public NCGreeneCountyParser() {
    super(CALL_SET, CITY_LIST, "GREENE COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE);
    setupMultiWordStreets("FOUR WAY", "FREE GOSPEL", "FRIENDSHIP CHURCH");
  }
  
  @Override
  public String getFilter() {
    return "@Greenecountync.com,";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    // Sometimes the place name and call code/description ends up in the name field
    Matcher match =  CALL_CODE_PTN1.matcher(data.strName);
    if (match.matches()) {
      data.strPlace = append(data.strPlace, " - ", match.group(1).trim());
      data.strCall = match.group(2);
      data.strName = "";
    }

    // See if a  mile marker ended up in the name
    if (data.strName.startsWith("MM ") || data.strName.startsWith("mm ")) {
      data.strAddress = append(data.strAddress, " ", data.strName);
      data.strName = "";
    }
    
    // If there is a call code in front of the call description, strip it off
    match = CALL_CODE_PTN2.matcher(data.strCall);
    if (match.matches()) {
      if (data.strCode.length() == 0) data.strCode = match.group(1);
      data.strCall = match.group(2);
    }
    
    // There is often a map code between the address and city fields, which
    // generally ends up in the APT field
    if (data.strApt.startsWith("- ")) {
      data.strMap = data.strApt.substring(2).trim();
      data.strApt = "";
    }
    else if ((match = MAP_PTN.matcher(data.strApt)).matches()) {
      data.strApt = match.group(1).trim();
      data.strMap = match.group(2);
    } else if  (data.strApt.equals("SECTOR")) {
      match = ADDR_DIR_PTN.matcher(data.strAddress);
      if (match.matches()) {
        data.strAddress = match.group(1);
        data.strMap = match.group(2) + ' ' + data.strApt;
        data.strApt = "";
      }
    }
    
    if (data.strPlace.startsWith("-")) data.strPlace = data.strPlace.substring(1).trim();
    if (data.strPlace.endsWith("#")) {
      match = START_DIGIT_PTN.matcher(data.strAddress);
      if (match.matches()) {
        data.strPlace = data.strPlace + match.group(1);
        data.strAddress = match.group(2);
      }
    }
    if (data.strPlace.equals("Not Entered")) data.strPlace = "";
    
    if (data.strCity.equals("WALTONSBURG")) data.strCity = "WALSTONBURG";
    
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("APT", "APT MAP");
  }

  private static final CodeSet CALL_SET = new CodeSet(
      "31 Alarm",
      "40 Fight In Progress",
      "50 P.D. Vehicle Accident - Property Damage",
      "50 P.I. Vehicle Accident - Personal Injury",
      "50 P.I. Vehicle Accident - Property Damage",
      "52 Ambulance Needed",
      "56 Drunk Pedestrian",
      "63 Investigate",
      "73 Mental Subject",
      "79 Domestic Dispute",
      "90 Shots Fired",
      "98 Fire Call"
  );

  private static final String[] CITY_LIST = new String[]{
    "HOOKERTON",
    "SNOW HILL",
    "WALSTONBURG",
    "WALTONSBURG",   // Misspelled by dispatch
    
    //Townships
    "BULL HEAD",
    "CARRS",
    "HOOKERTON",
    "JASON",
    "OLDS",
    "ORMONDSVILLE",
    "SHINE",
    "SNOW HILL",
    "SPEIGHTS BRIDGE",
    
    // Other
    "MAURY",
    
    // Lenoir County
    "LAGRANGE",
    "LA GRANGE",
    
    // Pitt County
    "AYDEN",
    "FARMVILLE",
    "GRIFTON",
    
    // Wilson County
    "SARATOGA",
    "STANTONSBURG",
    "WILSON"
    
  };
  
}
