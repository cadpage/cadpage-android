package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Missouri City, TX
 */
public class TXMissouriCityParser extends DispatchOSSIParser {
  public TXMissouriCityParser() {
    super(CITY_CODES, "MISSOURI CITY", "TX",
        "( CANCEL | FYI CALL ) ADDR! CITY? X? INFO+");
  }
  
  public String getFilter() {
    return "CAD@missouricitytx.gov";
  }
 
  @Override
  protected Field getField(String name) {
    if (name.equals("X")) return new CrossField("CROSS STREET\\s*(.*)", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static final Pattern MUTUAL_AID_PATTERN
    = Pattern.compile(".*(?i)MUTUAL +AID(?: +\\b([A-Z]+)\\b)?.*");
  private class MyInfoField extends InfoField {
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " / ", field);
      Matcher m = MUTUAL_AID_PATTERN.matcher(field);
      if (m.matches()) {
        if (!data.strCall.contains("MUTUAL AID")) {
          data.strCall = append (data.strCall, " - ", "MUTUAL AID");
        }
        String city = m.group(1);
        if (city != null && data.strCity.length() == 0) {
          data.strCity = convertCodes(city, CITY_CODES);
        }
      }
    }
    
    public String getFieldNames() {
      return append(super.getFieldNames(), " ", "CALL CITY");
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALVI",     "ALVIN",
      "ANGL",     "ANGLETON",
      "ARC",      "ARCOLA",
      "BRK",      "BROOKSIDE",
      "FBCO",     "FORT BEND",
      "FRES",     "FRESNO",
      "FUL",      "FULSHEAR",
      "HOU",      "HOUSTON",
      "HUM",      "HUMBLE",
      "IOWA",     "IOWA COLONY",
      "KATY",     "KATY",
      "MAN",      "MANVEL",
      "MISS",     "MISSOURI CITY",
      "NEED",     "NEEDVILLE",
      "PEA",      "PEARLAND",
      "PLK",      "PLEAK",
      "RICH",     "RICHMOND",
      "ROS",      "ROSENBERG",
      "RSH",      "ROSHARON",
      "STAF",     "STAFFORD",
      "STAFFORD", "STAFFORD",
      "SUG",      "SUGAR LAND",
      "TEXC",     "TEXAS CITY",
      "TOM",      "TOMBALL",
      "WHA",      "WHARTON",
  });
  
}
