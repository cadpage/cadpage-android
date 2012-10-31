package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;


public class NYBuffaloParser extends DispatchProQAParser {
  
  public NYBuffaloParser() {
    super("BUFFALO", "NY",
           "SKIP CALL CALL+? ADDR CITY ID! X:X");
  }
  
  @Override
  public String getFilter() {
    return "2002000004";
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace("/X=", "/X:");
    return super.parseMsg(body, data);
  }
}
