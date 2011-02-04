package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class FieldProgramParserTest extends BaseParserTest {
  
  private static final String[] CITY_LIST = new String[]{"KENSBURG", "KEN TOWN"};
  private static final String DEF_CITY = "STATE OF MIND";
  private static final String DEF_STATE = "XX";
  
  FieldProgramParser parser;
  
  public FieldProgramParserTest() {
    parser = new TestParser(CITY_LIST, DEF_CITY, DEF_STATE, "SKIP");
    setParser(parser, DEF_CITY, DEF_STATE);
  }
  
  @Test
  public void testproblem() {
  }
  
  @Test
  public void testBasicFields() {
    doFieldTest("Fields", 
        "CALL CALL SKIP PLACE ADDR CITY APT X X UNIT MAP ID PHONE INFO INFO SRC CODE NAME",
        "BLACK;BLUE;JUNK;TOWN;123 SOUTH;HOME;20;NORTH;SOUTH;CAR 22;MAPIT;666;222-1234;LINE1;LINE2;ST1;XXX;JOHN",
        "CALL:BLACK / BLUE",
        "PLACE:TOWN",
        "ADDR:123 SOUTH",
        "CITY:HOME",
        "APT:20",
        "X:NORTH & SOUTH",
        "UNIT:CAR 22",
        "MAP:MAPIT",
        "ID:666",
        "PHONE:222-1234",
        "INFO:LINE1 / LINE2",
        "SRC:ST1",
        "CODE:XXX",
        "NAME:JOHN");
  }
  
  @Test
  public void testFieldConditions() {
    
    doFieldTest("Address present",
        "ADDR? INFO", "US 30;LINE",
        "ADDR:US 30",
        "INFO:LINE");
    doFieldTest("Address absent",
        "ADDR? INFO", "LINE",
        "INFO:LINE");
    
    doFieldTest("City present",
        "CITY? INFO",
        "KEN TOWN;LIGHT",
        "CITY:KEN TOWN",
        "INFO:LIGHT");
    doFieldTest("City absent",
        "CITY? INFO",
        "LIGHT",
        "INFO:LIGHT");
    
    doFieldTest("Cross present",
        "X? INFO",
        "BLACK RD;LIGHT",
        "X:BLACK RD",
        "INFO:LIGHT");
    doFieldTest("Cross absent",
        "X? INFO",
        "LIGHT",
        "INFO:LIGHT");
    
    doFieldTest("ID present",
        "ID? INFO",
        "666;LIGHT",
        "ID:666",
        "INFO:LIGHT");
    doFieldTest("ID present",
        "ID? INFO",
        "LIGHT",
        "INFO:LIGHT");
    
    doFieldTest("INTLS 1",
        "INTLS? INFO",
        "XX;HELP",
        "INFO:HELP");
    doFieldTest("INTLS 2",
        "INTLS? INFO",
        "KEC;HELP",
        "INFO:HELP");
    doFieldTest("INTLS 3",
        "INTLS? INFO",
        "X;HELP",
        "INFO:X");
    doFieldTest("INTLS 4",
        "INTLS? INFO",
        "ab;HELP",
        "INFO:ab");
    
  }
  
  @Test
  public void testInfoAptField() {
    doFieldTest("T1", "INFO", "apt    201", "APT:201");
    doFieldTest("T2", "INFO", "aptnuk X", "INFO:aptnuk X");
    doFieldTest("T3", "INFO", "APT:16F", "APT:16F");
    doFieldTest("T4", "INFO", "APT# 30", "APT:30");
  }
  
  @Test
  public void testRequiredFields() {

    doFieldTest("All Fields", 
        "CALL CALL SKIP PLACE ADDR! CITY APT X X UNIT",
        "BLACK;BLUE;JUNK;TOWN;123 SOUTH;HOME;20;NORTH;SOUTH;CAR 22",
        "CALL:BLACK / BLUE",
        "PLACE:TOWN",
        "ADDR:123 SOUTH",
        "CITY:HOME",
        "APT:20",
        "X:NORTH & SOUTH",
        "UNIT:CAR 22");

    doFieldTest("Short fields", 
        "CALL CALL SKIP PLACE ADDR! CITY APT X X UNIT",
        "BLACK;BLUE;JUNK;TOWN;123 SOUTH",
        "CALL:BLACK / BLUE",
        "PLACE:TOWN",
        "ADDR:123 SOUTH");

    doFieldFail("Missing req field",
        "CALL CALL SKIP PLACE ADDR! CITY APT X X UNIT",
        "BLACK;BLUE;JUNK;TOWN");
    
    doFieldFail("Missing most everything",
        "CALL CALL SKIP PLACE ADDR! CITY APT X X UNIT",
        "NA");
  }
  
  @Test
  public void testOptionalFields() {
    
    doFieldTest("Optional field present",
        "CALL CITY? INFO",
        "HELLO DOLLY;KEN TOWN;BLUE LIGHT",
        "CALL:HELLO DOLLY",
        "CITY:KEN TOWN",
        "INFO:BLUE LIGHT");
    
    doFieldTest("Optional field absent",
        "CALL CITY? INFO",
        "HELLO DOLLY;BLUE LIGHT",
        "CALL:HELLO DOLLY",
        "INFO:BLUE LIGHT");
    
    doFieldTest("Triggered Optional field present",
        "CITY?% INFO",
        "%MYTOWN;MY LIFE",
        "CITY:MYTOWN",
        "INFO:MY LIFE");
    
    doFieldTest("Triggered Optional field absent",
        "CITY?% INFO",
        "KEN TOWN;MY LIFE",
        "INFO:KEN TOWN");
    
    doFieldTest("Deferred field present",
        "PLACE? CITY",
        "MACWORLD;KEN TOWN",
        "PLACE:MACWORLD",
        "CITY:KEN TOWN");
    
    doFieldTest("Deferred field absent",
        "PLACE? CITY INFO",
        "KEN TOWN;MY WAY",
        "CITY:KEN TOWN",
        "INFO:MY WAY");
    
    doFieldTest("Long deferred opt field present",
        "CALL PLACE? INFO INFO INFO CITY",
        "FIRE;LONGVIEW;LINE1;LINE2;LINE3;KEN TOWN",
        "CALL:FIRE",
        "PLACE:LONGVIEW",
        "INFO:LINE1 / LINE2 / LINE3",
        "CITY:KEN TOWN");
    
    doFieldTest("Long deferred opt field absent",
        "CALL PLACE? INFO INFO INFO CITY",
        "FIRE;LINE1;LINE2;LINE3;KEN TOWN",
        "CALL:FIRE",
        "INFO:LINE1 / LINE2 / LINE3",
        "CITY:KEN TOWN");
    
    doFieldTest("Optional field at end of program", "X?", "12");
  }
  
  @Test
  public void testRepeatFields() {
    
    doFieldTest("Infinite repeat field",
        "CALL PLACE INFO+",
        "HELP ME;AT HOME;SOMEWHERE;OVER THE RAINBOW;SKYS ARE BLUE",
        "CALL:HELP ME",
        "PLACE:AT HOME",
        "INFO:SOMEWHERE / OVER THE RAINBOW / SKYS ARE BLUE");
    
    doFieldTest("Conditional repeat field",
        "X+? INFO",
        "BLACK RD;WHITE ST;STONEVILLE",
        "X:BLACK RD & WHITE ST",
        "INFO:STONEVILLE");
    
    doFieldTest("Deferred conditional repeat field",
        "INFO+? ID",
        "LINE1;LINE2;LINE3;666",
        "INFO:LINE1 / LINE2 / LINE3",
        "ID:666");
    
    doFieldTest("Long deferred conditional repeat field",
        "INFO+? PLACE NAME ID",
        "LINE1;LINE2;LINE3;BIG HOUSE;KEN CORBIN;666",
        "INFO:LINE1 / LINE2 / LINE3",
        "PLACE:BIG HOUSE",
        "NAME:KEN CORBIN",
        "ID:666");
    
    doFieldTest("empty deferred conditional repeat field",
        "INFO+? PLACE NAME ID",
        "BIG HOUSE;KEN CORBIN;666",
        "PLACE:BIG HOUSE",
        "NAME:KEN CORBIN",
        "ID:666");
  }
  
  @Test
  public void testZQual() {
    
    doFieldTest("Without",
        "ADDR? CITY",
        "AVE OF WISDOM;KEN TOWN",
        "CITY:AVE OF WISDOM");
    
    doFieldTest("With",
        "ADDR:Z? CITY",
        "AVE OF WISDOM;KEN TOWN",
        "ADDR:AVE OF WISDOM",
        "CITY:KEN TOWN");
  }
  
  private void doFieldTest(String title, String program, String body, String ... result) {
    parser.setProgram(program);
    doTest(title, body, result);
    
  }
  
  private void doFieldFail(String title, String program, String body) {
    parser.setProgram(program);
    assertFalse(parser.parseMsg(body, new Data()));
  }
  
  private static class TestParser extends FieldProgramParser {

    public TestParser(String[] cities, String defCity, String defState, String programStr) {
      super(cities, defCity, defState, programStr);
    }

    @Override
    protected boolean parseMsg(String message, Data data) {
      return parseFields(message.split(";"), data);
    }
    
  }
}