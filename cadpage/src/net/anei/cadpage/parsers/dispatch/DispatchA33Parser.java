package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA33Parser extends FieldProgramParser {

  private static final Pattern RUN_REPORT_PATTERN = Pattern.compile("Event No: (\\d{4}-\\d{8}) (Status: ([A-Za-z]+) .*)");
  private static final Pattern SRC_PLACE_PATTERN = Pattern.compile("(?:SERVICE +)?(\\d+)\\b.* Business\\b *(.*?)(?: Vehicle\\(s\\).*)?");
  
  private String closeStatus;

  public DispatchA33Parser(String defCity, String defState, String closeStatus) {
    super(defCity, defState, 
          "Event_No:ID! Status:SKIP! Disposition:SKIP! Category:CALL! Address:ADDR! Precinct:SKIP! Sector:MAP! GEO:SKIP! Ward:SKIP! Intersection:X? Date_/_Time_Open:DATETIME! Dispatch:DATETIME! Law_Enf.:SKIP! Enroute:SKIP! Fire:SKIP! Arrival:SKIP! EMS:SKIP! Closed:SKIP Source:SRC_PLACE! Incident_Notes:INFO!");
    this.closeStatus =  closeStatus;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    // delete event logs
    int ei = body.indexOf("\nEvent Log\n");
    if (ei < 0) return false;
    body = body.substring(0, ei).trim();

    // replace newlines with spaces
    body = body.replace("\n", " ");
    
    // detect and parse run reports, else continue    
    Matcher mat = RUN_REPORT_PATTERN.matcher(body);
    if (mat.matches() && mat.group(3).equals(closeStatus)) {
      data.strCall = "RUN REPORT";
      data.strCallId = mat.group(1);
      data.strPlace = mat.group(2);
      return true;
    }

    return super.parseMsg(body, data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}", true);
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("SRC_PLACE")) { return new BaseSrcPlaceField(); }
    if (name.equals("DATETIME")) { return new BaseDateTimeField(); }
    return super.getField(name);
  }

  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" Complaint Numbers ");
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }

  private class BaseAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (city.length() == 0 || city.length() == 2) {
        if (!city.equals(data.defState)) data.strState = city;
        city = p.getLastOptional(',');
      }
      super.parse(p.get(), data);
      data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY ST";
    }
  }
  
  private class BaseDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      else super.parse(field, data);
    }
  }

  private class BaseSrcPlaceField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher mat = SRC_PLACE_PATTERN.matcher(field);
      if (mat.matches()) {
        data.strSource = mat.group(1);
        data.strPlace = mat.group(2).trim();
      } else abort();
    }

    @Override
    public String getFieldNames() {
      return "SRC PLACE";
    }
  }
}
