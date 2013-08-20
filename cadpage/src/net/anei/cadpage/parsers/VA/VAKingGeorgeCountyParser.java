package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VAKingGeorgeCountyParser extends DispatchDAPROParser {
  
	  public VAKingGeorgeCountyParser() {
			 super(CITY_LIST, "KING GEORGE COUNTY", "VA");
			 setupCallList(CALL_SET);
	  }
	  
	  private static final CodeSet CALL_SET = new CodeSet(
        "ABDOMINAL PAIN",
        "ALLERGIC REACTION",
        "CHOKING",
        "DIFFICULTY BREATHING",
        "FIRE ALARM RESIDENTIAL",
        "ILLNESS",
        "MOTOR VEHICLE ACCIDENT",
        "MUTUAL AID TO (FIRE)",
        "MUTUAL AID TO (RESCUE)",
        "MVA OVERTURNED",
        "OVERDOSE",
        "PUBLIC SERVICE - FIRE DEPT"
	  );
	  
	  private static final String[] CITY_LIST = new String[]{
	    "PORT ROYAL"
	  };
}