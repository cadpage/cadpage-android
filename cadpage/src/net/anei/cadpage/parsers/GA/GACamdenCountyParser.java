package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/*
Camden County, GA
Contact: "croney kingslandgeorgia.com" <croney@kingslandgeorgia.com>
Sender: astudstill@co.camden.ga.us
astudstill@co.camden.ga.us:2011-101695* HIGHWAY 17 STEFFANS* * * KINGSLAND* * Traffic Stop* TRAFFIC STOP* * * 1128,1140,1150,1152,509,514,523,532,LS3,R3* * Med
astudstill@co.camden.ga.us:2011-104696* 4059 MARTIN LUTHER KING BLVD* N4* * 514,541,546,ENG4,LS4,MED4 KINGSLAND* * INJURY* INJURY* 509,ENG5,LS3* * Medical: No
astudstill@co.camden.ga.us:2011-101995* 405 & HIGHWAY 40 OLD WAFFLE HOUSE* * * KINGSLAND* * ACCIDENT* ACCIDENT* ELAINE* 386-208-4465* 514,541,546,ENG4,LS4,MED4

astudstill@co.camden.ga.us:2011-104843* 429 EAGLE BLVD* * * KINGSLAND* * PERSON SICK* PERSON SICK* * 540,ENG4,LS4* * Medical: No* Haz
214 REDWOOD ST* * * KINGSLAND* * PERSON SICK* PERSON SICK* MS FAGEN*912-269-6157* LS3,R3* * Medical: No* Hazards: No* 

Contact:  Jeff <kfr438@tds.net>
astudstill@co.camden.ga.us:2011-181161* ADVANCE COLLISION CENTER* * * KINGSLAND* * WIRE DOWN* WIRE DOWN* JOHN* 316-258-1559* ENG4,LS4* * Medical: No* Haz

*/
public class GACamdenCountyParser extends DispatchA3Parser {
  
  public GACamdenCountyParser() {
    super("CAMDEN COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "astudstill@co.camden.ga.us";
  }
}
