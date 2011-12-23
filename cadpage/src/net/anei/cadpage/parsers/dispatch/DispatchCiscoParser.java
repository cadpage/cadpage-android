package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/***
Sugarcreek, OH
"Ct:EMS MINOR       Loc:4336 STATE RT 725            Apt:      XSt:BAYBERRY COVE D LAKEMAN DR      Grid:003F Units:72                                        Rmk:"
We use Cisco Public Safety�s ECAD program to page out CFS events.  CAD does send out multiple pages per event � one for the call and each responding unit.  Below are sample texts for review:
"Ct:FIRE ALARM - RE Loc:4334 KILLIAN CT              Apt:      XSt:BELFAST DR                      Grid:0001 Units:M71   B70   P219                          Rmk:"
"Ct:EMS MINOR       Loc:I 675 N/8MM                  Apt:      XSt:WILMINGTON PIKE FEEDWIRE RD     Grid:0045 Units:72                                        Rmk:"
"Ct:TRAFFIC ACCIDEN Loc:FEEDWIRE RD/WINSHIRE TER     Apt:      XSt:LITTLE SUGARCRE LEDGESTONE BLVD Grid:0002 Units:C70   B70   E71   M72   P228              Rmk:"
"Ct:OTHER FIRE      Loc:5980 WILMINGTON PIKE         Apt:      XSt:CLYO RD         WILMINGTON PIKE Grid:003A Units:72                                        Rmk:"
Ct:EMS MINOR       Loc:6244 WILMINGTON PIKE         Apt:      XSt:CLYO RD         CENTER POINT DR Grid:003B Units:E74   M72   R70   P241 

Vigo County, IN
Ct:FALL Loc:3301 ST MARY'S RD Apt: XSt:BLOOMTOWN RD US HWY 150 Grid:112D Units:E-42 TC-1 Rmk:92 YOLD FML; FELL; FACE DOWN ON FLOOR -
Ct:FALL Loc:309 N CHURCH ST Apt: XSt:PARIS AV Grid:0WTH Units:E-41 TC-2 Rmk:65 Years F ;fall
Ct:CHEST PAIN Loc:500 W PARIS AV Apt: XSt:6TH ST WTH 4TH ST WTH Grid:0WTH Units:E-41 TC-1 Rmk:
Ct:CHOKING Loc:2925 N MAPLE PL Apt: XSt:LOCUST AV Grid:0126 Units:E-42 TC-1 Rmk:18 Months F ;CHOKING
Ct:MVA-UNKNOWN-INJ Loc:US HWY 40/INTERSTATE 70 Apt: XSt: Grid:0169 Units:E-41 Rmk:SEMI AND PASSENGER CAR//UNKNOWN Injuries

St Francois County, MO
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE ALARM      Loc:3962 HAWK HOLLOW RD          Apt:      XSt:RIDGE\nTOP DR\n(Con't) 2 of 2\nGrid:4101 Units:E4161 T4171 4100  E4160 F4185             Rmk:ALARM SHOWING\nSMOKE SENSOR, ATTEMPTING K\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:EMS CALL        Loc:HIGHWAY H/HIGHWAY AA         Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4101 Units:F4185 4100  A5177 5100                    Rmk:\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:INVESTIGATION   Loc:!RAIL ROAD LN OFF HILDEBRECH Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4100  E4160                               Rmk:ON THE AIR\nINVESTIGATING A POSSIBLE FIRE\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:MVA INJURY      Loc:US HIGHWAY 67/HILDEBRECHT RD Apt:\nXSt:\n(Con't) 2 of 2\nGrid:6741 Units:E4160 F4185 A5177 R4276 E4261             Rmk:T-BONE\nCOLLISION -- UNKNOWN ON INJURY CA\n\n(End)
1 of 2\nFRM:IPN.9999900138@ipnpaging.com\nMSG:Ct:FIRE MISC       Loc:4 DOE RUN                    Apt:\nXSt:\n(Con't) 2 of 2\nGrid:4100 Units:4102                                      Rmk:HAVE 4139\nCONTACT 4102 AT THE FIREHOUSE\n\n(End)

Oxford, OH
Ct:MED:ENTRAPMENT  Loc:11 S POPLAR ST               Apt:      XSt:HIGH ST WALNUT ST               Grid:1604 Units:NO19                                      Rmk:
Ct:FD: FIRE ALARM  Loc:5201 COLLEGE CORNER PKe      Apt:219   XSt:                                Grid:4300 Units:M11                                       Rmk:
Ct:MED:EMERGENCY   Loc:CHESTNUT ST/MAIN ST          Apt:      XSt:                                Grid:3116 Units:E11   M11                                 Rmk:
Ct:PD: INJ CRASH   Loc:CHURCH ST/COLLEGE AV         Apt:      XSt:                                Grid:2535 Units:LO49  LO57                                Rmk:
Ct:FD: OTHER       Loc:5980 WILMINGTON PIKE         Apt:      XSt:CLYO RD         WILMINGTON PIKE Grid:6590 Units:C10                                       Rmk:

Howard County, IN
Subject:BREATHING PROBLEM\nLoc:1103 N 1100E XSt:200N 100N Grid:E300 Units:A11 Rmk:68 YOA FEMALE, DIZZY, BREATHING HARD, REAL RESTLE
Subject:BREATHING PROBLEM\nLoc:221 S HOWARD ST XSt:MAIN ST G HOLIDAY LN Grid:D210 Units:AGTFD Rmk:CANCER PATIENT DIFFICULTY BREATHI
Subject:BREATHING PROBLEM\nLoc:1401 SUNFLOWER CT XSt:MEADOW DR Grid:D210 Units:AGTFD Rmk:
Subject:TRANSPORTION\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:RETURN TRANSPORT FROM HOWARD COMM
Subject:RESIDENTIAL FIRE\nLoc:10269 E 300S XSt:1100E 980E Grid:A400 Units:E11 A11 Rmk:SMOKE COMING FROM THE UTILITY CLOSET
Subject:BREATHING PROBLEM\nLoc:6348 E 200N XSt:700E 600E Grid:D400 Units:AGTFD A11 Rmk:
Subject:ABDOM/BACK PAIN\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:ROOM 406 95 YOA FEMALE
Subject:GAS ODOR\nLoc:325 S MAPLE ST G XSt:MAIN ST G HALL ST Grid:D210 Units:E11 A11 Rmk:SMELLS NATURAL GAS INSIDE HER RESIDENCE

***/

public class DispatchCiscoParser extends FieldProgramParser {
  
  public DispatchCiscoParser(String defCity, String defState) {
    this(null, defCity, defState);
  }
  
  public DispatchCiscoParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState,
           "Ct:CALL! Loc:ADDR/S! Apt:APT XSt:X? Grid:MAP Units:UNIT Rmk:INFO");
  }
  
  private class MyUnitField extends UnitField {
    @Override 
    public void parse(String field, Data data) {
      super.parse(field.replaceAll(" +", " "), data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field.replaceAll("  +", " & "), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
