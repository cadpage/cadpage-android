package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDMontgomeryCountyParser;

import org.junit.Test;

public class MDMontgomeryCountyParserTest extends BaseParserTest {

  public MDMontgomeryCountyParserTest() {
    setParser(new MDMontgomeryCountyParser(), "MONTGOMERY COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
    		"MCo / [mCAD] * D * 2301 * BUILDING FIRE * 1620 E JEFFERSON ST ,RO * E723 E703 E721 E726 E705B AT723 AT703 RS703 A723 BC703 BC704 D3 D5 DFRS INV CEALRM CODE BCNOT",
    		"BOX:2301",
    		"CALL:BUILDING FIRE",
    		"ADDR:1620 E JEFFERSON ST",
    		"CITY:ROCKVILLE",
    		"UNIT:E723 E703 E721 E726 E705B AT723 AT703 RS703 A723 BC703 BC704"
    		);
    doTest("T2",
    		"MCo / [mCAD] * D * 0302 * BUILDING FIRE * 733 MONROE ST ,RO * E723 E733 E726 E725 E721 AT703 AT723 RS741B M723 BC703 BC704 D3 D5 DFRS INV CEALRM CODE BCNOT",
    		"BOX:0302",
    		"CALL:BUILDING FIRE",
    		"ADDR:733 MONROE ST",
        "CITY:ROCKVILLE",
    		"UNIT:E723 E733 E726 E725 E721 AT703 AT723 RS741B M723 BC703 BC704"
    		);
    doTest("T3",
    		"MCo / [mCAD] * D * 0301 * HOUSE FIRE * 1006 DE BECK DR ,RO * E703 E723 E721 E725 E733 AT703 T731 RS703 A703 BC703 BC704",
    		"BOX:0301",
    		"CALL:HOUSE FIRE",
    		"ADDR:1006 DE BECK DR",
        "CITY:ROCKVILLE",
    		"UNIT:E703 E723 E721 E725 E733 AT703 T731 RS703 A703 BC703 BC704"
    		);
    doTest("T4",
    		"MCo / [mCAD] * D * 2312 * UNCONFIRMED POWDER * 5700 BOU AVE ,MCG (TARGET STORE) * E723 AT723 A723 M703 HM707 E720",
    		"BOX:2312",
    		"CALL:UNCONFIRMED POWDER",
    		"ADDR:5700 BOU AVE",
    		"UNIT:E723 AT723 A723 M703 HM707 E720",
    		"PLACE:TARGET STORE"
    		);
    doTest("T5",
    		"MCo / [mCAD] * D * 0801 * BOX ALARM * 17211 KING JAMES WAY ,MCG * E728 E731 E703 T731 RS703 A708C BC705 BC703",
    		"BOX:0801",
    		"CALL:BOX ALARM",
    		"ADDR:17211 KING JAMES WAY",
    		"UNIT:E728 E731 E703 T731 RS703 A708C BC705 BC703"
    		);
    doTest("T6",
        "CAD MSG: * D * 3132 * BOX ALARM * 209 FOUNTAIN GREEN LA ,GA  * E708 E722 E729 E734 E728 T731 AT708 RS703 M73M",
        "BOX:3132",
        "CALL:BOX ALARM",
        "ADDR:209 FOUNTAIN GREEN LA",
        "MADDR:209 FOUNTAIN GREEN LN",
        "CITY:GAITHERSBURG",
        "UNIT:E708 E722 E729 E734 E728 T731 AT708 RS703");

    doTest("T7",
        "CAD MSG: * D * 3525 * PIC w/VEH OVERTURNED-ALS1 * S270C 121-27 @ 17000 S270 X18 TO X16 HWY ,MCG  * M735 T7",
        "BOX:3525",
        "CALL:PIC w/VEH OVERTURNED-ALS1",
        "PLACE:S270C 121-27",
        "ADDR:17000 S270 X18 TO X16 HWY",
        "UNIT:M735");

    doTest("T8",
        "(MCo) [mCAD] * D * 4009 * PIC w/ ENTRAPMENT -ALS1 * 4700 BROOM DR / 18400 WICKHAM RD ,MCG * A740 E740 M704 RS704 D4 EMS EMSNOT BCNOT DFRS",
        "BOX:4009",
        "CALL:PIC w/ ENTRAPMENT -ALS1",
        "ADDR:4700 BROOM DR & 18400 WICKHAM RD",
        "MADDR:4700 BROOM DR",
        "UNIT:A740 E740 M704 RS704");

    doTest("T9",
        "FRM:General Alerts\nMSG:CAD MSG: * D *  * MAF FULL * 14615 PHILIP DR * AT715 BCNOT DFRS=",
        "CALL:MAF FULL",
        "ADDR:14615 PHILIP DR",
        "UNIT:AT715");

    doTest("T10",
        "CAD MSG: * D * 0609 * RSC - RESET ALARM * 4908 AUBURN AVE ,MCG  * RS741B ECC1",
        "BOX:0609",
        "CALL:RSC - RESET ALARM",
        "ADDR:4908 AUBURN AVE",
        "UNIT:RS741B");

    doTest("T11",
        "CAD MSG: * D * 1704 * ABDOMINAL PAIN * 7500 MATTINGLY LA ,MCG  * A717 ECC30",
        "BOX:1704",
        "CALL:ABDOMINAL PAIN",
        "ADDR:7500 MATTINGLY LA",
        "MADDR:7500 MATTINGLY LN",
        "UNIT:A717");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[Important message from MCEN] CAD MSG: * D * 2112 * PIC w/ ENTRAPMENT -ALS1 * 12000 CONNECTICUT AVE / 11900 VEIRS MILL RD ,MCG  * A721 PE721 RS742B D5 DFRS\n" +
        "Sent by MCCAD MCCAD to PE721, FS21, A721, DFRS, D5, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2112",
        "CALL:PIC w/ ENTRAPMENT -ALS1",
        "ADDR:12000 CONNECTICUT AVE & 11900 VEIRS MILL RD",
        "MADDR:12000 CONNECTICUT AVE",
        "UNIT:A721 PE721 RS742B");

    doTest("T2",
        "[Important message from MCEN] CAD MSG: * D * 2403 * HOUSE FIRE * 5 APPLEBY CT ,MCG  * PE715 PE718 PE712 PE841 PE716 T715 AT718 RS742B M715 BC701 BC704 D12 D15 DFRS INV CEALRM CODE BCNOT\n" +
        "Sent by MCCAD MCCAD to INV, BCNOT, D15, FS24, PE718, PE715, D12, AT718, PE716, CEALRM, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2403",
        "CALL:HOUSE FIRE",
        "ADDR:5 APPLEBY CT",
        "UNIT:PE715 PE718 PE712 PE841 PE716 T715 AT718 RS742B M715 BC701 BC704");

    doTest("T3",
        "[Important message from MCEN] CAD MSG: * D * 2403 * HOUSE FIRE * 8 APPLEBY CT ,MCG  * RID T716 RS814 REDX INV CODE DFRS WIG A724\n" +
        "Sent by MCCAD MCCAD to INV, WIG, T716, FS24, A724, DFRS, REDX, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2403",
        "CALL:HOUSE FIRE",
        "ADDR:8 APPLEBY CT",
        "UNIT:T716 RS814 A724");

    doTest("T4",
        "[Important message from MCEN] CAD MSG: * D * 3008 * POTOMAC RIVER RESCUE M * BILLY GOAT TRAIL A @ 13250 POTOMAC RIVER RIVR ,MCG  * RRTF ST710 SWTL A710 M401 PE730 D10 EAGLE DFRS BCNOT WRT\n" +
        "Sent by MCCAD MCCAD to FS30, PE730, BCNOT, DFRS, RRAT, D10, ST710, A710, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:3008",
        "CALL:POTOMAC RIVER RESCUE M",
        "ADDR:13250 POTOMAC RIVER RIVR",
        "PLACE:BILLY GOAT TRAIL A",
        "UNIT:ST710 A710 M401 PE730");

    doTest("T5",
        "[Important message from MCEN] CAD MSG: * D * 1102 * PIC * 6598 MASSACHUSETTS AVE / 6400 GOLDSBORO RD ,MCG  * RS741 M741 DFRS\n" +
        "Sent by MCCAD MCCAD to RS741, DFRS, FS11, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1102",
        "CALL:PIC",
        "ADDR:6598 MASSACHUSETTS AVE & 6400 GOLDSBORO RD",
        "MADDR:6598 MASSACHUSETTS AVE",
        "UNIT:RS741 M741");

    doTest("T6",
        "[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * PE717 PE728 PE740 PE708 PE734 PAT708 AT734 RS717 EW717 W704 W722 A717 BC703 BC704 D17 D8 DFRS INV CODE BCNOT\n" +
        "Sent by MCCAD MCCAD to INV, PE717, D8, RS717, W704, PE728, A717, EW717, BCNOT, PE740, pat708, BC703, pe708, D17, DFRS, AT734, FS17, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1716",
        "CALL:BOX ALARM",
        "ADDR:20908 GOLF VIEW DR",
        "PLACE:MONTGOMERY CC",
        "UNIT:PE717 PE728 PE740 PE708 PE734 PAT708 AT734 RS717 EW717 W704 W722 A717 BC703 BC704");

    doTest("T7",
        "[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * RID T725 RS729 M708 REDX INV CODE WIG DFRS\n" +
        "Sent by MCCAD MCCAD to INV, WIG, DFRS, M708, RS729, FS17, REDX, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1716",
        "CALL:BOX ALARM",
        "ADDR:20908 GOLF VIEW DR",
        "PLACE:MONTGOMERY CC",
        "UNIT:T725 RS729 M708");

    doTest("T8",
        "[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * WSTF W731 HCEW44 W709 PE704 D17 DFRS A708\n" +
        "Sent by MCCAD MCCAD to A708, DFRS, D17, pe704, FS17, W731, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1716",
        "CALL:BOX ALARM",
        "ADDR:20908 GOLF VIEW DR",
        "PLACE:MONTGOMERY CC",
        "UNIT:W731 W709 PE704 A708");

    doTest("T9",
        "[Important message from MCEN] CAD MSG: * D * 1716 * BOX ALARM * 20908 GOLF VIEW DR ,MCG (MONTGOMERY CC) * TF E753 PE729 AT718 D17 CT740 DFRS WITF AR733\n" +
        "Sent by MCCAD MCCAD to AT718, PE729, DFRS, D17, E753, FS17, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1716",
        "CALL:BOX ALARM",
        "ADDR:20908 GOLF VIEW DR",
        "PLACE:MONTGOMERY CC",
        "UNIT:E753 PE729 AT718 CT740 AR733");

    doTest("T10",
        "[Important message from MCEN] CAD MSG: * D * PG00 * MAF FULL * 6017 EASTERN AVE ,PG  * E702 T716 DFRS\n" +
        "Sent by MCCAD MCCAD to T716, DFRS, E702, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:PG00",
        "CALL:MAF FULL",
        "ADDR:6017 EASTERN AVE",
        "CITY:PRINCE GEORGES COUNTY",
        "UNIT:E702 T716");

    doTest("T11",
        "[Important message from MCEN] CAD MSG: * D * 0807 * PEDESTRIAN STRUCK- ALS2 * 460 GIRARD ST ,GA  * M708 DFRS PE708 ECC25\n" +
        "Sent by MCCAD MCCAD to pe708, FS08, DFRS, M708, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:0807",
        "CALL:PEDESTRIAN STRUCK- ALS2",
        "ADDR:460 GIRARD ST",
        "CITY:GAITHERSBURG",
        "UNIT:M708 PE708");

    doTest("T12",
        "[Important message from MCEN] CAD MSG: * D * 1527 * BOX ALARM * 13631 COLGATE WAY ,MCG  * PE715 PE841 PE724 PE712 T715 TK831 RS849 BC701 BC704 D15 D12 DFRS INV CEALRM CODE BCNOT A724 E810C\n" +
        "Sent by MCCAD MCCAD to INV, PE724, D15, BCNOT, FS15, PE715, D12, A724, CEALRM, DFRS, pe712, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1527",
        "CALL:BOX ALARM",
        "ADDR:13631 COLGATE WAY",
        "UNIT:PE715 PE841 PE724 PE712 T715 TK831 RS849 BC701 BC704 A724 E810C");

    doTest("T13",
        "[Important message from MCEN] CAD MSG: * D * 0846 * PIC w/ ENTRAPMENT -ALS1 * S270H 370-SHD GRV @ 8500 S270 X9 TO X8 HWY ,GA  * M708B RS703 PE708 D8 DFRS A753 M731 PAT708\n" +
        "Sent by MCCAD MCCAD to pe708, A753, RS703, FS08, D8, M708B, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:0846",
        "CALL:PIC w/ ENTRAPMENT -ALS1",
        "ADDR:8500 S270 X9 TO X8 HWY",
        "CITY:GAITHERSBURG",
        "PLACE:S270H 370-SHD GRV",
        "UNIT:M708B RS703 PE708 A753 M731 PAT708");

    doTest("T14",
        "[Important message from MCEN] CAD MSG: * D * 1527 * PIC - UNK STATUS * 3403 HAMPTON HOLLOW DR ,MCG  * DFRS\n" +
        "Sent by MCCAD MCCAD to DFRS, FS15, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1527",
        "CALL:PIC - UNK STATUS",
        "ADDR:3403 HAMPTON HOLLOW DR");

    doTest("T15",
        "[Important message from MCEN] CAD MSG: * D * 0208 * PEDESTRIAN STRUCK- ALS2 * 300 DOMER AVE / 8600 FLOWER AVE ,MCG  * A702 M701 DFRS ECC28 PE701\n" +
        "Sent by MCCAD MCCAD to pe701, A702, DFRS, M701, FS02, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:0208",
        "CALL:PEDESTRIAN STRUCK- ALS2",
        "ADDR:300 DOMER AVE & 8600 FLOWER AVE",
        "MADDR:300 DOMER AVE",
        "UNIT:A702 M701 PE701");

    doTest("T16",
        "[Important message from MCEN] CAD MSG: * D * 2101 * HOUSE FIRE * 11828 ROCKING HORSE RD ,MCG  * PE721 PE723 E705B PE718 PE725 AT723 AT718 RS742B A721 BC704 BC702 D5 D3 DFRS INV CEALRM CODE BCNOT\n" +
        "Sent by MCCAD MCCAD to INV, BCNOT, D3, PE721, FS21, PE723, AT723, E705B, AT718, CEALRM, DFRS, D5, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2101",
        "CALL:HOUSE FIRE",
        "ADDR:11828 ROCKING HORSE RD",
        "UNIT:PE721 PE723 E705B PE718 PE725 AT723 AT718 RS742B A721 BC704 BC702");

    doTest("T17",
        "[Important message from MCEN] CAD MSG: * D * 2606 * BELLS * 5550 TUCKERMAN LA ,MCG (BRIGHTON GARDENS (SNF)) * E726 AT723 CEALRM ECC30\n" +
        "Sent by MCCAD MCCAD to E726, AT723, CEALRM, FS26, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2606",
        "CALL:BELLS",
        "ADDR:5550 TUCKERMAN LA",
        "MADDR:5550 TUCKERMAN LN",
        "PLACE:BRIGHTON GARDENS (SNF",
        "UNIT:E726 AT723");

    doTest("T18",
        "[Important message from MCEN] CAD MSG: * D * 1106 * CHEM / HAZMAT * 5400 WESTBARD AVE ,MCG (GIANT FOOD) * E711 PE706 E710 T706 RS741 A711 M741D M726 HM707 E720 D11 BC702 BCNOT EMSNOT DFRS ECC24 HIRT\n" +
        "Sent by MCCAD MCCAD to BCNOT, T706, D11, HIRT, A711, EMSNOT, E711, RS741, HM707, pe706, FS11, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1106",
        "CALL:CHEM / HAZMAT",
        "ADDR:5400 WESTBARD AVE",
        "PLACE:GIANT FOOD",
        "UNIT:E711 PE706 E710 T706 RS741 A711 M741D M726 HM707 E720 BC702");

    doTest("T19",
        "[Important message from MCEN] CAD MSG: * D * 2606 * STATUS SEIZURES- ALS1 * 11025 ROSEMONT DR ,MCG  * E726 M723 ECC25\n" +
        "Sent by MCCAD MCCAD to E726, FS26, M723, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2606",
        "CALL:STATUS SEIZURES- ALS1",
        "ADDR:11025 ROSEMONT DR",
        "UNIT:E726 M723");

    doTest("T20",
        "[Important message from MCEN] CAD MSG: * D * 2606 * STATUS SEIZURES- ALS1 * TILDEN MS @ 11211 OLD GEORGETOWN RD ,MCG  * E726\n" +
        "Sent by MCCAD MCCAD to E726, FS26, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2606",
        "CALL:STATUS SEIZURES- ALS1",
        "ADDR:11211 OLD GEORGETOWN RD",
        "PLACE:TILDEN MS",
        "UNIT:E726");

    doTest("T21",
        "[Important message from MCEN] CAD MSG: * D * 0406 * PIC - UNK STATUS * 17200 NORWOOD RD / 17200 DR BIRD RD ,MCG  * DFRS EMSNOT\n" +
        "Sent by MCCAD MCCAD to DFRS, FS04, EMSNOT, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:0406",
        "CALL:PIC - UNK STATUS",
        "ADDR:17200 NORWOOD RD & 17200 DR BIRD RD",
        "MADDR:17200 NORWOOD RD");

    doTest("T22",
        "[Important message from MCEN] CAD MSG: * D * DC00 * TRANSFER * 5760 GEORGIA AVE NW ,DC  * ECC1 DFRS E702\n" +
        "Sent by MCCAD MCCAD to E702, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:DC00",
        "CALL:TRANSFER",
        "ADDR:5760 GEORGIA AVE NW",
        "CITY:DC",
        "UNIT:E702");

    doTest("T23",
        "[Important message from MCEN] CAD MSG: * D * DC00 * TRANSFER * 4300 WISCONSIN AVE NW ,DC  * ECC10 E711 DFRS\n" +
        "Sent by MCCAD MCCAD to DFRS, E711, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:DC00",
        "CALL:TRANSFER",
        "ADDR:4300 WISCONSIN AVE NW",
        "CITY:WASHINGTON",
        "STATE:DC",
        "UNIT:E711");

    doTest("T24",
        "[Important message from MCEN] CAD MSG: * D * 2610 * AFA * 10400 SEVEN LOCKS RD ,MCG (HEIGHTS SCHOOL) * E726 AT751 CEALRM ECC30\n" +
        "Sent by MCCAD MCCAD to E726, AT751, CEALRM, FS26, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2610",
        "CALL:AFA",
        "ADDR:10400 SEVEN LOCKS RD",
        "PLACE:HEIGHTS SCHOOL",
        "UNIT:E726 AT751");

    doTest("T25",
        "[Important message from MCEN] CAD MSG: * D * 2302 * PEDESTRIAN STRUCK- ALS2 * 5300 RANDOLPH RD / 12100 LAUDERDALE DR ,MCG  * PE723 DFRS A705 M726 ECC10\n" +
        "Sent by MCCAD MCCAD to A705, FS23, PE723, DFRS, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:2302",
        "CALL:PEDESTRIAN STRUCK- ALS2",
        "ADDR:5300 RANDOLPH RD & 12100 LAUDERDALE DR",
        "MADDR:5300 RANDOLPH RD",
        "UNIT:PE723 A705 M726");

    doTest("T26",
        "[Important message from MCEN] CAD MSG: * D * 1031 * LRG VEHICLE FIRE * IL495B MACARTHUR BLVD-RIVER RD @ 39500 IL495 X41 TO X39 HWY ,MCG  * E752 E401 A710 BC702 D10 DFRS E726 A741B ECC25 AT401\n" +
        "Sent by MCCAD MCCAD to DFRS, D10, FS10, A741B, A710, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1031",
        "CALL:LRG VEHICLE FIRE",
        "ADDR:39500 IL495 X41 TO X39 HWY",
        "PLACE:IL495B MACARTHUR BLVD-RIVER RD",
        "UNIT:E752 E401 A710 BC702 E726 A741B AT401");

    doTest("T27",
        "[Important message from MCEN] CAD MSG: * D * 0610 * METRO OTHER EVENT * METRO BETHESDA STA @ 7450 WISCONSIN AVE ,MCG  * PE706 PE707 T706 AT751 A741B D6 BC702 RAIL DFRS\n" +
        "Sent by MCCAD MCCAD to AT751, T706, A741B, D6, FS06, DFRS, pe706, pe707, RAIL, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:0610",
        "CALL:METRO OTHER EVENT",
        "ADDR:7450 WISCONSIN AVE",
        "PLACE:METRO BETHESDA STA",
        "UNIT:PE706 PE707 T706 AT751 A741B BC702");

    doTest("T28",
        "[Important message from MCEN] CAD MSG: * D * 1620 * PEDESTRIAN STRUCK- ALS2 * 9302 PINEY BRANCH RD ,MCG (FOREST PARK APTS) * T716 M712 DFRS A702 ECC30 PE712\n" +
        "Sent by MCCAD MCCAD to T716, DFRS, M712, FS16, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1620",
        "CALL:PEDESTRIAN STRUCK- ALS2",
        "ADDR:9302 PINEY BRANCH RD",
        "PLACE:FOREST PARK APTS",
        "UNIT:T716 M712 A702 PE712");

    doTest("T29",
        "[Important message from MCEN] CAD MSG: * D * PG00 * MA FULL * 1807 FOX ST ,PG  * ECC DFRS BCNOT PE712 T716\n" +
        "Sent by MCCAD MCCAD to BCNOT, T716, DFRS, pe712, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:PG00",
        "CALL:MA FULL",
        "ADDR:1807 FOX ST",
        "CITY:PRINCE GEORGES COUNTY",
        "UNIT:PE712 T716");

    doTest("T30",
        "[Important message from MCEN] CAD MSG: * D * PG00 * MA FULL * 1807 FOX ST ,PG  * DFRS M712\n" +
        "Sent by MCCAD MCCAD to DFRS, M712, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:PG00",
        "CALL:MA FULL",
        "ADDR:1807 FOX ST",
        "CITY:PRINCE GEORGES COUNTY",
        "UNIT:M712");

    doTest("T31",
        "[Important message from MCEN] CAD MSG: * D * 1614 * BOX ALARM * WARWICK TOWERS @ 1131 UNIVERSITY BLV W ,MCG  * PE716 PE718 E705B PE719 PE701 T716 AT718 AT719 RS742B A742D BC701 BC704 RD2 D1 DFRS INV CODE BCNOT\n" +
        "Sent by MCCAD MCCAD to pe701, D1, INV, BCNOT, PE719, T716, PE718, RD2, AT718, PE716, DFRS, FS16, MCCAD MCCAD (E-mail accounts, Pagers, Cell phones) through the Montgomery County Emergency Network \n" +
        "...Powered by the Roam Secure Alert Network\n" +
        "----\n" +
        "- Update your MCEN account at https://mcen.montgomerycountymd.gov\n",

        "BOX:1614",
        "CALL:BOX ALARM",
        "ADDR:1131 UNIVERSITY BLV W",
        "MADDR:1131 UNIVERSITY BLVD W",
        "PLACE:WARWICK TOWERS",
        "UNIT:PE716 PE718 E705B PE719 PE701 T716 AT718 AT719 RS742B A742D BC701 BC704");

  }
  
  public static void main(String[] args) {
    new MDMontgomeryCountyParserTest().generateTests("T1");
  }
  
}
