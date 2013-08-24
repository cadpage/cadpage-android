package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Olmsted County, MN
Contact: Joe Manning <jlmanning@gmail.com>
Sender: @rochestermn.gov

(Main St N 20 ST NW) Two vehicle Accident with injuries, neck and head pain\r\n\r\nJeff Wellik\r\nPublic Safety Communications\r\nRochester Police/Olmsted County Sh
(4639 grove st se) Elderly male stroke symptoms, blurred vision weak legs
(200 lakeshore dr nw) Med
(200 lakeshore dr nw  florence park) medical
(500 6 st ne) Medical
(6220 70 ST SW) Male with chest pains  6220 70 ST SW
(medical 1106 Sunrise Ct SE  baby with siezure)
(101 schumann dr nw) GRASS FIRE ON W SIDE OF KWIK TRIP
(medical) Medical at 106 4 st NE apt 311
(medical) 205 1 st e for a medical
(106 5 ave se medical) Fall victim elderly female
(2538 75 st se  medical  male thrown from horse)
(med 317 23 st nw) Med 317 23 st nw head inj from a fall

Contact: michaletz.derek@charter.net <michaletz.derek@charter.net>
Sender: pdcomm@rochestermn.gov

(OLMSTED COUNTY (ROCHESTER)(MN)) Byron First Responders needed for a medical 126 8 st NE Byron for a female difficulty breathing
(OLMSTED COUNTY (ROCHESTER)(MN)) med 863 high point dr ne, byron market place
(OLMSTED COUNTY (ROCHESTER)(MN)) fve  16 2 ave nw  kwik trip byron  frontage rd
(OLMSTED COUNTY (ROCHESTER)(MN)) medical  9346 35 st  sw poss feible seizure
(OLMSTED COUNTY (ROCHESTER)(MN)) accident unk inj on hwy 14 west in front of mcdonalds
(OLMSTED COUNTY (ROCHESTER)(MN)) need help with entrapment, no injury accident 10 ave ne / 7 st ne

Contact: Active911
Agency name: Eyota Ambulance
Location: Eyota, MN, United States
Sender: pdcomm@rochestermn.gov

(OLMSTED COUNTY (ROCHESTER)(MN)) 16884 I90 - w/b lane - rollover accident - unknown injuries - just west of the Dover Exit
(OLMSTED COUNTY (ROCHESTER)(MN)) Injury Accident I90 near MM 220, w/b lane - 
(OLMSTED COUNTY (ROCHESTER)(MN)) medical arbor gardens eyota non emergent
(OLMSTED COUNTY (ROCHESTER)(MN)) Injury aci north of county 9 on hwy 42 , 2 pinned in truck 
(OLMSTED COUNTY (ROCHESTER)(MN)) 8378 hwy 14 / chester woods park guy on the ice with medical
(OLMSTED COUNTY (ROCHESTER)(MN)) Eyota Ambulance: Medical Arbor Gardens 535 Canyon Dr NW ROom 108, Diff Breathing 
(OLMSTED COUNTY (ROCHESTER)(MN)) Medical \n121 Sandstone Dr NW\nFemale is Sick
(OLMSTED COUNTY (ROCHESTER)(MN)) MED - 14 5 ST SW EYOTA
(OLMSTED COUNTY (ROCHESTER)(MN)) FSR  43 park dr nw

*/

public class MNOlmstedCountyParserTest extends BaseParserTest {
  
  public MNOlmstedCountyParserTest() {
    setParser(new MNOlmstedCountyParser(), "OLMSTED COUNTY", "MN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Main St N 20 ST NW) Two vehicle Accident with injuries, neck and head pain\r\n" +
        "\r\n" +
        "Jeff Wellik\r\n" +
        "Public Safety Communications\r\n" +
        "Rochester Police/Olmsted County Sh",

        "ADDR:Main St N & 20 ST NW",
        "CALL:Two vehicle Accident with injuries, neck and head pain",
        "INFO:Jeff Wellik / Public Safety Communications / Rochester Police/Olmsted County Sh");

    doTest("T2",
        "(4639 grove st se) Elderly male stroke symptoms, blurred vision weak legs",
        "ADDR:4639 grove st se",
        "CALL:Elderly male stroke symptoms, blurred vision weak legs");

    doTest("T3",
        "(200 lakeshore dr nw) Med",
        "ADDR:200 lakeshore dr nw",
        "CALL:Med");

    doTest("T4",
        "(200 lakeshore dr nw  florence park) medical",
        "ADDR:200 lakeshore dr nw",
        "PLACE:florence park",
        "CALL:medical");

    doTest("T5",
        "(500 6 st ne) Medical",
        "ADDR:500 6 st ne",
        "CALL:Medical");

    doTest("T6",
        "(6220 70 ST SW) Male with chest pains  6220 70 ST SW",
        "ADDR:6220 70 ST SW",
        "CALL:Male with chest pains  6220 70 ST SW");

    doTest("T7",
        "(medical 1106 Sunrise Ct SE  baby with siezure)",
        "ADDR:1106 Sunrise Ct SE",
        "CALL:medical",
        "INFO:baby with siezure");

    doTest("T8",
        "(101 schumann dr nw) GRASS FIRE ON W SIDE OF KWIK TRIP",
        "ADDR:101 schumann dr nw",
        "CALL:GRASS FIRE ON W SIDE OF KWIK TRIP");

    doTest("T9",
        "(medical) Medical at 106 4 st NE apt 311",
        "ADDR:106 4 st NE",
        "APT:311",
        "CALL:Medical");

    doTest("T10",
        "(medical) 205 1 st e for a medical",
        "ADDR:205 1 st e",
        "CALL:medical",
        "INFO:for a medical");

    doTest("T11",
        "(106 5 ave se medical) Fall victim elderly female",
        "ADDR:106 5 ave se medical",
        "CALL:Fall victim elderly female");

    doTest("T12",
        "(2538 75 st se  medical  male thrown from horse)",
        "ADDR:2538 75 st se",
        "CALL:medical",
        "INFO:male thrown from horse");

    doTest("T13",
        "(med 317 23 st nw) Med 317 23 st nw head inj from a fall",
        "ADDR:317 23 st nw",
        "CALL:head inj from a fall");
        
  }
  
  @Test
  public void testMichaletzDerek() {

    doTest("T1",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) Byron First Responders needed for a medical 126 8 st NE Byron for a female difficulty breathing",
        "SRC:ROCHESTER",
        "CALL:Byron First Responders needed for a medical",
        "ADDR:126 8 st NE",
        "CITY:Byron",
        "INFO:for a female difficulty breathing");

    doTest("T2",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) med 863 high point dr ne, byron market place",
        "SRC:ROCHESTER",
        "CALL:med",
        "ADDR:863 high point dr ne",
        "CITY:byron",
        "INFO:market place");

    doTest("T3",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) fve  16 2 ave nw  kwik trip byron  frontage rd",
        "SRC:ROCHESTER",
        "CALL:fve",
        "ADDR:16 2 ave nw",
        "INFO:kwik trip byron  frontage rd");

    doTest("T4",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) medical  9346 35 st  sw poss feible seizure",
        "SRC:ROCHESTER",
        "CALL:medical",
        "ADDR:9346 35 st sw",
        "INFO:poss feible seizure");

    doTest("T5",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) accident unk inj on hwy 14 west in front of mcdonalds",
        "SRC:ROCHESTER",
        "CALL:accident unk inj on",
        "ADDR:hwy 14",
        "INFO:west in front of mcdonalds");

    doTest("T6",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) need help with entrapment, no injury accident 10 ave ne / 7 st ne",
        "SRC:ROCHESTER",
        "CALL:need help with entrapment, no injury accident",
        "ADDR:10 ave ne & 7 st ne");
  
  }
  
  @Test
  public void testEyotaAmbulance() {

    doTest("T1",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) 16884 I90 - w/b lane - rollover accident - unknown injuries - just west of the Dover Exit",
        "SRC:ROCHESTER",
        "CALL:Exit",
        "ADDR:16884 I90 - w & b lane - rollover accident - unknown injuries - just west of the",
        "MADDR:16884 I 90 - w",
        "CITY:Dover");

    doTest("T2",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) Injury Accident I90 near MM 220, w/b lane - ",
        "SRC:ROCHESTER",
        "CALL:Injury Accident",
        "ADDR:I-90",
        "MADDR:I 90",
        "INFO:near MM 220, w/b lane -");

    doTest("T3",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) medical arbor gardens eyota non emergent",
        "SRC:ROCHESTER",
        "CALL:medical arbor gardens eyota non emergent");

    doTest("T4",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) Injury aci north of county 9 on hwy 42 , 2 pinned in truck ",
        "SRC:ROCHESTER",
        "CALL:Injury aci north of",
        "ADDR:county 9",
        "MADDR:COUNTY ROAD 9",
        "INFO:on hwy 42 , 2 pinned in truck");

    doTest("T5",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) 8378 hwy 14 / chester woods park guy on the ice with medical",
        "SRC:ROCHESTER",
        "CALL:/ chester woods park guy on the ice with medical",
        "ADDR:8378 hwy 14");

    doTest("T6",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) Eyota Ambulance: Medical Arbor Gardens 535 Canyon Dr NW ROom 108, Diff Breathing ",
        "SRC:ROCHESTER",
        "CALL:Eyota Ambulance: Medical Arbor Gardens",
        "ADDR:535 Canyon Dr NW",
        "APT:108",
        "INFO:Diff Breathing");

    doTest("T7",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) Medical \n121 Sandstone Dr NW\nFemale is Sick",
        "SRC:ROCHESTER",
        "CALL:Medical",
        "ADDR:121 Sandstone Dr NW",
        "INFO:Female is Sick");

    doTest("T8",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) MED - 14 5 ST SW EYOTA",
        "SRC:ROCHESTER",
        "CALL:MED -",
        "ADDR:14 5 ST SW",
        "CITY:EYOTA");

    doTest("T9",
        "(OLMSTED COUNTY (ROCHESTER)(MN)) FSR  43 park dr nw",
        "SRC:ROCHESTER",
        "CALL:FSR",
        "ADDR:43 park dr nw");
   
  }
  
  public static void main(String[] args) {
    new MNOlmstedCountyParserTest().generateTests("T1");
  }
}
