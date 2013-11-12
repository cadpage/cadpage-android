package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Albemarle County, VA
 */

public class VAAlbemarleCountyParser extends FieldProgramParser {
  
  private static final Pattern GEN_ALERT_PTN = Pattern.compile("TIME: (\\d\\d:\\d\\d) +(.*)");
  
  public VAAlbemarleCountyParser() {
    super(CITY_CODES, "ALBEMARLE COUNTY", "VA",
          "( PRI:PRI_ID! TYP:CALL | CALL! ) APT:APT? AD:ADDR! CTY:CITY! LOC:INFO? CMT1:INFO? CMT2:INFO?? XST:X? XST2:X?");
  }
  
  @Override
  public String getFilter() {
    return "CAD@acuecc.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() < 10) return false;
    
    data.strUnit = body.substring(0,10).trim();
    body = body.substring(10).trim();
    
    Matcher match = GEN_ALERT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "GENERAL ALERT";
      data.strTime =  match.group(1);
      data.strPlace = match.group(2);
      return true;
    }
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PRI_ID")) return new MyPriorityIdField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern PRI_ID_PTN = Pattern.compile("(\\d) +FAF\\d{7}(\\d{5})");
  private class MyPriorityIdField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher match = PRI_ID_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strPriority = match.group(1);
      data.strCallId = match.group(2);
    }

    @Override
    public String getFieldNames() {
      return "PRI ID";
    }
    
  }
  
  // Address field may contain place name
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" - ");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data); 
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) {
        data.strSupp = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CITY INFO";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }

  @Override
  public String adjustMapAddress(String sAddress, boolean cross) {
    return sAddress.replace("LEWIS AND CLARK", "LEWIS_AND_CLARK");
  }

  @Override
  public String postAdjustMapAddress(String sAddress) {
    return sAddress.replace("LEWIS_AND_CLARK", "LEWIS AND CLARK");
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AC", "",
      "CH", "CHARLOTTSVILLE",
      "SC", "SCOTTSVILLE"
  });
}
