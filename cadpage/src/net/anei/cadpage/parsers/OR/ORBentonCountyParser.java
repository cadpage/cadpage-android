package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ORBentonCountyParser extends FieldProgramParser {
  
  // List of streets that extend wholly or partly into a region that Google does
  // not recognize as part of Philomath
  private static final String[] NOT_IN_PHILOMATH = new String[]{
    "BANKS",
    "BREWSTER",
    "BEAVER CREEK",
    "BLUEROCK",
    "DECKER",
    "GRASS HEIGHTS",
    "LINVILLE",
    "MARYS PEAK",
    "NEUMAN",
    "PETERSON",
    "STARR CREEK"
  }; 
  
  public ORBentonCountyParser() {
    super("BENTON COUNTY", "OR",
          "INC:CALL! ADD:ADDR! APT:APT CITY:CITY! X:X MAP:MAP CFS:ID DIS:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "alerts@corvallis.ealertgov.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! subject.equals("Corvallis Alert")) return false;
    if (!parseFields(body.split("\n"), data)) return false;
    
    // Now for some special fixes to work around Dispatch map issues
    if (data.strCity.equals("PHILOMATH")) {
      data.strAddress = data.strAddress.replace("MELVILL CRESCENT AV","MELVILL CRESCENT");
      String tmp = data.strAddress.toUpperCase();
      for (String badRoad : NOT_IN_PHILOMATH) {
        if (tmp.contains(badRoad)) {
          data.strCity = "";
          break;
        }
      }
    }
    
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      parseAddress(p.get('['), data);
      data.strCity = p.get(']');
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
