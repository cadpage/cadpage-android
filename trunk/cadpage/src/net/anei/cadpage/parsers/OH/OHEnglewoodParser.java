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

CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n622 EE98 EM98 OP72:12:31:00-53B:E53:2 VEH ACC UNK INJ:@9200 N MAIN ST,DAYTON:FDC SOUTH WALL\n\n
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n630 632 EM98:16:10:00-45:E45:MEDIC/SUICIDAL SUBJECT:@9000 N MAIN ST UNIT 300,DAYTON: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n622 EE98 EM98 OP72:12:31:00-53B:E53:2 VEH ACC UNK INJ:@9200 N MAIN ST,DAYTON:FDC SOUTH WALL 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n620 621 622 EM99:13:34:00-45:E45:MEDIC/CALLER ON SCENE FOR EVAL-PINK SLIP - SUBJ HAS MEDICAL PROBLEMS AND MENTAL ISSUES:@1100 TAYWOOD RD UNIT 14,ENGLEWOOD: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\nEE99 EL98 OP72 UE81 UE82:03:42:00-43:U43:POSS STRUCTURE FIRE:@426 APPLEGATE CT,UNION: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n631 EE98 EM99 OP72:22:13:00-53B:E53:POSS INJ CRASH:@NATIONAL RD@MAIN ST,ENGLEWOOD: 
CAD@englewood.oh.us\nSUBJ:<No Subject>\nMSG:\n924 UE81:14:02:00-43:U46:CHECK NORTH SIDE OF THE ROAD FOR A POSS FIELD FIRE:@RINEHART RD@SWEET POTATO RIDGE RD,CLAYTON: 
FRM:CAD@englewood.oh.us\nMSG:630 EM98:15:51:00-45:E45:MEDIC - 65YOF BACK DOOR SHORTNESS OF BREATH EXTREME PAIN ALL OVER :@322 HEATHER ST UNIT 6,ENGLEWOOD:\r\n

FRM:CAD@englewood.oh.us\nMSG:EM98:12:53:13-45::MEDIC/ 65 YOF, STOMACH PAINS:@824 HILE LN,ENGLEWOOD:\r\n
 1 of 2\nFRM:CAD@englewood.oh.us\nMSG:EE98 EM98 OP72:17:04:27-53B::2 VEH CRASH - 1 VEH ON SIDE:@404 W NATIONAL RD,ENGLEWOOD:KEYBOX FRONT DOOR LEFT,\n(Con't) 2 of 2\nFDC SE CORNER IN FENCE\r\n(End)
FRM:CAD@englewood.oh.us\nMSG:EM98:22:35:24-45:E45:MUTUAL AID MEDIC/ MALE WITH FEVER, X OF JEFFERSON BY JAY:@139 NORTH STREET,:\r\n
1 of 2\nFRM:CAD@englewood.oh.us\nMSG:EM98:08:30:44-45:E45:MEDIC CALL - SHORTNESS OF BREA:@9000 N MAIN ST UNIT G35,DAYTON:CANCER CENTER CALLS GO TO\n(Con't) 2 of 2\nCANCER CENTER\r\nLAKESIDE AMB ENTRANCE FOR BSMT-GROU\r\n(End)

 */


public class OHEnglewoodParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^:]+?):(\\d\\d:\\d\\d:\\d\\d)-([A-Z0-9]+:[-A-Z0-9]*):([^:?]+):@([^,]+?),([A-Z ]*?):(.*)");
  
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
    body = body.replace('\n', ' ').trim();
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
