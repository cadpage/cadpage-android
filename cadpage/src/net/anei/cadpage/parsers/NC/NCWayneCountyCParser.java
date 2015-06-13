package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCWayneCountyCParser extends HtmlProgramParser {
  
  public NCWayneCountyCParser() {
    super("WAYNE COUNTY", "NC",
          "RESPONSE! Sequence_Number:ID! Status:SKIP! Response_Type:CALL! Handling_Unit:UNIT! Address:ADDR");
  }
  
  @Override
  public String getFilter() {
    return "waynecounty911@waynegov.com";
  }
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    if (!subject.equals("Notification")) return false;
    return super.parseHtmlMsg(subject, body, data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("RESPONSE")) return new SkipField("Response", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    
  }
}
