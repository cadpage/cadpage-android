package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

/**
 * Adams County, PA
 */
public class PAAdamsCountyParser extends DispatchA1Parser {
  
  private static final Pattern IAMR_PREFIX = Pattern.compile("^Alert: .*\n");
  
  public PAAdamsCountyParser() {
    super("ADAMS COUNTY", "PA");
  }

  @Override
  public String getFilter() {
    return"adams911@adamscounty.us,messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Check for garbled prefix associated with IamResponding
    Matcher match = IAMR_PREFIX.matcher(body);
    if (match.find()) {
      data.strSource = subject;
      subject = match.group().trim();
      body = body.substring(match.end()).trim();
    }
    
    
    if (!super.parseMsg(subject, body, data)) return false;
    String city = data.strCity;
    if (city.toUpperCase().endsWith(" BORO")) {
      data.strCity = city.substring(0,city.length()-5).trim();
    } else {
      if (city.endsWith(" CO")) data.strCity = city = city + "UNTY";
      if (city.equals("WASHINGTON COUNTY") || 
          city.equals("CARROLL COUNTY") ||
          city.equals("FREDERICK COUNTY")) data.strState = "MD";
    }
    data.strSupp = data.strSupp.replace(" / ", "\n");
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram().replace("CITY", "CITY ST");
  }
}
