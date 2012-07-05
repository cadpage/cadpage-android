package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Currituck County, NC
Contact: Active911
Sender: CAD@co.currituck.nc.us
Agency name: Corolla Fire and Rescue Squad Inc Location: Corolla, NC 

CAD:INV REPORT OF SMOKE OR ALARM;827 WHALEHEAD DR;TEST CALL
CAD:CANCEL;827 WHALEHEAD DR; CRLA;(S)WHALEHEAD CLUB (N)
CAD:INV REPORT OF SMOKE OR ALARM;806 WHALEHEAD DR;JOHNS BROS
CAD:INV REPORT OF SMOKE OR ALARM;135 SALT HOUSE RD;JOHNS BROTHERS;8007682767
CAD:INV REPORT OF SMOKE OR ALARM;471 ISLAND LEAD RD
CAD:ASSIST FOR AGENCY OR PUBLIC;1013 LIGHTHOUSE DR;VERIZON WIRELESS;7248753289
CAD:GRASS FIRE;150 MP6 BEACH STRAND
CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS SECURITY;8007682767
CAD:INV REPORT OF SMOKE OR ALARM;792 APOLLO RD;THOMAS PARNELL;2524532368
CAD:ENTRAPMENT INACCESSIBLE;645 OCEAN FRONT ARCH;TRACEY WOOSLEY;2525971267
CAD:ASSIST FOR AGENCY OR PUBLIC;162 FOUR SEASONS LN DUCK;DARE CENTRAL
CAD:ACCIDENT;616-BLK HUNT CLUB DR;JACQUELYN;2525482221
CAD:CARBON MONOXIDE;913 SEA RIDGE DR;KEVIN HOFFMAN;4045979877
CAD:GRASS FIRE;1105-BLK AUSTIN ST;DAWN;2525482221
CAD:TRAUMATIC INJURIES;1101-BLK MORRIS DR E
CAD:INV REPORT OF SMOKE OR ALARM;762 VOYAGER RD;JOHNS BROTHERS;8007682767
CAD:COMMAND ESTABLISHED;762 VOYAGER RD; CRLA;(S)BUCK ISLAND (N)
CAD:GRASS FIRE;766 LAKESHORE CT;RIPLEY, CHARLES;2524536426
CAD:INV REPORT OF SMOKE OR ALARM;774 BAYBERRY CT;BRETT FRAILEY;2524532609
CAD:ACCIDENT;OCEAN TRL/SCHOOLHOUSE LN;AT&T MOBILITY;7048986965
CAD:ACCIDENT;1150 OCEAN TRL;MARIE LONG;7578693009
CAD:ACCIDENT;510-C OLD STONEY RD;CHEIF 6;2526194442
CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS
CAD:HAZARDOUS CONDITION;861 LIGHTHOUSE DR;BRIAN COLE;9106395191
CAD:ENTRAPMENT INACCESSIBLE;600 CURRITUCK CLUBHOUSE DR;JAMES HOLDING L*L*C;2524530512
CAD:INV REPORT OF SMOKE OR ALARM;1001 CANE GARDEN BAY CIR;NICOLE;4432204886
CAD:INV REPORT OF SMOKE OR ALARM;418 MYRTLE POND RD;JOHNS BROS-17;8007682767
CAD:GRASS FIRE;333 AUDUBON DR
CAD:INV REPORT OF SMOKE OR ALARM;453 NORTH COVE RD;SUSAN -JOHNS BRO
CAD:ACCIDENT;424-BLK OCEAN TRL;VERIZON WIRELESS;2522027842
CAD:INV REPORT OF SMOKE OR ALARM;935 COROLLA DR;TRUDY ALEXANDER;2524533310
CAD:SICK PERSON;1140 MORRIS DR;TRACEY STARLIPER;2525971196

[] CAD:INV REPORT OF SMOKE OR ALARM;774 BAYBERRY CT;BRETT FRAILEY;2524532609\n
[] CAD:ACCIDENT;OCEAN TRL/SCHOOLHOUSE LN;AT&T MOBILITY;7048986965\n
[] CAD:ACCIDENT;1150 OCEAN TRL;MARIE LONG;7578693009\n
[] CAD:ACCIDENT;510-C OLD STONEY RD;CHEIF 6;2526194442\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS\n
[] CAD:HAZARDOUS CONDITION;861 LIGHTHOUSE DR;BRIAN COLE;9106395191\n
[] CAD:ENTRAPMENT INACCESSIBLE;600 CURRITUCK CLUBHOUSE DR;JAMES HOLDING L*L*C;2524530512\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1001 CANE GARDEN BAY CIR;NICOLE;4432204886\n
[] CAD:INV REPORT OF SMOKE OR ALARM;418 MYRTLE POND RD;JOHNS BROS-17;8007682767\n
[] CAD:GRASS FIRE;333 AUDUBON DR\n
[] CAD:INV REPORT OF SMOKE OR ALARM;453 NORTH COVE RD;SUSAN -JOHNS BRO\n
[] CAD:ACCIDENT;424-BLK OCEAN TRL;VERIZON WIRELESS;2522027842\n
[] CAD:INV REPORT OF SMOKE OR ALARM;935 COROLLA DR;TRUDY ALEXANDER;2524533310\n
[] CAD:SICK PERSON;1140 MORRIS DR;TRACEY STARLIPER;2525971196\n
[] CAD:INV REPORT OF SMOKE OR ALARM;247 LONGFELLOW CV;JOHNS BROS\n
[] CAD:F6;STRUCTURE FIRE;750 WATERS EDGE\n
[] CAD:HAZARDOUS CONDITION;OCEAN TRL/OCEAN WAY;ANDREW;8048952818\n
[] CAD:ACCIDENT;604-BLK CURRITUCK CLUBHOUSE DR;PETER IDANOV;2522025523\n
[] CAD:TRANSFORMER OR POLE FIRE;1023-BLK OCEAN TRL;COROLLA LIGHT SECURITY;2522026313\n
[] CAD:BREATHING PROBLEMS;626 WAVE ARCH;ROSE VARIEL;4124435782\n
[] CAD:GAS LEAK;257 LONGFELLOW CV;GENE HOLCUTT;2524356628\n
[] CAD:INV REPORT OF SMOKE OR ALARM;806 WHALEHEAD DR;JOHNS BROS\n
[] CAD:COMMAND ESTABLISHED;806 WHALEHEAD DR; CRLA;(S)WHALEHEAD CLUB (N)\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;1066 OCEAN TRL;VICKI CHASE;4052264969\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;866 WHALEHEAD DR;GREG KAUFFMAN;5402208954\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;634 MYRTLEWOOD CT;ROBERT ELDICH;6103498458\n
[] CAD:INV REPORT OF SMOKE OR ALARM;169 SALT HOUSE RD;DAVID MURRAY;2524536388\n
[] CAD:INV REPORT OF SMOKE OR ALARM;929 WHALEHEAD DR;SUSAN BARCLAY;8144420297\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;157 SALT HOUSE RD;MARYANNE LEPINSKI;2404092081\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROTHERS;8007672767\n
[] CAD:INV REPORT OF SMOKE OR ALARM;815-E OCEAN TRL;SIMPLEX GRINELL;8887467539\n
[] CAD:ACCIDENT;812-B OCEAN TRL;TIM ZENNO;2156302467\n
[] CAD:F6;STRUCTURE FIRE;1263 SANDCASTLE DR\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1251 LAKESIDE CT;ROSE;2524895549\n
[] CAD:ACCIDENT;770-BLK OCEAN TRL;PAUL ROETTEGER;3143046013\n
[] CAD:F6;STRUCTURE FIRE;867 LIGHTHOUSE DR\n
[] CAD:F6;STRUCTURE FIRE;655 JUNIPER BERRY CT\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1123 OCEAN TRL;BARRY RICHMAN;2524532121\n
[] CAD:CANCEL;1123 OCEAN TRL; CRLA\n


*/

public class NCCurrituckCountyParser extends DispatchOSSIParser {
  
  public NCCurrituckCountyParser() {
    super(CITY_CODES, "CURRITUCK COUNTY", "NC",
           "F6? CALL ADDR/S! CITY? PLACENAME PHONE");
  }
  
  @Override
  public String getFilter() {
    return "CAD@co.currituck.nc.us";
  }
  
  private class MyPlaceNameField extends PlaceNameField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("(S)") && field.endsWith("(N)")) {
        data.strPlace = field.substring(3,field.length()-3).trim();
      } else {
        data.strName = field;
      }
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("F6")) return new SkipField("F6");
    if (name.equals("PLACENAME")) return new MyPlaceNameField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CRLA", "COROLLA",
      "DUCK", "DUCK",
  });
}
