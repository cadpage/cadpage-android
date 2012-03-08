package net.anei.cadpage.parsers.WI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Kenosha County, WI Village of Pleasant Prairie, Pleasant Prairie Fire & Rescue
Contact: David Wilkinson <dwilkinson@plprairiewi.com>
Sender: CAD@plprairiewi.com
System: Prophoenix

6245  CAD¡plprairiewi.com Subject:Phoenix Notification 2012000155 ä02/09/2012 03:24:52ñ MED CALL - Medical Callä1ñ 11623 28th Ave Units: 5641 Comments:
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000152 ä02/08/2012 16:54:48ñ MED CALL - Medical Callä1ñ 9500BLK 88th Ave Units: 5642 Comments
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000153 ä02/08/2012 17:47:01ñ FIRE STR - Fire - Structureä1ñ 8000 95th St Units: 5691 5641 56
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000154 ä02/08/2012 18:09:17ñ ELEV ALM - Elevator Alarmä1ñ 8330 82nd St,CMPLX Units: 5642 Comm
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000151 ä02/08/2012 07:18:41ñ MED CALL - Medical Callä1ñ 11831 120th Ct Units: 5642 Comments:
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000157 ä02/09/2012 18:43:23ñ MED CALL - Medical Callä1ñ 8109 57th Ave Units: 5641 Comments:
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000158 ä02/09/2012 18:53:48ñ MED CALL - Medical Callä1ñ 10106 29th Ave Units: 5642 Comments:

*/


public class WIKenoshaCountyBParser extends FieldProgramParser {
  
  private static final Pattern MASTER = 
    Pattern.compile("\\d+[: ] CAD¡plprairiewi.com Subject:Phoenix Notification (\\d+) ä(\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)ñ (.*)ä(\\d)ñ (.*)");
  
  public WIKenoshaCountyBParser() {
    super("KENOSHA COUNTY", "WI",
          "ADDR! Units:UNIT Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "CAD@plprairiewi.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    data.strDate = match.group(2);
    data.strTime = match.group(3);
    data.strCall = match.group(4).trim();
    data.strPriority = match.group(5);
    body = match.group(6).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID DATE TIME CALL PRI " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() +  " PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
