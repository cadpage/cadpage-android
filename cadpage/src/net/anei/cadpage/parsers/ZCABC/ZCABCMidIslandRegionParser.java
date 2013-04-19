package net.anei.cadpage.parsers.ZCABC;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ZCABCMidIslandRegionParser extends FieldProgramParser {

  public ZCABCMidIslandRegionParser() {
    this("", "BC");
  }
  
  public ZCABCMidIslandRegionParser(String defCity, String defState) {
    super(defCity, defState, "CALL? ADDR/ZSC CITY DATETIME!");
  }
  
  @Override
  public String getFilter() {
    return "paging@ni911.ca";
  }
  
  @Override
  public String getLocName() {
    return "Mid-Island Region, BC";
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!subject.equals("Fire Dispatch")) return false;
    
    // Clean the body of any email text
    int newLine = body.indexOf('\n');
    if(newLine >= 0) {
      body = body.substring(0, newLine);
    }
    
    String[] fields = body.split(",");
    return parseFields(fields, data);
  }

  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      if(data.strCall.length() > 0) parseAddress(field, data);
      else super.parse(field, data);
    }
  }
  
  private class MyDateTimeField extends DateTimeField {
    
    @Override 
    public boolean checkParse(String field, Data data) {
      if(field.startsWith("BC")) {
        field = field.substring(2).trim();
        String[] dateTime = field.split(" ");
        
        // Check the first element to see if it is a date or a time
        if(dateTime[0].contains("/")) {
          data.strDate = dateTime[0];
        }
        else {
          data.strTime = dateTime[0];
        }
        
        // If we have two elements, the second is always time
        if(dateTime.length > 1) {
          data.strTime = dateTime[1];
        }
        
        return true;
      }
      else {
        return false;
      }
    }
    
    @Override
    public void parse(String field, Data data) {
      if(!checkParse(field, data)) super.abort();
    }
    
    @Override 
    public boolean canFail() {
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
}
