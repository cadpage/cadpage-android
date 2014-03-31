package net.anei.cadpage.parsers.MN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;



public class MNWrightCountyParser extends DispatchA13Parser {
  
  private static final Pattern COUNTY_PTN = Pattern.compile("(.*?)[ -]+(HENNE|STEARNS)", Pattern.CASE_INSENSITIVE);
  
  public MNWrightCountyParser() {
    super("WRIGHT COUNTY", "MN");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    Matcher match = COUNTY_PTN.matcher(data.strAddress);
    if (match.matches()) {
      data.strAddress = match.group(1);
      if (data.strCity.length() == 0) {
        String county =  match.group(2).toUpperCase();
        if (county.equals("HENNE")) county = "HENNEPIN";
        data.strCity =  county + " COUNTY";
      }
    }
    return true;
  }
  
}
