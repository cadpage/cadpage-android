package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Caroline County, MD
Contact: Brent Marine <bamarine123@gmail.com>
Sender: msg@cfmsg.com <From%3Amsg@cfmsg.com>
(PM13 is the unit code.  26 A is part of the call description)

(Chief ALT) [PM13] 26 A-Sick Person -- 520 Kerr Ave Denton - XSts: Dead End / Daffin Ln
(Chief ALT) [200 Fire] Wires Down -- 22542 Dover Bridge Rd Preston - XSts: Poplar Neck Rd, Tanyard Rd / Bethlehem Rd
(Chief ALT) [200 Fire] 17 A-Falls -- 21182 Marsh Creek Rd Preston - XSts: Frazier Neck Rd / Bethlehem Rd
 */


public class MDCarolineCountyParser extends SmsMsgParser {

  @Override
  protected boolean parseMsg(String body, Data data) {

    data.defState="MD";
    data.defCity = "CAROLINE COUNTY";
    
    int ipt = body.indexOf("(Chief ALT)");
    if (ipt < 0) return false;
    body = body.substring(ipt+10).trim();
    
    Parser p = new Parser(body);
    p.get("]");
    data.strCall = p.getOptional(" -- ");
    if (data.strCall.length() == 0) return false;
    
    String sAddr = p.get("XSts:");
    if (sAddr.endsWith(" -")) sAddr = sAddr.substring(0, sAddr.length()-2);
    Parser p2 = new Parser(sAddr);
    data.strCity = p2.getLast(' ');
    sAddr = p2.get();
    parseAddress(sAddr, data);
    
    data.strCross = p.get();
    
    return true;
  }
}
