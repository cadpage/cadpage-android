package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/*
Bloomington, MN
Contact: "Meyer, Curt" <CMeyer@ci.bloomington.mn.us>
Sender: logis-emergin-paging@logis.org
System: Motorola Premier 1

RESIDENTIAL FIRE ALM AD: 9824 DELLRIDGE RD CMT1: AUDIBLE RESIDENTIAL FIRE ALARM NO ANSWER ON CALLING INSIDE 952-884-001
STRUCTURE FIRE AD: 8336 17 AV S CMT1: READING ON CO DETECTOR GAS ADN 225 - BEEPING - NO ONE FEELS ILL
SELECT STATION CALL APT: 6 AD: 25 98 ST W LOC: METRO APARTMENTS CMT1: STOVE WAS LEFT ON - NEED VENTILATION - OFFICER IS ON SCENE
RESET ALARM AD: 5230 102 ST W LOC: TARNHILL APARTMENTS CMT1: ON 3RD FLOOR WESTEND - PULL STATION ACTIVATED - FALSE ALARM - NEEDS
STRUCTURE FIRE AD: 8100 HIGHWOOD DR LOC: FRIENDSHIP VILLAGE/M CMT1: MALE WITH LEG TRAPPED IN MECHANISM OF ELEVATOR
ELEVATOR RESCUE AD: 5401 GREEN VALLEY DR LOC: CROWNE PLAZA HOTEL CMT1: ONE STUCK IN ELEVATOR FOR 20 MIN - IN SOUTH TOWER BET 5TH

*/


public class MNBloomingtonParser extends DispatchPrintrakParser {
  
  public MNBloomingtonParser() {
    super("BLOOMINGTON", "MN");
  }
  
  @Override
  public String getFilter() {
    return "logis-emergin-paging@logis.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return super.parseMsg("TYP: " + body, data);
  }
}
