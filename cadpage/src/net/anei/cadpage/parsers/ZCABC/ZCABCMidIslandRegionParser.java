package net.anei.cadpage.parsers.ZCABC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ZCABCMidIslandRegionParser extends FieldProgramParser {
  
  private static final Pattern SRC_PTN = Pattern.compile("(BEAVER CREEK|CAMPBELL RIVER|CHERRY CREEK|COMOX|COURTENAY|CUMBERLAND|DENMAN ISLAND|OYSTER RIVER|PT ALBERNI|SPROAT LAKE) *(.*)");
  private static final Pattern GPS_PTN = Pattern.compile("\\(?([-+]?[\\d:\\.]+),([-+]?[\\d:\\.]+)\\)");

  public ZCABCMidIslandRegionParser() {
    this("", "BC");
  }
  
  public ZCABCMidIslandRegionParser(String defCity, String defState) {
    super(defCity, defState, "CALL? ADDR/ZSC CITY DATETIME!");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "INLAND ISLAND",
        "MIRACLE BEACH");
  }
  
  @Override
  public String getFilter() {
    return "paging@ni911.ca";
  }
  
  @Override
  public String getLocName() {
    return "Mid-Island Region, BC";
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!subject.equals("Fire Dispatch")) return false;

    // Strip off leading source name
    Matcher match = SRC_PTN.matcher(body);
    if (match.matches()) {
      data.strSource = match.group(1);
      body = match.group(2);
    }
    
    // Clean the body of any email text
    int newLine = body.indexOf('\n');
    if(newLine >= 0) {
      body = body.substring(0, newLine);
    }
    
    // GPS coordinates contain a comma which must be escaped
    body = GPS_PTN.matcher(body).replaceAll("($1|$2)");
    
    String[] fields = body.split(",");
    return parseFields(fields, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }

  private static final Pattern ADDR_GPS_PTN = Pattern.compile("(.*?) *(\\([^\\)A-Z]+\\))");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_GPS_PTN.matcher(field);
      if (match.matches()) {
        data.strCall = append(data.strCall, " / ", match.group(1));
        data.strAddress = match.group(2).replace('|', ',');
      }

      else if(data.strCall.length() > 0) {
        parseAddress(field, data);
      }
      else {
        super.parse(field, data);
      }
    }
  }
  
  private class MyDateTimeField extends DateTimeField {
    
    @Override 
    public boolean checkParse(String field, Data data) {
      if(field.startsWith("BC")) {
        field = field.substring(2).trim();
        String[] dateTime = field.split(" ");
        
        // Check the first element to see if it is a date or a time
        if(dateTime[0].contains("/")) {
          data.strDate = dateTime[0];
        }
        else {
          data.strTime = dateTime[0];
        }
        
        // If we have two elements, the second is always time
        if(dateTime.length > 1) {
          data.strTime = dateTime[1];
        }
        
        return true;
      }
      else {
        return false;
      }
    }
    
    @Override
    public void parse(String field, Data data) {
      if(!checkParse(field, data)) super.abort();
    }
    
    @Override 
    public boolean canFail() {
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ALARMS",
      "BEACH/BRUSH/MISC OUT EMERG",
      "CHIMNEY FIRE",
      "ALARMS",
      "BEACH/BRUSH/MISC OUT EMERG",
      "CHIMNEY FIRE",
      "DUTY OFFICER",
      "FIRST ALARM - C",
      "FIRST RESP ASSIST D/E",
      "FIRST RESP D",
      "FIRST RESP DELAY B/C",
      "FIRST RESP E",
      "MOTOR VEHICLE ACCIDENT",
      "MVI PED STRUCK",
      "STRUCTURE FIRE",
      "STRUCTURE ODOUR",
      "STRUCTURE SMOKE",
      "DUTY OFFICER",
      "FIRST ALARM - A",
      "FIRST ALARM - B",
      "FIRST ALARM - C",
      "FIRST RESP ASSIST D/E",
      "FIRST RESP ASSIST",
      "FIRST RESP A",
      "FIRST RESP B",
      "FIRST RESP C",
      "FIRST RESP D",
      "FIRST RESP DELAY B/C",
      "FIRST RESP DELAY D/E",
      "FIRST RESP E",
      "HYDRO TROUBLE",
      "MARINE",
      "MOTOR VEHICLE ACCIDENT",
      "MOTOR VEHICLE FIRE",
      "MVI / EXTRICATION",
      "MVI PED STRUCK",
      "RESCUE LOW ANGLE/BCAS ASSIST",
      "RESCUE ROAD",
      "STRUCTURE FIRE",
      "STRUCTURE ODOUR",
      "STRUCTURE SMOKE",
      "TEST"
  );
}
