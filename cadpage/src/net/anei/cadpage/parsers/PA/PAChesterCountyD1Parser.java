package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyD1Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*{2,}");
  
  public PAChesterCountyD1Parser() {
    super("TIME! CALL ADDRPLX BOX_PLACE INFO+");
  }
  
  @Override
  public String getFilter() {
    return "adi62@ridgefirecompany.com,dispatch@berwynfireco.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    // subject is truncated version of address that we don't care about
    // but it has to be non-empty
    if (subject.length() == 0) return false;
    
    // And all of the should treat line breaks as spaces
    body = body.replace('\n', ' ');

    // Split and parse by double asterisk delimiters
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("ADDRPLX")) return new MyAddressPlaceCrossField();
    if (name.equals("BOX_PLACE")) return new MyBoxPlaceField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  // Address has to expand on the base class MyAddressField
  // adding cross street and place names
  private static final Pattern INTERSECT = Pattern.compile("\\b[NSEW]O\\b");
  private static final Pattern PIKE = Pattern.compile("\\bPK\\b");
  private class MyAddressPlaceCrossField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = stripFieldEnd(field,"(V)");
      Parser p = new Parser(field);
      data.strCross = p.getLastOptional(" btwn ");
      data.strPlace = p.getLastOptional(" -- ");
      field = p.get();
      field = INTERSECT.matcher(field).replaceAll("&");
      field = PIKE.matcher(field).replaceAll("PIKE");
      parseChesterAddress(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE X";
    }
  }
  
  private static final Pattern BOX_PTN = Pattern.compile("\\d{4}");
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|SUITE)[- /]+([^-]+?)-+(.*)");
  private class MyBoxPlaceField extends Field {

    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "-");
      if (BOX_PTN.matcher(field).matches()) {
        data.strBox = field;
      } else {
        Matcher match = APT_PTN.matcher(field);
        if (match.matches()) {
          data.strApt = append(data.strApt, "-", match.group(1).trim());
          field = match.group(2).trim();
        }
        data.strPlace = field;
      }
    }

    @Override
    public String getFieldNames() {
      return "BOX PLACE";
    }
    
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (field.length() <= 6) {
        String city = CITY_CODES.getProperty(field);
        if (city != null) {
          if (data.strCity.length() == 0) data.strCity = city;
          return;
        }
      }
      super.parse(field, data);
    }
  }
} 
