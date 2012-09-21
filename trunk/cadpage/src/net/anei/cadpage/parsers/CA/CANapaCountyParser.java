package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Napa County, CA
Contact: Joe Russo <bumbero19@gmail.com>
Sender: Lnucad@fire.ca.gov

(CAD Page) PA, OTHER; 413 BURGUNDY S ,CALISTOGA_CITY ; Inc# 000483; 70YOM GL FALL NON INJ; RA: CAL; X: -122 34.2255  Y: 38 34.7732; E19 AMR19; Cmd: NAPA CO FIRE; CB#: 7073226460
(CAD Page) FIRE, COMMERCIAL ALARM; CALISTOGA GARDEN @ 1715 WASHINGTON ST ,CALISTOGA_CITY ; Inc# 000412; GENERAL FIRE ALARM; RA: CAL; X: -122 35.0390  Y: 38 34.86 CB#: 7073226460
(CAD Page) MEDICAL; DUFFY'S @ 3076 MYRTLEDALE RD ,CALISTOGA ; Inc# 000459; CHEST PAIN; RA: L55; X: -122 35.9647  Y: 38 35.7255; E26 E19; Cmd: NAPA CO FIRE; Tac: CB#: 7073226460
(CAD Page) FIRE, RESIDENTIAL ALARM; 1670 DIAMOND MOUNTAIN RD ,CALISTOGA ; Inc# 000277; LOWER LEVEL SMOKE DETECTOR; RA: S33; X: -122 34.7655  Y: 38 33.7344; B1412 CB#: 7073226460
(CAD Page) FIRE, SMOKE CHECK; 4300 HWY 29 / 3898 OLD LAWLEY TOLL RD ,CALISTOGA ; Inc# 000406; POSS CTRL - WHITE; RA: S37; X: -122 35.7937  Y: 38 38.4289; E26 E19 CB#: 7073226460
(CAD Page) FIRE, DEBRIS; 4750 SILVERADO TRL ,CALISTOGA ; Inc# 000185; COMPOST FIRE; RA: L54; X: -122 33.324  Y: 38 34.7315; E26 E19 B1414; Cmd: NAPA CO FIRE; Tac CB#: 7073226460
(CAD Page) FIRE, VEH PASSENGER; RLS @ =L(38.654873,-122.596711) ,MIDDLETOWN ; Inc# 000149; NEAR RLS. 60 PICK FLAMES SEEN FROM ENGINE COMPARTMENT; RA: M5; X: -122 CB#: 7073226460

 */


public class CANapaCountyParser extends FieldProgramParser {
  
  public CANapaCountyParser() {
    super("NAPA COUNTY", "CA",
          "CALL ADDR ID INFO! RA:UNIT! GPS UNIT Cmd:SRC Tac:CH");
  }
  
  @Override
  public String getFilter() {
    return "Lnucad@fire.ca.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    
    // Don't know what this is, but it gets in the way
    int pt = body.lastIndexOf(" CB#:");
    if (pt < 0) return false;
    body = body.substring(0,pt).trim();
    return parseFields(body.split(";"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getOptional('@');
      String city = p.getLastOptional(',');
      if (city.endsWith("_CITY")) city = city.substring(0,city.length()-5);
      data.strCity = city.replace('_', ' ').trim();
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames();
    }
  }

  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("Inc# ")) abort();
      field = field.substring(5).trim();
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }
}
