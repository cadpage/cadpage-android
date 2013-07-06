package net.anei.cadpage.parsers.MN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class MNWashingtonCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(.*?)  ICR #(\\d+)  (DISPATCH)");
  private static final Pattern HWY_I_PTN = Pattern.compile("\\bHWY +I(\\d+)\\b");
  
  public MNWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "MN");
    setFieldList("ADDR APT ID CALL");
  }
  
  @Override
  public String getFilter() {
    return "sheriff@co.washington.mn.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("ICOM/400 notification")) return false;
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    String addr = match.group(1).replace('.', ' ').trim();
    addr = HWY_I_PTN.matcher(addr).replaceAll("I-$1");
    parseAddress(StartType.START_ADDR, addr, data);
    String apt = getLeft();
    if (apt.startsWith("/")) {
      data.strAddress = data.strAddress + " & " + apt.substring(1).trim();
    } else if ((data.strAddress.endsWith(" ST") || data.strAddress.endsWith(" DR")) &&
               (apt.startsWith("PL ") || apt.startsWith("LN "))) {
      data.strAddress = data.strAddress + ' ' + apt;
    }  else {
      data.strApt = append(data.strApt, " ", apt);
    }
    data.strCallId = match.group(2);
    data.strCall = match.group(3);
    return true;
  }
}
