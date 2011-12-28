package net.anei.cadpage.parsers.MN;

import java.util.Properties;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * This class parses messages from some as yet unidentified CAD software vendor
 **/

/*
Andover Fire, Anoka county, Minnesota (class III)
Contact: Matt K <mattkohout@gmail.com>
Sender: cad.cad@co.anoka.mn.us
INC: field is an incident number
CAD MSG: *D A3   57       HANSON BLVD NW / ANDOVER BLVD NW  NE CORNER..SMOKE/CHARRED GRASS...SM FLAMES INC:10019729   [42]
CAD MSG: *D A3   39F      17844 XEON ST NW  FIRE ALARM... SMOKE OR HEAT UPSTAIRS OR IN GARAGE... SMALL DOG ONSITE INC:10019638  
CAD MSG: *D A3   45F      14950 HANSON BLVD NW @ANDOVER ELEMENTARY  PLANNED FIRE DRILL AT 1330 ... WILL CALL BACK WHEN COMPLETE INC:10019627   
CAD MSG: *D A3   57       A FIRE DEPT 3 @15929 CROSSTOWN BLVD NW  ** ILLEGAL BURN * IN MILLER WOODS THE NEW DEVELOPMENT INC:10019583   
CAD MSG: *D A3   32R      YMCA @15200 HANSON BLVD NW  ** SKATEBOARD PARK * 7 YO FE * FELL FRM A ACTIVITY BARS * DID LOOSE CONC IS CONC NOW * DIFF BREATHING AMB   
CAD MSG: *D A1   59       RR TRACKS / BUNKER LAKE BLVD NW  PD ACCIDENT/BLOCKING/NEED SGT TO RESPOND ALSO / FIRE RTN FOR WASH DOWN INC:10019310  
CAD MSG: *D A2   56       CO7 NW / CO58 NW  STRONG GAS ODOR IN THE AREA INC:10019278  
CAD MSG: *D A1   51       14015 DRAKE ST NW  POSS FIRE IN THE WALL...LOTS OF SMOKE FROM THE BASEMENT...EVERYONE ISOUT INC:10019127
CAD MSG: *D A1   32R      13645 HIDDEN CREEK DR NW  63 YO DIAB HUSB W/LOW BLOOD SUGARS...41 ..... AMB ORD / TRANSF INC:10022305
CAD MSG: *D A2   50       DAKOTAH ST NW / VALLEY DR NW  LARGE FIRE BEHIND A HOUSE ON THE NORTH SIDE OF THE INTERSECTION ..NOTABLE TO TELL WHAT IS BURNING INC:100

Contact: Mike Christian <lfdmikec@gmail.com>, 16512789021@tmomail.net
cad.cad@co.Anoka.mn.us / / CAD MSG: *D S1 39F 7783 233 LN NE GEN SMOKE/FIRE ALRM.. INC:11001880

Contact: "Mike/Jenni Dahlin" <mike.jenni.dahlin@gmail.com>
CAD MSG: *D D4   32M      3254 90 LN NE  LIFT ASSIST ONLY...LARGE MALE (300+) INC:11007548\n

Conact: matt kohout <mattkohout@gmail.com>
CAD MSG: *D A1   51       844 140 LN NW  OVEN ON FIRE.. FLAME IS OUT AND STILL LOTS OF SMOKE SMOKE.. EVERYONE IS OUT OF THE HOMEINC:11017847

*/

public class MNAnokaCountyParser extends SmartAddressParser {
  
  public MNAnokaCountyParser() {
    super("ANOKA COUNTY", "MN");
  }
  
  @Override
  public String getFilter() {
    return "cad.cad@co.anoka.mn.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Extract primary call description
    int pt = body.indexOf("CAD MSG: *D ");
    if (pt < 0) return false;
    body = body.substring(pt);
    
    if (body.length() < 26) return false;
    Parser p = new Parser(body.substring(12, 26).trim());
    data.strSource = p.get(' ');
    data.strCall = p.get();
    String sDesc = CALL_CODES.getProperty(data.strCall);
    if (sDesc != null) data.strCall = data.strCall + " - " + sDesc;
    
    body = body.substring(26);
    
    // Extract call ID if there is one
    pt = body.lastIndexOf(" INC:");
    if (pt >= 0) {
      int pt2 = body.indexOf(' ', pt+5);
      if (pt2 < 0) pt2 = body.length();
      data.strCallId = body.substring(pt+5, pt2);
      body = body.substring(0, pt).trim();
    }
    
    // Normally a double blank separate the place & address line from the supp information
    
    pt = body.indexOf("  ");
    if (pt >= 0) {
      String addressLine = body.substring(0, pt);
      data.strSupp = body.substring(pt+2).trim();
      
      // An @ separates the place name from address,
      // But we cannot assume which one comes first. we have to check both
      // sides to see which makes a better address.
      
      // Which one we pick has to be parsed a second time to pick up some
      // of the subtle changes the parser makes
      pt = addressLine.indexOf('@');
      if (pt < 0) {
        parseAddress(StartType.START_ADDR, addressLine, data);
      } else {
        String part1 = addressLine.substring(0, pt).trim();
        String part2 = addressLine.substring(pt+1).trim();
        if (checkAddress(part1) > checkAddress(part2)) {
          parseAddress(StartType.START_ADDR, part1, data);
          data.strPlace = part2;
        } else {
          data.strPlace = part1;
          parseAddress(StartType.START_ADDR, part2, data);
        }
      }
    }
    
    // If we don't find the expected double blank, parser it as a name/address
    // field followed by supplemental info
    
    else {
      body = body.replaceAll("@", "");
      parseAddress(StartType.START_PLACE, body, data);
      data.strSupp = getLeft();
    }
    return true;
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "27F",  "Bomb Threat",
      "32M",  "Medical",
      "32R",  "Rescue",
      "32X",  "PI Accident",
      "39F",  "Alarm (Fire)",
      "39CO", "Alarm (Carbon Monoxide)",
      "45F",  "Fire Drill",
      "50",   "Fire (Unknown)",
      "51",   "Fire (Building)",
      "52",   "Fire (Grass)",
      "53",   "Fire (Vehicle)",
      "54",   "Fire (Refuse)",
      "55",   "Fire (Electrical)",
      "56",   "Smoke/Gas Odor",
      "57",   "Fire (Misc)",
      "59",   "Police Assist",
      "PC59", "Phone Call",
      "73F",  "Road Closure Info"
  });
}
