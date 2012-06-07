package net.anei.cadpage.parsers.FL;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Manatee County, FL
Contact: "Lee Whitehurst" <lwhitehurst@emfr.org>
Sender: 93001
Location: SR70 EB FR I75 NB UB Estimated Address: alias EXIT 217 UB TYPE CODE: ACCIDENT W/ INJURIES - FIRE/EMS INSIDE LOCATION: SUB TYPE: RE-HIGH MECHANISM (ROLLOVER) TIME: 17:33:02 MAP GRID: 1913-D
Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE (THREAT RESIDENTIAL) TIME: 19:21:37 MAP GRID: 2207-A
Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE (THREAT BLDG) TIME: 17:32:16 MAP GRID: 2207-A
Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE (THREAT BLDG) TIME: 17:32:16 MAP GRID: 2207-A
Location: 35100 SR 64 E MY Estimated Address: @FAULKNER FARMS TYPE CODE: TRAUMATIC INJURIES INSIDE LOCATION: SUB TYPE: RE-UNCONSCIOUS OR ARREST TIME: 19:04:35 MAP GRID: 1602-B
Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE (THREAT RESIDENTIAL) TIME: 19:21:37 MAP GRID: 2207-A
Location: SINGLETARY RD/289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 15:07:03 MAP GRID: 2218-C
Location: 30771 BETTS RD MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE TIME: 15:16:08 MAP GRID: 2208-A
Location: 6520 219TH ST E UB Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 13:31:53 MAP GRID: 1721-C
Location: 40721 11TH AVE E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 18:11:48 MAP GRID: 1432-E
Location: 71ST AVE E/VERNA BETHANY RD MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE W/ UNK THREAT TIME: 14:26:20 MAP GRID: 1725-F
Location: 25606 73RD AVE E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE W/ UNK THREAT TIME: 14:31:14 MAP GRID: 1726-F
Location: 25008 75TH AVE E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 09:29:29 MAP GRID: 1726-F
Location: MORGAN JOHNSON RD/SR 64 E UB Estimated Address TYPE CODE: NATURAL GAS LEAK/ODOR INSIDE LOCATION: NORTH SIDE OF ROADWAY 100 FEET SUB TYPE: RUPTURE/LEAK OUTSIDE (COMMERCIAL LINE OR TANK > 5 GAL) TIME: 16:49:23 MAP GRID: 1027-F

Contact: Daniel Cacchiotti <dpcacchiotti@gmail.com>
Sender: 9418123029 <user phone>
Estimated Address: EST 17993 SR 70 E UB TYPE CODE: ACCIDENT W/ INJS (FIRE/EMS) INSIDE LOCATION: SUB TYPE: RE-UNK STATUS/OTHER CODES N/A TIME: 00:49:38 MAP GRID
Location: 11031 GATEWOOD DR UB Estimated Address TYPE CODE: TEST CALL FOR ECC INSIDE LOCATION: SUB TYPE:  TIME: 11:06:59 MAP GRID: 1132-E
Location: 71ST AVE E/VERNA BETHANY RD MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE W/ UNK THREAT TIME: 14:26:20 MAP GRID:
Location: SR 64 E/LAKEWOOD RANCH BLVD UB Estimated Address TYPE CODE: VEHICLE FIRE INSIDE LOCATION: SUB TYPE: COMMERCIAL VEHICLE TIME: 18:44:41 MAP GRID: 1130-E
Location: 11030 SR 64 E UB Estimated Address TYPE CODE: VEHICLE FIRE INSIDE LOCATION: SUB TYPE: COMMERCIAL VEHICLE TIME: 18:44:41 MAP GRID: 1129-E

Contact: Chris Melser <mcfd1201@gmail.com>
Sender: 777177296980
  Location: LEGACY BLVD/UNIVERSITY PKWY UB Estimated Address TYPE CODE: MVC W/ INJS (FIRE/EMS) INSIDE LOCATION: SUB TYPE: RE-ENTRAPMENT TIME: 17:24:28 MAP GRID:

 */

public class FLManateeCountyParser extends FieldProgramParser {
  
  public FLManateeCountyParser() {
    super(CITY_CODES, "MANATEE COUNTY", "FL",
        "Location:ADDR/S? Estimated_Address:PLACE? TYPE_CODE:CALL! SUB_TYPE:INFO TIME:TIME% MAP_GRID:MAP");
  }

  @Override
  public String getFilter() {
    return "93001,777";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0) return false;
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      int pt = field.indexOf(": @");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      
      if (field.endsWith("Estimated Address")) {
        field = field.substring(0,field.length()-17).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      
      // Remove leading EST
      if (field.startsWith("EST ")) field = field.substring(4).trim();
      if (field.startsWith("@")) field = field.substring(1).trim();
      
      // If there was no location field, use this
      if (data.strAddress.length() == 0) {
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
      }
      
      // Otherwise this is a normal place field
      else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MY", "MYAKKA CITY",
      "UB", "BRADENTON"
  });
}
