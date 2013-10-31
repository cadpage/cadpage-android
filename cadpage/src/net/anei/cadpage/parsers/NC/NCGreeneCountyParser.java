
package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCGreeneCountyParser extends DispatchSouthernParser {

  public NCGreeneCountyParser() {
    super(CITY_LIST, "GREENE COUNTY", "NC", 0);
  }
  
  @Override
  public String getFilter() {
    return "@Greenecountync.com,";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (! super.parseMsg(body, data)) return false;
    if (data.strAddress.startsWith("0 ")) data.strAddress = data.strAddress.substring(2).trim();
    return true;
  }
  
  @Override
  protected void parseExtra(String sExtra, Data data) {
    Matcher match = EXTRA_PTN.matcher(sExtra);
    if (match.find()) {
      data.strSupp = sExtra.substring(match.end()).trim();
      sExtra = sExtra.substring(0,match.start()).trim();
    }
    data.strCall = sExtra;
  }
  private static final Pattern EXTRA_PTN = Pattern.compile(" (?=MA ?\\d:)");
  
//Flag indicating that the call ID is optional
  public static final int DSFLAG_ID_OPTIONAL = 0x08;

  private static final String[] CITY_LIST = new String[]{
    "HOOKERTON",
    "SNOW HILL",
    "WALSTONBURG",
    
    //Townships
    "BULL HEAD",
    "CARRS",
    "HOOKERTON",
    "JASON",
    "OLDS",
    "ORMONDSVILLE",
    "SHINE",
    "SNOW HILL",
    "SPEIGHTS BRIDGE" };
  
}
