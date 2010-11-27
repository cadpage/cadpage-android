package net.anei.cadpage;

import java.util.HashMap;
import java.util.Map;

import net.anei.cadpage.parsers.SmsMsgParser;


/**
 * This class takes care of allocating the correct parser for a location code
 */
public class ManageParsers {
  
  // The name of the general alert parser code
  private static final String ALERT_PARSER = "GeneralAlert";
  
  // Table mapping known location codes to their corresponding parser
  private Map<String, SmsMsgParser> parserMap = new HashMap<String, SmsMsgParser>();
  
  private String curLocCode = null;
  private SmsMsgParser curParser = null;
 
  // Private constructor, no body can build this except getInstance()
  private ManageParsers() {}
  

  /**
   * Get parser corresponding to location code
   * @param location requested location code or null to use current config setting
   * @return requested parser
   */
  public SmsMsgParser getParser(String location) {
    
    // First level cache.  If location code matches what we have stored for
    // the current location code, return the current parser
    String curLocation = null;
    if (location == null) curLocation = location = ManagePreferences.location();
    if (location.equals(curLocCode)) return curParser;
    
    // Second level cache, see if it is the our table of parsers by location
    SmsMsgParser parser = parserMap.get(location);
    if (parser == null) {
      
      // No such luck.  We will have to find the parser class and instantiate it
      String className = "net.anei.cadpage.parsers." + location + "Parser";
      try {
        parser = (SmsMsgParser)Class.forName(className).newInstance();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
      
      // Then save the location and parser in our parser table 
      parserMap.put(location, parser);
    }
    
    // Before we return the parser we found, see if the requested location
    // matches the current location setting.  If it does, save the values
    // in the first level cache
    if (curLocation == null) curLocation = ManagePreferences.location();
    if (location.equals(curLocation)) {
      curLocCode = location;
      curParser = parser;
    }
    return parser;
  }
  
  /**
   * @return parser used to process general alerts (no parsing no address)
   */
  public SmsMsgParser getAlertParser() {
    return getParser(ALERT_PARSER);
  }
  
  private static ManageParsers instance = new ManageParsers();
  
  /**
   * @return singleton instance of ManageParsers
   */
  public static ManageParsers getInstance() {
    return instance;
  }

}
