package net.anei.cadpage.parsers.IN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class INWayneCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(\\d\\d/\\d\\d) (\\d\\d:\\d\\d) ([^:]+): (.*)");
  
  public INWayneCountyParser() {
    super("WAYNE COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "amoore@co.wayne.in.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("911")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    String sAddr = match.group(3);
    String sExtra = match.group(4).trim();
    
    int pt = sAddr.lastIndexOf(" 10-");
    if (pt < 0) pt = sAddr.lastIndexOf(' ');
    if (pt >= 0) {
      data.strCall = sAddr.substring(pt+1);
      sAddr = sAddr.substring(0,pt).trim();
    }
    if (data.strCall.length() == 0) data.strCall = "ALERT";
    pt = sAddr.lastIndexOf('#');
    if (pt >= 0) {
      data.strApt = sAddr.substring(pt+1).trim();
      sAddr = sAddr.substring(0,pt).trim();
    }
    sAddr = sAddr.replace("//", "&");
    parseAddress(sAddr, data);
    
    String[] flds = sExtra.split("  +");
    int ndx = 0;
    String fld = flds[ndx];
    if (fld.startsWith("Landmark Comment:")) {
      pt = fld.indexOf(" Landmark:",17);
      if (pt >= 0) {
        data.strPlace = append(fld.substring(pt+10).trim(), "-", fld.substring(17,pt).trim());
      } else {
        data.strPlace = fld.substring(17).trim();
      }
      ndx++;
    }
    
    else if (fld.startsWith("Landmark:")) {
      data.strPlace = fld.substring(9).trim();
      ndx++;
    }
    
    boolean loop = false;
    do {
      loop = false;
      fld = flds[ndx].trim();
      if (fld.contains("//")) {
        data.strCross = fld.replace("//", " & ").replaceAll("  +", " ");
        ndx++;
        if (data.strAddress.equals(data.strCross)) {
          data.strCross = "";
          loop = true;
        }
      }
    } while (loop && ndx<flds.length);
    
    for ( ; ndx<flds.length; ndx++) {
      fld = flds[ndx].trim();
      if (fld.startsWith(";")) fld = fld.substring(1).trim();
      data.strSupp = append(data.strSupp, "  ", fld);
    }
    
    return true;
  }
}
