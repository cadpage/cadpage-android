package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class ILAdamsCountyParser extends SmartAddressParser {

  public ILAdamsCountyParser() {
    super("ADAMS COUNTY", "IL");
    setFieldList("ID SRC CALL ADDR APT");
  } 
  
  private static final Pattern SRC_CALL = Pattern.compile("((?:\\w+-)+\\w+) (\\d+-\\d+.*)");
  
  protected boolean parseMsg(String subject, String body, Data data) {
    // check subject and parse SRC
    if (!subject.startsWith("CAD Page for ")) return false;
    else data.strCallId = subject.substring(13).trim();
    
    String[] fields = body.split(",");
    
    // first group is either SRCCALL or just CALL
    Matcher mat = SRC_CALL.matcher(fields[0]);
    if (mat.matches()) {
      data.strSource = mat.group(1);
      data.strCall = mat.group(2);
    }
    else data.strCall = fields[0];
    
    // intermediate groups are all CALL
    for (int i = 1; i < fields.length - 2; i++) {
      data.strCall = append(data.strCall, ", ", fields[i]);
    }
    
    // last two groups are CALL ADDR or ADDR APT (if only one group left, its ADDR)
    if (fields.length > 2) {
      int a = fields.length - 2;
      int b = a + 1;
      Result res1 = parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, fields[a]);
      Result res2 = parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, fields[b]);
      if (res1.getStatus() >= res2.getStatus()) {
        res1.getData(data);
        data.strApt = fields[b];
      } else {
        data.strCall = append(data.strCall, ",", fields[a]);
        res2.getData(data);
      }
    } else if (fields.length > 1) { //( SRCCALL | CALL ) ADDR is the only 2 field format
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, fields[1], data);
    }
    
    return true;
  }
  
}
