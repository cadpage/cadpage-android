package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;
import net.anei.cadpage.parsers.SplitMsgOptions;
import net.anei.cadpage.parsers.SplitMsgOptionsCustom;

/**
 * Collin County, TX
 */
public class TXCollinCountyAParser extends FieldProgramParser {

  private static final Pattern MASTER1 = Pattern.compile("CFS(#)? (\\d{8}) +(.*)");
  private static final Pattern MSG_DISPATCH_PTN = Pattern.compile("Message [Ff]rom Dispatch ");
  private static final Pattern TRAIL_JUNK_PTN = Pattern.compile("(?:(?:\\[[^\\[\\]]*)?\\{[^\\{\\}]*?\\}?|\\[SENT: [:\\d]+\\])$");
  
  public TXCollinCountyAParser() {
    this("COLLIN COUNTY", "TX");
  }

  protected TXCollinCountyAParser(String defCity, String defState) {
    super(defCity, defState,
          "MASH! UNITS:UNIT ST_RMK:INFO/N CFS_RMK:INFO/N");
    setupCallList(CALL_LIST);
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
    setupMultiWordStreets(MWORD_STREET_LIST);
  }
  
  @Override
  public String getFilter() {
    return "ccsodispatch@co.collin.tx.us,DispatchSMS@coppelltx.gov,ics.gateway@wylietexas.gov,wyliefiredispatch@gmail.com,CADPaging-NOREPLY@flower-mound.com,prosperdispatch@gmail.com,@outlook.com";
  }
  
  
  @Override
  public String getAliasCode() {
    return "TXCollinCountyA";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public SplitMsgOptions getActive911SplitMsgOptions() {
    return new SplitMsgOptionsCustom() {
      @Override public boolean splitBlankIns() { return false; }
      @Override public boolean noParseSubjectFollow() { return true; }
    };
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER1.matcher(body);
    if (match.matches()) {
      String delim = match.group(1) == null ? "  +" : "// +";
      data.strCallId = match.group(2);
      body = match.group(3);
      String flds[] = body.split(delim);
      if (flds.length > 1) {
        flds[0] = flds[0].trim();
        flds[1] = flds[1].trim();
        int s1 = checkAddress(flds[0]);
        int s2 = checkAddress(flds[1]);
        if (s1 > 0 || s2 > 0) {
          if (s2 > s1) {
            parseAddress(flds[1], data);
            data.strCall = flds[0];
          } else {
            parseAddress(flds[0], data);
            data.strCall = flds[1];
          }
          
          if (flds.length > 2) data.strSupp = flds[2];
          for (int ndx = 2; ndx<flds.length; ndx++) {
            data.strSupp = append(data.strSupp, "\n", flds[ndx].trim());
          }
          return true;
        }
      }
      
      data.msgType = MsgType.GEN_ALERT;
      data.strSupp = body;
      return true;
    }
    
    String alert = null;
    match = MSG_DISPATCH_PTN.matcher(body);
    if (match.lookingAt()) {
      body = body.substring(match.end()).trim();
      alert = body;
    }

    // Remove trailing ID
    match = TRAIL_JUNK_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    
    body = body.replace("CFS RMK ", "CFS RMK: ");
    body = body.replaceAll(" +/ +", " / ");
    if (super.parseMsg(body, data)) {
      
      if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
      if (data.strAddress.length() > 0) return true;
    }
    
    if (alert != null) return data.parseGeneralAlert(this, alert);
    return false;
  }
  
  @Override
  public String getProgram() {
    return "ID CALL ADDR APT CITY PLACE X SRC MAP UNIT INFO TIME";
  }
  
  // Parse a mashup of ID, CALL, ADDR, CITY, and Cross streets all of which might
  // or might not be separated by double blank delimiters
  private static final Pattern ID_PTN = Pattern.compile("^(?:([- A-Z0-9]+)\\b)?(\\d{8}) +");
  private static final Pattern DIST_GRID_PTN = Pattern.compile("\\[([A-Z]+) (?:DIST: ([A-Z0-9]*) )?GRID: ([A-Z0-9]*) *(.*?)\\]");
  private static final Pattern DIST_GRID_PTN2 = Pattern.compile("([A-Z]+) (?:DIST: ([A-Z0-9]*) )?GRID: ([A-Z0-9]*) *(.*?)");
  private static final Pattern BRACKET_PTN = Pattern.compile(" +(?:\\{([^\\[\\]\\{\\}]*?)\\}|\\[([^\\[\\]\\{\\}]*?)\\]) *");
  private static final Pattern STANDBY_PTN = Pattern.compile("^STANDBY(?: AT THIS TIME)?  +");
  private static final Pattern STAGE_AT_PTN = Pattern.compile("  +STAGE AT ");
  private static final Pattern JUNK_PTN = Pattern.compile(" (?:\"[^A-Za-z0-9]\"|\"SPECIFY(?: NATURE)?\"|\\{\\{TONE\\}\\}) ");
  private static final Pattern IN_PTN = Pattern.compile("(.*)(?: IN (?!CUSTODY|CITY|TOWN|WOODS)|, )(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern ALPHA_PTN = Pattern.compile("[A-Z]+", Pattern.CASE_INSENSITIVE);
  private static final Pattern TX_PTN = Pattern.compile("TX(?: (?:\\d{5}|0))?\\b *(.*)");
  private class MashField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      
      // Start with easy stuff.  ID is almost always the first token
      // Occasionally there is a call prefix in front of it
      Matcher match = ID_PTN.matcher(field);
      if (!match.lookingAt()) abort();
      String prefix = getOptGroup(match.group(1));
      if (prefix.equals("CFS")) prefix = "";
      data.strCallId = match.group(2);
      field = field.substring(match.end());
      
      // Check for one or more map grid constructs
      match = DIST_GRID_PTN.matcher(field);
      if (match.find()) {
        parseDistGrid(match, data);
        String info = field.substring(match.end()).trim();
        field = field.substring(0,match.start()).trim();
        
        while ((match = DIST_GRID_PTN.matcher(info)).lookingAt()) {
          parseDistGrid(match, data);
          info = info.substring(match.end()).trim();
        }
        data.strSupp = info;
      }

      // If first phrase is a standby request, combine it with second term
      field = STANDBY_PTN.matcher(field).replaceFirst("STANDBY ");
      
      // Fix leading blanks before STAGE AT phrase
      field = STAGE_AT_PTN.matcher(field).replaceFirst(" STAGE AT");
      
      // Cleanup other special problems
      field = JUNK_PTN.matcher(field).replaceAll("  ");
      
      // A field in {} is considered a place name
      match = BRACKET_PTN.matcher(field);
      if (match.find()) {
        String place = match.group(1);
        if (place == null) place = match.group(2);
        data.strPlace = place.trim();
        field = field.substring(0,match.start()) + "  " + field.substring(match.end());
      }
      
      // Break up what is left by any double blank delimiters and see what we have to work with
      String[] flds = field.split("  +");
      switch (flds.length) {
      
      case 1:
        
        parseAddr(CALL | CROSS, flds[0], data);
        break;
        
      case 2:
        
        // Two fields is ambiguous, we don't know if if the break is call/address and cross
        // or call and address/cross.  We'll check both for an IN keyword, which
        // would mark the address
        if (parseAddr(OPTIONAL | CROSS, flds[1], data)) {
          data.strCall = flds[0];
        }
        
        else { 
          parseAddr(CALL, flds[0], data);
          data.strCross = flds[1];
        }
        break;
        
      default:
        
        // Three or more fields, special case if next to last field is CROSS STREETS
        int addrPt = -1;
        
        for (int ii = flds.length-2; addrPt < 0 && ii>=1 && ii >= flds.length-3; ii--) {
          if (flds[ii].equals("CROSS STREETS")) {
            data.strCross = flds[ii+1];
            if (ii+2 < flds.length) data.strSupp = flds[ii+2];
            addrPt = ii-1; 
            parseAddr((addrPt == 0 ? CALL : 0), flds[addrPt], data); 
          }
        }
        
        // Otherwise, look for address in one of the last
        // two fields.
        if (addrPt < 0) {
          for (int ii = flds.length-1; addrPt < 0 && ii >= 0; ii--) {
            int flags = OPTIONAL;
            if (ii == 0) flags |= CALL;
            if (ii == flds.length-1) flags |= CROSS;
            if (parseAddr(flags, flds[ii], data)) {
              addrPt = ii;
              if (ii + 1 < flds.length) {
                data.strCross = flds[ii+1];
                for (ii = ii+2; ii < flds.length; ii++) {
                  data.strSupp = append(data.strSupp, " - ", flds[ii]);
                }
              }
            }
          }
        }
        
        if (addrPt < 0) abort();
        
        // ANy fields in front of address are concatenated to form call description
        for (int ii = 0; ii < addrPt; ii++) {
          data.strCall = append(data.strCall, " - ", flds[ii]);
        }
        break;
      }
      
      // Append the call prefix if we have one
      data.strCall = append(prefix, " - ", data.strCall);
      
      // However we got them, remove leading/trailing / from cross field
      data.strCross = stripFieldStart(data.strCross, "/");
      data.strCross = stripFieldEnd(data.strCross, "/");
    }
    
    private void parseDistGrid(Matcher match, Data data) {
      String extra = parseDistGrid2(match, data);
      while (extra.length() > 0) {
        match = DIST_GRID_PTN2.matcher(extra);
        if (!match.matches()) break;
        extra = parseDistGrid2(match, data);
      }
    }

    private String parseDistGrid2(Matcher match, Data data) {
      String src = match.group(1).trim();
      if (!data.strSource.contains(src)) data.strSource = append(data.strSource, " ", src);
      String map = append(getOptGroup(match.group(2)), "-", match.group(3).trim());
      if (!data.strMap.equals(map)) data.strMap = append(data.strMap, "/", map);
      return match.group(4).trim();
    }
    
    private static final int OPTIONAL = 1;
    private static final int CALL = 2;
    private static final int CROSS = 4;
    private boolean parseAddr(int flags, String sAddress, Data data) {
      
      // Break out flag options
      boolean optional = (flags & OPTIONAL) != 0;
      boolean call = (flags & CALL) != 0;
      boolean cross = (flags & CROSS) != 0;
      
      int parseFlags = FLAG_NO_IMPLIED_APT;
      StartType st = StartType.START_ADDR;
      if (call) {
        st = StartType.START_CALL;
        parseFlags |= FLAG_START_FLD_REQ; 
      }
      
      // Next, see if address contains an IN keyword separated call/address from city/cross
      Matcher match = IN_PTN.matcher(sAddress);
      if (match.find()) {
        
        sAddress = match.group(1).trim();
        String tail = match.group(2).trim();
        
        // Check for doubled IN city construct
        match = IN_PTN.matcher(sAddress);
        if (match.matches()) {
          String city = match.group(2).trim();
          boolean good = ALPHA_PTN.matcher(city).matches();
          if (!good) {
            String upCity = city.toUpperCase();
            String city2 = DOUBLE_CITY_LIST.getCode(upCity, true);
            if (city2 != null) {
              good = true;
              if (city2.length() < upCity.length() && (city2.endsWith(" CO") || city.endsWith(" COUNTY"))) {
                city = upCity.substring(city2.length()).trim();
              } else {
                city = city2;
              }
            }
          }
          if (good) {
            sAddress = match.group(1).trim();
            data.strCity = city;
            tail = stripFieldStart(tail, city);
          }
        }
        
        // Check, use smart parser to split call and address
        parseAddress(st, parseFlags | FLAG_ANCHOR_END, sAddress, data);
        
        tail = trimTX(tail);
        
        if (data.strCity.length() > 0) {
          if (cross) setCross(tail, data);
          return true;
        }
        
        // Otherwise, if we aren't handling cross streets, it is all city
        if (!cross) {
          data.strCity = tail;
          return true;
        }
        
        // Otherwise, see if it starts with a two word city, if it does
        // use that city to break tail into city and cross streets
        String city = DOUBLE_CITY_LIST.getCode(tail.toUpperCase(), true);
        if (city != null) {
          data.strCity = tail.substring(0,city.length());
          setCross(trimTX(tail.substring(city.length()).trim()), data);
          return true;
        }
        
        // Otherwise first word of tail is city, rest is cross
        // Unless city was followed by TX which needs to go
        Parser p = new Parser(tail);
        data.strCity = p.get(' ');
        setCross(trimTX(p.get()), data);
        return true;
      }
      
      // No IN keyword, if this was an optional parse, return failure
      // Unless is an obvious address
      if (optional) {
        Result res = parseAddress(st, parseFlags | FLAG_CHECK_STATUS | FLAG_ANCHOR_END, sAddress);
        if (res.getStatus() < STATUS_FULL_ADDRESS) return false;
        res.getData(data);
        return true;
      }
      
      // no IN keyword, which we assume means no city
      // Use smart address parser to separate call, adddress, and cross
      if (!cross) parseFlags |= FLAG_ANCHOR_END;
      parseAddress(st, parseFlags, sAddress, data);
      if (cross) setCross(getLeft(), data);
      return true;
    }

    private String trimTX(String tail) {
      Matcher match;
      match = TX_PTN.matcher(tail);
      if (match.matches()) tail = match.group(1);
      return tail;
    }
    
    private void setCross(String cross, Data data) {
      if (cross.equals("2ND TONE/PAGE")) {
        data.strCall = append(data.strCall, " - ", cross);
      } else {
        data.strCross = cross;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL ADDR CITY X SRC MAP";
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("  ");
      if (pt >= 0) {
        String info = field.substring(pt+2).trim();
        if (!info.startsWith("<NO ") && !info.endsWith(" REMARKS>")) {
          data.strSupp = append(data.strSupp, "\n", info);
        }
        field = field.substring(0,pt);
      }
      super.parse(field, data);
    }
  }
  
  private static final Pattern INFO_MAP_PTN = Pattern.compile("^MAP(?: PAGE)?[ _]?((?:[A-Z]{3} )?[-A-Z0-9]+)(?:\\.PDF)? *");
  private static final Pattern INFO_TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d)\\b");
  private static final Pattern INFO_NONE_PTN = Pattern.compile(" *<NO(?:NE|.* COMMENTS|.* REMARKS)> *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher  match = INFO_MAP_PTN.matcher(field);
      if (match.find()) {
        data.strMap = match.group(1);
        field = field.substring(match.end());
      }
      
      match = INFO_TIME_PTN.matcher(field);
      if (match.find()) {
        data.strTime = match.group(1);
        field = field.substring(match.end()).trim();
      }
      
      field = INFO_NONE_PTN.matcher(field).replaceAll(" ").trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "MAP TIME INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MASH")) return new MashField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "880-101 S COIT RD",  "33.226272,-96.767895",
      "880-102 S COIT RD",  "33.226272,-96.767895",
      "880-103 S COIT RD",  "33.226272,-96.767895",
      "880-104 S COIT RD",  "33.226272,-96.767895",
      "880-105 S COIT RD",  "33.226272,-96.767895",
      "880-106 S COIT RD",  "33.226272,-96.767895",
      "880-107 S COIT RD",  "33.226272,-96.767895",
      "880-108 S COIT RD",  "33.226272,-96.767895",
      "880-109 S COIT RD",  "33.226272,-96.767895",
      "880-110 S COIT RD",  "33.226272,-96.767895",
      "880-111 S COIT RD",  "33.226272,-96.767895",
      "880-112 S COIT RD",  "33.226272,-96.767895",
      "880-201 S COIT RD",  "33.225406,-96.767932",
      "880-202 S COIT RD",  "33.225406,-96.767932",
      "880-203 S COIT RD",  "33.225406,-96.767932",
      "880-204 S COIT RD",  "33.225406,-96.767932",
      "880-205 S COIT RD",  "33.225406,-96.767932",
      "880-206 S COIT RD",  "33.225406,-96.767932",
      "880-207 S COIT RD",  "33.225406,-96.767932",
      "880-301 S COIT RD",  "33.224984,-96.767943",
      "880-302 S COIT RD",  "33.224984,-96.767943",
      "880-303 S COIT RD",  "33.224984,-96.767943",
      "880-304 S COIT RD",  "33.224984,-96.767943",
      "880-305 S COIT RD",  "33.224984,-96.767943",
      "880-306 S COIT RD",  "33.224984,-96.767943",
      "880-307 S COIT RD",  "33.224984,-96.767943",
      "880-401 S COIT RD",  "33.226124,-96.768340",
      "880-402 S COIT RD",  "33.226124,-96.768340",
      "880-403 S COIT RD",  "33.226124,-96.768340",
      "880-404 S COIT RD",  "33.226124,-96.768340",
      "880-405 S COIT RD",  "33.226124,-96.768340",
      "880-406 S COIT RD",  "33.226124,-96.768340",
      "880-407 S COIT RD",  "33.226124,-96.768340",
      "880-501 S COIT RD",  "33.225823,-96.768790",
      "880-502 S COIT RD",  "33.225823,-96.768790",
      "880-503 S COIT RD",  "33.225823,-96.768790",
      "880-504 S COIT RD",  "33.225823,-96.768790",
      "880-505 S COIT RD",  "33.225823,-96.768790",
      "880-506 S COIT RD",  "33.225823,-96.768790",
      "880-507 S COIT RD",  "33.225823,-96.768790",
      "880-601 S COIT RD",  "33.225172,-96.768329",
      "880-602 S COIT RD",  "33.225172,-96.768329",
      "880-603 S COIT RD",  "33.225172,-96.768329",
      "880-604 S COIT RD",  "33.225172,-96.768329",
      "880-605 S COIT RD",  "33.225172,-96.768329",
      "880-606 S COIT RD",  "33.225172,-96.768329",
      "880-607 S COIT RD",  "33.225172,-96.768329",
      "880-701 S COIT RD",  "33.225576,-96.769075",
      "880-702 S COIT RD",  "33.225576,-96.769075",
      "880-703 S COIT RD",  "33.225576,-96.769075",
      "880-704 S COIT RD",  "33.225576,-96.769075",
      "880-705 S COIT RD",  "33.225576,-96.769075",
      "880-706 S COIT RD",  "33.225576,-96.769075",
      "880-707 S COIT RD",  "33.225576,-96.769075",
      "880-801 S COIT RD",  "33.225168,-96.768753",
      "880-802 S COIT RD",  "33.225168,-96.768753",
      "880-803 S COIT RD",  "33.225168,-96.768753",
      "880-804 S COIT RD",  "33.225168,-96.768753",
      "880-805 S COIT RD",  "33.225168,-96.768753",
      "880-806 S COIT RD",  "33.225168,-96.768753",
      "880-807 S COIT RD",  "33.225168,-96.768753",
      "880-901 S COIT RD",  "33.224746,-96.768404",
      "880-902 S COIT RD",  "33.224746,-96.768404",
      "880-903 S COIT RD",  "33.224746,-96.768404",
      "880-904 S COIT RD",  "33.224746,-96.768404",
      "880-905 S COIT RD",  "33.224746,-96.768404",
      "880-906 S COIT RD",  "33.224746,-96.768404",
      "880-907 S COIT RD",  "33.224746,-96.768404",
      "880-1001 S COIT RD",  "33.225365,-96.769418",
      "880-1002 S COIT RD",  "33.225365,-96.769418",
      "880-1003 S COIT RD",  "33.225365,-96.769418",
      "880-1004 S COIT RD",  "33.225365,-96.769418",
      "880-1005 S COIT RD",  "33.225365,-96.769418",
      "880-1006 S COIT RD",  "33.225365,-96.769418",
      "880-1007 S COIT RD",  "33.225365,-96.769418",
      "880-1101 S COIT RD",  "33.225029,-96.769118",
      "880-1102 S COIT RD",  "33.225029,-96.769118",
      "880-1103 S COIT RD",  "33.225029,-96.769118",
      "880-1104 S COIT RD",  "33.225029,-96.769118",
      "880-1105 S COIT RD",  "33.225029,-96.769118",
      "880-1106 S COIT RD",  "33.225029,-96.769118",
      "880-1107 S COIT RD",  "33.225029,-96.769118",
      "880-1201 S COIT RD",  "33.224661,-96.768978",
      "880-1202 S COIT RD",  "33.224661,-96.768978",
      "880-1203 S COIT RD",  "33.224661,-96.768978",
      "880-1204 S COIT RD",  "33.224661,-96.768978",
      "880-1205 S COIT RD",  "33.224661,-96.768978",
      "880-1206 S COIT RD",  "33.224661,-96.768978",
      "880-1207 S COIT RD",  "33.224661,-96.768978",
      "880-1301 S COIT RD",  "33.225163,-96.769815",
      "880-1302 S COIT RD",  "33.225163,-96.769815",
      "880-1303 S COIT RD",  "33.225163,-96.769815",
      "880-1304 S COIT RD",  "33.225163,-96.769815",
      "880-1305 S COIT RD",  "33.225163,-96.769815",
      "880-1306 S COIT RD",  "33.225163,-96.769815",
      "880-1307 S COIT RD",  "33.225163,-96.769815",
      "880-1308 S COIT RD",  "33.225163,-96.769815",
      "880-1309 S COIT RD",  "33.225163,-96.769815",
      "880-1310 S COIT RD",  "33.225163,-96.769815",
      "880-1311 S COIT RD",  "33.225163,-96.769815",
      "880-1312 S COIT RD",  "33.225163,-96.769815",
      "880-1401 S COIT RD",  "33.224701,-96.769525",
      "880-1402 S COIT RD",  "33.224701,-96.769525",
      "880-1403 S COIT RD",  "33.224701,-96.769525",
      "880-1404 S COIT RD",  "33.224701,-96.769525",
      "880-1405 S COIT RD",  "33.224701,-96.769525",
      "880-1406 S COIT RD",  "33.224701,-96.769525",
      "880-1407 S COIT RD",  "33.224701,-96.769525",
      "880-1408 S COIT RD",  "33.224701,-96.769525",
      "880-1409 S COIT RD",  "33.224701,-96.769525",
      "880-1410 S COIT RD",  "33.224701,-96.769525",
      "880-1411 S COIT RD",  "33.224701,-96.769525",
      "880-1412 S COIT RD",  "33.224701,-96.769525",
      "880-1501 S COIT RD",  "33.224392,-96.769402",
      "880-1502 S COIT RD",  "33.224392,-96.769402",
      "880-1503 S COIT RD",  "33.224392,-96.769402",
      "880-1504 S COIT RD",  "33.224392,-96.769402",
      "880-1505 S COIT RD",  "33.224392,-96.769402",
      "880-1506 S COIT RD",  "33.224392,-96.769402",
      "880-1507 S COIT RD",  "33.224392,-96.769402",
      "880-1601 S COIT RD",  "33.224593,-96.770641",
      "880-1602 S COIT RD",  "33.224593,-96.770641",
      "880-1603 S COIT RD",  "33.224593,-96.770641",
      "880-1604 S COIT RD",  "33.224593,-96.770641",
      "880-1605 S COIT RD",  "33.224593,-96.770641",
      "880-1606 S COIT RD",  "33.224593,-96.770641",
      "880-1607 S COIT RD",  "33.224593,-96.770641",
      "880-1701 S COIT RD",  "33.224553,-96.77004",
      "880-1702 S COIT RD",  "33.224553,-96.77004",
      "880-1703 S COIT RD",  "33.224553,-96.77004",
      "880-1704 S COIT RD",  "33.224553,-96.77004",
      "880-1705 S COIT RD",  "33.224553,-96.77004",
      "880-1706 S COIT RD",  "33.224553,-96.77004",
      "880-1707 S COIT RD",  "33.224553,-96.77004",
      "880-1801 S COIT RD",  "33.224127,-96.769949",
      "880-1802 S COIT RD",  "33.224127,-96.769949",
      "880-1803 S COIT RD",  "33.224127,-96.769949",
      "880-1804 S COIT RD",  "33.224127,-96.769949",
      "880-1805 S COIT RD",  "33.224127,-96.769949",
      "880-1806 S COIT RD",  "33.224127,-96.769949",
      "880-1807 S COIT RD",  "33.224127,-96.769949",
      "880-1901 S COIT RD",  "33.224127,-96.769949",
      "880-1902 S COIT RD",  "33.224351,-96.770362",
      "880-1903 S COIT RD",  "33.224351,-96.770362",
      "880-1904 S COIT RD",  "33.224351,-96.770362",
      "880-1905 S COIT RD",  "33.224351,-96.770362",
      "880-1906 S COIT RD",  "33.224351,-96.770362",
      "880-1907 S COIT RD",  "33.224351,-96.770362",
      "880-2001 S COIT RD",  "33.224849,-96.77025",
      "880-2002 S COIT RD",  "33.224849,-96.77025",
      "880-2003 S COIT RD",  "33.224849,-96.77025",
      "880-2004 S COIT RD",  "33.224849,-96.77025",
      "880-2005 S COIT RD",  "33.224849,-96.77025",
      "880-2006 S COIT RD",  "33.224849,-96.77025",
      "880-2007 S COIT RD",  "33.224849,-96.77025",
      "880-2101 S COIT RD",  "33.224315,-96.771151",
      "880-2102 S COIT RD",  "33.224315,-96.771151",
      "880-2103 S COIT RD",  "33.224315,-96.771151",
      "880-2104 S COIT RD",  "33.224315,-96.771151",
      "880-2105 S COIT RD",  "33.224315,-96.771151",
      "880-2106 S COIT RD",  "33.224315,-96.771151",
      "880-2107 S COIT RD",  "33.224315,-96.771151",
      "880-2108 S COIT RD",  "33.224315,-96.771151",
      "880-2109 S COIT RD",  "33.224315,-96.771151",
      "880-2110 S COIT RD",  "33.224315,-96.771151",
      "880-2111 S COIT RD",  "33.224315,-96.771151",
      "880-2112 S COIT RD",  "33.224315,-96.771151",
      "880-2201 S COIT RD",  "33.223840,-96.771746",
      "880-2202 S COIT RD",  "33.223840,-96.771746",
      "880-2203 S COIT RD",  "33.223840,-96.771746",
      "880-2204 S COIT RD",  "33.223840,-96.771746",
      "880-2205 S COIT RD",  "33.223840,-96.771746",
      "880-2206 S COIT RD",  "33.223840,-96.771746",
      "880-2207 S COIT RD",  "33.223840,-96.771746",
      "880-2301 S COIT RD",  "33.223611,-96.771564",
      "880-2302 S COIT RD",  "33.223611,-96.771564",
      "880-2303 S COIT RD",  "33.223611,-96.771564",
      "880-2304 S COIT RD",  "33.223611,-96.771564",
      "880-2305 S COIT RD",  "33.223611,-96.771564",
      "880-2306 S COIT RD",  "33.223611,-96.771564",
      "880-2307 S COIT RD",  "33.223611,-96.771564",
      "880-2401 S COIT RD",  "33.223373,-96.771317",
      "880-2402 S COIT RD",  "33.223373,-96.771317",
      "880-2403 S COIT RD",  "33.223373,-96.771317",
      "880-2404 S COIT RD",  "33.223373,-96.771317",
      "880-2405 S COIT RD",  "33.223373,-96.771317",
      "880-2406 S COIT RD",  "33.223373,-96.771317",
      "880-2407 S COIT RD",  "33.223373,-96.771317",
      "880-2501 S COIT RD",  "33.223548,-96.772186",
      "880-2502 S COIT RD",  "33.223548,-96.772186",
      "880-2503 S COIT RD",  "33.223548,-96.772186",
      "880-2504 S COIT RD",  "33.223548,-96.772186",
      "880-2505 S COIT RD",  "33.223548,-96.772186",
      "880-2506 S COIT RD",  "33.223548,-96.772186",
      "880-2507 S COIT RD",  "33.223548,-96.772186",
      "880-2601 S COIT RD",  "33.223297,-96.771982",
      "880-2602 S COIT RD",  "33.223297,-96.771982",
      "880-2603 S COIT RD",  "33.223297,-96.771982",
      "880-2604 S COIT RD",  "33.223297,-96.771982",
      "880-2605 S COIT RD",  "33.223297,-96.771982",
      "880-2606 S COIT RD",  "33.223297,-96.771982",
      "880-2607 S COIT RD",  "33.223297,-96.771982",
      "880-2701 S COIT RD",  "33.223059,-96.771709",
      "880-2702 S COIT RD",  "33.223059,-96.771709",
      "880-2703 S COIT RD",  "33.223059,-96.771709",
      "880-2704 S COIT RD",  "33.223059,-96.771709",
      "880-2705 S COIT RD",  "33.223059,-96.771709",
      "880-2706 S COIT RD",  "33.223059,-96.771709",
      "880-2707 S COIT RD",  "33.223059,-96.771709",
      "880-2801 S COIT RD",  "33.223323,-96.772626",
      "880-2802 S COIT RD",  "33.223323,-96.772626",
      "880-2803 S COIT RD",  "33.223323,-96.772626",
      "880-2804 S COIT RD",  "33.223323,-96.772626",
      "880-2805 S COIT RD",  "33.223323,-96.772626",
      "880-2806 S COIT RD",  "33.223323,-96.772626",
      "880-2807 S COIT RD",  "33.223323,-96.772626",
      "880-2808 S COIT RD",  "33.223323,-96.772626",
      "880-2809 S COIT RD",  "33.223323,-96.772626",
      "880-2810 S COIT RD",  "33.223323,-96.772626",
      "880-2811 S COIT RD",  "33.223323,-96.772626",
      "880-2812 S COIT RD",  "33.223323,-96.772626",
      "880-2901 S COIT RD",  "33.223045,-96.772363",
      "880-2902 S COIT RD",  "33.223045,-96.772363",
      "880-2903 S COIT RD",  "33.223045,-96.772363",
      "880-2904 S COIT RD",  "33.223045,-96.772363",
      "880-2905 S COIT RD",  "33.223045,-96.772363",
      "880-2906 S COIT RD",  "33.223045,-96.772363",
      "880-2907 S COIT RD",  "33.223045,-96.772363",
      "880-3001 S COIT RD",  "33.222794,-96.772127",
      "880-3002 S COIT RD",  "33.222794,-96.772127",
      "880-3003 S COIT RD",  "33.222794,-96.772127",
      "880-3004 S COIT RD",  "33.222794,-96.772127",
      "880-3005 S COIT RD",  "33.222794,-96.772127",
      "880-3006 S COIT RD",  "33.222794,-96.772127",
      "880-3007 S COIT RD",  "33.222794,-96.772127",
      "880-3101 S COIT RD",  "33.222987,-96.773061",
      "880-3102 S COIT RD",  "33.222987,-96.773061",
      "880-3103 S COIT RD",  "33.222987,-96.773061",
      "880-3104 S COIT RD",  "33.222987,-96.773061",
      "880-3105 S COIT RD",  "33.222987,-96.773061",
      "880-3106 S COIT RD",  "33.222987,-96.773061",
      "880-3107 S COIT RD",  "33.222987,-96.773061",
      "880-3201 S COIT RD",  "33.222758,-96.772825",
      "880-3202 S COIT RD",  "33.222758,-96.772825",
      "880-3203 S COIT RD",  "33.222758,-96.772825",
      "880-3204 S COIT RD",  "33.222758,-96.772825",
      "880-3205 S COIT RD",  "33.222758,-96.772825",
      "880-3206 S COIT RD",  "33.222758,-96.772825",
      "880-3207 S COIT RD",  "33.222758,-96.772825",
      "880-3301 S COIT RD",  "33.222502,-96.772567",
      "880-3302 S COIT RD",  "33.222502,-96.772567",
      "880-3303 S COIT RD",  "33.222502,-96.772567",
      "880-3304 S COIT RD",  "33.222502,-96.772567",
      "880-3305 S COIT RD",  "33.222502,-96.772567",
      "880-3306 S COIT RD",  "33.222502,-96.772567",
      "880-3307 S COIT RD",  "33.222502,-96.772567",
      "880-3401 S COIT RD",  "33.222677,-96.773479",
      "880-3402 S COIT RD",  "33.222677,-96.773479",
      "880-3403 S COIT RD",  "33.222677,-96.773479",
      "880-3404 S COIT RD",  "33.222677,-96.773479",
      "880-3405 S COIT RD",  "33.222677,-96.773479",
      "880-3406 S COIT RD",  "33.222677,-96.773479",
      "880-3407 S COIT RD",  "33.222677,-96.773479",
      "880-3501 S COIT RD",  "33.222395,-96.773785",
      "880-3502 S COIT RD",  "33.222395,-96.773785",
      "880-3503 S COIT RD",  "33.222395,-96.773785",
      "880-3504 S COIT RD",  "33.222395,-96.773785",
      "880-3505 S COIT RD",  "33.222395,-96.773785",
      "880-3506 S COIT RD",  "33.222395,-96.773785",
      "880-3507 S COIT RD",  "33.222395,-96.773785",
      "880-3508 S COIT RD",  "33.222395,-96.773785",
      "880-3509 S COIT RD",  "33.222395,-96.773785",
      "880-3510 S COIT RD",  "33.222395,-96.773785",
      "880-3511 S COIT RD",  "33.222395,-96.773785",
      "880-3512 S COIT RD",  "33.222395,-96.773785",
      "880-3601 S COIT RD",  "33.222435,-96.77327",
      "880-3602 S COIT RD",  "33.222435,-96.77327",
      "880-3603 S COIT RD",  "33.222435,-96.77327",
      "880-3604 S COIT RD",  "33.222435,-96.77327",
      "880-3605 S COIT RD",  "33.222435,-96.77327",
      "880-3606 S COIT RD",  "33.222435,-96.77327",
      "880-3607 S COIT RD",  "33.222435,-96.77327",
      "880-3701 S COIT RD",  "33.222076,-96.773495",
      "880-3702 S COIT RD",  "33.222076,-96.773495",
      "880-3703 S COIT RD",  "33.222076,-96.773495",
      "880-3704 S COIT RD",  "33.222076,-96.773495",
      "880-3705 S COIT RD",  "33.222076,-96.773495",
      "880-3706 S COIT RD",  "33.222076,-96.773495",
      "880-3707 S COIT RD",  "33.222076,-96.773495",
      "880-3708 S COIT RD",  "33.222076,-96.773495",
      "880-3709 S COIT RD",  "33.222076,-96.773495",
      "880-3710 S COIT RD",  "33.222076,-96.773495",
      "880-3711 S COIT RD",  "33.222076,-96.773495",
      "880-3712 S COIT RD",  "33.222076,-96.773495",
      "880-3801 S COIT RD",  "33.222076,-96.774101",
      "880-3802 S COIT RD",  "33.222076,-96.774101",
      "880-3803 S COIT RD",  "33.222076,-96.774101",
      "880-3804 S COIT RD",  "33.222076,-96.774101",
      "880-3805 S COIT RD",  "33.222076,-96.774101",
      "880-3806 S COIT RD",  "33.222076,-96.774101",
      "880-3807 S COIT RD",  "33.222076,-96.774101",
      "880-3901 S COIT RD",  "33.222206,-96.772921",
      "880-3902 S COIT RD",  "33.222206,-96.772921",
      "880-3903 S COIT RD",  "33.222206,-96.772921",
      "880-3904 S COIT RD",  "33.222206,-96.772921",
      "880-3905 S COIT RD",  "33.222206,-96.772921",
      "880-3906 S COIT RD",  "33.222206,-96.772921",
      "880-3907 S COIT RD",  "33.222206,-96.772921",
      
      "980-110 S COIT RD",  "33.223826,-96.768216",
      "980-111 S COIT RD",  "33.223826,-96.768216",
      "980-112 S COIT RD",  "33.223826,-96.768216",
      "980-113 S COIT RD",  "33.223826,-96.768216",
      "980-114 S COIT RD",  "33.223826,-96.768216",
      "980-115 S COIT RD",  "33.223826,-96.768216",
      "980-116 S COIT RD",  "33.223826,-96.768216",
      "980-117 S COIT RD",  "33.223826,-96.768216",
      "980-120 S COIT RD",  "33.223826,-96.768216",
      "980-121 S COIT RD",  "33.223826,-96.768216",
      "980-122 S COIT RD",  "33.223826,-96.768216",
      "980-123 S COIT RD",  "33.223826,-96.768216",
      "980-124 S COIT RD",  "33.223826,-96.768216",
      "980-125 S COIT RD",  "33.223826,-96.768216",
      "980-126 S COIT RD",  "33.223826,-96.768216",
      "980-127 S COIT RD",  "33.223826,-96.768216",
      "980-130 S COIT RD",  "33.223826,-96.768216",
      "980-131 S COIT RD",  "33.223826,-96.768216",
      "980-132 S COIT RD",  "33.223826,-96.768216",
      "980-133 S COIT RD",  "33.223826,-96.768216",
      "980-134 S COIT RD",  "33.223826,-96.768216",
      "980-135 S COIT RD",  "33.223826,-96.768216",
      "980-136 S COIT RD",  "33.223826,-96.768216",
      "980-137 S COIT RD",  "33.223826,-96.768216",
      "980-210 S COIT RD",  "33.223507,-96.768533",
      "980-211 S COIT RD",  "33.223507,-96.768533",
      "980-212 S COIT RD",  "33.223507,-96.768533",
      "980-213 S COIT RD",  "33.223507,-96.768533",
      "980-214 S COIT RD",  "33.223507,-96.768533",
      "980-215 S COIT RD",  "33.223507,-96.768533",
      "980-216 S COIT RD",  "33.223507,-96.768533",
      "980-217 S COIT RD",  "33.223507,-96.768533",
      "980-220 S COIT RD",  "33.223507,-96.768533",
      "980-221 S COIT RD",  "33.223507,-96.768533",
      "980-222 S COIT RD",  "33.223507,-96.768533",
      "980-223 S COIT RD",  "33.223507,-96.768533",
      "980-224 S COIT RD",  "33.223507,-96.768533",
      "980-225 S COIT RD",  "33.223507,-96.768533",
      "980-226 S COIT RD",  "33.223507,-96.768533",
      "980-227 S COIT RD",  "33.223507,-96.768533",
      "980-230 S COIT RD",  "33.223507,-96.768533",
      "980-231 S COIT RD",  "33.223507,-96.768533",
      "980-232 S COIT RD",  "33.223507,-96.768533",
      "980-233 S COIT RD",  "33.223507,-96.768533",
      "980-234 S COIT RD",  "33.223507,-96.768533",
      "980-235 S COIT RD",  "33.223507,-96.768533",
      "980-236 S COIT RD",  "33.223507,-96.768533",
      "980-237 S COIT RD",  "33.223507,-96.768533",
      "980-310 S COIT RD",  "33.223409,-96.769037",
      "980-311 S COIT RD",  "33.223409,-96.769037",
      "980-312 S COIT RD",  "33.223409,-96.769037",
      "980-313 S COIT RD",  "33.223409,-96.769037",
      "980-314 S COIT RD",  "33.223409,-96.769037",
      "980-315 S COIT RD",  "33.223409,-96.769037",
      "980-316 S COIT RD",  "33.223409,-96.769037",
      "980-317 S COIT RD",  "33.223409,-96.769037",
      "980-320 S COIT RD",  "33.223409,-96.769037",
      "980-321 S COIT RD",  "33.223409,-96.769037",
      "980-322 S COIT RD",  "33.223409,-96.769037",
      "980-323 S COIT RD",  "33.223409,-96.769037",
      "980-324 S COIT RD",  "33.223409,-96.769037",
      "980-325 S COIT RD",  "33.223409,-96.769037",
      "980-326 S COIT RD",  "33.223409,-96.769037",
      "980-327 S COIT RD",  "33.223409,-96.769037",
      "980-330 S COIT RD",  "33.223409,-96.769037",
      "980-331 S COIT RD",  "33.223409,-96.769037",
      "980-332 S COIT RD",  "33.223409,-96.769037",
      "980-333 S COIT RD",  "33.223409,-96.769037",
      "980-334 S COIT RD",  "33.223409,-96.769037",
      "980-335 S COIT RD",  "33.223409,-96.769037",
      "980-336 S COIT RD",  "33.223409,-96.769037",
      "980-337 S COIT RD",  "33.223409,-96.769037",
      "980-410 S COIT RD",  "33.223826,-96.769445",
      "980-411 S COIT RD",  "33.223826,-96.769445",
      "980-412 S COIT RD",  "33.223826,-96.769445",
      "980-413 S COIT RD",  "33.223826,-96.769445",
      "980-414 S COIT RD",  "33.223826,-96.769445",
      "980-415 S COIT RD",  "33.223826,-96.769445",
      "980-416 S COIT RD",  "33.223826,-96.769445",
      "980-417 S COIT RD",  "33.223826,-96.769445",
      "980-420 S COIT RD",  "33.223826,-96.769445",
      "980-421 S COIT RD",  "33.223826,-96.769445",
      "980-422 S COIT RD",  "33.223826,-96.769445",
      "980-423 S COIT RD",  "33.223826,-96.769445",
      "980-424 S COIT RD",  "33.223826,-96.769445",
      "980-425 S COIT RD",  "33.223826,-96.769445",
      "980-426 S COIT RD",  "33.223826,-96.769445",
      "980-427 S COIT RD",  "33.223826,-96.769445",
      "980-430 S COIT RD",  "33.223826,-96.769445",
      "980-431 S COIT RD",  "33.223826,-96.769445",
      "980-432 S COIT RD",  "33.223826,-96.769445",
      "980-433 S COIT RD",  "33.223826,-96.769445",
      "980-434 S COIT RD",  "33.223826,-96.769445",
      "980-435 S COIT RD",  "33.223826,-96.769445",
      "980-436 S COIT RD",  "33.223826,-96.769445",
      "980-437 S COIT RD",  "33.223826,-96.769445",
      "980-510 S COIT RD",  "33.223503,-96.770191",
      "980-511 S COIT RD",  "33.223503,-96.770191",
      "980-512 S COIT RD",  "33.223503,-96.770191",
      "980-513 S COIT RD",  "33.223503,-96.770191",
      "980-514 S COIT RD",  "33.223503,-96.770191",
      "980-515 S COIT RD",  "33.223503,-96.770191",
      "980-516 S COIT RD",  "33.223503,-96.770191",
      "980-517 S COIT RD",  "33.223503,-96.770191",
      "980-520 S COIT RD",  "33.223503,-96.770191",
      "980-521 S COIT RD",  "33.223503,-96.770191",
      "980-522 S COIT RD",  "33.223503,-96.770191",
      "980-523 S COIT RD",  "33.223503,-96.770191",
      "980-524 S COIT RD",  "33.223503,-96.770191",
      "980-525 S COIT RD",  "33.223503,-96.770191",
      "980-526 S COIT RD",  "33.223503,-96.770191",
      "980-527 S COIT RD",  "33.223503,-96.770191",
      "980-530 S COIT RD",  "33.223503,-96.770191",
      "980-531 S COIT RD",  "33.223503,-96.770191",
      "980-532 S COIT RD",  "33.223503,-96.770191",
      "980-533 S COIT RD",  "33.223503,-96.770191",
      "980-534 S COIT RD",  "33.223503,-96.770191",
      "980-535 S COIT RD",  "33.223503,-96.770191",
      "980-536 S COIT RD",  "33.223503,-96.770191",
      "980-537 S COIT RD",  "33.223503,-96.770191",
      "980-610 S COIT RD",  "33.223072,-96.76981",
      "980-611 S COIT RD",  "33.223072,-96.76981",
      "980-612 S COIT RD",  "33.223072,-96.76981",
      "980-613 S COIT RD",  "33.223072,-96.76981",
      "980-614 S COIT RD",  "33.223072,-96.76981",
      "980-615 S COIT RD",  "33.223072,-96.76981",
      "980-616 S COIT RD",  "33.223072,-96.76981",
      "980-617 S COIT RD",  "33.223072,-96.76981",
      "980-620 S COIT RD",  "33.223072,-96.76981",
      "980-621 S COIT RD",  "33.223072,-96.76981",
      "980-622 S COIT RD",  "33.223072,-96.76981",
      "980-623 S COIT RD",  "33.223072,-96.76981",
      "980-624 S COIT RD",  "33.223072,-96.76981",
      "980-625 S COIT RD",  "33.223072,-96.76981",
      "980-626 S COIT RD",  "33.223072,-96.76981",
      "980-627 S COIT RD",  "33.223072,-96.76981",
      "980-630 S COIT RD",  "33.223072,-96.76981",
      "980-631 S COIT RD",  "33.223072,-96.76981",
      "980-632 S COIT RD",  "33.223072,-96.76981",
      "980-633 S COIT RD",  "33.223072,-96.76981",
      "980-634 S COIT RD",  "33.223072,-96.76981",
      "980-635 S COIT RD",  "33.223072,-96.76981",
      "980-636 S COIT RD",  "33.223072,-96.76981",
      "980-637 S COIT RD",  "33.223072,-96.76981",
      "980-710 S COIT RD",  "33.222825,-96.769584",
      "980-711 S COIT RD",  "33.222825,-96.769584",
      "980-712 S COIT RD",  "33.222825,-96.769584",
      "980-713 S COIT RD",  "33.222825,-96.769584",
      "980-714 S COIT RD",  "33.222825,-96.769584",
      "980-715 S COIT RD",  "33.222825,-96.769584",
      "980-716 S COIT RD",  "33.222825,-96.769584",
      "980-717 S COIT RD",  "33.222825,-96.769584",
      "980-720 S COIT RD",  "33.222825,-96.769584",
      "980-721 S COIT RD",  "33.222825,-96.769584",
      "980-722 S COIT RD",  "33.222825,-96.769584",
      "980-723 S COIT RD",  "33.222825,-96.769584",
      "980-724 S COIT RD",  "33.222825,-96.769584",
      "980-725 S COIT RD",  "33.222825,-96.769584",
      "980-726 S COIT RD",  "33.222825,-96.769584",
      "980-727 S COIT RD",  "33.222825,-96.769584",
      "980-730 S COIT RD",  "33.222825,-96.769584",
      "980-731 S COIT RD",  "33.222825,-96.769584",
      "980-732 S COIT RD",  "33.222825,-96.769584",
      "980-733 S COIT RD",  "33.222825,-96.769584",
      "980-734 S COIT RD",  "33.222825,-96.769584",
      "980-735 S COIT RD",  "33.222825,-96.769584",
      "980-736 S COIT RD",  "33.222825,-96.769584",
      "980-737 S COIT RD",  "33.222825,-96.769584",
      "980-810 S COIT RD",  "33.223104,-96.770695",
      "980-811 S COIT RD",  "33.223104,-96.770695",
      "980-812 S COIT RD",  "33.223104,-96.770695",
      "980-813 S COIT RD",  "33.223104,-96.770695",
      "980-814 S COIT RD",  "33.223104,-96.770695",
      "980-815 S COIT RD",  "33.223104,-96.770695",
      "980-816 S COIT RD",  "33.223104,-96.770695",
      "980-817 S COIT RD",  "33.223104,-96.770695",
      "980-820 S COIT RD",  "33.223104,-96.770695",
      "980-821 S COIT RD",  "33.223104,-96.770695",
      "980-822 S COIT RD",  "33.223104,-96.770695",
      "980-823 S COIT RD",  "33.223104,-96.770695",
      "980-824 S COIT RD",  "33.223104,-96.770695",
      "980-825 S COIT RD",  "33.223104,-96.770695",
      "980-826 S COIT RD",  "33.223104,-96.770695",
      "980-827 S COIT RD",  "33.223104,-96.770695",
      "980-830 S COIT RD",  "33.223104,-96.770695",
      "980-831 S COIT RD",  "33.223104,-96.770695",
      "980-832 S COIT RD",  "33.223104,-96.770695",
      "980-833 S COIT RD",  "33.223104,-96.770695",
      "980-834 S COIT RD",  "33.223104,-96.770695",
      "980-835 S COIT RD",  "33.223104,-96.770695",
      "980-836 S COIT RD",  "33.223104,-96.770695",
      "980-837 S COIT RD",  "33.223104,-96.770695",
      "980-910 S COIT RD",  "33.222727,-96.770335",
      "980-911 S COIT RD",  "33.222727,-96.770335",
      "980-912 S COIT RD",  "33.222727,-96.770335",
      "980-913 S COIT RD",  "33.222727,-96.770335",
      "980-914 S COIT RD",  "33.222727,-96.770335",
      "980-915 S COIT RD",  "33.222727,-96.770335",
      "980-916 S COIT RD",  "33.222727,-96.770335",
      "980-917 S COIT RD",  "33.222727,-96.770335",
      "980-920 S COIT RD",  "33.222727,-96.770335",
      "980-921 S COIT RD",  "33.222727,-96.770335",
      "980-922 S COIT RD",  "33.222727,-96.770335",
      "980-923 S COIT RD",  "33.222727,-96.770335",
      "980-924 S COIT RD",  "33.222727,-96.770335",
      "980-925 S COIT RD",  "33.222727,-96.770335",
      "980-926 S COIT RD",  "33.222727,-96.770335",
      "980-927 S COIT RD",  "33.222727,-96.770335",
      "980-930 S COIT RD",  "33.222727,-96.770335",
      "980-931 S COIT RD",  "33.222727,-96.770335",
      "980-932 S COIT RD",  "33.222727,-96.770335",
      "980-933 S COIT RD",  "33.222727,-96.770335",
      "980-934 S COIT RD",  "33.222727,-96.770335",
      "980-935 S COIT RD",  "33.222727,-96.770335",
      "980-936 S COIT RD",  "33.222727,-96.770335",
      "980-937 S COIT RD",  "33.222727,-96.770335",
      "980-1010 S COIT RD",  "33.222444,-96.77011",
      "980-1011 S COIT RD",  "33.222444,-96.77011",
      "980-1012 S COIT RD",  "33.222444,-96.77011",
      "980-1013 S COIT RD",  "33.222444,-96.77011",
      "980-1014 S COIT RD",  "33.222444,-96.77011",
      "980-1015 S COIT RD",  "33.222444,-96.77011",
      "980-1016 S COIT RD",  "33.222444,-96.77011",
      "980-1017 S COIT RD",  "33.222444,-96.77011",
      "980-1020 S COIT RD",  "33.222444,-96.77011",
      "980-1021 S COIT RD",  "33.222444,-96.77011",
      "980-1022 S COIT RD",  "33.222444,-96.77011",
      "980-1023 S COIT RD",  "33.222444,-96.77011",
      "980-1024 S COIT RD",  "33.222444,-96.77011",
      "980-1025 S COIT RD",  "33.222444,-96.77011",
      "980-1026 S COIT RD",  "33.222444,-96.77011",
      "980-1027 S COIT RD",  "33.222444,-96.77011",
      "980-1030 S COIT RD",  "33.222444,-96.77011",
      "980-1031 S COIT RD",  "33.222444,-96.77011",
      "980-1032 S COIT RD",  "33.222444,-96.77011",
      "980-1033 S COIT RD",  "33.222444,-96.77011",
      "980-1034 S COIT RD",  "33.222444,-96.77011",
      "980-1035 S COIT RD",  "33.222444,-96.77011",
      "980-1036 S COIT RD",  "33.222444,-96.77011",
      "980-1037 S COIT RD",  "33.222444,-96.77011",
      "980-1110 S COIT RD",  "33.222852,-96.771172",
      "980-1111 S COIT RD",  "33.222852,-96.771172",
      "980-1112 S COIT RD",  "33.222852,-96.771172",
      "980-1113 S COIT RD",  "33.222852,-96.771172",
      "980-1114 S COIT RD",  "33.222852,-96.771172",
      "980-1115 S COIT RD",  "33.222852,-96.771172",
      "980-1116 S COIT RD",  "33.222852,-96.771172",
      "980-1117 S COIT RD",  "33.222852,-96.771172",
      "980-1120 S COIT RD",  "33.222852,-96.771172",
      "980-1121 S COIT RD",  "33.222852,-96.771172",
      "980-1122 S COIT RD",  "33.222852,-96.771172",
      "980-1123 S COIT RD",  "33.222852,-96.771172",
      "980-1124 S COIT RD",  "33.222852,-96.771172",
      "980-1125 S COIT RD",  "33.222852,-96.771172",
      "980-1126 S COIT RD",  "33.222852,-96.771172",
      "980-1127 S COIT RD",  "33.222852,-96.771172",
      "980-1130 S COIT RD",  "33.222852,-96.771172",
      "980-1131 S COIT RD",  "33.222852,-96.771172",
      "980-1132 S COIT RD",  "33.222852,-96.771172",
      "980-1133 S COIT RD",  "33.222852,-96.771172",
      "980-1134 S COIT RD",  "33.222852,-96.771172",
      "980-1135 S COIT RD",  "33.222852,-96.771172",
      "980-1136 S COIT RD",  "33.222852,-96.771172",
      "980-1137 S COIT RD",  "33.222852,-96.771172",
      "980-1210 S COIT RD",  "33.222354,-96.770652",
      "980-1211 S COIT RD",  "33.222354,-96.770652",
      "980-1212 S COIT RD",  "33.222354,-96.770652",
      "980-1213 S COIT RD",  "33.222354,-96.770652",
      "980-1214 S COIT RD",  "33.222354,-96.770652",
      "980-1215 S COIT RD",  "33.222354,-96.770652",
      "980-1216 S COIT RD",  "33.222354,-96.770652",
      "980-1217 S COIT RD",  "33.222354,-96.770652",
      "980-1220 S COIT RD",  "33.222354,-96.770652",
      "980-1221 S COIT RD",  "33.222354,-96.770652",
      "980-1222 S COIT RD",  "33.222354,-96.770652",
      "980-1223 S COIT RD",  "33.222354,-96.770652",
      "980-1224 S COIT RD",  "33.222354,-96.770652",
      "980-1225 S COIT RD",  "33.222354,-96.770652",
      "980-1226 S COIT RD",  "33.222354,-96.770652",
      "980-1227 S COIT RD",  "33.222354,-96.770652",
      "980-1230 S COIT RD",  "33.222354,-96.770652",
      "980-1231 S COIT RD",  "33.222354,-96.770652",
      "980-1232 S COIT RD",  "33.222354,-96.770652",
      "980-1233 S COIT RD",  "33.222354,-96.770652",
      "980-1234 S COIT RD",  "33.222354,-96.770652",
      "980-1235 S COIT RD",  "33.222354,-96.770652",
      "980-1236 S COIT RD",  "33.222354,-96.770652",
      "980-1237 S COIT RD",  "33.222354,-96.770652",
      "980-1310 S COIT RD",  "33.222592,-96.771559",
      "980-1311 S COIT RD",  "33.222592,-96.771559",
      "980-1312 S COIT RD",  "33.222592,-96.771559",
      "980-1313 S COIT RD",  "33.222592,-96.771559",
      "980-1314 S COIT RD",  "33.222592,-96.771559",
      "980-1315 S COIT RD",  "33.222592,-96.771559",
      "980-1316 S COIT RD",  "33.222592,-96.771559",
      "980-1317 S COIT RD",  "33.222592,-96.771559",
      "980-1320 S COIT RD",  "33.222592,-96.771559",
      "980-1321 S COIT RD",  "33.222592,-96.771559",
      "980-1322 S COIT RD",  "33.222592,-96.771559",
      "980-1323 S COIT RD",  "33.222592,-96.771559",
      "980-1324 S COIT RD",  "33.222592,-96.771559",
      "980-1325 S COIT RD",  "33.222592,-96.771559",
      "980-1326 S COIT RD",  "33.222592,-96.771559",
      "980-1327 S COIT RD",  "33.222592,-96.771559",
      "980-1330 S COIT RD",  "33.222592,-96.771559",
      "980-1331 S COIT RD",  "33.222592,-96.771559",
      "980-1332 S COIT RD",  "33.222592,-96.771559",
      "980-1333 S COIT RD",  "33.222592,-96.771559",
      "980-1334 S COIT RD",  "33.222592,-96.771559",
      "980-1335 S COIT RD",  "33.222592,-96.771559",
      "980-1336 S COIT RD",  "33.222592,-96.771559",
      "980-1337 S COIT RD",  "33.222592,-96.771559",
      "980-1410 S COIT RD",  "33.22217,-96.771859",
      "980-1411 S COIT RD",  "33.22217,-96.771859",
      "980-1412 S COIT RD",  "33.22217,-96.771859",
      "980-1413 S COIT RD",  "33.22217,-96.771859",
      "980-1414 S COIT RD",  "33.22217,-96.771859",
      "980-1415 S COIT RD",  "33.22217,-96.771859",
      "980-1416 S COIT RD",  "33.22217,-96.771859",
      "980-1417 S COIT RD",  "33.22217,-96.771859",
      "980-1420 S COIT RD",  "33.22217,-96.771859",
      "980-1421 S COIT RD",  "33.22217,-96.771859",
      "980-1422 S COIT RD",  "33.22217,-96.771859",
      "980-1423 S COIT RD",  "33.22217,-96.771859",
      "980-1424 S COIT RD",  "33.22217,-96.771859",
      "980-1425 S COIT RD",  "33.22217,-96.771859",
      "980-1426 S COIT RD",  "33.22217,-96.771859",
      "980-1427 S COIT RD",  "33.22217,-96.771859",
      "980-1430 S COIT RD",  "33.22217,-96.771859",
      "980-1431 S COIT RD",  "33.22217,-96.771859",
      "980-1432 S COIT RD",  "33.22217,-96.771859",
      "980-1433 S COIT RD",  "33.22217,-96.771859",
      "980-1434 S COIT RD",  "33.22217,-96.771859",
      "980-1435 S COIT RD",  "33.22217,-96.771859",
      "980-1436 S COIT RD",  "33.22217,-96.771859",
      "980-1437 S COIT RD",  "33.22217,-96.771859"

  });
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "A O REEVES",
    "ANNIE OAKLEY",
    "ARBOR BROOK",
    "ARBOR CREEK",
    "ARBOR MANORS",
    "ARMADILLO RANCH",
    "ASH LEAF",
    "AUDIE MURPHY",
    "AUTUMN BREEZE",
    "AUTUMN HILL",
    "BALMORAL CASTLE",
    "BAT MASTERSON",
    "BEACON HILL",
    "BEAR CREEK",
    "BEAVER CREEK",
    "BELLA VISTA",
    "BELT LINE",
    "BENT GRASS",
    "BENT OAK",
    "BETHEL SCHOOL",
    "BETTYE GAYE",
    "BIG CANYON",
    "BIG DELTA",
    "BIRD FARM",
    "BLACK WALNUT",
    "BLUE SAGE",
    "BLUE STEM",
    "BOB TEDFORD",
    "BOB WHITE",
    "BOIS D ARC",
    "BOIS DE ARC",
    "BONNIE VIEW",
    "BRAMBLE BRANCH",
    "BRIAR OAK",
    "BRIMBERRY CEMETERY",
    "BRINLEE BRANCH CREEK",
    "BRINLEE CREEK RANCH",
    "BROCKDALE PARK",
    "BROKEN BEND",
    "BRUSH CREEK",
    "BRUTON ORAND",
    "BRYANT FARM",
    "BUFFALO BILL",
    "BUFFALO SPRINGS",
    "BURDEN RANCH",
    "BUSINESS PARK",
    "BUTCH CASSIDY",
    "CACTUS PATH",
    "CANYON CREEK",
    "CARRIAGE HOUSE",
    "CARTER RANCH",
    "CEDAR COVE",
    "CEDAR CREST",
    "CEDAR HILL",
    "CEDAR RIDGE",
    "CHAPEL SPRINGS",
    "CHERRY HILLS",
    "CHERRY WOOD",
    "CHIMNEY ROCK",
    "CHINN CHAPEL",
    "CHRISTIE FARMS",
    "CLEAR CREEK",
    "CLEAR HAVEN",
    "CLOVER RIDGE",
    "COLLIN GREEN",
    "COTTAGE HILL",
    "COUNTRY CLUB",
    "COUNTRY RIDGE",
    "COUNTRY TIME",
    "COUNTRY WALK",
    "COUNTY LINE",
    "COYOTE CALL",
    "CREEK CANYON",
    "CREEK VIEW",
    "CREEK WOOD",
    "CRIPPLE CREEK",
    "CROOKED STICK",
    "CROSS FENCE",
    "CROSS POST",
    "CROSS TIMBERS",
    "CROSS TRAIL",
    "CROWN COLONY",
    "CRYSTAL FALLS",
    "CYPRESS CREEK",
    "CYPRESS LEAF",
    "DEER TRACK PARK",
    "DEL CARMEN",
    "DENTON TAP",
    "DESERT CREEK",
    "DIPPING VAT",
    "DODGE OAKHURST",
    "DOGWOOD PARK",
    "DOUBLE B",
    "DOVE HILL",
    "EAST FORK",
    "EAST MAIN",
    "ECHO RIDGE",
    "EL CAMINO",
    "ELK CHASE",
    "ENGLISH IVY",
    "EVENING SUN",
    "FAIR OAKS",
    "FAIRWAY CROSSING",
    "FARR HILL",
    "FATE MAIN",
    "FLOWER MOUND",
    "FOREST CREST",
    "FOREST MEADOW",
    "FOREST OAKS",
    "FOSTER CROSSING",
    "FOUNTAIN VIEW",
    "FOUR NOTCH",
    "GARDEN RIDGE",
    "GAS HOUSE",
    "GENTLE CREEK",
    "GLEN ELLEN",
    "GLEN LAKES",
    "GLEN RIDGE",
    "GOURD CREEK CEMETERY",
    "GRANITE VALLEY",
    "GRASSY CREEK",
    "GREEN BRIAR",
    "HADLEY CREEK",
    "HANAKOA FALLS",
    "HARDY BOTTOM",
    "HARVEST HILL",
    "HAY MEADOW",
    "HAZY MEADOW",
    "HEATHER GLEN",
    "HELMOKEN FALLS",
    "HICKORY CREEK",
    "HICKORY HILL",
    "HIDDEN BROOK",
    "HIDDEN CREEK",
    "HIDDEN FALLS",
    "HIDDEN GLEN",
    "HIDDEN LAKE",
    "HIDDEN VALLEY",
    "HIGH MEADOW",
    "HIGH PLAINS",
    "HIGH POINT",
    "HIGH WILLOW",
    "HIGHLAND FAIRWAY",
    "HIGHLAND MEADOW",
    "HIGHLAND MEADOWS",
    "HIGHLAND RIDGE",
    "HIGHRIDGE FARMS",
    "HITCHING POST",
    "HOLLY LEAF",
    "HONEY CREEK",
    "HONEY LOCUST",
    "HONEY MESQUITE",
    "HORACE SMITH",
    "HUNTERS GLEN",
    "HUNTERS RIDGE",
    "HUNTERS RUN",
    "INDIAN BLANKET",
    "INDIAN ROCK",
    "J C WALKER",
    "KATE BOLDEN",
    "KINGS POINT",
    "LA CIMA",
    "LAKE FOREST",
    "LAKE PARK",
    "LAKE PLACE",
    "LAKE TRAIL",
    "LAKE VIEW",
    "LAKE WICHITA",
    "LAUREL OAK",
    "LENORARD WAY",
    "LEWIS CANYON",
    "LIGHT FARMS",
    "LINCOLN WOOD",
    "LIVE OAK",
    "LOGANS WAY",
    "LOMA ALTA",
    "LONE OAK",
    "LONE RIDGE",
    "LONE STAR",
    "LONESOME DOVE",
    "LONG PRAIRIE",
    "LONG VALLEY",
    "LONGSTREET CEMETERY",
    "LOOK OUT",
    "LOUIS DAVIS",
    "LUCAS BRANCH",
    "LUCKY 13",
    "MAPLE RIDGE",
    "MARBLE PASS",
    "MARK ALEXANDER",
    "MARTIN LUTHER KING JR",
    "MAXWELL CREEK",
    "MCCARLEY RANCH",
    "MCKAMY CREEK",
    "MEADOW CREST",
    "MEADOW GLEN",
    "MEADOW GREEN",
    "MEADOW LAKE",
    "MEADOW LARK",
    "MEADOW VIEW",
    "MEADOW VISTA",
    "MEADOW WOODS",
    "MEDICAL CENTER",
    "MEDICAL PLAZA",
    "MELISSA LANDFILL",
    "MEMORIAL HOSPITAL",
    "MILLERS CREEK",
    "MOFFETT SPRINGS",
    "MONTE CARLO",
    "MORNING VIEW",
    "MOSS CREEK",
    "MOSS GLEN",
    "MOSSY OAKS",
    "NATCHES TRACE",
    "NIAGARA FALLS",
    "NORMAL PARK",
    "NORTH GRAPEVINE MILL",
    "NORTH HILL",
    "NORTH RIDGE",
    "NORTH STAR",
    "OAK GLEN",
    "OAK GROVE",
    "OAK HOLLOW",
    "OAK PARK",
    "OAK SPRINGS",
    "OBANNON RANCH",
    "OLD CROSS TIMBERS",
    "ONE PLACE",
    "OUTER LOOP",
    "PALO DURO",
    "PALO PINTO",
    "PARK MEADOW",
    "PARK TRAILS",
    "PARK VALLEY",
    "PARKER SQUARE",
    "PAT HENRY CEMETERY",
    "PAT KELLY",
    "PAUL MICHAEL",
    "PEBBLE CREEK",
    "PECAN CREEK",
    "PECAN GROVE",
    "PECAN HOLLOW",
    "PECAN PLACE",
    "PENTON LINNS",
    "PETERS COLONY",
    "PHEASANT CREEK",
    "PHEASANT RUN",
    "PHELPS SLAB",
    "PIN OAK",
    "PINE HURST",
    "PINE KNOLL",
    "PINE RIDGE",
    "PINE SHADOWS",
    "PIONEER PARK",
    "PIONEER PATH",
    "PLYMOUTH COLONY",
    "POINT DE VUE",
    "POINT WEST",
    "PONDEROSA PINE",
    "PONY EXPRESS",
    "PORT OCONNER",
    "POST OAK",
    "PRAIRIE CREEK",
    "PRAIRIE VISTA",
    "PRESTON HILLS",
    "PRESTON LAKES",
    "PRINCETON MEADOWS",
    "PRINCETON OAKS",
    "PROSPER COMMONS",
    "PURPLE SAGE",
    "QUAIL HOLLOW",
    "QUAIL RUN",
    "QUARTER HORSE",
    "RANCH ROAD",
    "RAVEN TERRACE",
    "RAVENWOOD VILLAGE",
    "RED BUD",
    "RED OAK",
    "REMINGTON PARK",
    "RENFRO VALLEY",
    "RHEA MILLS",
    "RIDGE VIEW",
    "RIVER PLACE",
    "ROBINSON CREEK",
    "ROCK CANYON",
    "ROCK RIDGE",
    "ROLLING BROOK",
    "ROLLING HILLS",
    "ROLLING RIDGE",
    "ROUND PRAIRIE",
    "ROY ROGERS",
    "ROYAL OAK",
    "RUBY CREST",
    "RUNNING BROOK",
    "RYANS FERRY",
    "SADDLE CREEK",
    "SAINT PAUL",
    "SALMON LAKE",
    "SAM HOUSTON",
    "SAM RAYBURN",
    "SAM SLOTT",
    "SANDY LAKE",
    "SANTA FE",
    "SCALES RANCH",
    "SCENIC POINT",
    "SENTINEL OAK",
    "SETTLERS RIDGE",
    "SHADOW HILL",
    "SHADOW ROCK",
    "SHADY BEND",
    "SHADY HILL",
    "SHADY KNOLL",
    "SHADY OAKS",
    "SHADY TIMBERS",
    "SLATER CREEK",
    "SLEEPY HOLLOW",
    "SMITH ACRES",
    "SMITH HILL",
    "SPANISH OAK",
    "SPRING CIRCLE",
    "SPRING MEADOW",
    "SPRING RIDGE",
    "SPRING RUN",
    "ST CHARLES",
    "STANLEY FALLS",
    "STARK PLACE",
    "STILL FOREST",
    "STILL MEADOW",
    "STONE BEND",
    "STONE CREEK",
    "STONE TRACE",
    "SUN RIDGE",
    "SUN VALLEY",
    "SUNNY HILL",
    "SUNNY KNOLL",
    "SURREY ESTATES",
    "SURREY WOODS",
    "SWEET GUM",
    "TANUR CASCADE",
    "THE COWBOY",
    "THE CROSSINGS",
    "THOUSAND OAKS",
    "THREE RIVERS",
    "TIMBER CREEK",
    "TIMBER MEADOW",
    "TIMBER RIDGE",
    "TOLEDO BEND",
    "TOM CLEVINGER",
    "TOWN CENTER",
    "TOWNE VIEW",
    "TRAILS END",
    "TREE LINE",
    "TWIN CREEKS",
    "TWIN HILLS",
    "TWIN LAKES",
    "TWIN OAKS",
    "TWIN VALLEY",
    "VALLEY DALE",
    "VALLEY OAK",
    "VALLEY RIDGE",
    "VAN ZANDT",
    "VETERANS MEMORIAL",
    "VICK SPRING",
    "VICTORIA FALLS",
    "VILLAGE CREST",
    "VISTA VIEW",
    "WAGON WHEEL",
    "WATCH HILL",
    "WATER OAK",
    "WATERS EDGE",
    "WAVERLY CEMETERY",
    "WEST CROSSING",
    "WEST OAK",
    "WESTON CREEK",
    "WHISPERING HILLS",
    "WHISPERING MEADOWS",
    "WHITE BUD",
    "WHITE CREST",
    "WHITE OAK",
    "WHITLEY PLACE",
    "WILD ROSE",
    "WILLIS OSBURN",
    "WILLOW CREEK",
    "WILLOW PLACE",
    "WILLOW POINT",
    "WILLOW RIDGE",
    "WILLOW RUN",
    "WILLOW SPRINGS",
    "WINDING CREEK",
    "WINDING OAKS",
    "WINDING RIVER",
    "WINDSOR CENTRE",
    "WINDY KNOLL",
    "WIRE ROAD",
    "WISDOM CREEK",
    "WOLF CREEK",
    "WOOD CREEK",
    "WOOD LODGE",
    "WOODED CREEK",
    "WYATT EARP",
    "WYLIE EAST"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "10-150 MAJOR ACCIDENT",
      "1050 MAJOR",
      "1050 MINOR",
      "911 HANG UP/OPEN LINE",
      "ABDOMINAL PAIN",
      "ALARM CALL",
      "AMB",
      "AMBULANCE/EMS SERVICE",
      "ANIMAL BITE",
      "ANIMAL COMPLAINT",
      "ASSAULT",
      "ASSIST MOTORIST",
      "ASSIST PD",
      "ASSIST POLICE DEPARTMENT",
      "ATTEMPT SUICIDE",
      "ATTEMPTED SUICIDE",
      "AUDIBLE BURGLAR ALARM",
      "AUTOMATIC AID ENGINE",
      "AUTOMATIC FIRE ALARM",
      "BITE",
      "BOAT IN DISTRESS",
      "BREATHING PROBLEMS",
      "BURGLARY MOTOR VEH IN PROGRESS",
      "BURN",
      "CAR/VEHICLE FIRE",
      "CARBON MONOXIDE ALARM",
      "CARBON MONOXIDE INVESTIGATION",
      "CARDIAC ARREST",
      "CFALARM",
      "CHASE",
      "CHECK",
      "CHEMICAL FIRE",
      "CHEST PAINS",
      "CHOKING",
      "CLOSE PATROL",
      "COMERCIAL FIRE ALARM",
      "COMMERCIAL FIRE ALARM",
      "CONTROLLED BURN",
      "CONVULSIONS/SEIZURES",
      "DECEASED PERSON",
      "DDIST",
      "DIABETIC PROBLEMS",
      "DISREGARD PER FVFD",
      "DIST",
      "DISTURBANCE",
      "DOMESTIC DISTURBANCE",
      "DOMESTIC IN PROGRESS",
      "DOWN POWER LINE",
      "DOWN TREE",
      "DUMPSTER FIRE",
      "DRIVING WHILE INTOXICATED",
      "DROWNING",
      "ELECTRICAL FIRE",
      "ELEVATOR ALARM",
      "ELEVATOR RESCUE",
      "ELEVATOR RESCUE/ALARM",
      "EMERGENCY MEDICAL CALL",
      "EMERGENCY MEDICAL ALARM",
      "EMERGENCY PUBLIC ASSIST",
      "EMERGENCY WATER CUT OFF",
      "EMS",
      "EMS-NON EMERGENCY TRANSFER",
      "EMS - CARDIAC EMERGENCY",
      "EMS - INJURED PERSON",
      "EMS - PERSON FALLEN",
      "EMS - SEIZURE",
      "EMS - SICK PERSON",
      "EMS - SUICIDAL PERSON",
      "EMS - UNCONSCIOUS PERSON",
      "EMS CALL",
      "EMS CARDIAC",
      "EMS MEDICAL",
      "EMS OTHER/STANDBY/PR",
      "EMS - STROKE (CVA)",
      "EMS TRANSFER",
      "EMS TRAUMA",
      "EMSFALL",
      "ENRT TO STAGE FOR POSSIBLE MENTAL SUBJ",
      "EVENT",
      "FAIL TO LEAVE ID, ACCIDENT",
      "FALARM",
      "FALL U/6FT",
      "FD MISC. FIRE",
      "FDALMRES",
      "FDBOTTOW",
      "FDLAKE",
      "FDMUTMVA",
      "FDMUTUAL",
      "FDSTRUC",
      "FIRE ALARM",
      "FIRE OTHER",
      "FIRE PUBLIC ASSIST",
      "FIRE REPORTED OUT",
      "FIRST",
      "FIRST RESPONDERS",
      "FISRT RESPONDERS",
      "FLOODING REPORTED",
      "FOLLOW UP INVESTIGATION",
      "FUEL SPILL",
      "GFIRE",
      "GRASS FIRE",
      "GRASS/BRUSH FIRE (LOW HAZD)",
      "GRASS/WILDLAND FIRE",
      "GRASS OR BRUSH FIRE",
      "GREASE FIRE",
      "GRILL FIRE",
      "HAZARDOUS CONDITION",
      "HAZARDOUS MATERIALS",
      "HEART PROBLEMS",
      "HEMORRHAGE/LACERATIONS",
      "INJURED PERSON",
      "INJURY",
      "INTOXICATED DRIVER COMPLAINT",
      "INVESTIGATION",
      "INVESTIGATION-UNKNOWN SIT.",
      "LAKE EMERGENCY",
      "LEAK",
      "LIFT ASSIST ONLY",
      "LOCK-IN/OUT",
      "LOCKED",
      "LOCKED VEHICLE/RESIDENCE",
      "LOCKOUT",
      "LOOSE",
      "MAJOR",
      "MAJOR ACCIDENT",
      "MAJOR ACCIDENT (INJURIES)",
      "MAJOR ACCIDENT (MAJOR ROAD)",
      "MAJOR ACCIDENT 10/50",
      "MAJOR HIT AND RUN ACCIDENT",
      "MAJOR WITH EXTRICATION",
      "MINOR ACCIDENT",
      "MINOR ACCIDENT 10/50",
      "MISCELLANEOUS FIRE",
      "MISSING CHILD",
      "MEDIC CALL- COALITION",
      "MEDICAL ALARM",
      "MEDICAL EMERGENCY",
      "MEDICATION OVERDOSE",
      "MENTAL",
      "MENTAL SUBJECT",
      "MISCELLANEOUS FIRE",
      "MOTORIST ASSIST",
      "MUTUAL",
      "MUTUAL AID",
      "MUTUAL AID FIRE",
      "MUTUAL AID,FIRE/FILL IN",
      "MUTUAL AID AMB FOR MAJOR",
      "MUTUAL AID AMBULANCE",
      "MUTUAL AID BRUSH",
      "MUTUAL AID ENGINE",
      "MUTUAL AID ENGINE FILL IN",
      "MUTUAL AID ENGINE TO SCENE",
      "MUTUAL AID FOR GRASS FIRE",
      "MUTUAL AID FVFD",
      "MUTUAL AID FIRE/RESCUE REQUEST",
      "MUTUAL AID GRASS FIRE",
      "MUTUAL AID, MEDIC TO LOCATION",
      "MUTUAL AID MEDICAL CALL",
      "MUTUAL AID ON SFIRE",
      "MUTUAL AIDE REQ TENDER",
      "MUTUAL AID SFIRE",
      "MUTUAL AID STRUCTURE FIRE",
      "MUTUAL AID TRUCK TO THE SCENE",
      "MVA2",
      "NARCOTICS INVESTIGATION",
      "NATURAL / PROPANE GAS LEAK",
      "NATURAL DISASTER",
      "NATURAL GAS LEAK",
      "ODOR",
      "ODOR INSIDE STRUCTURE",
      "ODOR INVESTIGATION",
      "ODOR/SMOKE INVESTIGATION",
      "OPEN LINE",
      "OTHER CALL FOR FIRE DEPARTMENT",
      "OVERDOSE",
      "PATIENT ASSIST OR LIFT ASSIST",
      "PROPERTY PUBLIC ASSIST",
      "PUBLIC ASSIST",
      "PUBLIC ASSIST (FD)",
      "QUINT",
      "RECKLS",
      "RECKLESS DRIVER",
      "RES. SMOKE DETECTOR PROBLEM",
      "RESCUE",
      "RESCUE-TRAPED PERSON(S)",
      "RESCUE-TRAPPED PERSON(S)",
      "RESD. FIRE ALARM",
      "RESIDENTIAL FIRE ALARM",
      "RESIDENTIAL PANIC ALARM",
      "SEARCH FOR MISSING PERSON",
      "SFIRE",
      "SHOOTING",
      "SICK PERSON",
      "SMOKE",
      "SMOKE DETECTOR ALARM",
      "SMOKE INVESTIGATION",
      "SPECIAL ASSIGNMENT",
      "SPECIAL ASSIGNMENT \"SPECIFY\"",
      "SPECIAL EVENT",
      "SPECIAL HAZARD",
      "STANDBY ELECTRICAL FIRE",
      "STILL ALARM ENGINE",
      "STROKE",
      "STRUCTURE FIRE",
      "SUBJECT PASSED OUT",
      "SUICIDE THREAT",
      "SUSPICIOUS CIRCUMSTANCES",
      "TEST CALL",
      "TEST FIRE CALL",
      "TRAFFIC HAZARD",
      "TRAFIC HAZARD",
      "TRAFFIC STOP",
      "TRASH / DUMPSTER FIRE",
      "TRASH FIRE",
      "TRAUMATIC INJURIES",
      "TSUICI",
      "UFIRE",
      "UNAUTHORIZED BURN",
      "UNAUTHORZED BURN",
      "UNCONSCIOUS PERSON",
      "UNLOCK REQUEST",
      "UTILITY LINES DOWN",
      "UNATTENDED DEATH",
      "UNKNOWN MEDICAL PROBLEM",
      "UNKNOWN FIRE",
      "VEHICLE FIRE",
      "VFIRE",
      "WATER FLOW ALARM",
      "WATER FLOW ALARM, BUSN OR RESD",
      "WATER LEAK",
      "WATER RESCUE",
      "WELFARE CHECK",
      "WELFARE CONCERN"
  );
  
  private static final CodeSet DOUBLE_CITY_LIST = new CodeSet(
    "BLUE RIDGE",
    "COLLIN COUNTY",
    "COLLIN CO",
    "FIRST - 2ND PAGE",
    "FLOWER MOUND",
    "GRAYSON COUNTY",
    "GRAYSON CO",
    "HUNT COUNTY",
    "HUNT CO",
    "LITTLE ELM",
    "LOWRY CROSSING",
    "MC KINNEY",
    "NEW WAVERLY",
    "PILOT POINT",
    "ROYSE CITY",
    "SAINT PAUL",
    "ST PAUL",
    "VAN ALSTYNE",
    "WALKER COUNTY"
  );
}
