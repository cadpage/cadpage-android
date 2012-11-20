package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VARockinghamCountyParser extends DispatchDAPROParser {
  
  private static final String DEF_STATE = "VA";
  private static final String DEF_CITY = "ROCKINGHAM COUNTY";
  
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
        "BRO", "BROADWAY",
        "BRI", "BRIDGEWATER",
        "HAR", "HARRISONBURG",
        "SIN", "SINGERS GLEN",
        "CLO", "CLOVER HILL",
        "HIN", "HINTON",
        "MOU", "MOUNT CRAWFORD",
        "TIM", "TIMBERVILLE",
        "DAY", "DAYTON",
        "GRO", "GROTTOES",
        "MCG", "MCGAHEYSVILLE",
        "PEN", "PENN LAIRD",
        "ELK", "ELKTON",
        "WEY", "WEYERS CAVE",
        "NEW", "NEW MARKET",
        "STA", "STANLEY",
        "LUR", "LURAY",
        "SHE", "SHENANDOAH",
        "KEE", "KEEZLETOWN"
    });
  
	  
	  public VARockinghamCountyParser() {
			 super(CITY_CODE_TABLE, DEF_CITY, DEF_STATE);
	  }
	  
	  @Override
	  public String getFilter() {
	    return "messaging@iamresponding.com,mailbox@hrecc.org";
	  }
}