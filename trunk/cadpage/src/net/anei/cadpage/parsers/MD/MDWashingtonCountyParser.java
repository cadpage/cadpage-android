package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Washington County, MD
 */
public class MDWashingtonCountyParser extends FieldProgramParser {
  
  private static final Pattern CALL_QUAL_PTN = Pattern.compile("^((?:Recall Reason|Completed|Cancel Reason):.*?)\n");
  private static final Pattern CROSS_PTN = Pattern.compile("\\[([^\\[\\]]*) - ([^\\[\\]]*)\\]");
  private static final Pattern DELIM = Pattern.compile(" *(?<= )- +|  ,");
 
  public MDWashingtonCountyParser() {
    super(CITY_LIST, "WASHINGTON COUNTY", "MD",
        "ADDR/SXP CITY? X? CALL! CALL+? ( TRAIL1! END | UNIT UNIT+? ( TRAIL2! END | INFO+? TRAIL3! END ) )");
    addExtendedDirections();
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@washco-md.net,@c-msg.net,TextAlert@sems79.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    // Look for call qualifier prefix
    Matcher match = CALL_QUAL_PTN.matcher(body);
    if (match.find()) {
      data.strCall = match.group(1).trim();
      body = body.substring(match.end()).trim();
    }
    
    // Drop everything after the first newline
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    pt = body.indexOf(" / [!] ");
    if (pt >= 0) {
      subject = body.substring(0,pt).trim();
      body = body.substring(pt+7).trim();
    }
    
    if (subject.endsWith("|!")) subject = subject.substring(0,subject.length()-2).trim();
    if (!subject.equals("CAD") && !subject.equals("!")) data.strSource = subject;
    
    // Standard cross street field contains a spurious delimiter that we need to protect
    body = CROSS_PTN.matcher(body).replaceFirst("[$1 & $2]");
    
    // Split body into fields separated by  -
    if (!parseFields(DELIM.split(body), data)) return false;
    String state = CITY_STATE_TABLE.getProperty(data.strCity.toUpperCase());
    if (state != null) data.strState = state;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram().replace("CITY", "CITY ST");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TRAIL1")) return new TrailField(1);
    if (name.equals("TRAIL2")) return new TrailField(2);
    if (name.equals("TRAIL3")) return new TrailField(3);
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      // First field contains option M/A county, address and optional place name
      Parser p = new Parser(field);
      String maCounty = p.getOptional(" CO, ");
      if (maCounty.length() > 0) maCounty = convertCodes(maCounty, COUNTY_CODES);
      super.parse(p.get(','), data);
      data.strPlace = append(data.strPlace, " - ", p.get());
      if (data.strCity.length() == 0) data.strCity = maCounty;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR PLACE CITY ST";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("[") || ! field.endsWith("]")) return false;
      field = field.substring(1, field.length()-1).trim();
      if (field.endsWith("&")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
      return true;
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }

  private static final Pattern UNIT_PTN = Pattern.compile("(?:[0-9]?[A-Z]+[0-9]+|[0-9]{4})(?:[,\\$][A-Z0-9,\\$]+)?\\b");
  private class MyUnitField extends UnitField {
    public MyUnitField() {
      setPattern(UNIT_PTN, true);
    }
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, ",", field);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp," - ", field);
    }
  }
  
  // TrailField always handles the last field in the text string.  It always has a date field
  //  and may have an ID field.  Depending on the context, there are three possibilities for
  // a leading unit field
  //   TRAIL1 - Leading UNIT field is required
  //   TRAIL2 - Leading UNIT field is optional
  //   TRAIL3 - Leading UNIT field will not be present
  
  private static final Pattern TIME_PTN = Pattern.compile("(?<=^| )(\\d\\d:\\d\\d)\\b");
  private static final Pattern TIME2_PTN = Pattern.compile("\\b[\\d:]*$");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{7}$");
  private class TrailField extends Field {
    
    private int type;
    
    public TrailField(int type) {
      this.type = type;
    }

    @Override
    public void parse(String field, Data data) {
      
      // Check for leading unit field
      if (type <= 2) {
        Matcher match = UNIT_PTN.matcher(field);
        if (match.lookingAt()) {
          data.strUnit = append(data.strUnit, ",", match.group());
          field = field.substring(match.end()).trim();
        } else if (type == 1) abort();
      }
      
      Matcher match = TIME_PTN.matcher(field);
      if (match.find()) {
        data.strTime = match.group(1);
      } else {
        match = TIME2_PTN.matcher(field);
        if (!match.find()) abort();
      }
      String sPart1 = field.substring(0,match.start()).trim();
      String sPart2 = field.substring(match.end()).trim();
      
      match = ID_PTN.matcher(sPart1);
      if (match.find()) {
        data.strCallId = match.group();
        sPart1 = sPart1.substring(0,match.start()).trim();
      }
      data.strSupp = append(data.strSupp, " - ", sPart1);
      data.strSupp = append(data.strSupp, " - ", sPart2);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT ID INFO TIME";
    }
  }
  
  private static final String[] CITY_LIST = new String[]{
    "HAGERSTOWN",
    "BOONSBORO",
    "CLEAR SPRING",
    "FUNKSTOWN",
    "HANCOCK",
    "KEEDYSVILLE",
    "SHARPSBURG",
    "SMITHSBURG",
    "WILLIAMSPORT",
    
    "GREENCASTLE",
    "THURMONT"
  };
  
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "ALL", "ALLEGANY COUNTY",
      "BER", "BERKELEY COUNTY",
      "FRA", "FRANKLIN COUNTY",
      "FRE", "FREDERICK COUNTY",
      "FUL", "FULTON COUNTY",
      "JEF", "JEFFERSON COUNTY",
      "LOU", "LOUDOUN COUNTY",
      "MOR", "MORGAN COUNTY"
  });
  
  private static final Properties CITY_STATE_TABLE = buildCodeTable(new String[]{
      
      "GREENCASTLE",      "PA",
      "FRANKLIN COUNTY",  "PA",
      "FULTON COUNTY",    "PA",
      
      "LOUDOUN COUNTY",   "VA",
      
      "BERKELEY COUNTY",  "WV",
      "JEFFERSON COUNTY", "WV",
      "MORGAN COUNTY",    "WV"
  });
}
