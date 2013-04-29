package net.anei.cadpage.parsers.SC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class SCYorkCountyParser extends MsgParser {
  
  private static final String[] KEYWORDS = new String[]{"UNIT", "P", "LOC", "X", "NAR", "INC#"}; 

  public SCYorkCountyParser() {
    super("YORK COUNTY", "SC");
    setFieldList("UNIT ADDR X CITY PLACE CALL INFO ID");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Properties props = parseMessage("UNIT: " + body, KEYWORDS);
    if (props.getProperty("P") == null) return false;
    
    data.strUnit = props.getProperty("UNIT", "");
    String sAddr = props.getProperty("LOC");
    if (sAddr == null) return false;
    parseAddress(sAddr, data);
    
    body = props.getProperty("X");
    if (body == null) return false;
    
    Parser p = new Parser(body);
    data.strCross = p.get('*');
    data.strPlace = p.get('*');
    data.strCity = p.get('*');
    data.strPlace = append(data.strPlace, " - ", p.get('*'));
    data.strCall = p.get('*') + " - " + p.get('*');
    
    data.strSupp = props.getProperty("NAR", "");
    data.strCallId = props.getProperty("INC#", "");

    if (data.strPlace.length() > 0) {
      String tmp = new Parser(data.strPlace).get(' ');
      int ipt = data.strCity.indexOf(" " + tmp);
      if (ipt >= 0) data.strCity = data.strCity.substring(0,ipt).trim();
    }

    return true;
  }
}
