package net.anei.cadpage.parsers.OH;


import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
MBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common
FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit
FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name

*/

public class OHXenaTownshipParser extends FieldProgramParser {
  
  
  public OHXenaTownshipParser() {
    super("XENA", "OH","CALL  Location:ADDR! Time:SKIP Units:UNIT? Info:INFO? ");
  }
  
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    return true;
  }
  
  
  
  
}
