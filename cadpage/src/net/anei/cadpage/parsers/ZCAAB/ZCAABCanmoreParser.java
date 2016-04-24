package net.anei.cadpage.parsers.ZCAAB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.StandardCodeTable;

/**
 * Canmore, Alberta, Canada
 */
public class ZCAABCanmoreParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(\\d\\d:\\d\\d[AP]M) CALL (\\d\\d[a-z]\\d\\d[a-z]?|911test) AT (.+)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mmaa");
  
  private static final CodeTable STD_CODE_TABLE = new StandardCodeTable();
  
  public ZCAABCanmoreParser() {
    super("CANMORE", "AB");
    setFieldList("TIME CODE CALL ADDR APT PLACE CITY");
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
  }
  
  @Override
  public String getFilter() {
    return "LuchiaM@fresc.ca";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Rip & Run")) return false;
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    setTime(TIME_FMT, match.group(1), data);
    data.strCode = match.group(2);
    String call = STD_CODE_TABLE.getCodeDescription(data.strCode);
    if (call == null) call = data.strCode;
    data.strCall = call;
    Parser p = new Parser(match.group(3).trim());
    String addr = p.get(',');
    if (addr.length() == 0) addr = p.get(',');
    addr = addr.replace('_', ' ');
    if (addr.startsWith("*")) addr = addr.substring(1);
    parseAddress(addr.trim(), data);
    data.strCity = p.getLast(',');
    data.strPlace = p.get();
    return true;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return SPLIT_NUMBER_PTN.matcher(addr).replaceFirst("$1");
  }
  private static final Pattern SPLIT_NUMBER_PTN = Pattern.compile("^\\d{1,3}-(\\d{3,})\\b");
  
  @Override
  protected String adjustGpsLookupAddress(String address) {
    return address.toUpperCase();
  }
  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "2 HWY E & 418 AVE E",   "50.6739928, -113.8691339",
      "100-72132 594 AVE E",   "50.5217056, -113.8836797",
      "2140 466 AVE E",        "50.6351678, -113.9864622",
      "434243 2 HWY E",        "50.6594800, -113.8396003"
  });
}
