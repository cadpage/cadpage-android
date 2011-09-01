package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAErieCountyBParserTest;

import org.junit.Test;


public class PAErieCountyBParserTest extends BaseParserTest {
  
  public PAErieCountyBParserTest() {
    setParser(new PAErieCountyBParser(), "ERIE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Ill Patient - 32 W PEARL STREET - Barnett Building  (PRE-PLAN) - APT 210 - Juliet Street & Academy Street",
        "CALL:Ill Patient",
        "ADDR:32 W PEARL STREET",
        "APT:210",
        "PLACE:Barnett Building  (PRE-PLAN)",
        "X:Juliet Street & Academy Street");

    doTest("T2",
        "Anaphylaxis - 9004 ROUTE 215 -  - HANSON RESIDENCE - CONNEAUT TWP LINE & WOOD ROAD",
        "CALL:Anaphylaxis",
        "ADDR:9004 ROUTE 215",
        "PLACE:HANSON RESIDENCE",
        "X:CONNEAUT TWP LINE & WOOD ROAD");

    doTest("T3",
        "Cardiac - 155 E STATE STREET - Albion Family Practice  (PRE-PLAN) - Wells Avenue & Elk Street",
        "CALL:Cardiac",
        "ADDR:155 E STATE STREET",
        "PLACE:Albion Family Practice  (PRE-PLAN)",
        "X:Wells Avenue & Elk Street");

    doTest("T4",
        "MVA - 126 E STATE STREET -  - Water Street & Wells Avenue",
        "CALL:MVA",
        "ADDR:126 E STATE STREET",
        "X:Water Street & Wells Avenue");

    doTest("T5",
        "Chest Pain - E STATE STREET & First Avenue -  - MEET PD -",
        "CALL:Chest Pain",
        "ADDR:E STATE STREET & First Avenue",
        "PLACE:MEET PD");

    doTest("T6",
        "Ill Patient - 10745 ROUTE 18 - SCI-Albion  (PRE-PLAN) - USE FRONT ENTRANCE - Boro / Township Line & Carter Road",
        "CALL:Ill Patient",
        "ADDR:10745 ROUTE 18",
        "PLACE:SCI-Albion  (PRE-PLAN) - USE FRONT ENTRANCE",
        "X:Boro / Township Line & Carter Road");

    doTest("T7",
        "Fire Alarm -- Business - 32 W PEARL STREET - Barnett Building  (PRE-PLAN) - Juliet Street & Academy Street",
        "CALL:Fire Alarm -- Business",
        "ADDR:32 W PEARL STREET",
        "PLACE:Barnett Building  (PRE-PLAN)",
        "X:Juliet Street & Academy Street");

    doTest("T8",
        "Ill Patient - 10745 ROUTE 18 - SCI-Albion  (PRE-PLAN) - Boro / Township Line & Carter Road",
        "CALL:Ill Patient",
        "ADDR:10745 ROUTE 18",
        "PLACE:SCI-Albion  (PRE-PLAN)",
        "X:Boro / Township Line & Carter Road");

    doTest("T9",
        "Fracture - 2 W STATE STREET - Country Fair - MEET PD - Main Street & Academy Street",
        "CALL:Fracture",
        "ADDR:2 W STATE STREET",
        "PLACE:Country Fair - MEET PD",
        "X:Main Street & Academy Street");

    doTest("T10",
        "Cardiac - 210 E STATE STREET - Northwest Area Health Center  (PRE-PLAN) - Orchard Street & Third Avenue",
        "CALL:Cardiac",
        "ADDR:210 E STATE STREET",
        "PLACE:Northwest Area Health Center  (PRE-PLAN)",
        "X:Orchard Street & Third Avenue");

    doTest("T11",
        "Unresponsive Patient - 44 WALNUT STREET - SHERMAN RESIDENCE - Thornton Avenue & Euclid Street",
        "CALL:Unresponsive Patient",
        "ADDR:44 WALNUT STREET",
        "PLACE:SHERMAN RESIDENCE",
        "X:Thornton Avenue & Euclid Street");
  }
  
  public static void main(String[] args) {
    new PAErieCountyBParserTest().generateTests("T1");
  }
}