package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Sullivan County, NY
 */
public class NYSullivanCountyParser extends FieldProgramParser {
  
    public NYSullivanCountyParser() {
      super("SULLIVAN COUNTY", "NY",
             "SKIP Type:CALL! Loc:ADDR! X:X V:CITY CN:NAME");
    }
    
    @Override
    public String getFilter() {
      return "911@co.sullivan.ny.us";
    }

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) {
	    
	    if (!subject.equalsIgnoreCase("911 Page")) return false;
	    return super.parseMsg(body, data);
	  }
	  
	  class MyCityField extends CityField {
	    
	    @Override
	    public void parse(String fld, Data data) {
	      if (fld.startsWith("V/")) fld = fld.substring(2).trim();
	      super.parse(fld, data);
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("CITY")) return new MyCityField();
      return super.getField(name);
    }
	  
	}
	