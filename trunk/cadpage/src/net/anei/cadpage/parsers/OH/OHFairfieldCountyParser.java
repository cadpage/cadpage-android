package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/*
Fairfield County, OH
Contact: Brian Malone <ptfd13@gmail.com>
Contact: Kasey Farmer <kasey.farmer610@gmail.com>
Sender: radio@sheriff.fairfield.oh.us
System: Emergitech.

[DIS44]- NATURE: ACAL LOCATION: 114 ACADEMY ST PLEASANTV ILLE BETWEEN S MAIN ST / LINCOLN AV COMMENTS: NO APT GIVENGENDERAL FIRE -DIS44 Fairfield 911
[DIS15]- NATURE: S29 LOCATION: 2295 ELDER RD NE PLEASAN T TWP BETWEEN US RT 22 / BERRY RD COMMENTS: 67 YOF SEVERE A BD & SIDE PAINS. -DIS15 Fairfield
[DIS20]- NATURE: C4 LOCATION: 4815 OLD MILLERSPORT RD NE PLEASANT TWP BETWEEN OLD MILL RD / CARROLL-EASTERN RD CO MMENTS: REF TO 2 VEHICLES, 1 INTO CO
[DIS45]- NATURE: S29 LOCATION: 2890 LANCASTER-THORNVILL E RD NE PLEASANT TWP BETWEEN PLEASANT WAY / COONPATH RD AC CESS BY ST RT 188 COMMENTS: 44 YOM
[DIS48]- NATURE: C28 LOCATION: 206 MARKET ST PLEASANTVI LLE BETWEEN W WALNUT ST / S MAIN ST COMMENTS: PILE OF LEAVE S 4-5 FT FROM A STRUCTURE ---SEEMS
[DIS45]- NATURE: C28 LOCATION: COONPATH RD NW / LANCAST ER-KIRKERSVILLE RD NW GREENFIELD TWP BETWEEN CLAYPOOL DR / DEAD END COMMENTS: CALLER IS ADV TH
[DIS19]- NATURE: C4 LOCATION: COONPATH RD NW / ELECTIO N HOUSE RD NW GREENFIELD TWP BETWEEN CLAYPOOL DR / DEAD END COMMENTS: REF TO 2 VEHICLES..UNKNOW
[DIS50]- NATURE: C4 LOCATION: 4496 CINCINNATI-ZANESVIL LE RD NE PLEASANT TWP BETWEEN IRELAND ROAD / SNOKE HILL RD ACCESS BY US RT 22 COMMENTS: +039.73
[DIS40]- NATURE: S29 LOCATION: 6570 MC CLEERY RD NW LIB ERTY TWP BETWEEN LEONARD RD / PLEASANTVILLE RD COMMENTS: 38 YOM WITH SEVERE ABDOMINAL PAIN -DI

 */


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
    
    // If preparser removed the dispatch unit, put it back
    if (subject.length() > 0) body = '[' + subject + "]" + body; 
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
