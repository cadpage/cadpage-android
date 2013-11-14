package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyD1Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*\\*");
  
  public PAChesterCountyD1Parser() {
    super("TIME! CALL ADDRPLX BOX INFO+");
  }
  
  @Override
  public String getFilter() {
    return "adi62@ridgefirecompany.com";
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
  
  // Call field strips trailing asterisk marker
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" *")) field = field.substring(0,field.length()-2);
      super.parse(field, data);
    }
  }
  
  // Address has to expand on the base class MyAddressField
  // adding cross street and place names
  private static final Pattern INTERSECT = Pattern.compile("\\b[NSEW]O\\b");
  private static final Pattern PIKE = Pattern.compile("\\bPK\\b");
  private class MyAddressPlaceCrossField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("(V)")) field = field.substring(0, field.length()-3).trim();
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDRPLX")) return new MyAddressPlaceCrossField();
    return super.getField(name);
  }
} 
