package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Lancaster County, PA
 */
public class PALancasterCountyParser extends MsgParser {
  
  private static Pattern LANC_PTN = Pattern.compile("\\bLANC\\b", Pattern.CASE_INSENSITIVE);
  
  public PALancasterCountyParser() {
    super("LANCASTER COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911@lcwc911.us,messaging@iamresponding.com,@everbridge.net,141000";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! body.contains("~")) return false;
    
    if (subject.indexOf(' ') >= 0 || subject.indexOf('-') >= 0) { 
      data.strCall = subject;
    } else {
      data.strSource = subject;
    }
    
    int ndx = 0;
    for (String line : body.split("~")) {
      ndx++;
      line = line.trim();
      switch (ndx) {
      
      case 1:
        int pt = line.indexOf('/');
        if (pt < 0) pt = line.indexOf('\n');
        if (pt >= 0) {
          data.strCall = append(data.strCall, " / ", line.substring(0,pt).trim());
          line = line.substring(pt+1).trim();
        } else {
          if (data.strCall.length() == 0) return false;
        }
        data.strCity = line;
        if (data.strCity.endsWith(" BORO")) data.strCity = data.strCity.substring(0, data.strCity.length()-5).trim();
        if (data.strCity.endsWith(" BOROUGH")) data.strCity = data.strCity.substring(0, data.strCity.length()-8).trim();
        if (data.strCity.startsWith("LANC")) data.strCity = "LANCASTER";
        break;
        
      case 2:
        line = LANC_PTN.matcher(line).replaceAll("LANCASTER");
        parseAddress(line, data);
        break;
        
      case 3:
        data.strCross = line;
        break;
        
      case 4:
        // Could be second cross st, or if there wasn't a cross street, this
        // would be the unit field
        if (line.length() == 0) break;
        if (data.strCross.length() > 0) {
          data.strCross += " & " + line;
          break;
        }
        ndx++;
        // fall through to case 5
    
      case 5:
        data.strUnit = line;
        break;
      }
    }
    return true;
  }
}
