package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;



public class PAChesterCountyD4Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DETAIL_MARKER = Pattern.compile("(?:\n| \\*\\* )DETAILS TO ");
  private static final Pattern UNIT_PTN = Pattern.compile(" Primary Unit: ([^ ]+) ");
  private static final Pattern LOC_BTWN_PTN = Pattern.compile("\n *Loc: .* btwn (.*?)(?: \\(V\\) *)?\n");
  private static final Pattern CITY_PTN = Pattern.compile("  Municipality: ([A-Z]+) ");
  
  public PAChesterCountyD4Parser() {
    super("DISPATCH TIME CALL ADDRCITY PLACE NAME PHONE BOX INFO+");
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
    if (!parseFields(body.split(" \\*\\* "), data)) return false;
    
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
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("*")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
} 
