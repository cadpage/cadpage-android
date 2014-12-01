package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAPennStarParser extends FieldProgramParser {
  
  private static final Pattern PTN_CALL_ID = Pattern.compile("^([0-9]{2}-[0-9]{2}-[0-9]+): +");
  
  public PAPennStarParser() {
    super("", "PA", 
          "UNIT ( ADDR_GPS ADDR_GPS ADDR_DIST? ADDR_DEG CALL! APT? | CALL! ADDR CITY ST ) To:INFO");
  }
  
  @Override
  public String getLocName() {
    return "PENNSTAR, PA";
  }
  
  @Override 
  public String getFilter() {
    return "mail@ghds.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Extract the Call ID (ex: 23-13-21515:), ':' is always the delimiter for this field
    Matcher match = PTN_CALL_ID.matcher(body);
    if(!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    String saveBody = body;
    
    if (body.startsWith("(STANDBY)")) {
      data.strCall = body.substring(0,9);
      body = body.substring(9).trim();
    }
    
    if (parseFields(body.split(","), 3, data)) {
      setGPSLoc(data.strAddress, data);
      if (data.strState.equals("PA")) data.strState = "";
    }
    
    else {
      String id = data.strCallId;
      data.parseGeneralAlert(this, saveBody);
      data.strCallId = id;
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR_GPS")) return new MyAddressField("[NSEW]\\d+ \\d+\\.\\d+", " ");
    if (name.equals("ADDR_DIST")) return new MyAddressField("\\d+\\.\\d+ nm", ", ");
    if (name.equals("ADDR_DEG")) return new MyAddressField("\\d+(?:\\.\\d+)? deg", ", ");
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("APT")) return new AptField(".{1,3}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }    
  
  private class MyAddressField extends AddressField {
    
    private String connect;
    
    public MyAddressField(String pattern, String connect) {
      setPattern(pattern, true);
      this.connect = connect;
    }
    
   @Override
   public void parse(String field, Data data) {
     data.strAddress = append(data.strAddress, connect, field);
   }
   
   @Override
   public String getFieldNames() {
     return "ADDR GPS";
   }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " ", field);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      super.parse("To: " + field, data);
    }
  }
}
