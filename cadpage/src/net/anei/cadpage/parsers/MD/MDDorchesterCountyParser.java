package net.anei.cadpage.parsers.MD;

import java.util.Properties;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MDDorchesterCountyParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "MD";
  private static final String DEF_CITY = "DORCHESTER COUNTY";
  
  private static final String[] KEYWORDS = new String[]{"CT", "BOX", "DUE"};
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
        "CAMB", "CAMBRIDGE"
    });

  public MDDorchesterCountyParser(){
    super(CITY_CODE_TABLE, DEF_CITY, DEF_STATE);
  }
  
  public String getFilter() {
    return "dor911@docogonet.com";
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int ipt = body.indexOf("DOR911:CT:");
    if (ipt < 0) return false;
    body = body.substring(ipt+7).replaceAll(" :DC", "");;
    
    // If there is a : right after city then there is Supp data between City Code and ESZ:
    
    Properties props = parseMessage(body, KEYWORDS);
    String strAddr = props.getProperty("CT");
    parseAddress(StartType.START_CALL, FLAG_AT_BOTH, strAddr, data);
    data.strCity = convertCodes(data.strCity, CITY_CODE_TABLE);
    data.strBox = props.getProperty("BOX", "");
    data.strUnit = props.getProperty("DUE", "");
    return true;
  }
}