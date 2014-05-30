package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class CTFairfieldCountyBParser extends SmartAddressParser {

  public CTFairfieldCountyBParser() {
    super(CITY_LIST, "FAIRFIELD COUNTY", "CT");
    setFieldList("SRC ADDR APT CITY CALL TIME");
  }
  
  @Override
  public String getFilter() {
    return "swrcc@dmsct.net";
  }

  private static Pattern MASTER = Pattern.compile("(?:MEMS: )?(.*?) - (.*?) --(?:Disp |CMED)@ (\\d{2}:\\d{2})");
  
  @Override protected boolean parseMsg(String subject, String body, Data data) {
    
    // Process general alerts
    if (subject.equals("Message from SWRCC")) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
      return true;
    }
    
    if (!subject.contains(":")) data.strSource = subject;
    
    
    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;
    parseAddress(StartType.START_ADDR, mat.group(1).trim(), data);
    data.strCall = mat.group(2).trim();
    data.strTime = mat.group(3).trim();
    return true;
  }
  
  private static String[] CITY_LIST = new String[]{
    "EASTON",
    "MONROE" 
  };
  
}
