package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PALackawannaCountyAParser extends FieldProgramParser {
  
  public PALackawannaCountyAParser() {
    super("LACKAWANNA COUNTY", "PA",
           "Location:ADDR/SXx! Common_Name:PLACE? Call_Type:CALL! Call_Time:DATETIME Nature_of_Call:INFO CFS_Number:ID");
  }
  
  @Override
  public String getFilter() {
    return "aegispage@lackawannacounty.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    body = body.replace("Call Type:", " Call Type:").replaceAll(" CFS Number ", " CFS Number: ").replace('\n', ' ');

    return super.parseMsg(body, data);
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("0 ")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
}
