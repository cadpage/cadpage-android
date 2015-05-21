package net.anei.cadpage.parsers.MT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MTMissoulaCountyParser extends FieldProgramParser {

  public MTMissoulaCountyParser() {
    super("MISSOULA COUNTY", "MT",
          "Call_Type:CALL! Address:ADDR/S6 Common_Name:PLACE! Assigned_Units:UNIT! Narrative:INFO");
  }
  
  @Override
  public String getFilter() {
    return "911@missoulaonthealert.com";
  }
  
  private static final Pattern MARKER = Pattern.compile("(\\d{4}), Call # (\\d+) +");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("911 Page")) return false;
    
    Matcher match = MARKER.matcher(body);
    if (!match.lookingAt()) return false;
    data.strSource = match.group(1);
    data.strCallId = match.group(2);
    body = body.substring(match.end());
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC ID " + super.getProgram();
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern PRESERVE_NUMBER_PTN = Pattern.compile(".* MM HWY");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.getLastOptional(',');
      field = p.get().replace('@', '&');
      super.parse(field, data);
      if (data.strApt.length() > 0 && PRESERVE_NUMBER_PTN.matcher(data.strAddress).matches()) {
        data.strAddress = data.strAddress + ' ' + data.strApt;
        data.strApt = "";
      }
      
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
}
