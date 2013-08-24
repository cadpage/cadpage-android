package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Broome County, NY
Contact: Chuck Rogers <cmr49a@gmail.com> (Dispatch CAD Administrator)
Contact: David Abell <daemt25@gmail.com>
Sender: messaging@iamresponding.com <From%3Amessaging@iamresponding.com>
System: New World

(49 Sanitaria Spr Fire) 49-DIABETIC-C :2786 ROUTE 79 :78 yo fem high blood sugar/unable t   &lt;13C02&gt; :78 year old, Female, Conscious, Breathing.  A
25:DIABETIC-C :412 ADAMS AV APT 1S :67 yom diabetic / low sugar &lt;13C01&gt; :67 year old, Male, Conscious, Breathing. Not alert (Combative or Agg ressive). Cross Sts:TRACY ST/RIVERVIEW DR 01:29 02/07/2011 2011-00002425 Caller:BATTISTI,MAURICE,, Phone:607-239-4661 V/Endicott
25:OVERDOSE-B :431 E MAIN ST MANLEY'S 25-1 :FEM INTOX - CONSC/ALERT 22.09 TXFR 23-B-1 : Cross Sts:LODER AV/VESTAL AV 00:52 02/07/2011 2011-00002423 Caller:LASKOWSKY,OFC,, Phone: V/Endicott
25:FALLS -D :600 HIGH AV UHS SKILLED NURSING :87 YOF FALLEN/NOT ALERT 17-D-3 : ADULT CARE/DAVIS AV ENTRANCE ROOM 413 FLR 4 Cross Sts:W EDWARD ST/RIVER TERR 22:50 02/06/2011 2011-00002416 Caller:IDEAL SENIOR LIVING, Phone:607-786-7449 V/Endicott
25:ALARM-BLDG :9 HILLSIDE CT APT 4 :POSS FIRE ALARM GOING OFF / TENANTS LEFT :NO SMELL OF SMOKE OR FIRE SEEN COMPL IN APT 1 Cross Sts:W MAIN ST/DEAD END 18:03 02/06/2011 2011-00000251 Caller:RANDO,TIM,, Phone:607-727-1115 V/Endicot
25:ALARM-BLDG :722 W MAIN ST :GENERAL ALARM : ENJOY GOLF COURSE Cross Sts:ENDICOTT V-LINE/INDUSTRIAL PARK RD 14:40 02/06/2011 2011-00000249 Caller:SENTRY OP 79,,, Phone: V/Endicott
(25 Endicott Fire) 25-BREATHNG-C :308 ARTHUR AV APT 3 :40 yom diff breathing &lt;06C01&gt; :40 year old, Male, Conscious, Breathing. Abnormal breathing  (Asthma) . Cross StsE MAIN ST/TRACY ST 00:12 02/01/2011 2011-00002020 Caller:WILLIAMS,CINDY,, Phone:000-242-5076 V/Endicott
(25 Endicott Fire) 25:CHSTPAIN-C :415 E MAIN ST LOURDES PRIMARY 25 :41 yof chest pain &lt;10C04&gt; :41 year old, Female, Conscious, Breathing.  Breathing normally =&gt; 35. Cross Sts:LODER AV/VESTAL AV 17:39 02/01/2011 2011-00002058 Caller:CUTTING,SANDY,, Phone:607-786-180 V/Endicott
(25 Endicott Fire) 25:SEIZURES-D :326 JENNINGS ST :42 yof seizure                        &lt;12D02&gt; :42 year old, Female, Unconscious, Breathing.  CO
(59 Five Mile Pt Fire) 59:DIABETIC-C :913 ROUTE 11 APT 2D COUNTRYSIDE VILLAGE :34 YOF DIABETIC PROBLEM               &lt;13C01&gt; :34 year old, Female,

Contact: Kahl <kdmiller324@aol.com>
Sender: mplus@co.broome.ny.us
((26873) ) ) 32:ALARM-HOUS :416 E BENITA BLVD :SMOKE ALARM GOING OFF INTERMITTENLY IN :BASEMENT. NO SMOKE OR FIRE VISIBLE-POSS PROBLEM WITH DETECTOR Cross Sts

Contact: Neal Haight <dmbfn290@gmail.com>
Sender: mplus@co.broome.ny.us
Subject:(11470) ) \nCOMM:CHSTPAIN-C :27 GOLDEN LN HARPURSVILLE SENIOR :66yom chest pain                      <10C02> :66 year old, Male, C
Subject:(12610) ) \nCOMM:UNRSPNSV-D :528 JENSEN RD :81 YOM NOT ALERT/SEVERE HEADACHE/DELTA :CALLER IS VESTAL CREW CHIEF OR DRIVER/CAN DO E

Contact: "J.E. Dancesia" <john@ezems.com>
.... (46 Conklin Fire) 46:CHSTPAIN-D :12 WILLOW WAY :84 yom chest pain                     &lt;10D03&gt; :84 year old, Male, Conscious, Breathing.  CHANGING COLOR. Cross Sts:CONKLIN RD/DAVID RD 18:55 07/24/2011 2011-00013205 Caller:CEBULA,JAMES,, Phone:000-775-2793 T/Conklin
.... (46 Conklin Fire) 46:FALLS   -D :1186 CONKLIN RD :69 YOM FALLEN                         &lt;17D05&gt; :69 year old, Male, Conscious, Breathing.  LONG FALL. Cross Sts:POWERS RD/CAROL CT 13:54 07/23/2011 2011-00013114 Caller:KING,PAULINE,, Phone:000-206-2374 T/Conklin

Contact: "spazking4lif@aim.com" <spazking4lif@aim.com>
(79 Union Amb) 79:TRAUMA  -D :36 BAKER ST :8 yof hit by veh                      &lt;30D01&gt; :8 year old, Female, Unconscious, Breathing.  Unconscious
(79 Union Amb) 79:UNRSPNSV-C :420 HARRY L DR CHRISTMAS TREE SHOPS :36 yof fainted x1 rapid heart         &lt;31C01&gt; :BUSN: Cross Sts:N HUDSON ST/GIAN
(79 Union Amb) 79:DIABETIC-C :950 BOSWELL HILL RD :54 yof diabetic not alert             &lt;13C01&gt; :54 year old, Female, Conscious, Breathing.  Not

Contact: Jeffrey Mauro <jeffgm07@gmail.com>
(22 Deposit Fire/Amb) 22/75:SICKPERS-A :480 BIG HOLLOW RD :56YOM GEN ILLNESS/UNABLE TO WALK   ALPHA :ISSUES RELATED TO A GOUT FLARE UP IN HIS FOOT Cross

Contact: Eric <vfd323@gmail.com>
Sender: messaging@iamresponding.com
 1 of 2\nFRM:messaging@iamresponding.com\nSUBJ:32 Vestal Fire\nMSG:32:ALARM-BLDG :4400 VESTAL PKWY E BINGHAMTON UNIVERSIT :FIRE ALARM ACTS :\n(Con't) 2 of 2\nENDICOTT HALL 001A Cross Sts:ROUTE 201/MURRAY HILL RD 17:45 09/07/2012 2012-00000187 Caller:SUNY,,, Phone:000-777-2393 T/Vestal(End)

Contact: Neal Haight <dmbfn290@gmail.com>
Sender: 93001020
),29:MUTUAL AID :NY CITY-NASSAU-SUFFOLK :MUTUAL AID DEPLOYMENT TO NYC :HURRICANE SANDY Cross Sts: 00:58 10/30/2012 2012-00001708 Caller:BROOME COUNTY,OES,,Phone:000-778-1270 Out Broome
),29:HOUSE :ROBBLE AV :POSS HOUSE FIRE, SMELL OF SMOKE/HAZE AROUND :HOUSE ; RED/WH HOUSE ON WEST SIDE OF ROAD CALLER IS AT 308 ROBBLE Cross Sts:JENKINS ST/PINE ST 17:13 11/09/2012 2012-00001967 Caller:SPACEK,NANCY,, Phone:607-785-5226 V/Endicott

Contact: Active911
Agency name: Broome County Office of Emergency Services
Location: Binghamton, NY, United States

((10240) )) OES:MUTUAL AID :NEW YORK CITY :MUTUAL AID DEPLOYMENT TO NYC :HURRICANE SANDY Cross Sts: 00:58 10/30/2012 2012-00001708 Caller:BROOME COUNTY,OES,, Phone:000-778-1270 Out Broome\r\n\r\n
((7859) )) OES:MUTUAL AID :904 JACKSON HILL RD :PORT CRANE FIRE ON STAND-BY AT FIRE 37 :GREENE ON SCENE OF LARGE BRUSH FIRE Cross Sts: 21:11 10/27/2012 2012-00000202 Caller:CHENANGO,CO,, Phone: Out Broome\r\n\r\n
((5978) )) OES:MUTUAL AID :SUSQUEHANNA COUNTY :DIVE TEMA REQ TO ASSIST WITH RECOVERY :POSS CAR INTO RIVER OVERNIGHT - POSS VICTIM IN VEH IN RIVER RECOVERY ASSIST SUS FIRE OAKLAND BURROGH PD RIVER ST OAKLAND Cross Sts: 17:35 10/21/2012 2012-00000198 Caller:SUSQUEHANNA COUNTY,, Phone:570-278-3841 Out Broome\r\n\r\n
((4429) )) OES:FIRE OTHER :153 LT VANWINKLE DR EMERGENCY SERVICES :TEST INCIDENT :THIS IS A TEST INCIDENT Cross Sts:UPPER FRONT ST/DEAD END 10:09 10/18/2012 2012-00000075 Caller:ROGERS,CHUCK,, Phone:000-778-8214 T/Dick\r\n\r\n

Contact: Neal Haight <dmbfn290@gmail.com>
Sender: 93001026
 ),COMM:feeling dizzy 37yom <31A01> :55 ELM ST Cross Sts:WHEELER ST/DEAD END :V/Deposit : :37 year old, Male, Conscious, Breathing. Caller Statement:

*/

public class NYBroomeCountyParserTest extends BaseParserTest {
  
  public NYBroomeCountyParserTest() {
    setParser(new NYBroomeCountyParser(), "BROOME COUNTY", "NY");
  }
  
  @Test
  public void testBadMsg() {
    doBadTest(":o) :o) :o)");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(49 Sanitaria Spr Fire) 49-DIABETIC-C :2786 ROUTE 79 :78 yo fem high blood sugar/unable t   &lt;13C02&gt; :78 year old, Female, Conscious, Breathing.  A",
        "SRC:49",
        "CALL:DIABETIC-C",
        "ADDR:2786 ROUTE 79",
        "INFO:78 yo fem high blood sugar/unable t <13C02> / 78 year old, Female, Conscious, Breathing. A");

    doTest("T2",
        "25:DIABETIC-C :412 ADAMS AV APT 1S :67 yom diabetic / low sugar &lt;13C01&gt; :67 year old, Male, Conscious, Breathing. Not alert (Combative or Agg ressive). Cross Sts:TRACY ST/RIVERVIEW DR 01:29 02/07/2011 2011-00002425 Caller:BATTISTI,MAURICE,, Phone:607-239-4661 V/Endicott",
        "SRC:25",
        "CALL:DIABETIC-C",
        "ADDR:412 ADAMS AV",
        "MADDR:412 ADAMS AVE",
        "APT:1S",
        "INFO:67 yom diabetic / low sugar <13C01> / 67 year old, Male, Conscious, Breathing. Not alert (Combative or Agg ressive).",
        "X:TRACY ST/RIVERVIEW DR",
        "TIME:01:29",
        "DATE:02/07/2011",
        "ID:2011-00002425",
        "NAME:BATTISTI,MAURICE",
        "PHONE:607-239-4661");

    doTest("T3",
        "25:OVERDOSE-B :431 E MAIN ST MANLEY'S 25-1 :FEM INTOX - CONSC/ALERT 22.09 TXFR 23-B-1 : Cross Sts:LODER AV/VESTAL AV 00:52 02/07/2011 2011-00002423 Caller:LASKOWSKY,OFC,, Phone: V/Endicott",
        "SRC:25",
        "CALL:OVERDOSE-B",
        "ADDR:431 E MAIN ST",
        "PLACE:MANLEY'S 25-1",
        "INFO:FEM INTOX - CONSC/ALERT 22.09 TXFR 23-B-1",
        "X:LODER AV/VESTAL AV",
        "TIME:00:52", 
        "DATE:02/07/2011",
        "ID:2011-00002423",
        "NAME:LASKOWSKY,OFC");

    doTest("T4",
        "25:FALLS -D :600 HIGH AV UHS SKILLED NURSING :87 YOF FALLEN/NOT ALERT 17-D-3 : ADULT CARE/DAVIS AV ENTRANCE ROOM 413 FLR 4 Cross Sts:W EDWARD ST/RIVER TERR 22:50 02/06/2011 2011-00002416 Caller:IDEAL SENIOR LIVING, Phone:607-786-7449 V/Endicott",
        "SRC:25",
        "CALL:FALLS -D",
        "ADDR:600 HIGH AV",
        "MADDR:600 HIGH AVE",
        "PLACE:UHS SKILLED NURSING",
        "INFO:87 YOF FALLEN/NOT ALERT 17-D-3 / ADULT CARE/DAVIS AV ENTRANCE ROOM 413 FLR 4",
        "X:W EDWARD ST/RIVER TERR",
        "TIME:22:50",
        "DATE:02/06/2011",
        "ID:2011-00002416",
        "NAME:IDEAL SENIOR LIVING",
        "PHONE:607-786-7449");

    doTest("T5",
        "25:ALARM-BLDG :9 HILLSIDE CT APT 4 :POSS FIRE ALARM GOING OFF / TENANTS LEFT :NO SMELL OF SMOKE OR FIRE SEEN COMPL IN APT 1 Cross Sts:W MAIN ST/DEAD END 18:03 02/06/2011 2011-00000251 Caller:RANDO,TIM,, Phone:607-727-1115 V/Endicot",
        "SRC:25",
        "CALL:ALARM-BLDG",
        "ADDR:9 HILLSIDE CT",
        "APT:4",
        "INFO:POSS FIRE ALARM GOING OFF / TENANTS LEFT / NO SMELL OF SMOKE OR FIRE SEEN COMPL IN APT 1",
        "X:W MAIN ST/DEAD END",
        "TIME:18:03", 
        "DATE:02/06/2011",
        "ID:2011-00000251",
        "NAME:RANDO,TIM",
        "PHONE:607-727-1115");

    doTest("T6",
        "25:ALARM-BLDG :722 W MAIN ST :GENERAL ALARM : ENJOY GOLF COURSE Cross Sts:ENDICOTT V-LINE/INDUSTRIAL PARK RD 14:40 02/06/2011 2011-00000249 Caller:SENTRY OP 79,,, Phone: V/Endicott",
        "SRC:25",
        "CALL:ALARM-BLDG",
        "ADDR:722 W MAIN ST",
        "INFO:GENERAL ALARM / ENJOY GOLF COURSE",
        "X:ENDICOTT V-LINE/INDUSTRIAL PARK RD",
        "TIME:14:40",
        "DATE:02/06/2011",
        "ID:2011-00000249",
        "NAME:SENTRY OP 79");

    doTest("T7",
        "(25 Endicott Fire) 25-BREATHNG-C :308 ARTHUR AV APT 3 :40 yom diff breathing &lt;06C01&gt; :40 year old, Male, Conscious, Breathing. Abnormal breathing  (Asthma) . Cross Sts:E MAIN ST/TRACY ST 00:12 02/01/2011 2011-00002020 Caller:WILLIAMS,CINDY,, Phone:000-242-5076 V/Endicott",
        "SRC:25",
        "CALL:BREATHNG-C",
        "ADDR:308 ARTHUR AV",
        "MADDR:308 ARTHUR AVE",
        "APT:3",
        "INFO:40 yom diff breathing <06C01> / 40 year old, Male, Conscious, Breathing. Abnormal breathing (Asthma) .",
        "X:E MAIN ST/TRACY ST",
        "TIME:00:12",
        "DATE:02/01/2011",
        "ID:2011-00002020",
        "NAME:WILLIAMS,CINDY",
        "PHONE:000-242-5076");

    doTest("T8",
        "(25 Endicott Fire) 25:CHSTPAIN-C :415 E MAIN ST LOURDES PRIMARY 25 :41 yof chest pain &lt;10C04&gt; :41 year old, Female, Conscious, Breathing.  Breathing normally =&gt; 35. Cross Sts:LODER AV/VESTAL AV 17:39 02/01/2011 2011-00002058 Caller:CUTTING,SANDY,, Phone:607-786-180 V/Endicott",
        "SRC:25",
        "CALL:CHSTPAIN-C",
        "ADDR:415 E MAIN ST",
        "PLACE:LOURDES PRIMARY 25",
        "INFO:41 yof chest pain <10C04> / 41 year old, Female, Conscious, Breathing. Breathing normally => 35.",
        "X:LODER AV/VESTAL AV",
        "ID:2011-00002058",
        "TIME:17:39",
        "DATE:02/01/2011",
        "NAME:CUTTING,SANDY",
        "PHONE:607-786-180");

    doTest("T9",
        "(25 Endicott Fire) 25:SEIZURES-D :326 JENNINGS ST :42 yof seizure                        &lt;12D02&gt; :42 year old, Female, Unconscious, Breathing.  CO",
        "SRC:25",
        "CALL:SEIZURES-D",
        "ADDR:326 JENNINGS ST",
        "INFO:42 yof seizure <12D02> / 42 year old, Female, Unconscious, Breathing. CO");

    doTest("T10",
        "((26873) ) ) 32:ALARM-HOUS :416 E BENITA BLVD :SMOKE ALARM GOING OFF INTERMITTENLY IN :BASEMENT. NO SMOKE OR FIRE VISIBLE-POSS PROBLEM WITH DETECTOR Cross Sts",
        "SRC:32",
        "CALL:ALARM-HOUS",
        "ADDR:416 E BENITA BLVD",
        "INFO:SMOKE ALARM GOING OFF INTERMITTENLY IN / BASEMENT. NO SMOKE OR FIRE VISIBLE-POSS PROBLEM WITH DETECTOR Cross Sts");

    doTest("T11",
        "Subject:(11470) ) \nCOMM:CHSTPAIN-C :27 GOLDEN LN HARPURSVILLE SENIOR :66yom chest pain                      <10C02> :66 year old, Male, C",
        "SRC:COMM",
        "CALL:CHSTPAIN-C",
        "ADDR:27 GOLDEN LN",
        "PLACE:HARPURSVILLE SENIOR",
        "INFO:66yom chest pain <10C02> / 66 year old, Male, C");

    doTest("T12",
        "Subject:(12610) ) \nCOMM:UNRSPNSV-D :528 JENSEN RD :81 YOM NOT ALERT/SEVERE HEADACHE/DELTA :CALLER IS VESTAL CREW CHIEF OR DRIVER/CAN DO E",
        "SRC:COMM",
        "CALL:UNRSPNSV-D",
        "ADDR:528 JENSEN RD",
        "INFO:81 YOM NOT ALERT/SEVERE HEADACHE/DELTA / CALLER IS VESTAL CREW CHIEF OR DRIVER/CAN DO E");

    doTest("T13",
        ".... (46 Conklin Fire) 46:CHSTPAIN-D :12 WILLOW WAY :84 yom chest pain                     &lt;10D03&gt; :84 year old, Male, Conscious, Breathing.  CHANGING COLOR. Cross Sts:CONKLIN RD/DAVID RD 18:55 07/24/2011 2011-00013205 Caller:CEBULA,JAMES,, Phone:000-775-2793 T/Conklin",
        "SRC:46",
        "CALL:CHSTPAIN-D",
        "ADDR:12 WILLOW WAY",
        "INFO:84 yom chest pain <10D03> / 84 year old, Male, Conscious, Breathing. CHANGING COLOR.",
        "X:CONKLIN RD/DAVID RD",
        "TIME:18:55",
        "DATE:07/24/2011",
        "ID:2011-00013205",
        "NAME:CEBULA,JAMES",
        "PHONE:000-775-2793 T/Conklin");

    doTest("T14",
        ".... (46 Conklin Fire) 46:FALLS   -D :1186 CONKLIN RD :69 YOM FALLEN                         &lt;17D05&gt; :69 year old, Male, Conscious, Breathing.  LONG FALL. Cross Sts:POWERS RD/CAROL CT 13:54 07/23/2011 2011-00013114 Caller:KING,PAULINE,, Phone:000-206-2374 T/Conklin",
        "SRC:46",
        "CALL:FALLS -D",
        "ADDR:1186 CONKLIN RD",
        "INFO:69 YOM FALLEN <17D05> / 69 year old, Male, Conscious, Breathing. LONG FALL.",
        "X:POWERS RD/CAROL CT",
        "TIME:13:54",
        "DATE:07/23/2011",
        "ID:2011-00013114",
        "NAME:KING,PAULINE",
        "PHONE:000-206-2374 T/Conklin");
  }
  
  @Test
  public void testParser79() {

     doTest("T1",
         "(79 Union Amb) 79:TRAUMA  -D :36 BAKER ST :8 yof hit by veh                      &lt;30D01&gt; :8 year old, Female, Unconscious, Breathing.  Unconscious",
         "SRC:79",
         "CALL:TRAUMA -D",
         "ADDR:36 BAKER ST",
         "INFO:8 yof hit by veh <30D01> / 8 year old, Female, Unconscious, Breathing. Unconscious");

     doTest("T2",
         "(79 Union Amb) 79:UNRSPNSV-C :420 HARRY L DR CHRISTMAS TREE SHOPS :36 yof fainted x1 rapid heart         &lt;31C01&gt; :BUSN: Cross Sts:N HUDSON ST/GIAN",
         "SRC:79",
         "CALL:UNRSPNSV-C",
         "ADDR:420 HARRY L DR",
         "PLACE:CHRISTMAS TREE SHOPS",
         "INFO:36 yof fainted x1 rapid heart <31C01> / BUSN:",
         "X:N HUDSON ST/GIAN");

     doTest("T3",
         "(79 Union Amb) 79:DIABETIC-C :950 BOSWELL HILL RD :54 yof diabetic not alert             &lt;13C01&gt; :54 year old, Female, Conscious, Breathing.  Not",
         "SRC:79",
         "CALL:DIABETIC-C",
         "ADDR:950 BOSWELL HILL RD",
         "INFO:54 yof diabetic not alert <13C01> / 54 year old, Female, Conscious, Breathing. Not");

  }
  
  @Test
  public void testParser22() {

    doTest("T1",
        "(22 Deposit Fire/Amb) 22/75:SICKPERS-A :480 BIG HOLLOW RD :56YOM GEN ILLNESS/UNABLE TO WALK   ALPHA :ISSUES RELATED TO A GOUT FLARE UP IN HIS FOOT Cross",
        "SRC:22/75",
        "CALL:SICKPERS-A",
        "ADDR:480 BIG HOLLOW RD",
        "INFO:56YOM GEN ILLNESS/UNABLE TO WALK ALPHA / ISSUES RELATED TO A GOUT FLARE UP IN HIS FOOT Cross");
  }
  
  @Test
  public void testParser32() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:messaging@iamresponding.com\n" +
        "SUBJ:32 Vestal Fire\n" +
        "MSG:32:ALARM-BLDG :4400 VESTAL PKWY E BINGHAMTON UNIVERSIT :FIRE ALARM ACTS :\n" +
        "(Con't) 2 of 2\n" +
        "ENDICOTT HALL 001A Cross Sts:ROUTE 201/MURRAY HILL RD 17:45 09/07/2012 2012-00000187 Caller:SUNY,,, Phone:000-777-2393 T/Vestal(End)",

        "SRC:32",
        "CALL:ALARM-BLDG",
        "ADDR:4400 VESTAL PKWY E",
        "PLACE:BINGHAMTON UNIVERSIT",
        "INFO:FIRE ALARM ACTS / ENDICOTT HALL 001A",
        "X:ROUTE 201/MURRAY HILL RD",
        "TIME:17:45",
        "DATE:09/07/2012",
        "ID:2012-00000187",
        "NAME:SUNY",
        "PHONE:000-777-2393 T/Vestal");

  }
  
  @Test
  public void testNeilHaight() {

    doTest("T1",
        "),29:MUTUAL AID :NY CITY-NASSAU-SUFFOLK :MUTUAL AID DEPLOYMENT TO NYC :HURRICANE SANDY Cross Sts: 00:58 10/30/2012 2012-00001708 Caller:BROOME COUNTY,OES,,Phone:000-778-1270 Out Broome",
        "SRC:29",
        "CALL:MUTUAL AID",
        "ADDR:NY CITY-NASSAU-SUFFOLK",
        "INFO:MUTUAL AID DEPLOYMENT TO NYC / HURRICANE SANDY",
        "TIME:00:58",
        "DATE:10/30/2012",
        "ID:2012-00001708",
        "NAME:BROOME COUNTY,OES,,Phone:000-778-1270 Out Broome");

    doTest("T2",
        "),29:HOUSE :ROBBLE AV :POSS HOUSE FIRE, SMELL OF SMOKE/HAZE AROUND :HOUSE ; RED/WH HOUSE ON WEST SIDE OF ROAD CALLER IS AT 308 ROBBLE Cross Sts:JENKINS ST/PINE ST 17:13 11/09/2012 2012-00001967 Caller:SPACEK,NANCY,, Phone:607-785-5226 V/Endicott",
        "SRC:29",
        "CALL:HOUSE",
        "ADDR:ROBBLE AV",
        "MADDR:ROBBLE AVE & JENKINS ST",
        "INFO:POSS HOUSE FIRE, SMELL OF SMOKE/HAZE AROUND / HOUSE ; RED/WH HOUSE ON WEST SIDE OF ROAD CALLER IS AT 308 ROBBLE",
        "X:JENKINS ST/PINE ST",
        "TIME:17:13",
        "DATE:11/09/2012",
        "ID:2012-00001967",
        "NAME:SPACEK,NANCY",
        "PHONE:607-785-5226");

  }
  
  @Test
  public void testBCOES() {

    doTest("T1",
        "((10240) )) OES:MUTUAL AID :NEW YORK CITY :MUTUAL AID DEPLOYMENT TO NYC :HURRICANE SANDY Cross Sts: 00:58 10/30/2012 2012-00001708 Caller:BROOME COUNTY,OES,, Phone:000-778-1270 Out Broome\r\n" +
        "\r\n",

        "SRC:OES",
        "CALL:MUTUAL AID",
        "ADDR:NEW YORK CITY",
        "INFO:MUTUAL AID DEPLOYMENT TO NYC / HURRICANE SANDY",
        "TIME:00:58",
        "DATE:10/30/2012",
        "ID:2012-00001708",
        "NAME:BROOME COUNTY,OES",
        "PHONE:000-778-1270 Out Broome");

    doTest("T2",
        "((7859) )) OES:MUTUAL AID :904 JACKSON HILL RD :PORT CRANE FIRE ON STAND-BY AT FIRE 37 :GREENE ON SCENE OF LARGE BRUSH FIRE Cross Sts: 21:11 10/27/2012 2012-00000202 Caller:CHENANGO,CO,, Phone: Out Broome\r\n" +
        "\r\n",

        "SRC:OES",
        "CALL:MUTUAL AID",
        "ADDR:904 JACKSON HILL RD",
        "INFO:PORT CRANE FIRE ON STAND-BY AT FIRE 37 / GREENE ON SCENE OF LARGE BRUSH FIRE",
        "TIME:21:11",
        "DATE:10/27/2012",
        "ID:2012-00000202",
        "NAME:CHENANGO,CO",
        "PHONE:Out Broome");

    doTest("T3",
        "((5978) )) OES:MUTUAL AID :SUSQUEHANNA COUNTY :DIVE TEMA REQ TO ASSIST WITH RECOVERY :POSS CAR INTO RIVER OVERNIGHT - POSS VICTIM IN VEH IN RIVER RECOVERY ASSIST SUS FIRE OAKLAND BURROGH PD RIVER ST OAKLAND Cross Sts: 17:35 10/21/2012 2012-00000198 Caller:SUSQUEHANNA COUNTY,, Phone:570-278-3841 Out Broome\r\n" +
        "\r\n",

        "SRC:OES",
        "CALL:MUTUAL AID",
        "ADDR:SUSQUEHANNA COUNTY",
        "INFO:DIVE TEMA REQ TO ASSIST WITH RECOVERY / POSS CAR INTO RIVER OVERNIGHT - POSS VICTIM IN VEH IN RIVER RECOVERY ASSIST SUS FIRE OAKLAND BURROGH PD RIVER ST OAKLAND",
        "TIME:17:35",
        "DATE:10/21/2012",
        "ID:2012-00000198",
        "NAME:SUSQUEHANNA COUNTY",
        "PHONE:570-278-3841 Out Broome");

    doTest("T4",
        "((4429) )) OES:FIRE OTHER :153 LT VANWINKLE DR EMERGENCY SERVICES :TEST INCIDENT :THIS IS A TEST INCIDENT Cross Sts:UPPER FRONT ST/DEAD END 10:09 10/18/2012 2012-00000075 Caller:ROGERS,CHUCK,, Phone:000-778-8214 T/Dick\r\n" +
        "\r\n",

        "SRC:OES",
        "CALL:FIRE OTHER",
        "ADDR:153 LT VANWINKLE DR",
        "PLACE:EMERGENCY SERVICES",
        "INFO:TEST INCIDENT / THIS IS A TEST INCIDENT",
        "X:UPPER FRONT ST/DEAD END",
        "TIME:10:09",
        "DATE:10/18/2012",
        "ID:2012-00000075",
        "NAME:ROGERS,CHUCK",
        "PHONE:000-778-8214 T/Dick");

  }
  
  @Test
  public void testNealHaight() {

    doTest("T1",
        " ),COMM:feeling dizzy 37yom <31A01> :55 ELM ST Cross Sts:WHEELER ST/DEAD END :V/Deposit : :37 year old, Male, Conscious, Breathing. Caller Statement:",
        "SRC:COMM",
        "CALL:feeling dizzy 37yom",
        "CODE:31A01",
        "ADDR:55 ELM ST",
        "X:WHEELER ST/DEAD END");
    
  }

  
  public static void main(String[] args) {
    new NYBroomeCountyParserTest().generateTests("T1");
  }
}