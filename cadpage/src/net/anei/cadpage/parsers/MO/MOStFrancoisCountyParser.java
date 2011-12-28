package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/***
St Francois County, MO
Contact: Alex Stephens <alexstephns18@gmail.com>
Sender: IPN.9999900138@ipnpaging.com

1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE ALARM      Loc:3962 HAWK HOLLOW RD          Apt:      XSt:RIDGE\nTOP DR\n(Con't) 2 of 2\nGrid:4101 Units:E4161 T4171 4100  E4160 F4185             Rmk:ALARM SHOWING\nSMOKE SENSOR, ATTEMPTING K\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:EMS CALL        Loc:HIGHWAY H/HIGHWAY AA         Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4101 Units:F4185 4100  A5177 5100                    Rmk:\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:INVESTIGATION   Loc:!RAIL ROAD LN OFF HILDEBRECH Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4100  E4160                               Rmk:ON THE AIR\nINVESTIGATING A POSSIBLE FIRE\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:MVA INJURY      Loc:US HIGHWAY 67/HILDEBRECHT RD Apt:\nXSt:\n(Con't) 2 of 2\nGrid:6741 Units:E4160 F4185 A5177 R4276 E4261             Rmk:T-BONE\nCOLLISION -- UNKNOWN ON INJURY CA\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE MISC       Loc:4 DOE RUN                    Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4102                                      Rmk:HAVE 4139\nCONTACT 4102 AT THE FIREHOUSE\n\n(End)

***/

public class MOStFrancoisCountyParser extends DispatchCiscoParser {
  
  public MOStFrancoisCountyParser() {
    super("ST FRANCOIS COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "IPN.9999900138@ipnpaging.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return super.parseMsg(body.replace('\n', ' ').replace("!",""), data);
  }
}
