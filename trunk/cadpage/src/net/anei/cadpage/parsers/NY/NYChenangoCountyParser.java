package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.dispatch.DispatchA2Parser;





public class NYChenangoCountyParser extends DispatchA2Parser {
    
    public NYChenangoCountyParser() {
      super("CHENANGO COUNTY", "NY");
    }
    
    @Override
    public String getFilter() {
      return "cad@co.chenango.ny.us";
    }
	}
	