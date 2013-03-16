package net.anei.cadpage.parsers.OK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OKLoveCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^NEWOCC #OUTS  |^NEWINC #([-0-9]+) ");
  
  public OKLoveCountyParser() {
    this("LOVE COUNTY", "OK");
  }
  
  public OKLoveCountyParser(String defCity, String defState) {
    super(defCity, defState,
           "CALL! Address:ADDR! Reporting_Person:NAME! Phone:PHONE! Detail:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "Alert@loveco911.org,EnterpolAlerts@loveco911.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.startsWith("HISTORY FOR ")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = getOptGroup(match.group(1));
    body = body.substring(match.end()).trim();
    body = body.replace(", Phone:", "\nPhone:");
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

}
