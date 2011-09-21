package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Douglas County, CO
Contact: K Allen <allenkody@gmail.com>
Sender: @notifyatonce.net

(Dispatch) Call: F MED ASSIST Location: 6287 OLD DIVIDE TRL / Map: AD35C Units: MED181 E184 XXX184  HOSPITALITY PL / GREEN CT Common Name: Time: 08/25/.
(Dispatch) Call: F MED ASSIST Location: 11710 PONDEROSA LN / Map: AF40D Units: E184 MED181 XXX184  PONDEROSA RD / ELKHORN DR Common Name: Time: 08/25/1
(Dispatch) Call: F GAS LP OUTSIDE Location: DEERFIELD RD / S  WHITE TAIL DR I Map: AI38D Units: E181 XXX181  Common Name: Time: 08/25/11 20:07 Narrativ
(Dispatch) Call: F MED ASSIST Location: 2535 BURNT OAK DR / Map: AG37A Units: E181 MED181 XXX181  BURNING TREE TRL / DEAD END Common Name: Time: 08/25/

Elbert County (dispatched through Douglas County)
Contact: Ian McQueen <imcqueen@gmail.com>
Sender: dcso@douglas.co.us
(Dispatch) Call: F MED ASSIST Location: S PINE ST / SPRUCE ST Map: AJ44 Units: MED271 E273 XXX271  Common Name: Time: 09/20/11 17:13 Narrative:  PER LE 473 PINE

 */


public class CODouglasCountyParser extends FieldProgramParser {

  public CODouglasCountyParser() {
    this("DOUGLAS COUNTY", "CO");
  }
  
  protected CODouglasCountyParser(String defCity, String defState) {
    super(defCity, defState,
           "Call:CALL! Location:ADDR! Map:MAP Units:UNIT! Common_Name:NAME Time:SKIP");
  }
  
  public String getFilter() {
    return "@notifyall.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatch")) return false;
    return super.parseMsg(body, data);
  }
  
  // Address field should strip  trailing slash characters
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  // Unit field also contains cross field
  private class MyUnitField extends UnitField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get("  "), data);
      data.strCross = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT X";
    }
  }
  
  @Override
  public Field getField(String  name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
}
