package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IL.ILMedstarParser;

import org.junit.Test;

/*
Medstar IL (Medical only in Randolf, Clinton, and St Clair counties)
Contact: l.keirstead@yahoo.com,6154407605@vzwpix.com
Sender: emsdispatch@medstarems.net
System: ProQA
[- part 1 of 1]  RC:Run# 34870/64 WEST BOUND//across from weight station/////male subj white car hit by a truck isp en route/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34859/505 LEMANS WAY///SCC PG 15/FAIRVIEW HEIGHTS///55yof unc diff b possible overdose on pills - adavan tramadol/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34577/20 KINDER ST//cah/SCC PG 11/EAST SAINT LOUIS///31f c/b chest and back px cardiac hx  ProQA comments: chest px/10D04
[- part 1 of 1]  RC:Run# 34384/1308 CORLISS//westinghouse and n greenmount//SHILO///38m c/b rapid heart rate/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34620/13 LOISEL DR///SCC PG 14/EAST SAINT LOUIS///70 M C/B CONFUSED ProQA comments: UNK/31D03
(- part 1 of 1) RC:Run# 35456/STATE HWY 157 & STATE HWY 15//Centerville/SCC PG 13/EAST SAINT LOUIS///pedestian struck/<PROQA_DET>
(- part 1 of 1) RC:Run# 35411/St Elizabeths B'vll/IN PATIENT/634 1/SCC PG 26/BELLEVILLE/119 KENSINGTON HEIGHTS RD//f extreme weakness unable to support s

Contact: Scott Fry <emtbasic12@gmail.com>
1 of 2\nFRM:emsdispatch@medstarems.net\nSUBJ:- part 1 of 1\nMSG:RC:Run# 17158/St Elizabeths B'vll/IN PATIENT/347-2/SCC PG26/BELLEVILLE/429 S MAIN\n(Con't) 2 of 2\nST//CONFUSED POSS COMBATIVE NSE PCS AND FACESHEET REQ ***MEDICARE****\n(End)

Contact: Mark Bearth <mark.bearth@gmail.com>
RC:Run# 17411/451 3RD ST////BECKEMEYER///ST ANTHONY'S CHURCH  75YOM UNC/BREATHING NURSE ON SCENE ProQA comme

Contact: Active911
[- part 1 of 1] RC:Run# 23121/ATRIUM HEALTHCARE & REHAB//ROOM 2-3/SCC PG 23/CAHOKIA///Psychiatric/Suicide Attempt/40 YOF C/B PYSCH HX DID NOT RESPOND TO HALDAL/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23123/64 EAST BOUND AT 25TH ST////EAST SAINT LOUIS///Traffic Accidents/F PT C/B ROCK WENT THROUGH WINDOW/ GLASS IN MOUTH/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23124/502 S 17TH ST///SCC PG 26/BELLEVILLE///Psychiatric/Suicide Attempt/50 YOM C/B TOOK HANDFUL OF VICODEN PD ON SCENE/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23124/502 S 17TH ST///SCC PG 26/BELLEVILLE///Psychiatric/Suicide Attempt/50 YOM C/B TOOK HANDFUL OF VICODEN PD ON SCENE/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23126/1307 POTOMAC DR///SCC PG 27/BELLEVILLE///Breathing Problems/22 YOF PT C/SOB POSS ETOH/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23127/Red Bud Regional Hosp/ER DEPT/5//RED BUD/Touchette Reg Hosp/IN PATIENT//38 YOM C/B PSYCH EVAL/ SUICIDAL/ NSE/ PCS AND FACE SHEET REQUESTED/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23128/S 27TH ST & TRENDLEY AVE///SCC PG 12/EAST SAINT LOUIS///Unknown Problem (Man Down)/f subj slump over the wheel been there for more than an hour/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23129/Cedar Ridge//E-13-B/SCC PG 18/LEBANON///Transfer/Interfacility/Palliative Care/79YOF C/DIFF BREATHING ELEVATED B/P CODE LEVEL FULL/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23130/PD BELLEVILLE///SCC PG 26/BELLEVILLE///Assault/Rape/20YOM C/B FACIAL INJURIES FROM 10-1O/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23131/S 13TH ST & TUDOR AVE///SCC PG 12/EAST SAINT LOUIS///Traffic Accidents/10-50 ROLLOVER WITH ENTRAPMENT/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23132/3117 W BLVD////BELLEVILLE///Falls/Back Injuries (Traumatic)/PD ON SCENE 23 YOM C/B FELL DOWN STAIRS/ UNK INJ/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23134/Charles Gardens//ROOM 14/SCC PG 15/FAIRVIEW HEIGHTS///Hemorrhage/Lacerations/83 YOM C/B RECTAL BLEED/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23135/631 N 85TH ST///SCC PG 14/EAST SAINT LOUIS///Assault/Rape/28YOF C/B ASSAULTED PD 10-76 SUBJ STRUCK IN THE HEAD/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23136/804 N 33RD ST///SCC PG 3/EAST SAINT LOUIS///Sick Person (Specific Diagnosis)/47YOM C/B UNABLE TO GET UP/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23137/BELLEVILLE HEALTHCARE AND REHAB//404-2/SCC PG 26/BELLEVILLE///Transfer/Interfacility/Palliative Care/90YOF UNRESPONSIVE/B UNK PROBLEM CODE LEVELFULL/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23138/324 N JACKSON ST///SCC PG 26/BELLEVILLE///Unconscious/Fainting (Non-traumatic)/22YOF UNC/B UNK PROBLEM PD 10-76/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23139/N 21ST ST & SAINT CLAIR AVE///SCC PG 2/EAST SAINT LOUIS///Traumatic Injuries (Specific)/PD 10-23 WINDOWS BUSTED OUT GLASS HIT BABY/<PROQA_DET>\r\n\r\n\n

 */

public class ILMedstarParserTest extends BaseParserTest {
  
  public ILMedstarParserTest() {
    setParser(new ILMedstarParser(), "", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[- part 1 of 1]  RC:Run# 34870/64 WEST BOUND//across from weight station/////male subj white car hit by a truck isp en route/<PROQA_DET>",
        "ID:34870",
        "ADDR:64 WEST BOUND",
        "CALL:across from weight station",
        "INFO:male subj white car hit by a truck isp en route");
    
    doTest("T2",
        "[- part 1 of 1]  RC:Run# 34859/505 LEMANS WAY///SCC PG 15/FAIRVIEW HEIGHTS///55yof unc diff b possible overdose on pills - adavan tramadol/<PROQA_DET>",
        "ID:34859",
        "ADDR:505 LEMANS WAY",
        "MAP:15",
        "CITY:FAIRVIEW HEIGHTS",
        "CALL:55yof unc diff b possible overdose on pills - adavan tramadol");
    
    doTest("T3",
        "[- part 1 of 1]  RC:Run# 34577/20 KINDER ST//cah/SCC PG 11/EAST SAINT LOUIS///31f c/b chest and back px cardiac hx  ProQA comments: chest px/10D04",
        "ID:34577",
        "ADDR:20 KINDER ST",
        "MAP:11",
        "CITY:EAST SAINT LOUIS",
        "CALL:31f c/b chest and back px cardiac hx");
    
    doTest("T4",
        "[- part 1 of 1]  RC:Run# 34384/1308 CORLISS//westinghouse and n greenmount//SHILO///38m c/b rapid heart rate/<PROQA_DET>",
        "ID:34384",
        "ADDR:1308 CORLISS",
        "X:westinghouse and n greenmount",
        "CITY:SHILOH",
        "CALL:38m c/b rapid heart rate");
    
    doTest("T5",
        "[- part 1 of 1]  RC:Run# 34620/13 LOISEL DR///SCC PG 14/EAST SAINT LOUIS///70 M C/B CONFUSED ProQA comments: UNK/31D03",
        "ID:34620",
        "ADDR:13 LOISEL DR",
        "MAP:14",
        "CITY:EAST SAINT LOUIS",
        "CALL:70 M C/B CONFUSED");
    
    doTest("T6",
        "(- part 1 of 1) RC:Run# 35456/STATE HWY 157 & STATE HWY 15//Centerville/SCC PG 13/EAST SAINT LOUIS///pedestian struck/<PROQA_DET>",
        "ID:35456",
        "ADDR:STATE HWY 157 & STATE HWY 15",
        "MADDR:STATE 157 & STATE 15",
        "PLACE:Centerville",
        "MAP:13",
        "CITY:EAST SAINT LOUIS",
        "CALL:pedestian struck");

    doTest("T7",
        "1 of 2\nFRM:emsdispatch@medstarems.net\nSUBJ:- part 1 of 1\nMSG:RC:Run# 17158/St Elizabeths B'vll/IN PATIENT/347-2/SCC PG26/BELLEVILLE/429 S MAIN\n(Con't) 2 of 2\nST//CONFUSED POSS COMBATIVE NSE PCS AND FACESHEET REQ ***MEDICARE****\n(End)",
        "ID:17158",
        "ADDR:St Elizabeths B'vll",
        "PLACE:IN PATIENT",
        "APT:347-2",
        "MAP:26",
        "CITY:BELLEVILLE",
        "CALL:429 S MAIN ST",
        "INFO:CONFUSED POSS COMBATIVE NSE PCS AND FACESHEET REQ ***MEDICARE****");

    doTest("T8",
        "RC:Run# 17411/451 3RD ST////BECKEMEYER///ST ANTHONY'S CHURCH  75YOM UNC/BREATHING NURSE ON SCENE ProQA comme",
        "ID:17411",
        "ADDR:451 3RD ST",
        "CITY:BECKEMEYER",
        "CALL:ST ANTHONY'S CHURCH  75YOM UNC",
        "INFO:BREATHING NURSE ON SCENE ProQA comme");
   
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[- part 1 of 1] RC:Run# 23121/ATRIUM HEALTHCARE & REHAB//ROOM 2-3/SCC PG 23/CAHOKIA///Psychiatric/Suicide Attempt/40 YOF C/B PYSCH HX DID NOT RESPOND TO HALDAL/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23121",
        "ADDR:ATRIUM HEALTHCARE & REHAB",
        "APT:ROOM 2-3",
        "MAP:23",
        "CITY:CAHOKIA",
        "CALL:Psychiatric/Suicide Attempt",
        "INFO:40 YOF C / B PYSCH HX DID NOT RESPOND TO HALDAL");

    doTest("T2",
        "[- part 1 of 1] RC:Run# 23123/64 EAST BOUND AT 25TH ST////EAST SAINT LOUIS///Traffic Accidents/F PT C/B ROCK WENT THROUGH WINDOW/ GLASS IN MOUTH/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23123",
        "ADDR:64 EAST BOUND AT 25TH ST",
        "CITY:EAST SAINT LOUIS",
        "CALL:Traffic Accidents",
        "INFO:F PT C / B ROCK WENT THROUGH WINDOW /  GLASS IN MOUTH");

    doTest("T3",
        "[- part 1 of 1] RC:Run# 23124/502 S 17TH ST///SCC PG 26/BELLEVILLE///Psychiatric/Suicide Attempt/50 YOM C/B TOOK HANDFUL OF VICODEN PD ON SCENE/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23124",
        "ADDR:502 S 17TH ST",
        "MAP:26",
        "CITY:BELLEVILLE",
        "CALL:Psychiatric/Suicide Attempt",
        "INFO:50 YOM C / B TOOK HANDFUL OF VICODEN PD ON SCENE");

    doTest("T4",
        "[- part 1 of 1] RC:Run# 23124/502 S 17TH ST///SCC PG 26/BELLEVILLE///Psychiatric/Suicide Attempt/50 YOM C/B TOOK HANDFUL OF VICODEN PD ON SCENE/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23124",
        "ADDR:502 S 17TH ST",
        "MAP:26",
        "CITY:BELLEVILLE",
        "CALL:Psychiatric/Suicide Attempt",
        "INFO:50 YOM C / B TOOK HANDFUL OF VICODEN PD ON SCENE");

    doTest("T5",
        "[- part 1 of 1] RC:Run# 23126/1307 POTOMAC DR///SCC PG 27/BELLEVILLE///Breathing Problems/22 YOF PT C/SOB POSS ETOH/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23126",
        "ADDR:1307 POTOMAC DR",
        "MAP:27",
        "CITY:BELLEVILLE",
        "CALL:Breathing Problems",
        "INFO:22 YOF PT C / SOB POSS ETOH");

    doTest("T6",
        "[- part 1 of 1] RC:Run# 23127/Red Bud Regional Hosp/ER DEPT/5//RED BUD/Touchette Reg Hosp/IN PATIENT//38 YOM C/B PSYCH EVAL/ SUICIDAL/ NSE/ PCS AND FACE SHEET REQUESTED/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23127",
        "ADDR:Red Bud Regional Hosp",
        "APT:5",
        "PLACE:ER DEPT",
        "CITY:RED BUD",
        "CALL:Touchette Reg Hosp",
        "INFO:IN PATIENT / 38 YOM C / B PSYCH EVAL /  SUICIDAL /  NSE /  PCS AND FACE SHEET REQUESTED");

    doTest("T7",
        "[- part 1 of 1] RC:Run# 23128/S 27TH ST & TRENDLEY AVE///SCC PG 12/EAST SAINT LOUIS///Unknown Problem (Man Down)/f subj slump over the wheel been there for more than an hour/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23128",
        "ADDR:S 27TH ST & TRENDLEY AVE",
        "MAP:12",
        "CITY:EAST SAINT LOUIS",
        "CALL:Unknown Problem (Man Down)",
        "INFO:f subj slump over the wheel been there for more than an hour");

    doTest("T8",
        "[- part 1 of 1] RC:Run# 23129/Cedar Ridge//E-13-B/SCC PG 18/LEBANON///Transfer/Interfacility/Palliative Care/79YOF C/DIFF BREATHING ELEVATED B/P CODE LEVEL FULL/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23129",
        "ADDR:Cedar Ridge",
        "PLACE:E-13-B",
        "MAP:18",
        "CITY:LEBANON",
        "CALL:Transfer",
        "INFO:Interfacility / Palliative Care / 79YOF C / DIFF BREATHING ELEVATED B / P CODE LEVEL FULL");

    doTest("T9",
        "[- part 1 of 1] RC:Run# 23130/PD BELLEVILLE///SCC PG 26/BELLEVILLE///Assault/Rape/20YOM C/B FACIAL INJURIES FROM 10-1O/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23130",
        "ADDR:PD BELLEVILLE",
        "MAP:26",
        "CITY:BELLEVILLE",
        "CALL:Assault/Rape",
        "INFO:20YOM C / B FACIAL INJURIES FROM 10-1O");

    doTest("T10",
        "[- part 1 of 1] RC:Run# 23131/S 13TH ST & TUDOR AVE///SCC PG 12/EAST SAINT LOUIS///Traffic Accidents/10-50 ROLLOVER WITH ENTRAPMENT/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23131",
        "ADDR:S 13TH ST & TUDOR AVE",
        "MAP:12",
        "CITY:EAST SAINT LOUIS",
        "CALL:Traffic Accidents",
        "INFO:10-50 ROLLOVER WITH ENTRAPMENT");

    doTest("T11",
        "[- part 1 of 1] RC:Run# 23132/3117 W BLVD////BELLEVILLE///Falls/Back Injuries (Traumatic)/PD ON SCENE 23 YOM C/B FELL DOWN STAIRS/ UNK INJ/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23132",
        "ADDR:3117 W BLVD",
        "CITY:BELLEVILLE",
        "CALL:Falls/Back Injuries (Traumatic)",
        "INFO:PD ON SCENE 23 YOM C / B FELL DOWN STAIRS /  UNK INJ");

    doTest("T12",
        "[- part 1 of 1] RC:Run# 23134/Charles Gardens//ROOM 14/SCC PG 15/FAIRVIEW HEIGHTS///Hemorrhage/Lacerations/83 YOM C/B RECTAL BLEED/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23134",
        "ADDR:Charles Gardens",
        "APT:ROOM 14",
        "MAP:15",
        "CITY:FAIRVIEW HEIGHTS",
        "CALL:Hemorrhage/Lacerations",
        "INFO:83 YOM C / B RECTAL BLEED");

    doTest("T13",
        "[- part 1 of 1] RC:Run# 23135/631 N 85TH ST///SCC PG 14/EAST SAINT LOUIS///Assault/Rape/28YOF C/B ASSAULTED PD 10-76 SUBJ STRUCK IN THE HEAD/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23135",
        "ADDR:631 N 85TH ST",
        "MAP:14",
        "CITY:EAST SAINT LOUIS",
        "CALL:Assault/Rape",
        "INFO:28YOF C / B ASSAULTED PD 10-76 SUBJ STRUCK IN THE HEAD");

    doTest("T14",
        "[- part 1 of 1] RC:Run# 23136/804 N 33RD ST///SCC PG 3/EAST SAINT LOUIS///Sick Person (Specific Diagnosis)/47YOM C/B UNABLE TO GET UP/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23136",
        "ADDR:804 N 33RD ST",
        "MAP:3",
        "CITY:EAST SAINT LOUIS",
        "CALL:Sick Person (Specific Diagnosis)",
        "INFO:47YOM C / B UNABLE TO GET UP");

    doTest("T15",
        "[- part 1 of 1] RC:Run# 23137/BELLEVILLE HEALTHCARE AND REHAB//404-2/SCC PG 26/BELLEVILLE///Transfer/Interfacility/Palliative Care/90YOF UNRESPONSIVE/B UNK PROBLEM CODE LEVELFULL/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23137",
        "ADDR:BELLEVILLE HEALTHCARE AND REHAB",
        "MADDR:BELLEVILLE HEALTHCARE & REHAB",
        "APT:404-2",
        "MAP:26",
        "CITY:BELLEVILLE",
        "CALL:Transfer",
        "INFO:Interfacility / Palliative Care / 90YOF UNRESPONSIVE / B UNK PROBLEM CODE LEVELFULL");

    doTest("T16",
        "[- part 1 of 1] RC:Run# 23138/324 N JACKSON ST///SCC PG 26/BELLEVILLE///Unconscious/Fainting (Non-traumatic)/22YOF UNC/B UNK PROBLEM PD 10-76/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23138",
        "ADDR:324 N JACKSON ST",
        "MAP:26",
        "CITY:BELLEVILLE",
        "CALL:Unconscious/Fainting (Non-traumatic)",
        "INFO:22YOF UNC / B UNK PROBLEM PD 10-76");

    doTest("T17",
        "[- part 1 of 1] RC:Run# 23139/N 21ST ST & SAINT CLAIR AVE///SCC PG 2/EAST SAINT LOUIS///Traumatic Injuries (Specific)/PD 10-23 WINDOWS BUSTED OUT GLASS HIT BABY/<PROQA_DET>\r\n" +
        "\r\n\n",

        "ID:23139",
        "ADDR:N 21ST ST & SAINT CLAIR AVE",
        "MAP:2",
        "CITY:EAST SAINT LOUIS",
        "CALL:Traumatic Injuries (Specific)",
        "INFO:PD 10-23 WINDOWS BUSTED OUT GLASS HIT BABY");

  }
  
  public static void main(String[] args) {
    new ILMedstarParserTest().generateTests("T1");
  }
}