package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Delaware County, PA
Contact: Philip Hoffman <h03158@hotmail.com>
Sender: station55@comcast.net

13:59*FIRE-NON - NON BLDG RESPONSE*643 CONCHESTER HWY*CHELSEA PKWY*610-859-8920,~ MULCH ON ISLAND NEAR STOP SIGN IN CORNER OF THE PARKING LOT
13:42*ALARM -*785 CHERRY TREE RD B*HIDDEN VALLEY RD*OFFICE #610-494-8583,ESZ 406,APT B3 CMCST VOIP CALL,~ HALLWAY SMOKE DETECTOR,OFFICE #610-494-8583,ESZ 406,
11:17*ALARM -*1702 CHICHESTER AV*LAUGHEAD AV*BUSINESS,484-490-5167,OWNER BEING NOTIFIED,ALARM CO NOW ADVISING THEY ARE GETTING A FALSE ALARM,UNSURE IF THEY HA
14:19*FIRE-BLD - BUILDING RESPONSE*3386 CHICHESTER AV*THORNTON RD*610-485-8040 ESZ 405,~DEEP FRYER ON FIRE IN THE KITCHEN,SQ61, M100C, N13RIT,Location: 3386 C
17:08*FIRE-HAZMAT - HAZMAT RESPONSE*OGDEN AV & NAAMANS CREEK RD*OGDEN AV*2 VEHS INVOLVED,PULLED OVER TO THE SIDE,2 VEHS,NAAMANS CREEK RD OGDEN AV, Cross Stree
10:22*ALARM -*1509 MEETINGHOUSE RD*2ND AV*610-497-2652,~ZONE 1,OBN, }
12:18*ALARM -*925 MEETINGHOUSE RD*LOCUST ST*610-485-6881,~GENERAL,OBN,
13:42*ALARM -*785 CHERRY TREE RD B*HIDDEN VALLEY RD*OFFICE #610-494-8583,ESZ 406,APT B3 CMCST VOIP CALL,~ HALLWAY SMOKE DETECTOR,OFFICE #610-494-8583,ESZ 406,
14:52*ALARM -*736 CARRIAGE CIR*CHERRY TREE RD*SCHATZ RES,~GEN OBN,OBN,610-494-1430,
11:17*ALARM -*1702 CHICHESTER AV*LAUGHEAD AV*BUSINESS,484-490-5167,OWNER BEING NOTIFIED,ALARM CO NOW ADVISING THEY ARE GETTING A FALSE ALARM,UNSURE IF THEY HA

*/

public class PADelawareCountyAParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d\\d:\\d\\d\\*");
  
  public PADelawareCountyAParser() {
    super("DELAWARE COUNTY", "PA",
           "CALL ADDR X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "station55@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    return parseFields(body.split("\\*"), data);
  }
}
