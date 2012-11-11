package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;




public class PAChesterCountyFParser extends PAChesterCountyBaseParser {

  private static final Pattern DETAILS_TO_FOLLOW = Pattern.compile("\\r?\\nDETAILS TO FOLLOW\\b\\r?\\n?");
  private static final Pattern DELIM = Pattern.compile("(\\* )?\\*\\*");
  
  public PAChesterCountyFParser() {
    super("CALL ADDRCITY ( CITY PLACE X APT INFO | APT INFO CITY PLACE )");
  }
  
  @Override
  public String getFilter() {
    return "cad@oxfordfire.com,paging@minquas.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains(" * ** ")) return false;

    body = DETAILS_TO_FOLLOW.matcher(body).replaceAll("");
    body = body.replace('\n', ' ');

    // Split and parse by asterisk delimiters
    return parseFields(DELIM.split(body), data);
  }
  
  private static final Pattern TRAILER = Pattern.compile(" *\\(N?V\\)$");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = TRAILER.matcher(field);
      if (match.find()) {
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return true;
      return super.checkParse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
} 
