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

Contact: John Betts <philbert08@yahoo.com>
FRM:cayuga911@co.cayuga.ny.us\nSUBJ:From911Center\nMSG:\n04/20/11 13:51 3204 FRANKLIN STREET RD SENNETT Alarm - Fire\n

Contact: Christine Thurston <thurstce@gmail.com>
(From 911 Center) 06/15/11 00:03 215 CAYUGA ST UNION SPRINGS Cardiac  Call Number 467 was created from Call Number 462(Jun 14 2011 11:20PM)  stried the pho

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
    "MENTZ", "PORT BYRON",
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
    
    if (!subject.equals("From 911 Center") &&
        !subject.equals("From911Center")) return false;
    Parser p = new Parser(body);
    p.get(' ');
    p.get(' ');
    parseAddress(StartType.START_ADDR, p.get(), data);
    data.strCall = getLeft();
    if (data.strCall.length() > 30) {
      data.strSupp = data.strCall;
      data.strCall = "";
    }
    return true;
  }
  
}
	