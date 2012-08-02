package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CASanJoaquinCountyParserTest extends BaseParserTest {
  
  public CASanJoaquinCountyParserTest() {
    setParser(new CASanJoaquinCountyParser(), "SAN JOAQUIN COUNTY", "CA");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "BS18-1    Dispatched: 00:45:33 Enroute: 00:48:05 On Scene: 01:00:47 AOR: 01:20:35",
        "CALL:RUN REPORT",
        "PLACE:BS18-1    Dispatched: 00:45:33 Enroute: 00:48:05 On Scene: 01:00:47 AOR: 01:20:35");

    doTest("T2",
        "BS18-1    Dispatched: 02:01:53 Enroute: 02:04:23 On Scene: 02:05:26 AOR: 02:26:24",
        "CALL:RUN REPORT",
        "PLACE:BS18-1    Dispatched: 02:01:53 Enroute: 02:04:23 On Scene: 02:05:26 AOR: 02:26:24");

    doTest("T3",
        "T26-1     12018446    Dispatched:18:49:50Enroute:18:51:55On Scene:18:53:54AOR:19:15:58",
        "CALL:RUN REPORT",
        "PLACE:T26-1     12018446    Dispatched:18:49:50Enroute:18:51:55On Scene:18:53:54AOR:19:15:58");

    doTest("T4",
        "T26-1     12018446    Dispatched:18:49:50Enroute:        On Scene:        AOR:18:51:14",
        "CALL:RUN REPORT",
        "PLACE:T26-1     12018446    Dispatched:18:49:50Enroute:        On Scene:        AOR:18:51:14");

    doTest("T5",
        "E26-1     12018782    Dispatched:00:37:41Enroute:00:40:05On Scene:        AOR:00:42:38",
        "CALL:RUN REPORT",
        "PLACE:E26-1     12018782    Dispatched:00:37:41Enroute:00:40:05On Scene:        AOR:00:42:38");

    doTest("T6",
        "T26-1     12018873    Dispatched:05:47:04Enroute:05:49:25On Scene:05:55:03AOR:06:01:39",
        "CALL:RUN REPORT",
        "PLACE:T26-1     12018873    Dispatched:05:47:04Enroute:05:49:25On Scene:05:55:03AOR:06:01:39");

  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "BS18-1    ZUM-110502      Medical Aid                     3232 E Munford Ave     Dead End/S STATE ROUBldg:            Apt: 3",
        "UNIT:BS18-1",
        "ID:ZUM-110502",
        "CALL:Medical Aid",
        "ADDR:3232 E Munford Ave",
        "X:Dead End/S STATE ROU",
        "APT:3");

    doTest("T2",
        "BS18-1    ZUM-110503      Medical Aid                     1840 S B St     E FOURTH ST/E FIFTH Bldg:            Apt:",
        "UNIT:BS18-1",
        "ID:ZUM-110503",
        "CALL:Medical Aid",
        "ADDR:1840 S B St",
        "X:E FOURTH ST/E FIFTH");

    doTest("T3",
        "T26-1     FRC-120542      Structure Fire                  10331 S Priest Rd                                 E GALIN RD/E KRELL LBldg:            Apt:",
        "UNIT:T26-1",
        "ID:FRC-120542",
        "CALL:Structure Fire",
        "ADDR:10331 S Priest Rd",
        "X:E GALIN RD/E KRELL L");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "E18-1 11020566     Fire Alarm - Co  5045 S State Route 99 E F E ARCH RD/E SUNNY RD 830A",
        "UNIT:E18-1",
        "ID:11020566",
        "CALL:Fire Alarm - Co",
        "ADDR:5045 S State Route 99 E",
        "MADDR:5045 S State 99 E",
        "X:F E ARCH RD / E SUNNY RD",
        "MAP:830A");

    doTest("T2",
        "      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386                Assigned Units: E9-3,E9-2,E26-2,BC9-0",
        "UNIT:E9-3,E9-2,E26-2,BC9-0",
        "ID:12014058",
        "CALL:Vegetation Fire",
        "ADDR:30000 S Kasson Rd",
        "X:E LINNE RD/E DEODARA",
        "MAP:T386");

    doTest("T3",
        "BC9-0 12018079     Traffic Collisi W Eleventh St / S Bird Rd                           T327A               Assigned Units: E9-2,T26-2,E9-6,T9-1,BC9-0",
        "UNIT:E9-2,T26-2,E9-6,T9-1,BC9-0",
        "ID:12018079",
        "CALL:Traffic Collisi",
        "ADDR:W Eleventh St & S Bird Rd",
        "MAP:T327A");

    doTest("T4",
        "T26-1 12018446     Structure Fire   16658 S Ore Claim Trl     W CLAIM STAKE AVE/W  L142A                                Assigned Units:T26-1,E11-1,T26-1,E3-4,E3-1,LM",
        "UNIT:T26-1,E11-1,T26-1,E3-4,E3-1,LM",
        "ID:12018446",
        "CALL:Structure Fire",
        "ADDR:16658 S Ore Claim Trl",
        "X:W CLAIM STAKE AVE/W",
        "MAP:L142A");

    doTest("T5",
        "E26-1 12018116     Vegetation Fire I 5 NB / S KASSON RD                                H5C3                Assigned Units: E9-3,E26-1",
        "UNIT:E9-3,E26-1",
        "ID:12018116",
        "CALL:Vegetation Fire",
        "ADDR:I 5 NB & S KASSON RD",
        "MADDR:I 5 & S KASSON RD",
        "MAP:H5C3");

    doTest("T6",
        "      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386                Assigned Units: E9-3,E9-2,E26-2,BC9-0",
        "UNIT:E9-3,E9-2,E26-2,BC9-0",
        "ID:12014058",
        "CALL:Vegetation Fire",
        "ADDR:30000 S Kasson Rd",
        "X:E LINNE RD/E DEODARA",
        "MAP:T386");

    doTest("T7",
        "T26-2 12018956     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B               Assigned Units: T26-2",
        "UNIT:T26-2",
        "ID:12018956",
        "CALL:Medical Aid",
        "ADDR:25600 S Chrisman Rd",
        "X:W SCHULTE RD/ELISSAG",
        "MAP:T354B");

    doTest("T8",
        "T9-1  12018957     Traffic Collisi I 580 Eb / S Corral Hollow Rd                       H580C1              Assigned Units: E9-4,E9-8,T9-1,BC9-0,E26-1",
        "UNIT:E9-4,E9-8,T9-1,BC9-0,E26-1",
        "ID:12018957",
        "CALL:Traffic Collisi",
        "ADDR:I 580 Eb & S Corral Hollow Rd",
        "MADDR:I 580 & S Corral Hollow Rd",
        "MAP:H580C1");

    doTest("T9",
        "      12019053     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B               Assigned Units: T26-2",
        "UNIT:T26-2",
        "ID:12019053",
        "CALL:Medical Aid",
        "ADDR:25600 S Chrisman Rd",
        "X:W SCHULTE RD/ELISSAG",
        "MAP:T354B");

  }
  
  @Test
  public void testJohn() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:BS18-1    ZUM-110502      Medical Aid                     3232 E Munford Ave\n" +
        "(Con't) 2 of 2\n" +
        "     Dead End/S STATE ROUBldg:            Apt: 3\n" +
        "(End)",

        "UNIT:BS18-1",
        "ID:ZUM-110502",
        "CALL:Medical Aid",
        "ADDR:3232 E Munford Ave",
        "X:Dead End/S STATE ROU",
        "APT:3");

    doTest("T2",
        "FRM:LifecomCellPaging@amr.net\nMSG:BS18-1    Dispatched: 00:45:33 Enroute: 00:48:05 On Scene: 01:00:47 AOR: 01:20:35",
        "CALL:RUN REPORT",
        "PLACE:BS18-1    Dispatched: 00:45:33 Enroute: 00:48:05 On Scene: 01:00:47 AOR: 01:20:35");

    doTest("T3",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:BS18-1    ZUM-110503      Medical Aid                     1840 S B St\n" +
        "(Con't) 2 of 2\n" +
        "     E FOURTH ST/E FIFTH Bldg:            Apt:\n" +
        "(End)",

        "UNIT:BS18-1",
        "ID:ZUM-110503",
        "CALL:Medical Aid",
        "ADDR:1840 S B St",
        "X:E FOURTH ST/E FIFTH");

    doTest("T4",
        "FRM:LifecomCellPaging@amr.net\nMSG:BS18-1    Dispatched: 02:01:53 Enroute: 02:04:23 On Scene: 02:05:26 AOR: 02:26:24",
        "CALL:RUN REPORT",
        "PLACE:BS18-1    Dispatched: 02:01:53 Enroute: 02:04:23 On Scene: 02:05:26 AOR: 02:26:24");

    doTest("T5",
        "FRM:LifecomCellPaging@amr.net\nMSG:E18-1 11020566     Fire Alarm - Co  5045 S State Route 99 E F E ARCH RD/E SUNNY RD 830A",
        "UNIT:E18-1",
        "ID:11020566",
        "CALL:Fire Alarm - Co",
        "ADDR:5045 S State Route 99 E",
        "MADDR:5045 S State 99 E",
        "X:F E ARCH RD / E SUNNY RD",
        "MAP:830A");

  }
  
  @Test
  public void testDavidReinhard() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386            \n" +
        "(Con't) 2 of 2\n" +
        "    Assigned Units: E9-3,E9-2,E26-2,BC9-0\r\n" +
        "(End)",

        "UNIT:E9-3,E9-2,E26-2,BC9-0",
        "ID:12014058",
        "CALL:Vegetation Fire",
        "ADDR:30000 S Kasson Rd",
        "X:E LINNE RD/E DEODARA",
        "MAP:T386");

    doTest("T2",
        "1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:BC9-0 12018079     Traffic Collisi W Eleventh St / S Bird Rd                           T327A           \n" +
        "(Con't) 2 of 2\n" +
        "    Assigned Units: E9-2,T26-2,E9-6,T9-1,BC9-0\r\n" +
        "(End)",

        "UNIT:E9-2,T26-2,E9-6,T9-1,BC9-0",
        "ID:12018079",
        "CALL:Traffic Collisi",
        "ADDR:W Eleventh St & S Bird Rd",
        "MAP:T327A");

    doTest("T3",
        "FRM:LifecomCellPaging@amr.net\nMSG:T26-1     12018446    Dispatched:18:49:50Enroute:        On Scene:        AOR:18:51:14",
        "CALL:RUN REPORT",
        "PLACE:T26-1     12018446    Dispatched:18:49:50Enroute:        On Scene:        AOR:18:51:14");

    doTest("T4",
        "FRM:LifecomCellPaging@amr.net\nMSG:T26-1     12018446    Dispatched:18:49:50Enroute:18:51:55On Scene:18:53:54AOR:19:15:58",
        "CALL:RUN REPORT",
        "PLACE:T26-1     12018446    Dispatched:18:49:50Enroute:18:51:55On Scene:18:53:54AOR:19:15:58");

    doTest("T5",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:T26-1 12018446     Structure Fire   16658 S Ore Claim Trl     W CLAIM STAKE AVE/W  L142A               \n" +
        "(Con't) 2 of 2\n" +
        "                 Assigned Units:T26-1,E11-1,T26-1,E3-4,E3-1,LM\n" +
        "(End)",

        "UNIT:T26-1,E11-1,T26-1,E3-4,E3-1,LM",
        "ID:12018446",
        "CALL:Structure Fire",
        "ADDR:16658 S Ore Claim Trl",
        "X:W CLAIM STAKE AVE/W",
        "MAP:L142A");

    doTest("T6",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:T26-1     FRC-120542      Structure Fire                  10331 S Priest Rd                            \n" +
        "(Con't) 2 of 2\n" +
        "     E GALIN RD/E KRELL LBldg:            Apt:\n" +
        "(End)",

        "UNIT:T26-1",
        "ID:FRC-120542",
        "CALL:Structure Fire",
        "ADDR:10331 S Priest Rd",
        "X:E GALIN RD/E KRELL L");

    doTest("T7",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:E26-1 12018116     Vegetation Fire I 5 NB / S KASSON RD                                H5C3            \n" +
        "(Con't) 2 of 2\n" +
        "    Assigned Units: E9-3,E26-1\n" +
        "(End)",

        "UNIT:E9-3,E26-1",
        "ID:12018116",
        "CALL:Vegetation Fire",
        "ADDR:I 5 NB & S KASSON RD",
        "MADDR:I 5 & S KASSON RD",
        "MAP:H5C3");

    doTest("T8",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:      12014058     Vegetation Fire 30000 S Kasson Rd              E LINNE RD/E DEODARA T386            \n" +
        "(Con't) 2 of 2\n" +
        "    Assigned Units: E9-3,E9-2,E26-2,BC9-0\n" +
        "(End)",

        "UNIT:E9-3,E9-2,E26-2,BC9-0",
        "ID:12014058",
        "CALL:Vegetation Fire",
        "ADDR:30000 S Kasson Rd",
        "X:E LINNE RD/E DEODARA",
        "MAP:T386");

    doTest("T9",
        "FRM:LifecomCellPaging@amr.net\nMSG:E26-1     12018782    Dispatched:00:37:41Enroute:00:40:05On Scene:        AOR:00:42:38\r\n",
        "CALL:RUN REPORT",
        "PLACE:E26-1     12018782    Dispatched:00:37:41Enroute:00:40:05On Scene:        AOR:00:42:38");

    doTest("T10",
        "FRM:LifecomCellPaging@amr.net\nMSG:T26-1     12018873    Dispatched:05:47:04Enroute:05:49:25On Scene:05:55:03AOR:06:01:39\r\n",
        "CALL:RUN REPORT",
        "PLACE:T26-1     12018873    Dispatched:05:47:04Enroute:05:49:25On Scene:05:55:03AOR:06:01:39");

    doTest("T11",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:T26-2 12018956     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B           \n" +
        "(Con't) 2 of 2\n" +
        "    Assigned Units: T26-2\r\n" +
        "(End)",

        "UNIT:T26-2",
        "ID:12018956",
        "CALL:Medical Aid",
        "ADDR:25600 S Chrisman Rd",
        "X:W SCHULTE RD/ELISSAG",
        "MAP:T354B");

    doTest("T12",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:T9-1  12018957     Traffic Collisi I 580 Eb / S Corral Hollow Rd                       H580C1          \n" +
        "(Con't) 2 of 2\n" +
        "    Assigned Units: E9-4,E9-8,T9-1,BC9-0,E26-1\r\n" +
        "(End)",

        "UNIT:E9-4,E9-8,T9-1,BC9-0,E26-1",
        "ID:12018957",
        "CALL:Traffic Collisi",
        "ADDR:I 580 Eb & S Corral Hollow Rd",
        "MADDR:I 580 & S Corral Hollow Rd",
        "MAP:H580C1");

    doTest("T13",
        " 1 of 2\n" +
        "FRM:LifecomCellPaging@amr.net\n" +
        "MSG:      12019053     Medical Aid     25600 S Chrisman Rd            W SCHULTE RD/ELISSAG T354B           \n" +
        "(Con't) 2 of 2\n" +
        "    Assigned Units: T26-2\r\n" +
        "(End)",

        "UNIT:T26-2",
        "ID:12019053",
        "CALL:Medical Aid",
        "ADDR:25600 S Chrisman Rd",
        "X:W SCHULTE RD/ELISSAG",
        "MAP:T354B");

  }
  
  public static void main(String[] args) {
    new CASanJoaquinCountyParserTest().generateTests("T1", "UNIT ID CALL ADDR X MAP PLACE APT");
  }
}