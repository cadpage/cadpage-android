package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchAegisParser;



public class MDOceanCityParser extends DispatchAegisParser {

  private String address1 = null;
  private String address2 = null;
  private int addrStat1 = -1;
  private int addrStat2 = -1;
  
  @Override
  public String getFilter() {
    return "msg@cfmsg.com,alert@cfmsg.com";
  }
  
  public MDOceanCityParser() {
    super("OCEAN CITY", "MD",
           "Nature:CALL! LOC:ADDR PLACE ADD:ADDR Cross_STS:X");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {

    address1 = null;
    address2 = null;
    addrStat1 = -1;
    addrStat2 = -1;
    
    // The OCMD city codes just confused things, better to get rid of them
    body = body.replaceAll(" OCMD ", " ");
    if (! super.parseMsg(subject, body, data)) return false;
    
    // Pick the best address as the address
    // If no place name was found, use the second best address
    if (address1 == null) return false;
    parseAddress(address1, data);
    if (data.strPlace.length() == 0 && address2 != null) data.strPlace = address2;
    return true;
  }
  
  // This text format has two address fields, and the real address might
  // be in either one.
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      int status = checkAddress(field);
      if (address1 == null || status > addrStat1) {
        address2 = address1;
        addrStat2 = addrStat1;
        address1 = field;
        addrStat1 = status;
      } else if (address2 == null || status > addrStat2) {
        address2 = field;
        addrStat2 = status;
      }
    }

    @Override
    public String getFieldNames() {
      return "ADDR PLACE X CITY";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
