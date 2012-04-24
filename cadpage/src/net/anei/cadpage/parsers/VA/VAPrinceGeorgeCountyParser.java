package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/***
Prince George County, VA
Contact: Kevin Hamel <khamel30@gmail.com>, 8047217263@vtext.com
Sender: cad@messages.princegeorgeva.org

388:CAD:FIRE AUTOMATIC AID - DINWIDDIE;SPAIN DR/OAK GROVE
386:CAD:ACCIDENT ENTRAPMENT-OVERTURNED;38 I95 S;CARS
384:CAD:FIRE WIRE/POWER LINES DOWN;13499 S CRATER RD/GARYS CHURCH RD;PETE
380:CAD:FIRE AUTOMATIC AID - DINWIDDIE;27317 REAMS DR
379:CAD:ACCIDENT UNKNOWN INJURY;20000-BLK S CRATER RD;OFFRAMP I95 S;HALIFAX RD;CARS
377:CAD:ACCIDENT ENTRAPMENT-OVERTURNED;20000 ROWANTY RD;ROWANTY CT;INDIAN SWAMP LN;CARS
376:CAD:EMS-SICK;16702 S CRATER RD;PRINCE GEORGE DR;PRINCE GEORGE DR;PETE
375:CAD:ACCIDENT UNKNOWN INJURY;42 I95 S;I295 S;PETE
369:CAD:FIRE ALARM;2643 LANSING RD;INDIAN RD;TEMPLETON RD;PETE
368:CAD:FIRE CARBON MONOXIDE/SMOKE DET;714 JOHNS RD;S CRATER RD;OAK HILL CT;CARS
366:CAD:ACCIDENT - COMMERICAL VEHICLE;16699 S CRATER RD/PRINCE GEORGE DR;PETE

Contact: "joeclary@yahoo.com" <joeclary@yahoo.com>
Sender: CAD@messages.princegeorgeva.org
1108:CAD:ACCIDENT UNKNOWN INJURY;43 I95 N;PETE

***/

public class VAPrinceGeorgeCountyParser extends DispatchOSSIParser {
 
  public VAPrinceGeorgeCountyParser() {
    super(CITY_CODES, "PRINCE GEORGE COUNTY", "VA",
           "ID: CALL ADDR! X/Z+? CITY");
  }
  
  @Override
  public String getFilter() {
    return "cad@messages.princegeorgeva.org";
  }

  private static final String AUTO_AID_PFX = "FIRE AUTOMATIC AID - ";
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(AUTO_AID_PFX)) {
        data.strCity = field.substring(AUTO_AID_PFX.length()).trim();
        field = field.substring(0,AUTO_AID_PFX.length()-3).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }

  private static final Properties CITY_CODES= buildCodeTable(new String[]{
      "CARS", "CARSON",
      "PETE", "PETERSBURG"
  });
}
