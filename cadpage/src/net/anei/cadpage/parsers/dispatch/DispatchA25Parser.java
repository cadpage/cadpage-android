package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA25Parser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_ID_PTN = Pattern.compile(" INC #(\\d+-\\d+) ");
  private static final Pattern MARKER = Pattern.compile("^NEWOCC #OUTS  |^NEWINC #([-0-9]+) ");
  
  public DispatchA25Parser(String defCity, String defState) {
    super(defCity, defState,
           "CALL! CALL2+? Address:ADDR! Reporting_Person:NAME! Phone:PHONE% Detail:INFO%");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.startsWith("HISTORY FOR ")) {
      Matcher match = RUN_REPORT_ID_PTN.matcher(subject);
      if (match.find()) data.strCallId = match.group(1);
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = getOptGroup(match.group(1));
    body = body.substring(match.end()).trim();
    body = body.replace(", Phone", "\n Phone");
    return super.parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern CALL_PTN = Pattern.compile("([-A-Z0-9]+) - (.*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCode = match.group(1);
      data.strCall = match.group(2).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class MyCall2Field extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!data.strCall.endsWith("-")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " ", field);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.getLastOptional(',');
      if (data.strCity.length() == 0) data.strCity = p.getLastOptional(" - ");
      data.strPlace = p.getOptional(" - ");
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames() + " CITY";
    }
  }
  
  private class MyNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0 && ", Phone:".startsWith(field.substring(pt))) {
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("CALL2")) return new MyCall2Field();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
  }

}
