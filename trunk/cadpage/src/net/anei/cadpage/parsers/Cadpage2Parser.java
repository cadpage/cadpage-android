package net.anei.cadpage.parsers;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class Cadpage2Parser extends CadpageParserBase {
  
  @Override
  public String getLocName() {
    return "Standard Cadpage Format B";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Only valid if positive ID established
    if (!isPositiveId()) return false;
    
    // Otherwise, process fields broken by newlines and ignore
    // anything that doesn't start with a valid keyword
    for (String line : body.split("\n")) {
      int pt = line.indexOf(':');
      if (pt < 0) continue;
      String key = line.substring(0,pt).trim();
      String value = line.substring(pt+1).trim();
      Field field = getMapField(key);
      if (field == null) continue;
      field.parse(value, data);
    }
    return true;
  }

}
