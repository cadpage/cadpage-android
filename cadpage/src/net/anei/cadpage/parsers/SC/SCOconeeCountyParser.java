package net.anei.cadpage.parsers.SC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Oconee County, SC
Contact: William Rochester <william.rocheste
Sender: 911@oconeelaw.com
System: Aegis

[911 Message]  S80 - CORONARY PROBLEM  1280 N  STHY 11 XStreet: SPRINGDALE DR / SCENIC HEIGHTS RD, FOWLER RD WEST UNION    2011-00000815  09/26/11 22:27  Narr:   S
[911 Message]  S80 - CORONARY PROBLEM  206 S  TUGALOO ST XStreet: W MAULDIN ST / BOOKER DR WALHALLA    2011-00000809  09/25/11 06:49  Narr:   PATIENT IS HER FATHER
[911 Message]  S46 - ALTERED MENTAL STATUS  308 N  LAUREL ST XStreet: ARDASHIR LN / WALHALLA GARDENS CIR WALHALLA    2011-00000777  09/16/11 12:24  Narr:   76 YOA
(911 Message) S4 - DIABETIC REACTION  100 PINE MANOR CIR APT 3 XStreet: STOUDEMIRE ST / STOUDEMIRE ST WALHALLA  COUNTRY RIDGE APTS  2011-00000872  10/26/11 19:21
(911 Message) LIFT ASSISTANCE  313 MANOR LN XStreet: INDUSTRIAL PARK PL / DEAD END SENECA     12/02/11 01:06  Narr:   COME TO THE BACK DOOR  NEEDS HELP GETTING UP
(911 Message) S86 - CHEST PAIN  3440 BLUE RIDGE BLVD XStreet: MISTY DR, THE OLE HOME PLACE LN / TRAVELLERS BLVD WEST UNION  EDWARDS AUTO SALES  2011-00000946  11/
(911 Message) LIFT ASSISTANCE  313 MANOR LN XStreet: INDUSTRIAL PARK PL / DEAD END SENECA     12/02/11 01:06  Narr:   COME TO THE BACK DOOR  NEEDS HELP GETTING UP

 */


public class SCOconeeCountyParser extends SmartAddressParser {
  
  private static final Pattern ID_PTN = Pattern.compile("  (\\d{4}-\\d{8})  ");
  private static final Pattern DATE_TIME_MARK = Pattern.compile("    (\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d)\\b");
  private static final Pattern DATE_TIME_MARK2 = Pattern.compile("^(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d)\\b");
  private static final String DATE_TIME_MARK3 = "NN/NN/NN NN:NN";
  
  public SCOconeeCountyParser() {
    super(CITY_LIST, "OCONEE COUNTY", "SC");
  }
  
  @Override
  public String getFilter() {
    return "911@oconeelaw.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("911 Message")) return false;
    
    // Look for an ID marker
    String sLeader, sTrailer;
    do {
      Matcher match = ID_PTN.matcher(body);
      if (match.find()) {
        
        // Found it, get the ID and identify leading portion
        data.strCallId = match.group(1);
        sLeader = body.substring(0,match.start()).trim();
        sTrailer = body.substring(match.end()).trim();
        
        // This should be followed by a date and time
        match = DATE_TIME_MARK2.matcher(sTrailer);
        if (match.find()) {
          data.strDate = match.group(1);
          data.strTime = match.group(2);
          sTrailer = sTrailer.substring(match.end()).trim();
          break;
        }
        
        // If it isn't, see if it is a truncated Date/time
        String sCheck = sTrailer.replaceAll("\\d", "N");
        if (! DATE_TIME_MARK3.startsWith(sCheck)) return false;
        sTrailer = "";
        break;
      }
      
      match = DATE_TIME_MARK.matcher(body);
      if (match.find()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
        sLeader = body.substring(0,match.start()).trim();
        sTrailer = body.substring(match.end()).trim();
        break;
      }
      return false;
    } while (false);

    int pt = sLeader.indexOf("  ");
    if (pt < 0) return false;
    data.strCall = sLeader.substring(0,pt);
    String sAddr = sLeader.substring(pt+2).trim();
    
    sAddr = sAddr.replace(" XStreet:", " XS:");
    parseAddress(StartType.START_ADDR, FLAG_START_FLD_REQ, sAddr, data);
    data.strPlace = getLeft();
    
    if (sTrailer.startsWith("Narr:")) sTrailer = sTrailer.substring(5).trim();
    if ("Narr:".startsWith(sTrailer)) sTrailer = "";
    data.strSupp = sTrailer;
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "SALEM",
    "SENECA",
    "WALHALLA",
    "WEST UNION",
    "WESTMINSTER",
    
    "FAIR PLAY",
    "LONG CREEK",
    "MOUNTAIN REST",
    "NEWRY",
    "OAKWAY",
    "RICHLAND",
    "TAMASSEE",
    "TOWNVILLE",
    "UTICA"
  };
}
