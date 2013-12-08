package net.anei.cadpage.parsers.OH;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;



public class OHClermontCountyBParser extends DispatchA1Parser {
  
  public OHClermontCountyBParser() {
    super("CLERMONT COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "utcc@union-township.oh.us";
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return TR_PTN.matcher(addr).replaceAll("TERRACE");
  }
  private static final Pattern TR_PTN = Pattern.compile("\\bTR\\b", Pattern.CASE_INSENSITIVE);
}
