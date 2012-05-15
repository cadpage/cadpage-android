package net.anei.cadpage.parsers.RI;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Washington County, RI
Contact: Patrick Hawkins <forestryfire302@gmail.com>
Sender: cad_do_not_reply@westerlyambulance.org

(CAD Notification) 2012/05/13 15:25:39\n10 CEDAR HILLS DR\nNO NAME\nRICHMOND\nEMERGENCY\n\nNotes\n71 FEMALE, FALL IN PAIN.  CALL FROM 303
(CAD Notification) 2012/05/13 10:11:03\n825 MAIN ST APT C105\nNO NAME\nHOPKINTON\nEMERGENCY\n\nNotes\nMEDICAL ALARM, NO RESPONSE
(CAD Notification) 2012/05/13 04:41:24\n307 CHURCH ST A\nNO NAME\nRICHMOND\nEMERGENCY\n\nNotes\n86 Y/O F. FALL VICTIM
(CAD Notification) 2012/05/13 02:27:03\n807 MAIN ST APT B5\nNO NAME\nHOPKINTON\nEMERGENCY\n\nNotes\n80 Y/O F. DEYDRATION AND WEAK
(CAD Notification) 2012/05/12 13:32:27\n2 @95 N\n@95 NORTH AT EXIT 2 (@95)\nHOPKINTON\nMVA\n\nAssigned Units\nAMB_313 RESP HOT\n\nNotes\nNORTH OF EXIT
(CAD Notification) 2012/05/12 01:41:45\n31 COLUMBIA HTS OVAL\nNO NAME\nCHARLESTOWN\nEMERGENCY\n\nNotes\nDISORIENTED MAN
(CAD Notification) 2012/05/12 16:26:30\n54 NOOSENECK HILL RD\nRI STATE POLICE (NOOSENECK HILL RD)\nRICHMOND\nEMERGENCY\n\nNotes\nEYE INJURY FROM PRE

*/

public class RIWashingtonCountyParser extends FieldProgramParser {
 
  public RIWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "RI",
           "DATETIME ADDR PLACE CITY CALL EMPTY ( ASGN_UNIT UNIT EMPTY | ) NOTES INFO!");
  }
  
  @Override
  public String getFilter() {
    return "cad_do_not_reply@westerlyambulance.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD Notification")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() != 19) abort();
      data.strDate = field.substring(5,10) + "/" + field.substring(0,4);
      data.strTime = field.substring(11);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field.replace('@', 'I'), data);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("NO NAME")) return;
      field = field.replace('@', 'I');
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("EMPTY")) return new SkipField("", true);
    if (name.equals("ASGN_UNIT")) return new SkipField("Assigned Units", true);
    if (name.equals("NOTES")) return new SkipField("Notes", true);
    return super.getField(name);
  }
  
  
}
