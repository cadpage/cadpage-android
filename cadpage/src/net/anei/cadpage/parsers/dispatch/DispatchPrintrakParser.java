package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/***
Lehigh County PA
ST0100 TYP: RESP DIST-ABN BREATH APT: 8 AD: 4015 SCHOENECK RD CTY: LOWER MACUNGIE LOC: BIG O MHP CN: NURSE JULIE CMT1: **CHARLIE BREATHING PROBLEMS - ABNORMAL REATHING CMT2: 57 YEAR OLD MALE | 502 LBS | FULL OF FLUID | BLOOD IN STOOL | TIME: 10:11 UNTS: FD/30CHIEFS FD/ST01 XST2: MOUNTAIN RD
ST0100 TYP: NON-DWELL STRUCTURE AD: 8635 HENSINGERSVILLE RD CTY: 06 LONGSWAMP CMT1: **NON-DWELLING STRUCTURE FIRE (SHED, DETATCHED GARAGE) CMT2: FULLY INVOLVED STRUCTURE FIRE TIME: 01:37 UNTS: FD/ST01 XST: WALKER RD XST2: 8603 OAK HOLLOW LN
ST0100 TYP: APARTMENT BLDG FIRE AD: 2130 STATE ST CTY: 06 LONGSWAMP CN: BERKS CMT1: **APARTMENT BUILDING FIRE (MULTI-OCCUPANCY RESIDENTIAL) CMT2: REQ ST 01 WIT BERKS ST21 SMOKE FROM BASEMENT IN APT BUILDING TIME: 14:22 UNTS: FD/E111 XST: 175 SCHLOSSBURG ST XST2: 380 JAMES LN
ST0100 TYP: TRAFFIC CONTROL AD: CHURCH ST&THOMAS ST CTY: ALBURTIS LOC: ON THOMAS CN: RONALD CONRAD CMT1: **TRAFFIC CONTROL CMT2: ASST WITH WATER MAIN TIME: 08:
ST0100 TYP: MVA WITH RESCUE AD: S RT100&SCHANTZ RD CTY: UPPER MACUNGIE CN: TIM MARTIN CMT1: **BRAVO MVA - WITH INJURIES CMT2: PER PASSERBY AIRBAGS DEPLOYED TIM 14:06 UNTS: FD/ST25 FD/A6295 FD/E2511 FD/R141 FD/06R21
ST0100 TYP: RESCUE-SPECIFY TYPE AD: GAP RD&WALKER RD CTY: 06 LONGSWAMP CN: BERKS CMT1: **DELTA TRENCH COLLAPSE WITH RESCUE (ALERT RESCUE TONES) CMT2: ST 1 AND T66 WITH ATV RIGHT ON TO WALKER TO THE DEAD END BERK EMS AND FI TIME: 02:19 UNTS: FD/E112
ST3000 TYP: FD STANDBY AT OWN ST AD: ALLENTOWN FD CTY: ALLENTOWN LOC: ALLENTOWN FD CMT1: **FIRE STANDBY - AT OWN STATION CMT2: Original Location : ALLENTOWN FD TIME: 17:43 UNTS: FD/E3711 FD/E3012 FD/E1112 FD/E3112 FD/TK231 FD/E2711 FD/R1141&nbsp;
ST3000 TYP: EMS ASSIST AD: 3510 MACUNGIE RD CTY: LOWER MACUNGIE CN: JARRETT DENNIS CMT1: **ECHO CARDIAC ARREST - NOT BREATHING CMT2: 0010001030 WIFE WONT WAKE UP SNORING RESP 55 YEAR OLD FEMALE UNCONSCIO TIME: 10:07 UNTS: FD/30CHIEFS FD/ST30 XST: 3157 WATERMILL DR XST2: 5248 INDIAN CREEK RD
ST3000 TYP: SMOKE IN DWELLING AD: 2008 ELBOW LN CTY: LOWER MACUNGIE CN: LINDA STROHL CMT1: **SMOKE IN THE DWELLING CMT2: SMOKE COMING FROM THE EXHAUST PIPE OF HEATING SYSTEM FILLING BASEMENT WIT TIME: 06:58 UNTS: FD/30CHIEFS FD/ST30 FD/A6681 FD/ST66 FD/R3041 FD/E3012 FD/TK3031 FD/E3112 XST: 4486 REDWOOD LN XST2: HESS CIR
ST6651 TYP: NON-DWELL STRUCTURE AD: 8635 HENSINGERSVILLE RD CTY: 06 LONGSWAMP CMT1: **NON-DWELLING STRUCTURE FIRE (SHED, DETATCHED GARAGE) CMT2: FULLY INVOLVED STRUCTURE FIRE TIME: 01:37 UNTS: FD/6651 XST: WALKER RD XST2: 8603 OAK HOLLOW LN
ST3000 TYP: CHIMNEY FIRE AD: 6043 LOWER MACUNGIE RD CTY: LOWER MACUNGIE LOC: LOWER MACUNGIE ELEMENTARY CN: MR FELDMAN CMT1: **CHIMNEY FIRE CMT2: SMOKE COMING FROM THE CHIMNEY TIME: 22:09 UNTS: FD/30CHIEFS FD/ST30 FD/ST66 FD/A6683 FD/E3012 FD/TK3031 FD/R3041 FD/E2511 XST: S KROCKS RD XST2: SPRING CREEK RD
ST3000 TYP: UNCONSC-EFFECTIVE BR AD: 7547 CATALPA DR CTY: LOWER MACUNGIE CN: DAVE KOWALICK CMT1: **DELTA UNCONSCIOUS - EFFECTIVE BREATHING CMT2: 0110000513 UNCON 30 YEAR OLD MALE UNCONSCIOUS BREATHING STATUS UNKNOW TIME: 19:30 UNTS: FD/R3041 XST: WOODBINE RD XST2: RED OAK LN
ST3000 TYP: STRUCT/DWELL-UNK SIT AD: SPRINGHOUSE RD&amp;TREXLER BLVD CTY: SOUTH WHITEHALL LOC: . CN: CHRIS BENALE CMT1: **STRUCTURE OR&nbsp;DWELLING FIRE - UNKNOWN SITUATION CMT2: ABANDONED BARN WITH SMOKE COMING OUT OFROOF CAN SEE FLAMES ALSO TIME: 14:45 UNTS: FD/TK3031
ST3000 TYP: ALARM-FIRE-DWELLING AD: 4129 FAWN TRAIL RD CTY: SOUTH WHITEHALL LOC: CRON RES 610-530-0708 CN: OPER MANDI CMT1: **RESIDENTIAL FIRE ALARM - SINGLE-FAMILY OCCUPANCY CMT2: ZONE 6 SMOKE DETECTOR / ATTEMPTED KEYHOLDER TIME: 17:49 UNTS: FD/ST32 FD/E3212&nbsp;FD/TA3221 FD/SP3291 FD/E1111 FD/TK3031 FD/R1141 XST: 1382 BUCK TRAIL RD XST2: 1386 DOE TRAIL RD
ST3000 TYP: SPILL &lt;50 GAL UNCNTD AD: KROCKS RD&amp;HAMILTON BLVD CTY: LOWER MACUNGIE CN: JAMES FOREMAN CMT1: **BRAVO MVA - WITH INJURIES CMT2: TWO VEHICLES / ONE FEMALE 40'S POSS BROKEN NOSE TIME: 16:13 UNTS: FD/30CHIEFS FD/ST30
This one's on the PA Turnpike (I-476 at mile marker 57.4 NB).. You'll see how it's put in here with the mile marker:
ST3000 TYP: MVA-ROLLOVER AD: I476MM57 4NB CTY: SOUTH WHITEHALL LOC: I476MM57 4NB CMT1: **DELTA MVA WITH ROLLOVER CMT2: ONE VEHICLE&nbsp;ON THE TURNPIKE ANOTHER POSSIBLY FLIPPED OVER THE GUARDRAIL TIME: 11:57 UNTS: FD/30CHIEFS FD/ST30 FD/A6298 FD/ST62MN FD/R3041 FD/E3012 XST: TILGHMAN ST XST2: RT22
ST3000 TYP: MVA WITH RESCUE AD: WILD CHERRY LN&amp;VALLEY STREAM L CTY: LOWER MACUNGIE CN: DALE METZGER CMT1: **DELTA MVA WITH RESCUE (ALERT RESCUE TONES AS NECESSARY) CMT2: VEHICLE HIT HTE BRIDGE | MALE TRAPPED INTHE VEHICLE TIME: 07:04 UNTS: FD/30CHIEFS FD/ST30&nbsp;FD/A6682 FD/ST66 FD/E3012 FD/R3041

Orange County, NY
DEPTWK     TYP: MVA- UNKNOWN STATUS AD: ST RTE 17 W&EXIT 120 W OFF CTY: WALLKILL CN: RICHARD CMT1: CALLER REPORTS A 2 CAR MV
DEPTWK     TYP: FALLS APT: 621 AD: 121 DUNNING RD CTY: WALLKILL CN: MARGARET TENNISON CMT1: MVISITOR FELL IN PT ROOM ARM AND
DEPTWK     TYP: PSYCH EMERG BLD: 10 APT: 13B AD: 92 FITZGERALD DR CTY: WALLKILL CN: TRACZ, CAROLINE CMT1: "SEND AS AN ALPHA
DEPTWK     TYP: MVA WITH INJURIES AD: 637 ST RTE 211 W CTY: WALLKILL CN: PAULIE SMITH CMT1: CAR OFF ROADWAY UNK INJURIES TIM
DEPTWK     TYP: POISONING/OVERDOSE APT: 124 AD: 563 ST RTE 211 E CTY: WALLKILL CN: CARMINE AT THE DESK CMT1: MALE AUBJECT TR
DEPTPB     TYP: MEDICAL ASSISTANCE AD: ST RTE 302&BRUYN AVE CTY: CRAWFORD CMT1: Parent Inc F35110110000013 UPDATE PriUnt to
DEPTWK     TYP: ASSAULT AD: 470 ST RTE 211 E CTY: WALLKILL CN: HOPE TOTTEN CMT1: WAS PUNCHED IN THE BACK OF THE HEAD BY CUST
DEPTWK     TYP: TRAUMA APT: 312 AD: 455 SCHUTT ROAD EXT CTY: WALLKILL CN: CODY, MARY PRATT CMT1: "SEND AS AN ALPHA RESPONSE"
DEPTWK     TYP: MVA- UNKNOWN STATUS AD: 470 ST RTE 211 E CTY: WALLKILL CN: AMBER CMT1: 1 CAR INTO A POLE WITH AIRBAG DEPLOYM
DEPTWK     TYP: PSYCH EMERG- VIOLENT BLD: 1 APT: 1A AD: 35 SILVER LAKE SCOTCHTOWN RD CTY: WALLKILL CN: VON HON MEGGAN CMT1:
DEPTWK     TYP: MEDICAL ASSISTANCE AD: 601 E MAIN ST CTY: WALLKILL CN: SAMANTHA ORTIZ CMT1: INCIDENT CLONED FROM PARENT: LTW
DEPTPB     TYP: TRAUMA AD: 2 CHURCH ST CTY: CRAWFORD CN: KAYLA CMT1: MGIRL WAS HIT IN THE FACE NOSE BLEEDING 18 YEAR OLD FEM
DEPTWK     TYP: DIABETIC PROBLEMS APT: 309 AD: 455 SCHUTT ROAD EXT CTY: WALLKILL CN: BOSCO, JOAN CMT1: DIABETIC PROBLEMS 78
DEPTWK     TYP: MVA WITH INJURIES AD: ST RTE 211 E&EXIT 120 W OFF CTY: WALLKILL CN: MARGRET BUTLER JOHNS CMT1: 2 CAR NO WITH
DEPTPB     TYP: MEDICAL ASSISTANCE AD: 3105 ST RTE 52 CTY: ULSTER CN: ULSTER CMT1: 63 Y/O/M DIFF BREATHING/CHEST PAIN CMT2:
DEPTPB     TYP: MEDICAL ASSISTANCE AD: CO RTE 48&ST RTE 302 CTY: CRAWFORD CMT1: PT WITH RIB INJURIES / 2ND TO MVA/ USE EXTRE
DEPTWK     TYP: MEDICAL ASSISTANCE AD: 455 SCHUTT ROAD EXT CTY: WALLKILL CN: MOBILE LIFE CMT1: EVALUATION FROM MVA CMT2: Ori
DEPTWK     TYP: MVA- UNKNOWN STATUS AD: ST RTE 211 E&EXIT 120 E ON CTY: WALLKILL CN: ROSEALEE CMT1: 3 CAR MVA /// CALLER C/O
DEPTWK     TYP: LIFTING ASSISTANCE BLD: 10 APT: 13B AD: 92 FITZGERALD DR CTY: WALLKILL CN: TRACZ, CAROLINE CMT1: "SEND AS AN

email:
DEPTPB          TYP: MEDICAL ASSISTANCE AD: 1015 INDIAN SPRINGS RD CN: ULSTER 911 CMT1: REGISTRO RD AND REDDER RD / 67/M UPPER ABDOMIAL PAIN-ALS CALL / WALKER VA CMT2: LLEY FIRE DISTRICT TIME: 14:44

Calumet County, WI
HAFR       PRI: 1 INC: FHA110114000008 TYP: RESCUE ADVANCED LIFE AD: N8016 PIGEON RD CTY: CMSV CN: BRUSE CMT1: 11 MONTH OLD INFANT WITH SOMETHING STUCK I
BUFD       PRI: 1 INC: FBU110115000010 TYP: ACCIDENT - C AD: CTY TK CE&OUTAGAMIE RD CTY: BUCT CN: KARNER,BEN CMT1: ***IF 2191 OR 2192 IS RESPONDING ALSO
HAFR       PRI: 1 INC: FHA110116000010 TYP: RESCUE ADVANCED LIFE AD: W5872 EASTER LILY DR CTY: CMTH CN: SWEERE, SHANNON CMT1: 13YOA FEMALE BAD

Lee County, FL
10116004231 TYP: SEIZURES AD: 1051 FIFTH ST CTY: FT MYERS BEACH LOC: LIGHTHOUSE RESORT TIKI BAR CN: VERIZON WIRELESS CMT1: CONVULSIONS / ZURES CMT2: Original Location : LIGHTHOUSE RESORT TIKI BAR TIME: 16:34 FBFBA32 FBFBE31 XST: 1 MATANZAS BRIDGE XST2: 1067 FOURTH ST
10116004116 TYP: BREATHING PROBLEM AD: 11610 DOGWOOD LN CTY: FT MYERS BEACH LOC: BAYSIDE ESTATES CN: KESTLER, BARBARA CMT1: BREATHING PRO MS CMT2: Original Location : BAYSIDE ESTATES TIME: 08:35 FBFBA32 FBFBE33XST: 17681 EGLANTINE LN
10118004821 TYP: CHEST PAINS AD: 885 ARAPAHO TRL CTY: FORT MYERS LOC: INDIAN CREEK CN: HANKS, ROBIN & DEAN CMT1: CHEST PAIN (NON TRAUMATI CMT2: Original Location : INDIAN CREEK TIME: 18:29 FBFBA32 FBFBE33 XST: 1205 SHASTA TRL XST2: 1211 SHASTA TRL
110118004875 TYP: GENERAL ILLNESS APT: 114 AD: 17761 SAN CARLOS BLVD CTY: FT MYERS BEACH LOC: TAHITIAN INN CN: LCSO - CHELSEA CMT1 ICK PERSON (SPECIFIC DIAGNOSIS) CMT2: Original Location : TAHITIAN INN TIME: 22:56 FBFBA32 FBFBE33 XST: 17605 BROADWAY AVE XST2: 11891 IS
10119005036 TYP: FALL AD: 1131 FIRST ST CTY: FT MYERS BEACH LOC: NERVOUS NELLIE'S WATERFRONT CN: NERVOUS NELLIE'S WAT CMT1: 1) MPDS TYPE
10119005092 TYP: OD / POISONING AD: 71 AVENUE C CTY: FT MYERS BEACH LOC: PKG LOT CN: AT&T MOBILITY CMT1: OVERDOSE / POISONING (INGESTION) CMT2: Original Location : PKG LOT TIME: 17:27 FBFBA33 FBFBE31 XST2: 1511 ESTERO BLVD
10119005122 TYP: HEMORRHAGE APT: 535 AD: 8350 ESTERO BLVD CTY: FT MYERS BEACH LOC: CARLOS POINT CONDOS CN: VERIZON WIRELESS CMT1: HEMORRH / LACERATIONS CMT2: Original Location : CARLOS POINT CONDOS TIME: 20:38FBFBA33 FBFBTK33 XST: 99 TARPON RD XST2: 111 ESTRELLITA DR
10119005132 TYP: FAINTING APT: 4 AD: 2370 ESTERO BLVD CTY: FT MYERS BEACH CN: METRO PCS CMT1: 1) MPDS TYPE (2?) CMT2: 38 YEAR OLD FEMALE SCIOUS BREATHING UNCONSCIOUS / FAINTING (NEAR) TIME: 21:51 FBFBA32 FBFBE31 XST: 111 MANGO ST XST2: 81 MANGO ST
10120005323 TYP: FALL AD: 3001 ESTERO BLVD CTY: FT MYERS BEACH LOC: RED COCONUT RV PARK CN: VERIZON WIRELESS CMT1: FALLS CMT2: Original L RED COCONUT RV PARK TIME: 15:54 FBFBA33 FBFBE31 XST: 1 GULF VIEW COLONY XST2: 930 SAND DOLLAR DR
10120005404 TYP: CHEST PAINS AD: 17861 PEPPARD DR CTY: FT MYERS BEACH CN: AT&T MOBILITY CMT1: CHEST PAIN (NON TRAUMATIC) CMT2: 70 YEAR OL EMALE CONSCIOUS BREATHING CHEST PAIN (NON-TRAUMATIC) TIME: 20:33 FBFBA32FBFBE33 XST: 11211 AZALEA LN


Lee County, FL added as well

***/

public class DispatchPrintrakParser extends FieldProgramParser {
  
  public DispatchPrintrakParser(String defCity, String defState) {
    this(null, defCity, defState, null);
  }
  
  public DispatchPrintrakParser(String defCity, String defState, String expTerm) {
    this(null, defCity, defState, expTerm);
  }
  
  public DispatchPrintrakParser(Properties cityCodes, String defCity, String defState) {
    this(cityCodes, defCity, defState, null);
  }
  
  public DispatchPrintrakParser(Properties cityCodes, String defCity, String defState, String expTerm) {
    super(cityCodes, defCity, defState,
          setExpectFlag("SRC PRI:SKIP INC:ID TYP:CALL! BLD:APT APT:APT AD:ADDR! CTY:CITY LOC:PLACE CN:NAME CMT1:INFO CMT2:INFO TIME:SKIP UNTS:UNIT XST:X XST2:X", expTerm));
  }
  
  private class MyAptField extends AptField {
    
    @Override
    public void parse(String field, Data data) {
      data.strApt = append(data.strApt, "-", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
}
