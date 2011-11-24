package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Neptune, NJ
Contact: Ross Leibowitz <rossl32100@gmail.com>
Sender: iar@neptunetownship.org

Subject:NEPTUNE PD COMMS CENTER\nhamilton fire/sr fire and hamilton first aid 716 shell place carbon monoxide alarm
Subject:NEPTUNE PD COMMS CENTER\nhamilton first aid 716 shell pl carbon monoxide alarm with symptoms﻿
Subject:NEPTUNE PD COMMS CENTER\nHFA-CANCEL CALL 716 SHELL PL REFUSAL AS PER PATROL﻿
Subject:NEPTUNE PD COMMS CENTER\nall neptune ems all call ocean grove 98.5 lawrence ave female feeling weak and dizzy
Subject:NEPTUNE PD COMMS CENTER\nEMS ALL CALL 98.5 LAWRENCE AV FOR ALERTERD MENTAL STATUS

 */

public class NJNeptuneParser extends SmartAddressParser {
  
  public NJNeptuneParser() {
    super("NEPTUNE", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "iar@neptunetownship.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("NEPTUNE PD COMMS CENTER")) return false;
    Result res = parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_NO_IMPLIED_APT, body);
    if (res.getStatus() > 0) {
      res.getData(data);
      data.strSupp = res.getLeft();
    } else {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
    }
    return true;
  }
}
