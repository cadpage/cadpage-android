package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Southern Software CAD

Jefferson County, TN 
DISPATCH:1718 BROOKLINE CT JEFFERSON CITY 2011-611597 22:43:08  BREATHING DIFFICULTY

Jackson County, NC 
Bill:9783 CHARLEYS CREEK RD TUCKASEGEE MDL 26A03 2011009480 22:20:01 SICK PERSON (SPECIFIC DIAGNOSIS) CALLER ADV SHE HAD HEART SURGERY A LITTLE WHILE AGO AND HER

Brunswick County, NC
349:560 CUMBERLAND ST SE BOLIVIA MDL 09B01 11-020650 17:02:34 Cardiac or Respiratiory Arrest / Death RECV CALL FROM FUNERAL HOME ADVING THAT THEY RECV CALL STATING A FEMALE WAS DEAD AT THIS LOCATION AD
415:111 SE 32ND ST OAK ISLAND VERIZON WIRELESS 7045790781 MDL 09E01 11-025910 20:39:44 Cardiac or Respiratiory Arrest - De
411:22 BOUNDARYLINE DR NW C CALABASH LYNN 9102094924 11-025720 06:59:32 Structure Fire SMELL SOMETHING BURNING IN RESD
399:1295 DECATOR ST SW SUPPLY PAM 9106339368 MDL 09E01 11-025419 22:11:30 Cardiac or RespArrest  CALLER ADV THE PT IS STIFF
428:BAY POINT CT / JENNIS AV FELICIA  9103685110 MDL 27D04 11-026412 21:09:48 Stab-Gunshot-Pen Trauma AT THE END OF  RD .
426:BAY POINT CT-JENNIS AV FELICIA 9103685110 11-026412 21:07:25 Stab-Gun-Trauma AT THE END OF BAYPOINT RD MALE SUBJ IS CUT
415:111 SE 32ND ST OAK ISLAND  7045790781 MDL 09E01 11-025910 20:39:44 Cardiac or Resp Arrest - Death TRANS BY OKI... ADVD TH
411:22 BOUNDARYLINE DR NW C CALABASH LYNN 9102094924 11-025720 06:59:32 Structure Fire SMELL SOMETHING BURNING IN RESD,

Person County, NC
JBROWN:115 CROSS CREEK CT TIMBERLAKE 2011019922 18:27:47 FIRE STOVE
Jason_White:HURDLE MILLS RD / PAYNES TAVERN RD 2011019901 15:46:01 MVA PI CARD 29 car vs motorcycle
Shutchings:GUESS RD / HURDLE MILLS RD 2011019810 00:35:44 MVA PI CARD 29
Shutchings:115 JACOBS-MOORE LN HURDLE MILLS 2011019797 23:05:28 FIRE STRUCTURE FLAMES VISIBLE the house is on fire
Bmelton:HURDLE MILLS RD / POINDEXTER RD 2011019760 17:21:08 TREE DOWN
BGILLISPIE:796 WHEELERS CHURCH RD HURDLE MILLS MDL 10C01 2011019661 05:54:13 CHEST PAIN CARD 10
BROWN:225 CROWN BLVD TIMBERLAKE 2011020040 11:49:49 ALARMS-FIRE design works building 2 general fire alarm adt 8772857397
BOAKLEY:120 N OLD LANTERN RD TIMBERLAKE PLANTERS WAY X INT L/R CARRIAGE LN 18:44:47 FIRE STOVE GAS GRILL PROPANE TANK EXPLODED

Chilton County, AL
120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
COUNTY RD 57 \ COUNTY RD 445 2011039172 06:20:45 WRECK-UNKNOWN INJURIES CALLER STATES ONE VEHICLE OVERTURNED.. ADV THAT THE SUBJECT IS OUT OF THE VEHICLE
120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
100 COUNTY RD 99 LOT 5 VERBENA 2011043298 18:37:55 SHORTNESS OF BREATH GRANDMOTHER ON CHEMO NOT DOING GOOD 
518 COUNTY RD 221 THORSBY 2011046746 06:20:05 DIABETIC RESIDENCE IS A BEIGE DOUBLE WIDE WITH MAROON SHUTTERS. RED TOYOTA AND BLACK DODGE IN THE BACK YARD

Chattam County, NC
HEATHER.BOONE:399 LYNDFIELD CLOSE PITTSBORO MDL 10D04 1119468 18:13:33 Chest Pains- Clammy HUSBAND HAVING CHEST PAINS - EMER
HEATHER.BOONE:791 RED GATE RD PITTSBORO 1119520 05:38:59 medical call HUSBAND OFF BALCONY
LISA.SCOTT:965 SEAFORTH BEACH RD PITTSBORO 1119461 17:08:12 medical call 10YOM WEARING WHITE SHORTS NAMED TRAY LAST SEEN APPROX 4 MINS AGO
KIM.HANNER:858 BRUMLEY PITTSBORO MDL 31C02 1119495 22:11:57 Unconscious / Fainting (Near) Fainting episodes an WIFE PASSED OUT, IS CONS NOW
KIM.HANNER:475 NATURE TRAIL RD CHAPEL HILL 1119504 00:09:15 Convulsions/ Seizures- CONTINUOUS or MULTIPLE seiz PREVIOUS CALL FOR THIS ADDRESS WITH THIS NUMBER GIVEN BY CARY PD UNKNOWN PROBLEM POSSIBLE SEIZURES

Moore County, NC
[[911 NOTIFICATION] ]  505 PINEHURST ST ABERDEEN 2011024766 19:52:16 F69 STRUCTURE FIRE LOOKS LIKE BACK DECK ON FIRE
[[911 NOTIFICATION] ]  1 S. VINELAND SOUTH CELL TOWER 2011025029 09:31:20 M25 PSYCHIATRIC/SUICIDE ATTEMPT
[[911 NOTIFICATION] ]  126 ROBIN HOOD LN ABERDEEN 2011025065 13:37:27 F52 ALARM-FIRE ACTIVATION AC 800 932-3822 OPER SP8
[[911 NOTIFICATION] ]  632 SAND PIT RD ABERDEEN MDL 07A01 2011025721 11:06:58 M7 BURNS/EXPLOSIONS
[[911 NOTIFICATION] ]  218 BERRY ST PINE BLUFF 2011026135 14:36:24 F67 OUTSIDE FIRE/WOODS/BRUSH TREE ON FIRE
[[911 NOTIFICATION] ]  1 E NEW ENGLAND /S PEAR 2011025862 07:31:07 F67 OUTSIDE FIRE/WOODS/BRUSH

Polk County, NC
polkcounty911:767 THERMAL VIEW DR TRYON SMITH 828817313307:38:26 FALL VICTIM 89 YO FEMALE FROM STORY RD TO SKYUKA RD
polkcounty911:1426 HAYES RD COLUMBUS 07:20:59 TREE DOWN CONTS FROM S PEAK ST TO PENIEL RD
polkcounty911:418 S PEAK ST COLUMBUS EARLY, DORIS 8288948807 13:09:13 MEDICAL EMERGEN 86 YO VERY WEAK FROM E MILLS ST AND CONTS AS HAYES RD
polkcounty911:429 LOCKHART RD TRYON RHONDA 828859020509:57:24 MEDICAL EMERGEN 38 YO LEFT LEG PAINNUMB FOOT FROM W HOWARD ST TO LANIER LN
polkcounty911:86 GREENVILLE ST SALUDA PAT 8287494411 13:49:40 CHOKING FEMALE CHOKING FOR PAST HOUR//PALE
polkcounty911:159 LANIER DR COLUMBUS John 8643030507 08:08:08 UNCONSCIOUS 75 yo man with cancer.
polkcounty911:1 GREEN RIVER COVE RD mill spring carol 8288179441 09:52:03 DOWN POWER LINE FROM S NC 9 HWY TO RUTHERFORD CO LINE
Polkcounty911:1733 E US 74 HWY before pea ridge rd MILL SPRING 423637001121:49:01 10-50. June 9, 9:48 PM
polkcounty911:26 KELLY LN MILL SPRING 8288948141 16:50:54 SEIZURES 25 Y/O MALE SEIZING FROM CHIMNEY ROCK RD TO DEAD END. June 10 4:50 PM.
polkcounty911:935 POLK COUNTY LINE RD RUTHERFORDTON BAILY, PHILLIP 8287489222 14:23:05 VEHICLE FIRE 18 WHEELER LOADED WITH LUMBER ON FIRE FROM ROCK SPRINGS. June 11, 2:21 PM.
polkcounty911:4861 E NC 108 HWY MILL SPRING SLIMPLEX GRENELL 888746753911:28:38 FIRE ALARM BUILDING ONE FROM HOUSTON RD/WALKER ST TO RUTHERFORD CO LINE. June 14, 11:29 AM.
polkcounty911:620 BURT BLACKWELL RD MILL SPRING QUANDT, LEONARD & CRYSTAL 8288946023 13:27:52 SMOKE COMPLAINT ACROSS FROM THE ABOVE ADDRESS NEAR DUKE POWER. June 15, 1:28 PM
polkcounty911:1 COLUMBUS FIRE DEPT 2201 17:54:26 STANDBY REQUEST MSFD STANDBY FOR THEM REF RESOURCES DEPLETED. June 18, 5:55 PM
polkcounty911:1 GREEN RIVER COVE RD mill spring carol 8288179441 09:52:03 DOWN POWER LINE FROM S NC 9 HWY TO RUTHERFORD CO LINE. June 19 9:53 AM.

Watauga County, NC
HOWARDS CREEK RD / SUGARLOAF RD FDL 71B01 2011013987 16:02:05 VEHICLE FIRE 421N-RT TATER HILL RD-LT HOWARDS CREEK RD TO SUGARLOAF RD
524 JONES DR BOONE MDL 01A01 2011013875 02:10:09 ABDOMINAL PAIN 194S-CHESTNUT GRV RD-LT COBBS CREEK RD-1ST RT JONES DR
131 BIG VALLEY ST BOONE 2011013813 13:15:57 STRUCTURE FIRE 321S-LT DEERFIELD RD-TRAVEL 2.0 MI-RT BIG VALLEY ST INTO DEERFIELD MEADOWS BUSINESS PARK
200 QUAIL ST BOONE 2011013939 03:11:32 STANDBY
853 HIDDEN VALLEY DR BOONE MDL 09E01 2011013997 20:13:36 ARREST-ADULT 105S-BESIDE HIDDEN VALLEY MOTEL-LT HIDDEN VALLEY DR

Transylvania County, NC
911CENTER:45 OAK PARK DR BREVARD CITY 2011-019677 10:43:54 ALARM FIRE (10-37) alarm fire
911CENTER:2725 RESERVE RD LITTLE RIVER 2011-019735 16:20:13 ALARM FIRE (10-37) FOGLE, JOHN 8288775516 FIRE ALARM SMOKE DETECTOR
911CENTER:1 WHITMIRE ST BREVARD CITY 2011-019863 13:34:30 STRUCTURE FIRE OUTBUILDING ON FIRE
911CENTER:1 N BROAD ST BREVARD CITY 2011-019978 10:22:32 HAZARDOUS MATERIAL INCIDENT GREEN RANGE ROVER LEAKING GAS AT PUMP #7
911CENTER:400 ASHEVILLE HWY BREVARD CITY 2011-020259 13:35:26 BRUSH FIRE MULCH FIRE IN FRONT OF DOMINOS PIZZA
911CENTER:1 ISLAND COVE RD LITTLE RIVER 2011-020447 21:09:42 STRUCTURE FIRE BLACK SMOKE ON ISLAND COVE RD
8595 GREENVILLE HWY CONNESTEE 2011-026771 16:02:18 CHEST PAIN 67 YO FEMALE, POSSIBLY HAVING A HEART ATTACK. 1ST HOUSE ON LT PAST CEDAR MTN HOUSE
313 KNOB RD BREVARD 2011-027203 18:23:45 STRUCTURE FIRE ELECTRICAL FIRE. SECOND HOUSE ON THE LEFT.
21 HONDAH BLVD LAKE HONDAH 2011-027194 17:28:49 STRUCTURE FIRE CALLER ADV A LOT OF SMOKE COMING FROM HIS NEIGHBORS HOUSE.
1 CONNESTEE RD CONNESTEE 2011-027031 14:04:11 HEAD INJURY REF 9 YO HAD BICYCLE ACCIDENT IN FRONT OF THE CHURCH, POSSIBLE HEAD AND ARM INJURY
11 SHERWOOD RIDGE RD SHERWOOD FOREST 2011-027139 10:23:11 UNCONSCIOUS/UNRESPONSIVE female unresp dob 04/07/21 winnie seale

Carteret county, NC 
CEC:303 COLLEGE CIR MOREHEAD CITY FDL 52C03-G 11-090057 12:36:58 ALARM FIRE
CEC:3905 ARENDELL ST MOREHEAD CITY MDL 30B01 11-090021 11:38:14 TRAUMATIC INJURIES
CEC:828 S YAUPON TER MOREHEAD CITY 11-089759 20:36:57 CHECK WELFARE
CEC:3722 BRIDGES ST MOREHEAD CITY MDL 10C04 11-089619 15:13:10 CHEST PAIN
CEC:2714 MAYBERRY LOOP RD MOREHEAD CITY 11-089532 12:03:48 HEAT - COLD EXPOSURE
CEC:1005 YAUPON DR MOREHEAD CITY 11-088667 20:15:44 OUTSIDE FIRE
CEC:3500 ARENDELL ST MOREHEAD CITY 11-089379 04:23:11 TRANSFER (MEDICAL) INTERFACILITY
CEC:3017 BRIDGES ST MOREHEAD CITY 11-086957 13:07:00 STRUCTURE FIRE
CEC:5018 HWY 70 MOREHEAD CITY 11-088596 16:40:33 MVC UNK PI
CEC:BRIDGES ST ST EXT / HWY 70 11-087512 13:54:18 MVC MINOR
CEC:5167 HWY 70 MOREHEAD CITY FDL 60D03-O 11-087553 15:18:54 GAS LEAK - ODOR (LP or Natural Gas)
CEC:11-082100 08:48:00 SICK PERSON WEST WOOD SQUARE APTS 403 BROOK ST E32 MOREHEAD CITY
CEC:11-082157 11:29:34 MVC PI OR ROLLOVER WILCO HESS MHC 4TH ST 400 ARENDELL ST MOREHEAD CITY
CEC:11-082262 16:31:51 STRUCTURE FIRE 4 VINE LN NEWPORT FDL 69D10
CEC:114 CLUB COLONY DR b ATLANTIC BEACH FDL 52B01-G 11-084908 18:06:28 ALARM FIRE
CEC:306 CRAVEN ST BEAUFORT MDL 17B03-G 11-089178 19:42:02 FALLS
CEC:405 WEST BEAUFORT RD BEAUFORT FDL 69D06 11-085673 04:39:22 STRUCTURE FIRE
CEC:HWY 24 / HWY 70 11-088160 17:29:35 MVC PI OR ROLLOVER
CEC:438 MACON CT MOREHEAD CITY MDL 01A01 11-088343 02:36:15 ABDOMINAL PAIN - PROBLEMS
CEC:306 CRAVEN ST BEAUFORT MDL 17B03-G 11-089178 19:42:02 FALLS
CEC:315 FRONT ST BEAUFORT FDL 52C03-G 11-088849 04:01:34 ALARM FIRE
CEC:4035 ARENDELL ST rm 226 MOREHEAD CITY 11-089051 14:12:37 BREATHING PROBLEMS
CEC:1805 ARENDELL ST apt b MOREHEAD CITY MDL 26D01 11-088938 09:43:13 SICK PERSON

Madison County, NC
S: M:TERESA:1 MANOR RD MARS HILL 2011046591 14:24:27 TEST test page
S: M:Randy:16 A AVE HOT SPRINGS 2011046589 13:32:14 STROKE 80 y/o female possible stroke has history
S: M:Randy:590 MEDICAL PARK DR MARSHALL 2011046583 11:27:50 DIFFICULTY IN BREATHING 63 y/o female with copd with difficult
S: M:JOEY:6266 US 25-70 HWY MARSHALL 2011046522 23:38:41 CHEST PAIN 50 Y/O FEMALE CHEST PAINS
S: M:JOEY:31 TWEED RD MARSHALL 2011046509 00:21:13 WILDFIRE SOME TYPE OF FIRE ON TWEED ROAD. THIS IS A THIRD PARTY CALL
S: M:BRETT:717 HENRY TREADWAY RD MARSHALL 2011046457 20:00:32 ROUTINE TRANSPORT 84 y/o female
S: M:BRETT:150 BERRY WILLS RD HOT SPRINGS 2011046451 18:00:17 FALL-WITH INJURIES
S: M:ROBIN:127 MOUNTAIN HAVEN DR MARS HILL 2011046543 10:06:25 SICK CALL MALE LOWER BOWEL INFECTION ( C-DIF ) 64 YOA 1ST D
S: M:ROBIN:193 LUTHER DR MARS HILL 2011046538 06:28:43 IRREGULAR HEART RATE FEMALE 98 YOA LOW BP//IRREGULAR HEART RATE
S: M:AVA:89 NEWGROUND RD MARS HILL 2011046496 15:21:14 LEG PAIN recent  hip surgery complaining of increase in leg pain

Hentry County, VA
480 LEWIS RD MARTINSVILLE 2011095252 12:30:03 RFA-(3) FALL - FRACTURE
2900 DILLONS FORK RD FIELDALE 2011095631 08:16:38 ROV-(2) OVERDOSE
2487 SPRUCE ST MARTINSVILLE 2011095614 06:57:08 RFA-(3) FALL - FRACTURE
1890 DANIELS CREEK RD COLLINSVILLE 2011095584 22:15:45 RSI-(2) SICK
2630 VIRGINIA AVE COLLINSVILLE 2011095480 11:35:03 RDZ-(3) DIZZINESS, WEAKNESS
1385 WINGFIELD ORCHARD RD MARTINSVILLE 2011095447 07:31:58 R3-(1) CHEST PAINS

Botetourt County, VA
SM:167000 INTERSTATE 81 BUCHANAN 12001756 02:03:45 ACCIDENT 10-50 NB SIDE TRACTOR TRAILER WENT DOWN OVER BANK POSS FLIPPED\n\n\nThe information in this e-mail messag
BCH:1078 BRUGHS MILL RD FINCASTLE 12001840 12:35:42 FLUE FIRE CALLING FROM HER IN LAWS. HOME NO IS 992-4197--SHE CHECKED IF ANYONE WAS HOME AND NO ONE ANSWERED.
ARG:158300 INTERSTATE 81 FINCASTLE 12001904 16:01:02 ACCIDENT 10-50 NB / HIT THE GUARDRAIL / WAS ALL OVER THE ROAD BEFORE THAT FOR ABOUT 3 MILES / SAYS HE IS NOT
JBC:TRUCKSTOPS-TRAVEL CENTERS OF AMERICA 2905 LEE HWY TROUTVILLE 12001955 23:03:26 CARDIAC 50 YO M/
SM:1 ROANOKE RD/CATAWBA RD 12002013 20:11:16 CARDIAC WANT TO MEET AT PAPA JOHNS HAVING CHEST PAINS DIFF BREATHING 70 YOM HAS FLUID ON CHEST/WILL BE IN A\n\n\nThe inf

Montgomery County, NC
CAD:DAYS INN 531 EAST MAIN ST 105 BISCOE 14:14:20 ASSAULT - SEXUAL ASSAULT man an woman was fighting and then fm turned on caller.
CAD:1344 NC HWY 109 S MT GILEAD MDL 09E01 19:26:03 CARDIAC OR RESPIRATORY ARREST - DEATH
CAD:1344 NC HWY 109 S MT GILEAD 19:21:52 UNCONSCIOUS - FAINTING (NEAR) E
CAD:348 AUMAN RD BISCOE 17:25:35 ASSAULT - SEXUAL ASSAULT ASSAULT CALLERS SON GAVE FM BLACK EYE

Anson County, NC
1078 SALISBURY ST WADESBORO 2012007703 14:09:41 FIRE STRUCTURE MA 1: ST3 LVILLE MA 2: ST6 POLKTON
0 US HWY 52 N ANSONVILLE 2012007859 15:02:58 ACCIDENT - PERSONAL INJURIES GREY IMPALA IN WOODS
264 MARTIN ST ANSONVILLE MDL 26O21 2012007878 18:02:33 AMBULANCE NEEDED JENNY TYSON MA1: ST 8 BVILLE MA2: ST 6 POLKTON
3263 RANDALL RD POLKTON MDL 10C02 2012007984 16:07:15 CHEST PAIN MA1: ST 8 BVILLE MA2: ST 6 POLKTON
388 JACKS BRANCH RD WADESBORO MDL 10D04 2012007967 07:16:47 CHEST PAIN MA1: ST 8 BVILLE MA2: ST 6 POLKTON

Washington County, VA
NSCOTT:13604 PRICES BRIDGE RD GLADE SPRING SANTANA GALLIHER 2766080200 1220015 23:27:05 MVA IVE BEEN IN A WRECK, I HIT A TREE, MY CAR IS TOTALLED, THE VEHICLE I
LSTRINGER:215 SWEET BRIER ST GLADE SPRING JASON 2764518304 1219928 09:15:17 SICK CALL 30YO FEMALE IS VOMITING, HAS BACK PAIN, FEELS FAINT.
BDULA:228 MIMOSA ST APT A GLADE SPRING SPRINT NEXTEL - CDMA 2764926648 1219900 00:21:44 SICK CALL HE IS STILL SICK AND THROWING UP
LSTRINGER:PETRO TRUCK CENTER 12433 MAPLE ST GLADE SPRING CARDINAL TRAVEL CENTER/JONATHAN 2764296000 1219922 07:26:55 AMBULANCE NEEDED INCOHERENT FEMALE, POSS.
MEVANS:11585 MOUNT CALM DR APT 8 GLADE SPRING WEBB,CYNTHIA 2766950260 1219667 14:52:22 SICK CALL 62 YO MALE SHORT OF BREATH AND HURTS TO COUGH
NSCOTT:13604 PRICES BRIDGE RD GLADE SPRING SANTANA GALLIHER 2766080200 1220015 23:27:05 MVA IVE BEEN IN A WRECK, I HIT A TREE, MY CAR IS TOTALLED, THE VEHICLE I
TRAINEE_1:33137 LIGHTHOUSE HILL GLADE SPRING MILLER, BRENDA 2764964267 1219961 15:38:46 TREE DOWN CALLER ADVISED THAT A TREE HAS FALLEN ON THE POWER LINE AND BDULA:228 MIMOSA ST GLADE SPRING SPRINT NEXTEL - CDMA 1219760 01:25:30 SICK CALL HE IS THROWING UP HE IS 51 YEARS OLD
DHARTSOCK:304 EVERGREEN ST GLADE SPRING SMITH, P N 2764295639 1219281 09:38:45 AMBULANCE NEEDED 73 Y/O FEMALE HIGH BP AND HAVING CHANGES IN VISION NEEDS TO G
JMARTIN:32497 CLINCHBURG RD MEADOWVIEW CRUEY, JANE S 2769445787 1218968 09:18:26 STROKE CALLER STATES HIS DAD IS HAVING A STROKE
DHARTSOCK:30077 HILLMAN HWY MEADOWVIEW ASSISTED LVNG,SERENITY 2769444300 1218276 07:15:01 SEIZURES 39 Y/O FEMALE SEIZURES NEED AN AMBULAN
OARNOLD:12433 MAPLE ST GLADE SPRING CARDINAL TRAVEL CENTER 2764296000 1215775 11:35:56 SEIZURES HAVE A MALE IN THE BATH ROOM HAVING A SEIZURES NP
OARNOLD:13168 MEADOWVIEW SQ MEADOWVIEW SOUTHWEST VIRGINIA COMMUNITY/DONNA KENESTER 2765251632 1212903 16:11:00 HEADACHE BAD HEAD ACHE NP
MEVANS:33573 CROWEVILLE DR GLADE SPRING BAILEY, JOHNNY C 2764295596 1218704 20:34:45 SICK CALL 83YO MALE BAD STOMACH ISSUES AND HURTING IN H

*/

public class DispatchSouthernParser extends SmartAddressParser {
  
  // Flag indicating  a leading dispatch name is required
  public static final int DSFLAG_DISPATCH_ID = 0x01;
  
  // Flag indicating a leading dispatch name is optional
  public static final int DSFLAG_OPT_DISPATCH_ID = 0x02;
  
  // Flag indicate a unit designation follows the time stamp
  public static final int DSFLAG_UNIT = 0x04;
  
  // Flag indicating that the call ID is optional
  public static final int DSFLAG_ID_OPTIONAL = 0x08;
  
  // Flag indicating a place name may precede the address
  // And Name/Phone number follows address
  public static final int DSFLAG_LEAD_PLACE = 0x010;
  
  // Flag indicating cross street information follows the address instead of
  // the usual name & phone
  public static final int DSFLAG_FOLLOW_CROSS = 0x20;
  
  private static final Pattern LEAD_PTN = Pattern.compile("^[\\w\\.]+:");
  private static final Pattern ID_TIME_PTN = Pattern.compile("\\b(\\d{2,4}-?\\d{4,8}) (\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final Pattern OPT_ID_TIME_PTN = Pattern.compile("\\b(?:(\\d{2,4}-?\\d{4,8}) )?(\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final Pattern CALL_PTN = Pattern.compile("^[A-Z0-9\\- /]+\\b");
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");

  private Pattern idTimePattern;
  private boolean leadDispatch;
  private boolean optDispatch;
  private boolean unitId;
  private boolean inclPlace;
  private boolean inclCross;
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState) {
    this(cityList, defCity, defState, DSFLAG_DISPATCH_ID);
  }
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState, int flags) {
    super(cityList, defCity, defState);
    this.leadDispatch = (flags & DSFLAG_DISPATCH_ID) != 0;
    this.optDispatch = (flags & DSFLAG_OPT_DISPATCH_ID) != 0;
    this.unitId = (flags & DSFLAG_UNIT) != 0;
    this.idTimePattern = (flags & DSFLAG_ID_OPTIONAL) != 0 ? OPT_ID_TIME_PTN : ID_TIME_PTN;
    this.inclPlace = (flags &  DSFLAG_LEAD_PLACE) != 0;
    this.inclCross = (flags & DSFLAG_FOLLOW_CROSS) != 0;
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Message must always start with dispatcher ID, which we promptly discard
    if (leadDispatch || optDispatch) {
      Matcher match = LEAD_PTN.matcher(body);
      if (match.find()) {
        body = body.substring(match.end()).trim();
      } else if (!optDispatch) return false;
    }
    
    // find an ID/Time pattern which splits the message into two fields
    Matcher match = idTimePattern.matcher(body);
    if (!match.find()) return false;
    
    data.strCallId = getOptGroup(match.group(1));
    data.strTime = match.group(2);
    String sAddr = body.substring(0,match.start()).trim();
    String sExtra = body.substring(match.end()).trim();
    
    if (sAddr.length() > 0) {
      parseMain(sAddr, data);
      parseExtra(sExtra, data);
    } else {
      parseExtra2(sExtra, data);
    }
    return true;
  }

  protected void parseMain(String sAddr, Data data) {
    // First half contains address, optional place/name, and possibly an MDL call code
    Parser p = new Parser(sAddr);
    data.strCode = p.getLastOptional(" MDL ");
    if (data.strCode.length() == 0) data.strCode = p.getLastOptional(" FDL ");
    sAddr = p.get();
    StartType st = (inclPlace ? StartType.START_PLACE : StartType.START_ADDR);
    int flags = (inclCross ? FLAG_CROSS_FOLLOWS : 0);
    parseAddress(st, flags, sAddr, data);
    String sLeft = getLeft();
    
    // Processing what is left gets complicated
    // if cross street information follows the address, process that
    if (inclCross) {
      data.strCross = sLeft.replace(" X ", " / ");
    }
    
    // Otherwise, if the place name isn't located in front of the address
    // assume whatever follows it is a place name
    else if (!inclPlace) {
      data.strPlace = sLeft;
    }

    // Otherwise assume it is a name followed by an optional phone number
    else {
      Matcher match = PHONE_PTN.matcher(sLeft);
      if (match.find()) {
        data.strPhone = match.group();
        sLeft = sLeft.substring(0,match.start()).trim();
      }
      data.strName = sLeft;
    }
  }

  protected void parseExtra(String sExtra, Data data) {

    // Second half May contain unit ID,
    // then call description and long call description
    // Call description comes first and contains only upper case letters and numbers
    Matcher match;
    Parser p;
    if (unitId) {
      p = new Parser(sExtra);
      data.strUnit = p.get(' ');
      sExtra = p.get();
    }
    match = CALL_PTN.matcher(sExtra);
    if (match.find()) {
      String sCall = match.group().trim();
      if (sCall.length() <= 20) {
        data.strCall = sCall;
        sExtra = sExtra.substring(match.end()).trim();
      }
    }
    data.strSupp = sExtra;
    if (data.strCall.length() == 0 && data.strSupp.length() == 0) data.strCall= "ALERT";
  }

  protected void parseExtra2(String sExtra, Data data) {
    // First half contains address, optional place/name, and possibly an MDL call code
    Parser p = new Parser(sExtra);
    data.strCode = p.getLastOptional(" MDL ");
    if (data.strCode.length() == 0) data.strCode =p.getLastOptional(" FDL ");
    sExtra = p.get();
    parseAddress(StartType.START_CALL, sExtra, data);
    data.strSupp = getLeft();
  }
}
