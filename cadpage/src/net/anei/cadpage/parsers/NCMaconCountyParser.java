package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;
/*
Contact: Ryan Hursey <ryanhursey@gmail.com>
Sender: 8283420118
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1650 WIDE HORIZON DR FRANKLIN AAAAA, AAAAA 5555559999 Map: Grids:0,0
911 CENTER:90F >FIRE ALARM 120 RIVERVIEW ST FRANKLIN ANGEL MEDICAL CENTER 5555558411 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 289 SUTTON LN FRANKLIN AAAAA, AAAAAAA& AAAAAA 5555559999 Map: Grids:0,0
911 CENTER:MED >EMERGENCY RUN 248 HARRISON AVE XS: W MAIN ST TO BRYSON CITY RD FRANKLIN AAAAAA, CHARMAYNE 5555559999 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 11 CHATTACHOEE LN FRANKLIN VERIZON WIRELESS 5555559999
911 CENTER:C1 >EMERGENCY RUN 236 PAULINE AVE XS: ULCO DR FRANKLIN AAAAA, AAAAAAA P 5555559999 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1682 LEATHERMAN GAP RD FRANKLIN  AAA, ANGIE 5555559999 Map: Grids:0,0
911 CENTER:50 >VEHICLE ACCIDENT 837 GEORGIA RD FRANKLIN AAAAA 5555558237 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 730 LAKESHORE DR FRANKLIN CHRISTIAN, JOHN SMITH 8285249999 Map: Grids:0,0
Sender: 8283711473
911 CENTER:50 >VEHICLE ACCIDENT 428 COWEETA CHURCH RD OTTO SMITH, J 828369999 Map: Grids:0,0
*/

public class NCMaconCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_CODES = new String[]{"FRANKLIN"};
  
  public NCMaconCountyParser() {
    super(CITY_CODES);
  }

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("911 CENTER:");
  }

  @Override
  protected void parse(String body, Data data) {
    data.defState = "NC";
    data.defCity = "MACON COUNTY";
    
    body= body.replace(">","Call:");
    Properties props = parseMessage(body, new String[]{"CENTER", "Call", "Map", "Grids"});
    
    String line = props.getProperty("Call", "");
    parseAddress(StartType.START_CALL, line, data);
    
    // some cleanup stuff
    if (data.strCall.endsWith(" REPORTED AT")) {
      data.strCall = data.strCall.substring(0, data.strCall.length()-12);
    }
  }
}
