package net.anei.cadpage.parsers.GA;


import net.anei.cadpage.parsers.dispatch.DispatchA12Parser;


public class GAEffinghamCountyParser extends DispatchA12Parser {
  
  public GAEffinghamCountyParser() {
    super("EFFINGHAM COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "Effingham911@EffinghamCounty.org";
  }
  
}
