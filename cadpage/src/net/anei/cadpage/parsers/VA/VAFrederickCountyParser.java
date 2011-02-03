package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchAParser;

/*
Frederick County, VA
Contact: Timothy Vaught <tvaught5388@gmail.com>
Sender: CAD@co.frederick.va.us
CAD:107 HICKORY HILL DR;GENERAL ILL-NEW ONSET IMMOBILE;LAUREL HILL DR;LAKESIDE DR
CAD:458 HITES RD;UNCON/FAINT-UNCON/BREATHING;CARSON LN;GEM DR
CAD:2044-79 FAIRFAX PIKE;PREGNANCY-LABOR;APPRENTICE LN
CAD:250 COSTELLO DR;FILL STATION;FRONT ROYAL PIKE;PRINCE FREDERICK DR
CAD:3632 VALLEY PIKE;FALL - POSS DANGEROUS;COMMONWEALTH CT;FAY ST
 */
public class VAFrederickCountyParser extends DispatchAParser {
  
  public VAFrederickCountyParser() {
    super("FREDERICK COUNTY", "VA",
           "ADDR CALL! X? X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@co.frederick.va.us";
  }
}