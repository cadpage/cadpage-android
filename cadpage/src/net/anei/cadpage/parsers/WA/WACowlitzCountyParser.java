package net.anei.cadpage.parsers.WA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class WACowlitzCountyParser extends FieldProgramParser {
  
  public WACowlitzCountyParser() {
    super(CITY_CODES, "COWLITZ COUNTY", "WA",
          "ADDR/S! RMRK:INFO! CALLER_NAME:NAME CALLER_ADDR:SKIP TIME:TIME Disp:UNIT");
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.equals("LOC")) break;
      
      if (subject.equals("DIVE") && body.startsWith("LOC: ")) {
        body = body.substring(4).trim();
        break;
      }
      
      return false;
    } while (false);
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(": @");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private static final Pattern INFO_GPS_PTN = Pattern.compile("([-+]?\\d+\\.\\d{6} +[-+]?\\d}\\d{6})[- ]+(.*)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      // Look for GPS coordinates
      Matcher match = INFO_GPS_PTN.matcher(field);
      if (match.matches()) {
        setGPSLoc(match.group(1), data);
        field = match.group(2);
      }
      super.parse(field, data);
    }
  }
  
  private static Properties CITY_CODES = buildCodeTable(new String[] {
      "AM", "AMBOY",
      "AR", "ARIEL",
      "CO", "COUGAR",
      "KA", "KALAMA",
      "KE", "KELSLO",
      "LV", "LONGVIEW",
      "RV", "ROSE VALLEY",
      "SL", "SILVER LAKE",
      "TO", "TOUTLE",
      "WD", "WOODLAND",

      
  });

}
