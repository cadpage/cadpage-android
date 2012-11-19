package net.anei.cadpage.parsers.ZAU;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class ZAUNewSouthWalesBParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(\\d\\d [A-Z][a-z]+ \\d{4} \\d\\d:\\d\\d:\\d\\d) (?:INCIDENT CALL (?:([A-Z]+) )?-)? RESPOND TO (.*)");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("dd MMMMMMMM yyyy HH:mm:ss");

  public ZAUNewSouthWalesBParser() {
    super(ZAUNewSouthWalesParser.CITY_LIST, "", "NSW", CountryCode.AU);
  }

  @Override
  public String getLocName() {
    return "New South Wales, AU";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.find()) return false;
    setDateTime(DATE_TIME_FMT, match.group(1), data);
    data.strSource = getOptGroup(match.group(2));
    String addr = match.group(3);
    if (addr.endsWith(".")) addr = addr.substring(0,addr.length()-1).trim();
    Parser p = new Parser(addr.replace(" X ", " & "));
    addr = p.getLastOptional(',');
    String city = null;
    if (addr.length() > 0) {
      if (isCity(addr)) {
        city = addr;
        addr = p.getLastOptional(',');
      }
    }
    
    if (addr.length() > 0) {
      data.strCall = p.get();
      parseAddress(addr, data);
    }
    
    else {
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, p.get(), data);
    }
    
    if (city != null) data.strCity = city;
    
    return true;
  }
}
