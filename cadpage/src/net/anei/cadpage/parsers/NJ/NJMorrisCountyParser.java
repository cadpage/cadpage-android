package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NJMorrisCountyParser extends MsgParser {
  
  private static final Pattern MASTER_PTN = 
    Pattern.compile("(.*?) \\[([-A-Za-z ]+)\\] \\(([-A-Z\\\\/ ]+)\\) - (.*)", Pattern.DOTALL);
  
  private static final Pattern PLACE_CODE_PTN = Pattern.compile("\\(\\d+\\)");
  private static final Pattern ID_TIME_PTN = Pattern.compile("(F\\d{6,}) +(\\d\\d:\\d\\d)");
  
  public NJMorrisCountyParser() {
    super("MORRIS COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@co.morris.nj.us,mcdispatch@optimum.net,iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    
    String sAddress = match.group(1).trim();
    if (sAddress.startsWith("***")) sAddress = sAddress.substring(3).trim();
    Parser p = new Parser(sAddress);
    data.strPlace = p.getOptional(',');
    Matcher match2 = PLACE_CODE_PTN.matcher(data.strPlace);
    if (match2.find()) { 
      data.strApt = data.strPlace.substring(match2.end()).trim();
      data.strPlace = data.strPlace.substring(0,match2.start()).trim();
    }
    data.strApt = append(data.strApt, " - ", p.getOptional(','));
    data.strApt = append(data.strApt, " - ", p.getLastOptional(" BLDG "));
    parseAddress(p.get(), data);
    
    data.strCity = match.group(2).trim();
    data.strCall = match.group(3).trim();
    String sExtra = match.group(4);
    String[] flds = sExtra.split("\n");
    if (flds.length > 1) {
      data.strUnit = flds[0].trim();
      int last = flds.length-1;
      match = ID_TIME_PTN.matcher(flds[last]);
      if (match.matches()) {
        data.strCallId = match.group(1);
        data.strTime =match.group(2);
        last--;
      }
      for (int ndx = 1; ndx <= last; ndx++) {
        String fld = flds[ndx].trim();
        if (fld.length() > 0) {
          data.strSupp = append(data.strSupp, " / ", fld);
        }
      }
    }
    
    else {
      p = new Parser(sExtra);
      sExtra = p.getLastOptional(" - ");
      data.strSupp = p.get();
      p = new Parser(sExtra);
      data.strUnit = p.get(' ');
      data.strTime = p.get();
    }
    return true;
  }
}
