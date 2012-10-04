package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Olmsted County, MN
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
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, p.get("  "), data);
      if (data.strCall.length() == 0) data.strCall = p.get("  ");
      data.strSupp = p.get();
    }
    
    else {
      if (body.toUpperCase().startsWith(subject.toUpperCase())) {
        subject = body.substring(0,subject.length()).trim();
        body = body.substring(subject.length()).trim();
        if (body.toUpperCase().startsWith("AT ")) body = body.substring(3).trim();
      }
      
      Parser p = new Parser(subject);
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT, p.get("  "), data);
      data.strPlace = p.get();
      
      if (data.strAddress.length() > 0) {
        String[] flds = body.split("\n");
        data.strCall = flds[0].trim();
        for (int ii = 1; ii<flds.length; ii++) {
          data.strSupp = append(data.strSupp, " / ", flds[ii].trim());
        }
      }
      
      else {
        parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT, body, data);
        data.strSupp = getLeft();
      }
    }
    return true;
  }
}
