package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyD4Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile(" \\*\\*?(?= |$)|\n");
  private static final Pattern UNIT_PTN = Pattern.compile(" Primary Unit: ([^ ]+) ");
  private static final Pattern LOC_BTWN_PTN = Pattern.compile("\n *Loc: .* btwn (.*?)(?: \\(V\\) *)?\n");
  private static final Pattern CITY_PTN = Pattern.compile("  Municipality: ([A-Z]+) ");
  
  public PAChesterCountyD4Parser() {
    super("DISPATCH TIME CALL UNK? ADDRCITY! ( X PLACE_PHONE CITY BOX! | EMPTY PLACE_PHONE CITY BOX! | PLACE ( NAME PHONE BOX! | NAME PHONE/Z BOX! | ) ) INFO+? DATE CODE ID");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.equals("Dispatch")) {
      body = subject + " * " + body;
    } else if (body.startsWith("Dispatch / ")) {
      body = body.substring(11).trim();
    }
    String sExtra = null;
    int pt = body.indexOf("** Inc History");
    if (pt < 0) pt = body.indexOf('\n');
    if (pt >= 0) {
      sExtra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
    }
    if (!parseFields(DELIM.split(body), data)) return false;
    
    if (sExtra != null) {
      Parser p = new Parser(sExtra);
      data.strUnit = p.getMatcherValue(UNIT_PTN);
      data.strCross = p.getMatcherValue(LOC_BTWN_PTN);
      if (data.strCity.length() == 0) {
        data.strCity = convertCodes(p.getMatcherValue(CITY_PTN), CITY_CODES);
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " UNIT X CITY";
  }
  
  private static final Pattern PLACE_PTN = Pattern.compile("-.*|.*-(?:[A-Z]{2})?");
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
      boolean result = PLACE_PTN.matcher(field).matches();
      if (result || force) {
        if (field.startsWith("-")) field = field.substring(1).trim();
        if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
        super.parse(field, data);
      }
      return result;
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
    if (name.equals("X")) return new CrossField(".*&.*");
    if (name.equals("PLACE_PHONE")) return new MyPlacePhoneField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("NAME")) return new MyNameField();
    if (name.equals("PHONE")) return new PhoneField("\\d{3}-\\d{3}-\\d{3,4}");
    if (name.equals("BOX")) return new BoxField("\\d{4}");
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DATE")) return new DateField("\\d\\d/\\d\\d/\\d\\d", true);
    return super.getField(name);
  }
} 
