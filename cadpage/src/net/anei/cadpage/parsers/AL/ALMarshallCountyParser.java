package net.anei.cadpage.parsers.AL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

/**
 * St Clair County, AL
 */
public class ALMarshallCountyParser extends DispatchB2Parser {
  
  private static final Pattern ID_PTN = Pattern.compile("^(\\d+):");
  private static final Pattern MARKER_PTN = Pattern.compile("^(\\d{10})?911-CENTER:");


  public ALMarshallCountyParser() {
    super(2, CITY_LIST, "MARSHALL COUNTY", "AL");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@marshall911.com,2002";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    do {  // Dummy loop
      
      Matcher match = ID_PTN.matcher(body);
      if (match.find()) {
        data.strCallId = match.group(1);
        body = body.substring(match.end()).trim();
        break;
      }
      
      match = MARKER_PTN.matcher(body);
      if (match.find()) {
        data.strCallId = match.group(1);
        body = body.substring(match.end()).trim();
        break;
      }
      
      return false;
    } while (false);
    
    return super.parseMsg(body,  data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALBERTVILLE",
    "ARAB",
    "BOAZ",
    "DOUGLAS",
    "JOPPA",
    "GRANT",
    "GUNTERSVILLE",
    "HORTON",
    "UNION GROVE"
  };
}
