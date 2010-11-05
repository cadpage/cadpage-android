package net.anei.cadpage.parsers;

import java.util.HashMap;
import java.util.Map;

import net.anei.cadpage.SmsMsgInfo;

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
  
  // Main dictionary maps words to a bitmap indicating what is important about that word
  private final Map<String, Integer> dictionary = new HashMap<String, Integer>();
  
  // Bitmask indicating dictionary word is a road suffix
  private static final int ID_ROAD_SFX = 1;
  
  // Bitmask bit indicating dictionary word is a route number prefix
  private static final int ID_ROUTE_PFX = 2;
  
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
  
  public SmartAddressParser(String[] cities) {
    this();
    setupDictionary(ID_CITY, cities);
  }
  
  // Default constructor
  public SmartAddressParser() {
    setupDictionary(ID_ROAD_SFX, 
        "AVENUE", "AV", "AVE", 
        "STREET", "ST", 
        "PLACE", "PL", 
        "ROAD", "RD", 
        "LANE", "LN", "LA",
        "DRIVE", "DR",
        "SQUARE", "SQ",
        "BLVD",
        "WAY", "PKWY", "FWY",
        "CIRCLE", "CIR",
        "TRAIL", "TRL",
        "PATH",
        "PIKE",
        "COURT", "CT",
        "TER",
        "HWY");
    setupDictionary(ID_ROUTE_PFX, "RT", "ST", "US", "FS", "INTERSTATE", "I", "HWY", "STHWY");
    setupDictionary(ID_DIRECTION, "N", "NE", "E", "SE", "S", "SW", "W", "NW");
    setupDictionary(ID_CONNECTOR, "AND", "/", "&");
    
    // C/S should be in this list, but it gets changed before we parse stuff
    setupDictionary(ID_CROSS_STREET, "XS:", "X:");
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
  private String[] tokens;
  private int[] tokenType;
  private int lastCity = -1;
  private int startAddress = -1;  
  private int startCross = -1;
  private int startCity = -1;
  private int endAll = -1;

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

    // Make sure any / character will parse by itself
    // Before we do that we have to protect the C/S cross street indicator
    address = address.replaceAll(" C/S ", " XS: ").replaceAll("/", " / ");
    
    // Parse line into tokens and categorize each token
    // While we are doing this, identify the index of the last city
    tokens = address.split("\\s+");
    tokenType = new int[tokens.length];
    lastCity = -1;
    startAddress = -1;  
    startCross = -1;
    startCity = -1;
    endAll = -1;
    
    for (int ndx = 0; ndx < tokens.length; ndx++) {
      tokenType[ndx] = findType(tokens[ndx]);
      if (isType(ndx, ID_CITY)) lastCity = ndx;
    }
    
    // Now comes the hard part.
    do {
      
      // See if the address starts at the beginning of this field
      // this will make life a lot easier
      boolean startAddr = (sType == StartType.START_ADDR);
      
      // We have a number of basic patters that we will recognize
      // Try each one until we find one that works
      if (parseTrivialAddress(startAddr)) break;
      if (parseSimpleAddress(startAddr)) break;
      if (parseIntersection(startAddr)) break;
      if (parseNakedRoad(startAddr)) break;
      
      // Total failure, assign the entire field to either the call description
      // or the address
      endAll = tokens.length;
      if (sType != StartType.START_CALL) startAddress = 0;
      
    } while (false);
    
    fillInData(sType, data);
  }
  
  /**
   * We handle the dead simple case where the address starts at the 
   * beginning of the text and we have found a city to mark the end
   * of the address (would that life were always this simple
   */
  private boolean parseTrivialAddress(boolean startAddr) {
    
    if (!startAddr) return false;
    return parseToCity(0);
  }

  /**
   * Look for the basic address looking like
   *     <number> <street name> <street suffix>
   */
  private boolean parseSimpleAddress(boolean startAddr) {
    
    // Look for a numeric field which we assume is the house number
    // If field starts with address this has to be the first token
    // Exception, numeric fields that follow a route prefix are part
    // of a road name and cannot be a house number.
    int sAddr = 0;
    while (true) {
      if (sAddr >= tokens.length) return false;
      if (isType(sAddr, ID_NUMBER)) {
        if (sAddr > 0 && isType(sAddr-1, ID_ROUTE_PFX)) return false;
        break;
      }
      if (startAddr) return false;
      sAddr++;
    }
    
    // If we found a city beyond this start point, just use that as the terminator
    if (parseToCity(sAddr)) return true;
    
    // Otherwise, see if we can find a road starting from the next token
    int sEnd = findRoadEnd(sAddr+1);
    if (sEnd < 0) return false;
    
    // If it has, we have found what we need to have found and we are going
    // to be successful
    startAddress = sAddr;
    endAll = sEnd;
    
    // But there might be some additional cross street info we can parse
    findCrossStreet();
    return true;
  }

  /**
   * Look for intersection adddress with the basic form of
   *    <roadname> <road sfx> <connector> <roadname> <road sfx>
   * @param startAddr
   * @return
   */
  private boolean parseIntersection(boolean startAddr) {
    
    // First lets figure out where the address starts
    int sAddr = 0;
    int ndx = 0;

    // If address starts at beginning of field, find end of address and
    // confirm that it starts with a road followed by a connector
    if (startAddr) {
      sAddr = 0;
      ndx = findRoadEnd(0);
      if (ndx < 0) return false;
      if (! isType(ndx, ID_CONNECTOR)) return false;
    }
    
    // Otherwise, scan forward looking for a <road-sfx> <connector> combination
    // Then back up 2 places assuming the road consists of one token.
    // If the previous token is a direction, back up one more to include that.
    else {
      ndx = 1;
      while (true) {
        ndx++;
        if (ndx >= tokens.length) return false; 
        if (isType(ndx, ID_CONNECTOR)) {
          if (isType(ndx-1, ID_ROAD_SFX) ||
              isType(ndx-1, ID_NUMBER) & ndx>2 & isType(ndx-2, ID_ROUTE_PFX)) {
            sAddr = ndx - 2;
            if (sAddr > 0 && isType(sAddr-1, ID_DIRECTION)) sAddr--;
            break;
          }
        }
      }
    }
    
    // When we get here, 
    // saddr points to beginning of address
    // ndx points to the first connector after the first road name.
    // Change the connector to something Google maps will always recognize
    tokens[ndx] = "&";
    
    // If there is a city terminating the address, just parse up to it
    if (parseToCity(ndx)) {
      startAddress = sAddr;
      return true;
    }
    
    // Otherwise find end of second road
    ndx = findRoadEnd(ndx+1);
    if (ndx < 0) return false;
    
    // If we found that, we have a successful intersection parse
    startAddress = sAddr;
    endAll = ndx;
    
    // But there might be some additional cross street info we can parse
    findCrossStreet();
    return true;
  }
  
  /**
   * Look for simple road without a house number or intersection
   *    <roadname> <roadsfx>
   * @return true if 
   */
  private boolean parseNakedRoad(boolean startAddr) {

    // First lets figure out where the address starts
    int sAddr = 0;
    int ndx = 0;

    // If address starts at beginning of field, find end of address and
    if (startAddr) {
      sAddr = 0;
      ndx = findRoadEnd(0);
      if (ndx < 0) return false;
    }
    
    // Otherwise, scan forward looking for a <road-sfx>
    // Then back up 1 places assuming the road consists of one token.
    // If the previous token is a direction, back up one more to include that.
    else {
      ndx = 0;
      while (true) {
        ndx++;
        if (ndx >= tokens.length) return false; 
        if (isType(ndx, ID_ROAD_SFX)) {
          sAddr = ndx - 1;
          if (sAddr > 0 && isType(sAddr-1, ID_DIRECTION)) sAddr--;
          break;
        }
      }
    }
    
    // When we get here, 
    // saddr points to beginning of address
    // ndx points past the end of the road
    
    // We have a successful intersection parse
    startAddress = sAddr;
    endAll = ndx;
    
    // But there might be some additional cross street info we can parse
    findCrossStreet();
    return true;
  }
  
  /**
   * See if we can parse an address from a known starting point to a city
   * @param stNdx known start of address
   * @return true if successful
   */
  private boolean parseToCity(int stNdx) {
    
    if (lastCity <= stNdx) return false;
    
    startAddress = stNdx;
    for (int ndx = 0; ndx < tokens.length; ndx++) {
      if (isType(ndx, ID_CROSS_STREET)) startCross = ndx + 1;
      if (isType(ndx, ID_CITY)) {
        startCity = ndx;
        endAll = ndx+1;
        return true;
      }
    }
    return false;
  }

  /**
   * See if we can find some additional cross street information after
   * the end of a successfully parsed address
   */
  private void findCrossStreet() {
    
    // if the address isn't followed by a cross street indicator, nothing to find
    if (! isType(endAll, ID_CROSS_STREET)) return;
    
    // If it was, skip past it 
    int sCross = endAll + 1;
    int sEnd = sCross;
    
    while (true) {
      
      // And try to find another road
      sEnd = findRoadEnd(sEnd);
      if (sEnd < 0) break;
      
      // Success, save the cross street location
      startCross = sCross;
      endAll = sEnd;
      
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
    
    // Now start looking for a street suffix (or cross street indicator
    // If we have to pass more than two tokens before finding, give up
    
    int end = start+1;
    while (true) {
      if (isType(end, ID_ROAD_SFX)) return end+1;
      if (isType(end, ID_CROSS_STREET)) return end;
      
      // A number preceeded by a route prefix counts as a road
      if (isType(end, ID_NUMBER) && end > 0 && isType(end-1, ID_ROUTE_PFX)) return end+1;
      if (++end - start > 2) return -1;
    }
  }

  /**
   * Fill data object with information from parsed line
   * @param startCall if call description should be parsed from 
   * beginning of the address field
   */
  private void fillInData(StartType startType, SmsMsgInfo.Data data) {
    
    int end = endAll;
    if (startCity >= 0) {
      data.strCity = buildData(startCity, end);
      end = startCity;
    }
    
    if (startCross >= 0) {
      data.strCross = buildData(startCross, end);
      end = startCross - 1;
    }
    
    if (startAddress >= 0) {
      data.strAddress = buildData(startAddress, end);
      end = startAddress;
    }
    
    switch (startType) {
    case START_CALL:
      data.strCall = buildData(0, end);
      break;
    case START_PLACE:
      data.strPlace = buildData(0, end);
      break;
    }
  }

  /**
   * Construct data field from the token sequence from given start and end position
   * @param start starting token index
   * @param end ending token index
   * @return Constructed data field.
   */
  private String buildData(int start, int end) {
    
    StringBuilder sb = new StringBuilder();
    for (int ndx = start; ndx < end; ndx++) {
      if (ndx != start) sb.append(' ');
      sb.append(tokens[ndx]);
    }
    return sb.toString();
  }

  // Identify token type
  private int findType(String token) {
    
    // If token is in dictionary, return the associated type code
    Integer iType = dictionary.get(token);
    if (iType != null) return iType;
    
    if (NUMERIC.matcher(token).matches()) return ID_NUMBER;
    return 0;
  }
  
  private boolean isType(int ndx, int mask) {
    if (ndx >= tokenType.length) return false; 
    return (tokenType[ndx] & mask) != 0;
  }
}
