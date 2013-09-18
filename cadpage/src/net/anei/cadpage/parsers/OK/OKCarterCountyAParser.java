package net.anei.cadpage.parsers.OK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OKCarterCountyAParser extends FieldProgramParser {

  private static final Pattern RUN_REPORT_PATTERN = Pattern.compile("Event No: (\\d{4}-\\d{8}) Status: X Disposition: CLSD +(.*)");
  private static final Pattern SRC_PLACE_PATTERN = Pattern.compile("(?:SERVICE +)?(\\d+)\\b.* Business\\b *(.*)");

  public OKCarterCountyAParser() {
    super("ARDMORE", "OK", "Event_No:ID! Status:SKIP! Disposition:SKIP! Category:CALL! Address:ADDR! Precinct:SKIP! Sector:MAP! GEO:SKIP! Ward:SKIP! Intersection:X? Date_/_Time_Open:DATETIME! Dispatch:DATETIME! Law_Enf.:SKIP! Enroute:SKIP! Fire:SKIP! Arrival:SKIP! EMS:SKIP! Closed:SKIP! Source:SRC_PLACE! Incident_Notes:INFO!");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    // delete event logs
    int ei = body.indexOf("\nEvent Log\n");
    if (ei < 0) return false;
    else body = body.substring(0, ei).trim();

    // replace newlines with spaces
    body = body.replace("\n", " ");
    
    // detect and parse run reports, else continue    
    Matcher mat = RUN_REPORT_PATTERN.matcher(body);
    if (mat.matches()) {
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
    if (name.equals("SRC_PLACE")) { return new SrcPlaceField(); }
    if (name.equals("DATETIME")) { return new MyDateTimeField(); }
    return super.getField(name);
  }

  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      else super.parse(field, data);
    }
  }

  private class SrcPlaceField extends Field {
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
