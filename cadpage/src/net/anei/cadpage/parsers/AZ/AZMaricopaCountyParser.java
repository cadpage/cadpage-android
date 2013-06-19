
package net.anei.cadpage.parsers.AZ;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Mesa, AZ (Maricopa County)
 */

public class AZMaricopaCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
	"SCOT", "SCOTTSDALE",
	"SNLK", "SUN LAKES",
	"APJU", "APACHE JUNCTION",
	"CHAN", "CHANDLER",
	"GILB", "GILBERT",
	"MESA", "MESA",
	"PINA", "PINAL",
	"QNCR", "QUEEN CREEK",
	"TEMP", "TEMPE"
  });

  public AZMaricopaCountyParser() {
    super(CITY_CODES, "MARICOPA COUNTY", "AZ",
           "Location:ADDR/S! EVENT:ID! TYPE_CODE:CALL! TIME:TIME! CALLER_NAME:NAME! CALLER_ADDR:SKIP! Comments:INFO SPECIAL_ADDRESS_COMMENT:INFO? Grid:MAP Plat:MAP Block:INFO");
    
    
  }
  @Override
  public String getFilter() {
    return "cad.admin@mesaaz.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String extra = p.getLastOptional(": @");
      String apt = p.getLastOptional(',');
      super.parse(p.get(), data);
      
      if (apt.equals("INT")) {
        StringBuilder sb = new StringBuilder();
        for (String road : extra.split("/")) {
          road = road.trim();
          if (!data.strAddress.contains(road)) {
            if (sb.length() > 0) sb.append(" & ");
            sb.append(road);
          }
        }
        data.strCross = sb.toString();
      }
      
      else {
        data.strApt = apt;
        data.strPlace = extra;
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT PLACE X";
    }
  }

  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
}
