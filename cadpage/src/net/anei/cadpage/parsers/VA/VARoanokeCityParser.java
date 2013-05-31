package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Roanoke City, VA
 */
public class VARoanokeCityParser extends FieldProgramParser {
  
  private static final Pattern MASTER = Pattern.compile("([A-Za-z0-9 ]+) at (.*)");
  
  public VARoanokeCityParser() {
    super("ROANOKE CITY", "VA",
           "ADDR! CMT:INFO! Original_Location:PLACE");
  }
  
  @Override
  public String getFilter() {
    return "e911@roanokeva.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (match.matches()) {
      data.strCall = match.group(1).trim();
      String sAddr = match.group(2).replace("APT ", " APT").trim();
      parseAddress(sAddr, data);
      if (checkAddress(data.strAddress, 2) > 0) return true;
      data.initialize(this);
    }
    
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strCall = convertCodes(field.substring(0,pt), CALL_CODES);
      super.parse(field.substring(pt+1).trim(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL " + super.getFieldNames();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "F-ALARM",  "FIRE ALARM",
      "FIRE",     "STRUCTURE FIRE",
      "GSWI",     "GUN SHOT WOUND",
      "ROBI",     "ROBBERY IN PROGRESS",
      "PURSI",    "PURSUIT"
  });
}
