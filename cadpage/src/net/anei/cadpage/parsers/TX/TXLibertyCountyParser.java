package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class TXLibertyCountyParser extends SmartAddressParser {
  
  private static final Pattern NUMBER_O = Pattern.compile("(\\d+)O(\\d*)");
  
  public TXLibertyCountyParser() {
    super(CITY_CODES, "LIBERTY COUNTY", "TX");
    setFieldList("CALL ADDR PLACE INFO");
  }
  
  public String getFilter() {
    return "lcso@lcffa.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Standards for CAD page are pretty low
    if (!isPositiveId()) return false;
    if (subject.length() == 0) return false;
    
    // SKip everything after a double newline, and turn all remaining newlines to blanks
    int pt = body.indexOf("\n\n");
    if (pt >= 0) body = body.substring(0,pt);
    body = body.replace('\n', ' ');
    
    // They use @ to mark intersections :(
    body = body.replace('@', '&');
    
    // And fumble fing an O for a zero?
    body = NUMBER_O.matcher(body).replaceAll("$10$2");
    
    // Splitting OVERPASS into two words fools the address logic into thinking
    // that PASS ends a street suffix
    body = body.replace("OVER PASS", "OVERPASS");
    
    // OK, see if we can find an address
    // Address is usually at the beginning of the call, so we will try that first
    // if no luck that way, look for it anywhere
    Result res = parseAddress(StartType.START_ADDR, FLAG_NO_IMPLIED_APT, body);
    if (res.getStatus() == 0) res = parseAddress(StartType.START_CALL, FLAG_NO_IMPLIED_APT, body);
    
    // Still no luck?  Subject goes in call, body goes in place and call it good
    if (res.getStatus() == 0) {
      data.strCall = subject;
      data.strPlace = body;
      return true;
    }
    
    // Address found.  See if it is followed by place name in brackets
    res.getData(data);
    String tail = res.getLeft();
    if (tail.length() > 0) {
      char chr = tail.charAt(0);
      if (chr == '(' || chr == '[') {
        chr = (chr == '(' ? ')' : ']');
        pt = tail.indexOf(chr, 1);
        if (pt < 0) pt = tail.length();
        data.strPlace = tail.substring(1,pt).trim();
        tail = tail.substring(pt+1).trim();
      }
    }
    
    // Whatever is before and affter the address goes into info, the subject
    // will be the call
    data.strSupp = append(data.strCall, " / ", tail);
    data.strCall = subject;
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
  });
}
