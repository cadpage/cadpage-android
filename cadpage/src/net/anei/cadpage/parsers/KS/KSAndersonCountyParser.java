package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;

public class KSAndersonCountyParser extends DispatchA33Parser {


  public KSAndersonCountyParser() {
    super("ANDERSON COUNTY", "KS", "X");
  }
  
  @Override
  public String getFilter() {
    return "ANDERSONCOUNTY@PUBLICSAFETYSOFTWARE.NET";
  }
}
