package net.anei.cadpage.parsers.AR;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;

/**
 *Bentonville, AR
 */
public class ARBentonvilleParser extends DispatchA9Parser {
  
  public ARBentonvilleParser() {
    super("BENTONVILLE", "AR");
  }
  
  @Override
  public String getFilter() {
    return "BentonvillePD@bentonville.arkansas.gov";
  }
}


