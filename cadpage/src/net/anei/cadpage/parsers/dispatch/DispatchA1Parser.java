package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA1Parser extends FieldProgramParser {

  public DispatchA1Parser(String defCity, String defState) {
    this(null, defCity, defState);
  }
  
  public DispatchA1Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, 
           "ALRM_LVL:PRI RUN_CARD:BOX? LOC:SKIP PLACE? ADDR! APT? CITY BTWN:X COM:INFO INFO+? CT:INFO INFO+? UNITS:UNIT");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("Alert:")) return false;
    data.strCall = subject.substring(6).trim();
    if (data.strCall.length() == 0) data.strCall = "ALERT";
    body = body.replace(", RUN CARD:", "\nRUN CARD:");
    return parseFields(body.split("\n"), data);
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "BOX");
      super.parse(field, data);
    }
  }
  
  private class MyPlaceField extends PlaceField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {

      // If first or second following field starts with BTWN: this must be an address
      // followed by a city
      if (getRelativeField(1).startsWith("BTWN:")) return false;
      if (getRelativeField(2).startsWith("BTWN:")) return false;
      
      // If next field looks like an apartment, and third field starts with BTWN:, 
      // then this must be an address followed by apartment and city
      String aptFld = getRelativeField(1);
      if ((aptFld.length()<=3 || aptFld.startsWith("APT") || aptFld.startsWith("LOT"))&& 
           getRelativeField(3).startsWith("BTWN:")) return false;
      
      // Otherwise, we can be a place field
      parse(field, data);
      return true;
    }
  }
  
  // This should be the address field.  But check to see if the place field
  // in front of it makes a better address
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (data.strPlace.length() > 0) {
        int chk1 = checkAddress(data.strPlace);
        if (chk1 > 0 && chk1 > checkAddress(field)) {
          String tmp = data.strPlace;
          data.strPlace = field;
          field = tmp;
        }
      }
      super.parse(field, data);
      
      if (data.strPlace.startsWith("BOX ")) {
        data.strBox = append(data.strBox, " / ", data.strPlace.substring(4).trim());
        data.strPlace = "";
      }
    }
  }
  
  private static final Pattern APT_PATTERN = Pattern.compile("(?:APT|ROOM|RM)[-:]? *(.*)|(LOT *.*|.* (?:APT|ROOM|RM|\\bHALLWAY\\b).*)");
  private class MyAptField extends AptField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = APT_PATTERN.matcher(field);
      if (match.matches()) {
        field = match.group(1);
        if (field == null) field = match.group(2);
      }
      else if (field.length() > 3 && !field.contains("#")) return false; 
      parse(field, data);
      return true;
    }
  }
  
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
  public Field getField(String name) {
    if (name.equals("BOX")) return new MyBoxField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
}
