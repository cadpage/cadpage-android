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
    // Except for lines following an INFO: keyword, which we
    // assume result from a long INFO string that contains line breaks
    boolean info = false;
    for (String line : body.split("\n")) {
      int pt = line.indexOf(':');
      if (pt < 0) continue;
      String key = line.substring(0,pt).trim();
      String value = line.substring(pt+1).trim();
      Field field = getMapField(key);
      if (field != null) {
        info = key.equals("INFO");
        field.parse(value, data);
      } else if (info) {
        data.strSupp = append(data.strSupp, "\n", line);
      }
    }
    return true;
  }

}
