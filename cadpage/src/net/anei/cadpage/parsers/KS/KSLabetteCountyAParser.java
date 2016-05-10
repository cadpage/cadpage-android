package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;


public class KSLabetteCountyAParser extends DispatchA33Parser {
  
  public KSLabetteCountyAParser() {
    super("LABETTE COUNTY", "KS", "X");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@LABETTECOUNTY.COM";
  }
  
 }
