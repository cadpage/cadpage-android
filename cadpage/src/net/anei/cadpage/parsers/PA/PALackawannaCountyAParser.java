package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PALackawannaCountyAParser extends FieldProgramParser {
  
  public PALackawannaCountyAParser() {
    super("LACKAWANNA COUNTY", "PA",
           "Location:ADDR/SXx! Common_Name:PLACE? Call_Type:CALL! Call_Time:DATETIME Narrative:INFO Quadrant:MAP District:SKIP Nature_Of_Call:INFO");
  }
  
  @Override
  public String getFilter() {
    return "aegispage@lackawannacounty.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("Call Type:", " Call Type:").replace(" Narrative ", " Narrative: ");
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
