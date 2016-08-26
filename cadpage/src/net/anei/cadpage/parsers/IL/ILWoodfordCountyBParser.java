package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA47Parser;


public class ILWoodfordCountyBParser extends DispatchA47Parser {
  
  public ILWoodfordCountyBParser() {
    super("{Woodford Comm}", CITY_LIST, "WOODFORD COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "woodcom@woodford-county.org";
  }

  private static final String[] CITY_LIST =new String[]{
    
      //Cities
      
      "El Paso",
      "Eureka",
      "Germantown Hills",
      "Metamora",
      "Minonk",
      "Roanoke",
      "Washburn",

      //Villages 

      "Bay View Gardens",
      "Benson",
      "Congerville",
      "Deer Creek",
      "Goodfield",
      "Kappa",
      "Panola",
      "Secor",
      "Spring Bay",

      //Unincorporated communities

      "Lowpoint",
      "Oak Ridge",
      "Spires",
      "Woodford"

  };
}
