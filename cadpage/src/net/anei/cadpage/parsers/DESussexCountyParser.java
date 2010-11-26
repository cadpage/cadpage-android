package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser.StartType;

/*
 * [86 EMS] -- 31C2 -- 33384 Hartford Ct Lewes
[86 EMS] -- 33A1 -- 36101 Seaside Blvd Rehoboth
[86 EMS] -- 17A1 -- 18958 Coastal Hwy Lewes
[86 Fire] -- F - Auto Fire Alarm -- Hallmark, Parcel Post, Safeway -- 19266 Coastal Hwy Rehoboth -- INC #602
[86 Fire] -- F - Standby -- Bethany Beach Station 70 Rehoboth Beach -- INC #599
[83 FIRE] -- Traffic/TransportationAcdntALS -- 228 W Dupont Hwy Millsboro 19966 -- Food Lion (83)
[83 FIRE] -- Vehicle Fire -- 26026 Patriots Way Georgetown 19947 -- Sussex Central High School
[83 FIRE] -- Carbon Monoxide Detector -- 28 Patterson Dr Georgetown 19947 
[83 FIRE] -- Washdown (Fuel Spill) -- 26972 - 28044 Zoar Rd Georgetown 19947
[83 FIRE] -- Traffic/TransportationAcdntBLS -- 0 Dupont Blvd & Av Of Honor Georgetown 19947
[83 FIRE] -- Structure Fire -- 0 JOHNSON RD & JESTICE FARM RD Laurel 19956
[83 FIRE] -- Cardiac/Resp./Death-ALS -- 28723 Woodcrest Dr Harbeson 19951
 */


public class DESussexCountyParser extends SmartAddressParser {

	
	  @Override
	  public boolean isPageMsg(String body) {
		  return body.contains("] -- ");
	  }

	  @Override
	  protected void parse(String body, Data data) {
	    data.defState="DE";

	    int ipt = body.indexOf('-');
	    if (ipt >= 0) body = body.substring(ipt+2).trim();

	    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, body, data);
	    //body = getLeft();
	    // if Call still has -- in it at end remove.
	    if (data.strCall.contains("--")){
	    	int idx = data.strCall.indexOf("-");
	    	data.strCall = data.strCall.substring(0,idx);
	    }
	    data.strCall = data.strCall.trim();
	    data.strSupp=getLeft();	    



	  }
	}
	

