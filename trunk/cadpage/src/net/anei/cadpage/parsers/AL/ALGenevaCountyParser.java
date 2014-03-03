
package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Baldwin County, AL
 */
public class ALGenevaCountyParser extends DispatchOSSIParser {

  public ALGenevaCountyParser() {
    super("GENEVA COUNTY", "AL",
          "CALL ADDR! X+? INFO+");
  }
    
  @Override
  public String getFilter() {
    return "CAD@smtp.gmail.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
