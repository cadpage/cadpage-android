package net.anei.cadpage.parsers;

/*
Farmingdale, NY
Contact: Frank Romano <fromano129@gmail.com>
Sender: paging@alpinesoftware.com.
CAD Software: Red Alert

Signal 9 . . Stroke (CVA) at 64 DOUD ST. . 11:31:21
General Alarm . . SMOKE ODOR IN AREA at 36 WAVERLY PL. . 17:04:46
House Fire . . Electrical Fire at 23 BEECHWOOD ST. . 18:24:03
Motor Vehicle Accident . . With Aided at intersection of MAIN ST and FULTON ST. . 11:46:09
Signal 9 . . Cardiac / Respiratory Arrest at 610 CONKLIN ST. . 06:20:05
 */


public class NYFarmingdaleParser extends DispatchRedAlertParser {
  
  public NYFarmingdaleParser() {
    super("FARMINGDALE", "NY");
  }
}
