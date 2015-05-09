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
	      "ABDOMINAL PAIN",
	      "ALLERGIC REACTION",
	      "CARDIAC ARREST",
	      "CHEST PAINS",
	      "DIFFICULTY BREATHING",
        "EMS-ABDOMINAL PAIN",
        "EMS-CARDIAC CONDITION",
        "EMS-CHEST PAIN",
        "EMS-DIFFICULTY BREATHING",
        "EMS-FALLS",
        "EMS-MENTAL PROBLEM",
        "EMS-STROKE",
        "EMS-TRAUMA INJURIES",
        "FRACTURE",
        "GENERAL ILLNESS",
        "INJURIES FROM A FALL",
        "INJURY - LEG, ARM, ETC.",
        "PSYCHIATRIC EMERGENCY",
        "SEIZURES",
        "SMOKE IN THE AREA",
        "TRAFFIC CRASH",
        "VEHICLE FIRE"
	  );
	  
	  private static final Properties CITY_CODES = buildCodeTable(new String[]{
        "BER", "BERGTON",
        "BRO", "BROADWAY",
        "BRI", "BRIDGEWATER",
        "CLO", "CLOVER HILL",
        "DAY", "DAYTON",
        "ELK", "ELKTON",
        "GRO", "GROTTOES",
        "HAR", "HARRISONBURG",
        "HIN", "HINTON",
        "KEE", "KEEZLETOWN",
        "LUR", "LURAY",
        "MCG", "MCGAHEYSVILLE",
        "MOU", "MOUNT CRAWFORD",
        "NEW", "NEW MARKET",
        "PEN", "PENN LAIRD",
        "SHE", "SHENANDOAH",
        "RIL", "RILEYVILLE",
        "SIN", "SINGERS GLEN",
        "STA", "STANLEY",
        "TIM", "TIMBERVILLE",
        "WEY", "WEYERS CAVE"
    });
}