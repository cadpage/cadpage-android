package net.anei.cadpage.parsers;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo;
import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.SmsPopupUtils;

/**
 * Abstract message parser class that adds support for "smart" address parsing.
 * That is parsing logic that can be used for text formats that do not clearly 
 * deliminate where the the address portion of the message can be found. 
 *
 */
public abstract class SmartAddressParser extends SmsMsgParser {
  

  /**
   * Type code indicating what kind of information might preceed the address
   * portion of this message
   */
  public  enum StartType {START_ADDR, START_CALL, START_PLACE, START_SKIP};
  
  /**
   * Flag indicating that the start field (either CALL, PLACE, or SKIP) must
   * contain at least one token
   */
  public static final int FLAG_START_FLD_REQ = 0x0001;
  
  /**
   * Flag indicating that an @ mark will be used to mark the start of a
   * place name following the normal address instead of an address
   */
  public static final int FLAG_AT_PLACE = 0x0002;
  
  /**
   * Flag indicating that an @ mark can be used to mark either the start of
   * an address or the start of a place name following an address
   */
  public static final int FLAG_AT_BOTH = 0x0004;
  
  /**
   * Flag indicating that address should extend to end of parsed data field
   */
  public static final int FLAG_ANCHOR_END = 0x0008;
  
  /**
   * Flag indicating that status should always be calculated, even if
   * both beginning and end of the address have been identified
   */
  public static final int FLAG_CHECK_STATUS = 0x0010;
  
  /**
   * Flag indicating that the & or / between street names for an intersection
   * type address may not be present and should be implied
   */
  public static final int FLAG_IMPLIED_INTERSECT = 0x0020;
  
  /**
   * Flag indicating the presence of some kind of pad field between the
   * address proper and the city field.   The field can be retrieved later
   * with a getPadField() method
   */
  public static final int FLAG_PAD_FIELD = 0x0040;
  
  /**
   * Flag indicating that @ and AT tokens should be ignored
   */
  public static final int FLAG_IGNORE_AT = 0x0080;
  
  private Properties cityCodes = null;
  
  // Main dictionary maps words to a bitmap indicating what is important about that word
  private final Map<String, Integer> dictionary = new HashMap<String, Integer>();
  
  // Bitmask indicating dictionary word is a road suffix
  private static final int ID_ROAD_SFX = 1;
  
  // Bitmask bit indicating dictionary word is a route number prefix
  private static final int ID_ROUTE_PFX_PFX = 2;
  
  // Bitmask bit indicating dictionary word is a direction modifier
  private static final int ID_DIRECTION = 4;
  
  // Bitmask bit indicating dictionary work is an intersection connector
  private static final int ID_CONNECTOR = 8;
  
  // Bitmask bit indicating dictionary word is a cross street selector
  private static final int ID_CROSS_STREET = 0x10;
  
  // Bitmask bit indicating dictionary word is a city name/code
  private static final int ID_CITY = 0x100;
  
  // Bitmask bit indicating numeric token
  private static final int ID_NUMBER = 0x200;
  
  // Bitmask bit indicating start of multiword token
  private static final int ID_MULTIWORD = 0x400;
  
  // Bitmask bit indicating a start address marker
  private static final int ID_AT_MARKER = 0x800;
  
  // Bitmask bit indicating token had a preceding @ character
  private static final int ID_INCL_AT_MARKER = 0x1000;
  
  // Bitmask bit indicating token is an apartment selector
  private static final int ID_APPT = 0x2000;
  
  // Bitmask bit indicating token is a complete single word token
  // both this and the ID_MULTIWORD flag may be set if a token is both
  // a single complete token and the start of a multiword token
  private static final int ID_COMPLETE = 0x4000;
  
  // Bitmask bit indicating token is a route prefix that can be extended
  // by another normal route prefix
  private static final int ID_ROUTE_PFX_EXT =  0x8000;
  
  // Bitmask bit indicating token is an ambiguous road suffix
  private static final int ID_AMBIG_ROAD_SFX = 0x10000;
  
  // Bitmask bit indicatign token cannot be part of an address
  private static final int ID_NOT_ADDRESS = 0x20000;
  
  // Bitmask bit indicating token can be an alpha route or highway number
  private static final int ID_ALPHA_ROUTE = 0x40000;
  
  // Bitmask indicating dictionary word is either a route number prefix or a
  // route prefix extender
  private static final int ID_ROUTE_PFX = ID_ROUTE_PFX_PFX | ID_ROUTE_PFX_EXT;
  
  private static final Pattern PAT_HOUSE_NUMBER = Pattern.compile("\\d+(?:-\\d+)?(?:-?[A-Z])?");
  
  // List of multiple word cities that need to be converted to and from single tokens
  List<String[]> mWordCities = null;
  
  public SmartAddressParser(String[] cities, String defCity, String defState) {
    this(defCity, defState);
    setupCities(cities);
  }
  
  public SmartAddressParser(Properties cityCodes, String defCity, String defState) {
    this(defCity, defState);
    if (cityCodes != null) setupCities(getKeywords(cityCodes));
    this.cityCodes = cityCodes;
  }
  
  public SmartAddressParser(String defCity, String defState) {
    super(defCity, defState);
    setupDictionary(ID_ROAD_SFX, 
        "AVENUE", "AV", "AVE", 
        "STREET", "ST", 
        "PLACE", "PL", 
        "ROAD", "RD", 
        "LANE", "LN",
        "DRIVE", "DR",
        "SQUARE", "SQ",
        "BLVD", "BL", "BLV",
        "WAY", "PKWY", "PKY", "PK", "FWY", "WY", "HW", "EXPW", "PW",
        "CIRCLE", "CIR",
        "TRAIL", "TRL", "TR",
        "PATH",
        "PIKE",
        "COURT", "CT",
        "TER", "TERR",
        "HWY",
        "MALL",
        "GTWY", "GATEWAY",
        "PLAZ", "PLAZA",
        "TURNPIKE", "TPKE", "TPK",
        "PASS",
        "EST",
        "RUN",
        "GRN",
        "LOOP");
    
    setupDictionary(ID_AMBIG_ROAD_SFX, 
        "PLACE", "TRAIL", "PATH", "PIKE", "COURT", "MALL", "TURNPIKE", "PASS", "RUN", "LANE");
        
    setupDictionary(ID_ROUTE_PFX_EXT, "RT", "RTE", "ROUTE", "HW", "HWY", "HIGHWAY", "ROAD", "RD");
    setupDictionary(ID_ROUTE_PFX_PFX, "STATE", "ST", "SR", "SRT", "US", "FS", "INTERSTATE", "I", "STHWY", "USHWY", "CO", "CR", "COUNTY");
    setupDictionary(ID_ROUTE_PFX_PFX, new String[]{defState});
    setupDictionary(ID_DIRECTION, "N", "NE", "E", "SE", "S", "SW", "W", "NW", "NB", "EB", "SB", "WB", "EXT");
    setupDictionary(ID_CONNECTOR, "AND", "/", "&");
    setupDictionary(ID_AT_MARKER, "AT", "@");
    
    // C/S should be in this list, but it gets changed before we parse stuff
    setupDictionary(ID_CROSS_STREET, "XS:", "X:");
    setupDictionary(ID_APPT, "APT:", "APT", "#", "SP");
  }
  
  /**
   * Add full length names of directions to direction dictionary tables
   */
  protected void addExtendedDirections() {
    setupDictionary(ID_DIRECTION, "NORTH", "SOUTH", "EAST", "WEST");
  }
  
  private String[] getKeywords(Properties table) {
    String[] result = new String[table.size()];
    int ndx = 0;
    for (Enumeration<?> e = table.propertyNames(); e.hasMoreElements(); ) {
      result[ndx++] = (String)e.nextElement();
    }
    return result;
  }
  
  private void setupCities(String[] cities) {

    // Run thorough the city list
    for (String city : cities) {
      
      // If city name contains a blank, things get complicated
      if (city.contains(" ")) {
        
        // Break up city name into token list and add it to mWordCities
        if (mWordCities == null) mWordCities = new ArrayList<String[]>();
        String[] tokenList = city.split(" +");
        mWordCities.add(tokenList);
        
        // And add the first token to the dictionary as an incomplete city
        setupDictionary(ID_CITY | ID_MULTIWORD, tokenList[0]);
      }
      
      // Otherwise, we just add this to dictionary as a normal city
      else {
        setupDictionary(ID_CITY | ID_COMPLETE, city);
      }
    }
  }
  
  private void setupDictionary(int bitMask, String ... args) {
    for (String arg : args) {
      int newMask = bitMask;
      Integer oldMask = dictionary.get(arg);
      if (oldMask != null) newMask |= oldMask;
      dictionary.put(arg, newMask);
    }
  }
  
  
  // Parser working variables
  private int flags;
  private String[] tokens;
  private int[] tokenType;
  private int lastCity = -1;
  private int startNdx = 0;
  
  // Have to save last result for backward compatibility with some calls
  private Result lastResult = null;
  
  /**
   * Determine if a string looks like a valid address
   * @param address Address string to be checked
   * @return zero if string is not recognized as valid address, otherwise a
   * numeric value in which higher values indicate better addresses
   */
  protected int checkAddress(String address) {
    return checkAddress(address, 0);
  }
  
  /**
   * Determine if a string looks like a valid address
   * @param address Address string to be checked
   * @param extra number of extra tokens (presumably city names) that can
   * be ignored at the end of the line
   * @return zero if string is not recognized as valid address, otherwise a
   * numeric value in which higher values indicate better addresses
   */
  protected int checkAddress(String address, int extra) {
    return parseAddress(StartType.START_ADDR, 0, address).getStatus(extra);
  }

  /**
   * Parse address line
   * @param sType indicates what we now about start of address field
   *         START_ADDR - field starts with the address
   *         START_CALL - field starts with call description followed by address
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
   * @param address address field to be parsed
   * @param data data object to be filled with information from parsed address field.
   */
  protected void parseAddress(StartType sType, String address, SmsMsgInfo.Data data) {
    parseAddress(sType, 0, address, data);
  }

  /**
   * Parse address line
   * @param sType indicates what we now about start of address field
   *         START_ADDR - field starts with the address
   *         START_CALL - field starts with call description followed by address
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
   * @param flags - Special processing flags                     
   * @param address address field to be parsed
   * @param data data object to be filled with information from parsed address field.
   */
  protected void parseAddress(StartType sType, int flags, String address, SmsMsgInfo.Data data) {
    Result result = parseAddress(sType, flags, address);
    result.getData(data);
  }
  
  
  /**
   * Determine if the string that we just parsed looks like an address
   * @return zero if string was not recognized as valid address, otherwise a
   * numeric value in which higher values indicate better addresses
   */
  protected int getStatus() {
    return lastResult.getStatus();
  }
  
  /**
   * parse address and return a result object that can be used to build
   * the parsed data fields at a later time
   * @param sType indicates what we now about start of address field
   *         START_ADDR - field starts with the address
   *         START_CALL - field starts with call description followed by address
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
   * @param flags - Special processing flags                     
   * @param address address field to be parsed
   * @return integer indicating how good this address is, higher number mean better fit
   */
  protected Result parseAddress(StartType sType, String address) {
    return parseAddress(sType, 0, address);
  }
  
  /**
   * parse address and return a result object that can be used to build
   * the parsed data fields at a later time
   * @param sType indicates what we now about start of address field
   *         START_ADDR - field starts with the address
   *         START_CALL - field starts with call description followed by address
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
   * @param flags - Special processing flags                     
   * @param address address field to be parsed
   * @return integer indicating how good this address is, higher number mean better fit
   */
  protected Result parseAddress(StartType sType, int flags, String address) {

    this.flags = flags;
    lastCity = -1;
    Result result = new Result();
    lastResult = result;
    
    result.startType = sType;
    
    // Before we do anything else, see if we can find some GPS coordinates
    // in this address.  If we do find them, pack them so they will parse
    // into a single token
    String gpsCoords = null;
    Matcher match = SmsPopupUtils.GPSPattern.matcher(address);
    if (match.find()) {
      gpsCoords = match.group(1) + ',' + match.group(2); 
      address = address.substring(0, match.start()) + gpsCoords 
                  + address.substring(match.end());
    }

    // We have a lot of pre parsing adjustments that must be made to normal
    // address strings, but get skipped if we have already identified this
    // as a GSP coordinate address
    else {
      
      // Make sure any / or & character will parse by itself
      // Before we do that we have to protect the C/S cross street indicator
      // Another disaster that needs to be prevented is breaking up AT&T into
      // AT and an &
      boolean att = address.contains("AT&T");
      if (att) address = address.replaceAll("AT&T", "AT%T");
      address = address.replaceAll(" C/S:? ", " XS: ").replace("/", " / ").replace("&", " & ").trim();
      if (att) address = address.replaceAll("AT%T", "AT&T");
      
      // Make sure any colon keyword parsers by itself
      address = address.replaceAll(":", ": ");
      
      // Periods used with abbreviations also cause trouble.  Just get rid of all periods
      address = address.replace(".", "");
    }

    // Check for null string
    result.status = 0;
    address = address.trim();
    if (address.length() == 0) return result;

    // Set up token list and types
    setTokenTypes(sType, address, result);
    
    // Save tokens in result object
    result.tokens = tokens;
    
    // Now comes the hard part.
    
    // We have a number of basic patters that we will recognize
    // Try each one until we find one that works
    result.status = 4;
    if (parseTrivialAddress(result)) return result;
    if (parseGPSCoords(result, gpsCoords)) return result;
    result.status = 3;
    if (parseSimpleAddress(result)) return result;
    result.status = 2;
    if (parseIntersection(result)) return result;
    result.status = 1;
    if (parseNakedRoad(result)) {
      // If the naked road pattern detected an implied intersection symbol
      // promote the result status to intersection
      if (result.insertAmp >= 0) result.status++; 
      return result;
    }
    
    // If all else fails, use the fallback parser
    parseFallback(sType, result);
    result.status = 0;
    return result;
  }

  /**
   * Called after address has been parsed with FLAG_PAD_FIELD flag
   * @return pad field between address and city
   */
  public String getPadField() {
    return lastResult.getPadField();
  }

  /**
   * Called after address has been parsed
   * @return the part of the line after the address
   */
  public String getLeft() {
    return lastResult.getLeft();
  }
  
  /**
   * We handle the dead simple case where the address starts at the 
   * beginning of the text and we have found a city to mark the end
   * of the address (would that life were always this simple
   */
  private boolean parseTrivialAddress(Result result) {
    
    // If caller has locked both ends of the address, and wants an address status
    // Or we are supposed to insert implied intersection symbols
    // Or we should parse out a pad field
    // then return failure status so one of the other address parsers can make
    // some kind of reasonableness check on this
    if (isFlagSet(FLAG_CHECK_STATUS|FLAG_IMPLIED_INTERSECT|FLAG_PAD_FIELD)) return false;
    
    // OK, we have to have at least 2 items before the city
    if (result.startAddress < 0) return false;
    return parseToCity(result.startAddress, result.startAddress+2, result);
  }

  /**
   * Handle special case where the prospective address contains a token
   * that contains valid GPS coordinates
   */
  private boolean parseGPSCoords(Result result, String gpsCoords) {
    
    // If no GPS coordinates were found, return false
    if (gpsCoords == null) return false;
    
    // We have already packed the GPS coordinates into a single token
    // now find that token
    int gpsNdx = 0;
    for (; gpsNdx < tokens.length; gpsNdx++) {
      if (tokens[gpsNdx].contains(gpsCoords)) break;
    }
    if (gpsNdx >= tokens.length) throw new RuntimeException("GPS coordinates not found");

    // Expand address to beginning or end of token string if required by
    // constraints
    result.startAddress = result.initAddress = 
      (result.startType == StartType.START_ADDR ? 0 : gpsNdx);
    result.endAll = (isFlagSet(FLAG_ANCHOR_END) ? tokens.length : gpsNdx+1);
    return true;
  }

  /**
   * Look for the basic address looking like
   *     <number> <street name> <street suffix>
   */
  private boolean parseSimpleAddress(Result result) {
    
    boolean padField = isFlagSet(FLAG_PAD_FIELD);
    
    // Look for a numeric field which we assume is the house number
    // If field starts with address this has to be the first token
    // Exception, numeric fields that follow a route prefix are part
    // of a road name and cannot be a house number.
    // Exception to exception, CO is a valid route prefix, but it could also
    // be an abbreviation for COMPANY in a prefix name.  So we won't count it
    // as a route prefix
    int sAddr = result.startAddress >= 0 ? result.startAddress : startNdx;
    int sEnd;
    boolean flexAt = isFlagSet(FLAG_AT_BOTH);
    boolean locked = false;
    while (true) {
      while (true) {
        
        if (sAddr >= tokens.length) return false;
        if (isType(sAddr, ID_CROSS_STREET)) return false;
        if (isHouseNumber(sAddr)) {
          if (sAddr > 0 && isType(sAddr-1, ID_ROUTE_PFX) && 
              !tokens[sAddr-1].equalsIgnoreCase("CO")) return false;
          break;
        }
        if (result.startAddress >= 0 || locked) return false;
        if (flexAt && isType(sAddr, ID_INCL_AT_MARKER)) return false;
        sAddr++;
        if (flexAt && isType(sAddr, ID_AT_MARKER)) locked = true;
      }
      
      // If we found a city beyond this start point, just use that as the terminator
      if (! padField && parseToCity(sAddr, sAddr+2, result)) {
        if (locked) result.initAddress--;
        return true;
      }
      
      // Otherwise, see if we can find a road starting from the next token
      sEnd = findRoadEnd(sAddr+1);
      if (sEnd > 0) break;
      
      // This isn't what we are looking for
      // Increment the search index and look for something else
      sAddr++;
    }
    
    // We have found what we need to have found and we are going
    // to be successful
    if (result.startAddress < 0) result.initAddress = result.startAddress = sAddr;
    if (locked) result.initAddress--;
    result.endAll = sEnd;
    
    // Special case - simple address can have intersection marker followed by
    // cross stream info
    if (isType(sEnd, ID_CONNECTOR)) {
      findCrossStreetEnd(sEnd + 1, result);
    }
    
    // But there might be some additional cross street info we can parse
    findCrossStreet(result);
    
    // If we are looking for a pad field between the address and city
    // now is when we try to find that city
    if (padField) {
      result.startPad = result.endAll;
      parseToCity(result.startAddress, result.endAll, result);
    }
    return (result.endAll == tokens.length || !isFlagSet(FLAG_ANCHOR_END));
  }

  /**
   * Look for intersection adddress with the basic form of
   *    <roadname> <road sfx> <connector> <roadname> <road sfx>
   * @return true if successful
   */
  private boolean parseIntersection(Result result) {
    
    boolean padField = isFlagSet(FLAG_PAD_FIELD);
    
    // First lets figure out where the address starts
    int sAddr;
    int ndx;
    
    boolean flexAt = isFlagSet(FLAG_AT_BOTH);
    boolean atStart = false;

    // If address starts at beginning of field, find end of address and
    // confirm that it starts with a road followed by a connector
    if (result.startAddress >= 0) {
      ndx = startIntersection(result.startAddress);;
      if (ndx < 0) return false;
      sAddr = result.startAddress;
    }
    
    // Otherwise, scan forward looking for a <road-sfx> <connector> combination
    // Then back up 2 places assuming the road consists of one token.
    // If the previous token is a direction, back up one more to include that.
    else {
      int start = startNdx;
      ndx = start;
      while (true) {
        if (flexAt && isType(ndx, ID_AT_MARKER)) atStart = true;
        ndx++;
        if (ndx >= tokens.length) return false;
        if (isType(ndx, ID_CROSS_STREET)) return false;

        if (atStart || flexAt && isType(ndx, ID_INCL_AT_MARKER)) {
          sAddr = ndx;
          ndx = startIntersection(sAddr);;
          if (ndx < 0) return false;
          break;
        }
        if (ndx-start >= 1 && isType(ndx, ID_CONNECTOR)) {
          sAddr = ndx-1;
          if (isType(sAddr, ID_DIRECTION)) sAddr--;
          
          if (sAddr >= start && isRoadToken(sAddr)) break;
          
          if (sAddr > start && !isType(sAddr-1,ID_NOT_ADDRESS)) { 
            sAddr--;
            if (isType(sAddr+1, ID_ROAD_SFX)) {
              if (sAddr > start && isType(sAddr, ID_AMBIG_ROAD_SFX)) sAddr--;
              break;
            }
            if (isType(sAddr, ID_ROUTE_PFX) & isType(sAddr+1, ID_NUMBER | ID_ALPHA_ROUTE)) {
              if (sAddr > start && 
                  isType(sAddr, ID_ROUTE_PFX_EXT) && 
                  isType(sAddr-1, ID_ROUTE_PFX_PFX)) sAddr--;
              break;
            }
          }
        }
      }
      
      // If road is preceded by a direction, include that
      sAddr = stretchRoadPrefix(start, sAddr);
    }
    
    // When we get here, 
    // saddr points to beginning of address
    // ndx points to the first connector after the first road name.

    // If there is a city terminating the address, just parse up to it
    if (!padField && parseToCity(sAddr, ndx+2, result)) {
      result.initAddress = result.startAddress = sAddr;
      if (atStart) result.initAddress--;
      return true;
    }
    
    // Otherwise find end of second road
    ndx = findRoadEnd(ndx+1);
    if (ndx < 0) return false;
    
    // If we found that, we have a successful intersection parse
    if (result.startAddress < 0) { 
      result.initAddress = result.startAddress = sAddr;
      if (atStart) result.initAddress--;
    }
    result.endAll = ndx;
    
    // But there might be some additional cross street info we can parse
    findCrossStreet(result);
    
    // If we are looking for a pad field between the address and city
    // now is when we try to find that city
    if (padField) {
      result.startPad = result.endAll;
      parseToCity(result.startAddress, result.endAll, result);
    }

    return (result.endAll == tokens.length || !isFlagSet(FLAG_ANCHOR_END));
  }
  
  /**
   * Try to parse first part intersection starting at specified index
   * @param sAddr starting index
   * @return index of connector if successful, otherwise -1
   */
  private int startIntersection(int sAddr) {
    int ndx = findRoadEnd(sAddr);
    if (ndx < 0) return -1;
    if (! isType(ndx, ID_CONNECTOR)) return -1;
    return ndx;
  }

  /**
   * Look for simple road without a house number or intersection
   *    <roadname> <roadsfx>
   * @return true if found 
   */
  private boolean parseNakedRoad(Result result) {

    int ndx;
    
    boolean flexAt = isFlagSet(FLAG_AT_BOTH);
    boolean atStart = false;
    boolean padField = isFlagSet(FLAG_PAD_FIELD);

    // If address starts at beginning of field, find end of address and
    // Don't have to look for city because we wouldn't be here if both startAddr
    // and city was found
    if (result.startAddress >= 0) {
      ndx = findRoadEnd(result.startAddress);
      if (ndx < 0) return false;
    }
    
    // Otherwise, scan forward looking for a <road-sfx>
    //            that isn't the start of a <route-pfx> <number> combination
    // or number preceded by a <route-pfx>
    // or an ambiguous <road-sfx> followed by a second <road-sfx>
    else {
      int start = startNdx;
      ndx = start;
      int sAddr;
      while (true) {
        if (flexAt && isType(ndx, ID_AT_MARKER)) atStart = true;
        ndx++;
        sAddr = ndx - 1;
        if (ndx >= tokens.length) return false;
        if (isType(ndx, ID_CROSS_STREET)) return false;
        if (atStart || flexAt && isType(ndx, ID_INCL_AT_MARKER)) {
          sAddr = ndx;
          ndx = findRoadEnd(sAddr);
          ndx--;
          if (ndx < 0) return false;
          break;
        }
        
        if (isType(ndx, ID_ROAD_SFX) && !isType(sAddr, ID_NOT_ADDRESS)) {
          boolean startHwy = 
              (isType(ndx, ID_ROUTE_PFX) && isType(ndx+1, ID_NUMBER | ID_ALPHA_ROUTE)) ||
              (isType(ndx, ID_ROUTE_PFX_PFX) && isType(ndx+1, ID_ROUTE_PFX_EXT) && isType(ndx+2, ID_NUMBER)) ||
              (isType(ndx, ID_AMBIG_ROAD_SFX) && (isType(ndx+1, ID_ROAD_SFX)));
          
          if (!startHwy) break; 
        }
        if (ndx > start && isType(ndx, ID_NUMBER | ID_ALPHA_ROUTE) && isType(ndx-1, ID_ROUTE_PFX)) break;
        if (isRoadToken(ndx)) {
          sAddr = ndx;
          break;
        }
      }
      
      // See if this is a two part route name
      if (sAddr > 0 &&
          (isType(sAddr, ID_ROUTE_PFX_EXT) && isType(sAddr-1, ID_ROUTE_PFX_PFX) ||
           isType(sAddr, ID_AMBIG_ROAD_SFX))) {
        sAddr--;
      }

      // If the previous token is a direction, back up one more to include that.
      sAddr = stretchRoadPrefix(start, sAddr);
      
      // increment end pointer past the road terminator
      // If the following token is a direction, increment end pointer past that too
      ndx++;
      if (isType(ndx, ID_DIRECTION)) ndx++;
      result.initAddress = result.startAddress = sAddr;
      if (atStart) result.initAddress--;
    }
    
    // When we get here, 
    // startAddress points to beginning of address
    // ndx points past the end of the road
    
    // We have a naked road parse
    result.endAll = ndx;
    
    // If we are looking for implied interestection markers see if we can
    // find another street name immediately following this one.  If we can
    // then set the implied & colum to the end of the first street and set
    // the end of the address field to the end of the second street.
    if (isFlagSet(FLAG_IMPLIED_INTERSECT)) {
      ndx = findRoadEnd(ndx);
      if (ndx >= 0) {
        result.insertAmp = result.endAll;
        result.endAll = ndx;
        
        // A direction token between the two streets is ambiguous.  The
        // initial road parsing logic would have assigned it to the first road
        // If we find that the first road ends with a direction, but the second
        // road does not, then reassign the direction token from the end of the
        // first road to the beginning of the second
        if (isType(result.insertAmp-1, ID_DIRECTION) &&
            !isType(result.endAll-1, ID_DIRECTION)) result.insertAmp--;
      }
    }
    
    // See if we can parse out to a city
    if (!padField && parseToCity(result.startAddress, result.endAll, result)) return true;
    
    // Nope, see if we can find some cross street info
    findCrossStreet(result);
    
    // If we are looking for a pad field between the address and city
    // now is when we try to find that city
    if (padField) {
      result.startPad = result.endAll;
      parseToCity(result.startAddress, result.endAll, result);
    }

    return (result.endAll == tokens.length || !isFlagSet(FLAG_ANCHOR_END));
  }

  /**
   * Fallback parser used when nothing else works
   * @param sType
   */
  private void parseFallback(StartType sType, Result result) {
    
    // Total failure, assign the entire field to either the call description
    // or the address
    int endAddr = result.endAll = result.tokens.length;
    
    // Check for any invalid tokens.  If we find any they mark the end of any
    // possible address
    if (!isFlagSet(FLAG_ANCHOR_END)) {
      for (int ndx = 0; ndx < endAddr; ndx++) {
        if (isType(ndx, ID_NOT_ADDRESS)) {
          endAddr = result.endAll = ndx;
          break;
        }
      }
    }
    
    // If there is a cross street indicator, use it to set up the cross street
    for (int ndx = 0; ndx<endAddr; ndx++) {
      if (isType(ndx, ID_CROSS_STREET)) {
        result.startCross = ndx + 1;
        endAddr = ndx;
      }
    }
    
    // if @ is used as a fixed start address marker (default operation)
    // then we would have used one to set startAddress and no longer need
    // to worry about it
    
    // If @ is being used as an Optional start address marker, startAddress
    // would not be set and we have to look through the token string to
    // see if we find a @ marker
    int stIndex = (isFlagSet(FLAG_START_FLD_REQ) ? 1 : 0);
    if (result.startAddress < 0 && isFlagSet(FLAG_AT_BOTH)) {
      for (int ndx = stIndex; ndx < endAddr; ndx++) {
        if (isType(ndx, ID_AT_MARKER)) {
          result.initAddress = ndx;
          result.startAddress = ndx+1;
          break;
        } else if (isType(ndx, ID_INCL_AT_MARKER)) {
          result.initAddress = result.startAddress = ndx;
          break;
        }
      }
    }
    
    // We are really getting desperate, but see if there is a valid house number
    // in here, and if there is set the start address to it
    if (result.startAddress < 0) {
      for (int ndx = stIndex; ndx < endAddr-1; ndx++) {
        if (isHouseNumber(ndx)) {
          result.initAddress = result.startAddress = ndx;
          break;
        }
      }
    }
    
    // If we found a flexable @ to start the address, see if we can parse
    // to an ending city
    if (result.startAddress >= 0) {
      if (parseToCity(result.startAddress, result.startAddress+2, result)) return;
    }
    
    // If we still don't have an start address, assign the entire line
    // to whatever the prefix would be assigned as.  If prefix was being
    // skipped or there is no prefix, assign everything to the address
    if (result.startAddress < 0) {
      if (sType == StartType.START_CALL || sType == StartType.START_PLACE) {
        result.initAddress = result.startAddress = endAddr;
      } else {
        result.initAddress = result.startAddress = 0;
      }
    }
    
    // We aren't done yet.
    // if @ are being used to mark a place name, see if we can find one
    // in what we have for an address and split the rest into a place name
    if (isFlagSet(FLAG_AT_BOTH | FLAG_AT_PLACE)) {
      for (int ndx = result.startAddress+1; ndx<endAddr; ndx++) {
        if (isType(ndx, ID_AT_MARKER)) {
          result.initPlace = ndx;
          result.startPlace = ndx+1;
          break;
        } else if (isType(ndx, ID_INCL_AT_MARKER)) {
          result.initPlace = result.startPlace = ndx;
          break;
        }
      }
    }
  }
  
  /**
   * Called when we found the end of a road name and are guessing at where
   * it might start
   * @param start Hard limit on where address can start
   * @param sAddr index of current start of tentative road name
   * @return index of presumed road name
   */
  private int stretchRoadPrefix(int start, int sAddr) {
    
    // Look up to 3 tokens back to see if we find a direction token
    // Stop search if we encounter a /, lest we confuse a W/INJURY
    // as part of a road name
    for (int j = 1; j<= 3; j++) {
      int ndx = sAddr - j;
      if (ndx < start) break;
      if (tokens[ndx].equals("/")) break;
      if (isType(ndx, ID_NOT_ADDRESS)) break;
      if (isType(ndx, ID_DIRECTION)) return sAddr-j; 
    }
    return sAddr;
  }
  
  /**
   * See if we can parse an address from a known starting point to a city
   * @param stNdx known start of address
   * @param srcNdx start looking for city here
   * @return true if successful
   */
  private boolean parseToCity(int stNdx, int srcNdx, Result result) {
    
    // If FLAG_ANCHOR_END is set, we are going to parse this to the
    // end of the line without looking for a city
    boolean anchorEnd = isFlagSet(FLAG_ANCHOR_END);
    boolean parseToEnd = anchorEnd & ! isFlagSet(FLAG_CHECK_STATUS);
    boolean padField = isFlagSet(FLAG_PAD_FIELD);

    if (srcNdx >= tokens.length) return false;
    if (!parseToEnd && lastCity < srcNdx) return false;
    
    boolean flexAt = isFlagSet(FLAG_AT_PLACE | FLAG_AT_BOTH);
    
    int inApt = -1;
    int stApt = -1;
    int inPlace = -1;
    int stPlace = -1;
    int stCross = -1;
    
    for (int ndx = srcNdx; ndx < tokens.length; ndx++) {
      
      // Only check for fun stuff if it isn't inside a pad field
      if (!padField) {
        
        if (isType(ndx, ID_NOT_ADDRESS)) return false;
        
        // Check for place name
        if (flexAt && stApt < 0 && stCross < 0) {
          if (isType(ndx, ID_AT_MARKER)) {
            inPlace = ndx;
            stPlace = ndx+1;
          } else if (isType(ndx, ID_INCL_AT_MARKER)) {
            inPlace = stPlace = ndx;
          }
        }
        
        // Check for apartment marker
        if (stCross < 0) {
          if (isType(ndx, ID_APPT)) {
            inApt = ndx;
            stApt = ndx + 1;
          }
          else if (tokens[ndx].startsWith("#")) {
            inApt = stApt = ndx;
          }
        }
        
        
        // Check for cross street marker
        if (isType(ndx, ID_CROSS_STREET)) stCross = ndx + 1;
      }
      
      // Is there a city here?
      int endCity = findEndCity(ndx);
      if (endCity >= 0) {
        if (!anchorEnd || endCity == tokens.length) {
          if (result.startAddress < 0) result.initAddress = result.startAddress = stNdx;
          result.initPlace = inPlace;
          result.startPlace = stPlace;
          result.initApt = inApt;
          result.startApt = stApt;
          result.startCross = stCross;
          result.startCity = ndx;
          result.endAll = endCity;
          return true;
        }
      }
    }
    
    // If we are parsing to end of field, return successful status
    if (parseToEnd) {
      if (result.startAddress < 0) result.initAddress = result.startAddress = stNdx;
      result.initPlace = inPlace;
      result.startPlace = stPlace;
      result.initApt = inApt;
      result.startApt = stApt;
      result.startCross = stCross;
      result.endAll = tokens.length;
      return true;
    }
    return false;
  }
  
  /**
   * Find the end of a city that starts at the current index
   * @param ndx current index
   * @return one past the last token in city if city was found,
   * -1 if this is not a city.
   */
  private int findEndCity(int ndx) {
    
    // If this isn't a city or city start the answer is no
    if (! isType(ndx, ID_CITY)) return -1;
    
    // If there is a road suffix in one of the following two tokens, this
    // must be one of those accursed streets including the city name, but not
    // the city
    if (isType(ndx+1, ID_ROAD_SFX) || isType(ndx+2, ID_ROAD_SFX)) return -1;
    
    // If this is the start of a multi-word city, see if
    // we find a match in the muti-word city list
    // If there are multiple matches, pick the longest
    int endNdx = -1;
    if (isType(ndx, ID_MULTIWORD)) {
      for (String[] tokenList : mWordCities) {
        boolean match = true;
        for (int j = 0; j< tokenList.length; j++) {
          if (ndx+j >= tokens.length ||
              ! tokenList[j].equalsIgnoreCase(tokens[ndx+j])) {
            match = false;
            break;
          }
        }
        if (match) {
          int tmp = ndx + tokenList.length;
          if (tmp > endNdx) endNdx = tmp;
        }
      }
    }

    // If we didn't find a multi-word city see if this token is
    // a singleword city
    if (endNdx < 0 && isType(ndx, ID_COMPLETE)) {
      endNdx = ndx + 1;
    }
    
    // If we did find a city, check to make sure it isn't followed by
    // a road suffix before we return it's end
    if (endNdx >= 0 && isType(endNdx, ID_ROAD_SFX)) return -1;
    return endNdx;
  }

  /**
   * See if we can find some additional cross street information after
   * the end of a successfully parsed address
   */
  private void findCrossStreet(Result result) {
    
    if (result.endAll >= tokens.length) return;
    
    // check for optional place marker
    if (isFlagSet(FLAG_AT_PLACE | FLAG_AT_BOTH)) {
      if (isType(result.endAll, ID_AT_MARKER)) {
        result.initPlace = result.endAll++;
        result.startPlace = result.endAll;
      }
      else if (isType(result.endAll, ID_INCL_AT_MARKER)) {
        result.initPlace = result.startPlace = result.endAll;
      }
      
      // Alas, we don't have any way to guess at how long the place name
      // might be.  Default to one word, unless we find another marker
      // further down the road
      if (result.startPlace >= 0) {
        result.endAll++;
        for (int ndx = result.endAll; ndx < tokens.length; ndx++) {
          if (isType(result.endAll, ID_NOT_ADDRESS)) break;
          if (isType(ndx, ID_APPT | ID_CROSS_STREET) ||
              isAptToken(ndx)) {
            result.endAll = ndx;
            break;
          }
        }
      }
    }
    
    // First lets look for an apartment
    if (isType(result.endAll, ID_APPT)) {
      result.initApt = result.endAll++;
      result.startApt = result.endAll++;
      if (result.endAll > tokens.length) result.endAll = tokens.length;
    }
    
    else if (isAptToken(result.endAll)) {
      result.initApt = result.startApt = result.endAll++;
    }
    
    // Now see if we are at a cross street indicator.  If not, nothing to find
    if (! isType(result.endAll, ID_CROSS_STREET)) return;
    
    findCrossStreetEnd(result.endAll+1, result);
  }

  /**
   * Locate end of cross street field
   * @param sCross
   * @param result
   */
  private void findCrossStreetEnd(int sCross, Result result) {

    int sEnd = sCross;
    
    while (true) {
      
      // And try to find another road
      sEnd = findRoadEnd(sEnd);
      if (sEnd < 0) break;
      
      // Success, save the cross street location
      result.startCross = sCross;
      result.endAll = sEnd;
      
      // If this road was terminated by a connector
      // Loop back and see if we can find another cross street
      if (!isType(sEnd, ID_CONNECTOR)) break;
      sEnd++;
    }
  }

  /**
   * See if we can identify a road name starting at a given index
   * @param start starting index
   * @return index of token past end of road name if successful, -1 otherwise
   */
  private int findRoadEnd(int start) {
    
    // If this starts with a street direction, skip over it
    if (isType(start, ID_DIRECTION)) start++;
    
    // Dummy loop that we can break out of when we find a road end
    int end;
    do {
      
      if (isType(start, ID_NOT_ADDRESS)) return -1;
      
      // A stand alone road token can terminate the road search, but it must
      // be the first thing in the search sequence
      if (isRoadToken(start)) {
        end = start+1;
        break;
      }
      
      // See if this is a numbered highway
      if (isType(start, ID_ROUTE_PFX)) {
        end = start + 1;
        if (isType(start, ID_ROUTE_PFX_PFX) && isType(start+1, ID_ROUTE_PFX_EXT)) end++;
        if (isType(end, ID_NUMBER | ID_ALPHA_ROUTE)) {
          end++;
          break;
        }
      }
      
      // Still no luck,
      // start looking for a street suffix (or cross street indicator
      // If we have to pass more than two tokens before finding, give up
      end = start;
      boolean good = false;
      while (++end - start <= 3) {

        good = true;
        if (isType(end, ID_ROAD_SFX) &&
            (! (isType(end, ID_AMBIG_ROAD_SFX) && isType(end+1, ID_ROAD_SFX)))) {
          end++; 
          break; 
        }
        if (isType(end, ID_CROSS_STREET)) break;
        
        // A number preceded by a route prefix counts as a road
        if (isType(end, ID_NUMBER) && end > 0 && isType(end-1, ID_ROUTE_PFX)) {end++; break;}
        good = false;
      }
      
      if (!good) return -1;
      
    } while (false);
    
    // If road is followed by a direction, include that
    if (isType(end, ID_DIRECTION)) end++;
    return end;
  }

  private void setTokenTypes(StartType sType, String address, Result result) {
    // Parse line into tokens and categorize each token
    // While we are doing this, identify the index of the last city
    // And see if we have a keyword flagging the start of the address
    lastCity = -1;
    startNdx = isFlagSet(FLAG_START_FLD_REQ) ? 1 : 0;
    result.tokens = tokens = address.split("\\s+");
    tokenType = new int[tokens.length];
    boolean flexAt = isFlagSet(FLAG_AT_PLACE | FLAG_AT_BOTH);
    boolean ignoreAt = isFlagSet(FLAG_IGNORE_AT);
    
    result.initAddress = result.startAddress = (sType == StartType.START_ADDR? 0 : -1);
    boolean setStart = (result.startAddress < 0 || flexAt);
    boolean pastAddr = false; 
    for (int ndx = 0; ndx < tokens.length; ndx++) {
      setType(ndx, setStart, pastAddr);
      if (isType(ndx, ID_CROSS_STREET | ID_APPT)) {
        pastAddr = true;
        setStart = false;
      }
      if (setStart && !flexAt && !ignoreAt) {
        if (isType(ndx, ID_AT_MARKER)) {
          result.initAddress = ndx;
          result.startAddress = ndx + 1;
        } else if (isType(ndx, ID_INCL_AT_MARKER)) {
          result.initAddress = result.startAddress = ndx;
        }
      }
      if (isType(ndx, ID_CITY)) lastCity = ndx;
    }
  }

  // Identify token type
  private static final Pattern BAD_CHARS = Pattern.compile("[\\(\\)\\[\\],]");
  private void setType(int ndx, boolean checkAt, boolean pastAddr) {
    String token = tokens[ndx];
    
    // If token contains any illegal characters, flag it as a non-address token
    // and bail out.  This is only a problem if we are still in the address proper
    // If we have passed the address and are now in apt or cross fields, illegal
    // character tokens are OK
    if (!pastAddr && BAD_CHARS.matcher(token).find()) {
      tokenType[ndx] |= ID_NOT_ADDRESS;
      if (isFlagSet(FLAG_ANCHOR_END)) startNdx = ndx+1;
      return;
    }
    
    // If token is longer than 1 char and starts with an @
    // Strip off the @ and add the ID_INCL_START_MARK flag
    int mask = 0;
    if (checkAt && token.length() > 1 && token.charAt(0) == '@') {
      tokens[ndx] = token = token.substring(1);
      mask = ID_INCL_AT_MARKER;
    }
    
    // If token is in dictionary, return the associated type code
    // City codes are not permitted to follow intersection connectrs, cross
    // street markers, or at markers for fear thay might be a street with the
    // same name as a city
    Integer iType = dictionary.get(token.toUpperCase());
    if (iType != null) {
      mask |= iType;
      if (ndx > 0 && isType(ndx-1, ID_CONNECTOR | ID_CROSS_STREET | ID_AT_MARKER) ||
          ndx > 1 && isType(ndx-2, ID_CONNECTOR | ID_CROSS_STREET | ID_AT_MARKER) && isType(ndx-1, ID_DIRECTION)) {
        mask &= ~ID_CITY;
      }
    }
    
    else if (NUMERIC.matcher(token).matches()) {
      mask |= ID_NUMBER;
    }
    
    // Some states use alpha route numbers.  This token is a candidate if
    // it hasn't been designated as anything else
    // it is one or two characters long
    // all of the characters are letters
    // it is not a common 2 letter word
    if (mask == 0 && Character.isLetter(token.charAt(0))) {
      if (token.length() == 1 ||
         token.length() == 2 && Character.isLetter(token.charAt(1)) &&
         !token.equals("IN") && !token.equals("OF")) {
        mask |= ID_ALPHA_ROUTE;
      }
    }
    tokenType[ndx] =  mask;
  }
  
  private boolean isType(int ndx, int mask) {
    if (ndx >= tokenType.length) return false; 
    return (tokenType[ndx] & mask) != 0;
  }
  
  private boolean isFlagSet(int mask) {
    return (flags & mask) != 0;
  }
  
  // Determine if token is a single standalone road token
  // such as I-234, or US50, or RT250NB :(
  private boolean isRoadToken(int ndx) {
    
    // If illegal char, answer is no
    if (isType(ndx, ID_NOT_ADDRESS)) return false;
    
    // Get the string token
    if (ndx >= tokenType.length) return false; 
    String token = tokens[ndx];
    
    // See how many letters there are at start of token
    int pt = 0;
    while (pt < token.length() && Character.isLetter(token.charAt(pt))) pt++;
    
    // If zero, or if entire token is letters, the answer is no
    if (pt == 0 || pt == token.length()) return false;
    
    // If next character is a dash, skip over it
    int pta = pt;
    
    int ptBreak = pt;
    boolean dashFound = (token.charAt(pt) == '-');
    if (dashFound) {
      pt++;
      ptBreak = -1;
    }
    
    // If next character is not a digit, answer is no
    if (pt >= token.length() || ! Character.isDigit(token.charAt(pt))) return false;
    
    // Shift the alpha portion upper case and see if what is left is a route prefix
    String pfx = token.substring(0, pta).toUpperCase();
    Integer mask = dictionary.get(pfx);
    if (mask == null || (mask&ID_ROUTE_PFX) == 0) return false;
    
    // Looks promising.  Now scan over any digits and see what we have left
    do pt++; while (pt < token.length() && Character.isDigit(token.charAt(pt)));
    
    // If we are at end of string, answer is yes
    // Otherwise, the answer depends on if the remaining suffix looks like some
    // kind of highway qualifier (NB = north bound for example)
    if (pt != token.length()) {
      String sfx = token.substring(pt).toUpperCase();
      
      do {
        if (sfx.length() == 2 && sfx.charAt(1) == 'B' &&
            "NESW".indexOf(sfx.charAt(0)) >= 0) break;
        
        // Nothing recognized, return false
        return false;
        
      } while (false);
      
      // OK, this looks valid.
      // But Google maps won't recognize the highway qualifier, so we have to get rid of it
      tokens[ndx] = token.substring(0, pt);
    }
    
    // OK, we've concluded this is a valid single word road name.  Now we
    // need to clean up some things Google can't handle
    
    // Google doesn't handle some prefixes with a dash separator, so just to
    // be on the safe side, we always insert one if it wasn't there initially
    // Unless this is a RT prefix, in which cas the dash just doesn't work at all
    if (ptBreak >= 0 && !pfx.equals("RT")) {
      tokens[ndx] = tokens[ndx].substring(0, ptBreak) + "-" + tokens[ndx].substring(ptBreak);
    }
    
    // And Google doesn't like the SRT prefix, change it it to ST
    if (pfx.equals("SRT")) {
      tokens[ndx] = "ST" + tokens[ndx].substring(3);
    }
    return true;
  }
  
  // Determine if token is a valid house number
  private boolean isHouseNumber(int ndx) {
    
    // If numeric token, answer is yes
    if (isType(ndx, ID_NUMBER)) return true;
    
    // Try it against the numeric street number pattern
    // which allows a trailing letter qualifier
    if (ndx >= tokens.length) return false;
    if (PAT_HOUSE_NUMBER.matcher(tokens[ndx]).matches()) return true;
    return false;
    
  }
  
  // Determine if token at index is a standalone apartment number
  private boolean isAptToken(int ndx) {
    if (ndx >= tokens.length) return false;
    String token = tokens[ndx];
    
    if (token.length() > 4) return false;
    char chr = token.charAt(0);
    return (chr == '#' || Character.isDigit(chr));
  }
  
  
  public class Result {
    private String[] tokens;
    private StartType startType;
    private int status = -1;
    private int initAddress = -1;
    private int startAddress = -1; 
    private int initPlace = -1;
    private int startPlace = -1;
    private int initApt = -1;
    private int startApt = -1;
    private int startCross = -1;
    private int startPad = -1;
    private int startCity = -1;
    private int endAll = -1;
    private int insertAmp = -1;
    
    /**
     * @return result status
     */
    public int getStatus() {
      return status;
    }
    
    /**
     * Determine Determine how good an address this parse call found
     * @param extra number of extra tokens (presumably city names) that can
     * be ignored at the end of the line
     * @return zero if string is not recognized as valid address, otherwise a
     * numeric value in which higher values indicate better addresses
     */
    public int getStatus(int extra) {
      if (tokens == null) return 0;
      if (tokens.length-endAll > extra) return 0;
      return status;
    }
  
    /**
     * Fill data object with information from parsed line
     */
    public void getData(SmsMsgInfo.Data data) {
      
      // If prefix ends with some variation of "REPORTED AT" drop the 
      // REPORTED (AT has already been dropped)
      if (initAddress > 0 && isType(initAddress, ID_AT_MARKER) &&
          tokens[initAddress-1].equalsIgnoreCase("REPORTED")) initAddress--;
      
      int end = endAll;
      if (startCity >= 0) {
        data.strCity = buildData(startCity, end, false);
        if (cityCodes != null) data.strCity = convertCodes(data.strCity, cityCodes);
        end = startCity;
      }
      
      if (startPad >= 0) end = startPad;
      
      if (startCross >= 0) {
        data.strCross = buildData(startCross, end, false);
        end = startCross - 1;
      }
      
      if (startApt >= 0) {
        data.strApt = buildData(startApt, end, false);
        end = initApt;
      }
      
      if (startPlace >= 0) {
        data.strPlace = buildData(startPlace, end,false);
        end = initPlace;
      }
      
      if (startAddress >= 0) {
        data.strAddress = buildData(startAddress, end, true);
        end = startAddress;
      }
      
      switch (startType) {
      case START_CALL:
        data.strCall = append(data.strCall, " / ", buildData(0, initAddress, false).replaceAll(" / ", "/"));
        break;
      case START_PLACE:
        if (data.strPlace.length() == 0) {
          data.strPlace = buildData(0, initAddress, false).replaceAll(" / ", "/");
        }
        break;
      }
    }

    /**
     * Special variant of getData that places all address information in the
     * cross street field
     */
    public void getCrossData(Data data) {
      String sCross = buildData(startAddress, endAll, true);
      data.strCross = append(data.strCross, " & ", sCross);
    }
    
    /**
     * @return the pad field (if any) that lies between the address propert and
     * the city field
     */
    public String getPadField() {
      if (startPad < 0) return "";
      int end = endAll;
      if (startCity >= 0) end = startCity;
      return buildData(startPad, end, false);
    }

    /**
     * Called after address has been parsed
     * @return the part of the line after the address
     */
    public String getLeft() {
      if (endAll < 0) return "";
      return buildData(endAll, tokens.length, false);
    }
  
    /**
     * Construct data field from the token sequence from given start and end position
     * @param start starting token index
     * @param end ending token index
     * @param addr true if we are processing the address field
     * @return Constructed data field.
     */
    private String buildData(int start, int end, boolean addr) {
      
      StringBuilder sb = new StringBuilder();
      for (int ndx = start; ndx < end; ndx++) {
        if (ndx != start) sb.append(' ');
        if (addr && ndx == insertAmp) sb.append("& ");
        String token = tokens[ndx];
        if (addr && token.equals("/")) token = "&";
        sb.append(token);
      }
      return sb.toString();
    }
  }
}
