package net.anei.cadpage.parsers.IL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;


/**
 * Madison County, IL
 */
public class ILMadisonCountyParser extends FieldProgramParser {
  
  public ILMadisonCountyParser() {
    super("MADISON COUNTY", "IL", 
          "SKIP ( EMPTY CALL EMPTY ( ADDRCITY EMPTY PLACE EMPTY APT EMPTY X | PLACE EMPTY ADDRCITY EMPTY ( PHONE | APT ) ) EMPTY INFO EMPTY ID EMPTY! ( URL EMPTY! | ) " + 
               "| CALL EMPTY ADDRCITY EMPTY EMPTY EMPTY X EMPTY EMPTY EMPTY INFO EMPTY DATETIME EMPTY NAME EMPTY PHONE! ) TIMES+");
  }
  
  @Override
  public String getFilter() {
    return "@glen-carbon.il.us,@co.madison.il.us,@troypolice.us";
  }
  
  String timeInfo;

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Automatic R&R Notification:")) return false;
    timeInfo = "";
    if (!parseFields(body.split("\n"), data)) return false;
    if (data.msgType == MsgType.RUN_REPORT) {
      data.strSupp = append(timeInfo, "\n", data.strSupp);
    }
    
    // Remove duplidate apt
    if (data.strApt.length() > 0) {
      data.strAddress = stripFieldEnd(data.strAddress, ' ' + data.strApt);
    }
    return true;
  }
  
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("URL")) return new SkipField("http://.*", true);
    if (name.equals("DATETIME")) return new DateTimeField(DATE_TIME_FMT, true);
    if (name.equals("PHONE")) return new MyPhoneField();
    if (name.equals("TIMES")) return new MyTimesField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_PHONE_PTN = Pattern.compile("(.*) (\\d{10})");
  private class MyAddressCityField extends AddressField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.equals("<UNKNOWN>")) {
        boolean good = false;
        int pt = field.lastIndexOf(',');
        if (pt >= 0) {
          good = true;
          data.strCity = field.substring(pt+1).trim();
          field = field.substring(0,pt).trim();
        }
        Matcher match = ADDR_PHONE_PTN.matcher(field);
        if (match.matches()) {
          good = true;
          field = match.group(1).trim();
          data.strPhone = match.group(2);
        }
        field = field.replace('@', '&');
        if (!good && !isValidAddress(field)) return false;
      }
      super.parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PHONE CITY";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("<UNKNOWN>")) return;
      super.parse(field, data);
    }
  }
  
  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals(data.strApt)) return;
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("No Cross Streets Found")) return;
      super.parse(field, data);
    }
  }
  
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("[") || !field.endsWith("]")) abort();
      field = field.replace("[", "").replace("]", "");
      super.parse(field, data);
    }
  }
  
  private class MyPhoneField extends PhoneField {
    
    public MyPhoneField() {
      super("\\d{10}");
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern DISPATCH_TIME_PTN =  Pattern.compile("Dispatched at: (\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M)\\b.*");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyTimesField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (field.startsWith("Unit:")) {
        data.strUnit = append(data.strUnit, " ", field.substring(5).trim());
        timeInfo = append(timeInfo, "\n", field);
        return;
      }
      Matcher match = DISPATCH_TIME_PTN.matcher(field);
      if (match.matches()) {
        data.strDate = match.group(1);
        setTime(TIME_FMT, match.group(2), data);
      }
      if (field.indexOf("Cleared at:") >= 0) data.msgType = MsgType.RUN_REPORT;
      field = "  " + field.replace("\t", "\n  ");
      timeInfo = append(timeInfo, "\n", field);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT DATE TIME INFO";
    }
  }
}
