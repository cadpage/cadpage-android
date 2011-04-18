package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDSaintMarysCountyParser;

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
        "ADDR:22607 THREE NOTCH RD",
        "X:MACARTHUR BL",
        "CITY:LEXINGTON PARK",
        "UNIT:CO9 CO3 SQ3 CO39 CO79 A796",
        "INFO:N/B LANES TWO VEHICLES AT LEAST ONE INJURY");
    
    doTest("T2",
        "14:41:22*Personal Injury Accident*21050 WILLOWS RD INTERSECTN*ABBERLY CREST LN*LEXINGTON PARK*CO3 CO39 CO6R*",
        "CALL:Personal Injury Accident",
        "ADDR:21050 WILLOWS RD",
        "X:ABBERLY CREST LN",
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
    
    doTest("T7",
        "20:51:10*Chest Pain*19673 NORTH SNOW HILL MANOR RD*SOUTH SNOW HILL MANOR RD*LYARD RD*ST MARYS CITY*CO39 A398 ALS*PT. DOES HAVE A PACEMAKER",
        "CALL:Chest Pain",
        "ADDR:19673 NORTH SNOW HILL MANOR RD",
        "X:SOUTH SNOW HILL MANOR RD / LYARD RD",
        "CITY:ST MARYS CITY",
        "UNIT:CO39 A398 ALS",
        "INFO:PT. DOES HAVE A PACEMAKER");

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
    
    doTest("T17",
        "((57079) CAD ) 16:18:26*Breathing Difficulties*CHESAPEAKE SHORES*21412 GREAT MILLS RD*SUBURBAN DR*SANNERS LN*LEXINGTON PARK*CO39 A397 ALS M3*RM102B-FRONT",
        "CALL:Breathing Difficulties",
        "PLACE:CHESAPEAKE SHORES",
        "ADDR:21412 GREAT MILLS RD",
        "X:SUBURBAN DR / SANNERS LN",
        "CITY:LEXINGTON PARK",
        "UNIT:CO39 A397 ALS M3",
        "INFO:RM102B-FRONT");
    
    doTest("T18",
        "((61165) CAD ) 07:09:07*Sick Person*46369 HATTONS REST LN*DEAD END*POINT LOOKOUT RD*PARK HALL*CO39*Using ProQA Medical*",
        "CALL:Sick Person",
        "ADDR:46369 HATTONS REST LN",
        "X:DEAD END / POINT LOOKOUT RD",
        "CITY:PARK HALL",
        "UNIT:CO39",
        "INFO:Using ProQA Medical");

    doTest("T19",
        "((60056) CAD ) 18:14:19*Traumatic Injuries*21121 ACE LN*WINDING WY*SHORT WY*LORD CALVERT TRLPK*CO39*Using ProQA Medical*",
        "CALL:Traumatic Injuries",
        "ADDR:21121 ACE LN",
        "X:WINDING WY / SHORT WY",
        "PLACE:LORD CALVERT TRLPK",
        "UNIT:CO39",
        "INFO:Using ProQA Medical");
          
    doTest("T20",
        "((59734) CAD ) 16:59:32*Eye Problems/Injuries*LA QUINTA INN*22769 THREE NOTCH RD*CHANCELLORS RUN RD*GUNSTON DR*CALIFORNIA*CO39*at the front desk*",
        "CALL:Eye Problems/Injuries",
        "PLACE:LA QUINTA INN",
        "ADDR:22769 THREE NOTCH RD",
        "X:CHANCELLORS RUN RD / GUNSTON DR",
        "CITY:CALIFORNIA",
        "UNIT:CO39",
        "INFO:at the front desk");
     
    doTest("T21",
        "((62231) CAD ) 15:12:53*Sick Person*CHESAPEAKE SHORES*21412 GREAT MILLS RD*SUBURBAN DR*SANNERS LN*LEXINGTON PARK*CO39*97 yr/f with GI bleed   rm 223A  (b",
        "CALL:Sick Person",
        "PLACE:CHESAPEAKE SHORES",
        "ADDR:21412 GREAT MILLS RD",
        "X:SUBURBAN DR / SANNERS LN",
        "CITY:LEXINGTON PARK",
        "UNIT:CO39",
        "INFO:97 yr/f with GI bleed   rm 223A  (b");
              
    doTest("T22",
        "((62650) CAD ) 17:06:15*Personal Injury Accident*GOV THOMAS JOHNSON BRIDGE*46100 PATUXENT BEACH RD*NORTH PATUXENT BEACH RD*DEAD",
        "CALL:Personal Injury Accident",
        "PLACE:GOV THOMAS JOHNSON BRIDGE",
        "ADDR:46100 PATUXENT BEACH RD",
        "X:NORTH PATUXENT BEACH RD / DEAD");
    
    doTest("T23",
        "((14072) CAD ) 08:27:10*Sick Person*BANK OF AMERICA*21800 NORTH SHANGRI LA DR*THREE NOTCH RD*GREAT MILLS RD*LEXINGTON PARK*CO39 A397*Using ProQA",
        "CALL:Sick Person",
        "PLACE:BANK OF AMERICA",
        "ADDR:21800 NORTH SHANGRI LA DR",
        "X:THREE NOTCH RD / GREAT MILLS RD",
        "CITY:LEXINGTON PARK",
        "UNIT:CO39 A397",
        "INFO:Using ProQA");
          
    doTest("T24",
        "((557) CAD ) 23:33:54*Breathing Difficulties*CEDAR LANE APARTMENTS*22680 CEDAR LANE CT APT2204*POINT LOOKOUT RD*CEDAR LANE RD*LEONARDTOWN*ALS CO19*74YOM",
        "CALL:Breathing Difficulties",
        "PLACE:CEDAR LANE APARTMENTS",
        "ADDR:22680 CEDAR LANE",
        "APT:CT APT2204",
        "X:POINT LOOKOUT RD / CEDAR LANE RD",
        "CITY:LEONARDTOWN",
        "UNIT:ALS CO19",
        "INFO:74YOM");

     doTest("T25",
         "((19239) CAD ) 20:51:10*Chest Pain*19673 NORTH SNOW HILL MANOR RD*SOUTH SNOW HILL MANOR RD*LYARD RD*ST MARYS CITY*CO39 A398 ALS*PT. DOES HAVE A PACEMAKER",
         "CALL:Chest Pain",
         "ADDR:19673 NORTH SNOW HILL MANOR RD",
         "X:SOUTH SNOW HILL MANOR RD / LYARD RD",
         "CITY:ST MARYS CITY",
         "UNIT:CO39 A398 ALS",
         "INFO:PT. DOES HAVE A PACEMAKER");

     doTest("T26",
         "((20390) CAD ) 09:06:30*Sick Person*CAMPUS CENTER*47600 MILL FIELD DR*POINT LOOKOUT RD*DEAD END*ST MARYS CITY*CO39*2ND FLOOR;*",
         "CALL:Sick Person",
         "PLACE:CAMPUS CENTER",
         "ADDR:47600 MILL FIELD DR",
         "X:POINT LOOKOUT RD / DEAD END",
         "CITY:ST MARYS CITY",
         "UNIT:CO39",
         "INFO:2ND FLOOR;");

     doTest("T27",
         "((49639) CAD ) 17:18:40*Mutual Aid*14386 SOUTH SOLOMONS ISLAND RD*CO9 CO7 CO3*",
         "CALL:Mutual Aid",
         "ADDR:14386 SOUTH SOLOMONS ISLAND RD",
         "UNIT:CO9 CO7 CO3");
    
     doTest("T28",
          "((23645) CAD ) 07:33:05*Mutual Aid EMS*401 EP WORTH CT*CO9*302; unresponsive*",
          "CALL:Mutual Aid EMS",
          "ADDR:401 EP WORTH CT",
          "UNIT:CO9",
          "INFO:302; unresponsive");

     doTest("T29",
         "((25655) CAD ) 19:03:50*Mutual Aid*CALVERT CO*CO9 CO7 CO3*Box 3-03*",
         "CALL:Mutual Aid",
         "ADDR:CALVERT CO",
         "UNIT:CO9 CO7 CO3",
         "INFO:Box 3-03");

     doTest("T30",
         "((25495) CAD ) 19:03:50*Mutual Aid*CALVERT CO*CO9 CO7 CO3*Box 3-03*",
         "CALL:Mutual Aid",
         "ADDR:CALVERT CO",
         "UNIT:CO9 CO7 CO3",
         "INFO:Box 3-03");

     doTest("T31",
         "((25420) CAD ) 18:44:03*Vehicle Fire*NICOLET PARK*21777 BUNKER HILL DR*DEAD END*LEXINGTON PARK*CO3*Using ProQA Fire*",
         "CALL:Vehicle Fire",
         "PLACE:NICOLET PARK",
         "ADDR:21777 BUNKER HILL DR",
         "X:DEAD END",
         "CITY:LEXINGTON PARK",
         "UNIT:CO3",
         "INFO:Using ProQA Fire");

     doTest("T32",
         "((20896) CAD ) 14:43:34*OUTSIDE FIRE*21139 THREE NOTCH RD INTERSECTN*HERMANVILLE RD*HERMANVILLE*CO3*APPROX 1 MILE IN FROM 235*",
         "CALL:OUTSIDE FIRE",
         "ADDR:21139 THREE NOTCH RD",
         "X:HERMANVILLE RD",
         "CITY:HERMANVILLE",
         "UNIT:CO3",
         "INFO:APPROX 1 MILE IN FROM 235");

     doTest("T33",
         "((24505) CAD ) 12:13:18*1050 PD Structure*21481 SYDNEY DR*SELL DR*LEXINGTON PARK*CO3 SQ3*VEHICLE INTO A HOUSE*",
         "CALL:1050 PD Structure",
         "ADDR:21481 SYDNEY DR",
         "X:SELL DR",
         "CITY:LEXINGTON PARK",
         "UNIT:CO3 SQ3",
         "INFO:VEHICLE INTO A HOUSE");

     doTest("T34",
         "((33038) CAD ) 01:57:14*Hazardous Condition*APT 311 FOXCHASE*45910 FOXCHASE DR APT311*LEXINGTON DR*GREAT MILLS*CO9*Using ProQA Fire*",
         "CALL:Hazardous Condition",
         "PLACE:APT 311 FOXCHASE",
         "ADDR:45910 FOXCHASE DR",
         "APT:APT311",
         "X:LEXINGTON DR",
         "CITY:GREAT MILLS",
         "UNIT:CO9",
         "INFO:Using ProQA Fire");

     doTest("T35",
         "((33120) CAD ) 03:41:27*CO Detector No Symptons*45713 SUMMER LN*DEAD END*LORD CALVERT TRLPK*CO3*Using ProQA Fire*",
         "CALL:CO Detector No Symptons",
         "PLACE:LORD CALVERT TRLPK",
         "ADDR:45713 SUMMER LN",
         "X:DEAD END",
         "UNIT:CO3",
         "INFO:Using ProQA Fire");

     doTest("T36",
         "((38992) CAD ) 16:54:15*Tree Down*46449 SUE DR*PRATHER DR*LEXINGTON PARK*CO3*TREE IN THE POWER LINES/LINES ARE SPARKING/LEANING ON HOUSE*",
         "CALL:Tree Down",
         "ADDR:46449 SUE DR",
         "X:PRATHER DR",
         "CITY:LEXINGTON PARK",
         "UNIT:CO3",
         "INFO:TREE IN THE POWER LINES/LINES ARE SPARKING/LEANING ON HOUSE");
         
  }
  
  public static void main(String[] args) {
    new MDSaintMarysCountyParserTest().generateTests("T37", "CALL PLACE ADDR APT X CITY UNIT INFO");
  }
}