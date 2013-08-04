package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MOPhelpsCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Incident# : ([A-Z0-9]+) For Activity (Dispatch|Finish) Resource");
 
  public MOPhelpsCountyParser() {
    super("PHELPS COUNTY", "MO",
           "Case#:SKIP! Julian_Incident#:ID! Priority:PRI Agency_Type:SKIP! Alarm_Level:SKIP! receive_Source:SKIP! Primary_Officer:SKIP! Agency_Code:SRC! CFS:CODE! CFS_Description:CALL! Location:ADDR! Common_Place:PLACE! Cross_Streets:X! Zone:MAP! Area_Of_Responsibility:SKIP! Juris:SKIP! Municipality:CITY! Disposition:SKIP! Incident_Recv_DateTime:DATETIME! Dispatch_DateTime:SKIP! Arrive_DateTime:SKIP! Finish/Clear_DateTime:SKIP! Contain_DateTime:SKIP Comment_DateTime:SKIP Origin_ID:SKIP Comment:INFO INFO+?");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    if (match.group(2).equals("Finish")) {
      data.strCall = "RUN REPORT";
      data.strCallId = match.group(1);
      data.strPlace = body;
      return true;
    }
    
    body = body.replace(":-", ":");
    return parseFields(body.split("\n"), data);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("----")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    return PVTNNNN_PTN.matcher(address).replaceAll("PVT DRIVE $1");
  }
  private static final Pattern PVTNNNN_PTN = Pattern.compile("\\b(?:PVT|PRIVATE DR) *(\\d+)\\b", Pattern.CASE_INSENSITIVE);
}