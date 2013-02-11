package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class NYFultonCountyParser extends SmartAddressParser {

  private static final Pattern MASTER = Pattern.compile("([A-Z]+) +(.*?) +(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d)(\\d\\d)(?: +(?:([-+]?\\d+\\.\\d+ +[-+]?\\d+\\.\\d+)|-1 +-1))?");
    
    public NYFultonCountyParser() {
      super(CITY_LIST, "FULTON COUNTY", "NY");
      setFieldList("SRC CALL ADDR APT CITY PLACE DATE TIME GPS");
    }
    
    @Override
    public String getFilter() {
      return "impactpaging@co.fulton.ny.us";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    Matcher match = MASTER.matcher(body);
	    if (!match.matches()) return false;
	    data.strSource = match.group(1);
	    String addr = match.group(2);
	    data.strDate = match.group(3);
	    data.strTime = match.group(4) + ':' + match.group(5);
	    String gps = match.group(6);
	    if (gps != null) setGPSLoc(gps, data);
	    
	    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, addr, data);
	    if (data.strCity.length() >= 2 && data.strCity.charAt(1) == ' ') {
	      data.strCity = data.strCity.substring(2);
	    }
	    data.strPlace = getLeft();
	    
	    return true;
	  }
	  
	  @Override
	  public int getMapFlags() {
	    return MAP_FLG_PREFER_GPS;
	  }
	  
	  private static final String[] CITY_LIST = new String[]{
      "GLOVERSVILLE",
      "JOHNSTOWN",
      "BROADALBIN",
      "DOLGEVILLE",
      "MAYFIELD",
      "NORTHVILLE",
      "BLEECKER",
      "BROADALBIN",
      "CAROGA",
      "EPHRATAH",
      "JOHNSTOWN",
      "MAYFIELD",
      "NORTHAMPTON",
      "OPPENHEIM",
      "PERTH",
      "STRATFORD",

      "C GLOVERSVILLE",
      "C JOHNSTOWN",
      "V BROADALBIN",
      "V DOLGEVILLE",
      "V MAYFIELD",
      "V NORTHVILLE",
      "T BLEECKER",
      "T BROADALBIN",
      "T CAROGA",
      "T EPHRATAH",
      "T JOHNSTOWN",
      "T MAYFIELD",
      "T NORTHAMPTON",
      "T OPPENHEIM",
      "T PERTH",
      "T STRATFORD"
	  };
	}
	