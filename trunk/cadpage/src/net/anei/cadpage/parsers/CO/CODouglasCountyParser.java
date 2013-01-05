package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CODouglasCountyParser extends FieldProgramParser {
  
  private static final Pattern TRAIL_ID_PTN = Pattern.compile(" +(\\d{4}-\\d{8})$");

  public CODouglasCountyParser() {
    this("DOUGLAS COUNTY", "CO");
  }
  
  protected CODouglasCountyParser(String defCity, String defState) {
    super(defCity, defState,
           "Call:CALL! Location:ADDR! Map:MAP Units:UNIT! Common_Name:PLACE Time:DATETIME Narrative:INFO? Nature_Of_Call:INFO");
  }
  
  @Override
  public String getAliasCode() {
    return "CODouglasCounty";
  }
  
  @Override
  public String getFilter() {
    return "@notifyall.com,@notifyatonce.com,dcso@douglas.co.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatch")) return false;
    Matcher match = TRAIL_ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(0,match.start());
    }
    body = body.replace("Time: ", " Time: ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " ID";
  }
  
  // Address field should strip  trailing slash characters
  // and a trailing operations channel
  private static final Pattern OPS_PTN = Pattern.compile("\\bEOPS\\d$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = OPS_PTN.matcher(field);
      if (match.find()) {
        data.strChannel = match.group();
        field = field.substring(0,match.start()).trim();
      }
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CH";
    }
  }
  
  // Unit field also contains cross field
  private class MyUnitField extends UnitField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get("  "), data);
      data.strCross = p.get();
      if (data.strCross.equals("No Cross Streets Found")) data.strCross = "";
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT X";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(data.strAddress)) {
        field = field.substring(0,field.length()-data.strAddress.length()).trim();
      }
      super.parse(field, data);
    }
  }
  
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 14) super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("E911 Info - ", "");
      if (data.strChannel.length() > 0 && field.startsWith(data.strChannel)) {
        field = field.substring(data.strChannel.length()).trim();
      }
      super.parse(field, data);
    }
  }
  
  
  @Override
  public Field getField(String  name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
