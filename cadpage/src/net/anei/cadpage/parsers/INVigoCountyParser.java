package net.anei.cadpage.parsers;

/***
Vigo County, IN
Contact: Billy Roberts <thfd334@gmail.com>
Sender: 37284
System: Cisco
Ct:FALL Loc:3301 ST MARY'S RD Apt: XSt:BLOOMTOWN RD US HWY 150 Grid:112D Units:E-42 TC-1 Rmk:92 YOLD FML; FELL; FACE DOWN ON FLOOR -
Ct:FALL Loc:309 N CHURCH ST Apt: XSt:PARIS AV Grid:0WTH Units:E-41 TC-2 Rmk:65 Years F ;fall
Ct:CHEST PAIN Loc:500 W PARIS AV Apt: XSt:6TH ST WTH 4TH ST WTH Grid:0WTH Units:E-41 TC-1 Rmk:
Ct:CHOKING Loc:2925 N MAPLE PL Apt: XSt:LOCUST AV Grid:0126 Units:E-42 TC-1 Rmk:18 Months F ;CHOKING
Ct:MVA-UNKNOWN-INJ Loc:US HWY 40/INTERSTATE 70 Apt: XSt: Grid:0169 Units:E-41 Rmk:SEMI AND PASSENGER CAR//UNKNOWN Injuries
Ct:EMS MAJOR Loc:6244 WILMINGTON PIKE Apt: XSt:CLYO RD CENTER POINT DR Grid:003B Units:C70 M71 P223 Rmk:
***/

public class INVigoCountyParser extends DispatchCiscoParser {
  
  public INVigoCountyParser() {
    super("VIGO COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "37284";
  }
}
