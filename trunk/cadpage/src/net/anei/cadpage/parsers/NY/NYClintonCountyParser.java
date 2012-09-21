package net.anei.cadpage.parsers.NY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Clinton County, NY (Keeseville)
Contact: natebecca110611@gmail.com
Sender: 777-154,777-163

.... (Keeseville) Time: May 02, 2012 11:59:43\nAgencyName: Keeseville EMS\nAddress: 89 Second St, CHESTERFIELD (WASHINGTON ST/LUMBER ST)\nResp.Type: 001Ambulance\nPriority: Priority 1
.... (Keeseville) Time: May 01, 2012 19:26:16\nAgencyName: Keeseville EMS\nAddress: 164 HILL ST, AUSABLE (TAYLOR HILL RD, HALLOCK HILL RD/87)\nResp.Type: 001Ambulance\nPriority: Priority 1
.... (Keeseville) Time: April 30, 2012 18:54:04\nAgencyName: Keeseville EMS\nAddress: 73 Clinton St, KEESEVILLE VILLAGE (CHESTERFIELD) (DIVISION ST/CHURCH ST)\nResp.Type: 24B02-Unknown status/Other codes not applicable\nPriority:
.... (Keeseville) Time: April 30, 2012 17:49:11\nAgencyName: Keeseville\nAddress: 80 PLEASANT ST, KEESEVILLE VILLAGE (AUSABLE) (LIBERTY ST/MAIN ST)\nResp.Type: 003-Chimney Fire\nPriority: Priority 1

*/


public class NYClintonCountyParser extends FieldProgramParser {
  
    public NYClintonCountyParser() {
      super("CLINTON COUNTY", "NY",
             "Time:DATETIME! AgencyName:SRC! Address:ADDR! Resp.Type:CALL! Priority:PRI");
    }
    
    @Override
    public String getFilter() {
      return "777-";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    return parseFields(body.split("\n"), data);
	  }
	  
	  private static final DateFormat DATE_FMT = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
	  private class MyDateTimeField extends DateTimeField {
	    @Override
	    public void parse(String field, Data data) {
	      setDateTime(DATE_FMT, field, data);
	    }
	  }
	  
	  private class MyAddressField extends AddressField {
	    @Override
	    public void parse(String field, Data data) {
	      Parser p = new Parser(field);
	      parseAddress(p.get(','), data);
	      data.strCity = p.get('(');
	      data.strCross = p.get(')');
	      
	      field = p.get();
	      while (field.startsWith("(")) {
	        p = new Parser(field.substring(1));
	        data.strCross = p.get(')');
	        field = p.get();
	      }
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "ADDR APT CITY X";
	    }
	  }
	  
	  private class MyPriorityField extends PriorityField {
	    @Override
	    public void parse(String field, Data data) {
	      if (field.startsWith("Priority ")) field = field.substring(9).trim();
	      super.parse(field, data);
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("DATETIME")) return new MyDateTimeField();
      if (name.equals("ADDR")) return new MyAddressField();
      if (name.equals("PRI")) return new MyPriorityField();
      return super.getField(name);
    }
	}
	