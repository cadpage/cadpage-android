package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PACrawfordCountyParserTest extends BaseParserTest {
  
  public PACrawfordCountyParserTest() {
    setParser(new PACrawfordCountyParser(), "CRAWFORD COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FRM:\nSUBJ:TWDU >TREES/WIRES DOWN URGENT\nMSG:OESCAD:STATE HWY 18 SPRING TWP THARP, DENNIS Cad: 2012-0000000067",
        "CALL:TREES/WIRES DOWN URGENT",
        "ADDR:STATE HWY 18",
        "MADDR:STATE 18",
        "CITY:SPRING TWP",
        "NAME:THARP, DENNIS",
        "ID:2012-0000000067");

    doTest("T2",
        "FRM:OESCAD@WINDSTREAM.NET\nSUBJ:TWDU  >TREES/WIRES DOWN URGENT\nMSG:OESCAD:STATE HWY 18 SPRING TWP THARP, DENNIS Cad: 2012-0000000067",
        "CALL:TREES/WIRES DOWN URGENT",
        "ADDR:STATE HWY 18",
        "MADDR:STATE 18",
        "CITY:SPRING TWP",
        "NAME:THARP, DENNIS",
        "ID:2012-0000000067");

    doTest("T3",
        "FRM:OESCAD@WINDSTREAM.NET\nSUBJ:SFR   >STRUCTURE FIRE\nMSG:OESCAD:150 S MAIN ST XS: SPRING ST SPRINGBORO BORO PIERI, PIERINO Map:E-3\n(Con't) 2 of 2\nGrids:0,0 Cad: 2012-0000000547(End)",
        "CALL:STRUCTURE FIRE",
        "ADDR:150 S MAIN ST",
        "X:SPRING ST",
        "CITY:SPRINGBORO",
        "NAME:BORO PIERI, PIERINO",
        "MAP:E-3",
        "ID:2012-0000000547");

    doTest("T4",
        "1 of 2\nFRM:OESCAD@WINDSTREAM.NET\nSUBJ:CS    >CARDIAC SYMPTOMS\nMSG:OESCAD:135 MEAD AVE XS: BEAVER ST SPRINGBORO BORO NAAS, DAVID C Map:E-3\n(Con't) 2 of 2\nGrids:0,0 Cad: 2012-0000001348(End)",
        "CALL:CARDIAC SYMPTOMS",
        "ADDR:135 MEAD AVE",
        "X:BEAVER ST",
        "CITY:SPRINGBORO",
        "NAME:BORO NAAS, DAVID C",
        "MAP:E-3",
        "ID:2012-0000001348");

    doTest("T5",
        "1 of 2\nFRM:OESCAD@WINDSTREAM.NET\nSUBJ:UNC   >UNCONSCIOUS SUBJECT\nMSG:OESCAD:104 CUSSEWAGO ST Apt: A Bldg XS: SPRINGBORO RD SPRINGBORO BORO\n(Con't) 2 of 2\nHOOVER,KYLE Map:E-3 Grids:0,0 Cad: 2012-0000001631(End)",
        "CALL:UNCONSCIOUS SUBJECT",
        "ADDR:104 CUSSEWAGO ST",
        "APT:A Bldg",
        "X:SPRINGBORO RD",
        "CITY:SPRINGBORO",
        "NAME:BORO HOOVER,KYLE",
        "MAP:E-3",
        "ID:2012-0000001631");
  
  }
  
  public static void main(String[] args) {
    new PACrawfordCountyParserTest().generateTests("T1", "CALL ADDR APT X PLACE CITY NAME PHONE MAP ID");
  }
}
