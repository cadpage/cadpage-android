package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

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

Contact: matthew pruitt <pruitt1547@gmail.com>
CAD:ACCIDENT WITH INJURY;3095 OLD CAPE CHARLES RD;CACH;N65;C1;BENDERS LN;PARSONS CIR
 */

public class VAAccomackCountyParser extends DispatchOSSIParser {
  
  public VAAccomackCountyParser() {
    super("ACCOMACK COUNTY", "VA",
           "CALL ADDR! ( CITYST | SKIP MAP MAP ) X X ( ID | INFO )");
  }
  
  @Override
  public String getFilter() {
    return "cad@esva911.org";
  }

  // We need a special field parser to handle the CITYST field
  private class CityStField extends Field {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (! field.contains(" ")) return false;
      parse(field, data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.get(' ');
      data.strState = p.get();
    }
  }
  
  // And we need a special MAP field that will append two map data fields
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, ",", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CITYST")) return new CityStField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
  
}
