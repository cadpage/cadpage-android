package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ILChampaignUrbanaParserTest extends BaseParserTest {
  
  public ILChampaignUrbanaParserTest() {
    setParser(new ILChampaignUrbanaParser(), "", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Run# 6373, <Unknown>, 16:48, 1701 W CURTIS RD, CHAMPAIGN, 4M VOMITING FEVER LETHARGIC 26C1, <None>, SICK PERSON",
        "ID:6373",
        "ADDR:1701 W CURTIS RD",
        "CITY:CHAMPAIGN",
        "INFO:4M VOMITING FEVER LETHARGIC 26C1 / SICK PERSON");

    doTest("T2",
        "Run# 6407, <Unknown>, 17:00, 404 SCOTTSWOOD DR, URBANA, 11 F W ABDONINAL PAIN 1A1, <None>, ABDOMINAL PAIN",
        "ID:6407",
        "ADDR:404 SCOTTSWOOD DR",
        "CITY:URBANA",
        "INFO:11 F W ABDONINAL PAIN 1A1 / ABDOMINAL PAIN");

    doTest("T3",
        "Run# 6400, JOHN SMITH, 14:45, CU DIALYSIS, URBANA, RETURN TO CCNH. AUTH# R1369756, <None>, TRANSFER/INTERFACILITY, CHAMPAIGN COUNTY NURSING HOME, 220 B2, URBANA",
        "ID:6400",
        "NAME:JOHN SMITH",
        "ADDR:CU DIALYSIS",
        "CITY:URBANA",
        "INFO:RETURN TO CCNH. AUTH# R1369756 / TRANSFER/INTERFACILITY / CHAMPAIGN COUNTY NURSING HOME / 220 B2 / URBANA");

    doTest("T4",
        "Run# 6419, <Unknown>, 21:43, 507 CRYSTAL LAKE DR, URBANA, 25A1 INTOX F PT MENTAL EVAL, <None>, PSYCHIATRIC/SUICIDE",
        "ID:6419",
        "ADDR:507 CRYSTAL LAKE DR",
        "CITY:URBANA",
        "INFO:25A1 INTOX F PT MENTAL EVAL / PSYCHIATRIC/SUICIDE");

    doTest("T5",
        "Run# 6422, <Unknown>, 22:28, 2306 BARBERRY DR, CHAMPAIGN, 19C2 RACING HEART RATE, <None>, HEART PROBLEM/AICD",
        "ID:6422",
        "ADDR:2306 BARBERRY DR",
        "CITY:CHAMPAIGN",
        "INFO:19C2 RACING HEART RATE / HEART PROBLEM/AICD");

    doTest("T6",
        "Run# 6427, <Unknown>, 01:23, 208 VAN VOORHIS DR, TUSCOLA, 26A9 FEVER & PAIN, <None>, SICK PERSON",
        "ID:6427",
        "ADDR:208 VAN VOORHIS DR",
        "CITY:TUSCOLA",
        "INFO:26A9 FEVER & PAIN / SICK PERSON");

    doTest("T7",
        "Run# 6368, SMITH, JOHN, 13:48, 709 E BARKER ST, D, TUSCOLA, 68F DIFF BREATHING 6C1, <None>, BREATHING PROBLEM",
        "ID:6368",
        "NAME:SMITH, JOHN",
        "ADDR:709 E BARKER ST",
        "APT:D",
        "CITY:TUSCOLA",
        "INFO:68F DIFF BREATHING 6C1 / BREATHING PROBLEM");

    doTest("T8",
        "Run# 6421, SMITH, JOHN, 22:30, 302 S SPRUCE ST, VILLA GROVE, GOING FOR CARE NOT AVALIBLE AT OTHER FACILITY IN AREA // SUICIDAL // NEED AOB, <None>, TRANSFER/INTERFACILITY",
        "ID:6421",
        "NAME:SMITH, JOHN",
        "ADDR:302 S SPRUCE ST",
        "CITY:VILLA GROVE",
        "INFO:GOING FOR CARE NOT AVALIBLE AT OTHER FACILITY IN AREA // SUICIDAL // NEED AOB / TRANSFER/INTERFACILITY");

    doTest("T9",
        "Run# 6403, SIDELL, WILLIAM, 15:52, W BRADLEY AVE & CLAYTON BLVD, CHAMPAIGN, 57 M W BACK PAIN AFTER A MVA 29D2, <None>, TRAFFIC/TRANSPORTATION ACCIDENT",
        "ID:6403",
        "NAME:SIDELL, WILLIAM",
        "ADDR:W BRADLEY AVE & CLAYTON BLVD",
        "CITY:CHAMPAIGN",
        "INFO:57 M W BACK PAIN AFTER A MVA 29D2 / TRAFFIC/TRANSPORTATION ACCIDENT");
    
  }
  
  public static void main(String[] args) {
    new ILChampaignUrbanaParserTest().generateTests("T1");
  }
}