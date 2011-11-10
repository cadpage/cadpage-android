package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/*
Franklin County, VA
Contact: Larry Davids <davidsla07@gmail.com
Sender: mailbox@franklincountyva.org

MAILBOX:S07 EMS-OTHER/DEFINE 18360 VIRGIL H GOODE HWY 124 RMT CFS# 2010-030542 CROSS: SHADY LN/BLACKWATER RIVER
MAILBOX:S07 EMS-CHEST PAIN 413 WOODDALE DR RMT CFS# 2010-030355 CROSS: VIRGIL H GOODE HWY/DEAD END
MAILBOX:S07 EMS-PATIENT FALLEN 3005 GREEN LEVEL RD RMT CFS# 2010-030541 CROSS: GRASSY HILL RD/LITTLE MOUNTAIN DR
MAILBOX:S07 EMS-CARDIAC VIRGIL H GOODE HWY & LINK ST RMT CFS# 2010-030580
MAILBOX:S07 EMS-HIGH BLOOD PRESSURE 1808 BETHLEHEM RD BML CFS# 2010-030643 CROSS: BETHANY RD/DILLONS MILL RD
MAILBOX:C07 FIRE-ALARM COMMERCIAL 3325 GRASSY HILL RD RMT CFS# 2010-033866 CROSS: JAMESTOWN RD/CALLAWAY RD

Contact: dot.jspencer@gmail.com
S: M:MAILBOX:S02 ACCIDENT-INJURY 1450 WIRTZ CFS# 2011-028395\n

*/

public class VAFranklinCountyParser extends DispatchDAPROParser {
  
/*
Listed alphabetically.
Areas in Franklin County listed first.
Surrounding areas overlapping Franklin County listed next

Other areas that are still needed - based on Zip Code Addressing
      "XXX", "Ferrum"
      "XXX", "Glade Hill"
      "XXX", "Henry"
      "XXX", "Penhook"
      "XXX", "Redwood"
      "XXX", "Union Hall"
      "XXX", "Wirtz"
*/
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
      "BML", "Boones Mill",
      "CAL", "Callaway",
      "RMT", "Rocky Mount",	  
      "BAS", "Bassett",	  
      "HAR", "Hardy",
      "MAR", "Martinsville"
      });

  
  public VAFranklinCountyParser() {
    super(CITY_CODE_TABLE, "FRANKLIN COUNTY", "VA");
  }
      
  
  @Override
  public String getFilter() {
    return "mailbox@franklincountyva.org";
  }

}