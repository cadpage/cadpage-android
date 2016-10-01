package net.anei.cadpage.parsers.WV;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

/**
 * Hardy County, WV (B) 
 */
public class WVGrantCountyParser extends DispatchA48Parser {
  
  public WVGrantCountyParser() {
    super(CITY_LIST, "GRANT COUNTY", "WV", FieldType.NONE);
    setupCallList(CALL_CODE);
  }
  
  @Override
  public String getFilter() {
    return "CAD@hardynet.com";
  }
  
  private static final CodeSet CALL_CODE = new CodeSet(

      
  );
  
  private static final String[] CITY_LIST = new String[]{

      //CITY

          "PETERSBURG",

      //TOWN

          "BAYARD",

      //UNINCORPORATED COMMUNITIES

          "ARTHUR",
          "BISMARCK",
          "CABINS",
          "DOBBIN",
          "DORCAS",
          "FAIRFAX",
          "FORMAN",
          "GORMANIA",
          "GREENLAND",
          "HENRY",
          "HOPEVILLE",
          "LAHMANSVILLE",
          "MAYSVILLE",
          "MEDLEY",
          "MOUNT STORM",
          "OLD ARTHUR",
          "SCHERR",
          "WILLIAMSPORT",
          "WILSONIA"

  };
}
