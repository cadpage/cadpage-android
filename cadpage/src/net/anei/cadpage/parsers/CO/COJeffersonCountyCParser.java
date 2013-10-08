package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Jefferson County, CO
 */
public class COJeffersonCountyCParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("Alarm #(\\d*\\-\\d*)");
  private static final Pattern UPDATE_PTN = Pattern.compile("Address UPDATE:(.*(?=Apt UPDATE:))Apt UPDATE:(.*)");
  
  public COJeffersonCountyCParser() {
    super("JEFFERSON COUNTY", "CO",
        "Add:ADDR! Apt:APT? ( Type:CALL! | Typ:CALL! ) Units:UNIT! Alarm:ID");
   }

  @Override
  public String getFilter() {
    return "@co.jefferson.co.us";
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Information")) return false;
    
    Matcher matchAlarm = RUN_REPORT_PTN.matcher(body);
    if (matchAlarm.find()){
      data.strCall = "RUN REPORT";
      data.strCallId = matchAlarm.group(1);
      data.strPlace = body.substring(matchAlarm.end()).trim();
      return true;
    }
    
    Matcher matchUpdate = UPDATE_PTN.matcher(body);
    if (matchUpdate.find()){
      data.strCall = "ADDRESS UPDATE";
      data.strAddress = matchUpdate.group(1).trim();
      data.strApt = matchUpdate.group(2).trim();
      return true;
    }
    body = body.replace("Alarm#", " Alarm:");
    return super.parseMsg(body, data);
  }
  
  private class MyCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.trim();
      int spaceIndex = field.indexOf(' ');
      if (spaceIndex < 0) {
        data.strCall = field;
      } else {
        data.strCall = field.substring(0, spaceIndex);
        field = field.substring(spaceIndex).trim();
        if (field.startsWith("Map ")) field = field.substring(4).trim();
        data.strMap = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL MAP";
    }
  }
  

  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
}