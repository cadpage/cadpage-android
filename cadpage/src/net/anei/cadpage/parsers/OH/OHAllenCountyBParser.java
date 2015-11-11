package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.SplitMsgOptions;
import net.anei.cadpage.parsers.SplitMsgOptionsCustom;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHAllenCountyBParser extends DispatchEmergitechParser {
  
  public OHAllenCountyBParser() {
    super("[*]- NATURE:", 0, CITY_LIST, "ALLEN COUNTY", "OH");
  }

  @Override
  public SplitMsgOptions getActive911SplitMsgOptions() {
    return new SplitMsgOptionsCustom(){};
  }
  
  private static final String[] CITY_LIST = new String[]{
    
      //Cities
      
      "DELPHOS",
      "LIMA",

      //Villages

      "BEAVERDAM",
      "BLUFFTON",
      "CAIRO",
      "ELIDA",
      "HARROD",
      "LAFAYETTE",
      "SPENCERVILLE",

      //Townships

      "AMANDA",
      "AMERICAN",
      "AUGLAIZE",
      "BATH",
      "JACKSON",
      "MARION",
      "MONROE",
      "PERRY",
      "RICHLAND",
      "SHAWNEE",
      "SPENCER",
      "SUGAR CREEK",

      //Unincorporated communities

      "ALLENTOWN",
      "AUGLAIZE",
      "CONANT",
      "FORT SHAWNEE",
      "GOMER",
      "HUME",
      "KEMP",
      "LANDECK",
      "NEEDMORE",
      "OAKVIEW",
      "ROCKPORT",
      "ROUSCULP",
      "SCOTTS CROSSING",
      "SLABTOWN",
      "SOUTH WARSAW",
      "SOUTHWORTH",
      "WEST NEWTON",
      "WESTMINSTER",
      "YODER"
  };
}
