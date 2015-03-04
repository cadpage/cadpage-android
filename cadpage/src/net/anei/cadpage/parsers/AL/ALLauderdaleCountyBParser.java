package net.anei.cadpage.parsers.AL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Lauderdale County, AL
 */
public class ALLauderdaleCountyBParser extends FieldProgramParser {
  
  public ALLauderdaleCountyBParser() {
    super(ALLauderdaleCountyAParser.CITY_TABLE, "LAUDERDALE COUNTY", "AL",
        "Pri:SRC? Address:ADDR/S! Time:TIME! Cross_Streets:X! Event_Type:CALL! Re:INFO!");
    setBreakChar('-');
  }
  
  @Override
  public String getFilter() {
    return "@everbridge.net,89361";
  }
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("([A-Z]{2,3}\\d{8}) EV- +.*");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  // Address field must parse : @<place name> syntax
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional(": @");
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "/");
      field = stripFieldEnd(field, "/");
      super.parse(field, data);
    }
  }
  
  // INFO field may have cell phone # & GPS location
  private static final Pattern CELL_INFO_PTN = 
      Pattern.compile("^ALT# ([\\d\\-]+) ([+\\-]\\d+\\.\\d+ [+\\-]\\d+\\.\\d+), *");
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = CELL_INFO_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group(1);
        setGPSLoc(match.group(2), data);
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PHONE GPS INFO";
    }
  }
}
