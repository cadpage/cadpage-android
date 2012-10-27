package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Ontario County, NY
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
	  
	  private class MyCrossField extends CrossField {
	    @Override
	    public void parse(String field, Data data) {
	      field = field.replaceAll(" - ", " & ");
	      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
	      super.parse(field, data);
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("TIME")) return new TimeField();
      if (name.equals("ADDR")) return new MyAddressField();
      if (name.equals("X")) return new MyCrossField();
      return super.getField(name);
    }
    
    @Override
    public String adjustMapAddress(String addr) {
      addr = RT_5_25_PTN.matcher(addr).replaceAll("5");
      addr = RT_5_21_PTN.matcher(addr).replaceAll("$1");
      return addr;
    }
	  private static final Pattern RT_5_25_PTN = Pattern.compile("\\b5 (?:AND|&) 20\\b");
	  private static final Pattern RT_5_21_PTN = Pattern.compile("(?:RT |ROUTE |\\b)(?:5|20)(?: *& *)((?:RT|ROUTE) *21)\\b");
	}
	