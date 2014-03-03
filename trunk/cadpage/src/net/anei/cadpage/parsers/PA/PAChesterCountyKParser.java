/*
Chester County, PA
*/

package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyKParser extends PAChesterCountyBaseParser{

  public PAChesterCountyKParser() {
    super("TIME CALL ADDR ( CITY | PLACE_PHONE ) COUNTY_PLACE BOX! INFO+");
  }

  @Override
  public String getFilter() {
    return "ADI64@norco.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (body.endsWith("*")) body = body + ' ';
    return parseFields(body.split(" \\*\\* ", -1), 6, data);
  }

  @Override
  protected void parseAddressA7(String sAddr, Data data) {
    if (sAddr.endsWith("(NV")) sAddr = sAddr.substring(0, sAddr.length()-3).trim();
    super.parseAddressA7(sAddr, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("COUNTY_PLACE")) return new MyCountyPlaceField();
    return super.getField(name);
  }
  
  private class MyCountyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      
      // We still haven't figured this field out.  But it does
      // (Sometimes) indicate a location in Montgomery County
      if (field.equals("MONT") || field.equals("MONTC")) {
        if (data.strCity.length() == 0) data.strCity = "MONTGOMERY COUNTY";
        return;
      }
      super.parse(field, data);
    }
  }
  
}
