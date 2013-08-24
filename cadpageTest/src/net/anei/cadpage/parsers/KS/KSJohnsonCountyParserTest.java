package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Johnson County, KS
Contact: Mike Morse <michaeltmorse@gmail.com>
Sender: 93001xxx    (email) ecc1@jocogov.org<mailto:ecc1@jocogov.org>

Add: 2908 W 48th Ter Apt: Loc: Nature: MEDICAL Grid: 19/1. Incident# 10-3560129 Cross:Dead End/MISSION RD
Add: 5055 Buena Vista St Apt: Loc: Nature: Bleeding - Laceration Grid: 18/1. Incident# 10-3560040 Cross:W 51ST ST/SYCAMORE DR
Add: 2435 Drury Ln Apt: Loc: Nature: Auto Alarm - Residence Grid: 34/1. Incident# 10-3560070 Cross:OAKWOOD RD/OVERHILL RD
Add: 6028 Mission Rd Apt: Loc: Nature: MEDICAL Grid: 34/1. Incident# 10-3560106 Cross:EASTVALE DR/W 61ST ST
Add: 4817 Skyline Dr Apt: Loc: Nature: Building Fire Grid: 18/1. Incident# 10-3620163 Cross:W 48TH ST/Dead End
Add: Broadmoor St & Johnson Dr Apt: Loc: Nature: Injury Accident Grid: 32/1. Incident# 10-3640058 Cross:
Add: Shawnee Mission Pkwy & Nal Apt: Loc: Nature: Injury Accident C2 Grid: 32/1. Incident# 10-3640048 Cross:

Contact: Mike Shaw <mshaw1957@gmail.com>
Sender: calls+bncCAAQ1K3H7wQaBJUY9Sk@jocofd1.org
(info:) Add: Gardner West Rd & Lake Roa Apt:            Loc:                 Nature: Investigate Power Lines Down   Grid: 290/1 Incident# 11-1

Contact: Brad Ralston <bralston911@gmail.com>
Sender:ECC2@jocogov.org
Subject:info:\nAdd: E Lincoln Ln & N Evergreen Apt: d          Loc: Lincoln Townhom Nature: Non Breather - C1C             Grid: 339/1 Incident

Contact: Matt Gillotti <matt.gillotti@jocofd1.org>
Sender: calls+bncBAABBXPORGEQKGQELEY4UAI@jocofd1.org
(info:) Add: 210 E Mccarty St           Apt:            Loc:                 Nature: MEDICAL                        Grid: 430/1 Inciden

Contact: Chad Kelly <firefighterkelly@gmail.com>
Sender: ecc4@jocogov.org
Add: 7344 Canterbury St         Apt:            Loc:                 Nature: MEDICAL              Grid: 68/1. Incident# 13-0690093 Cross:WINDSOR ST/W 74T

Contact: Ken Phelps <ken.phelps@jocofd1.org>
Sender: ecc4@jocogov.org
1 of 2\nFRM:ecc4@jocogov.org\nMSG:Add: 400 S Moonlight Rd         Apt: 15H        Loc: Moonlight Ridge             Nature: Behavioral C2\n(Con't) 2 of 2\nGrid: 363/1 Incident# 13-1860028 Cross:E PUMPKIN RIDGE ST/E COTTAGE C(End)

*/

public class KSJohnsonCountyParserTest extends BaseParserTest {
  
  public KSJohnsonCountyParserTest() {
    setParser(new KSJohnsonCountyParser(), "JOHNSON COUNTY", "KS");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Add: 2908 W 48th Ter Apt: Loc: Nature: MEDICAL Grid: 19/1. Incident# 10-3560129 Cross:Dead End/MISSION RD",
        "ADDR:2908 W 48th Ter",
        "CALL:MEDICAL",
        "MAP:19/1",
        "ID:10-3560129",
        "X:Dead End/MISSION RD");

    doTest("T2",
        "Add: 5055 Buena Vista St Apt: Loc: Nature: Bleeding - Laceration Grid: 18/1. Incident# 10-3560040 Cross:W 51ST ST/SYCAMORE DR",
        "ADDR:5055 Buena Vista St",
        "CALL:Bleeding - Laceration",
        "MAP:18/1",
        "ID:10-3560040",
        "X:W 51ST ST/SYCAMORE DR");

    doTest("T3",
        "Add: 2435 Drury Ln Apt: Loc: Nature: Auto Alarm - Residence Grid: 34/1. Incident# 10-3560070 Cross:OAKWOOD RD/OVERHILL RD",
        "ADDR:2435 Drury Ln",
        "CALL:Auto Alarm - Residence",
        "MAP:34/1",
        "ID:10-3560070",
        "X:OAKWOOD RD/OVERHILL RD");

    doTest("T4",
        "Add: 6028 Mission Rd Apt: Loc: Nature: MEDICAL Grid: 34/1. Incident# 10-3560106 Cross:EASTVALE DR/W 61ST ST",
        "ADDR:6028 Mission Rd",
        "CALL:MEDICAL",
        "MAP:34/1",
        "ID:10-3560106",
        "X:EASTVALE DR/W 61ST ST");

    doTest("T5",
        "Add: 4817 Skyline Dr Apt: Loc: Nature: Building Fire Grid: 18/1. Incident# 10-3620163 Cross:W 48TH ST/Dead End",
        "ADDR:4817 Skyline Dr",
        "CALL:Building Fire",
        "MAP:18/1",
        "ID:10-3620163",
        "X:W 48TH ST/Dead End");

    doTest("T6",
        "Add: Broadmoor St & Johnson Dr Apt: Loc: Nature: Injury Accident Grid: 32/1. Incident# 10-3640058 Cross:",
        "ADDR:Broadmoor St & Johnson Dr",
        "CALL:Injury Accident",
        "MAP:32/1",
        "ID:10-3640058");

    doTest("T7",
        "Add: Shawnee Mission Pkwy & Nal Apt: Loc: Nature: Injury Accident C2 Grid: 32/1. Incident# 10-3640048 Cross:",
        "ADDR:Shawnee Mission Pkwy & Nal",
        "CALL:Injury Accident C2",
        "MAP:32/1",
        "ID:10-3640048");

    doTest("T8",
        "(info:) Add: Gardner West Rd & Lake Roa Apt:            Loc:                 Nature: Investigate Power Lines Down   Grid: 290/1 Incident# 11-1",
        "ADDR:Gardner West Rd & Lake Roa",
        "CALL:Investigate Power Lines Down",
        "MAP:290/1",
        "ID:11-1");

    doTest("T9",
        "Subject:info:\nAdd: E Lincoln Ln & N Evergreen Apt: d          Loc: Lincoln Townhom Nature: Non Breather - C1C             Grid: 339/1 Incident",
        "ADDR:E Lincoln Ln & N Evergreen",
        "APT:d",
        "PLACE:Lincoln Townhom",
        "CALL:Non Breather - C1C",
        "MAP:339/1");

    doTest("T10",
        "(info:) Add: 210 E Mccarty St           Apt:            Loc:                 Nature: MEDICAL                        Grid: 430/1 Inciden",
        "ADDR:210 E Mccarty St",
        "CALL:MEDICAL",
        "MAP:430/1");

    doTest("T11",
        "Add: 7344 Canterbury St         Apt:            Loc:                 Nature: MEDICAL              Grid: 68/1. Incident# 13-0690093 Cross:WINDSOR ST/W 74T",
        "ADDR:7344 Canterbury St",
        "CALL:MEDICAL",
        "MAP:68/1",
        "ID:13-0690093",
        "X:WINDSOR ST/W 74T");

    doTest("T1",
        "1 of 2\n" +
        "FRM:ecc4@jocogov.org\n" +
        "MSG:Add: 400 S Moonlight Rd         Apt: 15H        Loc: Moonlight Ridge             Nature: Behavioral C2\n" +
        "(Con't) 2 of 2\n" +
        "Grid: 363/1 Incident# 13-1860028 Cross:E PUMPKIN RIDGE ST/E COTTAGE C(End)",

        "ADDR:400 S Moonlight Rd",
        "APT:15H",
        "PLACE:Moonlight Ridge",
        "CALL:Behavioral C2",
        "MAP:363/1",
        "ID:13-1860028",
        "X:E PUMPKIN RIDGE ST/E COTTAGE C");

  }
  
  public static void main(String[] args) {
    new KSJohnsonCountyParserTest().generateTests("T1");
  }
}
