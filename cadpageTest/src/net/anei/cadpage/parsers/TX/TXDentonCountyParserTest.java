package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXDentonCountyParserTest extends BaseParserTest {
  
  public TXDentonCountyParserTest() {
    setParser(new TXDentonCountyParser(), "DENTON COUNTY", "TX");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "CAD:DOWN POWER LINES;WINDY MEADOW DR/CORINTH PKWY;CORI;CALLER ADV HIS DRIVER THAT HIT THE POLE CALLED HIM WITH THE INFORMATION // CALLER IS NOT ON SCENE // NO",
        "CALL:DOWN POWER LINES",
        "ADDR:WINDY MEADOW DR & CORINTH PKWY",
        "CITY:CORINTH",
        "INFO:CALLER ADV HIS DRIVER THAT HIT THE POLE CALLED HIM WITH THE INFORMATION // CALLER IS NOT ON SCENE // NO");

    doTest("T2",
        "CAD:FALLS;1620 VILLA CT;CORI;[Medical Priority Info] PROBLEM: FELL OUT OF BED # PATS: 1 AGE: 71 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes [08/08/11 14:34:3",
        "CALL:FALLS",
        "ADDR:1620 VILLA CT",
        "CITY:CORINTH",
        "INFO:FELL OUT OF BED # PATS: 1 AGE: 71 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes");

    doTest("T3",
        "CAD:CITIZEN ASSIST;212 S SHADY SHORES RD;LAKE;NEAR MAIN OFFICE;AT THE HUNDLEY SHORES APARTMENTS [08/08/11 09:54:29 JCADENHEAD] CALLER HAS TRIED EVERYTHING SHE",
        "CALL:CITIZEN ASSIST",
        "ADDR:212 S SHADY SHORES RD",
        "CITY:LAKE DALLAS",
        "INFO:NEAR MAIN OFFICE / AT THE HUNDLEY SHORES APARTMENTS / CALLER HAS TRIED EVERYTHING SHE");

    doTest("T4",
        "CAD:SICK PERSON;5650 I35E;CORI;ORR NISSAN;MAIN BLDG AT NEW CAR SHOW ROOM / PT IN BATHROOM [08/08/11 08:09:48 THIGGINS] [Medical Priority Info] RESPONSE: Alpha",
        "CALL:SICK PERSON",
        "ADDR:5650 I35E",
        "MADDR:5650 I35",
        "CITY:CORINTH",
        "INFO:ORR NISSAN / MAIN BLDG AT NEW CAR SHOW ROOM / PT IN BATHROOM");

    doTest("T5",
        "CAD:TRAFFIC TRANSPORT INCIDENT;461MM I35 E;CORI;N/B;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Unknown status/Other codes not applicable (Unknow",
        "CALL:TRAFFIC TRANSPORT INCIDENT",
        "ADDR:461MM I35 E",
        "MADDR:461MM I 35 E",
        "CITY:CORINTH",
        "INFO:N/B / Unknown status/Other codes not applicable (Unknow");

    doTest("T6",
        "CAD:TRAFFIC TRANSPORT INCIDENT;CORINTH PKWY/I35 E SERV;CORI;[LAW] {351} HEAD ON [08/04/11 09:29:27 JCOOK] FEMALE BLEEDING FROM FACE IN MITS GALANT [08/04/11 09",
        "CALL:TRAFFIC TRANSPORT INCIDENT",
        "ADDR:CORINTH PKWY & I35 E FRONTAGE",
        "CITY:CORINTH",
        "INFO:{351} HEAD ON / FEMALE BLEEDING FROM FACE IN MITS GALANT");

    doTest("T7",
        "CAD:TRAFFIC TRANSPORT INCIDENT;CORINTH PKWY/I35 E SERV;CORI;FEMALE WAS HIT HEAD ON BUT THAT WAS ALL SHE SAID BEFORE DISCONNECTING OTHER THAN THAT FACT THAT SHE",
        "CALL:TRAFFIC TRANSPORT INCIDENT",
        "ADDR:CORINTH PKWY & I35 E FRONTAGE",
        "CITY:CORINTH",
        "INFO:FEMALE WAS HIT HEAD ON BUT THAT WAS ALL SHE SAID BEFORE DISCONNECTING OTHER THAN THAT FACT THAT SHE");

    doTest("T8",
        "CAD:FIRE SMOKE INVESTIGATION;TURBEVILLE RD/I35 E SERV;HICK;[LAW] POSS IN HICKORY CREEK PARK [08/04/11 13:05:39 MKING] [LAW] {207} REQUESTING LCFD [08/04/11 13:",
        "CALL:FIRE SMOKE INVESTIGATION",
        "ADDR:TURBEVILLE RD & I35 E FRONTAGE",
        "CITY:HICKORY CREEK",
        "INFO:POSS IN HICKORY CREEK PARK / {207} REQUESTING LCFD");

    doTest("T9",
        "CAD:ALARM FLOW;1035 HICKORY CREEK BLVD;HICK;212 NOTIFIED [08/05/11 03:40:25 BPUTNAM] rec: 0337 / will call prem next / att kh [08/05/11 03:40:01 BPUTNAM] poe:",
        "CALL:ALARM FLOW",
        "ADDR:1035 HICKORY CREEK BLVD",
        "CITY:HICKORY CREEK",
        "INFO:212 NOTIFIED / rec: 0337 / will call prem next / att kh / poe:");

    doTest("T10",
        "CAD:SICK PERSON;1509 SHADOW CREST DR;CORI;[Medical Priority Info] PROBLEM: VOMITTING # PATS: 1 AGE: 72 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes [08/05/1",
        "CALL:SICK PERSON",
        "ADDR:1509 SHADOW CREST DR",
        "CITY:CORINTH",
        "INFO:VOMITTING # PATS: 1 AGE: 72 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes");

    doTest("T11",
        "CAD:SICK PERSON;1 LAKE LN;HICK;[Medical Priority Info] PROBLEM: GRANDFATHER HAS PROBLEMS # PATS: 1 AGE: 77 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes [08/05",
        "CALL:SICK PERSON",
        "ADDR:1 LAKE LN",
        "CITY:HICKORY CREEK",
        "INFO:GRANDFATHER HAS PROBLEMS # PATS: 1 AGE: 77 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes");

    doTest("T12",
        "CAD:TRAFFIC TRANSPORT INCIDENT;460MM I35 E;CORI;SB;[LAW] {211} GO AHEAD AND TONE MEDICS [08/05/11 18:24:06 AVINSON] got transfer from pd denton for an accident",
        "CALL:TRAFFIC TRANSPORT INCIDENT",
        "ADDR:460MM I35 E",
        "CITY:CORINTH",
        "INFO:SB / {211} GO AHEAD AND TONE MEDICS / got transfer from pd denton for an accident");

    doTest("T13",
        "CAD:WATER MAIN BREAK;I35 E SERV/MEADOWVIEW DR;CORI;S/B;WATER MAIN BREAK / NOT A LOT OF WATER / SMALL LINE / LEAKING ONTO THE EDGE OF THE ROADWAY OF MEADOWVIEW",
        "CALL:WATER MAIN BREAK",
        "ADDR:I35 E FRONTAGE & MEADOWVIEW DR",
        "CITY:CORINTH",
        "INFO:S/B / WATER MAIN BREAK / NOT A LOT OF WATER / SMALL LINE / LEAKING ONTO THE EDGE OF THE ROADWAY OF MEADOWVIEW");

    doTest("T14",
        "CAD:FALLS;201-L32 N SHADY SHORES RD;LAKE;CALLER IS GUY JEFFERSON [08/06/11 03:03:19 MHAMILTON] WIFE SLIPPED IN BATHTUB AND NEEDS ASSISTANCE TO GET HER OUT//SHE",
        "CALL:FALLS",
        "ADDR:201-L32 N SHADY SHORES RD",
        "CITY:LAKE DALLAS",
        "INFO:CALLER IS GUY JEFFERSON / WIFE SLIPPED IN BATHTUB AND NEEDS ASSISTANCE TO GET HER OUT//SHE");

    doTest("T15",
        "CAD:SICK PERSON;505 GRAYSON LN;LAKE;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Not alert. 1.She is not completely alert (not responding appropri",
        "CALL:SICK PERSON",
        "ADDR:505 GRAYSON LN",
        "CITY:LAKE DALLAS",
        "INFO:Not alert. 1.She is not completely alert (not responding appropri");

    doTest("T16",
        "CAD:TRAFFIC TRANSPORT INCIDENT;FM 2181/POST OAK DR;CORI;SB;{346} TONE OUT MEDICS FOR EVALUATION OF 13YO PT [08/06/11 13:31:42 JCADENHEAD] RD BLOCKAGE / JEEP IS",
        "CALL:TRAFFIC TRANSPORT INCIDENT",
        "ADDR:FM 2181 & POST OAK DR",
        "CITY:CORINTH",
        "INFO:SB / {346} TONE OUT MEDICS FOR EVALUATION OF 13YO PT / RD BLOCKAGE / JEEP IS");

    doTest("T17",
        "CAD:SICK PERSON;1200 MAIN ST;HICK;Event spawned from BOATER ASSIST. [08/06/2011 17:47:05 TCHAPMAN] LOST CONNECTION / CALLER ADV BATTERY WAS LOW [08/06/11 17:46",
        "CALL:SICK PERSON",
        "ADDR:1200 MAIN ST",
        "CITY:HICKORY CREEK",
        "INFO:Event spawned from BOATER ASSIST. / LOST CONNECTION / CALLER ADV BATTERY WAS LOW");

    doTest("T18",
        "CAD:WATER MAIN BREAK;FAIRVIEW DR/MEADOWVIEW DR;CORI;FIRST NOTICED 3-4 MINS AGO [08/06/11 18:03:38 TCHAPMAN] NO ONE AROUND THE HYDRANT [08/06/11 18:03:25 TCHAPM",
        "CALL:WATER MAIN BREAK",
        "ADDR:FAIRVIEW DR & MEADOWVIEW DR",
        "CITY:CORINTH",
        "INFO:FIRST NOTICED 3-4 MINS AGO / NO ONE AROUND THE HYDRANT");

    doTest("T19",
        "CAD:TRAFFIC TRANSPORT INCIDENT;MEADOWVIEW DR/FORESTWOOD DR;CORI;[LAW] UDTS: {314} RESPONDING CODE 2 OR 3 [08/06/11 18:07:04 CJMORRISON] [Medical Priority Info]",
        "CALL:TRAFFIC TRANSPORT INCIDENT",
        "ADDR:MEADOWVIEW DR & FORESTWOOD DR",
        "CITY:CORINTH",
        "INFO:UDTS: {314} RESPONDING CODE 2 OR 3");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "CAD:110137609;238 STRAIT LN;HILLTOP LN;HICKORY CREEK;LCFD;FIRE STRUCTURE",
        "ID:110137609",
        "CALL:FIRE STRUCTURE",
        "ADDR:238 STRAIT LN",
        "X:HILLTOP LN & HICKORY CREEK");

    doTest("T2",
        "CAD:110138525;08/05/2011 17:00:12;FIRE VEHICLE;ORR NISSAN;5650 I35 E;LCFD;brake on fire - sees flame [08/05/11 17:01:04 TPRICE]",
        "ID:110138525",
        "CALL:FIRE VEHICLE",
        "NAME:ORR NISSAN",
        "ADDR:5650 I35 E",
        "MADDR:5650 I 35 E",
        "INFO:brake on fire - sees flame");
 
  }
  
  public static void main(String[] args) {
    new TXDentonCountyParserTest().generateTests("T1");
  }
}
