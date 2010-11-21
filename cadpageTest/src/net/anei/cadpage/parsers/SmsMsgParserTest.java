package net.anei.cadpage.parsers;

import org.junit.Test;

import net.anei.cadpage.parsers.SmsMsgParser.Parser;

import static org.junit.Assert.*;


public class SmsMsgParserTest {

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
  }
}
