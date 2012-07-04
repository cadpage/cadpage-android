package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/*
Halifax County, NC
Contact: Brandon Lindsey <blindseynfd@gmail.com>
Sender: HalifaxCoE911@HalifaxNC911.com

HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* JACKSON ST // 7TH ST* * * ROANOKE RAPIDS* * * * * WRECK NOPI* * * * C181,C182,FI14* * * * *
HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* HWY 158 // AVE* * * ROANOKE RAPIDS* * * * * WRECK NOPI* * * * EMS4,EMS6,FI14* * * * *
HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* 1403 EAST 10TH ST* * * ROANOKE RAPIDS* * * * * FIRE-ELEC* * * * FI14* * * * *
HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* PILAND ST* * * ROANOKE RAPIDS* * * * * SPECIAL ASSG* * * * F1402,FI14* * * * *
HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* SUBWAY // JULLIAN R ALLSBROOK* * * ROANOKE RAPIDS* * * * * WRECK NOPI* * * * FI14* * * * *
HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* 93 ROANOKE AVE* * * ROANOKE RAPIDS* * * * * FIRE-SMOKE* * * * FI14* * * * *

Contact: Trey Evans <treyevans1989@gmail.com>
Sender: halifaxcoe911@halifaxnc911.com
HalifaxCoE911:* 1159 BACON RD* * * LITTLETON* * * * * ARSON* * * * 122,FI21* * * * *
HalifaxCoE911:* ODELL LITTLETON RD // NEAR PANCEA SPRINGS* * * LITTLETON* * * * FIRE-BRUSH* * * * FI21* * * * *
HalifaxCoE911:* 110 WOODLAWN CT* * * LITTLETON* * * * * ALARM-FIRE* * * * FI21* * * * *
HalifaxCoE911:* FAUCETTE STORE RD // 158* * * LITTLETON* * * * * WRECK UNKPI* * * * FI21,MED1,R154,SHP1* * * *
HalifaxCoE911:* 105 SMOKETREE CT* * * LITTLETON* * * * * FIRE-CHECK* * * * FI21* * * * *
HalifaxCoE911:* 130 EAST END AVE* * * LITTLETON* * * * * FIRE-SMOKE* * * * FI21* * * * *
HalifaxCoE911:* 863 ODELL LITTLETON RD* * * LITTLETON* * * * * WRECK UNKPI* * * EMS1,FI21,MED1* * * * *
HalifaxCoE911:* 1515 GOLF COURSE RD* * * LITTLETON* * * * * FIRE-BRUSH* * * FI21* * * * *
HalifaxCoE911:* BIG REID RD* * * LITTLETON* * * * * FIRE-BRUSH* * * * F2101,FI21* * * * *
HalifaxCoE911:* HWY 903 // FLEMING DAIR RD* * * LITTLETON* * * * * FIRE-ELEC* * * * FI21* * * * *

*/
public class NCHalifaxCountyParser extends DispatchA3Parser {
  
  public NCHalifaxCountyParser() {
    super(0, "HalifaxCoE911:* ", "HALIFAX COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "HalifaxCoE911@HalifaxNC911.com";
  }
}
