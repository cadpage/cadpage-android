package net.anei.cadpage.parsers.OR;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ORJosephineCountyParser extends FieldProgramParser {
  
  private static final Pattern LAT_LON_PTN = Pattern.compile("\\bLAT: *([-+]?[\\d\\.]+),? +LON: *([-+]?[\\d\\.]+)\\b");
  private static final Pattern LAT_LON_PTN2 = Pattern.compile("\\bLAT:([-+]?[\\d\\.]+) LON:([-+]?[\\d\\.]+)\\b");
  private static final Pattern DELIM = Pattern.compile("\n|: |(?<=[AP]M):");
  
  private static final Pattern UNITS_PTN = Pattern.compile("Units: +");
  
  public ORJosephineCountyParser() {
    super("JOSEPHINE COUNTY", "OR",
          "( ID CALL ADDRCITY/SXa PLACE SRC DATETIME! UNIT | DATE_TIME_CALL ADDR_CITY_X/SXa! Units:UNIT | CALL ADDRCITY/SXa PLACE DATETIME ID! UNIT ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@Pacific.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! subject.trim().equals("!")) return false;
    body = LAT_LON_PTN.matcher(body).replaceAll("LAT:$1 LON:$2");
    body = UNITS_PTN.matcher(body).replaceFirst("Units:");
    if (!parseFields(DELIM.split(body), data)) return false;
    data.strAddress = LAT_LON_PTN2.matcher(data.strAddress).replaceFirst("LAT: $1, LON: $2");
    return true;
  }
  
  private static final Pattern DATE_TIME_PREFIX_PTN = Pattern.compile("^(\\d\\d?/\\d\\d?/\\d{4} +\\d\\d?:\\d\\d:\\d\\d? [AP]M) +");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  private class MyDateTimeCallField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      Matcher match = DATE_TIME_PREFIX_PTN.matcher(field);
      if (!match.find()) return false;
      
      setTime(DATE_TIME_FMT, match.group(1), data);
      field = field.substring(match.end());
      super.parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME CALL";
    }
  }
  
  private class MyAddressCityCrossField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get(',').replace('@', '&'), data);
      data.strCity = p.get("  ");
      data.strCross = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY X";
    }
  }
  
  private static final Pattern INTERSECT_MARKER = Pattern.compile(" *@ *");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      field = INTERSECT_MARKER.matcher(field).replaceAll(" & ");
      super.parse(field, data);
    }
  }
  
  private class MyDateTimeField extends DateTimeField {
    public MyDateTimeField() {
      setPattern("\\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{2}:\\d{2} [AP]M", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      setDateTime(DATE_TIME_FMT, field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE_TIME_CALL")) return new MyDateTimeCallField();
    if (name.equals("ADDR_CITY_X")) return new MyAddressCityCrossField();
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ID")) return new IdField("\\d+|ODF", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  @Override
  public String adjustMapAddress(String address) {
    // There is a street named JUMP OFF JOE CREED RD that trips the OFF mapping logic
    return address.replace("JUMP OFF", "JUMP0OFF");
  }

  @Override
  public String postAdjustMapAddress(String address) {
    return address.replace("JUMP0OFF", "JUMP OFF");
  }
}
