package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

public class MIInghamCountyParser extends DispatchA3Parser{

  public MIInghamCountyParser() {
    super("InghamCO:", "INGHAM COUNTY", "MI", "ID ADDR APT APT CITY! Line6:X! Line7:X! Line8:MAP! Line9:INFO1! Line10:CODE! Line11:CALL! Line12:NAME Line13:PHONE Line14:UNIT Line15:MAP Line16:INFO Line17:INFO Line18:INFO");

  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    setBreakChar('=');
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d\\d\\-\\d{7}", true);
    return super.getField(name);
  }
}
