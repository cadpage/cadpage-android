package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchAegisParser;

/*
Ocean City, MD 
Contact: Flyin619...@gmail.com
Sender: msg@cfmsg.com

(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2500 Baltimore Ave - Crystal Beach Hotel - ADD:(s) (n)boardwalk OCMD - Cross STS:26th St & 25th St
(Chief ALT) [STA:700] - Nature:Vehicle Fire - ADD:8878 Stephen Decatur Hwy OCMD - Cross STS:Clark Rd & Landings Blvd
[Chief ALT]  [STA:700] - Nature:Mutual Aid Fire - ADD:1 W Indian St OCMD - Cross STS:Bay St & E Indian St
(Chief ALT) [700 Service] - Nature:Public Service - ADD:24 White Crane Dr OCMD - Cross STS:Misty Shore Dr & Mystic Harbour Blvd
(Chief ALT) [700 Auto] - Nature:Auto Alarm - ADD:4 Hidden Cove Way OCMD - Cross STS:Fountain Dr W & Sunset Island Dr
[Chief ALT]  [STA:700] - Nature:Gas Leak - LOC:Coins - ADD:2820 Philadelphia Ave OCMD - Cross STS:29th St & 28th St
[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:Sakura Japanese Steak House - ADD:12741 Ocean Gtwy OCMD - Cross STS:Golf Course Rd & Keyser Point Rd
(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:1208 Baltimore Ave - Beach Break - ADD:(s) (n)boardwalk OCMD - Cross STS:Woods Ln & 12th St
(Chief ALT) [STA:700] - Nature:Building Fire - LOC:408 Baltimore Ave - Tidelands Caribbean Annex Bldg - ADD:(s) (n)boardwalk OCMD - Cross STS:5th St & 4th St
(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2700 Baltimore Ave - Dunes Motel - ADD:(s) (n)boardwalk OCMD - Cross STS:28th St & 27th St
[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:1701 Atlantic Ave - Holiday Inn Hotel & Suites - ADD:(s) (n)boardwalk OCMD - Cross STS:18th St & 17th St

*/

public class MDOceanCityParser extends DispatchAegisParser {

  private String address1 = null;
  private String address2 = null;
  private int addrStat1 = -1;
  private int addrStat2 = -1;
  
  @Override
  public String getFilter() {
    return "msg@cfmsg.com";
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
