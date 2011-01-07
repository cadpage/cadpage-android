package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDSaintMarysCountyParserTest extends BaseParserTest {
  
  public MDSaintMarysCountyParserTest() {
    setParser(new MDSaintMarysCountyParser(), "SAINT MARYS COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "21:10:05*Personal Injury Accident*22607 THREE NOTCH RD INTERSECTN*MACARTHUR BL*LEXINGTON PARK*CO9 CO3 SQ3 CO39 CO79 A796*N/B LANES TWO VEHICLES AT LEAST ONE INJURY*",
        "CALL:Personal Injury Accident",
        "ADDR:22607 THREE NOTCH RD & MACARTHUR BL",
        "CITY:LEXINGTON PARK",
        "UNIT:CO9 CO3 SQ3 CO39 CO79 A796",
        "INFO:N/B LANES TWO VEHICLES AT LEAST ONE INJURY");
    
    doTest("T2",
        "14:41:22*Personal Injury Accident*21050 WILLOWS RD INTERSECTN*ABBERLY CREST LN*LEXINGTON PARK*CO3 CO39 CO6R*",
        "CALL:Personal Injury Accident",
        "ADDR:21050 WILLOWS RD & ABBERLY CREST LN",
        "CITY:LEXINGTON PARK",
        "UNIT:CO3 CO39 CO6R");
    
    doTest("T3",
        "15:24:31*Working House Fire*20242 POINT LOOKOUT RD*OLD GREAT MILLS RD*INDIAN BRIDGE RD*GREAT MILLS*CO3 CO9 CO6 CO1 CO5 CO39 CO6R*",
        "CALL:Working House Fire",
        "ADDR:20242 POINT LOOKOUT RD",
        "X:OLD GREAT MILLS RD / INDIAN BRIDGE RD",
        "CITY:GREAT MILLS",
        "UNIT:CO3 CO9 CO6 CO1 CO5 CO39 CO6R");

    doTest("T4",
        "21:11:30*Commercial Building Fire*46528 VALLEY CT APT3019*SPRING VALLEY DR*DEAD END*LEXINGTON PARK*CO3 CO13 CO9 TK3 CO7 TK7 CO39*Using ProQA re*",
        "CALL:Commercial Building Fire",
        "ADDR:46528 VALLEY CT",
        "APT:APT3019",
        "X:SPRING VALLEY DR / DEAD END",
        "CITY:LEXINGTON PARK",
        "UNIT:CO3 CO13 CO9 TK3 CO7 TK7 CO39",
        "INFO:Using ProQA re");
    
    doTest("T5",
        "23:14:28*Heart Problems*22521 IVERSON DR UNIT3*AMBER DR*CUL DE SAC*CALIFORNIA*CO9*55YOF C/A/B; RAPID HEART RATE AND WEAK; HX DIABETES;*",
        "CALL:Heart Problems",
        "ADDR:22521 IVERSON DR",
        "APT:UNIT3",
        "X:AMBER DR / CUL DE SAC",
        "CITY:CALIFORNIA",
        "UNIT:CO9",
        "INFO:55YOF C/A/B; RAPID HEART RATE AND WEAK; HX DIABETES;");
    
    doTest("T6",
        "((37593) CAD ) 22:12:45*CO Detector With Symptons*21353 FOXGLOVE CT*DEAD END*BAYWOODS RD*HERMANVILLE*CO3 CO39*Using ProQA Fire*",
        "CALL:CO Detector With Symptons",
        "ADDR:21353 FOXGLOVE CT",
        "X:DEAD END / BAYWOODS RD",
        "CITY:HERMANVILLE",
        "UNIT:CO3 CO39",
        "INFO:Using ProQA Fire");
        

    doTest("T10",
        "((46589) CAD) 14:02:26*Stroke**APT A2**22027 OXFORD CT APTA2*GLOUCESTER CT*DEAD END*LEXINGTON PARK*CO39*Using ProQA Medical*",
        "CALL:Stroke",
        "PLACE:APT A2",
        "ADDR:22027 OXFORD CT",
        "APT:APTA2",
        "X:GLOUCESTER CT / DEAD END",
        "CITY:LEXINGTON PARK",
        "UNIT:CO39",
        "INFO:Using ProQA Medical");
    
    doTest("T11",
        "((46677) CAD) 13:59:56*Chest Pain*40452 MEDLEYS LN*LAUREL GROVE RD*LOVEVILLE RD*OAKVILLE*CO79 ALS*subject has pacemaker*",
        "CALL:Chest Pain",
        "ADDR:40452 MEDLEYS LN",
        "X:LAUREL GROVE RD / LOVEVILLE RD",
        "CITY:OAKVILLE",
        "UNIT:CO79 ALS",
        "INFO:subject has pacemaker");
    
    doTest("T12",
        "((46589) CAD) 13:29:15*Breathing Difficulties**ST MARYS NURSING CENTER**21585 PEABODY ST RM441A*HOLLYWOOD RD*DEAD END*LEONARDTOWN*CO19 CO79 ALS*hx copd*",
        "CALL:Breathing Difficulties",
        "PLACE:ST MARYS NURSING CENTER",
        "ADDR:21585 PEABODY ST",
        "APT:RM441A",
        "X:HOLLYWOOD RD / DEAD END",
        "CITY:LEONARDTOWN",
        "UNIT:CO19 CO79 ALS",
        "INFO:hx copd");
    
    doTest("T13",
        "((46589) CAD) 12:47:33*Chest Pain*17498 GRAYSON RD*BEACHVILLE RD*VILLA RD*ST INIGOES*CO49R ALS*Using ProQA Medical*",
        "CALL:Chest Pain",
        "ADDR:17498 GRAYSON RD",
        "X:BEACHVILLE RD / VILLA RD",
        "CITY:ST INIGOES",
        "UNIT:CO49R ALS",
        "INFO:Using ProQA Medical");
    
    doTest("T14",
        "((46589) CAD) 12:14:40*Sick Person**NEWTOWNE VILLAGE APTS**22810 DORSEY ST APT309*CONNELY CT*DEAD END*LEONARDTOWN*CO19 CO79 A799*Using ProQA Medical*",
        "CALL:Sick Person",
        "PLACE:NEWTOWNE VILLAGE APTS",
        "ADDR:22810 DORSEY ST",
        "APT:APT309",
        "X:CONNELY CT / DEAD END",
        "CITY:LEONARDTOWN",
        "UNIT:CO19 CO79 A799",
        "INFO:Using ProQA Medical");
    
    doTest("T15",
        "((46589) CAD) 12:08:40*Sick Person*46104 SALTMARSH CT*WEST WESTBURY BL*DEAD END*LEXINGTON PARK*CO39 A397*Using ProQA Medical*",
        "CALL:Sick Person",
        "ADDR:46104 SALTMARSH CT",
        "X:WEST WESTBURY BL / DEAD END",
        "CITY:LEXINGTON PARK",
        "UNIT:CO39 A397",
        "INFO:Using ProQA Medical");

    doTest("T16",
        "((47017) CAD ) 21:24:45*Seizures/Convulsions*THREE OAK CENTER*46905 LEI DR*THREE NOTCH RD*SOUTH CORAL DR*LEXINGTON PARK*ALS CO39*Using ProQA",
        "CALL:Seizures/Convulsions",
        "PLACE:THREE OAK CENTER",
        "ADDR:46905 LEI DR",
        "X:THREE NOTCH RD / SOUTH CORAL DR",
        "CITY:LEXINGTON PARK",
        "UNIT:ALS CO39",
        "INFO:Using ProQA");
    
        
  }
}