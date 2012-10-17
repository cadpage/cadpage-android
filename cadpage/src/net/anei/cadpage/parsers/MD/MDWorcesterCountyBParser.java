package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MDWorcesterCountyBParser extends FieldProgramParser {
  
  public MDWorcesterCountyBParser() {
    super(MDWorcesterCountyParser.CITY_LIST, "WORCESTER COUNTY", "MD",
           "CALL PLACE ADDR/S");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] parts = subject.split("\\|");
    if (parts.length != 2 && !parts[0].equals("Chief ALT")) return false;
    data.strSource =  parts[1].trim();
    
    if (!body.startsWith("-- ")) return false;
    body = body.substring(3).trim();
    return parseFields(body.split(" -- "), data);
  }
  
  private static final Pattern STATE_ZIP_PTN = Pattern.compile(" ([A-Z]{2}), \\d{5}$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = STATE_ZIP_PTN.matcher(field);
      if (!match.find()) abort();
      data.strState = match.group(1);
      if (data.strState.equals("MD")) data.strState = "";
      field = field.substring(0,match.start()).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
