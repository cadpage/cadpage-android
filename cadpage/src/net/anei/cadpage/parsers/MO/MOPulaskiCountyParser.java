package net.anei.cadpage.parsers.MO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Pulaski County, MO (and Laclede County)
Contact: "Mike Garrett" <hfpd.1835@yahoo.com>
Sender:911dispatch@embarqmail.com

There is code to unscramble these in MILivingstonCountyParser.  Move it to base
parser class.
Units will be 4 digits, or xFDn or Mnn.  Break at first one found

 1 of 3\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n(Con't) 2 of 3\n17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n(Con't) 3 of 3\nReceived Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)

STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29
STRUCTURE FIRE RESIDENTIAL  27465 SINGLE DR UNIT PULASKI COUNTY CrossStreets: Highway AA 0.30 mi N HFD1 Call Received Time: 12/13/2010 5:05:49 Dispatch: 12/13/2010 5:07:30
BREATHING DIFFICULTY  32064 ROUTE 66   CrossStreets: HFD1 Call Received Time: 12/8/2010 03:01:30 Dispatch: 12/8/2010 03:01:49
MOTOR VEHICLE ACCIDENT WITH INJURY  150 I-44 EAST UNIT PULASKI COUNTY CrossStreets: HFD2 Call Received Time: 12/6/2010 22:25:49 Dispatch: 12/6/2010 22:28:11
STRUCTURE FIRE RESIDENTIAL  30684 HIGHWAY AB - V2W UNIT RICHLAND CrossStreets: HFD1 Call Received Time: 12/5/2010 03:31:42 Dispatch: 12/5/2010 03:34:35
VEHICLE FIRE  28795 HIGHWAY 17  PULASKI COUNTY CrossStreets: Sassafras Ln 0.12 mi SHighway AB 0.27 mi NE HFD1 Call Received Time: 12/3/2010 02:07:51 Dispatch: 12/3/2010 02:08:38
 
*/


public class MOPulaskiCountyParser extends SmartAddressParser {

  private static final String[] KEYWORDS = 
    new String[]{"MSG", "CrossStreets", "Call Received Time", "Dispatch"};
  
  private static final String[] CITY_TABLE = new String[]{
    "PULASKI COUNTY",
    "BIG PINEY",
    "CROCKER",
    "DEVILS ELBOW",
    "DIXON",
    "GASCOZARK",
    "HOOKER",
    "LAQUEY",
    "RICHLAND",
    "ST ROBERT",
    "SWEDEBORG",
    "WAYNESVILLE"
  };
  
  // Unit codes will be nnnn, or xFDn, or Mnn
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(\\d{4}|[A-Z]{1,2}FD\\d|M\\d\\d)\\b");
  
  public MOPulaskiCountyParser() {
    super(CITY_TABLE, "PULASKI COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "911dispatch@embarqmail.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains(" CrossStreets:")) return false;
    
    Properties props = parseMessage("MSG:" + body, KEYWORDS);
    
    // Parse call description and address
    String sAddr = props.getProperty("MSG", "");
    parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, sAddr, data);
    
    // Strip out extraneous address text
    int pt = data.strAddress.indexOf(" - ");
    if (pt >= 0) data.strAddress = data.strAddress.substring(0, pt).trim();
    if (data.strAddress.endsWith(" UNIT")) {
      data.strAddress = data.strAddress.substring(0, data.strAddress.length()-5).trim();
    }
    
    // Cross street field contains cross streets and units and extra stuff that we discard
    String fld = props.getProperty("CrossStreets", "");
    Matcher match = UNIT_PTN.matcher(fld);
    if (!match.find()) {
      data.strCross = fld;
    } else {
      data.strCross = fld.substring(0,match.start()).trim();
      data.strUnit = fld.substring(match.start());
    }
    
    return true;
  }
}
