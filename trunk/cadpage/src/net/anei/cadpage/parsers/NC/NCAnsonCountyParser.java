
package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/*
Anson County, NC
Contact: support@active911.com
Sender: Ansonville Fire <chyatt@ansonvillefire.com>
Sender: <notifyuser@co.anson.nc.us>

1078 SALISBURY ST WADESBORO 2012007703 14:09:41 FIRE STRUCTURE MA 1: ST3 LVILLE MA 2: ST6 POLKTON
0 US HWY 52 N ANSONVILLE 2012007859 15:02:58 ACCIDENT - PERSONAL INJURIES GREY IMPALA IN WOODS
264 MARTIN ST ANSONVILLE MDL 26O21 2012007878 18:02:33 AMBULANCE NEEDED JENNY TYSON MA1: ST 8 BVILLE MA2: ST 6 POLKTON
3263 RANDALL RD POLKTON MDL 10C02 2012007984 16:07:15 CHEST PAIN MA1: ST 8 BVILLE MA2: ST 6 POLKTON
388 JACKS BRANCH RD WADESBORO MDL 10D04 2012007967 07:16:47 CHEST PAIN MA1: ST 8 BVILLE MA2: ST 6 POLKTON


*** NOT PARSING YET ***
Sender: Chris Hyatt <hyatt2377@yahoo.com>
9145 US HWY 52 North Ansonville  test Structure fire test page only
1981 Randall rd polkton nc\nFire Alarm Test
1981 Randall Rd.\nPolkton NC\nFire Alarm Test Click on link to see map. text me if it works
ANSONVILLE 201220119191 FIRE STRUCTURE test test MA 1 ST3 LVILLE MA 2 ST6 POLKTON\n1078 SALISBURY ST

*/


public class NCAnsonCountyParser extends DispatchSouthernParser {

  public NCAnsonCountyParser() {
    super(CITY_LIST, "ANSON COUNTY", "NC", 0);
  }
  
  @Override
  public String getFilter() {
    return "chyatt@ansonvillefire.com,notifyuser@co.anson.nc.us";
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

  private static final String[] CITY_LIST = new String[]{
    "ANSONVILLE",
    "LILESVILLE",
    "MCFARLAN",
    "MORVEN",
    "NORTH ANSONVILLE",
    "PEACHLAND",
    "POLKTON",
    "WADESBORO"
  };
}
