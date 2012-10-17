package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class MIEmmetCountyParser extends DispatchOSSIParser {
  
  public MIEmmetCountyParser() {
    this("EMMET COUNTY", "MI");
  }
  
  MIEmmetCountyParser(String defCity, String defState) {
    super(defCity, defState,
           "ID?:FYI CALL SRC! ADDR INFO+");
  }
  
  @Override
  public String getAliasCode() {
    return "MIEmmetCounty";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("CAD:MSG", "CAD:");
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{3,4}", true);
    return super.getField(name);
  }
}
