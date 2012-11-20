package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class VALouisaCountyParser extends FieldProgramParser {

  
  public VALouisaCountyParser() {
    super(CITY_CODES, "LOUISA COUNTY", "VA",
           "ID? CALL! ADDR/S! PLACE BOX! Info:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "911@louisa.org,Dispatch@louisa.org,CADEMS4@louisa.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Incident Notification")) return false;
    int pt = body.indexOf(" Closed APCO Case:");
    if (pt < 0) pt = body.indexOf(" Opened APCO Case:");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return parseFields(body.split(";"), data);
  }
  
  // ID field, confirm has correct form
  private static final Pattern CALL_ID_PTN = Pattern.compile("Call#: *-(\\d+)");
  private class MyIdField extends IdField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = CALL_ID_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strCallId = match.group(1);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (!field.startsWith("Box ")) abort();
      field = field.substring(4).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("BOX")) return new MyBoxField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CTOR", ""
  });
}
