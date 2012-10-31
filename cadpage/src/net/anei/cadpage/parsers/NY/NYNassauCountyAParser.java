package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYNassauCountyAParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "NY";
  private static final String DEF_CITY = "NASSAU COUNTY";
  
  private static final String[] KEYWORDS = new String[]{"LOC", "c/s", "ADTNL", "GRID", "TOA"};

  public NYNassauCountyAParser() {
    super(DEF_CITY, DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt1 = body.indexOf("***");
    if (pt1 < 0) return false;
    pt1 += 3;
    int pt2 = body.indexOf("*** ", pt1);
    if (pt2 < 0) return false;
    data.strCall = body.substring(pt1, pt2).trim();
    
    body = "LOC:" + body.substring(pt2+4).trim();
    Properties props = parseMessage(body, KEYWORDS);
    
    // The c/s: keyword is required to distinguish this text format from
    // the Nassau County version D
    String sCross = props.getProperty("c/s");
    if (sCross == null) return false;
    data.strCross = sCross;

    
    String sAddr = props.getProperty("LOC", "");
    Parser p = new Parser(sAddr);
    data.strCall = data.strCall + " - " + p.get(' ');
    sAddr = p.get('[');
    data.strCity = p.get(']');
    if (data.strCity.length() == 0) return false;
    parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, sAddr, data);
    
    data.strSupp = props.getProperty("ADTNL", "");
    data.strMap = props.getProperty("GRID", "");

    return true;
  }
}


