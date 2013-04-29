package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYNassauCountyHParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*\\*");
  private static final Pattern TRAIL_BRACKET_PTN = Pattern.compile(" *<\\d+>$");
  
  public NYNassauCountyHParser() {
    super("NASSAU COUNTY", "NY",
           "CALL PLACENAME ADDR! CS:X? TOA:TIMEDATE!");
  }
  
  @Override
  public String getFilter() {
    return "scmbackup@verizon.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("** ")) return false;
    body = body.substring(3).trim().replace('\n', ' ');
    body = TRAIL_BRACKET_PTN.matcher(body).replaceFirst("");
    return parseFields(DELIM.split(body), data);
    
  }
  
  private class MyTimeDateField extends TimeDateField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('-', '/');
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIMEDATE")) return new MyTimeDateField();
    return super.getField(name);
  }
}
