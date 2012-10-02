package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Ulster County, NY
 */
public class NYUlsterCountyParser extends MsgParser {

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

    body = body.replace('\n', ' ');
    if (!isPageMsg(body, Kingstonkeywords)) return false;

    Properties props = parseMessage(body, Kingstonkeywords);
    data.strCity = props.getProperty("Venue", "").replaceAll(" +", " ");
    if (data.strCity.toUpperCase().startsWith("KING CITY")) { data.strCity="KINGSTON";} 
    data.strCall = props.getProperty("Inc", "");
    parseAddress(props.getProperty("Loc", ""), data);
    data.strCross = props.getProperty("XSts", "");
    data.strUnit = props.getProperty("Unit", "");
    data.strDate = props.getProperty("Date", "");
    String sSupp = props.getProperty("Time","");
    int ipt = sSupp.indexOf(' ');
    if (ipt >= 0) {
      data.strSupp = sSupp.substring(ipt+1).trim();
      sSupp = sSupp.substring(0,ipt).trim();
    }
    data.strTime = sSupp;
    return true;
    
  }
}




