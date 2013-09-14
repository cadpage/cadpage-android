package net.anei.cadpage.parsers.IN;


import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Starke County, IN
 */
public class INStarkeCountyParser extends DispatchA29Parser {
  
  public INStarkeCountyParser() {
    super("STARKE COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@co.starke.in.us,messaging@iamresponding.com";
  }
}
