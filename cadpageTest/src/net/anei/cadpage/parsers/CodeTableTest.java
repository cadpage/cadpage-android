package net.anei.cadpage.parsers;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeTableTest {

  @Test
  public void testCodeTable() {
    CodeTable table = new CodeTable(
        "01A",    "BIG MISTAKE",
        "02B",    "BROKEN FINGER",
        "02B3",   "BROKEN MIDDLE FINGER",
        "02B3R",  "BROKEN MIDDLE FINGER RIGHT HAND",
        "02B3L",  "BROKEN MIDDLE FINGER LEFT HAND"
        );
    
    assertNull(table.getCodeDescription("X1"));
    assertEquals("BIG MISTAKE", table.getCodeDescription("01A"));
    assertEquals("BIG MISTAKE", table.getCodeDescription("01A6"));
    assertEquals("BROKEN MIDDLE FINGER", table.getCodeDescription("02B3"));
    assertEquals("BROKEN MIDDLE FINGER RIGHT HAND", table.getCodeDescription("02B3R"));
  }

}
