package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/***
Ulster County, NY
Contact: Andrew Buboltz <ajb5620@gmail.com>
Sender: cad@co.ulster.ny.us

((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl
((63937) MDAV/ ) Unit:ENG6 UnitSts: Loc:86 HOFFMAN XSts:BROADWAY/MARYS  AV Venue:King City Inc:Struct Fir Date:11/03/2010 Time:21:22 SMOKE CODITION IN  AREA Addtl
((59728) SQUI/ )  Unit:ENG6 UnitSts: Loc:77 CORNELL XSts:TREMPER AV/SMITH AV Venue:King  City Inc:Haz Mat Date:11/02/2010 Time:00:45 UNKNOWN ODOR IN BUILDING  Addt
((2203) BKIN/ ) Unit:ENG6 UnitSts: Loc:89 NEWKIRK AV XSts:HASBROUCK AV/MAPLE  Venue:King City Inc:Struct Fir Date:11/05/2010 Time:21:39 BASEMENT FULL OF SMOKE ***/

public class NYUlsterCountyParser extends SmsMsgParser {

  private static final String[]Kingstonkeywords = new String[]{"Unit","UnitSts","Loc", "XSts", "Venue", "Inc","Date", "Time"};
  
  public NYUlsterCountyParser() {
    super("ULSTER COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.ulster.ny.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    if (!isPageMsg(body, Kingstonkeywords)) return false;

    Properties props = parseMessage(body, Kingstonkeywords);
    data.strCity = props.getProperty("Venue", "").replaceAll(" +", " ");
    if (data.strCity.toUpperCase().startsWith("KING CITY")) { data.strCity="KINGSTON";} 
    data.strCall = props.getProperty("Inc", "");
    parseAddress(props.getProperty("Loc", ""), data);
    data.strCross = props.getProperty("XSts", "");
    data.strUnit = props.getProperty("Unit", "");
    String sSupp = props.getProperty("Time","");
    int ipt = sSupp.indexOf(' ');
    if (ipt >= 0) data.strSupp = sSupp.substring(ipt+1).trim();
    return true;
    
  }
}




