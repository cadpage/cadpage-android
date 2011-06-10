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

 */


public class PAChesterCountyD2Parser extends PAChesterCountyDBaseParser {
  
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
