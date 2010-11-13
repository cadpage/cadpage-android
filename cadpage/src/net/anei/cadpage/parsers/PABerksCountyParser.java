package net.anei.cadpage.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Berks County, PA
Contact: "thirty5tripleuno@yahoo.com" <thirty5tripleuno@yahoo.com>
CAD MSG: *D MVAUNK   E STATE ST / S KEMP ST 0082 2 VEH / COMP IS ANDREW BROOKS / INVOLVED // AT THE INTERSECTION B
CAD MSG: *D MVAWITH  102 BEAVER CREEK RD 0087 1 VEH / SPUN OUT / MALE OCC (COMP'S HUSBAND) BELIEVES HE FRACTURED H
CAD MSG: *D FTEST    STATION 35 @110 PARK AV 0082 BERKS TESING THE TEXT PAGING SYSTEM NO ACTION REQUIRED
CAD MSG: *D MVAUNK   NOBLE ST / BASTIAN RD 0079 ONE CAR, OCCUPIED, INTO A FIELD // ONLY LANDMARK SHE COULD MEN﻿﻿
CAD MSG: *D SF       28 NOBLE ST 0081 SEES FLAMES IN BASEMENT //ADVISED TO EVAC /
CAD MSG: *D MVAENT   FORGEDALE RD / DAVIDS DR 0087 2VEHS HEAD ON/2 VICTIMS ENTRAPPED /1 FEMALE SERIOUSLY INJ/BLEED﻿﻿
*/

public class PABerksCountyParser extends SmsMsgParser {
  
  private static final String DEF_STATE = "PA";
  private static final String DEF_CITY = "BERKS COUNTY";
  
  private static final Pattern DIGITS = Pattern.compile(" \\d{4} ");

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("CAD MSG: ");
  }

  @Override
  protected void parse(String body, Data data) {
    data.defState = DEF_STATE;
    data.defCity = DEF_CITY;
    
    // Extract primary call description
    if (body.length() < 20) return;
    data.strCall = body.substring(9, 20).trim();
    body = body.substring(20);
    
    // Look for a 4 digit station ID, this marks the end of the address
    Matcher match = DIGITS.matcher(body);
    if (! match.find()) return;
    
    // An '@' splits place name from address
    String address = body.substring(0, match.start()).trim();
    int pt = address.indexOf('@');
    if (pt >= 0) {
      data.strPlace = address.substring(0, pt).trim();
      address = address.substring(pt+1).trim();
    }
    data.strAddress = address.replace("/", "&");
    body = body.substring(match.end()).trim();
    
    // Anything beyond that is supplemental info
    data.strSupp = body.replaceAll("//+", "/");
  }
}
