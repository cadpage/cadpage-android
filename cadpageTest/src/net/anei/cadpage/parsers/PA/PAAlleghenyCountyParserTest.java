package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAAlleghenyCountyParserTest extends BaseParserTest {
  
  public PAAlleghenyCountyParserTest() {
    setParser(new PAAlleghenyCountyParser(), "ALLEGHENY COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "ALLEGHENY COUNTY 911 :FRCOM3, F1, POSS FIRE COM - SMELL OF SMOKE/BLDG ENDG, SHARPSBURG TOWERS #902, SHP, at 601 MAIN ST #902, SHP, btwn S MAIN ST and 7TH ST, NFD3, 265002, CALLER REPORTING A STRONG SMELL OF \"SCHLAK\" PAINT OR AMMONIA IN THE BUILDING. CALLER WAS ADVISED TO EVAC, Units:102EN1, 111EN1, 149EN1, 191EN1,",
        "CALL:FRCOM3 - POSS FIRE COM - SMELL OF SMOKE/BLDG ENDG",
        "PLACE:SHARPSBURG TOWERS #902",
        "CITY:SHARPSBURG",
        "ADDR:601 MAIN ST",
        "APT:902",
        "X:S MAIN ST and 7TH ST",
        "SRC:NFD3",
        "ID:265002",
        "INFO:CALLER REPORTING A STRONG SMELL OF \"SCHLAK\" PAINT OR AMMONIA IN THE BUILDING. CALLER WAS ADVISED TO EVAC", 
        "UNIT:102EN1 111EN1 149EN1 191EN1");
        
    doTest("T2",
        "ALLEGHENY COUNTY 911 :NGASRES, F1, NATURAL GAS SMELL/LEAK RES BLDG, 40 EASTON RD, FOX, btwn CHAPEL OAK RD and OLD MILL RD, ON THE STREET, IN FRONT OF, NFD3, 157001, Medical ProQA recommends dispatch at this time, Units:102EN1, 157EN1, 172EN1 - From 405 11/11/2010 12:17:38 TXT STOP to opt-out",
        "CALL:NGASRES - NATURAL GAS SMELL/LEAK RES BLDG",
        "ADDR:40 EASTON RD",
        "CITY:FOX CHAPEL",
        "X:CHAPEL OAK RD and OLD MILL RD",
        "INFO:ON THE STREET / IN FRONT OF / Medical ProQA recommends dispatch at this time",
        "SRC:NFD3",
        "ID:157001",
        "UNIT:102EN1 157EN1 172EN1");
    
    doTest("T3",
        "ALLEGHENY COUNTY 911 :NGASCOM, F1, NATURAL GAS SMELL/LEAK COM BLDG, FREEPORT MEDICAL ASSOC, ASP, at 241 FREEPORT RD, ASP, SUITE 7-FOX CHAPEL DERMETOLOGY, btwn CENTER AVE and EASTERN AVE, NFD3, 102001, STRONG SMELL OF NATURAL GAS IN THE BLDG, Units:102EN1, 111EN2, 157RQ1, 191TK1, 260RQ1, 265TK1 - From 405 11/10/2010 10:02:01 TXT STOP to opt-out",
        "CALL:NGASCOM - NATURAL GAS SMELL/LEAK COM BLDG",
        "PLACE:FREEPORT MEDICAL ASSOC",
        "CITY:ASPINWALL", 
        "ADDR:241 FREEPORT RD",
        "INFO:SUITE 7-FOX CHAPEL DERMETOLOGY / STRONG SMELL OF NATURAL GAS IN THE BLDG",
        "X:CENTER AVE and EASTERN AVE",
        "SRC:NFD3", 
        "ID:102001", 
        "UNIT:102EN1 111EN2 157RQ1 191TK1 260RQ1 265TK1");
        
     doTest("T4",   
        "ALLEGHENY COUNTY 911 :NGASRES, F1, NATURAL GAS SMELL/LEAK RES BLDG, 262 EMERSON RD, SHA, btwn JORDAN LN and HAWTHORNE RD, NFD3, 260001, NAT TXT STOP to opt-out",
        "CALL:NGASRES - NATURAL GAS SMELL/LEAK RES BLDG", 
        "ADDR:262 EMERSON RD", 
        "CITY:SHALER", 
        "X:JORDAN LN and HAWTHORNE RD", 
        "SRC:NFD3", 
        "ID:260001",
        "INFO:NAT");
        
     doTest("T5",
        "ALLEGHENY COUNTY 911 :NGASOUT, F2, NATURAL GAS SMELL/LEAK OUTSIDE, 22 4TH ST, SHP, btwn SHORT CANAL ST and PILGRIM WAY, NFD3, 265001, STRON TXT STOP to opt-out",
        "CALL:NGASOUT - NATURAL GAS SMELL/LEAK OUTSIDE", 
        "ADDR:22 4TH ST", 
        "CITY:SHARPSBURG", 
        "X:SHORT CANAL ST and PILGRIM WAY", 
        "SRC:NFD3", 
        "ID:265001", 
        "INFO:STRON");
        
    doTest("T6",
        "ALLEGHENY COUNTY 911 :QRS0, Q0, E-0 QRS / EMS ASSIST, 43 OAKHURST CIR, ASP, btwn RIVER OAKS DR and RIVER OAKS DR, NFD3, 102001, 74YOF CHEST TXT STOP to opt-out",
        "CALL:QRS0 - E-0 QRS / EMS ASSIST", 
        "ADDR:43 OAKHURST CIR", 
        "CITY:ASPINWALL", 
        "X:RIVER OAKS DR and RIVER OAKS DR", 
        "SRC:NFD3", 
        "ID:102001", 
        "INFO:74YOF CHEST");
        
    doTest("T7",
        "ALLEGHENY COUNTY 911 :29B1, F1, TRAFFIC -WITH INJURIES, THOMPSON RUN RD/SUNNY HILL DR, ROS,  <310/ 0>, NFD3, 247006 191001, GARAGE ON FIRE, Units:102EN1, 149EN1, 191EN1, 191TK1, 240SQ1, 247TK1, 259EN1, 260TK1, 312RQ40 - From 405 11/13/2010 06:43:58 TXT STOP to opt-out",
        "CALL:29B1 - TRAFFIC -WITH INJURIES", 
        "ADDR:THOMPSON RUN RD & SUNNY HILL DR", 
        "CITY:ROSS",
        "INFO:<310/ 0> / GARAGE ON FIRE", 
        "SRC:NFD3", 
        "ID:247006 191001",
        "UNIT:102EN1 149EN1 191EN1 191TK1 240SQ1 247TK1 259EN1 260TK1 312RQ40");
  }
}
