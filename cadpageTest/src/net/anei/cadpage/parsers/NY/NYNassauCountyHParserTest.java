package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Nassau County, NY

Contact: Besnik Gjonlekaj <tigerfdny@gmail.com>
Sender: scmbackup@verizon.net,cpg.page@gmail.com
** 1- STRUCTURE FIRE \n\n** VOGT, WILLIAM J.\n** 153 CYPRESS LANE WEST\n** CS: COTTONWOOD LANE / CARDINAL LANE\n** TOA: 08:04 04-24-13
** 2- VEHICLE FIRE \n\n** NORTHBOUND MEADOWBROOK STATE PARKWAY \n** N/B MEADOWBROOK STATE PARKWAY** TOA: 06:40 04-24-13
** 4- SIGNAL 9 \n\n** RICHARD IGNELZI\n** 2331 SALISBURY ROAD\n** CS: FAIRFIELD AVENUE / WASHINGTON AVENUE\n** TOA: 13:40 04-23-13
** 14- SIGNAL 8 - FOR AFA \n\n** LA QUINTA INN \n** 821 STEWART AVENUE\n** CS: MERCHANTS CONCOURSE / SOUTH STREET \n** TOA: 17:31 04-24-13
** 3- AUTO ACCIDENT W/AIDED \n\n** MERCHANTS CONCOURSE & STEWART AVENUE \n** MERCHANTS CONCOURSE\n** CS: STEWART AVENUE ** TOA: 21:21 04-24-13
** 4- SIGNAL 9  \n\n** CLARKE HIGH SCHOOL \n** 740 EDGEWOOD DRIVE\n** CS: BERNARD DRIVE / NELSON PLACE \n** TOA: 11:07 04-25-13
** 16- AFA \n\n** VACANT (2012) \n** 1195 CORPORATE DRIVE\n** CS: MERCHANTS CONCOURSE / ZECKENDORF BOULEVARD \n** TOA: 11:13 05-22-13
 
 */

public class NYNassauCountyHParserTest extends BaseParserTest {
  
  public NYNassauCountyHParserTest() {
    setParser(new NYNassauCountyHParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "** 1- STRUCTURE FIRE \n\n** VOGT, WILLIAM J.\n** 153 CYPRESS LANE WEST\n** CS: COTTONWOOD LANE / CARDINAL LANE\n** TOA: 08:04 04-24-13",
        "CALL:1- STRUCTURE FIRE",
        "NAME:VOGT, WILLIAM J.",
        "ADDR:153 CYPRESS LANE WEST",
        "X:COTTONWOOD LANE / CARDINAL LANE",
        "TIME:08:04",
        "DATE:04/24/13");

    doTest("T2",
        "** 2- VEHICLE FIRE \n\n** NORTHBOUND MEADOWBROOK STATE PARKWAY \n** N/B MEADOWBROOK STATE PARKWAY** TOA: 06:40 04-24-13",
        "CALL:2- VEHICLE FIRE",
        "PLACE:NORTHBOUND MEADOWBROOK STATE PARKWAY",
        "ADDR:N & B MEADOWBROOK STATE PARKWAY",
        "TIME:06:40",
        "DATE:04/24/13");

    doTest("T3",
        "** 4- SIGNAL 9 \n\n** RICHARD IGNELZI\n** 2331 SALISBURY ROAD\n** CS: FAIRFIELD AVENUE / WASHINGTON AVENUE\n** TOA: 13:40 04-23-13",
        "CALL:4- SIGNAL 9",
        "NAME:RICHARD IGNELZI",
        "ADDR:2331 SALISBURY ROAD",
        "X:FAIRFIELD AVENUE / WASHINGTON AVENUE",
        "TIME:13:40",
        "DATE:04/23/13");

    doTest("T4",
        "** 14- SIGNAL 8 - FOR AFA \n\n" +
        "** LA QUINTA INN \n" +
        "** 821 STEWART AVENUE\n" +
        "** CS: MERCHANTS CONCOURSE / SOUTH STREET \n" +
        "** TOA: 17:31 04-24-13",

        "CALL:14- SIGNAL 8 - FOR AFA",
        "PLACE:LA QUINTA INN",
        "ADDR:821 STEWART AVENUE",
        "X:MERCHANTS CONCOURSE / SOUTH STREET",
        "TIME:17:31",
        "DATE:04/24/13");

    doTest("T5",
        "** 3- AUTO ACCIDENT W/AIDED \n\n" +
        "** MERCHANTS CONCOURSE & STEWART AVENUE \n" +
        "** MERCHANTS CONCOURSE\n" +
        "** CS: STEWART AVENUE ** TOA: 21:21 04-24-13",

        "CALL:3- AUTO ACCIDENT W/AIDED",
        "PLACE:MERCHANTS CONCOURSE & STEWART AVENUE",
        "ADDR:MERCHANTS CONCOURSE",
        "MADDR:MERCHANTS CONCOURSE & STEWART AVENUE",
        "X:STEWART AVENUE",
        "TIME:21:21",
        "DATE:04/24/13");

    doTest("T6",
        "** 4- SIGNAL 9  \n\n" +
        "** CLARKE HIGH SCHOOL \n" +
        "** 740 EDGEWOOD DRIVE\n" +
        "** CS: BERNARD DRIVE / NELSON PLACE \n" +
        "** TOA: 11:07 04-25-13",

        "CALL:4- SIGNAL 9",
        "PLACE:CLARKE HIGH SCHOOL",
        "ADDR:740 EDGEWOOD DRIVE",
        "X:BERNARD DRIVE / NELSON PLACE",
        "TIME:11:07",
        "DATE:04/25/13");

    doTest("T7",
        "** 16- AFA \n\n** VACANT (2012) \n** 1195 CORPORATE DRIVE\n** CS: MERCHANTS CONCOURSE / ZECKENDORF BOULEVARD \n** TOA: 11:13 05-22-13",
        "CALL:16- AFA",
        "NAME:VACANT (2012)",
        "ADDR:1195 CORPORATE DRIVE",
        "X:MERCHANTS CONCOURSE / ZECKENDORF BOULEVARD",
        "TIME:11:13",
        "DATE:05/22/13");

  }
  
  public static void main(String[] args) {
    new NYNassauCountyHParserTest().generateTests("T1");
  }

}