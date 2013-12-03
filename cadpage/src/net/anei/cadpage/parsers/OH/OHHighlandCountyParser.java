package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHHighlandCountyParser extends DispatchEmergitechParser {
  
  public OHHighlandCountyParser() {
    super(new String[]{"Networkadmin:", "Emergitech:", "Dispatch:"}, 
          73, CITY_LIST, "HIGHLAND COUNTY", "OH");
    addSpecialWords("ORCHARD", "SAUNER");
  }
  
  @Override
  public String getFilter() {
    return "networkadmin@highlandcoso.com,Emergitech@highlandcoso.com,Dispatch@highlandcoso.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    Matcher match = INFO_GPS_PTN.matcher(data.strSupp);
    if (match.find()) {
      setGPSLoc(match.group(1), data);
      data.strSupp = data.strSupp.substring(match.end());
    }
    return true;
  }
  private static final Pattern INFO_GPS_PTN = Pattern.compile("^(\\+\\d{3}\\.\\d{6} -\\d{3}\\.\\d{6})\\b *(?:CF?= *[ \\d]+% *)?");
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("INFO", "GPS INFO");
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Mutual aid counties
    "FAYETTE COUNTY",

    // Cites
    "HILLSBORO",
    
    // Villages
    "GREENFIELD",
    "HIGHLAND",
    "LEESBURG",
    "LYNCHBURG",
    "MOWRYSTOWN",
    "SINKING SPRING",
    
    // Townships
    "BRUSHCREEK TWP",
    "CLAY TWP",
    "CONCORD TWP",
    "DODSON TWP",
    "FAIRFIELD TWP",
    "HAMER TWP",
    "JACKSON TWP",
    "LIBERTY TWP",
    "MADISON TWP",
    "MARSHALL TWP",
    "NEW MARKET TWP",
    "PAINT TWP",
    "PENN TWP",
    "SALEM TWP",
    "UNION TWP",
    "WASHINGTON TWP",
    "WHITEOAK TWP",
    
    // Unincorporated communities
    "ALLENSBURG",
    "BELFAST",
    "BERRYSVILLE",
    "BOSTON",
    "BRIDGES",
    "BUFORD",
    "CAREYTOWN",
    "CARMEL",
    "CENTERFIELD",
    "DANVILLE",
    "DODSONVILLE",
    "EAST DANVILLE",
    "EAST MONROE",
    "ELMVILLE",
    "FAIRFAX",
    "FAIRVIEW",
    "FOLSOM",
    "GIST SETTLEMENT",
    "HARIETT",
    "HARWOOD",
    "HOAGLAND",
    "HOLLOWTOWN",
    "MARSHALL",
    "NEW MARKET",
    "NEW PETERSBURG",
    "PRICETOWN",
    "RAINSBORO",
    "RUSSELL",
    "SAMANTHA",
    "SHACKLETON",
    "STRINGTOWN",
    "SUGAR TREE RIDGE",
    "TAYLORSVILLE",
    "WILLETTSVILLE"
  };
}
