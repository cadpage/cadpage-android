package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Martinez, GA (Martinez Columbia Fire Rescue
Contact: "Brent Willis" <bwillis@mvfd.net>
Sender: no-reply@mvfd.net
 
Working structure fire!  Assistance is needed if available.\nAddress: 611 KETTLE CREEK DR\nDO NOT CALL DISPATCH!!!! (Reported on 11/21/2010 @ 12:39:39 AM)
Working structure fire!  Assistance is needed if available.\n330 HACKAMORE TRL\nDO NOT CALL DISPATCH!!!! (Reported on 10/22/2010 @ 9:50:55 PM)
Working structure fire!  Assistance is needed if available.\nAddress:298 Ashbrook dr\nDO NOT CALL DISPATCH!!!! (Reported on 09/14/2010 @ 2:20:07 PM)
Working structure fire! Assistance is needed if available.\nAddress:ACROSS FROM 3736 CATUS TRAIL\nDO NOT CALL DISPATCH!!!! (Reported on 09/08/2010 @ 3:53:59 PM)
Working structure fire! Assistance is needed if available.\nAddress:711 HIDDEN PL OFF HWY 28\nDO NOT CALL DISPATCH!!!! (Reported on 8/12/2010 @ 9:24:21 AM)
 */


public class GAMartinezParser extends MsgParser {
  
  public GAMartinezParser() {
    super("MARTINEZ", "GA");
  }
  
  @Override
  public String getFilter() {
    return "no-reply@mvfd.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    String[] lines = body.split("\n");
    if ( !(lines.length == 3) || ! lines[2].startsWith("DO NOT CALL DISPATCH!!!!")) return false;
    
    data.strCall = lines[0].trim();
    
    String sAddr = lines[1].trim();
    if (sAddr.startsWith("Address:")) sAddr = sAddr.substring(8);
    if (sAddr.startsWith("ACROSS FROM ")) {
      data.strPlace = sAddr.substring(0,11).trim();
      sAddr = sAddr.substring(12).trim();
    }
    int ipt = sAddr.indexOf(" OFF ");
    if (ipt >= 0) {
      data.strCross = sAddr.substring(ipt+1).trim();
      sAddr = sAddr.substring(0,ipt).trim();
    }
    parseAddress(sAddr, data);
    
    return true;
  }
}
