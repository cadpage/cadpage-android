package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYWayneCountyParser extends FieldProgramParser {
    
    public NYWayneCountyParser() {
      super("WAYNE COUNTY", "NY",
             "DISPATCH TIME CALL ADDR! PLACENAME? X APT? PHONE");
    }
    
    @Override
    public String getFilter() {
      return "newarkamb@fdcms.info,williamsonfireco@fdcms.info";
    }

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) {
	    body = body + " ";
	    return parseFields(body.split(" \\*\\* "), data);
	  }

	  // Name field ignores standalone dashes
	  private class MyPlaceNameField extends PlaceNameField {
      @Override
      public void parse(String field, Data data) {
        if (field.equals("-")) return;
        super.parse(field, data);
      }
	  }
	  
	  // Cross street field might have neighboring county
	  private class MyCrossField extends CrossField {
	    @Override
	    public boolean canFail() {
	      return true;
	    }
	    
	    @Override
	    public boolean checkParse(String field, Data data) {
	      if (field.toUpperCase().endsWith(" COUNTY")) {
	        data.strCity = field;
	      } else if (field.contains(" * ")) {
          field  = field.replace('*', '&');
          super.parse(field, data);
	      } else return false;
	      return true;
	    }
	    
	    @Override
	    public void parse(String field, Data data) {
	      if (field.toUpperCase().endsWith(" COUNTY")) {
	        data.strCity = field;
	      }  else {
	        field  = field.replace('*', '&');
	        super.parse(field, data);
	      }
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "X CITY";
	    }
	  }
	  
	  private class MyAptField extends AptField {
	    @Override
	    public boolean canFail() {
	      return true;
	    }
	    
	    @Override
	    public boolean checkParse(String field, Data data) {
	      if (!field.startsWith("-Apt:"))  return false;
	      super.parse(field.substring(5).trim(), data);
	      return true;
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
      if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
      if (name.equals("PLACENAME")) return new MyPlaceNameField();
      if (name.equals("X")) return new MyCrossField();
      if (name.equals("APT")) return new MyAptField();
      return super.getField(name);
    }
	  
	}
	