package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Englewood, OH (In Montgomery county)
Contact: Zach Marvin <zchmrvn11@gmail.com>
Sender: CAD@englewood.oh.us
System: CMI

Our pages consist of the units first. Any numbers (Ex: 630, 924, 821) are police 
units, all others are the fire units with the first letter being the city (Ex: EE98 
is Englewood Engine 98). Also something that may be helpful is at the end of the 
page there is the city that the address is located in based off of Google Maps. 
If you have a way to incorporate that into the alert that would be cool because 
if we go mutual aid to another city Google Maps may have some trouble finding the 
location if Englewood is in it. If you need pages from Farmersville or New Lebanon 
let me know because I don't get those to my phone (I'd have to pull them off of our 
server). The one labeled with **** are Union pages (One was a structure fire that 
Englewood was also dispatched to as Automatic Mutual Aid (AMAR)). 
After the time you will notice our call codes. This is after the - and the first 
code is a police code, second code is the fire code. 45 for police is a medic call 
assist. E45 is an Englewood (because of the E) Medic Call. We have a small list 
of about 8 fire codes in all maybe less. If for some reason you would want them 
I can get them to you. The email address that sends the pages is CAD@englewood.oh.us

CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n622 EE98 EM98 OP72:12:31:00-53B:E53:2 VEH ACC UNK INJ:@9200 N MAIN ST,DAYTON:FDC SOUTH WALL\n\n
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n630 632 EM98:16:10:00-45:E45:MEDIC/SUICIDAL SUBJECT:@9000 N MAIN ST UNIT 300,DAYTON: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n622 EE98 EM98 OP72:12:31:00-53B:E53:2 VEH ACC UNK INJ:@9200 N MAIN ST,DAYTON:FDC SOUTH WALL 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n620 621 622 EM99:13:34:00-45:E45:MEDIC/CALLER ON SCENE FOR EVAL-PINK SLIP - SUBJ HAS MEDICAL PROBLEMS AND MENTAL ISSUES:@1100 TAYWOOD RD UNIT 14,ENGLEWOOD: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\nEE99 EL98 OP72 UE81 UE82:03:42:00-43:U43:POSS STRUCTURE FIRE:@426 APPLEGATE CT,UNION: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n631 EE98 EM99 OP72:22:13:00-53B:E53:POSS INJ CRASH:@NATIONAL RD@MAIN ST,ENGLEWOOD: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n924 UE81:14:02:00-43:U46:CHECK NORTH SIDE OF THE ROAD FOR A POSS FIELD FIRE:@RINEHART RD@SWEET POTATO RIDGE RD,CLAYTON: 
FRM:CAD@englewood.oh.us\nMSG:630 EM98:15:51:00-45:E45:MEDIC - 65YOF BACK DOOR SHORTNESS OF BREATH EXTREME PAIN ALL OVER :@322 HEATHER ST UNIT 6,ENGLEWOOD:\r\n

 */


public class OHEnglewoodParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^:]+?):(\\d\\d:\\d\\d:\\d\\d)-([A-Z0-9]+:[A-Z0-9]+):([^:?]+):@([^,]+?),([A-Z ]+?):(.*)");
  
  public OHEnglewoodParser() {
    super("ENGLEWOOD", "OH");
  }
  
  @Override
  public String getFilter() {
    return "CAD@englewood.oh.us";
  }
  
  @Override
  public String getLocName() {
    return "Englewood Regional Communications, OH";
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1).trim();
    data.strTime =match.group(2).trim();
    data.strCode = match.group(3).trim();
    data.strCall = match.group(4).trim();
    String sAddr = match.group(5).trim().replace("@", " & ");
    parseAddress(sAddr, data);
    data.strCity = match.group(6).trim();
    data.strSupp = match.group(7).trim();
    return true;
  }
}
