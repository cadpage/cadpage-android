package net.anei.cadpage.parsers.KY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class KYBooneCountyAParser extends FieldProgramParser {
  
  private static final String MARKER = "IPS I/Page Notification";
  
  public KYBooneCountyAParser() {
    super(CITY_CODES, "BOONE COUNTY", "KY",
          "Location:ADDR/S! Event_Number:ID! Event_Type:CALL! CALLER_NAME:NAME! CALLER_ADDR:SKIP! TIME:TIME! Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "jfussinger@bcpscc.org";
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.equals(MARKER)) break;
      
      if (body.startsWith(MARKER)) {
        body = body.substring(MARKER.length()).trim();
        break;
      }
      
      return false;
    } while (false);
    
    return super.parseMsg(body,  data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // The match really can not fail
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional(": @");
      String apt = p.getLastOptional(":APT");
      if (apt.length() == 0) apt = p.getLastOptional(',');
      super.parse(p.get(), data);
      data.strApt = append(data.strApt, "-", apt);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE APT";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("SPECIAL ADDRESS COMMENT:")) field = field.substring(27).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "FLOR", "FLORENCE",
      "UNIO", "UNION",
      "WALT", "WALTON",
      "BURL", "BURLINGTON",
      "PETE", "PETERSBURG",
      "ERLA", "ERLANGER",
      "CRIT", "CRITTENDEN",
      "HEBR", "HEBRON",
      "VERO", "VERONA",
      "INDE", "INDEPENDENCE",
      "BCFL", "FLORENCE",
      "BCWA", "WALTON",
      "BCUN", "UNION",
      "GAC",  "GALATIN",
      "GRC",  "GRANT",
      "KEC",  "KENTON",

  }); 
}
