package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Adams County, CO
Contact: "Matt Kehoe" <mjkehoe@gmail.com>
Sender: ipspage@adcom911.org

Subject:IPS I/Page Notification E 64TH AVE/MONACO ST ADAM CCPD 09:51:48 TYPE CODE: ACCI CALLER NAME: TIME: 09:51:48 Comments: -104.90947
Subject:IPS I/Page Notification 6950 NIAGARA ST ADAM CCPD 11:04:10 TYPE CODE: EMS CALLER NAME: FELIX - 13YO TIME: 11:04:10 Comments: 15YO
Subject:IPS I/Page Notification 10220 BRIGHTON RD ADAM CCPD:DIVERSIFIES TRUCK AND RV 17:22:11 TYPE CODE: NONSTR CALLER NAME: BOB TIME: 17:
Subject:IPS I/Page Notification US HIGHWAY 85 NB/E 77TH AVE ADAM ADAM 03:34:04 TYPE CODE: NONSTR CALLER NAME: ASHLEY TIME: 03:34:04 Commen
Subject:IPS I/Page Notification 9900 E 102ND AVE ADAM CCPD:USF 06:06:49 TYPE CODE: FRALRM CALLER NAME: ADT TIME: 06:06:49 Comments: WATER
 */


public class COAdamsCountyParser extends SmsMsgParser {
  
  private static final String CAD_MARKER = "Subject:IPS I/Page Notification ";
  private static final String[] KEYWORDS = 
    new String[]{"LOC", "TYPE CODE", "CALLER NAME", "TIME", "Comments"};
  
  public COAdamsCountyParser() {
    super("ADAMS COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "ipspage@adcom911.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf(CAD_MARKER);
    if (pt < 0) return false;
    body = "LOC:" + body.substring(pt+CAD_MARKER.length());
    
    Properties props = parseMessage(body, KEYWORDS);
    String sAddr = props.getProperty("LOC", "");
    pt = sAddr.indexOf(" ADAM ");
    if (pt < 0) return false;
    parseAddress(sAddr.substring(0, pt), data);
    
    data.strCall = props.getProperty("TYPE CODE");
    
    // There is a comment field, but it never seems to have enough info to
    // make it worth parsing
    
    return true;
  }
}
