package net.anei.cadpage.parsers;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/* Sample Harris Page

Contact: chris pivonka <cpivonka87@gmail.com>
Sender: CommCenter@ccems.com <From%3ACommCenter@ccems.com>

1of2:09/06 11:28 19707 WOOD WALK LN, ; Map:337U Sub:PINEHURST OF ATASCOCITA Nat:09E01-ARREST - NOT BREATHING Units:E-M19 E-M29 E-7900
1of2:09/05 08:56 19226 AQUATIC DR, ; Map:378A Sub:WALDEN ON LAKE HOUSTON Nat:52B01G-FIRE ALARM - RESIDENTIAL Units:ATFD E-E39 X-
1of2:09/04 19:45 17219 KOBUK VALLEY CIR, ; Map:377E Sub:EAGLE SPRINGS Nat:67B03U-OUTSIDE FIRE - INVESTIGA Units:E-E39 X-St:*** Dead
1of2:09/03 08:14 LILES LN/WOODLAND HILLS DR, ; Map:376H Sub:ATASCOCITA FOREST Nat:29-MOTOR VEHICLE INCIDENT Units:E-M19 E-E39 X-
11/15 11:28 19506 SWEETGUM FOREST DR, ; Map:337V Sub:PINEHURST OF ATASCOCITA Nat:28B01U-STROKE/CVA - UNKNOWN Units:E-E39 X-St:TWELFTH FAIRWAY *** Dead
11/13 13:12 6918 ATASCA CREEK DR, ; Map:377C Sub:ATASCA WOODS Nat:52B01G-FIRE ALARM - RESIDENTIAL Units:ATFD E-E39 X-St:LEENS LODGE LN FOUNTAIN L
11/13 02:18 E FM 1960/DINERO DR, ; Map:337Z Sub: Nat:29D02M-MVI - PEDESTRIAN Units:E-M19 E-E39 E-B39 X-St:DINERO DR E FM 1960
11/13 02:17 E FM 1960/DINERO DR, ; Map:337Z Sub: Nat:29-MOTOR VEHICLE INCIDENT Units:E-M19 E-E39 X-St:DINERO DR E FM 1960
11/12 18:24 Repage: 8922 PINE SHORES DR, ; Map:338S Sub:ATASCOCITA SHORES Nat:60B02-GAS LEAK - UNKNOWN Units:E-E19 X-St:SHOREVIEW LN SUNCOVE LN
11/12 18:08 Repage: ATASCOCITA RD/TIMBER FOREST D, ; Map:377A Sub: Nat:29-MOTOR VEHICLE INCIDENT Units:HUM2 E-E29 X-St:TIMBER FOREST DR ATASCOCI
11/12 17:31 E FM 1960/POSSUM PARK RD, ; Map:336T Sub: Nat:68C01-HEAVY SMOKE OUTSIDE Units:E-E39 E-B39 X-St:POSSUM PARK RD E FM 1960
11/19 17:00 OAK HOLLOW DR-HC/GRANT RD-HC, ; Map:369E Nat:67B01U-SMALL OUTSIDE FIRE Units:E21 E26 B22 X-St:GRANT RD WILLOW LN
11/28 12:49 6006 WOODMANCOTE DR-HC, ; Map:337X- Nat:27-STABBING / SHOOTING Units:E-M29 X-St:DANALYN CT CLOYANNA LN

1of2:09/06 11:56 W HILLSIDE DR/EASTEX FRWY, ; Map:414D Sub: Nat:MA-MUTUAL AID / ASSIST AGENCY Units:E91 T81 T73 E-L19 X-St:EASTEX
12/07 12:26 14231 CELLINI DR-HC, ; Map:368P- Nat:MA-MUTUAL AID / ASSIST AGENCY Units:MUTAID E24 X-St:TERREBONE DR BONAPARTE DR
12/08 17:53 13830 ROSETTA DR-HC, ; Map:368P- Nat:MA-MUTUAL AID / ASSIST AGENCY Units:MUTAID E22 X-St:BELLA DR LA BARRE DR
*/

public class TXCyCreekCommCenterParser extends SmsMsgParser {
  
  private static final Pattern MARKER = Pattern.compile("\\d\\d/\\d\\d \\d\\d:\\d\\d ");
  
  @Override
  public String getFilter() {
    return "CommCenter@ccems.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
  
    data.defState="TX";
    data.defCity="HARRIS COUNTY";
    
    // Strip message prefix
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    int ipt = match.end();
    body = body.substring(ipt);
    if (body.startsWith("Repage: ")) body = body.substring(8);
    body = "Loc:" + body;
    
    Properties props = parseMessage(body, new String[]{"Map", "Sub", "Nat", "Units", "X-St"});
    String sAddr = props.getProperty("Loc", "");
    ipt = sAddr.indexOf(',');
    if (ipt > 0) sAddr = sAddr.substring(0, ipt).trim();
    parseAddressCity(sAddr, data);
    if (data.strCity.equals("HC")) data.strCity = "";
    
    data.strMap = props.getProperty("Map", "");
    data.strPlace = props.getProperty("Sub", "");
    data.strCall = props.getProperty("Nat", "");
    data.strUnit = props.getProperty("Units", "");
    data.strCross = props.getProperty("X-St", "");
    
    if (data.strCall.contains("MA-MUTUAL AID")) data.strCity = "HOUSTON";
    return true;
  }
}
