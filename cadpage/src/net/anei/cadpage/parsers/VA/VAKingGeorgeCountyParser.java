package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VAKingGeorgeCountyParser extends DispatchDAPROParser {
  
	  public VAKingGeorgeCountyParser() {
			 super(CITY_LIST, "KING GEORGE COUNTY", "VA");
	  }
	  
	  private static final String[] CITY_LIST = new String[]{
	    "PORT ROYAL"
	  };
}