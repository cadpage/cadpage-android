package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class PALawrenceCountyParser extends DispatchB2Parser {
  
  private static final Pattern CALL_ADDR_PTN = Pattern.compile("(.* (?:ALPHA|BRAVO|CHARLIE?|DELTA)) +(.*)", Pattern.CASE_INSENSITIVE);
  
  public PALawrenceCountyParser() {
    super("911-CENTER:",CITY_LIST, "LAWRENCE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@leoc.net,test@leoc.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BOR")) data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
    return true;
  }

  @Override
  protected Pattern getCallPattern() {
    return CALL_ADDR_PTN;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
        "NEW CASTLE",
        
    //  Boroughs
        "BESSEMER BOR",
        "ELLPORT BOR",
        "ELLWOOD CITY BOR",
        "ENON VALLEY BOR",
        "NEW BEAVER BOR",
        "NEW WILMINGTON BOR",
        "SNPJ BOR",
        "SOUTH NEW CASTLE BOR",
        "VOLANT BOR",
        "WAMPUM BOR",
        
     //  Townships
        "HICKORY TWP",
        "LITTLE BEAVER TWP",
        "MAHONING TWP",
        "NESHANNOCK TWP",
        "NORTH BEAVER TWP",
        "PERRY TWP",
        "PLAIN GROVE TWP",
        "PULASKI TWP",
        "SCOTT TWP",
        "SHENANGO TWP",
        "SLIPPERY ROCK TWP",
        "TAYLOR TWP",
        "UNION TWP",
        "WASHINGTON TWP",
        "WAYNE TWP",
        "WILMINGTON TWP"
   };
}
