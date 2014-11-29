package net.anei.cadpage.parsers.KY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYAndersonCountyParser extends DispatchB2Parser {
  
  public KYAndersonCountyParser() {
    super("911-CENTER:",CITY_LIST, "ANDERSON COUNTY", "KY");
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
  
  @Override
  public String adjustMapAddress(String addr) {
    return BYPASS_PTN.matcher(addr).replaceAll("US 127");
  }
  private static final Pattern BYPASS_PTN = Pattern.compile("\\bBYPASS\\b", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_LIST = new String[]{
    "GLENSBORO",
    "LAWRENCEBURG"};


}
