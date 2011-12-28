package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Xenia township, OH
Contact:  Brian Miller. Xtfd62@yahoo.com, 9376732333@messaging.sprintp

MBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common
FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit
FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name
FMBLS-MEDICAL Location: 721 KINSEY RD CRESTLINE DR / APOLLO DR XENIA TWP Time: 23:36 Units:  Common Name: I
FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name
FMBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common
CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI
FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit
CRPI Location: 413 CLIFTON RD LITTLE MIAMI SCENIC BIKE PATH / CLARK RUN RD XENIA TWP Time: 19:17 Units: E51
CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI
FMBLS-MEDICAL Location: 9 SEXTON DR OLD SPRINGFIELD PIKE / OLD SPRINGFIELD PIKE XENIA TWP Time: 21:28 Units
FACO-FIRE ALARM COMMERCIAL Location: 121 FAIRGROUND RD GREENE COUNTY FAIRGROUNDS / BEAVERCREEK LN XENIA TWP
FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 13:36 Units: M52  Common Na
FMALS-MEDIC AL Location: 3301 BONE RD UNKNOWN / E SPRING VALLEY PAINTERSVILLE RD CAESARCREEK TWP Time: 18:2
CRUI Location: E LIMESTONE ST XENIA AVE YELLOW SPRINGS Time: 18:42 Units: E82 HUSMA M51 CHF81  Common Name:
FMBLS-MEDICAL Location: 2960 W  ENON RD SR 235 / W HYDE RD XENIA TWP Time: 12:02 Units: M51  Common Name: G
FMBLS-MEDICAL Location: 2383 NEEDMORE RD No Cross Streets Found CAESARCREEK TWP Time: 17:05 Units: M52  Com
FMALS-MEDIC AL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 09:05 Units: M52 E52  Comm
FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:
FGRA-GRASS/FIELD Location: 55 CLIFTON RD US 68 N / LITTLE MIAMI SCENIC BIKE PATH XENIA TWP Time: 00:05 Unit
FSCE-SERVICE CALL-ENGINE Location: 8834 MICHAELA LN WARREN COUNTY Time: 20:41 Units: T51 T52  Common Name:
FMBLS-MEDICAL Location: 1541 SR 380 COUNTRY PLACE CT / RENAISSANCE WOOD CT XENIA TWP Time: 00:28 Units: M52
FMBLS-MEDICAL Location: 467 WILSON DR REGINA DR / MEADOW LN XENIA TWP Time: 23:39 Units:  Common Name: Info
FRES-RESIDENTIAL FIRE Location: 710 HAWKINS RD CREEKSIDE TRAIL BIKE PATH / FORD RD XENIA TWP Time: 20:51 Un
FMALS-MEDIC AL Location: 1264 BOYD RD DEAD END / US 68 S XENIA TWP Time: 21:25 Units: M52 E52  Common Name:
FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:

New Jasper Township
Contact: Greg Gould <gould1440@gmail.com>
Sender: psisn_dispatch@ci.xenia.oh.us
(Dispatch Info) FMBLS-MEDICAL Location: 738 BLACK FOOT TRL SHAWNEE TRL / ONEIDA TRL NEW JASPER TWP Time: 20:37 Units:  Common Name: Info:  Problem: LO
(Dispatch Info) FMALS-MEDIC AL Location: 3986 SHAWNEE TRL N LAKESHORE DR / NIAGARA TRL NEW JASPER TWP Time: 14:09 Units: M42 BR14  Common Name: Info:
(Dispatch Info) FMBLS-MEDICAL Location: 3811 WAYNESVILLE JAMESTOWN RD ST JOHN RD / MT CARMEL RD NEW JASPER TWP Time: 09:57 Units: M14 BR14  Common Nam
(Dispatch Info) CRUI Location: 3809 JASPER RD ST JOHN RD / APACHE TRL NEW JASPER TWP Time: 18:16 Units:  Common Name: Info:  W 2 PTS NON ER TO GMH  PO
(Dispatch Info) FMALS-MEDIC AL Location: 2136 E  HOOP RD GULTICE RD / COOPER LN NEW JASPER TWP Time: 06:21 Units: M14 BR14  Common Name: Info:  NOT RE

 */


public class OHXeniaParser extends FieldProgramParser {
  
  public OHXeniaParser() {
    super("GREENE COUNTY", "OH",
           "CALL Location:ADDR! Time:SKIP Units:UNIT Common_Name:NAME Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "psisn_dispatch@ci.xenia.oh.us";
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      parseAddress(StartType.START_ADDR, field, data);
      Parser p = new Parser(getLeft());
      data.strPlace = p.getOptional(',');
      field = p.get();
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field, data);
      data.strCity = getLeft();
    }

    @Override
    public String getFieldNames() {
      return "ADDR PLACE X CITY";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
