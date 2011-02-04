package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAAccomackCountyParser;

import org.junit.Test;


public class VAAccomackCountyParserTest extends BaseParserTest {
  
  public VAAccomackCountyParserTest() {
    setParser(new VAAccomackCountyParser(), "ACCOMACK COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CAD:STROKE;6225 HOLLAND RD;NEWC;A25;A6;DEBRA LN;R J DR",
        "CALL:STROKE",
        "ADDR:6225 HOLLAND RD",
        "MAP:A25,A6",
        "X:DEBRA LN & R J DR");

    doTest("T2",
        "CAD:ACCIDENT WITH INJURY;12432 LANKFORD HWY;HALL;A59;B6;FOX DR;JOHN TAYLOR RD",
        "CALL:ACCIDENT WITH INJURY",
        "ADDR:12432 LANKFORD HWY",
        "MAP:A59,B6",
        "X:FOX DR & JOHN TAYLOR RD");
    
    doTest("T3",
        "CAD:ABDOMINAL PAIN;15361 LANKFORD HWY;MAPP;A68;D4;GILLESPIE LN;SHERWOOD DR;MILE MARKER 125",
        "CALL:ABDOMINAL PAIN",
        "ADDR:15361 LANKFORD HWY",
        "MAP:A68,D4",
        "X:GILLESPIE LN & SHERWOOD DR",
        "INFO:MILE MARKER 125");

    doTest("T4",
        "CAD:MISSING PERSON DEPLOYMENT;2885 FOX HUNTERS RD;HARRINGTON DE;FOX HUNTERS RD;WHITELEYBURG RD;4345793096",
        "CALL:MISSING PERSON DEPLOYMENT",
        "ADDR:2885 FOX HUNTERS RD",
        "CITY:HARRINGTON",
        "ST:DE",
        "X:FOX HUNTERS RD & WHITELEYBURG RD",
        "INFO:4345793096");

    doTest("T5",
        "CAD:MISSING PERSON STANDBY;26208 WALNUT TREE RD;EDEN MD;S UPPER FERRY RD;WALNUT TREE RD;4345793096",
        "CALL:MISSING PERSON STANDBY",
        "ADDR:26208 WALNUT TREE RD",
        "CITY:EDEN",
        "ST:MD",
        "X:S UPPER FERRY RD & WALNUT TREE RD",
        "INFO:4345793096");
        
    doTest("T6",
        "CAD:MAN POWER SEARCH CHILD;698 MASSIE RD;CHARLOTTESVILLE VA;MASSIE RD;ARLINGTON BLVD;4345793096",
        "CALL:MAN POWER SEARCH CHILD",
        "ADDR:698 MASSIE RD",
        "CITY:CHARLOTTESVILLE",
        "ST:VA",
        "X:MASSIE RD & ARLINGTON BLVD",
        "INFO:4345793096");
  }
}