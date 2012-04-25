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

Contact: Justin Gattorno <jgattorno@gmail.com>
Sender: wgfc22@comcast.net
(Dispatch) 03/21/12 * 13:49:18 * MOBILE HOME/TRAILER FIRE * * 8 VIEW LA ,58 * WESTVIEW WY & DEAD END * PENN * - *  * 610-960-709 * 2204 *  * 22 * Dispatch *
(Dispatch) 03/23/12 * 11:11:49 * HOUSE FIRE * * 64 RICHARDS LA,88   (NV) *  *  * ** X-STRT DARIEN RD - COVERED * NCC *  *  *  *  * Dispatch *
(Dispatch) 04/23/12 * 11:59:38 * ACCIDENT - UNKNOWN INJURIES * * WB W AVONDALE RD WO STATE RD ,71   (V) *  * NEWLON * - *  * C610-299-21 * 1202 *  * 12 * Dispatc

*NOT PARSING* (missing city)
(Dispatch) 04/24/12 * 14:21:46 * DEBRIS / FD RESP * * RT 796/RT 896 ,71    (V) *  *  * ON 896 AT THE SPLIT AT 796- * PSPA *  * 1201 *  * 12 * Dispatch * 

 */


public class PAChesterCountyEParser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile(" \\*");
  
  public PAChesterCountyEParser() {
    super("DATE! TIME! CALL APT ADDRCITY X/Z+? CITY! PLACE NAME PHONE UNIT EMPTY? SRC?");
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
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("*")) field = field.substring(1).trim();
      if (field.startsWith("X-STRT ")) {
        field = field.substring(7).trim();
        int pt = field.indexOf(" - ");
        if (pt >= 0) {
          data.strSupp = field.substring(pt+3).trim();
          field = field.substring(0,pt).trim();
        }
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "X INFO";
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.equals("Dispatch")) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
} 
