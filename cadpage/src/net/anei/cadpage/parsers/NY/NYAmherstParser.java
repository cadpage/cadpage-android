package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;


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


public class NYAmherstParser extends SmsMsgParser {
  
    private static final Pattern BOX = Pattern.compile("\\s[A-Z][A-Z][A-Z]\\.?\\s");
    
    public NYAmherstParser() {
      super("AMHERST", "NY");
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) { 

	    if (! body.startsWith("CLA ")) return false;
	    
	    body = body.substring(4).trim();
	    String strAddr = "";
	    
	    Matcher match = BOX.matcher(body);
	    if (!match.find()) return false;
	    strAddr = body.substring(0,match.start()).trim();
	    data.strCall = body.substring(match.start()).trim();
	    
	    parseAddress(strAddr, data);
	    
	    return true;
	  }
	}
	