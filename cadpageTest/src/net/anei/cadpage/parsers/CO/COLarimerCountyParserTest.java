package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class COLarimerCountyParserTest extends BaseParserTest {
  
  public COLarimerCountyParserTest() {
    setParser(new COLarimerCountyParser(), "LARIMER COUNTY", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(BFPD) (CFS) Power Lines Down/Arcing        // E County Road 4 & Weld County // Apt/Lot            // Radio:MAC 5 NE                       //",
        "CALL:Power Lines Down/Arcing",
        "ADDR:E County Road 4 & Weld County");

    doTest("T2",
        "(BFPD) (CFS) MVA Unk Injury                 // 248790 Interstate 25 Sb // Apt/Lot            // Radio:TALK GP3                       // MM 249 SB I25",
        "CALL:MVA Unk Injury",
        "ADDR:248790 Interstate 25 Sb",
        "INFO:MM 249 SB I25");

    doTest("T3",
        "(BFPD) (CFS) Grass / Wildland Fire          // 5307 Foothills Dr  // Apt/Lot            // Radio:TALK GP3                       //",
        "CALL:Grass / Wildland Fire",
        "ADDR:5307 Foothills Dr");

    doTest("T4",
        "(BFPD) (CFS) Alarm Fire / Residential       // 20510 Weld County Road 5   // Apt/Lot            // Radio:TALK GP3                       // CLETCHER RESIDENCE",
        "CALL:Alarm Fire / Residential",
        "ADDR:20510 Weld County Road 5",
        "INFO:CLETCHER RESIDENCE");

    doTest("T5",
        "(BFPD) (CFS) Convulsions/Seizures (C,D)     // 315 Goose Hollow Rd  // Apt/Lot            // Radio:TALK GP2                       //",
        "CALL:Convulsions/Seizures (C,D)",
        "ADDR:315 Goose Hollow Rd");

    doTest("T6",
        "(BFPD) (CFS) Breathing Problems (E)         // 512 Redwood Cir  // Apt/Lot            // Radio:                               //",
        "CALL:Breathing Problems (E)",
        "ADDR:512 Redwood Cir");
    
  }
  
  public static void main(String[] args) {
    new COLarimerCountyParserTest().generateTests("T1");
  }
}