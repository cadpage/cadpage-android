package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Cumberland County, TN
Contact: Jeremy <fyrboy55@gmail.com>
Sender: dispatch@911email.net

(E911) FIRE ALARM/10-72A\r\n115 HUNTINGTON DR\r\nKEY PAD ALARM
(E911) FIRE ALARM/10-72A\r\nSTONEHENGE DR\r\nGENERAL/COMMERCIAL BUILDING SYSTEMS/800-877-3624
(E911) MVA-INJ/10-46\r\nPEAVINE RD BY ACE HARDWARE\r\nJUV COMPLAINING OF CHEST PAINS , 2 VEHS

 */

public class TNCumberlandCountyParser extends FieldProgramParser {
  
  public TNCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "TN",
           "CALL ADDR INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("E911")) return false;
    return parseFields(body.split("\n"), 3, data);
  }
}
