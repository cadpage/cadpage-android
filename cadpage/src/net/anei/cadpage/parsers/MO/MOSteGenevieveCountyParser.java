package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Ste. Genevieve County, MO
 */
public class MOSteGenevieveCountyParser extends DispatchCiscoParser {

  public MOSteGenevieveCountyParser() {
    super("STE. GENEVIEVE", "MO");
  }

  @Override
  public String getFilter() {
    return "sfc_cad@sfc911.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strAddress.startsWith("!")) data.strAddress = data.strAddress.substring(1).trim();
    return true;
  }
}
  