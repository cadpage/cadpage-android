package net.anei.cadpage.parsers.DE;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchAegisParser;

/*
Kent County, DE (Variant B)
Contact: jeffrey morris <bowers4015@gmail.com>
Contact: Adam Warner <awarner7777@gmail.com>
Sender: msg@cfmsg.com
System: Aegis CAD

(Chief ALT) [40 EMS] - 26A10 - Sick Person - Unwell/Ill -- 2536 Skeeter Neck Rd, Frederica -- Xst's: Bowers Beach Rd / E Front St -- Caller: High Vue Logging Inc
(Chief ALT) [KCPS] - [911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.
(Chief ALT) [40 EMS] - 23C1V - Overdose/Poisoning -- 181 Holly Dr, Frederica -- High Point Mhp -- Xst's: Garden Pl / Maple Dr -- Caller: Marrillo Paul
(Chief ALT) [55 EMS 1] - 2D2 - Allergic Reaction -- 149 Juanita Dr, Magnolia -- London Village -- Xst's: Jeffrey Dr / Millchop Ln -- Caller: Price Laura
(Chief ALT) [40 EMS] - 29B4 - MVC Unknown -- Mulberrie Point Rd, Frederica
(Chief ALT) [40 EMS] - 10D2 - Chest Pains -- 196 N  Bayshore Dr, Frederica -- Bowers Beach -- Xst's: N Flack Ave / Main St -- Caller: Margaret
(Chief ALT) [40 EMS] - 26C2 - Sick Person -- 201 Hubbard Ave, Frederica -- Bowers Beach -- Xst's: Dead End / Canal St -- Caller: Ingle Heather
(Chief ALT) [40 EMS] - 10C4 - Chest Pains -- 302 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Second St, Sycamore Dr / Lorna Ln -- Caller: Thom Ronald
(Chief ALT) [40 EMS] - 6C1 - Breathing Problems -- 294 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Kiwi Ct / Kylie Ln -- Caller: Hurd Shirley
(Chief ALT) [40 Fire] - 17A2 - Falls - Non-Recent -- 254 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Tyson Ln / Ibis Ct -- Caller: Spink Kimberley
(Chief ALT) [40 Fire] - Outside Fire-Unknown 2124 BOWERS BEACH RD, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd

 */
public class DEKentCountyBParser extends DispatchAegisParser {
  
  public DEKentCountyBParser() {
    super("KENT COUNTY", "DE",
           "CODE? CALL+? ADDR! PLACE Xst's:X Caller:NAME");
  }
  
  // Code field must match code pattern
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(Pattern.compile("\\d{1,2}[A-Z]\\d{1,2}"));
    }
  }
  
  // Call field concatenates with dashes
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  // Address field must have comma delimited city name
  private class MyAddressField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      if (pt < 0) return false;
      data.strCity = field.substring(pt+1).trim();
      field = field.substring(0,pt).trim();
      
      if (data.strCall.length() == 0) {
        parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, field, data);
      } else {
        super.parse(field, data);
      }
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
