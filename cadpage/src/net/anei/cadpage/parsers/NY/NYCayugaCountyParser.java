package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


/*
Cayuga County, NY
Contact: Corey <crooker1@twcny.rr.com>
Sender: cayuga911@co.cayuga.ny.us

(From 911 Center) 02/14/11 16:26 5 CEDAR LN BRUTUS Cardiac
(From 911 Center) 02/14/11 14:59 8318 W  LOOP RD MONTEZUMA General  
(From 911 Center) 02/14/11 12:19 PINE ST PARK ST PORT BYRON Collapse
(From 911 Center) 02/14/11 10:29 7 EVERGREEN LN BRUTUS Stroke

*/


public class NYCayugaCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_LIST = new String[]{

    "AUBURN",
    "AURELIUS", "CAYUGA",
    "BRUTUS", "WEEDSPORT",
    "CATO", "MERIDIAN", "CATO",
    "CONQUEST", 
    "FLEMING",
    "GENOA",
    "IRA",
    "LEDYARD", "AURORA",
    "LOCKE",
    "MENTZ", "PORT BRYON",
    "MONTEZUMA",
    "MORAVIA", "MORAVIA",
    "NILES", 
    "OWASCO",
    "SCIPIO",
    "SEMPRONIUS",
    "SENNETT",
    "SPRINGPORT", "UNION SPRINGS",
    "STERLING", "FAIR HAVEN",
    "SUMMERHILL",
    "THROOP",
    "VENICE",
    "VICTORY"
  };

  public NYCayugaCountyParser() {
    super(CITY_LIST, "CAYUGA COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "cayuga911@co.cayuga.ny.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equalsIgnoreCase("From 911 Center")) return false;
    Parser p = new Parser(body);
    p.get(' ');
    p.get(' ');
    parseAddress(StartType.START_ADDR, p.get(), data);
    data.strCall = getLeft();
    return true;
  }
  
}
	