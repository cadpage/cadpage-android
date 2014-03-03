package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchDAPROParser extends FieldProgramParser {
  
  private static final String PROGRAM_STR = "ADDR/SCXa! CFS:ID? INFO:INFO? Run:ID? CROSS:X";
  
  private static final Pattern MARKER = Pattern.compile("^([-A-Z0-9]+) +(?:(\\d\\d:\\d\\d) +)?");


  public DispatchDAPROParser(String defCity, String defState) {
    super(defCity, defState, PROGRAM_STR);
  }
  
  public DispatchDAPROParser(Properties cityCodeTable, String defCity, String defState) {
    super(cityCodeTable, defCity, defState, PROGRAM_STR);
  }
  
  public DispatchDAPROParser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, PROGRAM_STR);
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    boolean mark =  body.startsWith("MAILBOX:");
    if (mark) body = body.substring(8).trim();
    String alertBody = body;
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) {
      if (!mark) return false;
      data.strCall = "GENERAL ALERT";
      data.strPlace = alertBody;
      return true;
    }
    data.strSource = match.group(1);
    data.strTime = getOptGroup(match.group(2));
    body = body.substring(match.end());
    
    int pt = body.indexOf(" CFS# ");
    if (pt >= 0) {
      pt += 4;
      body = body.substring(0,pt) + ':' + body.substring(pt+1);
    } else if ((pt = body.indexOf(" - ")) >= 0) {
      body = body.substring(0,pt) + " INFO:" + body.substring(pt+3);
    } else if (mark) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = alertBody;
      data.strSource = "";
      return true;
    } else return false;
    
    body = body.replace(" Run# ", " Run: ");
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC TIME " + super.getProgram();
  }
  
  @Override 
  public Field getField(String name) {
    if (name.equals("ID")) return new BaseIdField();
    if (name.equals("X")) return new BaseCrossField();
    return super.getField(name);
  }
  
  private static final Pattern ID_PTN = Pattern.compile("((?:\\d{4}-)?\\d{6}),? *(.*)");
  private class BaseIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      data.strSupp = match.group(2);
    }
  }
  
  private class BaseCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "/");
      super.parse(field, data);
    }
  }
}
