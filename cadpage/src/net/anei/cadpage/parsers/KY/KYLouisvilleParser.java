package net.anei.cadpage.parsers.KY;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.StandardCodeTable;

/**
 * Louisville, KY
 */
public class KYLouisvilleParser extends FieldProgramParser {
  
  public KYLouisvilleParser() {
    super(CITY_CODES, "LOUISVILLE", "KY",
           "Location:ADDR/S? TYPE_CODE:CODE! SUB_TYPE:CALL! TIME:TIME! Comments:INFO INFO+");
  }
  
  @Override
  public String getFilter() {
    return "MetroSafeTech@louisvilleky.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  private class MyCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      String call = CALL_CODES.getCodeDescription(field);
      if (call != null) data.strCall = call; 
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("default")) return;
      if (field.length() == 0) return;
      if (data.strCall.length() == 0) {
        data.strCall = field;
      } else {
        data.strCall = data.strCall + " (" + field + ")";
      }
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(':');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        if (data.strPlace.startsWith("@")) data.strPlace = data.strPlace.substring(1).trim();
        field = field.substring(0,pt).trim();
      }
      Parser p = new Parser(field);
      data.strApt = append(p.getLastOptional(','), "-", p.getLastOptional(';'));
      field = p.get();
      if (field.startsWith("@")) field = field.substring(1).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private static final Pattern INFO_SKIP_PTN = Pattern.compile(" *ProQA dispatch code: [0-9A-Za-z]+ Responder script: *| *\\*\\* Case number .*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = INFO_SKIP_PTN.matcher(field).replaceAll(" / ").trim();
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static CodeTable CALL_CODES = new StandardCodeTable();

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ANC",  "ANCHORAGE",
      "BAR",  "BARBOURMEADE",
      "BELM", "BELLEMEADE",
      "BRM",  "BLUE RIDGE MANOR",
      "BRWD", "BRIARWOOD",
      "BVIL", "BROWNSBORO VILLAGE",
      "COLD", "COLDSTREAM",
      "CROS", "CROSSGATE",
      "DRHI", "DOUGLAS HILLS",
      "FHIL", "FOREST HILLS",
      "FINC", "FINCASTLE",
      "GMOR", "GRAYMOOR-DEVONDALE",
      "HOAC", "HOUSTON ACRES",
      "HUAC", "HURSTBOURNE ACRES",
      "HURS", "HURSTBOURNE",
      "INH",  "INDIAN HILLS",
      "JTN",  "JEFFERSONTOWN",
      "LVIL", "LOUISVILLE",
      "LYND", "LYNDON",
      "MCRE", "MANOR CREEK",
      "MEDE", "MEADOWVIEW ESTATES",
      "MEDV", "MEADOWVALE",
      "MHIL", "MURRAY HILL",
      "MOOR", "MOORLAND",
      "MTWN", "MIDDLETOWN",
      "NORT", "NORTHFIELD",
      "NOWD", "NORWOOD",
      "PLAN", "PLANTATION",
      "RFIE", "ROLLING FIELDS",
      "RHIL", "ROLLING HILLS",
      "SRPK", "ST REGIS PARK",
      "STM",  "ST MATTHEWS",
      "TBRO", "TEN BROECK",
      "PRO",  "PROSPECT",
      "WDHI", "WOODLAND HILLS",
      "WDPK", "WOODLAWN PARK",
      "WHIL", "WINDY HILLS",
      "WTWD", "WESTWOOD"

  });
}
