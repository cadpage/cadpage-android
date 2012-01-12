package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


/*
Wyoming County, NY (REPLACE!!!)
Contact: Kimo Brandon <brandokw@clarkson.edu>
Contact: Louis Yunker <louisyunker@yahoo.com>
Sender: wyco911@wyomingco.net

SICK PERSON\n90 KERN RD BENT (Between ERIE CO LINE & URF RD) ADULT FML NOT FEELING WELL
FALLS\n1387 ROUTE 77 BENT (Between ROUTE 354 & POLAND HILL RD)
HEART PROBLEMS\n1535 FRIEDMAN RD BENT (Between ROUTE 77 & TINKHAM RD)
STRUCTURE FIRE\nFRENCH RD BENT (Between ROUTE 354 & HOOVER RD) barn fire
SEIZURE/CONVULSION\n1375 ROUTE 354 BENT (Between ROUTE 77 & GRAFF RD)
STRUCTURE FIRE\n1649 ROUTE 238 ATTT (Between NESBITT RD & ATTICA TOWN LINE)
SICK PERSON\n1258 BURROUGH RD BENT (Between ROUTE 354 & SCHOELLKOPF RD)Post surgical abdominal pain.

*/


public class NYWyomingCountyParser extends SmartAddressParser {
  
  public NYWyomingCountyParser() {
    super(CITY_CODES, "WYOMING COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "wyco911@wyomingco.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    String[] flds = body.split("\n");
    if (flds.length != 2) return false;

    data.strCall = flds[0];
    Parser p = new Parser(flds[1]);
    String sAddr = p.get("(Between ");
    data.strCross = p.get(')');
    data.strSupp = p.get();
    
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    return true;
    
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARCT", "ARCADE",
      "ATTT", "ATTICA",
      "BENT", "BENNINGTON",
      "CAST", "CASTILE",
      "COVT", "COVINGTON",
      "EAGT", "EAGLE",
      "GAIT", "GAINSVEILLE",
      "GENT", "GENESEE FALLS",
      "JAVT", "JAVA",
      "MIDT", "MIDDLEBURY",
      "ORAT", "ORANGEVILLE",
      "PERT", "PERRY",
      "PIKT", "PIKE",
      "WART", "WARSAW",
      "WEAT", "WEATHERSFIELD",
      
      "ARCV", "ARCADE",
      "ATTV", "ATTICA",
      "CASV", "CASTILE",
      "GAIV", "GAINSVILLE",
      "PERV", "PERRY",
      "PIKV", "PIKE",
      "SILV", "SILVER SPRINGS",
      "STRV", "STRYKERSVILLE",
      "WARV", "WARSAW",
      "WYOV", "WYOMING"
  });
}
