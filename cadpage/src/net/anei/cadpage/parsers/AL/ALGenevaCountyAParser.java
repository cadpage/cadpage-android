
package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Baldwin County, AL
 */
public class ALGenevaCountyAParser extends DispatchOSSIParser {

  public ALGenevaCountyAParser() {
    super("GENEVA COUNTY", "AL",
          "CALL ADDR! X+? INFO+");
  }
    
  @Override
  public String getFilter() {
    return "CAD@smtp.gmail.com,34Central@smtp.gmail.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
