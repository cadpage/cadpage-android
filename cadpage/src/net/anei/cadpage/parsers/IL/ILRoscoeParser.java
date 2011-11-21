package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Roscoe, IL
Contact: Ron Klaman <hrfdrklaman@gmail.com>
Sender: hrfdfiresvcrunnotification@gmail.com
S:HRFD: Med: 687 Marion Rd M: 56 f deleious\n\n
S:HRFD: Med:9918 Bluebonnet M: 70 M diaahra\n\n

Contact: John Donovan <hrfdfireman@gmail.com>
Sender: hrfdfiresvcrunnotification@gmail.com
(HRFD: Med:14244 krotz Dr) m fall victim
(HRFD: Med:6792 Michelle Dr) F Trouble Breathing

Contact: Thomas Aaker <hrfdtaaker@gmail.com>
Sender: hrfdfiresvcrunnotification@gmail.com
S:HRFD: Med:4694 indigo place M: c/o alarm no \n
S:HRFD: Fire:380 Morning Cloak  #4 M: DRyer Fire\n
S:HRFD: Fire:6569 Burr Oak Rd M: fire alarm\n
S:HRFD: Med:629 ALTHEA M: RES. C.O. ALARM\n

*/

public class ILRoscoeParser extends SmsMsgParser {
  
  private static Pattern MARKER = Pattern.compile(": (?:Med|Fire):");
  
  public ILRoscoeParser() {
    super("ROSCOE", "IL");
  }
  
  @Override
  public String getFilter() {
    return "hrfdfiresvcrunnotification@gmail.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = MARKER.matcher(subject);
    if (!match.find()) return false;
    data.strSource = subject.substring(0, match.start()).trim();
    parseAddress(subject.substring(match.end()).trim(), data);
    data.strCall = body;
    return true;
  }
}
