package net.anei.cadpage.parsers.OR;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ORJosephineCountyParser extends FieldProgramParser {
  
  public ORJosephineCountyParser() {
    super("JOSEPHINE COUNTY", "OR",
          "CALL ADDRCITY DATETIME ID UNIT! INFO");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@Pacific.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! subject.equals("!")) return false;
    return parseFields(body.split(": "), 5, data);
  }
  
  private static final Pattern INTERSECT_MARKER = Pattern.compile(" *@ *");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      field = INTERSECT_MARKER.matcher(field).replaceAll(" & ");
      super.parse(field, data);
    }
  }
  
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
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
      field = field.replaceAll("\\s+", " ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ID")) return new IdField("\\d+", true);
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
