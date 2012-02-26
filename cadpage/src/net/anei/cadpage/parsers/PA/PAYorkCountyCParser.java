package net.anei.cadpage.parsers.PA;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
York County, PA
Contact: "Freistat, Brandon" <brandon.freistat@fairviewfire.net>
Sender: messaging@iamresponding.com

(Station 68) : 203 LOCUST DR \n  FAIRVIEW TWP\n  \nLONGVIEW AVE / PLEASANT VIEW RD\nDistrict: 68-02\n\n    FIRE STRUCT RESID\nUnits Sent: 2\nFIRESTA68, 52-03
(Station 68) : 378 PLEASANT VIEW RD \n  FAIRVIEW TWP\n  \nGURTNER RD / LANE\nDistrict: 68-02\n\n    FIRE STRUCT RESID\nUnits Sent: 2\nFIRESTA68, 52-12 \n\n   
(Station 68) : 6000 LEWISBERRY RD \nAdditional Location Information:BLK\n  CONEWAGO TWP\n  \nBREMER RD / ANDERSONTOWN RD\nCOPENHAFFER RD\nDistrict: 26-09

*/

public class PAYorkCountyCParser extends FieldProgramParser {
  
  public PAYorkCountyCParser() {
    super("YORK COUNTY", "PA",
           "ADDR PLACE? CITY! INFO X+ District:MAP! CALL+ Units_Sent:SKIP UNIT");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Station ")) return false;
    data.strSource = subject;
    if (!body.startsWith(": ")) return false;
    body = body.substring(2).trim();
    String[] flds = body.split("\n");
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final String PLACE_LABEL = "Additional Location Information:";
  private class MyPlaceField extends PlaceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith(PLACE_LABEL)) return false;
      field = field.substring(PLACE_LABEL.length()).trim();
      return super.checkParse(field, data);
    }
  }
  @Override
  protected Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
}
