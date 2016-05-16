package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA45Parser;

public class PAPikeCountyBParser extends DispatchA45Parser {
  
  public PAPikeCountyBParser() {
    super(CITY_CODES, "PIKE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "@pike.alertpa.org,messaging@iamresponding.com";
  }

  private static final Pattern SPECIAL_BRK_PTN = Pattern.compile("> *\n *>");
  private static final Pattern MBLANK_PTN = Pattern.compile(" {2,}");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Fix usual IAR silliness
    body = SPECIAL_BRK_PTN.matcher(body).replaceAll(" ");
    body = MBLANK_PTN.matcher(body).replaceAll(" ");

    if (!subject.equals("Pike CAD")) data.strSource = subject;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
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
