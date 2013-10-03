package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;



public class IAMuscatineCountyParser extends DispatchShieldwareParser {
  
  public IAMuscatineCountyParser() {
    super(CITY_LIST, "MUSCATINE COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "777,888";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    data.strSource = subject;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities    
    "ATALISSA",
    "BLUE GRASS",
    "DURANT",
    "CONESVILLE",
    "FRUITLAND",
    "MUSCATINE",
    "NICHOLS",
    "STOCKTON",
    "WALCOTT",
    "WEST LIBERTY",
    "WILTON",

    // Unincorporated communities
    "CRANSTON",
    "FAIRPORT",
    "MIDWAY BEACH",
    "MONTPELIER",
    "MOSCOW",
    "PETERSBURG"
  };
}
