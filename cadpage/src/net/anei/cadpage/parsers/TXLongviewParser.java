package net.anei.cadpage.parsers;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/* Sample Longview Page
 * 
RC:Run# 30209/ *Non Life Emergency P/2/ Sick Person (Specific Diagnosis)/ 1102 FRANCIS/ EASTON/ 18:21/ <Unknown>/ bp issues-- dizzy spells-- P
RC:Run# 30209/*Non Life Emergency P/1/Sick Person (Specific Diagnosis)/1102 FRANCIS///EASTON/18:21/////<Unknown>/bp issues-- dizzy spells--
RC:Run# 29907/PR Event/Public Service/CRYSTAL FARMS RD///TATUM/19:15/////PR EVENT/ TATUM/Tatum vs Harmony////
RC:Run# 29793/*Non Life Emergency P/1/Falls/301 B FORREST ACRES///TATUM/22:18/////<Unknown>/////
RC:Run# 29764/*Non Life Emergency P/1/Overdose / Poisoning (Ingestion)/1100 S ADAMS ST//Panola Apts: 32/CARTHAGE/17:23/////<Unknown>/////

We have no examples of cross street or intersections, so we are probably handling them badly.

 */

public class TXLongviewParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "TX";
  private static final String DEF_CITY = "LONGVIEW";
  
  private static final Pattern SPLIT_PATTERN = Pattern.compile(" */+ *");
  private static final Pattern TIME_PATTERN = Pattern.compile("\\d\\d:\\d\\d");
  
  public TXLongviewParser() {
    super(DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    if (! body.startsWith("RC:Run# ")) return false;

    data.defCity=DEF_CITY;
    data.defState=DEF_STATE;
    
    String[] flds = SPLIT_PATTERN.split(body);
    
    // Extract call ID from first field
    String fld = flds[0];
    int pt = fld.lastIndexOf(' ');
    if (pt >= 0) data.strCallId = fld.substring(pt+1);
    
    // Fields are tightly delimited but very loosely positioned
    // Only consistent field we can identify is a time marker, so lets find it
    int timeLine = -1;
    for (int ndx = 0; ndx < flds.length; ndx++) {
      if (TIME_PATTERN.matcher(flds[ndx]).matches()) {
        timeLine = ndx;
        break;
      }
    }
    if (timeLine == -1) return false;
    
    // Field in front of time marker is always the city
    int ndx = timeLine-1;
    if (ndx < 0) return false;
    data.strCity = flds[ndx];
    
    // Field in front of that is usually the address, but may contain an apartment number
    if (--ndx < 0) return false;
    fld = flds[ndx];
    if (fld.toUpperCase().contains("APT")) {
      pt = fld.lastIndexOf(':');
      if (pt < 0) pt = fld.lastIndexOf(' ');
      if (pt >= 0) {
        data.strApt = fld.substring(pt+1).trim();
        if (--ndx < 0) return false;
      }
    }
    
    // Next field has to be the address
    data.strAddress = flds[ndx];
    
    // Construct the call description with everything from field 2 up to the
    // address field
    for (pt = 1; pt<ndx; pt++) {
      if (data.strCall.length() > 0) data.strCall += "/";
      data.strCall += flds[pt];
    }
    
    // Construct extra information field from everything behind the time marker
    for (ndx = timeLine+1; ndx<flds.length; ndx++) {
      if (flds[ndx].equalsIgnoreCase("<Unknown>")) continue;
      if (data.strSupp.length() > 0) data.strSupp += "/";
      data.strSupp += flds[ndx];
    }
    return true;
  }
}
