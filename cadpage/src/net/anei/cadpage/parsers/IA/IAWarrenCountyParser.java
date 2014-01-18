package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA38Parser;



public class IAWarrenCountyParser extends DispatchA38Parser {
  
  public IAWarrenCountyParser() {
    super("WARREN COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String field, Data data) {
    data.strSource = subject;
    return super.parseMsg(field, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
