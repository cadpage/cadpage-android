package net.anei.cadpage.parsers.SC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Charleston County, SC
Contact: Gary Durgin <gary.durgin@charlestonrescue.com>
Contact: 5155707818@vtext.com
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
1211-0002346 District 09 Rescue Entrapment Unknown B Address: Dorchester Rd / Hill Blvd X Street:  IFO HUNLEY PARK Cmd Channel:  In

Contact: Michael Helms <mhelms1125@gmail.com>
Sender: CDC_Dispatch@charlestoncounty.org
Medical Assist Charlie Respons 1605 Highway 41 X Street: JOE ROUSE RD/JOE ROUSE RD Op Channel: EMS OPS

Contact: Gregory Kramer <g.j.kramer@gmail.com>
(Dispatch Info) ANY MEMBER AVAILABLE TO ASSIST WITH THE SOCON BASEBALL TOURNAMENT TOMM CONTACT 619 AS SOON AS POSSIBLE. OPR#5

Contact: Patrick Phillips <james.patrick.phillips@gmail.com>
(Dispatch Info) Medical Assist Bravo Response 1717 River Rd X Street: TOBY RD/UNNAMED_298 ST Cmnd Channel: EMS OPS

 
Contact: Josh Sims <josh.sims00@gmail.com>
From: CDC_Dispatch@charlestoncounty.org
(Dispatch Info) M04           0338252             District 04 EMS     04B01A    1402 Camp Rd        XS:SECESSIONVILLE RD/JAMES POINT DR  Apt/Bldg: 8           04B_Assault Poss Dang Area    Location Name:Fini Event Planning
(Dispatch Info) M04           0347732             District 04 EMS     06D02A    311 Fleming Rd      XS:MAYBANK HWY/STIRCREEK RD          Apt/Bldg:
(Dispatch Info) M04           0348340             District 04 EMS     33C06T    2 Bishop Gadsden WayXS:CAMP RD/CHESIRE DR                Apt/Bldg: 1059        33C_Transfer Emrgncy Respnse TLocation Name:MEYERS HALL
(Dispatch Info) M04           0348332             District 04 EMS     26C02     2 BISHOP GADSDEN WAYXS:CAMP RD/CHESIRE DR                Apt/Bldg: APT 1002    26C_Sick Abnormal Breathing   Location Name:
(Dispatch Info) M04           0348435             District 01 EMS     01C05     573 Meeting St      XS:JOHNSON ST/STUART ST              Apt/Bldg:             01C_Abn Pain Abv Navl Male >35Location Name:Crisis Ministries Sh
(Dispatch Info) M04           0348430             District 04 EMS     131C01    Riverland Dr / CanalXS:                                  Apt/Bldg:             29B_Accident MVA Unknown      Location Name:

 */


public class SCCharlestonCountyParser extends FieldProgramParser {
  
  public SCCharlestonCountyParser() {
    super("CHARLESTON COUNTY", "SC",
           "( PREFIX Address:ADDR! X_Street:X Cmd_Channel:CH | ADDR/SC! X_Street:X Cmd_Channel:CH! )");
  }
  
  @Override
  public String getFilter() {
    return "CDC_Dispatch@charlestoncounty.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    // See if we can parse this as a fixed field message
    if (parseFixedFieldMsg(subject, body, data)) return true;
    body = body.replace(" Op Channel:", " Cmd Channel:").replace(" Cmnd Channel:", " Cmd Channel:");
    if (! super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) return false;
    if (data.strAddress.length() == 0) return false;
    return true;
  }

  private boolean parseFixedFieldMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Info")) return false;
    if (body.length() < 87) return false;
    if (!body.substring(34,43).equals("District ")) return false;
    if (!body.substring(84,87).equals("XS:")) return false;
    if (body.length() >= 130 &&
        !body.substring(121,130).equals("Apt/Bldg:")) return false;
    if (body.length() >= 187 &&
        !body.substring(173,187).equals("Location Name:")) return false;
    if (body.length() < 130) data.expectMore = true;
    
    data.strUnit = getField(body, 0, 14);
    data.strCallId = getField(body, 14,34);
    data.strSource = getField(body, 43, 46);
    data.strCall = getField(body, 46, 54);
    data.strCode = getField(body, 54, 64);
    parseAddress(getField(body, 64, 84), data);
    data.strCross = getField(body, 87, 121);
    data.strApt = getField(body, 130, 143);
    data.strSupp = getField(body, 143, 173);
    data.strPlace = getField(body, 187, 9999);
    
    return true;
  }
  
  @Override
  public String getProgram() {
    return "UNIT ID SRC CALL CODE ADDR X APT INFO PLACE CH";
  }
  
  private static String getField(String body, int start, int end) {
    int len = body.length();
    if (start > len) start = len;
    if (end > len) end = len;
    return body.substring(start, end).trim();
  }

  private static final Pattern PREFIX_PTN = 
      Pattern.compile("(\\d{4}-\\d{7}) District (\\d{2}) (.*)");
  private class PrefixField extends CallField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = PREFIX_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strCallId = match.group(1);
      data.strSource = match.group(2);
      parse(match.group(3), data);
      return true;
    }

    @Override
    public String getFieldNames() {
      return "ID SRC";
    }
    
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PREFIX")) return new PrefixField();
    return super.getField(name);
  }
}
