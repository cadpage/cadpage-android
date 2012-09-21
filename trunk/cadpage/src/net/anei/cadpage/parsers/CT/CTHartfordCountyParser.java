package net.anei.cadpage.parsers.CT;

import java.util.Properties;

/*
Farmington, CT
Contact: "J. Neves" <jneves@effd.org>
Contact: Vincenzo <vgarcia1322@comcast.net>
Sender: pdpaging@farmington-ct.org

1100024685 MEDICAL CALL CHARLIE RESPONSE 00088  SCOTT SWAMP RD   UM1 XXFF AMR1 111117 15:13
1200006652 FIRE - BRUSH FIRE 01825 FARMINGTON AVE Prem Map -  PARK POND PL/SOUTH MAIN ST  XXTH 120409 11:05\r\n\r
1200006665 FIRE - MV  00270 FARMINGTON AVE Prem Map -  TALCOTT NOTCH RD/PARK DR  EXOG UE1 XXEF 120409 15:40\r\n\r
1200006659 FIRE - BRUSH FIRE SPIELMAN HWY/ MOUNTAIN SPRING RD   LC1 XXBF 120409 13:26\r\n\r
1200006653 MEDICAL CALL BRAVO RESPONSE 00204 MAIN ST BIDWELL SQ/ROURKE PL  XXFF AMR1 120409 11:12\r\n\r
1200006626 FIRE - SMOKE/GAS INVEST OUTSIDE 00339 MEADOW RD SOMERSBY WAY/JUDSON LA  EXSW XXFF 120409 00:12\r\n\r
1200006038 MEDICAL CALL CHARLIE RESPONSE 00051 LITCHFIELD RD PLAINVILLE AVE/BIRCH ST  UM1 XXTH AMR1 120330 20:14\r\n\r

*/

public class CTHartfordCountyParser extends CTNewHavenCountyBParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{});
  
  public CTHartfordCountyParser() {
    super(CITY_CODES, "HARTFORD COUNTY", "CT");
  }
  
  public CTHartfordCountyParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
  }
  
  @Override
  public String getFilter() {
    return "pdpaging@farmington-ct.org";
  }
}
