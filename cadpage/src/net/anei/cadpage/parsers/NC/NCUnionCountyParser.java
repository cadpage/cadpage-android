package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Union County, NC
Contact: David Bruce <dbruce0571@gmail.com>
Sender: cad@uc.co.union.nc.us

CAD:3711 WHITE STORE RD;WINGATE;OUTSIDE FIRE;S09;WITMORE RD;NASH RD;02/15/2011 13:21:38
CAD:3812 E HWY 74;WINGATE;SICK PERSON EMD;S09;FX-CF2;BIVENS ST;N STEWART ST;02/18/2011 16:03:05;FOOD LION WINGATE

Contact: James Murray <jmurray1555@gmail.com>
Sender: CAD@co.union.nc.us
CAD:3626 HAYES RD;INDIAN TRAIL;BREATHING PROBLEMS EMD;S19;BR-2;OLD CHARLOTTE HWY;OLD CHARLOTTE HWY;09/26/2011 19:37:34

*/

public class NCUnionCountyParser extends DispatchOSSIParser {
  
  public NCUnionCountyParser() {
    super("UNION COUNTY", "NC",
           "ADDR CITY CALL SRC! INFO X X SKIP PLACE");
  }
  
  @Override
  public String getFilter() {
    return "cad@uc.co.union.nc.us,cad@webmail.co.union.nc.us,cad@co.union.nc.us";
  }
}
