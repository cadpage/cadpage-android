package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class PACrawfordCountyParser extends DispatchBParser {
  private static final Pattern MARKER = Pattern.compile("^(?:CRAWFORD COUNTY +911 +)?OESCAD(?:@WINDSTREAM.NET)?:|CRAWFORD COUNTY +911(?: CRAWFORD_COUNTY_911)?:");

  public PACrawfordCountyParser() {
    super(CITY_LIST, "CRAWFORD COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "OESCAD@WINDSTREAM.NET";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    int pt = body.indexOf(" Reply STOP ");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    boolean good = subject.contains(">");
    Matcher match = MARKER.matcher(body);
    if (match.find()) {
      good = true;
      body = body.substring(match.end()).trim();
    }
    if (!good) return false;
    body = subject + " " + body;
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.toUpperCase().endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    }
    
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
    "WOODCOCK TWP"
  };
}
