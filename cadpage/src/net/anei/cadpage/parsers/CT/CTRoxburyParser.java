package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Roxbury, CT
Contact: Mike Josefson <mikejosefson@gmail.com>
Sender: globalpaging@nowestps.org

FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:FLAG SWAMP RD & SOUTH ST  ROXBURY MVA EMS ROX AMB RO EMSX RO ENG12 ROX RES9 ROX FD1 Primary Incident: 040734\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:39 TRANSYLVANIA RD  ROXBURY CHOKING ABNORM BREATH (PARTIAL OBSTRUCT) ROX AMB RO EMSX Primary Incident: 040410\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:102 PAINTER HILL RD  ROXBURY FAINTING/SYNCOPE ROX AMB RO EMSX Primary Incident: 040378\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:314 PAINTER HILL RD  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00120\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:71 SOUTH ST  ROXBURY FIRE ALARM RO ENG12 RO ENG10 RO TKR11 ROX RES9 ROX FD1 Primary Incident: 00119\n\n\n(End)
FRM:globalpaging@nowestps.org\nSUBJ:From Northwest\nMSG:BOTSFORD HILL RD & GOLDEN HARVEST RD  ROXBURY WIRES DOWN/FIRE ROX RES9 ROX FD1 Primary Incident: 00109

*/

public class CTRoxburyParser extends SmartAddressParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\bROX?\\b");

  public CTRoxburyParser() {
    super(CITY_LIST, "ROXBURY", "CT");
  }
  
  @Override
  public String getFilter() {
    return "globalpaging@nowestps.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("From Northwest")) return false;
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    Parser p = new Parser(body);
    data.strCallId = p.getLastOptional("Primary Incident:");
    if (data.strCallId.length() == 0) return false;
    body = p.get();
    parseAddress(StartType.START_ADDR, body, data);
    body = getLeft();
    Matcher match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = body.substring(match.start());
      body = body.substring(0,match.start());
    }
    data.strCall = body;
    return true;
  }
  
  private static String[] CITY_LIST = new String[]{
    "ROXBURY"  
  };
}
