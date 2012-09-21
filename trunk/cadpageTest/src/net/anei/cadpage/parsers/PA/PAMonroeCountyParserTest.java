package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAMonroeCountyParserTest extends BaseParserTest {
  
  public PAMonroeCountyParserTest() {
    setParser(new PAMonroeCountyParser(), "MONROE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD MSG: *D F1 WASHINGTON PL / PRESIDENTIAL DR 203 POCONO FARMS / CALLER REPORTING\n\nWORKING FIRE / NO ONE IN THE RESIDENCE",
        "CODE:F1",
        "CALL:Fire & EMS Dispatch",
        "ADDR:WASHINGTON PL & PRESIDENTIAL DR",
        "CITY:Coolbaugh",
        "INFO:POCONO FARMS / CALLER REPORTING WORKING FIRE / NO ONE IN THE RESIDENCE");

    doTest("T2",
        "CAD MSG: *D F1 255 SUMMIT AVE 209 HOUSE FIRE / APPEARS TO BE VACANT / UNK IF ANYONE LIVES THERE OR NOT /",
        "CODE:F1",
        "CALL:Fire & EMS Dispatch",
        "ADDR:255 SUMMIT AVE",
        "CITY:Pocono",
        "INFO:HOUSE FIRE / APPEARS TO BE VACANT / UNK IF ANYONE LIVES THERE OR NOT /");

    doTest("T3",
        "CAD MSG: *D F2 GEISINGER FAMILY PRA / COMMERCE CT 203 GESINGER MT POCONO // BLACK GRAND AM ON FIRE// UNK IF ANYONE IS IN IT/",
        "CODE:F2",
        "CALL:Fire Dispatch",
        "PLACE:GEISINGER FAMILY PRA",
        "ADDR:COMMERCE CT",
        "MADDR:GEISINGER FAMILY PRA,COMMERCE CT",
        "CITY:Coolbaugh",
        "INFO:GESINGER MT POCONO / BLACK GRAND AM ON FIRE / UNK IF ANYONE IS IN IT /");

    doTest("T4",
        "CAD MSG: *D F1 HATCHERY DR / PARADISE VALLEY RD 208 RTE 940/TROUT HATCHERY// FULLY INVOLVED// NO VEHICLES INT HE D/W DOESN",
        "CODE:F1",
        "CALL:Fire & EMS Dispatch",
        "ADDR:HATCHERY DR & PARADISE VALLEY RD",  // Can't find HATCHERY DR
        "CITY:Paradise",
        "X:RTE 940",
        "INFO:/ TROUT HATCHERY / FULLY INVOLVED / NO VEHICLES INT HE D / W DOESN");

    doTest("T5",
        "CAD MSG: *D F2 JACK WILLIAMS TIRE / RTE 940 403 JACK WILLIAMS TIRE 839-8300 OFFICE/BATHROOM SMOKE DET WILL ATEM",
        "CODE:F2",
        "CALL:Fire Dispatch",
        "PLACE:JACK WILLIAMS TIRE",
        "ADDR:RTE 940",
        "MADDR:JACK WILLIAMS TIRE,RTE 940",
        "CITY:Mount Pocono",
        "INFO:JACK WILLIAMS TIRE 839-8300 OFFICE / BATHROOM SMOKE DET WILL ATEM");

    doTest("T6",
        "CAD MSG: *D E45J S I380 HWY / MM 1 POC SUM HWY 215 ONE VEH OFF THE FEMALE WITH NUMBNESS AND HUSBAND UNABLE TO GET OF THE",
        "CODE:E45J",
        "CALL:Motor Vehicle Accident with Entrapment",
        "ADDR:S I380 HWY & MM 1 POC SUM HWY",
        "MADDR:S I 380 & MM 1 POC SUM HWY",
        "CITY:Tobyhanna",
        "INFO:ONE VEH OFF THE FEMALE WITH NUMBNESS AND HUSBAND UNABLE TO GET OF THE");

    doTest("T7",
        "CAD MSG: *D F2 FS 33 POCONO SUMMIT 215 SPECIAL ASSIGNMENT AT STATION AT THIS TIME",
        "CODE:F2",
        "CALL:Fire Dispatch",
        "ADDR:FS 33 POCONO SUMMIT",  // FS is confusing things
        "CITY:Tobyhanna",
        "INFO:SPECIAL ASSIGNMENT AT STATION AT THIS TIME");

    doTest("T8",
        "CAD MSG: *D F2      7021 VISTA DR 203 PCP LOT G61 FIRE ALARM KEEPS GOING OFF / DOES\\NOT BELIVE ITS THE BATT",
        "CODE:F2",
        "CALL:Fire Dispatch",
        "ADDR:7021 VISTA DR",
        "CITY:Coolbaugh",
        "INFO:PCP LOT G61 FIRE ALARM KEEPS GOING OFF / DOES\\NOT BELIVE ITS THE BATT");

    doTest("T9",
        "CAD MSG: *D F2      WHITE TAIL DR / FAIRWAY DR 203 FAIRWAY DR//SOMETHING IN THE MIDDLE OF THE STREET IS ON FIRE/UNK WHAT",
        "CODE:F2",
        "CALL:Fire Dispatch",
        "ADDR:WHITE TAIL DR & FAIRWAY DR",   // Can't find WHITE TAIL DR
        "CITY:Coolbaugh",
        "X:FAIRWAY DR",
        "INFO:/ SOMETHING IN THE MIDDLE OF THE STREET IS ON FIRE / UNK WHAT");

    doTest("T10",
        "CAD MSG: *D E45J      RTE 196 / RYANS RD 203 2 CAR MVA WITH INJURY AND ENTRAPMENT//CALLER NOT INVOLVED//CALLER STAT",
        "CODE:E45J",
        "CALL:Motor Vehicle Accident with Entrapment",
        "ADDR:RTE 196 & RYANS RD",
        "CITY:Coolbaugh",
        "INFO:2 CAR MVA WITH INJURY AND ENTRAPMENT / CALLER NOT INVOLVED / CALLER STAT");

    doTest("T11",
        "CAD MSG: *D F1      WINDING WAY / SHADY SIDE DR 203 HOUSE FIRE FLAMES SHOWING  CAR IN DW UNK IF ANYONE HOME    NEAR SHAYS",
        "CODE:F1",
        "CALL:Fire & EMS Dispatch",
        "ADDR:WINDING WAY & SHADY SIDE DR",
        "CITY:Coolbaugh",
        "INFO:HOUSE FIRE FLAMES SHOWING CAR IN DW UNK IF ANYONE HOME NEAR SHAYS");

    doTest("T12",
        "CAD MSG: *D F2       POCONO MOUNTAIN WEST 215 PANTHER LN          OFFICE EXT 81400  // GENRAL FIRE ALARM\r\n\r",
        "CODE:F2",
        "CALL:Fire Dispatch",
        "PLACE:POCONO MOUNTAIN WEST",
        "ADDR:PANTHER LN",
        "MADDR:POCONO MOUNTAIN WEST,PANTHER LN",
        "CITY:Tobyhanna",
        "INFO:OFFICE EXT 81400 / GENRAL FIRE ALARM");
   
  }
  
  public static void main(String[] args) {
    new PAMonroeCountyParserTest().generateTests("T1", "CODE CALL PLACE ADDR APT CITY X INFO");
  }
}
