package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA57Parser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\n|(?=Call Type:|Common Name:|Additional Location Info:|Status:|District:|Beat:)");
  
  public DispatchA57Parser(String defCity, String defState) {
    super(defCity, defState,
          "Call_Time:DATETIME! Call_Type:CALL! Address:ADDRCITY! Common_Name:PLACE! City:CITY Closest_Intersection:X! Additional_Location_Info:INFO! Assigned_Units:UNIT! Priority:PRI! Status:SKIP! Quadrant:MAP! District:MAP! Beat:MAP! Primary_Incident:ID! Radio_Channel:CH Narrative:INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return super.parseFields(DELIM.split(body), 13, data);
  };
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "/", field);
    }
  }
  
  private static final Pattern INFO_CH_PTN = Pattern.compile("TAC\\d+");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (INFO_CH_PTN.matcher(field).matches()) {
        data.strChannel = append(data.strChannel, "/", field);
      } else {
        data.strSupp = append(data.strSupp, "\n", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CH INFO";
    }
  }
}
