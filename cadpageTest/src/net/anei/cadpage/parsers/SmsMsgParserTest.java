package net.anei.cadpage.parsers;

import java.util.Properties;
import java.util.regex.Pattern;

import org.junit.Test;

import net.anei.cadpage.parsers.OR.ORBentonCountyParser;
import net.anei.cadpage.parsers.MsgParser.Parser;

import static org.junit.Assert.*;


public class SmsMsgParserTest {
  
  @Test
  public void testProblems() {
    
    doKeyTest("T5",
        "JUNK CALL : MY CALL NEW TYPE : HELLO OLD TYPE : ONE TIME OLD",
        "CALL:MY CALL",
        "NEW TYPE:HELLO",
        "OLD TYPE:ONE TIME OLD");
  }
  
  @Test
  public void testParserCode() {
    MsgParser parser = new ORBentonCountyParser();
    assertEquals("ORBentonCounty", parser.getParserCode());
  }

  @Test
  public void testParser() {
    Parser parser = new Parser("Hey baby, light my fire: for :: sake Johny");
    assertEquals("TA0", "", parser.getOptional(';'));
    assertEquals("TA1", "Hey baby", parser.getOptional(','));
    assertEquals("TA2", "light", parser.get(' '));
    assertEquals("TA3", "my fire: for", parser.get("::"));
    assertEquals("TA4", "sake Johny", parser.get());
    
    parser.init("ONE TWO THREE");
    assertEquals("TB1", "ONE", parser.get(' '));
    assertEquals("TB2", "TWO", parser.get(' '));
    assertEquals("TB3", "THREE", parser.get(' '));
    assertEquals("TB4", "", parser.get(' '));
    
    parser.init("ONE TWO THREE");
    assertEquals("TB1", "THREE", parser.getLast(' '));
    assertEquals("TB2", "TWO", parser.getLast(' '));
    assertEquals("TB3", "ONE", parser.getLast(' '));
    assertEquals("TB4", "", parser.getLast(' '));
    
    parser.init("ONE TWO THREE");
    assertEquals("TC1", "ONE", parser.get(' '));
    assertEquals("TC2", "THREE", parser.getLast(' '));
    assertEquals("TC3", "TWO", parser.getLast(' '));
    assertEquals("TC4", "", parser.getLast(' '));
    
    parser.init("ONE TWO THREE");
    assertEquals("TD1", "THREE", parser.getLast(' '));
    assertEquals("TD2", "TWO", parser.getLast(' '));
    assertEquals("TD3", "ONE", parser.getLast(' '));
    assertEquals("TD4", "", parser.getLast(' '));
    
    parser.init("BEGIN ABC!DEF END");
    assertEquals("TE1", "BEGIN ABC", parser.get("!"));
    assertEquals("TE2", "", parser.getOptional("!DE"));
    assertEquals("TE2", "", parser.getLastOptional("!DE"));
    assertEquals("TE3", "F END", parser.getLastOptional("DE"));
    
    parser.init("BEGIN ABC!DEF END");
    assertEquals("TE1", "DEF END", parser.getLast("!"));
    assertEquals("TE2", "", parser.getLastOptional("BC!"));
    assertEquals("TE2", "", parser.getOptional("BC!"));
    assertEquals("TE3", "BEGIN A", parser.getOptional("BC"));
    
    Pattern ptn = Pattern.compile("(?:-[AB]LS *)?\\d\\d:\\d\\d");
    parser.init("Something 23:17 else comes-BLS 22:22 from here");
    assertEquals("TP1", "Something", parser.get(ptn));
    assertEquals("TP2", "else comes", parser.get(ptn));
    assertEquals("TP3", "from here", parser.get(ptn));
  }
  
  private static String[] KEYWORDS = new String[]{"CALL", "NEW TYPE", "OLD TYPE", "INFO"};

  @Test
  public void testParseKeywords() {

    doKeyTest("T1", 
        "JUNK CALL:MY CALL NEW TYPE:HELLO OLD TYPE:ONE TIME INFO: ITS A BIG WORLD",
        "CALL:MY CALL",
        "NEW TYPE:HELLO",
        "OLD TYPE:ONE TIME",
        "INFO:ITS A BIG WORLD");

    doKeyTest("T2", 
        "JUNK CALL:MY CALL NEW TYPE:HELLO OLD TYPE:ONE TIME INFO:",
        "CALL:MY CALL",
        "NEW TYPE:HELLO",
        "OLD TYPE:ONE TIME",
        "INFO:");

    doKeyTest("T3", 
        "JUNK CALL:MY CALL OLD TYPE:ONE TIME INF",
        "CALL:MY CALL",
        "OLD TYPE:ONE TIME");

    doKeyTest("T3", 
        "CALL:MY CALL NEW TYPE: HELLO OLD TYP",
        "CALL:MY CALL",
        "NEW TYPE:HELLO");

    doKeyTest("T4", 
        "JUNK CALL:MY CALL NEW TYPE:HELLO OLD TYPE:ONE TIME CALL",
        "CALL:MY CALL",
        "NEW TYPE:HELLO",
        "OLD TYPE:ONE TIME CALL");

    doKeyTest("T4", 
        "JUNK CALL:MY CALL NEW TYPE:HELLO OLD TYPE:ONE TIME OLD",
        "CALL:MY CALL",
        "NEW TYPE:HELLO",
        "OLD TYPE:ONE TIME OLD");
    
    doKeyTest("T5",
        "JUNK CALL : MY CALL NEW TYPE : HELLO OLD TYPE : ONE TIME OLD",
        "CALL:MY CALL",
        "NEW TYPE:HELLO",
        "OLD TYPE:ONE TIME OLD");
  }

  private void doKeyTest(String title, String test, String ... results) {
    doKeyTest(title, test, KEYWORDS, results);
  }

  private void doKeyTest(String title, String test, String[] keywords, String ... results) {
    Properties props = MsgParser.parseMessage(test, keywords);
    checkProperties(title, results, props);
  }

  private void checkProperties(String title, String[] results, Properties props) {
    for (String result : results) {
      int pt = result.indexOf(':');
      String key = result.substring(0, pt);
      String val = result.substring(pt+1);
      assertEquals(title +':' + key, val, props.get(key));
    }
    
    assertEquals(title + ":count", results.length, props.size());
  }
}
