package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCNashCountyParser extends DispatchOSSIParser {
  
  public NCNashCountyParser() {
    super("NASH COUNTY", "NC",
           "SKIP ADDR! SKIP SKIP CITY! UNK EMPTY? CALL! SKIP PLACENAME UNK UNIT UNK SRC INFO+");
  }
  
  @Override
  public String getFilter() {
    return "nash911@nashcountync.gov,9300";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    if (!body.startsWith("NASH911:")) return false;
    body = body + " ";
    return parseFields(body.split("\\* "), data);
  }
  
  @Override
  protected boolean checkPlace(String field) {
    return !field.contains(",");
  }
}
