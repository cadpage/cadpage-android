package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class NYFranklinCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("FRACO911  ([A-Z0-9]+)  ([-/ A-Z0-9]+?)  (.*)  [A-Za-z]+ CANCEL");
  private static final Pattern ZIP_PTN = Pattern.compile("\\d{5}");

  public NYFranklinCountyParser() {
    super("FRANKLIN COUNTY", "NY");
    setFieldList("SRC CALL ADDR APT CITY X");
  }
  
  @Override
  public String getFilter() {
    return "4702193648";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    data.strCall = match.group(2).trim();
    String addr = match.group(3).trim();
    boolean isCross = addr.endsWith(")");
    if (isCross) addr = addr.substring(0,addr.length()-1).trim();
    Parser p = new Parser(addr);
    String cross = p.getLastOptional('(');
    cross = stripFieldEnd(cross, "/");
    cross = stripFieldStart(cross, "/");
    data.strCross = cross;
    data.strCity = p.getLastOptional(',');
    if (ZIP_PTN.matcher(data.strCity).matches()) {
      String city = p.getLastOptional(',');
      if (city.length() > 0) data.strCity = city;
    }
    parseAddress(p.get(), data);
    return true;
  }
}
