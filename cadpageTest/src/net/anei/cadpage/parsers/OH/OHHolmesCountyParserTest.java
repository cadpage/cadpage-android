package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Holmes County, OH

Contact: Active911
Agency name: Prairie Township Fire Department
Location: Holmesville, OH, United States
Sender: 911@holmescountysheriff.org 

(DISPATCHINCIDENT # 13EFD0066,1) LONG TERM CAD#    102850   ACTIVE CALL# 24\nPRIORITY: 0                   REPORTED: 15:17:19 05/06/13\n\n Nature: FIRE STRUCTURE                              Type: f\nAddress: 6133 TR 327; Hardy Twp                      Zone: MFD\n   City: Millersburg\n\nResponding Units: 701,703,702,302,306,301,801,802,LAD7\n\nDirections:\n\n\nComments:\n\n\nContact: Laura Mast                        Phone: (330)674-2981
(DISPATCHINCIDENT # 135300045) LONG TERM CAD#    102836   ACTIVE CALL# 10\nPRIORITY: 0                   REPORTED: 10:17:26 05/06/13\n\n Nature: SQUAD RUN                                   Type: e\nAddress: 8157 SR 83; Prairie Twp                     Zone: 53\n   City: Holmesville\n\nResponding Units: 53\n\nDirections:\n\n\nComments:\nLes Posey, age 88 has fallen in the driveway\n\nContact: Hatten,Pam                        Phone: (330)279-4417
(DISPATCHINCIDENT # 13HFD0022) LONG TERM CAD#    102820   ACTIVE CALL# 45\nPRIORITY: 0                   REPORTED: 21:06:54 05/05/13\n\n Nature: FIRE ALL OTHERS                             Type: f\nAddress: CR 245 N of TR 562; Prairie Twp             Zone: HFD\n   City: Holmesville\n\nResponding Units: 301\n\nDirections:\n\n\nComments:\n\n\nContact:                                   Phone: (   )   -

 */
public class OHHolmesCountyParserTest extends BaseParserTest {
  
  public OHHolmesCountyParserTest() {
    setParser(new OHHolmesCountyParser(), "HOLMES COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(DISPATCHINCIDENT # 13EFD0066,1) LONG TERM CAD#    102850   ACTIVE CALL# 24\n" +
        "PRIORITY: 0                   REPORTED: 15:17:19 05/06/13\n\n" +
        " Nature: FIRE STRUCTURE                              Type: f\n" +
        "Address: 6133 TR 327; Hardy Twp                      Zone: MFD\n" +
        "   City: Millersburg\n\n" +
        "Responding Units: 701,703,702,302,306,301,801,802,LAD7\n\n" +
        "Directions:\n\n\n" +
        "Comments:\n\n\n" +
        "Contact: Laura Mast                        Phone: (330)674-2981",

        "ID:13EFD0066,1/102850/24",
        "TIME:15:17:19",
        "DATE:05/06/13",
        "CALL:FIRE STRUCTURE",
        "ADDR:6133 TR 327",
        "APT:Hardy Twp",
        "MAP:MFD",
        "CITY:Millersburg",
        "UNIT:701,703,702,302,306,301,801,802,LAD7",
        "NAME:Laura Mast",
        "PHONE:(330)674-2981");

    doTest("T2",
        "(DISPATCHINCIDENT # 135300045) LONG TERM CAD#    102836   ACTIVE CALL# 10\n" +
        "PRIORITY: 0                   REPORTED: 10:17:26 05/06/13\n\n" +
        " Nature: SQUAD RUN                                   Type: e\n" +
        "Address: 8157 SR 83; Prairie Twp                     Zone: 53\n" +
        "   City: Holmesville\n\n" +
        "Responding Units: 53\n\n" +
        "Directions:\n\n\n" +
        "Comments:\n" +
        "Les Posey, age 88 has fallen in the driveway\n\n" +
        "Contact: Hatten,Pam                        Phone: (330)279-4417",

        "ID:135300045/102836/10",
        "TIME:10:17:26",
        "DATE:05/06/13",
        "CALL:SQUAD RUN",
        "ADDR:8157 SR 83",
        "MADDR:8157 OH 83",
        "APT:Prairie Twp",
        "MAP:53",
        "CITY:Holmesville",
        "UNIT:53",
        "INFO:Les Posey, age 88 has fallen in the driveway",
        "NAME:Hatten,Pam",
        "PHONE:(330)279-4417");

    doTest("T3",
        "(DISPATCHINCIDENT # 13HFD0022) LONG TERM CAD#    102820   ACTIVE CALL# 45\n" +
        "PRIORITY: 0                   REPORTED: 21:06:54 05/05/13\n\n" +
        " Nature: FIRE ALL OTHERS                             Type: f\n" +
        "Address: CR 245 N of TR 562; Prairie Twp             Zone: HFD\n" +
        "   City: Holmesville\n\n" +
        "Responding Units: 301\n\n" +
        "Directions:\n\n\n" +
        "Comments:\n\n\n" +
        "Contact:                                   Phone: (   )   -",

        "ID:13HFD0022/102820/45",
        "TIME:21:06:54",
        "DATE:05/05/13",
        "CALL:FIRE ALL OTHERS",
        "ADDR:CR 245 N of TR 562",
        "MADDR:COUNTY ROAD 245 & TR 562",
        "APT:Prairie Twp",
        "MAP:HFD",
        "CITY:Holmesville",
        "UNIT:301");
 
  }
  
  public static void main(String[] args) {
    new OHHolmesCountyParserTest().generateTests("T1");
  }
}