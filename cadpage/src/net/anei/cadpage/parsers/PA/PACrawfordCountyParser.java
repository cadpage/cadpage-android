package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;


public class PACrawfordCountyParser extends DispatchB3Parser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("(?:CRAWFORD COUNTY +911 )?(?:CRAWFORD_COUNTY_911:|OESCAD:|OESCAD@WINDSTREAM.NET:)");

  public PACrawfordCountyParser() {
    super(PREFIX_PTN, CITY_LIST, "CRAWFORD COUNTY", "PA");
    removeWords("CIRCLE", "TRL");
  }
  
  @Override
  public String getFilter() {
    return "OESCAD@WINDSTREAM.NET,CRAWFORD_COUNTY_911@oescad.com";
  }
  
  @Override
  public String adjustMapAddress(String address) {
    return WASHINGTON_STREET_EXT.matcher(address).replaceAll("$1");
  }
  private static final Pattern WASHINGTON_STREET_EXT = Pattern.compile("\\b(WASHINGTON ST(?:REET)?) EXT?\\b");
  
  @Override
  protected int getExtraParseAddressFlags() {
    return FLAG_CROSS_FOLLOWS;
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    int pt = body.indexOf(" Reply STOP ");
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strCity.toUpperCase().endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    } else if (data.strCity.endsWith(" CO")) {
      data.strCity += "UNTY";
      if (data.strCity.equals("VNG COUNTY")) data.strCity = "VENANGO COUNTY";
    } else if (data.strCity.equals("LEBOUF TWP")) data.strCity = "LEBOEUF TWP";
    
    if (data.strCallId.length() == 0) data.expectMore = true;
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "MEADVILLE",
    "TITUSVILLE",
    
    "MEADVILLE CITY",
    "TITUSVILLE CITY",
    
    // Boroughs
    "BLOOMING VALLEY",
    "CAMBRIDGE SPRINGS",
    "CENTERVILLE",
    "CONNEAUT LAKE",
    "CONNEAUTVILLE",
    "COCHRANTON",
    "HYDETOWN",
    "LINESVILLE",
    "SAEGERTOWN",
    "SPARTANSBURG",
    "SPRINGBORO",
    "TOWNVILLE",
    "VENANGO",
    "WOODCOCK",

    "BLOOMING VALLEY BORO",
    "CAMBRIDGE SPRINGS BORO",
    "CENTERVILLE BORO",
    "CONNEAUT LAKE BORO",
    "CONNEAUTVILLE BORO",
    "COCHRANTON BORO",
    "HYDETOWN BORO",
    "LINESVILLE BORO",
    "SAEGERTOWN BORO",
    "SPARTANSBURG BORO",
    "SPRINGBORO BORO",
    "TOWNVILLE BORO",
    "VENANGO BORO",
    "WOODCOCK BORO",

    // Townships
    "ATHENS TWP",
    "BEAVER TWP",
    "BLOOMFIELD TWP",
    "CAMBRIDGE TWP",
    "CONNEAUT TWP",
    "CUSSEWAGO TWP",
    "EAST FAIRFIELD TWP",
    "EAST FALLOWFIELD TWP",
    "EAST MEAD TWP",
    "EAST MEAD TOWNSHIP",
    "FAIRFIELD TWP",
    "GREENWOOD TWP",
    "HAYFIELD TWP",
    "NORTH SHENANGO TWP",
    "OIL CREEK TWP",
    "PINE TWP",
    "RANDOLPH TWP",
    "RICHMOND TWP",
    "ROCKDALE TWP",
    "ROME TWP",
    "SADSBURY TWP",
    "SOUTH SHENANGO TWP",
    "SPARTA TWP",
    "SPRING TWP",
    "STEUBEN TWP",
    "SUMMERHILL TWP",
    "SUMMIT TWP",
    "TROY TWP",
    "UNION TWP",
    "VENANGO TWP",
    "VERNON TWP",
    "WAYNE TWP",
    "WEST FALLOWFIELD TWP",
    "WEST MEAD TWP",
    "WEST SHENANGO TWP",
    "WOODCOCK TWP",
    
    // Ashtabula County
    "ASHTABULA CO",
    
    // Erie County
    "ERIE CO",
    "ERIE COUNTY",
    "LEBOUF TWP",  // Misspelled
    "LEBOEUF TWP",
    "SUMMMIT TWP",
    "SUMMIT TOWNSHIP",
    
    // Mercer County
    "MERCER COUNTY",
    "MERCER CO",
    
    "FRENCH CREEK",
    "SANDY LAKE",
    
    "DEER CREEK TWP",
    "FRENCH CREEK TWP",
    
    // Venango County
    "VNG CO",
    "PLUM TWP"
  };
}
