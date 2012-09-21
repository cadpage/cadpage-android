package net.anei.cadpage.parsers.MT;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Lewis & Clark County, MT (alternate)
Contact: support@active911.com
Sender: runcards@lcpage.org

(MUTUAL AID REQ) REQ: 1 Management Staff |Engine 6411 |Tender 6423\nLOC: 5106 bluebell rd  TYPE: South Structure - 1st Alarm West Valley is requesting mutual aid, South Structure - 1st Alarm. CONTACT West Valley STAGING ON GOLD CHANNEL

*/
public class MTLewisAndClarkCountyBParser extends FieldProgramParser {

  public MTLewisAndClarkCountyBParser() {
    super("LEWIS AND CLARK COUNTY", "MT",
           "REQ:INFO! LOC:ADDR! TYPE:INFO!");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    data.strCall = subject;
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
}
