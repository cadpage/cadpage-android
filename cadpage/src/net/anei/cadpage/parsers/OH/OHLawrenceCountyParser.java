package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;




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
    if (data.strName.equals("LAWRENC E TWP")) {
      data.strCity = "LAWRENCE TWP";
      data.strName = "";
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
