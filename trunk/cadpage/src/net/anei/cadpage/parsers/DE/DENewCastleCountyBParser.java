package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchChiefWebPagingParser;


public class DENewCastleCountyBParser extends DispatchChiefWebPagingParser {
  
  public DENewCastleCountyBParser() {
    super(CITY_LIST, "NEW CASTLE COUNTY", "DE");
  }

  @Override
   protected boolean parseMsg(String subject, String body, Data data) {
    
    // Drop calls from Deepwater, NJ
    if (body.contains(" Caller:")) return false;
    
    body = body.replace("Dead - End", "Dead End");
    return  super.parseMsg(subject,  body, data);
  }
  
  private static String[] CITY_LIST = new String[]{
    "NEW CASTLE",
    
    "ARDENCROFT",
    "ARDENTOWN",
    "BELLEFONTE",
    "CLAYTON",
    "DELAWARE CITY",
    "ELSMERE",
    "MIDDLETOWN",
    "NEW CASTLE",
    "NEWARK",
    "NEWPORT",
    "ODESSA",
    "SMYRNA",
    "TOWNSEND",
    "WILMINGTON",
    "BEAR",
    "BROOKSIDE",
    "CLAYMONT",
    "COLLINS PARK",
    "CHRISTIANA",
    "EDGEMOOR",
    "GLASGOW",
    "GREENVILLE",
    "HOCKESSIN",
    "HOLLY OAK",
    "MARSHALLTON",
    "MINQUADALE",
    "MONTCHANIN",
    "NORTH STAR",
    "OGLETOWN",
    "PIKE CREEK",
    "ROCKLAND",
    "ST. GEORGES",
    "STANTON",
    "WILMINGTON MANOR",
    "WINTERTHUR",
    "WINTERSET"
  };
}


