package net.anei.cadpage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmsMsgParser;

/**
 * This class contains all of the useful data fields that are parsed from
 * the actual message text
 */
public class SmsMsgInfo {

  private String strCall;
  private String strPlace;
  private String strAddress;
  private String strCity;
  private String strApt;
  private String strCross;
  private String strBox;
  private String strUnit;
  private String strState;
  private String strMap;
  private String strCallId;
  private String strPhone;
  private String strSupp;
  private String strCode;
  private String strSource;
  private String strName;
  private String defCity;
  private String defState;
  
  // Flag set when parser determines that message is incomplete
  // and another part should be expected
  private boolean expectMore;
  

  /**
   * Temporary data class used to pass information to constructor
   * @author ken
   *
   */
  public static class Data {
    public String strCall = "";
    public String strPlace = "";
    public String strAddress = "";
    public String strCity = "";
    public String strApt = "";
    public String strCross = "";
    public String strBox= "" ;
    public String strUnit= "" ;
    public String strState="";
    public String strMap = "";
    public String strCallId = "";
    public String strPhone="";
    public String strSupp="";
    public String strCode="";
    public String strSource = "";
    public String strName = "";
    public String defCity = "";
    public String defState="";
    
    public boolean expectMore = false;
    

    /**
     * @return relative score that can be used to pick out the better result
     * from multiple possible parsings
     */
    public int score() {
      int result = 0;
      if (strAddress.length() > 0) result += 10000;
      if (strCall.length() > 0) result += 1000;
      if (strCity.length() > 0) result += 100;
      if (strApt.length() > 0) result += 10;
      if (strCross.length() > 0) result += 100;
      if (strBox.length() > 0) result += 10;
      if (strUnit.length() > 0) result += 10;
      if (strState.length() > 0) result += 10;
      if (strMap.length() > 0) result += 10;
      if (strPlace.length() > 0) result += 10;
      if (strCallId.length() > 0) result += 10;
      if (strPhone.length() > 0) result += 1;
      if (strSupp.length() > 0) result += 1;
      if (strCode.length() > 0) result += 1;
      return result;
    }
  }

  /**
   * constructor
   * @param info data object containing all message information
   */
  public SmsMsgInfo(Data info) {
    strCall = info.strCall;
    strPlace = info.strPlace;
    strAddress = info.strAddress;
    strCity = info.strCity;
    strApt = info.strApt;
    strCross = info.strCross;
    strBox = info.strBox;
    strUnit = info.strUnit;
    strState = info.strState;
    strMap = info.strMap;
    strCallId = info.strCallId;
    strPhone = info.strPhone;
    strSupp = info.strSupp;
    strCode = info.strCode;
    strSource = info.strSource;
    strName = info.strName;
    defCity = info.defCity;
    defState = info.defState;
    expectMore = info.expectMore;
  }
  
  /**
   * @return call ID
   */
  public String getCallId() {
    return strCallId;
  }

  /**
   * @return the Call description
   */
  public String getCall() {
    return strCall;
  }
  
  /**
   * @return return place name
   */
  public String getPlace() {
    return strPlace;
  }

  /**
   * @return the call address
   */
  public String getAddress() {
    return strAddress;
  }
  /**
   * @return return mapping address
   */
  public String getMapAddress() {
    String sAddr = cleanBlock(strAddress);
    sAddr = cleanBounds(sAddr);
    sAddr = cleanHouseNumbers(sAddr);
    sAddr = cleanDoubleRoutes(sAddr);
    StringBuilder sb = new StringBuilder(sAddr);
    
    // If there wasn't an address number or intersection marker in address
    // try appending cross street info as as intersection
    if (!validAddress(sAddr)) {
      if (strCross.length() > 0) {
        sb.append(" & ");
        sb.append(strCross);
      }
    
      // If that didn't work, lets hope a place name will be enough
      else if (strPlace.length() > 0) {
        sb.insert(0, ',');
        sb.insert(0, strPlace);
      }
    }
    
    // Add city if specified, default city otherwise
    boolean override = ManagePreferences.overrideDefaults();
    String city = strCity;
    if (city.length() == 0) {
      city = (override ? ManagePreferences.defaultCity() :  defCity);
    }
    if (city.length() > 0) {
      sb.append(",");
      sb.append(city);
    } 
    
    // Add state if specified, default state otherwise
    String state = strState;
    if (state.length() == 0) {
      state = (override ? ManagePreferences.defaultState() : defState);
    }
    if (state.length() > 0) {
      sb.append(",");
      sb.append(state);
    }
    
    return sb.toString();
	}
  
  // Clean up any BLK indicators
  // Remove occurance of BLK bracketed by non-alpha characters
  private static final Pattern BLK_PAT = Pattern.compile("[^A-Z](BLK)[^A-Z]");
  private String cleanBlock(String sAddr) {
    sAddr = sAddr.replaceAll("[\\{\\}]", "");
    Matcher match = BLK_PAT.matcher(sAddr);
    if (match.find()) {
      sAddr = sAddr.substring(0,match.start(1)) + sAddr.substring(match.end(1));
    }
    return sAddr;
  }
  
  // Clean up and NB, SB, EB, or WB words

  private static final Pattern DIRBOUND_PAT = Pattern.compile("\\s(N|S|E|W)B\\b");
  private String cleanBounds(String sAddr) {
    Matcher match = DIRBOUND_PAT.matcher(sAddr);
    return match.replaceAll("").trim();
  }

  // Google map isn't found of house numbers mixed with intersections
  // If we find an intersection marker, remove any house numbers
  private static final Pattern HOUSE_NUMBER = Pattern.compile("^ *\\d+ +");
  private static final Pattern STREET_SFX = Pattern.compile("^ *(AV|AVE|ST)\\b");
  private String cleanHouseNumbers(String sAddress) {
    sAddress = sAddress.replace(" and ", " & ");
    int ipt = sAddress.indexOf('&');
    if (ipt >= 0) {
      
      Matcher match = HOUSE_NUMBER.matcher(sAddress);
      for (int part = 2; part >= 1; part--) {
        switch (part) {
        case 1:
          match.region(0, ipt);
          break;
          
        case 2:
          match.region(ipt+1, sAddress.length());
        }
        
        if (match.find()) {
          // Safety check, don't mess with number if followed by AV, AVE, or ST
          int st = match.start();
          int end = match.end();
          Matcher match2 = STREET_SFX.matcher(sAddress);
          match2.region(end, match.regionEnd());
          if (! match2.find()) {
            sAddress = sAddress.substring(0, st) + sAddress.substring(end);
          }
        }
      }
    }
    
    // If it isn't an intersection, check for a appt number
    // Generally google ignores appt numbers, but it chokes on one that
    // starts with a #
    else {
      ipt = sAddress.lastIndexOf(' ');
      if (ipt+1 < sAddress.length() && sAddress.charAt(ipt+1) == '#') {
        sAddress = sAddress.substring(0, ipt).trim();
      }
    }
    return sAddress;
  }

  // Google can handle things like ST 666 or US 666 or RTE 666.
  // But it doesn't loke US RTE 666
  // If we find a construct like that, remove the middle section
  private static final Pattern DBL_ROUTE_PTN = 
    Pattern.compile("\\b(US|ST|STATE) +(RT|RTE|ROUTE|HW|HWY) +(\\d+)\\b", Pattern.CASE_INSENSITIVE);
  private String cleanDoubleRoutes(String sAddress) {
    Matcher match = DBL_ROUTE_PTN.matcher(sAddress);
    int pt = 0;
    if (!match.find(pt)) return sAddress;
    
    StringBuilder sb = new StringBuilder();
    do {
      sb.append(sAddress.substring(pt, match.start()));
      sb.append(sAddress.substring(match.start(1), match.end(1)));
      sb.append(' ');
      sb.append(sAddress.substring(match.start(3), match.end(3)));
      pt = match.end();
    } while (match.find(pt));
    sb.append(sAddress.substring(pt));
    return sb.toString();
  }

  
  /**
   * @return true if address is valid standalone address
   * (ie either starts with a house number or contains an intersection marker) 
   */
  private boolean validAddress(String sAddr) {
    int pt = sAddr.indexOf(' ');
    if (pt > 0 && SmsMsgParser.NUMERIC.matcher(sAddr.substring(0, pt)).matches()) return true;
    if (sAddr.contains("&") || sAddr.contains(" AND ") || sAddr.contains(" and ")) return true; 
    return false;
  }
  
  /**
   * @return the call city
   */
  public String getCity() {
    return strCity;
  }

  /**
   * @return the call State
   */
  public String getState() {
    return strState;
  }

  /**
   * @return the call appt number
   */
  public String getApt() {
    return strApt;
  }

  /**
   * @return the call Cross street description
   */
  public String getCross() {
    return strCross;
  }

  /**
   * @return the call box
   */
  public String getBox() {
    return strBox;
  }

  /**
   * @return the call unit
   */
  public String getUnit() {
    return strUnit;
  }
  
  /**
   * @return map code
   */
  public String getMap() {
    return strMap;
  }
  
  /**
   * @return the callback phone number
   */
  public String getPhone() {
    return strPhone;
  }
  /**
   * @return the Supp Info 
   */
  public String getSupp() {
    return strSupp;
  }
  
  /***
   * @return call type code
   */
  public String getCode() {
    return strCode;
  }
  
  /**
   * @return the page source 
   */
  public String getSource() {
    return strSource;
  }
  
  /**
   * @return name
   */
  public String getName() {
    return strName;
  }
  
  
  /**
   * @return the default city 
   */
  public String getDefCity() {
    return defCity;
  }
  
  /**
   * @return the default state 
   */
  public String getDefState() {
    return defState;
  }
  
  /**
   * @return true if additional messages are expected
   */
  public boolean isExpectMore() {
    return expectMore;
  }
  

  /**
   * Append message information to support message under construction
   * @param sb String builder holding message being constructed
   */
  public void addMessageInfo(StringBuilder sb) {
    sb.append("\n\nParser Info");
    
    addInfo(sb, "Call", strCall);
    addInfo(sb, "Place", strPlace);
    addInfo(sb, "Addr", strAddress);
    addInfo(sb, "City", strCity);
    addInfo(sb, "Apt", strApt);
    addInfo(sb, "X", strCross);
    addInfo(sb, "Box", strBox);
    addInfo(sb, "Unit", strUnit);
    addInfo(sb, "St", strState);
    addInfo(sb, "Map", strMap);
    addInfo(sb, "ID", strCallId);
    addInfo(sb, "Ph", strPhone);
    addInfo(sb, "Info", strSupp);
    addInfo(sb, "Code", strCode);
  }
  
  private void addInfo(StringBuilder sb, String title, String value) {
    if (value.length() > 0) {
      sb.append('\n');
      sb.append(title);
      sb.append(':');
      sb.append(value);
    }
  }



}
