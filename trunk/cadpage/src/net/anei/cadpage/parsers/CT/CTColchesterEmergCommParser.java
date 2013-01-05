package net.anei.cadpage.parsers.CT;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class CTColchesterEmergCommParser extends FieldProgramParser {
  
  public CTColchesterEmergCommParser() {
    super("", "CT",
          "CITY ADDR APT X CALL PLACENAME ID! EXTRA");
  }
  
  @Override
  public String getLocName() {
    return "Colchester Emergency Communications, CT";
  }

  @Override
  public String getFilter() {
    return "messaging@iamresponding.com,911@kx911.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\\\\"), 7, data);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("@")) abort();
      super.parse(field.substring(1).trim(), data);
    }
  }
  
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("** ")) abort();
      super.parse(field.substring(3).trim(), data);
    }
  }
  
  private class ExtraField extends Field {

    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strTime = field.substring(0,pt).trim();
      pt = field.indexOf(" CT (");
      if (pt >= 0) {
        field = field.substring(pt+5).trim();
        if (field.endsWith(")")) field = field.substring(0,field.length()-1).trim();
        data.strSupp = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "TIME INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("EXTRA")) return new ExtraField();
    return super.getField(name);
  }
}
