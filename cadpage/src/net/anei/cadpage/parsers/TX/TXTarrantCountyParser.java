package net.anei.cadpage.parsers.TX;


import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;

/*
Tarrant County, TX
Contact: "Jerritt Gideon" <j.gideon@tcfirealarm.com>
Sender:tarrantctydsp@rednmxcad.com

TRAUMA, GROUND LVL FALL: EMS FALL 99 YO/M  at 5604 N SCHILDER DR, RIVER OAKS  c/s: WALTER DR Box: 61S . . 10:12:42
STRUCTURE FIRE, Duplex/ Condo at 117 ST CLARE DR, TARRANT COUNTY c/s ST ELIZABETH DR Box 101U.. 23:57:40
MEDICAL, Cardiac Problem: 45 YO/F C&B, HAVING PALPITATIONS at 5130 BEN DAY MURRIN RD LOT 725, TARRANT COUNTY c/s: HWY 377 S Box: 99T. . 19:00:18
M V A, Unknown: DUMP TRUCK VS SUV, POSS DISMEMBERMENT at 7936 CONFEDERATE PARK RD, TARRANT COUNTY c/s: SILVER CREEK AZLE RD Box: 49P. . 17:25:51
GRASS FIRE, Single Station: REPORTED SMALL GRASS FIRE at 12100 OLD GRANBURY RD, TARRANT COUNTY c/s: FLOYD HAMPTON RD Box: 116X. . 17:30:33
TRAUMA, GROUND LVL FALL: 80 YO/M FALL. HIP PAIN. C/B at 300 N OLD DECATUR RD, SAGINAW c/s: W MCLEROY BLVD Box: 33X O: FIRST BAPTIST CHURCH. . 10:52:00
MEDICAL, MEDICAL ALARM: NO ANSWER ON CALL BACK at 5913 ED COADY RD, EDGECLIFF VILLAGE c/s: SYCAMORE CREEK RD Box: 90Z. . 03:02:46

*/

public class TXTarrantCountyParser extends DispatchRedAlertParser {
  
  public TXTarrantCountyParser() {
    super("TARRANT COUNTY","TX");
  }
}
