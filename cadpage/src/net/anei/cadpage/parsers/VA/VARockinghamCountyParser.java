package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VARockinghamCountyParser extends DispatchDAPROParser {
	  
	  public VARockinghamCountyParser() {
			 super(CITY_CODES, "ROCKINGHAM COUNTY", "VA");
			 setupCallList(CALL_SET);
	  }
	  
	  @Override
	  public String getFilter() {
	    return "messaging@iamresponding.com,mailbox@hrecc.org,@c-msg.net";
	  }
	  
	  @Override
    protected boolean parseMsg(String body, Data data) {
      if (!super.parseMsg(body, data)) return false;
      
      // Not sure what the city of lexington is putting in
      // source field, but it certainly is not a source.
      if (data.strSource.length() > 0 && Character.isDigit(data.strSource.charAt(0))) {
        data.strBox = data.strSource;
        data.strSource = "";
      }
      return true;
    }
	  
	  @Override
	  public String getProgram() {
	    return "BOX " + super.getProgram();
	  }

    private static final CodeSet CALL_SET = new CodeSet(
        "ABDOMINAL PAIN",
        "ACCIDENT NO INJURY",
        "ACCIDENT WITH INJURY",
        "ACCIDENT WITH INJURY MOUNTAIN",
        "ALLERGIC REACTION",
        "BRUSH FIRE GREATER THAN 50' AW",
        "CARDIAC ARREST",
        "CHEST PAINS",
        "CHEST PAINS/CARDIAC",
        "CHIMNEY FIRE",
        "CHIMNEY FIRE DEER HAVEN",
        "CHIMNEY FIRE OLD BUENA",
        "COMMERCIAL NATURAL GAS/PROPANE",
        "COMMERCIAL VEHICLE FIRE",
        "DIFFICULTY BREATHING",
        "EMS-ABDOMINAL PAIN",
        "EMS-CARDIAC CONDITION",
        "EMS-CHEST PAIN",
        "EMS-DIFFICULTY BREATHING",
        "EMS-FALLS",
        "EMS-MENTAL PROBLEM",
        "EMS SERVICE CALL",
        "EMS-STROKE",
        "EMS-TRAUMA INJURIES",
        "FALL",
        "FIRE ALARM",
        "FIRE SERVICE CALL",
        "FIRE SERVICE CALL BOUNDARY",
        "FLUID LEAK FROM VEHICLE NO INJ",
        "FRACTURE",
        "GENERAL ILLNESS",
        "HAZARDOUS MATERIALS CALL",
        "INJURIES FROM A FALL",
        "INJURY - LEG, ARM, ETC.",
        "MEDICAL ALARM/LIFELINE ALARM",
        "PSYCHIATRIC EMERGENCY",
        "SEIZURES",
        "SHORT OF BREATH/DIFF BREATHING",
        "SMOKE IN THE AREA",
        "STRUCTURE FIRE",
        "SWIFT WATER TEAM CALL",
        "TECHNICAL RESCUE CALL NICHOLS HALL",
        "TRAFFIC CRASH",
        "UNKNOWN MEDICAL EMERGENCY",
        "UNRESPONSIVE",
        "VEHICLE FIRE"
	  );
	  
	  private static final Properties CITY_CODES = buildCodeTable(new String[]{
        "BER", "BERGTON",
        "BRO", "BROADWAY",
        "BRI", "BRIDGEWATER",
        "BUE", "BUENA VISTA",
        "CLO", "CLOVER HILL",
        "DAY", "DAYTON",
        "ELK", "ELKTON",
        "FAI", "FAIRFIELD",
        "GLA", "GLASGOW",
        "GRO", "GROTTOES",
        "HAR", "HARRISONBURG",
        "HIN", "HINTON",
        "KEE", "KEEZLETOWN",
        "LEX", "LEXINGTON",
        "LUR", "LURAY",
        "MCG", "MCGAHEYSVILLE",
        "MOU", "MOUNT CRAWFORD",
        "NAT", "NATURAL BRIDGE",
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