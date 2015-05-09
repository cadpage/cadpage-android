package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;



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
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  public boolean parseFields(String[] flds, Data data) {
    
    if (flds.length < 6) return false;
    
    for (int j = 0; j<flds.length; j++) flds[j] = flds[j].trim();
    
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
