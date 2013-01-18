package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.Message;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

/**
 * Gloucester County, NJ (version A)
 */
public class NJGloucesterCountyAParser extends DispatchProphoenixParser {
  
  private static final Pattern FROM_ADDR_PTN = Pattern.compile("GC RSAN #(\\d+)");
  private static final Pattern SPECIAL_TRAIL_PTN = Pattern.compile(";.{2}$");
  
  private String fromAddress;
  
  public NJGloucesterCountyAParser() {
    super(CITY_CODES, "GLOUCESTER COUNTY", "NJ");
  }
 
  @Override
  public String getFilter() {
    return "gccad@co.gloucester.nj.us,777";
  }
  
  @Override
  protected Data parseMsg(Message msg, int parseFlags) {
    fromAddress = msg.getAddress();
    return super.parseMsg(msg, parseFlags);
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    
    // THere are some weird text options presumably introduced by forwarding services
    if (body.startsWith("Fwd:")) body = body.substring(4).trim();
    
    Matcher match = FROM_ADDR_PTN.matcher(fromAddress);
    if (match.matches()) {
      body = "GC ALERT (#" + match.group(1) + ") " + body;
      match = SPECIAL_TRAIL_PTN.matcher(body);
      if (match.find()) body = body.substring(0,match.start()).trim();
    }
    
    if (!body.contains("\n")) body = body.replace("} ", "}\n");
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("ROWAN")) {
      data.strPlace = data.strCity;
      data.strCity = "GLASSBORO";
    }
    return true;
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "A", "CLAYTON",
      "B", "DEPTFORD",
      "C", "EAST GREENWICH TWP",
      "D", "ELK TWP",
      "E", "FRANKLIN TWP",
      "F", "GLASSBORO",
      "G", "GIBBSTOWN",
      "H", "HARRISON TWP",
      "I", "LOGAN TWP",
      "J", "MANTUA TWP",
      "K", "MONROE TWP ",
      "L", "NATIONAL PARK",
      "M", "NEWFIELD",
      "N", "PAULSBORO",
      "O", "PITMAN",
      "P", "SOUTH HARRISON TWP",
      "Q", "SWEDESBORO",
      "R", "WASHINGTON TWP",
      "S", "WENONAH",
      "T", "WEST DEPTFORD TWP",
      "U", "WESTVILLE BORO",
      "V", "WOODBURY CITY",
      "Y", "ROWAN",
      "04", "BUENA VISTA TWP",
      "05", "BUENA VISTA TWP",
      "CU", "CUMBERLAND COUNTY"
  });
}
