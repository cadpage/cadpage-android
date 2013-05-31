package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYGeneseeCountyParser extends FieldProgramParser {
  
  public NYGeneseeCountyParser() {
    super(CITY_LIST, "GENESEE COUNTY", "NY",
           "Unit:UNIT? Status:CALL! PLACE? ADDR CITY? INFO! X DATETIME ID");
  }
  
  @Override
  public String getFilter() {
    return "911center@co.genesee.ny.us,777,888";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      
      if (body.startsWith("GENESEE COUNTY DISPATCH ")) {
        body = body.substring(24).trim();
        break;
      }
      
      if (subject.equals("Dispatch")) break;
        
      return false;
    } while (false);
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    String saveBody = body;
    
    if (body.startsWith("Unit:")) {
      body = body.replace(" Status:", "**Status:");
    } else if(!body.startsWith("Status:")) {
      body = "Status: " + body;
    }
    
    String flds[] = body.split("\\*\\*");
    return parseFields(flds, 3, data) ||
            data.parseGeneralAlert(this, saveBody);
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Dispatched ")) field = field.substring(11).trim();
      if (field.endsWith("*")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // remove leading asterisk
      if (field.startsWith("*")) field = field.substring(1).trim();
      
      // If field contains comma, parse as address and cross / city
      String sApt = "";
      int pt = field.indexOf(',');
      if (pt >= 0) {
	      String sAddr = field.substring(0,pt).trim();
	      String sCity = field.substring(pt+1).trim();
	      int pt2 = sCity.lastIndexOf('-');
	      if (pt2 >= 0) {
	        sApt = sCity.substring(pt2+1).trim();
	        if (sApt.startsWith("APT ")) sApt = sApt.substring(4);
	        sCity = sCity.substring(0,pt2).trim();
	      }
	      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_ONLY_CITY | FLAG_ANCHOR_END, sCity, data);
        parseAddress(sAddr, data);
        data.strApt = append(data.strApt, "-", sApt);
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
      return "ADDR CITY APT";
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
      if (! field.startsWith(",")) return false;
      if (! field.endsWith("-")) return false;
      data.strCity = field.substring(1, field.length()-1).trim();
      return true;
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALABAMA",
    "ALEXANDER",
    "ATTICA",
    "BATAVIA",
    "BERGEN",
    "BERGEN",
    "BETHANY",
    "BYRON",
    "CORFU",
    "DARIEN",
    "ELBA",
    "LE ROY",
    "OAKFIELD",
    "PAVILION",
    "PEMBROKE",
    "STAFFORD",

    // Erie County
    "ALDEN",
    "AKRON",
    
    // Wyoming County
    "ATTICA",
    "BENNINGTON",
    
    // Erie County,
    "CLARENCE",
    "NEWSTEAD"
  };
}
