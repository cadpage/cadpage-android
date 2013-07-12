package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYNewYorkCityParser extends FieldProgramParser {
    
    public NYNewYorkCityParser() {
      super("NEW YORK CITY", "NY",
             "ADDR! Bet:X PLACE Apt:APT? PLACE Call_ID:ID!");
    }
    
    @Override
    public String getFilter() {
      return "callid@hatzalah.org";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    return parseFields(body.split(" - "), 3, data);
	  }
	}
	