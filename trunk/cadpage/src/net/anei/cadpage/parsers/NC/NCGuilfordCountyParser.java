package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Guilford County, NC
 */
public class NCGuilfordCountyParser extends DispatchOSSIParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:\\d{1,4}:)?[\\w@\\-\\.]+? *[\n:](?=CAD:|[A-Z]{3,4};)");
  
  public NCGuilfordCountyParser() {
    super("GUILFORD COUNTY", "NC",
           "FYI? ID? ( CALL2 ADDR! | PRI/Z MUTUAL ADDR! | ( SRC SRC PRI | PRI? ) CODE? CALL ADDR! ) EXTRA? ( X X? | PLACE X X? | ) ( PRI UNIT SRC SRC | ) XINFO+? UNIT");
  }
  
  @Override
  public String getFilter() {
    return "@edispatches.com,93001,firedistrict13@listserve.com,CAD@greensboro-nc.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (match.find()) {
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
  
  private static final Pattern CODE_PTN = Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Za-z]?");
  private static final Pattern APT_PTN = Pattern.compile("(?:APT |RM:|ROOM ) *([^ ]*) *(.*)");
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(CODE_PTN, true);
    }
  }
  
  // Extra information field
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
      if (field.startsWith("APT ")) {
        data.strApt = field.substring(4).trim();
        return true;
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
      String city = CITY_CODES.getProperty(field);
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = append(data.strApt, " - ", match.group(1));
        field = match.group(2);
        if (field.length() == 0) return;
      }
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

  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{7,}", true);
    if (name.equals("CALL2")) return new Call2Field();
    if (name.equals("MUTUAL")) return new MutualField();
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("PRI")) return new PriorityField("\\d", true);
    if (name.equals("EXTRA")) return new ExtraField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("XINFO")) return new CrossInfoField();
    if (name.equals("UNIT")) return new UnitField("[A-Z]+\\d+(?:,[A-Z]+\\d+)*", true);
    return super.getField(name);
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
      "J",    "JAMESTOWN",
      "JU",   "JULIAN",
      "K",    "KERNERSVILLE",
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
  
}
