package net.anei.cadpage.parsers.PA;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAColumbiaCountyParser extends FieldProgramParser {

  public PAColumbiaCountyParser() {
    super("COLUMBIA COUNTY", "PA", "U:UNIT! E:ID! ET:CALL! ST:CALL! P:PRI! LOC:ADDR! MAP:MAP! T:TIME! A:UNIT! D:UNIT! N:NAME! PH:PHONE! S:SKIP! C:DATETIME!");
  }

  private static Pattern RUN_REPORT_PTN = Pattern.compile(".*Units: ([A-Z0-9_]+) ([A-Z0-9_]+) *(.*)", Pattern.DOTALL);
  private static Pattern GEN_ALERT_PTN = Pattern.compile("The Event ([^ ]+) has changed:.*");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.startsWith("Alarm -") || subject.startsWith("Notification -")) {
      setFieldList("UNIT ID");
      Matcher rrMat = RUN_REPORT_PTN.matcher(body);
      if (!rrMat.matches()) return false;
      data.strUnit = rrMat.group(1);
      data.strCallId = rrMat.group(2);
      data.strPlace = body;
      data.strCall = "RUN REPORT";
    }

    else {
      Matcher mat = GEN_ALERT_PTN.matcher(body);
      if (mat.matches()) {
        data.strCall = "GENERAL ALERT";
        data.strCallId = mat.group(1);
        data.strPlace = body;
      }
      
      else if (!super.parseFields(body.split(","), data)) return false;
    }
    
    // The combine primary unit and the call ID in the call ID field.
    // Splitting them out is tricky because number of digits in both 
    // fields is variable.  The key identifier is that the call ID
    // starts with the current year, so that is what we will check for
    String callId = data.strCallId;
    Calendar cal = new GregorianCalendar();
    cal.setTime(new Date());
    int year = cal.get(Calendar.YEAR);
    int p1 = callId.indexOf(Integer.toString(year));
    int p2 = callId.indexOf(Integer.toString(year-1));
    int brk = (p2 < 0 ? p1 : p1 < 0 ? p2 : Math.min(p1, p2));
    if (brk > 0) {
      String unit = callId.substring(0,brk);
      data.strCallId = callId.substring(brk);
      if (!data.strUnit.contains(unit)) data.strUnit = append(data.strUnit, " ", unit);
    }
    return true;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PRI")) return new PriorityField("\\d?", true); 
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  private class MyUnitField extends UnitField {

    @Override
    public void parse(String field, Data data) {
      // if strUnit doesn't contain field, append it
      if (data.strUnit.contains(field)) return;
      data.strUnit = append(data.strUnit, " ", field);
    }

  }

  private static Pattern NON_ASCII = Pattern.compile("[^\\x00-\\x7F]");

  private class MyCallField extends CallField {

    @Override
    public void parse(String field, Data data) {
      // remove non ASCII characters from call
      field = NON_ASCII.matcher(field).replaceAll("");
      data.strCall = append(data.strCall, " - ", field);
    }

  }

  private static Pattern DATE_TIME = Pattern.compile("(?:(\\d{1,2}/\\d{1,2}/\\d{4} \\d{2}:\\d{2}:\\d{2}).*)?", Pattern.DOTALL);

  private class MyDateTimeField extends DateTimeField {

    @Override
    public void parse(String field, Data data) {
      // ignore if empty or doesn't match
      if (field.length() == 0) return;
      Matcher mat = DATE_TIME.matcher(field);
      if (!mat.matches()) abort();

      super.parse(getOptGroup(mat.group(1)), data);
    }

  }

  private static Pattern CITY_PATTERN = Pattern.compile("(.*?) *(?:(?:\\[|:) *(.*?)(?: BORO)?\\]?)?");

  private class MyAddressField extends Field {

    @Override
    public void parse(String field, Data data) {
      // never run into this before, but apparently if matches() isn't called
      // before group(), matcher throws exception.
      Matcher mat = CITY_PATTERN.matcher(field);
      if (!mat.matches()) return;
      data.strAddress = mat.group(1);
      data.strCity = getOptGroup(mat.group(2));
      if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY";
    }
  }
}