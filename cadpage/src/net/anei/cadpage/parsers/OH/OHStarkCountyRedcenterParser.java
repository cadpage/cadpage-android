package net.anei.cadpage.parsers.OH;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;


public class OHStarkCountyRedcenterParser extends DispatchEmergitechParser {
  
  public OHStarkCountyRedcenterParser() {
    super("RED:", CITY_LIST, "STARK COUNTY", "OH");
  }
  
  @Override
  public int getMapFlags() {
    
    // Suppressing the LA -> LN translation fixes problems when LAWRENCE is split wrong
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  public String getFilter() {
    return "RED@sssnet.com,messaging@iamresponding.com,777,7127390583";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    // Fix some IAR message "improvements"
    body = body.replace(" \n-", " ");
    if (body.startsWith("-NATURE:")) body = "RED:[XXX]" + body;
    if (!super.parseMsg(body, data)) return false;
    if (data.strUnit.equals("XXX")) data.strUnit = "";
    if (data.strCity.startsWith("-")) data.strCity = "";
    
    // Fix streets that should have trailing direction
    data.strAddress = fixAddress(data.strAddress);
    data.strCross = fixAddress(data.strCross);
    return true;
  }
  
  private String fixAddress(String addr) {
    return REV_DIR_STREET_PTN.matcher(addr).replaceAll("$2 $1");
    
  }
  private static final Pattern REV_DIR_STREET_PTN = Pattern.compile("\\b([NSEW]) (MILAN ST)\\b");


  private static final String[] CITY_LIST = new String[]{
    // Cities
    "ALLIANCE",
    "CANAL FULTON",
    "CANTON",
    "LOUISVILLE",
    "MASSILLON",
    "NORTH CANTON",
    
    // Villages
    "BEACH CITY",
    "BREWSTER",
    "EAST CANTON",
    "EAST SPARTA",
    "HARTVILLE",
    "HILLS AND DALES",
    "LIMAVILLE",
    "MAGNOLIA",
    "MINERVA",
    "MEYERS LAKE",
    "NAVARRE",
    "WAYNESBURG",
    "WILMOT",
    
    // Townships
    "BETHLEHEM TWP",
    "CANTON TWP",
    "JACKSON TWP",
    "LAKE TWP",
    "LAWRENCE TWP",
    "LEXINGTON TWP",
    "MARLBORO TWP",
    "NIMISHILLEN TWP",
    "OSNABURG TWP",
    "PARIS TWP",
    "PERRY TWP",
    "PIKE TWP",
    "PLAIN TWP",
    "SANDY TWP",
    "SUGAR CREEK TWP",
    "TUSCARAWAS TWP",
    "WASHINGTON TWP",
    
    // Census-designated places
    "GREENTOWN",
    "PERRY HEIGHTS",
    "UNIONTOWN",
    
    // Other localities
    "AVONDALE",
    "CAIRO",
    "MARCHAND",
    "MAXIMO",
    "MIDDLEBRANCH",
    "NEW FRANKLIN",
    "NORTH INDUSTRY",
    "NORTH LAWRENCE",
    "PARIS",
    "RICHVILLE",
    "ROBERTSVILLE",
    "WACO",
    
    // Wierdness
    "-CITY",
    "-TWP"
  };
}
