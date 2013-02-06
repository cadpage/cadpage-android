package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYNassauCountyDParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^([^\\*]*?)\\*\\*\\*([^\\*]+?)\\* \\* ");
  private static final Pattern DELIM = Pattern.compile(" \\*");
  
  public NYNassauCountyDParser() {
    super("NASSAU COUNTY", "NY",
           "PLACE ADDR! CS:X INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCall = append(match.group(2).trim(), " - ", match.group(1).trim());
    body = body.substring(match.end());
    return parseFields(DELIM.split(body), 2, data);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" UNITS ");
      if (pt >= 0) {
        String unit = field.substring(pt+7).trim();
        if (unit.endsWith(",")) unit = unit.substring(0,unit.length()-1).trim();
        data.strUnit = append(data.strUnit, ", ", unit);
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO UNIT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = BLVE_PTN.matcher(addr).replaceAll(" BLVD");
    addr = SWIM_PTN.matcher(addr).replaceAll(" ");
    return addr;
  }
  private static final Pattern BLVE_PTN = Pattern.compile(" +BLVE\\b");
  private static final Pattern SWIM_PTN = Pattern.compile(" +SWIM\\b");
  
}


