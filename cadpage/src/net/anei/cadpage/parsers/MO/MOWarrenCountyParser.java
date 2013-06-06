package net.anei.cadpage.parsers.MO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class MOWarrenCountyParser extends DispatchGlobalDispatchParser {

  public MOWarrenCountyParser() {
    super(CITY_TABLE, "WARREN COUNTY", "MO", DispatchGlobalDispatchParser.PLACE_FOLLOWS_ADDR);
    setupMultiWordStreets("REVEREND THOMAS S HIGGINS",
                          "ST FRANCIS");
  }
  
  @Override
  public String getFilter() {
    return " warrencounty911@warrencounty911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!subject.equals("Dispatch")) return false;
    
    if (!super.parseMsg(subject, body, data)) return false;
    
    int pt = data.strCross.indexOf('\n');
    if (pt >= 0) {
      data.strPlace = append(data.strPlace, " - ", data.strCross.substring(pt+1).trim());
      data.strCross = data.strCross.substring(0,pt).trim();
    }
    return true;
  }
  
  
  private static final Pattern LINE_BREAK_PTN = Pattern.compile("[\\. ]*\n+");
  private class MyInfoField extends BaseInfoField {
    @Override
    public void parse(String field, Data data) {
      field = LINE_BREAK_PTN.matcher(field).replaceAll(". ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_TABLE = new String[]{
    "ASPENHOFF",
    "DUTZOW",
    "FORISTELL",
    "INNSBROOK",
    "MARTHASVILLE",
    "MINDEN",
    "PENDLETON",
    "TRELOAR",
    "TRUESDALE",
    "WARRENTON",
    "WRIGHT CITY",
    
    // Lincoln County
    "HAWK POINT",
    "TROY"
  };
}
