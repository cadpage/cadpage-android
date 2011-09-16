package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


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
        "APT:1S",
        "INFO:67 yom diabetic / low sugar <13C01> / 67 year old, Male, Conscious, Breathing. Not alert (Combative or Agg ressive).",
        "X:TRACY ST/RIVERVIEW DR",
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
        "ID:2011-00002423",
        "NAME:LASKOWSKY,OFC");

    doTest("T4",
        "25:FALLS -D :600 HIGH AV UHS SKILLED NURSING :87 YOF FALLEN/NOT ALERT 17-D-3 : ADULT CARE/DAVIS AV ENTRANCE ROOM 413 FLR 4 Cross Sts:W EDWARD ST/RIVER TERR 22:50 02/06/2011 2011-00002416 Caller:IDEAL SENIOR LIVING, Phone:607-786-7449 V/Endicott",
        "SRC:25",
        "CALL:FALLS -D",
        "ADDR:600 HIGH AV",
        "PLACE:UHS SKILLED NURSING",
        "INFO:87 YOF FALLEN/NOT ALERT 17-D-3 / ADULT CARE/DAVIS AV ENTRANCE ROOM 413 FLR 4",
        "X:W EDWARD ST/RIVER TERR",
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
        "ID:2011-00000249",
        "NAME:SENTRY OP 79");

    doTest("T7",
        "(25 Endicott Fire) 25-BREATHNG-C :308 ARTHUR AV APT 3 :40 yom diff breathing &lt;06C01&gt; :40 year old, Male, Conscious, Breathing. Abnormal breathing  (Asthma) . Cross Sts:E MAIN ST/TRACY ST 00:12 02/01/2011 2011-00002020 Caller:WILLIAMS,CINDY,, Phone:000-242-5076 V/Endicott",
        "SRC:25",
        "CALL:BREATHNG-C",
        "ADDR:308 ARTHUR AV",
        "APT:3",
        "INFO:40 yom diff breathing <06C01> / 40 year old, Male, Conscious, Breathing. Abnormal breathing (Asthma) .",
        "X:E MAIN ST/TRACY ST",
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
        "ID:2011-00013114",
        "NAME:KING,PAULINE",
        "PHONE:000-206-2374 T/Conklin");
  }
  
  @Test
  public void testParser2() {

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
  
  public static void main(String[] args) {
    new NYBroomeCountyParserTest().generateTests("T1");
  }
}