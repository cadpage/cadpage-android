package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Ontario County, NY
Contact: ozzy8585@frontiernet.net
Sender: E911page@co.ontario.ny.us

AUTO ALRM\n18:23\n5658 EAST LAKE RD\nSUNNY HOLLOW - WILLOW BEACH\nF14\nLOCUS RES - GENERAL FIRE ALARM - ATT REP\nF111890007
CRASH UNK\n14:32\nCOUNTY ROAD 37 - ROUTE 20A\nASHLEY RD - ROUTE 20A\nE14\nMERCEDES IN THE DITCH ALSO ANOTHER CAR INVOLVED - FEMALE WAS GETTING OUT OF THE MERCE
CRASH-PI\n13:56\nBIG TREE RD - BARNARD RD\nBARNARD RD - COUNTY LINE\nE14\nMOTORCYCLE CRASH - 1 INJURED\nE111910021
WIRES DOWN\n15:16\nCOUNTY ROAD 37 - RASPBERRY HILL\nRASPBERRY HILL - HOWCROFT RD\nF14\nWIRE DOWN ABOUT 200 METERS SOUTH OF RASPBERRY HILL ROAD ON CR 37 CAUSING
CO DET.\n08:20\n4910 COUNTY ROAD 36\nMASTIN DR - SANDY BOTTOM RD\nF14\nWOKE UP TO CO DETECTOR GOING OFF, NO ILLNESS, WILL WAIT OUTSIDE\nF111960002

Contact: Chris Burt <cvfd022@hotmail.com>
CO DET.\n15:39\nLAKE BREEZE HOME, 3101 STATE RT 21\nSTATE RT 5 - COUNTY ROAD 32\nF04\nCO DETECTOR IN BASEMENT IS GOING OFF - NO ILLNESS\nF120210009

*/


public class NYOntarioCountyParser extends FieldProgramParser {
  
    public NYOntarioCountyParser() {
      super("ONTARIO COUNTY", "NY",
             "CALL TIME ADDR X UNIT! INFO ID");
    }
    
    @Override
    public String getFilter() {
      return "E911page@co.ontario.ny.us";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    return parseFields(body.split("\n"), data);
	  }
	  
	  private class TimeField extends SkipField {
	    public TimeField() {
	      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
	    }
	  }
	  
	  private class MyAddressField extends AddressField {
	    @Override
	    public void parse(String field, Data data) {
	      int pt = field.indexOf(',');
	      if (pt >= 0) {
	        data.strPlace = field.substring(0,pt).trim();
	        field = field.substring(pt+1).trim();
	      }
	      super.parse(field.replace(" - ", " & "), data);
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "PLACE " + super.getFieldNames();
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("TIME")) return new TimeField();
      if (name.equals("ADDR")) return new MyAddressField();
      return super.getField(name);
    }
	  
	}
	