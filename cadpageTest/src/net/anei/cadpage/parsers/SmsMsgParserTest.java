package net.anei.cadpage.parsers;

import org.junit.Test;

import net.anei.cadpage.parsers.SmsMsgParser.Parser;

import static org.junit.Assert.*;


public class SmsMsgParserTest {

  @Test
  public void testParser() {
    Parser parser = new Parser("Hey baby, light my fire: for :: sake Johny");
    assertEquals("T0", null, parser.getOptional(';'));
    assertEquals("T1", "Hey baby", parser.getOptional(','));
    assertEquals("T2", "light", parser.get(' '));
    assertEquals("T3", "my fire: for", parser.get("::"));
    assertEquals("T4", "sake Johny", parser.get());
  }
}
