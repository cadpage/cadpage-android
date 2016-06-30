package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class DispatchSPKParser extends HtmlProgramParser {

  public DispatchSPKParser(String defCity, String defState) {
    this(null, defCity, defState);
  }

  public DispatchSPKParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState,
         "CURDATETIME! Incident_Information%EMPTY! CAD_Incident:ID? ( Event_Code:CALL! THRD_PRTY_INFO+? | Event_Code_Description:CALL! ) Priority:PRI? Incident_Disposition:SKIP? JUNK+? " + 
               "( Location:ADDRCITY! Intersection:SKIP? Community:CITY? Location_Information:PLACE? L/L:GPS? ( Cross_Street:EMPTY! X+? | ) Apartment:APT? Building:BLDG? ( Caller_information%EMPTY Caller_Source:SKIP? Caller_Phone:PHONE? Caller_Name:NAME? | ) " +  
               "| Location_Information:PLACE? Apartment:APT Building:BLDG ( Caller_information%EMPTY Caller_Source:SKIP? Caller_Phone:PHONE? Caller_Name:NAME? | ) Location:ADDRCITY! Intersection:SKIP? Community:CITY? ) INFO/N<+",
         "table|tr");
  }
  
  private boolean dispatchTime;
  private String times;
  private Set<String> unitSet = new HashSet<String>();
  
  private enum InfoType { CAD_TIMES, REMARKS, UNIT_INFO, UNIT_STATUS };
  private InfoType infoType;
  private int colNdx;
  
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    
    if (!subject.contains(" reaches status ") && 
        !subject.contains(" gets ") &&
        !subject.contains("has a Service Request status change")) return false;
    
    dispatchTime = false;
    times = null;
    unitSet.clear();
    infoType = null;
    colNdx = -1;
    if (!super.parseHtmlMsg(subject, body, data)) return false;
    if (data.msgType == MsgType.RUN_REPORT) data.strSupp = append(times, "\n", data.strSupp);
    unitSet.clear();
    return true;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("CURDATETIME")) return new BaseDateTimeField();
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{5,8}|\\d{8}-\\d{6}\\.\\d{3}|", true);
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("THRD_PRTY_INFO")) return new BaseThirdPartyInfoField();
    if (name.equals("JUNK")) return new SkipField("(?!Location:|Apartment:).*", true);
    if (name.equals("CITY")) return new BaseCityField();
    if (name.equals("X")) return new BaseCrossField();
    if (name.equals("BLDG")) return new BaseBuildingField();
    if (name.equals("INFO")) return new BaseInfoField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("As of (\\d\\d?/\\d\\d?/\\d\\d) (\\d\\d:\\d\\d:\\d\\d(?: [AP]M)?)");
  private class BaseDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = convertTime(match.group(2));
    }
  }
  
  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" - ");
      if (pt >= 0) {
        data.strCode = field.substring(0,pt).trim();
        field = field.substring(pt+3).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class BaseThirdPartyInfoField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      if (field.startsWith("3rd Party Complaint: Medical Complaint: ")) {
        data.strCall = field.substring(40).trim();
        return true;
      }
      
      if (field.startsWith("3rd Party Code: Dispatch Code: ")) {
        data.strCode = field.substring(31).trim();
        return true;
      }
      
      return false;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "CALL CODE";
    }
    
  }
  
  private class BaseCityField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() > 0) return;
      super.parse(field, data);
    }
  }
  
  private class BaseCrossField extends CrossField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.contains(":")) return false;
      if (field.equals("Caller information")) return false;
      if (field.equals("CAD Times")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      
      // Cross streets tend to be duplicated a lot :(
      if (field.length() == 0) return;
      if (data.strAddress.contains("&")) return;
      if (data.strAddress.contains(field)) return;
      if (data.strCross.contains(field)) return;
      super.parse(field, data);
    }
  }
  
  private class BaseBuildingField extends AptField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      data.strApt = append(data.strApt, " ", "Bldg:" + field);
    }
  }
  
  private static final Pattern TIMES_PTN = Pattern.compile("Call (.*?) Time: +(\\d\\d?/\\d\\d?/\\d\\d) +(\\d\\d?:\\d\\d:\\d\\d(?: [AP]M)?)");
  private static final Pattern INFO_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d\\d) +(\\d\\d?:\\d\\d:\\d\\d(?: [AP]M)?)");
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      // Special Html tag processing
      if (field.startsWith("<|") && field.endsWith("|>")) {
        if (field.equals("<|/table|>")) {
          infoType = InfoType.REMARKS;
          colNdx = -1;
        }
        else if (field.equals("<|tr|>")) {
          colNdx = 0;
        }
        return;
      }
      if (colNdx >= 0) colNdx++;
      
      
      if (field.equals("CAD Times") || field.equals("CAD Times:")) {
        infoType = InfoType.CAD_TIMES;
        if (times == null) times = field;
        else times = times + '\n' + field;
        return;
      }
      
      if (field.equals("Remarks/Narratives:") || field.equals("Notices:") || field.equals("Notes:") ||
          field.equals("EMS DISPATCH PROTOCOL:") || field.equals("Dispatch:")) {
        infoType = InfoType.REMARKS;
        return;
      }
      
      if (field.equals("Unit Information:")) {
        infoType = InfoType.UNIT_INFO;
        colNdx = -1;
        return;
      }
      
      if (field.equals("Unit Status:")) {
        infoType = InfoType.UNIT_STATUS;
        if (times == null) times = field;
        else times = times + '\n' + field;
        colNdx = -1;
        return;
      }
      
      if (field.startsWith("POI Information:") || field.equals("Priors:") || 
          field.equals("Case Numbers:") || field.equals("Incident Log:")) {
        infoType = null;
        return;
      }
      
      if (infoType == null) return;
      
      switch (infoType) {
      case CAD_TIMES:
        Matcher match = TIMES_PTN.matcher(field);
        if (match.matches()) {
          String type = match.group(1);
          if (!dispatchTime && type.equals("Dispatched")) {
            dispatchTime = true;
            data.strDate = match.group(2);
            data.strTime = convertTime(match.group(3));
          } else if (type.equals("Ready For Dispatch") || 
                     type.equals("Ready_for_dispatch") || 
                     type.equals("On Scene") ||
                     type.equals("Closed")) data.msgType = MsgType.RUN_REPORT;  
        }
        times = times + '\n' + field;
        return;
        
      case REMARKS:
        if (INFO_TIME_PTN.matcher(field).matches()) return;
        if (field.startsWith("Responding Units:")) {
          for (String unit : field.substring(17).split(",")) {
            addUnit(unit.trim(), data);
          }
        } else if (field.startsWith("Caller Name:")) {
          data.strName = field.substring(12).trim();
        } else if (field.startsWith("Problem:")) {
          field = field.substring(8).trim();
          if (data.strCall.equals("PRO QA IN PROGESS")) data.strCall = field;
          else data.strCall = append(data.strCall, " - ", field);
        } else if (field.startsWith("Callback:")) {
          data.strPhone = field.substring(9).trim();
        } else if (!field.equals("Number of patients: 1")) {
          super.parse(field, data);
        }
        return;
        
      case UNIT_INFO:
        if (colNdx != 1) return;
        if (!field.equals("Unit")) addUnit(field, data);
        return;
        
      case UNIT_STATUS:
        if (field.equals("Date/Time")) return;
        if (field.equals("Unit")) return;
        if (field.equals("Status")) return;
        if (field.equals("Unit Location/Remarks")) return;
        String delim = colNdx == 1 ? "\n" : "   ";
        times = times + delim + field;
        
        if (colNdx == 2) addUnit(field, data);
        
        if (!dispatchTime && field.equals("Dispatched")) {
          match = INFO_TIME_PTN.matcher(getRelativeField(-2));
          if (match.matches()) {
            dispatchTime = true;
            data.strDate = match.group(1);
            data.strTime = convertTime(match.group(2));
          }
        }
        
        if (field.equals("On Scene") || 
            field.equals("Available")) data.msgType = MsgType.RUN_REPORT;
        return;
      }
    }
    
    private void addUnit(String unit, Data data) {
      unit = unit.replace(' ', '_');
      if (unitSet.add(unit)) data.strUnit = append(data.strUnit, ",", unit);
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME INFO UNIT CALL NAME PHONE";
    }
  }
  
  private static String convertTime(String time) {
    if (time.endsWith("M")) {
      try {
        time = TIME_FMT2.format(TIME_FMT1.parse(time));
      } catch (ParseException ex) {
        throw new  RuntimeException(ex);
      }
    }
    return time;
  }
  private static final DateFormat TIME_FMT1 = new SimpleDateFormat("hh:mm:ss aa");
  private static final DateFormat TIME_FMT2 = new SimpleDateFormat("HH:mm:ss");
}
