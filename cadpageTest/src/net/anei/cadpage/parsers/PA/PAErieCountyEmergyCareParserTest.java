package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAErieCountyEmergyCareParserTest;

import org.junit.Test;

/*
EnergyCare (Erie County, PA)
Contact: "Thomas, George" <gthomas@emergycare.org>
System: Zoll RescueNet

Run# 17973/ 0087-A/ 08:55/ ALS/ Priority 1/ E 20TH ST & MCCLELLAND AVE/ 16510/ GREY PICKUP TRUCK/ ON 20TH/ W OF MCCLELLAND/ <PROQA_DET>/ MALE IN PICKUP PARKED ON SIDE OF ROAD SLUMPED OVER OFF TO THE SIDE UNK. EMD: 31D0/ ECDOPS: 2012-35555/ <Unknown>/ X=Buffalo Rd&E 20th St
Run# 17958/ 0081-A/ 08:17/ BLS/ Priority 1/ 2416 STATE ST/ 16503/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ BLS P1; 52 year old/ Female/ Unconscious/ Breathing. Convulsions /Seizures. Not seizing now and breathing effectively (verified) (Epileptic or Previous history of seizures). EMD: 12A1E/ ECDOPS: 2012-35545/ <Unknown>/ X=E 26th St&W 24th St
Run# 17945/ 0030-A/ 07:30/ Medical Taxi/ Priority 4 / VA Out of Town/ TANGLEWOOD APTS/ 16504/ 101 - BUILDING 819/ <PROQA_DET>/ VA MEDICAL CTR UNIVERSITY CAMPUS/ NU/ OWN CH/BILL VA/MCGUIRE WILL DO/ COCCARELLI/ ALBERT/ X=UNNAMED|WAYNE&WAYNE
Run# 17968/ 0045-A/ 09:30/ BLS/ Priority 3 / Local/ TWINBROOK MEDICAL CENTER/ 16511/ east 212/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ wound clinic for md meritz/ med nec for crew/ ms pt sacreal wounds nsa/ LAST NAME/ FIRST NAME/ X=PRIESTLEY&NAPIER
Run# 19857/ 0095-A/ 10:51/ BLS/ Priority 1/ 531 E 12TH ST/ 16503/ DOWNSTAIRS/ <PROQA_DET>/ SAINT VINCENT HEALTH CENTER/ BLS P1; 21 year old/ Male/ Conscious/ Breathing. Hemorrhage/ Lacerations. SERIOUS hemorrhage. EMD: 21B2/ ECDOPS: 2012-39719/ <Unknown>/ X=Wallace St&Ash St
Run# 19859/ 0096-A/ 10:58/ Paramedic Intercept/ Priority 1/ 10906 LAKE RD/ 16428/ <PROQA_DET>/ DISORIENTED PERSON/ ASSIST CRESCENT/ <Unknown>/ X=N Mill St
Run# 19866/ 0100-A/ 11:20/ BLS/ Priority 2/ 2912 COCHRAN ST/ 16508/ STAGE AWAY/ <PROQA_DET>/ BLS P1 / LAW; 40 year old/ Female/ Conscious/ Breathing. Psychiatric / AbnormalBehavior / Suicide Attempt. Non-SERIOUS or MINOR hemorrhage (Violent). EMD: 25B2V/ ECDOPS: 2012-39726/ <Unknown>/ X=W 31st St&W 29th St
Run# 19872/ 0104-A/ 11:44/ BLS W/ALS ASSIST/ Priority 1/ 1042 E 11TH ST/ 16503/ WITH ENGINE 8/ <PROQA_DET>/ BLS P1 / ALS P1; 38 year old/ Male/ Conscious/ Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1/ ECDOPS: 2012-39737/ <Unknown>/ X=Pennsylvania Ave&Brewster St
Run# 19860/ 0098-A/ 11:01/ ALS/ Priority 1/ DIALYSIS CENTER OF ERIE/ 16502/ LOBBY/ <PROQA_DET>/ BLS P1 / ALS P1; 71 year old/ Female/ Conscious/ Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1/ ECDOPS: 2012-39721/ <Unknown>/ X=17TH&16TH
Run# 19861/ 0099-A/ 11:07/ BLS/ Priority 1/ GRANDVIEW MANOR/ 16504/ 122/ <PROQA_DET>/ BLS PRIORITY 1; 92 year old/ Female/ Consciousness unknown/ Breathing status unknown. Unknown Problem (Man Down). EMD: 32B2/ ECDOPS: 2012-39722/ <Unknown>/ X=UNNAMED|UNNAMED&UNNAMED
Run# 19839/ 0044-B/ 09:41/ BLS/ Priority 3 / Local/ UPMC HAMOT MEDICAL CENTER/ 16550/ WOUND CLINIC/ <PROQA_DET>/ TWINBROOK MEDICAL CENTER/ NO SPEC ATTN/CREW TO GET MED NEC/HUTCHINSON/ CHARLES/ X=2ND&DOBBINS LANDING

Contact: Matt Fuller <mfullererie@gmail.com>
Sender: EC-COMM@emergycare.org
(- part 1 of 1) RC:Run# 23232/0160-A/16:30/ALS-V/Priority 3 / Local/UPMC HAMOT MEDICAL CENTER/16550/ICU SOUTH BED 14/<PROQA_DET>/PRESQUE ISLE REHAB AND NURSI

 */

public class PAErieCountyEmergyCareParserTest extends BaseParserTest {
  
  public PAErieCountyEmergyCareParserTest() {
    setParser(new PAErieCountyEmergyCareParser(), "ERIE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Run# 17973/ 0087-A/ 08:55/ ALS/ Priority 1/ E 20TH ST & MCCLELLAND AVE/ 16510/ GREY PICKUP TRUCK/ ON 20TH/ W OF MCCLELLAND/ <PROQA_DET>/ MALE IN PICKUP PARKED ON SIDE OF ROAD SLUMPED OVER OFF TO THE SIDE UNK. EMD: 31D0/ ECDOPS: 2012-35555/ <Unknown>/ X=Buffalo Rd&E 20th St",
        "ID:17973",
        "TIME:08:55",
        "CALL:ALS",
        "PRI:1",
        "ADDR:E 20TH ST & MCCLELLAND AVE",
        "CITY:16510",
        "INFO:GREY PICKUP TRUCK / ON 20TH / W OF MCCLELLAND / MALE IN PICKUP PARKED ON SIDE OF ROAD SLUMPED OVER OFF TO THE SIDE UNK. EMD: 31D0 / ECDOPS: 2012-35555 / <Unknown> / X=Buffalo Rd&E 20th St");

    doTest("T2",
        "Run# 17958/ 0081-A/ 08:17/ BLS/ Priority 1/ 2416 STATE ST/ 16503/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ BLS P1; 52 year old/ Female/ Unconscious/ Breathing. Convulsions /Seizures. Not seizing now and breathing effectively (verified) (Epileptic or Previous history of seizures). EMD: 12A1E/ ECDOPS: 2012-35545/ <Unknown>/ X=E 26th St&W 24th St",
        "ID:17958",
        "TIME:08:17",
        "CALL:BLS",
        "PRI:1",
        "ADDR:2416 STATE ST",
        "CITY:16503",
        "INFO:UPMC HAMOT MEDICAL CENTER / BLS P1; 52 year old / Female / Unconscious / Breathing. Convulsions / Seizures. Not seizing now and breathing effectively (verified) (Epileptic or Previous history of seizures). EMD: 12A1E / ECDOPS: 2012-35545 / <Unknown> / X=E 26th St&W 24th St");

    doTest("T3",
        "Run# 17945/ 0030-A/ 07:30/ Medical Taxi/ Priority 4 / VA Out of Town/ TANGLEWOOD APTS/ 16504/ 101 - BUILDING 819/ <PROQA_DET>/ VA MEDICAL CTR UNIVERSITY CAMPUS/ NU/ OWN CH/BILL VA/MCGUIRE WILL DO/ COCCARELLI/ ALBERT/ X=UNNAMED|WAYNE&WAYNE",
        "ID:17945",
        "TIME:07:30",
        "CALL:Medical Taxi",
        "PRI:4",
        "ADDR:VA Out of Town",
        "PLACE:TANGLEWOOD APTS",
        "CITY:16504",
        "INFO:101 - BUILDING 819 / VA MEDICAL CTR UNIVERSITY CAMPUS / NU / OWN CH / BILL VA / MCGUIRE WILL DO / COCCARELLI / ALBERT / X=UNNAMED|WAYNE&WAYNE");

    doTest("T4",
        "Run# 17968/ 0045-A/ 09:30/ BLS/ Priority 3 / Local/ TWINBROOK MEDICAL CENTER/ 16511/ east 212/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ wound clinic for md meritz/ med nec for crew/ ms pt sacreal wounds nsa/ LAST NAME/ FIRST NAME/ X=PRIESTLEY&NAPIER",
        "ID:17968",
        "TIME:09:30",
        "CALL:BLS",
        "PRI:3",
        "ADDR:TWINBROOK MEDICAL CENTER",
        "CITY:16511",
        "INFO:east 212 / UPMC HAMOT MEDICAL CENTER / wound clinic for md meritz / med nec for crew / ms pt sacreal wounds nsa / LAST NAME / FIRST NAME / X=PRIESTLEY&NAPIER");

    doTest("T5",
        "Run# 19857/ 0095-A/ 10:51/ BLS/ Priority 1/ 531 E 12TH ST/ 16503/ DOWNSTAIRS/ <PROQA_DET>/ SAINT VINCENT HEALTH CENTER/ BLS P1; 21 year old/ Male/ Conscious/ Breathing. Hemorrhage/ Lacerations. SERIOUS hemorrhage. EMD: 21B2/ ECDOPS: 2012-39719/ <Unknown>/ X=Wallace St&Ash St",
        "ID:19857",
        "TIME:10:51",
        "CALL:BLS",
        "PRI:1",
        "ADDR:531 E 12TH ST",
        "CITY:16503",
        "INFO:DOWNSTAIRS / SAINT VINCENT HEALTH CENTER / BLS P1; 21 year old / Male / Conscious / Breathing. Hemorrhage / Lacerations. SERIOUS hemorrhage. EMD: 21B2 / ECDOPS: 2012-39719 / <Unknown> / X=Wallace St&Ash St");

    doTest("T6",
        "Run# 19859/ 0096-A/ 10:58/ Paramedic Intercept/ Priority 1/ 10906 LAKE RD/ 16428/ <PROQA_DET>/ DISORIENTED PERSON/ ASSIST CRESCENT/ <Unknown>/ X=N Mill St",
        "ID:19859",
        "TIME:10:58",
        "CALL:Paramedic Intercept",
        "PRI:1",
        "ADDR:10906 LAKE RD",
        "CITY:16428",
        "INFO:DISORIENTED PERSON / ASSIST CRESCENT / <Unknown> / X=N Mill St");

    doTest("T7",
        "Run# 19866/ 0100-A/ 11:20/ BLS/ Priority 2/ 2912 COCHRAN ST/ 16508/ STAGE AWAY/ <PROQA_DET>/ BLS P1 / LAW; 40 year old/ Female/ Conscious/ Breathing. Psychiatric / AbnormalBehavior / Suicide Attempt. Non-SERIOUS or MINOR hemorrhage (Violent). EMD: 25B2V/ ECDOPS: 2012-39726/ <Unknown>/ X=W 31st St&W 29th St",
        "ID:19866",
        "TIME:11:20",
        "CALL:BLS",
        "PRI:2",
        "ADDR:2912 COCHRAN ST",
        "CITY:16508",
        "INFO:STAGE AWAY / BLS P1 / LAW; 40 year old / Female / Conscious / Breathing. Psychiatric / AbnormalBehavior / Suicide Attempt. Non-SERIOUS or MINOR hemorrhage (Violent). EMD: 25B2V / ECDOPS: 2012-39726 / <Unknown> / X=W 31st St&W 29th St");

    doTest("T8",
        "Run# 19872/ 0104-A/ 11:44/ BLS W/ALS ASSIST/ Priority 1/ 1042 E 11TH ST/ 16503/ WITH ENGINE 8/ <PROQA_DET>/ BLS P1 / ALS P1; 38 year old/ Male/ Conscious/ Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1/ ECDOPS: 2012-39737/ <Unknown>/ X=Pennsylvania Ave&Brewster St",
        "ID:19872",
        "TIME:11:44",
        "CALL:BLS W / ALS ASSIST",
        "PRI:1",
        "ADDR:1042 E 11TH ST",
        "CITY:16503",
        "INFO:WITH ENGINE 8 / BLS P1 / ALS P1; 38 year old / Male / Conscious / Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1 / ECDOPS: 2012-39737 / <Unknown> / X=Pennsylvania Ave&Brewster St");

    doTest("T9",
        "Run# 19860/ 0098-A/ 11:01/ ALS/ Priority 1/ DIALYSIS CENTER OF ERIE/ 16502/ LOBBY/ <PROQA_DET>/ BLS P1 / ALS P1; 71 year old/ Female/ Conscious/ Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1/ ECDOPS: 2012-39721/ <Unknown>/ X=17TH&16TH",
        "ID:19860",
        "TIME:11:01",
        "CALL:ALS",
        "PRI:1",
        "ADDR:DIALYSIS CENTER OF ERIE",
        "CITY:16502",
        "INFO:LOBBY / BLS P1 / ALS P1; 71 year old / Female / Conscious / Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. EMD: 10C1 / ECDOPS: 2012-39721 / <Unknown> / X=17TH&16TH");

    doTest("T10",
        "Run# 19861/ 0099-A/ 11:07/ BLS/ Priority 1/ GRANDVIEW MANOR/ 16504/ 122/ <PROQA_DET>/ BLS PRIORITY 1; 92 year old/ Female/ Consciousness unknown/ Breathing status unknown. Unknown Problem (Man Down). EMD: 32B2/ ECDOPS: 2012-39722/ <Unknown>/ X=UNNAMED|UNNAMED&UNNAMED",
        "ID:19861",
        "TIME:11:07",
        "CALL:BLS",
        "PRI:1",
        "ADDR:GRANDVIEW MANOR",
        "CITY:16504",
        "INFO:122 / BLS PRIORITY 1; 92 year old / Female / Consciousness unknown / Breathing status unknown. Unknown Problem (Man Down). EMD: 32B2 / ECDOPS: 2012-39722 / <Unknown> / X=UNNAMED|UNNAMED&UNNAMED");

    doTest("T11",
        "Run# 19839/ 0044-B/ 09:41/ BLS/ Priority 3 / Local/ UPMC HAMOT MEDICAL CENTER/ 16550/ WOUND CLINIC/ <PROQA_DET>/ TWINBROOK MEDICAL CENTER/ NO SPEC ATTN/CREW TO GET MED NEC/HUTCHINSON/ CHARLES/ X=2ND&DOBBINS LANDING",
        "ID:19839",
        "TIME:09:41",
        "CALL:BLS",
        "PRI:3",
        "ADDR:UPMC HAMOT MEDICAL CENTER",
        "CITY:16550",
        "INFO:WOUND CLINIC / TWINBROOK MEDICAL CENTER / NO SPEC ATTN / CREW TO GET MED NEC / HUTCHINSON / CHARLES / X=2ND&DOBBINS LANDING");

    doTest("T12",
        "(- part 1 of 1) RC:Run# 23232/0160-A/16:30/ALS-V/Priority 3 / Local/UPMC HAMOT MEDICAL CENTER/16550/ICU SOUTH BED 14/<PROQA_DET>/PRESQUE ISLE REHAB AND NURSI",
        "ID:23232",
        "TIME:16:30",
        "CALL:ALS-V",
        "PRI:3",
        "ADDR:UPMC HAMOT MEDICAL CENTER",
        "CITY:16550",
        "INFO:ICU SOUTH BED 14 / PRESQUE ISLE REHAB AND NURSI");
  
  }
  
  public static void main(String[] args) {
    new PAErieCountyEmergyCareParserTest().generateTests("T5");
  }
}