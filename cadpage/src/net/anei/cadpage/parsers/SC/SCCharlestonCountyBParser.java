package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Charleston County, SC
Contact: Michael Helms <mhelms1125@gmail.com>
Sender: CDC_Dispatch@charlestoncounty.org
Medical Assist Charlie Respons 1605 Highway 41 X Street: JOE ROUSE RD/JOE ROUSE RD Op Channel: EMS OPS

 */


public class SCCharlestonCountyBParser extends FieldProgramParser {
  
  public SCCharlestonCountyBParser() {
    super("CHARLESTON COUNTY", "SC",
           "ADDR/SC! X_Street:X! Op_Channel:INFO");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Quick check to eliminate SCCharlestonCountyAParser messages
    if (body.contains("Address:")) return false;
    return super.parseMsg(body, data);
  }
}
