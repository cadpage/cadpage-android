package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Harford, MD Sample pages
Contact: "Greg Dietrich" <greg.dietrich@nvfc10.org>
Sender:  rc.279@c-msg.net
Under box number, the N in this case actually represents a 10## box. Also notice that a separate text is sent for each piece of equipment due on a box assignment (see the two last text messages below.
[!] EOC:A1091 UNC >UNCONSCIOUS 2200 CHANNEL RD XS: X BIG BRANCH BRDG #127 PYLESVILLE CRIZER,KIM BOX: N08 Cad: 2010-0000162717
[!] EOC:A1091 SICK >SICK PERSON 1606 SCOTT RD XS: X FAWN GROVE RD PYLESVILLE BATCHELDER,MICHELLE BOX: N04 Cad: 2010-0000162427
[!] EOC:A1091 DIAB >DIABETIC EMRG. 2145 HARKINS RD XS: SAINT PAULS CHURCH RD PYLESVILLE ROHREAUGH,KEN BOX: N04 Cad: 2010-0000162445
[!] EOC:E1011 MISC >MISC 4873 CAREA RD XS: X WALNUT SPRING CT WHITE HALL SHERBS,ROBERT BOX: N08 Cad: 2010-0000162395
[!] EOC:A1091 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161
[!] EOC:E1011 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161
[!] EOC:F03 BUILD >BUILDING FIRE 21 EASTERN AVE XS: S MAIN ST BEL AIR LEBRUN,MARLEEN BOX: 302 Cad: 2010-0000195539

Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169
 */
public class MDHarfordParser extends DispatchBParser {
  
  private static final String DEF_CITY = "HARFORD";
  private static final String DEF_STATE = "MD";
  
  private static final String[] CITY_LIST =new String[]{
    "ABERDEEN", "BEL AIR", "HAVRE DE GRACE", "JOPPA", "ABINGDON", "BELCAMP",
    "LEVEL", "CHURCHVILLE", "DARLINGTON", "WHITEFORD", "JARRETTSVILLE", "STREET",
    "HICKORY", "FALLSTON", "JOPPATOWNE", "FAWN GROVE", "DELTA", "PYLESVILLE", 
    "WHITE HALL", "FOREST HILL"};

  public MDHarfordParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE);
  }
  
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains("[!] EOC:")) return false;
    
    // First token following EOC: is the unit
    int pt = body.indexOf("EOC:");
    if (pt < 0) return false;
    body = body.substring(pt+4).trim();
    pt = body.indexOf(' ');
    if (pt < 0) return false;
    data.strUnit = body.substring(0, pt);
    body = body.substring(pt+1).trim();
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCross.startsWith("X ")) data.strCross = data.strCross.substring(2);
    return true;
  }
}
