package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchA31Parser;


public class TXBrazoriaCountyAParser extends DispatchA31Parser {
  
  public TXBrazoriaCountyAParser() {
    super("MPD", "BRAZORIA COUNTY", "TX");
  }
  
  @Override
  public String getFilter() {
    return "cadpaging@manvelpd.org";
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return BACKWARD_HWY_PTN.matcher(addr).replaceAll("TX $1");
  }
  private static final Pattern BACKWARD_HWY_PTN = Pattern.compile("\\b(\\d+) *SH", Pattern.CASE_INSENSITIVE);
}
