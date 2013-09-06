package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA25Parser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_ID_PTN = Pattern.compile(" INC #(\\d+-\\d+) ");
  private static final Pattern RUN_REPORT_PTN2 = Pattern.compile("^OCC #\\d\\d-\\d+, INC #(\\d\\d-\\d+)");
  private static final Pattern MARKER = Pattern.compile("^NEWOCC #OUTS  +|^NEWINC #([-0-9]+) +");
  private static final Pattern MISSING_DELIM = Pattern.compile(",? (?=Phone:)");
  private static final Pattern ALTERNATE_PTN = Pattern.compile("NEW (.*)[-,] ([ A-Za-z]+)");
  
  public DispatchA25Parser(String defCity, String defState) {
    super(defCity, defState,
           "CALL! CALL2+? Address:ADDR! Reporting_Person:NAME Phone:PHONE% Detail:INFO%");
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
    
    Matcher match = RUN_REPORT_PTN2.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    match = MARKER.matcher(body);
    if (match.find()) {
      data.strCallId = getOptGroup(match.group(1));
      body = body.substring(match.end());
      body = MISSING_DELIM.matcher(body).replaceFirst("\n");
      return super.parseFields(body.split("\n"), data);
    }
    
    match = ALTERNATE_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("CALL ADDR APT CITY");
      String addr = match.group(1).trim();
      data.strCity = match.group(2).trim();
      int pt = addr.indexOf(" - ");
      if (pt >= 0) {
        data.strCall = addr.substring(0,pt).trim();
        parseAddress(addr.substring(pt+3).trim(), data);
        return true;
      }
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, addr, data);
      return (data.strAddress.length() > 0);
    }
    return false;
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
      String addr = p.get();
      String apt = "";
      if (addr.endsWith(")")) {
        int pt = addr.indexOf('(');
        if (pt >= 0) {
          apt = addr.substring(pt+1, addr.length()-1).trim();
          addr = addr.substring(0,pt).trim();
        }
      }
      parseAddress(addr, data);
      data.strApt = append(data.strApt, "-", apt);
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
