package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;


/* 
Chester County, PA (variant D5)
Contact: Active911
Agency name: Malvern Fire Company Location: Malvern, PA 
Sender: messaging@iamresponding.com

(MFC) GSHF ** 01:19 ** RESPIRATORY DIFFICULTY - ALS * ** 317 DEVON WY ,53 ** - ** DEVON LA & DEVON WY ** 5684 ** EGOSHN ** 60/F - HAVING ANXIETY, SOB\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) MALF ** 08:24 ** CVA/STROKE - ALS * ** 414 PAOLI PK ,54 ** 2ND FLR, M ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** 85 YOA/F - LEFT SIDED WEAKNESS\n\nDETAILS TO FOLLOW\n ** \nFrom: messaging@emergencysmc.com
(MFC) EWHF ** 11:00 ** ABDOMINAL PAIN - ALS * ** 477 LANCASTER AV ,42 ** SLEEPY'S- ** ASPEN LA & CHARLES ST ** 0501 ** EWHITE ** 46/M--PAIN IN STOMACH--HAVING RESPDIF\n\nDETAILS TO ** 
(MFC) PLIF ** 11:27 ** RESPIRATORY DIFFICULTY - ALS * ** 2 INDUSTRIAL BL ,54 ** SUITE 110, ** W CENTRAL AV & INDUSTRIAL ** 0314 ** WILLIS ** COME IN ENTRANCE 'C" FOR BEST ACCESS. 80 YOA/F\n\n/ ** 
(MFC) PLIF ** 11:50 ** HYPO TENSION - ALS * ** 600 PAOLI POINTE DR ,43 ** ROOM 105-H ** DEAD END & E CENTRAL AV ** 0303 ** TREDYF ** 92/F 90/56\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) BERF ** 12:04 ** SEIZURES - ALS * ** 200 W SWEDESFORD RD ,43 ** INSIDE BIG ** N VALLEY FORGE RD & CONTE ** 0271 ** TREDYF ** 40'S/M\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) MALF ** 14:01 ** CVA/STROKE - ALS * ** 414 PAOLI PK ,54 ** RM 320--OA ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** 84/M\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) EWHF ** 17:53 ** RESPIRATORY DIFFICULTY - ALS * ** 1145 KING RD ,42 ** -CAMILLA H ** GILLET DR & IMMACULATA DR ** 0599 ** EWHITE ** 17/F--\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) MALF ** 21:28 ** INJURED PERSON - BLS * ** 131 PROSPECT AV ,02 ** - ** MONUMENT AV & W FIRST AV ** 0401 ** MALVRN ** 67/F--INJ TOE\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) PLIF ** 21:49 ** CVA/STROKE - ALS * ** 139 SPRUCE LA ,54 ** - ** PINE TREE RD & DEVON RD ** 0305 ** WILLIS ** 50S/M POSS STROKE, DROOPING MOUTH ON ONE SIDE\n\nDET ** 
(MFC) GSHF ** 22:08 ** HEMORRHAGING - ALS * ** 1361 BOOT RD ,53 ** RM 237-WEL ** CARRIAGE DR & JACLYN DR ** 5684 ** EGOSHN ** 87/M\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) MALF ** 23:22 ** FALLS - BLS / LIFT ASSIST * ** 324 LANCASTER AV ,54 ** REMENISCEN ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS ** 94/M\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) MALF ** 23:54 ** EMOTIONAL DISORDER - BLS * ** 940 KING RD ,53 ** RM 109-MAL ** MUNICIPAL BOUNDARY & MADE ** 0488 ** EGOSHN ** 48/F SUICIDAL THOUGHTS\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) EWHF ** 08:30 ** SYNCOPE/FAINTING - ALS * ** 1 TANGLEWOOD LA ,42 ** USE FRT DO ** SUMMIT RD & DEAD END ** 0503 ** EWHITE ** 71/F\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) GSHF ** 09:02 ** HOUSE FIRE * ** 1000 HERSHEY MILL RD ,53 ** - ** MILLSTREAM DR & TANGLEWOO ** 5603 ** EGOSHN ** SIDE OF HOUSE ON FIRE FROM CIGARETTE BUTT\n\nDETAILS ** 
(MFC) GSHF ** 09:36 ** FALLS - BLS / LIFT ASSIST * ** 1615 E BOOT RD ,53 ** AT REAR EN ** N CHESTER RD & APPLEBROOK ** 5655 ** EGOSHN ** PAIN IN SHOULDER, FROM STANDING, 90/M\n\nDETAILS TO ** \nFrom: messaging@emergencysmc.com
(MFC) EWHF ** 18:26 ** RESPIRATORY DIFFICULTY - ALS * ** 6 WATERS RD ,42 ** - ** SUMMIT RD & DEAD END ** 0503 ** EWHITE ** 95F HI TEMP, RESP DIFF\n\n ** 
(MFC) MALF ** 19:03 ** BRUSH FIRE * ** 35 LANDMARK DR ,02 ** JUST PAST ** DEAD END & N SUGARTOWN RD ** 0401 ** MALVRN ** PINENEEDLES SET ON FIRE BY JUVS\n\nDETAILS TO FOLLOW ** 
(MFC) PLIF ** 19:26 ** FALLS - ALS * ** 18 COBBLESTONE DR ,54 ** - ** MUNICIPAL BOUNDARY & MUNI ** 0305 ** WILLIS ** 57/M FELL FROM 2 STORY ROOF\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) EWHF ** 00:57 ** FALLS - BLS / LIFT ASSIST * ** 4 OAK HILL CI ,42 ** - ** SUMMIT RD & FOREST WY ** 0503 ** EWHITE ** **LIFT ASSIST ONLY***90/M\n\n ** 
(MFC) MALF ** 06:59 ** UNRESPONSIVE PERSON - ALS * ** 308 CHARLESTON GREENE ,02 ** - ** DEAD END & W KING ST ** 0481 ** MALVRN ** 70/M\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) EWHF ** 14:16 ** UNCONSCIOUS PERSON - ALS * ** 235 LANCASTER AV ,42 ** QVC STORE- ** MALIN RD & MAPLE LINDEN L ** 0505 ** EWHITE ** 18 MONTH/F -\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) MALF ** 15:35 ** RESPIRATORY DIFFICULTY - ALS * ** 324 LANCASTER AV ,54 ** 1ST FLOOR ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS ** 74/F\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) MALF ** 18:43 ** ALARM - FIRE * ** 105 MOUNTAIN LAUREL LA ,02 ** SIEGEL RES ** OLD LINCOLN HW & DEAD END ** 0401 ** MALVRN ** AFA--FIRST FLOOR AND BASEMENT SMOKE DETECTOR--\n\nAT ** 
(MFC) MALF ** 02:21 ** HEART PROBLEMS - ALS * ** 414 PAOLI PK ,54 ** ROOM 103 B ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** 80/F, AFIB AND ABDOMINAL PAIN\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) EWHF ** 14:36 ** CVA/STROKE - ALS * ** SB RT 202 NO RT 29 ,42   (V) ** 3RD EMERGE **  ** 0519 ** EWHITE ** PT IS IN A RED CHEVY MALABU--3RD PARTY INFO 25\n\n Y ** 
(MFC) GSHF ** 16:12 ** HEMORRHAGING - ALS * ** 1650 YARDLEY DR ,53 ** - ** CHANDLER DR & YARDLEY CT ** 5684 ** EGOSHN ** 87/F - NOSEBLEED FOR 10 MINS\n\nDETAILS TO FOLLOW\n\nT ** 
(MFC) EWHF ** 07:55 ** FALLS - ALS * ** 1145 KING RD ,42 ** 3RD WEST - ** GILLET DR & IMMACULATA DR ** 0599 ** EWHITE ** 96 YO F- POSS FRAC FEMUR OR HIP FROM FALL = HX\n\n: ** 
(MFC) EWHF ** 07:59 ** FALLS - BLS / LIFT ASSIST * ** 4 FORGE DR ,42 ** - ** WILBURDALE RD & DALE LA ** 0508 ** EWHITE ** 81 Y/O F--FALL FROM STANDING POSITION\n\nDETAILS TO ** 
(MFC) EWHF ** 09:08 ** POLES,WIRES,TRANSFORMER FIRE * ** 333 WARREN AV ,42 ** IFO- ** SPRING RD & OLD LANCASTER ** 0504 ** EWHITE ** TREE LIMB TOUCHING WIRE SMOKING\n\n ** 
(MFC) MALF ** 10:08 ** CHEST PAINS - ALS * ** 2 SECOND AV ,54 ** - ** DUFFRYN AV & GRUBB RD ** 0403 ** WILLIS ** 79/F-CHEST DISCOMFORT-TOOK NITROSTAT FEW MINS \n\nAG ** 
(MFC) MALF ** 16:07 ** SICK PERSON - BLS * ** 324 LANCASTER AV ,54 ** 1ST FLR RE ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS ** 70/MALE-DIZZY\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) EWHF ** 16:46 ** HEART PROBLEMS - ALS * ** 50 FOUNDRY WY ,42 ** NEXT TO PU ** WYETH DR & CHESTER VALLEY ** 0566 ** EWHITE ** 33/F - FEELING FAINT - RAPID HEART BEAT\n\nDETAILS T ** 
(MFC) MALF ** 21:08 ** FALLS - BLS / LIFT ASSIST * ** 324 LANCASTER AV ,54 ** ROOM 128-S ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS **  ** 
(MFC) NWTF ** 22:58 ** INJURED PERSON - BLS * ** GOSHEN RD/MARLBOROUGH RD ,54    (V) ** - **  ** 0041 **  **  ** 
(MFC) MALF ** 03:15 ** ALARM - FIRE * ** 414 PAOLI PK ,54 ** BUS--484-5 ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** AFA, ZONE 1 GENERAL, ATN\n\n ** 
(MFC) MALF ** 05:11 ** RESPIRATORY DIFFICULTY - ALS * ** 414 PAOLI PK ,54 ** MAPLE UNIT ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** VOMITING, 45/M\n\nDETAILS TO FOLLOW\n\n ** 
(MFC) EWHF ** 06:30 ** FALLS - BLS / LIFT ASSIST * ** 62 SPRING RD ,42 ** VIRGINIA H ** QUAKER LA & WATCH HILL LA ** 0504 ** EWHITE ** PENDANT, MADE VOICE CONTACT--UNK AGE/F, FELL A\n\nND ** 
(MFC) EWHF ** 12:09 ** POLES,WIRES,TRANSFORMER FIRE * ** MOORES RD/RT 401 ,42    (V) ** - **  ** 0509 **  ** WIRES HANGING DOWN LOW ON ROAD, SPARKING\n\nDETAILS ** 
(MFC) EWHF ** 13:12 ** ABDOMINAL PAIN - ALS * ** 9 LEE BL ,42 ** ESSEX GRAI ** SIDLEY RD & SPRING MILL D ** 0508 ** EWHITE ** 50S/M - SOB AND ABDOMINAL/BACK PAIN\n\nDETAILS TO FO ** 
(MFC) PLIF ** 14:40 ** ALLERGC/MED REACTION - ALS * ** 1000 CEDAR HOLLOW RD ,43 ** RADIATE ME ** RT 202 & W SWEDESFORD RD ** 0301 ** TREDYF ** 40/F -- TOUNGE IS SWELLING -- UNK WHAT IS CAUS\n\nIN ** 

 */


public class PAChesterCountyD5Parser extends PAChesterCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*\\*");
  
  public PAChesterCountyD5Parser() {
    super("AGENCY TIME CALL ADDRCITY APTPL X BOX! CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "adi62@ridgefirecompany.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (subject.length() == 0) return false;
    data.strSource = subject;
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();

    // Split and parse by double asterisk delimiters
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  // Call field strips trailing asterisk marker
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" *")) field = field.substring(0,field.length()-2);
      super.parse(field, data);
    }
  }
  
  // Apt - place field
  private static final Pattern APT_PTN = Pattern.compile("(?:RM|#|ROOM|SUITE) *(.*)", Pattern.CASE_INSENSITIVE);
  private class MyAptPlaceField extends Field {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("-")) return;
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = match.group(1);
      } else {
        data.strPlace = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "APT PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("AGENCY")) return new SkipField("[A-Z]{4}", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("APTPL")) return new MyAptPlaceField();
    if (name.equals("BOX")) return new BoxField("\\d{4}", true);
    return super.getField(name);
  }
} 
