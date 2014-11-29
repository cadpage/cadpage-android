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
    super("COLUMBIA COUNTY", "PA",
          "( SELECT/1 Loc:ADDR! Rcvd:TIME! Units:ID! Comments:INFO! " +
          "| U:UNIT? E:ID! ET:CALL! ST:CALL! P:PRI! LOC:ADDR! MAP:MAP! T:TIME! A:UNIT! D:UNIT! N:NAME! PH:PHONE! S:SKIP! C:INFO! )");
  }

  private static Pattern GEN_ALERT_PTN = Pattern.compile("The Event ([^ ]+) has changed:.*");
  private static Pattern CALL_UNIT_MAP_PTN = Pattern.compile("([A-Z]+) ([A-Z0-9]+) \\((\\d{0,3})\\) +(?=Loc:)");
  
  private boolean runReport;

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    runReport = subject.startsWith("Times - ") || subject.startsWith("Notification - ");
    Matcher mat = CALL_UNIT_MAP_PTN.matcher(body);
    if (mat.lookingAt()) {
      select = "1";
      data.strCall = mat.group(1);
      data.strUnit = mat.group(2).trim();
      data.strMap = mat.group(3);
      if (!parseMsg(body.substring(mat.end()), data)) return false;
      checkRunReport(body, data);
      return true;
    }

     if ((mat = GEN_ALERT_PTN.matcher(body)).matches()) {
      data.strCall = "GENERAL ALERT";
      data.strCallId = mat.group(1);
      data.strPlace = body;
      return true;
    }
    select = "2";
    if (!super.parseFields(body.split(","), data)) return false;
    checkRunReport(body, data);
    return true;
  }
  
  @Override
  public String getProgram() {
    String result = super.getProgram();
    if (select.equals("1")) result = "CALL UNIT MAP " + result;
    return result;
  }
  
  private void checkRunReport(String body, Data data) {
    if (runReport) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strAddress = data.strApt = data.strCity = data.strCross = 
          data.strMap = data.strPriority = data.strName = data.strPhone = 
          data.strSupp = ""; 
    }
  }

  private String select = "";
  
  @Override
  protected String getSelectValue() {
    return select;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PRI")) return new PriorityField("\\d?", true); 
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

    
  private class MyIdField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      
      // Split field by blanks.  All but the last piece are regular units
      Parser p = new Parser(field);
      while (true) {
        String unit = p.getOptional(' ');
        if (unit.length() == 0) break;
        addUnit(unit, data);
      }
      field = p.get();
      
      // They combine primary unit and the call ID in the call ID field.
      // Splitting them out is tricky because number of digits in both 
      // fields is variable.  The key identifier is that the call ID
      // starts with the current year, so that is what we will check for
      Calendar cal = new GregorianCalendar();
      cal.setTime(new Date());
      int year = cal.get(Calendar.YEAR);
      int p1 = field.indexOf(Integer.toString(year));
      int p2 = field.indexOf(Integer.toString(year-1));
      int brk = (p2 < 0 ? p1 : p1 < 0 ? p2 : Math.min(p1, p2));
      if (brk > 0) {
        addUnit(field.substring(0,brk), data);
        data.strCallId = field.substring(brk);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT ID";
    }
  }

  private class MyUnitField extends UnitField {

    @Override
    public void parse(String field, Data data) {
      addUnit(field, data);
    }
  }

  private static Pattern NON_ASCII = Pattern.compile("[^ -~]");

  private class MyCallField extends CallField {

    @Override
    public void parse(String field, Data data) {
      // remove non ASCII characters from call
      field = NON_ASCII.matcher(field).replaceAll("");
      data.strCall = append(data.strCall, " - ", field);
    }
  }

  private static Pattern CITY_PATTERN = Pattern.compile("(.*?) *(?:(?:\\[|:) *(.*?)(?: BORO)?\\]?)?");

  private class MyAddressField extends Field {

    @Override
    public void parse(String field, Data data) {
      // never run into this before, but apparently if matches() isn't called
      // before group(), matcher throws exception.
      Matcher mat = CITY_PATTERN.matcher(field);
      if (!mat.matches()) abort();
      data.strAddress = mat.group(1);
      data.strCity = getOptGroup(mat.group(2));
      if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY";
    }
  }

  private static Pattern DATE_TIME_UNIT_PTN = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{2}:\\d{2}:\\d{2}) '?([A-Z0-9_]+) : ([A-Z]+).*");

  private class MyInfoField extends Field {

    @Override
    public void parse(String field, Data data) {
      for (String part : field.split("\n")) {
        part = part.trim();
        Matcher mat = DATE_TIME_UNIT_PTN.matcher(part);
        if (mat.matches()) {
          if (data.strTime.length() == 0) {
            data.strDate = mat.group(1);
            data.strTime = mat.group(2);
          }
          addUnit(mat.group(3), data);
          if (mat.group(4).equals("AVAIL")) runReport = true;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME UNIT INFO";
    }
  }
  
  /**
   * Add new unit to unit fields if it is not already present
   * @param unit new unit
   * @param data data object
   */
  private static void addUnit(String unit, Data data) {
    Pattern ptn = Pattern.compile("\\b" + unit + "\\b");
    if (ptn.matcher(data.strUnit).find()) return;
    data.strUnit = append(data.strUnit, " ", unit);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return addr.replace("TWO AND ONE HALF", "2 1/2");
  }
}