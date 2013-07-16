package net.anei.cadpage.parsers.WV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;



public class WVHardyCountyParser extends DispatchB3Parser {

  private static final Pattern CITY_SUFFIX = Pattern.compile("^VILLAGE\\b", Pattern.CASE_INSENSITIVE);
  
  public WVHardyCountyParser() {
    super(CITY_LIST, "HARDY COUNTY", "WV");
  }
  
  @Override
  public String getFilter() {
    return "HARDYCOE911@hardynet.com";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
   
  private static final String[] CITY_LIST = new String[]{  
    "MOOREFIELD",
    "WARDENSVILLE"
    
  }; 
}
