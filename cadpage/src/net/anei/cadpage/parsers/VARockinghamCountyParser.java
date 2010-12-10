package net.anei.cadpage.parsers;

import java.util.Properties;

/*
Rockingham County, VA (class II)
Contact: Spencer Gibson <stgibs@gmail.com>
Sender: messaging@iamresponding.com or mailbox@hrecc.org

Some departments have a leading blank and some do not.  Other departments start
with a different code, but it will always be Rnn or Cnn.

R40 EMS-CARDIAC CONDITION 1751 MAIN AVE HAR CFS# 2010-082726 CROSS: GARBERS CHURCH RD/S HIGH ST
R40 EMS-MENTAL PROBLEM 445 N MAIN ST 44 HAR CFS# 2010-082451 CROSS: WOLFE ST/ROCK ST
R40 EMS-ABDOMINAL PAIN 1737 MORELAND DR HAR CFS# 2010-083119 CROSS: PHEASANT RUN CIR/ASHFORD CT
R40 EMS-CHEST PAIN 235 LAYMAN ST 101 HAR CFS# 2010-083046 CROSS: N MAIN ST/LONGVIEW DR
R40 TRAFFIC CRASH 300 BOYERS RD BLK HAR CFS# 2010-082984 CROSS: MYSTIC WOODS LN/CULLISON CT
R40 TRAFFIC CRASH RESERVOIR ST & CANTRELL AV HAR CFS# 2010-082327
(Rescue 40) R40 ODOR INVESTIGATION IN STRUCTUR 290 WARREN SERVICE DR HAR CFS# 2010-091415 CROSS: BLUESTONE DR/DEAD END
*/

public class VARockinghamCountyParser extends DispatchDAPROParser {
  
  private static final String DEF_STATE = "VA";
  private static final String DEF_CITY = "ROCKINGHAM COUNTY";
  
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
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
        "SHE", "SHENANDOAH"
    });
  
	  
	  public VARockinghamCountyParser() {
			 super(CITY_CODE_TABLE, DEF_CITY, DEF_STATE);
	  }
	  
	  @Override
	  public String getFilter() {
	    return "messaging@iamresponding.com,mailbox@hrecc.org";
	  }
}