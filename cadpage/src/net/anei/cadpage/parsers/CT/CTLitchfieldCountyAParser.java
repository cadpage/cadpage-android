package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class CTLitchfieldCountyAParser extends SmartAddressParser {
  
  private static final Pattern MASTER1 = Pattern.compile("(.*) RESPOND TO (.*?)(?:,|,? (\\d{1,3}-[A-Z]-\\d{1,2}(?:-?[A-Z])?|HOT|ALPHA|COLD|\\d+|)) *(?::|--| -)(\\d\\d:\\d\\d)(?:(?: ([A-Z]\\d{2}-\\d+)|\\*\\*), *((?:[-+]?\\d+\\.\\d{4,}|0), *(?:[-+]?\\d+\\.\\d{4,}|0))| *\\(.*\\))?");
  private static final Pattern MASTER2 = Pattern.compile("(.+?)-(.+)-(.*?) *\\*\\*\\* (\\d\\d:\\d\\d)---");
  private static final Pattern MAU_HILL = Pattern.compile("^(.*) MAUWEEHOO H(?:IL)?L (.*)$");
  private static final Pattern START_PAREN_PTN = Pattern.compile("^\\(.*?\\)");
  
  public CTLitchfieldCountyAParser() {
    super(CTLitchfieldCountyParser.CITY_LIST, "LITCHFIELD COUNTY", "CT");
    addExtendedDirections();
    setupMultiWordStreets(
        "LIME ROCK",
        "SAW MILL HILL");
  }
  
  @Override
  public String getFilter() {
    return "@lcd911.com,89361";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("LCD") && !subject.equalsIgnoreCase("LCD Message")) return false;
    
    body = body.replace('\n', ' ');
    Matcher match = MASTER1.matcher(body);
    if (match.matches()) {
      setFieldList("SRC ADDR X PLACE APT CITY CALL CODE TIME ID GPS");
      data.strSource = match.group(1).trim();
      String sAddr = match.group(2).trim();
      data.strCode = getOptGroup(match.group(3));
      data.strTime = match.group(4);
      data.strCallId = getOptGroup(match.group(5));
      String gps = match.group(6);
      if (gps != null) setGPSLoc(gps, data);
      
      Parser p = new Parser(sAddr);
      data.strCall = p.getLast(',');
      data.strPlace = p.getLast(',');
      sAddr = p.get();
      if (sAddr.length() == 0) return false;
      parseAddressField(sAddr, data);
      return true;
    }
    
    match = MASTER2.matcher(body);
    if (match.matches()) {
      setFieldList("CALL ADDR X PLACE APT CITY PLACE TIME");
      
      data.strCall = match.group(1).trim();
      parseAddressField(match.group(2).trim(), data);
      data.strPlace = append(data.strPlace, " - ", match.group(3).trim());
      data.strTime = match.group(4);
      
      return true;
    }
    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    return true;
  }

  private void parseAddressField(String sAddr, Data data) {
    Matcher match;
    parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD | FLAG_ANCHOR_END, sAddr, data);
    if (data.strCity.equals("HEMLOCK ROXBURY")) data.strCity = "ROXBURY";
    String sPlace = getPadField();
    
    
    // There is a street called MAUWEEHOO HILL (or HL) that just confuses
    // the heck out of the smart parser so we will make some special checks for it
    if (data.strPlace.length() == 0) {
      match = MAU_HILL.matcher(data.strAddress);
      if (match.find()) {
        data.strAddress = match.group(1) + " MAUWEEHOO HILL";
        sPlace = match.group(2);
      }
    }
    
    // OK, there can be some strange things in the pad field
    // A leading term in parens is an alternative street name that should be appended to the
    // address.  It will be removed from the map address
    match = START_PAREN_PTN.matcher(sPlace);
    if (match.find()) {
      data.strAddress = append(data.strAddress, " ", match.group());
      sPlace = sPlace.substring(match.end()).trim();
    }
    
    // What's left is an optional place name followed by an optional cross
    // street, which may have an alternate street name in parens
    // So first remove the tentative alternate street name
    String chkCross = sPlace;
    String extra = null;
    if (chkCross.endsWith(")")) {
      int pt = chkCross.indexOf('(');
      if (pt >= 0) {
        extra = chkCross.substring(pt);
        chkCross = chkCross.substring(0,pt).trim();
      }
    }
    
    // Now use the smart addresss parser to separate the place name from the cross street
    String savePlace = data.strPlace;
    data.strPlace = "";
    parseAddress(StartType.START_PLACE, FLAG_ONLY_CROSS | FLAG_ANCHOR_END, chkCross, data);
    
    if (data.strPlace.endsWith("&")) data.strPlace = data.strPlace.substring(0,data.strPlace.length()-1).trim();
    
    // Append the extra paren info the the cross street if we found one
    // or to the place name if we did not
    if (extra != null) {
      if (data.strCross.length() > 0) {
        data.strCross = append(data.strCross, " ", extra);
      } else {
        data.strPlace = append(data.strPlace, " ", extra);
      }
    }
    
    // If we had a place name before going into this logic, the field we
    //  just parsed as a place should really be an apartment
    if (savePlace.length() > 0) {
      data.strApt = data.strPlace;
      data.strPlace = savePlace;
    }
  }
}
