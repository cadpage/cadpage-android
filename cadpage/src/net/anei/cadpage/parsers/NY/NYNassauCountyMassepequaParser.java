package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Nassau County, NY (Massepequa)
Contact: Rob Foley <efd6012@gmail.com>
Sender: paging@rednmxcad.com

Rescue: 100 VETERANS BLVD, Town: MASS, Cross: HICKSVILLE RD, Map: C-5, Block#: 160-NORTH, Time: 10:07:10
Washdown/spill: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:30:27
Vehicle Accident: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:28:13
Automatic Alarm: 5500 SUNRISE HWY, Town: MASS, Cross: UNQUA RD, Map: G-5, Block#: 487 SOUTH, Time: 04:19:08
Rescue: 217 EASTLAKE AVE, Town: MPK, Cross: MASSACHUSETTS AVE, Map: F-4, Block#: 262-EAST, Time: 03:35:56
Rescue: 66 HARBOR LN, Town: MPK, Cross: NASSAU ST, Map: D-8, Block#: 820-WEST, Time: 15:31:32

*/
public class NYNassauCountyMassepequaParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MASS", "MASSEPEQUA",
      "MPK",  "MASSEPEQUA PARK"
  });
  
  public NYNassauCountyMassepequaParser() {
    super(CITY_CODES, "NASSAU COUNTY", "NY", 
          "ADDR! Town:CITY! Cross:X! Map:MAP! Block:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "paging@rednmxcad.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace("Block#:", "Block:");
    return super.parseFields(body.split(","), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(':');
      if (pt < 0) abort();
      data.strCall = field.substring(0, pt).trim();
      super.parse(field.substring(pt+1).trim(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL " + super.getFieldNames();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
