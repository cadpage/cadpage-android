package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;
import net.anei.cadpage.parsers.HtmlDecoder;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DispatchBCParser extends DispatchA3Parser {
  private HtmlDecoder decoder = new HtmlDecoder();
  
  public DispatchBCParser(String defCity, String defState) {
    super(defCity, defState,
          "Event_No:EMPTY! ID! Status:EMPTY! Disposition:EMPTY! Category:EMPTY! CALL! " +
          "( Complaint_Numbers%EMPTY! Unit:EMPTY! UNIT Reporting_DSN:EMPTY Agency:EMPTY SRC | ) " +
          "Address:EMPTY! ADDR Precinct:EMPTY! MAP Sector:EMPTY! MAP/D GEO:EMPTY! MAP/D ESZ:EMPTY! MAP/D Ward:EMPTY! MAP/D Intersection:EMPTY! X " +
          "Date_/_Time%EMPTY Open:EMPTY! DATETIME1? Law_Enf.:EMPTY! SRC Dispatch:EMPTY! DATETIME1? Fire:EMPTY! SRC Enroute:EMPTY! DATETIME2? EMS:EMPTY! SRC Arrival:EMPTY! DATETIME2? " +
          "Source:EMPTY! Departure:EMPTY! DATETIME3? Closed:EMPTY! DATETIME3? " + 
          "( Person(s)_Involved%EMPTY! Name_Address_Phone%EMPTY! NAME_PHONE Business%EMPTY! | ) " + 
          "Incident_Notes:EMPTY INFO+ Event_Log%EMPTY");
  }
  
  private static final Pattern BR_TAG = Pattern.compile("</?br/?>", Pattern.CASE_INSENSITIVE);
  
  private String times;

  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    
    // Inappropriate <br> tags get inserted in the wierdest places, so we 
    // will just get rid of them
    body = BR_TAG.matcher(body).replaceAll("");
    String[] flds = decoder.parseHtml(body);
    if (flds == null) return false;
    times = "";
    if (! parseFields(flds, data)) return false;
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("DATETIME1")) return new BaseDateTimeField(1);
    if (name.equals("DATETIME2")) return new BaseDateTimeField(2);
    if (name.equals("DATETIME3")) return new BaseDateTimeField(3);
    if (name.equals("X")) return new BaseCrossField();
    if (name.equals("SRC")) return new BaseSourceField();
    if (name.equals("NAME_PHONE")) return new BaseNamePhoneField();
    if (name.equals("INFO")) return new BaseInfoField();
    return super.getField(name);
  }
  
  private static final Pattern DIGIT_PATTERN = Pattern.compile("([A-Z0-9]*\\d[A-Z0-9]*) / (.*)");
  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = DIGIT_PATTERN.matcher(field);
      if (m.matches()) {
        data.strCode = m.group(1);
        data.strCall = m.group(2).trim();
      }
      else
        data.strCall = field.trim();
    }
    
    @Override
    public String getFieldNames() {
      return "CALL CODE";
    }
  }
  
  private static final Pattern STATE_CODE_PTN = Pattern.compile("[A-Z]{2}");
  private class BaseAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (STATE_CODE_PTN.matcher(city).matches()) {
        data.strState = city;
        city = p.getLastOptional(',');
      }
      data.strCity = city;
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY ST";
    }
  }
  
  private class BaseDateTimeField extends DateTimeField {
    private int type;
    
    public BaseDateTimeField(int type) {
      super("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d|", true);
      this.type = type;
    }
    
    @Override
    public void parse(String field, Data data) {
      String title = getRelativeField(-1);
      String line = append(title, "   ", field);
      times = append(times, "\n", line);
      if (field.length() == 0) return;
      if (type == 1) {
        super.parse(field, data);
      } else if (type == 3) {
        data.msgType = MsgType.RUN_REPORT;
      }
    }
  }
  
  private static final Pattern CROSS_DIR_PTN = Pattern.compile("[NSEW]/?B");
  private class BaseCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (CROSS_DIR_PTN.matcher(field).matches()) {
        data.strAddress = append(data.strAddress, " ", field.replace("/", ""));
      }
      else {
        super.parse(field, data);
      }
    }
  }
  
  private class BaseSourceField extends SourceField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(' ', '_');
      data.strSource = append(data.strSource, ",", field);
    }
  }
  
  private static final Pattern PHONE_PATTERN
    = Pattern.compile("(.*?)((?:\\(\\d{3}\\) ?)?\\d{3}\\-\\d{4}.*)");
  private class BaseNamePhoneField extends NameField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = PHONE_PATTERN.matcher(field);
      if (m.matches()) {
        data.strName = m.group(1).trim();
        data.strPhone = m.group(2).trim();
      }
      else {
        data.strName = field.trim();
      }
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  private static final Pattern INFO_DASHES_PTN = Pattern.compile("-*");
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (INFO_DASHES_PTN.matcher(field).matches()) return;
      data.strSupp = append(data.strSupp, " ", field);
    }
  }
}
