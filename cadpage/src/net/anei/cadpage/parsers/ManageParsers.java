package net.anei.cadpage.parsers;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



/**
 * This class takes care of allocating the correct parser for a location code
 */
public class ManageParsers {
  
  // The name of the general alert parser code
  private static final String ALERT_PARSER = "GeneralAlert";
  
  // Table mapping known location codes to their corresponding parser
  private Map<String, MsgParser> parserMap = new HashMap<String, MsgParser>();
  
  private String curLocCode = null;
  private MsgParser curParser = null;
 
  // Private constructor, no body can build this except getInstance()
  private ManageParsers() {}
  
  /**
   * Get parser corresponding to location code
   * @param location requested location code or null to use current config setting
   * @return requested parser
   */
  public MsgParser getParser(String location) {
    
    // Convert any old codes that have been renamed to new values
    location = convertLocationCode(location);
    
    // First level cache.  If location code matches what we have stored for
    // the current location code, return the current parser
    if (location.equals(curLocCode)) return curParser;
    
    // Second level cache, see if it is the our table of parsers by location
    MsgParser parser = parserMap.get(location);
    if (parser == null) {
      
      // Otherwise we need to create a new parser
      // First see if there are multiple location parsers
      if (location.contains(",")) {
        
        // If there are, call ourselves recursively to allocate each
        // individual parser
        String[] locationList = location.split(",");
        MsgParser[] parserList = new MsgParser[locationList.length];
        for (int ii = 0; ii<locationList.length; ii++) {
          parserList[ii] = getParser(locationList[ii]);
        }
        parser = new GroupBestParser(parserList);
      }
      
      // Otherwise find the parser class and instantiate it
      else {
        String className = getParserClassname(location);
        try {
          parser = (MsgParser)Class.forName(className).newInstance();
        } catch (Exception ex) {
          throw new RuntimeException("Failed to instantiate " + className + '\n' + ex.getMessage(), ex);
        }
      }
      
      // Then save the location and parser in our parser table 
      parserMap.put(location, parser);
    }
    
    // Before we return the parser we found, save parser in primary cache
    curLocCode = location;
    curParser = parser;
    return parser;
  }
  
  /**
   * Get fully qualified parser class name associated with location
   * @param location requested location
   * @return parser class name
   */
  private String getParserClassname(String location) {
    
    String pkg = null;
    if (location.startsWith("ZCA")) {
      pkg = location.substring(0,5);
    } else if (location.startsWith("Z")) {
      pkg = location.substring(0,3);
    } else if (Character.isUpperCase(location.charAt(1))) {
      pkg = location.substring(0,2);
    } else if (location.startsWith("Dispatch")) {
      pkg = "dispatch";
    } else if (location.startsWith("General") || location.startsWith("Standard")) {
      pkg = "general";
    }
    StringBuffer sb = new StringBuffer();
    sb.append(this.getClass().getPackage().getName());
    sb.append('.');
    if (pkg != null) {
      sb.append(pkg);
      sb.append('.');
    }
    sb.append(location);
    sb.append("Parser");
    return sb.toString();

  }
  
  /**
   * @return parser used to process general alerts (no parsing no address)
   */
  public MsgParser getAlertParser() {
    return getParser(ALERT_PARSER);
  }
  
  /**
   * Return location name associated with location code
   * @param location location code
   * @return location name 
   */
  public String getLocName(String location) {
    
    // Location shouldn't be null, but upstream bugs are setting it this
    // so at least don't die over it
    if (location == null) return "";
    
    return getParser(location).getLocName();
  }
  
  private static ManageParsers instance = new ManageParsers();
  
  /**
   * @return singleton instance of ManageParsers
   */
  public static ManageParsers getInstance() {
    return instance;
  }
  
  /**
   * Convert old codes that have been renamed to something else
   * @param location requested location code
   * @return possibly updated location code
   */
  public static String convertLocationCode(String location) {
    return MsgParser.convertCodes(location, OLD_CODE_TABLE);
  }
  
  // fixed map mapping old to new location codes
  private static final Properties OLD_CODE_TABLE = MsgParser.buildCodeTable(new String[]{
        "TXNassauBay",        "TXLaPorte",              // 01/06/2013
        "NVLasVegas",         "NVClarkCounty",          // 01/26/2013
        "ORMarionCountyN",    "ORMarionCounty",         // 03/14/2013
        "OHXenia",            "OHGreeneCounty",         // 03/18/2013
        "NCGreensboro",       "NCGuilfordCounty",       // 03/22/2013
        "NCDavieCountyA",     "NCDavieCounty",          // 09/30/2013
        "NCDavieCountyB",     "NCDavieCounty",          // 09/30/2013
        "NJHudsonCounty",     "NJJCMCEMSHudCEN",        // 11/22/2013
        "NJJCMCEMSHudCEN",    "NJJCMCEMSJerseyCity",    // 12/27/2013
        "CTLitchfieldCountyB","CTNewMilford",           // 12/28/2013
        "TXMontgomeryCountyC","TXMontgomeryCountyB",    // 02/26/2014
        "VALexingtonRockbridgeCounty", "VARockbridgeCounty",   //03/05/2014
        "MDHarford",          "MDHarfordCounty",        // 03/09/2014
        "TXWilliamsonCountyA","TXWilliamsonCounty",     // 04/24/2014  
        "TXWilliamsonCountyB","TXWilliamsonCounty",     // 04/24/2014
        "VAPrinceWilliamCountyA","VAPrinceWilliamCounty",// 04/26/2014
        "VAPrinceWilliamCountyB","VAPrinceWilliamCounty",// 04/26/2014
        "TXCombine",          "TXKaufmanCounty",         // 06/03/2014
        "PAChesterCountyK",   "PAChesterCountyD1",       // 07/22/2014
        "OHHarveysburg",      "PAWarrenCountyC"         // 08/02/2014
        
  });

}
