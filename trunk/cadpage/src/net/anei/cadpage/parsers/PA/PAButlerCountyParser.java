package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;



public class PAButlerCountyParser extends DispatchBParser {
  
  private static final Pattern MARKER = Pattern.compile(" Cad: \\d{4}-\\d{10}$");

  public PAButlerCountyParser() {
    super(CITY_LIST, "BUTLER COUNTY", "PA");
    setFieldList("CALL ADDR CITY X PLACE NAME PHONE MAP ID");
  }
  
  @Override
  public String getFilter() {
    return "@butlerco.911,@co.butler.pa.us";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return MARKER.matcher(body).find();
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (! super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BORO")) data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    if (data.strCity.equals("CONNOQ TWP")) data.strCity = "CONNOQUENESSING TWP";
    if (data.strMap.equals("00000,000")) data.strMap = "";
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BUTLER",
    
    "BRUIN BORO",
    "CALLERY BORO",
    "CHERRY VALLEY BORO",
    "CHICORA BORO",
    "CONNOQUENESSING BORO",
    "EAST BUTLER BORO",
    "EAU CLAIRE BORO",
    "EVANS CITY BORO",
    "FAIRVIEW BORO",
    "HARMONY BORO",
    "HARRISVILLE BORO",
    "KARNS CITY BORO",
    "MARS BORO",
    "PETROLIA BORO",
    "PORTERSVILLE BORO",
    "PROSPECT BORO",
    "SAXONBURG BORO",
    "SEVEN FIELDS BORO",
    "SLIPPERY ROCK BORO",
    "VALENCIA BORO",
    "WEST LIBERTY BORO",
    "WEST SUNBURY BORO",
    "ZELIENOPLE BORO",
    
    "ADAMS TWP",
    "ALLEGHENY TWP",
    "BRADY TWP",
    "BUFFALO TWP",
    "BUTLER TWP",
    "CENTER TWP",
    "CHERRY TWP",
    "CLAY TWP",
    "CLEARFIELD TWP",
    "CLINTON TWP",
    "CONCORD TWP",
    "CONNOQ TWP",
    "CONNOQUENESSING TWP",
    "CRANBERRY TWP",
    "DONEGAL TWP",
    "FAIRVIEW TWP",
    "FORWARD TWP",
    "FRANKLIN TWP",
    "JACKSON TWP",
    "JEFFERSON TWP",
    "LANCASTER TWP",
    "MARION TWP",
    "MERCER TWP",
    "MIDDLESEX TWP",
    "MUDDY CREEK TWP",
    "OAKLAND TWP",
    "PARKER TWP",
    "PENN TWP",
    "SLIPPERY ROCK TWP",
    "SUMMIT TWP",
    "VENANGO TWP",
    "WASHINGTON TWP",
    "WINFIELD TWP",
    "WORTH TWP",
    
    "BOYERS",
    "EIDENAU",
    "HILLIARDS",
    "MURRINSVILLE",
    "RENFREW",
    "SARVER",
    "WAHLVILLE",
    "WATTERS"
  };
}
