package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Caroline County, MD
Contact: Brent Marine <bamarine123@gmail.com>
Sender: msg@cfmsg.com <From%3Amsg@cfmsg.com>
(PM13 is the unit code.  26 A is part of the call description)

(Chief ALT) [PM13] 26 A-Sick Person -- 520 Kerr Ave Denton - XSts: Dead End / Daffin Ln
(Chief ALT) [200 Fire] Wires Down -- 22542 Dover Bridge Rd Preston - XSts: Poplar Neck Rd, Tanyard Rd / Bethlehem Rd
(Chief ALT) [200 Fire] 17 A-Falls -- 21182 Marsh Creek Rd Preston - XSts: Frazier Neck Rd / Bethlehem Rd
(Chief ALT) [200 EMS] House Fire -- 22272 Havercamp Rd Preston - XSts: Prchal Rd / Poplar Neck Rd

Contact: "jg0169586@yahoo.com" <jg0169586@yahoo.com>
(Chief ALT) [200 EMS] 23 B-Overdose / Poisoning -- 320 Park Ave Federalsburg - XSts: Railroad Ave / Academy Ave

Contact: Pj Dyott <pdyott@gmail.com>
(Chief ALT) [200 EMS] 19 D-Heart Problems / A.i.c.d. -- 121 E Central Ave Federalsburg - XSts: Reliance Ave / N Main St, S Main St, W Central Ave
(Chief ALT) [200 EMS] 23 D-Overdose / Poisoning -- 156 Main St Preston - XSts: Harmony Rd / Lednum Ave
(Chief ALT) [200 EMS] 27 B-Stab/gsw/pen. Trauma -- 6181 Bethlehem Rd Preston - XSts: Harmony Rd, Gilpin Point Rd / Bell Creek Rd, Grove Rd
(Chief ALT) [200 EMS] 04 B-Assault -- 305 Bloomingdale Ave Federalsburg - XSts: N University Ave / Hayman Dr


 */


public class MDCarolineCountyParser extends SmsMsgParser {
  
  public MDCarolineCountyParser() {
    super("CAROLINE COUNTY", "MD");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] subjects = subject.split("\\|");
    if (subjects.length != 2 || !subjects[0].equals("Chief ALT")) return false;
    data.strSource = subjects[1];
    Parser p = new Parser(body);
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
