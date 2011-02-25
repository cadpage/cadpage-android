package net.anei.cadpage.parsers.NJ;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Gloucester County, NJ
Contact: Rich Danner <richdanner@comcast.net>
Sender: alert_@private.gloucesteralert.com

Sta:23-1\nType:MVC\nLoc:233 N MAIN ST\nVen:HARRISON\nDsp-07:56:31\nClr- 
Sta:23-1\nType:SEIZ\nLoc:143 SALVATORE DR\nVen:HARRISON\nDsp-15:26:16\nClr- 
Sta:23-1\nType:DWEL\nLoc:296 WESTBROOK DR\nVen:WOOLWICH\nDsp-08:16:44\nClr- 
Sta:23-1\nType:MVC\nLoc:203 N MAIN ST\nVen:HARRISON\nDsp-09:34:52\nClr- 
Sta:23-1\nType:MVC\nLoc:203 N MAIN ST\nVen:HARRISON\nDsp-09:34:52\nClr- 
Sta:23-1\nType:ALRM\nLoc:7 FERRELL RD APT A\nVen:S\nDsp-14:55:22\nClr- 
Sta:23-1\nType:BRSH\nLoc:54 VESTRY RD\nVen:S\nDsp-12:40:42\nClr- 
Sta:23-1\nType:FALL\nLoc:115 FRANKLIN DR\nVen:HARRISON\nDsp-16:01:31\nClr- 
Sta:23-1\nType:BRSH\nLoc:49 TURTLE CREEK DR\nVen:HARRISON\nDsp-\nClr- 
Sta:23-1\nType:MVC\nLoc:2227 RT 322\nVen:WOOLWICH\nDsp-11:25:11\nClr- 
Sta:23-1\nType:MVC\nLoc:TOMLIN STATION RD\nVen:HARRISON\nDsp-17:31:56\nClr- 
 */


public class NJGloucesterCountyParser extends SmsMsgParser {
  
  private static final String[] KEYWORDS = new String[]{"Sta:", "Type:", "Loc:", "Ven:"};
  
  private static final Properties VENUE_CODES = buildCodeTable(new String[]{
      "DEPTFORD", "DEPFORD TWP",
      "EAST GREENWICH", "E GREENWICH TWP",
      "ELK", "ELK TWP",
      "FRANKLIN", "FRANKLIN TWP",
      "HARRISON", "HARRISON TWP",
      "LOGAN", "LOGAN TWP",
      "MANTUA", "MANTUA TWP",
      "MONROE", "MONROE TWP",
      "S", "S HARRISON TWP",
      "WASHINGTON", "WASHINGTON TWP",
      "WEST DEPTFORD", "W DEPTFORD TWP",
      "WOOLWICH", "WOOLWICH TWP",
      "WOODBRYHGT", "WOODBURY HEIGHTS"
  });
  
  public NJGloucesterCountyParser() {
    super("GLOUCESTER COUNTY", "NJ");
  }
 
  @Override
  public String getFilter() {
    return "alert_@private.gloucesteralert.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!isPageMsg(body, KEYWORDS)) return false;
    
    Properties props = parseMessage(body, "\n");
    data.strSource = props.getProperty("Sta", "");
    data.strCall = props.getProperty("Type", "");
    data.strAddress = props.getProperty("Loc", "");
    data.strCity = convertCodes(props.getProperty("Ven", ""), VENUE_CODES);
    
    return true;
  }
}
