package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Mongtomery County, NY
Contact: Paul Krug <paulkrug7@gmail.com>
Sender: paging@impact-sys.com

EMS - EMS CALL  5 CEMETERY V FONDA  05/06/2012 2155
EMS - EMS CALL  22 RAILROAD ST V FONDA  05/03/2012 1747
FIRE - SERVICE NBT BANK FONDA 34 W MAIN ST FONDA  04/30/2012 0650
EMS - EMS CALL CUMBERLAND FARMS 2 W MAIN ST FONDA  04/30/2012 0532
FIRE - STRUCTURE  56 E MAIN ST V FONDA  04/20/2012 0145
FIRE - CO CALL  21 BROADWAY V FONDA  04/18/2012 0817

*/


public class NYMontgomeryCountyBParser extends FieldProgramParser {
  
    public NYMontgomeryCountyBParser() {
      super(NYMontgomeryCountyParser.CITY_LIST, "MONTGOMERY COUNTY", "NY",
             "( ADDR/SCZ DATETIME/Z! END | CALL ADDR/S DATETIME! END )");
    }
    
    @Override
    public String getFilter() {
      return "paging@impact-sys.com";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    if (!parseFields(body.split("  "), data)) return false;
	    if (data.strCity.startsWith("V ")) data.strCity = data.strCity.substring(2).trim();
	    return true;
	  }
	  
	  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d/\\d{4}) (\\d{4})");
	  private class MyDateTimeField extends DateTimeField {
	    @Override
	    public void parse(String field, Data data) {
	      Matcher match = DATE_TIME_PTN.matcher(field);
	      if (!match.matches()) abort();
	      data.strDate = match.group(1);
	      String time = match.group(2);
	      data.strTime = time.substring(0,2) + ':' + time.substring(2,4);
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("DATETIME")) return new MyDateTimeField();
      return super.getField(name);
    }
	}
	