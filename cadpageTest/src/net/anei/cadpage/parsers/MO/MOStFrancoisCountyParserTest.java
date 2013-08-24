package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
St Francois County, MO
Contact: Alex Stephens <alexstephns18@gmail.com>
Sender: IPN.9999900138@ipnpaging.com

1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE ALARM      Loc:3962 HAWK HOLLOW RD          Apt:      XSt:RIDGE\nTOP DR\n(Con't) 2 of 2\nGrid:4101 Units:E4161 T4171 4100  E4160 F4185             Rmk:ALARM SHOWING\nSMOKE SENSOR, ATTEMPTING K\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:EMS CALL        Loc:HIGHWAY H/HIGHWAY AA         Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4101 Units:F4185 4100  A5177 5100                    Rmk:\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:INVESTIGATION   Loc:!RAIL ROAD LN OFF HILDEBRECH Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4100  E4160                               Rmk:ON THE AIR\nINVESTIGATING A POSSIBLE FIRE\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:MVA INJURY      Loc:US HIGHWAY 67/HILDEBRECHT RD Apt:\nXSt:\n(Con't) 2 of 2\nGrid:6741 Units:E4160 F4185 A5177 R4276 E4261             Rmk:T-BONE\nCOLLISION -- UNKNOWN ON INJURY CA\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE MISC       Loc:4 DOE RUN                    Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4102                                      Rmk:HAVE 4139\nCONTACT 4102 AT THE FIREHOUSE\n\n(End)

***/

public class MOStFrancoisCountyParserTest extends BaseParserTest {
  
  public MOStFrancoisCountyParserTest() {
    setParser(new MOStFrancoisCountyParser(), "ST FRANCOIS COUNTY", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE ALARM      Loc:3962 HAWK HOLLOW RD          Apt:      XSt:RIDGE\nTOP DR\n(Con't) 2 of 2\nGrid:4101 Units:E4161 T4171 4100  E4160 F4185             Rmk:ALARM SHOWING\nSMOKE SENSOR, ATTEMPTING K\n\n(End)",
        "CALL:FIRE ALARM",
        "ADDR:3962 HAWK HOLLOW RD",
        "X:RIDGE TOP DR",
        "MAP:4101",
        "UNIT:E4161 T4171 4100 E4160 F4185",
        "INFO:ALARM SHOWING SMOKE SENSOR, ATTEMPTING K");

    doTest("T2",
        "1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:EMS CALL        Loc:HIGHWAY H/HIGHWAY AA         Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4101 Units:F4185 4100  A5177 5100                    Rmk:\n\n(End)",
        "CALL:EMS CALL",
        "ADDR:HIGHWAY H & HIGHWAY AA",
        "MAP:4101",
        "UNIT:F4185 4100 A5177 5100");

    doTest("T3",
        "1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:INVESTIGATION   Loc:!RAIL ROAD LN OFF HILDEBRECH Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4100  E4160                               Rmk:ON THE AIR\nINVESTIGATING A POSSIBLE FIRE\n\n(End)",
        "CALL:INVESTIGATION",
        "ADDR:RAIL ROAD LN OFF HILDEBRECH",
        "MADDR:RAIL ROAD LN & HILDEBRECH",
        "MAP:4100",
        "UNIT:4100 E4160",
        "INFO:ON THE AIR INVESTIGATING A POSSIBLE FIRE");

    doTest("T4",
        "1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:MVA INJURY      Loc:US HIGHWAY 67/HILDEBRECHT RD Apt:\nXSt:\n(Con't) 2 of 2\nGrid:6741 Units:E4160 F4185 A5177 R4276 E4261             Rmk:T-BONE\nCOLLISION -- UNKNOWN ON INJURY CA\n\n(End)",
        "CALL:MVA INJURY",
        "ADDR:US HIGHWAY 67 & HILDEBRECHT RD",
        "MADDR:US 67 & HILDEBRECHT RD",
        "MAP:6741",
        "UNIT:E4160 F4185 A5177 R4276 E4261",
        "INFO:T-BONE COLLISION -- UNKNOWN ON INJURY CA");

    doTest("T5",
        "1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE MISC       Loc:4 DOE RUN                    Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4102                                      Rmk:HAVE 4139\nCONTACT 4102 AT THE FIREHOUSE\n\n(End)",
        "CALL:FIRE MISC",
        "ADDR:4 DOE RUN",
        "MAP:4100",
        "UNIT:4102",
        "INFO:HAVE 4139 CONTACT 4102 AT THE FIREHOUSE");
  }
  
  public static void main(String[] args) {
    new MOStFrancoisCountyParserTest().generateTests("T1");
  }
}