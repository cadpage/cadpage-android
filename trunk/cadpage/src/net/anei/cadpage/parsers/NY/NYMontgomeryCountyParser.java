package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Montgomery County, NY
Contact: Justin Cramer <cramerjd@gmail.com>
Sender: messaging@iamresponding.com

Subject:HVFD 218\n EMS - EMS CALL  14 PINE ST AMSTERDAM CITY  09/24/2011 1223\n\n\n
Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT   STATE HWY 30 T AMSTERDAM AMSTERDAM COMMONS 09/25/2011 0851\n\n\n
Subject:HVFD 218\nEMS - EMS CALL  300 HAMMOND TOWN RD AMSTERDAM  09/25/2011 1015\n\n\n
Subject:HVFD 218\nEMS - EMS CALL  106 HANNAFORD PLZ AMSTERDAM  09/25/2011 1945\n\n\n
Subject:HVFD 218\nEMS - EMS CALL  5005 STATE HWY 30 AMSTERDAM  09/25/2011 2250\n\n\n
Subject:HVFD 218\nEMS - EMS CALL  10 MAIN ST HAGAMAN VILLAGE  09/26/2011 0759\n\n\n
Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT WALMART 101 SANFORD FARM SHOP CT AMSTERDAM  09/26/2011 1011\n\n\n
Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT RECOVERY SPORTS GRILL 5005 STHWY 30 AMSTERDAM  09/26/2011 1331\n\n\n
Subject:HVFD 218\nMOTOR VEHICLE ACCIDENT   STATE HWY 30 T AMSTERDAM AMSTERDAM COMMONS 09/25/2011 0851

Contact: Kenneth LaBelle <klabelle65@gmail.com>
Sender: paging@impact-sys.com
FIRE - SMOKE CALL  1788 BURTONVILLE RD CHARLESTON  01/13/2012 0533

Contact: Paul Krug <paulkrug7@gmail.com>
Sender: paging@impact-sys.com
EMS - EMS CALL  5 CEMETERY V FONDA  05/06/2012 2155
EMS - EMS CALL  22 RAILROAD ST V FONDA  05/03/2012 1747
FIRE - SERVICE NBT BANK FONDA 34 W MAIN ST FONDA  04/30/2012 0650
EMS - EMS CALL CUMBERLAND FARMS 2 W MAIN ST FONDA  04/30/2012 0532
FIRE - STRUCTURE  56 E MAIN ST V FONDA  04/20/2012 0145
FIRE - CO CALL  21 BROADWAY V FONDA  04/18/2012 0817

*/


public class NYMontgomeryCountyParser extends SmartAddressParser {
  
  private static final Pattern SUBJ_PTN = Pattern.compile("[A-Z]{4} *\\d*");
  private static final Pattern TAIL_PTN = Pattern.compile(" (\\d\\d/\\d\\d/\\d{4}) (\\d+)$");
  
  public NYMontgomeryCountyParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "paging@impact-sys.com,messaging@iamresponding.com,impact@impact.co.Montgomery.NY.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (SUBJ_PTN.matcher(subject).matches()) data.strSource = subject;
    Matcher match = TAIL_PTN.matcher(body);
    if (!match.find()) return false;
    data.strDate = match.group(1);
    String time = match.group(2);
    data.strTime = time.substring(0,2) + ':' + time.substring(2,4);
    body = body.substring(0,match.start()).trim();
    
    StartType st = StartType.START_CALL;
    int pt = body.indexOf("  ");
    if (pt >= 0) {
      data.strCall = body.substring(0,pt);
      body = body.substring(pt+2).trim();
    }
    else {
      for (String call : CALL_LIST) {
        if (body.startsWith(call)) {
          data.strCall = call;
          body = body.substring(call.length()).trim();
          st = StartType.START_PLACE;
        }
      }
    }
    
    parseAddress(st, body, data);
    data.strPlace = append(data.strPlace, " - ", getLeft());
    
    data.strAddress = data.strAddress.replace("SHOP CT", "SHOPPING CTR");
    
    if (data.strCity.startsWith("V ") || data.strCity.startsWith("T ")) {
      data.strCity = data.strCity.substring(2).trim();
    }
    return true;
  }
  
  private static final String[] CALL_LIST = new String[] {
    "EMS - EMS CALL",
    "FIRE - CO CALL",
    "FIRE - SERVICE",
    "FIRE - STRUCTURE",
    "MOTOR VEHICLE ACCIDENT"
  };
  
  static final String[] CITY_LIST = new String[] {
    "AMES",
    "AMES VILLAGE",
    "V AMES",
    "AMSTERDAM",
    "AMSTERDAM CITY",
    "C AMSTERDAM",
    "T AMSTERDAM",
    "CANAJOHARIE",
    "CANAJOHARIE VILLAGE",
    "V CANAJOHARIE",
    "CHARLESTON",
    "FLORIDA",
    "FONDA",
    "FONDA VILLAGE",
    "V FONDA",
    "FORT JOHNSON",
    "FORT JOHNSON VILLAGE",
    "V FORT JOHNSON",
    "FORT PLAIN",
    "FORT PLAIN VILLAGE",
    "V FORT PLAIN",
    "FULTONVILLE",
    "FULTONVILLE VILLAGE",
    "V FULTONVILLE",
    "GLEN",
    "HAGAMAN",
    "HAGAMAN VILLAGE",
    "V HAGAMAN",
    "MINDEN",
    "MOHAWK",
    "NELLISTON",
    "NELLISTON VILLAGE",
    "V NELLISTON",
    "PALATINE",
    "PALATINE BRIDGE",
    "PALATINE BRIDGE VILLAGE",
    "V PALATINE BRIDGE",
    "ROO",
    "ST JOHNSVILLE",
    "ST JOHNSVILLE VILLAGE",
    "V ST JOHSVILLE"
  };
}
	