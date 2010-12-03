package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04
1110-0001574 District 03 Rescue MVA Entrapment D Address: Playground Rd / Ashley River Rd X Street:   Cmd Channel: Incident 07
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Chann
1110-0001577 District 09 Rescue Rescue Needed Address: Ashley Phosphate Rd / Stall Rd X Street:   Cmd Channel: Incident 04
1110-0001580 District 12 Rescue MVA Major Incident D Address: International Blvd / Mark Clark Expwy X Street:   Cmd Channel: Incid
1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident
 */


public class SCCharlestonCountyParser extends SmsMsgParser {
  private static final String[] KEYWORDS = new String[]{"CALL","Address", "X", "CMD"};
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains(" District ")) return false;

    data.defState="SC";
    data.defCity = "CHARLESTON COUNTY";
    body = body.replace("X Street:", "X:");
    body = body.replace("Cmd ","CMD: ");
    body = body.replace(" Channel: "," ");
    body = body.replace(" District "," CALL: ");
    
    Properties props = parseMessage(body, KEYWORDS);
    data.strCall = props.getProperty("CALL");
    parseAddress(props.getProperty("Address"),data);
    data.strCross = props.getProperty("X", "");
    data.strSupp = props.getProperty("CMD","");
    
    int idx = body.indexOf(" ");
    if (idx > 0) { data.strCallId = body.substring(0,idx).trim(); }
    /*
      Parser p = new Parser(flds[2]);
      data.strUnit = p.getLastOptional(".");
      parseAddress(p.get(), data);
    }
    Parser p = new Parser(body);
    p.get("TEXT:");
    data.strSupp = p.get("\\COMP:");
    */
    return true;
  }
}
