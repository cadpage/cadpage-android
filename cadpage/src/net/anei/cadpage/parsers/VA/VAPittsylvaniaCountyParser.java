package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/***
701:CAD:TRAFFIC ACCIDENT PI;100 MALMAISON RD/U S HIGHWAY NO 29; BLA
700:CAD:ABDOMINAL DISTRESS; 701 E WITT RD;BLA;WITT LN;MOUNT VIEW RD;[Medical Priority Info] PROBLEM:CHEST HURTING #PATS: 1 AGE: 77 Years SEX: Male
699:CAD:RESPIRATORY DISTRESS;600 NORTH POINTE LN;DAN;SEMINOLE DR;[Medical Priority Info] PROBLEM: TROUBLE BREATHING #PATS: 1 AGE: 5 Months SEX
698:CAD:RESPIRATORY DISTRESS;1000 LAWLESS CREEK RD;BLA;PRITCHETT LN;DAKE DR;[Medical Priority Info] PROBLEM: DIFF BREATHING #PATS: 1 AGE: 13 Y
697:CAD:OTHER FIRE EMERGENCY;7180 U S HIGHWAY NO 29;BLA;DANVILLE EXPW;GEORGES LN
696:CAD:CHOKING; 1824 FALL CREEK DR;DAN;U S HIGHWAY NO 29;[Medical Priority Info] PROBLEM: Verified COMPLETE obstruction (choking) # PATS: 1 AGE
695:CAD:ALL OTHER MEDICAL EMERGENCIES;316 WAREHOUSE RD;BLA;BLAIRS CIR;[Medical Priority Info] PROBLEM: MALE WITH SIDE PAIN, UNABLE TO GET UP #
694:CAD:UNKNOWN FIRE;7180 U S HIGHWAY NO 29;BLA;DANVILLE EXPW;GEORGES LN;REC A CALL FROM A SUBJECT AT THE PROPERTY REPORTING A SMELL OF GAS
693:CAD:DIABETIC;228 BETHEL RD;DAN;BETHEL CT;[Medical Priority Info] PROBLEM: female sugar is high # PATS: 1 AGE: 83 Years SEX: Female CONSCIOU
 
***/

public class VAPittsylvaniaCountyParser extends DispatchOSSIParser {


  private static final Properties CITY_CODES= buildCodeTable(new String[]{
		  "BLA","Blairs",
		  "DAN","Danville",
		  "GRE","Gretna",
		  "CHA","Chatham",
		  "CAL","Callands",
		  "CAS","Cascade",
		  "DRY","Dry Fork",
		  "HUR","Hurt",
		  "JAV","Java",
		  "KEE","Keeling",
		  "PIT","Pittsville",
		  "RIN","Ringgold",
		  "SAN","Sandy Level",
		  "SUT","Sutherlin",
		  "LON","Long Island",
        });
  
  public VAPittsylvaniaCountyParser() {
    super(CITY_CODES, "PITTSYLVANIA COUNTY", "VA",
           "ID: CALL ADDR! CITY X? X? INFO+");
  }
}
