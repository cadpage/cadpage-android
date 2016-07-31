package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class OHStarkCountyCencommParser extends SmartAddressParser {
  
  public OHStarkCountyCencommParser() {
    super(OHStarkCountyParser.CITY_LIST, "STARK COUNTY", "OH");
    setFieldList("CALL ADDR APT CITY INFO");
    setupSaintNames("ABIGAIL", "FRANCIS");
    setupMultiWordStreets("ST ABIGAIL", "ST FRANCIS");
  }
  
  @Override
  public String getFilter() {
    return "@neohio.twcbc.com,@neo.rr.com";
  }
  
  private static final Pattern FIX_NUMBER_PTN = Pattern.compile("\\b\\d*(?:2 ND|3 RD)\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern YOFM_PTN = Pattern.compile("\\b(\\d+) */ *([MF])\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern FIELD_DELIM_PTN = Pattern.compile(" *- +| +- *| *[:;] *");
  private static final Pattern MASTER1_PTN = Pattern.compile("(.*?) +(?:AT|ON) +(.*)", Pattern.CASE_INSENSITIVE);
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // To sloppy to continue without positive confirmation
    if (!isPositiveId()) return false;
    
    body = body.replace('\n', ' ');
    
    Matcher match = FIX_NUMBER_PTN.matcher(body);
    if (match.find()) {
      StringBuffer sb = new StringBuffer();
      do {
        match.appendReplacement(sb, match.group().replace(" ", ""));
      } while (match.find());
      match.appendTail(sb);
      body = sb.toString();
    }
    
    match = YOFM_PTN.matcher(body);
    if (match.find()) {
      StringBuffer sb = new StringBuffer();
      do {
        match.appendReplacement(sb, match.group(1) + " YO" + match.group(2).toUpperCase());
      } while (match.find());
      match.appendTail(sb);
      body = sb.toString();
    }
    
    String[] flds = FIELD_DELIM_PTN.split(body);
    if (flds.length > 1) {
      Result bestResult = null;
      int bestNdx = -1;
      for (int ndx = 0; ndx < flds.length; ndx++) {
        Result res = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_OPT_STREET_SFX, flds[ndx]);
        if (bestResult == null || res.getStatus() > bestResult.getStatus()) {
          bestResult = res;
          bestNdx = ndx;
        }
      }
      
      if (bestResult.getStatus() <= STATUS_NOTHING) return false;
      for (int ndx = 0; ndx < bestNdx; ndx++) {
        data.strCall = append(data.strCall, " - ", flds[ndx]);
      }
      
      bestResult.getData(data);
      String left = bestResult.getLeft();
      if (data.strCross.length() > 0) {
        left = append(data.strCross, " ", left);
        data.strCross = "";
      }
      data.strSupp = left;
      
      int ndx = bestNdx+1;
      if (data.strCall.length() == 0 && ndx < flds.length) {
        data.strCall = flds[ndx++];
      }
      
      for ( ; ndx<flds.length; ndx++) {
        data.strSupp = append(data.strSupp, " - ", flds[ndx]);
      }
      return true;
    }
    
    match = MASTER1_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = match.group(1);
      parseAddress(StartType.START_ADDR, FLAG_OPT_STREET_SFX, match.group(2), data);
      data.strSupp = getLeft();
      return true;
    }
    
    parseAddress(StartType.START_CALL, FLAG_OPT_STREET_SFX, body, data);
    if (!isValidAddress()) return false;
    String left = getLeft();
    if (data.strCross.length() > 0) {
      left = append(data.strCross, " ", left);
      data.strCross = "";
    }
    if (data.strCall.length() == 0) {
      data.strCall = left;
    } else {
      data.strSupp = left;
    }
    return true;
  }
}
