package net.anei.cadpage.parsers.NV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NVLasVegasCountyParserTest extends BaseParserTest {
  
  public NVLasVegasCountyParserTest() {
    setParser(new NVLasVegasParser(), "LAS VEGAS", "NV");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[SMS]  RE: 4051722 U: 3901, P: 2, G: 2914, PH: 28 L: 4966 MOMENTI ST-CC# , B: , AL: PC:, 26B PN:, N:26B], Location from Fire: 4966 MOMENTI ST, 01:57:51 88YOM CB...SE",
        "ID:4051722",
        "UNIT:3901",
        "PRI:2",
        "MAP:2914-28",
        "ADDR:4966 MOMENTI ST",
        "CODE:26B",
        "INFO:88YOM CB...SE");

    doTest("T2",
        "[SMS]  I: 4051701 U: 3901, P: 2, G: 2819, PH: 97 L: 6255 W TROPICANA AVE# , B: , AL: PC:, 32B PN:, N:32B], 00:38:29 Class of service: WPH2], 00:38:29 Validity of add",
        "ID:4051701",
        "UNIT:3901",
        "PRI:2",
        "MAP:2819-97",
        "ADDR:6255 W TROPICANA AVE",
        "CODE:32B",
        "INFO:Class of service: WPH2, Validity of add");

    doTest("T3",
        "[SMS]  I: 4051596 U: 3901, P: 2, G: 3223, PH: 55 L: S I 215 / S I 15# , B: , AL: PC:, 29B PN:, N:29B], 18:24:23 PR WAS PASSERBY UNK IF DRIVER IS INJ], 18:24:16 NHP E",
        "ID:4051596",
        "UNIT:3901",
        "PRI:2",
        "MAP:3223-55",
        "ADDR:S I 215 & S I 15",
        "CODE:29B",
        "INFO:PR WAS PASSERBY UNK IF DRIVER IS INJ, NHP E");

    doTest("T4",
        "[SMS]  I: 4050480 U: 3901, P: 1, G: 2715, PH: 62 L: 3779 TOHONO CANYON ST-CC# , B: , AL: PC:, 19D PN:, N:19D], Location from Fire: 3779 TOHONO CANYON ST, 22:04:52 Cl",
        "ID:4050480",
        "UNIT:3901",
        "PRI:1",
        "MAP:2715-62",
        "ADDR:3779 TOHONO CANYON ST",
        "CODE:19D",
        "INFO:Cl");

    doTest("T5",
        "[SMS]  I: 4050510 U: 3901, P: 1, G: 2925, PH: 92 L: 5757 WAYNE NEWTON BLVD-CC# , B: MCCARRAN INTERNATION, AL: PC:, 31D PN:, N:31D], Location from Fire: 5757 WAYNE NE",
        "ID:4050510",
        "UNIT:3901",
        "PRI:1",
        "MAP:2925-92",
        "ADDR:5757 WAYNE NEWTON BLVD",
        "PLACE:MCCARRAN INTERNATION",
        "CODE:31D");

    doTest("T6",
        "[SMS]  I: 4051701 U: 3901, P: 2, G: 2819, PH: 97 L: 6255 W TROPICANA AVE# , B: , AL: PC:, 32B PN:, N:32B], 00:38:29 Class of service: WPH2], 00:38:29 Validity of add",
        "ID:4051701",
        "UNIT:3901",
        "PRI:2",
        "MAP:2819-97",
        "ADDR:6255 W TROPICANA AVE",
        "CODE:32B",
        "INFO:Class of service: WPH2, Validity of add");

    doTest("T7",
        "[SMS]  RE: 4051722 U: 3901, P: 2, G: 2914, PH: 28 L: 4966 MOMENTI ST-CC# , B: , AL: PC:, 26B PN:, N:26B], Location from Fire: 4966 MOMENTI ST, 01:57:51 88YOM CB...SE",
        "ID:4051722",
        "UNIT:3901",
        "PRI:2",
        "MAP:2914-28",
        "ADDR:4966 MOMENTI ST",
        "CODE:26B",
        "INFO:88YOM CB...SE");

    doTest("T8",
        "[SMS]  I: 4051593 U: 3901, P: 2, G: 3316, PH: 99 L: 291 TAYMAN PARK AVE# , B: , AL: PC:, 25B PN:, N:25B], 18:22:40 17YOM,, /L2K ,, CODE 4 TO ENTER METO 97], 18:22:19",
        "ID:4051593",
        "UNIT:3901",
        "PRI:2",
        "MAP:3316-99",
        "ADDR:291 TAYMAN PARK AVE",
        "CODE:25B",
        "INFO:17YOM,, /L2K ,, CODE 4 TO ENTER METO 97,");

    doTest("T9",
        "[SMS]  I: 4051184 U: 3901, P: 1, G: 2915, PH: 51 L: 10196 STONE OAK CT-CC# , B: , AL: PC:, 10D PN:, N:10D], Location from Fire: 10196 STONE OAK CT, 01:36:01 [Geograp",
        "ID:4051184",
        "UNIT:3901",
        "PRI:1",
        "MAP:2915-51",
        "ADDR:10196 STONE OAK CT",
        "CODE:10D",
        "INFO:[Geograp");

    doTest("T10",
        "[SMS]  I: 4049937 U: 3901, P: 1, G: 2824, PH: 57 L: 265 E HARMON AVE# , B: , AL: PC:, 6C PN:, N:6C], 00:09:13 65YOM,CSHORT OF BREATH], 00:09:04 [Address: 265 E HARMO",
        "ID:4049937",
        "UNIT:3901",
        "PRI:1",
        "MAP:2824-57",
        "ADDR:265 E HARMON AVE",
        "CODE:6C",
        "INFO:65YOM,CSHORT OF BREATH, [Address: 265 E HARMO");
  }
  

  public static void main(String[] args) {
    new NVLasVegasCountyParserTest().generateTests("T1");
  }
}
