package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Muskegon County, MI 
Contact: john@duffhouse.net
sender: cad@mcd911.net
CAD:FYI: ;7610 EASY ST;BENSTON RD;WHITEHALL RD;MED1
CAD:FYI: ;322 E MUSKEGON AV;S LIVINGSTON ST;S BALDWIN ST;WIRED
CAD:FYI: ;1387 W HOLTON WHITEHALL RD;AUTOMOBILE RD;HYDE PARK RD;MED1
CAD:FYI: ;823 S LIVINGSTON ST;E MUSKEGON AV;E LEWIS ST;MED1
CAD:FYI: ;2715 N WEBER RD;DULEY DR;W MCMILLAN RD;FGRAS
CAD:FYI: ;4252 W BARD RD;SIMONELLI RD;ORSHAL RD;FAR
CAD:FYI: ;N WEBER RD/W MICHILLINDA RD;PI1
 */
public class MIMuskegonCountyParser extends SmsMsgParser {
  
  public MIMuskegonCountyParser() {
    super("MUSKEGON COUNTY", "MI");
  }
  
  @Override
  public String getFilter() {
    return "cad@mcd911.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("CAD:FYI:")) return false;
    
    body = body.trim();
    String[] AData = body.split(";");
    
    data.strCall = "Unkown";
    
    if (AData.length <= 1) return false;
    parseAddress(AData[1].replace("-", " ").trim(), data);
    
    if (AData.length <= 2) return true;
    for (int ndx = 2; ndx<AData.length-1; ndx++) {
      if (data.strCross.length() > 0) data.strCross += "/";
      data.strCross += AData[ndx].trim();
    }
    
    data.strSupp = AData[AData.length-1];
    
    return true;
  }
}
