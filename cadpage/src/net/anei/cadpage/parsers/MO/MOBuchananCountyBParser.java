package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class MOBuchananCountyBParser extends MsgParser {
  public MOBuchananCountyBParser() {
    super("BUCHANAN COUNTY", "MO");
    setFieldList("PLACE UNIT PRI ADDR CITY CODE CALL ID NAME DATE TIME INFO");
  }
  
  @Override
  public String getFilter() {
    return "APREWITT@heartland-health.com";
  }
  
  private static final String FORMAT_HEADER_S
    = "[A-Z]+:",
  UNIT_S = "\\b[A-Z]\\d{1,2}\\b";
  private static final Pattern FORMAT_MP
    = Pattern.compile(".* --CONT--"),
  FORMAT_RR
    = Pattern.compile(FORMAT_HEADER_S+".+ RECV \\d{2}:\\d{2}.*"),
  FORMAT_1
    = Pattern.compile(FORMAT_HEADER_S+"(.+)PRI:(.+)\\bAddr\\b(.+)CTY:(.+)PROB:(.+)(\\d{6}) END-OF-MSG"),
  FORMAT_2
    = Pattern.compile(FORMAT_HEADER_S+"(.+)P/U:.+PT:(.+)PUNM:(.+)Addr:(.+)CTY:(.+)RM:(.*)(WC:.*) END-OF-MSG"),
  FORMAT_3
    = Pattern.compile(FORMAT_HEADER_S+"(.*?)("+UNIT_S+")(?: +-EP-(.*)| +(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d))");
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher m = FORMAT_MP.matcher(body);
    if (m.matches()) {
      data.expectMore = true;
      // Tried returning true - doesn't make any difference
      return false;
    }
    m = FORMAT_RR.matcher(body);
    if (m.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    m = FORMAT_1.matcher(body);
    if (m.matches()) {
      data.strUnit = m.group(1).trim();
      data.strPriority = m.group(2).trim();
      parseFormat1Address(m.group(3).trim(), data);
      data.strCity = m.group(4).trim();
      data.strCall = m.group(5).trim();
      parseCall(m.group(5).trim(), data);
      data.strCallId = m.group(6);
      return true;
    }
    m = FORMAT_2.matcher(body);
    if (m.matches()) {
      data.strUnit = m.group(1).trim();
      data.strName = m.group(2).trim();
      data.strPlace = m.group(3).trim();
      parseAddress(m.group(4).trim(), data);
      data.strCity = m.group(5).trim();
      data.strApt = m.group(6).trim();
      data.strSupp = m.group(7).trim();
      return true;
    }
    m = FORMAT_3.matcher(body);
    if (m.matches()) {
      data.strUnit = m.group(2).trim();
      if (m.group(1).equals("Unit:"))
        parseEPAddress(getOptGroup(m.group(3)), data);
      else {
        data.strSupp = m.group(1).trim();
        data.strDate = getOptGroup(m.group(4));
        data.strTime = getOptGroup(m.group(5));
      }
      return true;
    }
    return false;
  }
  
  private static final Pattern CALL_PATTERN
  	= Pattern.compile("(\\d+)(.*)");
  private void parseCall(String field, Data data) {
	Matcher m = CALL_PATTERN.matcher(field);
	if (m.matches()) {
		data.strCode = m.group(1);
		field = m.group(2).trim();
	}
	data.strCall = field;
  }
  
  private static final Pattern FMT1_ADDRESS_PATTERN
    = Pattern.compile("(.*)(AltA.*)");
  private void parseFormat1Address(String field, Data data) {
    Matcher m = FMT1_ADDRESS_PATTERN.matcher(field);
    if (m.matches()) {
      field = m.group(1).trim();
      data.strSupp = m.group(2);
    }
    parseAddress(field, data);
  }
  
  private static final Pattern EP_ADDRESS_PATTERN
    = Pattern.compile("(POST +\\d+)(.*)");
  private void parseEPAddress(String field, Data data) {
    Matcher m = EP_ADDRESS_PATTERN.matcher(field);
    if (m.matches()) {
      data.strSupp = m.group(1);
      field = m.group(2).trim();
    }
    data.strSupp = append(data.strSupp," / ", "-EP-");
    parseAddress(field, data);
  }
}
