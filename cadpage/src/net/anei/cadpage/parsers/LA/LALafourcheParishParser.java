package net.anei.cadpage.parsers.LA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class LALafourcheParishParser extends SmartAddressParser {

  public final static Pattern PATTERN_SUBJECT = Pattern.compile("(\\d\\d-\\d{5,6}) - (\\d+[A-Z]?) : (.*)");
  public final static Pattern PATTERN_SUBJECT_SHORT = Pattern.compile("(\\d\\d-\\d{5}) -");
  public final static Pattern PATTERN_SUBJECT_SPC = Pattern.compile("FIRE ALARM|AIR MED|HOUSE FIRE|FIRE AT .*");
  
  public LALafourcheParishParser() {
    super(CITY_LIST, "LAFOURCHE PARISH", "LA");
    setFieldList("ID CODE CALL ADDR APT CITY INFO");
  }
  
  @Override
  public String getFilter() {
    return "no-reply@ledsportal.com,Dispatch@thibfiredept.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String strSubject, String strMessage, Data data) {
    
    // Extract the message ID from the Subject
    do {
      Matcher subMatch = PATTERN_SUBJECT.matcher(strSubject);
      if(subMatch.matches()) {                                      // Test for regular pattern
        data.strCallId = subMatch.group(1);
        data.strCode = subMatch.group(2);
        data.strCall = subMatch.group(3).trim();
        break;
      }
      Matcher shortMatch = PATTERN_SUBJECT_SHORT.matcher(strSubject);
      if (shortMatch.matches()) {
        data.strCallId = shortMatch.group(1);
        int pt = strMessage.toUpperCase().indexOf(" AT ");
        if (pt < 0) return false;
        data.strCall = strMessage.substring(0,pt).trim();
        strMessage = strMessage.substring(pt+4).trim();
        break;
      }
      
      Matcher special = PATTERN_SUBJECT_SPC.matcher(strSubject);
      if(special.matches()) {
        data.strCall = strSubject;
        break;
      }
      
      return false;
    } while (false);
    
    // Substitute LF's with spaces from message
    strMessage = strMessage.replace('\n', ' ');
    
    // Remove Intersection of
    strMessage = strMessage.replace("Intersection of", "").trim();
    
    // Extract the Address
    String leftOver = "";
    int firstComma = strMessage.indexOf(',');
    
    // Determine if we need have a comma or need to use Smart Address Parser
    if(firstComma >= 0) {
      parseAddress(strMessage.substring(0, firstComma).trim(), data);
      leftOver = strMessage.substring(firstComma+1).trim();
      
      // Extract the City
      String city = CITY_SET.getCode(leftOver);
      if(city != null) {
        data.strCity = city;
        leftOver = leftOver.substring(city.length()).trim();
        
        if(leftOver.startsWith(",")) {
          leftOver = leftOver.substring(1).trim();
        }
        
        if(leftOver.startsWith("LA")) {
          leftOver = leftOver.substring(2).trim();
        }
      }
      
      data.strSupp = leftOver;
    }
    // Need to use Smart Address Parser
    else {        
      // Remove the call from the start of the message
      if(strMessage.startsWith(data.strCall)) {
        strMessage = strMessage.substring(data.strCall.length()).trim();
      }
      
      // Parse the Address
      parseAddress(SmartAddressParser.StartType.START_ADDR, strMessage, data);
      
      // Remove address from string and store the rest in Info
      int addressIdx = strMessage.indexOf(data.strAddress);
      leftOver = strMessage.substring(addressIdx+data.strAddress.length()).trim();
      data.strSupp = leftOver;
    }
    
    return true;
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    
    // Replace "BY-PASS" with "BYPASS" (special case)
    sAddress = sAddress.replace("BY-PASS", "BYPASS");
    return sAddress;
  }
  
  private final static String[] CITY_LIST = new String[]{
      "THIBODAUX",
      "GOLDEN MEADOW",
      "LOCKPORT",
      "GHEENS",
      "CHACKBAY",
      "CUT OFF",
      "DES ALLEMANDS",
      "GALLIANO",
      "LAROSE",
      "MATHEWS",
      "PORT FOURCHON",
      "RACELAND"
  };
  private final static CodeSet CITY_SET = new CodeSet(CITY_LIST);
}
