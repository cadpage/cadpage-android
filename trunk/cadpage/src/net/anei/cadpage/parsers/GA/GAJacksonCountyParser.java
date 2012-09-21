package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Jackson County, GA
Contact: Jeffrey Jones <jljones87@gmail.com>
Sender: 93001nnn

JACKSONE911:1070 >FIRE 1382 WILHITE RD XS: PAYNEVILLE RD JEFFERSON WIER, GILBERT L & SUE 7063678650 Map: Grids:0,0 Cad: 2012-0000049643
JACKSONE911:1050I >ACCIDENT - INJURIES 3835 APPLE VALLEY RD BILL Cad: 2012-0000049719
JACKSONE911:SIG16 >STROKE/CVA PATIENT 87 BEND DR XS: COMMERCE RD JEFFERSON FLOYD PAULSON 7066148432 Map:H6 Grids:0,0 Cad: 2012-0000053376
JACKSONE911:SIG3 >CHEST PAIN/RESPIRATORY DISTRES 95 W G LEGG RD XS: RAFORD WILSON RD COMMERCE LEGG, JERRY 7063675387 Cad: 2012-0000055115
JACKSONE911:SIG3 >CHEST PAIN/RESPIRATORY DISTRES 4513 S APPLE VALLEY RD XS: EDGEFIELD DR COMMERCE HOMAN, JARED 7062026827 Map: Grids:0,0 Cad: 2012-0000054782

*/

public class GAJacksonCountyParser extends DispatchBParser {

  public GAJacksonCountyParser() {
    super(CITY_LIST, "JACKSON COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "93001";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("JACKSONE911:");
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // cities and towns
    "ARCADE",
    "BRASELTON",
    "COMMERCE",
    "HOSCHTON",
    "JEFFERSON",
    "MAYSVILLE",
    "NICHOLSON",
    "PENDERGRASS",
    "TALMO",
    
    // unincorporated communities
    "APPLE VALLEY",
    "ATTICA",
    "BROCKTON",
    "CENTER",
    "CLARKSBORO",
    "CONSTANTINE",
    "DRY POND",
    "EDNAVILLE",
    "FAIRVIEW",
    "GROVE LEVEL",
    "HOLDERS",
    "HOLLY SPRINGS",
    "RED STONE",
    "SELLS",
    "STONEHAM",
    "THOMPSONS MILLS",
    "THURMACK",
    "THYATIRA",
    "WILSONS CHURCH"

  };
}
