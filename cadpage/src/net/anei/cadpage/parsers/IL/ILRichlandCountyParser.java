package net.anei.cadpage.parsers.IL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Richland County, IL
Contact: "Olney FD" <office@olneyfd.com
Sender: messaging@iamresponding.com
System: Information Technologies, Inc
FIRE/RESCUE will turn into department code soon

FIRE/RESCUE - 5755 N SHIPLEY OLNEY - BARN ON FIRE
FIRE/RESCUE - DEERFARM/SHIPLEY -
FIRE/RESCUE - S PALMER ST NOBLE -
FIRE/RESCUE - 225 S PALMER ST NOBLE - VEH ON FIRE
FIRE/RESCUE - 4752 N SHIPLEY OLNEY -
FIRE/RESCUE - 380 W SOUTH NOBLE - DAN ROBINSON REQUEST NOBLE FIRE RESPOND AS HE HAS A HOT ELCECTICAL SMELL COMING FROM HIS HALLWAY BELIVED TO BE THE ATTIC.
FIRE/RESCUE - E PARKERSBURG LN - -
FIRE/RESCUE - 325N NOBLE - -
FIRE/RESCUE - 225 S PALMER ST NOBLE - VEH ON FIRE
FIRE/RESCUE - S PALMER ST NOBLE -
FIRE/RESCUE - 5755 N SHIPLEY OLNEY - BARN ON FIRE
FIRE/RESCUE - 2631 E ELBOW LN NOBLE - - REC'D 911 CELL CALL OF A BRUSH OR FIELD FIRE. ORIGINAL CALL WAS N OF 450N AND BETWEEN 600E AND 700E. TONED OUT NFD. 2203 MCCORMICK CALLED AND ADV'D THAT ALAN WALKER HAD A CONTROLLED BURN LAST NIGHT AND IS NOT SURE IF THEY HAVE STARTED IT BACK UP THIS MORNING, BUT WILL BE RESPONDING TO CHECK. MN
FIRE/RESCUE - 3772 E TWIN BRIDGE LN - -

*/

public class ILRichlandCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" -(?= |$)");
  
  public ILRichlandCountyParser() {
    super(CITY_LIST, "RICHLAND COUNTY", "IL",
           "SRC ADDR/S INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!parseFields(DELIM.split(body,-1), 3, data)) return false;
    int len = data.strSupp.length();
    if (len == 0) {
      data.strCall = "ALERT";
    } else if (len <= 40) {
      data.strCall = data.strSupp;
      data.strSupp = "";
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
      // Incorporated
      "CALHOUN",
      "CLAREMONT",
      "NOBLE",
      "OLNEY",
      "PARKERSBURG",
      // Unincorporated
      "BERRYVILLE",
      "DUNDAS",
      "WYNOOSE",
      // Townships
      "BONPAS TWP",
      "CLAREMONT TWP",
      "DECKER TWP",
      "DENVER TWP",
      "GERMAN TWP",
      "MADISON TWP",
      "NOBLE TWP",
      "OLNEY TWP",
      "PRESTON TWP"
  };
  
}
