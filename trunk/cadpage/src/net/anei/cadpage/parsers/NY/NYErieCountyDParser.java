package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
CLA 10990 Keller Rd. EMS 80M slurred speech
CLA 9970 Greiner Rd. EMS Finger laceration
CLA 5727 Marthas Vineyard EMS 55 y/o fell
CLA 5945 Vinecroft Dr. EMA apt. 401
CLA Salt rd. & County rd. MVA. 1/2 mile north of county.
CLA 5955 Elm St. EMS
CLA 9690 Clarence Center Rd. EMS

Contact: "Buttino, John" <John.Buttino@erie.gov>   (network administrator)
AMH 238 WESTFIELD RD EMS 79 YO F/  CHEST PAIN
AMH 52 ENDICOTT DR EMS 82 YO M
AMH 670 LONGMEADOW RD EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING
AMH 3030 SHERIDAN DR EMS RM 146 58 M TROUBLE BREATHING
AMH 35 ELM RD EMS 69M CHEST/ARM PAIN

Contact: brad marshall <northspartans@gmail.com>
Sender: 777075442231
ALERT@ERIE.GOV AMH KLEIN W RD&FOREST N RD MVA 2 CAR MVA - HEAD INJURY

Contact: Michael Grant <mike18435@gmail.com>
Sender: ALERT@ERIE.GOV
ALERT@ERIE.GOV WMV 5403 MAIN ST EMA APT 308 /

*/


public class NYErieCountyDParser extends MsgParser {

  private static final Pattern MASTER = Pattern.compile("([A-Z]{3}) (.*?) ((?:EMS|EMA|MVA)\\b.*)");
  
  public NYErieCountyDParser() {
    super("ERIE COUNTY", "NY");
  }

  @Override
  protected boolean parseMsg(String body, Data data) { 

    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    String city = CITY_CODES.getProperty(match.group(1));
    if (city == null) return false;
    data.strCity = city;
    parseAddress(match.group(2).trim(), data);
    data.strCall = match.group(3).trim();
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CLA", "CLARENCE",
      "AMH", "AMHERST",
      "WMV", "WILLIAMSVILLE"
  });
}
	