package net.anei.cadpage.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;


/*
CLA 10990 Keller Rd. EMS 80M slurred speech
CLA 9970 Greiner Rd. EMS Finger laceration
CLA 5727 Marthas Vineyard EMS 55 y/o fell
CLA 5945 Vinecroft Dr. EMA apt. 401
CLA Salt rd. & County rd. MVA. 1/2 mile north of county.
CLA 5955 Elm St. EMS
CLA 9690 Clarence Center Rd. EMS
All calls in Erie County, New York. Town of Clarence Center.
*/


public class NYAmherstParser extends SmartAddressParser {

	
	  @Override
	  public boolean isPageMsg(String body) {
		  return body.startsWith("CLA ");
	  }

	  @Override
	  protected void parse(String body, Data data) {
	    data.defState="NY";
	    data.defCity="AMHERST";
	    
	    if (body.contains("CLA ")){
	    body = body.substring(3);
	    body = body.trim();
	    }
	    String strAddr = "";

	    Pattern BOX = Pattern.compile("\\s[A-Z][A-Z][A-Z]");
	    Matcher match = BOX.matcher(body);
	    if (match.find()) {
	      strAddr = body.substring(0,match.start());
	      data.strCall = body.substring(match.start());
	    }
	    data.strCall = data.strCall.trim();
	    
	    strAddr = strAddr.trim();
	    
	    parseAddress(StartType.START_ADDR, strAddr, data);
	    data.strAddress = data.strAddress.replaceAll("\\.", "");



	  }
	}
	