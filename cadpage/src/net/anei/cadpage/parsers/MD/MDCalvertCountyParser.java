package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*    
Calvert County, MD
Contact: michael smith <lee020988@gmail.com>, 4436247957@vtext.com
Sender: dispatch@co.cal.md.us

M Priority 3 Medical  00:02 03/12/11 8536 BAYSIDE RD CHESAPEAKE BEACH 2011-00000445 CO1 abdom. pain
R Auto Accident Serious S5 R1 A59 A19 M102  21:41 03/11/11 W CHESAPEAKE BEACH RD DUNKIRK 2011-00016920  entrapment  a truck hit a another car
F Local Box E12  19:23 03/10/11 3741 3RD ST NORTH BEACH 2011-00000438  NEIGHBORS ARE TRYING TO APPROACH IT. THERE IS A CAR UNDER THE TREE, IT
M Priority 2 Medical A19 M102  17:19 03/10/11 950 E  MT HARMONY RD OWINGS 2011-00000435  ProQA Medical Key Questions have been completed; Disp Dispatch Code:
F Fire Alarm E11 E51 T1  16:30 03/10/11 1850 PROSPER LN OWINGS 2011-00000433 SNEADES ACE-OW ProQA Fire Questionnaire Completed;
F Area Box E61 E21 E52 E11 TN5 TN7 T2 S6 A68 NDC  17:52 03/09/11 65 WALTON RD HUNTINGTOWN 2011-00000443  ProQA Fire Questionnaire Completed; D 
M Priority 2 Medical A19 NOMED  10:45 03/09/11 8818 CHESAPEAKE LIGHTHOUSE DR NORTH BEACH 2011-00000428  ProQA Medical Questionnaire Completed;

 anythings starting with B, E, T, S, R, A, or M followed by 1-3 digits, or
 anything starting with TN followed by a single digit, or
 NDC or NOMED or COM
*/

public class MDCalvertCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_LIST = new String[] {
    "CHESAPEAKE BEACH", "NORTH BEACH", 
    "DUNKIRK", "HUNTINGTOWN", "LUSBY","OWINGS", "PRINCE FREDERICK", "ST LEONARD", "SOLMONS",
    "BARSTOW", "BROOMES ISLAND", "DARES BEACH", "DOWELL", "LOWER MARLBORO", "PORT REPUBLIC", "SUNDERLAND"
  };
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(?:[BETSRAM]\\d{1,3}|TN\\d|NDC|NMED|COM)\\b");
  private static final Pattern TIME_DATE_PTN = Pattern.compile("\\b\\d\\d:\\d\\d \\d\\d/\\d\\d/\\d\\d\\b");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{4}-\\d{8}\\b");
  
  public MDCalvertCountyParser() {
    super(CITY_LIST, "CALVERT COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.cal.md.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher timeDateMatch = TIME_DATE_PTN.matcher(body);
    if (! timeDateMatch.find()) return false;
    Matcher idMatch = ID_PTN.matcher(body);
    if (! idMatch.find(timeDateMatch.end())) return false;
    
    String strCall = body.substring(0,timeDateMatch.start()).trim();
    Matcher unitMatch = UNIT_PTN.matcher(strCall);
    if (unitMatch.find()) {
      data.strUnit = strCall.substring(unitMatch.start());
      strCall = strCall.substring(0,unitMatch.start()).trim();
    }
    data.strCall = strCall;
    
    String strAddress = body.substring(timeDateMatch.end(), idMatch.start()).trim();
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, strAddress, data);
    
    data.strCallId = idMatch.group();
    
    data.strSupp = body.substring(idMatch.end()).trim();
    return true;
  }
}
