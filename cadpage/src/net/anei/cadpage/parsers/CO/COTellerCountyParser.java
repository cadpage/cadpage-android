package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class COTellerCountyParser extends FieldProgramParser {
  
  public COTellerCountyParser() {
    super("TELLER COUNTY", "CO",
           "Add:ADDR! Problem:CALL! Loc:PLACE");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() >= 87 &&
        body.substring(0,5).equals("PROB:") &&
        body.substring(40,45).equals("ADD: ") &&
        body.substring(75,79).equals("APT:") &&
        body.substring(84,88).equals("LOC:")) { 
     
      setFieldList("ADDR CALL APT PLACE");
      parseAddress(substring(body, 5, 40), data);
      data.strCall = substring(body, 45, 75);
      data.strApt = substring(body, 79, 84);
      data.strPlace = substring(body, 88, 108);
      return true;
    }
    
    // Second format is handled by field program parser
    return super.parseMsg(body,  data);
  }
}
