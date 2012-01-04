package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCMecklenburgCountyBParserTest extends BaseParserTest {
  
  public NCMecklenburgCountyBParserTest() {
    setParser(new NCMecklenburgCountyBParser(), "MECKLENBURG COUNTY", "NC");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "6817 Wilson Grove Rd Charlie 10- Chest Pain Kuck Rd/Central Dr Mh112 Map - 353353/B9 06202011-392  [72]",
        "ADDR:6817 Wilson Grove Rd",
        "PRI:C",
        "CODE:10-",
        "CALL:Chest Pain",
        "X:Kuck Rd & Central Dr",
        "UNIT:Mh112",
        "MAP:353353/B9",
        "ID:06202011-392");

    doTest("T2",
        "7119 Lancashire Dr Charlie 23- Overdose/Ingestion/Poison Ravenglass Ln/Cairnsmore Pl Mh212 Map - 353353/C9 06202011-374",
        "ADDR:7119 Lancashire Dr",
        "PRI:C",
        "CODE:23-",
        "CALL:Overdose/Ingestion/Poison",
        "X:Ravenglass Ln & Cairnsmore Pl",
        "UNIT:Mh212",
        "MAP:353353/C9",
        "ID:06202011-374");

    doTest("T3",
        "13538 Idlefield Ln Charlie 30- Traumatic injuries,specifcIdle Dr/Mills End Cr Mh212 Map - 381381/D8 06202011-335  [67]",
        "ADDR:13538 Idlefield Ln",
        "PRI:C",
        "CODE:30-",
        "CALL:Traumatic injuries,specifcIdle Dr/Mills End Cr",
        "UNIT:Mh212",
        "MAP:381381/D8",
        "ID:06202011-335");

    doTest("T4",
        "7500 Bondhaven Dr Charlie 42- Fire/Police support Kew Tr/Lanterntree Ln Mh212 Map - 353353/C6 06212011-239  [96]",
        "ADDR:7500 Bondhaven Dr",
        "PRI:C",
        "CODE:42-",
        "CALL:Fire/Police support",
        "X:Kew Tr & Lanterntree Ln",
        "UNIT:Mh212",
        "MAP:353353/C6",
        "ID:06212011-239");

    doTest("T5",
        "10545 Blair Rd Mint Hill Urgent Care Charlie 23- Overdose/Ingestion/Poison Truelight Church Rd/Connell Rd MHL8 Map - 35",
        "ADDR:10545 Blair Rd",
        "INFO:Mint Hill Urgent Care",
        "PRI:C",
        "CODE:23-",
        "CALL:Overdose/Ingestion/Poison Truelight",
        "X:Church Rd & Connell Rd",
        "UNIT:MHL8",
        "MAP:35");

    doTest("T6",
        "6700 Burkandt Rd 75M SYNCOPAL EPISODE WITH HX OAlpha 31- Unconsciousness/Fainting Wilson Woods Dr/Fieldwood Rd MHL8 Map",
        "ADDR:6700 Burkandt Rd",
        "PRI:O",
        "APT:75M",
        "INFO:SYNCOPAL EPISODE WITH HX",
        "CODE:31-",
        "CALL:Unconsciousness/Fainting Wilson",
        "X:Woods Dr & Fieldwood Rd",
        "UNIT:MHL8 Map");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Subject:Incoming Message\n15503 N Old Statesville Rd North Meck Rescue Charlie 12- Convulsion/Seizure 60 Foot St/Unnamed St Nmr1 Map - 266266/",
        "ADDR:15503 N Old Statesville Rd",
        "INFO:North Meck Rescue",
        "PRI:C",
        "CODE:12-",
        "CALL:Convulsion/Seizure",
        "X:60 Foot St & Unnamed St",
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
        "CODE:28-",
        "CALL:Stroke/CVA Mt",
        "X:Holly-Huntersvill Rd & Dunn Commons Pk",
        "UNIT:COOR4",
        "MAP:292292/J9",
        "ID:12302011-096");

    doTest("T2",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 6700 Pleasant Oaks Cr Charlie 28- Stroke/CVA Songbird Ln/Catalina Ln COOR3 Map - 321321/E1 12282011-371",
        "ADDR:6700 Pleasant Oaks Cr",
        "MADDR:6700 Pleasant Oaks Cir",
        "PRI:C",
        "CODE:28-",
        "CALL:Stroke/CVA",
        "X:Songbird Ln & Catalina Ln",
        "UNIT:COOR3",
        "MAP:321321/E1",
        "ID:12282011-371");

    doTest("T3",
        "FRM:rc.334@c-msg.net\nSUBJ:cCAD\nMSG:[!] 10611 Mount Holly Rd ifo residence Charlie 29- Traffic accident Chattaroy Dr/Latta Av COOF3 Map - 320320/D3 12272011-012",
        "ADDR:10611 Mount Holly Rd",
        "INFO:ifo residence",
        "PRI:C",
        "CODE:29-",
        "CALL:Traffic accident",
        "X:Chattaroy Dr & Latta Av",
        "UNIT:COOF3",
        "MAP:320320/D3",
        "ID:12272011-012");
  }
  

  public static void main(String[] args) {
    new NCMecklenburgCountyBParserTest().generateTests("T1", "ADDR APT INFO PRI CODE CALL X UNIT MAP ID");
  }
}
