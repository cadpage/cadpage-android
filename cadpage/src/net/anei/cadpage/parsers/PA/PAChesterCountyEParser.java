package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;


/* 
Chester County, PA (Variant E)
Contact: jtg5097@yahoo.com <jtg5097@yahoo.com>
Sender: wgfc22@comcast.net

(Dispatch) 05/31/11 * 13:30:52 * SYNCOPE/FAINTING - ALS * * 880 W BALTIMORE PK ,58 * LEWIS RD & PUSEY MILL RD * PENN * WELLNESS CENTER OFFICE-SOUTHER * GRANDEL,
(Dispatch) 05/31/11 * 11:10:31 * OTHER TYPE RESCUE * * 880 W BALTIMORE PK ,58 * LEWIS RD & PUSEY MILL RD * PENN * IN PLOT-YMCA *  * 910-750-762 * 2264 *  * 22 *
(Dispatch) 05/31/11 * 09:30:53 * HYPO TENSION - ALS * * 774 W GLENVIEW DR ,58 * PHEASANT WY & EDGEWOOD CT * PENN * - *  * 610-345-136 * 2203 *  * 22 * Dispatch *
(Dispatch) 05/31/11 * 00:36:12 * BARN FIRE * * 248 HOOD RD ,48 * MUNICIPAL BOUNDARY & N MOSQUITO LA * WMARLB * - *  * 610-316-731 * 3604   * 36 * Dispatch *

 */


public class PAChesterCountyEParser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile(" \\*");
  
  public PAChesterCountyEParser() {
    super("DATE! TIME! CALL APT ADDRCITY X X/Z? CITY! PLACE NAME PHONE UNIT EMPTY? SRC");
  }
  
  @Override
  public String getFilter() {
    return "wgfc22@comcast.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatch")) return false;

    // Split and parse by asterisk delimiters
    return parseFields(DELIM.split(body), data);
  }
} 
