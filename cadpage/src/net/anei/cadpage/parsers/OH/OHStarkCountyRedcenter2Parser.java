package net.anei.cadpage.parsers.OH;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class OHStarkCountyRedcenter2Parser extends FieldProgramParser {
  
  public OHStarkCountyRedcenter2Parser() {
    super("STARK COUNTY", "OH", 
          "( Call:CALL! Date/Time:DATETIME1! Address:ADDRCITY! Place:PLACE! Crosses:X! Section:MAP? Run_Num:ID! Unit:SKIP? Alert:INFO1! Info:INFO1! Map:TIMES1+ " +
          "| Call_Address:ADDRCITY! Radio_Channel:CH! Common_Name:PLACE! Qualifier:EMPTY! Cross_Streets:X Local_Information:INFO! Custom_Layer:EMPTY! Census_Tract:EMPTY! Call_Type:CALL! Call_Priority:PRI! Nature_Of_Call:CALL/SDS! Units_Assigned:UNIT! Fire_Quadrant:MAP! Incident_Number(s):ID! Caller_Name:NAME! Caller_Phone:PHONE! Caller_Address:CADDR! Alerts:SKIP! Narratives:INFO1! Status_Times:TIMES1+ Google_Maps_Hyperlink:SKIP " +
          "| CALL:CALL! PLACE:PLACE! ADDR:ADDRCITY! ( ID:ID! DATE:DATETIME1! MAP:MAP! UNIT:SKIP! INFO:INFO1! TIMES1+ " +
                                                   "| CITY:CITY! ID:ID! PRI:PRI! DATE:DATE! TIME:TIME! UNIT:UNIT? INFO:INFO ) )");
  }
  
  @Override
  public String getFilter() {
    return "NWS@starksheriff.org,mbusto@redcenter.us,dispatch@neo-comm.org,cad@neo-comm.org";
  }

  String unit;
  String times;
  
  private static final Pattern JUNK_BRK_PTN = Pattern.compile("\n~ *\n|, *\n");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    unit = null;
    times = "";
    body = JUNK_BRK_PTN.matcher(body).replaceAll("\n");
    if (!parseFields(body.split("\n"), data)) return false;
    if (data.msgType == MsgType.RUN_REPORT) data.strSupp = append(times, "\n", data.strSupp);
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME1")) return new MyDateTime1Field();
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("INFO1")) return new MyInfo1Field();
    if (name.equals("TIMES1")) return new MyTimes1Field();
    if (name.equals("CADDR")) return new MyCallerAddressField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME1_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M);?");
  private static final DateFormat TIME_FMT1 = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTime1Field extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME1_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      setTime(TIME_FMT1, match.group(2), data);
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("\\[ *([- 0-9]+?) *\\]");
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      for (String part : field.split(",")) {
        part = part.trim();
        Matcher match = ID_PTN.matcher(part);
        if (match.matches()) {
          data.strCallId = append(data.strCallId, "/", match.group(1));
        }
      }
    }
  }
  
  private class MyInfo1Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("[","").replace("]","");
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }

  private class MyTimes1Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Unit:")) {
        unit = field.substring(5).trim();
        data.strUnit = append(data.strUnit, " ", unit);
        return;
      }
      if (unit == null) return;
      if (field.length() == 0) return;
      if (field.startsWith("Cleared at:")) data.msgType = MsgType.RUN_REPORT;
      field = unit + "  " + field;
      times = append(times, "\n", field);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT INFO";
    }
  }
  
  private class MyCallerAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (data.strAddress.length() > 0) return;
      super.parse(field, data);
    }
  }
}
