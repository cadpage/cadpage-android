package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.FieldProgramHtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchSPKParser extends FieldProgramHtmlParser {

  public DispatchSPKParser(String defCity, String defState) {
    super(defCity, defState,
         "ID DATETIME CALL ADDRCITY CITY X APT GPS PHONE NAME INFO UNIT",
          LAYOUT);
    translate(TRANS);
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!getHtmlCleaner(body)) return false;
    return parseFields(getValueArray(), data); 
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}|", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d\\d \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("CITY")) return new BaseCityField();
    return super.getField(name);
  }
  
  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" - ");
      if (pt >= 0) {
        data.strCode = field.substring(0,pt).trim();
        field = field.substring(pt+3).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class BaseCityField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() > 0) return;
      super.parse(field, data);
    }
  }
  
  private static final String[] LAYOUT = {
    "ID(table=0; element=td; label=/CAD Incident : /; remove_label)",
    "DATETIME(element=p; label=/As of /; remove_label)",
    "CODE(table=0; element=td; label=/Event Code: /; remove_label; required)",
    "LOCATION(table=0; element=td; label=/Location: /; remove_label; required)",
    "COMMUNITY(table=0; element=td; label=/Community: /; remove_label)",
    "CROSS_STREET(table=0; element=td; label=/Cross Street: /; offset=1-2; exclude=/Apartment: /; separator=/ & /)",
    "APARTMENT(table=0; element=td; label=/Apartment: /; remove_label)",
    "GPS(table=0; element=td; label=/L/L:/; remove_label)",
    "PHONE(xpath=///h1[normalize-space(.)=\"Caller information\"]/following-sibling::table[1]/tbody/tr/td[contains(., \"Caller Phone:\")]/; xJava; remove=/Caller Phone:/)",
    "NAME(xpath=///h1[normalize-space(.)=\"Caller information\"]/following-sibling::table[1]/tbody/tr/td[contains(., \"Caller Name:\")]/; xJava; remove=/Caller Name:/)",
    "NARRATIVE(xpath=///h1[normalize-space(.)=\"Remarks/Narratives:\"]/following-sibling::table[1]/tbody/tr/td[2]/; xJava)",
    "UNIT(xpath=///*[normalize-space(.)=\"Unit Information:\"]/following-sibling::table[1]/tbody/tr[position()>1]/td[1]/; xJava)"
  };
  
  private static final String[] TRANS = {
    "&amp;", "&"
  };
}
