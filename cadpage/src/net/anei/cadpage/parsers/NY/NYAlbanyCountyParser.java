package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Albany County, NY (Colonie)
Contact: Mike Sipperly <msipperly@gmail.com>
Sender: CAD@colonie.org
System: Hi-Tech

FIRE ALARM E405,E406,RS2,E412\n54 SUNSET BL\n HIGGINS ROBERT\nMap COL VILL 12:00:30
STRUCTURE FIRE E412,E410,RS3,E454,CVFT,TK9\n45 RAILROAD AV(FULLER)\n CNY STORM ALLSTARS\nMap FULLER 08:48:16
FIRE ALARM E412,E410,RS3,E405,TK9\n1417 CENTRAL AV\nCOLONIE CENTER\nMap FULLER 08:11:21
FIRE ALARM E437,E438,TK7,E405,RS10\n392 NEW KARNER RD\nDUNKIN DONUTS\nMap MIDWAY 14:16:56
FIRE ALARM E412,E410,RS3,E405,TK9\n1417 CENTRAL AV\nCOLONIE CENTER\nMap FULLER 08:11:21
MEDICAL CALL A622,E405\n10 STELLA TR\nMap COL VILL 20:55:06
CO ALARM W/ILLNESS E405,E406,E412,FP71\n28 HIALEAH DR\nMILLER GREGORY\nMap COL VILL 07:23:37
CO ALARM W/O ILLNESS E405,E406,FP71\n22 LOIS CT\nMap COL VILL 09:22:59
STRUCTURE FIRE - POSSIBLE E437,E438,TK7,RS7,E405\n6 GLENMORE DR\nMap MIDWAY 14:45:27
BFIRE ALARM E412,E410,TK3,RS3,E405\n1425 CENTRAL AV\nSEARS\nMap FULLER 11:57:21
MEDICAL CALL A621,CR16,E406\n1 ELM CT\nMap COL VILL 16:25:57

*/


public class NYAlbanyCountyParser extends FieldProgramParser {
  
    public NYAlbanyCountyParser() {
      super("ALBANY COUNTY", "NY",
             "CALLUNIT! ADDR! PLACE? MAP!");
    }
    
    @Override
    public String getFilter() {
      return "CAD@colonie.org";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    return parseFields(body.split("\n"), data);
	  }
	  
	  private class MyCallUnitField extends Field {
	    @Override
	    public void parse(String field, Data data) {
	      int pt = field.lastIndexOf(' ');
	      if (pt < 0) abort();
	      data.strCall = field.substring(0,pt).trim();
	      data.strUnit = field.substring(pt+1).trim();
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "CALL UNIT";
	    }
	  }
	  
	  private class MyAddressField extends AddressField {
	    @Override
	    public void parse(String field, Data data) {
	      int pt = field.indexOf('(');
	      if (pt >= 0) field = field.substring(0,pt).trim();
	      super.parse(field, data);
	    }
	  }
	  
	  private static final Pattern MAP_PTN = 
	    Pattern.compile("Map ([A-Z ]+) (\\d\\d:\\d\\d:\\d\\d)");
	  private class MyMapField extends MapField {
	    
	    @Override
	    public boolean canFail() {
	      return true;
	    }
	    
	    @Override
	    public boolean checkParse(String field, Data data) {
        Matcher match = MAP_PTN.matcher(field);
        if (!match.matches()) return false;
        data.strMap = match.group(1).trim();
        data.strTime = match.group(2);
        return true;
	    }
	    
	    @Override
	    public void parse(String field, Data data) {
	      if (!checkParse(field, data)) abort();
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "MAP TIME";
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("CALLUNIT")) return new MyCallUnitField();
      if (name.equals("ADDR")) return new MyAddressField();
      if (name.equals("MAP")) return new MyMapField();
      return super.getField(name);
    }
	  
	}
	