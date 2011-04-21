package net.anei.cadpage.parsers.IA;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Woodbury County, IA
Contact: "Luke Nixa NREMT-B" <lcn42781@cableone.net>
Sender: 712-253-8205 ?
System: Sunguard CAD

J:FIRE ALARM/813 N DERBY LN NORTH SIOUX PORTIONABLES/ FREEDOM DR & DEVILSFOOD DR/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/ PORTIONABLES.... WATER FLOW ALARM
J:FIRE SM VEHICLE/110 SODRAC DR NORTH SIOUX RED CARPET INN/ RIVER DR &/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/ TRUCK SMOKING LOOKS ON FIRE- NOBODY AROUND -IN FRONT OF INN
J:STROKE/300 CENTENNIAL DR NORTH SIOUX ALORICA/ N MERRILL AVE & GATEWAY DR/NSIOUX/ 72EMS9/ 49YO FEMALE  - HAS HAD ONE IN THE PAST - USE MIDDLE DOORS
J:CHOKING/215 WALLACE AVE NORTH SIOUX/ N MAIN ST & ROSE ST/NSIOUX/ 72EMS9
J:TROUBLE BREATHING/800 STEVENS PORT DR DAKOTA DUNES/DDUNES/ 72EMS9/VIZIO BUSINESS. SMALLER BLDG, 1ST BLDG. BOTTOM SUITE
J:SICK PERSON/24 NORTHSHORE DR NORTH SIOUX/STREETER DR & LEISURE LN/NSIOUX/ 72EMS9/FEMALE HAS BEEN ASLEEP FOR 15 HOURS AND CANT SEEM TO STAY
J:EMS FOR PI/1 I29 NORTH SIOUX MM1 I29 SD/IOWA BORDER &/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/UNDERNEATH THE
J: UNCONSCIOUS/FAINTING /925 WYNSTONE RD UNION COUNTY /NSIOUX /72EMS9 /12 YR OLD FEMALE FELL IS SHOWER 3 TIMES--UNCON NOW

*/


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