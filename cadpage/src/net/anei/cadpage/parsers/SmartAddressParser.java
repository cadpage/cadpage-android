
package net.anei.cadpage.parsers;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract message parser class that adds support for "smart" address parsing.
 * That is parsing logic that can be used for text formats that do not clearly 
 * deliminate where the the address portion of the message can be found. 
 *
 */
public abstract class SmartAddressParser extends MsgParser {

  /**
   * Type code indicating what kind of information might precede the address
   * portion of this message
   */
  public  enum StartType {START_ADDR, START_CALL, START_CALL_PLACE, START_PLACE, START_OTHER};
  
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
  
  /**
   * Flag indicating that we only want to parse a cross street
   */
  public static final int FLAG_ONLY_CROSS = 0x0100;
  
  /** 
   * Flag indicating that we only want to parse a city
   */
  public static final int FLAG_ONLY_CITY = 0x0200;
  
  /**
   * Flag indicating that a numeric field following the address should NOT
   * be considered an apartment number.  Use when dispatch never includes
   * a trailing apt.  And the following field might legitimately start
   * with a number as "123 BLACKSTONE DR 76 YO FEMALE
   */
  public static final int FLAG_NO_IMPLIED_APT =0x0400;
  
  /**
   * Flag indicating there is cross street information following the address
   * which means logic to identify a city followed by a street suffix as as
   * street name instead of a city should be suppressed.
   * Normally 123 BLACKSTONE DR PHILOMATH MAIN ST
   * would not terminate at PHILOMATH because PHILOMATH MAIN ST looks like
   * a valid street name.  Turning on this flag changes that.  There have
   * been cases were turning this on fixed problems with following data that
   * was not really a cross street, but looked like it could be a cross street
   */
  public static final int FLAG_CROSS_FOLLOWS = 0x0800;
  
  /**
   * Flag indicating that there my not be a blank delimiter between the
   * address and the data field in front of it. As in
   * STRUCTURE FIRE100 BLACK ST
   * Things are pretty bad when you have to use this
   */
  public static final int FLAG_START_FLD_NO_DELIM = 0x1000;
  
  /**
   * Flag indicating that we will accept street names with non street suffix.
   * Only use in cases where dispatch routinely drops streets suffixes.  When
   * you have to use this, things are going to go badly and a lot of addresses
   * are not going to parser properly.  But this is the best we can do.
   */
  public static final int FLAG_OPT_STREET_SFX = 0x2000;
  
  /**
   * Flag indicating that @ signs should be processed as at markers
   * but the word "AT" should be ignored.  This should probably be
   * used more often than it is.  Without it, things got south when
   * following data inocently contains the word AT.
   */
  public static final int FLAG_AT_SIGN_ONLY = 0x4000;
  
  /**
   * Flag indicating the presence of some kind of PAD field between
   * the address and city name.  Similar to the FLAG_PAD_FIELD flag
   * except that this pad field may not contain a legitimate city name.
   * The pad field can later be retrieved with the getPadField() method
   */
  public static final int FLAG_PAD_FIELD_EXCL_CITY = 0x8000;
  
  private static final int FLAG_ANY_PAD_FIELD = FLAG_PAD_FIELD | FLAG_PAD_FIELD_EXCL_CITY;
  
  /**
   * Flag indicating that this call should not find a city.  That any predefined city lists
   * or codes should be ignored.  Basically tells the parser to ignore any city codes or lists.
   * Obviously not needed when there are no city codes/lists.  But can be useful when
   * you have an address line that might or might not contain a city.  A parser can
   * work with a line that might contain either
   * STRUCTURE FIRE 1035 MAIN ST, PHILOMATH or
   * STRUCTURE FIRE 1035 MAIN ST PHILOMATH
   * by checking for the comma.  If found, extract city name from after the comma and turn
   * on the FLAG_NO_CITY flag
   */
  public static final int FLAG_NO_CITY = 0x10000;
  
  /**
   * Flag indicating that a NEAR clause should extend to the end of the input string.
   * I'm really not sure about this one.  But here is what I think happens.
   * Normally an address like 1035 MAIN ST NEAR THE PHILOMATH FIRE STATION
   * would parser NEAR THE as the place name and PHILOMATH as the city.  With
   * this flag set, NEAR THE PHILOMATH FIRE STATION goes into the place name.
   */
  public static final int FLAG_NEAR_TO_END = 0x20000;
  
  /**
   * Flag indicating a city with no address is an acceptable result
   */
  public static final int FLAG_EMPTY_ADDR_OK = 0x40000;
  
  /**
   * Flag indicating that entire line should be assigned to address in 
   * the event of a full parser failure
   */
  public static final int FLAG_FALLBACK_ADDR = 0x80000;
  
  /**
   * Flag indicating that extra effort should be expended to identify
   * implied apt fields at the end of the address field.  Normally only
   * numeric tokens following the address are considered apartments.  This
   * triggers some aggressive logic to identify non-numeric information
   * following the address and assigning it to the apt field.
   */
  public static final int FLAG_RECHECK_APT = 0x100000;
  
  /**
   * Flag indication that there is absolutely, positively, no street suffix
   * in this address.  Used only in the incredibly weird case where search for
   * a street suffix will mistakenly pick up a following cross street. 
   */
  public static final int FLAG_NO_STREET_SFX = 0x200000;
  
  /**
   * Flag indicating that the word "AND" should not be considered as
   * connecting two street names at an intersection
   */
  public static final int FLAG_AND_NOT_CONNECTOR = 0x400000;
  
  /**
   * Flag indicating that @ and at should be treated as cross street markers
   */
  public static final int FLAG_AT_MEANS_CROSS = 0x800000;
  
  public static final int STATUS_TRIVIAL = 5;
  public static final int STATUS_FULL_ADDRESS = 4;
  public static final int STATUS_INTERSECTION = 3;
  public static final int STATUS_STREET_NAME = 2;
  public static final int STATUS_MARGINAL = 1;
  public static final int STATUS_NOTHING = 0;
      
  // Pattern searching for characters that are not allowed in addresses
  private Pattern badCharPtn = null;
  
  private Properties cityCodes = null;
  
  // Main dictionary maps words to a bitmap indicating what is important about that word
  private final Map<String, Long> dictionary = new HashMap<String, Long>();
  
  // Bitmask indicating dictionary word is a road suffix
  private static final long ID_ROAD_SFX = 1L;
  
  // Bitmask bit indicating dictionary word is a route number prefix
  private static final long ID_ROUTE_PFX_PFX = 2L;
  
  // Bitmask bit indicating dictionary word is a direction modifier
  private static final long ID_DIRECTION = 4L;
  
  // Bitmask bit indicating dictionary work is an intersection connector
  private static final long ID_CONNECTOR = 8L;
  
  // Bitmask bit indicating dictionary word is a cross street selector
  private static final long ID_CROSS_STREET = 0x10L;
  
  // Bitmask bit indicating dictionary word is a city name/code
  private static final long ID_CITY = 0x100L;
  
  // Bitmask bit indicating numeric token
  private static final long ID_NUMBER = 0x200L;
  
  // Bitmask bit indicating start of multiword token
  private static final long ID_MULTIWORD = 0x400L;
  
  // Bitmask bit indicating a start address marker
  private static final long ID_AT_MARKER = 0x800L;
  
  // Bitmask bit indicating token had a preceding @ character
  private static final long ID_INCL_AT_MARKER = 0x1000L;
  
  // Bitmask bit indicating token is an apartment selector
  private static final long ID_APT = 0x2000L;
  
  // Bitmask bit indicating token is a complete single word token
  // both this and the ID_MULTIWORD flag may be set if a token is both
  // a single complete token and the start of a multiword token
  private static final long ID_COMPLETE = 0x4000L;
  
  // Bitmask bit indicating token is a route prefix that can be extended
  // by another normal route prefix
  private static final long ID_ROUTE_PFX_EXT =  0x8000L;
  
  // Bitmask bit indicating token is an ambiguous road suffix
  private static final long ID_AMBIG_ROAD_SFX = 0x10000L;
  
  // Bitmask bit indicating token cannot be part of an address
  private static final long ID_NOT_ADDRESS = 0x20000L;
  
  // Bitmask bit indicating token can be an alpha route or highway number
  private static final long ID_ALPHA_ROUTE = 0x40000L;
  
  // Bitmask bit indicating token is an optional extra road prefix (OLD, NEW)
  private static final long ID_OPT_ROAD_PFX = 0x80000L;
  
  // Bitmask bit indicating token is a road suffix commonly associated with
  // numbered road names
  private static final long ID_NUMBERED_ROAD_SFX = 0x100000L;
  
  // Bitmask bit indicating token is a word that is commonly used to qualify
  // other highway names
  private static final long ID_ROAD_QUALIFIER = 0x200000L;
  
  // Bitmask indicating dictionary word should be considered as starting a multi-word
  // street name
  private static final long ID_STREET_NAME_PREFIX = 0x400000L;
  
  private static final long ID_SPEC_CROSS_FWD = 0x0800000L;
  private static final long ID_SPEC_CROSS_REV = 0x1000000L;
  
  private static final long ID_RELATION = 0x2000000L;
  
  private static final long ID_NEAR = 0x4000000L;
  
  private static final long ID_SINGLE_WORD_ROAD = 0x8000000L;
  
  private static final long ID_BYPASS = 0x10000000L;
  
  private static final long ID_BLOCK = 0x20000000L;
  
  private static final long ID_AND_CONNECTOR = 0x40000000L;
  
  private static final long ID_FLOOR = 0x80000000L;
  
  private static final long ID_DR = 0x100000000L;
  
  private static final long ID_DOCTOR = 0x200000000L;
  
  private static final long ID_APT_SOFT = 0x200000000L;
  
  private static final long ID_NUMBER_SUFFIX = 0x400000000L;

  private static final long ID_ST = 0x800000000L;
  
  private static final long ID_SAINT = 0x1000000000L;
  
  private static final long ID_OF = 0x2000000000L;
  
  private static final long ID_TO = 0x4000000000L;
  
  private static final long ID_ROUTE_PFX = 0x8000000000L;
  
  private static final long ID_MILE_MARKER = 0x10000000000L;

  private static final long ID_PURE_DIRECTION = 0x20000000000L;

  private static final long ID_NOT_STREET_NAME = 0x40000000000L;
  
  private static final Pattern PAT_HOUSE_NUMBER = Pattern.compile("\\d+(?:-[A-Z]?[0-9/]+|\\.\\d)?(?:-?(?:[A-Z]|BLK))?", Pattern.CASE_INSENSITIVE);
  
  // List of multiple word cities
  private MultiWordList mWordCities = null;
  
  // List of multiple word street names
  // We keep two of these in case we have to search forward or backward
  private MultiWordList mWordStreetsFwd = null;
  private MultiWordList mWordStreetsRev = null;
  
  // List of special cross street names
  private MultiWordList mWordCrossStreetsFwd = null;
  private MultiWordList mWordCrossStreetsRev = null;
  
  // Call lookup table
  private CodeSet callDictionary = null;
  
  // Permanent address flags
  private boolean allowDirectionHwyNames = false;
  
  public SmartAddressParser(String[] cities, String defCity, String defState) {
    this(cities, defCity, defState, CountryCode.US);
  }
  
  public SmartAddressParser(String[] cities, String defCity, String defState, 
                            CountryCode code) {
    this(defCity, defState, code);
    setupCities(cities);
  }
  
  public SmartAddressParser(Properties cityCodes, String defCity, String defState) {
    this(cityCodes, defCity, defState, CountryCode.US);
  }
  
  public SmartAddressParser(Properties cityCodes, String defCity, String defState, 
                            CountryCode code) {
    this(defCity, defState, code);
    if (cityCodes != null) setupCities(getKeywords(cityCodes));
    this.cityCodes = cityCodes;
  }
  
  public SmartAddressParser(String defCity, String defState) {
    this(defCity, defState, CountryCode.US);
  }
  
  public SmartAddressParser(String defCity, String defState, CountryCode code) {
    super(defCity, defState, code);
    setupDictionary(defState);
    allowBadChars("");
  }

  /**
   * Set up base dictionary common to all countries
   * @param defState default state
   */
  private void setupDictionary(String defState) {

    setupDictionary(ID_ROAD_SFX, 
        "AVENUE", "AV", "AVE", 
        "STREET", "ST", 
        "PLACE", "PL", 
        "ROAD", "RD", 
        "LANE", "LN",
        "DRIVE", "DR",
        "SQUARE", "SQ",
        "BLVD", "BL", "BLV", "BVD",
        "PARKWAY", "WAY", "PKWAY", "PKWY", "PKY", "PK", "PY", "FWY", "WY", "HW", "EXPW", "PW", "PKW",
        "CIRCLE", "CIR", "CL", "CI", "CR",
        "TRAIL", "TRL", "TR", "TL",
        "PATH",
        "PIKE", "PKE",
        "COURT", "CT",
        "TER", "TERR",
        "HWY", "HY", "HW",
        "MALL",
        "GTWY", "GATEWAY",
        "PLAZ", "PLAZA",
        "TURNPIKE", "TRNPK", "TPKE", "TRPK", "TPK", "TP",
        "PASS",
        "EST",
        "RUN",
        "GRN",
        "GRV",
        "LOOP",
        "TERRACE", "TRC", "TRCE",
        "ESTATES", "ESTS",
        "WALK",
        "CUTOFF",
        "RCH", "REACH",
        "ARCH",
        "MNR",
        "BYPASS", "BYP",
        "ALLEY", "ALY",
        "FREEWAY",
        "HT", "HTS", "HEIGHTS",
        "BND", "BEND",
        "CV", "COVE",
        "THOROUGHFARE",
        "KNOLL",
        "XING");
    if ((getMapFlags() & MAP_FLG_SUPPR_LA) == 0)  setupDictionary(ID_ROAD_SFX, "LA");
    
    setupDictionary(ID_BYPASS, "BYPASS", "BYP", "BUSINESS", "BUS", "ALT");
    
    setupDictionary(ID_AMBIG_ROAD_SFX, 
        "PLACE", "TRAIL", "PATH", "PIKE", "COURT", "MALL", "TURNPIKE", "PASS", 
        "RUN", "LANE", "PARK", "POINT", "RIDGE", "CREEK", "MILL", "BRIDGE", "HILLS",
        "HILL", "TRACE", "STREET", "MILE", "BAY", "NOTCH", "END", "LOOP", "ESTATES",
        "SQUARE", "WALK", "CIRCLE", "GROVE", "HT", "HTS", "HEIGHTS", "BEND", "VALLEY",
        "WAY", "GATEWAY", "KNOLL", "COVE", "ARCH", "BYPASS");
    
    
    setupDictionary(ID_NUMBERED_ROAD_SFX, 
        "AVENUE", "AV", "AVE", 
        "STREET", "ST", 
        "PLACE", "PL",
        "ROAD", "RD",
        "HWY",
        "MILE");
    
    setupDictionary(ID_ROAD_QUALIFIER, "OLD");
        
    setupDictionary(ID_ROUTE_PFX_PFX, "STATE", "ST", "SR", "SRT", "US", "FS", "INTERSTATE", "I", "IH", "STHWY", "STHY", "SH", "USHWY", "USHY", "CO", "CR", "CORD", "COUNTY", "CTY", "FM", "FR");
    setupDictionary(ID_ROUTE_PFX_EXT, "RT", "RTE", "ROUTE", "HW", "HY", "HWY", "HIGHWAY", "ROAD", "RD");
    setupDictionary(ID_ROUTE_PFX, "STATE", "ST", "SR", "SRT", "US", "FS", "INTERSTATE", "I", "IH", "STHWY", "STHY", "SH", "USHWY", "USHY", "CO", "CR", "CORD", "COUNTY", "CTY", "FM", "FR", "RT", "RTE", "ROUTE", "HW", "HY", "HWY", "HIGHWAY");
    setupDictionary(ID_ROUTE_PFX_PFX, new String[]{defState});
    setupDictionary(ID_ROUTE_PFX, new String[]{defState});
    setupDictionary(ID_PURE_DIRECTION, "N", "NE", "E", "SE", "S", "SW", "W", "NW");
    setupDictionary(ID_DIRECTION, "N", "NE", "E", "SE", "S", "SW", "W", "NW", "NB", "EB", "SB", "WB", "EXT", 
                                  "NORTHBOUND", "EASTBOUND", "SOUTHBOUND", "WESTBOUND");
    setupDictionary(ID_OPT_ROAD_PFX, "OLD", "NEW", "UPPER", "LOWER");
    setupDictionary(ID_CONNECTOR, "AND", "/", "&");
    setupDictionary(ID_AND_CONNECTOR, "AND");
    setupDictionary(ID_AT_MARKER, "@", "AT");
    setupDictionary(ID_OF, "OF");
    setupDictionary(ID_TO, "TO");
    setupDictionary(ID_ST, "ST");
    setupDictionary(ID_MILE_MARKER, "MM", "MP");
    
    setupDictionary(ID_CROSS_STREET, "XS:", "X:", "C/S:", "C/S");
    setupDictionary(ID_NEAR, "NEAR", "ACROSS");
    setupDictionary(ID_APT, "APT:", "APT", "APTS", "#", "SP", "RM", "SUITE", "STE", "SUITE:", "ROOM", "ROOM:", "LOT", "UNIT");
    setupDictionary(ID_APT_SOFT, "APT", "APTS", "SUITE", "ROOM", "LOT", "UNIT");
    setupDictionary(ID_FLOOR, "FLOOR", "FLR", "FL");
    setupDictionary(ID_STREET_NAME_PREFIX, "HIDDEN", "LAKE", "MT", "MOUNT", "SUNKEN");
    setupDictionary(ID_NOT_ADDRESS, "YOM", "YOF", "YO");
    setupDictionary(ID_SINGLE_WORD_ROAD, "TURNPIKE");
    setupDictionary(ID_BLOCK, "BLK", "BLOCK");
    setupDictionary(ID_NUMBER_SUFFIX, "ND", "RD", "TH");
    setupDictionary(ID_NOT_STREET_NAME, "ON", "NO", "IN", "AT", "THE");
    
    // Set up special cross street names
    addCrossStreetNames(
        "ALLEY",
        "CITY LIMIT",
        "CITY LIMITS",
        "DEADEND",
        "DEAD END",
        "RAILROAD CROSSI",
        "RR",
        "RR TRACKS",
        "TRAILER PARK",
        "UNNAMED STREET"
    );
    
    // Add any country specific words
    switch (getCountryCode()) {
    case UK:
      setupDictionary(ID_ROAD_SFX,
          "CLOSE",
          "GREEN",
          "CRESCENT");
      break;
      
    case NZ:
      setupDictionary(ID_ROAD_SFX,
          "CRES", "CRESCENT",
          "TCE", "TERRACE");
      break;
      
    default:
      break;
    }
  }
  
  /**
   * Allow otherwise prohibited characters in address
   * @param charList list of characters that will be allowed
   */
  protected void allowBadChars(String charList) {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (char chr : "()[],".toCharArray()) {
      if (charList.indexOf(chr) < 0) {
        sb.append('\\');
        sb.append(chr);
      }
    }
    sb.append(']');
    badCharPtn = Pattern.compile(sb.toString());
  }
  
  /**
   * Add full length names of directions to direction dictionary tables
   */
  protected void addExtendedDirections() {
    setupDictionary(ID_DIRECTION, "NORTH", "SOUTH", "EAST", "WEST");
  }
  
  /**
   * Add vocabulary to identify nautical locations
   */
  protected void addNauticalTerms() {
    setupDictionary(ID_ROAD_SFX, 
        "POINT", "PT",
        "BAY",
        "STRAIGHT",
        "ISLAND", "ISLE");
  }
  
  /**
   * Add additional road suffix terms.  It is the callers responsibility
   * to ensure that all new suffix terms are properly handled when the
   * map address is generated
   * @param terms new road suffix terms
   */
  protected void addRoadSuffixTerms(String ... terms) {
    setupDictionary(ID_ROAD_SFX, terms);
  }
  
  /**
   * Add additional words that should not be allowed in address fields
   * @param words words to be added to list of invalid address words
   */
  protected void addInvalidWords(String ... words) {
    setupDictionary(ID_NOT_ADDRESS, words);
  }
  
  /**
   * Remove words from dictionary that are causing confusion
   * @param words words to be removed
   */
  protected void removeWords(String ... words) {
    for (String word : words) dictionary.remove(word);
  }
  
  private String[] getKeywords(Properties table) {
    String[] result = new String[table.size()];
    int ndx = 0;
    for (Enumeration<?> e = table.propertyNames(); e.hasMoreElements(); ) {
      result[ndx++] = (String)e.nextElement();
    }
    return result;
  }
  
  /**
   * Set up predefined city code tables or lists
   */
  private void setupCities(String[] cities) {
    if (cities == null) return;
    mWordCities = new MultiWordList(+1, ID_CITY, ID_MULTIWORD, ID_COMPLETE, cities);
  }
  
  private void setupDictionary(long bitMask, String ... args) {
    for (String arg : args) {
      long newMask = bitMask;
      Long oldMask = dictionary.get(arg);
      if (oldMask != null) newMask |= oldMask;
      dictionary.put(arg, newMask);
    }
  }

  /**
   * Look up a word on our internal dictionary
   * @param word word to be checked
   * @return true if word is found in dictionary and should
   * be expected in a street
   */
  public boolean isDictionaryWord(String word) {
    Long flags = dictionary.get(word);
    return (flags != null && (flags & (ID_NOT_ADDRESS|ID_NOT_STREET_NAME)) == 0);
  }
  
  /**
   * Setup predefined call list
   * @param callList list of predefined calls
   */
  protected void setupCallList(String ... callList) {
    setupCallList(new CodeSet(callList));
  }
  
  /**
   * Set up predefined call list
   * @param callDictionary CodeSet containing expected call values
   */
  protected void setupCallList(CodeSet callDictionary) {
    this.callDictionary = callDictionary;
  }
  
  @Override
  public CodeSet getCallList() {
    return callDictionary;
  }
  
  protected void setAllowDirectionHwyNames() {
    setAllowDirectionHwyNames(true);
  }
  
  public void setAllowDirectionHwyNames(boolean allowDirectionHwyNames) {
    this.allowDirectionHwyNames = allowDirectionHwyNames;
  }
  
  /**
   * Set up preloaded multi-word street names
   * @param names list of multi-word street names.  with no street suffixes
   */
  protected void setupMultiWordStreets(String ... names) {
    mWordStreetsFwd = new MultiWordList(+1, 0, ID_MULTIWORD, 0, names);
    mWordStreetsRev = new MultiWordList(-1, 0, ID_MULTIWORD, 0, names);
  }

  /**
   * Add additional names to the list of special cross street names
   * @param names cross street names to be added
   */
  protected void addCrossStreetNames(String ... names) {
    if (mWordCrossStreetsFwd == null) {
      mWordCrossStreetsRev = new MultiWordList(-1, ID_SPEC_CROSS_FWD, ID_MULTIWORD, ID_COMPLETE, names);
      mWordCrossStreetsFwd = new MultiWordList(+1, ID_SPEC_CROSS_REV, ID_MULTIWORD, ID_COMPLETE, names);
    } else {
      mWordCrossStreetsRev.addNames(-1, names);
      mWordCrossStreetsFwd.addNames(+1, names);
    }
  }
  
  protected void setupDoctorNames(String ... names) {
    setupDictionary(ID_DR, "DR");
    for (String name : names) {
      setupDictionary(ID_DOCTOR, name, name+"S", name+"'S");
    }
  }
  
  protected void setupSaintNames(String ... names) {
    setupDictionary(ID_SAINT, names);
  }
  
  
  // Parser working variables
  private int flags;
  private String[] tokens;
  private long[] tokenType;
  private int[] tokenPos;
  private int startAddress = -1;
  private int lastCity = -1;
  private int startNdx = 0;
  private String saveAddress;
  
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
    return parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_NO_CITY, address).getStatus(extra);
  }
  
  /**
   * Determine if a string looks like a valid address
   * @param address Address string to be checked
   * @return true if valid address
   */
  protected boolean isValidAddress(String address) {
    return isValidAddress(address, 0);
  }
  
  /**
   * Determine if a string looks like a valid address
   * @param address Address string to be checked
   * @param extra number of extra tokens (presumably city names) that can
   * be ignored at the end of the line
   * @return true if valid address
   */
  protected boolean isValidAddress(String address, int extra) {
    return parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_NO_CITY, address).isValid(extra);
  }
  
  /**
   * Determine if a string looks like a cross street
   * @param address Address string to be checked
   * @return true if valid cross street
   */
  protected boolean isValidCrossStreet(String address) {
    return isValidCrossStreet(address, 0);
  }
  
  /**
   * Determine if a string looks like a valid address
   * @param address Address string to be checked
   * @param extra number of extra tokens (presumably city names) that can
   * be ignored at the end of the line
   * @return true if valid cross street
   */
  protected boolean isValidCrossStreet(String address, int extra) {
    return parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ONLY_CROSS | FLAG_NO_CITY, address).isValid(extra);
  }
  
  /**
   * Determine if string contains a city name or code.
   * @param address string to be checked for city name
   * @return true if recognized as city, false otherwise
   */
  protected boolean isCity(String address) {
    return parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY | FLAG_CHECK_STATUS | FLAG_ANCHOR_END, address).getStatus() > 0;
  }

  /**
   * Parse address line
   * @param sType indicates what we now about start of address field
   *         START_ADDR - field starts with the address
   *         START_CALL - field starts with call description followed by address
   *         START_CALL_PLACE - field starts will call description possibly followed by place name
   *         START_PLACE - field starts with a place name
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
   * @param address address field to be parsed
   * @param data data object to be filled with information from parsed address field.
   */
  protected void parseAddress(StartType sType, String address, MsgInfo.Data data) {
    parseAddress(sType, 0, address, data);
  }

  /**
   * Parse address line
   * @param sType indicates what we now about start of address field
   *         START_ADDR - field starts with the address
   *         START_CALL - field starts with call description followed by address
   *         START_CALL_PLACE - field starts will call description possibly followed by place name
   *         START_PLACE - field starts with a place name
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
   * @param flags - Special processing flags                     
   * @param address address field to be parsed
   * @param data data object to be filled with information from parsed address field.
   */
  protected void parseAddress(StartType sType, int flags, String address, MsgInfo.Data data) {
    lastResult = parseAddress(sType, flags, address);
    lastResult.getData(data);
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
   * Determine if the string that we just parsed looks like an address
   * @return zero if string was not recognized as valid address, otherwise a
   * numeric value in which higher values indicate better addresses
   */
  protected boolean isValidAddress() {
    return lastResult.isValid();
  }
  
  /**
   * parse address and return a result object that can be used to build
   * the parsed data fields at a later time
   * @param sType indicates what we now about start of address field
   *         START_ADDR - field starts with the address
   *         START_CALL - field starts with call description followed by address
   *         START_CALL_PLACE - field starts will call description possibly followed by place name
   *         START_PLACE - field starts with a place name
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
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
   *         START_CALL_PLACE - field starts will call description possibly followed by place name
   *         START_PLACE - field starts with a place name
   *         START_SKIP - field starts with something we aren't interested in,
   *                      followed by address
   * @param flags - Special processing flags                     
   * @param address address field to be parsed
   * @return integer indicating how good this address is, higher number mean better fit
   */
  protected Result parseAddress(StartType sType, int flags, String address) {
    address = address.trim();
    Result result = parseAddressInternal(sType, flags, address);
    
    result.flags = flags;
    
    // Now is where we use the result to compute the true prefix and leftover segments
    result.stdPrefix = "";
    result.left = "";
    result.mBlankLeft = false;
    result.commaLeft = false;
    
    if (result.startField != null) {
      
      // If prefix ends with some variation of "REPORTED AT" drop the 
      // REPORTED (AT has already been dropped)
      int tmp = result.startField.fldEnd;
      if (tmp > 0 && isAtSign(tmp) && tokens[tmp-1].equalsIgnoreCase("REPORTED")) tmp--;
      
      if (tmp > 0) {
        if (tmp >= tokenPos.length) {
          result.stdPrefix = saveAddress;
        } else {
          result.stdPrefix = saveAddress.substring(0,tokenPos[tmp]).trim();
        }
      }
    }
    
    if (result.endAll >= 0 && result.endAll < tokenPos.length) {
      int tmp = result.endAll;
      while (tmp < tokens.length && tokens[tmp].equals(",")) {
        tmp++;
        result.commaLeft = true;
      }
      if (tmp < tokenPos.length){ 
        int pt = tokenPos[tmp];
        result.mBlankLeft = (pt >= 2 && saveAddress.substring(pt-2, pt).equals("  "));
        result.left = saveAddress.substring(pt);
      }
    }
    
    // If we were really parsing cross streets, switch address index to cross street index
    if (isFlagSet(FLAG_ONLY_CROSS)) {
      result.crossField = result.addressField;
      result.addressField = null;
    }
    return result;
  }
  
  private static final Pattern US_PTN = Pattern.compile("\\b(U) (S)\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern ADDR_START_PTN = Pattern.compile("^(?:@|AT |REPORTED AT )", Pattern.CASE_INSENSITIVE);
  private Result parseAddressInternal(StartType sType, int flags, String address) {
    this.flags = flags;
    lastCity = -1;
    Result result = new Result(this, flags);
    boolean onlyCity = isFlagSet(FLAG_ONLY_CITY);

    // If we have a call dictionary, and address starts with a call, search
    // the dictionary to see if address line starts with matching call.  This logic
    // should be suppressed if we are starting with a call description and the address
    // contains an @
    if ((sType == StartType.START_CALL && (isFlagSet(FLAG_AT_PLACE|FLAG_AT_BOTH|FLAG_IGNORE_AT) || !address.contains("@")) ||
         sType == StartType.START_CALL_PLACE) 
         && callDictionary != null) {
      String call = callDictionary.getCode(address.toUpperCase(), !isFlagSet(FLAG_START_FLD_NO_DELIM));
      if (call != null) {
        
        // We have a match.  Store the call (without the trailing space)
        // in the result call prefix.  Remove the call prefix from the address
        // line, and set the start type to start with the address
        result.callPrefix = address.substring(0,call.length());
        address = address.substring(call.length()).trim();
        Matcher match = ADDR_START_PTN.matcher(address);
        if (match.find()) address = address.substring(match.end()).trim();
        sType = (sType == StartType.START_CALL_PLACE ? StartType.START_PLACE : StartType.START_ADDR);
        this.flags &= ~FLAG_START_FLD_REQ;
      }
    }

    // Save the result address type
    result.startType = sType;

    // Check for null string
    result.status = -1;
    address = address.trim();
    if (address.length() == 0) return result;
    
    // Before we do anything else, see if we can find some GPS coordinates
    // in this address.  If we do find them, they will need to be protected
    // from being broken into separate tokens
    String gpsCoords = null;
    Matcher match = MsgParser.GPS_PATTERN.matcher(address);
    if (match.find()) gpsCoords = match.group();
    
    // Look for and compress any US symbols
    address = US_PTN.matcher(address).replaceAll("$1$2");
    
    // Strip leading zeros from starting numeric tokens
    if (!onlyCity) address = stripLeadingZero(address);

    // Set up token list and types
    setTokenTypes(sType, address, gpsCoords, result);
    
    // Null token list should return total failure status
    if (tokens.length == 0) {
      result.status = 0;
      return result;
    }
    
    // If we are looking for a city and nothing else, parseToCity can find it
    // If the city has to start and end the field, check that that start index is zero
    if (onlyCity && ! isFlagSet(FLAG_ONLY_CROSS)) {
      if (parseStartToCity(0, result)) {
        if (sType != StartType.START_ADDR || result.cityField.fldStart == 0) {
          result.status = STATUS_TRIVIAL;
          return result;
        }
        result.cityField = null;
      } 
      if (result.startField != null) {
        result.startField.end(tokens.length);
      } else {
        result.endAll = 0;
      }
      return result;
    }
    
    // Now comes the hard part.
    
    // We have a number of basic patters that we will recognize
    // Try each one until we find one that works
    result.status = STATUS_TRIVIAL;
    if (parseTrivialAddress(result, false)) return result;
    if (!isFlagSet(FLAG_ONLY_CROSS)) {
      if (parseGPSCoords(result, gpsCoords)) return result;
      result.status = STATUS_FULL_ADDRESS;
      if (parseSimpleAddress(result)) return result;
    }
    result.status = STATUS_INTERSECTION;
    if (parseIntersection(result)) return result;
    result.status = STATUS_STREET_NAME;
    if (parseNakedRoad(result)) {
      // If the naked road pattern detected an implied intersection symbol
      // promote the result status to intersection
      if (result.insertAmp >= 0) result.status++; 
      return result;
    }

    result.status = STATUS_TRIVIAL;
    if (parseTrivialAddress(result, true)) return result;

    // If all else fails, use the fallback parser
    parseFallback(sType, result);
    result.status = STATUS_NOTHING;
    if (result.addressField != null && 
        isHouseNumber(result.addressField.fldStart)) result.status = STATUS_MARGINAL;
    return result;
  }

  /**
   * Called after address has been parsed
   * @return the part of the line in front of the address
   */
  public String getStart() {
    return lastResult.getStart();
  }

  /**
   * Called after address has been parsed with FLAG_PAD_FIELD or
   * FLAG_PAD_FIELD_EXCL_CITY flag
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
   * Called after address has been parsed
   * @return true if multple blanks occurred before the getLeft() result
   */
  public boolean isMBlankLeft() {
    return lastResult.isMBlankLeft();
  }

  /**
   * Called after address has been parsed
   * @return true if there was a comma before the getLeft() result
   */
  public boolean isCommaLeft() {
    return lastResult.isCommaLeft();
  }
  
  /**
   * We handle the dead simple case where the address starts at the 
   * beginning of the text and we have found a city to mark the end
   * of the address (would that life were always this simple
   */
  private boolean parseTrivialAddress(Result result, boolean skipPad) {
    
    // If start address is not fixed somewhere, this cannot possibly work
    if (startAddress < 0) return false;
    
    // If we were called to specifically check address status, we always fail
    // because this short circuits the entire address validation logic
    if (isFlagSet(FLAG_CHECK_STATUS)) return false;

    // We end up getting called twice. The first time skipPad is false, and we are
    // still hoping to find an implied intersection or pad field, which won't happen if we   
    // return a trivial result here 
    
    // We are called a second time if nothing else has worked, in which case we
    // will ahead and process this if we skipped processing the first time around
    if (isFlagSet(FLAG_IMPLIED_INTERSECT|FLAG_ANY_PAD_FIELD) != skipPad) return false;
    
    // OK, we have to have at least 1 items before the city
    // Unless we are parsing a cross street instead of a real address, in which
    // case we allow it to be empty
    int reserve = (isFlagSet(FLAG_ONLY_CROSS | FLAG_EMPTY_ADDR_OK) ? 0 : isHouseNumber(startAddress) ? 2 : 1);
    return parseAddressToCity(startAddress, startAddress+reserve, result);
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
    int start = (result.startType == StartType.START_ADDR ? 0 : gpsNdx);
    int end  = (isFlagSet(FLAG_ANCHOR_END) ? tokens.length : gpsNdx+1);
    if (result.startField != null) result.startField.end(start);
    result.addressField = new FieldSpec(start, end);
    result.endAll = end;
    return true;
  }

  /**
   * Look for the basic address looking like
   *     <number> <street name> <street suffix>
   */
  private boolean parseSimpleAddress(Result result) {
    
    result.reset(startAddress);
    boolean padField = isFlagSet(FLAG_ANY_PAD_FIELD);

    // Start looking through the address for a starting house number
    int start = startAddress >= 0 ? startAddress : startNdx;
    int sAddr = start;
    int sEnd = -1;
    boolean flexAt = isFlagSet(FLAG_AT_BOTH);
    boolean locked = false;
    while (true) {
      while (true) {
        if (sAddr >= tokens.length) return false;
        if (isType(sAddr, ID_CROSS_STREET)) return false;
        
        // See if this token looks like a house number, and is not followed by an invalid address token or a connector 
        if (isHouseNumber(sAddr) && !isType(sAddr+1, ID_NOT_ADDRESS | ID_AT_MARKER | ID_INCL_AT_MARKER | ID_NUMBER_SUFFIX) && findConnector(sAddr+1)<0) {
          
          // And is not followed by another number, unless that number is followed by a numbered road suffix
          if (!isHouseNumber(sAddr+1) || isType(sAddr+2, ID_NUMBERED_ROAD_SFX)) {
            
            // And is not following a relational operator
            if (sAddr == 0 || ! isType(sAddr-1, ID_RELATION)) {
              
              // Getting closer...
              // if the house number appears to be part of a numbered highway, bail out
              // Unless the previous word is "CO" which might be abbreviation for "COMPANY in the prefix data
              if (findRevNumberedHwy(start, sAddr) >= 0 && !tokens[sAddr-1].equalsIgnoreCase("CO")) return false;
              
              // If the house numbered is followed by a numbered road suffix
              // this starts looking chancey.  But more analysis is needed.
              if (isType(sAddr+1, ID_NUMBERED_ROAD_SFX)) {
                
                // If the numbered road suffix is actually the start of a numbered highway name, we are good to go
                sEnd = findNumberedHwy(sAddr+1);
                if (sEnd >= 0) {
                  sEnd++;
                  sEnd = bumpTrailingDir(sEnd);
                  break;
                }

                // If the numbered road suffix is ST, see if it is actually the start
                // of a street name named after saint.  if it is, we are good to go
                if (isType(sAddr+1, ID_ST)) {
                  if (!isType(sAddr+2, ID_DIRECTION)) {
                    sEnd = findRoadEnd(sAddr+1, 0);
                    if (sEnd > 0) break;
                  }
                }
                
                // Otherwise, this has been confirmed as a legitimate numbered road suffix following
                // the house number which is a show stopper
                return false;
              }
              break;
            }
          }
        }
        
        // Not a house  number.  If the start address field is locked, bail out
        if (startAddress >= 0 || locked) return false;
        if (flexAt && isType(sAddr, ID_INCL_AT_MARKER)) return false;
        
        // Otherwise move on to the next token
        // If we encounter a flexible @ sign, lock in the start of the address field
        sAddr++;
        if (flexAt && isAtSign(sAddr)) locked = true;
      }
      
      // OK, we found a house number!!
      // sAddr points to the house number
      // sEnd points to end of street name if identified, or -1 if not.
      
      // If we found a city beyond this start point, just use that as the terminator
      if (! padField && parseAddressToCity(sAddr, (sEnd > 0 ? sEnd : sAddr+2), result)) {
        if (locked && result.startField != null) result.startField.fldEnd--;
        return true;
      }
      
      // Otherwise, see if we can find a road starting from the next token
      if (sEnd < 0) sEnd = findRoadEnd(sAddr+1, 2);
      if (sEnd > 0) {
        
        // We found one.  But before accepting it lets check for one
        // particular special case.  If the start address position is not locked
        // and the road suffix that ended this address also happens to be a 
        // numbered route prefix, the see if we can get a better address
        // match treating treating that as a number route prefix
        if (startAddress < 0 && isType(sEnd-1, ID_ROUTE_PFX)) {
          int tmp = sEnd-2;
          while (tmp > 0 && isType(tmp, ID_DIRECTION)) tmp--;
          if (tmp > sAddr) {
            int saveStartAddress =  startAddress;
            startAddress = tmp;
            if (parseSimpleAddress(result)) return true;
            startAddress = saveStartAddress;
          }
        }
        
        // Not problem, this will be the end of the address
        break;
      }
      
      // This isn't what we are looking for
      // Increment the search index and look for something else
      sAddr++;
    }
    
    // We have found what we need to have found and we are going
    // to be successful
    result.addressField = new FieldSpec(sAddr, sEnd);
    if (result.startField != null) result.startField.optionalEnd(locked ? sAddr-1 : sAddr);
    result.endAll = sEnd;
    
    // Special case - simple address can have intersection marker followed by
    // cross stream info.  But it has to be a real 1 token marker.  We do
    // not accept "N OF" type connectors here
    int tmp = findConnector(sEnd);
    if (tmp == sEnd+1) {
      findCrossStreetEnd(tmp, result);
    }
    
    // But there might be some additional cross street info we can parse
    findCrossStreet(result);
    
    // If we are looking for a pad field between the address and city
    // now is when we try to find that city
    if (padField) parsePadToCity(result.endAll, result);
    return (result.endAll == tokens.length || !isFlagSet(FLAG_ANCHOR_END));
  }

  /**
   * Look for intersection adddress with the basic form of
   *    <roadname> <road sfx> <connector> <roadname> <road sfx>
   * @return true if successful
   */
  private boolean parseIntersection(Result result) {
    
    result.reset(startAddress);
    boolean padField = isFlagSet(FLAG_ANY_PAD_FIELD);
    
    // First lets figure out where the address starts
    int sAddr;
    int ndx;
    
    boolean flexAt = isFlagSet(FLAG_AT_BOTH);
    boolean atStart = false;

    // If address starts at beginning of field, find end of address and
    // confirm that it starts with a road followed by a connector
    if (startAddress >= 0) {
      ndx = startIntersection(startAddress);
      if (ndx < 0) return false;
      sAddr = startAddress;
    }
    
    // Otherwise, scan forward looking for a <road-sfx> <connector> combination
    // Then back up 2 places assuming the road consists of one token.
    else {
      int start = startNdx;
      ndx = start;
      while (true) {
        if (flexAt && isAtSign(ndx)) atStart = true;
        ndx++;
        if (ndx >= tokens.length) return false;
        if (isType(ndx, ID_CROSS_STREET)) return false;

        if (atStart || flexAt && isType(ndx, ID_INCL_AT_MARKER)) {
          sAddr = ndx;
          ndx = startIntersection(sAddr);;
          if (ndx < 0) return false;
          break;
        }
        if (ndx-start >= 1) {
          int tmp = findConnector(ndx);
          if (tmp >= 0) {
            sAddr = ndx-1;
            ndx = tmp;
            
            // If cross street search, check for special cross street name
            if (isFlagSet(FLAG_ONLY_CROSS)) {
              tmp = mWordCrossStreetsRev.findEndSequence(sAddr);
              if (tmp >= 0) {
                sAddr = tmp;
                break;
              }
            }
            
            // skip over direction and bypass
            if (sAddr > start && isType(sAddr, ID_DIRECTION)) sAddr--;
            
            // See if this is a multi word street name without a suffix
            if (isFlagSet(FLAG_OPT_STREET_SFX)) {
              int save = sAddr;
              sAddr = mWordStreetsRev.findEndSequence(sAddr);
              if (sAddr != save) break;
            }
  
            // Skip over bypass
            if (sAddr > start && isType(sAddr, ID_BYPASS)) sAddr--;
            
            if (sAddr >= start && isRoadToken(sAddr)) break;
            
            if (sAddr > start && isType(sAddr, ID_ROAD_SFX)) {
              sAddr--;
              if (isType(sAddr,ID_NOT_ADDRESS|ID_NOT_STREET_NAME)) continue;
              sAddr = findRoadStart(start, sAddr);
              break;
            }
            
            // Check for a route prefix followed by a numeric or alpha route number
            // We check two positions for this sequence to catch the odd case where an alpha route number
            // has previously been mistaken for a direction
            // Good old St Louis County, MO. Thank your for creating a HWY W :(
            tmp = findRevNumberedHwy(start, sAddr);
            if (tmp < 0) tmp = findRevNumberedHwy(start, sAddr+1);
            if (tmp >= 0) {
              sAddr = tmp;
              break;
            }
            
            if (isFlagSet(FLAG_OPT_STREET_SFX) && !isType(sAddr,ID_NOT_ADDRESS)) break; 
  
            // One last chance.  If we skipped over a "BYPASS" token to get here
            // see if we can treat it as a suffix as well
            if (sAddr > start && isType(sAddr+1, ID_BYPASS)) {
              if (isType(sAddr,ID_NOT_ADDRESS)) continue;
              sAddr = findRoadStart(start, sAddr);
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
    // ndx points to the token following the connector

    // If there is a city terminating the address, just parse up to it
    if (!padField && parseAddressToCity(sAddr, ndx+1, result)) {
      if (atStart && result.startField != null) result.startField.fldEnd--;
      return true;
    }
    
    // Otherwise find end of second road
    ndx = findRoadEnd(ndx, 2);
    if (ndx < 0) return false;
    
    // If we found that, we have a successful intersection parse
    result.addressField = new FieldSpec(sAddr, ndx);
    if (startAddress < 0) result.startField.end(atStart ? sAddr - 1 : sAddr); 
    result.endAll = ndx;
    
    // But there might be some additional cross street info we can parse
    findCrossStreet(result);
    
    // If we are looking for a pad field between the address and city
    // now is when we try to find that city
    if (padField) parsePadToCity(result.endAll, result);

    return (result.endAll == tokens.length || !isFlagSet(FLAG_ANCHOR_END));
  }

  /**
   * Find beginning of street name once we have identified a legitimate street suffix
   * @param start hard beginning of possible street name
   * @param sAddr tentative begining of possible street name
   * @return
   */
  private int findRoadStart(int start, int sAddr) {
    
    // Two things to check.  First is to see if we have a recognized multi word street name
    int save = sAddr;
    if (mWordStreetsRev != null) sAddr = mWordStreetsRev.findEndSequence(sAddr);
    
    // If not, see if the first word is an ambiguous street suffix, and if it is, include the
    // previous word,
    if (sAddr == save && isAmbigRoadSuffix(sAddr)) sAddr--;
    return sAddr;
  }
  
  /**
   * Try to parse first part intersection starting at specified index
   * @param sAddr starting index
   * @return index of connector if successful, otherwise -1
   */
  private int startIntersection(int sAddr) {
    
    // Find end of road at specified start point
    int ndx = findRoadEnd(sAddr, 2);
    if (ndx < 0) return -1;
    
    //  Is this followed by a connector?
    return findConnector(ndx);
  }

  /**
   * Look for simple road without a house number or intersection
   *    <roadname> <roadsfx>
   * @return true if found 
   */
  private boolean parseNakedRoad(Result result) {
    
    result.reset(startAddress);
    boolean flexAt = isFlagSet(FLAG_AT_BOTH);
    boolean atStart = false;
    boolean padField = isFlagSet(FLAG_ANY_PAD_FIELD);
    
    // Normally we will consider the possiblilty that ST might be the
    // beginning of a street name starting with the abbrevation for Saint.
    // But don't try this if  there is a reason to expect a different
    // street following this one.
    boolean suppressSTLookahead = isFlagSet(FLAG_IMPLIED_INTERSECT|FLAG_CROSS_FOLLOWS);

    // If address starts at beginning of field, find end of address and
    // Don't have to look for city because we wouldn't be here if both startAddr
    // and city was found

    int sAddr, ndx;
    if (!flexAt && startAddress >= 0) {
      sAddr = ndx = startAddress;
      while (isType(ndx, ID_OPT_ROAD_PFX)) ndx++;
      ndx = findRoadEnd(ndx, 0);
      if (ndx < 0) return false;
    }
    
    // Otherwise, scan forward looking for a <road-sfx>
    //            that isn't the start of a <route-pfx> <number> combination
    // or number preceded by a <route-pfx>
    // or an ambiguous <road-sfx> followed by a second <road-sfx>
    else {
      int start = startNdx;
      ndx = start;
      boolean found = false;
      int failStart = -1;
      int failEnd = -1;
      while (true) {
        
        // See if there is a naked cross street name here.  Finding one doesn't
        // immediately return that result, but it defines the fallback result
        // we will use if something better doesn't come along.
        if (failStart < 0 && isFlagSet(FLAG_ONLY_CROSS)) {
          failEnd = mWordCrossStreetsFwd.findEndSequence(ndx);
          if (failEnd >= 0) failStart = ndx;
        }
        
        // See if we have a multi-word street match
        if (mWordStreetsFwd != null) {
          int tmp = mWordStreetsFwd.findEndSequence(ndx);
          if (tmp > ndx+1) {
            
            // If followed by a road suffix, this is what we are looking for
            if (isType(tmp, ID_ROAD_SFX)) {
              found = true;
              sAddr = ndx;
              ndx = tmp;
              break;
            }
            
            // Otherwise, use it as the failure fallback
            else if (failStart < 0) {
              failStart = ndx;
              failEnd = tmp;
            }
          }
        }
        
        
        if (flexAt && isAtSign(ndx)) atStart = true;
        ndx++;
        sAddr = ndx - 1;
        if (ndx >= tokens.length) break;
        if (isType(ndx, ID_CROSS_STREET)) break;
        if (atStart || flexAt && isType(ndx, ID_INCL_AT_MARKER)) {
          start = sAddr = ndx;
          ndx = findRoadEnd(sAddr, 0);
          ndx--;
          if (ndx >= 0) found = true;
          break;
        }
        
        if (isType(ndx, ID_ROAD_SFX) && !isType(sAddr, ID_NOT_ADDRESS|ID_NOT_STREET_NAME) && findConnector(sAddr)<0) {
          boolean startHwy = checkNumberedHwy(ndx) || 
                             ndx > start && findNumberedHwy(ndx-1) >= 0 ||
                             (isType(ndx, ID_AMBIG_ROAD_SFX) && (isType(ndx+1, ID_ROAD_SFX)));
          
          // If street suffix was ST, see if it might be the beginning of a street name
          // Don't do this if we are looking for an implied intersection
          if (!startHwy && !suppressSTLookahead && isType(ndx, ID_ST)) {
            if (!isType(ndx+1, ID_DIRECTION)) {
              int sEnd = findRoadEnd(ndx, 0);
              if (sEnd > 0) {
                found = true;
                sAddr = ndx;
                ndx = sEnd-1;
                break;
              }
            }
          }

          // OK, this is a legitimate street suffix
          // Check the multiple word street list to find the start of the
          // street name.  If not found, assume a one word street name.
          if (!startHwy) {
            found = true;
            
            // Assume one word street name, unless first word is an ambiguous suffix
            // in which case we keep expanding the street name
            while (sAddr > start && findConnector(sAddr-1)<0 && isAmbigRoadSuffix(sAddr)) {
              sAddr--;
            }
            break; 
          }
        }
        
        int tmp = findRevNumberedHwy(start, ndx);
        if (tmp >= 0) {
          sAddr = tmp;
          found = true;
          break;
        }
        
        if (isRoadToken(ndx)) {
          sAddr = ndx;
          found = true;
          break;
        }
      }
      
      // When we break out of this loop, see if we found a real street name
      // If we didn't, see if there is a fallback street name we can return
      // otherwise fail
      if (!found) {
        if (failStart < 0) return false;
        sAddr = failStart;
        ndx = failEnd;
      }
      
      else {
  
        // If the previous token is a direction, back up one more to include that.
        sAddr = stretchRoadPrefix(start, sAddr);
        
        // increment end pointer past the road terminator
        // and possibly over a trailing direction
        ndx++;
        ndx = bumpTrailingDir(ndx);
      }
      result.startField.end(atStart ? sAddr-1 : sAddr);
    }
    
    // When we get here, 
    // startAddress points to beginning of address
    // ndx points past the end of the road
    
    // We have a naked road parse
    result.addressField = new FieldSpec(sAddr, ndx);
    result.endAll = ndx;
    
    // If we are looking for implied intersection markers see if we can
    // find another street name immediately following this one.  If we can
    // then set the implied & column to the end of the first street and set
    // the end of the address field to the end of the second street.
    if (isFlagSet(FLAG_IMPLIED_INTERSECT)) {

      // if a street connector or mile marker follows the road name
      // do not insert an ampersand here
      int mark = result.endAll;
      if (!isType(mark, ID_MILE_MARKER) && findConnector(mark)<0) {
        
        boolean parseToEnd = !padField && parseAddressToCity(sAddr, ndx+1, result);
        if (parseToEnd) {
          result.insertAmp = mark;
          ndx = result.endAll;
        } else {
          ndx = findRoadEnd(ndx, 0);
          if (ndx >= 0) {
            result.insertAmp = result.endAll;
            result.addressField.end(ndx);
            result.endAll = ndx;
          }
        }
          
        // A direction token between the two streets is ambiguous.  The
        // initial road parsing logic would have assigned it to the first road
        // If we find that the first road ends with a direction, but the second
        // road does not, then reassign the direction token from the end of the
        // first road to the beginning of the second
        // This logic should also be suppressed if we are parsing cross streets
        // and the following address is a special cross street name
        if (result.insertAmp >= 0) {
          if (isType(result.insertAmp-1, ID_DIRECTION) &&
              !isType(result.insertAmp, ID_PURE_DIRECTION) &&
              !isType(result.addressField.fldEnd-1, ID_DIRECTION) &&
              (!isFlagSet(FLAG_ONLY_CROSS) ||  mWordCrossStreetsFwd.findEndSequence(result.insertAmp) < 0)) {
              result.insertAmp--;
          }
          if (parseToEnd) return true;
        }
      }
    }
    
    // See if we can parse out to a city
    if (!padField && parseAddressToCity(sAddr, result.endAll, result)) return true;
    
    // Nope, see if we can find some cross street info
    findCrossStreet(result);
    
    // If we are looking for a pad field between the address and city
    // now is when we try to find that city
    if (padField) parsePadToCity(result.endAll, result);

    return (result.endAll == tokens.length || !isFlagSet(FLAG_ANCHOR_END));
  }

  /**
   * Fallback parser used when nothing else works
   * @param sType
   */
  private void parseFallback(StartType sType, Result result) {

    result.reset(startAddress);
    boolean crossOnly = isFlagSet(FLAG_ONLY_CROSS);
    boolean padField = isFlagSet(FLAG_ANY_PAD_FIELD);
    boolean parseToCity = false;
    
    // Total failure, assign the entire field to either the call description
    // or the address
    int endAddr = result.tokens.length;
    result.endAll = endAddr;
    
    // Check for any invalid tokens.  If we find any they mark the end of any
    // possible address
    if (!isFlagSet(FLAG_ANCHOR_END) || padField) {
      int st = (startAddress >= 0 ? startAddress : 0);
      for (int ndx = st; ndx < endAddr; ndx++) {
        if (isType(ndx, ID_NOT_ADDRESS)) {
          endAddr = ndx;
          break;
        }
      }
      result.endAll = endAddr;
      if (padField && endAddr < result.tokens.length){
        int tmpNdx = endAddr;
        if (isComma(tmpNdx)) tmpNdx++;
        parsePadToCity(tmpNdx, result);
        parseToCity = true;
      }
    }
    
    if (!crossOnly) { 
      
      // If there is a cross street indicator, use it to set up the cross street
      for (int ndx = 0; ndx<endAddr; ndx++) {
        if (isType(ndx, ID_CROSS_STREET)) {
          result.crossField = new FieldSpec(ndx+1, endAddr);
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
      if (!isFlagSet(FLAG_IGNORE_AT)) {
        if (startAddress < 0 && isFlagSet(FLAG_AT_BOTH)) {
          for (int ndx = stIndex; ndx < endAddr; ndx++) {
            if (isAtSign(ndx)) {
              result.addressField = new FieldSpec(ndx+1, endAddr);
              endAddr = ndx;
              break;
            } else if (isType(ndx, ID_INCL_AT_MARKER)) {
              result.addressField = new FieldSpec(ndx, endAddr);
              endAddr = ndx;
              break;
            }
          }
        }
      }
      
      // We are really getting desperate, but see if there is a valid house number
      // in here, and if there is set the start address to it
      if (result.addressField == null && startAddress < 0) {
        for (int ndx = stIndex; ndx < endAddr-1; ndx++) {
          if (isHouseNumber(ndx) && !isType(ndx+1, ID_NOT_ADDRESS)) {
            if (ndx == 0 || ! isType(ndx-1, ID_RELATION)) {
              result.addressField = new FieldSpec(ndx, endAddr);
              endAddr = ndx;
              break;
            }
          }
        }
      }
    }
    
    // If we still don't have an address, see if this is an address or
    // skip start type.  If so, assign all of the remaining line as an address
    if (result.addressField == null) {
      if (startAddress >= 0) {
        result.addressField =  new FieldSpec(startAddress, endAddr);
        endAddr = startAddress;
      }
    }

    // However we managed to come up with an address, see if we can pick out a city
    // at the end of it.  If that fails, see if last token is an apt
    if (!crossOnly && !parseToCity && result.addressField != null) {
      int sAddr = result.addressField.fldStart;
      if (!parseAddressToCity(sAddr, sAddr+2, result)) {
        int tmpNdx = result.addressField.fldEnd-1;
        if (tmpNdx > 0) {
          if (isType(tmpNdx-1,ID_APT)) {
            result.aptField = new FieldSpec(tmpNdx, tmpNdx+1);
            result.addressField.fldEnd = tmpNdx-1;
          }
          else if (isAptToken(tokens[tmpNdx], false)) {
            result.aptToken = true;
            result.aptField = new FieldSpec(tmpNdx, tmpNdx+1);
            result.addressField.fldEnd = tmpNdx;
          }
        }
      }
    }
    
    // If we don't have an address, but are parsing to end of field,  see if we can
    // find a city at end of field
    else if (isFlagSet(FLAG_ANCHOR_END) && result.startField != null) {
      if (parseStartToCity(0, result)) endAddr = result.startField.fldEnd;
    }
    
    
    if (result.startField != null && startAddress < 0) result.startField.end(endAddr);
    
    
    // We aren't done yet.
    // if @ are being used to mark a place name, see if we can find one
    // in what we have for an address and split the rest into a place name
    if (isFlagSet(FLAG_AT_BOTH | FLAG_AT_PLACE) && result.addressField != null) {
      for (int ndx = result.addressField.fldStart; ndx<result.addressField.fldEnd; ndx++) {
        if (isAtSign(ndx)) {
          result.addressField.fldStart = ndx+1;
          if (result.startField != null) result.startField.end(ndx);
          break;
        } else if (isType(ndx, ID_INCL_AT_MARKER)) {
          result.addressField.fldStart = ndx;
          if (result.startField != null) result.startField.end(ndx);
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
   * 
   * @return index of presumed road name
   */
  private int stretchRoadPrefix(int start, int sAddr) {
    
    // If road starts with a common street name prefix, back up one place
    if (sAddr > start && isType(sAddr-1, ID_STREET_NAME_PREFIX)) sAddr--;
    
    // Look up to 3 tokens back to see if we find a direction token
    // Stop search if we encounter a /, lest we confuse a W/INJURY
    // as part of a road name
    for (int j = 1; j<= 3; j++) {
      int ndx = sAddr - j;
      if (ndx < start) break;
      if (tokens[ndx].equals("/")) break;
      if (isType(ndx, ID_NOT_ADDRESS)) break;
      if (findConnector(ndx)>=0 || ndx>0 && findConnector(ndx-1)==ndx+1) break;
      if (isType(ndx, ID_DIRECTION)) return sAddr-j; 
    }
    
    // No luck, see if the previous token is a possible road prefix
    if (sAddr > start && isType(sAddr-1, ID_OPT_ROAD_PFX)) sAddr--;
    
    // If road starts with a direction, back up one place
    if (sAddr > start && isType(sAddr, ID_DIRECTION)) sAddr--;
    return sAddr;
  }
  
  /**
   * Parse address field to city
   * @param stAddr prospective start of address field
   * @param srcNdx index to start searching
   * @param result Result object where results will be saved
   * @return true if city was found and all pertinent information was found.
   * False if not city was found and  nothing was changed in result
   */
  private boolean parseAddressToCity(int stAddr, int srcNdx, Result result) {
    FieldSpec addressField = new FieldSpec(stAddr);
    if (!parseToCity(addressField, true, srcNdx, result)) return false;
    result.addressField = addressField;
    if (result.startField != null) result.startField.optionalEnd(stAddr);
    return true;
  }
  
  /**
   * Parse pad field to city
   * @param start prospective start of pad field
   * @param result Result object where results will be saved
   * @return true if city was found and all pertinent information was found.
   * False if not city was found and  nothing was changed in result
   */
  private boolean parsePadToCity(int start, Result result) {
    FieldSpec padField = new FieldSpec(start);
    if (!parseToCity(padField, false, start, result)) return false;
    result.padField = padField;
    return true;
  }
  
  /**
   * Parse start field to City
   * @param start prospective start of pad field
   * @param result Result object where results will be saved
   * @return true if city was found and all pertinent information was found.
   * False if not city was found and  nothing was changed in result
   */
  private boolean parseStartToCity(int start, Result result) {
    return parseToCity(result.startField, false, start, result);
  }
    
  
  /**
   * See if we can parse an address from a known starting point to a city
   * @param fldSpec previous field being parsed
   * @param addr true if fldSpec is destined to be an address field spec
   * @param srcNdx start looking for city here
   * @return true if  city was identified and all fields have been set
   */
  private boolean parseToCity(FieldSpec fldSpec, boolean addr, int srcNdx, Result result) {
    
    // If we are doing a cross only parse without a city, answer is always no
    boolean crossOnly = isFlagSet(FLAG_ONLY_CROSS);
    if (crossOnly && !isFlagSet(FLAG_ONLY_CITY | FLAG_ANCHOR_END)) return false;
    
    // If FLAG_ANCHOR_END is set, we are going to parse this to the
    // end of the line without looking for a city
    boolean anchorEnd = isFlagSet(FLAG_ANCHOR_END);
    boolean parseToEnd = anchorEnd && ! isFlagSet(FLAG_CHECK_STATUS);
    boolean padField = isFlagSet(FLAG_ANY_PAD_FIELD);
    boolean cityOnly = isFlagSet(FLAG_ONLY_CITY);
    boolean nearToEnd = isFlagSet(FLAG_NEAR_TO_END);

    if (srcNdx >= tokens.length) return false;
    if (!parseToEnd && !nearToEnd && lastCity < srcNdx) return false;
    
    boolean flexAt = isFlagSet(FLAG_AT_PLACE | FLAG_AT_BOTH);
    
    // Notice: If the FLAG_ANY_PAD_FIELD was set, some of these fields might have
    // been found before the PAD field, in which case we don't want to disturb
    // them.
    FieldSpec placeField = null;
    FieldSpec aptField = null;
    FieldSpec crossField = null;
    FieldSpec nearField = null;
    boolean aptToken = false;
    
    FieldSpec startField = new FieldSpec(0);
    
    FieldSpec lastField = startField;
    for (int ndx = srcNdx-1; ndx < tokens.length; ndx++) {
      
      // Skip over multiword  street names
      if (mWordStreetsFwd != null && ndx >= 0) {
        int tmpNdx = mWordStreetsFwd.findEndSequence(ndx);
        if (tmpNdx > ndx+1) {
          if (isFlagSet(FLAG_NO_STREET_SFX)) ndx = tmpNdx;
          else if (isType(tmpNdx, ID_ROAD_SFX)) ndx = tmpNdx + 1;
        }
      }
      if (ndx < srcNdx) continue;
      
      // Is there a city here?
      int tmpNdx = ndx;
      if (isComma(tmpNdx)) tmpNdx++;
      int endCity = findEndCity(tmpNdx);
      if (endCity >= 0) {
        if (!anchorEnd || endCity == tokens.length) {
          lastField.end(ndx);
          if (placeField != null) result.placeField = placeField;
          if (aptField != null) {
            result.aptToken = aptToken;
            result.aptField = aptField;
          }
          if (crossField != null) result.crossField = crossField;
          if (nearField != null && nearField.fldEnd-nearField.fldStart > 1) result.nearField = nearField;
          result.cityField = new FieldSpec(tmpNdx, endCity);
          result.endAll = endCity;
          if (fldSpec != null) fldSpec.end(startField.fldEnd);
          
          // If there is a pad field, it might have the misfortune to be a 
          // place name that includes a local city name.  So we will call
          // ourselves recursively in an attempt to find another city name
          // behind this one
          if (isFlagSet(FLAG_PAD_FIELD) && endCity < tokens.length) {
            parseToCity(fldSpec, addr, endCity, result);
          }
          return true;
        }
      }
      
      // If we are only parsing a city field, skip all of the fancy stuff
      if (cityOnly) continue;
      
      // Only check for fun stuff if it isn't inside a pad field
      if (!padField) {
        
        // Check for place name
        if (flexAt && placeField == null) {
          if (isAtSign(tmpNdx)) {
            lastField.end(ndx);
            ndx = tmpNdx;
            lastField = placeField = new FieldSpec(ndx+1);
          } else if (isType(ndx, ID_INCL_AT_MARKER)) {
            lastField.end(ndx);
            ndx = tmpNdx;
            lastField = placeField = new FieldSpec(ndx);
          }
        }

        // Special stuff not checked for in cross street only parse
        if (!crossOnly) {

        // Check for apartment marker
          if (aptField == null) {
            if (tmpNdx+1 < tokens.length && isType(tmpNdx, ID_FLOOR | ID_APT) && 
                (!isType(tmpNdx, ID_APT_SOFT) || !isType(tmpNdx+1, ID_ROAD_SFX))) {
              lastField.end(ndx);
              ndx = tmpNdx;
              int tmp = ndx;
              if (!isType(tmp, ID_FLOOR)) tmp++;
              lastField = aptField = new FieldSpec(tmp);
            }
            else if (tmpNdx < tokens.length && isAptToken(tokens[tmpNdx], false)) {
              aptToken = true;
              lastField.end(ndx);
              ndx = tmpNdx;
              lastField = aptField = new FieldSpec(ndx);
            }
          }
          
          // Check for cross street marker
          if (crossField == null && isType(tmpNdx, ID_CROSS_STREET)) {
            lastField.end(ndx);
            ndx = tmpNdx;
            lastField = crossField = new FieldSpec(ndx+1);
          }
          
          if (nearField == null && isType(tmpNdx, ID_NEAR)) {
            lastField.end(ndx);
            ndx = tmpNdx;
            lastField = nearField = new FieldSpec(ndx);
          }
        }
      }
      
      // If we are processing an address field and we skipped over a comma
      // without finding anything, or encountered a non-address character
      // fail here
      if (addr && lastField == startField) {
        if (tmpNdx != ndx) return false;
        if (isType(ndx, ID_NOT_ADDRESS)) return false;
      }
      ndx = tmpNdx;
    }
    
    // If we are parsing to end of field, return successful status
    // If we are still processing a NEAR field and the FLAG_NEAR_TO_END
    // flag was set, do likewise
    if (parseToEnd ||
        nearToEnd && nearField != null && nearField == lastField) {
      lastField.end(tokens.length);
      if (placeField != null) result.placeField = placeField;
      if (aptField != null) {
        result.aptField = aptField;
        result.aptToken = aptToken;
      }
      if (crossField != null) result.crossField = crossField;
      if (nearField != null) result.nearField = nearField;
      result.endAll = tokens.length;
      if (fldSpec != null) fldSpec.end(startField.fldEnd);
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
    
    // If there is no city list, obviously there is no city
    if (mWordCities == null) return -1;
    
    // If this call should ignore any listed cities, return now
    if (isFlagSet(FLAG_NO_CITY)) return -1;

    // See if we can find the end of a city sequence
    // If not, then return -1;
    int endNdx = mWordCities.findEndSequence(ndx);
    if (endNdx < 0) return -1;
    
    // Under no circumstances will we accept a city ending with "CO" or "COUNTY" 
    // that is followed by the word "LINE" or "LIN".
    if (endNdx < tokens.length) {
      String lastWord = tokens[endNdx-1].toUpperCase();
      if (lastWord.equals("CO") || lastWord.equals("COUNTY")) {
        lastWord = tokens[endNdx].toUpperCase();
        if (lastWord.equals("LINE") || lastWord.equals("LIN")) return -1;
      }
    }
    
    // We found a real city.  But....
    // We don't want to return this as a city if it look it might by a street
    // named after that city :(
    
    // But we do not have to worry about that if we are only parsing a city name
    if (isFlagSet(FLAG_ONLY_CITY) && !isFlagSet(FLAG_ONLY_CROSS)) return endNdx;
    
    // OK, we have to do this....
    // If the city is followed by a road suffix, disqualify it
    // Unless the road suffix is followed by a road suffix
    boolean crossFollows = isFlagSet(FLAG_CROSS_FOLLOWS);
    if (isType(endNdx, ID_ROAD_SFX) && !isType(endNdx+1, ID_ROAD_SFX)) {
      
      // Or unless there might be a following cross street, and the street suffix
      // found after the city can start a valid road name in its own right
      if (!crossFollows || findRoadEnd(endNdx, 3) < 0) { 
        
        // Another exception is if the road suffix is "DR" and is followed
        // by a known  Doctor name
        // Or ST followed by a known Saint name
        if (!isType(endNdx, ID_DR) || !isType(endNdx+1, ID_DOCTOR)) {
          if (!isType(endNdx, ID_ST) || !isType(endNdx+1, ID_SAINT)) return -1;
        }
      }
    }
    
    // A road suffix one or two tokens past the end of the city also disqualifies it
    // Except some times there really is cross street information following
    // the address, in which case just ignore all the above
    if (!crossFollows) {
      if (isRealRoadSuffix(endNdx+1) || isRealRoadSuffix(endNdx+2)) return -1;
    }
    
    // Looks good, lets return this
    return endNdx;
  }
  
  /**
   * Determine if token is unambiguous street suffix
   * @param ndx - token index
   * @return true if token at index it unambiguous street suffix
   */
  private boolean isRealRoadSuffix(int ndx) {
    return isType(ndx, ID_ROAD_SFX) && !isType(ndx, ID_AMBIG_ROAD_SFX);
  }
  
  /**
   * Determine if token is a potential ambiguous road suffix, which means
   * road names should generally include the word in front of this
   * @param ndx token index
   * @return true if previous word should be included in road name
   */
  private boolean isAmbigRoadSuffix(int ndx) {
    
    // If this is the first token, obviusly we cannot include a previous word
    if (ndx == 0) return false;
    
    // Is this a potential ambiguous road suffix
    if (!isType(ndx, ID_AMBIG_ROAD_SFX)) return false;
    
    // If the previous word cannot be an address, answer is no
    if (isType(ndx-1,ID_NOT_ADDRESS)) return false;
    
    // One more special case, if there might not be a delimiter
    // between the start field and address, and the previous word
    // looks like it might consist of a merged word and house number
    if (isFlagSet(FLAG_START_FLD_NO_DELIM) && MIXED_WORD_PTN.matcher(tokens[ndx-1]).matches()) return false;
    
    // Otherwise we are good to go
    return true;
  }
  private static final Pattern MIXED_WORD_PTN = Pattern.compile("[A-Z]+\\d+", Pattern.CASE_INSENSITIVE);

  /**
   * See if we can find some additional cross street information after
   * the end of a successfully parsed address
   */
  private void findCrossStreet(Result result) {
    
    if (isFlagSet(FLAG_ONLY_CROSS)) return;
    
    if (result.endAll >= tokens.length) return;
    
    // check for optional place marker
    if (isFlagSet(FLAG_AT_PLACE | FLAG_AT_BOTH)) {
      if (isAtSign(result.endAll)) {
        result.endAll++;
        result.placeField = new FieldSpec(result.endAll);
      }
      else if (isType(result.endAll, ID_INCL_AT_MARKER)) {
        result.placeField = new FieldSpec(result.endAll);
      }
      
      // Alas, we don't have any way to guess at how long the place name
      // might be.  Default to one word, unless we find another marker
      // further down the road
      if (result.placeField != null) {
        result.endAll++;
        for (int ndx = result.endAll; ndx < tokens.length; ndx++) {
          if (isType(result.endAll, ID_NOT_ADDRESS)) break;
          if (isType(ndx, ID_APT | ID_CROSS_STREET) ||
              isAptToken(ndx)) {
            result.endAll = ndx;
            break;
          }
        }
        result.placeField.end(result.endAll);
      }
    }
    
    // First lets look for an apartment
    int ndx = result.endAll;
    if (isComma(ndx)) ndx++;
    if (isType(ndx, ID_APT)) {
      if (++ndx < tokens.length) {
        result.aptField = new FieldSpec(ndx, ++ndx);
        result.endAll = ndx;
      }
    }
    
    else if (isAptToken(ndx)) {
      result.aptToken = true;
      result.aptField = new FieldSpec(ndx, ++ndx);
      result.endAll = ndx;
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
    int ndx = sEnd;
    while (true) {
      
      // And try to find another road
      ndx = findRoadEnd(ndx, 2);
      if (ndx < 0) break;
      sEnd = ndx;
      
      // If this road was terminated by a connector
      // Loop back and see if we can find another cross street
      int tmp = findConnector(sEnd);
      if (tmp < 0) break;
      ndx = tmp;
    }
    
    // Success, save the cross street location
    if (sEnd > sCross) {
      result.crossField = new FieldSpec(sCross, sEnd);
      result.endAll = sEnd;
    }
  }

  /**
   * See if we can identify a road name starting at a given index
   * @param start starting index
   * @param option - option controlling how we will deal with a suffixless street search
   *                  0 - No suffixless street names accepted
   *                  1 - only multiword suffixless street names accepted
   *                  2 - any suffixless street name accepted
   *                  3 - Only identified multiword or numbered highway names accepted
   * @return index of token past end of road name if successful, -1 otherwise
   */
  private int findRoadEnd(int start, int option) {
    
    // Skip over BLOCK indicator
    if (isType(start, ID_BLOCK)) start++;
    
    // If this starts with a street direction, skip over it
    if (isType(start, ID_DIRECTION)) start++;
    
    // Ditto for a street prefix
    // But save the original start position, some checks will use this
    // original start position and some will used the prefix adjusted start
    // position
    int origStart = start;
    if (isType(start, ID_OPT_ROAD_PFX)) start++;
    
    // If we are out of tokens, the answer is no
    if (origStart >= tokens.length) return -1; 
    
    // Dummy loop that we can break out of when we find a road end
    int end;
    do {
      
      // See if this is the start of a multi word street name
      // terminated by a proper road suffix
      int mWordIndex = -1;
      if (mWordStreetsFwd != null) {
        mWordIndex = mWordStreetsFwd.findEndSequence(origStart);
        if (mWordIndex > origStart+1) {
          if (isType(mWordIndex, ID_ROAD_SFX)) {
            if (isType(mWordIndex, ID_AMBIG_ROAD_SFX) && isType(mWordIndex+1, ID_ROAD_SFX)) mWordIndex++;
            end = mWordIndex+1;
            break;
          }
          if (isFlagSet(FLAG_NO_STREET_SFX)) {
            end = mWordIndex;
            break;
          }
        }
      }
      
      // Compute the failure index that we return if we fail to find a proper road end.
      // If we are processing cross streets, check for a special cross street name and
      // set the failure index to the end of that
      int failIndex = -1;
      if (isFlagSet(FLAG_ONLY_CROSS)) {
        failIndex = mWordCrossStreetsFwd.findEndSequence(origStart);
      }
      
      // if we are accepting roads without a street suffix, we will compute the
      // default value assuming this is a suffixless street name.  If not, the failure return
      // is always -1;
      if (failIndex < 0 && option > 1 && isFlagSet(FLAG_OPT_STREET_SFX|FLAG_NO_STREET_SFX)) {
        if (isType(start, ID_NOT_ADDRESS|ID_NOT_STREET_NAME) || findConnector(start)>=0) return -1;
        if (mWordIndex >= 0) {
          failIndex = mWordIndex;
        } else {
          failIndex = start+1;
        }
        if (option < 2 && failIndex - start < 2) failIndex = -1;
      }
      
      if (isType(start, ID_NOT_ADDRESS) || findConnector(start)>=0) return failIndex;
      
      // A stand alone road token can terminate the road search, but it must
      // be the first thing in the search sequence
      if (isRoadToken(start)) {
        end = start+1;
        break;
      }
      
      // See if this is a numbered highway
      end = findNumberedHwy(start);
      if (end >= 0) {
        
        // Yet another special case Texas FM number highways can be terminated
        // with a street suffix :(
        if (tokens[start].equalsIgnoreCase("FM")) {
          if (isType(end+1, ID_ROAD_SFX)) end++;
        }
        end++;
        
        // If this is a route prefix extension, (possibly following a direction)
        // we normally skip past it.
        // But do not do this if we are in implied intersections and it
        // looks like the beginning of another numbered hwy
        int tend = end;
        if (isType(tend, ID_DIRECTION)) tend++;
        if (isType(tend, ID_ROUTE_PFX_EXT)) {
          if (!isFlagSet(FLAG_IMPLIED_INTERSECT) || !isType(tend, ID_ROUTE_PFX) || !isType(tend+1, ID_ALPHA_ROUTE)) end = tend+1;
        }
        break;
      }
      
      // OK, OK, if we find a number followed by a connector, we will consider
      // it a numbered highway (sheesh)
      if (isType(start, ID_NUMBER) && findConnector(start+1)>=0) return start+1;
      
      // Still no luck,
      // If we are deliberately ignoring street suffixes, take what we have so far
      // Possibly incrementing the result over a road suffix that is right here.
      if (isFlagSet(FLAG_NO_STREET_SFX)) {
        if (failIndex > 0) {
          if (isType(failIndex-1, ID_NOT_STREET_NAME)) return -1;
          if (isType(failIndex, ID_ROAD_SFX)) failIndex++;
        }
        end = failIndex;
        break;
      }
      
      // If we only accept numbered highways, time to bail out
      if (option == 3) return -1;

      // start looking for a street suffix (or cross street indicator
      // If we have to pass more than two tokens before finding, give up
      end = origStart;
      boolean good = false;
      boolean number = false;
      while (++end - start <= 3) {
        
        // An intersection marker marks the end of things
        if (findConnector(end)>=0) {
          end = failIndex;
          break;
        }

        // See if this is a normal road suffix
        // Skip if it an ambiguous road suffix and a real road suffix follows it
        // Or if the road suffix is part of a two part highway number
        // Or if this is a TO route prefix phrase
        good = true;
        if (isType(end, ID_ROAD_SFX) && !isType(end-1, ID_NOT_STREET_NAME) &&
            (! (isType(end, ID_AMBIG_ROAD_SFX) && isType(end+1, ID_ROAD_SFX))) &&
            ( !checkNumberedHwy(end)) &&
            (findNumberedHwy(end-1) < 0) && 
            (! (isType(end, ID_ROUTE_PFX) && isType(end-1, ID_TO)))) {
          end++; 
          break; 
        }
        if (isType(end, ID_CROSS_STREET)) break;
        
        // A numeric token is acceptable only if it is the last token in the street name
        good = false;
        if (number) break;
        if (isType(end, ID_NUMBER)) number = true;
      }
      
      if (!good) end = failIndex;
      
    } while (false);
    
    // if we swappend in failIndex for end, it might be negative
    if (end < 0) return -1;
    
    // Check for BYPASS
    if (isType(end, ID_BYPASS)) end++;
    
    // If road is followed by a direction and that direction can not be part of
    // a following cross street, include it
    if (isType(end, ID_DIRECTION) && !isType(end+1, ID_OF)) {
      if (!isFlagSet(FLAG_CROSS_FOLLOWS) || end+1 == tokens.length || isComma(end+1) || findConnector(end+1)>=0) end++;
    }
    return end;
  }

  private void setTokenTypes(StartType sType, String address, String gpsCoords, Result result) {
    // Parse line into tokens and categorize each token
    // While we are doing this, identify the index of the last city
    // And see if we have a keyword flagging the start of the address
    startAddress =  -1;
    lastCity = -1;
    startNdx = isFlagSet(FLAG_START_FLD_REQ) ? 1 : 0;
    
    // A lot of special constructs need to be protected.  Which we will accomplish
    // by creating a second version of the address line that will be used to
    // identify the token positions with the line.  While the original address line
    // will be used to actually extract the token values
    String searchAddress = address;
    
    // GPS Coordinates can now contain blanks or colons, which we need to go to some trouble
    // to temporarily replace so they do not result in the coordinates being broken up
    if (gpsCoords != null) {
      String altGPSCoords = gpsCoords.replaceAll(".", "~");
      searchAddress = searchAddress.replace(gpsCoords, altGPSCoords);
    }
    
    // The field delimiter pattern we use will break tokens before and after any / or & 
    // characters.  But there are some special constructs that we do not want broken up.
    // These need to be protected
    
    Matcher match = PROTECTED_TOKEN_PTN.matcher(searchAddress);
    if (match.find()) {
      StringBuffer  sb = new StringBuffer();
      do {
        match.appendReplacement(sb, match.group().replace('/', '%').replace('&', '%'));
      } while (match.find());
      match.appendTail(sb);
      searchAddress = sb.toString();
    }

    // Now scan through the protected address line using the field token
    // delimiter pattern to identify the start and end of each token
    // Despite our best effort, there are case where the pattern may detect
    // back to back delimiters and we have to take steps to prevent that 
    // from producing zero length tokens
    List<Integer> tokenStartList = new ArrayList<Integer>();
    List<Integer> tokenEndList = new ArrayList<Integer>();
    match = TOKEN_DELIM_PTN.matcher(searchAddress);
    int lastEnd = 0;
    while (match.find()) {
      int st = match.start();
      int end = match.end();
      if (st > lastEnd) {
        tokenStartList.add(lastEnd);
        tokenEndList.add(st);
      }
      lastEnd = end;
    }
    if (lastEnd < address.length()) {
      tokenStartList.add(lastEnd);
      tokenEndList.add(address.length());
    }
    
    int cnt = tokenStartList.size();
    tokenPos = new int[cnt];
    tokens = new String[cnt];
    for (int ndx = 0; ndx < cnt; ndx++) {
      int st = tokenStartList.get(ndx);
      tokenPos[ndx] = st;
      tokens[ndx] = address.substring(st, tokenEndList.get(ndx));
    }
    
    result.tokens = tokens;
    
    // Save the original address
    // When parsing is finished, we will use this to calculate the true prefix and leftover segments
    saveAddress = address;
    
    tokenType = new long[tokens.length];
    boolean flexAt = isFlagSet(FLAG_AT_PLACE | FLAG_AT_BOTH);
    boolean ignoreAt = isFlagSet(FLAG_IGNORE_AT);
    
    if (sType == StartType.START_ADDR) startAddress = 0; 
    else result.startField = new FieldSpec(0); 
    
    boolean setStart = (startAddress < 0 || flexAt);
    boolean pastAddr = false; 
    for (int ndx = 0; ndx < tokens.length; ndx++) {
      setType(ndx, setStart, pastAddr);
      if (isType(ndx, ID_CROSS_STREET | ID_APT)) {
        pastAddr = true;
        setStart = false;
      }
      if (setStart && !flexAt && !ignoreAt) {
        if (isAtSign(ndx)) {
          result.startField.end(ndx);
          startAddress = ndx + 1;
        } else if (isType(ndx, ID_INCL_AT_MARKER)) {
          result.startField.end(ndx);
          startAddress = ndx;
        }
      }
      if (isType(ndx, ID_CITY)) lastCity = ndx;
    }
  }
  
  // Sequence containing slashes that need to be protected
  private static final Pattern PROTECTED_TOKEN_PTN = Pattern.compile("\\bC/S:|\\b(?:\\d/\\d|AT&T|C/S)\\b");
  
  // Token delimiter pattern should find field breaks
  // 1) for any sequence of one or more blanks
  // 2) Before or after any & or / or comma
  // 3) After any :
  // 4) For any period not followed by a space
  private static final Pattern TOKEN_DELIM_PTN = 
      Pattern.compile("\\.?(?:\\s+|(?<! )(?=[/&,])|(?<=[/&,:])(?! )|(?<=\\.)(?![ \\d])|,)");

  // Identify token type
  private void setType(int ndx, boolean checkAt, boolean pastAddr) {
    String token = tokens[ndx];
    
    // If token contains any illegal characters, flag it as a non-address token
    // and bail out.  This is only a problem if we are still in the address proper
    // If we have passed the address and are now in apt or cross fields, illegal
    // character tokens are OK
    if (!pastAddr && badCharPtn.matcher(token).find()) {
      tokenType[ndx] |= ID_NOT_ADDRESS;
      return;
    }
    
    // If token is longer than 1 char and starts with an @
    // Strip off the @ and add the ID_INCL_START_MARK flag
    long mask = 0;
    if (checkAt && token.length() > 1 && token.charAt(0) == '@') {
      tokens[ndx] = token = token.substring(1);
      mask = ID_INCL_AT_MARKER;
    }
    
    // If token ends with a numeric comparison character, set the relation flag
    char chr = token.charAt(token.length()-1);
    if ("=><".indexOf(chr) >= 0) mask |= ID_RELATION;
    
    // If token is in dictionary, return the associated type code
    // City codes are not permitted to follow intersection connectors, cross
    // street markers, or at markers for fear they might be a street with the
    // same name as a city
    Long iType = dictionary.get(token.toUpperCase());
    if (iType != null) {
      long iiType = iType;
      
      // If @ is being used as a cross street marker, switch any tokens marked
      // as at signs to connectors
      if (isFlagSet(FLAG_AT_MEANS_CROSS)) {
        if ((iiType & ID_AT_MARKER) != 0) {
          iiType = (iiType & ~ID_AT_MARKER) | ID_CONNECTOR;
        }
      }
      mask |= iiType;
      if (ndx > 0 && isType(ndx-1, ID_CONNECTOR | ID_CROSS_STREET | ID_AT_MARKER) ||
          ndx > 1 && isType(ndx-2, ID_CONNECTOR | ID_CROSS_STREET | ID_AT_MARKER) && isType(ndx-1, ID_DIRECTION)) {
        mask &= ~ID_CITY;
      }
    }
    
    // Numeric tokens 9 digits or longer are probably SSNs or phone numbers
    // which should be marked as non-address tokens
    else if (NUMERIC.matcher(token).matches()) {
      if (token.length() >= 9) {
        tokenType[ndx] |= ID_NOT_ADDRESS;
        if (isFlagSet(FLAG_ANCHOR_END) && !isFlagSet(FLAG_ANY_PAD_FIELD)) startNdx = ndx+1;
        return;
      }
      else mask |= ID_NUMBER | ID_ALPHA_ROUTE;
    }
    
    // Some states use alpha route numbers.  This token is a candidate if
    // it hasn't been designated as anything else
    // it is one or two characters long
    // all of the characters are letters
    // it is not a common 2 letter word
    // The ordinal directions (NSEW) may be legitimate alpha routes (grumble)
    if (mask == 0) {
      if (ROUTE_NUMBER_PTN.matcher(token).matches()) mask |= ID_ALPHA_ROUTE;
    } else {
      if (allowDirectionHwyNames && token.length() == 1 && "NSEW".contains(token)) {
        mask |= ID_ALPHA_ROUTE;
      }
    }
    
    tokenType[ndx] =  mask;
  }
  private static final Pattern ROUTE_NUMBER_PTN = Pattern.compile("(?!IN|OF)[A-Z]{1,2}|\\d+[ABHNSEW]?");
  
  private boolean isAtSign(int ndx) {
    if (! isType(ndx, ID_AT_MARKER)) return false;
    if (!isFlagSet(FLAG_AT_SIGN_ONLY)) return true;
    return tokens[ndx].equals("@");
  }
  
  private boolean isComma(int ndx) {
    if (ndx >= tokens.length) return false;
    return tokens[ndx].equals(",");
  }
  
  private int findConnector(int ndx) {
    if (isType(ndx, ID_CONNECTOR)) {
      if (isFlagSet(FLAG_AND_NOT_CONNECTOR) && isType(ndx, ID_AND_CONNECTOR)) return -1;
      return ndx+1;
    }
    if (isType(ndx, ID_DIRECTION) && isType(ndx+1, ID_OF)) return ndx+2;
    
    return -1;
  }
  
  /**
   * find end of number highway name
   * @param ndx possible start of numbered highway name
   * @return index of last token in numbered  highway name if found
   * -1 if not found
   */
  private int findNumberedHwy(int ndx) {
    return findNumberedHwy(ndx, false);
  }
  
  /**
   * Check a potential road suffix to confirm that is not the start
   * of a numbered highway.  A single route prefix and number will not
   * be considered since it is more likely to be a route suffix followed
   * by an apt number.
   * @param ndx index road suffix to be checked
   * @return true if this does look more like the start of a numbered
   * highway than an ending road suffix
   */
  private boolean checkNumberedHwy(int ndx) {
    return (findNumberedHwy(ndx, true) >= 0);
  }
  
  /**
   * find end of number highway name
   * @param ndx possible start of numbered highway name
   * @param boolean strict true if this should be a strict positive
   * identification check (ie.  Not a street suffix followed by an apt)
   * @return index of last token in numbered  highway name if found
   * -1 if not found
   */
  private int findNumberedHwy(int ndx, boolean strict) {
    if (isType(ndx, ID_ROUTE_PFX_PFX) && isType(ndx+1, ID_ROUTE_PFX_EXT) && isType(ndx+2, ID_ALPHA_ROUTE)) {
      
      // More special cases.  In a strict search, if a cross street might follow this address and
      // the token following this one starts a legitimate numbered highway name, then disgregard 
      // this one
      if (strict && findNumberedHwy(ndx+1, false) >= 0) return -1;
      
      // Otherwise return the end of this numbered highway
      return ndx+2;
    }
    if (!strict && isType(ndx, ID_ROUTE_PFX) && isType(ndx+1, ID_ALPHA_ROUTE)) return ndx+1;
    return -1;
  }
  
  /**
   * find end of number highway name
   * @param start hard start of address field
   * @param ndx possible end of numbered highway name
   * @return one beginning index of numbered highway name if found
   * -1 if not found
   */
  private int findRevNumberedHwy(int start, int ndx) {
    if (ndx <= start) return -1;
    if (!isType(ndx, ID_ALPHA_ROUTE)) return -1;
    if (ndx > start+1 && isType(ndx-2, ID_ROUTE_PFX_PFX) && isType(ndx-1, ID_ROUTE_PFX_EXT)) return ndx-2;
    if (isType(ndx-1, ID_ROUTE_PFX)) return ndx-1;
    return -1;
  }

  /**
   * Bump index over trailing direction
   * @param ndx current end address
   * @return adjusted end address
   */
  private int bumpTrailingDir(int ndx) {
    
    // Bump pass bypass word
    if (isType(ndx, ID_BYPASS)) ndx++;
    
    // If the following token is a direction, increment end pointer past that too
    // unless we expected a following cross street, in which case the direction should
    // be considered part of the following cross street
    // unless the direction token is the last token in which case there can't be a following
    // cross street, can there
    // Also do not do this if the word following the direct is "OF".
    if ((!isFlagSet(FLAG_CROSS_FOLLOWS) || ndx+1 == tokens.length) && isType(ndx, ID_DIRECTION) && !isType(ndx+1, ID_OF)) ndx++;
    return ndx;
  }

  private boolean isType(int ndx, long mask) {
    if (ndx >= tokenType.length) return false; 
    return (tokenType[ndx] & mask) != 0;
  }
  
  private boolean isFlagSet(int mask) {
    return (flags & mask) != 0;
  }
  
  // Determine if token is a single standalone road token
  // such as I-234, or US50, or RT250NB :(
  private boolean isRoadToken(int ndx) {
    
    // If reserved single word name, answer is yes
    if (isType(ndx, ID_SINGLE_WORD_ROAD)) return true;
    
    // If illegal char, answer is no
    if (isType(ndx, ID_NOT_ADDRESS | ID_CONNECTOR)) return false;
    
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
    if (token.charAt(pt) == '-') pt++;
    
    // If next character is not a digit, answer is no
    if (pt >= token.length() || ! Character.isDigit(token.charAt(pt))) return false;
    
    // Shift the alpha portion upper case and see if what is left is a route prefix
    String pfx = token.substring(0, pta).toUpperCase();
    Long mask = dictionary.get(pfx);
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

        if (sfx.length() == 1 && 
            "NESW".indexOf(sfx.charAt(0)) >= 0) break;
        
        // Nothing recognized, return false
        return false;
        
      } while (false);
    }
    return true;
  }
  
  // Determine if token is a valid house number
  private boolean isHouseNumber(int ndx) {
    
    // If numeric token, answer is yes
    if (isType(ndx, ID_NUMBER)) return true;
    
    // If not address, return false
    if (isType(ndx, ID_NOT_ADDRESS)) return false;
    
    // Try it against the numeric street number pattern
    // which allows a trailing letter qualifier
    if (ndx >= tokens.length) return false;
    return isHouseNumber(tokens[ndx]);
  }

  /**
   * Determine if token is a house number
   * @param token token to be checked
   * @return true if this is a house number
   */
  protected boolean isHouseNumber(String token) {
    if (token.equals("7-11")) return false;
    if (PAT_HOUSE_NUMBER.matcher(token).matches()) return true;
    return false;
  }
  
  // Determine if token at index is a standalone apartment number
  private boolean isAptToken(int ndx) {
    if (ndx >= tokens.length) return false;
    return isAptToken(tokens[ndx], !isFlagSet(FLAG_NO_IMPLIED_APT));
  }
  
  /**
   * Determine if token is a valid single apartment token
   * @param token token to be checked
   * @param numberOK true if tokens that start with a digit should be considered valid
   * @return true if this is an apartment token
   */
  private boolean isAptToken(String token, boolean numberOK) {
    
    // Do not accept fractions
    if (token.contains("/")) return false;
    
    int pt = getAptBreak(token);
    if (pt < 0) return false;
    
    // Check for reserved things that look like street names
    if (isFlagSet(FLAG_CROSS_FOLLOWS) && token.length() >= 3) {
      String tail = token.substring(token.length()-3).toUpperCase();
      if (tail.equals("1ST") || tail.equals("2ND") || tail.equals("3RD") || tail.substring(1).equals("TH")) return false;
    }
    if (pt == 0) return numberOK & token.length()-pt <= 4;
    String prefix = token.substring(0,pt).toUpperCase();
    Long flags = dictionary.get(prefix);
    return flags != null && (flags & ID_APT) != 0;
  }

  /**
   * Extract the Apt value from a token that has previously been
   * identified as a single word apartment token
   * @param token token to be checked
   * @return apartment value
   */
  private static String getAptValue(String token) {
    int pt = getAptBreak(token);
    return token.substring(pt);
  }
  
  /**
   * Identify the break between the Apt keyword and value in a token
   * that we are trying to identify as a single word apt token
   * @param token Token to be checked
   * @return offset into token of start of apartment value
   */
  private static int getAptBreak(String token) {
    if (token.startsWith("#")) return 1;
    Matcher match = DIGIT.matcher(token);
    if (match.find()) return match.start();
    return -1;
  }
  private static final Pattern DIGIT = Pattern.compile("\\d");
  
  /**
   * This class contains a searchable list of multi word items.  It will be
   * used to keep two lists.  One of multi-word cities, and another of multi-word
   * streets.
   */
  private class MultiWordList {
    
    private int dir;
    private long idFlag;
    private long incompFlag;
    private long completeFlag;
    private List<String[]> wordList = null;
    
    /**
     * Create a multiword list
     * @param dir search direction +1 for forward search, -1 for backward search
     * @param idFlag token flag used to objects in this list.  If zero any
     * token will be considered to be at least a single word match
     * @param incompFlag token flag used to mark beginning of multiword sequences
     * @param completeFlag token flag used to mark complete single word sequence.
     * Not used if idFlag is zero
     * @param nameList list of possibly multiword names to be added to list
     */
    public MultiWordList(int dir, long idFlag, long incompFlag, long completeFlag, String[] nameList) {
      this.dir = (dir < 0 ? -1 : 1);
      this.idFlag = idFlag;
      this.incompFlag = incompFlag;
      this.completeFlag = completeFlag;

      addNames(dir, nameList);
    }

    public void addNames(int dir, String[] nameList) {
      
      long flags1 = idFlag | incompFlag;
      long flags2 = idFlag | completeFlag;
      // Run thorough the city list
      for (String name : nameList) {
        
        // If city name does not contain a blank, we are not interested in it
        if (name.contains(" ")) {
          
          // Break up city name into token list.
          // If this a backward search list, reverse the tokenList word order
          if (wordList == null) wordList = new ArrayList<String[]>();
          String[] tokenList = name.split(" +");
          if (dir < 0) {
            for (int ndx = 0; ndx < tokenList.length/2; ndx++) {
              int ndx2 = tokenList.length-ndx-1;
              String tmp = tokenList[ndx];
              tokenList[ndx] = tokenList[ndx2];
              tokenList[ndx2] = tmp;
            }
          }
          
          // Add the token list to the word list
          wordList.add(tokenList);
          
          // And add the first token to the dictionary as an incomplete city
          if (flags1 != 0) setupDictionary(flags1, tokenList[0]);
          
          // Add the rest of the tokens to the dictionary with no flags
          // Doesn't hurt the address parsing logic and the weird DispatchEmergitechParser
          // subclasses work better if these are in the dictionary
          for (int ndx = 1; ndx < tokenList.length; ndx++) setupDictionary(0, tokenList[ndx]);
        }
        
        // Otherwise, we just add this to dictionary as a normal city
        else {
          if (flags2 != 0) setupDictionary(flags2, name);
        }
      }
    }
    
    /**
     * Search for a single or multi-word sequence begining at specfied index
     * @param ndx specified token index
     * @return if no sequence found, return -1.
     * If search direction is forward returns one past the end of a found sequence
     * If search direction is backward, returns the beginning of found sequence
     */
    public int findEndSequence(int ndx) {
      
      // If there is an ID token flag, and isn't set for this index, look no further 
      if (idFlag != 0 && !isType(ndx, idFlag)) return -1;
      
      // If this is flagged as the start of a multi-word entry, see if
      // we find a match in the muti-word list
      // If there are multiple matches, pick the longest
      int foundLen = 0;
      if (isType(ndx, incompFlag) && wordList != null) {
        for (String[] tokenList : wordList) {
          boolean match = true;
          for (int j = 0; j< tokenList.length; j++) {
            int jj = ndx + j*dir;
            if (jj < 0 || jj >= tokens.length ||
                ! tokenList[j].equalsIgnoreCase(tokens[jj])) {
              match = false;
              break;
            }
          }
          if (match) {
            if (tokenList.length > foundLen) foundLen = tokenList.length;
          }
        }
      }

      // If we didn't find a multiword match, see if this is flagged as a complete
      // single word match.  If there was no completeFlag, than any single word
      // item will be considered a match.  If no singleword match, return -1
      if (foundLen == 0) {
        if (completeFlag == 0 || isType(ndx, completeFlag)) foundLen = 1;
        else return -1;
      }
      
      // Compute the end (or beginning) index of what we have found and return it.
      int endNdx = ndx + foundLen*dir;
      if (dir < 0) endNdx++;
      return endNdx;
    }
  }
  
  private static class FieldSpec {
    int fldStart;
    int fldEnd;
    
    public FieldSpec(int fldStart) {
      this(fldStart, -1);
    }

    public FieldSpec(int fldStart, int fldEnd) {
      this.fldStart = fldStart;
      this.fldEnd = fldEnd;
    }
    
    public void end(int fldEnd) {
      this.fldEnd = fldEnd;
    }

    public void optionalEnd(int fldEnd) {
      if (this.fldEnd < 0) this.fldEnd = fldEnd;
    }
  }
  
  private static final Pattern NO_DELIM_ADDR_PTN1 = Pattern.compile("(?<!\\d)\\d+\\b");  
  private static final Pattern NO_DELIM_ADDR_PTN2 = Pattern.compile("(?<!\\d)\\d+$");  
  public static class Result {
    
    // We do need to access our parent object for global configuration settings
    // and to perform additional calculations.  But we must never refer to any
    // local variables used in calculating this result that may have been
    // overridden by a second calculation.  So, we declare Result as static to
    // avoid accidental references to local members, but save the parent object
    // so we can use it when we have determined that it is safe to do so.
    private SmartAddressParser parent;
    private int flags;
    
    private String[] tokens;
    private StartType startType;
    private int status = -1;
    private String callPrefix = null;
    private String stdPrefix = null;
    private FieldSpec startField = null;
    private FieldSpec addressField = null;
    private FieldSpec placeField = null;
    private boolean aptToken = false;
    private FieldSpec aptField = null;
    private FieldSpec crossField = null;
    private FieldSpec padField = null;
    private FieldSpec cityField = null;
    private FieldSpec nearField = null;
    private int insertAmp = -1;
    int endAll = -1;
    private Result nearResult = null;

    private String startFld = null;
    private String left = null;
    private boolean mBlankLeft = false;
    private boolean commaLeft = false;
    
    public Result(SmartAddressParser parent, int flags) {
      this.parent = parent;
      this.flags = flags;
    }
    
    public void reset(int startAddress) {
      if (startAddress < 0) startField.end(-1);
      addressField = null;
      placeField = null;
      aptToken = false;
      aptField = null;
      crossField = null;
      padField = null;
      cityField = null;
      insertAmp = -1;
      endAll = -1;
    }
   
    /**
     * Determine Determine how good an address this parse call found
     * @return zero if string is not recognized as valid address, otherwise a
     * numeric value in which higher values indicate better addresses
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
     * Determine Determine how good an address this parse call found
     * @return true if this is a valid address
     */
    public boolean isValid() {
      return status > STATUS_MARGINAL;
    }
    
    /**
     * Determine Determine how good an address this parse call found
     * @param extra number of extra tokens (presumably city names) that can
     * be ignored at the end of the line
     * @return true if this is a valid address
     */
    public boolean isValid(int extra) {
      if (tokens == null) return false;
      if (tokens.length-endAll > extra) return false;
      return isValid();
    }
  
    /**
     * Fill data object with information from parsed line
     */
    public void getData(MsgInfo.Data data) {
      
      if (addressField != null) data.strAddress = stripLeadingZero(buildData(addressField, 2));
      if (placeField != null) data.strPlace = buildData(placeField, 0);
      if (aptField != null) {
        String apt =  buildData(aptField, 0);
        if (aptToken) apt = getAptValue(apt);
        else if (apt.startsWith("#")) apt = apt.substring(1).trim();
        data.strApt = apt;
      }
      if (crossField != null) data.strCross = buildData(crossField, 1);
      if (cityField != null) {
        data.strCity = buildData(cityField, 0);
        if (parent.cityCodes != null) {
          String city = parent.cityCodes.getProperty(data.strCity.toUpperCase());
          if (city != null) data.strCity = city;
        }
      }
      
      // Before we figure out with to do with the leading start field, see if some of it
      // should be stripped off and added to the address
      // We use two pattern searches to do this.  If no address has been found, look for
      // any word ending in 1 or more digits.  If we found an address but the result 
      // status indicates it did not find a street number, restrict the previos search
      // to the last word of the start field.  if we find a match for either pattern
      // move the digits and everything following them to the address field
      startFld = stdPrefix;
      if ((flags & FLAG_START_FLD_NO_DELIM) != 0) {
        Pattern searchPtn = null;
        if (data.strAddress.length() == 0) {
          searchPtn = NO_DELIM_ADDR_PTN1;
        } else if (status < STATUS_FULL_ADDRESS) {
          searchPtn = NO_DELIM_ADDR_PTN2;
        }
        if (searchPtn != null) {
          Matcher match = searchPtn.matcher(startFld);
          if (match.find()) {
            int pt = match.start();
            data.strAddress = append(startFld.substring(pt), " ", data.strAddress);
            startFld = startFld.substring(0,pt);
          }
        }
      }
      
      if (callPrefix != null) data.strCall = callPrefix;
      
      // If no address field has been found, but we have a start field and caller
      // has requested fallback to put everything in the address field, make it so
      if (data.strAddress.length() == 0 && startFld.length() > 0 && (flags & FLAG_FALLBACK_ADDR) != 0) {
        parent.parseAddress(startFld, data);
        startFld = "";
      }
      
      // Otherwise, assign the start field to where it seems appropriate
      else {
        switch (startType) {
          case START_CALL:
          case START_CALL_PLACE:
            data.strCall = append(data.strCall, " / ", startFld);
            break;
          case START_PLACE:
            if (data.strPlace.length() == 0) data.strPlace = startFld;
            break;
        case START_ADDR:
          break;
        case START_OTHER:
          break;
        }
      }
    
      // We do the NEAR field last, because it requires a lot of special treatment
      if (nearField != null) {
        
        // If there is no cross street and the near field content looks like an
        // address, stick it in the cross street.
        // Otherwise append the full term to the place field
        String field = buildData(nearField, 0);
        String field2 = null;
        int pt = field.indexOf(' ');
        if (pt >= 0) field2 = field.substring(pt+1);
        
        boolean nearPlace = true;
        if (field2 != null && data.strCross.length() == 0) {
          
          // If we found a city, the near field has a well defined end
          // and we can just call checkAddress to see if the near field is
          // an address or not
          if (data.strCity.length() > 0) {
            if (parent.isValidAddress(field2)) {
              data.strCross = field2;
              nearPlace = false;
            }
          }
          
          // If there is no city, things get complicated.  This could only have
          // happened if the FLAG_NEAR_TO_END flag was specified and we have
          // to make another call to parseAddress to see how much of the
          // near field looks like an address.  Whatever is left will be saved
          // and returned by a call to our getLeft() method.
          else {
            Result res = parent.parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field2);
            if (res.isValid()) {
              res.getData(data);
              nearResult = res;
              nearPlace = false;
            }
          }
        }
        if (nearPlace) data.strPlace = append(data.strPlace, " ", field); 
      }

      // See if we should check for non-numeric apartment fields following the address
      if ((flags & FLAG_RECHECK_APT) != 0 && data.strApt.length() == 0) {
        String addr = data.strAddress;
        String cross = data.strCross;
        data.strAddress = "";
        
        Result result = parent.parseAddress(StartType.START_ADDR, FLAG_NO_CITY, addr);
        result.getData(data);
        String apt1 = result.getLeft();
        String apt2 = append(data.strApt, " ", apt1);
        if (apt2.length() == 0 || parent.isNotExtraApt(apt1)) {
          data.strAddress = addr;
          data.strCross = cross;
          data.strApt = "";
          Matcher match = ADDR_TRAIL_FL.matcher(addr);
          if (match.find()) {
            data.strAddress = addr.substring(0,match.start());
            data.strApt = match.group(1);
          }
        } else {
          Matcher match = ADDR_PLACE_MARK.matcher(apt1);
          if (match.matches()) {
            data.strPlace = append(data.strPlace, " - ", match.group(1));
          } else {
            data.strApt = apt2;
          }
        }
      }
    }
    
    /**
     * return the start field that is fond in front of the address
     */
    public String getStart() {
      if (startFld == null) {
        throw new RuntimeException("Invalid call to getStart()");
      }
      return startFld;
    }
    
    /**
     * @return the pad field (if any) that lies between the address property and
     * the city field
     */
    public String getPadField() {
      return buildData(padField, 0);
    }

    /**
     * Called after address has been parsed
     * @return the part of the line after the address
     */
    public String getLeft() {
      if (nearResult != null) return nearResult.getLeft();
      return left;
    }
    
    /**
     * Determine there were multiple blanks directly in front of the string
     * returned by getLeft()
     * @return true if there were multiple blanks before the getLeft() result
     */
    public boolean isMBlankLeft() {
      if (nearResult != null) return nearResult.isMBlankLeft();
      return mBlankLeft;
    }
    
    /**
     * Determine there was a comma in front of the string returned by getLeft()
     * @return true if there was a comma before the getLeft() result
     */
    public boolean isCommaLeft() {
      if (nearResult != null) return nearResult.isCommaLeft();
      return commaLeft;
    }
    
    /**
     * @return whatever was identifying as being in front of the address
     */
    public String getAddressPrefix() {
      return buildData(startField, 0);
    }
    
    /**
     * @return everything from start of identified address to end of string
     */
    public String getFullAddress() {
      if (addressField ==  null) return null;
      return buildData(addressField.fldStart, endAll, 0);
    }

    /**
     * @return parsed city field
     */
    public String getCity() {
      return buildData(cityField, 0);
    }
    
    private String buildData(FieldSpec spec, int addrCode) {
      if (spec == null) return "";
      return buildData(spec.fldStart, spec.fldEnd, addrCode);
    }
  
    /**
     * Construct data field from the token sequence from given start and end position
     * @param start starting token index
     * @param end ending token index
     * @param addr code indicating what should be inserted between street names
     *         0 nothing or leave existing slash
     *         1 - slash
     *         2 - ampersand
     * @return Constructed data field.
     */
    private String buildData(int start, int end, int addrCode) {
      
      boolean atToCross = ((flags & FLAG_AT_MEANS_CROSS) != 0);
      StringBuilder sb = new StringBuilder();
      for (int ndx = start; ndx < end; ndx++) {
        
        // Comma is a special case.  Skip if first token in sequence
        // otherwise inhibit the usual blank placed between it and the
        // previous token
        String token = tokens[ndx];
        if (token.equals(",")) {
          if (ndx == start) continue;
        } else {
          if (sb.length() > 0) sb.append(' ');
        }
        
        // Insert & if required
        if (ndx == insertAmp) {
          sb.append(new String[]{"", "/ ", "& "}[addrCode]);
        }
        if (addrCode>1 && 
            (token.equals("/") || 
             (atToCross && token.equalsIgnoreCase("AT")))) token = "&";
        sb.append(token);
      }
      return sb.toString();
    }
  }
  private static final Pattern ADDR_PLACE_MARK = Pattern.compile("^(?:AT |@) *(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern ADDR_TRAIL_FL = Pattern.compile(" +(\\d+ *FL)$", Pattern.CASE_INSENSITIVE);
  
  /**
   * Check a potential extra apartment field for constructs that do 
   * not look like apartment fields
   * @param apt prospective extra apartment field
   * @return true if this does not look like a possible apartment field
   */
  protected boolean isNotExtraApt(String apt) {
    return NOT_APT_PTN.matcher(apt).matches();
  }
  private static final Pattern NOT_APT_PTN = Pattern.compile("(?:[&/]|(?:MM|EX|NORTH|SOUTH|EAST|WEST|PRIOR|BLK|MILE|BEFORE|AFTER|RUNAWAY|OFF|FROM|NEAR|OFF)\\b).*", Pattern.CASE_INSENSITIVE);
}
