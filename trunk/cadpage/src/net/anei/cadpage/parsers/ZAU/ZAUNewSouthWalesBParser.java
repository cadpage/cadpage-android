package net.anei.cadpage.parsers.ZAU;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class ZAUNewSouthWalesBParser extends SmartAddressParser {
  
  private static final Pattern DATE_TIME_MARKER = Pattern.compile("^(\\d\\d [A-Z][a-z]+ \\d{4} \\d\\d:\\d\\d:\\d\\d) ");
  private static final Pattern INCIDENT_CALL_PTN = Pattern.compile("^(?:\\d+-[A-Z]{3}-\\d{4} \\d\\d?:\\d\\d:\\d\\d )?INCID?ENT CALL(?:[- ]+(?!RESPOND|STOP)([A-Z]+))?[-,; ]+", Pattern.CASE_INSENSITIVE);
  private static final Pattern RESPOND_TO_PTN = Pattern.compile("^(.*?)(?:[-=] )?(?:PLEASE |PLS )?RE?SPO?ND TO (?:REPORT OF)?", Pattern.CASE_INSENSITIVE);
  private static final Pattern TRAIL_DATE_PTN = Pattern.compile("\\. *[\\d/]*$| +\\d+-[A-Z][a-z]{2}-\\d{4} \\d\\d?:\\d\\d:\\d\\d$");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("dd MMMMMMMM yyyy HH:mm:ss");

  public ZAUNewSouthWalesBParser() {
    super(ZAUNewSouthWalesParser.CITY_LIST, "", "NSW", CountryCode.AU);
    setFieldList("DATE TIME SRC CALL ADDR APT CITY INFO");
  }

  @Override
  public String getLocName() {
    return "New South Wales, AU";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = DATE_TIME_MARKER.matcher(body);
    if (!match.find()) return false;
    setDateTime(DATE_TIME_FMT, match.group(1), data);
    body = body.substring(match.end()).trim();
    
    // There are two different optional keywords, at least one must be present
    // INCIDENT CALL
    boolean good = false;
    String addr = body;
    match = INCIDENT_CALL_PTN.matcher(body);
    if (match.find()) {
      data.strSource = getOptGroup(match.group(1));
      if (match.group().length() > 1) good = true;;
      addr = body.substring(match.end());
    }
    
    // and - RESPOND TO
    String callPrefix = "";
    match = RESPOND_TO_PTN.matcher(addr);
    if (match.lookingAt()) {
      callPrefix = match.group(1).trim();
      good = true;
      addr = addr.substring(match.end()).trim();
    } 
    else if (addr.startsWith("-")) addr = addr.substring(1).trim();
    
    if (!good) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
      return true;
    }
    
    match = TRAIL_DATE_PTN.matcher(addr);
    if (match.find()) addr = addr.substring(0,match.start()).trim();
    
    Parser p = new Parser(addr.replace(" X ", " & ").replace(" 'X' ", " & "));
    addr = p.getLastOptional(',');
    String city = "";
    if (addr.length() > 0) {
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, addr, data);
      city = data.strCity;
      data.strCity = "";
      if (city.length() > 0) {
        addr = p.getLastOptional(',');
      }
    }
    
    if (addr.length() > 0) {
      String call = p.get();
      if (city.length() == 0 && isValidAddress(call)) {
        data.strCall = addr;
        addr = call;
      } else {
        data.strCall = call;
      }
      int flags = (city.length() > 0 ? FLAG_ANCHOR_END : 0);
      parseAddress(StartType.START_CALL, flags, addr, data);
    }
    
    else {
      parseAddress(StartType.START_CALL, p.get(), data);
    }
    data.strSupp = getLeft();
    
    data.strCall = append(callPrefix, " - ", data.strCall);
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
    }
    
    if (city.length() > 0) data.strCity = city;
    if (data.strCity.equalsIgnoreCase("WINMALLEE")) data.strCity = "WINMALEE";
    return true;
  }
}
