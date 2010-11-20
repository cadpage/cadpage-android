package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;



public class COGreeleyParser extends SmsMsgParser {

	
	  @Override
	  public boolean isPageMsg(String body) {
		  return body.contains(",TEXT:");
	  }

	  @Override
	  protected void parse(String body, Data data) {
	    data.defState="CO";
	    data.defCity = "Greeley";
	    String[] flds = body.split(",");
	    if (flds.length > 4) {
	    	data.strCallId = flds[0];
	    	data.strCall = flds[1];
	    	String[] fldsA = flds[2].split(".");
	    	data.strAddress = fldsA[0];
	    	data.strUnit = fldsA[1];
	        Parser p = new Parser(flds[3]);
	        data.strSupp = p.getOptional(':');
	    }
	    



	  }
	}
