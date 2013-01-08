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
  
  private static final Pattern MCVEAGH_PTN = Pattern.compile("\\bMC VEAGH\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      while (field.startsWith("U:")) field = field.substring(2).trim();
      field = MCVEAGH_PTN.matcher(field).replaceAll("MCVEAGH");
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
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AV", "AVON",
      "av", "AVON",
      "BA", "BETHANY",
      "ba", "BETHANY",
      "BE", "BERLIN",
      "be", "BERLIN",
      "BR", "BRANFORD",
      "br", "BRANFORD",
      "CH", "CHESTER",
      "ch", "CHESTER",
      "CL", "CLINTON",
      "cl", "CLINTON",
      "CO", "COLCHESTER",
      "co", "COLCHESTER",
      "CR", "CROMWELL",
      "cr", "CROMWELL",
      "CS", "CHESHIRE",
      "cs", "CHESHIRE",
      "DH", "DURHAM",
      "dh", "DURHAM",
      "DR", "DEEP RIVER",
      "dr", "DEEP RIVER",
      "EF", "EAST HARTFORD",
      "ef", "EAST HARTFORD",
      "EH", "EAST HADDAM",
      "eh", "EAST HADDAM",
      "EM", "EAST HAMPTON",
      "em", "EAST HAMPTON",
      "EV", "EAST HAVEN",
      "ev", "EAST HAVEN",
      "GL", "GLASTONBURY",
      "gl", "GLASTONBURY",
      "GR", "GROTON",
      "gr", "GROTON",
      "GU", "GUILFORD",
      "gu", "GUILFORD",
      "HD", "HADDAM",
      "hd", "HADDAM",
      "HE", "HEBRON",
      "he", "HEBRON",
      "HF", "HARTFORD",
      "hf", "HARTFORD",
      "HN", "HAMDEN",
      "hn", "HAMDEN",
      "KW", "KILLINGWORTH",
      "kw", "KILLINGWORTH",
      "LI", "LONG ISLAND",
      "li", "LONG ISLAND",
      "LY", "LYME",
      "ly", "LYME",
      "MA", "MADISON",
      "ma", "MADISON",
      "MB", "MARLBOROUGH",
      "mb", "MARLBOROUGH",
      "MD", "MIDDLETOWN",
      "md", "MIDDLETOWN",
      "ME", "MERIDEN",
      "me", "MERIDEN",
      "MF", "MIDDLEFIELD",
      "mf", "MIDDLEFIELD",
      "MI", "MIDDLEBURY",
      "mi", "MIDDLEBURY",
      "ML", "MILFORD",
      "ml", "MILFORD",
      "MV", "MONTVILLE",
      "mv", "MONTVILLE",
      "NB", "NEW BRANFORD",
      "nb", "NEW BRANFORD",
      "NE", "NEWINGTON",
      "ne", "NEWINGTON",
      "NH", "NEW HAVEN",
      "nh", "NEW HAVEN",
      "NK", "NORWALK",
      "nk", "NORWALK",
      "NL", "NEW LONDON",
      "nl", "NEW LONDON",
      "NO", "NORWICH",
      "no", "NORWICH",
      "NV", "NORTH HAVEN",
      "nv", "NORTH HAVEN",
      "NW", "NEW BRITAIN",
      "nw", "NEW BRITAIN",
      "NY", "NEW YORK CITY",
      "ny", "NEW YORK CITY",
      "OL", "OLD LYME",
      "ol", "OLD LYME",
      "OS", "OLD SAYBROOK",
      "os", "OLD SAYBROOK",
      "OR", "ORANGE",
      "or", "ORANGE",
      "PL", "PORTLAND",
      "pl", "PORTLAND",
      "RH", "ROCKY HILL",
      "rh", "ROCKY HILL",
      "SA", "SALEM",
      "sa", "SALEM",
      "SO", "SOUTHINGTON",
      "so", "SOUTHINGTON",
      "ST", "STONINGTON",
      "st", "STONINGTON",
      "SX", "ESSEX",
      "sx", "ESSEX",
      "WA", "WALLINGFORD",
      "wa", "WALLINGFORD",
      "WB", "WESTBROOK",
      "wb", "WESTBROOK",
      "WE", "WEATHERSFIELD",
      "we", "WEATHERSFIELD",
      "WF", "WATERFORD",
      "wf", "WATERFORD",
      "WH", "WEST HARTFORD",
      "wh", "WEST HARTFORD",
      "WO", "WOODBRIDGE",
      "wo", "WOODBRIDGE",
      "WP", "WESTPORT",
      "wp", "westport",
      "WT", "WATERBURY",
      "wt", "WATERBURY",
      "WV", "WEST HAVEN",
      "wv", "WEST HAVEN"
  });
}
