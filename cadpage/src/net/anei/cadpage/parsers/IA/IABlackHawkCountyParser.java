package net.anei.cadpage.parsers.IA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class IABlackHawkCountyParser extends FieldProgramParser {
  
  private static final Pattern CALL_ID_PATTERN = Pattern.compile("^\\d\\d-\\d{6} ");
  
  public IABlackHawkCountyParser() {
    super("BLACK HAWK COUNTY", "IA",
           "CALL! Reported:DATETIME! ADDR X PLACE! UNIT");
  }
  
  @Override
  public String getFilter() {
    return "Swmail@bhcso.org,Xmail@connectingyou.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = CALL_ID_PATTERN.matcher(body);
    if (! match.find()) return false;
    
    data.strCallId = body.substring(0, match.end()-1);
    body = body.substring(match.end()).trim();
    
    // Calls come in two forms.  The easy one has nice line break delimiters
    String[] flds = body.split("\n");
    if (flds.length == 1) return oldParseMsg(body, data); 
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "/");
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      // Last token is the (possibly abbreviated) city
      int pt = field.lastIndexOf('@');
      if (pt < 0) pt = field.lastIndexOf('/');
      if (pt < 0) pt = field.lastIndexOf(' ');
      if (pt < 0) {
        if (CITY_SET.contains(field.toUpperCase())) {
          data.strCity = field;
          field = "";
        }
      } else {
        String city = field.substring(pt+1).trim();
        if (CITY_SET.contains(city.toUpperCase())) {
          data.strCity = city;
          field = field.substring(0,pt).trim();
        }
      }
      if (data.strCity.equals("RAYMO")) data.strCity = "RAYMOND";
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("X")) return new MyCrossField();
    if  (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private boolean oldParseMsg(String body, Data data) {
    
    // city is awkward because they sometimes use / and sometimes blank to
    // delineate it
    int pt = Math.max(body.lastIndexOf(' '), body.lastIndexOf('/'));
    if (pt < 0) return false;
    data.strCity = body.substring(pt+1).trim();
    body = body.substring(0, pt).trim();
    
    // Parse description and address, anything left is a cross street
    parseAddress(StartType.START_CALL, body, data);
    data.strCross = getLeft();
    
    return true;
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      // Incorporated cities
      "CEDAR FALLS",
      "DUNKERTON",
      "ELK RUN HEIGHTS",
      "EVANSDALE",
      "GILBERTVILLE",
      "HUDSON",
      "JANESVILLE",
      "JESUP",
      "LA PORTE CITY",
      "RAYMOND",
      "RAYMO",
      "WATERLOO",
      
      // Unincorporated areas
      "DEWAR",
      "EAGLE CENTER",
      "FINCHFORD",
      "GLASGOW",
      "VOORHIES",
      "WASHBURN",
      
      // Townships
      "BARCLAY",
      "BENNINGTON",
      "BIG CREEK",
      "BLACK HAWK",
      "CEDAR",
      "CEDAR FALLS",
      "EAGLE",
      "EAST WATERLOO",
      "FOX",
      "LESTER",
      "LINCOLN",
      "MOUNT VERNON",
      "ORANGE",
      "POYNER",
      "SPRING CREEK",
      "UNION",
      "WASHINGTON",

  }));
}
