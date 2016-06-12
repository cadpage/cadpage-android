package net.anei.cadpage.parsers.MT;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MTCascadeCountyBParser extends FieldProgramParser {
  
  public MTCascadeCountyBParser() {
    super("CASCADE COUNTY", "MT", 
          "DATETIME EMPTY? UNIT_CALL EMPTY+? Caller_Name:NAME? Caller_Phone:PHONE? EMPTY+? ADDRCITY! DUP_ADDR? APT_PLACE? INFO/N+");
  }
  
  @Override
  public String getFilter() {
    return "911Text@911intn.org,@greatfallsmt.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Automatic R&R Notification")) return false;
    int pt = body.indexOf("\nCity of Great Falls");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return parseFields(body.split("\n+"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("UNIT_CALL")) return new MyUnitCallField();
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DUP_ADDR")) return new MyDupAddressField();
    if (name.equals("APT_PLACE")) return new MyAptPlaceField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
    }
  }
  
  private class MyUnitCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt < 0) abort();
      data.strUnit = field.substring(0,pt).trim();
      data.strCall = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CALL";
    }
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("LAT:")) {
        data.strAddress = field;
        return;
      }
      field = field.replace('@', '&');
      super.parse(field, data);
    }
  }
  
  private class MyDupAddressField extends SkipField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return field.equals(getRelativeField(-1));
    }
  }
  
  private static final Pattern APT_PTN = Pattern.compile("\\d+[A-Z]?|1/2");
  private class MyAptPlaceField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("http://")) return false;
      if (field.startsWith("[")) return false;
      if (APT_PTN.matcher(field).matches()) {
        data.strApt = append(data.strApt, "-", field);
      } else {
        data.strPlace = field;
      }
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "APT PLACE";
    }
  }

  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("http://")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equalsIgnoreCase("Gore Hill")) return "Great Falls";
    if (city.equalsIgnoreCase("MANG")) return "Great Falls";
    if (city.equalsIgnoreCase("Sand Coulee")) return "Great Falls";
    return city;
  }
}
