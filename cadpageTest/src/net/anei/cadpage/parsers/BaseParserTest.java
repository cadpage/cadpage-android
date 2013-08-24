package net.anei.cadpage.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public abstract class BaseParserTest {
  
  // Dummy parser class used as a placeholder to resolve compile references 
  // in dummy skeleton test classes
  protected class DummyParser extends MsgParser {
    public DummyParser() {
      super("", "");
      setFieldList("CALL");
    }
    protected boolean parseMsg(String body, Data data) {
      data.strCall = "DummyParser invoked from test class";
      return true;
    }
  }
  
  private static final String FROM_ADDRESS = "1112223333";
  private static final int PARSE_FLAGS = MsgParser.PARSE_FLG_TEST_MODE | 
                                            MsgParser.PARSE_FLG_POSITIVE_ID | 
                                            MsgParser.PARSE_FLG_SKIP_FILTER;
  
  private static final String[] RUN_REPORT_TERMS = "CALL SRC ID UNIT PLACE DATE TIME INFO".split(" ");

  private MsgParser parser = null;
  private String defCity;
  private String defState;
  private String fromAddress = FROM_ADDRESS;
  private boolean skipBadTest = false;
  private String parserLocCode = null;
  private String parserMapCode = null;
  
  public void setParser(MsgParser parser, String defCity, String defState) {
    setParser(parser);
    this.defCity = defCity;
    this.defState = defState;
  }
  
  public void setParser(MsgParser parser) {
    // If parser is set twice, assume this is a group parser test
    // in which case bad message tests that should fail for the target parser
    // might be passed by another parser in the group.  Also if we are called
    // multiple times, we want the parse location code to match the code
    // reported by the first parser
    if (this.parser != null) skipBadTest = true;
    this.parser = parser;
    if (parserLocCode == null) parserLocCode = parserMapCode = parser.getParserCode();
  }
  
  public void setExpLocCode(String parserLocCode) {
    this.parserLocCode = parserLocCode;
    this.parserMapCode = parserLocCode;
  }
  
  public void setExpMapCode(String parserMapCode) {
    this.parserMapCode = parserMapCode;
  }
  
  public void setDefaults(String defCity, String defState) {
    this.defCity = defCity;
    this.defState = defState;
  }
  
  public void setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
  }
  
  @Before
  public void baseSetup() {
    this.setFromAddress(FROM_ADDRESS);
  }
  
  @Test
  public void testBadMsg() {
    if (parser == null) return;
    // Just call the parser with a badly formated msg and make sure it doesn't croak
    checkError("BAD MSG");
    checkError("");
  }
  
  private void checkError(String test) {
    parser.isPageMsg(new Message(true, fromAddress, "", test), PARSE_FLAGS);
  }
  
  public void doBadTest(String test) {
    if (skipBadTest) return;
    Message msg = new Message(true, fromAddress, "", test);
    assertFalse(parser.isPageMsg(msg, PARSE_FLAGS));
  }
  
  /**
   * Main parse test method
   * @param title - test name
   * @param test - test message
   * @param result - expected results
   */
  public void doTest(String title, String test, String ... result) {
    doSubTest(title, "", test, result);
  }
  
  /**
   * Main parse test method
   * @param title - test name
   * @param chkMapAddr - true if map addresses should be checked
   * @param test - test message
   * @param result - expected results
   */
  public void doTest(String title, boolean chkMapAddr, String test, String ... result) {
    doSubTest(title, chkMapAddr, "", test, result);
  }
  
  /**
   * Main parse test method
   * @param title - test name
   * @param subject - test subject
   * @param test - test message
   * @param result - expected results
   */
  public void doSubTest(String title, String subject, String test, String ... result) {
    doSubTest(title, true, subject, test, result);
  }
    
  
  /**
   * Main parse test method
   * @param title - test name
   * @param chkMapAddr - true if map addresses should be checked
   * @param subject - test subject
   * @param test - test message
   * @param result - expected results
   */
  public void doSubTest(String title, boolean chkMapAddr, String subject, String test, String ... result) {
    
    if (subject.length() == 0 && test.startsWith("{")) {
      int pt = test.indexOf('}');
      subject = test.substring(1,pt);
      test = test.substring(pt+1).trim();
    }
    
    TestMessage msg = new TestMessage(true, fromAddress, subject, test);
    assertTrue(title + ":parse", parser.isPageMsg(msg, PARSE_FLAGS));
    doMsgTest(title, chkMapAddr, msg, result);
  }
  
  /**
   * The real main parse method.  Call can pass any subclass of Message.  Message
   * object must have been parsed prior to call.
   * @param title - test name
   * @param chkMapAddr - true if map addresses should be checked
   * @param msg - parsed message
   * @param result - expected results
   */
  protected void doMsgTest(String title, boolean chkMapAddr, Message msg, String...result) {
    
    MsgInfo.Data data = new MsgInfo.Data(null);
    String expMapAddr = "";
    String expMapCity = "";
    for (String str : result) {
      int pt = str.indexOf(':');
      String sType = str.substring(0, pt);
      str = str.substring(pt+1);
      if (sType.equals("CALL")) data.strCall = str;
      else if (sType.equals("PLACE")) data.strPlace = str;
      else if (sType.equals("ADDR")) data.strAddress = str;
      else if (sType.equals("MADDR")) expMapAddr = str;
      else if (sType.equals("CITY")) data.strCity = str;
      else if (sType.equals("MCITY")) expMapCity = str;
      else if (sType.equals("APT")) data.strApt = str;
      else if (sType.equals("X")) data.strCross = str;
      else if (sType.equals("BOX")) data.strBox = str;
      else if (sType.equals("UNIT")) data.strUnit = str;
      else if (sType.equals("ST")) data.strState = str;
      else if (sType.equals("MAP")) data.strMap = str;
      else if (sType.equals("ID")) data.strCallId = str;
      else if (sType.equals("PHONE")) data.strPhone = str;
      else if (sType.equals("INFO")) data.strSupp = str;
      else if (sType.equals("SRC")) data.strSource = str;
      else if (sType.equals("CODE")) data.strCode = str;
      else if (sType.equals("NAME")) data.strName = str;
      else if (sType.equals("PRI")) data.strPriority = str;
      else if (sType.equals("CH")) data.strChannel = str;
      else if (sType.equals("GPS")) data.strGPSLoc = str;
      else if (sType.equals("DATE")) data.strDate = str;
      else if (sType.equals("TIME")) data.strTime = str;
      else if (sType.equals("URL")) data.strInfoURL = str;
      else fail("Keyword " + sType + " is not defined");
    }
    if (parserLocCode != null) {
      assertEquals(title + ":location", parserLocCode, msg.getLocationCode());
    }
    MsgInfo info = msg.getInfo();
    if (parserMapCode != null) {
      assertEquals(title + ":mapParser", parserMapCode, info.getParser().getParserCode());
    }
    
    // Calculate reported map address.  GPS coordinate conversion doesn't get
    // handled by the regular getBaseMapAddress() method.  We will detect it
    // by calling getMapAddress() and using its results if it doesn't start with
    // the value returned by getBaseMapAddress()
    String actMapAddr = "";
    String actMapCity = "";
    if (chkMapAddr) {
      String longMapAddr = info.getMapAddress(2, "XXXX", "XX");
      actMapAddr = info.getBaseMapAddress(2);
      if (longMapAddr != null && !longMapAddr.startsWith(actMapAddr)) actMapAddr = longMapAddr;
      if (actMapAddr.equals(info.getAddress())) actMapAddr = "";
      
      actMapCity = info.getMapCity();
      if (actMapCity.equals(info.getCity())) actMapCity = "";
    }
    
    assertEquals(title + ":Call", data.strCall, info.getCall());
    assertEquals(title + ":Place", data.strPlace, info.getPlace());
    assertEquals(title + ":Address", data.strAddress, info.getAddress());
    assertEquals(title + ":MapAddr", expMapAddr, actMapAddr);
    assertEquals(title + ":City", data.strCity, info.getCity());
    assertEquals(title + ":MapCity", expMapCity, actMapCity);
    assertEquals(title + ":Apt", data.strApt, info.getApt());
    assertEquals(title + ":Cross", data.strCross, info.getCross());
    assertEquals(title + ":Box", data.strBox, info.getBox());
    assertEquals(title + ":Unit", data.strUnit, info.getUnit());
    assertEquals(title + ":State", data.strState, info.getState());
    assertEquals(title + ":Map", data.strMap, info.getMap());
    assertEquals(title + ":ID", data.strCallId, info.getCallId());
    assertEquals(title + ":Phone", data.strPhone, info.getPhone());
    assertEquals(title + ":Supp", data.strSupp, info.getSupp());
    assertEquals(title + ":Src", data.strSource, info.getSource());
    assertEquals(title + ":Code", data.strCode, info.getCode());
    assertEquals(title + ":Name", data.strName, info.getName());
    assertEquals(title + ":Pri", data.strPriority, info.getPriority());
    assertEquals(title + ":Ch", data.strChannel, info.getChannel());
    assertEquals(title + ":GPS", data.strGPSLoc, info.getGPSLoc());
    assertEquals(title + ":Date", data.strDate, info.getDate());
    assertEquals(title + ":Time", data.strTime, info.getTime());
    assertEquals(title + ":URL", data.strInfoURL, info.getInfoURL());
    
    assertEquals(title + ":DefCity", defCity, info.getDefCity());
    assertEquals(title + ":DefState", defState, info.getDefState());
  }
  
  private static class TestMessage extends Message {

    private String location = null;
    
    public TestMessage(boolean preParse, String fromAddress, String subject, String body) {
      super(preParse, fromAddress, subject, body);
    }

    @Override
    protected void setLocationCode(String location) {
      this.location = location;
    }

    @Override
    public String getLocationCode() {
      return location;
    }
    
    
    
    
  }
  
  private static final Map<String,String> KEYWORD_MAP = new HashMap<String,String>(); 
  static {
    KEYWORD_MAP.put("CALL", "CALL");
    KEYWORD_MAP.put("PLACE", "PLACE");
    KEYWORD_MAP.put("ADDR", "ADDR");
    KEYWORD_MAP.put("CITY", "CITY");
    KEYWORD_MAP.put("APT", "APT");
    KEYWORD_MAP.put("X", "X");
    KEYWORD_MAP.put("BOX","BOX");
    KEYWORD_MAP.put("UNIT", "UNIT");
    KEYWORD_MAP.put("ST", "ST");
    KEYWORD_MAP.put("MAP", "MAP");
    KEYWORD_MAP.put("ID", "ID");
    KEYWORD_MAP.put("PHONE", "PHONE");
    KEYWORD_MAP.put("INFO", "INFO");
    KEYWORD_MAP.put("SRC", "SRC");
    KEYWORD_MAP.put("CODE", "CODE");
    KEYWORD_MAP.put("NAME", "NAME");
    KEYWORD_MAP.put("PRI", "PRI");
    KEYWORD_MAP.put("CH", "CH");
    KEYWORD_MAP.put("GPS", "GPS");
    KEYWORD_MAP.put("DATE", "DATE");
    KEYWORD_MAP.put("TIME", "TIME");
    KEYWORD_MAP.put("URL", "URL");
  }
  
  /**
   * Generate test code for current parser from text string read from stdin
   */
  public void generateTests() {
    generateTests("T1", null, false);
  }
  
  /**
   * Generate test code for current parser from text string read from stdin
   * @param title title of first test
   */
  public void generateTests(String title) {
    generateTests(title, null, false);
  }
  
  
  /**
   * Generate test code for current parser from text string read from stdin
   * @param title title of first test
   * @param fieldNames list of field names to report
   * @deprecated Parsers should define field names with MsgParser.setFieldNames()
   */
  public void generateTests(String title, String fieldNames) {
    generateTests(title, fieldNames, false);
  }
  
  
  /**
   * Specialized test generator used to identify which subparser in a group parser
   * is accepting messages that ought not be accepted
   * @param parser parser to be checked
   */
  public void generateTests(MsgParser parser) {
    setParser(parser);
    generateTests("T1", "LOCCODE", true);
  }
  
  /**
   * Generate test code for current parser from text string read from stdin
   * @param title title of first test
   * @param fieldNames list of field names to report
   * @param skipFailures true to skip reporting of test failures
   */
  public void generateTests(String title, String fieldNames, boolean skipFailures) {
    
    // Read list of test strings
    String[] testMsgs = getTestMsgs();
    
    // And generate a test for each test string
    for (String testMsg : testMsgs) {
      generateTest(title, testMsg, fieldNames, skipFailures);
      title = incTitle(title);
    }
  }

  /**
   * Get a list of test messages. terminated by a blank line or EOF
   * @return array of test messages
   */
  private String[] getTestMsgs() {
    
    BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));
    
    List<String> msgList = new ArrayList<String>();
    System.out.println("Enter test messages, terminated by an empty line");
    while (true) {
      String line = null;
      try { line = ir.readLine(); } catch (IOException ex) {};
      if (line == null) break;
      if (line.trim().length() == 0) break;
      line = line.replace("\\n", "\n");
      line = line.replace("\\r", "\r");
      msgList.add(line);
    }
    return msgList.toArray(new String[msgList.size()]);
  }

  /**
   * Write one test code to stdout
   * @param title test title
   * @param test text message to be tested
   * @param terms list of expected value names
   * @param skipFailures - true to skip parse failure notices
   */
  private void generateTest(String title, String test, String fieldNames, boolean skipFailures) {
    
    String subject = "";
    String msgText = test;
    if (test.startsWith("{")) {
      int pt = test.indexOf('}');
      subject = test.substring(1, pt);
      msgText = test.substring(pt+1).trim();
    }
    Message msg = new Message(true, fromAddress, subject, msgText);
    if (!parser.isPageMsg(msg, PARSE_FLAGS)) {
      if (!skipFailures) {
        System.out.println();
        System.out.println("// ************************ PARSE FAILURE *****************************");
        System.out.println("// " + test.replace("\n", "\\n\n// ").replace("\r", "\\r"));
      }
      return;
    }
    
    // Get the list of field terms to use for this test
    MsgInfo info = msg.getInfo();
    String call = info.getCall();
    String[] terms;
    if (call.equals("GENERAL ALERT") || call.equals("RUN REPORT")) {
      terms = RUN_REPORT_TERMS;
    }
    else if (fieldNames != null) {
      terms = fieldNames.split(" +");
    } else {
      terms = getTestTerms();
    }
    
    System.out.println();
    System.out.println("    doTest(\"" + title + "\",");
    String brk = "";
    String[] lines = breakLines(test);
    for (String line : lines) {
      System.out.print(brk + "        \"" + escape(line) + "\"");
      brk = " +\n";
    }
    System.out.println(",");
    if (lines.length > 1) System.out.println();
    brk = "";
    for (int jj = 0; jj<terms.length; jj++) {
      String term = terms[jj];
      String value = getValue(info, term);
      if (value.length() == 0) continue;
      System.out.print(brk + "        \"" + term + ":" + escape(value) + "\"");
      brk = ",\n";
      if (term.equals("ADDR")) {
        term = "MADDR";
         value = getValue(info, term);
        if (value.length() == 0) continue;
        System.out.print(brk + "        \"" + term + ":" + escape(value) + "\"");
      }
      if (term.equals("CITY")) {
        term = "MCITY";
        value = getValue(info, term);
        if (value.length() == 0) continue;
        System.out.print(brk + "        \"" + term + ":" + escape(value) + "\"");
      }
    }
    System.out.println(");");
  }
  
  private static final Pattern NEWLINE_PTN = Pattern.compile("\n+");
  private String[] breakLines(String test) {
    if (test.length() < 130 || test.indexOf('\n') < 0) return new String[]{test};
    List<String> list = new ArrayList<String>();
    Matcher match = NEWLINE_PTN.matcher(test);
    int st = 0;
    while (match.find()) {
      if (match.start() > 0) {
        int pt = match.end();
        list.add(test.substring(st, pt));
        st = pt;
      }
    }
    if (st < test.length()) list.add(test.substring(st));  
    return list.toArray(new String[list.size()]);
  }
  
  private String[] getTestTerms() {
    
    String prog = parser.getProgram();
    
    List<String> termList = new ArrayList<String>();
    Set<String> termSet = new HashSet<String>();
    for (String term : prog.split(" +")) {
      if (termSet.add(term)) termList.add(term);
    }
    
    return termList.toArray(new String[termList.size()]);
  }
 
  private String escape(String value) {
    value = value.replace("\\", "\\\\");
    value = value.replace("\"", "\\\"");
    value = value.replace("\n", "\\n");
    value = value.replace("\r", "\\r");
    return value;
  }

  /**
   * Retrieve specified value from message info object
   * @param info message info object
   * @param sType requested value type
   * @return value of requested type
   */
  private String getValue(MsgInfo info, String sType) {
    if (sType.equals("CALL")) return info.getCall();
    if (sType.equals("PLACE")) return info.getPlace();
    if (sType.equals("ADDR")) return info.getAddress();
    if (sType.equals("MADDR")) {
      String addr = info.getBaseMapAddress(2);
      if (addr.equals(info.getAddress())) addr = "";
      return addr;
    }
    if (sType.equals("CITY")) return info.getCity();
    if (sType.equals("MCITY")) {
      String city = info.getMapCity();
      if (city.equals(info.getCity())) city = "";
      return city;
    }
    if (sType.equals("APT")) return info.getApt();
    if (sType.equals("X")) return info.getCross();
    if (sType.equals("BOX")) return info.getBox();
    if (sType.equals("UNIT")) return info.getUnit();
    if (sType.equals("ST")) return info.getState();
    if (sType.equals("MAP")) return info.getMap();
    if (sType.equals("ID")) return info.getCallId();
    if (sType.equals("PHONE")) return info.getPhone();
    if (sType.equals("INFO")) return info.getSupp();
    if (sType.equals("SRC")) return info.getSource();
    if (sType.equals("CODE")) return info.getCode();
    if (sType.equals("NAME")) return info.getName();
    if (sType.equals("PRI")) return info.getPriority();
    if (sType.equals("CH")) return info.getChannel();
    if (sType.equals("GPS")) return info.getGPSLoc();
    if (sType.equals("DATE")) return info.getDate();
    if (sType.equals("TIME")) return info.getTime();
    if (sType.equals("URL")) return info.getInfoURL();
    if (sType.equals("LOCCODE")) return info.getParser().getParserCode();
    else throw new RuntimeException("Keyword " + sType + " is not defined");
  }
  
  /**
   * Increment test title
   * @param title current test title
   * @return next test title
   */
  private String incTitle(String title) {
    
    // Identify the trailing digit portion of the title
    int brk = 0;
    for (int jj = 0; jj<title.length(); jj++) {
      if (! Character.isDigit(title.charAt(jj))) brk = jj+1;
    }
    int testNo = Integer.parseInt(title.substring(brk)) + 1;
    return title.substring(0,brk) + String.format("%" + (title.length()-brk) + "d", testNo);
  }
  
  /**
   * Dummy MsgParser subclass that is used to flag test classes for which we do not yet have
   * a parser written
   */
  protected static class NotReadyParser extends MsgParser {
    public NotReadyParser() {
      super("", "");
    }
  }
}
