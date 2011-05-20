package net.anei.cadpage.parsers.NY;


import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;

/*
Rockland County, NY
Contact: "Timothy A Woolley" <TWooley@newcityfire.org>
Sender: paging@alpinesoftware.com
System: RedAlert

AUTOMATIC ALARM at 254 S MAIN ST, New City c/s:ELINOR PL SCHRIEVER LN . . 18:59:20
NATURAL GAS - OUTSIDE at 108 BIRCH LN, New City c/s: OLD BRICK RD / RED HILLRD . . 22:15:43
AUTOMATIC ALARM at 129 STRAWTOWN RD, New City c/s: VILLAGE WAY / RONE CT . . 00:07:21
VEHICLE FIRE at 48 GERMONDS RD, New City c/s: ROUTE 304 / LYNCREST AV . . 15:14:38
CO W/ SYMPTOMS at 85 OLD PHILLIPS HILL RD, New City c/s: MAHONEY CT / BUENA VISTA RD . . 18:18:51
BRUSH/MULCH/RUBBISH OUTSIDE at 14 OLD ROUTE 304, New City c/s: FAIR HAVEN DR, WESTGATE BLVD / N MAIN ST, ZUKOR RD 16:16:06
HAAZMAT at CONGERS RD/MAIN ST, New City . . 10:40:52

*/

public class NYRocklandCountyParser extends DispatchRedAlertParser {
  
  public NYRocklandCountyParser() {
    super("ROCKLAND COUNTY","NY");
  }

  @Override
  public String getFilter() {
    return "paging@alpinesoftware.com";
  }
}
