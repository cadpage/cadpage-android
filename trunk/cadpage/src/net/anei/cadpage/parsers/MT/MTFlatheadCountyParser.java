package net.anei.cadpage.parsers.MT;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MTFlatheadCountyParser extends FieldProgramParser {

  public MTFlatheadCountyParser() {
    super(CITY_LIST, "FLATHEAD COUNTY", "MT",
           "Unit:UNIT! Status:SKIP! Location:ADDR/S! Call_Type:CALL! Call_Time:SKIP! Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@communicationcenter.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Information")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("U:")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("MAP ")) field = field.substring(4).trim();
      data.strMap = append(data.strMap, " - ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "COLUMBIA FALLS",
    "KALISPELL",
    "WHITEFISH",
    
    "BIGFORK",
    "CORAM",
    "EVERGREEN",
    "HUNGRY HORSE",
    "LAKESIDE",
    "MARTIN CITY",
    "NIARADA",
    "SOMERS",
    
    "POLEBRIDGE",
    "WEST GLACIER",
  };
  
}
