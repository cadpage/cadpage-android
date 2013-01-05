package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;



public class NYHerkimerCountyParser extends DispatchBParser {
  
  private static final String DEF_CITY = "HERKIMER COUNTY";
  private static final String DEF_STATE = "NY";
  
  private static final String[] CITY_LIST =  
    {"NORWAY", "NEWPORT", "RUSSIA", "POLAND", "NEWPORT", "FAIRFIELD",
     "MIDDLEVILLE", "OHIO", "DEERFIELD", "LITTLE FALLS CITY"}; 
  
  public NYHerkimerCountyParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "HC911@herkimercounty.org";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.isPageMsg(body) && !body.contains("Grids:,, NY")) return false; 
    body = "(" + subject + ") " + body.replaceAll("\n", " ").replaceAll(" Grids:,, NY ", " ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public boolean parseAddrField(String line, Data data) {
    if (line.length() < 10) return false;
    if (line.charAt(0) == '(') {
      int pt = line.indexOf(')');
      if (pt < 0) return false;
      data.strCall = line.substring(1, pt);
      data.strCall = data.strCall.replaceAll("\\s+>", ">");
      line = line.substring(pt+1).trim();
    }
    
    // Call smart parser for rest of it
    parseAddress(StartType.START_ADDR, line, data);
    return true;
  }
}
