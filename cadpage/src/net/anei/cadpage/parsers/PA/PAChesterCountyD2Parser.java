package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;


/* 
Chester County, PA (variant D)
Contact: Ray Stegmaier <stegmaierr@gmail.com>
Sender: pfdfire@fdcms.com
http://wiki.radioreference.com/index.php/Chester_County_%28PA%29

(309 STARR ST ,15) ACCIDENT - INJURIES * * VEH VRS POLE\nDETAILS TO FOLLOW\nTYP: ACCUNK  --> ACCINJ  \nRSP: 0050   --> 0004   \n* 05/08/11 * 11:11 *
(300 W HIGH ST ,15) ALARM - FIRE * * AFA - GEN - ATN\n* 05/08/11 * 05:42 *
(325 BRIDGE ST ,15) ACCIDENT - PEDESTRIAN STRUCK * * PD OS WITH ONE  SUBJ ON THE GROUND\nLOC: 300 BRIDGE ST ,15 -->\2s325 BRIDGE ST ,15-\n- FAMILY DOLLAR S * 05/08/11
(2 N MAIN ST ,15) FUEL SPILL * * ENG65 IS RESPONDING\n* 05/07/11 * 13:31 *
(724 WHEATLAND ST ,15) BRUSH FIRE * * DETAILS TO FOLLOW\n* 04/20/11 * 15:52 *
(140 NUTT RD ,15) ALARM - FIRE * * FIRE ALARM TWO SEPERATE SMOKE DETECTOR UNK LOC\n- DID NOT CALL THE HOSPITAL-WILL BE NOTIFING-\nDETAI * 04/25/11 * 12:47 *
(213 W HIGH ST ,15) TRASH/DUMPSTER FIRE * * SMOLDERING FROM DUMPSTER -- DUMPSTER IS A "2 L\nID" DUMPSTER\nDETAILS TO FOLLOW\n* 05/01/11 * 20:28 *

Not valid, but something like this is putting parser in a recursion loop
(540 WELLINGTON SQUARE DR) CHOKING - BLS * ** 540 WELLINGTON SQUARE DR ,33 ** BRICKSIDE GRILL/OUTSIDE BY SID ** 40 Y/O M--PARTIAL AIRWAY OBST\nDETAILS TO FOLLOW
(470 MANOR AV ,39) CVA/STROKE - ALS * ** 470 MANOR AV ,39 ** THE GLEN UNIT - LOUNGE-SAINT M ** 89 YO/F - CHANGE IN MENTAL STATUS\nDETAILS TO FOLL ** CALN **  ** U
(456 ACORN LA ,11) ACCIDENT - MOTORCYCLE * ** 456 ACORN LA ,11 ** IN BACK PARKING LOT- ** UNK MALE/POSS BROKEN RIBS\nDETAILS TO FOLLOW\n*  **  ** CHESTNUT ST & W
(445 MANOR AV ,11) NEUROLOGICAL/HEAD INJ - ALS * ** 445 MANOR AV ,11 ** MAIN STADIUM FOOTBALL FIELD-DO ** M/11 FELL AND HIT HEAD\nDETAILS TO FOLLOW\n** DNGTWN **
(FONT RD/RT 100 ,32    (V) ACCIDENT - MOTORCYCLE * ** FONT RD/RT 100 ,32    (V) ** - ** VEH VS MC\nDETAILS TO FOLLOW\n**  **  **  **
(300 CAMPBELL CI ,40) SICK PERSON - BLS * ** 300 CAMPBELL CI ,40 ** BLDG 300 APT 11-WOODMONT NORTH ** F/92 - LETHARGIC / INFECTION AND CELLULITIS\nDETAI ** ECALN
(4347 LINCOLN HW ,39) SYNCOPE/FAINTING - ALS * ** 4347 LINCOLN HW ,39 * -LIMITED NAILS ** ORIG 911 H/U---20/F\nDETAILS TO FOLLOW\n* CALN **  ** WEDGEWOOD RD & W

 */


public class PAChesterCountyD2Parser extends PAChesterCountyBaseParser {
  
  public PAChesterCountyD2Parser() {
    super("CALL SKIP INFO+? DATE!");
  }
  
  @Override
  public String getFilter() {
    return "pfdfire@fdcms.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Address is passed in subject
    if (! parseChesterAddress(subject, data)) return false;
    
    // And all of the should treat line breaks as spaces
    body = body.replace('\n', ' ');
    
    // Split fields by asterisk and parse
    return parseFields(body.split("\\*"), data);
  }
  
  // Time must match correct format
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  // Date must match correct format
  private class DateField extends SkipField {
    public DateField() {
      setPattern(Pattern.compile("\\d\\d/\\d\\d/\\d\\d"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("DATE")) return new DateField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ADDR CITY " + super.getProgram();
  }

} 
