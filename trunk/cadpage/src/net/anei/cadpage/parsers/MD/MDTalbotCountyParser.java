package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MDTalbotCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^Talbot ?911:\\*[DG] ");
  private static final Pattern UNIT_PTN = Pattern.compile(" +([A-Z]\\d+)$");
  
  public MDTalbotCountyParser() {
    super("TALBOT COUNTY", "MD");
    setFieldList("BOX CALL ADDR PLACE INFO UNIT");
  }
  
  @Override
  public String getFilter() {
    return "msg@cfmsg.com,alert@cfmsg.com,777";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    Matcher match = MARKER.matcher(body);
    if (! match.find()) return false;
    body = body.substring(match.end()).trim();
    
    match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = match.group(1);
      body = body.substring(0,match.start());
    }
    
    int pt = body.indexOf(' ');
    if (pt < 0) return false;
    data.strBox = body.substring(0,pt);
    body = body.substring(pt+1).trim();
    
    // OK, go do your magic!!
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_AT_BOTH, body, data);
    data.strSupp = getLeft().replaceAll("  +", " ");
    return true;
  }
}
