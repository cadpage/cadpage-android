package net.anei.cadpage.parsers.MA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Yarmouth, MA
Contact: Charles Talbott <medic2@comcast.net>

 109 NOTTINGHAM DR\nNO NAME\nYARMOUTH\nMedical Priority 2/3\n2_East_1\n\nNotes\nPOSSIBLE UNATTENDED
 579 BUCK ISLAND RD\nMAYFLOWER PLACE\nYARMOUTH\nMedical Priority 2/3\n3_South_1\n\nNotes\nBREWSTER UNIT EYE SWELLING
 43 MEDINAH DR\n2_West_3\n\nNotes\nDEHYDRATION SHORTNESS OF BREATH
 55 COTTONWOOD ST\nBACK PAIN
 19 FLICKER LN\n1_East_2\n\nNotes\n87 Y/O MALE DIFF BREATHING
 33 LEWIS RD\n3_South_1\n\nNotes\nUNRESPONSIVE FEMALE
 121 CAMP ST\nMILL POND VILLAGE\nYARMOUTH\nAFA (residential)\n3_North_2
 23 TASMANIA DR\n2_East_1
 6 SQUIRREL RUN\nNO NAME\nYARMOUTH\nCO Asymptomatic\n2_West_3\n\nNotes
 0 ROUTE 6\nNO NAME\nYARMOUTH\nMVC\nMID-CAPE HIGHWAY\n\nNotes\n6 EAST BOUND JUST PAST EXIT 8\n

*/

public class MAYarmouthParser extends MsgParser {
  
  private static final Pattern PRIORITY_PTN = Pattern.compile("Medical Priority (\\d)/\\d");
  private static final Pattern MAP_PTN = Pattern.compile("\\d_(?:North|East|South|West)_\\d");
  
  public MAYarmouthParser() {
    super("YARMOUTH", "MA");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    String[] flds = body.split("\n+");
    if (flds.length < 2) return false;
    if (flds[0].length() == 0) return false;
    if (!Character.isDigit(flds[0].charAt(0))) return false;
    
    boolean found = false;
    String field = flds[0].trim();
    if (field.startsWith("0 ")) field = field.substring(2).trim();
    parseAddress(field, data);
    for (int ndx = 1; ndx<flds.length; ndx++) {
      field = flds[ndx].trim();
      
      if (field.length() == 0) continue;
      if (field.equals("NO NAME") ||
          field.equals("YARMOUTH") ||
          field.equals("Notes")) {
        found = true;
        continue;
      }
      
      if (data.strPriority.length() == 0) {
        Matcher match =  PRIORITY_PTN.matcher(field);
        if (match.matches()) {
          found = true;
          data.strPriority = match.group(1);
          continue;
        }
      }
      
      if (data.strMap.length() == 0 && MAP_PTN.matcher(field).matches()) {
        found = true;
        data.strMap = field;
        continue;
      }
      
      if (!found) {
        found = true;
        data.strPlace = field;
        continue;
      }
      
      if (data.strCall.length() == 0) {
        data.strCall = field;
      } else {
        data.strSupp = append(data.strSupp, " / ", field);
      }
    }
    
    if (data.strCall.length() == 0) {
      data.strCall = data.strPlace;
      data.strPlace = "";
    }
    return true;
  }
}
