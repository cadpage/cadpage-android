package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Cecil County, MD
Contact: CodeMessaging
Sender: @c-msg.net

[pCAD] TYPE: 17A01 FALL LOC: 33 CENTER ST BOX: 700 TIME: 162632
[pCAD] TYPE: 06D01 RESPIRATORY DISTRESS LOC: 32 OWENS CT BOX: 600 TIME: 034305
[pCAD] TYPE: MVA MOTOR VEHICLE ACC LOC: PERRYLAWN DR / TURNPIKE DR BOX: 602 TIME: 072112
[pCAD] TYPE: 33A03 TRANS/PALLIATIVE LOC: BOX: 1100 TIME: 184230
[pCAD] TYPE: 06D01 RESPIRATORY DISTRESS LOC: 300 CARTER CT APT D BOX: 601 TIME: 092448
[pCAD] TYPE: 30A01 INJURED PERSON LOC: 1201 CHESAPEAKE OVERLOOK PKWY @CASINO BOX: 602D TIME: 174554
[pCAD] TYPE: 26A10 SICK PERSON LOC: 108 CONCORD DR @CONCORD APARTMENTS BOX: 600 TIME: 194041
[pCAD] TYPE: 31D03 UNCON/SYNCOPAL LOC: 33 RESERVOIR RD BOX: 602 TIME: 084642
[pCAD] TYPE: AMBO AMBO CALL LOC: PERRYLAWN DR / DIAMOND JIM RD BOX: 606 TIME: 092817
[pCAD] TYPE: AMBO AMBO CALL LOC: 330 OTSEGO ST BOX: 600 TIME: 172824
[pCAD] TYPE: AMBO AMBO CALL LOC: 701 RUSTIC CT BOX: 601 TIME: 184244
[pCAD] TYPE: AMBO AMBO CALL LOC: CASINO @1201 CHESAPEAKE OVERLOOK PKWY BOX: 602D TIME: 111634
[pCAD] TYPE: HOUSE HOUSE FIRE LOC: 751 AIKEN AVE BOX: 600 TIME: 144557
[pCAD] TYPE: 02C02 ALLERGIC REACTION LOC: 469 SUMPTER DR BOX: 601 TIME: 153301
[pCAD] TYPE: HAZMAT HAZARDOUS MATERIALS LOC: CECIL COUNTY LANDFIL @758 E OLD PHILADELPHIA RD BOX: 401 TIME: 132727
[pCAD] TYPE: HOUSE HOUSE FIRE LOC: 751 AIKEN AVE BOX: 600 TIME: 012030
[pCAD] TYPE: MVA MOTOR VEHICLE ACC LOC: PERRYLAWN DR / RT 222 - PERRYVILLE BOX: 602 TIME: 091057


*/

public class MDCecilCountyCParser extends FieldProgramParser {
  
  public MDCecilCountyCParser() {
    super("CECIL COUNTY", "MD",
        "TYPE:CALL! LOC:ADDR! BOX:BOX! TIME:TIME!");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.getLastOptional(" - ");
      String addr = p.get('@');
      String place = p.get();
      
      // They aren't consistent about whether the place comes before or after the address
      // so we will pick the one that doesn't look like an address
      if (place.length() > 0) {
        if (checkAddress(place) > checkAddress(addr)) {
          String tmp = addr;
          addr = place;
          place = tmp;
        }
      }
      data.strPlace = place;
      super.parse(addr, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE CITY";
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() != 6) return;
      field = field.substring(0,2) + ':' + field.substring(2,4) + ':' + field.substring(4,6);
      super.parse(field, data);
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }  
}






