package net.anei.cadpage.parsers.SC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class SCOrangeburgCountyParser extends SmartAddressParser {
  
  private static final Pattern AT_MARK_PTN = Pattern.compile(" @ | AT ");
  private static final Pattern LAN_PTN = Pattern.compile("\\bLAN\\b");
  private static final Pattern INTERSECT_PTN = Pattern.compile(" *INTERSECTION (?:OF ) *");
  private static final Pattern CROSS_GRID_PTN = Pattern.compile("(?:CROSS (?:OF )? *(.*?) *)?(?:GRIDS?[: ] *(.*))?");
 
  public SCOrangeburgCountyParser() {
    super(CITY_CODES, "ORANGEBURG COUNTY", "SC");
    addInvalidWords("FROM", "TO");
    setupMultiWordStreets("OLD NUMBER SIX");
    setFieldList("CALL ADDR APT CITY X MAP INFO");
  }
  
  @Override
  public String getFilter() {
    return "obcdispatch@orangeburgcounty.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.startsWith(":oburgeoc:")) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body.substring(10).trim();
      return true;
    }
    
    if (!body.startsWith(":obcdispatch:")) return false;
    body = body.substring(13).trim();
    
    // Split text body by slashes
    String[] flds = body.split("/");
    String addr = flds[0];
    
    // If the first part has an @ or AT marker, that marks the beginning of the address
    StartType st = StartType.START_CALL;
    int flags = FLAG_START_FLD_REQ;
    Matcher match = AT_MARK_PTN.matcher(addr);
    if (match.find()) {
      data.strCall = addr.substring(0,match.start()).trim();
      addr = addr.substring(match.end()).trim();
      st = StartType.START_ADDR;
      flags = 0;
    }
    addr = addr.replace(",", "");
    addr = LAN_PTN.matcher(addr).replaceAll("LN");
    addr = INTERSECT_PTN.matcher(addr).replaceAll(" ").trim();
    parseAddress(st, flags, addr, data);
    if (getStatus() == 0) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
      data.strAddress = "";
      return true;
    }
    flds[0] = getLeft();
    
    if (data.strAddress.endsWith(" IN")) {
      data.strAddress = data.strAddress.substring(0,data.strAddress.length()-3).trim();
    }
    
    // Now process the rest of the split fields
    for (String fld : flds) {
      fld = fld.trim();
      if ((match = CROSS_GRID_PTN.matcher(fld)).matches()) {
        data.strCross = append(data.strCross, " & ", getOptGroup(match.group(1)));
        data.strMap = append(data.strMap, "-", getOptGroup(match.group(2)));
      }
      else if (checkAddress(fld) > 0) {
        data.strCross = append(data.strCross, " & ", fld);
      } 
      else {
        data.strSupp = append(data.strSupp, " / ", fld);
      }
    }
    
    return true;
    
  }
  
  private static final String[] CITY_CODES = new String[]{
    "BOWMAN",
    "BRANCHVILLE",
    "BROOKDALE",
    "COPE",
    "CORDOVA",
    "ELLOREE",
    "EUTAWVILLE",
    "HOLLY HILL",
    "LIVINGSTON",
    "NEESES",
    "NORTH",
    "NORWAY",
    "ORANGEBURG",
    "ROWESVILLE",
    "SANTEE",
    "SPRINGFIELD",
    "VANCE",
    "WILKINSON HEIGHTS",
    "WOODFORD",
    
    "BERKLEY COUNTY"
  }; 
}
