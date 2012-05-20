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
