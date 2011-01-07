package net.anei.cadpage.parsers;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/* Sample Arnold Pages.
 * 
MEDICAL Box 17-7 1236 JONES STATION RD  [MT CALVARY UNITED METH CHURCH] E171,PM17 TASER PATIENT; 1145 [1/49]  /4m-5/ 
Box Alarm 12-19 540 BENFIELD RD (CENTER DR) Echo E12,QNT30,E18,E171,QNT23,TK26,SQ23,PM12,BC2,SCA ODOR GAS IN STRUCTURE (HOT); 1351 [2/50]
Local Alarm 17-12 24 CASCADE RD (GRANDVIEW RD) E171 ALARMS/NON HIGH LIFE (HOT); 1705 [3/51] 
*MEDICAL BOX 23-5 831 RITCHIE HWY N  [Unit 307A]  [KRIS LEIGH CATERED LIVING] QNT23,PM17,TRO CARDIAC ARREST; 0548 [2/42]  /2d-96/
*MEDICAL Box 23-12 1244 RITCHIE HWY S  [Unit 18]  [SEVERN COMMERCE CENTER] QNT23,PM17 STROKE; 0921 [3/43]  /lm-2/ 
*Medical Box 40-83 RT50 W/JENNIFER RD MU40,E40,E171 MVC; 1517 [4/44]  /18d-19/ 
Box Alarm 23-15 812 WINDSOR RD (FOREST LN) Echo QNT23,E171,E19,TW40,QNT30,SQ23,PM17,BC2,SCA STRUCTURE/BARN/GARAGE (HOT); 1607 [5/45] 
MEDICAL Box 19-5 1604 ORCHARD WAY (HARMONY ACRES LN) E172,MU39 STROKE; 1643 [6/46] 
MEDICAL Box 40-26 1724 VINEYARD TRL (RAMSHORN TRL) TW40,PM17 SEIZURES; 0035 [1/41]

Contact: firemann172@yahoo.com
These were from a screen cap so they may have issues. I asked the user for one's without the ...
HazMat Box 17-17 1939 BALTO ANNAP BLVD (CARVEL DR) Kilo E171,SQ2,BC2,SU23,SCA,PM39 Chemical ODOR ...
Local Box 23-6 88 HOYLE LN (BRENDA JOYCE LN) Charlie B17 ELECTRIC WIRES OUTSIDE (COLD); 1404[9...
Still Box 40-24A 1872 ANNAPOLIS MALL [CHEESCAKE FACTORY] Kilo E172,TK36 ALARMS/MALLS (WARM ...
Local Box 19-5 1652 PLEASANT PLAINS RD (OLD SAINT MARGARETS RD) Charlie HOLD,U@*,E172 ELECTRIC ...
MEDICAL Box 19-13 1572 SECRETARIAT DR (MAN O WAR CT) A19,PM17 CHEST PAIN; 1341 [6/284] /13m-1 
Medical Box 40-83 RT50 E/BESTGATE RD MU40,E40,E172 MVC; 1238 [5/283] /lm-7
Medical Box 17-QA BRIDE POINT DR /COX [Unit NECK] [RD BX1-10] MOA PM17 MVC; PM17 REQ TAX 3 1133 ...
 */

public class MDArnoldParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "MD";
  private static final String DEF_CITY = "Arnold";
  
  private static final Pattern BOX = Pattern.compile("\\b\\d\\d-[A-Z0-9]{1,3}\\b");

  public MDArnoldParser() {
    super(DEF_CITY, DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = BOX.matcher(body);
    if (! match.find()) return false;
    data.strCall = body.substring(0, match.end());
    body = body.substring(match.end()).trim();
    
    // Delete after ;
    Parser p = new Parser(body);
    p.getLastOptional(';');
    body = p.get();
    
    // OK, there are two ways to go from here.  If we find a open paren or square 
    // bracket, that definitively marks the end of the address
    int ipt = body.indexOf('(');
    int ipt2 = body.indexOf('[');
    if (ipt < 0) ipt = ipt2;
    else if (ipt2 >= 0 && ipt2 < ipt) ipt = ipt2;
    if (ipt >= 0) {
      
      parseAddress(body.substring(0,ipt).trim(), data);
      body = body.substring(ipt);
      
      // Following the address, we may find a place name in square brackets or
      // a cross street in parenthesis.  In either order
      while (body.length() > 0) {
        char stch = body.charAt(0);
        char endch = 0;
        if (stch == '(') endch=')';
        else if (stch == '[') endch = ']';
        else break;
        p = new Parser(body.substring(1));
        String fld = p.get(endch);
        body = p.get();
        
        if (stch == '(') {
          if (data.strCross.length() > 0) data.strCross += " & ";
          data.strCross += fld;
        }
        else {
          if (data.strPlace.length() > 0) data.strPlace += " - ";
          data.strPlace += fld;
        }
      }
    }
    
    // If we didn't find a bracket terminator, we will have to rely on the
    // smart parser to find the address
    else {
      parseAddress(StartType.START_ADDR, body, data);
      body = getLeft();
    }
    
    // We aren't done yet.
    // this might be followed what looks like a camel case name
    // which will be followed by a unit designation.  We'll identify the
    // camel case name if the second character is lower case
    p = new Parser(body);
    data.strUnit = p.get(' ');
    if (data.strUnit.length() >= 2 && Character.isLowerCase(data.strUnit.charAt(1))) {
      data.strUnit = p.get(' ');
    }
    
    // Anything left is supplemental info
    data.strSupp = p.get();

    return true;
  }
}
