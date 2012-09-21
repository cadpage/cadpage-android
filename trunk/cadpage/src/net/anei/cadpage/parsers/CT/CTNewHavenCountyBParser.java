package net.anei.cadpage.parsers.CT;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
New Haven County, CT (North Branford & Northford)
Contact: Jeff Green <greenjeffreya@gmail.com>
Sender: paging@mail.nbpolicect.org.
System: NEXTGEN

1100008173 MEDICAL MEDA 00167  BRANFORD RD HUBBARD RD/TWIN LAKE RD  MED4 503 110910 11:50
1100008148 MEDICAL MEDD 00009  SALEM ST CLINTONVILLE RD/VILLAGE ST  MED4 R2 110909 17:55
1100008142 MUTUAL AID 00392  HOPE HILL RD WALLINGFORD    MED4 110909 15:38
1100008130 AUTOMATIC FIRE ALARM 00051  CIRO RD FOXON RD/DEAD END  E1 ET11 ET22 T1 R11 515 110909 10:07
1100008128 MEDICAL MEDB 00049  CAPUTO RD FOXON RD ROUTE 80/MILL RD  R1 MED4 515 110909 08:38
1100007980 BRUSH FIRE TWIN LAKES RD/ LAKE RD   BR1 ET11 502 110904 12:22

Wallinford Mutual aid (WLFD)
1100008057 MVA W/INJURIES N MAIN/RT68 WLFD A44 110906 17:05
1100007014 MUTUAL AID 00909  BEAVER HEAD RD , GUILFORD    MED4 110811 01:16

Contact: Chris crotty <nbfd819@gmail.com>
Sender: paging@nbpolicect.org
1100010113 MEDICAL MEDC 00254  BRANFORD RD Prem Map -  HARRISON RD/FOXON RD  MED4 R1 111116 23:04\n
1100011295 MEDICAL MEDD 01739 FOXON RD NORTH ST/SEA HILL RD  MED4 R1 111230 23:13\n
1100011302 MUTUAL AID 00260 FOREST RD JERZ LN/OLD FOREST RD  MED4 111231 03:49\n
1100011303 MEDICAL MEDA 00043 WOODCHASE LN TOTOKET RD/MILL RD  515 MED4 111231 05:02\n

East Haven, CT (in New Haven county)
Contact: "nemo48@sbcglobal.net" <nemo48@sbcglobal.net>
Contact: "Mark Nimons" <MNimons@easthavenfire.com>
Sender: paging@easthavenfire.com
1100005182 ALPHA MEDICAL 00055 THOMPSON ST  Prem Map -14 PP 65 FOXON RD/GAY ST  (Prem Map -14 PP 65)    S5 111120 15:40
1100004628 CHARLIE MEDICAL TF1 00057 MAIN ST Prem Map -5 PP 80 SALTONSTALL PKWY/DEBORAH LA (Prem Map -5 PP 80) R1 111017 09:16
1100004627 CHARLIE MEDICAL TF3 00267 RUSSO AVE Map -13 BRENNAN ST/ANN ST S5 111017 03:25
1100004626 MVA WITH INJURIES LAUREL ST/ NORTH HIGH ST E1 R1 C4 S2 111016 23:29
1100004625 CHARLIE MEDICAL TF4A 00038 TALMADGE AVE Prem Map -3 PP165 POND ST/DEAD END (Prem Map -3 PP165) R1 111016 22:00
1100004612 ALPHA MEDICAL 01270 NORTH HIGH ST Prem Map -14 PP 63 CORBIN RD/MAPLE ST S5 111015 21:49
1100004608 DELTA MEDICAL TF1 00152 KIMBERLY AVE Map -7 PARDEE PL/KIMBERLY AVE R1 111015 19:03

Farmington, CT (in Hartford county)
Contact: "J. Neves" <jneves@effd.org>
Contact: Vincenzo <vgarcia1322@comcast.net>
Sender: pdpaging@farmington-ct.org

1100024685 MEDICAL CALL CHARLIE RESPONSE 00088  SCOTT SWAMP RD   UM1 XXFF AMR1 111117 15:13
1200006652 FIRE - BRUSH FIRE 01825 FARMINGTON AVE Prem Map -  PARK POND PL/SOUTH MAIN ST  XXTH 120409 11:05\r\n\r
1200006665 FIRE - MV  00270 FARMINGTON AVE Prem Map -  TALCOTT NOTCH RD/PARK DR  EXOG UE1 XXEF 120409 15:40\r\n\r
1200006659 FIRE - BRUSH FIRE SPIELMAN HWY/ MOUNTAIN SPRING RD   LC1 XXBF 120409 13:26\r\n\r
1200006653 MEDICAL CALL BRAVO RESPONSE 00204 MAIN ST BIDWELL SQ/ROURKE PL  XXFF AMR1 120409 11:12\r\n\r
1200006626 FIRE - SMOKE/GAS INVEST OUTSIDE 00339 MEADOW RD SOMERSBY WAY/JUDSON LA  EXSW XXFF 120409 00:12\r\n\r
1200006038 MEDICAL CALL CHARLIE RESPONSE 00051 LITCHFIELD RD PLAINVILLE AVE/BIRCH ST  UM1 XXTH AMR1 120330 20:14\r\n\r

Contact:  Ralph Spaduzzi <rspaduzzi@gmail.com>
Sender: paging@easthavenfire.com
1200003638 AFA NIGHT RESPONSE 00003 COSEY BEACH AVE  Prem Map -2 PP 88 FOUR BEACHES ENTRANCE/JAMACA CO  E4 E1 T3 E6 R1 R4 S2 C4 120820\r

*/

public class CTNewHavenCountyBParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(\\d{10}) +");
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" +(\\d{6}) (\\d\\d:\\d\\d)$"); 
  private static final Pattern TRUNC_DATE_TIME_PTN = Pattern.compile(" +\\d{6} [\\d:]+$| +\\d{1,6}$"); 
  private static final Pattern MAP_PFX_PTN =Pattern.compile("^(?:Prem )?Map -");
  private static final Pattern MAP_PTN = Pattern.compile("^\\d{1,2}(?: ?[A-Z]{2} ?\\d{1,3})?\\b");
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+(?=\\d)");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
    "WLFD", "WALLINFORD"
  });
  
  public CTNewHavenCountyBParser() {
    this(CITY_CODES, "NORTH BRANFORD", "CT");
  }
  
  public CTNewHavenCountyBParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
  }
  
  @Override
  public String getFilter() {
    return "paging@mail.nbpolicect.org,paging@nbpolicect.org,paging@easthavenfire.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    
    match =  DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      String date = match.group(1);
      data.strDate = date.substring(2,4) + "/" + date.substring(4,6) + "/" + date.substring(0,2);
      data.strTime = match.group(2);
      body = body.substring(0,match.start());
    } else {
      match = TRUNC_DATE_TIME_PTN.matcher(body);
      if (match.find()) body = body.substring(0,match.start());
    }

    // Unit are at the end of the body separated by a double blank.
    // But we don't want to actually extract them here, we want to do it after
    // we have parsed out the address and city.  Except that parsing the address
    // and city removes the double blank we are looking for :(
    
    // So, we'll check for the double blank here and save the prospective unit
    // field.  Then, after the address has been parsed, if the extra string
    // still ends with this prospective unit, then we will strip it off
    String sUnit = null;
    int pt = body.lastIndexOf(") ");
    if (pt >= 0) {
      data.strUnit = body.substring(pt+2).trim();
      body = body.substring(0,pt+1);
    } else {
      if (pt < 0) pt = body.lastIndexOf("  ");
      if (pt >= 0) sUnit = body.substring(pt+2).trim();
    }
    
    String sExtra;
    pt = body.indexOf(',');
    if (pt >= 0) {
      sExtra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
      Parser p = new Parser(sExtra);
      data.strCity = p.get(' ');
      sExtra = p.get();
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END | FLAG_START_FLD_REQ, body, data);
    }
    
    else {
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, body, data);
      sExtra = getLeft();
    }
    match = MAP_PFX_PTN.matcher(sExtra);
    if (match.find()) {
      sExtra = sExtra.substring(match.end()).trim();
      match = MAP_PTN.matcher(sExtra);
      if (match.find()) {
        data.strMap = match.group();
        sExtra = sExtra.substring(match.end()).trim();
        pt = sExtra.indexOf('(');
        if (pt >= 0) sExtra = sExtra.substring(0,pt).trim();
      }
    }
    if (sUnit != null && sExtra.endsWith(sUnit)) {
      data.strUnit = sUnit;
      sExtra = sExtra.substring(0, sExtra.length() - sUnit.length()).trim();
    }
    
    // That usually does the trick, but if we didn't find a unit that way
    // just grab the last word
    if (data.strUnit.length() == 0) {
      pt = sExtra.lastIndexOf(' ');
      if (pt >= 0) {
        data.strUnit = sExtra.substring(pt+1).trim();
        sExtra = sExtra.substring(0,pt).trim();
      } else {
        data.strUnit = sExtra;
        sExtra = "";
      }
    }
    
    data.strCross = sExtra;
    
    match = LEAD_ZERO_PTN.matcher(data.strAddress);
    if (match.find()) {
      data.strAddress = data.strAddress.substring(match.end()).trim();
    }
    return true;
  }
}
