package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;


/*
Wyoming County, NY
Contact: Kimo Brandon <brandokw@clarkson.edu>,5853565874@vtext.com
Sender: benningtonfd+bncCJaK9YeOBRDD1c7yBBoEC5LrgA@googleg
        benningtonfd+bncCJaK9YeOBRCi3LryBBoEcjen6A@googleg

 2314, STEDMAN RD;BENNINGTON TOWN (TINKHAM RD / GEISE RD)\n4105-Fire Alarm\nBE:2011:59\nThe document(s) accompanying t
 560, BURROUGH RD;BENNINGTON TOWN (GETMAN RD / FRIEDMAN RD)\n4001-Abdominal Pain\nBE:2011:57\nThe document(s) accompan
 ATTICA RODEO GROUNDS ;ATTICA VILLAGE ( 230 EXCHANGE ST)\n4109-Stand-by\nAT:2011:211
709, BURROUGH RD;BENNINGTON TOWN (FRIEDMAN RD / ROUTE 354)\n4026-Sick Person\nBE:2011:54
 1204, FRENCH RD;BENNINGTON TOWN (ROUTE 354 / HOOVER RD)\n4001-Abdominal Pain\nBE:2011:51
 2050, ROUTE 354 #PH;BENNINGTON TOWN (FRENCH RD / MAXON RD)\n4002-Allergies\nBE:2011:46
 1950, ROUTE 354 ;BENNINGTON TOWN (FRENCH RD / MAXON RD)\n6302-MVA/INJURY\nBE:2011:45
32,S PEARL ST #APT LOWER;ATTICA VILLAGE (MAIN ST / DEAD END)\n4010-Chest Pain\nAT:2011:174
 380, ROUTE 77 ;BENNINGTON TOWN (GENESEE CO LINE / CHURCH RD)\n4030-Traumatic Injury\nBE:2011:42
(!BE) BURROUGHS RD/ROUTE 20A\n4029-Traffic Accident\nHC:2011:17

*/


public class NYWyomingCountyParser extends FieldProgramParser {
    
    public NYWyomingCountyParser() {
      super("WYOMING COUNTY", "NY",
             "ADDR CALL SRCMAP!");
    }
    
    @Override
    public String getFilter() {
      return "benningtonfd";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    return parseFields(body.split("\n"), data);
	  }
	  
	  private static final Pattern X_PTN = Pattern.compile("\\((.*?)\\)$");
	  private class MyAddressField extends AddressField {
	    
	    @Override
	    public void parse(String field, Data data) {
	      Matcher match = X_PTN.matcher(field);
	      if (match.find()) {
	        data.strCross = match.group(1);
	        field = field.substring(0,match.start()).trim();
	      }
	      Parser p = new Parser(field);
	      String sCity = p.getLastOptional(";");
	      sCity = stripTrail(sCity, " TOWN");
	      sCity = stripTrail(sCity, " VILLAGE");
	      sCity = stripTrail(sCity, " CITY");
	      data.strCity = sCity;
	      data.strPhone = p.getLastOptional(" #PH");
	      data.strApt = p.getLastOptional(" #APT");
	      parseAddress(p.get().replaceAll(", ?", " "), data);
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "ADDR APT PHONE CITY X";
	    }
	    
	    private String stripTrail(String field, String term) {
	      if (field.endsWith(term)) field = field.substring(0, field.length()-term.length()).trim();
	      return field;
	    }
	  }

	  private static final Pattern SRC_MAP_PTN = Pattern.compile("([A-Z]{2}):(\\d{4}:\\d{1,4})");
	  private class SourceMapField extends Field {
	    
      @Override
      public void parse(String field, Data data) {
        Matcher match = SRC_MAP_PTN.matcher(field);
        if (!match.matches()) abort();
        data.strSource = match.group(1);
        data.strMap = match.group(2);
      }
      
      @Override
      public String getFieldNames() {
        return "SRC MAP";
      }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("ADDR")) return new MyAddressField();
      if (name.equals("SRCMAP")) return new SourceMapField();
      return super.getField(name);
    }
	  
	}
	