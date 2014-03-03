package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHFairfieldCountyParser extends DispatchEmergitechParser {
  
  public OHFairfieldCountyParser() {
    super("", -24, CITY_LIST, "FAIRFIELD COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@smtp-server.Columbus.rr.com";
  }
  
  
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Remove prefix
    if (body.startsWith("Dispatch:")) {
      body = body.substring(9).trim();
    }
    
    // If preparser removed the dispatch unit, put it back
    else if (subject.length() > 0) {
      body = '[' + subject + "]" + body; 
    }
    return super.parseMsg(body, data);
  }



  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "COLUMBUS",
    "LANCASTER",
    "PICKERINGTON",
    "REYNOLDSBURG",
    
    // Villages
    "AMANDA",
    "BALTIMORE",
    "BREMEN",
    "BUCKEYE LAKE",
    "CANAL WINCHESTER",
    "CARROLL",
    "LITHOPOLIS",
    "MILLERSPORT",
    "PLEASANTVILLE",
    "RUSHVILLE",
    "STOUTSVILLE",
    "SUGAR GROVE",
    "TARLTON",
    "THURSTON",
    "WEST RUSHVILLE",
    
    // Townships
    "AMANDA TWP",
    "BERNE TWP",
    "BLOOM TWP",
    "CLEARCREEK TWP",
    "GREENFIELD TWP",
    "HOCKING TWP",
    "LIBERTY TWP",
    "MADISON TWP",
    "PLEASANT TWP",
    "RICHLAND TWP",
    "RUSH CREEK TWP",
    "VIOLET TWP",
    "WALNUT TWP",
    
    // Census-designated place
    "FAIRFIELD BEACH",
    
    // Other Communities
    "CEDAR HILL",
    "CLEARPORT",
    "COLFAX",
    "DELMONT",
    "DRINKLE",
    "DUMONTSVILLE",
    "GENEVA",
    "GREENCASTLE",
    "HAMBURG",
    "HAVENSPORT",
    "HOOKER",
    "HORNS MILL",
    "JEFFERSON",
    "LOCKVILLE",
    "MARCY",
    "NEW SALEM",
    "NORTH BERNE",
    "OAKLAND",
    "OAKTHORPE",
    "REVENGE",
    "ROYALTON",
    "WATERLOO"
  };
}
