package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/* 
Carteret county, NC 
Contact: Jamie Fulk <jfulk2402@gmail.com>
Sender: cec@carteretcountygov.org
Use DispatchSouthernParser
CEC:303 COLLEGE CIR MOREHEAD CITY FDL 52C03-G 11-090057 12:36:58 ALARM FIRE
CEC:3905 ARENDELL ST MOREHEAD CITY MDL 30B01 11-090021 11:38:14 TRAUMATIC INJURIES
CEC:828 S YAUPON TER MOREHEAD CITY 11-089759 20:36:57 CHECK WELFARE
CEC:3722 BRIDGES ST MOREHEAD CITY MDL 10C04 11-089619 15:13:10 CHEST PAIN
CEC:2714 MAYBERRY LOOP RD MOREHEAD CITY 11-089532 12:03:48 HEAT - COLD EXPOSURE
CEC:1005 YAUPON DR MOREHEAD CITY 11-088667 20:15:44 OUTSIDE FIRE
CEC:3500 ARENDELL ST MOREHEAD CITY 11-089379 04:23:11 TRANSFER (MEDICAL) INTERFACILITY
CEC:3017 BRIDGES ST MOREHEAD CITY 11-086957 13:07:00 STRUCTURE FIRE
CEC:5018 HWY 70 MOREHEAD CITY 11-088596 16:40:33 MVC UNK PI
CEC:BRIDGES ST ST EXT / HWY 70 11-087512 13:54:18 MVC MINOR
CEC:5167 HWY 70 MOREHEAD CITY FDL 60D03-O 11-087553 15:18:54 GAS LEAK - ODOR (LP or Natural Gas)
CEC:11-082100 08:48:00 SICK PERSON WEST WOOD SQUARE APTS 403 BROOK ST E32 MOREHEAD CITY
CEC:11-082157 11:29:34 MVC PI OR ROLLOVER WILCO HESS MHC 4TH ST 400 ARENDELL ST MOREHEAD CITY
CEC:11-082262 16:31:51 STRUCTURE FIRE 4 VINE LN NEWPORT FDL 69D10
CEC:114 CLUB COLONY DR b ATLANTIC BEACH FDL 52B01-G 11-084908 18:06:28 ALARM FIRE
CEC:306 CRAVEN ST BEAUFORT MDL 17B03-G 11-089178 19:42:02 FALLS
CEC:405 WEST BEAUFORT RD BEAUFORT FDL 69D06 11-085673 04:39:22 STRUCTURE FIRE
CEC:HWY 24 / HWY 70 11-088160 17:29:35 MVC PI OR ROLLOVER
CEC:438 MACON CT MOREHEAD CITY MDL 01A01 11-088343 02:36:15 ABDOMINAL PAIN - PROBLEMS
CEC:306 CRAVEN ST BEAUFORT MDL 17B03-G 11-089178 19:42:02 FALLS
CEC:315 FRONT ST BEAUFORT FDL 52C03-G 11-088849 04:01:34 ALARM FIRE
CEC:4035 ARENDELL ST rm 226 MOREHEAD CITY 11-089051 14:12:37 BREATHING PROBLEMS
CEC:1805 ARENDELL ST apt b MOREHEAD CITY MDL 26D01 11-088938 09:43:13 SICK PERSON

Sea Level, NC (In Carteret County)
Contact: Phillip Laxton <plaxton@sealevelfire-rescue.org>
Sender: plaxton@sealevelfire-rescue.org
CEC:272 HWY 70 SEA LEVEL SEA LEVEL 11-087105 20:00:18 HEART PROB -DEFIB
CEC:272 HWY 70 SEA LEVEL SEA LEVEL 11-090344 23:57:53 SICK PERSON
CEC:1056 HWY 70 DAVIS DAVIS MDL 28C01-L 11-090093 13:50:12 STROKE
CEC:468 HWY 70 SEA LEVEL SEA LEVEL MDL 06D02 11-088385 08:00:04 BREATHING PROBLEMS
CEC:1133 HWY 70 STACY STACY MDL 28C01-L 11-086390 13:22:20 STROKE
CEC:1185 SEASHORE DR ATLANTIC MDL 09E01 11-084435 20:18:33 UNCONSCIOUS - FAINTING

Contact: James <firefighter1249@gmail.com>
wcfd.comm2+caf_=2522413726=vtext.com@gmail.com CEC:392 CROATAN DR CAPE CARTERET MDL 01D01 11-109565 11:32:17 FALLS
wcfd.comm2+caf_=2522413726=vtext.com@gmail.com CEC:129 HUNTER BROWN DR CAPE CARTERET 11-113600 16:24:22 STROKE

*/

public class NCCarteretCountyParser extends DispatchSouthernParser {
  
  
  public NCCarteretCountyParser() {
    super(CITY_LIST, "CARTERET COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "cec@carteretcountygov.org,@sealevelfire-rescue.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    // Sometimes city name is duplicated in address
    // which ends up as the place name
    if (data.strCity.equals(data.strPlace)) data.strPlace = "";
    return true;
  }
  

  private static final String[] CITY_LIST = new String[]{
    "ATLANTIC BEACH",
    "BEAUFORT",
    "BOGUE",
    "CAPE CARTERET",
    "CEDAR POINT",
    "EMERALD ISLE",
    "INDIAN BEACH",
    "MOREHEAD CITY",
    "NEWPORT",
    "PELETIER",
    "PINE KNOLL SHORES",
    
    "ATLANTIC",
    "BETTIE",
    "BROAD CREEK",
    "CEDAR ISLAND",
    "DAVIS",
    "GALES CREEK",
    "GLOUCESTER",
    "HARKERS ISLAND",
    "HARLOWE",
    "LOLA",
    "MARSHALLBERG",
    "MERRIMON",
    "MILL CREEK",
    "NORTH RIVER",
    "OCEAN",
    "OTWAY",
    "SALTER PATH",
    "SEA GATE",
    "SEA LEVEL",
    "STACY",
    "STELLA",
    "STRAITS",
    "SMYRNA",
    "WILDWOOD",
    "WILLISTON",
    "WIREGRASS"
   
  };

}
