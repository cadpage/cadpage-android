package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Handles parsing for some, as yet, unidentified vendor

Camden County, GA
astudstill@co.camden.ga.us:2011-101695* HIGHWAY 17 STEFFANS* * * KINGSLAND* * Traffic Stop* TRAFFIC STOP* * * 1128,1140,1150,1152,509,514,523,532,LS3,R3* * Med
astudstill@co.camden.ga.us:2011-104696* 4059 MARTIN LUTHER KING BLVD* N4* * 514,541,546,ENG4,LS4,MED4 KINGSLAND* * INJURY* INJURY* 509,ENG5,LS3* * Medical: No
astudstill@co.camden.ga.us:2011-101995* 405 & HIGHWAY 40 OLD WAFFLE HOUSE* * * KINGSLAND* * ACCIDENT* ACCIDENT* ELAINE* 386-208-4465* 514,541,546,ENG4,LS4,MED4
astudstill@co.camden.ga.us:2011-104843* 429 EAGLE BLVD* * * KINGSLAND* * PERSON SICK* PERSON SICK* * 540,ENG4,LS4* * Medical: No* Haz
214 REDWOOD ST* * * KINGSLAND* * PERSON SICK* PERSON SICK* MS FAGEN*912-269-6157* LS3,R3* * Medical: No* Hazards: No* 
astudstill@co.camden.ga.us:2011-181161* ADVANCE COLLISION CENTER* * * KINGSLAND* * WIRE DOWN* WIRE DOWN* JOHN* 316-258-1559* ENG4,LS4* * Medical: No* Haz

Northampton County, NC
S: M:Northampton911:* URIAH MARTIN RD // NEAR CEMETERY* * * CONWAY* * FIRE - BRUSH* * * * EMS3,FS20* * Medical: No* Hazards: No* * 
S: M:Northampton911:* BOAT LANDING* * * WELDON* * MISSING PERS* * * * EMS8,FS20* * Medical: No* Hazards: No* * 
S: M:Northampton911:* 907 HORNE RD* * * PENDLETON* * FIRE - SMOKE* * * * EMS3,FS18,FS20* * Medical: No* Hazards: No* * 
S: M:Northampton911:* 203 WHITE ST* * * CONWAY* * ODOR OF GAS* * * * FS20* * Medical: No* Hazards: No* * 

*/
public class DispatchA3Parser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*(?: \\*)*");
  
  public DispatchA3Parser(String defCity, String defState) {
    super(defCity, defState,
           "ID? ADDR/SXP APT? CITY! CALL CALL2? ( NAME PHONE | ) UNIT! INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(DELIM.split(body), data);
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("[\\d\\-]+"));
    }
  }
  
  private class MyAptField extends AptField {
    public MyAptField() {
      setPattern(Pattern.compile("[-A-Z0-9]{1,3}"));
    }
  }
  
  private class Call2Field extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return (field.equalsIgnoreCase(data.strCall));
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("^[^ ]*,[^ ]* ");
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = UNIT_PTN.matcher(field);
      if (match.find()) field = field.substring(match.end()).trim();
      super.parse(field, data);
    }
  }
  
  // Pattern that the unit field must match
  private static final Pattern REAL_UNIT_PTN = Pattern.compile("[A-Z0-9]{1,3}[0-9](?:,[A-Z0-9]{1,4})*");
  
  // Name field is OK, unless it is a unit field
  private class MyNameField extends NameField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    public boolean checkParse(String field, Data data) {
      if (REAL_UNIT_PTN.matcher(field).matches()) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  // Unit field must match unit pattern
  // But if name field is empty, it can only means that this field was tried
  // as a name field and failed because it matched the unit pattern, so we don't
  // have to check it again
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (data.strName.length() > 0 && 
          ! REAL_UNIT_PTN.matcher(field).matches()) abort();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("CALL2")) return new Call2Field();
    if (name.equals("NAME")) return new MyNameField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
}
