package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Allegheny County, PA
 */
public class PAAlleghenyCountyParser extends FieldProgramParser {
  
  private static final String MARKER = "ALLEGHENY COUNTY 911 :";
  private static final Pattern TRAILER_PTN = Pattern.compile(" - From \\d+ (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)$");
  
  public PAAlleghenyCountyParser() {
    super(CITY_CODES, "ALLEGHENY COUNTY", "PA",
           "CODE PRI CALL ADDR CITY ( AT CITY | ) XINFO+? SRC BOX! ID? INFO+ Units:UNIT UNIT+");
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
    
    // Drop anything beyond a line break
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // Remove trailing stuff that we aren't interested in
    Matcher match = TRAILER_PTN.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      body = body.substring(0,match.start()).trim();
    }
    
    // If it isn't there or is truncated, remove what we 
    // do find and set the possibly incomplete data flag
    else {
      data.expectMore = true;
      pt = body.indexOf(" - From");
      if (pt >= 0) body = body.substring(0, pt).trim();
    }
    
    body = body.replace(" Unit:", " Units:");
    return parseFields(body.split(","), 7, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " DATE TIME";
  }
  
  // Stock address field is fine, but we want test generator to know
  // that this might be a place field
  private class MyAddressField extends AddressField {
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames();
    }
  }
  

  // City field must always be exactly 3 characters long
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() != 3) abort();
      super.parse(field, data);
    }
  }
  
  // AT field is option and hold the real address
  // if present, the previous address turns into a place name
  private class MyAtField extends AddressField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override public boolean checkParse(String field, Data data) {
      if (!field.startsWith("at ")) return false;
      data.strPlace = data.strAddress;
      data.strAddress = "";
      super.parse(field.substring(3).trim(), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\d{10}");
  private class MyCrossInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("btwn ")) {
        data.strCross = field.substring(5).trim();
      } else if (PHONE_PTN.matcher(field).matches()) {
        data.strPhone = field;
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "INFO X PHONE";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Medical ProQA")) return;
      super.parse(field, data);
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("AT")) return new MyAtField();
    if (name.equals("XINFO")) return new MyCrossInfoField();
    if (name.equals("BOX")) return new BoxField("[A-Z]?\\d{5,}(?: +[A-Z]?\\d{5,})*|[A-Z]{2,3}\\d{2,3}", true);
    if (name.equals("ID")) return new IdField("F\\d{9}", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
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
