package net.anei.cadpage.parsers.NC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Guilford County, NC
 */
public class NCGuilfordCountyParser extends DispatchOSSIParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:(?:\\d{1,4}:)?[\\w@\\-\\.]+? *[\n:])?(?=CAD:|[A-Z]{3,4};)");
  
  public NCGuilfordCountyParser() {
    super("GUILFORD COUNTY", "NC",
          "FYI? ID? ( CALL2 ADDR! | PRI/Z MUTUAL ADDR! | ( SRC SRC PRI | PRI? ) CODE? CALL ADDR! ) CODE? CITY? ( NAME ID | ID? ) EXTRA? ( X X? | PLACE X X? | ) ( PRI UNIT? SRC SRC | ) XINFO+? UNIT CITY? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "@edispatches.com,93001,firedistrict13@listserve.com,CAD@greensboro-nc.gov,mhfd38all@listserve.com,@summerfieldfire.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (match.lookingAt()) {
      body = body.substring(match.end()).trim();
      if (!body.startsWith("CAD:")) body = "CAD:" + body;
    }
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (!super.parseMsg(body, data)) return false;
    
    // If out of county mutual aid call, cancel the default county
    if (data.strSource.startsWith("ALCO")) data.strCity = "ALAMANCE COUNTY";
    else if (data.strCall.equals("MUTUAL")) data.defCity = "";
    return true;
  }

  @Override
  public String getProgram() {
    return super.getProgram().replace("SRC", "SRC CITY");
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{7,}", true);
    if (name.equals("CALL2")) return new Call2Field();
    if (name.equals("MUTUAL")) return new MutualField();
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("PRI")) return new PriorityField("\\d", true);
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("EXTRA")) return new ExtraField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("XINFO")) return new CrossInfoField();
    if (name.equals("UNIT")) return new UnitField("[A-Z]+\\d+(?:,[A-Z]+\\d+)*", true);
    return super.getField(name);
  }

  private class Call2Field extends CallField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() < 6) return false;
      parse(field, data);
      return true;
    }
  }
  
  private class MutualField extends CallField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.equals("MUTUAL")) return false;
      parse(field, data);
      return true;
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public void parse(String field, Data data) {
      data.strSource = append(data.strSource, "-", field);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override 
    public boolean checkParse(String field, Data data) {
      field = field.toUpperCase();
      String city = CITY_CODES.getProperty(field);
      if (city != null) {
        data.strCity = city;
        return true;
      }
      
      if (CITY_SET.contains(field)) {
        data.strCity = field;
        return true;
      }
      
      return false;
    }
  }
  
  private static final Pattern CODE_PTN = Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Za-z]?");
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(CODE_PTN, true);
    }
  }
  
  // Extra information field
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|RM|ROOM|SUITE|LOT)[: ] *(.*)");
  private static final Pattern SRC_PTN = Pattern.compile("[A-Z]{4}");
  private class ExtraField extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("DIST:")) {
        data.strSupp = field;
        return true;
      }
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = append(data.strApt, "-", match.group(1));
        return true;
      }
      if (NUMERIC.matcher(field).matches()) {
        
        // See if this might be a priority field that will be followed
        // by two source fields.
        if (field.length() > 1 || !SRC_PTN.matcher(getRelativeField(+2)).matches()) {
          data.strApt = append(data.strApt, "-", field);
          return true;
        }
      }
      return false;
    }
    
    @Override
    public String getFieldNames() {
      return "INFO APT";
    }
  }
  
  private class CrossInfoField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = append(data.strApt, " - ", match.group(1));
        return;
      }
      String city = CITY_CODES.getProperty(field);
      if (city != null) {
        data.strCity = city;;
      } else if (field.startsWith("TAC ")) {
        data.strChannel = field;
      } else if (data.strCode.length() == 0 && CODE_PTN.matcher(field).matches()) {
        data.strCode = field;
      } else if (data.strCall.length() == 0) {
        data.strCall = field;
      } else {
        data.strSupp = append(data.strSupp, " / ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X CITY INFO CODE CH CALL";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "A",    "ARCHDALE",
      "ALAM", "ALAMANCE COUNTY",
      "B",    "BROWN SUMMIT",
      "BUR",  "BURLINGTON",
      "CLI",  "CLIMAX",
      "COL",  "COLFAX",
      "DAVI", "DAVIDSON COUNTY",
      "E",    "ELON",
      "EDEN", "EDEN",
      "FORS", "FORSYTH COUNTY",
      "G",    "GREENSBORO",
      "GI",   "GIBSONVILLE",
      "GUIL", "GUILFORD COUNTY",
      "H",    "HIGH POINT",
      "HP",   "HIGH POINT",
      "J",    "JAMESTOWN",
      "JU",   "JULIAN",
      "K",    "KERNERSVILLE",
      "KV",   "KERNERSVILLE",
      "L",    "LIBERTY",
      "M",    "MCLEANSVILLE",
      "OAK",  "OAK RIDGE",
      "P",    "PLEASANT GARDEN",
      "RAN",  "RANDLEMAN",
      "RAND", "RANDOLPH COUNTY",
      "REI",  "REIDSVILLE",
      "ROCK", "ROCKINGHAM COUNTY",
      "SE",   "SEDALIA",
      "ST",   "STOKESDALE",
      "SU",   "SUMMERFIELD",
      "T",    "THOMASVILLE",
      "W",    "WHITSETT",
      "X",    "UNIDENTIFIED"
  });
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(

      // Cities
      "ARCHDALE",
      "BURLINGTON",
      "GREENSBORO",
      "HIGH POINT",

      // Towns
      "GIBSONVILLE",
      "JAMESTOWN",
      "KERNERSVILLE",
      "OAK RIDGE",
      "PLEASANT GARDEN",
      "SEDALIA",
      "STOKESDALE",
      "SUMMERFIELD",
      "WHITSETT",

      // Townships
      "BRUCE",
      "CENTER GROVE",
      "CLAY",
      "DEEP RIVER",
      "FENTRESS",
      "FRIENDSHIP",
      "GILMER",
      "GREENE",
      "HIGH POINT",
      "JAMESTOWN",
      "JEFFERSON",
      "MADISON",
      "MONROE",
      "MOREHEAD",
      "OAK RIDGE",
      "ROCK CREEK",
      "SUMNER",
      "WASHINGTON",

      // Census-designated places
      "FOREST OAKS",
      "JULIAN",
      "MCLEANSVILLE",

      // Unincorporated communities
      "BROWN SUMMIT",
      "CLIMAX",
      "COLFAX",
      "MONTICELLO",
      
      // Alamance County
      "ELON",
      
      // Davidson County
      "THOMASVILLE",
      
      // Forsyth County
      "KERNERSVILLE",
      
      // Guilford County
      "SEDALIA",
      
      // Randolph County
      "LIBERTY",
      "RANDLEMAN",
      
      // Rockingham County
      "EDEN",
      "REIDSVILLE",
      
      // Counties
      "ALAMANCE COUNTY",
      "DAVIDSON COUNTY",
      "FORSYTH COUNTY",
      "GUILFORD COUNTY",
      "RANDOLPH COUNTY",
      "ROCKINGHAM COUNTY"
  ));
  
}
