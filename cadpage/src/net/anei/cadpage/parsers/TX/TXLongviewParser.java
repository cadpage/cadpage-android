package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/* Sample Longview Page
 * 
RC:Run# 30209/ *Non Life Emergency P/2/ Sick Person (Specific Diagnosis)/ 1102 FRANCIS/ EASTON/ 18:21/ <Unknown>/ bp issues-- dizzy spells-- P
RC:Run# 30209/*Non Life Emergency P/1/Sick Person (Specific Diagnosis)/1102 FRANCIS///EASTON/18:21/////<Unknown>/bp issues-- dizzy spells--
RC:Run# 29907/PR Event/Public Service/CRYSTAL FARMS RD///TATUM/19:15/////PR EVENT/ TATUM/Tatum vs Harmony////
RC:Run# 29793/*Non Life Emergency P/1/Falls/301 B FORREST ACRES///TATUM/22:18/////<Unknown>/////
RC:Run# 29764/*Non Life Emergency P/1/Overdose / Poisoning (Ingestion)/1100 S ADAMS ST//Panola Apts: 32/CARTHAGE/17:23/////<Unknown>/////

Champion EMS, Danigerfield, TX
Contact: Daniel White <dwhite@championems.com>
Sender: nettechs@championems.com

[CAD - part 1 of 1]  RC:Run# 31754/*Non Life Emergency P/1/Chest Pain/204 MOUNTAIN VIEW///DAIGNERFEILD/02:13/////<Unknown>/////
[CAD - part 1 of 1]  RC:Run# 31710/*Non Life Emergency P/1/Unconscious / Fainting (Near)/347 COUNTY ROAD 2101///DAINGERFIELD/13:31/////<Unknown>/had stent t
[CAD - part 1 of 1]  RC:Run# 31696/*Non Life Emergency P/1/Sick Person (Specific Diagnosis)/2246 COUNTY ROAD 4206///NAPLES/10:31/////<Unknown>/////
[CAD - part 1 of 1]  RC:Run# 31669/*Non Life Emergency P/1/Falls/3000 FM 250///HUGHES SPRINGS/23:22/////<Unknown>/////
[CAD - part 1 of 1]  RC:Run# 31646/*Non Life Emergency P/2/Assault / Sexual Assault/1005 COUNTY ROAD 4214///DAINGERFIELD/17:30/////<Unknown>/pt was thrown d
[CAD - part 1 of 1]  RC:Run# 31627/*Non Life Emergency P/1/Unconscious / Fainting (Near)/401 E HOUSTON ST///LINDEN/14:06/////<Unknown>/passed out////
[CAD - part 1 of 1]  RC:Run# 31414/PR Event/<None>/US HWY 67//N33 11.075 x W94 42.799/OMAHA/16:30/////PR EVENT/ PR EVENT/////
[CAD - part 1 of 1]  RC:Run# 31394/*Non Scheduled Transfer/Routine Transfer/Titus Regional Medical Center//Wound Care/MOUNT PLEASANT/13:31/Omaha Health Care
[CAD - part 1 of 1]  RC:Run# 31315/*Non Life Emergency P/1/Chest Pain/1912 GUM SPRINGS RD///LONGVIEW/14:56/////<Unknown>/Camp RV park --////

 */

public class TXLongviewParser extends DispatchProQAParser {
  
  private static final String DEF_STATE = "TX";
  private static final String DEF_CITY = "LONGVIEW";
  
  private static final Pattern TIME_PATTERN = Pattern.compile("\\d\\d:\\d\\d");
  
  public TXLongviewParser() {
    super(DEF_CITY, DEF_STATE, null);
  }
  
  @Override
  public String getFilter() {
    return "nettechs@championems.com";
  }

  @Override
  public boolean parseFields(String[] flds, Data data) {
    
    if (flds.length < 6) return false;
    
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
    String fld = flds[ndx];
    if (fld.toUpperCase().contains("APT")) {
      int pt = fld.lastIndexOf(':');
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
    for (int pt = 0; pt<ndx; pt++) {
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
