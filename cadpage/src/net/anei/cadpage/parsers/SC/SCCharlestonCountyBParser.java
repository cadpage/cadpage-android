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
           "CALL! Address:ADDR! X_Street:X Cmd_Channel:INFO");
  }
  
  @Override
  public String getFilter() {
    return "CDC_Dispatch@charlestoncounty.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {

    data.defState="SC";
    data.defCity = "CHARLESTON COUNTY";
    
    Parser p = new Parser(body);
    String callId = p.get(' ');
    if (p.get(' ').equals("District")) {
      data.strCallId = callId;
      data.strSource = p.get(' ');
      body = p.get();
    }
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID SRC " + super.getProgram();
  }
}
