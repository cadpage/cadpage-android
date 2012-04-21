package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Pender County, NC
Contact: Tripp Lanier <triper99@gmail.com>
Sender: 911-@pendersheriff.com

911-:=12-010417* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-012441* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * BRUSH/FOREST FIRE (RP 1-4)* * * FD13* * * * *
911-:=12-012596* HOLLINGSWORTH DR // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-013390* 1520 OLD MAPLE HILL RD* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-009752* 5471 NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-009855* 14976 NC HWY 53 EAST* * * * * * * * * ASSIST EMS* * * FD13,FD15* * * * *

*/

public class NCPenderCountyParser extends FieldProgramParser {
  
  public NCPenderCountyParser() {
    super("PENDER COUNTY", "NC",
           "ID ADDR UNK UNK UNK UNK UNK UNK UNK UNK CALL UNK UNK UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911-@pendersheriff.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("911-:=")) return false;
    body = body.substring(6).trim();
    if (body.endsWith("*")) body = body + ' ';
    return parseFields(body.split("\\* "), 14, data);
  }
  
  private class UnknownField extends SkipField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() > 0) abort();
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field.replaceAll("//+", "/"), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{2}-\\d{6}");
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNK")) return new UnknownField();
    return super.getField(name);
  }
}
