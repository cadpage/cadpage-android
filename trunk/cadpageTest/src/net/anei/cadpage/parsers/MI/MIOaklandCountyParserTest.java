package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MIOaklandCountyParserTest extends BaseParserTest {
  
  public MIOaklandCountyParserTest() {
	  setParser(new MIOaklandCountyParser(), "OAKLAND COUNTY", "MI");
  }
  
  @Test
  public void testActive911A1() {

    doTest("T1",
        "(South Lyon Medical) Respond to a medical at 106 s lafayette - seizure",
        "CALL:medical",
        "ADDR:106 s lafayette",
        "INFO:seizure");

    doTest("T2",
        "(South Lyon Medical) Respond to a medical at south lyon gardens  low heart rate ",
        "CALL:medical",
        "ADDR:south lyon gardens",
        "INFO:low heart rate");

    doTest("T3",
        "(South Lyon Fire Run) Respond to a fire alarm at 23000 valerie for gen fire alarm ",
        "CALL:fire alarm",
        "ADDR:23000 valerie",
        "INFO:gen fire alarm");

    doTest("T4",
        "(South Lyon Medical) Respond to a medical at 25376 potomac elderly male fell hit head is conscious ",
        "CALL:medical",
        "ADDR:25376 potomac",
        "INFO:elderly male fell hit head is conscious");

    doTest("T5",
        "(South Lyon Medical) Respond to a medical at 501 wellington 5 mth old having seizure ",
        "CALL:medical",
        "ADDR:501 wellington",
        "INFO:5 mth old having seizure");

    doTest("T6",
        "(South Lyon Medical) Respond to a medical at 25328 franklin terrace",
        "CALL:medical",
        "ADDR:25328 franklin terrace");

    doTest("T7",
        "(South Lyon Medical) Respond to a medical at 514 lanier chest pains",
        "CALL:medical",
        "ADDR:514 lanier",
        "INFO:chest pains");

    doTest("T8",
        "(South Lyon Medical) Respond to a medical at 380 Lennox St",
        "CALL:medical",
        "ADDR:380 Lennox St");

    doTest("T9",
        "(South Lyon Medical) Respond to a medical at 22195 quail run #16 apt 3",
        "CALL:medical",
        "ADDR:22195 quail run",
        "APT:16",
        "INFO:apt 3");

    doTest("T10",
        "(South Lyon Fire Run) Respond to a brush fire at Equestrian/Colt",
        "CALL:brush fire",
        "ADDR:Equestrian & Colt");

    doTest("T11",
        "(South Lyon Medical) Respond to a medical at St Joes Church 830 S Lafayette  for 82 yo fem in/out of conciousness",
        "CALL:medical",
        "PLACE:St Joes Church",
        "ADDR:830 S Lafayette",
        "INFO:82 yo fem in/out of conciousness");

    doTest("T12",
        "(South Lyon Fire Run) Respond to a medical at 836 Downy Nest",
        "CALL:medical",
        "ADDR:836 Downy Nest");

    doTest("T13",
        "(South Lyon Medical) Respond to a medical at 22195 quail run apt 3 drk red blood in cath bag patient on cumadin and diabetic",
        "CALL:medical",
        "ADDR:22195 quail run",
        "APT:3",
        "INFO:drk red blood in cath bag patient on cumadin and diabetic");

    doTest("T14",
        "(South Lyon Medical) Respond to a medical at lake st and mill injury accident",
        "CALL:medical",
        "ADDR:lake st and mill",
        "MADDR:lake st & mill",
        "INFO:injury accident");

    doTest("T15",
        "(South Lyon Medical) Respond to a medical at witches hat 350 dorothy for poss heart attack",
        "CALL:medical",
        "PLACE:witches hat",
        "ADDR:350 dorothy",
        "INFO:poss heart attack");

    doTest("T16",
        "(South Lyon Medical) Respond to a medical at 134 w liberty diabetic high blood sugar vomiting ",
        "CALL:medical",
        "ADDR:134 w liberty",
        "INFO:diabetic high blood sugar vomiting");

    doTest("T17",
        "(South Lyon Medical) Respond to a medical at 503 stryker male poss suicide by gun shot in chest ",
        "CALL:medical",
        "ADDR:503 stryker",
        "INFO:male poss suicide by gun shot in chest");

    doTest("T18",
        "(South Lyon Medical) Respond to a medical at 522 n reese set diff breathing",
        "CALL:medical",
        "ADDR:522 n reese",
        "INFO:set diff breathing");

    doTest("T19",
        "(South Lyon Medical) Respond to a medical at 535 w lake",
        "CALL:medical",
        "ADDR:535 w lake");

    doTest("T20",
        "(South Lyon Medical) Respond to a medical at 510 lanier  high blood sugar",
        "CALL:medical",
        "ADDR:510 lanier",
        "INFO:high blood sugar");

    doTest("T21",
        "(South Lyon Medical) Respond to a medical at 559 Old Pond St",
        "CALL:medical",
        "ADDR:559 Old Pond St");

    doTest("T22",
        "(South Lyon Medical) Respond to a medical at 1035 Arabian Ct",
        "CALL:medical",
        "ADDR:1035 Arabian Ct");

    doTest("T23",
        "(South Lyon Fire Run) Respond to a wires - behind 101 n lafayette SL Herald",
        "CALL:wires",
        "PLACE:behind",
        "ADDR:101 n lafayette",
        "INFO:SL Herald");

    doTest("T24",
        "(South Lyon Medical) Respond to a medical at 61746 valley forge - diff breathing",
        "CALL:medical",
        "ADDR:61746 valley forge",
        "INFO:diff breathing");

    doTest("T25",
        "(South Lyon Medical) Respond to a medical at 62067 ticonderoga dr apt 5",
        "CALL:medical",
        "ADDR:62067 ticonderoga dr",
        "APT:5");

    doTest("T26",
        "(South Lyon Medical) Respond to a medical at 414 Ada",
        "CALL:medical",
        "ADDR:414 Ada");

    doTest("T27",
        "(South Lyon Medical) Respond to a medical at 408 washington chest pains diff breathing ",
        "CALL:medical",
        "ADDR:408 washington",
        "INFO:chest pains diff breathing");

    doTest("T28",
        "(South Lyon Medical) Respond to a medical at 61702 williamsburg #2",
        "CALL:medical",
        "ADDR:61702 williamsburg",
        "APT:2");

    doTest("T29",
        "(South Lyon Medical) Respond to a medical at 682 forest",
        "CALL:medical",
        "ADDR:682 forest");

    doTest("T30",
        "(South Lyon Medical) Respond to a medical at 22185 quail run cir #1",
        "CALL:medical",
        "ADDR:22185 quail run cir",
        "APT:1");

    doTest("T31",
        "(South Lyon Medical) Respond to a medical at 559 old pond st",
        "CALL:medical",
        "ADDR:559 old pond st");

    doTest("T32",
        "(South Lyon Mutual Aid) Respond to a mutal aid request for Green Oak FD for station coverage at Station 83.",
        "CALL:mutal aid request for Green Oak FD for station coverage",
        "ADDR:Station 83");

    doTest("T33",
        "(South Lyon Mutual Aid) Respond to a mutal aid request for station coverage at sta 81 and 83 ",
        "CALL:mutal aid request for station coverage",
        "ADDR:sta 81 and 83",
        "MADDR:sta 81 & 83");

    doTest("T34",
        "(South Lyon Medical) Respond to a medical at 62292 yorktown unit 6 medical alarm head pain ",
        "CALL:medical",
        "ADDR:62292 yorktown",
        "INFO:unit 6 medical alarm head pain");

    doTest("T35",
        "(South Lyon Fire Run) Respond to a alarm at 1047 colt",
        "CALL:alarm",
        "ADDR:1047 colt");

    doTest("T36",
        "(South Lyon Mutual Aid) Respond to a mutal aid request for livingston co at station 81",
        "CALL:mutal aid request for livingston co",
        "ADDR:station 81");

    doTest("T37",
        "(South Lyon Medical) Respond to a medical at 25110 hamilton ct 78  pain abd",
        "CALL:medical",
        "ADDR:25110 hamilton ct 78",
        "INFO:pain abd");

    doTest("T38",
        "(South Lyon Fire Run) Respond to a grass fire at base of eletrical pole next to 356 cambridge",
        "CALL:grass fire",
        "PLACE:base of eletrical pole next to",
        "ADDR:356 cambridge");

  }
  
  @Test
  public void testActive911A2() {

    doTest("T1",
        "(South Lyon Fire Run) Respond to a 23000 valerie gen fire alarm zone 1",
        "CALL:gen fire alarm zone 1",
        "ADDR:23000 valerie");

    doTest("T2",
        "(South Lyon Fire Run) Respond to a 1131 polo house struck by lightening",
        "CALL:house struck by lightening",
        "ADDR:1131 polo");

  }
  
  @Test
  public void testActive911A3() {

    doTest("T1",
        "(medical) 686 lakewood unk odor inv and rp is feeling ill",
        "CALL:unk odor inv and rp is feeling ill",
        "ADDR:686 lakewood");

    doTest("T2",
        "(grass fire) 356 cambridge   grass fire",
        "CALL:grass fire",
        "ADDR:356 cambridge");

    doTest("T3",
        "(brush fire) 22350 brookfield  grass fire",
        "CALL:grass fire",
        "ADDR:22350 brookfield");

    doTest("T4",
        "(washdown) w lake and n hagadorn   washdown   at scene of pda",
        "CALL:washdown at scene of pda",
        "ADDR:w lake and n hagadorn",
        "MADDR:w lake & n hagadorn");

    doTest("T5",
        "(medical) 295 eagle way - choking on vomit",
        "CALL:- choking on vomit",
        "ADDR:295 eagle way");

  }
  
  public static void main(String[] args) {
    new MIOaklandCountyParserTest().generateTests("T1", "CALL PLACE ADDR APT INFO");
  }
}
