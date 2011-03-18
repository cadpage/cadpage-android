package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Charleston County, SC
Contact: Gary Durgin <gary.durgin@charlestonrescue.com>
Sender: CDC_Dispatch@charlestoncounty.org ??
1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04
1110-0001574 District 03 Rescue MVA Entrapment D Address: Playground Rd / Ashley River Rd X Street:   Cmd Channel: Incident 07
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Chann
1110-0001577 District 09 Rescue Rescue Needed Address: Ashley Phosphate Rd / Stall Rd X Street:   Cmd Channel: Incident 04
1110-0001580 District 12 Rescue MVA Major Incident D Address: International Blvd / Mark Clark Expwy X Street:   Cmd Channel: Incid
1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident
1110-0001582 District 01 Rescue Water Rescue Strnd Motorist  B Address: Jetty's Of Charelston Harbor X Street:  Charleston Harbor
1110-0001589 District 11 A Entrapment Unknown B Address: HIGHWAY 41 / N HIGHWAY 17 X Street:  COSMIC DOGS HOT DOG STAND Cmd Channe
1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04
1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident
1110-0001562 District 02 Rescue MVA Unknown B Address: Rivers Av / Mark Clark Expwy X Street:  On Mark Clark East Bound Cmd Channel:
1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd ...
1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd / Dogwood Rd X Street:  ALT# 843-327-8597 Cmd Channel:
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel:
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel: Incident 10
1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04
1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:
1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04
1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:

 */


public class SCCharlestonCountyAParser extends FieldProgramParser {
  
  public SCCharlestonCountyAParser() {
    super("CHARLESTON COUNTY", "SC",
           "CALL! Address:ADDR! X_Street:X Cmd_Channel:INFO");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Parser p = new Parser(body);
    String callId = p.get(' ');
    if (!p.get(' ').equals("District")) return false;
    data.strCallId = callId;
    data.strSource = p.get(' ');
    return super.parseMsg(p.get(), data);
  }
  
  @Override
  public String getProgram() {
    return "ID SRC " + super.getProgram();
  }
}
