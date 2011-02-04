package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDWicomicoCountyParserTest extends BaseParserTest {
  
  public MDWicomicoCountyParserTest() {
    setParser(new MDWicomicoCountyParser(), "WICOMICO COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "1638:CAD:2010110703;STRUCTURE FIRE;27887 POINTERS LN;SALI;SPANIEL CT;OXBRIDGE DR",
        "ID:2010110703",
        "CALL:STRUCTURE FIRE",
        "ADDR:27887 POINTERS LN",
        "CITY:SALISBURY",
        "X:SPANIEL CT & OXBRIDGE DR");
 
    doTest("T2",
        "1639:CAD:2010110960;STRUCTURE FIRE;914 E CHURCH ST;SALI;HOLLAND AVE;WALSTON AVE",
        "ID:2010110960",
        "CALL:STRUCTURE FIRE",
        "ADDR:914 E CHURCH ST",
        "CITY:SALISBURY",
        "X:HOLLAND AVE & WALSTON AVE");
        
    doTest("T3",
        "1640:CAD:2010110997;PETROLEUM SPILL;2530 N SALISBURY BLVD;SALI;N ZION RD;N ZION RD",
        "ID:2010110997",
        "CALL:PETROLEUM SPILL",
        "ADDR:2530 N SALISBURY BLVD",
        "CITY:SALISBURY",
        "X:N ZION RD & N ZION RD");

    doTest("T4",
        "1642:CAD:2010111051;NON BREATHING;105 CIVIC AVE;SALI;OLD OCEAN CITY RD;WHITE ST;[Medical Priority Update] Medical Priority reconfigured event from 09-E-01 to",
        "ID:2010111051",
        "CALL:NON BREATHING",
        "ADDR:105 CIVIC AVE",
        "CITY:SALISBURY",
        "X:OLD OCEAN CITY RD & WHITE ST",
        "INFO:Medical Priority reconfigured event from 09-E-01 to");
    
    doTest("T5",
        "1643:CAD:2010111259;AUTOMATIC ALARM;121 E NAYLOR MILL RD;SALI;N SALISBURY BLVD;JASMINE DR;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. HI",
        "ID:2010111259",
        "CALL:AUTOMATIC ALARM",
        "ADDR:121 E NAYLOR MILL RD",
        "CITY:SALISBURY",
        "X:N SALISBURY BLVD & JASMINE DR",
        "INFO:Alarms. HI");
    
    doTest("T7",
        "1650:CAD:2010111860;STRUCTURE FIRE;1110 N DIVISION ST;SALI;NAYLOR ST;UNION AVE",
        "ID:2010111860",
        "CALL:STRUCTURE FIRE",
        "ADDR:1110 N DIVISION ST",
        "CITY:SALISBURY",
        "X:NAYLOR ST & UNION AVE");
        
    doTest("T8",
        "1654:CAD:2010112048;STRUCTURE FIRE;413 CAMDEN CT;SALI;CAMDEN AVE;CAMDEN AVE;[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire.Caller Stat",
        "ID:2010112048",
        "CALL:STRUCTURE FIRE",
        "ADDR:413 CAMDEN CT",
        "CITY:SALISBURY",
        "X:CAMDEN AVE & CAMDEN AVE",
        "INFO:Structure Fire.Caller Stat");
    
    setDefaults("WICOMICO COUNTY", "");
    doTest("T10",
        "1644:CAD:2010111333;STRUCTURE FIRE;1103 STATE ST;DELM;HIGHLAND AVE;VIRGINIA AVE",
        "ID:2010111333",
        "CALL:STRUCTURE FIRE",
        "ADDR:1103 STATE ST",
        "CITY:DELMAR",
        "X:HIGHLAND AVE & VIRGINIA AVE");
    
    doTest("T11",
        "CAD:2010110683;PI ACCIDENT;8859 JERSEY RD;DELM;CONNELLY MILL RD;ADKINS RD;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 25 year old, Male,",
        "ID:2010110683",
        "CALL:PI ACCIDENT",
        "ADDR:8859 JERSEY RD",
        "CITY:DELMAR",
        "X:CONNELLY MILL RD & ADKINS RD",
        "INFO:25 year old, Male,");
  }
}