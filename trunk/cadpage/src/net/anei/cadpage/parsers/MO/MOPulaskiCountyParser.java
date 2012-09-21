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
 1 of 3\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:UNCONSCIOUS/UNRESPONSIVE  21501 HIGHWAY 28, Apt. UNIT PULASKI COUNTY CrossStreets:\n(Con't) 2 of 3\nHawk Dr 0.01 mi NE Private Dr 0.16 mi NW M22 WRFD1 Call Received Time: 6/10/2012 09:19:51 Dispatch: 6/10/2012 09:21:29 Dispatch:\n(Con't) 3 of 3\n6/10/2012 09:21:29\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:MOTOR VEHICLE ACCIDENT WITH INJURY  101 DISCOVERY DR, Apt. UNIT WAYNESVILLE\n(Con't) 2 of 2\nCrossStreets: Lowe Av 0.02 mi N 707 WRFD1 Call Received Time: 6/13/2012 18:59:14 Dispatch: 6/13/2012 19:01:33\r\n\r\n\r\n\r\n(End)
 1 of 2\nFRM:911dispatch@embarqmail.com\nSUBJ:DO NOT REPLY\nMSG:NATURAL COVER FIRE  15365 TOP DR PULASKI COUNTY CrossStreets: Turkey Dr 0.10 mi SE\n(Con't) 2 of 2\nTrue Rd 0.24 mi SW WRFD1 Call Received Time: 7/1/2012 21:38:25 Dispatch: 7/1/2012 21:40:28\r\n\r\n\r\n\r\n(End)

Contact: Active911
[DO NOT REPLY] Call Number: 266654 \r\nMOTOR VEHICLE ACCIDENT WITH INJURY \r\nDispatch: 8/3/2012 22:09:56 \r\nAckldge: 22:10:03 \r\n\r\n\r\n\r\n\r\nClear: 23:40:44 \r\nComplete: 23:51:16\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] Call Number: 266893 \r\nDIABETIC \r\nDispatch: 8/5/2012 16:39:31 \r\nAckldge: 16:39:33 \r\nEnroute: 16:45:08 \r\nOnScene: 16:46:40 \r\n\r\n\r\nClear: 16:51:31 \r\nComplete: 16:54:29\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] Call Number: 266943 \r\nSTRUCTURE FIRE RESIDENTIAL \r\nDispatch: 8/6/2012 00:19:09 \r\nAckldge: 0:20:18 \r\n\r\n\r\n\r\n\r\n\r\nComplete: 0:32:53\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] Call Number: 266964 \r\nNATURAL COVER FIRE \r\nDispatch: 8/6/2012 10:20:06 \r\nAckldge: 10:24:09 \r\nEnroute: 10:29:19 \r\n\r\n\r\n\r\nClear: 11:13:41 \r\nComplete: 11:13:42\r\n\r\n\r\n\r\n\r\n\r\n

[DO NOT REPLY] MOTOR VEHICLE ACCIDENT WITH INJURY  MARIES COUNTY 630 MARIES COUNTY CrossStreets: MARIES MSHP1 MSHP2 DAD DFD1 Call Received Time: 8/3/2012 21:43:40 Dispatch: 8/3/2012 22:09:56\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] NATURAL COVER FIRE  11000 CYPRESS RD PULASKI COUNTY CrossStreets: N Highway 133 0.01 mi N Conway Rd 0.14 mi W DFD1 Call Received Time: 8/4/2012 02:48:10 Dispatch: 8/4/2012 02:49:49\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] FIRE ALARM - COMMERCIAL  11752 HIGHWAY MM PULASKI COUNTY CrossStreets: Highway 28 0.55 mi NW Private Dr 1.10 mi SE DFD1 Call Received Time: 8/4/2012 06:27:56 Dispatch: 8/4/2012 06:29:17\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] DIABETIC  204 SUNSET RD DIXON CrossStreets: Dale Ln 0.05 mi E Lang St 0.07 mi W DAD M31 DFD1 Call Received Time: 8/5/2012 16:27:13 Dispatch: 8/5/2012 16:39:31\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] STRUCTURE FIRE RESIDENTIAL  16202 BUTTERCUP RD PULASKI COUNTY CrossStreets: Bangor Rd 0.28 mi S Highway HH 0.63 mi NE M23 CFD1 TCFD1 PCSD1 1501 1552 1351 1562 1361 WRFD1 DFD1 Call Received Time: 8/6/2012 00:03:55 Dispatch: 8/6/2012 00:19:09\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] NATURAL COVER FIRE  HIGHWAY 28 PULASKI COUNTY CrossStreets: DFD1 Call Received Time: 8/6/2012 10:18:26 Dispatch: 8/6/2012 10:20:06\r\n\r\n\r\n\r\n\r\n\r\n
[DO NOT REPLY] OVERDOSE/POISONING  208 WILLOW ALY, Apt. A DIXON CrossStreets: N Walnut st 6332.73 mi W N Oak St 6332.82 mi W DAD M31 DFD1 Call Received Time: 8/6/2012 19:18:17 Dispatch: 8/6/2012 19:43:03\r\n\r\n\r\n\r\n\r\n\r\n

*/


public class MOPulaskiCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("\nComplete: *\\d{1,2}:\\d{1,2}:\\d{1,2}$");
  
  public MOPulaskiCountyParser() {
    super(CITY_TABLE, "PULASKI COUNTY", "MO",
           "ADDR/SC! CrossStreets:X! Call_Received_Time:SKIP! Dispatch:DATETIME Dispatch:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "911dispatch@embarqmail.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (RUN_REPORT_PTN.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE";
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
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(\\d{4}|[A-Z]{1,2}[FP]D\\d?|M\\d\\d|MARIES|DAD)\\b");
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
