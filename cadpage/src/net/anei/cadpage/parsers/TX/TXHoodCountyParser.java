package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Bell County, TX
 */
public class TXHoodCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("INCIDENT # ([A-Z]\\d{8})");
  private static final Pattern HASH_DELIM = Pattern.compile("(?<=[A-Z]) ?#(?= )");
  private static final Pattern FIELD_BREAK = Pattern.compile(" (ACTIVE CALL|REPORTED|Type|Zone|Phone):");
  private static final Pattern FIELD_DELIM = Pattern.compile(" *\n+ *");
  
  public TXHoodCountyParser() {
    super("HOOD COUNTY", "TX",
           "INCIDENT:ID? LONG_TERM_CAD:SKIP! ACTIVE_CALL:SKIP! REPORTED:DATETIME! Nature:CALL! Type:SKIP! Address:ADDR! Zone:MAP! City:CITY! Responding_Units:UNIT! Directions:INFO! Comments:INFO! INFO+ Contact:NAME Phone:PHONE");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) data.strCallId = match.group(1);
    
    body = HASH_DELIM.matcher(body).replaceAll(":");
    body = FIELD_BREAK.matcher(body).replaceAll("\n$1:");
    return parseFields(FIELD_DELIM.split(body), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(';');
      if (pt > 0) {
        data.strCross = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X";
    }
  }
  
  private static final Pattern DATE_TIME_OPER_PTN = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d{4}) - .*");
  private static final Pattern PHONE_GPS_PTN = Pattern.compile("CALLBACK=([-()\\d]+) LAT=([-+]\\d+\\.\\d+) LON=([-+]\\d+\\.\\d+) UNC=\\d+");
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("ProQA Fire.*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_OPER_PTN.matcher(field);
      if (match.matches()) {
        data.strTime = match.group(1);
        data.strDate = match.group(2);
        return;
      }
      
      match = PHONE_GPS_PTN.matcher(field);
      if (match.matches()) {
        data.strPhone = match.group(1);
        data.strGPSLoc = match.group(2) + "," + match.group(3);
        return;
      }
      
      if (INFO_JUNK_PTN.matcher(field).matches()) return;
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO TIME DATE GPS";
    }
  }
  
  // phone field has to contain a digit
  private static final Pattern LEGIT_PHONE_PTN = Pattern.compile(".*\\d.*");
  private class MyPhoneField extends PhoneField {
    @Override
    public void parse(String field, Data data) {
      if (!LEGIT_PHONE_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("PHONE")) return new MyPhoneField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    
    // The address field is fine, what we are really trying to correct
    // is problems in the cross street field that get migrated into the
    // address when no street number is specified
    
    if (CROSS_SKIP_PTN.matcher(addr).find()) return "";
    
    addr = CROSS_REMOVE_PTN.matcher(addr).replaceAll("");
    return addr.trim();
  }
  private static final Pattern CROSS_SKIP_PTN = Pattern.compile("^\\d+[a-z]{2} house\\b|^house before\\b|^house after\\b|^entrance to\\b|^accross\\b|\\bbehind\\b|\\bnext to\\b\\bon side\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern CROSS_REMOVE_PTN = Pattern.compile("\\b(?:north|south|east|west|area) of\\b", Pattern.CASE_INSENSITIVE);
}
