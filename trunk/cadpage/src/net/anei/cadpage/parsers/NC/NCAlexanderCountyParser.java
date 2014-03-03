package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCAlexanderCountyParser extends SmartAddressParser {
  
  private static final Pattern CODE_PTN = Pattern.compile("\\d{1,2}[A-Z]\\d{1,2}[A-Za-z]?");
  private static final Pattern NC_PTN = Pattern.compile("\\bNC\\b");
  
  public NCAlexanderCountyParser() {
    super("ALEXANDER COUNTY", "NC");
    setFieldList("ADDR PLACE CALL CODE X");
  }
  
  @Override
  public String getFilter() {
    return "CAD@alexandercountync.gov";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (body.length() == 0) body = subject;
    if (body.startsWith("|")) body = body.substring(1).trim();
    if (!body.startsWith("CAD:")) return false;
    body = body.substring(4).trim();
    
    String[] flds = body.split(";");
    int st = 0;
    if (flds[st].trim().equals("FYI:")) st++;
    if (st >= flds.length) return false;
    parseAddress(flds[st].trim(), data);
    
    int ndx = st + 2;
    if (ndx > flds.length) return false;
    boolean code = false;
    while (true) {
      if (ndx >= flds.length) break;
      String field = flds[ndx].trim();
      code = CODE_PTN.matcher(field).matches();
      if (code || NC_PTN.matcher(field).find() || field.startsWith("US ") || 
          checkAddress(field) > 0) break;
      if (++ndx > st+3) return false;
    }
    
    data.strCall = flds[ndx-1].trim();
    if (ndx == st+3) data.strPlace = flds[ndx-2].trim();
    
    if (code) data.strCode = flds[ndx++].trim();
    
    int stx = ndx;
    for (ndx = stx; ndx<flds.length && ndx < stx+2; ndx++) {
      data.strCross = append(data.strCross, " & ", flds[ndx].trim());
    }
    return true;
  }
}
