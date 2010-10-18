package net.anei.cadpage;

/**
 * This class contains all of the useful data fields that are parsed from
 * the actual message text
 */
public class SmsMsgInfo {

  private String strCall;
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
  private String defCity;
  private String defState;

  /**
   * Temporary data class used to pass information to constructor
   * @author ken
   *
   */
  public static class Data {
    public String strCall = "";
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
    public String defCity = "";
    public String defState="";
  }

  /**
   * constructor
   * @param info data object containing all message information
   */
  public SmsMsgInfo(Data info) {
    strCall = info.strCall;
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
    defCity = info.defCity;
    defState = info.defState;
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
   * @return the call address
   */
  public String getAddress() {
    return strAddress;
  }

  /**
   * @return return mapping address
   */
  public String getMapAddress() {
    StringBuilder sb = new StringBuilder(strAddress);
    String city = strCity;
    if (city.length() == 0) city = defCity;
    if (city.length() > 0) {
      sb.append(",");
      sb.append(city);
    } 
    String state = strState;
    if (state.length() == 0) state = defState;
    if (state.length() > 0) {
      sb.append(",");
      sb.append(state);
    }
    
    return sb.toString();
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
}
