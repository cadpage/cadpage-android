package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class CTCheshireParser extends SmartAddressParser {

  public CTCheshireParser() {
    super(CITY_LIST, "CHESHIRE", "CT");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "BROAD SWAMP",
        "COOK HILL",
        "COPPER BEACH",
        "COUNTRY CLUB",
        "FAR HORIZON",
        "HALF MOON",
        "IVES ROW",
        "MOUNTAIN BROOK",
        "MT SANFORD",
        "NOB HILL",
        "OLD FARMS",
        "PINE BROOK",
        "POUND RIDGE",
        "ROUND HILL",
        "SORGHUM MILL",
        "STONY HILL",
        "TROUT BROOK",
        "WOOD HILL"
    );
    removeWords("CL");
  }

  @Override
  public String getProgram() {
    return "CALL ADDR PLACE APT X CITY UNIT INFO"; // should I even be adding place to the program?
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    // check subj
    if (!subject.equals("CFD Dispatch")) return false;

    // parse as general alert if normal parsing fails
    if (!parseAddressInternal(body, data)) data.parseGeneralAlert(this, body);

    // never fail
    return true;
  }

  private static Pattern UNIT = Pattern.compile("(.*?)Dispatch received by unit ([^ ]+(?: *(?:Dispatch received by )?unit *[^ ]+)*)(.*?)");
  private static Pattern UDELIM = Pattern.compile(" *(?:Dispatch received by )?unit *");
  private static Pattern REQUESTED = Pattern.compile("(\\d+) requested *(.*)");

  private boolean parseAddressInternal(String body, Data data) {
    // we'll split message in half by first @
    int ai = body.indexOf("@");
    if (ai == -1) return false;

    // first half is CALL ADDR. getLeft() goes to strCross if empty, strPlace if not
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_NO_CITY, body.substring(0, ai - 1).trim(), data);
    if (data.strAddress.length() == 0) return false;
    String left = getLeft();
    
    // remove preceding slash present when a cross street that isnt a street name is left
    data.strPlace = stripFieldStart(left, "/");
    
    //get part 2, just return if not present
    String trail = body.substring(ai + 1).trim();
    if (trail.length() == 0) return true;
    
    // parse X and CITY first if present
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_ONLY_CITY , trail);
    if (res.isValid()) {
      res.getData(data);
      trail = res.getLeft();
    } // delete "No Cross Streets Found"
    if (data.strCross.equals("No Cross Streets Found")) data.strCross = "";
    
    // parse UNIT from "Dispatch received by" format
    Matcher mat = UNIT.matcher(trail);
    if (mat.matches()) {
      data.strUnit = UDELIM.matcher(mat.group(2)).replaceAll(", ");
      trail = append(mat.group(1).trim(), " / ", mat.group(3).trim());
    }

    // if UNIT wasn't present with dispatch tag, it might be with trailing requested tag
    mat = REQUESTED.matcher(trail);
    while (mat.matches()) {
      data.strUnit = append(data.strUnit, " ", mat.group(1));
      trail = mat.group(2);
      mat = REQUESTED.matcher(trail);
    }

    // put whats left in INFO
    data.strSupp = append(data.strSupp, " / ", trail);

    // out
    return true;
  }
  
  private static String[] CITY_LIST = new String[]{
    "CHESHIRE"
  };
  
  private static String[] CALL_LIST = new String[]{
    "ACCIDENT - NO INJURIES",
    "ACCIDENT - W/INJURIES",
    "ALARM BURGLAR",
    "COMPLAINTS GENERAL",
    "FD-ALARM",
    "FD-BRUSH/OPEN BURN/MULCH",
    "FD-CO NO SIGNS/SYMPTOMS",
    "FD-CO SIGNS/SYMPTOMS",
    "FD-CAR FIRE",
    "FD-GAS ODOR/LEAK IN BUILDING",
    "FD-MVA EXTRICATION/ROLLOVER",
    "FD-SMOKE IN AREA",
    "FD-STRUCTURE",
    "FD-TRANSFORMER/WIRES",
    "FD-WATER CONDITION",
    "HAZARD",
    "MEDICAL ASSIST",
    "WIRES DOWN"
  };
}
