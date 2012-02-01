package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/* 
Liberty County, TX
Contact: "Craig Powell" <craig@hardinvfd.org>
Contact: support@active911.com
Sender: "Liberty County " <lcso@lcffa.org>

[FIRE CALL]  FM834 NEAR BASEBALL FIELDS POSS OUT OF CONTROL GRASS FIRE
[EMS]  11346 SH146N 72YOF DIFF BREATHING HISTORY OF CONGESTIVE HEART FAILURE
[10-50]  146N S OF OVER PASS 10-50 OCCUPIED MIGHT CATCH FIRE
[MVA]  2 vehicle major FM 834 @ CR 2003 by junior high
[FIRE CALL] EXXON STATION IN HULL BEHIND ELEMENTARY SCHOOL  ON FIRE POSS EXPLOSIONS
[MEDICAL CALL]437 CR2002W 72 YOM CHEST PAINS
[EMS]201 CR2517 [KNIGHTS FORREST]\n73 YOM HIGH BP DIFF WALKING
[EMS]668 CR2060\n68YOF DIFF BREATHING
[CRIME SCENE CLASS]ALL FIRE CHIEFS PLEASE NOTIFY SHERRY WITH THE # OF MEMBERS FROM YOUR DEPT\nTHAT WILL BE ATTENDING THE CLASS THIS SATURDAY IN HARDIN
[MED CALL]201 CR 2517 (KNIGHTS FOREST) POSS STROKE CANT WALK SLURRED SPEECH 
[FIRE CALL]FM1011 TO OIL TANKS LIGHTENING STRUCK THEM THEY ARE ON FIRE
[MED CALL]CR2552 54 YOM FELL AND HURT BACK HWY 146 T/L CR2550 T/R CR2551 ON CORNER OF\nCR2551 & CR2552
[Crime scene class]Don't forget about the class tomorrow at Hardin High school cafeteria at  \n0800.\n\nCraig
[FIRE CALL]447 CR2070\nGRASS FIRE
[AGG ASSAULT]261 CR 255O\n40YOM STABBED NEAR WRIST SEVERE BLEEDING
[AGG ASSAULT]STAGE
[EMS]16897 SH146N\n78YOM AMPUTATED LEG HAS BEEN BOTHERING HIM FOR A WEEK

*/

public class TXLibertyCountyParser extends SmartAddressParser {
  
  private static final Pattern NUMBER_O = Pattern.compile("(\\d+)O(\\d*)");
  
  public TXLibertyCountyParser() {
    super(CITY_CODES, "LIBERTY COUNTY", "TX");
  }
  
  public String getFilter() {
    return "lcso@lcffa.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Standards for CAD page are pretty low
    if (!isPositiveId()) return false;
    if (subject.length() == 0) return false;
    
    // SKip everything after a double newline, and turn all remaining newlines to blanks
    int pt = body.indexOf("\n\n");
    if (pt >= 0) body = body.substring(0,pt);
    body = body.replace('\n', ' ');
    
    // They use @ to mark intersections :(
    body = body.replace('@', '&');
    
    // And fumble fing an O for a zero?
    body = NUMBER_O.matcher(body).replaceAll("$10$2");
    
    // Splitting OVERPASS into two words fools the address logic into thinking
    // that PASS ends a street suffix
    body = body.replace("OVER PASS", "OVERPASS");
    
    // OK, see if we can find an address
    // Address is usually at the beginning of the call, so we will try that first
    // if no luck that way, look for it anywhere
    Result res = parseAddress(StartType.START_ADDR, FLAG_NO_IMPLIED_APT, body);
    if (res.getStatus() == 0) res = parseAddress(StartType.START_CALL, FLAG_NO_IMPLIED_APT, body);
    
    // Still no luck?  Subject goes in call, body goes in place and call it good
    if (res.getStatus() == 0) {
      data.strCall = subject;
      data.strPlace = body;
      return true;
    }
    
    // Address found.  See if it is followed by place name in brackets
    res.getData(data);
    String tail = res.getLeft();
    if (tail.length() > 0) {
      char chr = tail.charAt(0);
      if (chr == '(' || chr == '[') {
        chr = (chr == '(' ? ')' : ']');
        pt = tail.indexOf(chr, 1);
        if (pt < 0) pt = tail.length();
        data.strPlace = tail.substring(1,pt).trim();
        tail = tail.substring(pt+1).trim();
      }
    }
    
    // Whatever is before and affter the address goes into info, the subject
    // will be the call
    data.strSupp = append(data.strCall, " / ", tail);
    data.strCall = subject;
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
  });
}
