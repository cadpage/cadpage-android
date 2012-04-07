package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAErieCountyEmergyCareParserTest;

import org.junit.Test;


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
        "MADDR:TANGLEWOOD APTS,VA Out of Town",
        "PLACE:TANGLEWOOD APTS",
        "CITY:16504",
        "INFO:101 - BUILDING 819 / VA MEDICAL CTR UNIVERSITY CAMPUS / NU / OWN CH / BILL VA / MCGUIRE WILL DO / COCCARELLI / ALBERT / X=UNNAMED|WAYNE&WAYNE");

    doTest("T4",
        "Run# 17968/ 0045-A/ 09:30/ BLS/ Priority 3 / Local/ TWINBROOK MEDICAL CENTER/ 16511/ east 212/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ wound clinic for md meritz/ med nec for crew/ ms pt sacreal wounds nsa/ LAST NAME/ FIRST NAME/ X=PRIESTLEY&NAPIER",
        "ID:17968",
        "TIME:09:30",
        "CALL:BLS",
        "PRI:3",
        "ADDR:Local",
        "MADDR:TWINBROOK MEDICAL CENTER,Local",
        "PLACE:TWINBROOK MEDICAL CENTER",
        "CITY:16511",
        "INFO:east 212 / UPMC HAMOT MEDICAL CENTER / wound clinic for md meritz / med nec for crew / ms pt sacreal wounds nsa / LAST NAME / FIRST NAME / X=PRIESTLEY&NAPIER");
   
  }
  
  public static void main(String[] args) {
    new PAErieCountyEmergyCareParserTest().generateTests("T1");
  }
}