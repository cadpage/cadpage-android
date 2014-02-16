package net.anei.cadpage.parsers.NM;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NMChavesCountyParser extends DispatchOSSIParser {

  public NMChavesCountyParser() {
    super("CHAVES COUNTY", "NM",
        "FYI ADDR X/Z+? CALL! END");
  }

  @Override
  public String getFilter() {
    return "CAD@roswellpolice.com";
  }
}
