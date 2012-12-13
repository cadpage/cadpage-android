package net.anei.cadpage.parsers.VA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class VALexingtonRockbridgeCountyParser extends FieldProgramParser {
  
  private static final Pattern DATE_TIME_PTN = 
    Pattern.compile(" (\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{1,2}:\\d{2}:\\d{2} [A-P]M)\\b");
  private static final Pattern SQ_BRACKETS_PTN = Pattern.compile(" *\\[.*\\] *");
  private static DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  
  public VALexingtonRockbridgeCountyParser() {
    super("", "VA",
           "Type:CALL! Loc:ADDR! Units:UNIT! City:CITY!");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,411911";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Strip off data field from end of message
    int pt = body.indexOf("\nMessage");
    if (pt > 0) body = body.substring(0, pt).trim();
    
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    data.strDate = match.group(1);
    setTime(TIME_FMT,match.group(2), data);
    String extra = body.substring(match.end()).trim();
    body = body.substring(0,match.start());
    
    // And parse what is left
    if (!super.parseMsg(body, data)) return false;
    
    // OK, now lets see what to make of the extra data
    String address2 = null;
    if (extra.startsWith("**Nearest Address:")) {
      extra = extra.substring(18).trim();
      if (extra.startsWith("None")) {
        extra = extra.substring(4).trim();
      } else {
        Parser p = new Parser(extra);
        address2 = p.get(',');
        extra = p.get();
        if (extra.startsWith(data.strCity)) extra = extra.substring(data.strCity.length()).trim();
      }
    }
    
    if (address2 != null && !address2.equals("None") && address2.length() > 0) {
      if (checkAddress(data.strAddress) == 0) {
        data.strPlace = data.strAddress;
        data.strAddress = address2;
      }
    }
    
    extra = SQ_BRACKETS_PTN.matcher(extra).replaceAll(" ");
    data.strSupp = extra;
    return true;
  }

  @Override
  public String getProgram() {
    return super.getProgram() + " DATE TIME PLACE INFO";
  }
}
