package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.FieldProgramParser.AddressField;
import net.anei.cadpage.parsers.FieldProgramParser.Field;
import net.anei.cadpage.parsers.SmartAddressParser.Result;
import net.anei.cadpage.parsers.SmartAddressParser.StartType;
import net.anei.cadpage.parsers.SmsMsgParser.Parser;


//
//Ocean City, MD  (Not using county dispatch :( )
//Contact: Flyin619...@gmail.com
//Sender: msg@cfmsg.com
//(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2500 Baltimore Ave - Crystal Beach Hotel - ADD:(s) (n)boardwalk OCMD - Cross STS:26th St & 25th St
//(Chief ALT) [STA:700] - Nature:Vehicle Fire - ADD:8878 Stephen Decatur Hwy OCMD - Cross STS:Clark Rd & Landings Blvd
//[Chief ALT]  [STA:700] - Nature:Mutual Aid Fire - ADD:1 W Indian St OCMD - Cross STS:Bay St & E Indian St
//(Chief ALT) [700 Service] - Nature:Public Service - ADD:24 White Crane Dr OCMD - Cross STS:Misty Shore Dr & Mystic Harbour Blvd
//(Chief ALT) [700 Auto] - Nature:Auto Alarm - ADD:4 Hidden Cove Way OCMD - Cross STS:Fountain Dr W & Sunset Island Dr
//[Chief ALT]  [STA:700] - Nature:Gas Leak - LOC:Coins - ADD:2820 Philadelphia Ave OCMD - Cross STS:29th St & 28th St
//[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:Sakura Japanese Steak House - ADD:12741 Ocean Gtwy OCMD - Cross STS:Golf Course Rd & Keyser Point Rd
//(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:1208 Baltimore Ave - Beach Break - ADD:(s) (n)boardwalk OCMD - Cross STS:Woods Ln & 12th St
//(Chief ALT) [STA:700] - Nature:Building Fire - LOC:408 Baltimore Ave - Tidelands Caribbean Annex Bldg - ADD:(s) (n)boardwalk OCMD - Cross STS:5th St & 4th St
//(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2700 Baltimore Ave - Dunes Motel - ADD:(s) (n)boardwalk OCMD - Cross STS:28th St & 27th St
//[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:1701 Atlantic Ave - Holiday Inn Hotel & Suites - ADD:(s) (n)boardwalk OCMD - Cross STS:18th St & 17th St
//

public class MDOceanCityParser extends FieldProgramParser {
  
  @Override
  public String getFilter() {
    return "msg@cfmsg.com";
  }
  
  public MDOceanCityParser() {
    super("OCEAN CITY", "MD",
           "Nature:CALL LOC:ADDR! Time:SKIP Units:UNIT Common_Name:NAME Info:INFO");
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      parseAddress(StartType.START_ADDR, field, data);
      Parser p = new Parser(getLeft());
      data.strPlace = p.getOptional(',');
      field = p.get();
      Result res = parseAddress(StartType.START_ADDR, field);
      res.getCrossData(data);
      data.strCity = res.getLeft();
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
}
