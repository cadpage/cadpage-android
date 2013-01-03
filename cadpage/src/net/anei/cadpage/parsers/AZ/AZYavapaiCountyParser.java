
package net.anei.cadpage.parsers.AZ;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Mesa, AZ (Maricopa County)
 */

public class AZYavapaiCountyParser extends FieldProgramParser {

  public AZYavapaiCountyParser() {
    super(CITY_CODES, "YAVAPAI COUNTY", "AZ",
           "CT:ADDR/SC! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "@sedonafire.org";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CTWD",  "COTTONWOOD"
  });
}
