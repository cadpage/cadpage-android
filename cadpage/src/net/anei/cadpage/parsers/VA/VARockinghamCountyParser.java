package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VARockinghamCountyParser extends DispatchDAPROParser {
	  
	  public VARockinghamCountyParser() {
			 super(CITY_CODES, "ROCKINGHAM COUNTY", "VA");
			 setupCallList(CALL_SET);
	  }
	  
	  @Override
	  public String getFilter() {
	    return "messaging@iamresponding.com,mailbox@hrecc.org";
	  }
	  
	  private static final CodeSet CALL_SET = new CodeSet(
        "EMS-ABDOMINAL PAIN",
        "EMS-CARDIAC CONDITION",
        "EMS-CHEST PAIN",
        "EMS-DIFFICULTY BREATHING",
        "EMS-FALLS",
        "EMS-MENTAL PROBLEM",
        "EMS-STROKE",
        "EMS-TRAUMA INJURIES",
        "TRAFFIC CRASH"
	  );
	  
	  private static final Properties CITY_CODES = buildCodeTable(new String[]{
        "BER", "BERGTON",
        "BRO", "BROADWAY",
        "BRI", "BRIDGEWATER",
        "HAR", "HARRISONBURG",
        "SIN", "SINGERS GLEN",
        "CLO", "CLOVER HILL",
        "HIN", "HINTON",
        "MOU", "MOUNT CRAWFORD",
        "TIM", "TIMBERVILLE",
        "DAY", "DAYTON",
        "GRO", "GROTTOES",
        "MCG", "MCGAHEYSVILLE",
        "PEN", "PENN LAIRD",
        "ELK", "ELKTON",
        "WEY", "WEYERS CAVE",
        "NEW", "NEW MARKET",
        "STA", "STANLEY",
        "LUR", "LURAY",
        "SHE", "SHENANDOAH",
        "KEE", "KEEZLETOWN"
    });
}