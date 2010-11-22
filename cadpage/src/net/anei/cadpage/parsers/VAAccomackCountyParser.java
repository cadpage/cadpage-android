package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/* Accomack Test Pages
Accomack County, VA - (class I)
Contact: niblett25@gmail.com
Sender: cad@esva911.org
Field 3 is unknown
Field 4-5 make up a map code
Field 6-7 are cross streets
CAD:STROKE;6225 HOLLAND RD;NEWC;A25;A6;DEBRA LN;R J DR
CAD:ACCIDENT WITH INJURY;12432 LANKFORD HWY;HALL;A59;B6;FOX DR;JOHN TAYLOR RD
CAD:ABDOMINAL PAIN;15361 LANKFORD HWY;MAPP;A68;D4;GILLESPIE LN;SHERWOOD DR;MILE MARKER 125

Flatland Search & Rescue
Contact: Flatland Rescue <flatlandsearchandrescueinc@yahoo.com>
CAD:MISSING PERSON DEPLOYMENT;2885 FOX HUNTERS RD;HARRINGTON DE;FOX HUNTERS RD;WHITELEYBURG RD;4345793096
CAD:MISSING PERSON STANDBY;26208 WALNUT TREE RD;EDEN MD;S UPPER FERRY RD;WALNUT TREE RD;4345793096
CAD:MAN POWER SEARCH CHILD;698 MASSIE RD;CHARLOTTESVILLE VA;MASSIE RD;ARLINGTON BLVD;4345793096


 */

public class VAAccomackCountyParser extends SmsMsgParser {

    @Override
    public boolean isPageMsg(String body) {
      return body.startsWith("CAD:");
    }

  @Override
  protected void parse(String body, Data data) {

    data.defState="VA";
    data.defCity="ACCOMACK COUNTY";

    if (body.length() < 4) return;
    
    String[] lines = body.substring(4).split(";");
    int ndx = 0;
    for (String line : lines) {
      line = line.trim();
      switch(ndx++) {
      
      case 0:
        // Call desc
        data.strCall = line;
        break;
        
      case 1:
        // address
        parseAddress(line, data);
        break;
        
      case 2:
        // This could be a city & state
        if (line.contains(" ")) {
          Parser p = new Parser(line);
          data.strState = p.getLast(' ');
          data.strCity = p.get();
          
          // Skip over the two map codes
          ndx += 2;
          break;
        }
        
        // Or it could be a strange field that we skip
        break;
        
      case 3:
      case 4:
        // Map codes
        if (data.strMap.length() > 0) data.strMap += ",";
        data.strMap += line;
        break;
        
      case 5:
      case 6:
        // Cross streets
        if (data.strCross.length() > 0) data.strCross += " & ";
        data.strCross += line;
        break;
        
      case 7:
        data.strSupp = line;
        break;
      }
    }
  }
}
