package net.anei.cadpage.parsers;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.CO.COAdamsCountyParser;
import net.anei.cadpage.parsers.CO.COBoulderCountyParser;
import net.anei.cadpage.parsers.CO.COWeldCountyParser;
import net.anei.cadpage.parsers.CO.CONorthglennEMSParser;
import net.anei.cadpage.parsers.NJ.NJMercerCountyParser;
import net.anei.cadpage.parsers.TX.TXMontgomeryCountyParser;
import net.anei.cadpage.parsers.general.GeneralParser;

import org.junit.Test;
import static org.junit.Assert.*;


public class GroupBestParserTest extends BaseParserTest {
  
  @Test
  public void testProblem() {
  }
  
  @Test
  public void testGeneralAlert() {
    
    setParser(new GroupBestParser(new GeneralParser(), new TXMontgomeryCountyParser()), "", "");
    setExpLocCode("TXMontgomeryCountyB");
    setDefaults("MONTGOMERY COUNTY", "TX");

    doTest("T17",
        "(CAD Message) 13-008577 - 7) 04/16/2013 18:45:46 18:45:46.000-[7] [Notification] [Woodlands Fire]-Problem changed from Fall to Unconscious/Fainting by Woodlands Fire [Shared]",
        "CALL:GENERAL ALERT",
        "ID:13-008577 - 7",
        "PLACE:[Woodlands Fire]-Problem changed from Fall to Unconscious/Fainting by Woodlands Fire",
        "DATE:04/16/2013",
        "TIME:18:45:46");
    
    setParser(new GroupBestParser(new GeneralParser(), new NJMercerCountyParser()), "", "");
    setExpLocCode("NJMercerCounty");
    setDefaults("MERCER COUNTY", "NJ");
    doTest("T2",
        "UNIT: LS6 ; LATE TURN-AROUND ;PLEASE CALL LIFECOMM WITH YOUR STATUS ; (#1\r\n",
        "UNIT:LS6",
        "CALL:GENERAL ALERT",
        "PLACE:LATE TURN-AROUND ;PLEASE CALL LIFECOMM WITH YOUR STATUS ; (#1");
  }
  
  @Test
  public void testRealParser() {
    
    MsgParser adamsParser = new COAdamsCountyParser();
    MsgParser weldCountyParser = new COWeldCountyParser();
    MsgParser northGlennParser = new CONorthglennEMSParser();
    MsgParser[] parsers = new MsgParser[]{ adamsParser, weldCountyParser, northGlennParser };
    setParser(new GroupBestParser(parsers), "", "");
    
    setExpLocCode(adamsParser.getParserCode());
    setDefaults("ADAMS COUNTY", "CO");
    doTest("ADAMS COUNTY",
        "Subject:IPS I/Page Notification E 64TH AVE/MONACO ST ADAM CCPD 09:51:48 TYPE CODE: ACCI CALLER NAME: TIME: 09:51:48 Comments: -104.90947",
        "ADDR:E 64TH AVE & MONACO ST",
        "CITY:COMMERCE CITY",
        "TIME:09:51:48",
        "CALL:ACCI",
        "INFO:-104.90947");

    setExpLocCode(weldCountyParser.getParserCode());
    setDefaults("WELD COUNTY", "CO");
    doTest("Weld County",
        "\" \" 24\nSIPF\nD\n3211 LUPTON AVE\nEV\n24\nMOM IS NOT WAKING UP 0000 Confirm 0001 Refuse TXT STOP to opt-out",
        "SRC:24",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:3211 LUPTON AVE",
        "SRC:EV",
        "UNIT:24",
        "INFO:MOM IS NOT WAKING UP 0000 Confirm 0001 Refuse");
    
    setExpLocCode(northGlennParser.getParserCode());
    setDefaults("ADAMS COUNTY", "CO");
    doTest("T1",
        "- part 1 of 1 / RC:Run# 10174/6211 OLIVE ST///Pregnancy / Childbirth/",
        "ID:10174",
        "ADDR:6211 OLIVE ST",
        "CALL:Pregnancy / Childbirth");
  }
  
  @Test
  public void testAliasedParser1() {
    setParser(new GroupBestParser(new COWeldCountyParser(), new COBoulderCountyParser()), "", "CO");
    setExpLocCode("COWeldCounty");
    doTest("Weld County",
        "\" \" 24\nSIPF\nD\n3211 LUPTON AVE\nEV\n24\nMOM IS NOT WAKING UP 0000 Confirm 0001 Refuse TXT STOP to opt-out",
        "SRC:24",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:3211 LUPTON AVE",
        "SRC:EV",
        "UNIT:24",
        "INFO:MOM IS NOT WAKING UP 0000 Confirm 0001 Refuse");
  }
  
  @Test
  public void testAliasedParser2() {
    setParser(new GroupBestParser(new COWeldCountyParser(), new COWeldCountyParser()), "WELD COUNTY", "CO");
    setExpLocCode("COWeldCounty");
    doTest("Weld County",
        "\" \" 24\nSIPF\nD\n3211 LUPTON AVE\nEV\n24\nMOM IS NOT WAKING UP 0000 Confirm 0001 Refuse TXT STOP to opt-out",
        "SRC:24",
        "CODE:SIPF",
        "CALL:SICK AND INJURED POLICE/FIRE",
        "ADDR:3211 LUPTON AVE",
        "SRC:EV",
        "UNIT:24",
        "INFO:MOM IS NOT WAKING UP 0000 Confirm 0001 Refuse");
  }
  
  @Test
  public void testSingleParser() {
    MsgParser parser = new TestParser("TESTA", "AFROM", "AA");
    
    int flgs = 0;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "AFROM", "BB");
    doTest(parser, flgs, "BFROM", "AA");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_GEN_ALERT;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "AFROM", "BB", "GeneralAlert", "GENERAL ALERT", "BB");
    doTest(parser, flgs, "BFROM", "AA");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT", "TESTA", "RUN REPORT","");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "AFROM", "BB");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_FORCE;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "AFROM", "BB", "GeneralAlert","GENERAL ALERT", "BB");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT", "TESTA", "RUN REPORT","");
  }
  
  public void testSingleLooseFilterParser() {
    MsgParser parser = new TestParser("TESTA", "AFROM", null);
    
    int flgs = 0;
    doTest(parser, flgs, "AFROM", "XX", "TESTA", "TESTA", "");
    doTest(parser, flgs, "XFROM", "XX");
    doTest(parser, flgs, "AFROM", "XX RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER;
    doTest(parser, flgs, "AFROM", "XX");
    doTest(parser, flgs, "XFROM", "XX");
    doTest(parser, flgs, "AFROM", "XX RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER | MsgParser.PARSE_FLG_POSITIVE_ID;
    doTest(parser, flgs, "AFROM", "XX", "TESTA", "TESTA", "");
    doTest(parser, flgs, "XFROM", "XX", "TESTA", "TESTA", "");
    doTest(parser, flgs, "AFROM", "XX RUN REPORT", "TESTA", "RUN REPORT", "");
  }
  
  public void testSingleLooseNoFilterParser() {
    MsgParser parser = new TestParser("TESTA", "", null);
    
    int flgs = 0;
    doTest(parser, flgs, "XFROM", "XX");
    doTest(parser, flgs, "XFROM", "XX RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER;
    doTest(parser, flgs, "XFROM", "XX");
    doTest(parser, flgs, "XFROM", "XX RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER | MsgParser.PARSE_FLG_POSITIVE_ID;
    doTest(parser, flgs, "XFROM", "XX", "TESTA", "TESTA", "");
    doTest(parser, flgs, "XFROM", "XX RUN REPORT", "TESTA", "RUN REPORT", "");
  }
  
  @Test
  public void testGroupParser1() {
    MsgParser parser = new GroupBestParser(new MsgParser[]{
        new TestParser("TESTA", "AFROM", "AA"),   
        new TestParser("TESTB", "BFROM", "BB"),   
    });
    
    int flgs = 0;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "AFROM", "BB");
    doTest(parser, flgs, "BFROM", "AA");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_GEN_ALERT;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "AFROM", "BB", "GeneralAlert", "GENERAL ALERT", "BB");
    doTest(parser, flgs, "BFROM", "AA", "GeneralAlert", "GENERAL ALERT", "AA");
    doTest(parser, flgs, "CFROM", "AA");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT", "TESTA", "RUN REPORT", "");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "AFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT");
    
    flgs = MsgParser.PARSE_FLG_FORCE;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "AFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC", "GeneralAlert", "GENERAL ALERT", "CC");
    doTest(parser, flgs, "AFROM", "AA RUN REPORT", "TESTA", "RUN REPORT", "");
  }
  
  @Test
  public void testGroupParser2() {
    MsgParser parser = new GroupBestParser(new MsgParser[]{
        new TestParser("TESTA", "AFROM", "AA"),   
        new TestParser("TESTB", "BFROM", null),   
    });
    
    int flgs = 0;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "AFROM", "BB");
    doTest(parser, flgs, "BFROM", "AA", "TESTB", "TESTB", "");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER | MsgParser.PARSE_FLG_POSITIVE_ID;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC", "TESTB", "TESTB", "");
    
    flgs = MsgParser.PARSE_FLG_GEN_ALERT;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTB", "TESTB", "");
    doTest(parser, flgs, "AFROM", "BB", "GeneralAlert", "GENERAL ALERT", "BB");
    doTest(parser, flgs, "CFROM", "AA");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER | MsgParser.PARSE_FLG_GEN_ALERT;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC");
    
    flgs = MsgParser.PARSE_FLG_FORCE;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC", "TESTB", "TESTB", "");
  }
  
  @Test
  public void testGroupParser3() {
    MsgParser parser = new GroupBestParser(new MsgParser[]{
        new TestParser("TESTA", "AFROM", "AA"),   
        new TestParser("TESTB", "", null),   
    });
    
    int flgs = 0;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB");
    doTest(parser, flgs, "AFROM", "BB");
    doTest(parser, flgs, "BFROM", "AA");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER | MsgParser.PARSE_FLG_POSITIVE_ID;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    
    flgs = MsgParser.PARSE_FLG_GEN_ALERT;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB");
    doTest(parser, flgs, "BFROM", "AA");
    doTest(parser, flgs, "AFROM", "BB", "GeneralAlert", "GENERAL ALERT", "BB");
    doTest(parser, flgs, "CFROM", "AA");
    
    flgs = MsgParser.PARSE_FLG_SKIP_FILTER | MsgParser.PARSE_FLG_GEN_ALERT;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC");
    
    flgs = MsgParser.PARSE_FLG_FORCE;
    doTest(parser, flgs, "AFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "BFROM", "BB", "TESTB", "TESTB", "");
    doTest(parser, flgs, "CFROM", "AA", "TESTA", "TESTA", "");
    doTest(parser, flgs, "CFROM", "CC", "TESTB", "TESTB", "");
  }
  

  private void doTest(MsgParser parser, int flags, String address, String body) {
    TestMessage msg = new TestMessage(address, body);
    assertFalse("pass", parser.isPageMsg(msg, flags));
  }
  
  private void doTest(MsgParser parser, int flags, String address, String body,
                      String expParser, String expCall, String expPlace) {
    
    TestMessage msg = new TestMessage(address, body);
    assertTrue("fail", parser.isPageMsg(msg, flags));
    assertEquals("parser", expParser, msg.getLocationCode());
    assertEquals("call", expCall, msg.getInfo().getCall());
    assertEquals("place", expPlace, msg.getInfo().getPlace());
  }
  
  @Test
  public void testAliasing1() {
    MsgParser parser = new GroupBestParser(
        new TestGroupParser("BENTON COUNTY", "OR", "111,222", "P1", "XX"),
        new TestGroupParser("BENTON COUNTY", "OR", "111,222", "P2", "XX")
    );
    assertEquals("Filter", "111,222", parser.getFilter());
    assertEquals("Locname", "Benton County, OR", parser.getLocName());
    doAliasTest(parser, "111", "BENTON COUNTY", "OR");
    doAliasFail(parser, "333");
  }
  
  @Test
  public void testAliasing2() {
    MsgParser parser = new GroupBestParser(
        new TestGroupParser("BENTON COUNTY", "OR", "111,222", "P1", "XX"),
        new TestGroupParser("LINN COUNTY", "OR", "111,333", "P2", "XX")
    );
    assertEquals("Filter", "111,222,333", parser.getFilter());
    assertEquals("Locname", "", parser.getLocName());
    doAliasTest(parser, "111", "", "OR");
    doAliasTest(parser, "222", "", "OR");
    doAliasTest(parser, "333", "", "OR");
    doAliasFail(parser, "444");
  }
  
  private void doAliasTest(MsgParser parser, String sender, String expCity, String expState) {
    Message msg = new Message(false, sender, "TEST SUBJECT", "TEST MSG");
    assertTrue("Msg parse failed", parser.isPageMsg(msg, 0));
    MsgInfo info = msg.getInfo();
    assertEquals("CALL", "AOK", info.getCall());
    assertEquals("DCITY", expCity, info.getDefCity());
    assertEquals("DST", expState, info.getDefState());
  }
  
  private void doAliasFail(MsgParser parser, String sender) {
    Message msg = new Message(false, sender, "TEST SUBJECT", "TEST MSG");
    assertFalse("Msg parse did not fail", parser.isPageMsg(msg, 0));
  }

  // Test message that retains location code
  private static class TestMessage extends Message {
    private String location;

    public TestMessage(String address, String body) {
      super(false, address, "", body);
    }
    
    @Override
    protected void setLocationCode(String location) {
      this.location = location;
    }
    
    public String getLocationCode() {
      return location;
    }
  }
  
  // Test message parser used to build test Group parsers
  private static class TestParser extends MsgParser {
    
    private String name;
    private String filter;
    private String key;
    
    public TestParser(String name, String filter, String key) {
      super("", "");
      this.name = name;
      this.filter = filter;
      this.key = key;
    }
    
    @Override
    public String getFilter() {
      return filter;
    }

    @Override
    public String getParserCode() {
      return name;
    }
    
    @Override
    public boolean parseMsg(String body, Data data) {
      if (key == null) {
        if (!isPositiveId()) return false;
      } else {
        if (!body.startsWith(key)) return false;
      }
      if (body.contains("RUN REPORT")) {
        data.strCall = "RUN REPORT";
      } else {
        data.strCall = name;
      }
      return true;
    }
  }
  
  private static class TestGroupParser extends MsgParser {
    
    private String filter;
    private String parserCode;
    private String aliasCode;
    
    public TestGroupParser(String defCity, String defState, String filter, String parserCode, String aliasCode) {
      super(defCity, defState);
      this.filter = filter;
      this.parserCode = parserCode;
      this.aliasCode = aliasCode;
    }

    @Override
    public String getFilter() {
      return filter;
    }
    
    @Override
    public String getParserCode() {
      return parserCode;
    }
    
    @Override
    public String getAliasCode() {
      return aliasCode;
    }

    @Override
    protected boolean parseMsg(String strMessage, Data data) {
      data.strCall = "AOK";
      return true;
    }
  }
}