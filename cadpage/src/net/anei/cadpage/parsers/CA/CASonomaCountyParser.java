package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Sonoma County, CA
Contact: Michael Gevas <mgevas@valleyfordfire.com>
Contact: Sage Howell <sagehowellmobile@gmail.com>
Contact: "jpich@aol.com" <jpich@aol.com>
Contact: "Joe Boldt" <JoeB@svfra.org>
Sender: sclec@sonoma-county.org

Loc: HWY1/VALLEY FORD ROAD VFR BOX: 3540 TYP:TC CN: CHP LOG # 632 C#: TYPE CODE: TC CALLER NAME: CHP LOG # 632 CALLER ADDR:  TIME: 11:07:31 COM: ** Case n
Loc: 1320 BAY VIEW ST BBY:@ BODEGA UNION CHURCH BOX: 3433 B3 TYP: GAS-IN CN: BODEGA BAY UNION CHURCH C#: (707)875-3559 TYPE CODE: GAS-IN CALLER NAME: BODEGA
Loc: BBY:@HWY 1MM012.42 BOX:3332 B TYP: TC-EX CN: CHP LOG 344 C#: TYPE CODE: TC_EX CALLER NAME:CHP LOG 344 CALLER ADDR:  TIME: 03:44:34 COM: OVER TURN
Loc: 1400 VALLEY FORD FREESTONE RD VFR BOX: 3439 B TYP: SER-PA CN: JOANNA C#: (707) 876-3288 TYPE CODE: SER-PA CALLER NAME: JOANNA CALLER ADDR:  TIME: 13:01
Loc: 2458 BIG OAK DR SR BOX: 2946 D4 TYP: STRUW CN: AT&T MOBILITY 80 635 6840  4 C#: (707) 327-7382 TYPE CODE: STRUW CALLER NAME: AT&T MOBILITY
Loc: CALISTOGA RD/CHALFANT RD RIN BOX: 2452 D TYP: TC-EX CN: CHP LOG#1987 C#:  TYPE CODE: TC-EX CALLER NAME: CHP LOG#1987 CALLER ADDR:  TIME: 19:32:46 COM:
Loc: 801 SANTA BARBARA DR SRO BOX: 3049 B4 TYP: GAS-IN CN: JOEY C#: (707) 391-8596 TYPE CODE: GAS-IN CALLER NAME: JOEY CALLER ADDR:  TIME: 18:14:37 COM:  Ev
Loc: 311 BELHAVEN CI SR BOX: 2955 C3 TYP: STRU CN: COUGHLAN JAQUELINE C#: (707) 538-7881 TYPE CODE: STRU CALLER NAME: COUGHLAN JAQUELINE CALLER ADDR: 311 BE
Loc: 187 PEACH BLOSSOM DR SR BOX: 2847 B4 TYP: GAS-IN CN:  C#: (707) 523-4778 TYPE CODE: GAS-IN CALLER NAME:  CALLER ADDR:  TIME: 12:50:50 COM:  UNSURE WHAT
Loc: 2637 WILD BILL CI SR BOX: 3048 C4 TYP: STRU CN: BARRAGAN MARTHA C#: (707) 544-5719 TYPE CODE: STRU CALLER NAME: BARRAGAN MARTHA CALLER ADDR: 2637 WILD
Loc: DUTTON MEADOW/TUXHORN DR SR BOX: 3048 D4 CN: TOGNERI JOHN W C#: (707) 545-7701 TYP: STRU CALLER ADDR: 2742 MORGAN CREEK TIME: 14:58:04 COM:  OUT BLDG /
Loc: 4585 OLD REDWOOD HW LAR BOX: 2747 B2 CN: AT&T MOBILITY 800 635 6840  4 C#: (707) 953-6573 TYP: VEG CALLER ADDR: 434 Pacific Heights Drive S RS TIME: 17
Loc: SR: @SB 101 AT 12 BOX: 3049 A2 CN: CHP LOG 721 C#:  TYP: TC-EX CALLER ADDR:  TIME: 10:44:33 COM:  CRO 3 ** Case number SRS11016088 has been assigned fo  
Loc: 2055 RANGE AV SR,326: @LAMPLIGHTERS SENIOR CITIZEN INN BOX: 2848 D3 CN: MCNEIL K C#: (707) 528-6259 TYP: FA-RES CALLER ADDR: 2055 RANGE AV TIME: 22:39:  
Loc: 2389 MCBRIDE LN SR,12: @PARK VILLA APTS BOX: 2848 D1 CN:  C#:  TYP: STRU CALLER ADDR:  TIME: 17:46:46 COM:  apt 12 ** Case number SRS11015986 has been  
Loc: BEL: @NB 101 NO TODD BOX: 3149 C4 CN:  C#:  TYP: TC-EX CALLER ADDR:  TIME: 08:36:59 COM:  VEH OVERTURNED ** Case number SRS11015469 has been assigned f  
Loc: 2350 MCBRIDE LN SR,C9: @MCBRIDE APTS BOX: 2848 D2 CN: GUTIERREZ A C#: (707) 576-7446 TYP: GAS-IN CALLER ADDR: 2350 MC BRIDE LN TIME: 22:04:37 COM:  **  
Loc: WALKER AV/TODD RD BEL BOX: 3247 A CN:  C#:  TYP: STRU CALLER ADDR:  TIME: 02:07:14 COM:  FLAMES SEEN RP FROM 5002 LLANO RD APPEARS TO BE SPREADING ** C  
Loc: 555 1ST ST SR: @LOT 12 BOX: 2949 D1 CN: BARRY C#: 1-800-470-1000 TYP: FA-WF CALLER ADDR: BAY ALARM TIME: 13:51:38 COM:  CONTROL 3 WATER FLOW 6 INCH MAI  
Loc: W 3RD ST/TRACKS SR BOX: 2949 C3 CN:  C#:  TYP: VEG CALLER ADDR:  TIME: 14:06:16 COM:  AT THE CREEK PEOPLE WERE SCREAMING FOR SOMEONE TO CALL UNDER THE  
Loc: SR: @SB 101 AT CORBY OFF BOX: 3049 A4 TYP: VEHFULL CN: AT&T MOBILITY 800 635 6840  4 C#: (707) 480-1310 TYPE CODE: VEHFULL CALLER NAME: AT&T MOBILITY 8  
Loc: 1621 HERBERT ST SR,7 BOX: 2848 D3 CN:  C#:  TYP: STRU CALLER ADDR:  TIME: 00:11:13 COM:  SOME KIND OF ODD BEEPING HAS BEEN GOING ON INSIDE THE APT 7 RP 
Loc: 1051 YUBA DR ROS BOX: 3147 B2 CN: WILLIAMS RUTH C#: (707) 544-8224 TYP: STRU CALLER ADDR: 962 YUBA DR TIME: 17:59:51 COM:  SMOKE FROM THE ROOF RED HOUS
Loc: 1142 DUER RD WSR BOX: 3045 C4 TYP: HC CN: SANDRA C#: (707) 484-0358 TYPE CODE: HC CALLER NAME: SANDRA CALLER ADDR:  TIME: 14:50:20 COM:  BROKEN SPRINKL
Loc: 420 GREVE LN SO BOX: 3662 A1 CN:  C#: (707) 939-9366 TYP: MED CALLER ADDR:  TIME: 01:38:32 COM:  HIGH BP FEELING ILL ** Case number SON11002627 has bee
Loc: 1850 SPERRING RD SCH BOX: 3759 B1 CN: STANLEY 877 476 4968 C#: (707) 933-9300 TYP: FA-RES CALLER ADDR:  TIME: 09:26:52 COM:  SMOKE DETECTOR HALLWAY CON
Loc: 800 OREGON ST SO: @MERRILL GARDENS,266 BOX: 3660 B4 CN: DOMOGALLA VERN F C#: (707) 996-8354 TYP: SER-PA CALLER ADDR: 800 OREGON TIME: 09:52:45 COM:  AP
Loc: 5500 WILSHIRE DR MWS BOX: 2649 B2 CN: VERIZON WIRELESS 800 451 5242 4 C#: (707) 326-5961 TYP: VEG CALLER ADDR: 2201 NEWGATE CT S RS TIME: 16:25:22 COM:
Loc: 237 GROVE ST WI BOX: 2443 B2 CN: VERIZON WIRELESS 800 451 5242 4 C#: (707) 479-6714 TYP: STRU CALLER ADDR: 2450 SWEETWATER SPRINGS RD HBG TIME: 17:29:5

Contact: stephen heine <stevesrf@gmail.com>, Steve <sjheine@comcast.net>
Sender: messaging@iamresponding.com
(Wilmar) Loc: 4000. D ST PET BOX: 4052 D CN:COM  N -122.6389 T 38.19909 METERS 16 CONTORL 4 SMALL BUT GROWING **
(Wilmar) Loc: 200 KUCK LN PET BOX: 3749 D CN:COM:  DIARRHEA DIFFICULTY BREATHING **

Email variants
Loc: VALLEY FORD RD/HWY 1 VFR BOX: 3540 TYP: TC CN: AT&T MOBILITY 800 635 6840  4 C#: (650) 455-7732 TYPE CODE: TC CALLER NAME: AT&T MOBILITY 800 635 6840  4 CALLER ADDR: 2885 BAY HILL RD BDGA TIME: 16:00:06 COM:  N -122.7320 T 38.40650 METERS 2758 MOTORCYCLE 
Loc: 14460 SCHOOL ST VFR BOX: 3539 A2 TYP: MED CN: BEAL FRED C#: (707) 876-3232 TYPE CODE: MED CALLER NAME: BEAL FRED CALLER ADDR: 14460 SCHOOL TIME: 20:34:31 COM:  SCSO 911 HAD SURGERY IS SF A WEEK AGO LEG SWOLLEN FROM WHERE THE SURGERY WAS IN HIS LEG CONTROL 2 PT HAS A 102 TEMP DR TOLD HIM TO CALL 911 78 YOM 
Loc: 814 OWL CT BBY BOX: 3535 C1 TYP: STRU CN: CASTLE,STACEY C#: (707) 875-9870 TYPE CODE: STRU CALLER NAME: CASTLE,STACEY CALLER ADDR: 814 OWL CT TIME: 10:17:55 COM:  SCSO- 911 SMOKE COMING FROM AN ELECTICAL OUTELT 
Loc: BLOOMFIELD RD/SUTTON ST BLO BOX: 3542 B4 TYP: HC CN: 8540 C#:  TYPE CODE: HC CALLER NAME: 8540 CALLER ADDR:  TIME: 20:39:02 COM:  veh in ditch and water start 8580
BOX: 3437 TYP: VEG CN: VERIZON WIRELESS 800 451 5242 4 C#: (707) 321-9508 TYPE CODE: VEG CALLER NAME: VERIZON WIRELESS 800 451 5242 4 CALLER ADDR: 2885 BAY HILL RD BDGA BAY TIME: 12:33:30 COM:  N -122.9738 T 38.33546 METERS 41 RIGHT BEFORE THE BODEGA HWY TURN OFF SHE COULD NOT GIVE AN ADDRESS OR A MILE MARKER
Loc: BBY: @HWY 1 MM012.42 BOX: 3332 B TYP: TC-EX CN: CHP LOG 344 C#:  TYPE CODE: TC-EX CALLER NAME: CHP LOG 344 CALLER ADDR:  TIME: 03:44:34 COM:  OVER TURNED VEH NEAR SALMON CREEK CONTROL 2 
Loc: HWY 1/BODEGA HW BOD BOX: 3436 TYP: TC-EX CN: CHP C#:  TYPE CODE: TC-EX CALLER NAME: CHP CALLER ADDR:  TIME: 20:46:20 COM:  OVERTURNED VEH ON HWY 1, BETWEEN VALLEY FORD AND BODEGA HWY BAD CONNECTION WITH RP, PER CHP

Contact: support@active911.com
[] EVENT: SON121380005 Loc: 91 NAPA RD SO,117: @VINTAGE AT SONOMA CN: SPRINT NEXTEL-CDMA 866-398-3284 EID: 4444104 TYP: MED CALLER ADDR: 4499 STAGE GULCH RD SNMA TIME: 13:45:54 COM:  N -122.4580 T 38.27444 METERS 41 FALL / HEAD INJURY ** Case number SON12001670 has been assigned for SON:F33 Unit 3382 requested case number SON12001670 ** >>>> by: ERIN GRACE on terminal: red2 87 YOM RT HIP PAIN CONTROL 4 ROOM 117 17 B 1 - G\n
[] Loc: 4255 WARM SPRINGS RD GLE CN: ROSEWSKY HANS & ALICE EID: 4444131 TYP: MED CALLER ADDR: 4255 WARM SPRINGS RD TIME: 14:06:30 COM:  DIFF BREATHING DIZZY CONTROL 4 POSS CARBON MONOXIDE PROBLEM ** Case number SON12001671 has been assigned for SON:F33 ** Case number GLE12000125 has been assigned for GLE:F32 ** >>>> by: FRANCES ROSSITER on terminal: red6 Unit 3281 requested case number GLE12000125 Unit MED303 requested case number SON12001671 ** >>>> by: FRANCES ROSSITER on terminal: red6 WIFE, SON, FRIEND AND RP RP IS IN A HOSPITAL BED, CAN'T GET OUT THE FRIEND FELT DIZZY ALSO LAST NIGHT WAS COUGHING AND DIZZY, HIS O2 MACHINE ON ALL NIGHT\n
[] Loc: RIDGEVIEW DR/MONTECITO LN SRO BOX: 2850 C2 CN: ROMERO JOHN C#: (707) 546-0315 TYP: STRU CALLER ADDR: 3333 MONTECITO LN TIME: 23:56:10 COM:  MULT CALLERS UNK TYPE FIRE CONTROL 3 RP ASSUMED IT WAS A STRU RP CONFIRMED A STRU ** Case number KWD12000080 has been assigned for KWD:F31 ** Case number SRS12009323 has been assigned for SRS:F71 ** >>>> by: JOE WAYT on terminal: red2 Unit 7580 requested case number SRS12009323 ** >>>> by: JOE WAYT on terminal: red2 Unit 3197 requested case number KWD12000080 TAC 5 ASSIGNED\n

 */


public class CASonomaCountyParser extends FieldProgramParser {
  
  public CASonomaCountyParser() {
    super(CITY_LIST, 
           "SONOMA COUNTY", "CA",
           "Loc:ADDR? BOX:BOX TYP:CALL? CN:NAME C#:PHONE TYP:CALL? TYPE_CODE:SKIP CALLER_NAME:NAME CALLER_ADDR:ADDR2/S TIME:TIME COM:INFO");
  }
  
  @Override
  public String getFilter() {
    return "sclec@sonoma-county.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = body.replace(" CN:COM ", " CN: COM:").replace(" CN:COM:", " CN: COM:");
    if (! super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0) return false;
    return true;
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String fld, Data data) {
      fld = fld.replaceAll(": @", ":@");
      int pt = fld.indexOf(":@");
      if (pt >= 0) {
        data.strPlace = fld.substring(pt+2).trim();
        fld = fld.substring(0,pt).trim();
      }
      if (fld.length() <= 3) {
        data.strSource = fld;
        fld = data.strPlace;
        data.strPlace = "";
      }
      
      pt = fld.lastIndexOf(',');
      if (pt >= 0) {
        data.strApt = fld.substring(pt+1).trim();
        fld = fld.substring(0, pt);
      }
      
      fld = fld.replace(" AT ", " & ");
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, fld, data);
      if (data.strCity.length() > 0) {
        if (data.strSource.length() == 0) data.strSource = data.strCity;
        data.strCity = convertCodes(data.strCity, CITY_CODES);
      } else if (data.strSource.length() > 0) {
        data.strCity = convertCodes(data.strSource, CITY_CODES);
      }
      if (data.strCity.length() <= 3) data.strCity = "";
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY SRC PLACE";
    }
  }
  
  private class MyAddress2Field extends MyAddressField {
    @Override
    public void parse(String field, Data data) {
      if (data.strAddress.length() > 0) return;
      super.parse(field, data);
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override 
    public void parse(String field, Data data) {
      if (field.length() < 5) return;
      if (field.length() < 8) field = field.substring(0,5);
      super.parse(field, data);
    }
  }
  
  private static final String JUNK_MARKER = " ** Case number";
  private static final Pattern END_JUNK_PTN = Pattern.compile(" on terminal: \\w+ +| case number [A-Z]{3}[0-9]{8} +");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" **");
      if (pt >= 0) {
        String tail = field.substring(pt);
        if (tail.startsWith(JUNK_MARKER) || JUNK_MARKER.startsWith(tail)) {
          field = field.substring(0,pt).trim();
          Matcher match = END_JUNK_PTN.matcher(tail);
          pt = tail.length();
          while (match.find()) pt = match.end();
          field = append(field, " - ", tail.substring(pt).trim());
            
        }
      } else if (field.equals("**")) field = "";
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ADDR2")) return new MyAddress2Field();
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AGU", "AQUA CALIENTE",
      "ANP", "ANNAPOLIS",
      "AST", "CLOVERDALE",
      "BBY", "BODEGA BAY",
      "BEL", "SANTA ROSA",
      "BEN", "SANTA ROSA",
      "BLO", "PETALUMA",
      "BOD", "BODEGA",
      "BOY", "BOYES HOT SPRINGS",
      "CAM", "CAMP MEEKER",
      "CAZ", "CAZADERO",
      "CL",  "CLOVERDALE",
      "CLO", "CLOVERDALE",
      "CO",  "COTATI",
      "COT", "COTATI",
      "DRC", "HEALDSBURG",
      "DUN", "DUNCANS MILLS",
      "ELD", "ELDRIDGE",
      "ELV", "EL VERANO",
      "FIT", "HEALDSBURG",
      "FOR", "FORESTVILLE",
      "FTR", "FORT ROSS",
      "FUL", "SANTA ROSA",
      "GEY", "GEYSERVILLE",
      "GLE", "GLEN ELLEN",
      "GRA", "GRATON",
      "GUE", "GUERNVILLE",
      "HE",  "HEALDSBURG",
      "HEA", "HEALDSBURG",
      "HES", "SEBATOPOL",
      "JCD", "JCD",
      "JEN", "JENNER",
      "KEN", "KENWOOD",
      "KNI", "CALISTOGA",
      "KOR", "FORESTVILLE",
      "LAK", "PETALUMA",
      "LAR", "SANTA ROSA",
      "LKC", "LAKE COUNTY",
      "LSO", "GEYSERVILLE",
      "MAY", "GLEN ELLEN",
      "MEN", "MENDOCINO COUNTY",
      "MRN", "MARIN COUNTY",
      "MRO", "MONTE RIO",
      "MTN", "CALISTOGA",
      "MWS", "SANTA ROSA",
      "NAP", "NAPA",
      "OCC", "OCCIDENTAL",
      "PE",  "PETALUMA",
      "PEN", "PENNGROVE",
      "PET", "PETALUMA",
      "RIN", "SANTA ROSA",
      "RLN", "HEALDSBURG",
      "RND", "RIO NIDO",
      "ROH", "ROHNERT PARK",
      "ROS", "SANTA ROSA",
      "RP",  "ROHNERT PARK",
      "SCH", "SCHELLVILLE",
      "SE",  "SEBATOPOL",
      "SEB", "SEBATOPOL",
      "SO",  "SONOMA",
      "SOL", "SOLANO COUNTY",
      "SON", "SONOMA",
      "SR",  "SANTA ROSA",
      "SRO", "SANTA ROSA",
      "SSU", "ROHNERT PARK",
      "TCG", "PETALUMA",
      "TIM", "TIMBER COVE",
      "TSR", "SEA RANCH",
      "TWI", "SEBATOPOL",
      "TWR", "PETALUMA",
      "VFR", "VALLEY FORD",
      "WI",  "WINDSOR",
      "WIN", "WINDSOR",
      "WSR", "SANTA ROSA",

      "BDGA",      "BODEGA",
      "BDGA BAY",  "BODEGA BAY"
  });
  
  private static final String[] CITY_LIST = CITY_CODES.keySet().toArray(new String[CITY_CODES.size()]);
}
