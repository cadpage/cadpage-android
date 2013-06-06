package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Roxbury, CT
 * Seymour, CT
 */
public class CTNorthwestPublicSafetyParser extends SmartAddressParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(?:ROX?|TANGO)\\b");
  private static final Pattern APT_EXT_PTN = Pattern.compile("UNIT|ROOM|RM|LOT|SUITE|FLR|1ST|2ND|3RD", Pattern.CASE_INSENSITIVE);

  public CTNorthwestPublicSafetyParser() {
    super(CITY_LIST, "", "CT");
    setFieldList("ADDR APT PLACE CITY CALL UNIT ID");
  }
  
  @Override
  public String getLocName() {
    return "Northwest Public Safety, CT";
  }

  @Override
  public String getFilter() {
    return "globalpaging@nowestps.org,no-reply@nowestps.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("From Northwest")) return false;
    body = body.replace('\n', ' ');
    Parser p = new Parser(body);
    String sAddr = p.get("Primary Incident:");
    data.strCallId = p.get(' ');
    if (data.strCallId.length() == 0) return false;
    String sAddr2 = p.get();
    
    
    parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD, sAddr, data);
    data.strPlace = getPadField();
    if (data.strApt.startsWith("(")) {
      int pt = data.strPlace.indexOf(')');
      if (pt >= 0) {
        data.strApt = data.strApt + ' ' + data.strPlace.substring(0,pt+1);
        data.strPlace = data.strPlace.substring(pt+1).trim();
      }
    } 
    else if (APT_EXT_PTN.matcher(data.strApt).matches()) {
      p = new Parser(data.strPlace);
      data.strApt = append(data.strApt, " ", p.get(' '));
      data.strPlace = p.get();
    }
    else if (data.strApt.equals("PARKING") && data.strPlace.startsWith("LOT")) {
      data.strApt = "PARKING LOT";
      data.strPlace = data.strPlace.substring(3).trim();
    }
    else if (data.strApt.length() == 0 && data.strPlace.startsWith("&")) {
      data.strAddress = data.strAddress + " " + data.strPlace;
      data.strPlace = "";
    }
    
    body = getLeft();
    Matcher match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = body.substring(match.start());
      body = body.substring(0,match.start()).trim();
    }
    data.strCall = body;
    
    // There is a Primary Incident address at the end of the call that
    // is usually the same as the initial address.  When it is different
    // it is the address that we should use, unless it is just a truncated
    // version of the initial address
    if (!sAddr.startsWith(sAddr2)) {
      data.strAddress = "";
      data.strApt = "";
      parseAddress(StartType.START_ADDR, sAddr2, data);
    }
    return true;
  }
  
  private static String[] CITY_LIST = new String[]{
    "ROXBURY",
    "SEYMOUR",
    "WASHINGTON"
  };
}
