package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA1Parser extends FieldProgramParser {
  
  private Set<String> citySet = null;

  public DispatchA1Parser(String defCity, String defState) {
    this((Properties)null, defCity, defState);
  }
  
  public DispatchA1Parser(Set<String> citySet, String defCity, String defState) {
    this((Properties)null, defCity, defState);
    this.citySet = citySet;
  }
  
  public DispatchA1Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, 
           "ALRM_LVL:PRI? RUN_CARD:BOX? LOC:PLACE PLACE2? ADDR! APT? CITY BTWN:X INCIDENT:ID? COM:INFO INFO+? CT:INFO INFO+? UNITS:UNIT INCIDENT:ID DATE/TIME:DATETIME RPT_#:EMPTY ID");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("Alert:")) return false;
    data.strCall = subject.substring(6).trim();
    if (data.strCall.length() == 0) data.strCall = "ALERT";
    body = body.replace(", RUN CARD:", "\nRUN CARD:");
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("BOX")) return new MyBoxField();
    if (name.equals("PLACE2")) return new MyPlace2Field();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("ID")) return new IdField("[E|F]=(.*)");
    return super.getField(name);
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "BOX");
      super.parse(field, data);
    }
  }
  
  private class MyPlace2Field extends PlaceField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      
      // If this looks like a box field, make do with that
      if (checkBoxField(field, data)) return true;
      
      // Otherwise there are a lot of things to check
      do {
  
        // If first or second following field starts with BTWN: this must be an address
        // followed by a city
        if (getRelativeField(1).startsWith("BTWN:")) return false;
        if (getRelativeField(2).startsWith("BTWN:")) return false;
        
        // If next field looks like an apartment, this must be an address
        String next = getRelativeField(1);
        if (APT_PATTERN.matcher(next).matches()) return false;
        
        // Empty strings should be counted as an apt
        if (next.length() == 0) return false;
        
        // If the field beyond that looks like an apt, then the next field is the
        // address line and we are an apt.
        String next2 = getRelativeField(2);
        if (APT_PATTERN.matcher(next2).matches()) break;
        
        // Looks like a tossup.  We need to do an address comparison.  This will be
        // treated as the place name unless the we are a better address then the next field
        int chk1 = checkAddress(field);
        if (chk1 > STATUS_MARGINAL && chk1 > checkAddress(next)) return false;
        
      } while (false);
      
      // OK, parse this as a place field
      parse(field, data);
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return "BOX PLACE";
    }
  }
  
  // This should be the address field.  But check to see if the place field
  // in front of it makes a better address
  private class MyAddressField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strPlace.length() > 0) {
        int chk1 = checkAddress(data.strPlace);
        if (chk1 > STATUS_MARGINAL && chk1 > checkAddress(field)) {
          String tmp = data.strPlace;
          data.strPlace = "";
          super.parse(tmp, data);
          return false;
        }
      }
      super.parse(field, data);
      return true;
    }
  }
  
  private static final Pattern APT_PATTERN = Pattern.compile("(?:APT|ROOM|RM)[-:]? *(.*)|(LOT *.*|.* (?:APT|ROOM|RM|bHALLWAY)\\b.*|\\d+[A-Z]?|[A-Z])");
  private static final Pattern CITY_PATTERN = Pattern.compile("[ A-Za-z]+");
  private class MyAptField extends AptField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {

      // See if this looks like a box field
      if (checkBoxField(field, data)) return true;

      // At this point, we are either an apt or a city, and there are different ways to figure out
      // just which it is
      do {
        
        // If it looks like an apt, so be it
        Matcher match = APT_PATTERN.matcher(field);
        if (match.matches()) {
          field = match.group(1);
          if (field == null) field = match.group(2);
          break;
        }
        
        // If next field does not start with BTWN, it must be a city and we must be an apt
        if (!getRelativeField(+1).startsWith("BTWN:")) break;
        
        // Check to see if this could possibly be a city
        if (!CITY_PATTERN.matcher(field).matches()) break;
        
        // If we were not given a city set, assume this is a city
        if (citySet == null) return false;
        
        // Otherwise, use it to check to see if this is a city or not
        if (citySet.contains(field.toUpperCase())) return false;
        
      } while (false);
      
      parse(field, data);
      return true;
    }
  }
  
  private boolean checkBoxField(String field, Data data) {
    Matcher match = BOX_PTN.matcher(field);
    if (!match.find()) return false;
    if (match.start() == 0) field = field.substring(match.end()).trim();
    if (!data.strBox.contains(field)) {
      data.strBox = append(data.strBox, " / ", field);
    }
    return true;
  }
  private static final Pattern BOX_PTN = Pattern.compile("\\bBO?X\\b");
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("N/A ")) field = field.substring(4).trim();
      if (field.endsWith(" N/A")) field = field.substring(0,field.length()-4).trim();
      if (field.startsWith("&")) field = field.substring(1).trim();
      if (field.endsWith("&")) field = field.substring(0,field.length()-1).trim();
      field = field.replaceAll("  +", " ");
      super.parse(field, data);
    }
  }
  
  private static final Pattern SKIP_INFO_PTN = Pattern.compile("[A-Z]+[0-9]* at(?: POS \\d+)?");
  private class MyInfoField extends InfoField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (SKIP_INFO_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
}
