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
  
  private static final Pattern CALL_QUAL_PTN = Pattern.compile("^((?:Recall Reason|Completed):.*?)\n");
  private static final Pattern CROSS_PTN = Pattern.compile("\\[([^\\[\\]]*) - ([^\\[\\]]*)\\]");
  private static final Pattern DELIM = Pattern.compile(" *(?<= )- +|  ,");
 
  public MDWashingtonCountyParser() {
    super(CITY_LIST, "WASHINGTON COUNTY", "MD",
        "ADDR CITY? X? CALL! CALL+? UNIT UNIT+? INFO+? TRAIL! END");
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
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      // First field contains option M/A county, address and optional place name
      Parser p = new Parser(field);
      String maCounty = p.getOptional(" CO, ");
      if (maCounty.length() > 0) {
        maCounty = COUNTY_CODES.getProperty(maCounty, maCounty);
        int pt = maCounty.indexOf(',');
        if (pt >= 0) {
          data.strState = maCounty.substring(pt+1);
          maCounty = maCounty.substring(0,pt);
        }
        data.strCity = maCounty;
      }
      super.parse(p.get(','), data);
      data.strPlace = p.get();
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
  
  private class MyUnitField extends UnitField {
    public MyUnitField() {
      super("(?:[0-9]?[A-Z]+[0-9]+|[0-9]{4})(?:,[A-Z0-9,]+)?", true);
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
  
  private static final Pattern TIME_PTN = Pattern.compile("(?<=^| )(\\d\\d:\\d\\d)\\b");
  private static final Pattern TIME2_PTN = Pattern.compile("\\b\\d[\\d:]*$");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{7}$");
  private class TrailField extends Field {

    @Override
    public void parse(String field, Data data) {
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
      return "ID INFO TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TRAIL")) return new TrailField();
    return super.getField(name);
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
    
    "THURMONT"
  };
  
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "ALL", "ALLEGANY COUNTY",
      "BER", "BERKELEY COUNTY,WV",
      "FRA", "FRANKLIN COUNTY,PA",
      "FRE", "FREDERICK COUNTY",
      "FUL", "FULTON COUNTY,PA",
      "JEF", "JEFFERSON COUNTY,WV",
      "LOU", "LOUDOUN COUNTY,VA",
      "MOR", "MORGAN COUNTY,WV"
  });
}
