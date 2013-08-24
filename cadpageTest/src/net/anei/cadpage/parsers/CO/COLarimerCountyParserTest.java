package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Larimer County, CO (also Weld and Boulder Counties)
Contact: Shane Doyon <shanedoyon@gmail.com>
Sender: BFPD@notifyall.com
System: Tritech?

Weld County is a cross street.
Default to Larimer county, but provide way to override empty set (None or NA)

(BFPD) (CFS) Power Lines Down/Arcing        // E County Road 4 & Weld County // Apt/Lot            // Radio:MAC 5 NE                       //
(BFPD) (CFS) MVA Unk Injury                 // 248790 Interstate 25 Sb // Apt/Lot            // Radio:TALK GP3                       // MM 249 SB I25
(BFPD) (CFS) Grass / Wildland Fire          // 5307 Foothills Dr  // Apt/Lot            // Radio:TALK GP3                       //
(BFPD) (CFS) Alarm Fire / Residential       // 20510 Weld County Road 5   // Apt/Lot            // Radio:TALK GP3                       // CLETCHER RESIDENCE
(BFPD) (CFS) Convulsions/Seizures (C,D)     // 315 Goose Hollow Rd  // Apt/Lot            // Radio:TALK GP2                       //
(BFPD) (CFS) Breathing Problems (E)         // 512 Redwood Cir  // Apt/Lot            // Radio:                               //

Contact: Josh Valerio <j247valerio@gmail.com>
Sender: LFR@notifyall.com
(NOTIFYall msg) (CFS) Alarm Fire / CO with Patients  // 1727 N Wilson Ave              // Apt/Lot 503        // Radio:TALK GP2                       //

Contact: Active911
Agency name: Berthoud Fire Protection District Station 1
Location: Berthoud, Co, United States

(BFPD) (CFS) MVA Injury                     // 45 Vdr                         // Apt/Lot            // Radio:TALK GP3                       // VDR VALLEY DIRT RIDERS         // 49P4       // P331,BFD,BE1
(BFPD) (CFS) Breathing Problems (C,D)       // 6205 Sandia Ln                 // Apt/Lot            // Radio:TALK GP3                       //                                // 47F2       // BE2,BFD,P331,P329
(BFPD) (CFS) Breathing Problems (C,D)       // 505 Mayo Ct                    // Apt/Lot            // Radio:TALK GP3                       //                                // 49K1       // BFD,BE1,P331,P329
(BFPD) (CFS) Unconscious/Fainting (C,D)     // Interstate 25 Nb & E Highway 6 // Apt/Lot            // Radio:TALK GP3                       //                                // 45Q3       // P331,BE1,BFD,P329
(BFPD) (CFS) MVA Unk Injury                 // 253800 Interstate 25 Sb        // Apt/Lot            // Radio:                               // MM 254 SB I25 JOHNSONS CORNER  // 45P1       // P351,E6,BFD,BE1
(BFPD) (CFS) MVA Unk Injury                 // 110 - 999 Weld County Road 46  // Apt/Lot            // Radio:TALK GP3                       //                                // 48M2       // P331,BE1,BFD
(BFPD) (CFS) MVA Unk Injury                 // 249999 Interstate 25 Sb        // Apt/Lot            // Radio:TALK GP3                       // MM 250 SB I25 BERTHOUD EXIT    // 49P1       // P331,BE1,BFD
(BFPD) (CFS) MVA Injury                     // WELD COUNTY ROAD 7 & E HIGHWAY // Apt/Lot            // Radio:TALK GP3                       //                                // 49P2       // P331,BE2,BFD
(BFPD) (CFS) MVA Unk Injury                 // 252090 Interstate 25 Sb        // Apt/Lot            // Radio:TALK GP2                       // MM 252 SB I25 JOHNSTOWN EXIT   // 47P1       // BFD,E6,P351,BE2
(BFPD) (CFS) No EMD (B)                     // 15493 Highway 287              // Apt/Lot            // Radio:TALK GP3                       //                                // NOT FOUND  // BFD,BE1,P331,P329
(BFPD) (CFS) Falls (D)                      // 227 2nd St                     // Apt/Lot            // Radio:                               // SUNSHINE ACRES MOBILE HOME PAR // 49K1       // BFD,BE1,P331,P329
(BFPD) (CFS) Alarm Fire / Commercial        // 855 Franklin Ave               // Apt/Lot            // Radio:                               // BERTHOUD LIVING CENTER         // 48K3       // BFD,BTK1,BE2,P321
(BFPD) (CFS) Breathing Problems (C,D)       // 505 Mayo Ct                    // Apt/Lot            // Radio:TALK GP3                       //                                // 49K1       // BFD,BE1,P331,P329
(BFPD) (CFS) MVA Injury                     // 253800 Interstate 25 Sb        // Apt/Lot            // Radio:MUTUAL AID 1                   // MM 254 SB I25 JOHNSONS CORNER  // 45P1       // E6,P311,BFD,BE1
(BFPD) (CFS) MVA Unk Injury                 // 249999 Interstate 25 Nb        // Apt/Lot            // Radio:TALK GP3                       // MM 250 NB I25 BERTHOUD EXIT    // 49P1       // P331,BFD,BE1
(BFPD) (CFS) Other Agency EMD (C,D)         // 723 Live Oak Ct                // Apt/Lot            // Radio:TALK GP3                       //                                // 50G2       // BE2,P331,BFD,P329
(BFPD) (CFS) Other Agency EMD (C,D)         // 1402 4th St                    // Apt/Lot 3          // Radio:TALK GP2                       //                                // 48K1       // BFD,BE1,P321
(BFPD) (CFS) Traumatic Injuries (B)         // 3501 Cottonwood Ln             // Apt/Lot            // Radio:TALK GP3                       //                                // 50H1       // BE2,BFD,P331
(BFPD) (CFS) MVA Unk Injury                 // 249999 Interstate 25 Sb        // Apt/Lot            // Radio:TALK GP3                       // MM 250 SB I25 BERTHOUD EXIT    // 49P1       // P331,BFD,BE1
(BFPD) (CFS) Sick Person (Spec Diag) (A)    // 4th St & Massachusetts Ave     // Apt/Lot            // Radio:TALK GP3                       //                                // 48K4       // BFD,BE1,P331

 */

public class COLarimerCountyParserTest extends BaseParserTest {
  
  public COLarimerCountyParserTest() {
    setParser(new COLarimerCountyParser(), "LARIMER COUNTY", "CO");
  }
  
  @Test
  public void testBFPDParser() {

    doTest("T1",
        "(BFPD) (CFS) Power Lines Down/Arcing        // E County Road 4 & Weld County // Apt/Lot            // Radio:MAC 5 NE                       //",
        "SRC:BFPD",
        "CALL:Power Lines Down/Arcing",
        "ADDR:E County Road 4 & Weld County",
        "MADDR:E COUNTY ROAD 4 & Weld County",
        "CH:MAC 5 NE");

    doTest("T2",
        "(BFPD) (CFS) MVA Unk Injury                 // 248790 Interstate 25 Sb // Apt/Lot            // Radio:TALK GP3                       // MM 249 SB I25",
        "SRC:BFPD",
        "CALL:MVA Unk Injury",
        "ADDR:248790 Interstate 25 Sb",
        "MADDR:248790 Interstate 25",
        "CH:TALK GP3",
        "PLACE:MM 249 SB I25");

    doTest("T3",
        "(BFPD) (CFS) Grass / Wildland Fire          // 5307 Foothills Dr  // Apt/Lot            // Radio:TALK GP3                       //",
        "SRC:BFPD",
        "CALL:Grass / Wildland Fire",
        "ADDR:5307 Foothills Dr",
        "CH:TALK GP3");

    doTest("T4",
        "(BFPD) (CFS) Alarm Fire / Residential       // 20510 Weld County Road 5   // Apt/Lot            // Radio:TALK GP3                       // CLETCHER RESIDENCE",
        "SRC:BFPD",
        "CALL:Alarm Fire / Residential",
        "ADDR:20510 Weld County Road 5",
        "MADDR:20510 Weld COUNTY ROAD 5",
        "PLACE:CLETCHER RESIDENCE",
        "CH:TALK GP3");

    doTest("T5",
        "(BFPD) (CFS) Convulsions/Seizures (C,D)     // 315 Goose Hollow Rd  // Apt/Lot            // Radio:TALK GP2                       //",
        "SRC:BFPD",
        "CALL:Convulsions/Seizures (C,D)",
        "ADDR:315 Goose Hollow Rd",
        "CH:TALK GP2");

    doTest("T6",
        "(BFPD) (CFS) Breathing Problems (E)         // 512 Redwood Cir  // Apt/Lot            // Radio:                               //",
        "SRC:BFPD",
        "CALL:Breathing Problems (E)",
        "ADDR:512 Redwood Cir");
    
  }
  
  @Test
  public void testLFRParser() {

    doTest("T1",
        "(NOTIFYall msg) (CFS) Alarm Fire / CO with Patients  // 1727 N Wilson Ave              // Apt/Lot 503        // Radio:TALK GP2                       //",
        "CALL:Alarm Fire / CO with Patients",
        "ADDR:1727 N Wilson Ave",
        "APT:503",
        "CH:TALK GP2");
   
  }
  
  @Test
  public void testBerthoudFire() {

    doTest("T1",
        "(BFPD) (CFS) MVA Injury                     // 45 Vdr                         // Apt/Lot            // Radio:TALK GP3                       // VDR VALLEY DIRT RIDERS         // 49P4       // P331,BFD,BE1",
        "SRC:BFPD",
        "CALL:MVA Injury",
        "ADDR:45 Vdr",
        "CH:TALK GP3",
        "PLACE:VDR VALLEY DIRT RIDERS",
        "MAP:49P4",
        "UNIT:P331,BFD,BE1");

    doTest("T2",
        "(BFPD) (CFS) Breathing Problems (C,D)       // 6205 Sandia Ln                 // Apt/Lot            // Radio:TALK GP3                       //                                // 47F2       // BE2,BFD,P331,P329",
        "SRC:BFPD",
        "CALL:Breathing Problems (C,D)",
        "ADDR:6205 Sandia Ln",
        "CH:TALK GP3",
        "MAP:47F2",
        "UNIT:BE2,BFD,P331,P329");

    doTest("T3",
        "(BFPD) (CFS) Breathing Problems (C,D)       // 505 Mayo Ct                    // Apt/Lot            // Radio:TALK GP3                       //                                // 49K1       // BFD,BE1,P331,P329",
        "SRC:BFPD",
        "CALL:Breathing Problems (C,D)",
        "ADDR:505 Mayo Ct",
        "CH:TALK GP3",
        "MAP:49K1",
        "UNIT:BFD,BE1,P331,P329");

    doTest("T4",
        "(BFPD) (CFS) Unconscious/Fainting (C,D)     // Interstate 25 Nb & E Highway 6 // Apt/Lot            // Radio:TALK GP3                       //                                // 45Q3       // P331,BE1,BFD,P329",
        "SRC:BFPD",
        "CALL:Unconscious/Fainting (C,D)",
        "ADDR:Interstate 25 Nb & E Highway 6",
        "MADDR:Interstate 25 & E Highway 6",
        "CH:TALK GP3",
        "MAP:45Q3",
        "UNIT:P331,BE1,BFD,P329");

    doTest("T5",
        "(BFPD) (CFS) MVA Unk Injury                 // 253800 Interstate 25 Sb        // Apt/Lot            // Radio:                               // MM 254 SB I25 JOHNSONS CORNER  // 45P1       // P351,E6,BFD,BE1",
        "SRC:BFPD",
        "CALL:MVA Unk Injury",
        "ADDR:253800 Interstate 25 Sb",
        "MADDR:253800 Interstate 25",
        "PLACE:MM 254 SB I25 JOHNSONS CORNER",
        "MAP:45P1",
        "UNIT:P351,E6,BFD,BE1");

    doTest("T6",
        "(BFPD) (CFS) MVA Unk Injury                 // 110 - 999 Weld County Road 46  // Apt/Lot            // Radio:TALK GP3                       //                                // 48M2       // P331,BE1,BFD",
        "SRC:BFPD",
        "CALL:MVA Unk Injury",
        "ADDR:110 - 999 Weld County Road 46",
        "MADDR:110 Weld COUNTY ROAD 46",
        "CH:TALK GP3",
        "MAP:48M2",
        "UNIT:P331,BE1,BFD");

    doTest("T7",
        "(BFPD) (CFS) MVA Unk Injury                 // 249999 Interstate 25 Sb        // Apt/Lot            // Radio:TALK GP3                       // MM 250 SB I25 BERTHOUD EXIT    // 49P1       // P331,BE1,BFD",
        "SRC:BFPD",
        "CALL:MVA Unk Injury",
        "ADDR:249999 Interstate 25 Sb",
        "MADDR:249999 Interstate 25",
        "CH:TALK GP3",
        "PLACE:MM 250 SB I25 BERTHOUD EXIT",
        "MAP:49P1",
        "UNIT:P331,BE1,BFD");

    doTest("T8",
        "(BFPD) (CFS) MVA Injury                     // WELD COUNTY ROAD 7 & E HIGHWAY // Apt/Lot            // Radio:TALK GP3                       //                                // 49P2       // P331,BE2,BFD",
        "SRC:BFPD",
        "CALL:MVA Injury",
        "ADDR:WELD COUNTY ROAD 7 & E HIGHWAY",
        "CH:TALK GP3",
        "MAP:49P2",
        "UNIT:P331,BE2,BFD");

    doTest("T9",
        "(BFPD) (CFS) MVA Unk Injury                 // 252090 Interstate 25 Sb        // Apt/Lot            // Radio:TALK GP2                       // MM 252 SB I25 JOHNSTOWN EXIT   // 47P1       // BFD,E6,P351,BE2",
        "SRC:BFPD",
        "CALL:MVA Unk Injury",
        "ADDR:252090 Interstate 25 Sb",
        "MADDR:252090 Interstate 25",
        "CH:TALK GP2",
        "PLACE:MM 252 SB I25 JOHNSTOWN EXIT",
        "MAP:47P1",
        "UNIT:BFD,E6,P351,BE2");

    doTest("T10",
        "(BFPD) (CFS) No EMD (B)                     // 15493 Highway 287              // Apt/Lot            // Radio:TALK GP3                       //                                // NOT FOUND  // BFD,BE1,P331,P329",
        "SRC:BFPD",
        "CALL:No EMD (B)",
        "ADDR:15493 Highway 287",
        "CH:TALK GP3",
        "UNIT:BFD,BE1,P331,P329");

    doTest("T11",
        "(BFPD) (CFS) Falls (D)                      // 227 2nd St                     // Apt/Lot            // Radio:                               // SUNSHINE ACRES MOBILE HOME PAR // 49K1       // BFD,BE1,P331,P329",
        "SRC:BFPD",
        "CALL:Falls (D)",
        "ADDR:227 2nd St",
        "PLACE:SUNSHINE ACRES MOBILE HOME PAR",
        "MAP:49K1",
        "UNIT:BFD,BE1,P331,P329");

    doTest("T12",
        "(BFPD) (CFS) Alarm Fire / Commercial        // 855 Franklin Ave               // Apt/Lot            // Radio:                               // BERTHOUD LIVING CENTER         // 48K3       // BFD,BTK1,BE2,P321",
        "SRC:BFPD",
        "CALL:Alarm Fire / Commercial",
        "ADDR:855 Franklin Ave",
        "PLACE:BERTHOUD LIVING CENTER",
        "MAP:48K3",
        "UNIT:BFD,BTK1,BE2,P321");

    doTest("T13",
        "(BFPD) (CFS) Breathing Problems (C,D)       // 505 Mayo Ct                    // Apt/Lot            // Radio:TALK GP3                       //                                // 49K1       // BFD,BE1,P331,P329",
        "SRC:BFPD",
        "CALL:Breathing Problems (C,D)",
        "ADDR:505 Mayo Ct",
        "CH:TALK GP3",
        "MAP:49K1",
        "UNIT:BFD,BE1,P331,P329");

    doTest("T14",
        "(BFPD) (CFS) MVA Injury                     // 253800 Interstate 25 Sb        // Apt/Lot            // Radio:MUTUAL AID 1                   // MM 254 SB I25 JOHNSONS CORNER  // 45P1       // E6,P311,BFD,BE1",
        "SRC:BFPD",
        "CALL:MVA Injury",
        "ADDR:253800 Interstate 25 Sb",
        "MADDR:253800 Interstate 25",
        "CH:MUTUAL AID 1",
        "PLACE:MM 254 SB I25 JOHNSONS CORNER",
        "MAP:45P1",
        "UNIT:E6,P311,BFD,BE1");

    doTest("T15",
        "(BFPD) (CFS) MVA Unk Injury                 // 249999 Interstate 25 Nb        // Apt/Lot            // Radio:TALK GP3                       // MM 250 NB I25 BERTHOUD EXIT    // 49P1       // P331,BFD,BE1",
        "SRC:BFPD",
        "CALL:MVA Unk Injury",
        "ADDR:249999 Interstate 25 Nb",
        "MADDR:249999 Interstate 25",
        "CH:TALK GP3",
        "PLACE:MM 250 NB I25 BERTHOUD EXIT",
        "MAP:49P1",
        "UNIT:P331,BFD,BE1");

    doTest("T16",
        "(BFPD) (CFS) Other Agency EMD (C,D)         // 723 Live Oak Ct                // Apt/Lot            // Radio:TALK GP3                       //                                // 50G2       // BE2,P331,BFD,P329",
        "SRC:BFPD",
        "CALL:Other Agency EMD (C,D)",
        "ADDR:723 Live Oak Ct",
        "CH:TALK GP3",
        "MAP:50G2",
        "UNIT:BE2,P331,BFD,P329");

    doTest("T17",
        "(BFPD) (CFS) Other Agency EMD (C,D)         // 1402 4th St                    // Apt/Lot 3          // Radio:TALK GP2                       //                                // 48K1       // BFD,BE1,P321",
        "SRC:BFPD",
        "CALL:Other Agency EMD (C,D)",
        "ADDR:1402 4th St",
        "APT:3",
        "CH:TALK GP2",
        "MAP:48K1",
        "UNIT:BFD,BE1,P321");

    doTest("T18",
        "(BFPD) (CFS) Traumatic Injuries (B)         // 3501 Cottonwood Ln             // Apt/Lot            // Radio:TALK GP3                       //                                // 50H1       // BE2,BFD,P331",
        "SRC:BFPD",
        "CALL:Traumatic Injuries (B)",
        "ADDR:3501 Cottonwood Ln",
        "CH:TALK GP3",
        "MAP:50H1",
        "UNIT:BE2,BFD,P331");

    doTest("T19",
        "(BFPD) (CFS) MVA Unk Injury                 // 249999 Interstate 25 Sb        // Apt/Lot            // Radio:TALK GP3                       // MM 250 SB I25 BERTHOUD EXIT    // 49P1       // P331,BFD,BE1",
        "SRC:BFPD",
        "CALL:MVA Unk Injury",
        "ADDR:249999 Interstate 25 Sb",
        "MADDR:249999 Interstate 25",
        "CH:TALK GP3",
        "PLACE:MM 250 SB I25 BERTHOUD EXIT",
        "MAP:49P1",
        "UNIT:P331,BFD,BE1");

    doTest("T20",
        "(BFPD) (CFS) Sick Person (Spec Diag) (A)    // 4th St & Massachusetts Ave     // Apt/Lot            // Radio:TALK GP3                       //                                // 48K4       // BFD,BE1,P331",
        "SRC:BFPD",
        "CALL:Sick Person (Spec Diag) (A)",
        "ADDR:4th St & Massachusetts Ave",
        "CH:TALK GP3",
        "MAP:48K4",
        "UNIT:BFD,BE1,P331");
  
  }
  
  public static void main(String[] args) {
    new COLarimerCountyParserTest().generateTests("T1");
  }
}