package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class PALawrenceCountyParser extends DispatchB2Parser {
  
  public PALawrenceCountyParser() {
    super("911-CENTER:",CITY_LIST, "LAWRENCE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@leoc.net,test@leoc.net";
  }
  
  private static final String[] CITY_LIST = new String[]{
    // Cities
        "NEW CASTLE",
    //  Boroughs
        "BESSEMER",
        "ELLPORT",
        "ELLWOOD CITY // partly in Beaver County",
        "ENON VALLEY",
        "NEW BEAVER",
        "NEW WILMINGTON",
        "S.N.P.J.",
        "SOUTH NEW CASTLE",
        "VOLANT",
        "WAMPUM",
     //  Townships
        "HICKORY TOWNSHIP",
        "LITTLE BEAVER TOWNSHIP",
        "MAHONING TOWNSHIP",
        "NESHANNOCK TOWNSHIP",
        "NORTH BEAVER TOWNSHIP",
        "PERRY TOWNSHIP",
        "PLAIN GROVE TOWNSHIP",
        "PULASKI TOWNSHIP",
        "SCOTT TOWNSHIP",
        "SHENANGO TOWNSHIP",
        "SLIPPERY ROCK TOWNSHIP",
        "TAYLOR TOWNSHIP",
        "UNION TOWNSHIP",
        "WASHINGTON TOWNSHIP",
        "WAYNE TOWNSHIP",
        "WILMINGTON TOWNSHIP"};



}
