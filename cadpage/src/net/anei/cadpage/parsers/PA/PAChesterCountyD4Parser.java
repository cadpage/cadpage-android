package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;



public class PAChesterCountyD4Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DETAIL_MARKER = Pattern.compile("(?:\n| \\*\\* )DETAILS TO ");
  private static final Pattern DELIM = Pattern.compile(" \\*\\*?(?= |$)");
  private static final Pattern UNIT_PTN = Pattern.compile(" Primary Unit: ([^ ]+) ");
  private static final Pattern LOC_BTWN_PTN = Pattern.compile("\n *Loc: .* btwn (.*?)(?: \\(V\\) *)?\n");
  private static final Pattern CITY_PTN = Pattern.compile("  Municipality: ([A-Z]+) ");
  
  public PAChesterCountyD4Parser() {
    super("DISPATCH TIME CALL UNK? ADDRCITY ( X/Z PLACE_PHONE/Z CITY | PLACE NAME PHONE ) BOX! INFO+");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String sExtra = null;
    int pt;
    Matcher match = DETAIL_MARKER.matcher(body);
    if (match.find()) pt = match.start();
    else pt = body.indexOf('\n');
    if (pt >= 0) {
      sExtra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
    }
    body = body.replace("\n", "");
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
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern PLACE_PHONE_PTN = Pattern.compile("(.*?)[ /](\\d{3}-\\d{3}-\\d{4})-");
  private class MyPlacePhoneField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = PLACE_PHONE_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strPlace = match.group(1).trim();
      data.strPhone = match.group(2);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      // TODO Auto-generated method stub
      return null;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
    if (name.equals("PLACE_PHONE")) return new MyPlacePhoneField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
} 
