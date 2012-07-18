package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Olmsted County, MN
Contact: Joe Manning <jlmanning@gmail.com>
Sender: @rochestermn.gov

(Main St N 20 ST NW) Two vehicle Accident with injuries, neck and head pain\r\n\r\nJeff Wellik\r\nPublic Safety Communications\r\nRochester Police/Olmsted County Sh
(4639 grove st se) Elderly male stroke symptoms, blurred vision weak legs
(200 lakeshore dr nw) Med
(200 lakeshore dr nw  florence park) medical
(500 6 st ne) Medical
(6220 70 ST SW) Male with chest pains  6220 70 ST SW
(medical 1106 Sunrise Ct SE  baby with siezure)
(101 schumann dr nw) GRASS FIRE ON W SIDE OF KWIK TRIP

*/

public class MNOlmstedCountyParser extends SmartAddressParser {
  
  public MNOlmstedCountyParser() {
    super("OLMSTED COUNTY", "MN");
  }
  
  @Override
  public String getFilter() {
    return "@rochestermn.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Not enough identification features to positively identify as a text page
    // so we require that identification be done externally
    if (!isPositiveId()) return false;

    // If no body (which gets to us as no subject) treat as special case
    if (subject.length() == 0) {
      Parser p = new Parser(body);
      data.strSupp = p.getLastOptional("  ");
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, p.get(), data);
      if (data.strCall.length() == 0) {
        data.strCall = data.strSupp;
        data.strSupp = "";
      }
    }
    
    else {
      Parser p = new Parser(subject);
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT, p.get("  "), data);
      data.strPlace = p.get();
      
      String[] flds = body.split("\n");
      data.strCall = flds[0].trim();
      for (int ii = 1; ii<flds.length; ii++) {
        data.strSupp = append(data.strSupp, " / ", flds[ii].trim());
      }
    }
    return true;
  }
}
