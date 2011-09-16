package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Clermont county, OH
Contact: carl jervis <cjervis911@yahoo.com>
Sender: 911-center@co.clermont.oh.us
System: CAD Interactive 6.1.1.63

FSTRUC>STRUCTURE FIRE 1890 SR 232 XS: LAUREL POINT ISABEL RD LAUREL BUTLER, SHAWN Map: Grids:, Cad: 2011-0000014744
MED >MED GENERIC DO NOT DELETE 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP BETTLES,LINDA Map: Grids:, Cad: 2011-0000015125
FDUMP >DUMPSTER FIRE 2601 WILDWOOD LN XS: SR 222 TATE TOWNSHIP WIRELESS-VERIZON(XYP) Map: Grids:, Cad: 2011-0000015892
06D02 >BREATHING PROBLEMS 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP LESTER,CURTIS Map: Grids:, Cad: 2011-0000016117
29B04 >TRAFF OR TRANSPT ACC/MVA W/INJ 1542 SR 133 XS: RUDD RD FRANKLIN TOWNSHIP WIRELESS-AT&T MOBILITY(XYP) Map: Grids:, Cad: 2011-0000016205
06D02 >BREATHING PROBLEMS 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP LESTER,CURTIS Map: Grids:, Cad: 2011-0000016117
29B01 >TRAFF OR TRANSPT ACC/MVA W/INJ BETHEL HYGIENE RD&amp;SR 133 XS: SR 133 TATE TOWNSHIP Cad: 2011-0000016983
FSMOKE>SMOKE IN THE AREA 3465 SR 774 XS: HENSON RD FRANKLIN TOWNSHIP LORI SPARKS Map: Grids:, Cad: 2011-0000017023
29B01 >TRAFF OR TRANSPT ACC/MVA W/INJ LAUREL PT ISABEL RD&BECKELHYMER RD XS: BECKELHYMER RD WASHINGTON TOWNSHIP HAYMOND,LINDA S Cad: 2011-0000017231
FWIRES>WIRES DOWN E OSBORNE ST&N EAST ST XS: N EAST ST BETHEL JEFF W/RUMPKE Cad: 2011-0000017232

Contact: Ryan Payer <ryan.payer3@gmail.com>
FSTRUC>STRUCTURE FIRE 966 E LEGENDARY RUN XS: ABERDEEN RIDGE PIERCE TOWNSHIP HANSBAUER,DAVID & LINDA Map: Grids:, Cad: 2011-0000069848

Contact:  James <firefighter1249@gmail.com>
Sender: 911-CENTER@clermontcountyohio.gov
04B01 >ASSAULT/SEXUAL ASSAULT 5728 GAVEY WAY XS: SR 131 WAYNE TOWNSHIP JEFFERS,JORDAN Map: Grids:, Cad: 2011-0000077041

Contact: Dennis Rutter <dennis.rutter73@gmail.com>
FALARM>FIRE ALARM 1466 HWY 50 XS: BARRETT RD STONELICK TOWNSHIP CINTAS FIRE PROTECTION-55 Map: Grids:, Cad: 2011-0000077411

*/

public class OHClermontCountyParser extends DispatchBParser {
  
  private static final String[] CITY_CODES = new String[]{
    "BATAVIA TOWNSHIP", "FRANKLIN TOWNSHIP", "GOSHEN TOWNSHIP", 
    "JACKSON TOWNSHIP", "MIAMI TOWNSHIP", "MONROE TOWNSHIP", "OHIO TOWNSHIP", 
    "PIERCE TOWNSHIP", "STONELICK TOWNSHIP", "TATE TOWNSHIP", "UNION TOWNSHIP",
    "WASHINGTON TOWNSHIP", "WAYNE TOWNSHIP", "WILLIAMSBURG TOWNSHIP",
    
    "AFTON", "AMELIA", "BANTAM", "BATAVIA", "BELFAST", "BETHEL", "BRANCH HILL",
    "CHILO", "CLERMONTVILLE", "EDENTON", "FELICITY", "GLEN ESTE", "GOSHEN",
    "HAMLET", "HULINGTON", "LAUREL", "LERADO", "LINDALE", "LOCUST CORNER",
    "LOVELAND", "MARATHON", "MIAMIVILLE", "MILFORD", "MONTEREY", "MOSCOW",
    "MOUNT CARMEL", "MOUNT HOLLY", "MOUNT PISGAH", "MOUNT REPOSE", "MULBERRY",
    "NEVILLE", "NEW RICHMOND", "NEWTONSVILLE", "NICHOLSVILLE", "OLIVE BRANCH",
    "OWENSVILLE", "PALESTINE", "PERINTOWN", "POINT ISABEL", "POINT PLEASANT", 
    "SALTAIR", "SUMMERSIDE", "TOBASCO", "UTOPIA", "WIGGONSVILLE", "WILLIAMSBURG",
    "WITHAMSVILLE", "WOODVILLE"
  };

  private static final String DEF_STATE = "OH";
  private static final String DEF_CITY = "CLERMONT COUNTY";
 
  public OHClermontCountyParser() {
    super(CITY_CODES, DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@clermontcountyohio.gov";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    return super.parseMsg(body, data);
  }

  @Override
  protected boolean isPageMsg(String body) {
    return body.contains(" Cad:") && !body.startsWith("EVENT: ");
  }
}
