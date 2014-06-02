package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA45Parser;

public class PAPikeCountyBParser extends DispatchA45Parser {
  
  public PAPikeCountyBParser() {
    super(CITY_CODES, "PIKE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "@pike.alertpa.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Pike CAD")) return false;
    return super.parseMsg(body, data);
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BGV", "BLOOMING GROVE",
      "DEL", "DELAWARE TWP",
      "DIN", "DINGMAN TWP",
      "LAK", "LACKAWAXEN",
      "MAB", "MATAMORAS",
      "MCP", "MONROE COUNTY",
      "MFB", "MILFORD",
      "MFT", "MILFORD TWP",
      "ONY", "ORANGE COUNTY",
      "SHO", "SHAHOLA",
      "SNJ", "SUSSEX COUNTY",
      "SNY", "SULLIVAN COUNTY",
      "UNK", "",
      "WCP", "WAYNE COUNTY",
      "WES", "WESTFALL TWP",

  });
}
