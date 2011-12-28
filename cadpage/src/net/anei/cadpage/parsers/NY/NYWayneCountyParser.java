package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Wayne County, NY (Newark)
Marbletown Fire and Newark Ambulance
Contact: Brandon <frenchie31692@yahoo.com>
Sender: newarkamb@fdcms.info

Subject:Dispatch\nDispatch ** 05:32 ** FALLS ** 1542 STEBBINS RD ** HERMAN, ELAINE ** STUART AVE * TELLIER RD ** 315-331-6505 ** \n
Subject:Dispatch\nDispatch ** 23:01 ** MEDICAL ALARM ACTIVATION ** 790 E MAPLE AVE ** ADT ** DRUMLIN CT * CUYLER ST ** 877-238-7730 ** \n
Subject:Dispatch\nDispatch ** 21:01 ** BREATHING PROBLEMS ** 5400 ROUTE 31 ** HALL, JANET ** WHITBECK RD * W UNION ST ** 315-359-3978 ** \n
Subject:Dispatch\nDispatch ** 20:11 ** HOUSE FIRE ** 106 HILL ST ** VZW CALL ** LYONS ST * STANSELL ST ** 315-690-9286 ** \n
Subject:Dispatch\nDispatch ** 10:49 ** ABDOMINAL PAIN / PROBLEMS ** 101 COBBLESTONE TER ** FINGER LAKES DD ** VIENNA ST * VIENNA ST ** 315-
Subject:Dispatch\nDispatch ** 18:28 ** TRANSPORT-MEDICAL ** 1200 DRIVING PARK AVE ** NEWARK WAYNE CO ** SUNSET DR * FREY ST ** 332-2494 **
Subject:Dispatch\nDispatch ** 22:04 ** BARN/GARAGE FIRE ** 735 BOHNER ** - ** ONTARIO COUNTY **  ** 

*/

public class NYWayneCountyParser extends FieldProgramParser {
    
    public NYWayneCountyParser() {
      super("WAYNE COUNTY", "NY",
             "DISPATCH TIME CALL ADDR! NAME X PHONE");
    }
    
    @Override
    public String getFilter() {
      return "newarkamb@fdcms.info";
    }

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) {
	    if (!subject.equals("Dispatch")) return false;
	    body = body + " ";
	    return parseFields(body.split(" \\*\\* "), data);
	  }

	  // Name field ignores standalone dashes
	  private class MyNameField extends NameField {
      @Override
      public void parse(String field, Data data) {
        if (field.equals("-")) return;
        super.parse(field, data);
      }
	  }
	  
	  // Cross street field might have neighboring county
	  private class MyCrossField extends CrossField {
	    @Override
	    public void parse(String field, Data data) {
	      if (field.toUpperCase().endsWith(" COUNTY")) {
	        data.strCity = field;
	      }  else {
	        super.parse(field, data);
	      }
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "X CITY";
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
      if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
      if (name.equals("NAME")) return new MyNameField();
      if (name.equals("X")) return new MyCrossField();
      return super.getField(name);
    }
	  
	}
	