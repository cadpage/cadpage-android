package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Warren County, OH
Contact: Active911
Agency name: Lebanon Fire Division
Location: Lebanon, OH, United States
Sender: dispatch@lebanonohio.gov

(FIRE CALL) Loc:943 CAMARGO XSt:GRANDSTONE COUR DEAD END Grid:0605 Units:E41 M41 Rmk:KEY PAD FIRE ALARM                                                                                                                                                                                                                                                                           
(SERVICE CALL) Loc:100 ARROW SPRINGS BLVD XSt:ST RT 48 DEAD END Grid:2905 Units:M41 Rmk:ON A DETAIL CUTTING OFF A RING AT ARROWSPRINGS                                                                                                                                                                                                                                            
(SERVICE CALL) Loc:17 SUMMIT XSt:MOUND CENTER Grid:0406 Units:B41 Rmk:ODOR INVESTIGATION                                                                                                                                                                                                                                                                                          
(FIRE CALL) Loc:452 E MULBERRY XSt:CHILICOTHE MOUND Grid:0403 Units:B41 E41 Rmk:C.O. ALRM ACTIVATION,,, NEW UNIT, COMPL IS UNSURE IF ITS AN ACTUAL ACTIVATION                                                                                                                                                                                                                     
(EMER MEDICAL) Loc:50 SHAKER RUN Apt:B XSt:SPRINGHOUSE CT MONROE Grid:0415 Units:M41 Rmk:84-85 O2 SAT                                                                                                                                                                                                                                                                             
(EMER MEDICAL) Loc:990 EAST RIDGE Apt:34 XSt:MONROE DEAD END Grid:1513 Units:M42 B41 E41 Rmk:61 YR OLD FEMALE INFECTION                                                                                                                                                                                                                                                           
(EMER MEDICAL) Loc:489 LA LUZ Apt:104 XSt:COLUMBUS DEAD END Grid:0411 Units:M41 B41 E41 Rmk:51 YR OLD FEMALE WITH ABDOMINAL PAIN                                                                                                                                                                                                                                                  
(EMER MEDICAL) Loc:7 MEADOW LN Apt:B XSt:BROADWAY PINE RIDGE Grid:0601 Units:M41 B41 E41 Rmk:MALE 85, TROUBLE BREATHING AND ABDOMENAL PAIN                                                                                                                                                                                                                                        
(EMER MEDICAL) Loc:923 NELSON LN Apt:A XSt:STUBBS MILL DEAD END Grid:0316 Units:M41 B41 E41 Rmk:FEMALE 75, PAIN IN CHEST, HISTORY OF HEART TROUBLE                                                                                                                                                                                                                                
(EMER MEDICAL) Loc:900 FRANKLIN Apt:7 XSt:CAMBRIDGE HART RD Grid:0112 Units:M41 Rmk:POSSIBLE OVERDOSE                                                                                                                                                                                                                                                                             
(EMER MEDICAL) Loc:115 OREGONIA XSt:MAIN CITY LIMIT Grid:0401 Units:M41 Rmk:TROUBLE BREATHING, FAMILY REQUESTING SQUAD                                                                                                                                                                                                                                                            
(FIRE CALL) Loc:1500 KINGSVIEW XSt:TURTLECREEK COLUMBIA Grid:5203 Units:B41 E41 M42 Rmk:ZONE 68, NW RISER                                                                                                                                                                                                                                                                         
(EMER MEDICAL) Loc:102 E SILVER XSt:MECHANIC CHERRY Grid:0101 Units:M41 B41 E41 Rmk:                                                                                                                                                                                                                                                                                              
(EMER MEDICAL) Loc:990 EAST RIDGE Apt:13 XSt:MONROE DEAD END Grid:1513 Units:M41 B41 E41 Rmk:51 YR OLD MALE                                                                                                                                                                                                                                                                       
(FIRE CALL) Loc:209 W MAIN XSt:WATER CLAY Grid:0102 Units:B41 E41 M41 Rmk:SMELL OF NATURAL GAS INSIDE BUILDING                                                                                                                                                                                                                                                                    
(FIRE CALL) Loc:800 FARVIEW XSt:CARSON DEAD END Grid:0114 Units:B41 E41 M41 E43 Rmk:SHED IN THE REAR ON FIRE                                                                                                                                                                                                                                                                      
(FIRE CALL) Loc:800 FARVIEW XSt:CARSON DEAD END Grid:0114 Units:B41 E41 M41 Rmk:SHED IN THE REAR ON FIRE                                                                                                                                                                                                                                                                          
(EMER MEDICAL) Loc:441 AUTUMNWIND DR XSt:COUNTRYSIDE DR BROOK WAY Grid:1111 Units:M41 Rmk:MALE SUBJ DOWN                                                                                                                                                                                                                                                                          
(EMER MEDICAL) Loc:990 EAST RIDGE Apt:10 XSt:MONROE DEAD END Grid:1513 Units:M41 Rmk:POSSIBLE BROKEN HAND                                                                                                                                                                                                                                                                         
(EMER MEDICAL) Loc:1048 HUNTERS RUN Apt:12 XSt:PHEASANT RUN TAMARACK CT Grid:0501 Units:M42 B41 E41 Rmk:FEMALE NEEDS EVAL                                                                                                                                                                                                                                                         
(EMER MEDICAL) Loc:211 E ORCHARD Apt:2 XSt:DEERFIELD EAST Grid:0312 Units:M41 B41 E41 Rmk:CHEST PAINS                                                                                                                                                                                                                                                                             
(MUTUAL AID) Loc:20 W SILVER XSt:BROADWAY SYCAMORE Grid:0101 Units:L41 Rmk:L41 TO APPLIANCE FIRE, 1575 OLD ST RT 122, TAC 2                                                                                                                                                                                                                                                       
(EMER MEDICAL) Loc:1275 CATALPA RIDGE DR XSt:LANCE CT DEAD END Grid:1209 Units:M42 B41 E41 Rmk:FEMALE 84, RPTS PAIN UNDER LEFT ARE AND LEFT BREAST                                                                                                                                                                                                                                
(EMER MEDICAL) Loc:305 LAWNDALE XSt:BROOKSIDE CARSON Grid:0602 Units:M41 B41 E41 M42 Rmk:3RD PARTY, MEDICAL ALERT CALL::                                                                                                                                                                                                                                                          
(EMER MEDICAL) Loc:305 LAWNDALE XSt:BROOKSIDE CARSON Grid:0602 Units:M41 B41 E41 Rmk:3RD PARTY, MEDICAL ALERT CALL::                                                                                                                                                                                                                                                              
(EMER MEDICAL) Loc:935 BROOKSIDE XSt:LAWNDALE DEAD END Grid:0602 Units:M42 B41 E41 Rmk:FEMALE 30, CP,, NEEDING TRANSPORT, PT HAS NO ONE TO CARE FOR HER TONIGHT                                                                                                                                                                                                                   
(EMER MEDICAL) Loc:116 E MAIN XSt:MECHANIC CHERRY Grid:0101 Units:M41 Rmk:SUE HALL ADV SHE IS READY TO GO TO HOSPITAL                                                                                                                                                                                                                                                             
(EMER MEDICAL) Loc:916 COLUMBUS XSt:MONROE BELVEDERE Grid:0501 Units:M41 E44 Rmk:CHEST PAINS                                                                                                                                                                                                                                                                                      
(EMER MEDICAL) Loc:916 COLUMBUS XSt:MONROE BELVEDERE Grid:0501 Units:M42 E44 Rmk:CHEST PAINS                                                                                                                                                                                                                                                             
(EMER MEDICAL) Loc:116 E MAIN XSt:MECHANIC CHERRY Grid:0101 Units:M41 B41 E41 Rmk:EMP SUICIDAL FEMALE                                                                                                                                                                                                                                                    
(EMER MEDICAL) Loc:116 E MAIN XSt:MECHANIC CHERRY Grid:0101 Units:M42 B41 E41 Rmk:EMP SUICIDAL FEMALE                                                                                                                                                                                                                                                    
(EMER MEDICAL) Loc:474 YALE XSt:OXFORD DEAD END Grid:0105 Units:M41 Rmk:FEMALE HAS FALLEN                                                                                                                                                                                                                                                                                         
(FIRE CALL) Loc:298 FORGE DR XSt:BYPASS 48 LOCUST FORGE Grid:1206 Units:E44 M42 Rmk:SMELL OF NATURAL GAS IN THE RESD                                                                                                                                                                                                                                                              
(FIRE CALL) Loc:1170 PROMENADE DR XSt:PEWTER HILL CT DEAD END Grid:0614 Units:B41 E41 M41 Rmk:FIRE ALARM KEEPS GOING OFF , NO SMOKE OR FLAMES                                                                                                                                                                                                                                     
(EMER MEDICAL) Loc:334 SUMMIT XSt:EASTVIEW GLENVIEW Grid:0408 Units:M42 Rmk:FEMALE FOR MENTAL EVALUATION,NON ER RESPONSE REQUESTED                                                                                                                                                                                                                                                
(EMER MEDICAL) Loc:462 GLENVIEW XSt:HIGHLAND RIDGE Grid:0408 Units:M41 B41 E41 Rmk:FEMALE AGE 27 TROUBLE BREATHING                                                                                                                                                                                                                                                                
(SERVICE CALL) Loc:777 FRANKLIN XSt:FARVIEW CAMBRIDGE Grid:0113 Units:B41 Rmk:FAIRLY LARGE OPEN BURN                                                                                                                                                                                                                                                                              
(EMER MEDICAL) Loc:500 JUSTICE XSt:EAST COOK Grid:0306 Units:M42 Rmk:DEPUTY OUT WITH SUBJECT WITH CHEST PAINS                                                                                                                                                                                                                                                                     
(EMER MEDICAL) Loc:935 BROOKSIDE XSt:LAWNDALE DEAD END Grid:0602 Units:M41 Rmk:58 YOA FEMALE ILL AND WEAK                                                                                                                                                                                                                                                                         
(ACC/SQUAD) Loc:BROADWAY/MILLER RD XSt:NORTHWOOD CITY LIMIT Grid:0608 Units:E41 Rmk:AUTO ACCIDENT / POSSIBLE INJURY                                                                                                                                                                                                                                                               
(SERVICE CALL) Loc:380 OVERLOOK TR XSt:HORSESHOE FALLS HORSESHOE FALLS Grid:0503 Units:E41 Rmk:ADV HER C/O DETECTOR IS GOING OFF AGAIN & READING HIGHER THAN THE LAST ITME                                                                                                                                                                                                        
(FIRE ALARM) Loc:401 JUSTICE XSt:EAST COOK Grid:0306 Units:M42 E44 Rmk:GENERAL FIRE ALARMS                                                                                                                                                                                                                                                                                        
(EMER MEDICAL) Loc:41 SPRINGHOUSE CT Apt:A XSt:SHAKER RUN DEAD END Grid:0415 Units:M41 B41 E41 Rmk:82 YR OLD FEMALE NOT FEELING WELL VERY WEAK                                                                                                                                                                                                                                    
(EMER MEDICAL) Loc:915 N BROADWAY XSt:MEADOW LN MONROE Grid:0504 Units:M43 E41 Rmk:EMPLOYEE SEVERE ABDOMINAL PAIN                                                                                                                                                                                                                                                                 
(EMER MEDICAL) Loc:915 N BROADWAY XSt:MEADOW LN MONROE Grid:0504 Units:M41 E41 Rmk:EMPLOYEE SEVERE ABDOMINAL PAIN                                                                                                                                                                                                                                                                 
(FIRE ALARM) Loc:380 OVERLOOK TR XSt:HORSESHOE FALLS HORSESHOE FALLS Grid:0503 Units:B41 E41 Rmk:CO ACTIVATION                                                                                                                                                                                                                                                                    
(EMER MEDICAL) Loc:975 KINGSVIEW Apt:B XSt:ST RT 48 TURTLECREEK UNI Grid:5313 Units:M41 Rmk:FILLING FELL OUT IN A LOT OF PAIN                                                                                                                                                                                                                                                     
(EMER MEDICAL) Loc:975 KINGSVIEW Apt:B XSt:ST RT 48 TURTLECREEK UNI Grid:5313 Units:M42 Rmk:FILLING FELL OUT IN A LOT OF PAIN                                                                                                                                                                                                                                                     
(EMER MEDICAL) Loc:929 FAIRWINDS Apt:A XSt:NORTHWOOD DEAD END Grid:0607 Units:B41 E41 Rmk:45 PATIENT DIFF BREATHING                                                                                                                                                                                                                                                               
(EMER MEDICAL) Loc:1470 N BROADWAY Apt:100 XSt:NORTHWOOD MILLER RD Grid:0505 Units:M41 B41 E41 Rmk:HIGH BP RESP DISTRESS                                                                                                                                                                                                                                                          

 */
public class OHWarrenCountyBParserTest extends BaseParserTest {
  
  public OHWarrenCountyBParserTest() {
    setParser(new OHWarrenCountyBParser(), "WARREN COUNTY", "OH");
  }
  
  @Test
  public void testLebanonFireDiv() {
 
    doTest("T1",
        "(FIRE CALL) Loc:943 CAMARGO XSt:GRANDSTONE COUR DEAD END Grid:0605 Units:E41 M41 Rmk:KEY PAD FIRE ALARM                                                                                                                                                                                                                                                                           ",
        "CALL:FIRE CALL",
        "ADDR:943 CAMARGO",
        "X:GRANDSTONE COUR DEAD END",
        "MAP:0605",
        "UNIT:E41 M41",
        "INFO:KEY PAD FIRE ALARM");

    doTest("T2",
        "(SERVICE CALL) Loc:100 ARROW SPRINGS BLVD XSt:ST RT 48 DEAD END Grid:2905 Units:M41 Rmk:ON A DETAIL CUTTING OFF A RING AT ARROWSPRINGS                                                                                                                                                                                                                                            ",
        "CALL:SERVICE CALL",
        "ADDR:100 ARROW SPRINGS BLVD",
        "X:ST RT 48 DEAD END",
        "MAP:2905",
        "UNIT:M41",
        "INFO:ON A DETAIL CUTTING OFF A RING AT ARROWSPRINGS");

    doTest("T3",
        "(SERVICE CALL) Loc:17 SUMMIT XSt:MOUND CENTER Grid:0406 Units:B41 Rmk:ODOR INVESTIGATION                                                                                                                                                                                                                                                                                          ",
        "CALL:SERVICE CALL",
        "ADDR:17 SUMMIT",
        "X:MOUND CENTER",
        "MAP:0406",
        "UNIT:B41",
        "INFO:ODOR INVESTIGATION");

    doTest("T4",
        "(FIRE CALL) Loc:452 E MULBERRY XSt:CHILICOTHE MOUND Grid:0403 Units:B41 E41 Rmk:C.O. ALRM ACTIVATION,,, NEW UNIT, COMPL IS UNSURE IF ITS AN ACTUAL ACTIVATION                                                                                                                                                                                                                     ",
        "CALL:FIRE CALL",
        "ADDR:452 E MULBERRY",
        "X:CHILICOTHE MOUND",
        "MAP:0403",
        "UNIT:B41 E41",
        "INFO:C.O. ALRM ACTIVATION,,, NEW UNIT, COMPL IS UNSURE IF ITS AN ACTUAL ACTIVATION");

    doTest("T5",
        "(EMER MEDICAL) Loc:50 SHAKER RUN Apt:B XSt:SPRINGHOUSE CT MONROE Grid:0415 Units:M41 Rmk:84-85 O2 SAT                                                                                                                                                                                                                                                                             ",
        "CALL:EMER MEDICAL",
        "ADDR:50 SHAKER RUN",
        "APT:B",
        "X:SPRINGHOUSE CT MONROE",
        "MAP:0415",
        "UNIT:M41",
        "INFO:84-85 O2 SAT");

    doTest("T6",
        "(EMER MEDICAL) Loc:990 EAST RIDGE Apt:34 XSt:MONROE DEAD END Grid:1513 Units:M42 B41 E41 Rmk:61 YR OLD FEMALE INFECTION                                                                                                                                                                                                                                                           ",
        "CALL:EMER MEDICAL",
        "ADDR:990 EAST RIDGE",
        "APT:34",
        "X:MONROE DEAD END",
        "MAP:1513",
        "UNIT:M42 B41 E41",
        "INFO:61 YR OLD FEMALE INFECTION");

    doTest("T7",
        "(EMER MEDICAL) Loc:489 LA LUZ Apt:104 XSt:COLUMBUS DEAD END Grid:0411 Units:M41 B41 E41 Rmk:51 YR OLD FEMALE WITH ABDOMINAL PAIN                                                                                                                                                                                                                                                  ",
        "CALL:EMER MEDICAL",
        "ADDR:489 LA LUZ",
        "APT:104",
        "X:COLUMBUS DEAD END",
        "MAP:0411",
        "UNIT:M41 B41 E41",
        "INFO:51 YR OLD FEMALE WITH ABDOMINAL PAIN");

    doTest("T8",
        "(EMER MEDICAL) Loc:7 MEADOW LN Apt:B XSt:BROADWAY PINE RIDGE Grid:0601 Units:M41 B41 E41 Rmk:MALE 85, TROUBLE BREATHING AND ABDOMENAL PAIN                                                                                                                                                                                                                                        ",
        "CALL:EMER MEDICAL",
        "ADDR:7 MEADOW LN",
        "APT:B",
        "X:BROADWAY PINE RIDGE",
        "MAP:0601",
        "UNIT:M41 B41 E41",
        "INFO:MALE 85, TROUBLE BREATHING AND ABDOMENAL PAIN");

    doTest("T9",
        "(EMER MEDICAL) Loc:923 NELSON LN Apt:A XSt:STUBBS MILL DEAD END Grid:0316 Units:M41 B41 E41 Rmk:FEMALE 75, PAIN IN CHEST, HISTORY OF HEART TROUBLE                                                                                                                                                                                                                                ",
        "CALL:EMER MEDICAL",
        "ADDR:923 NELSON LN",
        "APT:A",
        "X:STUBBS MILL DEAD END",
        "MAP:0316",
        "UNIT:M41 B41 E41",
        "INFO:FEMALE 75, PAIN IN CHEST, HISTORY OF HEART TROUBLE");

    doTest("T10",
        "(EMER MEDICAL) Loc:900 FRANKLIN Apt:7 XSt:CAMBRIDGE HART RD Grid:0112 Units:M41 Rmk:POSSIBLE OVERDOSE                                                                                                                                                                                                                                                                             ",
        "CALL:EMER MEDICAL",
        "ADDR:900 FRANKLIN",
        "APT:7",
        "X:CAMBRIDGE HART RD",
        "MAP:0112",
        "UNIT:M41",
        "INFO:POSSIBLE OVERDOSE");

    doTest("T11",
        "(EMER MEDICAL) Loc:115 OREGONIA XSt:MAIN CITY LIMIT Grid:0401 Units:M41 Rmk:TROUBLE BREATHING, FAMILY REQUESTING SQUAD                                                                                                                                                                                                                                                            ",
        "CALL:EMER MEDICAL",
        "ADDR:115 OREGONIA",
        "X:MAIN CITY LIMIT",
        "MAP:0401",
        "UNIT:M41",
        "INFO:TROUBLE BREATHING, FAMILY REQUESTING SQUAD");

    doTest("T12",
        "(FIRE CALL) Loc:1500 KINGSVIEW XSt:TURTLECREEK COLUMBIA Grid:5203 Units:B41 E41 M42 Rmk:ZONE 68, NW RISER                                                                                                                                                                                                                                                                         ",
        "CALL:FIRE CALL",
        "ADDR:1500 KINGSVIEW",
        "X:TURTLECREEK COLUMBIA",
        "MAP:5203",
        "UNIT:B41 E41 M42",
        "INFO:ZONE 68, NW RISER");

    doTest("T13",
        "(EMER MEDICAL) Loc:102 E SILVER XSt:MECHANIC CHERRY Grid:0101 Units:M41 B41 E41 Rmk:                                                                                                                                                                                                                                                                                              ",
        "CALL:EMER MEDICAL",
        "ADDR:102 E SILVER",
        "X:MECHANIC CHERRY",
        "MAP:0101",
        "UNIT:M41 B41 E41");

    doTest("T14",
        "(EMER MEDICAL) Loc:990 EAST RIDGE Apt:13 XSt:MONROE DEAD END Grid:1513 Units:M41 B41 E41 Rmk:51 YR OLD MALE                                                                                                                                                                                                                                                                       ",
        "CALL:EMER MEDICAL",
        "ADDR:990 EAST RIDGE",
        "APT:13",
        "X:MONROE DEAD END",
        "MAP:1513",
        "UNIT:M41 B41 E41",
        "INFO:51 YR OLD MALE");

    doTest("T15",
        "(FIRE CALL) Loc:209 W MAIN XSt:WATER CLAY Grid:0102 Units:B41 E41 M41 Rmk:SMELL OF NATURAL GAS INSIDE BUILDING                                                                                                                                                                                                                                                                    ",
        "CALL:FIRE CALL",
        "ADDR:209 W MAIN",
        "X:WATER CLAY",
        "MAP:0102",
        "UNIT:B41 E41 M41",
        "INFO:SMELL OF NATURAL GAS INSIDE BUILDING");

    doTest("T16",
        "(FIRE CALL) Loc:800 FARVIEW XSt:CARSON DEAD END Grid:0114 Units:B41 E41 M41 E43 Rmk:SHED IN THE REAR ON FIRE                                                                                                                                                                                                                                                                      ",
        "CALL:FIRE CALL",
        "ADDR:800 FARVIEW",
        "X:CARSON DEAD END",
        "MAP:0114",
        "UNIT:B41 E41 M41 E43",
        "INFO:SHED IN THE REAR ON FIRE");

    doTest("T17",
        "(FIRE CALL) Loc:800 FARVIEW XSt:CARSON DEAD END Grid:0114 Units:B41 E41 M41 Rmk:SHED IN THE REAR ON FIRE                                                                                                                                                                                                                                                                          ",
        "CALL:FIRE CALL",
        "ADDR:800 FARVIEW",
        "X:CARSON DEAD END",
        "MAP:0114",
        "UNIT:B41 E41 M41",
        "INFO:SHED IN THE REAR ON FIRE");

    doTest("T18",
        "(EMER MEDICAL) Loc:441 AUTUMNWIND DR XSt:COUNTRYSIDE DR BROOK WAY Grid:1111 Units:M41 Rmk:MALE SUBJ DOWN                                                                                                                                                                                                                                                                          ",
        "CALL:EMER MEDICAL",
        "ADDR:441 AUTUMNWIND DR",
        "X:COUNTRYSIDE DR BROOK WAY",
        "MAP:1111",
        "UNIT:M41",
        "INFO:MALE SUBJ DOWN");

    doTest("T19",
        "(EMER MEDICAL) Loc:990 EAST RIDGE Apt:10 XSt:MONROE DEAD END Grid:1513 Units:M41 Rmk:POSSIBLE BROKEN HAND                                                                                                                                                                                                                                                                         ",
        "CALL:EMER MEDICAL",
        "ADDR:990 EAST RIDGE",
        "APT:10",
        "X:MONROE DEAD END",
        "MAP:1513",
        "UNIT:M41",
        "INFO:POSSIBLE BROKEN HAND");

    doTest("T20",
        "(EMER MEDICAL) Loc:1048 HUNTERS RUN Apt:12 XSt:PHEASANT RUN TAMARACK CT Grid:0501 Units:M42 B41 E41 Rmk:FEMALE NEEDS EVAL                                                                                                                                                                                                                                                         ",
        "CALL:EMER MEDICAL",
        "ADDR:1048 HUNTERS RUN",
        "APT:12",
        "X:PHEASANT RUN TAMARACK CT",
        "MAP:0501",
        "UNIT:M42 B41 E41",
        "INFO:FEMALE NEEDS EVAL");

    doTest("T21",
        "(EMER MEDICAL) Loc:211 E ORCHARD Apt:2 XSt:DEERFIELD EAST Grid:0312 Units:M41 B41 E41 Rmk:CHEST PAINS                                                                                                                                                                                                                                                                             ",
        "CALL:EMER MEDICAL",
        "ADDR:211 E ORCHARD",
        "APT:2",
        "X:DEERFIELD EAST",
        "MAP:0312",
        "UNIT:M41 B41 E41",
        "INFO:CHEST PAINS");

    doTest("T22",
        "(MUTUAL AID) Loc:20 W SILVER XSt:BROADWAY SYCAMORE Grid:0101 Units:L41 Rmk:L41 TO APPLIANCE FIRE, 1575 OLD ST RT 122, TAC 2                                                                                                                                                                                                                                                       ",
        "CALL:MUTUAL AID",
        "ADDR:20 W SILVER",
        "X:BROADWAY SYCAMORE",
        "MAP:0101",
        "UNIT:L41",
        "INFO:L41 TO APPLIANCE FIRE, 1575 OLD ST RT 122, TAC 2");

    doTest("T23",
        "(EMER MEDICAL) Loc:1275 CATALPA RIDGE DR XSt:LANCE CT DEAD END Grid:1209 Units:M42 B41 E41 Rmk:FEMALE 84, RPTS PAIN UNDER LEFT ARE AND LEFT BREAST                                                                                                                                                                                                                                ",
        "CALL:EMER MEDICAL",
        "ADDR:1275 CATALPA RIDGE DR",
        "X:LANCE CT DEAD END",
        "MAP:1209",
        "UNIT:M42 B41 E41",
        "INFO:FEMALE 84, RPTS PAIN UNDER LEFT ARE AND LEFT BREAST");

    doTest("T24",
        "(EMER MEDICAL) Loc:305 LAWNDALE XSt:BROOKSIDE CARSON Grid:0602 Units:M41 B41 E41 M42 Rmk:3RD PARTY, MEDICAL ALERT CALL::                                                                                                                                                                                                                                                          ",
        "CALL:EMER MEDICAL",
        "ADDR:305 LAWNDALE",
        "X:BROOKSIDE CARSON",
        "MAP:0602",
        "UNIT:M41 B41 E41 M42",
        "INFO:3RD PARTY, MEDICAL ALERT CALL::");

    doTest("T25",
        "(EMER MEDICAL) Loc:305 LAWNDALE XSt:BROOKSIDE CARSON Grid:0602 Units:M41 B41 E41 Rmk:3RD PARTY, MEDICAL ALERT CALL::                                                                                                                                                                                                                                                              ",
        "CALL:EMER MEDICAL",
        "ADDR:305 LAWNDALE",
        "X:BROOKSIDE CARSON",
        "MAP:0602",
        "UNIT:M41 B41 E41",
        "INFO:3RD PARTY, MEDICAL ALERT CALL::");

    doTest("T26",
        "(EMER MEDICAL) Loc:935 BROOKSIDE XSt:LAWNDALE DEAD END Grid:0602 Units:M42 B41 E41 Rmk:FEMALE 30, CP,, NEEDING TRANSPORT, PT HAS NO ONE TO CARE FOR HER TONIGHT                                                                                                                                                                                                                   ",
        "CALL:EMER MEDICAL",
        "ADDR:935 BROOKSIDE",
        "X:LAWNDALE DEAD END",
        "MAP:0602",
        "UNIT:M42 B41 E41",
        "INFO:FEMALE 30, CP,, NEEDING TRANSPORT, PT HAS NO ONE TO CARE FOR HER TONIGHT");

    doTest("T27",
        "(EMER MEDICAL) Loc:116 E MAIN XSt:MECHANIC CHERRY Grid:0101 Units:M41 Rmk:SUE HALL ADV SHE IS READY TO GO TO HOSPITAL                                                                                                                                                                                                                                                             ",
        "CALL:EMER MEDICAL",
        "ADDR:116 E MAIN",
        "X:MECHANIC CHERRY",
        "MAP:0101",
        "UNIT:M41",
        "INFO:SUE HALL ADV SHE IS READY TO GO TO HOSPITAL");

    doTest("T28",
        "(EMER MEDICAL) Loc:916 COLUMBUS XSt:MONROE BELVEDERE Grid:0501 Units:M41 E44 Rmk:CHEST PAINS                                                                                                                                                                                                                                                                                      ",
        "CALL:EMER MEDICAL",
        "ADDR:916 COLUMBUS",
        "X:MONROE BELVEDERE",
        "MAP:0501",
        "UNIT:M41 E44",
        "INFO:CHEST PAINS");

    doTest("T29",
        "(EMER MEDICAL) Loc:916 COLUMBUS XSt:MONROE BELVEDERE Grid:0501 Units:M42 E44 Rmk:CHEST PAINS                                                                                                                                                                                                                                                             ",
        "CALL:EMER MEDICAL",
        "ADDR:916 COLUMBUS",
        "X:MONROE BELVEDERE",
        "MAP:0501",
        "UNIT:M42 E44",
        "INFO:CHEST PAINS");

    doTest("T30",
        "(EMER MEDICAL) Loc:116 E MAIN XSt:MECHANIC CHERRY Grid:0101 Units:M41 B41 E41 Rmk:EMP SUICIDAL FEMALE                                                                                                                                                                                                                                                    ",
        "CALL:EMER MEDICAL",
        "ADDR:116 E MAIN",
        "X:MECHANIC CHERRY",
        "MAP:0101",
        "UNIT:M41 B41 E41",
        "INFO:EMP SUICIDAL FEMALE");

    doTest("T31",
        "(EMER MEDICAL) Loc:116 E MAIN XSt:MECHANIC CHERRY Grid:0101 Units:M42 B41 E41 Rmk:EMP SUICIDAL FEMALE                                                                                                                                                                                                                                                    ",
        "CALL:EMER MEDICAL",
        "ADDR:116 E MAIN",
        "X:MECHANIC CHERRY",
        "MAP:0101",
        "UNIT:M42 B41 E41",
        "INFO:EMP SUICIDAL FEMALE");

    doTest("T32",
        "(EMER MEDICAL) Loc:474 YALE XSt:OXFORD DEAD END Grid:0105 Units:M41 Rmk:FEMALE HAS FALLEN                                                                                                                                                                                                                                                                                         ",
        "CALL:EMER MEDICAL",
        "ADDR:474 YALE",
        "X:OXFORD DEAD END",
        "MAP:0105",
        "UNIT:M41",
        "INFO:FEMALE HAS FALLEN");

    doTest("T33",
        "(FIRE CALL) Loc:298 FORGE DR XSt:BYPASS 48 LOCUST FORGE Grid:1206 Units:E44 M42 Rmk:SMELL OF NATURAL GAS IN THE RESD                                                                                                                                                                                                                                                              ",
        "CALL:FIRE CALL",
        "ADDR:298 FORGE DR",
        "X:BYPASS 48 LOCUST FORGE",
        "MAP:1206",
        "UNIT:E44 M42",
        "INFO:SMELL OF NATURAL GAS IN THE RESD");

    doTest("T34",
        "(FIRE CALL) Loc:1170 PROMENADE DR XSt:PEWTER HILL CT DEAD END Grid:0614 Units:B41 E41 M41 Rmk:FIRE ALARM KEEPS GOING OFF , NO SMOKE OR FLAMES                                                                                                                                                                                                                                     ",
        "CALL:FIRE CALL",
        "ADDR:1170 PROMENADE DR",
        "X:PEWTER HILL CT DEAD END",
        "MAP:0614",
        "UNIT:B41 E41 M41",
        "INFO:FIRE ALARM KEEPS GOING OFF , NO SMOKE OR FLAMES");

    doTest("T35",
        "(EMER MEDICAL) Loc:334 SUMMIT XSt:EASTVIEW GLENVIEW Grid:0408 Units:M42 Rmk:FEMALE FOR MENTAL EVALUATION,NON ER RESPONSE REQUESTED                                                                                                                                                                                                                                                ",
        "CALL:EMER MEDICAL",
        "ADDR:334 SUMMIT",
        "X:EASTVIEW GLENVIEW",
        "MAP:0408",
        "UNIT:M42",
        "INFO:FEMALE FOR MENTAL EVALUATION,NON ER RESPONSE REQUESTED");

    doTest("T36",
        "(EMER MEDICAL) Loc:462 GLENVIEW XSt:HIGHLAND RIDGE Grid:0408 Units:M41 B41 E41 Rmk:FEMALE AGE 27 TROUBLE BREATHING                                                                                                                                                                                                                                                                ",
        "CALL:EMER MEDICAL",
        "ADDR:462 GLENVIEW",
        "X:HIGHLAND RIDGE",
        "MAP:0408",
        "UNIT:M41 B41 E41",
        "INFO:FEMALE AGE 27 TROUBLE BREATHING");

    doTest("T37",
        "(SERVICE CALL) Loc:777 FRANKLIN XSt:FARVIEW CAMBRIDGE Grid:0113 Units:B41 Rmk:FAIRLY LARGE OPEN BURN                                                                                                                                                                                                                                                                              ",
        "CALL:SERVICE CALL",
        "ADDR:777 FRANKLIN",
        "X:FARVIEW CAMBRIDGE",
        "MAP:0113",
        "UNIT:B41",
        "INFO:FAIRLY LARGE OPEN BURN");

    doTest("T38",
        "(EMER MEDICAL) Loc:500 JUSTICE XSt:EAST COOK Grid:0306 Units:M42 Rmk:DEPUTY OUT WITH SUBJECT WITH CHEST PAINS                                                                                                                                                                                                                                                                     ",
        "CALL:EMER MEDICAL",
        "ADDR:500 JUSTICE",
        "X:EAST COOK",
        "MAP:0306",
        "UNIT:M42",
        "INFO:DEPUTY OUT WITH SUBJECT WITH CHEST PAINS");

    doTest("T39",
        "(EMER MEDICAL) Loc:935 BROOKSIDE XSt:LAWNDALE DEAD END Grid:0602 Units:M41 Rmk:58 YOA FEMALE ILL AND WEAK                                                                                                                                                                                                                                                                         ",
        "CALL:EMER MEDICAL",
        "ADDR:935 BROOKSIDE",
        "X:LAWNDALE DEAD END",
        "MAP:0602",
        "UNIT:M41",
        "INFO:58 YOA FEMALE ILL AND WEAK");

    doTest("T40",
        "(ACC/SQUAD) Loc:BROADWAY/MILLER RD XSt:NORTHWOOD CITY LIMIT Grid:0608 Units:E41 Rmk:AUTO ACCIDENT / POSSIBLE INJURY                                                                                                                                                                                                                                                               ",
        "CALL:ACC/SQUAD",
        "ADDR:BROADWAY & MILLER RD",
        "X:NORTHWOOD CITY LIMIT",
        "MAP:0608",
        "UNIT:E41",
        "INFO:AUTO ACCIDENT / POSSIBLE INJURY");

    doTest("T41",
        "(SERVICE CALL) Loc:380 OVERLOOK TR XSt:HORSESHOE FALLS HORSESHOE FALLS Grid:0503 Units:E41 Rmk:ADV HER C/O DETECTOR IS GOING OFF AGAIN & READING HIGHER THAN THE LAST ITME                                                                                                                                                                                                        ",
        "CALL:SERVICE CALL",
        "ADDR:380 OVERLOOK TR",
        "X:HORSESHOE FALLS HORSESHOE FALLS",
        "MAP:0503",
        "UNIT:E41",
        "INFO:ADV HER C/O DETECTOR IS GOING OFF AGAIN & READING HIGHER THAN THE LAST ITME");

    doTest("T42",
        "(FIRE ALARM) Loc:401 JUSTICE XSt:EAST COOK Grid:0306 Units:M42 E44 Rmk:GENERAL FIRE ALARMS                                                                                                                                                                                                                                                                                        ",
        "CALL:FIRE ALARM",
        "ADDR:401 JUSTICE",
        "X:EAST COOK",
        "MAP:0306",
        "UNIT:M42 E44",
        "INFO:GENERAL FIRE ALARMS");

    doTest("T43",
        "(EMER MEDICAL) Loc:41 SPRINGHOUSE CT Apt:A XSt:SHAKER RUN DEAD END Grid:0415 Units:M41 B41 E41 Rmk:82 YR OLD FEMALE NOT FEELING WELL VERY WEAK                                                                                                                                                                                                                                    ",
        "CALL:EMER MEDICAL",
        "ADDR:41 SPRINGHOUSE CT",
        "APT:A",
        "X:SHAKER RUN DEAD END",
        "MAP:0415",
        "UNIT:M41 B41 E41",
        "INFO:82 YR OLD FEMALE NOT FEELING WELL VERY WEAK");

    doTest("T44",
        "(EMER MEDICAL) Loc:915 N BROADWAY XSt:MEADOW LN MONROE Grid:0504 Units:M43 E41 Rmk:EMPLOYEE SEVERE ABDOMINAL PAIN                                                                                                                                                                                                                                                                 ",
        "CALL:EMER MEDICAL",
        "ADDR:915 N BROADWAY",
        "X:MEADOW LN MONROE",
        "MAP:0504",
        "UNIT:M43 E41",
        "INFO:EMPLOYEE SEVERE ABDOMINAL PAIN");

    doTest("T45",
        "(EMER MEDICAL) Loc:915 N BROADWAY XSt:MEADOW LN MONROE Grid:0504 Units:M41 E41 Rmk:EMPLOYEE SEVERE ABDOMINAL PAIN                                                                                                                                                                                                                                                                 ",
        "CALL:EMER MEDICAL",
        "ADDR:915 N BROADWAY",
        "X:MEADOW LN MONROE",
        "MAP:0504",
        "UNIT:M41 E41",
        "INFO:EMPLOYEE SEVERE ABDOMINAL PAIN");

    doTest("T46",
        "(FIRE ALARM) Loc:380 OVERLOOK TR XSt:HORSESHOE FALLS HORSESHOE FALLS Grid:0503 Units:B41 E41 Rmk:CO ACTIVATION                                                                                                                                                                                                                                                                    ",
        "CALL:FIRE ALARM",
        "ADDR:380 OVERLOOK TR",
        "X:HORSESHOE FALLS HORSESHOE FALLS",
        "MAP:0503",
        "UNIT:B41 E41",
        "INFO:CO ACTIVATION");

    doTest("T47",
        "(EMER MEDICAL) Loc:975 KINGSVIEW Apt:B XSt:ST RT 48 TURTLECREEK UNI Grid:5313 Units:M41 Rmk:FILLING FELL OUT IN A LOT OF PAIN                                                                                                                                                                                                                                                     ",
        "CALL:EMER MEDICAL",
        "ADDR:975 KINGSVIEW",
        "APT:B",
        "X:ST RT 48 TURTLECREEK UNI",
        "MAP:5313",
        "UNIT:M41",
        "INFO:FILLING FELL OUT IN A LOT OF PAIN");

    doTest("T48",
        "(EMER MEDICAL) Loc:975 KINGSVIEW Apt:B XSt:ST RT 48 TURTLECREEK UNI Grid:5313 Units:M42 Rmk:FILLING FELL OUT IN A LOT OF PAIN                                                                                                                                                                                                                                                     ",
        "CALL:EMER MEDICAL",
        "ADDR:975 KINGSVIEW",
        "APT:B",
        "X:ST RT 48 TURTLECREEK UNI",
        "MAP:5313",
        "UNIT:M42",
        "INFO:FILLING FELL OUT IN A LOT OF PAIN");

    doTest("T49",
        "(EMER MEDICAL) Loc:929 FAIRWINDS Apt:A XSt:NORTHWOOD DEAD END Grid:0607 Units:B41 E41 Rmk:45 PATIENT DIFF BREATHING                                                                                                                                                                                                                                                               ",
        "CALL:EMER MEDICAL",
        "ADDR:929 FAIRWINDS",
        "APT:A",
        "X:NORTHWOOD DEAD END",
        "MAP:0607",
        "UNIT:B41 E41",
        "INFO:45 PATIENT DIFF BREATHING");

    doTest("T50",
        "(EMER MEDICAL) Loc:1470 N BROADWAY Apt:100 XSt:NORTHWOOD MILLER RD Grid:0505 Units:M41 B41 E41 Rmk:HIGH BP RESP DISTRESS                                                                                                                                                                                                                                                          ",
        "CALL:EMER MEDICAL",
        "ADDR:1470 N BROADWAY",
        "APT:100",
        "X:NORTHWOOD MILLER RD",
        "MAP:0505",
        "UNIT:M41 B41 E41",
        "INFO:HIGH BP RESP DISTRESS");
   
  }
  
  public static void main(String[] args) {
    new OHWarrenCountyBParserTest().generateTests("T1");
  }
}