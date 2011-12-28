package net.anei.cadpage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.anei.cadpage.SmsMmsMessage;
import net.anei.cadpage.parsers.MsgInfo;
import net.anei.cadpage.parsers.MsgParser;

import org.junit.Test;

public class SmsMmsMessageTest {
  
  @Test
  public void testEscape() {
    assertEquals("BIG RED ONE", SmsMmsMessage.escape("BIG RED ONE"));
    assertEquals("BIG RED ONE\\n\n\\tOVER THERE\\n\nSIX\\6sSPACES\\3s3", 
                 SmsMmsMessage.escape("BIG RED ONE\n\tOVER THERE\nSIX      SPACES   3"));
  }
  
  @Test
  public void testIncidentDate() {
    doTimeTest("Nothing", "12/13/2011 13:23:10", "", "", "12/13/2011 13:23:10");
    doTimeTest("full dt/time", "01/01/2012 13:23:10", "12/13/2011", "23:18:50",
                               "12/13/2011 23:18:50");
    doTimeTest("miss yr/sec", "01/01/2012 13:23:10", "01/12", "23:18",
                              "01/12/2011 23:18:00");
    doTimeTest("miss yr roll", "01/01/2012 13:23:10", "12/13", "23:18:20",
                               "12/13/2011 23:18:20");
    doTimeTest("no date", "01/01/2012 23:18:00", "", "23:18:50",
                          "01/01/2012 23:18:50");
    doTimeTest("no date roll", "01/01/2012 10:50:00", "", "23:18:50",
                               "12/31/2011 23:18:50");
  }
  
  private static final DateFormat DATE_FMT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
  private static void doTimeTest(String title, String base, 
                                   final String date, final String time, 
                                   String expect) {
    long timestamp = 0;
    try {
      timestamp = DATE_FMT.parse(base).getTime();
    } catch (ParseException ex) {
      ex.printStackTrace();
      fail("Parse error");
    }
    
    SmsMmsMessage msg = new SmsMmsMessage("", "", "", timestamp, 0);
    MsgParser parser = new MsgParser("", ""){
      @Override
      protected boolean parseMsg(String strMessage, MsgInfo.Data data) {
        data.strDate = date;
        data.strTime = time;
        return true;
      }
    };
    assertTrue(parser.isPageMsg(msg.getParseInfo(), 0));
    Date rDate = msg.getIncidentDate();
    String result = (rDate == null ? null : DATE_FMT.format(rDate));
    assertEquals(title, expect, result);
  }
}
