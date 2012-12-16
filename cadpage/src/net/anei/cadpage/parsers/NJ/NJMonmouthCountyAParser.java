package net.anei.cadpage.parsers.NJ;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA11Parser;

/**
 * Monmouth County, NJ
 */
public class NJMonmouthCountyAParser extends DispatchA11Parser {
  
  public NJMonmouthCountyAParser() {
    super(CITY_CODES, "MONMOUTH COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "MCSOPageNotification@mcsonj.org,MCSOCallComplete@MCSONJ.ORG";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.startsWith("Call Complete Notification") || body.startsWith("Incident #: ")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    if (subject.equals("MCSO Page Notification") || isPositiveId()) {
      String[] fields = body.split("\n");
      if (fields.length < 6) fields = body.split("  +"); 
      return super.parseFields(fields, 6, data);
    }
    else return false;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "12", "07726",
      "16", "07728",
      "26", "MANALAPAN", // "07726",
      "32", "MILLSTONE", // "08510",
      "84", "COLTS NECK"
  });
}
