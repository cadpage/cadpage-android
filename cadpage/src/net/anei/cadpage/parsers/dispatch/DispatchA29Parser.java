package net.anei.cadpage.parsers.dispatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class DispatchA29Parser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^DISPATCH:([A-Z]{2,4}:[A-Z\\d]+(?: FD| \\d)?) - (?:(\\d\\d?/\\d\\d?) (\\d\\d?:\\d\\d?) - )?");
  private static final Pattern UNIT_INFO_PTN = Pattern.compile("[ /]+([A-Z\\d]+:[-A-Z\\d]+(?: FD| \\d)?(?:,[A-Z\\d]+:[-A-Z\\d]+(?: FD)?)*)\\b[ /]*");
  private static final Pattern HOUSE_NUMBER_PTN = Pattern.compile("(.*?)(?<!\\b(?:RT|US|HWY))[ /](\\d+) *([NSEW]|BLK|BLOCK|), +(.*)");
  private static final Pattern MULT_SLASH_PTN = Pattern.compile("//+");
  private static final Pattern DIR_OF_PTN = Pattern.compile("[/ ]+((?:N|S|E|W|NO|SO|EA|WE|NORTH|SOUTH|EAST|WEST) OF)[/ ]+");
  private static final Pattern CALL_ADDR_DELIM = Pattern.compile("/(?! *(?:AMBULANCE|MEDICAL|MISDIAL|RESCUE))");

  public DispatchA29Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    setFieldList("UNIT DATE TIME CALL ADDR APT CITY PLACE PHONE INFO");
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strUnit = match.group(1);
    data.strDate = getOptGroup(match.group(2));
    data.strTime = getOptGroup(match.group(3));
    body = body.substring(match.end()).trim();
    
    body = body.replace("Apt/Unit", "Apt");
    
    // Look for unit field.  If found is separates sup info from rest of call
    match = UNIT_INFO_PTN.matcher(body);
    if (match.find()) {
      addUnit(match.group(1), data);
      data.strSupp = body.substring(match.end());
      body = body.substring(0,match.start());
    }
    
    // Reduce multiple slashes to single slash
    body = MULT_SLASH_PTN.matcher(body).replaceAll("/");
    
    // Now things get complicated.
    // See if we can find an odd street number convention that marks the end of the
    // call description
    StartType st = StartType.START_CALL;
    int flags = FLAG_START_FLD_REQ;
    match = HOUSE_NUMBER_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = match.group(1).trim();
      body = append(match.group(2), " ", match.group(3));
      body = append(body, " ", match.group(4));
      st = StartType.START_ADDR;
      flags = 0;
    }
    
    // There is always a comma followed by a (possibly empty) city and optional place name
    // Very occasionally, the comma is part of the place name field, so we also check for
    // a city name following the second comma.
    int pt = body.lastIndexOf(',');
    if (pt < 0) return false;
    String city = body.substring(pt+1).trim();
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, city);
    if (!res.isValid()) {
      int pt2 = body.lastIndexOf(',', pt-1);
      if (pt2 >= 0) {
        city = body.substring(pt2+1);
        Result res2 = parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, city);
        if (res2.isValid()) {
          pt = pt2;
          res = res2;
        }
      }
    }
    res.getData(data);
    addPlace(res.getLeft(), data);
    body = body.substring(0,pt).trim();
    
    // OK, see what we can do with the address
    flags |= FLAG_ANCHOR_END;
    if (data.strCity.length() > 0) flags |= FLAG_NO_CITY;
    
    
   // Dispatch doesn't (or didn't) use the normal & or / intersection convention, the
   // use long NORTH OF type constucts.  To get these through the
   // smart address parser, we need to replace them all with &
   // then change them back on the other side.  To keep things
   // simple, we assume no more than one such construct per address
   String connector = null;
  match = DIR_OF_PTN.matcher(body);
   if (match.find()) {
     connector = match.group(1);
     body = body.substring(0,match.start()) + " & " + body.substring(match.end());
   }
   parseAddress(st, flags, body, data);
   if (connector != null) data.strAddress = data.strAddress.replaceFirst("&", connector);
   
   // Sometimes there is a slash delimiter marking the end of the call description.  It is not
   // always there, and we couldn't check for it earlier lest we confuse an intersection address
   // for the delimiter.  But now that we have done the best we could with the address, see if
   // we can find that delimmiter in the call description, and if we can, move everything behind
   // it into the address
   match = CALL_ADDR_DELIM.matcher(data.strCall);
   if (match.find()) {
     pt = match.start();
     String addr = append(data.strCall.substring(pt+1), " ", data.strAddress);
     data.strCall = data.strCall.substring(0,pt).trim();
     data.strAddress = "";
     parseAddress(addr, data);
   }
   return true;
 }
  
  private void addUnit(String field, Data data) {
    Set<String> unitSet = new HashSet<String>();
    if (data.strUnit.length() > 0) unitSet.addAll(Arrays.asList(data.strUnit.split(",")));
    for (String unit : field.split(",")) {
      if (!unitSet.contains(unit)) {
        unitSet.add(unit);
        data.strUnit = append(data.strUnit, ",", unit);
      }
    }
  }

  private void addPlace(String field, Data data) {
    Matcher match = CALLBK_PTN.matcher(field);
    if (match.find()) {
      data.strPhone = match.group(1);
      field = append(field.substring(0,match.start()).trim(), " ", field.substring(match.end()).trim());
    }
    data.strPlace = field;
  }
  private static final Pattern CALLBK_PTN = Pattern.compile("\\bCALLBK=([-\\d]*)");
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = EXWY_PTN.matcher(addr).replaceAll("").trim();
    addr = DIR_OF_PTN.matcher(addr).replaceAll(" & ");
    return addr;
  }
  private static final Pattern EXWY_PTN = Pattern.compile("\\bEXWY\\b");
}
