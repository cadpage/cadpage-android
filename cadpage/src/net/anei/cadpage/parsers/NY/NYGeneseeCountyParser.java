package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Genesee County, NY
Contact: rtripp@2ki.net
Sender: 911center@co.genesee.ny.us

[Dispatch]  Acc PIAA ** 392.3 RT 90 E** , BATAVIA - ** ONE VEHICLE ROLLOVER ** LEWISTON RD, I 90 / KELSEY RD, I 90 ** 07/12/11 17:29 **
[Dispatch]  Alarm Fire ** ** 2614 W  MAIN STREET RD , BATAVIA - ** 2ND FLOOR SMOKE DETECRTOR KENNETH HERMAN RESIDENCE ** READ
[Dispatch]  Fire Auto ** 387.6 RT 90 W** , BATAVIA - ** POSS TRACTOR TRAILER FIRE - BOX TRAILER ** I 90, I-90 CONNECTOR / I 90,
[Dispatch]  Fire Nat Propane Gas ** ** 8470 VIOLET LN , BATAVIA - ** COMPL STRUCK GAS LINE OUT THE RESIDENCE 1/2" LINE  ** DANA
[Dispatch]  Acc PIAA ** ** 5402 ELLICOTT STREET RD , BETHANY - ** ONE VEHICLE ACCIDENT ** CLAPSADDLE RD / MAYNE RD ** 06/19/11 02:22 **
(Dispatch) Acc PIAA ** FRONTIER KITCHENS** 8392 LEWISTON RD , BATAVIA - ** TWO CAR MVA MINER INJ ** PARK RD / W MAIN STREET RD
(Dispatch) Alarm Fire ** COLLEGE VILLAGE** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - ** F 201- FIRE ALARM - ALARM HAS RESE
[Dispatch]  Acc PIAA ** Johnson Automotive** 3924 W  MAIN STREET RD , BATAVIA - ** 2 CAR MVA W INJ ** COUNTY BLDG / COLONIAL BL

*/


public class NYGeneseeCountyParser extends FieldProgramParser {
    
    public NYGeneseeCountyParser() {
      super("GENESEE COUNTY", "NY",
             "CALL PLACE? ADDR CITY? INFO! X");
    }
    
    @Override
    public String getFilter() {
      return "911center@co.genesee.ny.us";
    }

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) {
	    if (!subject.equals("Dispatch")) return false;
	    String flds[] = body.split("\\*\\*");
	    if (flds.length < 3) return false;
	    return parseFields(flds, data);
	  }
	  
	  private class MyAddressField extends AddressField {
	    
	    @Override
	    public boolean checkParse(String field, Data data) {
	      
	      // Remove trailing dash
	      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
	      
	      // If field contains comma, parse as address and city
	      int pt = field.indexOf(',');
	      if (pt >= 0) {
  	      parseAddress(field.substring(0,pt).trim(), data);
  	      data.strCity = field.substring(pt+1).trim();
  	      return true;
	      }
	      
	      // Otherwise, treat it as an address if it starts with a digit
	      // or is recognized as an address
	      if (field.length() < 1) return false;
	      if (Character.isDigit(field.charAt(0)) || checkAddress(field) > 0) {
	        parseAddress(field, data);
	        return true;
	      }
	      
	      // Otherwise, not a valid address field
	      return false;
	    }
	    
	    @Override
	    public void parse(String field, Data data) {
	      if (!checkParse(field, data)) abort();
	    }
	    
	    @Override
	    public String getFieldNames() {
	      return "ADDR CITY";
	    }
	  }
	  
	  private class MyCityField extends CityField {
	    
	    @Override
	    public boolean canFail() {
	      return true;
	    }
	    
	    @Override
	    public boolean checkParse(String field, Data data) {
	      
	      // If we got the city from the address field, we don't need this one
	      if (data.strCity.length() > 0) return false;
	      
	      // Strip off trailing dash
	      if (field.startsWith(",")) field = field.substring(1).trim();
        if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
        data.strCity = field;
        return true;
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("ADDR")) return new MyAddressField();
      if (name.equals("CITY")) return new MyCityField();
      return super.getField(name);
    }
	  
	}
	