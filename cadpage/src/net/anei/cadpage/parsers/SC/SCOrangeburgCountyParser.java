package net.anei.cadpage.parsers.SC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class SCOrangeburgCountyParser extends SmartAddressParser {

  private static final Pattern GRID_SLASH_PTN = Pattern.compile("\\bGRID (?:ON )?(\\d{1,2})/ ?([A-Z]\\d{1,2})\\b");
  private static final Pattern AT_MARK_PTN = Pattern.compile(" @ | AT ");
  private static final Pattern LAN_PTN = Pattern.compile("\\bLAN\\b");
  private static final Pattern INTERSECT_PTN = Pattern.compile(" *INTERSECTION (?:OF ) *");
  private static final Pattern GRID_PTN = Pattern.compile("\\bGRIDS?[ :]+(?:ON )?(\\d{1,2}[ -][A-Z]\\d{1,2})\\b");;
  private static final Pattern CROSS_PTN = Pattern.compile("(.*)\\bCROSS (?:OF )?+(.*)");
 
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
    body = GRID_SLASH_PTN.matcher(body).replaceAll("GRID $1-$2");
    String[] flds = body.split("/");
    
    int ipt = 0;
    int status = 0;
    while (true) {
      String addr = flds[ipt].trim();
      
      // If the first part has an @ or AT marker, that marks the beginning of the address
      StartType st = StartType.START_CALL;
      int flags = FLAG_START_FLD_REQ;
      Matcher match = AT_MARK_PTN.matcher(addr);
      if (match.find()) {
        data.strCall = append(data.strCall, "/", addr.substring(0,match.start()).trim());
        addr = addr.substring(match.end()).trim();
        st = StartType.START_ADDR;
        flags = 0;
      }
      addr = addr.replace(",", "");
      addr = LAN_PTN.matcher(addr).replaceAll("LN");
      addr = INTERSECT_PTN.matcher(addr).replaceAll(" ").trim();
      Result res = parseAddress(st, flags, addr);
      status = res.getStatus();
      if (status > STATUS_MARGINAL) {
        String call = data.strCall;
        data.strCall = "";
        res.getData(data);
        data.strCall = append(call, "/", data.strCall);
        flds[ipt] = res.getLeft();
        break;
      }
      data.strCall = append(data.strCall, "/", flds[ipt++]);
      if (ipt >= flds.length) { 
        data.strCall = "GENERAL ALERT";
        data.strPlace = body;
        data.strAddress = "";
        return true;
      }
    }
    
    // Intersections can get split across two fields
    if (status == STATUS_STREET_NAME && flds[ipt].length() == 0 && flds.length > ++ipt) {
      Result res = parseAddress(StartType.START_ADDR, flds[ipt].trim());
      if (res.isValid()) {
        String tmp = data.strAddress;
        data.strAddress = "";
        res.getData(data);
        data.strAddress = append(tmp, " & ", data.strAddress);
        flds[ipt] = res.getLeft();
      }
    }
    
    data.strAddress = stripFieldEnd(data.strAddress, " IN");
    
    // Now process the rest of the split fields
    for ( ; ipt<flds.length; ipt++) {
      String fld = flds[ipt].trim();
      if (fld.length() == 0) continue;
      if (data.strMap.length() == 0) {
        Matcher match = GRID_PTN.matcher(fld);
        if (match.find()) {
          data.strMap = match.group(1).replace(' ', '-');
          fld = append(fld.substring(0,match.start()).trim(), " ", fld.substring(match.end()).trim());
        }
      }
      
      Matcher match = CROSS_PTN.matcher(fld);
      if (match.matches()) {
        fld = match.group(1).trim();
        data.strCross = append(data.strCross, " & ", match.group(2));
      }  
      if (isValidAddress(fld)) {
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
