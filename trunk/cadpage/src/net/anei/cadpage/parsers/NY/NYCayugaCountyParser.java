package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


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

Contact: Corey <crooker1@twcny.rr.com>
(From 911 Center) 08/27/11 02:10 RIVER RD RT 38 CONQUEST MVAPI  subject came into bar  bloody states car accident   pirates landing bar  mvapi   believes
(From 911 Center) 08/27/11 00:42 HEJAMADA CAMPGROUND764 MC DONALD RD MONTEZUMA General Illness  mohawk section    off to left after gate  68 yo f   left a
(From 911 Center) 08/26/11 14:49 8860 S  WILLOW ST WEEDSPORT General Illness  60 Y/O FEMALE  CALLER STATES SHE NEEDS TO GO TO ST JOES PER HER DR... ABDOME
(From 911 Center) 08/26/11 09:59 8860 S  WILLOW ST WEEDSPORT Injury from a Fall  70 FEMALE FELL YESTERDAY/DIFF AMBULATING TODAY  E911 Info - Class of Serv
(From 911 Center) 08/24/11 22:00 8750 CENTERPORT RD MENTZ Cardiac  79 Y/O FEMALE CHEST PAINS...  DERBY RESIDENCE

Should be general alert
(From 911 Center) ANY MEMBER THAT CAN DEPLOY FOR SEFU ON SUNDAY CONTACT ASST. CHF SABIN ON HIS CELLPHONE ASAP

*/


public class NYCayugaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d ");

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
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    parseAddress(StartType.START_ADDR, body, data);
    data.strCall = getLeft();
    if (data.strCall.length() > 30) {
      data.strSupp = data.strCall;
      data.strCall = "";
    }
    return true;
  }
  
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
  
}
	