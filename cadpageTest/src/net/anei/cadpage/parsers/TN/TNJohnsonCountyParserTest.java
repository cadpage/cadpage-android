package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Johnson County, TN
Contact: Pc Doctors <2209751@gmail.com>
Sender: 911 dispatch
System: Geoconx

[E911]  STRUCTURE FIRE\nGRADY STOUT 4235341985\n1312 CRACKERS NECK RD, MOUNTAIN CITY
[E911]  STRUCTURE FIRE\nCORNETT*S USED CARS 4237394613\n530 CRETSINGER RD, SHADY VALLEY
[E911]  STRUCTURE FIRE\nROBIN STANLEY 4237278607\n870 FURNACE CREEK RD, MOUNTAIN CITY
[E911]  VEHICLE FIRE\nCHRIS PIERCE 5555555555\n123 SESAME ST, MOUNTAIN CITY\nTEST ONLY
[E911]  FIRE CALL\nBETTY BRYANT 4237275474\n5833 HWY 421 S, MOUNTAIN CITY\nVEHICLE FIRE

 */

public class TNJohnsonCountyParserTest extends BaseParserTest {
  
  public TNJohnsonCountyParserTest() {
    setParser(new TNJohnsonCountyParser(), "JOHNSON COUNTY", "TN");
  }
  
  @Test
  public void test1Parser() {

    doTest("T1",
        "[E911]  STRUCTURE FIRE\nGRADY STOUT 4235341985\n1312 CRACKERS NECK RD, MOUNTAIN CITY",
        "CALL:STRUCTURE FIRE",
        "PHONE:4235341985",
        "NAME:GRADY STOUT",
        "ADDR:1312 CRACKERS NECK RD",
        "CITY:MOUNTAIN CITY");

    doTest("T2",
        "[E911]  STRUCTURE FIRE\nCORNETT*S USED CARS 4237394613\n530 CRETSINGER RD, SHADY VALLEY",
        "CALL:STRUCTURE FIRE",
        "PHONE:4237394613",
        "PLACE:CORNETT*S USED CARS",
        "ADDR:530 CRETSINGER RD",
        "CITY:SHADY VALLEY");

    doTest("T3",
        "[E911]  STRUCTURE FIRE\nROBIN STANLEY 4237278607\n870 FURNACE CREEK RD, MOUNTAIN CITY",
        "CALL:STRUCTURE FIRE",
        "PHONE:4237278607",
        "NAME:ROBIN STANLEY",
        "ADDR:870 FURNACE CREEK RD",
        "CITY:MOUNTAIN CITY");

    doTest("T4",
        "[E911]  VEHICLE FIRE\nCHRIS PIERCE 5555555555\n123 SESAME ST, MOUNTAIN CITY\nTEST ONLY",
        "CALL:VEHICLE FIRE",
        "PHONE:5555555555",
        "NAME:CHRIS PIERCE",
        "ADDR:123 SESAME ST",
        "CITY:MOUNTAIN CITY",
        "INFO:TEST ONLY");

    doTest("T5",
        "[E911]  FIRE CALL\nBETTY BRYANT 4237275474\n5833 HWY 421 S, MOUNTAIN CITY\nVEHICLE FIRE",
        "CALL:FIRE CALL",
        "PHONE:4237275474",
        "NAME:BETTY BRYANT",
        "ADDR:5833 HWY 421 S",
        "CITY:MOUNTAIN CITY",
        "INFO:VEHICLE FIRE");
 
  }
  

  public static void main(String[] args) {
    new TNJohnsonCountyParserTest().generateTests("T1");
  }
}
