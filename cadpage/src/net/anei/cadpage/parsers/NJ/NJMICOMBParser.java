package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * This may be obsolete and replaced by NJMICOMBParser, but we are not yet
 * convinced of that
 */

public class NJMICOMBParser extends MsgParser {
  
  private static final Pattern CITY_SFX_PTN = Pattern.compile(" +(?:Boro|City)$");
  
  public NJMICOMBParser() {
    super("", "NJ");
    setFieldList("UNIT ID CITY ADDR APT X CALL TIME");
  }
  
  @Override
  public String getFilter() {
    return "miccom@nnjems.org,cadsmtp@nnjems.org";
  }
  
  @Override
  public String getLocName() {
    return "MICCOM (northern NJ), NJ";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    
    data.strUnit = substring(body, 0, 10);
    
    // There are two flavors of run report, once for cancelled calls and one
    // for normal termination calls
    if (substring(body, 10, 11).equals("@") && 
        substring(body, 42, 43).equals("#") && 
        substring(body, 53, 59).equals("Disp")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strCallId = substring(body, 33, 53);
      return true;
    }

    if (substring(body, 10, 19).equals("CANCEL: #") && 
        substring(body, 80, 87).equals("Disp:")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strCallId = substring(body, 19, 29);
      return true;
    }
    
    // Now check for regular dispatch page

    if (substring(body, 10, 19).equals("RESPOND:#") && 
        substring(body, 150, 151).equals("@")) {
      data.strCallId = substring(body, 19, 29);
      data.strCity = CITY_SFX_PTN.matcher(substring(body, 30, 50)).replaceFirst("");
      parseAddress(substring(body, 50, 80), data);
      data.strApt = substring(body, 80, 90);
      data.strCross = substring(body, 90, 120);
      data.strCall = substring(body, 120, 150);
      data.strTime = substring(body, 151, 157);
      return true;
    }    
    return false;
  }
}
