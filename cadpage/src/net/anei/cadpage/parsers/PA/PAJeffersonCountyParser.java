package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class PAJeffersonCountyParser extends SmartAddressParser {
  
  private static final Pattern BOX_CH_PTN = Pattern.compile("(?: +BOX|-)? +(\\d{1,2}-[A-Z])(?: +([A-Za-z]+(?: +[A-Za-z]+)?))?$");
  
  public PAJeffersonCountyParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "PA");
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

    // SNYDER HILL in info section confuses the smart address parer
    body = body.replace("Snyder Hill", "Snyder-Hill");
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS, body, data);
    data.strCross = getPadField();
    String extra = getLeft();
    
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
          Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, part);
          if (res.getStatus() > 0) {
            String saveCross = data.strCross;
            data.strCross = "";
            res.getData(data);
            data.strCross = append(saveCross, ", ", data.strCross);
            part = res.getLeft();
            if (part.length() > 0) {
              data.strPlace = part;
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
    "SPRANKLE MILLS"

  };
}
