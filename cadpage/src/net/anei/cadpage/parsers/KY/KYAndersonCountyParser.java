package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYAndersonCountyParser extends DispatchB2Parser {
  
  public KYAndersonCountyParser() {
    super(CITY_LIST, "ANDERSON COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@lawrenceburgky.org";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  
  @Override
  protected boolean parseAddrField(String field, Data data) {
    field = field.replace('@', '&').replace(" AT ", " & ");
    return super.parseAddrField(field, data);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "GLENSBORO",
    "LAWRENCEBURG"};


}
