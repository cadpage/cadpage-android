package net.anei.cadpage.parsers.CA;

import java.util.Arrays;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Shasta County, CA
 */
public class CAShastaCountyParser extends SmartAddressParser {
  
  public CAShastaCountyParser() {
    super("SHASTA COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "vtext.com@gmail.com,5304482408,5304109246";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] flds = body.replace('\n', ' ').trim().split(" *; *");
    if (flds.length < 6) return false;
    
    String[] addressList = new String[3];
    
    data.strCall = flds[0];
    Parser p = new Parser(flds[1]);
    addressList[0] = p.get(',');
    data.strSource = p.get();
    addressList[1] = flds[2];
    addressList[2] = flds[3];
    
    // Life gets complicated, we have three address fields, but the best address
    // is not necessarily the first.  Sort them by address quality, the first
    // one will be the address, others will be cross streets
    AddrStat[] statList = new AddrStat[3];
    for (int j = 0; j< 3; j++) {
      statList[j] = new AddrStat(addressList[j]);
    }
    Arrays.sort(statList);
    parseAddress(statList[0].address, data);
    data.strCross = append(statList[1].address, " & ", statList[2].address);
    
    // Parse rest of fields
    if (!flds[4].startsWith("Map:")) return false;
    data.strMap = flds[4].substring(5).trim();
    
    if (!flds[5].startsWith("Inc# ")) return false;
    data.strCallId = flds[5].substring(5).trim();
    
    if (flds.length <= 6) return true;
    data.strUnit = flds[6];
    
    if (flds.length <= 7) return true;
    data.strSupp =flds[7];
    
    return true;
  }
  
  private class AddrStat implements Comparable<AddrStat>{
    String address;
    int status;
    
    AddrStat(String address) {
      this.address = address;
      this.status = -1;
      if (address.length() == 0) return;
      
      this.status = checkAddress(address);
      if (!address.contains("BLK")) this.status += 100;
      if (!address.contains("/")) this.status += 10;
    }

    @Override
    public int compareTo(AddrStat adst) {
      return -(this.status - adst.status);
    }
  }
}
