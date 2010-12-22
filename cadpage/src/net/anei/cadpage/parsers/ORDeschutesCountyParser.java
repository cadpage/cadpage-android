package net.anei.cadpage.parsers;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Deschutes County, OR
Contact:joanne day <frankday12@gmail.com>
Sender: 911@deschutes.org

Chest Pain Breathing normally => 35   -C-STA500-9395 SW SCOUT CAMP TRL-Map 131208-11:38:0
Sick Person Vomiting   -A-STA500-13852 SW CANYON DR-Map 131216-18:47:56
DEAD BODY/DEATH R3-R3-STA500-14537 SW STALLION DR-Map 131223-10:23:46
Falls Unk status Ground-B-STA500-13345 SW CINDER DR-Map 131215-00:30:04
Traffic Accidents HIGH MECH - Rollover-D2-STA500-SW BADGER RD/SW CHINOOK DR--13:11:56
Sick Person Abnormal breathing -C-512,571-8431 SW BASALT DR-Map 131216-10:46:05
Sick Person Vomiting   -A-STA500-13812 SW CANYON DR-Map 131216-18:47:56
*/


public class ORDeschutesCountyParser extends SmsMsgParser {
  
  private static final Pattern UNIT_PAT = Pattern.compile("(\\d\\d\\d)(,\\d\\d\\d)*");
  
  public ORDeschutesCountyParser() {
    super("DESCHUTES COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "911@deschutes.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Normally broken by dash field separators.
    // but a dash with a space on both side is probably a "REAL" dash and
    // needs to be projected form our parsing breaks
    body = body.replaceAll(" - ", "__");
    String[] flds = body.split("-");
    if (flds.length < 5) return false;
    
    int ndx = 1;
    for (String fld : flds) {
      fld = fld.trim();
      switch (ndx) {
      
      // First field is always the call description
      // remember to restore protected dashes
      case 1:
        data.strCall = fld.replaceAll("__", " - ");
        ndx++;
        break;

      // Now we are looking for a station identifier or unit designation
      // and skipping everything until we find it  
      case 2:
        if (fld.startsWith("STA")) {
          data.strSource = fld;
          ndx++;
        } else if (UNIT_PAT.matcher(fld).matches()) {
          data.strUnit = fld;
          ndx++;
        }
        break;
        
      // Following the station ID comes the address
      case 3:
        parseAddress(fld, data);
        ndx++;
        break;
        
      // Usually, but not always, followed by a map page
      case 4:
        if (fld.startsWith("Map ")) {
          data.strMap = fld.substring(4).trim();
        }
        ndx++;
        break;
      }
    }
    
    // We have to at least gotten to the address to be considered successful
    return (ndx >= 4);
  }
}
