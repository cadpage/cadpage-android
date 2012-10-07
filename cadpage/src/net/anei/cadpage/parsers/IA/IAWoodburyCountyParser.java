package net.anei.cadpage.parsers.IA;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class IAWoodburyCountyParser extends SmartAddressParser {

  private static final String[] CITY_LIST = new String[] {
    "NORTH SIOUX", "DAKOTA DUNES", "WYNSTONE", "ANTHON","BRONSON","CORRECTIONVILLE","CUSHING","DANBURY",
    "HORNICK","LAWTON","MOVILLE","OTO","PIERSON","SALIX","SERGEANT BLUFF","SIOUX CITY","SLOAN","SMITHLAND",
    "UNION COUNTY"
  };
  
  private static final Set<String> SD_CITY_SET = new HashSet<String>(Arrays.asList(new String[] {
    "NORTH SIOUX", "DAKOTA DUNES", "WYNSTONE", "UNION COUNTY"
  }));
  
  public IAWoodburyCountyParser() {
    super(CITY_LIST, "WOODBURY COUNTY", "IA");
  }


  @Override
  protected boolean parseMsg(String body, Data data) {

    int pt = body.indexOf("J:");
    if (pt < 0) return false;
    body = body.substring(pt+2).trim();
    
    String[] lines = body.split("/");
    int ndx = 0;
    for (String line : lines) {
      line = line.trim();
      switch (ndx++) {
      
      case 0:
        // Call description
        data.strCall = line;
        break;
        
      case 1:
        // Address line
        // Contains address city and optional place name
        // If city is in SD, change state
        parseAddress(StartType.START_ADDR,line,data);
        
        // If this didn't look like an address, it's probably another chunk
        // of the call description :(
        if (getStatus() == 0) {
          data.strCall = data.strCall + " / " + line;
          data.strAddress = data.strCity = "";
          ndx--;
          break;
        }
        
        data.strPlace = getLeft();
        if (SD_CITY_SET.contains(data.strCity)) data.strState = "SD"; 
        break;
      
      case 2:
        // Cross Street. If only one street will end with & which we drop
        // Occasionally is not present, in which case skip to next field
        if (line.contains("&")) {
          if (line.endsWith("&")) line = line.substring(0,line.length()-1).trim();
          data.strCross = line;
          break;
        }
        ndx++;
        
      case 3:
        // Station
        data.strSource = line;
        break;

      case 4:
        // Unit
        data.strUnit = line;
        break;
        
      case 5: 
        // supp info, repeats till end of msg
        if (line.length() > 0) {
          if (data.strSupp.length() > 0) data.strSupp += " / ";
          data.strSupp += line;
        }
        ndx--;
        break;
      }
      
    }
    
    // Return failure if we didn't get to station
    return ndx > 4;
  }
  

}