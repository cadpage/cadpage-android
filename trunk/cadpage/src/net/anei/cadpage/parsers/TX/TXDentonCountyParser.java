package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class TXDentonCountyParser extends DispatchOSSIParser {
  
  public TXDentonCountyParser() {
    super(CITY_LIST, "DENTON COUNTY", "TX",
          "FYI? ( ID ( DATIME SRC? CALL NAME? ADDR/s X/Z+? CITY | ADDR X/Z+? CITY SRC? CALL ) | CALL ADDR CITY ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@dentoncounty.com";
  }
  
  @Override
  public String getSponsor() {
    return "Lake Cities Fire Department";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("Message Forwarded by PageGate") && !body.startsWith("CAD:")) body = "CAD:" + body;
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.length() == 4) {
      String city = CITY_CODES.getProperty(data.strCity);
      if (city != null) {
        if (data.strSource.length() == 0) data.strSource = data.strCity;
        data.strCity = city;
      }
    }
    return true;
  }

  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{9}"));
    }
  }
  
  
  
  private static final Pattern SOURCE_PTN = Pattern.compile("[A-Z]{2}FD"); 
  private class MySourceField extends SourceField {
    public MySourceField() {
      setPattern(SOURCE_PTN);
    }
  }
  
  
  private static final Pattern SERV_PTN = Pattern.compile("\\bSERV\\b");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = SERV_PTN.matcher(field).replaceAll("FRONTAGE");
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = SOURCE_PTN.matcher(field);
      if (match.matches()) {
        data.strSource = field;
        if (data.strCity.length() == 0) data.strCity = field;
        return;
      }
      if (checkAddress(field) > 0) {
        data.strCross = append(data.strCross, " & ", field);
      } else {
        super.parse(field, data);
      }
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("DATIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d");
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARFD", "ARGYLE",
      "CORI", "CORINTH",
      "LAKE", "LAKE DALLAS",
      "LVFD", "LEWISVILLE",
      "HICK", "HICKORY CREEK",
      "SHAD", "SHADY SHORES",
      "LCFD", ""
  });
  
  private static final String[] CITY_LIST = new String[]{
    "ARFD", 
    "CORI", 
    "LAKE", 
    "LVFD", 
    "HICK", 
    "SHAD", 
    "LCFD",

    "ARGYLE",
    "BARTONVILLE",
    "COPPER CANYON",
    "CORRAL CITY",
    "CORINTH",
    "DENTON",
    "DOUBLE OAK",
    "FLOWER MOUND",
    "HICKORY CREEK",
    "LAKE DALLAS",
    "LEWISVILLE",
    "NORTHLAKE",
    "HICKORY CREEK",
    "SHADY SHORES",
    
    "DENTON COUNTY"
    
  };
}
