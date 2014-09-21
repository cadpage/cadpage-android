package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHGeaugaCountyAParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^GEAUGA COUNTY SHERIFF \\(Text Message[^\\)]*\\) ");
  private static final Pattern CALL_MARK_PTN = 
      Pattern.compile(" (?:(?:(?:IS )?NEEDE?D(?: AT)?(?: -)?)|AT -) ", Pattern.CASE_INSENSITIVE);
  private static final String[] CALL_PREFIXES = new String[]{
    "FOR A "
  };
 
  public OHGeaugaCountyAParser() {
    super("GEAUGA COUNTY", "OH");
    setFieldList("CALL ADDR APT INFO PLACE");
  }
  
  @Override
  public String getFilter() {
    return "777,888";
  }
  
  @Override
  public int getMapFlags() {
    // Suppress LA -> LN address adjustment
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    do {
      Matcher match = MARKER.matcher(body);
      if (match.find()) {
        body = body.substring(match.end()).trim();
        break;
      }
      
      if (subject.equals("Alert Notification")) {
        body = stripFieldEnd(body, "<br />");
        break;
      }
      
      return false;
    } while (false);
      
    StartType st = StartType.START_CALL;
    Matcher match = CALL_MARK_PTN.matcher(body);
    if (match.find()) {
      data.strCall = body.substring(0,match.start()).trim();
      body = body.substring(match.end()).trim();
      st = StartType.START_PLACE;
    }
    
    String[] flds = body.split(" -- ");
    if (flds.length > 2) {
      int addrNdx = 0;
      if (data.strCall.length() == 0) data.strCall = flds[addrNdx++]; 
      if (checkAddress(flds[addrNdx]) < checkAddress(flds[addrNdx+1])) {
        data.strPlace =  flds[addrNdx++];
      }
      parseAddress(flds[addrNdx], data);
      for (int ndx = addrNdx+1; ndx < flds.length; ndx++) {
        data.strSupp = append(data.strSupp, " -- ", flds[ndx]);
      }
    } 
    
    else {
      body = body.replace(',', ' ');
      Result res = parseAddress(st, FLAG_NO_IMPLIED_APT, body);
      if (!res.isValid()) {
        if (data.strCall.length() == 0) data.strCall = "GENERAL ALERT";
        data.strPlace = body;
      } else {
        res.getData(data);
        String sExtra = res.getLeft();
        if (data.strCall.length() == 0) {
          data.strCall = sExtra;
        } else {
          data.strSupp = sExtra;
        }
      }
    }
    
    // Clear out call prefixes
    for (String pfx : CALL_PREFIXES) {
      if (data.strCall.toUpperCase().startsWith(pfx)) {
        data.strCall = data.strCall.substring(pfx.length()).trim();
        break;
      }
    }
    
    return true;
  }
}
