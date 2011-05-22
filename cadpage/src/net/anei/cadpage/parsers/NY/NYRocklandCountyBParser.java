package net.anei.cadpage.parsers.NY;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Rockland County, NY (alternate)
Contact: Matthew Stritmater <m.stritmater@sloatsburgfire.org>
Sender: 44_Control@verizon.net

[Department/Unit #]  -  [Incident Type]    [Address]  Cross: [Cross Street 1] / [Cross Street 2] [Time] [Dispatcher #] - [Dispatcher Name]

15  -  STRUCTURE FIRE    94 ORANGE TRNPK  CROSS: MUNICIPAL PLZ / LIBERTY ROCK RD 17:03 30 - MANN
15  -  UNKNOWN TYPE - OUTSIDE    265 ORANGE TRNPK  CROSS: UNKNOWN / PARK AV 13:40 50 - HUMPHREY
15  -  VEHICLE FIRE   TWAY 34.6 NB  CROSS: UNKNOWN / NEW YORK STATE THWY N, NEW YORK STATE THRUWAY - 87 N 13:40 90 - FRIDHANDLER
15  -  VEHICLE FIRE   TWAY - SLOATSBURG REST AREA  CROSS: NEW YORK STATE THRUWAY - 87 N, NEW YORK STATE THRUWAY - 87 / NEW YORK STATE THRUWAY - 87, NEW YORK STATE THRUWAY - 87 N 17:13 22- BERTOLACCI
15  -  FLOODING CONDITION    23 SEVEN LAKES DR  CROSS: ALLEN LN / WALDRON TERR 07:37 71 - O'KEEFFE
15  -  BRUSH/MULCH/RUBBISH OUTSIDE    18 COLONIAL AV  CROSS: POTHAT ST / RICHARD ST 15:12 35 - BATES
15  -  VEHICLE FIRE    2 STERLING MINE RD  CROSS: ARCADIA CT, CRANBERRY RD / ARCADIA CT 19:40 10 - DELUCIA
15  -  OVEN/APPLIANCE/COOKING FIRE    151 ORANGE TRNPK  CROSS: LEDGE RD / POST RD 18:07 22- BERTOLACCI
15  -  ASSIST POLICE OR EMS    15 RICHARD ST  CROSS: COLONIAL AV / STERLING AV 06:50 71 - O'KEEFFE

*/

public class NYRocklandCountyBParser extends SmsMsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^ ]+) +- +(.*?)   +(.*?) +CROSS: *(.*?) \\d\\d:\\d\\d \\d\\d.*");
  
  public NYRocklandCountyBParser() {
    super("ROCKLAND COUNTY","NY");
  }

  @Override
  public String getFilter() {
    return "44_Control@verizon.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1);
    data.strCall = match.group(2);
    data.strAddress = match.group(3);
    data.strCross = match.group(4);
    return true;
  }
}
