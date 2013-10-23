package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class OHClarkCountyBParser extends SmartAddressParser {

  public static Pattern MASTER = Pattern.compile("-?(.*?)(?:-(\\d{4}))");
  public static Pattern CALL_CLEANER = Pattern.compile("(?: ?[/-] )?(.*?)");
  public static Pattern DELIMITER_MATCHER = Pattern.compile("(.*?)(?: APT (\\w+) | \\- | / )(.*?)");
  
  public OHClarkCountyBParser() {
    super("CLARK COUNTY", "OH");
    setFieldList("PLACE ADDR APT CALL ID");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {    
        
    //remove leading dash and trailing -nnnn
    Matcher mat = MASTER.matcher(body);
    if (mat.matches()) {
      body = mat.group(1).trim();
      data.strCallId = mat.group(2);
    }
    
  //parse
    parseAddress(StartType.START_ADDR, FLAG_NO_IMPLIED_APT|FLAG_IGNORE_AT, body, data);
    data.strCall = getLeft();
    
  //try with place start type
    if(data.strCall.equals("")) {
      data.strAddress = data.strApt = data.strPlace = "";
      parseAddress(StartType.START_PLACE, FLAG_NO_IMPLIED_APT|FLAG_IGNORE_AT, body, data);
      data.strCall = getLeft();
    }
    
    //if that failed, look for " - ", " / ", or " APT \\w+", and use it to mark end of addr field
    if(data.strCall.equals("")) {
      Matcher delMat = DELIMITER_MATCHER.matcher(body);
      if(delMat.matches()) {
        data.strAddress = data.strApt = data.strPlace = "";
        data.strAddress = delMat.group(1);
        if (delMat.group(2) != null) data.strApt = delMat.group(2); //if delimiter was apt then give its value to strApt
        data.strCall = delMat.group(3);
      }
    }
    
    //last resort, now try parseaddress with FLAG_OPT_ST_SFX
    if (data.strCall.equals("")) {
      data.strAddress = data.strApt = data.strPlace = "";
      parseAddress(StartType.START_ADDR, FLAG_NO_IMPLIED_APT|FLAG_OPT_STREET_SFX|FLAG_IGNORE_AT, body, data);
      data.strCall = getLeft();
    }
    
    //if call is still empty, make it a general report
    if(data.strCall.equals("")) {
      data.strAddress = data.strApt = data.strPlace = "";
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
    } else {
      //remove leading " / " or " - " from call (which only occurs as a result of parseaddress, so luckily it only needs to be here.)
      Matcher callMat = CALL_CLEANER.matcher(data.strCall);
      if(callMat.matches()) data.strCall = callMat.group(1);
    }
    
    return true;
  }

}
