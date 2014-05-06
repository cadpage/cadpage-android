package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class PALuzerneCountyParser extends DispatchA41Parser {

  public PALuzerneCountyParser() {
    super(CITY_CODES, "LUZERNE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "CADDispatch@LuzerneCounty.org,tyler.lyman@active911.com,5706907165@vzwpix.com,efd19@aol.com";
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BKMT", "BACK MOUNTAIN",
      "CENT", "WILKES-BARRE",
      "EAST", "WILKES-BARRE",
      "FTAC", "WILKES-BARRE",
      "MTOP", "WILKES-BARRE",
      "NORT", "WILKES-BARRE",
      "SOUT", "WILKES-BARRE",
      "WBFD", "WILKES-BARRE",
      "WEST", "WILKES-BARRE",
      "WSMA", "WILKES-BARRE",
     
      // OUT OF COUNTY
      "OOCF",      "OOCF"
  });
}
