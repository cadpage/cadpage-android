package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchA36Parser;


public class GABrantleyCountyParser extends DispatchA36Parser {
 
  public GABrantleyCountyParser() {
    super("BRANTLEY COUNTY", "GA", 1);
  }
  
  @Override
  public String getFilter() {
    return "brantleyga@smtp.sgcce-inc.com,brantleyga@ez911mail.com";
  }
 }
