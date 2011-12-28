package net.anei.cadpage.parsers.MD;

import java.util.Properties;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/***
Dorchester County, MD
Contact:ryan travers <traversboy@gmail.com>
Sender:dor911@docogonet.com
DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC
DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC
DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC
DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC
DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC
***/

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