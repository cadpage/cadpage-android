package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/* 
Somerset County, NJ 
Contact: CodeMessaging

[fCAD] TYPE - HHaz-Health Hazard LOC - 204~STRATFORD~PL~ XST - UNKNOWN / THOMPSON AVE NAR - 07/28/12 16:50:02~CALLER STATED A POTATO EXPLODED IN HER MICROWAVE AND SHE IS CONCERNED THAT THERE MAY BE FIRE IN THE WALLS.
[fCAD] TYPE - AF - Fire Alarm LOC - 9~DARTMOUTH~AVE~APT 4B XST - COLUMBIA DR / DEAD END NAR - 08/02/12 23:27:55~FFD DISPATCHED FOR AUDIBLE FIRE ALARM CALLED IN BY RESIDENT
[fCAD] TYPE - 39 - Notify LOC - POLHEMUS LANE~ XST - ~ NAR - 08/06/12 11:02:10~FYI ONLY-DO NOT RESPOND. POLHEMUS LANE CLOSED AT RR CROSSING 8/9 TO 8/17. DETOUR VIA TEMPORARY ROAD.
[fCAD] TYPE - 38G - Gas Leak LOC - 7~COLUMBIA~DR~APT 3A XST - MORGAN LN / DARTMOUTH AVE NAR - 07/13/12 19:18:20~FFD DISPATCHED FOR A STRONG SMELL OF GAS IN THE RESIDENCE FOR THE PAST 48 HOURS, NEG ILLNESS
[fCAD] TYPE - 38S - Smoke Condition LOC - 1~PATRIOTS~PARK~TD BANK PARK RED LOT XST - DRIVEWAY / DRIVEWAY NAR -
[fCAD] TYPE - 43 - MV Stop LOC - 300~COMMONS~WAY~BEST BUY XST - RAMP / 5TH AVE NAR - 07/26/12 15:01:31~BLK NISSAN MAX
[fCAD] TYPE - AF - Fire Alarm LOC - 190~FINDERNE~AVE~ADVOSERVE XST - ENGLISH CT / FOOTHILL RD NAR - 07/22/12 00:20:21~FFD DISPATCHED FOR FIRE ALARM ACTIVATION, 1 ST FLOOR OFFICE PULL STATION
[fCAD] TYPE - 38S - Smoke Condition LOC - 1~PATRIOTS~PARK~TD BANK PARK RED LOT XST - DRIVEWAY / DRIVEWAY NAR - 07/26/12 19:30:40~BLS UNIT 806 REPORTED A LARGE BLACK CLOUD OF SMOKE
[fCAD] TYPE - 43 - MV Stop LOC - 300~COMMONS~WAY~BEST BUY XST - RAMP / 5TH AVE NAR - 07/26/12 15:01:31~BLK NISSAN MAX
[fCAD] TYPE - AF - Fire Alarm LOC - 120~FINDERNE~AVE~PEOPLE CARE CENTER XST - LOCUST ST N / UNION AVE NAR - 07/31/12 18:03:20~AREA OF ACTIVATION - 2ND FLOOR SMOKE, 208
[fCAD] TYPE - AA - Audible Alarm LOC - 705~KLINE~PL~ XST - MORTON ST / PEARL ST NAR - 07/09/12 11:19:47~ALARM COMING FROM INSIDE SOME HOUSE IN THE AREA - CALLER UNABLE TO PINPOINT SOURCE
[fCAD] TYPE - 38S - Smoke Condition LOC - 511~UNION~AVE~ XST - YORKTOWN RD / PEARL ST NAR - 07/09/12 11:03:03~SMOKE CONDITION IN THE AREA. FFD/SMC801 DISPATCHED
[fCAD] TYPE - AF - Fire Alarm LOC - 100~MONROE~ST~ARBOR GLEN XST - GEORGE ST / JEFFERSON CT NAR - 07/18/12 00:45:49~HEALTH CARE BUIDLING
[fCAD] TYPE - 13 - Assist LOC - 311~MOUNTAIN~AVE~ XST - SOMERSET ST / STHY 28 NAR - 07/18/12 23:16:59~FFD DISPATCHED BY SCC FOR FAST TEAM INTO BOUND BROOK

*/

public class NJSomersetCountyBParser extends FieldProgramParser {

  private static final Pattern MASTER = Pattern.compile("TYPE - ([A-Za-z0-9]+) *- *(.*?) LOC - (.*) XST - (.*?) NAR -(?: (\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d:\\d\\d)~(.*))?");
  
  public NJSomersetCountyBParser() {
    super("SOMERSET COUNTY", "NJ",
        "TYPE:CODE! CALL! LOC:ADDR! XST:X! NAR:INFO");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("fCAD")) return false;
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCode = match.group(1);
    data.strCall = match.group(2).trim();
    String addr = match.group(3).replace('~', ' ').trim();
    parseAddress(addr, data);
    data.strCross = match.group(4).trim();
    if (data.strCross.equals("~")) data.strCross = "";
    data.strDate = getOptGroup(match.group(5));
    data.strTime = getOptGroup(match.group(6));
    data.strSupp = getOptGroup(match.group(7));
    return true;
  }
}



