package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;



public class IAMuscatineCountyParser extends DispatchShieldwareParser {
  
  public IAMuscatineCountyParser() {
    super("MUSCATINE COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "777,888";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    data.strSource = subject;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
