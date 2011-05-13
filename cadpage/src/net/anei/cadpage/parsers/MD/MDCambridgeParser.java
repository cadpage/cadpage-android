package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/***
Cambridge, MD
Very Similar to Fredrick County, MD, May be same vendor
Contact:ryan travers <traversboy@gmail.com>
Sender:dor911@docogonet.com
DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC
DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC
DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC
DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC
DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC
***/

public class MDCambridgeParser extends SmartAddressParser {

  private static final String[]Cambridgekeywords = new String[]{"CT", "BOX", "DUE",};
  private static final Pattern MARKER = Pattern.compile("@\\d");
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
        "CAMB","Cambridge"
    });

  public MDCambridgeParser(){
    super(CITY_CODE_TABLE, "CAMBRIDGE", "MD");
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    
    if (!body.contains("DOR911") ) return false;
    
    // If there is a : right after city then there is Supp data between City Code and ESZ:
    body = body.substring(body.indexOf(":")+1);
    
    Properties props = parseMessage(body, Cambridgekeywords);
    String strAddr = props.getProperty("CT","");
    
    // Everything changes if this is a Mutual aid call
    int ipt = strAddr.indexOf(" @MA ");
    if (ipt >= 0) {
      data.strCall = "Mutual Aid: " + strAddr.substring(0, ipt).trim();
      int ipt2 = strAddr.indexOf(':', ipt);
      if (ipt2 < 0) ipt2 = strAddr.length();
      data.strCity = strAddr.substring(ipt+5, ipt2).trim();
      strAddr = strAddr.substring(ipt2+1).trim().replaceAll("@", "");
      parseAddress(strAddr, data);
    }

    else {
      Matcher match = MARKER.matcher(body);
      if (! match.find()) {
      Parser p = new Parser(strAddr);
      strAddr = p.get('@');
      data.strPlace = p.get();
      } 
      parseAddress(StartType.START_CALL, strAddr, data);
    }
    
    data.strBox = props.getProperty("BOX", "");
    data.strUnit = props.getProperty("DUE", "");
    int iptb = data.strPlace.length();
    if (iptb >1 ) {
      // This address has a place name so City is in place
      int idx = data.strPlace.lastIndexOf(" ");
      data.strCity= data.strPlace.substring(idx).trim();
      data.strPlace = data.strPlace.substring(0,idx).trim();
    } 
    data.strCity = convertCodes(data.strCity, CITY_CODE_TABLE);
    if (data.strUnit.contains(":DC") ) {
        data.strUnit = data.strUnit.substring(0,data.strUnit.indexOf(":")).trim();
      }
    return true;
  }
}