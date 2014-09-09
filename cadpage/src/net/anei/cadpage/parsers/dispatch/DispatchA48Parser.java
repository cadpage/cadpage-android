package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class DispatchA48Parser extends SmartAddressParser {
  
  public enum FieldType { NAME, X };
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("As of \\d\\d?/\\d\\d?/\\d\\d \\d\\d");
  private static final Pattern MASTER_PTN = Pattern.compile("CAD:As of (\\d\\d?/\\d\\d?/\\d\\d) (\\d\\d:\\d\\d:\\d\\d) (\\d{4}-\\d{8}) (.*?) - (.*) Unit Org Name Area Types (.*)");
  
  private FieldType fieldType;

  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType) {
    super(cityList, defCity, defState);
    this.fieldType = fieldType;
    setFieldList("SRC DATE TIME ID CODE CALL ADDR APT CITY " + fieldType + " UNIT");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) {
      body = "CAD:" + subject + ':' + body;
      subject = "";
    }
    data.strSource = subject;
    
    match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    data.strCallId = match.group(3);
    data.strCode = match.group(4);
    String addr = match.group(5).trim();
    data.strUnit = match.group(6).trim();
    
    int pt = addr.lastIndexOf(',');
    String extra = null;
    if (pt >= 0) {
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, addr.substring(pt+1).trim(), data);
      if (data.strCity.length() > 0) {
        extra = stripFieldStart(getLeft(), data.strCity);
        addr = addr.substring(0,pt).trim().replace('@', '&');
        pt = addr.lastIndexOf(',');
        if (pt >= 0) {
          data.strCall = addr.substring(0,pt).trim();
          parseAddress(addr.substring(pt+1).trim(), data);
        } else {
          parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_NO_CITY | FLAG_ANCHOR_END, addr, data);
        }
      }
    }
    
    if (extra == null) {
      addr = addr.replace('@', '&');
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, addr, data);
      extra = getLeft();
    }
    
    switch (fieldType) {
    case NAME:
      data.strName = extra;
      break;
      
    case X:
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, extra, data);
      break;
    }
    
    if (data.strCall.equals(data.strCode)) data.strCode = "";
    return true;
  }
}
