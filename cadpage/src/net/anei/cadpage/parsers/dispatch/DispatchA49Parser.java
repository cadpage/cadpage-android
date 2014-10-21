package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Lafayette Parish, LA
*/

public class DispatchA49Parser extends FieldProgramParser {

  public DispatchA49Parser(String defCity, String defState) {
    super(defCity, defState, 
        "DATE_TIME_SRC! Addr:ADDR! Cross:X? Inc_Type:CODE! REMARKS! EXTRA+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n+"), 5, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE_TIME_SRC")) return new MyDateTimeSourceField();
    if (name.equals("REMARKS")) return new MyRemarkField();
    if (name.equals("EXTRA")) return new MyExtraField();
    return super.getField(name);
  }

  private static final Pattern DATE_TIME_SRC_PTN = Pattern.compile("Date:(\\d\\d/\\d\\d/\\d{4}) Time:(\\d\\d:\\d\\d)(?:EQPT:(\\d+)| Num:(\\d+))");
  private class MyDateTimeSourceField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_SRC_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strSource = getOptGroup(match.group(3));
      data.strCallId = getOptGroup(match.group(4));
    }

    @Override
    public String getFieldNames() {
      return "DATE TIME SRC ID";
    }
  }
  
  private static final Pattern REMARK_PTN = Pattern.compile("Remarks >RPT#< (\\d\\d-\\d{8})");
  private class MyRemarkField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("Remarks:")) return;
      Matcher match = REMARK_PTN.matcher(field);
      if (!match.matches()) abort();
      super.parse(match.group(1), data);
    }
  }

  private static final Pattern EXTRA_TIME_OP_PTN = Pattern.compile("(.*) \\d{4},\\d{3}");
  private static final Pattern EXTRA_CALL_PTN = Pattern.compile("F>>IC< *(.*?)(?: \\d{6})?");
  private static final Pattern EXTRA_PHONE_PTN = Pattern.compile("(?:\\d{3})?\\d{7}");
  private static final Pattern EXTRA_GPS_PTN = Pattern.compile("\\bLat=([-+]\\d+\\.\\d{4,}) Long=([-+]\\d+\\.\\d{4,})\\b");
  private class MyExtraField extends Field {
    @Override
    public void parse(String field, Data data) {
      
      Matcher match = EXTRA_CALL_PTN.matcher(field);
      if (match.matches()) {
        data.strCall = append(data.strCall, " / ", match.group(1));
        return;
      }
      
      match = EXTRA_TIME_OP_PTN.matcher(field);
      if (match.matches()) field = match.group(1).trim();
      field = stripFieldStart(field, "F>");
      
      if (EXTRA_PHONE_PTN.matcher(field).matches()) {
        data.strPhone = field;
        return;
      }
      
      match = EXTRA_GPS_PTN.matcher(field);
      if (match.find()) {
        setGPSLoc(match.group(1) + ',' + match.group(2), data);
      }
      
      data.strSupp = append(data.strSupp, "\n", field);
    }

    @Override
    public String getFieldNames() {
      return "CALL PHONE INFO GPS";
    }
  }
}
