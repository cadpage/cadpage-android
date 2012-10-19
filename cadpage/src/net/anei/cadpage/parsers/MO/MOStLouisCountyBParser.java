package net.anei.cadpage.parsers.MO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MOStLouisCountyBParser extends FieldProgramParser {
  
  public MOStLouisCountyBParser() {
    super("ST LOUIS COUNTY", "MO",
          "CALL CALL ADDR UNIT! MapRegions:MAP! CrossStreets:X Call_Number:ID");
  }
  
  @Override
  public String getFilter() {
    return "alert@scfa911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    body = body.replace(" CrossStreets:", "\nCrossStreets:");
    return parseFields(body.split("\n"), 5, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String sApt = null;
      int pt = field.indexOf(',');
      if (pt >= 0) {
        sApt = field.substring(pt+1).trim();
        if (sApt.startsWith("Apt. ")) sApt = sApt.substring(5).trim();
        if (sApt.startsWith("APT ")) sApt = sApt.substring(4).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
      if (sApt != null) {
        data.strApt = append(data.strApt, "-", sApt);
      }
    }
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("[A-Z]\\d\\d-\\d\\d");
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        String p1 = field.substring(0,pt).trim();
        String p2 = field.substring(pt+1).trim();
        if (MAP_PTN.matcher(p1).matches()) {
          field = p1;
          data.strSupp = p2;
        } else if (MAP_PTN.matcher(p2).matches()) {
          field = p2;
          data.strSupp = p1;
        }
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }
  
  private static final Pattern CARD_PTN = Pattern.compile("\\b[A-Z]{2} Card# \\d{4} 0\\.00 mi\\b");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = CARD_PTN.matcher(field).replaceAll("").trim();
      field = field.replaceAll("  +", " ");
      super.parse(field, data);
      
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
