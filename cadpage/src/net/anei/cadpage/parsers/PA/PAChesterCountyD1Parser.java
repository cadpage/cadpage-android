package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyD1Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*{2,}");
  
  public PAChesterCountyD1Parser() {
    super("TIME! CALL ADDR INFO1 INFO+");
  }
  
  @Override
  public String getFilter() {
    return "adi62@ridgefirecompany.com,dispatch@berwynfireco.org,ADI64@norco.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // And all of the should treat line breaks as spaces
    body = body.replace('\n', ' ');

    // Split and parse by double asterisk delimiters
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("INFO1")) return new MyInfoField(true);
    if (name.equals("INFO")) return new MyInfoField(false);
    return super.getField(name);
  }
  
  private static final Pattern BOX_PTN = Pattern.compile("\\d{4}");
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|SUITE)[- /]+([^-]+?)-+(.*)");
  private static final Pattern PHONE_PTN = Pattern.compile(".*\\b(?:CP)?\\d{3}[-\\.]?\\d{3}[-\\.]?\\d{4}\\b.*");
  private class MyInfoField extends InfoField {
    private boolean place;
    
    public MyInfoField(boolean place) {
      this.place = place;
    }
    
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "-");
      if (field.length() == 0) return;
      if (BOX_PTN.matcher(field).matches()) {
        data.strBox = append(data.strBox, "/", field);
        return;
      }
      if (PHONE_PTN.matcher(field).matches()) {
        data.strPhone = field;
        return;
      }
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = append(data.strApt, "-", match.group(1).trim());
        data.strPlace = match.group(2).trim();
        return;
      }
      if (field.length() <= 11) {
        String city = CITY_CODES.getProperty(field);
        if (city != null) {
          if (data.strCity.length() == 0) data.strCity = city;
          return;
        }
      }
      if (place) {
        data.strPlace = field;
        return;
      }
      super.parse(field, data);
    }

    @Override
    public String getFieldNames() {
      return "PLACE PHONE BOX INFO";
    }
  }
} 
