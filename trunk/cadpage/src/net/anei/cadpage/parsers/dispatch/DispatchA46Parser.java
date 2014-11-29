package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class DispatchA46Parser extends SmartAddressParser {
  
  String defState;

  public DispatchA46Parser(String defState, String defCity) {
    super(defState, defCity);
    setFieldList("SRC CODE ID CALL PLACE ADDR APT CITY ST INFO");
    this.defState = defState;
  }

  private static Pattern SUBJECT = Pattern.compile("(?:([A-Z]{3}) +- +)?(.*?) +- +(\\d{10})\\b[- ]*(.*)");
  private static Pattern BODY = Pattern.compile("(?:There has been a\\(n\\) +)?(.*?) +reported (at|across from) +(.*)");
  private static Pattern ADDR_PTN = Pattern.compile("([^,]*),([^,]*), *([A-Z]{2})\\b,? *(.*)");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    // try parsing from subject, fail if doesn't match
    Matcher mat = SUBJECT.matcher(subject);
    if (!mat.matches()) return false;
    data.strSource = getOptGroup(mat.group(1));
    data.strCall = mat.group(2);
    data.strCallId = mat.group(3);
    String subAddr = mat.group(4);
    
    int pt = body.indexOf('\n');
    if (pt >= 0) {
      data.strSupp = body.substring(pt+1).trim().replaceAll("\n\n+", "\n");
      body = body.substring(0,pt).trim();
    }

    // parse any unfound info from body and save body's trail
    mat = BODY.matcher(body);
    String addr;
    if (mat.matches()) {
      String call = stripFieldEnd(mat.group(1), "-");;
      if (!call.equals(data.strCall)) {
        data.strCode = data.strCall;
        data.strCall = call;
      }
      String place = mat.group(2);
      if (!place.equals("at")) data.strPlace = place;
      addr = mat.group(3).trim();
    } else {
      if (subAddr.length() == 0) return false;
      data.strSupp = append(body, "\n", data.strSupp);
      addr = subAddr;
    }
    mat = ADDR_PTN.matcher(addr);
    if (mat.matches()) {
      parseAddress(mat.group(1).trim(), data);
      data.strCity = mat.group(2).trim();
      data.strState = mat.group(3);
      data.strSupp = append(mat.group(4), "\n", data.strSupp);
    } else {
      pt = addr.indexOf(',');
      if (pt >= 0) {
        data.strSupp = addr.substring(pt+1).trim();
        addr = addr.substring(0,pt);
        parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT | FLAG_ANCHOR_END, addr, data);
      } else {
        parseAddress(StartType.START_ADDR, addr, data);
        data.strSupp = getLeft();
      }
    }
    return true;
  }
}
