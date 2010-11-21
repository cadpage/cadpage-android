package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;



public class DESussexCountyParser extends SmsMsgParser {

	
	  @Override
	  public boolean isPageMsg(String body) {
		  return body.contains("] -- ");
	  }

	  @Override
	  protected void parse(String body, Data data) {
	    data.defState="DE";

	    



	  }
	}
	

