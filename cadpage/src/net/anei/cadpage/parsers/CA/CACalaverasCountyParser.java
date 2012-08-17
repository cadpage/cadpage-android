package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/*
Calaveras County, CA
Contact: "Allendorf, Ed" <Ed.Allendorf@fire.ca.gov>
Sender: tcucad@FIRE.CA.GOV

(CAD Page) Inc# 007259: MTC MARK TWAIN CONV HOSPITAL @ 900 MOUNTAIN RANCH RD #22 ,CALAVERAS_COUNTY :Map  467/19D_018: LAT/LONG X: -120 40.1947  Y: 38 11.4804: MEDICAL: 64 YO F POSS STROKE: D4494
(CAD Page) Inc# 007256: 5489 TONAPAH RD ,CALAVERAS_COUNTY :Map  2647/32A_001: LAT/LONG X: -120 22.6286  Y: 38 10.1916: MEDICAL: 77 YO F FV POSS FX ANKLE: 43 E4480 D4494
(CAD Page) Inc# 007104: NATURAL BRIDGES @ =L(38.051636,-120.470996) ,CALAVERAS_COUNTY :Map  509/37B_005: LAT/LONG X: -120 28.2597  Y: 38 3.09816: MED, TRAFFIC COLLISION: MVA: 24 22 E4452
(CAD Page) Inc# 007077: 18455 OAK ST ,TUOLUMNE_CITY :Map  3249: LAT/LONG X: -120 14.3925  Y: 37 57.4074: FIRE, RESIDENTIAL:Smoke from structure : B4415 E4485 E4465 E761 73 81 53 72 56 B795 WT518 WT569 WT768 P701 DUTYCHF FIUXTO D4494
(CAD Page) Inc# 007072: FOOTHILL PEDIATRICS (ANGELS) @ 445 MAIN ST S ,ANGELS_CAMP :Map  508/30C_016: LAT/LONG X: -120 33.0980  Y: 38 4.67964: MEDICAL: 78 YO F SEIZURES SILENT APPROACH M-24: D4494 21 E4472
(CAD Page) Inc# 006809: 1262 PENNSYLVANIA GULCH RD / 1222 SKUNK RANCH RD ,MURPHYS :Map  2797/31A_024: LAT/LONG X: -120 26.1135  Y: 38 7.82106: FIRE, WILDLAND:Veg Fire  : E4472 D4494 HCVL2 HCVL4
(CAD Page) Inc# 007059: COLUMBIA SKY MHP @ 10956 GREEN ST #247 ,COLUMBIA :Map  3097/38B_013: : LAT/LONG X: -120 24.3873  Y: 38 2.23038: MEDICAL: 50 YO DIABETIC UNRESPONSIVE: D4494

 */


public class CACalaverasCountyParser extends MsgParser {
  
  private static final Pattern MASTER = 
      Pattern.compile("Inc# (\\d+):(?:([^@]+)@)?(.+?), *([A-Z_]+) *:Map  ([^:]*):(?: :)? LAT/LONG X: ([-+]?\\d+) (\\d+\\.\\d+) +Y: ([-+]?\\d+) (\\d+\\.\\d+): ([^:]*:[^:]+):(.*)");
  
  public CACalaverasCountyParser() {
    super("CALAVERAS COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "tcucad@FIRE.CA.GOV";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1);
    data.strPlace = getOptGroup(match.group(2));
    parseAddress(match.group(3).trim(), data);
    data.strCity = match.group(4).replace('_', ' ').trim();
    data.strMap = match.group(5).trim();
    data.strGPSLoc = cvtGPSCoord(match.group(6), match.group(7)) + ' ' + cvtGPSCoord(match.group(8), match.group(9));
    data.strCall = match.group(10).trim();
    data.strUnit = match.group(11).trim();
    
    return true;
  }

  private String cvtGPSCoord(String degree, String minute) {
    double dDegree = (float)Integer.parseInt(degree);
    double dMinute = Double.parseDouble(minute);
    double value = dDegree + Math.signum(dDegree)*dMinute/60.;
    return String.format("%8.6f", value);
  }
}
