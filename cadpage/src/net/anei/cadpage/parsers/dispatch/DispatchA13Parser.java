package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class DispatchA13Parser extends FieldProgramParser {
  
  private static final String PROGRAM = "SRCID? DISPATCHED CALL! ADDR";
  
  private Properties cityCodes = null;
  
  public DispatchA13Parser(String defCity, String defState) {
    super(defCity, defState, PROGRAM);
  }
  
  public DispatchA13Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, PROGRAM);
    this.cityCodes = cityCodes;
  }
  
  public DispatchA13Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, PROGRAM);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  // SRCID field contains source and call ID
  private static final Pattern SRCID_PTN = Pattern.compile(".*?([A-Z0-9][ A-Z0-9]+)?:(\\d+:\\d+)");
  private class SourceIdField extends Field {
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = SRCID_PTN.matcher(field);
      if (!match.matches()) return false;
      String src = match.group(1);
      if (src != null) data.strSource = src;
      data.strCallId = match.group(2);;
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
  private static final Pattern STATE_PTN = Pattern.compile(", *([A-Z]{2})$");
  private static final Pattern APT_PREFIX_PTN = Pattern.compile("^(?:APT|RM) *");
  private static final Pattern CITY_PTN = Pattern.compile("(.*)(?:;| - )(.*)");
  private class BaseAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      field = field.replace("\\\\", "&");
      
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
        data.strPlace = stripApt(sPart1.substring(1).trim(), data);
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sPart2, data);
      }
      
      // Otherwise, first part is the address and city
      else {
        match = STATE_PTN.matcher(sPart1);
        if (match.find()) {
          data.strState = match.group(1);
          sPart1 = sPart1.substring(0, match.start()).trim();
        }
        p = new Parser(sPart1);
        String cross = p.getLastOptional(',');
        if (! cross.contains("/") && !cross.startsWith("X ")) {
          data.strCity = cross;
          cross = p.getLastOptional(',');
        }
        if (cross.startsWith("X ")) cross = cross.substring(2).trim();
        data.strCross = cross;
        
        sPart1 = p.get();
        if (data.strCity.length() == 0) {
          match = CITY_PTN.matcher(sPart1);
          if (match.matches()) {
            String city = match.group(2).trim();
            if (cityCodes != null) city = convertCodes(city, cityCodes);
            data.strCity =  city;
            sPart1 = match.group(1).trim();
          }
        }
        
        sPart1 = stripApt(sPart1, data);
        if (data.strCity.length() > 0) {
          parseAddress(sPart1, data);
        } else {
          parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sPart1, data);
        }
        
        // Second part is generally the cross street
        // But if it does not contain a slash or semicolon, and the
        // address isn't a recognizable address, swap this for the address
        if (sPart2.length() > 0) {
          if (!sPart2.contains("/") && !sPart2.contains(";") &&
              data.strPlace.length() == 0 && checkAddress(data.strAddress) == 0 &&
              checkAddress(sPart2) >= STATUS_FULL_ADDRESS) {
            data.strPlace = data.strAddress;
            data.strAddress = "";
            parseAddress(sPart2, data);
          } else {
            if (sPart2.startsWith("/")) sPart2 = sPart2.substring(1).trim();
            if (sPart2.endsWith(";")) sPart2 = sPart2.substring(0,sPart2.length()-1).trim();
            if (sPart2.endsWith("/")) sPart2 = sPart2.substring(0,sPart2.length()-1).trim();
            data.strCross = append(data.strCross, " & ", sPart2);
          }
        }
      }

      // The rest contains city names, cross streets and/or supp info
      for (String part : new String[]{sPart3, sPart4, sPart5}) {
        if (data.strCity.length() == 0) {
          int pt = part.lastIndexOf(',');
          if (pt >= 0) {
            data.strCity = part.substring(pt+1).trim();
            part = part.substring(0,pt).trim();
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
        else if (data.strCity.length() == 0) {
          data.strCity = part;
        } else {
          data.strSupp = append(data.strSupp, " / ", part);
        }
      }
      
      // Occasionally a city name still makes it into the cross streets :(
      StringBuilder sb = new StringBuilder();
      for (String part : data.strCross.split("[,/]")) {
        part = part.trim();
        if (part.length() == 0) continue;
        if (part.equalsIgnoreCase(data.strCity)) continue;
        if (data.strCity.length() == 0 && isCity(part.toUpperCase())) {
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

  @Override
  protected Field getField(String name) {
    if (name.equals("SRCID")) return  new SourceIdField();
    if (name.equals("DISPATCHED")) return new SkipField("Dispatched|Terminated", true);
    if (name.equals("ADDR")) return new BaseAddressField();
    return super.getField(name);
  }
  
}
	