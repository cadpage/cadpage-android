package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class OKBryanCountyBParser extends DispatchB2Parser {

  public OKBryanCountyBParser() {
    super("0:",CITY_LIST, "BRYAN COUNTY", "OK");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getFilter() {
    return "lakewood1051@yahoo.com,15803801917@tmomail.net";
  }

  private static final CodeSet CALL_LIST = new CodeSet(
      "BRUSH FIRE",
      "DFD PAGER TEST SCHEDULE",
      "FIRE MISC. UNKNOWN TYPE",
      "FOUND PROPERTY",
      "MEDICAL CALL",
      "MVC - UNK INJ"
  );
  
  static final String[] CITY_LIST = new String[]{
    
      "BRYAN COUNTY",
      
      //Cities
      "DURANT",

      //Towns
      "ACHILLE",
      "ARMSTRONG",
      "BENNINGTON",
      "BOKCHITO",
      "CADDO",
      "CALERA",
      "COLBERT",
      "HENDRIX",
      "KEMP",
      "KENEFIC",
      "MEAD",
      "SILO",

      //Census-designated places
      "ALBANY",
      "BLUE",
      "CARTWRIGHT",

      //Unincorporated communities
      "ALLISON",
      "BANTY",
      "BROWN",
      "CADE",
      "COBB",
      "KIERSEY",
      "PLATTER",
      "ROMIA",
      "ROBERTA",
      "UTICA",
      "YARNABY",
      "YUBA"
  };

}
