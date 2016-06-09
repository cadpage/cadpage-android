package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class OKBryanCountyBParser extends DispatchB2Parser {

  public OKBryanCountyBParser() {
    super("911-CENTER:",CITY_LIST, "HYDE COUNTY", "NC");
    setupCallList(CALL_LIST);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      
      "blank"
 
  );
  static final String[] CITY_LIST = new String[]{
      
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
