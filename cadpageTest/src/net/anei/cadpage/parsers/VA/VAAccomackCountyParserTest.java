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
        "ID:4345793096");

    doTest("T5",
        "CAD:MISSING PERSON STANDBY;26208 WALNUT TREE RD;EDEN MD;S UPPER FERRY RD;WALNUT TREE RD;4345793096",
        "CALL:MISSING PERSON STANDBY",
        "ADDR:26208 WALNUT TREE RD",
        "CITY:EDEN",
        "ST:MD",
        "X:S UPPER FERRY RD & WALNUT TREE RD",
        "ID:4345793096");
        
    doTest("T6",
        "CAD:MAN POWER SEARCH CHILD;698 MASSIE RD;CHARLOTTESVILLE VA;MASSIE RD;ARLINGTON BLVD;4345793096",
        "CALL:MAN POWER SEARCH CHILD",
        "ADDR:698 MASSIE RD",
        "CITY:CHARLOTTESVILLE",
        "ST:VA",
        "X:MASSIE RD & ARLINGTON BLVD",
        "ID:4345793096");

    doTest("T7",
        "CAD:BREATHING PROBLEMS;23610 NORTH ST;ONAN;A600;D3;HERMITAGE RD;GREENWAY CIR;HERMITAGE",
        "CALL:BREATHING PROBLEMS",
        "ADDR:23610 NORTH ST",
        "MAP:A600,D3",
        "X:HERMITAGE RD & GREENWAY CIR",
        "INFO:HERMITAGE");

    doTest("T8",
        "CAD:ABDOMINAL PAIN/BACK PAIN;33063 STONEY CREEK RD;ATLA;A27;C1;GENE WAYNE LN;FLEMING RD",
        "CALL:ABDOMINAL PAIN/BACK PAIN",
        "ADDR:33063 STONEY CREEK RD",
        "MAP:A27,C1",
        "X:GENE WAYNE LN & FLEMING RD");

    doTest("T9",
        "CAD:RESIDENTIAL STRUCTURE FIRE;7255 FLEMING RD;ATLA;A27;D1;KATHRYN RD;VERNON RD",
        "CALL:RESIDENTIAL STRUCTURE FIRE",
        "ADDR:7255 FLEMING RD",
        "MAP:A27,D1",
        "X:KATHRYN RD & VERNON RD");

    doTest("T10",
        "CAD:ABDOMINAL PAIN/BACK PAIN;33063 STONEY CREEK RD;ATLA;A27;C1;GENE WAYNE LN;FLEMING RD",
        "CALL:ABDOMINAL PAIN/BACK PAIN",
        "ADDR:33063 STONEY CREEK RD",
        "MAP:A27,C1",
        "X:GENE WAYNE LN & FLEMING RD");
  }
  
  @Test
  public void testNorthamptonParser() {

    doTest("T1",
        "CAD:ACCIDENT WITH INJURY;7446 OCCOHANNOCK NECK RD/CREEKVIEW RD;WARD;N5;D4",
        "CALL:ACCIDENT WITH INJURY",
        "ADDR:7446 OCCOHANNOCK NECK RD & CREEKVIEW RD",
        "MADDR:7446 OCCOHANNOCK NECK RD",
        "MAP:N5,D4");

    doTest("T2",
        "CAD:CARBON MONOXIDE DETECTOR;11478 PARK AVE;EXMO;N203;D6;JACKSON ST;HOLLY CIR",
        "CALL:CARBON MONOXIDE DETECTOR",
        "ADDR:11478 PARK AVE",
        "MAP:N203,D6",
        "X:JACKSON ST & HOLLY CIR");

    doTest("T3",
        "CAD:EMS UNIT FIRE INCIDENT STANDBY;7247 YOUNG ST;MACH;N33;C3;BAYSIDE RD;LANKFORD HWY;NORTHAMPTON MIDDLE SCHOOL",
        "CALL:EMS UNIT FIRE INCIDENT STANDBY",
        "ADDR:7247 YOUNG ST",
        "MAP:N33,C3",
        "X:BAYSIDE RD & LANKFORD HWY",
        "INFO:NORTHAMPTON MIDDLE SCHOOL");

    doTest("T4",
        "CAD:ELECTRICAL EQUIPMENT FIRE;10669 TB RD/BAYSIDE RD;EXMO;N10;C5",
        "CALL:ELECTRICAL EQUIPMENT FIRE",
        "ADDR:10669 TB RD & BAYSIDE RD",
        "MADDR:10669 TB RD",
        "MAP:N10,C5");
    
  }
  
  public static void main(String[] args) {
    new VAAccomackCountyParserTest().generateTests("T8");
  }
}