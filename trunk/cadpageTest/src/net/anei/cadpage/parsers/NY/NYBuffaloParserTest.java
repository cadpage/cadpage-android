package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYBuffaloParserTest extends BaseParserTest {
  
  public NYBuffaloParserTest() {
    setParser(new NYBuffaloParser(), "BUFFALO", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "RC:Run# 4330/1 Hot 911 & Pvt/28B1 Stroke/CVA-unknown status/189 LANGFIELD DR///BUFFALO/14215////14:18/<Unknown>////X=TOWER ST&SUFFOLK ST",
        "CALL:28B1 Stroke / CVA-unknown status",
        "ADDR:189 LANGFIELD DR",
        "CITY:BUFFALO",
        "ID:14215",
        "X:TOWER ST&SUFFOLK ST");

    doTest("T2",
        "RC:Run# 3992/1 Hot 911 & Pvt/29B1 Traffic/Transport Accidents-injuries/E  LOVEJOY ST & N  OGDEN ST///BUFFALO/14206////17:35/<Unknown>////X=SCHILLER ST&N OGDEN",
        "CALL:29B1 Traffic / Transport Accidents-injuries",
        "ADDR:E  LOVEJOY ST & N  OGDEN ST",
        "CITY:BUFFALO",
        "ID:14206",
        "X:SCHILLER ST&N OGDEN");

    doTest("T3",
        "RC:Run# 4364/1 Hot 911 & Pvt/6C1 Breathing Problems-abnormal breathing/2128 ELMWOOD AVE///BUFFALO/14207////15:57/<Unknown>////X=HINMAN ST&DRIVEWAY",
        "CALL:6C1 Breathing Problems-abnormal breathing",
        "ADDR:2128 ELMWOOD AVE",
        "CITY:BUFFALO",
        "ID:14207",
        "X:HINMAN ST&DRIVEWAY");

    doTest("T4",
        "RC:Run# 4330/1 Hot 911 & Pvt/28B1 Stroke/CVA-unknown status/189 LANGFIELD DR///BUFFALO/14215////14:18/<Unknown>////X=TOWER ST&SUFFOLK ST",
        "CALL:28B1 Stroke / CVA-unknown status",
        "ADDR:189 LANGFIELD DR",
        "CITY:BUFFALO",
        "ID:14215",
        "X:TOWER ST&SUFFOLK ST");

    doTest("T5",
        "RC:Run# 3969/2 Cold  911/26A01 Sick-no priority symptoms(not 2-28)/BAILEY AVE & GENESEE ST///BUFFALO/14211////16:39/<Unknown>////X=WARRING AVE&USHY 62",
        "CALL:26A01 Sick-no priority symptoms(not 2-28)",
        "ADDR:BAILEY AVE & GENESEE ST",
        "CITY:BUFFALO",
        "ID:14211",
        "X:WARRING AVE&USHY 62");

    doTest("T6",
        "RC:Run# 3926/1 Hot 911 & Pvt/27B2 Stab/GSW/Penetrating Trauma-single peripheral wound/192 DAVIDSON AVE///BUFFALO/14215////14:49/<Unknown>////X=GODFREY ST&ORLEANS ST",
        "CALL:27B2 Stab / GSW / Penetrating Trauma-single peripheral wound",
        "ADDR:192 DAVIDSON AVE",
        "CITY:BUFFALO",
        "ID:14215",
        "X:GODFREY ST&ORLEANS ST");

    doTest("T7",
        "RC:Run# 3449/2 Cold  911/13A1 Diabetic-alert/behaving normally/1250 BAILEY AVE///BUFFALO/14206////07:50/<Unknown>////X=BOGARDUS ST&HENNEPIN ST",
        "CALL:13A1 Diabetic-alert / behaving normally",
        "ADDR:1250 BAILEY AVE",
        "CITY:BUFFALO",
        "ID:14206",
        "X:BOGARDUS ST&HENNEPIN ST");

    doTest("T8",
        "RC:Run# 929/1 Hot 911 & Pvt/9E1 Cardiac/Resp Arrest/DOA-not breathing at all/69 SIDNEY ST///BUFFALO/14211////09:44/<Unknown>////X=FILLMORE AVE&RICKERT AVE",
        "CALL:9E1 Cardiac / Resp Arrest / DOA-not breathing at all",
        "ADDR:69 SIDNEY ST",
        "CITY:BUFFALO",
        "ID:14211",
        "X:FILLMORE AVE&RICKERT AVE");
  }
  
  public static void main(String[] args) {
    new NYBuffaloParserTest().generateTests("T1");
  }
}