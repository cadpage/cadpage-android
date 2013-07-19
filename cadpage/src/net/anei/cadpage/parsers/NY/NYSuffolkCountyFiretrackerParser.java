package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYSuffolkCountyFiretrackerParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\*\\* ?([A-Z ]+) ?\\*\\* \\[([- A-Z0-9]+)\\] ");
  
  public NYSuffolkCountyFiretrackerParser() {
    super(CITY_LIST, "SUFFOLK COUNTY", "NY", 
           "ADDR/S! C/S:X? TOA:TIME? Add't_Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@firetracker.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("FirePage")) return false;
    body = body.replace('\n', ' ');
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1).trim();
    data.strCall = match.group(2).trim();
    body = body.substring(match.end()).trim();
    
    int pt = body.lastIndexOf('[');
    if (pt >= 0 && "[FireTracker]".startsWith(body.substring(pt))) {
      body = body.substring(0,pt).trim();
    }

    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC CALL " + super.getProgram();
  }
  
  private static final Pattern DATE_PTN = Pattern.compile(" +(\\d\\d?/\\d\\d?/\\d{4})$");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_PTN.matcher(field);
      if (match.find()) {
        data.strDate = match.group(1);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " DATE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "MASTIC BEACH",
    "SHIRLEY",
    "SMITH POINT"
  };
}
