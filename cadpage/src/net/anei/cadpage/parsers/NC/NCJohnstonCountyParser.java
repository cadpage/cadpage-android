package net.anei.cadpage.parsers.NC;


import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Johnston County, NC
Contact: "Ole Dean K." <koehmstedt@gmail.com>
Sender: 93001xxx

CAD:Evacuation In-Progress;70 MYSTICAL CT; GARN;(S)JORDAN RIDGE (N)
CAD:OPS5;CLD;52C02C;CARBON MONOXIDE ALARM;70 MYSTICAL CT;(S)JORDAN RIDGE (N);GALAXY DR;DENA HOLLOMAN;12/28/2010 22:20:35;CLD1
CAD:CLDFR;CLD;17B01G;INJURED PERSON;104 LAKEVIEW CT;(S)SOUTH RIDGE (N);SOUTH RIDGE DR;DOBERT, HENRY;12/28/2010 11:00:58;CLDR1
CAD:OPS;CLD;10C02;CHEST PAINS;643 BIG PINE RD;PEACE LN;GOVERNMENT RD;ESTERLENE MILLER;02/09/2011 15:21:31;CLDR2
CAD:OPS;CLD;06D02;DIFFICULTY BREATHING;101 CHERRY CT;ALLEN RD;DAVIS, JOHN;02/09/2011 15:08:36;CLDR1
CAD:OPS4;CLD;52B01S;FIRE ALARM;330 STEEL BRIDGE RD;CONTENDER DR;CLEVELAND RD;BROADVIEW;02/09/2011 12:18:09;CLD1
CAD:OPS4;CLD;MVA PERSONAL INJURY;WATKINS RD/CLEVELAND RD;SPRINT PCS;02/08/2011 07:18:56;CLD1
CAD:OPS4;CLD;GAS LEAK NATURAL GAS/PROPANE;105 JOSEPHINE RD;CLEVELAND RD;MOONLIGHT DR;POLENTA ELEMENTARY SCHOOL;SUSAN;02/08/2011
CAD:No Add`l Personnel / Unit;105 JOSEPHINE RD; GARN
CAD:OPS7;CLD;VEHICLE FIRE;314 I-40 HWY;314.5;SPRINT PCS;02/07/2011 15:54:03;CLD1
CAD:Standby At The Station;314 I-40 HWY; BENS;314.5
CAD:No Add`l Personnel / Unit;314 I-40 HWY; BENS;314.5

*/

public class NCJohnstonCountyParser extends DispatchOSSIParser {
  
  public NCJohnstonCountyParser() {
    super("JOHNSTON COUNTY", "NC",
           "( SRC SKIP CODE? | ) CALL ADDR! X? X? NAME");
  }

  @Override
  public String getFilter() {
    return "93001";
  }

  // Source code validates that is is not more than 5 characters long
  private class MySourceField extends SourceField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() > 5) return false;
      parse(field, data);
      return true;
    }
  }
  
  // Code field must match particular pattern
  private static final Pattern CODE_PATTERN = Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Z]?");
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(CODE_PATTERN);
    }
  }
  
  // Cross street won't pass normal address validation
  // We will take anything that doesn't look like a name with a comma
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.contains(",")) return false;
      parse(field, data);
      return true;
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}