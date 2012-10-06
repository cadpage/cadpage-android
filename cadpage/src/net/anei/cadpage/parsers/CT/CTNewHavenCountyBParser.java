package net.anei.cadpage.parsers.CT;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class CTNewHavenCountyBParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(\\d{10}) +");
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" +(\\d{6}) (\\d\\d:\\d\\d)$"); 
  private static final Pattern TRUNC_DATE_TIME_PTN = Pattern.compile(" +\\d{6} [\\d:]+$| +\\d{1,6}$"); 
  private static final Pattern MAP_PFX_PTN =Pattern.compile("^(?:Prem )?Map -");
  private static final Pattern MAP_PTN = Pattern.compile("^\\d{1,2}(?: ?[A-Z]{2} ?\\d{1,3})?\\b");
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+(?=\\d)");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
    "WLFD", "WALLINFORD"
  });
  
  public CTNewHavenCountyBParser() {
    this(CITY_CODES, "NORTH BRANFORD", "CT");
  }
  
  public CTNewHavenCountyBParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
  }
  
  @Override
  public String getFilter() {
    return "paging@mail.nbpolicect.org,paging@nbpolicect.org,paging@easthavenfire.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    
    match =  DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      String date = match.group(1);
      data.strDate = date.substring(2,4) + "/" + date.substring(4,6) + "/" + date.substring(0,2);
      data.strTime = match.group(2);
      body = body.substring(0,match.start());
    } else {
      match = TRUNC_DATE_TIME_PTN.matcher(body);
      if (match.find()) body = body.substring(0,match.start());
    }

    // Unit are at the end of the body separated by a double blank.
    // But we don't want to actually extract them here, we want to do it after
    // we have parsed out the address and city.  Except that parsing the address
    // and city removes the double blank we are looking for :(
    
    // So, we'll check for the double blank here and save the prospective unit
    // field.  Then, after the address has been parsed, if the extra string
    // still ends with this prospective unit, then we will strip it off
    String sUnit = null;
    int pt = body.lastIndexOf(") ");
    if (pt >= 0) {
      data.strUnit = body.substring(pt+2).trim();
      body = body.substring(0,pt+1);
    } else {
      if (pt < 0) pt = body.lastIndexOf("  ");
      if (pt >= 0) sUnit = body.substring(pt+2).trim();
    }
    
    String sExtra;
    pt = body.indexOf(',');
    if (pt >= 0) {
      sExtra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
      Parser p = new Parser(sExtra);
      data.strCity = p.get(' ');
      sExtra = p.get();
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END | FLAG_START_FLD_REQ, body, data);
    }
    
    else {
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, body, data);
      sExtra = getLeft();
    }
    match = MAP_PFX_PTN.matcher(sExtra);
    if (match.find()) {
      sExtra = sExtra.substring(match.end()).trim();
      match = MAP_PTN.matcher(sExtra);
      if (match.find()) {
        data.strMap = match.group();
        sExtra = sExtra.substring(match.end()).trim();
        pt = sExtra.indexOf('(');
        if (pt >= 0) sExtra = sExtra.substring(0,pt).trim();
      }
    }
    if (sUnit != null && sExtra.endsWith(sUnit)) {
      data.strUnit = sUnit;
      sExtra = sExtra.substring(0, sExtra.length() - sUnit.length()).trim();
    }
    
    // That usually does the trick, but if we didn't find a unit that way
    // just grab the last word
    if (data.strUnit.length() == 0) {
      pt = sExtra.lastIndexOf(' ');
      if (pt >= 0) {
        data.strUnit = sExtra.substring(pt+1).trim();
        sExtra = sExtra.substring(0,pt).trim();
      } else {
        data.strUnit = sExtra;
        sExtra = "";
      }
    }
    
    data.strCross = sExtra;
    
    match = LEAD_ZERO_PTN.matcher(data.strAddress);
    if (match.find()) {
      data.strAddress = data.strAddress.substring(match.end()).trim();
    }
    return true;
  }
}
