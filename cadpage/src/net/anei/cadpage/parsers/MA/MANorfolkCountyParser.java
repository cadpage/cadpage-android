package net.anei.cadpage.parsers.MA;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;

/**
 * Norfolk County, MA
 */
public class MANorfolkCountyParser extends DispatchRedAlertParser {
  
  public MANorfolkCountyParser() {
    super("NORFOLK COUNTY","MA");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body,  data)) return false;
    if (data.strPlace.contains(",") || data.strPlace.contains("&")) {
      data.strName = data.strPlace;
      data.strPlace = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("PLACE", "NAME PLACE");
  }
}
