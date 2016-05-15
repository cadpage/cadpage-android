package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA37Parser;

public class ALJacksonCountyParser extends DispatchA37Parser {

  public ALJacksonCountyParser() {
    super(null,CITY_LIST, "JACKSON COUNTY", "AL");
  }
  
  @Override
  public String getFilter() { 
    return "ALDispatch@scottsboro.org"; 
  }

  @Override
  protected boolean parseMessageField(String field, Data data) {
    
    data.strSupp = field;
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
      
      "JACKSON COUNTY",
      
  //Cities

      "BRIDGEPORT",
      "SCOTTSBORO",
      "STEVENSON",

  //Towns

      "DUTTON",
      "HOLLYWOOD",
      "HYTOP",
      "LANGSTON",
      "PAINT ROCK",
      "PISGAH",
      "PLEASANT GROVES",
      "SECTION",
      "SKYLINE",
      "WOODVILLE",

  //Unincorporated Communities

      "BAILEYTOWN",
      "BASS",
      "BOLIVAR",
      "BRYANT",
      "CARD SWITCH",
      "ESTILLFORK",
      "FACKLER",
      "FLAT ROCK",
      "FRANCISCO",
      "GORHAM'S BLUFF",
      "HIGDON",
      "HOLLYTREE",
      "LARKIN",
      "LIBERTY HILL",
      "LIM ROCK",
      "LONG ISLAND",
      "PIKEVILLE",
      "PRINCETON",
      "RASH",
      "ROSALIE",
      "SWAIM",
      "TRENTON",
      
  //Ghost towns

      "BELLEFONTE",
      "LITTLE NASHVILLE"

  };
}
