package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/**
 * Stamford, CT
 */
public class CTStamfordParser extends MsgParser {
  
  public CTStamfordParser() {
    super("STAMFORD", "CT");
    setFieldList("ADDR CITY APT X NAME CALL");
  }

  @Override
  public String getFilter() {
    return "SFD.NoReply@StamfordCT.Gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Stamford 911")) return false;
    
    FParser fp = new FParser(body);
    parseAddress(fp.get(30), data);
    if (!fp.check(",")) return false;
    data.strCity = fp.get(8);
    if (!fp.check(",CT.")) return false;
    data.strApt = fp.get(8);
    
    if (fp.checkAhead(56, "F ")) {
      data.strCross = fp.get(22); 
      data.strName = fp.get(34);
      data.strCall = fp.get();
    } 
    
    else {
      data.strCross = fp.get(20);
      data.strName = fp.get(52);
      data.strCall = fp.get(30);
    }
    return true;
  }
}
