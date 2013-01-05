package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHFranklinParser extends FieldProgramParser {
  
  public OHFranklinParser() {
    super(CITY_LIST, "FRANKLIN", "OH",
           "CALL! LOCATION:ADDR/S! BETWEEN:X? COMMENTS:INFO");
  }
  
  @Override
  public String getFilter() {
    return "@cmsg.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD|!") && !isPositiveId()) return false;
    body = body.replace(" BETWEEN ", " BETWEEN: ");
    return super.parseMsg(body, data);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN",
    "FRANKLIN TWP"
  };
}
