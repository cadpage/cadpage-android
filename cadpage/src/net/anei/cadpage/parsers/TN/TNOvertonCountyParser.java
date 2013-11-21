package net.anei.cadpage.parsers.TN;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;

/**
 * Overton, TN
 */
public class TNOvertonCountyParser extends DispatchB3Parser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d+:911@OPECD.COM:");

  public TNOvertonCountyParser() {
    super(MARKER, CITY_CODES, "OVERTON COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "911@OPECD.COM";
  }
  
 
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{

    // Cities and Towns
      
      "LIVINGSTON",
   
    // Unincorporated communities
      "ALLONS ",
      "ALLRED ",
      "ALPINE ",
      "CRAWFORD ",
      "HILHAM ",
      "MINERAL SPRINGS",
      "MONROE ",
      "RICKMAN "
      
  });
}
