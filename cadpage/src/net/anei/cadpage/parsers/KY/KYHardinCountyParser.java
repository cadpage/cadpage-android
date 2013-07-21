package net.anei.cadpage.parsers.KY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class KYHardinCountyParser extends FieldProgramParser {
  
  public KYHardinCountyParser() {
    super("HARDIN COUNTY", "KY",
          "Incident:ID! Nature:CALL! Address:ADDR! Cross:X Timeout:DATETIME! Info:INFO+");
  }
  
  @Override
  public String getFilter() {
    return "noreply@hckysar.appspotmail.com";
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Incident:")) return false;
    body = subject + '\n' + body;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      
      // See if they added a  "1" house number to what should be an intersection
      if (data.strAddress.startsWith("1 ") && data.strAddress.contains("&")) {
        data.strAddress = data.strAddress.substring(2).trim();
      }
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("[A-Z][a-z]{2} ([A-Z][a-z]{2} \\d\\d \\d\\d:\\d\\d:\\d\\d) UTC (\\d{4})");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MMM dd HH:mm:ss yyyy");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      
      // The field contains a UTC time zone indicator, but it lies
      // Time is really relative to local time zone
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      setDateTime(DATE_TIME_FMT, match.group(1) + ' ' + match.group(2), data);
    }
  }
  
  private static final Pattern INFO_SKIP_PTN = Pattern.compile(" *\\[\\d\\d[\\d[A-Z]/: ]*\\]?$|^(?:\\d\\d:\\d\\d:\\d\\d )?[A-Z]*\\] *|^\\d\\d:\\d\\d:\\d\\d *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = INFO_SKIP_PTN.matcher(field).replaceAll(" ").trim();
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
