package net.anei.cadpage.parsers.dispatch;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchRedAlertParser extends SmartAddressParser {
  
  private static final Pattern TIME_MARK = Pattern.compile("\\. ?\\. ?([\\d:]+)$");
  private static final Pattern CODE_PATTERN = Pattern.compile("\\b\\d{1,2}-?[A-Z]-?\\d{1,2}[A-Z]?\\b");
  
  public DispatchRedAlertParser(String defCity, String defState) {
    super(defCity, defState);
    setFieldList("CALL CODE INFO ADDR APT CITY BOX X PLACE TIME");
  }

  @Override
  public String getFilter() {
    return "paging@alpinesoftware.com,@rednmxcad.com,REDALERT";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Strip off leading slash
    if (body.startsWith("/")) body = body.substring(1).trim();
    
    // Look for the trailing time signature
    // If we find it, strip it off.
    boolean ok = false;
    Matcher match = TIME_MARK.matcher(body);
    if (match.find()) {
      ok = true;
      String sTime = match.group(1);
      if (sTime.length() >= 5) {
        if (sTime.length() < 8) sTime = sTime.substring(0,5);
        data.strTime = sTime;
      }
      body = body.substring(0,match.start()).trim();
    }
    
    // Call is sometimes in square brackets, which got treated as a subject
    // in which case it needs to be restored
    if (subject.length() > 0) body = subject + " " + body;
    
    // Also must have at " at " keyword which we will change to "LOC:"
    // If there happen to be more than one, only change the last one
    int pt = body.indexOf(" S:");
    if (pt <0) pt = body.length();
    pt = body.lastIndexOf(" at ", pt);
    if (pt >= 0) {
      body = body.substring(0, pt) + " LOC: " + body.substring(pt+4);
    }
    
    body = "TYPE:" + body.replace("c/s:", "CROSS:").replace(" c/s ", " CROSS:").replace(" CS:", " CROSS:").replace(" Box ", " Box:").replace(" B:", " O:").replaceAll("\\s+", " ");
    Properties props = parseMessage(body, new String[]{"TYPE","LOC","CROSS","Box", "O", "- S"});
    
    String sAddress = props.getProperty("LOC");
    if (sAddress == null) {
      if (!ok) return false;
      sAddress = props.getProperty("TYPE", "");
      sAddress = sAddress.replace("C/O","C%O");
      parseAddress(StartType.START_CALL, sAddress, data);
      if (data.strAddress.length() == 0) return false;
      data.strSupp = getLeft();
      data.strCall = data.strCall.replace("C%O", "C/O");
      data.strAddress = data.strAddress.replace("C%O", "C/O");
      data.strSupp = data.strSupp.replace("C%O", "C/O");
    } else {
      if (sAddress.startsWith("intersection of ")) sAddress = sAddress.substring(16);
      if (sAddress.contains(",")){
        int indx = sAddress.indexOf(",");
        data.strCity = sAddress.substring(indx + 1).trim();
        sAddress = sAddress.substring(0,indx).trim();
      }
      // Protect C/O sequence form being treated as an intersection
      parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, sAddress.replace("C/O", "C%O"), data);
      if (data.strAddress.length() == 0) {
        data.strAddress = data.strPlace;
        data.strPlace = "";
      }
      data.strAddress = data.strAddress.replace("C%O", "C/O");
      
      String sCall = props.getProperty("TYPE", "");
      int ipt = sCall.indexOf(':');
      if (ipt >= 0) {
        data.strCall= sCall.substring(0,ipt).trim();
        data.strSupp= sCall.substring(ipt+1).trim();
        match = CODE_PATTERN.matcher(data.strSupp);
        if (match.find()) {
          data.strCode = data.strSupp.substring(match.start(), match.end());
          data.strSupp = cutOut(data.strSupp, match.start(), match.end());
          if (data.strSupp.startsWith("- ")) data.strSupp = data.strSupp.substring(2).trim();
        }
      } else {
        data.strCall = sCall;
      }
      data.strCall = data.strCall.replaceAll("\\. \\.", "-");
    }

    data.strPlace = append(data.strPlace, " - ", props.getProperty("O", ""));
    data.strBox = props.getProperty("Box", "");
    String sCross = props.getProperty("CROSS");
    if (sCross != null) {
      ok = true;
      pt = sCross.indexOf(',');
      if (pt >= 0) {
        data.strSupp = append(data.strSupp, " / ", sCross.substring(pt+1).trim());
        sCross = sCross.substring(0,pt).trim();
      }
      data.strCross = sCross;
    }

    return ok;
  }
}
