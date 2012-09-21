package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/***
Pittsylvania, VA (replacement or alternate)

701:CAD:TRAFFIC ACCIDENT PI;100 MALMAISON RD/U S HIGHWAY NO 29; BLA
700:CAD:ABDOMINAL DISTRESS; 701 E WITT RD;BLA;WITT LN;MOUNT VIEW RD;[Medical Priority Info] PROBLEM:CHEST HURTING #PATS: 1 AGE: 77 Years SEX: Male
699:CAD:RESPIRATORY DISTRESS;600 NORTH POINTE LN;DAN;SEMINOLE DR;[Medical Priority Info] PROBLEM: TROUBLE BREATHING #PATS: 1 AGE: 5 Months SEX
698:CAD:RESPIRATORY DISTRESS;1000 LAWLESS CREEK RD;BLA;PRITCHETT LN;DAKE DR;[Medical Priority Info] PROBLEM: DIFF BREATHING #PATS: 1 AGE: 13 Y
697:CAD:OTHER FIRE EMERGENCY;7180 U S HIGHWAY NO 29;BLA;DANVILLE EXPW;GEORGES LN
696:CAD:CHOKING; 1824 FALL CREEK DR;DAN;U S HIGHWAY NO 29;[Medical Priority Info] PROBLEM: Verified COMPLETE obstruction (choking) # PATS: 1 AGE
695:CAD:ALL OTHER MEDICAL EMERGENCIES;316 WAREHOUSE RD;BLA;BLAIRS CIR;[Medical Priority Info] PROBLEM: MALE WITH SIDE PAIN, UNABLE TO GET UP #
694:CAD:UNKNOWN FIRE;7180 U S HIGHWAY NO 29;BLA;DANVILLE EXPW;GEORGES LN;REC A CALL FROM A SUBJECT AT THE PROPERTY REPORTING A SMELL OF GAS
693:CAD:DIABETIC;228 BETHEL RD;DAN;BETHEL CT;[Medical Priority Info] PROBLEM: female sugar is high # PATS: 1 AGE: 83 Years SEX: Female CONSCIOU

Contact: David Morgan <djmorgan911@gmail.com>
Sender: CAD@pittgov.org
1357:CHEST PAINS;1855 RAINBOW CIR;DAN;2011044707;BUCKHORN DR;POWHATAN DR;[Medical Priority Info] PROBLEM: CHEST PAINS AND SWEATING, NAUSEUA # PATS: 1 AGE: 39 Years
1363:EMS CALL FOR PROQA;12321 FRANKLIN TPKE;CHA;2011045077;F C BEVERLY RD;STRAWBERRY RD;[Medical Priority Info] PROBLEM: DIZZY SPELLS # PATS: 1 AGE: 85 Years SEX: F
1358:HEMORRHAGING;438 BONNY AVE;CAS;2011044807;PEACEFUL LN;SERENE CT;[Medical Priority Info] PROBLEM: BLEEDING FRON URINE AND BOWEL MOMENT # PATS: 1 AGE: 47 Years S
1360:RESPIRATORY DISTRESS;113 HUNTERS RDG;DAN;2011044913;HUNTERS TRL;HUNTERS CHASE;[Medical Priority Info] PROBLEM: HUSBAND TROUBLE BREATHING&CHEST PAINS # PATS: 1
1366:EMS CALL FOR PROQA;127 MEDICAL CENTER RD;DAN;2011045246;MOUNT CROSS RD;HINESVILLE RD
1365:ENTRAPMENT;127 MEDICAL CENTER RD;DAN;2011045245;MOUNT CROSS RD;HINESVILLE RD
1367:UNKNOWN MEDICAL EMERGENCY;1976 HILL CREEK RD;DRY;2011045254;SUNSET DR;MOUNT CROSS RD;[Medical Priority Info] PROBLEM: MEDICAL ALARM # PATS: 1 AGE: Unknown Rang
1364:EMS CALL FOR PROQA;1976 HILL CREEK RD;DRY;2011045231;SUNSET DR;MOUNT CROSS RD;[Medical Priority Info] PROBLEM: MEDICAL ALARM # PATS: 1 AGE: Unknown Range SEX:
1384:FALL;2837 MAPLETON DR;CAL;2011046603;WATER OAK RD;FRANKLIN TPKE;[Medical Priority Info] PROBLEM: FELL FROM LADDR BROKE HIP # PATS: 1 AGE: 85 Years SEX: Male CO

***/

public class VAPittsylvaniaCountyParser extends DispatchOSSIParser {
 
  private static final Pattern LEADER = Pattern.compile("^\\d+:(?!CAD:)");
  public VAPittsylvaniaCountyParser() {
    super(CITY_CODES, "PITTSYLVANIA COUNTY", "VA",
           "ID: CALL ADDR! CITY! ID? X? X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pittgov.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = LEADER.matcher(body);
    if (match.find()) {
      body = body.substring(0,match.end()) + "CAD:" + body.substring(match.end());
    }
    return super.parseMsg(body, data);
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{10}"));
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }

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
}
