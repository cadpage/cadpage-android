package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;



public class VAPrinceWilliamCountyBParser extends VAPrinceWilliamCountyBaseParser {
  
  public VAPrinceWilliamCountyBParser() {
    super("Event_Type:CALL! Inc._Address:ADDR! Box_Number:BOX! Radio_Channel:CH! Command:CMD! Landing_Zone:LZ? Comments:INFO");
  }

  @Override
  public String getFilter() {
    return "@rsan.pwcgov.org,PWRSAN";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    int pt = body.indexOf("Sent by PW Alert to ");
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (!body.startsWith("Event Type:")) body = "Event Type: " + body;
    return parseFields(body.split("\n"), 5, data);
  }
  
  private static final Pattern PAREN_PTN = Pattern.compile("\\(.*\\)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(PAREN_PTN.matcher(field).replaceAll("").trim(), data);
    }
  }
  
  private class MyCommandField extends MyInfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("N/A")) return;
      super.parse("Cmd: " + field, data);
    }
  }
  
  
  private class MyLZField extends MyInfoField {
    @Override
    public void parse(String field, Data data) {
      super.parse("LZ: " + field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CMD")) return new MyCommandField();
    if (name.equals("LZ")) return new MyLZField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}