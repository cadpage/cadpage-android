package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.dispatch.DispatchA49Parser;

/*
Lafayette Parish, LA
*/

public class LALivingstonParishParser extends DispatchA49Parser {
  
  public LALivingstonParishParser() {
    super("LIVIN PARISH","LA");
  }

  @Override
  public String getFilter() {
    return "cadalert@lafayettela.gov,alerts@carencrofd.org";
  }
 
}
