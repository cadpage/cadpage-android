package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYNiagaraCountyParser extends SmartAddressParser {

  private static final Pattern SRC_SUBJECT_PTN = Pattern.compile("TCAS|Station \\d+");
  private static final Pattern TRAIL_TIME_PTN = Pattern.compile(" +(?:(\\d\\d):?(\\d\\d)(?: ?HRS)?|(\\d:\\d{2}))$", Pattern.CASE_INSENSITIVE);
  private static final Pattern TRAIL_DATE_PTN = Pattern.compile(" +(\\d{1,2}/\\d{1,2}(?:/\\d{2}(?:\\d{2})?)?)$");

  public NYNiagaraCountyParser() {
    super("NIAGARA COUNTY", "NY");
    setFieldList("SRC CALL ADDR APT INFO DATE TIME");
    removeWords("CORD");
  }
  
  @Override
  public String getFilter() {
    return "@niagaracounty.com,777";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SRC_SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = subject;
    
    body = body.replace("\n", "");
    
    // Look for trailing date and time, or time and date
    
    match = TRAIL_DATE_PTN.matcher(body);
    if (match.find()) {
      body = body.substring(0,match.start());
      data.strDate = match.group(1);
    }
    
    match = TRAIL_TIME_PTN.matcher(body);
    if (match.find()) {
      body = body.substring(0,match.start());
      data.strTime = match.group(3);
      if (data.strTime == null) {
        data.strTime = match.group(1) + ':' + match.group(2);
      }
      if (data.strDate.length() == 0) {
        match = TRAIL_DATE_PTN.matcher(body);
        if (match.find()) {
          body = body.substring(0,match.start());
          data.strDate = match.group(1);
        }
      }
    }
    
    // That is about all we can get.  Use SAP for everything else
    parseAddress(StartType.START_CALL, FLAG_IGNORE_AT | FLAG_NO_IMPLIED_APT, body, data);
    String left = getLeft();
    left = stripFieldStart(left, "-");
    left = stripFieldStart(left, "/");
    if (data.strCall.length() == 0) {
      if (left.length() > 0) {
        data.strCall = left;
      } else {
        data.strCall = data.strAddress;
        data.strAddress = "";
      }
    } else {
      data.strSupp = left;
    }
    
    return true;
  }
}
