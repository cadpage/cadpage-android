package net.anei.cadpage.parsers.NY;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Oneida County, NY
Contact: jim humphreys <jimmycrack79@gmail.com>
Contact: Gary Reese <greese7169@yahoo.com>
Contact: brad white <wfdcar1@gmail.com>
Contact: James Brown <landscapesunlimitedcny@gmail.com>
Contact: james rouillier jr <scaredtwo@gmail.com>
Contact: eric roux <eroux33@gmail.com>
Contact: Michael Delong <mike.delong.392@gmail.com>
Contact: James Griffiths <griffballs72@gmail.com>
Contact: David Kennett <kennett.d.24@gmail.com>
Contact: daved1260@gmail.com" <daved1260@gmail.com>
Sender: dispatch@ocgov.net,dispatch@oc911.org

o;?WHIF:2010:0648\nDispatched\nEMS/BREATHING PROBLEMS\n111 HARDCASTLE AVE, WHITESBORO VILLAGE (MERITON DR/PERIMETER RD)
o;?WHIF:2010:0641\nDispatched\nEMS/DIABETIC PROBLEM\n31 MOHAWK ST, WHITESBORO VILLAGE (/SAUQUOIT STNear:AMERICAN LEGION POST
o;?WHIF:2010:0636\nDispatched\nINVESTIGATE\n124 HARTS HILL TERR, WHITESTOWN (GILBERT RD/Near:HARTS HILL INN)
o;?WHIF:2010:0644\nDispatched\nMVA-PI\nHUGHES ST, WHITESBORO VILLAGE/ WEST ST, WHITESBORO VILLAGE
o;?WHIF:2010:0677\nDispatched\nEMS/PSYCHIATRIC/SUICIDE ATTEMPT\n19 ELLMORE DR, WHITESBORO VILLAGE (SAUQUOIT ST/WIND PL)
i>¿WEVF:2010:0170\nDispatched\nEMS/STROKE/CVA\n9132 MAIN ST, WESTERN (GIFFORD HILL RD/GEORGE STNear:WOODS VALLEY
i>¿WEVF:2010:0171\nDispatchedWIRES DOWN/BURNHILLSIDE RD, WESTERN
i>¿WEVF:2010:0169\nDispatched\nFIRE STRUCTURE7893 GIFFORD HILL RD, WESTERN (CAMRODEN RD/ROUTE 46)
o;?WHIF:2010:0704>Dispatched>EMS/ABDOMINAL PAIN>20 MOHAWK ST, WHITESBORO VILLAGE (SAUQUOIT ST/FERNBANK CIR; Near:AMERICAN LEGION POST 1113)
¿WEVF:2010:0182Dispatched31D02 - UNCONSCIOUS -- EFFECTIVE BREATHING9725 N STEUBEN RD, STEUBEN (STARR HILL RD/LEWIS RD;)
i>¿WEVF:2011:0010DispatchedFIRE STRUCTURE8801 CAMRODEN RD, WESTERN (EVANS RD/TOWNLINE RD; Near:INGERSOLL TRAILER PARK)
i>¿WEMF:2011:0089Dispatched17A03 - PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)7700 STONE RD, WESTMORELAND (PECKVILLE RD/STOP 7 RD;)
MSG:i>¿DURF:2011:0013DispatchedALARM EMS5593 ROUTE 46, VERONA (ROUTE 31/FOX ST;)
MSG:i>¿DURF:2011:0013DispatchedALARM EMS5593 ROUTE 46, VERONA (ROUTE 31/FOX ST;)
?LECF:2011:0085>Dispatched\n>17A03 - PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)\n>5368 SLONE RD, LEE (LEE CENTER TABERG RD/SKINNER RD;)
?WEMF:2011:0144>Dispatched\n>ASSIST\n>6471 W CARTER RD, WESTMORELAND, NY
?DEEF:2011:0075>Dispatched\n>WIRES DOWN/BURN\n>6352 WALKER RD, DEERFIELD (CRUIKSHANK RD/MILLER RD;)
?LADF:2011:0165>Dispatched\n>FIRE STRUCTURE\n>8428 DAWN DR, ROME OUTSIDE (EVENING RD/;)
?VEOF:2011:0407>Dispatched\n>ALARM FIRE\n>5218 PATRICK RD (COUNTY ROUTE 48A), VERONA (VERONA, ROUTE 365/SNYDER RD; Near:TURNING STONE CASINO)
WATA:2011:0305 >Dispatched >EMS CALL >358 MADISON ST, WATERVILLE VILLAGE (/TERRY MEADOWS DR; Near:WATERVILLE HIGH SCHOOL)

Contact: Llewellyn Owens <bcsbeaverslew@yahoo.com>
Sender: messaging@iamresponding.com
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0356 &gt;Dispatched &gt;32B03 - UNKNOWN STATUS/OTHER CODES NOT APPLICABLE &gt;9218 MAIN ST N BROOKFIELD
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0354 &gt;Dispatched &gt;26A11 - VOMITING &gt;97 STAFFORD AVE N, WATERVILLE VILLAGE (W BACON ST, E BACON ST/
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0353 &gt;Dispatched &gt;17B03 - UNKNOWN STATUS/OTHER CODES NOT APPLICABLE &gt;774 ROUTE 12, SANGERFIELD (CR
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0352 &gt;Dispatched &gt;TRANSPORT &gt;@HARDINGS NURSING HOME  (220 TOWER ST), WATERVILLE VILLAGE
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0351 &gt;Dispatched &gt;EMS CALL &gt;@WATERVILLE MEMORIAL PARK ELEMENTARY SCHOOL  (145 E BACON ST), WATERVI
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0350 &gt;Dispatched &gt;EMS CALL &gt;ONEIDA  COUNTY
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0349 &gt;Dispatched &gt;17B01 - POSSIBLY DANGEROUS BODY AREA &gt;2522 ROUTE 315, MARSHALL (CALIFORNIA RD/HU
[Waterville Amb]  &#239;&#187;&#191;WATA:2011:0348 &gt;Dispatched &gt;06C01-ABNORMAL BREATHING &gt;144 HUNTINGTON PL, WATERVILLE VILLAGE (/TOWER ST) #MID

Contact: Laura Eaton <alightwenton@gmail.com>
(Bridgewater Fire) &#239;&#187;&#191;BRIA:2012:0001 &gt;Dispatched &gt;28C05 - SUDDEN PARALYSIS OR FACIAL DROOP (ONE SIDE) &gt;130 ELMWOOD AVE N, WATERV

Contact: David Ambrose <nhfd127@yahoo.com>
Sender: messaging@iamresponding.com
(New Hartford Fire) Dispatched >EMS CALL >@NH Post Office  (40 CAMPION RD), NEW HARTFORD
(New Hartford Fire) Dispatched &gt;MVA-UNKNOWN &gt;@K-Mart  (4645 COMMERCIAL DR), NEW HARTFORD
(New Hartford Fire) Dispatched  INVESTIGATE  50 COURT KNLS, NEW HARTFORD (/ROYAL CT)

Contact: "bcsbeaverslew@yahoo.com" <bcsbeaverslew@yahoo.com>
Sender: 777121901640
.... (Waterville Amb) &#239;&#187;&#191;WATA:2012:0010 &gt;Dispatched &gt;EMS CALL &gt;141 SANGER AVE, WATERVILLE VILLAGE (PARK PL/MADISON ST)


Contact: ryan legacy <rlegacy63@gmail.com>
Sender:messaging@iamresponding.com
(Oriskany Falls Fire) ORFA:2012:0067  Dispatched  EMS CALL  @OLIVERAPTS #APT 103  (124 COOPER ST), ORISKANY FALLS VILLA

Contact: Joseph Morosco <yfd120@gmail.com>
Sender: messaging@iamresponding.com
(Yorkville Fire) YORF:2012:0096 Dispatched EMS CALL 43 MAIN ST, YORKVILLE VILLAGE (/COMMERCIAL DR Near:YORKVILLE AUTO SALES) #APT 3 BACK

Contact: opie286 <opie286@gmail.com>
Sender: messaging@iamresponding.com
(Vernon Fire/Rescue) VENF:2012:0079 ;Dispatched ;19C04 - CARDIAC HISTORY ;4500 BEAVER MEADOW RD, VERNON (COOPER ST/ROUTE 5)

Contact: CHRIS HANNAN <fire56ch@yahoo.com>
Sender: messaging@iamresponding.com
FRM:messaging@iamresponding.com\nSUBJ:CANFD\nMSG:CANFD:2012:171\r\nDispatched\r\nPole/Wires\r\nN MAIN , CANASTOTA VILLAGE
 
** NOT IMPLEMENTED **
FRM:dispatch@oc911.org\nMSG:???WEMF:2011:0346AcknowledgeMVA-UNKNOWNROUTE 233, WESTMORELAND/W MAIN ST (COUNTY ROUTE 23), WESTMORELAND
???STIF:2011:0140Dispatched30B01 - POSSIBLY DANGEROUS BODY AREA8533 CHAMINADE RD, MARCY (OLD RIVER RD/ORISKANY RD; Near:VINCES U PULL IT)

*/

public class NYOneidaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("(?:\\b(\\d+:\\d+\\b)[^A-Z0-9]+)?\\bDispatched([^A-Z0-9]{1,3})(?=[A-Z0-9])");
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d\\d[A-Z]\\d\\d) ?- ?");
  private static final Pattern NY_PTN = Pattern.compile(", *NY$");
  private static final Pattern OUTSIDE = Pattern.compile("\\bOUTSIDE\\b");
  private static final Pattern KNLS = Pattern.compile("\\bKNLS\\b", Pattern.CASE_INSENSITIVE);
  
  public NYOneidaCountyParser() {
    super(CITY_LIST, "ONEIDA COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ocgov.net,@oc911.org,messaging@iamresponding.com,777";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    data.strSource = subject;

    // Format usually, but not always, has some field delimiters, but they
    // seem to change with the phase of the moon. There is always a "Dispatched"
    // field followed by a delimiter, followed (hopefully) by a alphnumeric character.
    // so we use this pattern to find and identify the delimiter
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = getOptGroup(match.group(1));
    String delim = match.group(2);
    body = body.substring(match.end());
    
    // If we identified a delimiter that is something other than a single
    // blank, use it to break the rest of the page into a call and an address
    // portion
    String sCall, sAddr;
    if (!delim.equals(" ")) {
      int pt = body.indexOf(delim);
      if (pt < 0) return false;
      sCall = body.substring(0,pt).trim();
      sAddr = body.substring(pt+delim.length()).trim();
    }

    // If the identified delimiter was a single blank, we will use the smart
    // address parser to find the break between the call and the first address
    else {
      int pt = body.indexOf('@');
      if (pt >= 0) {
        sCall = body.substring(0,pt).trim();
        sAddr = body.substring(pt).trim();
      } else {
        pt = body.indexOf(',');
        int pt2 = body.indexOf('(');
        if (pt < 0) pt = body.length();
        if (pt2 < 0) pt2 = body.length();
        pt = Math.min(pt, pt2);
        while (pt > 0 && body.charAt(pt-1) == ' ') pt--;
        sAddr = body.substring(0,pt);
        String sExtra = body.substring(pt);
        Result res = parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, sAddr);
        if (res.getStatus() == 0) return false;
        sCall = res.getAddressPrefix();
        sAddr = res.getFullAddress();
        if (sCall == null || sAddr == null) return false;
        sAddr = sAddr + sExtra;
      }
    } 
    
    match = CODE_PTN.matcher(sCall);
    if (match.find()) {
      data.strCode = match.group(1);
      sCall = sCall.substring(match.end()).trim();
    }
    data.strCall = sCall;
    
    // Break address field into stuff before, inside, and after two sets of parenthesis
    Parser p = new Parser(sAddr);
    String sPart1 = p.get('(');
    String sPart2 = p.get(')');
    String sPart3 = p.get('(');
    String sPart4 = p.get(')');
    String sPart5 = p.get();
    
    // If first part starts with @, it contains a place name
    // and the second part is the address
    if (sPart1.startsWith("@")) {
      data.strPlace = sPart1.substring(1).trim();
      parseAddress(sPart2, data);
    }
    
    // Otherwise, first part is the address and city
    else {
      match = NY_PTN.matcher(sPart1);
      if (match.find()) sPart1 = sPart1.substring(0, match.start()).trim();
      sPart1 = KNLS.matcher(sPart1).replaceAll("KNOLLE");
      int pt = sPart1.indexOf(',');
      if (pt >= 0) {
        data.strCity = sPart1.substring(pt+1).trim();
        sPart1 = sPart1.substring(0,pt).trim();
        pt = data.strCity.indexOf('/');
        if (pt >= 0) {
          data.strCross = data.strCity.substring(pt+1).trim();
          data.strCity = data.strCity.substring(0,pt).trim();
        }
        parseAddress(sPart1, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sPart1, data);
      }
      
      // Second part is generally the cross street
      // It may have a New: place name and may have leading or trailing slash
      // or semicolon characters that need to be removed
      pt = sPart2.indexOf("Near:");
      if (pt >= 0) {
        data.strSupp = sPart2.substring(pt);
        sPart2 = sPart2.substring(0,pt).trim();
      }
      if (sPart2.startsWith("/")) sPart2 = sPart2.substring(1).trim();
      if (sPart2.endsWith(";")) sPart2 = sPart2.substring(0,sPart2.length()-1).trim();
      if (sPart2.endsWith("/")) sPart2 = sPart2.substring(0,sPart2.length()-1).trim();
      data.strCross = append(data.strCross, " & ", sPart2);
    }
    
    // If we get this far, part 3 contains a city if it starts with a comma
    // otherwise it contains additional information, as does part 4
    // With some safeguards against a truncated city name
    if (sPart3.startsWith(",")) {
      sPart3 = sPart3.substring(1).trim();
      if (data.strCity.length() == 0) data.strCity = sPart3;
      else data.strSupp = append(data.strSupp, " / ", sPart3);
    }
    data.strSupp = append(data.strSupp, " / ", sPart4);
    data.strSupp = append(data.strSupp, " / ", sPart5);
    
    // Check for and remove OUTSIDE from city
    match = OUTSIDE.matcher(data.strCity);
    if (match.find()) data.strCity = data.strCity.substring(0,match.start()).trim();
    data.strCity = expandCity(data.strCity);
    
    data.strCross = data.strCross.replace(",", " /").trim();
    return true;
  }
  
  /**
   * Expand a possibly abbreviated city
   * @param sPart3 possibly abbreviated city
   * @return restored city
   */
  private String expandCity(String city) {
    if (city.length() == 0) return city;
    city = city.toUpperCase();
    SortedSet<String> set = CITY_SET.tailSet(city);
    if (set.isEmpty()) return city;
    String result = set.first();
    if (!result.startsWith(city)) return city;
    return result;
  }
  
  private TreeSet<String> CITY_SET = new TreeSet<String>(Arrays.asList(CITY_LIST));

  private static final String[] CITY_LIST = new String[]{
    "ANNSVILLE",
    "AUGUSTA",
    "AVA",
    "BARNEVELD VILLAGE",
    "BOONVILLE",
    "BOONVILLE VILLAGE",
    "BRIDGEWATER",
    "BRIDGEWATER VILLAGE",
    "BROOKFIELD",
    "CAMDEN",
    "CAMDEN VILLAGE",
    "CLARK MILLS",
    "CLAYVILLE VILLAGE",
    "CLINTON VILLAGE",
    "DEERFIELD",
    "FLORENCE",
    "FLOYD",
    "FORESTPORT",
    "HOLLAND PATENT VILLAGE",
    "KIRKLAND",
    "LEE",
    "MARCY",
    "MARSHALL",
    "MCCONNELLSVILLE VILLAGE",
    "N BROOKFIELD",
    "NEW HARTFORD VILLAGE",
    "NEW HARTFORD",
    "NEW YORK MILLS VILLAGE",
    "ONEIDA CASTLE VILLAGE",
    "ORISKANY VILLAGE",
    "ORISKANY FALLS VILLAGE",
    "PARIS",
    "PROSPECT VILLAGE",
    "REMSEN VILLAGE",
    "REMSEN",
    "ROME",
    "SANGERFIELD",
    "SHERRILL",
    "STEUBEN",
    "SYLVAN BEACH VILLAGE",
    "TRENTON",
    "UTICA",
    "VERNON VILLAGE",
    "VERNON",
    "VERONA",
    "VIENNA",
    "WATERVILLE VILLAGE",
    "WESTERN",
    "WESTMORELAND",
    "WHITESBORO VILLAGE",
    "WHITESTOWN",
    "YORKVILLE VILLAGE",
    
    "ONEIDA COUNTY"
  };
}
