package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

public class MIMuskegonCountyParser extends SmsMsgParser {
  
  @Override
  public String getFilter() {
    return "cad@mcd911.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("CAD:FYI:")) return false;
    
    data.defState="MI";
    data.defCity = "MUSKEGON COUNTY";
    
    body = body.trim();
    String[] AData = body.split(";");
    
    if (AData.length <= 1) return false;
    data.strCall = "Unkown";
    
    if (AData.length <= 2) return false;
    parseAddress(AData[1].replace("-", " "), data);
    
    if (AData.length <= 2) return false;
    data.strCross = AData[2];
    
    if (AData.length >= 3) {
    	data.strCross = data.strCross + "/" + AData[3];
    }
    if (AData.length >= 4){
    	data.strSupp = AData[4];
    }
    return true;
  }
}
