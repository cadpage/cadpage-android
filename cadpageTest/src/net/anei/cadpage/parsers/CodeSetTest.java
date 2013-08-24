package net.anei.cadpage.parsers;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeSetTest {

  @Test
  public void testCodeTable() {
    CodeSet table = new CodeSet(
        "RACELAND",
        "01",
        "01A",
        "02B"
        );
    
    assertEquals("01C", "01", table.getCode("01C"));

    assertNull(table.getCode("X1"));
    assertEquals("RACELAND", "RACELAND", table.getCode("RACELAND"));
    assertEquals("RACELAND1", "RACELAND", table.getCode("RACELAND1"));
    assertEquals("RACELAND,", "RACELAND", table.getCode("RACELAND,BEEP BEEP"));
    assertEquals("01AB", "01A", table.getCode("01AB"));
    assertEquals("01C", "01", table.getCode("01C"));
  }

}
