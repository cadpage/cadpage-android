package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/***
Vigo County, IN
Contact: Billy Roberts <thfd334@gmail.com>
Sender: 37284,cisco.paging@vigocounty.in.gov
System: Cisco
Ct:FALL Loc:3301 ST MARY'S RD Apt: XSt:BLOOMTOWN RD US HWY 150 Grid:112D Units:E-42 TC-1 Rmk:92 YOLD FML; FELL; FACE DOWN ON FLOOR -
Ct:FALL Loc:309 N CHURCH ST Apt: XSt:PARIS AV Grid:0WTH Units:E-41 TC-2 Rmk:65 Years F ;fall
Ct:CHEST PAIN Loc:500 W PARIS AV Apt: XSt:6TH ST WTH 4TH ST WTH Grid:0WTH Units:E-41 TC-1 Rmk:
Ct:CHOKING Loc:2925 N MAPLE PL Apt: XSt:LOCUST AV Grid:0126 Units:E-42 TC-1 Rmk:18 Months F ;CHOKING
Ct:MVA-UNKNOWN-INJ Loc:US HWY 40/INTERSTATE 70 Apt: XSt: Grid:0169 Units:E-41 Rmk:SEMI AND PASSENGER CAR//UNKNOWN Injuries
Ct:EMS MAJOR Loc:6244 WILMINGTON PIKE Apt: XSt:CLYO RD CENTER POINT DR Grid:003B Units:C70 M71 P223 Rmk:
(MEDICAL ALARM) Loc:1334 6TH AV Grid:0563 Units:M-7 Rmk:PUSHED PENDANT BUTTON/ UNABLE TO REACH
[TRASH OR RUBBISH-FIRE]  Loc:428 W POPLAR ST XSt:5TH ST WTH 4TH ST WTH Grid:0WTH Units:E-41 Rmk:RP ADV MALE SUBJECT THERE THAT IS CAUSING PROBLEMS AND
(BRUSH-FIRE-NO-EXPOSURE) Loc:447 N THORPE PL XSt:SARAH MYERS DR OLD PARIS RD Grid:0148 Units:B-41 T-42 Rmk:FIRE NEXT TO WOODS WITH ALL THE GRAVE PROP

Contact: "Dennis Boyd" <dboyd462@gmail.com>
Ct:FIRE-ENTRAPMENT Loc:101 N 7TH ST WTH Apt: XSt:JOHNSON AV MILLER AV Grid:0WTH Units:E-41 E-42 L-41 R-41 Rmk:HOUSE ON FIRE PEOPLE STILL INSIDE

Contact: "Sittler, Josh D." <Josh.Sittler@vigocounty.in.gov>
Sender: Cisco.Paging@VigoCounty.IN.Gov
(FIRE-RESIDENTIAL-STRUCTURE) Loc:1670 W EDGEMONT DR XSt:RAVINE PL EDGEWOOD AV Grid:0126 Units:91RIT CV912 Rmk:ADV HER NEIGHBORS HOUSE IS ON FIRE/OPEN
(FIRE-RESIDENTIAL-STRUCTURE) Loc:1670 W EDGEMONT DR XSt:RAVINE PL EDGEWOOD AV Grid:0126 Units:E-42 E-41 T-42 T-41 R-41 Rmk:ADV HER NEIGHBORS HOUSE IS
(INJURED PERSON) Loc:7201 E GROSS DR XSt:LAMA ST ST RD 159 Grid:237A Units:R-53 Rmk:

Contact: Paul Watson <paul.watson252@gmail.com>
Sender: Cisco.Paging@VigoCounty.IN.Gov
(FIRE-RESIDENTIAL-STRUCTURE) Loc:1318 S 11TH HLF ST XSt:COLLEGE AV WASHINGTON ST Grid:0741 Units:EC-2 EC-6 EC-9 L-5 M-9 Rmk:BACK OF THE HOUSE IS ON F
(FIRE-COMMERCIAL-STRUCTURE) Loc:663 OHIO ST Grid:0666 Units:EC-2 EC-3 EC-9 L-5 S-5 BAT-2 C-11 Rmk:FIRE SMOKE ALARM/BEEN GOING OFF FOR A COUPLE HRS

***/

public class INVigoCountyParser extends DispatchCiscoParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "WTH", "WEST TERRE HAUTE"
  });
  
  private static final Pattern HLF_PATTERN = Pattern.compile("\\bHLF\\b", Pattern.CASE_INSENSITIVE);
  
  public INVigoCountyParser() {
    super(CITY_CODES, "VIGO COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "37284,cisco.paging@vigocounty.in.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!body.startsWith("Ct:")) {
      if (subject.length() == 0) return false;
      body = "Ct:" + subject + " " + body;
    }
    if (!super.parseMsg(body, data)) return false;
    
    // Turn HLF -> 1/2
    data.strAddress = HLF_PATTERN.matcher(data.strAddress).replaceAll("1/2");
    return true;
  }
}
