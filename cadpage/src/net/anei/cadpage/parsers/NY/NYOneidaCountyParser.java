package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

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

** NOT IMPLEMENTED **
FRM:dispatch@oc911.org\nMSG:???WEMF:2011:0346AcknowledgeMVA-UNKNOWNROUTE 233, WESTMORELAND/W MAIN ST (COUNTY ROUTE 23), WESTMORELAND
???STIF:2011:0140Dispatched30B01 - POSSIBLY DANGEROUS BODY AREA8533 CHAMINADE RD, MARCY (OLD RIVER RD/ORISKANY RD; Near:VINCES U PULL IT)

*/

public class NYOneidaCountyParser extends SmsMsgParser {
  
  private static final Pattern DELIM = Pattern.compile(" *(?:\\n>?|>) *");
  private static final Pattern OUTSIDE = Pattern.compile("\\bOUTSIDE\\b");
  
  public NYOneidaCountyParser() {
    super("ONEIDA COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ocgov.net,@oc911.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf("Dispatched");
    if (pt < 0) return false;
    
    pt = body.lastIndexOf(':', pt-1);
    if (pt < 0) return false;
    pt = body.lastIndexOf(':', pt-1);
    if (pt < 0) return false;
    body = body.substring(pt+1);
    
    
    String[] flds = DELIM.split(body);
    if (flds.length <= 3) return false;

    data.strCallId = flds[0];
    if (flds[1].equals("Dispatch")) return false;
    data.strCall = flds[2];
    
    Parser p = new Parser(flds[3]);
    String sAddr = p.get(',');
    pt = sAddr.indexOf('(');
    if (pt >= 0) sAddr = sAddr.substring(0,pt).trim();
    parseAddress(sAddr, data);
    data.strCity = p.getOptional('(');
    Matcher match = OUTSIDE.matcher(data.strCity);
    if (match.find()) data.strCity = data.strCity.substring(0,match.start()).trim();
    if (data.strCity.length() > 0) {
      data.strCross = p.get(')');
    } else {
      data.strCity = p.get('/');
      data.strCross = p.get();
    }
    return true;
  }
}
