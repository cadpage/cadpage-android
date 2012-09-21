package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Onslow County, NC
Contact: Kim Cytryszewski <kimcytryszewski@gmail.com>,2526220424@messaging.sprintpcs.com
Sender: CAD@onslowcountync.gov

CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C\r
CAD:141 SHADY ST;STRUCTURE FIRE;PGFD;11B
CAD:417 LITTLE CREEK CT;ELECTRICAL HAZARD;WOFD;20D
CAD:1061 RIGGS RD/SMITH RD;DIST: 16.79 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20B
CAD:1612 RIGGS RD;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C
CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C
CAD:485 OLD 30 RD;MORTON ELEMENTARY;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20D
CAD:227 MIDDLE RIDGE DR;ALARMS;HFD;8D
CAD:100 BELGRADE SWANSBORO RD/FREEDOM WAY;DIST: 235.62 FT;STRUCTURE FIRE;SFD;17A
CAD:1000 YORKTOWN LN;LIBERTY POINTE APARTMENTS;STRUCTURE FIRE;PGFD;11B

Contact: Shane Jacobs <coastalcutz@gmail.com>
Sender: CAD@onslowcountync.gov
FRM:CAD@onslowcountync.gov\nMSG:CAD:1822 NEW RIVER INLET RD;UNIT 1107;17;FALL;17A03G
FRM:CAD@onslowcountync.gov\nMSG:CAD:9018 9TH ST;10;CHEST PAIN;10D04
FRM:CAD@onslowcountync.gov\nMSG:CAD:1822 NEW RIVER INLET RD;1107;17;FALL;17A01
FRM:CAD@onslowcountync.gov\nMSG:CAD:2075 HWY 172;COASTAL DREDGING;VEHICLE FIRE;SFFD;15A

*/

public class NCOnslowCountyParser extends DispatchOSSIParser {
  
  private static final Pattern CODE_PTN = Pattern.compile("\\d{1,2}[A-Z]\\d{1,2}[A-Z]?"); 
  
  private String selectValue;
  
  public NCOnslowCountyParser() {
    super("ONSLOW COUNTY", "NC",
           "ADDR ( SELECT/EMS UNIT+? CALL CODE | PLACE? CALL SRC UNIT2! )");
  }
  
  @Override
  public String getFilter() {
    return "CAD@onslowcountync.gov";
  }
  
  @Override
  protected boolean parseFields(String[] fields, Data data) {
    if (fields.length == 0) return false;
    selectValue = (CODE_PTN.matcher(fields[fields.length-1]).matches() ? "EMS" : "FIRE");
    return super.parseFields(fields, data);
  }

  @Override
  protected String getSelectValue() {
    return selectValue;
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("UNIT ")) field = field.substring(5).trim();
      data.strUnit = append(data.strUnit, "-", field);
    }
  }
  
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(CODE_PTN, true);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{1,2}FD", true);
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("UNIT2")) return new UnitField("\\d{1,2}[A-Z]", true);
    return super.getField(name);
  }
}
