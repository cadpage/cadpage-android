package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Allegheny County, PA
 */
public class PAAlleghenyCountyParser extends MsgParser {
  
  private static final String MARKER = "ALLEGHENY COUNTY 911 :";
  
  // Run ID consists of one or two 6+ digit numbers
  private static final Pattern BOX_PTN = Pattern.compile("E?\\d{5,}(?: +E?\\d{5,})*");
  
  public PAAlleghenyCountyParser() {
    super("ALLEGHENY COUNTY", "PA");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // There are a number of different message markers
    do {
      if (body.startsWith(MARKER)) {
        body = body.substring(MARKER.length()).trim();
        break;
      }
        
      if (body.startsWith(":")) {
        body = body.substring(1).trim();
        break;
      }
      
      if (subject.endsWith(" Station")) break;
        
      return false;
    } while (false);
    
    // Remove trailing stuff that we aren't interested in
    data.expectMore = true;
    int pt = body.indexOf(" - From");
    if (pt >= 0) {
      data.expectMore = false;
      body = body.substring(0, pt).trim();
    }
    
    // Split body into comma separated fields
    String[] flds = body.split(" *, *");
    int fldCnt = flds.length;
    if (fldCnt < 6) return false;
    
    // Fields 0 is code
    // Field 1 is priority
    // Field 2 is call description
    data.strCode = flds[0];
    data.strPriority = flds[1];
    data.strCall = flds[2];
    
    // Field 3 is up for grabs
    // Field 4 should be a 3 character town code
    String cityCode = flds[4];
    if (cityCode.length() != 3) return false;
    data.strCity = convertCodes(cityCode, CITY_CODES);
    
    // If field 5 starts with "at" then it contains the address and
    // field 3 contains the place name.  Field 6 probably duplicates
    // the city code and should be skipped
    int ndx = 5;
    if (flds[ndx].startsWith("at ")) {
    		parseAddress(flds[ndx].substring(3).trim(), data);
    		data.strPlace = flds[3];
    		ndx++;
    		if (ndx < fldCnt && flds[ndx].equals(cityCode)) ndx++;
    } 
    
    // Otherwise field 3 contains the address
    else {
      parseAddress(flds[3], data);
    }
    
    // Start looking for a run ID.
    // Once we find it, the field in front of it is the source, anything before
    // that goes into supplemental info
    String source = null;
    while (ndx < fldCnt) {
      String fld = flds[ndx++];
      
      // Except for fields that start with btwn which become cross strees
      if (fld.startsWith("btwn ")) {
        data.strCross = fld.substring(5).trim();
        continue;
      }
      if (BOX_PTN.matcher(fld).matches()) {
        if (source != null) data.strSource = append(data.strSource, " ", source);
        source = null;
        data.strBox = append(data.strBox, " ", fld);
        break;
      }
      if (source != null) {
        if (data.strSupp.length() > 0) data.strSupp += " / ";
        data.strSupp += source;
      }
      
      source = fld;
    }
    if (source != null) {
      if (data.strSupp.length() > 0) data.strSupp += " / ";
      data.strSupp += source;
    }
    
    // Now anything from here until we find a Unit: tag going into 
    // supp info
    if (ndx >= fldCnt) return true;
    while (!flds[ndx].startsWith("Units:")) {
      if (!flds[ndx].startsWith("Medical ProQA")) {
        data.strSupp = append(data.strSupp, " / ", flds[ndx]);
      }
      if (++ndx >= fldCnt) return true;
    }
    
    // Anything from the Unit tag on goes into units
    data.strUnit = append(data.strUnit, " ", flds[ndx].substring(6).trim());
    while (++ndx < fldCnt) {
      data.strUnit = append(data.strUnit, " ", flds[ndx]);
    }
    
    return true;
  }
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "ALE", "ALEPPO",
      "ASP", "ASPINWALL",
      "AVA", "AVALON",
      "BWB", "BALDWIN",
      "BWT", "BALDWIN TOWNSHIP",
      "BAS", "BELL ACRES",
      "BEL", "BELLEVUE",
      "BAV", "BEN AVON",
      "BAH", "BEN AVON HEIGHTS",
      "BPK", "BETHEL PARK",
      "BLA", "BLAWNOX",
      "BKR", "BRACKENRIDGE",
      "BRD", "BRADDOCK",
      "BRH", "BRADDOCK HILLS",
      "BWS", "BRADFORD WOODS",
      "BRE", "BRENTWOOD",
      "BRG", "BRIDGEVILLE",
      "CAR", "CARNEGIE",
      "CSH", "CASTLE SHANNON",
      "CHA", "CHALFANT",
      "CHE", "CHESWICK",
      "CHU", "CHURCHILL",
      "CLA", "CLAIRTON",
      "COL", "COLLIER",
      "COR", "CORAOPOLIS",
      "CRA", "CRAFTON",
      "CRE", "CRESCENT",
      "DOR", "DORMONT",
      "DRA", "DRAVOSBURG",
      "DUQ", "DUQUESNE",
      "EDR", "EAST DEER",
      "EMC", "EAST MCKEESPORT",
      "EPG", "EAST PITTSBURGH",
      "EWD", "EDGEWOOD",
      "EDG", "EDGEWORTH",
      "ELB", "ELIZABETH",
      "ELT", "ELIZABETH TWP",
      "EMS", "EMSWORTH",
      "ETN", "ETNA",
      "FWN", "FAWN",
      "FIN", "FINDLAY",
      "FOR", "FOREST HILLS ",
      "FWD", "FORWARD",
      "FOX", "FOX CHAPEL",
      "FPB", "FRANKLIN PARK",
      "FRZ", "FRAZER",
      "GLA", "GLASSPORT",
      "GLE", "GLENFIELD",
      "GTR", "GREEN TREE",
      "HAM", "HAMPTON",
      "HAR", "HARMAR",
      "HSN", "HARRISON",
      "HAY", "HAYESVILLE",
      "HEI", "HEIDELBERG",
      "HOM", "HOMESTEAD",
      "IND", "INDIANIA",
      "ING", "INGRAM",
      "JEF", "JEFFERSON",
      "KEN", "KENNEDY",
      "KIL", "KILBUCK",
      "LEE", "LEET",
      "LTD", "LEETSDALE",
      "LIB", "LIBERTY ",
      "LIN", "LINCOLN",
      "MAR", "MARSHALL",
      "MCC", "MCCANDLESS",
      "MCD", "MCDONALD ",
      "RKS", "MCKEES ROCKS",
      "MCK", "MCKEESPORT",
      "MIL", "MILLVALE",
      "MON", "MONROEVILLE",
      "MOO", "MOON",
      "MTO", "MT OLIVER",
      "MTL", "MT. LEBANON",
      "MUN", "MUNHALL ",
      "NEV", "NEVILLE ",
      "NBR", "NORTH BRADDOCK",
      "NFT", "NORTH FAYETTE",
      "NVT", "NORTH VERSAILLES",
      "OKD", "OAKDALE",
      "OAK", "OAKMONT",
      "OHA", "O'HARA",
      "OHI", "OHIO",
      "GOB", "GLEN OSBORNE",
      "PEN", "PENN HILLS",
      "PVG", "PENNSBURY VILLAGE",
      "PIN", "PINE",
      "PIT", "PITCAIRN",
      "PGH", "PITTSBURGH",
      "PLE", "PLEASANT HILLS",
      "PLU", "PLUM",
      "PVU", "PORT VUE",
      "RAN", "RANKIN ",
      "RES", "RESERVE ",
      "RCH", "RICHLAND",
      "ROB", "ROBINSON",
      "ROS", "ROSS",
      "ROF", "ROSSLYN FARMS",
      "SCT", "SCOTT",
      "SEW", "SEWICKLEY",
      "SHT", "SEWICKLEY HEIGHTS",
      "SHI", "SEWICKLEY HILLS",
      "SHA", "SHALER",
      "SHP", "SHARPSBURG",
      "SFT", "SOUTH FAYETTE",
      "SPK", "SOUTH PARK ",
      "SVS", "SOUTH VERSAILLES",
      "SPB", "SPRINGDALE",
      "SPT", "SPRINGDALE TWP.",
      "STO", "STOWE",
      "SWS", "SWISSVALE",
      "TAR", "TARENTUM",
      "THO", "THORNBURG",
      "TRA", "TRAFFORD",
      "TCV", "TURTLE CREEK",
      "USC", "UPPER ST. CLAIR",
      "VER", "VERONA",
      "VSB", "VERSAILLES",
      "WAL", "WALL",
      "WDR", "WEST DEER",
      "WEL", "WEST ELIZABETH",
      "WHM", "WEST HOMESTEAD",
      "WES", "WEST MIFFLIN",
      "WVW", "WEST VIEW",
      "WTK", "WHITAKER",
      "WOA", "WHITE OAK",
      "WHI", "WHITEHALL",
      "WIL", "WILKINS",
      "WBG", "WILKINSBURG",
      "WIM", "WILMERDING"
  });
}
