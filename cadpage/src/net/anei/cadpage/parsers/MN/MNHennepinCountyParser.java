package net.anei.cadpage.parsers.MN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * This class parses messages from some as yet unidentified CAD software vendor
 **/

/**
 * Hennepin county, MN
 */
public class MNHennepinCountyParser extends FieldProgramParser {
  
  private static final Pattern FIELD_PTN = Pattern.compile("; *([A-Z]+)-");
  
  public MNHennepinCountyParser() {
    super(CITY_CODES, "HENNEPIN COUNTY", "MN",
          "NAME LOC:ADDR APT:APT PLACE:PLACE CITY:CITY EVTYPE:CALL COMMENTS:INFO cross_streets:X");
  }
  
  @Override
  public String getFilter() {
    return "sheriff.cadpaging@co.hennepin.mn.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("NAME-")) return false;
    body = body.substring(5).trim();
    
    // Convert wierd field delimiters to standard colon terminated keywords
    body = FIELD_PTN.matcher(body).replaceAll(" $1: ");
    body = body.replace(" [#", " APT:").replace(" [@", " PLACE:").replace("cross streets :", "cross streets:");
    return super.parseMsg(body, data);
  }
  
  // Ignore info field if same as address
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(":")) field = field.substring(0,field.length()-1).trim();
      if (field.equals(data.strAddress)) return;
      super.parse(field, data);
    }
  }
  
  // Cross stree field may have more info at end separated by double blanks
  private static final Pattern CROSS_BREAK = Pattern.compile("  |\n");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CROSS_BREAK.matcher(field);
      if (match.find()) {
        data.strSupp = append(data.strSupp, "\n", field.substring(match.end()).trim());
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ANC", "ANOKA",
      "ANO", "ANOKA COUNTY",
      "BKC", "BROOKLYN CENTER",
      "BKP", "BROOKLYN PARK",
      "BLM", "BLOOMINGTON",
      "CAR", "CARVER COUNTY",
      "CHP", "CHAMPLIN",
      "COR", "CORCORAN",
      "CRY", "CRYSTAL",
      "DAK", "DAKOTA COUNTY",
      "DAY", "DAYTON",
      "DPH", "DEEPHAVEN",
      "EDN", "EDINA",
      "EDP", "EDEN PRAIRIE",
      "EXC", "EXCELSIOR",
      "FTS", "FORT SNELLING",
      "GDV", "GOLDEN VALLEY",
      "GRF", "GREENFIELD",
      "GRW", "GREENWOOD",
      "HAN", "HANOVER",
      "HOP", "HOPKINS",
      "IND", "INDEPENDENCE",
      "LLK", "LONG LAKE",
      "LOR", "LORETTO",
      "MAP", "METROPOLITAN AIRPORT",
      "MED", "MEDINA",
      "MLK", "MEDICINE LAKE",
      "MND", "MOUND",
      "MPG", "MAPLE GROVE",
      "MPL", "MINNEAPOLIS",
      "MPP", "MAPLE PLAIN",
      "MTB", "MINNETONKA BEACH",
      "MTK", "MINNETONKA",
      "MTT", "MINNETRISTA",
      "NHP", "NEW HOPE",
      "ORO", "ORONO",
      "OSE", "OSSEO",
      "PLY", "PLYMOUTH",
      "RAM", "RAMSEY COUNTY",
      "RCH", "RICHFIELD",
      "ROB", "ROBBINSDALE",
      "ROC", "ROCKFORD",
      "ROG", "HASSAN",
      "SCO", "SCOTT COUNTY",
      "SPK", "SPRING PARK",
      "STA", "ST ANTHONY",
      "STB", "ST BONIFACIUS",
      "STL", "ST LOUIS PARK",
      "SWD", "SHOREWOOD",
      "TKB", "TONKA BAY",
      "WAY", "WAYZATA",
      "WDL", "WOODLAND",
      "WRI", "WRIGHT COUNTY"

  });
}