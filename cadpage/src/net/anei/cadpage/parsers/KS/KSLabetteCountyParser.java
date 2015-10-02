package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;


public class KSLabetteCountyParser extends DispatchA33Parser {
  
  public KSLabetteCountyParser() {
    super("LABETTE COUNTY", "KS", "X");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@LABETTECOUNTY.COM";
  }
  
 }
