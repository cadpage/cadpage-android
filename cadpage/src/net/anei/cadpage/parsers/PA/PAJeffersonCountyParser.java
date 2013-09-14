package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class PAJeffersonCountyParser extends SmartAddressParser {
  
  private static final Pattern BOX_CH_PTN = Pattern.compile("(?: +BOX|-)? +(\\d{1,2}-[A-Z])(?: +([A-Za-z]+(?: +[A-Za-z]+)?))?$");
  private static final Pattern UNIT_PTN = Pattern.compile("(?: +(?:[A-Z]+\\d+|HH))+  +");
  private static final Pattern GPS_PIPE_PTN1 = Pattern.compile("^([-+]?\\d+\\.\\d+)\\|([-+]?\\d+\\.\\d+)\\b");
  private static final Pattern GPS_PIPE_PTN2 = Pattern.compile("\\b([-+]?\\d+\\.\\d+)\\|([-+]?\\d+\\.\\d+)\\b");
  
  public PAJeffersonCountyParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "PA");
    setupMultiWordStreets("SWARTZ ACRES");
    setFieldList("CALL UNIT ADDR APT X CITY PLACE INFO BOX CH");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@jeffersoncountypa.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Incident")) return false;
    
    Matcher match = BOX_CH_PTN.matcher(body);
    if (match.find()) {
      data.strBox = match.group(1);
      data.strChannel = getOptGroup(match.group(2));
      body = body.substring(0,match.start()).trim();
    }
    
    int pt = body.indexOf("Narrative:");
    if (pt >= 0) {
      data.strSupp = body.substring(pt+10).trim();
      body = body.substring(0,pt).trim();
    }
    
    // See if we can find a unit field separating the call description from the address
    StartType st = StartType.START_CALL;
    int flags = FLAG_START_FLD_REQ;
    match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strCall = body.substring(0,match.start());
      data.strUnit = match.group().trim();
      body = body.substring(match.end());
      st = StartType.START_ADDR;
      flags = 0;
    }
    
    // GPS coordinates use an unusual pipe separator that the smart address parser will not recognize
    String extra;
    Pattern ptn = (st == StartType.START_ADDR ? GPS_PIPE_PTN1 : GPS_PIPE_PTN2);
    match = ptn.matcher(body);
    if (match.find()) {
      if (st == StartType.START_CALL) data.strCall = body.substring(0,match.start()).trim();
      data.strAddress = match.group(1) + "," + match.group(2);
      extra = body.substring(match.end()).trim();
    }
    
    // If no GPS coordiantes found, use the smart address parser to split things
    else {
  
      // SNYDER HILL in info section confuses the smart address parer
      body = body.replace("Snyder Hill", "Snyder-Hill");
      body = body.replace(",", " ,");
      parseAddress(st, flags | FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS, body, data);
      String pad = getPadField();
      if (pad.length() > 0 && !pad.contains(" ")) {
        data.strAddress = append(data.strAddress, " ", pad);
      } else {
        data.strCross = getPadField();
      }
      extra = getLeft().replace(" ,", ",");
    }
    
    if (data.strCross.length() == 0 && extra.contains(" / ")) {
      boolean cross = true;
      boolean foundSlash = false;
      for (String part : extra.split(",")) {
        part = part.trim();
        boolean slash = part.contains("/");
        if (!slash && !foundSlash) {
          data.strCross = append(data.strCross, ", ", part);
        }
        else if (cross) {
          Result res = parseAddress(StartType.START_PLACE, FLAG_ONLY_CROSS, part);
          if (res.getStatus() > 0) {
            String savePlace = data.strPlace;
            String saveCross = data.strCross;
            data.strPlace = data.strCross = "";
            res.getData(data);
            data.strPlace = append(savePlace, " - ", data.strPlace);
            data.strCross = append(saveCross, ", ", data.strCross);
            part = res.getLeft();
            if (part.length() > 0) {
              data.strPlace = append(data.strPlace, " - ", part);
              cross = false;
            }
          } else if (slash) {
            data.strCross = append(data.strCross, ", ", part);
            cross = false;
          } else {
            data.strPlace = part;
            cross = false;
          }
        } else {
          data.strPlace = append(data.strPlace, ", ", part);
        }
        if (slash) foundSlash = true;
      }
    } else {
      data.strPlace = extra;
    }
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Boroughs
    "BIG RUN",
    "BROCKWAY",
    "BROOKVILLE",
    "CORSICA",
    "FALLS CREEK",
    "PUNXSUTAWNEY",
    "REYNOLDSVILLE",
    "SUMMERVILLE",
    "SYKESVILLE",
    "TIMBLIN",
    "WORTHVILLE",

    // Townships
    "BARNETT",
    "BEAVER",
    "BELL",
    "CLOVER",
    "ELDRED",
    "GASKILL",
    "HEATH",
    "HENDERSON",
    "KNOX",
    "MCCALMONT",
    "OLIVER",
    "PERRY",
    "PINE CREEK",
    "POLK",
    "PORTER",
    "RINGGOLD",
    "ROSE",
    "SNYDER",
    "UNION",
    "WARSAW",
    "WASHINGTON",
    "WINSLOW",
    "YOUNG",
    
    // Unincoroporated community
    "SPRANKLE MILLS",
    "CANOE",
    
    // Indiana County
    "BRUSH VALLEY"

  };
}
