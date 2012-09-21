package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Geauga county, OH
Contact: Erik Modrzynski <erikmodrzynski@gmail.com>
Sender: 777xxxxxxx
System: Spillman

GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 11 lois ln elderly female vomiting and sick TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) 13806 Mayfield Rd. Electrical Fire TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9579 Venus 76yom abdominal pain TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message 2of2) Smoking really bad. 2800/Wright TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message 1of2) Fire Dept needed at the Dept of Aging, 12555 Ravenwood Dr, reported possibly oven fire. TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 10865 holi dale 18 month old female diff breathing 2800 clr/phillips TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) Rescue neeeded at 13791 GAR Hwy for an unknown type overdose called into your station /2800 TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) INJURY ACCIDENT AT - GAR and Old State for 2 car MVA with possible injuries. TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9600 S brown rd for 50 yom with chest pain. TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) 14949 Rock Creek Rd. 40 y/o/m abdominal pain TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 668 WOODLAWN RD ELDERLY FEMALE DIFFICUTLY BREATHING TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9544 old state 32 yof chest pain TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9051 brakeman 57 yof ill TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) Rescue needed at 9051 Brakemen for 57yof compl of feeling ill TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) INJURY ACCIDENT AT - 1 CAR 1 ENTRAP 1 EJECTED 608 BY WALKING STICK TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message 1of2) RESCUE IS NEEDED AT - 8325 MADISON RD M/A TO THOMPSON WITH A SQUAD FOR 1 CAR MVA ROLLOVER TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9488 wildwood -- 46 y/o male -- possible alcohol poison -- 2800 TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) M/A to Chardon for a Fire Alarm off at Geauga Hospital. 2800/Wright TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) FIRE DEPT NEEDED AT - M/A TO MONTVILLE 9141 CLAY ST SMELL OF GAS IN THE HOUSE TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 14181 RADCLIFFE RD 72 YO FEMALE CONS NOT RESPONSIVE HIST OF HEART PROBLEMS TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - hambden twp park -- 13860 gar hwy -- 16 y/o male -- back pain -- 2800 TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - sunco station female in custody hx heart problems TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 9922 OLD STATE RD 90 YO FEMALE DIFF BREATHING TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) Rescue needed at 1 La Verne Ln, female possible going into Labor. 2800/Wright TXT STOP to opt-out
GEAUGA COUNTY SHERIFF (Text Message) RESCUE IS NEEDED AT - 12115 COUNTRY OAKS TRL 96 Y/O/F POSSIBLE D.O.A. 2800/DP TXT STOP to opt-out

Contact: support@active911
Sender: OH_GC_ENS@CO.GEAUGA.OH.US
(Alert Notification) Rescue needed at 12340 Bass Lake Rd Center of Dialysis for 78yof compl of infected port<br />
(Alert Notification) 12340 BASS LAKE RD A 1 BED 1 86 YOM CHANGE IN MENTAL STATUS<br />
(Alert Notification) rescue -- 14036 rock creek -- 43 y/o female -- breathing problems/low pulse ox -- 2800<br />
(Alert Notification) 12120 Caves Rd for a Chimney Fire Evacuation in progress.<br />
(Alert Notification) REQUEST ON STAND BY AT THE STATION FOR POSSIBLE SUICIDAL MALE 10917 LEADER<br />
(Alert Notification) Barclay House for a lift assist 88 yof slid out of chair 13149 Gar Hwy<br />
(Alert Notification) rescue needed 12630 gwendolyn farms suicide attempt by hanging<br />
(Alert Notification) Medical Arts building 13221 Ravenna Rd Dr Kondray's office 48yr old female difficulty breathing.<br />
(Alert Notification) RESCUE NEEDD AT 10942 LEADER FEMALE THAT FELL<br />
(Alert Notification) rescue needed at 11995 fowlers mill rd female several day ago<br />
 
*/

public class OHGeaugaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^GEAUGA COUNTY SHERIFF \\(Text Message[^\\)]*\\) ");
  private static final Pattern CALL_MARK_PTN = 
      Pattern.compile(" (?:(?:(?:IS )?NEEDE?D(?: AT)?(?: -)?)|AT -) ", Pattern.CASE_INSENSITIVE);
  private static final String[] CALL_PREFIXES = new String[]{
    "FOR A "
  };
 
  public OHGeaugaCountyParser() {
    super("GEAUGA COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "777";
  }
  
  @Override
  public int getMapFlags() {
    // Suppress LA -> LN address adjustment
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    do {
      Matcher match = MARKER.matcher(body);
      if (match.find()) {
        body = body.substring(match.end()).trim();
        break;
      }
      
      if (subject.equals("Alert Notification")) {
        if (body.endsWith("<br />")) body = body.substring(0,body.length()-6).trim();
        break;
      }
      
      return false;
    } while (false);
      
    StartType st = StartType.START_CALL;
    Matcher match = CALL_MARK_PTN.matcher(body);
    if (match.find()) {
      data.strCall = body.substring(0,match.start()).trim();
      body = body.substring(match.end()).trim();
      st = StartType.START_PLACE;
    }
    
    String[] flds = body.split(" -- ");
    if (flds.length > 2) {
      int addrNdx = 0;
      if (data.strCall.length() == 0) data.strCall = flds[addrNdx++]; 
      if (checkAddress(flds[addrNdx]) < checkAddress(flds[addrNdx+1])) {
        data.strPlace =  flds[addrNdx++];
      }
      parseAddress(flds[addrNdx], data);
      for (int ndx = addrNdx+1; ndx < flds.length; ndx++) {
        data.strSupp = append(data.strSupp, " -- ", flds[ndx]);
      }
    } 
    
    else {
      body = body.replace(',', ' ');
      Result res = parseAddress(st, FLAG_NO_IMPLIED_APT, body);
      if (res.getStatus() ==  0) {
        data.strPlace = body;
      } else {
        res.getData(data);
        String sExtra = getLeft();
        if (data.strCall.length() == 0) {
          data.strCall = sExtra;
        } else {
          data.strSupp = sExtra;
        }
      }
    }
    
    // Clear out call prefixes
    for (String pfx : CALL_PREFIXES) {
      if (data.strCall.toUpperCase().startsWith(pfx)) {
        data.strCall = data.strCall.substring(pfx.length()).trim();
        break;
      }
    }
    
    return true;
  }
}
