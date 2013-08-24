package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Carroll County, MO
Contact: relykc@aol.com
Sender: alerts@carollcomo911.org
 
(NEWOCC #OUTS  202 - ACCIDENT - MOTOR VEHICLE) NEWOCC #OUTS  202 - ACCIDENT -\nMOTOR VEHICLE\nAddress: Carrollton\nReporting Person: CLAUDIA AUER, Phone: 6
(NEWOCC #OUTS  202 - ACCIDENT - MOTOR VEHICLE) NEWOCC #OUTS  202 - ACCIDENT - \nMOTOR VEHICLE\nAddress: Z HWY  S OF U, Carrollton\nReporting Person: , Phone
(NEWOCC #OUTS  215 - FIRE (BRUSH, MISC, OUTDOORS)) NEWOCC #OUTS  215 - FIRE \n(BRUSH, MISC, OUTDOORS)\nAddress: Carrollton\nReporting Person: , Phone: \nDet
(NEWOCC #OUTS  224 - MISCELLANEOUS) NEWOCC #OUTS  224 - MISCELLANEOUS\nAddress: CCMH - 1502 N Jefferson Street, Carrollton\nReporting Person: STEPHANIE, P
(NEWOCC #OUTS  208 - BREAKING & ENTERING (BURG)) NEWOCC #OUTS  208 - BREAKING & \nENTERING (BURG)\nAddress: Carrollton\nReporting Person: SUE RICHARDT, Phon
(NEWOCC #OUTS  215 - FIRE (BRUSH, MISC, OUTDOORS)) NEWOCC #OUTS  215 - FIRE \n(BRUSH, MISC, OUTDOORS)\nAddress: UU  HWY, Carrollton\nReporting Person: SAMAN

*/

public class MOCarrollCountyParserTest extends BaseParserTest {
  
  public MOCarrollCountyParserTest() {
    setParser(new MOCarrollCountyParser(), "CARROLL COUNTY", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "(NEWOCC #OUTS  202 - ACCIDENT - MOTOR VEHICLE) NEWOCC #OUTS  202 - ACCIDENT -\n" +
        "MOTOR VEHICLE\n" +
        "Address: Carrollton\n" +
        "Reporting Person: CLAUDIA AUER, Phone: 6",

        "CODE:202",
        "CALL:ACCIDENT - MOTOR VEHICLE",
        "ADDR:Carrollton",
        "NAME:CLAUDIA AUER",
        "PHONE:6");

    doTest("T2",
        "(NEWOCC #OUTS  202 - ACCIDENT - MOTOR VEHICLE) NEWOCC #OUTS  202 - ACCIDENT - \n" +
        "MOTOR VEHICLE\n" +
        "Address: Z HWY  S OF U, Carrollton\n" +
        "Reporting Person: , Phone",

        "CODE:202",
        "CALL:ACCIDENT - MOTOR VEHICLE",
        "ADDR:Z HWY  S OF U",
        "MADDR:HWY Z & U",
        "CITY:Carrollton");

    doTest("T3",
        "(NEWOCC #OUTS  215 - FIRE (BRUSH, MISC, OUTDOORS)) NEWOCC #OUTS  215 - FIRE \n" +
        "(BRUSH, MISC, OUTDOORS)\n" +
        "Address: Carrollton\n" +
        "Reporting Person: , Phone: \n" +
        "Det",

        "CODE:215",
        "CALL:FIRE",
        "ADDR:Carrollton");

    doTest("T4",
        "(NEWOCC #OUTS  224 - MISCELLANEOUS) NEWOCC #OUTS  224 - MISCELLANEOUS\n" +
        "Address: CCMH - 1502 N Jefferson Street, Carrollton\n" +
        "Reporting Person: STEPHANIE, P",

        "CODE:224",
        "CALL:MISCELLANEOUS",
        "PLACE:CCMH",
        "ADDR:1502 N Jefferson Street",
        "CITY:Carrollton",
        "NAME:STEPHANIE");

    doTest("T5",
        "(NEWOCC #OUTS  208 - BREAKING & ENTERING (BURG)) NEWOCC #OUTS  208 - BREAKING & \n" +
        "ENTERING (BURG)\n" +
        "Address: Carrollton\n" +
        "Reporting Person: SUE RICHARDT, Phon",

        "CODE:208",
        "CALL:BREAKING &",
        "ADDR:Carrollton",
        "NAME:SUE RICHARDT");

    doTest("T6",
        "(NEWOCC #OUTS  215 - FIRE (BRUSH, MISC, OUTDOORS)) NEWOCC #OUTS  215 - FIRE \n" +
        "(BRUSH, MISC, OUTDOORS)\n" +
        "Address: UU  HWY, Carrollton\n" +
        "Reporting Person: SAMAN",

        "CODE:215",
        "CALL:FIRE",
        "ADDR:UU  HWY",
        "MADDR:HWY UU",
        "CITY:Carrollton",
        "NAME:SAMAN");

  }
  
  public static void main(String[] args) {
    new MOCarrollCountyParserTest().generateTests("T1");
  }
}