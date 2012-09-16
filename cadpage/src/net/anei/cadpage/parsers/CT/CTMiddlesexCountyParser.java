package net.anei.cadpage.parsers.CT;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Middlesex County, CT
 */

public class CTMiddlesexCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile(".*CAD Page for CFS (\\d{6,}-\\d+)");
  
  public CTMiddlesexCountyParser() {
    super(CITY_CODES, "MIDDLESEX COUNTY", "CT",
          "GPS? CALL! ADDR! Apt:APT! CITY! Cross_Streets:X? Caller:NAME! Disp_Time:DATETIME! EMPTY+? GPS");
  }

  @Override
  public String getFilter() {
    return ".sbc.mail.gq1.yahoo.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    return parseFields(body.split("\n"), 7, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern GPS_PATTERN = Pattern.compile("http://maps\\.google\\.com/maps\\?q=([-+]*\\d+\\.\\d+ +[-+]*\\d+\\.\\d+)");
  private class MyGPSField extends GPSField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      field = field.replace("%20", " ");
      Matcher match = GPS_PATTERN.matcher(field);
      if (!match.matches()) return false;
      String gps =  match.group(1);
      if (!gps.equals("+-1.00000 --1.00000")) super.parse(match.group(1), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      while (field.startsWith("U:")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" * ", " & ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("GPS")) return new MyGPSField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CH", "CHESTER",
      "ch", "CHESTER",
      "DH", "DURHAM",
      "dh", "DURHAM",
      "DR", "DEEP RIVER",
      "dr", "DEEP RIVER",
      "HD", "HADDAM",
      "hd", "HADDAM",
      "LY", "LYME",
      "ly", "LYME",
      "KW", "KILLINGWORTH",
      "kw", "KILLINGWORTH",
      "MD", "MIDDLETOWN",
      "md", "MIDDLETOWN",
      "OL", "OLD LYME",
      "ol", "OLD LYME",
      "OS", "OLD SAYBROOK",
      "os", "OLD SAYBROOK",
      "WB", "WESTBROOK",
      "wb", "WESTBROOK"
  });
}
