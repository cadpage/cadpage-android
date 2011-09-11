

package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/*
Chattam County, NC
Contact: Bill <leatherheadfirefighter@yahoo.com>
Sender: @chathamnc.org

FRM:HEATHER.BOONE@chathamnc.org
MSG:HEATHER.BOONE:399 LYNDFIELD CLOSE PITTSBORO MDL 10D04 1119468 18:13:33 Chest Pains- Clammy HUSBAND HAVING CHEST PAINS - EMER

FRM:HEATHER.BOONE@chathamnc.org
MSG:HEATHER.BOONE:791 RED GATE RD PITTSBORO 1119520 05:38:59 medical call HUSBAND OFF BALCONY

1 of 2
FRM:LISA.SCOTT@chathamnc.org
MSG:LISA.SCOTT:965 SEAFORTH BEACH RD PITTSBORO 1119461 17:08:12 medical call 10YOM WEARING WHITE SHORTS
(Con't) 2 of 2
NAMED TRAY LAST SEEN APPROX 4 MINS AGO(End)

1 of 2
FRM:KIM.HANNER@chathamnc.org
MSG:KIM.HANNER:858 BRUMLEY PITTSBORO MDL 31C02 1119495 22:11:57 Unconscious / Fainting (Near) Fainting
(Con't) 2 of 2
episodes an WIFE PASSED OUT, IS CONS NOW(End)

1 of 2
FRM:KIM.HANNER@chathamnc.org
MSG:KIM.HANNER:475 NATURE TRAIL RD CHAPEL HILL 1119504 00:09:15 Convulsions/ Seizures- CONTINUOUS or
(Con't) 2 of 2
MULTIPLE seiz PREVIOUS CALL FOR THIS ADDRESS WITH THIS NUMBER GIVEN BY CARY PD UNKNOWN PROBLEM POSSIBLE SEIZURES(End)
*/

public class NCChathamCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]{
    "FEARRINGTON",
    "GOLDSTON",
    "PITTSBORO",
    "SILER CITY",
    "CHAPEL HILL",
    
    "BEAR CREEK",
    "BENNETT",
    "BONLEE",
    "BRICKHAVEN",
    "BYNUM",
    "CARBONTON",
    "CORINTH",
    "CRUTCHFIELD CROSSROADS",
    "GULF",
    "HAYWOOD",
    "MONCURE",
    "SILK HOPE",
    "WILSONVILLE"
  };

  public NCChathamCountyParser() {
    super(CITY_LIST, "CHATHAM COUNTY", "NC");
    
    
  }
  @Override
  public String getFilter() {
    return "@chathamnc.org";
  }
  

}
