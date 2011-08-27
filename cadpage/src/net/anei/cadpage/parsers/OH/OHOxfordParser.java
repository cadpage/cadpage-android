package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/***
Oxford, OH
Contact: Greg Yingling <gyingling@cityofoxford.org>
Sender: cisco@cityofoxford.org

Ct:MED:ENTRAPMENT  Loc:11 S POPLAR ST               Apt:      XSt:HIGH ST WALNUT ST               Grid:1604 Units:NO19                                      Rmk:
Ct:FD: FIRE ALARM  Loc:5201 COLLEGE CORNER PKe      Apt:219   XSt:                                Grid:4300 Units:M11                                       Rmk:
Ct:MED:EMERGENCY   Loc:CHESTNUT ST/MAIN ST          Apt:      XSt:                                Grid:3116 Units:E11   M11                                 Rmk:
Ct:PD: INJ CRASH   Loc:CHURCH ST/COLLEGE AV         Apt:      XSt:                                Grid:2535 Units:LO49  LO57                                Rmk:
Ct:FD: OTHER       Loc:5980 WILMINGTON PIKE         Apt:      XSt:CLYO RD         WILMINGTON PIKE Grid:6590 Units:C10                                       Rmk:

***/

public class OHOxfordParser extends DispatchCiscoParser {
  
  public OHOxfordParser() {
    super(null, "OXFORD", "OH");
  }
  
  @Override
  public String getFilter() {
    return "cisco@cityofoxford.org";
  }
}
