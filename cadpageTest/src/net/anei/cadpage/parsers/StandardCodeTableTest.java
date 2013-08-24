package net.anei.cadpage.parsers;

import static org.junit.Assert.*;

import net.anei.cadpage.parsers.CodeTable.Result;

import org.junit.Test;

public class StandardCodeTableTest {

  private static final CodeTable TABLE = new StandardCodeTable(
      "1A1A",   "BAD TUMMYACHE",
      "01A01b", "KNOCKED UP"
      );

  @Test
  public void testCodeTable() {

    assertNull(TABLE.getResult("ABC"));
    check("1A1 YAZZA", "1A1", "Abdominal pain", "YAZZA");
    check("1A1A BEEP BEEP", "1A1A", "BAD TUMMYACHE", "BEEP BEEP");
    check("01A01B", "01A01B", "KNOCKED UP", "");
    check("1a1a BEEP BEEP", "1a1a", "BAD TUMMYACHE", "BEEP BEEP");
    check("01a01b", "01a01b", "KNOCKED UP", "");
  }
  
  private void check(String text, String expCode, String expDesc, String expRemain) {
    Result res = TABLE.getResult(text);
    assertNotNull(text, res);
    assertEquals(text + ":code", expCode, res.getCode());
    assertEquals(text + ":desc", expDesc, res.getDescription());
    assertEquals(text + ":rem", expRemain, res.getRemainder());
  }

}
