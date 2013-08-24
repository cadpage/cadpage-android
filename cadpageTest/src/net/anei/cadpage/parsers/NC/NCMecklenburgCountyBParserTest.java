package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Mecklenburg County, NC (alternate)
Contact: Jeremy Shimberg <jshimberg@carolina.rr.com>,7042398801@vtext.com
Sender: @minthillvfd.com

6817 Wilson Grove Rd Charlie 10- Chest Pain Kuck Rd/Central Dr Mh112 Map - 353353/B9 06202011-392  [72]
7119 Lancashire Dr Charlie 23- Overdose/Ingestion/Poison Ravenglass Ln/Cairnsmore Pl Mh212 Map - 353353/C9 06202011-374
13538 Idlefield Ln Charlie 30- Traumatic injuries,specifcIdle Dr/Mills End Cr Mh212 Map - 381381/D8 06202011-335  [67]
7500 Bondhaven Dr Charlie 42- Fire/Police support Kew Tr/Lanterntree Ln Mh212 Map - 353353/C6 06212011-239  [96]
10545 Blair Rd Mint Hill Urgent Care Charlie 23- Overdose/Ingestion/Poison Truelight Church Rd/Connell Rd MHL8 Map - 35
6700 Burkandt Rd 75M SYNCOPAL EPISODE WITH HX OAlpha 31- Unconsciousness/Fainting Wilson Woods Dr/Fieldwood Rd MHL8 Map

Contact: John Stroup <j.stroup@northmeckrescue.org>
Sender: paging@rcscom.com
Subject:Incoming Message\n15503 N Old Statesville Rd North Meck Rescue Charlie 12- Convulsion/Seizure 60 Foot St/Unnamed St Nmr1 Map - 266266/

Contact:  Soundwood <soundwood@msn.com>
Contact: bill elwood <elwoodaudio@gmail.com>
From: 334@c-msg.net
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10210 Couloak Dr SUIT E Charlie 28- Stroke/CVA Mt Holly-Huntersvill Rd/Dunn Commons Pk COOR4 Map - 292292/J9 12302011-096
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 6700 Pleasant Oaks Cr Charlie 28- Stroke/CVA Songbird Ln/Catalina Ln COOR3 Map - 321321/E1 12282011-371
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10611 Mount Holly Rd ifo residence Charlie 29- Traffic accident Chattaroy Dr/Latta Av COOF3 Map - 320320/D3 12272011-012
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 4322 Oakdale Rd 81yom/dehydration/silent approBravo-BLS COLD 26BC-Sick person Simpson Rd/E I-485\n(Con't) 2 of 2\nINNER HY COOR3 Map - 293293/E8 12312011-085(End)
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 2709 Kelly Rd Delta 17- Falls/Back injury(traumtc)Pleasant Grove Rd/Weston Woods Ln COOR2 Map - 293293/D1012302011-271
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10210 Couloak Dr SUIT E Charlie 28- Stroke/CVA Mt Holly-Huntersvill Rd/Dunn Commons Pk COOR4 Map - 292292/J9 12302011-096
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 6700 Pleasant Oaks Cr Charlie 28- Stroke/CVA Songbird Ln/Catalina Ln COOR3 Map - 321321/E1 12282011-371
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10611 Mount Holly Rd ifo residence Charlie 29- Traffic accident Chattaroy Dr/Latta Av COOF3 Map - 320320/D3 12272011-012
FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 2721 Nance Cove Rd Charlie 13- Diabetic problems Millwood Cr/Tall Meadow Rd COOR1 Map - 292292/H6 01052012-163
1 of 2\nFRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10607 Bur Oak Dr Fire - Emergency 52C-Alarm-Carbon Monoxide Falling Stream Dr/Double Cedar Dr\n(Con't) 2 of 2\nCOOF3 Map - 292292/E9 01062012-101(End)

Sender: alerts@cadpage.org
[!] 3310 Dunn Commons Py 201 RIVERMERE APTS Fire - Emergency 52F-Alarm-FIRE Shady Creek Rd/Dunn Commons Pk COOF3 Map - 292292/H9 02102012-333

Contact: Ronald Shumaker <smokediverbull@yahoo.com>
CodeMessaging account:334
[!] 10210 Couloak Dr CMC MTN ISLAND URGENT CARE Charlie 17- Falls/Back injury(traumtc)Mt Holly-Huntersvill Rd/Dunn Commons Pk COOR2 Map - 292292/J9 02202012-329

Contact: Active911
Agency name: Long Creek Fire
Location: Charlotte, NC, United States

911 Grassy Patch Ln STAGE pd en route/domestic Charlie 04- Assault Long Grass Ct/Grass Run Ct LONR3 Map - 321321/J4 10092012-302\r\n
3238 Ringtail Ln Charlie 26- Sick person Dead End/Swan Dr LONR4 Map - 293293/E9 10092012-290\r\n

639 Lightspun Ln cmpd23// m od unk substance Charlie 23- Overdose/Ingestion/Poison Big River Rd/Stonehenge Ln LONR4 Map - 322322/A4 10082012-048\r\n
9820 Callabridge Ct Walmart - Mountain Isle/ Fire - Emergency 52F-Alarm-FIRE Mt Holly-Huntersvill Rd/Mountain Island Plantation Dr LONF1 Map - 292292/J8 10072012-185\r\n
6300-blk Harris Technology Bv Fire - Routine 53-Citizen Assist/Service CallNorthwoods Business Py/Dead End LONF3 Map - 294294/G7 10072012-169\r\n

*/

public class NCMecklenburgCountyBParserTest extends BaseParserTest {
  
  public NCMecklenburgCountyBParserTest() {
    setParser(new NCMecklenburgCountyBParser(), "MECKLENBURG COUNTY", "NC");
  }
  
  @Test
  public void testParser0() {
    doBadTest("12463 Stratfield Place Cr               CAROLINA CROSSING SUBD        Delta                         31- Unconsciousness/Fainting  Stineway Ct/Sam Meeks Rd                                    PINR3     Map - 405405/J9 07302011-086");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "6817 Wilson Grove Rd Charlie 10- Chest Pain Kuck Rd/Central Dr Mh112 Map - 353353/B9 06202011-392  [72]",
        "ADDR:6817 Wilson Grove Rd",
        "PRI:C",
        "CODE:10",
        "CALL:Chest Pain",
        "X:Kuck Rd / Central Dr",
        "UNIT:Mh112",
        "MAP:353353/B9",
        "ID:06202011-392");

    doTest("T2",
        "7119 Lancashire Dr Charlie 23- Overdose/Ingestion/Poison Ravenglass Ln/Cairnsmore Pl Mh212 Map - 353353/C9 06202011-374",
        "ADDR:7119 Lancashire Dr",
        "PRI:C",
        "CODE:23",
        "CALL:Overdose/Ingestion/Poison",
        "X:Ravenglass Ln / Cairnsmore Pl",
        "UNIT:Mh212",
        "MAP:353353/C9",
        "ID:06202011-374");

    doTest("T3",
        "13538 Idlefield Ln Charlie 30- Traumatic injuries,specifcIdle Dr/Mills End Cr Mh212 Map - 381381/D8 06202011-335  [67]",
        "ADDR:13538 Idlefield Ln",
        "PRI:C",
        "CODE:30",
        "CALL:Traumatic injuries,",
        "X:specifcIdle Dr / Mills End Cr",
        "UNIT:Mh212",
        "MAP:381381/D8",
        "ID:06202011-335");

    doTest("T4",
        "7500 Bondhaven Dr Charlie 42- Fire/Police support Kew Tr/Lanterntree Ln Mh212 Map - 353353/C6 06212011-239  [96]",
        "ADDR:7500 Bondhaven Dr",
        "PRI:C",
        "CODE:42",
        "CALL:Fire/Police support",
        "X:Kew Tr / Lanterntree Ln",
        "UNIT:Mh212",
        "MAP:353353/C6",
        "ID:06212011-239");

    doTest("T5",
        "10545 Blair Rd Mint Hill Urgent Care Charlie 23- Overdose/Ingestion/Poison Truelight Church Rd/Connell Rd MHL8 Map - 35",
        "ADDR:10545 Blair Rd",
        "INFO:Mint Hill Urgent Care",
        "PRI:C",
        "CODE:23",
        "CALL:Overdose/Ingestion/Poison Truelight",
        "X:Church Rd / Connell Rd",
        "UNIT:MHL8",
        "MAP:35");

    doTest("T6",
        "6700 Burkandt Rd 75M SYNCOPAL EPISODE WITH HX OAlpha 31- Unconsciousness/Fainting Wilson Woods Dr/Fieldwood Rd MHL8 Map",
        "ADDR:6700 Burkandt Rd",
        "PRI:O",
        "APT:75M",
        "INFO:SYNCOPAL EPISODE WITH HX",
        "CODE:31",
        "CALL:Unconsciousness/Fainting Wilson",
        "X:Woods Dr / Fieldwood Rd",
        "UNIT:MHL8 Map");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Subject:Incoming Message\n15503 N Old Statesville Rd North Meck Rescue Charlie 12- Convulsion/Seizure 60 Foot St/Unnamed St Nmr1 Map - 266266/",
        "ADDR:15503 N Old Statesville Rd",
        "INFO:North Meck Rescue",
        "PRI:C",
        "CODE:12",
        "CALL:Convulsion/Seizure",
        "X:60 Foot St / Unnamed St",
        "UNIT:Nmr1",
        "MAP:266266/");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10210 Couloak Dr SUIT E Charlie 28- Stroke/CVA Mt Holly-Huntersvill Rd/Dunn Commons Pk COOR4 Map - 292292/J9 12302011-096",
        "ADDR:10210 Couloak Dr",
        "INFO:SUIT E",
        "PRI:C",
        "CODE:28",
        "CALL:Stroke/CVA",
        "X:Mt Holly-Huntersvill Rd / Dunn Commons Pk",
        "UNIT:COOR4",
        "MAP:292292/J9",
        "ID:12302011-096");

    doTest("T2",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 6700 Pleasant Oaks Cr Charlie 28- Stroke/CVA Songbird Ln/Catalina Ln COOR3 Map - 321321/E1 12282011-371",
        "ADDR:6700 Pleasant Oaks Cr",
        "MADDR:6700 Pleasant Oaks Cir",
        "PRI:C",
        "CODE:28",
        "CALL:Stroke/CVA",
        "X:Songbird Ln / Catalina Ln",
        "UNIT:COOR3",
        "MAP:321321/E1",
        "ID:12282011-371");

    doTest("T3",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10611 Mount Holly Rd ifo residence Charlie 29- Traffic accident Chattaroy Dr/Latta Av COOF3 Map - 320320/D3 12272011-012",
        "ADDR:10611 Mount Holly Rd",
        "INFO:ifo residence",
        "PRI:C",
        "CODE:29",
        "CALL:Traffic accident",
        "X:Chattaroy Dr / Latta Av",
        "UNIT:COOF3",
        "MAP:320320/D3",
        "ID:12272011-012");

    doTest("T4",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 4322 Oakdale Rd 81yom/dehydration/silent approBravo-BLS COLD 26BC-Sick person Simpson Rd/E I-485\n(Con't) 2 of 2\nINNER HY COOR3 Map - 293293/E8 12312011-085(End)",
        "ADDR:4322 Oakdale Rd",
        "INFO:81yom/dehydration/silent approBravo-BLS",
        "PRI:C",
        "CODE:26BC",
        "CALL:Sick person",
        "X:Simpson Rd / E I-485 INNER HY",
        "UNIT:COOR3",
        "MAP:293293/E8",
        "ID:12312011-085");

    doTest("T5",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 2709 Kelly Rd Delta 17- Falls/Back injury(traumtc)Pleasant Grove Rd/Weston Woods Ln COOR2 Map - 293293/D1012302011-271",
        "ADDR:2709 Kelly Rd",
        "PRI:D",
        "CODE:17",
        "CALL:Falls/Back injury(traumtc)Pleasant",
        "X:Grove Rd / Weston Woods Ln",
        "UNIT:COOR2",
        "MAP:293293/D1012302011-271");

    doTest("T6",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10210 Couloak Dr SUIT E Charlie 28- Stroke/CVA Mt Holly-Huntersvill Rd/Dunn Commons Pk COOR4 Map - 292292/J9 12302011-096",
        "ADDR:10210 Couloak Dr",
        "INFO:SUIT E",
        "PRI:C",
        "CODE:28",
        "CALL:Stroke/CVA",
        "X:Mt Holly-Huntersvill Rd / Dunn Commons Pk",
        "UNIT:COOR4",
        "MAP:292292/J9",
        "ID:12302011-096");

    doTest("T7",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 6700 Pleasant Oaks Cr Charlie 28- Stroke/CVA Songbird Ln/Catalina Ln COOR3 Map - 321321/E1 12282011-371",
        "ADDR:6700 Pleasant Oaks Cr",
        "MADDR:6700 Pleasant Oaks Cir",
        "PRI:C",
        "CODE:28",
        "CALL:Stroke/CVA",
        "X:Songbird Ln / Catalina Ln",
        "UNIT:COOR3",
        "MAP:321321/E1",
        "ID:12282011-371");

    doTest("T8",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10611 Mount Holly Rd ifo residence Charlie 29- Traffic accident Chattaroy Dr/Latta Av COOF3 Map - 320320/D3 12272011-012",
        "ADDR:10611 Mount Holly Rd",
        "INFO:ifo residence",
        "PRI:C",
        "CODE:29",
        "CALL:Traffic accident",
        "X:Chattaroy Dr / Latta Av",
        "UNIT:COOF3",
        "MAP:320320/D3",
        "ID:12272011-012");

    doTest("T9",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 2721 Nance Cove Rd Charlie 13- Diabetic problems Millwood Cr/Tall Meadow Rd COOR1 Map - 292292/H6 01052012-163",
        "ADDR:2721 Nance Cove Rd",
        "PRI:C",
        "CODE:13",
        "CALL:Diabetic problems",
        "X:Millwood Cr / Tall Meadow Rd",
        "UNIT:COOR1",
        "MAP:292292/H6",
        "ID:01052012-163");

    doTest("T10",
        "1 of 2\nFRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10607 Bur Oak Dr Fire - Emergency 52C-Alarm-Carbon Monoxide Falling Stream Dr/Double Cedar Dr\n(Con't) 2 of 2\nCOOF3 Map - 292292/E9 01062012-101(End)",
        "ADDR:10607 Bur Oak Dr",
        "INFO:Fire",
        "PRI:E",
        "CODE:52C",
        "CALL:Alarm-Carbon Monoxide Falling",
        "X:Stream Dr / Double Cedar Dr",
        "UNIT:COOF3",
        "MAP:292292/E9",
        "ID:01062012-101");

    doTest("T11",
        "[!] 3310 Dunn Commons Py 201 RIVERMERE APTS Fire - Emergency 52F-Alarm-FIRE Shady Creek Rd/Dunn Commons Pk COOF3 Map - 292292/H9 02102012-333",
        "ADDR:3310 Dunn Commons Py",
        "MADDR:3310 Dunn Commons Pkwy",
        "APT:201",
        "INFO:RIVERMERE APTS Fire",
        "PRI:E",
        "CODE:52F",
        "CALL:Alarm-FIRE",
        "X:Shady Creek Rd / Dunn Commons Pk",
        "UNIT:COOF3",
        "MAP:292292/H9",
        "ID:02102012-333");

    doTest("T12",
        "[!] 10210 Couloak Dr CMC MTN ISLAND URGENT CARE Charlie 17- Falls/Back injury(traumtc)Mt Holly-Huntersvill Rd/Dunn Commons Pk COOR2 Map - 292292/J9 02202012-329",
        "ADDR:10210 Couloak Dr",
        "INFO:CMC MTN ISLAND URGENT CARE",
        "PRI:C",
        "CODE:17",
        "CALL:Falls/Back injury(traumtc)Mt",
        "X:Holly-Huntersvill Rd / Dunn Commons Pk",
        "UNIT:COOR2",
        "MAP:292292/J9",
        "ID:02202012-329");
  }
  
  @Test
  public void testLongCreekFire() {

    doTest("T1",
        "911 Grassy Patch Ln STAGE pd en route/domestic Charlie 04- Assault Long Grass Ct/Grass Run Ct LONR3 Map - 321321/J4 10092012-302\r\n",
        "ADDR:911 Grassy Patch Ln",
        "INFO:STAGE pd en route/domestic",
        "PRI:C",
        "CODE:04",
        "CALL:Assault Long",
        "X:Grass Ct / Grass Run Ct",
        "UNIT:LONR3",
        "MAP:321321/J4",
        "ID:10092012-302");

    doTest("T2",
        "3238 Ringtail Ln Charlie 26- Sick person Dead End/Swan Dr LONR4 Map - 293293/E9 10092012-290\r\n",
        "ADDR:3238 Ringtail Ln",
        "PRI:C",
        "CODE:26",
        "CALL:Sick person",
        "X:Dead End / Swan Dr",
        "UNIT:LONR4",
        "MAP:293293/E9",
        "ID:10092012-290");

    doTest("T3",
        "639 Lightspun Ln cmpd23// m od unk substance Charlie 23- Overdose/Ingestion/Poison Big River Rd/Stonehenge Ln LONR4 Map - 322322/A4 10082012-048\r\n",
        "ADDR:639 Lightspun Ln",
        "INFO:cmpd23// m od unk substance",
        "PRI:C",
        "CODE:23",
        "CALL:Overdose/Ingestion/Poison Big",
        "X:River Rd / Stonehenge Ln",
        "UNIT:LONR4",
        "MAP:322322/A4",
        "ID:10082012-048");

    doTest("T4",
        "9820 Callabridge Ct Walmart - Mountain Isle/ Fire - Emergency 52F-Alarm-FIRE Mt Holly-Huntersvill Rd/Mountain Island Plantation Dr LONF1 Map - 292292/J8 10072012-185\r\n",
        "ADDR:9820 Callabridge Ct",
        "INFO:Walmart - Mountain Isle/ Fire",
        "PRI:E",
        "CODE:52F",
        "CALL:Alarm-FIRE",
        "X:Mt Holly-Huntersvill Rd / Mountain Island Plantation Dr",
        "UNIT:LONF1",
        "MAP:292292/J8",
        "ID:10072012-185");

    doTest("T5",
        "6300-blk Harris Technology Bv Fire - Routine 53-Citizen Assist/Service CallNorthwoods Business Py/Dead End LONF3 Map - 294294/G7 10072012-169\r\n",
        "ADDR:6300-blk Harris Technology Bv Fire -",
        "MADDR:6300 Harris Technology Bv Fire -",
        "PRI:R",
        "CODE:53",
        "CALL:Citizen Assist/Service CallNorthwoods",
        "X:Business Py / Dead End",
        "UNIT:LONF3",
        "MAP:294294/G7",
        "ID:10072012-169");

  }
  

  public static void main(String[] args) {
    new NCMecklenburgCountyBParserTest().generateTests("T1");
  }
}
