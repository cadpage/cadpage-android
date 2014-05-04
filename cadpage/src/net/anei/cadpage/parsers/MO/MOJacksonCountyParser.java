package net.anei.cadpage.parsers.MO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.HtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOJacksonCountyParser extends HtmlParser {
//  private static int n = 1;
  
  public MOJacksonCountyParser() {
    super("JACKSON COUNTY", "MO",
        "ID DATE TIME CALL PRI PLACE ADDR APT CITY MAP GPS CODE X",
        LAYOUT
        );
  }
  
  @Override
  public String getProgram() {
    return "ID DATE TIME CALL PRI PLACE ADDR APT CITY MAP GPS CODE X";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  private static final DateFormat MY_DATE_FMT
    = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
  
  @Override
  protected boolean parseHtmlMsg(String head, String body, Data data) {
    
    if (!getHtmlCleaner(body))
      return false;

//    makeFile("/home/brennus/html/jc-"+n+".html");
//    n++;
    
    /*
    data.strCallId = clean(getOptGroup(getTableCellValue(3, "Master_Incident_Number", 1)));
    String dateTime = getOptGroup(getTableCellValue(3, "Response_Date", 1));
    setDateTime(MY_DATE_FMT, clean(dateTime), data);
    callString = getOptGroup(getTableCellValue(3, "Problem", 1));
    if (callString.contains("/")) {
      String[] ccList = callString.split("/");
      data.strCall = ccList[0].trim();
      data.strCode = ccList[1].trim();
    }
    else
      data.strCall = callString;
    data.strPriority = getOptGroup(getTableCellValue(3, "Priority_Number", 1));
    data.strPlace = getOptGroup(getTableCellValue(3, "Location_Name", 1));
    data.strAddress = getOptGroup(getTableCellValue(3, "Address", 1));
    data.strApt = getOptGroup(getTableCellValue(3, "Apartment", 1));
    data.strCity = getOptGroup(getTableCellValue(3, "City", 1));
    data.strMap = getOptGroup(getTableCellValue(3, "Map_Info", 1));
    latitude = getOptGroup(getTableCellValue(3, "Latitude", 1));
    longitude = getOptGroup(getTableCellValue(3, "Longitude", 1));
    if (latitude.length() > 2)
      latitude = latitude.substring(0, 2)+"."+latitude.substring(2);
    if (longitude.length() > 2)
      longitude = longitude.substring(0, 2)+"."+longitude.substring(2);
    data.strGPSLoc = latitude+","+longitude;
    if (data.strCode.equals(""))
      data.strCode = getOptGroup(getTableCellValue(17, "Incident_Type", 1));
    data.strCross = getOptGroup(getTableCellValue(12, "Cross_Street", 1));
    */
    
    data.strCallId = getValue("CALLID");
    setDateTime(MY_DATE_FMT, clean(getValue("DATETIME")), data);
    String callString = getValue("CALLCODE");
    if (callString.contains("/")) {
      String[] ccList = callString.split("/");
      data.strCall = ccList[0].trim();
      data.strCode = ccList[1].trim();
    }
    else
      data.strCall = callString;
    data.strPriority = getValue("PRIORITY");
    data.strPlace = getValue("PLACE");
    data.strAddress = getValue("ADDRESS");
    data.strApt = getValue("APT");
    data.strCity = getValue("CITY");
    data.strMap = getValue("MAP");
    String latitude = getValue("LATITUDE"),
        longitude = getValue("LONGITUDE");
//    System.out.println("lat:"+latitude+", lon:"+longitude);
    if (latitude.length() > 2)
      latitude = latitude.substring(0, 2)+"."+latitude.substring(2);
    if (longitude.length() > 2)
      longitude = longitude.substring(0, 2)+"."+longitude.substring(2);
    data.strGPSLoc = latitude+","+longitude;
    if (data.strCode.equals(""))
      data.strCode = getValue("CODE");
    data.strCross = getValue("CROSS");
    
    return data.strCallId.length()>0 && data.strDate.length()>0 && data.strTime.length()>0 && callString.length()>0 && data.strPriority.length()>0 && data.strAddress.length()>0;
  }
  
  private static final String[] LAYOUT = {
    /*
     * for some reason I can't now get elements under a node other than root
     * so for now just use top level domain.  Fixed!  It's a problem with
     * htmlcleaner 2.7 being too smart and rejecting tags (& their descendants)
     * with a certain value of the xmlns attribute.
     * 
*/
    "CALLID(TABLE=3;ELEMENT=TD;LABEL=/Master_Incident_Number/;OFFSET=1)",
    "DATETIME(TABLE=3;ELEMENT=TD;LABEL=/Response_Date/;OFFSET=1)",
    "CALLCODE(TABLE=3;ELEMENT=TD;LABEL=/Problem/;OFFSET=1)",
    "PRIORITY(TABLE=3;ELEMENT=TD;LABEL=/Priority_Number/;OFFSET=1)",
    "PLACE(TABLE=3;ELEMENT=TD;LABEL=/Location_Name/;OFFSET=1)",
    "ADDRESS(TABLE=3;ELEMENT=TD;LABEL=/Address/;OFFSET=1)",
    "APT(TABLE=3;ELEMENT=TD;LABEL=/Apartment/;OFFSET=1)",
    // To avoid finding "Kansas City"
    "CITY(TABLE=3;ELEMENT=TD;LABEL=/Caller_Type/;OFFSET=-1)",
    "MAP(TABLE=3;ELEMENT=TD;LABEL=/Map_Info/;OFFSET=1)",
    "LATITUDE(TABLE=3;ELEMENT=TD;LABEL=/Latitude/;OFFSET=1)",
    "LONGITUDE(TABLE=3;ELEMENT=TD;LABEL=/Longitude/;OFFSET=1)",
    "CODE(TABLE=17;ELEMENT=TD;LABEL=/Incident_Type/;OFFSET=1)",
    "CROSS(TABLE=12;ELEMENT=TD;LABEL=/Cross_Street/;OFFSET=1)"

/*
    "CALLID(ELEMENT=TD;LABEL=/Master_Incident_Number/;OFFSET=1)",
    "DATETIME(ELEMENT=TD;LABEL=/Response_Date/;OFFSET=1)",
    "CALLCODE(ELEMENT=TD;LABEL=/Problem/;OFFSET=1)",
    "PRIORITY(ELEMENT=TD;LABEL=/Priority_Number/;OFFSET=1)",
    "PLACE(ELEMENT=TD;LABEL=/Location_Name/;OFFSET=1)",
    "ADDRESS(ELEMENT=TD;LABEL=/Address/;OFFSET=1)",
    "APT(ELEMENT=TD;LABEL=/Apartment/;OFFSET=1)",
    "CITY(ELEMENT=TD;LABEL=/City/;OFFSET=1)",
    "MAP(ELEMENT=TD;LABEL=/Map_Info/;OFFSET=1)",
    "LATITUDE(ELEMENT=TD;LABEL=/Latitude/;OFFSET=1)",
    "LONGITUDE(ELEMENT=TD;LABEL=/Longitude/;OFFSET=1)",
    "CODE(ELEMENT=TD;LABEL=/Incident_Type/;OFFSET=1)",
    "CROSS(ELEMENT=TD;LABEL=/Cross_Street/;OFFSET=1)"
*/
  };
 }