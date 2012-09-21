package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAWestmorelandCountyParserTest extends BaseParserTest {
  
  public PAWestmorelandCountyParserTest() {
    setParser(new PAWestmorelandCountyParser(), "WESTMORELAND COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Loc: 118 S 4TH ST YNGWD_B X-sts: CHESTNUT ST & LOCUST ST  Inc#:F11000861 NATURE: FIRE  CALLER: ANTHONY GALADIAY TOC: 19:08:40 Comments: FLAMES COMING OUT OF THE WALL  Disp: E26-1",
        "ADDR:118 S 4TH ST",
        "CITY:YOUNGWOOD",
        "X:CHESTNUT ST & LOCUST ST",
        "ID:F11000861",
        "CALL:FIRE",
        "NAME:ANTHONY GALADIAY",
        "INFO:FLAMES COMING OUT OF THE WALL",
        "UNIT:E26-1");

    doTest("T2",
        "Loc: 400 PAINTERSVILLE RD HEMP_T: @SUPER VALUE PERISHABLE WAREHOUSE X-sts: S CENTER AVE &   Inc#:F11001007 NATURE: AFA  CALLER: ADT....KANDRA TOC: 06:46:18 Comments: GENERAL & DRY RISER #9 WATER FLOW WATC  Disp: E28,E25-2,TL26,E27",
        "ADDR:400 PAINTERSVILLE RD",
        "CITY:HEMPFIELD TWP",
        "PLACE:SUPER VALUE PERISHABLE WAREHOUSE",
        "X:S CENTER AVE &",
        "ID:F11001007",
        "CALL:AFA",
        "NAME:ADT....KANDRA",
        "INFO:GENERAL & DRY RISER #9 WATER FLOW WATC",
        "UNIT:E28,E25-2,TL26,E27");

    doTest("T3",
        "Loc: 325 N CENTER AVE N_STANTN_B: @KFC X-sts: WESTMORE AVE & HIGHLAND AVE Inc#:F11001017 NATURE: FIRE  CALLER: STEVEN NELSON TOC: 10:33:44 Comments: WATER IS COMING IN THRU THE LIGHTS POSS ELECTRICAL FIRE HE SAW SMOPKE IN THE KITC E26-1,E25-2,E19,E27",
        "ADDR:325 N CENTER AVE",
        "CITY:NEW STANTON",
        "PLACE:KFC",
        "X:WESTMORE AVE & HIGHLAND AVE",
        "ID:F11001017",
        "CALL:FIRE",
        "NAME:STEVEN NELSON",
        "INFO:WATER IS COMING IN THRU THE LIGHTS POSS ELECTRICAL FIRE HE SAW SMOPKE IN THE KITC E26-1,E25-2,E19,E27");

    doTest("T4",
        "Loc: 911 S MAIN ST SW_GBG_B: @WESTMORELAND COUNTY BLIND ASSOCIATION X-sts: CRIBBS ST & GREEN ST  Inc#:F11001035 NATURE: AFA  CALLER: MARK TOC: 15:58:53 Comments: WATER FLOW ALARM MAAS NOTF  Disp: L23,E32-1,TL26,E24-1",
        "ADDR:911 S MAIN ST",
        "CITY:SW GREENSBURG",
        "PLACE:WESTMORELAND COUNTY BLIND ASSOCIATION",
        "X:CRIBBS ST & GREEN ST",
        "ID:F11001035",
        "CALL:AFA",
        "NAME:MARK",
        "INFO:WATER FLOW ALARM MAAS NOTF",
        "UNIT:L23,E32-1,TL26,E24-1");

    doTest("T5",
        "Loc: 407 CHESTNUT ST SW_GBG_B X-sts: STANTON ST & BRANDON ST  Inc#:F11000412 NATURE: AFA  CALLER: SCHUR NANCY TOC: 11:14:39 Comments: APT A AUDIBLE FIRE ALARM ACTIVATED CALLER DOES NOT WERE ITS COMING FROM DOES NOT KNOW WERE ITS COMING FROM  Disp: L23,E32-1,TL26,E24-1",
        "ADDR:407 CHESTNUT ST",
        "CITY:SW GREENSBURG",
        "X:STANTON ST & BRANDON ST",
        "ID:F11000412",
        "CALL:AFA",
        "NAME:SCHUR NANCY",
        "INFO:APT A AUDIBLE FIRE ALARM ACTIVATED CALLER DOES NOT WERE ITS COMING FROM DOES NOT KNOW WERE ITS COMING FROM",
        "UNIT:L23,E32-1,TL26,E24-1");

    doTest("T6",
        "Loc: 800 I 76 E MT_PLEAS_T X-sts: RAMP EXIT 75 TO I 76 E & RAMP I 76 E TO EXIT 91  Inc#:F11001058 NATURE: VF  CALLER: KEN GAY TOC: 06:31:36 Comments: IN THE MIDDLE OF THE ROAD  Disp: E25-2,E26-1",
        "ADDR:800 I 76 E",
        "CITY:MT PLEASANT TWP",
        "X:RAMP EXIT 75 TO I 76 E & RAMP I 76 E TO EXIT 91",
        "ID:F11001058",
        "CALL:VF",
        "NAME:KEN GAY",
        "INFO:IN THE MIDDLE OF THE ROAD",
        "UNIT:E25-2,E26-1");

    doTest("T7",
        "Loc: 680 I 76 W HEMP_T X-sts: RAMP EXIT 75 TO I 76 W & RAMP I 76 W TO EXIT 57  Inc#:F11000422 NATURE: 29B06  CALLER: EVAN ROBINSONS TOC: 13:46:00 Comments: 1 VEH UNK INJS Response text: Bravo Responder script: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.Unknown number of patients involved. Traffic / Transportation Accidents. 1.The accident involves a single vehicle. 2.It's not known if chemicals or other hazards are involved. 3.It's not known if anyone is pinned. 4.It's not known if anyone was thrown from the vehicle. 5.It's not known if everyone is completely awake (alert). 6.Their injuries are described as other than to a NOT DANGEROUS area. 7.There is no bleeding now. -079.645493 +040.26574 Duplicate Event:Location = 680 I 76 W HEMP_T, Cross Street 1 = RAMP EXIT 75 TO I VEH ACC FEMALE HAS BLOOD ON HER FACE 76 W RAMP I 76 W TO EXIT 57, Cross Street 2 = RAMP I 76 W TO EXIT 57, Caller LAYING NEXT TO CAR Name = TOM ALAND, Caller Ph Number = (412)607-7756, Caller Address = 423 HIT MEDIAN MIDDLETOWN RD HEMPFIELD, Call Source = ANI/ALI, Alarm Level = 0 End of Duplicate Event data  Disp: R25,R26",
        "ADDR:680 I 76 W",
        "CITY:HEMPFIELD TWP",
        "X:RAMP EXIT 75 TO I 76 W & RAMP I 76 W TO EXIT 57",
        "ID:F11000422",
        "CALL:29B06",
        "NAME:EVAN ROBINSONS",
        "INFO:1 VEH UNK INJS",
        "UNIT:R25,R26");

    doTest("T8",
        "Loc: 859 ROUTE 119 N_STANTN_B: alias 859 RT 119 N_STANTN_B X-sts: RAMP RT 119 S TO TOLL 66 N & RAMP TOLL 66 N TO SR 3091  Inc#:F11001086 NATURE: 29D02F  CALLER: LORI STRIPAY TOC: 15:06:51 Comments: TRUCK OTed  Disp: R25,R26",
        "ADDR:859 ROUTE 119",
        "CITY:NEW STANTON",
        "PLACE:alias 859 RT 119 N_STANTN_B",
        "X:RAMP RT 119 S TO TOLL 66 N & RAMP TOLL 66 N TO SR 3091",
        "ID:F11001086",
        "CALL:29D02F",
        "NAME:LORI STRIPAY",
        "INFO:TRUCK OTed",
        "UNIT:R25,R26");

    doTest("T9",
        "Loc: 2399 RACE TRACK RD HEMP_T: EST X-sts: N CENTER AVE & WILSON FOX RD Inc#:F11000404 NATURE: 29B06  CALLER: BETTY JEAN FALO TOC: 08:05:39 Comments: JUST BEFORE FOX DEN ACRES VEH INTO THE GULLY COMING FROM NEW STANTON ITS ON THE LEFT HAND SIDE UNK INJ Response text: Bravo Responder script: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown.Unknown number of patients involved. Traffic / Transportation Accidents. 1.The accident involves a single vehicle. 2.It's not known if chemicals or other hazards are involved. 3.It's not known if anyone is pinned. 4.It's not known if anyone was thrown from the vehicle. 5.It's not known if everyone is completely awake (alert). 6.The type and nature of their injuries are not known. 7.It's not known if there is SERIOUS bleeding. Chief complaint: UNK INJ Response description: Bravo  Disp: R26,E25-2,E104",
        "ADDR:2399 RACE TRACK RD",
        "CITY:HEMPFIELD TWP",
        "PLACE:EST",
        "X:N CENTER AVE & WILSON FOX RD",
        "ID:F11000404",
        "CALL:29B06",
        "NAME:BETTY JEAN FALO",
        "INFO:JUST BEFORE FOX DEN ACRES VEH INTO THE GULLY COMING FROM NEW STANTON ITS ON THE LEFT HAND SIDE UNK INJ",
        "UNIT:R26,E25-2,E104");

    doTest("T10",
        "X-sts: ROUTE 819 & ALBRIGHTS LAKE RD  Inc#:F11000118 NATURE: FIRE CALLER: CHRIS WENSEL TOC: 17:19:37 Comments:  JUST PAST INTERSECTION ON RIGHT.. WHEN HEADING AWAY FROM GREENSBURG S NOT SURE OF ADDRESS. // IS ON RT 819// // DARK SMOKE ALL AROUND HOUSE AND COMING OUT OF CHIMNEY.. DOES NOT SEE FLAMES UNK IF ANYONE INSIDE THE RES MAAS NOTIF CALLER LIVES AT 465 ALBRIGHT LAKE RD. . MAAS REQ NOT IF ACTUAL FIRE FT 5  Disp: E28,E79-8,E32-1,TL26",
        "ADDR:ROUTE 819 & ALBRIGHTS LAKE RD",
        "ID:F11000118",
        "CALL:FIRE",
        "NAME:CHRIS WENSEL",
        "INFO:JUST PAST INTERSECTION ON RIGHT.. WHEN HEADING AWAY FROM GREENSBURG S NOT SURE OF ADDRESS. // IS ON RT 819// // DARK SMOKE ALL AROUND HOUSE AND COMING OUT OF CHIMNEY.. DOES NOT SEE FLAMES UNK IF ANYONE INSIDE THE RES MAAS NOTIF CALLER LIVES AT 465 ALBRIGHT LAKE RD. . MAAS REQ NOT IF ACTUAL FIRE FT 5",
        "UNIT:E28,E79-8,E32-1,TL26");

    doTest("T11",
        "X-sts: ARMBRUST RD & FAIRGROUNDS RD  Inc#:F10019394 NATURE: 29B01 CALLER: PSPG TOC: 21:02:22 Comments:  1 INJ  Disp: R26,E28,R25,R28,E25-2,SS26",
        "ADDR:ARMBRUST RD & FAIRGROUNDS RD",
        "ID:F10019394",
        "CALL:29B01",
        "NAME:PSPG",
        "INFO:1 INJ",
        "UNIT:R26,E28,R25,R28,E25-2,SS26");

    doTest("T12",
        "X-sts: HILLIS ST & GENARD LN  Inc#:F10019516 NATURE: 29A01 CALLER: PSPGB TOC: 15:01:13 Comments:  BETWEEN 9 AND WAGNER MAA NOT FIRE TAC 7  Disp: R26",
        "ADDR:HILLIS ST & GENARD LN",
        "ID:F10019516",
        "CALL:29A01",
        "NAME:PSPGB",
        "INFO:BETWEEN 9 AND WAGNER MAA NOT FIRE TAC 7",
        "UNIT:R26");

    doTest("T13",
        "Loc: 407 N 4TH ST YNGWD_B X-sts: HALLER AVE & OVERHEAD BRIDGE RD Inc#:F11000526 NATURE: AED  CALLER: CRABTREE JAMES T/ RITA TOC: 04:42:15 Comments: 73 YOM / UNCON / NOT BREATHING Response text: Echo Responder script: 73 year old, Male, Unconscious, Not breathing. Cardiac or Respiratory Arrest / Death. CONN MAAS FIRE TAC 10  Disp: E26-1",
        "ADDR:407 N 4TH ST",
        "CITY:YOUNGWOOD",
        "X:HALLER AVE & OVERHEAD BRIDGE RD",
        "ID:F11000526",
        "CALL:AED",
        "NAME:CRABTREE JAMES T/ RITA",
        "INFO:73 YOM / UNCON / NOT BREATHING",
        "UNIT:E26-1");

    doTest("T14",
        "Loc: 220 N 5TH ST YNGWD_B X-sts: LINCOLN ST & WASHINGTON AVE  Inc#:F10019293 NATURE: AMBAS CALLER: MAAS TOC: 23:03:07 Comments:  REQ FIRE FOR LIFTING NON EMERGENCY  Disp: E26-1",
        "ADDR:220 N 5TH ST",
        "CITY:YOUNGWOOD",
        "X:LINCOLN ST & WASHINGTON AVE",
        "ID:F10019293",
        "CALL:AMBAS",
        "NAME:MAAS",
        "INFO:REQ FIRE FOR LIFTING NON EMERGENCY",
        "UNIT:E26-1");

    doTest("T15",
        "Loc: 220 TOLLHOUSE LN N_HUNT_T X-sts: ARONA RD & Inc#:F11004303 NATURE: FIRE CALLER: SHARON KAUFFMAN TOC: 15:52:00 Comments: ODOR OF POSS PLASTIC BURNING IN THE RESDIENCE FT 3\\ ADV TO GET OUT OF THE HOUSE...NOHO ADV Disp: E94-2,E57,E02-1,E03-1,Q10",
        "ADDR:220 TOLLHOUSE LN",
        "CITY:N HUNTINGDON TWP",
        "X:ARONA RD &",
        "ID:F11004303",
        "CALL:FIRE",
        "NAME:SHARON KAUFFMAN",
        "INFO:ODOR OF POSS PLASTIC BURNING IN THE RESDIENCE FT 3\\ ADV TO GET OUT OF THE HOUSE...NOHO ADV",
        "UNIT:E94-2,E57,E02-1,E03-1,Q10");

    doTest("T1",
        "1 of 3\n" +
        "FRM:alert@ecm2.us\n" +
        "SUBJ:ST49 - 911 Call\n" +
        "MSG:Loc: 151 GOODVIEW DR WASH_T: @WEST HAVEN MANOR NURSING HOME X-sts: ROUTE 66 & ROUTE 66 \n" +
        "(Con't) 2 of 3\n" +
        "Inc#:F12002321 NATURE: AFA AUTOMATIC FIRE ALARM  CALLER: SELECT SECURITY.20 TOC: 18:09:59 Fire TAC:  EMS Tac: Comments: SPECIAL ADDRESS\n" +
        "(Con't) 3 of 3\n" +
        "COMMENT: WING ?? ROOM # ?? GENERAL FIRE WATC FT 6  Disp: E49,Q102,E102,E169\n" +
        "(End)",

        "ADDR:151 GOODVIEW DR",
        "CITY:WASH_T",
        "PLACE:WEST HAVEN MANOR NURSING HOME",
        "X:ROUTE 66 & ROUTE 66",
        "ID:F12002321",
        "CALL:AFA AUTOMATIC FIRE ALARM",
        "NAME:SELECT SECURITY.20",
        "INFO:SPECIAL ADDRESS COMMENT: WING ?? ROOM # ?? GENERAL FIRE WATC FT 6",
        "UNIT:E49,Q102,E102,E169");
       
  }
  
  public static void main(String[] args) {
    new PAWestmorelandCountyParserTest().generateTests("T1");
  }
}