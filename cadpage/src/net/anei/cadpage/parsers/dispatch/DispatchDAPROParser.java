package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchDAPROParser extends FieldProgramParser {
  
  private static final String PROGRAM_STR = "ADDR/SCa! CFS:ID! Run:ID? CROSS:X";
  
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+");

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
    
    int pt = body.indexOf(" CFS# ");
    if (pt < 0) return false;
    pt += 4;
    body = body.substring(0,pt) + ':' + body.substring(pt+1);
    if (body.startsWith("MAILBOX:")) body = body.substring(8).trim();
    body = body.replace(" Run# ", " Run: ");
    
    if (! super.parseMsg(body, data)) return false;
    data.strAddress = LEAD_ZERO_PTN.matcher(data.strAddress).replaceFirst("").trim();
    return true;
  }
  
  @Override 
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }

  private static final Pattern TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d) ");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      // First token is always the source
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strSource = field.substring(0,pt);
      field = field.substring(pt+1).trim();
      
      // Might be followed by a dispatch time
      Matcher match = TIME_PTN.matcher(field);
      if (match.find()) {
        data.strTime = match.group(1);
        field = field.substring(match.end()).trim();
      }
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "SRC TIME CALL ADDR APT CITY";
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("((?:\\d{4}-)?\\d{6}),? *(.*)");
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      data.strSupp = match.group(2);
    }
  }
}
