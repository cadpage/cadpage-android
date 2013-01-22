package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCOnslowCountyParser extends DispatchOSSIParser {
  
  private static final Pattern CODE_PTN = Pattern.compile("\\d{1,2}[A-Z]\\d{1,2}[A-Za-z]?"); 
  
  private String selectValue;
  
  public NCOnslowCountyParser() {
    super(CITY_CODES, "ONSLOW COUNTY", "NC",
           "( ASSIST ADDR CITY DIST? INFO+ | ADDR ( SELECT/EMS APT? PLACE? UNIT CALL! CODE | PLACE? CALL SRC UNIT! ) )");
  }
  
  @Override
  public String getFilter() {
    return "CAD@onslowcountync.gov";
  }
  
  @Override
  protected boolean parseFields(String[] fields, Data data) {
    if (fields.length == 0) return false;
    selectValue = (fields.length < 4 || CODE_PTN.matcher(fields[fields.length-1]).matches() ? "EMS" : "FIRE");
    return super.parseFields(fields, data);
  }

  @Override
  protected String getSelectValue() {
    return selectValue;
  }
  
  private class AssistField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("ASSIST ")) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  private static final Pattern APT_PTN = Pattern.compile("(?:LOT|APT|UNIT|SUITE) *(.*)|\\d+");
  private class MyAptField extends AptField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // See if we match the master apartment pattern
      Matcher match = APT_PTN.matcher(field);
      if (!match.matches()) return false;
      
      // Match succeeded, but there are two possible outcomes.  If this had
      // some kind of apartment prefix, take it as gospel
      String apt = match.group(1);
      if (apt != null) {
        data.strApt = apt;
        return true;
      }
      
      // Otherwise is is a numeric token that looks a lot like a unit field.
      // The only way we can determine if this is an apartment
      // field is by looking at the next two fields to see if one of them looks
      // like a unit field.  If not, then we must be the unit field
      boolean found = false;
      for (int ndx = 1; ndx <= 2; ndx++) {
        String fld = getRelativeField(ndx);
        if (UNIT_PTN.matcher(fld).matches()) {
          found = true;
          break;
        }
      }
      if (!found) return false;
      data.strApt = field;
      return true;
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\d{1,2}[A-Z]?");
  private class MyUnitField extends UnitField {
    public MyUnitField() {
      setPattern(UNIT_PTN, true);
    }
    
    @Override
    public void parse(String field, Data data) {
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
    if (name.equals("ASSIST")) return new AssistField();
    if (name.equals("DIST")) return new PlaceField("DIST:.*");
    if (name.equals("SRC")) return new SourceField("[A-Z]{1,2}FD", true);
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("CODE")) return new MyCodeField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "RICH", "RICHLANDS"
  });
}
