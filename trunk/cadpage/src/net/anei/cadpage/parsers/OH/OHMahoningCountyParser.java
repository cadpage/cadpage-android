package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;


public class OHMahoningCountyParser extends DispatchEmergitechParser {
  
  private static final Pattern TRAIL_PTN = Pattern.compile(" +-[A-Z0-9]+$");
  private static final Pattern GPS_PTN = Pattern.compile("^X=([+-]?[0-9\\.]+)Y=([+-]?[0-9\\.]+)CF=\\d+%UF=\\d+MZ=[0-9\\.]*M");
  private static final Pattern GPS_TERM_PTN = Pattern.compile("Z ?=[0-9 \\.]*M");
  private static final Pattern[] CITY_SPACE_PTNS = {
    Pattern.compile("([NESW]) (.*)"),
    Pattern.compile("(.*) ([NESW])"),
    Pattern.compile("(.*) ([NESW] TWP)"),
    Pattern.compile("(LAK) (E .*)"),
    Pattern.compile("(NEW [NSEW]) (.*)")
  };
  
  public OHMahoningCountyParser() {
    super("", -23, CITY_LIST, "MAHONING COUNTY", "OH");
    setupMultiWordStreets("COLUMBIANA CANFIELD");
  }

  @Override
  public String getFilter() {
    return "anoble@ci.canfield.oh.us";
  }
  
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) subject = "666";
    if (!body.startsWith("- ")) body = "- " + body;
    body = '[' + subject + "]" + body;
    
    Matcher match = TRAIL_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start());
    
    if (!super.parseMsg(body,  data)) return false;
    data.strUnit = "";
    String call = CALL_CODES.getProperty(data.strCall);
    if (call != null) {
      data.strCode = data.strCall;
      data.strCall = call;
    }
    
    // Search for a GPS pattern that may have extra inserted spaces :(
    match = GPS_PTN.matcher(data.strSupp.replace(" ", ""));
    if (match.find()) {
      setGPSLoc(match.group(1) + ',' + match.group(2), data);
      match = GPS_TERM_PTN.matcher(data.strSupp);
      if (match.find()) {
        data.strSupp = data.strSupp.substring(match.end()).trim();
      }
    }
    
    for (Pattern ptn : CITY_SPACE_PTNS) {
      match = ptn.matcher(data.strCity);
      if (match.matches()) {
        data.strCity = match.group(1) + match.group(2);
        break;
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "CODE " + super.getProgram() + " GPS";
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "ALLIANCE",
    "CAMPBELL",
    "CANFIELD",
    "COLUMBIANA",
    "SALEM",
    "STRUTHERS",
    "YOUNGSTOWN",
    "YOUNGSTOW N",

    // Villages
    "BELOIT",
    "CRAIG BEACH",
    "LOWELLVILLE",
    "NEW MIDDLETOWN",
    "N EW MIDDLETOWN",
    "NEW MIDDLETOW N",
    "POLAND",
    "SEBRING",
    "WASHINGTONVILLE",
    "W ASHINGTONVILLE",
    "WASHINGTONVILL E",

    // Townships
    "AUSTINTOWN TWP",
    "AUSTINTOW N TWP",
    "BEAVER TWP",
    "BERLIN TWP",
    "BERLI N TWP",
    "BOARDMAN TWP",
    "BOARDMA N TWP",
    "CANFIELD TWP",
    "COITSVILLE TWP",
    "COITSVILL E TWP",
    "ELLSWORTH TWP",
    "E LLSWORTH TWP",
    "GOSHEN TWP",
    "GOSHE N TWP",
    "GREEN TWP",
    "GREE N TWP",
    "JACKSON TWP",
    "JACKSO N TWP",
    "MILTON TWP",
    "MILTO N TWP",
    "POLAND TWP",
    "SMITH TWP",
    "S MITH TWP",
    "SPRINGFIELD TWP",
    "S PRINGFIELD TWP",

    // Census-designated places
    "AUSTINTOWN",
    "AUSTINTOW N",
    "BOARDMAN",
    "BOARDMA N",
    "MAPLE RIDGE",
    "MAPLE RIDG E",
    "MINERAL RIDGE",
    "MINERAL RIDG E",
  
    //Other communities
    "DAMASCUS",
    "DAMASCU S",
    "ELLSWORTH",
    "E LLSWORTH",
    "GREENFORD",
    "LAKE MILTON",
    "LAK E MILTON",
    "LAKE MILTO N",
    "NEW SPRINGFIELD",
    "N EW SPRINGFIELD",
    "NEW S PRINGFIELD",
    "NORTH BENTON",
    "N ORTH BENTON",
    "NORTH BENTO N",
    "NORTH JACKSON",
    "N ORTH JACKSON",
    "NORTH JACKSO N",
    "NORTH LIMA",
    "N ORTH LIMA",
    "PETERSBURG",

  };
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "F29",   "Medical Call W/O AFD Response",
      "F30",   "Transfer To Lanes - Log Reason",
      "F31",   "Medical Call With AFD Response",
      "F42",   "Fire/Burning Complaint",
      "F86",   "Odor Complaint",
      "6A",    "Accident With Injury",
      "F87",   "Fire Department Call",
      "F88",   "Township Fuel Spills",
      "F89",   "Fire Department Freeway Call",
      "F90",   "Fire Drill",
      "F91",   "Structure Fire",
      "F92",   "Vehicle Fire",
      "F93",   "Grass/Bush Fire",
      "F94",   "Jaws Of Life Call",
      "F95",   "Dumpster Fire Near Building",
      "F96",   "Dumpster Fire Not Near Building",
      "F97",   "Fire Alarm",
      "F97A",  "Fire Alarm/Trouble Position",
      "F98",   "Fire Department Mutual Aid",
      "F99",   "Chemical Spill",
      "F101",  "Carbon Monoxide Check"
  });
}
