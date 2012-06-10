package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Hanover County, VA
Contact: brian_grimes@verizon.net
Contact: James Mayhew <kc4bpx@gmail.com>
Sender: e911@ps400.hanoverva.org

Subject:(21777) a\nUnit:E12 UnitSts: Inc#:2010-00000919 Inc:MVANoInj Loc:36 S INTERSTATE 295 MapRef:R Map 1591 VEH VS DEER, NO INJS, H
(16407]  a ) Unit:E07 UnitSts: Inc#:2012-00031976 Inc:DifBreathn Loc:7103 NEW HUNTER RD MapRef:R Map 1593 APT 1011 Addtl:DIFF BREATHING
(12716a ) Unit:E07 UnitSts: Inc#:2012-00031961 Inc:Unconscous Loc:7052 MECHANICSVILLE TP MapRef:R Map 1592 PASSED OUT Addtl:
[(7584]  a ) Unit:E07 UnitSts: Inc#:2012-00031934 Inc:VehFire Loc:MECHANICSVILLE TP/BELL CREEK MapRef:R Map 1592 Addtl:IN TURNING LANE, ON FIRE
(5677 a ) Unit:E07 UnitSts: Inc#:2012-00000667 Inc:OutSmall Loc:BELLFLOWER CR/TIFFANY MapRef:R Map 1503 Addtl:WPH2:
[(5243]  a ) Unit:E07 UnitSts: Inc#:2012-00031927 Inc:VehCrash Loc:COLD HARBOR RD/BELL CREEK MapRef:R Map 1594 3 VEH MVA, UNKNW INJURIES Addtl:ONE ON RIGHT
[(3875]  a ) Unit:E07 UnitSts: Inc#:2012-00031920 Inc:OutSmall Loc:MECHANICSVILLE TP/COLONY MapRef:R Map 1592   IN THE MEDIAN SMOKING Addtl:

Contact: support@active911.com
Agency name: Ashland Volunteer Fire Company Location: Ashland, VA 
Sender: e911@ps400.hanoverva.org
((23317) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00020175 Loc:99 N INTERSTATE 95 MapRef:R Map 46 Addtl:WPH2:      PLOTTING TO GET 10-50 LOCATION...
((23457) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084696 Loc:118 WINTER OAK DR MapRef:R Map 98-1 BEEN SICK SINCE LAST NIGHT,LIGHT HEADED, Addtl:BREATHING WIERD
((23568) a ) Unit:E01 UnitSts: Inc:Unknown Inc#:2012-00084697 Loc:314 MACMURDO ST MapRef:R Map 97-2 Addtl:
((23340) a ) Unit:E01 UnitSts: Inc:VehFire Inc#:2012-00020176 Loc:KINGS DOMINION BV DOMINON/INTERSTATE 95 MapRef:R Map 46 Addtl:OVERPASS AREA, L SHOULDER, WB, CAR FIRE...SMOKE...
((23274) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020175 Loc:99 N INTERSTATE 95 MapRef:R Map 46 Addtl:WPH2:      PLOTTING TO GET 10-50 LOCATION...
((24341) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084698 Loc:90 S INTERSTATE 95 MapRef:R Map 98-4 MVA/ RED CAR/ ON LEFT SHOULDER Addtl:
((24387) a ) Unit:E01 UnitSts: Inc:AstSrvCall Inc#:2012-00023808 Loc:HANOVER COURTHOUSE RD/PATRICK HENRY MapRef:R Map 85 TREE DOWN IN THE RDWY BLOCKING 301 Addtl:
((24764) a ) Unit:E01 UnitSts: Inc:Trauma Inc#:2012-00007175 Loc:BLUNTS BRIDGE RD/NEW FOUND MapRef:R Map 66 BICYCLE MVA // UNRESPONSIVE PT Addtl:WPH2:
((24941) a ) Unit:E01 UnitSts: Inc:ChestPain Inc#:2012-00084700 Loc:99 S CARTER RD ROOM 203 MapRef:R Map 83-3 Addtl:WPH2:  LEGS GOING NUMB, CHEST PAINS, CARDIAC HX, BACK PROBLEMS
((25899) a ) Unit:E01 UnitSts: Inc:Diabetic Inc#:2012-00084705 Loc:217 WESLEY ST MapRef:R Map 82-4 Addtl:
((26070) a ) Unit:E01 UnitSts: Inc:AlmMobile Inc#:2012-00084706 Loc:118 BROWN BARK PL MapRef:R Map 98-1 Addtl:
((26174) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00001006 Loc:501 CAROLINE ST MapRef:R Map 82-4 TRACTOR TRL HIT LAMP POLE Addtl:
((26648) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00020178 Loc:16280 INTERNATIONAL ST MapRef:R Map 46 Addtl:
((26652) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00020178 Loc:16280 INTERNATIONAL ST MapRef:R Map 46 Addtl:
((26767) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00050171 Loc:13264 MOUNTAIN RD MapRef:R Map 123 Addtl:
((26944) a ) Unit:E01 UnitSts: Inc:StrAplianc Inc#:2012-00045372 Loc:9416 WINDSOR SHADE DR MapRef:R Map 1271 STOVE FIRE Addtl:VOIP:
((26946) a ) Unit:TK01 UnitSts: Inc:StrAplianc Inc#:2012-00045372 Loc:9416 WINDSOR SHADE DR MapRef:R Map 1271 STOVE FIRE Addtl:VOIP:
((27098) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020179 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 95 N CAR ROLLED OVER FROM THE SOUTHBOUND Addtl:SHOOK
((27132) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00020179 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 95 N CAR ROLLED OVER FROM THE SOUTHBOUND Addtl:SHOOK
((27168) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084707 Loc:12023 ASHCAKE RD MapRef:R Map 96 Addtl:
((27416) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00050172 Loc:13264 MOUNTAIN RD MapRef:R Map 123 Addtl:
((27453) a ) Unit:E01 UnitSts: Inc:EleTrans Inc#:2012-00084709 Loc:401 CAROLINE ST MapRef:R Map 82-4 SHE LOST POWER HEARD A LOUD BANG AND SAW A Addtl:BOLT OF FIRE
((30713) a ) Unit:E01-2 UnitSts: Inc:VehCrash Inc#:2012-00084710 Loc:95.8 N INTERSTATE 95 MapRef:R Map 83-3 Addtl:
((30711) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084710 Loc:95.8 N INTERSTATE 95 MapRef:R Map 83-3 Addtl:
((30877) a ) Unit:E01-2 UnitSts: Inc:StrResd Inc#:2012-00040216 Loc:15357 GREENWOOD CHURCH RD MapRef:R Map 63    SOCET OUTSIDE OF THE AIRCONDITING UNIT Addtl:RES :
((30946) a ) Unit:TK01 UnitSts: Inc:StrResd Inc#:2012-00040216 Loc:15357 GREENWOOD CHURCH RD MapRef:R Map 63    SOCET OUTSIDE OF THE AIRCONDITING UNIT Addtl:RES :
((31199) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020182 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 Addtl:
((32531) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084711 Loc:94 N INTERSTATE 95 MapRef:R Map 83-3 MALE CALLER STATING A VEH RAN OFF THE Addtl:ROAD AND DOWN IN THE WOODS//4 PEOPLE NO INJURES
((33091) a ) Unit:E01 UnitSts: Inc:MAStage Inc#:2012-00020183 Loc:203 CAROLINE ST MapRef:R Map 82-4 Addtl:
((33963) a ) Unit:E01 UnitSts: Inc:Unconscous Inc#:2012-00084714 Loc:101 JUNCTION DR MapRef:R Map 83-3 CHARLES Addtl:BUS :
((36152) a ) Unit:E01 UnitSts: Inc:Poisoning Inc#:2012-00084719 Loc:212 N JAMES ST MapRef:R Map 82-4 Addtl:
((36190) a ) Unit:E01 UnitSts: Inc:OutTransfm Inc#:2012-00084720 Loc:100 N CARTER RD MapRef:R Map 83-3 FIRE OUT ON POLE Addtl:
((36415) a ) Unit:E01 UnitSts: Inc:StrSmokOdr Inc#:2012-00050176 Loc:13418 GREENWOOD RD MapRef:R Map 112 ELECTRICAL FIRE IN THE WALL Addtl:RES :
((36955) a ) Unit:E01 UnitSts: Inc:DifBreathn Inc#:2012-00050177 Loc:13371 WINSTON RD MapRef:R Map 80 DIFF BREATHING Addtl:RES :
((37992) a ) Unit:E01 UnitSts: Inc:StrComm Inc#:2012-00007180 Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:
((38344) a ) Unit:TK01 UnitSts: Inc:StrComm Inc#:2012-00007180 Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:
((39245) a ) Unit:E01 UnitSts: Inc:GasOutside Inc#:2012-00045382 Loc:11700 NORTH LAKERIDGE PK MapRef:R Map 1152 CHECK BEHIND BUILDING REF SMELL OF GAS Addtl:
((39315) a ) Unit:TK01 UnitSts: Inc:GasOutside Inc#:2012-00045382 Loc:11700 NORTH LAKERIDGE PK MapRef:R Map 1152 CHECK BEHIND BUILDING REF SMELL OF GAS Addtl:
((40168) a ) Unit:E01 UnitSts: Inc:Fall Inc#:2012-00007181 Loc:408 EAST OMNI CT MapRef:R Map 83-3 Addtl:WPH2:   HUSBAND FALLEN WHILE COMING DOWN THE STEPS - BACK IS HURTING
((41189) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00001061 Loc:12605 W PATRICK HENRY RD MapRef:R Map 66 1 VEH OVER TURN Addtl:
((41636) a ) Unit:E01 UnitSts: Inc:OutSmall Inc#:2012-00084727 Loc:WINSTON RD/WINSTON ESTATES MapRef:R Map 80 FIELD ON FIRE, ON A DIRT ROAD Addtl:NEXT ROAD PAST THE FIRE TRAINING CENTER
((41805) a ) Unit:B01 UnitSts: Inc:OutSmall Inc#:2012-00084727 Loc:WINSTON RD/WINSTON ESTATES MapRef:R Map 80 FIELD ON FIRE, ON A DIRT ROAD Addtl:NEXT ROAD PAST THE FIRE TRAINING CENTER
((42235) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084728 Loc:W PATRICK HENRY RD/MEDLEY GROVE MapRef:R Map 65 VEH WENT OVER THE SIDE, W/B 54 Addtl:RIGHT PAST PHHS
((42456) a ) Unit:E01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((42576) a ) Unit:TK01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((42695) a ) Unit:SQ01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((43334) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((43392) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((45390) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084733 Loc:145 SOUTH HILL CARTER PK MapRef:R Map 98-1 REQSTNG AMBULANCE Addtl:SHEILA
((46064) a ) Unit:E01 UnitSts: Inc:ChestPain Inc#:2012-00084734 Loc:100 N CARTER RD MapRef:R Map 83-3 42 YOF C/B W/ SLIGHT CHEST PAIN, SWEATING Addtl:AT THE FUEL DESK,
((46324) a ) Unit:E01 UnitSts: Inc:Seizures Inc#:2012-00084735 Loc:11252 GWATHMEY CHURCH RD MapRef:R Map 97-3 MALIE HAVING SEIZURE Addtl:
((46514) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00016157 Loc:MECHANICSVILLE TP/DEER COON MapRef:R Map 1512 MVA / REQ RESCUE Addtl:
((46694) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00045393 Loc:11132 PROGRESS RD STE B MapRef:R Map 1154 Addtl:

((37882) a ) Unit:Q01 UnitSts: Inc:Unknown Inc#:2012-00043119 Loc:11182 TINSLEY DR MapRef:R Map 67 Addtl:
((37936) a ) Unit:E04 UnitSts: Inc#:2012-00001031 Inc:ProQA Loc:14199 WASHINGTON HW MapRef:R Map 68 HEAVY BLACK SMOKE Addtl:
((38154) a ) Unit:M04 UnitSts: Inc#:2012-00007180 Inc:StrComm Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:
((39472) a ) Unit:M04 UnitSts: Inc#:2012-00040228 Inc:Poisoning Loc:15411 ROBERT TERRELL RD MapRef:R Map 51      POSS OVERDOSE//COMBATIVE Addtl:
((50237) a ) Unit:A04 UnitSts: Inc#:2012-00020190 Inc:Assault Loc:9900 DOSWELL RD RM 131 MapRef:R Map 58 Addtl:
((39976) a ) Unit:M04 UnitSts: Inc#:2012-00001054 Inc:Sickness Loc:15102 DEARBORN DR MapRef:R Map 56 Addtl:
((40529) a ) Unit:A04 UnitSts: Inc#:2012-00014113 Inc:VehCrash Loc:VERDON RD/LANDORA BRIDGE MapRef:R Map 14 MC MAN DOWN Addtl:
((42488) a ) Unit:E04 UnitSts: Inc#:2012-00084730 Inc:StrHiLife Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((42693) a ) Unit:Q01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((43410) a ) Unit:Q01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((43505) a ) Unit:E04 UnitSts: Inc#:2012-00045389 Inc:AlmComm Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((44043) a ) Unit:A04 UnitSts: Inc#:2012-00020191 Inc:Sickness Loc:11020 HEMLOCK LN MapRef:R Map 56 Addtl:
((44241) a ) Unit:A04 UnitSts: Inc#:2012-00007182 Inc:Psych Loc:101 OMNI RD MapRef:R Map 83-3 Addtl:EXTREMELY SUICIDAL CRYING ALL DAY AND ALL NIGHT
((44666) a ) Unit:A04 UnitSts: Inc#:2012-00001070 Inc:VehCrash Loc:ENGLAND ST/CARTER MapRef:R Map 83-3 2 VEH NO INJ Addtl:
((44823) a ) Unit:A04 UnitSts: Inc#:2012-00020192 Inc:ChestPain Loc:17107 ENGLISH WALNUT RD MapRef:R Map 33 WIFE IS HAVING TROUBLE BREATHING Addtl:RES :
((45368) a ) Unit:Q01 UnitSts: Inc:Sickness Inc#:2012-00084733 Loc:145 SOUTH HILL CARTER PK MapRef:R Map 98-1 REQSTNG AMBULANCE Addtl:SHEILA
((45781) a ) Unit:Q01 UnitSts: Inc:DifBreathn Inc#:2012-00045391 Loc:9300 FALCON DR MapRef:R Map 1273 Addtl:
((46307) a ) Unit:A04 UnitSts: Inc#:2012-00001072 Inc:Assault Loc:407 ENGLAND ST MapRef:R Map 82-4      YELLING SCREAMING Addtl:WPH2: SOMEONE WAS PUNCHED IN THE FACE
((46337) a ) Unit:Q01 UnitSts: Inc:Seizures Inc#:2012-00084735 Loc:11252 GWATHMEY CHURCH RD MapRef:R Map 97-3 MALIE HAVING SEIZURE Addtl:
((47409) a ) Unit:M04 UnitSts: Inc#:2012-00020193 Inc:ChestPain Loc:16000 THEME PARK WY MapRef:R Map 46 51 YOF / SVT / NO HX 194 PULSE Addtl:144/110 - MINOR CHEST PAIN / ALS AMBULANCE / NO LIGHTS OR SIRENS
((47903) a ) Unit:A04 UnitSts: Inc#:2012-00007183 Inc:Abdominal Loc:101 OMNI RD MapRef:R Map 83-3 OMNI PARK PLACE Addtl:CTX :
((48821) a ) Unit:Q01 UnitSts: Inc:ChestPain Inc#:2012-00052172 Loc:7190 HIGGINS LN MapRef:R Map 162 MOTHER CHEST PAINS,SOB Addtl:


** oddball - not parsing
((23057) a) > E01|ChestPain|16355 LITTLE RIVER DR , Ashland, VA|R Map 44 |WPH2:

 */


public class VAHanoverCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[\\[\\(]?(\\d{4,})[\\)\\] a]*");
  private static final Pattern START_TRASH_PTN = Pattern.compile("^a +[\\)\n]");
    
  
  public VAHanoverCountyParser() {
    super("HANOVER COUNTY", "VA",
           "Unit:UNIT! UnitSts:SKIP! Inc:CALL? Inc#:ID! Inc:CALL? Loc:ADDR! MapRef:MAP");
  }
  
  @Override
  public String getFilter() {
    return "e911@ps400.hanoverva.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    
    match = START_TRASH_PTN.matcher(body);
    if (match.find()) body = body.substring(match.start()).trim();
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("^[A-Z] Map \\d{2,4}(?:-\\d)?\\b");
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_PTN.matcher(field);
      if (!match.find()) abort();
      data.strMap = match.group();
      field = field.substring(match.end()).trim();
      field = field.replace("Addtl:", "-");
      if (field.startsWith("-")) field = field.substring(1).trim();
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      data.strSupp = field;
    }
    
    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }

  @Override
  public String adjustMapAddress(String sAddress) {
    return PK_PTN.matcher(sAddress).replaceAll("PKWY");
  }
  private static final Pattern PK_PTN = Pattern.compile("\\bPK\\b", Pattern.CASE_INSENSITIVE);
}
