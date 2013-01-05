package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Franklin County, VA
 */
public class VAFranklinCountyParser extends DispatchDAPROParser {
  
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
      "BML", "Boones Mill",	
      "CAL", "Callaway",
      "FER", "Ferrum",
      "GLA", "Glade Hill",
      "HEN", "Henry",
      "PEN", "Penhook",	  
      "RMT", "Rocky Mount",
      "UHL", "Union Hall",
      "WIR", "Wirtz",	  
      "BAS", "Bassett",	  
      "HAR", "Hardy",
      "MAR", "Martinsville",
      "MON", "Moneta"	  
    });

  
  public VAFranklinCountyParser() {
    super(CITY_CODE_TABLE, "FRANKLIN COUNTY", "VA");
  }
      
  
  @Override
  public String getFilter() {
    return "mailbox@franklincountyva.org";
  }

}