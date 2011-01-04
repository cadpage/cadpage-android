package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

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
public class VAFrederickCountyParser extends SmsMsgParser {
  
  public VAFrederickCountyParser() {
    super("FREDERICK COUNTY", "VA");
  }
  
  @Override
  public String getFilter() {
    return "CAD@co.frederick.va.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    if (!body.startsWith("CAD:")) return false;
    
    body = body.trim();
    String[] AData = body.split(";");
    
    
    
    if (AData.length <= 1) return false;
    AData[0] = AData[0].substring(4);
    parseAddress(AData[0].replace("-", " ").trim(), data);
    data.strCall = AData[1];
    if (AData.length <= 2) return true;
    if (AData[2].contains("[")) {
        //this is a comment not a cross street.
      data.strSupp = AData[2];
      return true;
    }
    for (int ndx = 2; ndx<AData.length; ndx++) {
      if (data.strCross.length() > 0) data.strCross += "/";
      data.strCross += AData[ndx].trim();
    }
    
    
    
    return true;
  }
}