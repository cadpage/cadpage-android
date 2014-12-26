package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyD4Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DETAILS_TO_FOLLOW = Pattern.compile("\n *DETAILS TO FOLLOW *");
  private static final Pattern DELIM = Pattern.compile(" \\*\\*?(?= |$)");
  
  public PAChesterCountyD4Parser() {
    super("DISPATCH TIME CALL EMPTY? ADDRCITY! ( X PLACE_PHONE CITY BOX! | PLACE ( NAME PHONE BOX! | NAME PHONE/Z BOX! | BOX | ) ) UNIT? INFO+? DATE CITY UNIT EMPTY");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.equals("Dispatch")) {
      body = subject + " * " + body;
    } else if (body.startsWith("Dispatch / ")) {
      body = body.substring(11).trim();
    }
    body = DETAILS_TO_FOLLOW.matcher(body).replaceFirst("");
    body = body.replace("\n** ", " ** ");
    body = body.replace("\n", "");
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " UNIT X CITY";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("X")) return new CrossField(".*&.*");
    if (name.equals("PLACE_PHONE")) return new MyPlacePhoneField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("NAME")) return new MyNameField();
    if (name.equals("PHONE")) return new PhoneField("\\d{3}-\\d{3}-\\d{3,4}");
    if (name.equals("BOX")) return new BoxField("\\d{4}", true);
    if (name.equals("UNIT")) return new UnitField("\\d{2}|", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DATE")) return new DateField("\\d\\d/\\d\\d/\\d\\d", true);
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  private static final Pattern PLACE_PTN = Pattern.compile("-.*|.*-(?:[A-Z]{2})?");
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|RM|#) *(.*)");
  private class MyPlaceField extends PlaceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return checkParse(field, data, false);
    }
    
    @Override
    public void parse(String field, Data data) {
      checkParse(field, data, true);
    }
    
    private boolean checkParse(String field, Data data, boolean force) {
      field = stripFieldStart(field, "-");
      field = stripFieldEnd(field, "-");
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = append(data.strApt, "-", match.group(1));
        return true;
      }
      else {
        boolean result = PLACE_PTN.matcher(field).matches();
        if (result || force) {
          super.parse(field, data);
        }
        return result;
      }
    }
  }
  
  private static final Pattern PLACE_PHONE_PTN = Pattern.compile("[ /](\\d{3}-\\d{3}-\\d{4})$");
  private class MyPlacePhoneField extends PlaceField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      Matcher match = PLACE_PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group(1);
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }

    @Override
    public String getFieldNames() {
      return "PLACE PHONE";
    }
  }
  
  private class MyNameField extends NameField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("DETAILS TO FOLLOW")) return;
      if (field.startsWith("ADR:")) return;
      if (field.startsWith("LOC:")) return;
      if (field.startsWith("NAM:")) {
        if (data.strName.length() == 0) data.strName = field.substring(4).trim();
      } else if (field.startsWith("LOCI:")) {
        if (data.strPlace.length() == 0) data.strPlace = field.substring(5).trim();
      } else if (field.startsWith("PHO:")) {
        if (data.strPhone.length() == 0) data.strPhone = field.substring(4).trim();
      } else {
        if (field.startsWith("TXT:")) field = field.substring(4).trim();
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PLACE PHONE INFO";
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() > 0) return;
      data.strCity = convertCodes(field, CITY_CODES);
    }
  }
} 
