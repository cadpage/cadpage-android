package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Prince Georges County, MD
 */
public class MDPrinceGeorgesCountyFireBizParser extends MDPrinceGeorgesCountyBaseParser {
  
  public MDPrinceGeorgesCountyFireBizParser() {
    super("MAPCALL! UNIT! ADDR! EXTRA+? URL END");
  }
  
  @Override
  public String getFilter() {
    return "@fireblitz.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    String[] lines = body.split("\n");
    if (lines.length <4 || lines.length > 6) return false;
    if (! lines[lines.length-1].startsWith("http://fireblitz.com/")) return false;
    return parseFields(lines, data);
  }
  
  private class MapCallField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      
      // First line contains a station ID & map page followed by a colon and call description
      Parser p = new Parser(field);
      data.strCall = p.getLastOptional(':');
      if (data.strCall.length() == 0) abort();
      String source = p.get('-');
      data.strMap = p.get();
      
      // First two characters *MIGHT* be a county code
      if (source.length() >= 2) {
        String code = source.substring(0,2);
        String county = COUNTY_CODES.getProperty(code);
        if (county != null) {
          data.strCity = county;
          if (code.equals("DC")) data.strState = "DC";
          source = source.substring(2);
        }
      }
      data.strSource = source;
    }
    
    @Override
    public String getFieldNames() {
      return "SRC CITY ST MAP CALL";
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strUnit = p.get(',');
      data.strSupp = p.get();
    }
  }
  
  private static final Pattern CITY_CODE_PTN = Pattern.compile("-([A-Z]{2})\\b");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
    
      // Third line is address, possibly with cross streets in parens
      // or square brackets
      if (field.startsWith("PG ")) field = field.substring(3).trim();
      int pt1 = field.indexOf('(');
      if (pt1 < 0) pt1 = field.indexOf('[');
      String sAddress;
      if (pt1 < 0) {
        sAddress = field;
      } else {
        sAddress = field.substring(0, pt1).trim();
        char cEnd = (field.charAt(pt1)=='(' ? ')' : ']');
        int pt2 = field.indexOf(cEnd, pt1+1);
        if (pt2 < 0) pt2 = field.length();
        data.strCross = field.substring(pt1+1, pt2);
      }
      pt1 = sAddress.indexOf(',');
      if (pt1 >= 0) sAddress = sAddress.substring(0, pt1).trim();
      Matcher match = CITY_CODE_PTN.matcher(sAddress);
      if (match.find()) {
        String code = match.group(1);
        String city = CITY_CODES.getProperty(code);
        if (city != null) {
          data.strCity = city;
          data.strPlace = sAddress.substring(match.end()).trim();
          sAddress = sAddress.substring(0,match.start()).trim();
        }
      }
      super.parse(sAddress, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE X";
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d) (\\d\\d:\\d\\d)");
  private class MyExtraField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.matches()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
      } else {
        if (field.startsWith("Notes:")) field = field.substring(6).trim();
        data.strSupp = append(data.strSupp, "\n", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAPCALL")) return new MapCallField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("EXTRA")) return new MyExtraField();
    return super.getField(name);
  }
  
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "PG", "PRINCE GEORGES COUNTY",
      "CH", "CHARLES COUNTY",
      "AA", "ANNE ARUNDEL COUNTY",
      "HO", "HOWARD COUNTY",
      "DC", "WASHINGTON"
  });
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "PA", "PASSADENA"
  });
}
