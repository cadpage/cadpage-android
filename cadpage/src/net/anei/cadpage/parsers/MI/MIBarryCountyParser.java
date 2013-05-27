package net.anei.cadpage.parsers.MI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MIBarryCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN =  Pattern.compile("CAD Page for CFS (\\d{6}-\\d{2})");
  
  public MIBarryCountyParser() {
    super("BARRY COUNTY", "MI",
          "CALL_ADDR TIME! INFO+");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class CallAddressField extends AddressField {
    @Override 
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt < 0) abort();
      data.strCall = field.substring(0,pt).trim();
      super.parse(field.substring(pt+1).trim(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL ADDR APT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL_ADDR")) return new CallAddressField();
    return super.getField(name);
  }
}
