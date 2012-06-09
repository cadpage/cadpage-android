package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
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

Contact: Doug Yurecko <dyurecko5u@gmail.com>
Sender: 911dispatch@embarqmail.com
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:MOTOR VEHICLE ACCIDENT WITH INJURY  DYER ST & W HISTORIC 66, Apt. UNIT WAYNESVILLE\n(Con't) 2 of 2\nCrossStreets: WPD M25 WRFD1 Call Received Time: 6/8/2012 07:44:22 Dispatch: 6/8/2012 07:46:06\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:NATURAL COVER FIRE  TEMPORAL RD, Apt. UNIT PULASKI COUNTY CrossStreets: WRFD1 Call\n(Con't) 2 of 2\nReceived Time: 6/6/2012 11:27:42 Dispatch: 6/6/2012 11:30:25\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:FALLS/ ACCIDENTS  LONGVIEW LN & HIGHWAY 17 PULASKI COUNTY CrossStreets: M22 WRFD1\n(Con't) 2 of 2\nCall Received Time: 6/6/2012 07:10:40 Dispatch: 6/6/2012 07:16:16\r\n\r\n\r\n\r\n(End)

*/


public class MOPulaskiCountyParser extends FieldProgramParser {
  
  public MOPulaskiCountyParser() {
    super(CITY_TABLE, "PULASKI COUNTY", "MO",
           "ADDR/SC! CrossStreets:X! Call_Received_Time:SKIP! Dispatch:DATETIME");
  }
  
  @Override
  public String getFilter() {
    return "911dispatch@embarqmail.com";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String[] parts = field.split("  +");
      if (parts.length == 3) {
        data.strCall = parts[0];
        parseAddress(cleanAddress(parts[1]), data);
        data.strCity = parts[2];
      } else if (parts.length == 2) {
        data.strCall = parts[0];
        parseAddress(StartType.START_ADDR, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, cleanAddress(parts[1]), data);
      } else {
        super.parse(cleanAddress(field), data);
      }
      
      if (data.strCity.equalsIgnoreCase("PULASKI COUNTY")) data.strCity = "";
      if (data.strAddress.endsWith(" UNIT")) {
        data.strAddress = data.strAddress.substring(0, data.strAddress.length()-5).trim();
      }
      if (data.strApt.endsWith("UNIT")) {
        data.strApt = data.strApt.substring(0, data.strApt.length()-4).trim();
      }
    }
    
    private String cleanAddress(String addr) {
      return addr.replace(" - ", "APT: ").replace(",", " ");
    }
  }
  
  // Unit codes will be nnnn, or xFDn, or Mnn
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(\\d{4}|[A-Z]{1,2}[FP]D\\d|M\\d\\d)\\b");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      
      // Cross street field contains cross streets and units and extra stuff that we discard
      Matcher match = UNIT_PTN.matcher(field);
      if (!match.find()) {
        data.strCross = field;
      } else {
        data.strCross = field.substring(0,match.start()).trim();
        data.strUnit = field.substring(match.start());
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X UNIT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
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
}
