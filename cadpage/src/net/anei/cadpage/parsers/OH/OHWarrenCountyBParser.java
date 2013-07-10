package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Warren County, OH
 */
public class OHWarrenCountyBParser extends DispatchCiscoParser {
  
  public OHWarrenCountyBParser() {
    super(null, "WARREN COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@lebanonohio.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() > 0 && !body.startsWith("Ct:")) {
      body = "Ct: " + subject + ' ' + body;
    }
    return super.parseMsg(body, data);
  }
}
