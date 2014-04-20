package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class DispatchA13Parser extends FieldProgramParser {
  
  private static final String PROGRAM = "SRCID? DISPATCHED CALL! ADDR X:GPS1 Y:GPS2";
  
  private Properties cityCodes = null;
  private boolean checkCity;
  
  public DispatchA13Parser(String defCity, String defState) {
    super(defCity, defState, PROGRAM);
    checkCity = false;
  }
  
  public DispatchA13Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, PROGRAM);
    this.cityCodes = cityCodes;
    this.checkCity = (cityCodes != null);
  }
  
  public DispatchA13Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, PROGRAM);
    this.checkCity = (cityList != null);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRCID")) return  new SourceIdField();
    if (name.equals("DISPATCHED")) return new SkipField("Dispatched|Acknowledge|Enroute|En Route Hosp|Responding|Req_?Dispatch|On *Scene|Standing ?By|Terminated", true);
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("GPS1")) return new MyGPSField(1);
    if (name.equals("GPS2")) return new MyGPSField(2);
    return super.getField(name);
  }
  
  // SRCID field contains source and call ID
  private static final Pattern SRCID_PTN = Pattern.compile(".*?([A-Z0-9][ A-Z0-9]+)?:(\\d+(?::\\d+)?)");
  private class SourceIdField extends Field {
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = SRCID_PTN.matcher(field);
      if (!match.matches()) return false;
      String src = match.group(1);
      if (src != null) data.strSource = src;
      data.strCallId = match.group(2);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "SRC ID";
    }
  }
  
  // Address field contains address, city, and possibly cross streets
  private static final Pattern MISMATCH_PAREN_PTN = Pattern.compile("(\\([^\\)]*)(?=\\()");
  private static final Pattern NUMBER_COMMA_PTN = Pattern.compile("([-\\d]+), *(.*)");
  private static final Pattern STATE_PTN = Pattern.compile("[A-Z]{2}");
  private static final Pattern APT_PREFIX_PTN = Pattern.compile("^(?:APT|RM|ROOM) *");
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|RM|ROOM) *(.*)|BLDG?.*|.* FLR|.* FLOOR");
  private static final Pattern BREAK_PTN = Pattern.compile(" *(?:[,;]) *");
  private class BaseAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      field = field.replace("\\\\", "&").replace('\\', '&');
      
      // Missed right parens cause a problem.  If we find any add a closing right paren.
      field = MISMATCH_PAREN_PTN.matcher(field).replaceAll("$1)");
      
      // And some agencies have a comma following the initial street number
      Matcher match = NUMBER_COMMA_PTN.matcher(field);
      if (match.matches()) field = match.group(1) + ' ' + match.group(2);
      
      // Break address field into stuff before, inside, and after two sets of parenthesis
      Parser p = new Parser(field);
      String sPart1 = p.get('(');
      String sPart2 = p.get(')');

      String sPart3 = p.get('(');
      String sPart4 = p.get(')');
      String sPart5 = p.get();
     
      // If first part starts with @, it contains a place name
      // and the second part is the address
      // Following parts contain cross streets, city names, or plain info
      if (sPart1.startsWith("@")) {
        sPart1 = stripApt(sPart1.substring(1).trim(), data);
        int pt = sPart1.lastIndexOf(',');
        if (pt >= 0) {
          String place = sPart1.substring(0,pt).trim();
          String addr = sPart1.substring(pt+1).trim();
          if (checkAddress(addr) > 0) {
            data.strPlace = place;
            parseAddress(addr, data);
          } else {
            pt = -1;
          }
        }
        if (pt < 0) {
          data.strPlace = sPart1;
          if (sPart3.length() == 0 && sPart4.length() > 0 && checkAddress(sPart4) > checkAddress(sPart2)) {
            data.strPlace = data.strPlace + '(' + sPart2 + ')';
            sPart2 = stripApt(sPart4, data);
            sPart4 = "";
          }
          parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sPart2, data);
          sPart2 = "";
        }
      }
      
      // Otherwise, first part is the address and city and occasionally
      // a cross street
      else {
        String addr = null;
        for (String fld : BREAK_PTN.split(sPart1)) {
          if (addr == null) {
            addr = fld;
            continue;
          }
          match = APT_PTN.matcher(fld);
          if (match.matches()) {
            String apt = match.group(1);
            if (apt == null) apt = fld;
            data.strApt = append(data.strApt, "-", apt);
            continue;
          }
          
          if (fld.equals("NE") || fld.equals("NW") || fld.equals("SE") || fld.equals("SW")) {
            addr = addr + " - " + fld;
            continue;
          }
          
          if (data.strCity.length() == 0) {
            boolean isCity;;
            if (checkCity) {
              isCity = isCity(fld);
            } else {
              isCity = !fld.contains("/") && !fld.contains(";") && !fld.contains("&");
            }
            if (isCity) {
              if (cityCodes != null) fld = convertCodes(fld, cityCodes);
              data.strCity = fld;
              continue;
            }
          }
          
          if (data.strCity.length() > 0 && 
              data.strState.length() == 0 && 
              STATE_PTN.matcher(fld).matches()) {
            data.strState = fld;
            continue;
          }
          if (fld.startsWith("X ")) fld = fld.substring(2).trim();
          data.strCross = append(data.strCross, " / ", fld);
        }
        
        addr = stripApt(addr, data);
        if (data.strCity.length() > 0) {
          parseAddress(addr, data);
        } else {
          parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, addr, data);
          
          // another oddity, sometimes the same city occurs at the end of
          // both streets in an intersection, so will try to eliminate the
          // extra ones
          if (data.strCity.length() > 0) {
            data.strAddress = data.strAddress.replace(' ' + data.strCity + " &", " &");
          }
        }
        
        // Second part is generally the cross street
        // But if it does not contain a slash or semicolon, and the
        // address isn't a recognizable address, swap this for the address
        if (sPart2.length() > 0) {
          if (data.strCity.length() == 0) {
            int pt = sPart2.lastIndexOf(',');
            if (pt >= 0) {
              String city = sPart2.substring(pt+1).trim();
              if (!checkCity || isCity(city)) {
                data.strCity = city;
                sPart2 = sPart2.substring(0,pt).trim();
              }
            }
          }
          if (!sPart2.contains("/") && !sPart2.contains(";") &&
              data.strPlace.length() == 0 && checkAddress(data.strAddress) == 0 &&
              checkAddress(sPart2) >= STATUS_FULL_ADDRESS) {
            data.strPlace = data.strAddress;
            data.strAddress = "";
            parseAddress(sPart2, data);
          } else {
            sPart2 = stripFieldStart(sPart2, "/");
            sPart2 = stripFieldEnd(sPart2, ";");
            sPart2 = stripFieldEnd(sPart2, "/");
            data.strCross = append(data.strCross, " & ", sPart2);
          }
        }
        sPart2 = "";
      }

      // The rest contains city names, cross streets and/or supp info
      for (String part : new String[]{sPart2, sPart3, sPart4, sPart5}) {
        if (part.length() == 0) continue;
        if (data.strCity.length() == 0) {
          int pt = part.lastIndexOf(',');
          if (pt >= 0) {
            String city = part.substring(pt+1).trim();
            if (!checkCity || isCity(city)) {
              data.strCity = city;
              part = part.substring(0,pt).trim();
            }
          }
        }
        part = stripApt(part, data);
        int pt = part.lastIndexOf("- ");
        if (pt >= 0) {
          data.strPlace = append(data.strPlace, " - ", part.substring(pt+2).trim());
          part = part.substring(0,pt).trim();
        }
        if (part.length() == 0) continue;
        if (part.contains("/")) {
          data.strCross = append(data.strCross, "/", part);
        } else if (part.startsWith("X ")) {
          data.strCross = append(data.strCross, "/", part.substring(2).trim());
        }
        else if (data.strCity.length() == 0  &&
                 (!checkCity || isCity(part))) {
          data.strCity = part;
        } else if (!part.equals(data.strPlace)) {
          data.strSupp = append(data.strSupp, " / ", part);
        }
      }
      
      // Very occasionally, the city name will end up in the APT field
      if (data.strCity.length() == 0 && data.strApt.length() > 0) {
        parseAddress(StartType.START_OTHER, FLAG_ONLY_CITY | FLAG_ANCHOR_END, data.strApt, data);
        data.strApt = getStart();
      }
      
      // Occasionally a city name still makes it into the cross streets :(
      StringBuilder sb = new StringBuilder();
      for (String part : data.strCross.split("[,/]")) {
        part = part.trim();
        if (part.length() == 0) continue;
        if (part.equalsIgnoreCase(data.strCity)) continue;
        if (data.strCity.length() == 0 && checkCity && isCity(part.toUpperCase())) {
          data.strCity = part;
        } else {
          if (sb.length() > 0) sb.append('/');
          sb.append(part);
        }
        data.strCross = sb.toString();
      }
    }
    
    private String stripApt(String part, Data data) {
      int pt = part.indexOf('#');
      if (pt >= 0) {
        String apt = part.substring(pt+1).trim();
        if (apt.startsWith("PVT")) {
          data.strPlace = append(data.strPlace, " - ", apt);
        } else { 
          apt = APT_PREFIX_PTN.matcher(part.substring(pt+1).trim()).replaceAll("");
          data.strApt = append(data.strApt, " - ", apt);
        }
        part = part.substring(0,pt).trim();
      }
      return part;
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR CITY ST APT X INFO";
    }
  }
  
  private class MyGPSField extends GPSField {
    
    private int type;
    
    public MyGPSField(int type) {
      this.type = type;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (type == 1) {
        data.strGPSLoc = field;
      }
      else if (type == 2) {
        field = data.strGPSLoc +',' + field;
        data.strGPSLoc = "";
        setGPSLoc(field, data);
      }
    }
  }
}
	