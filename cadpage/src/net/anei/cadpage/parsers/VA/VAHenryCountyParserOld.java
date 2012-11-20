package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class VAHenryCountyParserOld extends SmartAddressParser {
  
  private static final String DEF_STATE = "VA";
  private static final String DEF_CITY = "HENRY COUNTY";

  private static final String[] CITY_LIST = new String[]
      {"RIDGEWAY", "MARTINSVILLE", "SPENCER", "BASSETT", "COLLINSVILLE", "FIELDALE", "AXTON"}; 
  private static final MatchList CITY_MATCH = new MatchList(CITY_LIST);
  
  public VAHenryCountyParserOld() {
    super(CITY_LIST, DEF_CITY, DEF_STATE);
  }

  @Override
  public String getFilter() {
    return "@ridgewayrescue.com,@ridgewayfire.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (! subject.equals("CAD Call")) return false;

    // Split body by newline terminators
    String[] lines = body.split(" *\n *");
    
    // First pass through lines looking for the address line
    // which we identify because it ends with one of our known city names
    int addrNdx = -1;
    for (int ndx = 1; ndx < lines.length; ndx++) {
      String line = lines[ndx];
      int pt = line.lastIndexOf(' ');
      if (pt >= 0) {
        String token = line.substring(pt+1);
        if (CITY_MATCH.contains(token)) {
          addrNdx = ndx;
          break;
        }
      }
    }
    
    // If we didn't find an address line, pick line 2 if there is one
    // or the last line if their isn't
    if (addrNdx < 0) addrNdx = Math.min(2, lines.length-1);

    // Now make a second pass through the lines
    for (int ndx = 0; ndx < lines.length; ndx++) {
      String line = lines[ndx];
      
      // First line always contains call ID
      if (ndx == 0) {
        if (line.startsWith("(CAD Call)")) line = line.substring(10).trim();
        data.strCallId = line;
      }
      
      // If not address line, line 2 contains the unit and call description
      else if (ndx == 1 && ndx < addrNdx) {
        int pt = line.indexOf(' ');
        if (pt >= 0) {
          String tmp = line.substring(0, pt);
          if (tmp.contains("-(")) {
            data.strUnit = tmp.trim();
            line = line.substring(pt+1);
          }
        }
        data.strCall = line.trim();
      }
      
      // Beyond the second line, any line before the address line contains a place name
      else if (ndx < addrNdx) {
        if (data.strPlace.length() > 0) data.strPlace += ' ';
        data.strPlace += line;
      }
      
      // When we get to the address line, use the smart address parser to pick
      // the beginning of the address from any preceding place names.  Unless we
      // already have a place name, in which case address must start the line
      else if (ndx == addrNdx) {
        if (line.endsWith(" Not Entered")) line = line.substring(0,line.length()-12).trim();
        StartType start = (data.strPlace.length() > 0 ? StartType.START_ADDR : StartType.START_PLACE);
        parseAddress(start, line, data);
      }
      
      // Lines beyond the address line go into supplemental info
      else {
        if (data.strSupp.length() > 0) data.strSupp += " / ";
        data.strSupp += line;
      }
    }
    
    return true;
  }
}
