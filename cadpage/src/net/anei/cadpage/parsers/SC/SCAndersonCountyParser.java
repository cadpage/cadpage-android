package net.anei.cadpage.parsers.SC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class SCAndersonCountyParser extends DispatchB2Parser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("^(?:ANDERSON CO 911|AND 911|active911|([-a-z0-9]+)):");
 
  public SCAndersonCountyParser() {
    super(CITY_CODES, "ANDERSON COUNTY", "SC");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // See if this is one of our pages
    Matcher match = UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    data.strUnit = getOptGroup(match.group(1));
    body = body.substring(match.end()).trim();
    
    if (subject.equals("EVENT")) subject = "EVENT:";
    body = append(subject, " ", body);
    
    // Call superclass parser
    body = body.replace('@', '&').replace("//", "/");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    return sAddress.replace("SIX AND TWENTY", "SIX_AND_TWENTY");
  }

  @Override
  public String postAdjustMapAddress(String sAddress) {
    return sAddress.replace("SIX_AND_TWENTY", "SIX AND TWENTY");
  }

  private static final String[] CITY_CODES = new String[]{
    "ANDERSON", 
    "BELTON", 
    "CLEMSON", 
    "EASLEY",
    "HONEA PATH",
    "IVA",
    "PELZER", 
    "STARR",
    "WEST PELZER",
    "WILLIAMSTON",
    "CENTERVILLE",
    "HOMELAND PARK",
    "LA FRANC",
    "NORTHLAKE",
    "PIEDMONT", 
    "POWDERSVILLE",
    "SANDY SPRINGS",
    "TOWNVILLE",
    
    "PENDLETON"
  };
}
