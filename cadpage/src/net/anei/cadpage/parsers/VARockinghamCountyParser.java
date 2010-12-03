package net.anei.cadpage.parsers;

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
*/

public class VARockinghamCountyParser extends DispatchDAPROParser {
  
  private static final String DEF_STATE = "VA";
  private static final String DEF_CITY = "ROCKINGHAM COUNTY";
	  
	  public VARockinghamCountyParser() {
			    setDefaults(DEF_CITY, DEF_STATE);
	  }
			  
}