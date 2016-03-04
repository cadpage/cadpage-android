package net.anei.cadpage.parsers.KY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;


public class KYToddCountyParser extends DispatchA27Parser {
  
  public KYToddCountyParser() {
    super("TODD COUNTY", "KY","[A-Z]{1,3}FD|[A-Z]+\\d+|\\d{8}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
  
  @Override
  public int getMapFlags() {
    
    // We really don't have enough examples to make this determination, but
    // give dispatch the benefit of doubt.
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = PI_PTN.matcher(addr).replaceAll("PIKE");
    return super.adjustMapAddress(addr);
  }
  private static final Pattern PI_PTN = Pattern.compile("\bPI\b", Pattern.CASE_INSENSITIVE);
}