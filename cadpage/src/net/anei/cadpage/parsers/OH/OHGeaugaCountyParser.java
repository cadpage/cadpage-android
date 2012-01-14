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

*/

public class OHGeaugaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^GEAUGA COUNTY SHERIFF \\(Text Message[^\\)]*\\) ");
  private static final String[] CALL_MARKS = new String[]{
    " IS NEEDED AT - ",
    " needed at ",
    " AT - "
  };
 
  public OHGeaugaCountyParser() {
    super("GEAUGA COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "777";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    
    StartType st = StartType.START_CALL;
    for (String mark : CALL_MARKS) {
      int pt = body.indexOf(mark);
      if (pt >= 0) {
        data.strCall = body.substring(0,pt).trim();
        body = body.substring(pt+mark.length()).trim();
        st = StartType.START_PLACE;
        break;
      }
    }
    
    String[] flds = body.split(" -- ");
    if (flds.length > 1) {
      int addrNdx = 0;
      if (checkAddress(flds[0]) < checkAddress(flds[1])) {
        data.strPlace =  flds[0];
        addrNdx = 1;
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
    
    return true;
  }
}
