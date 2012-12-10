package net.anei.cadpage.parsers.IN;

import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Madison County (Alexandria), IN
 */
public class INMadisonCountyBParser extends FieldProgramParser {
  
  public INMadisonCountyBParser() {
    super("MADISON COUNTY", "IN",
          "( Call_Type:CALL! ( Nature:INFO! Units:UNIT! Call_#:ID! Call_Date/Time:DATETIME! Priority:PRI! Common_Name:PLACE! Address:ADDRCITY! Intersection:X City:CITY Units:UNIT! Info:SKIP! Narr:INFO! Beat:MAP2! Quadrant:MAP1! District:SKIP! Source:SKIP! | ADDRESS:ADDRCITY! UNITS:UNIT INFO:INFO ) | Units:UNIT Call_Type:CALL! Address:ADDRCITY! Info:INFO )");
  }
  
  @Override
  public String getFilter() {
    return "cfs@madisoncountypaging.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CFS")) return false;
    body = body.replace("Call Type:", " Call Type:");
    body = body.replace('\n', ' ').trim();
    return super.parseMsg(body, data);
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" RD# ");
      if (pt >= 0) {
        data.strMap = field.substring(pt+5).trim();
        field = field.substring(0,pt).trim();
      }
      field = field.replace('@', '&');
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " MAP";
    }
  }
  
  private class MyMap1Field extends MyMapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(field, "-", data.strMap);
    }
  }
  
  private class MyMap2Field extends MyMapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public String getFieldNames() {
      return "MAP";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("MM:dd:yyyy hh:mm:ss aa"));
    if (name.equals("MAP1")) return new MyMap1Field();
    if (name.equals("MAP2")) return new MyMap2Field();
    return super.getField(name);
  }
}
