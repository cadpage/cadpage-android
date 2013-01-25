package net.anei.cadpage.parsers.IN;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
 * Hamilton County, IN (variant A)
 */
public class INHamiltonCountyAParser extends FieldProgramParser {
 
  public INHamiltonCountyAParser() {
    super("HAMILTON COUNTY", "IN",
           "Unit:SKIP? Status:DISPATCHED? Location:ADDR/SXa! Quad:MAP! Units:UNIT! Type:CALL Narr:INFO CFS:ID Coord:GPS Venue:CITY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@hamiltoncounty.in.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
 
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CADPage")) return false;
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) data.strCall = "ALERT";
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      field = field.replaceAll("  +", " ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DISPATCHED")) return new SkipField("Dispatched", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
