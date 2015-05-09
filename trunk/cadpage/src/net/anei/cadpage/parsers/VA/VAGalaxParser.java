package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Grayson County, VA
 */
public class VAGalaxParser extends DispatchDAPROParser {
  
  public VAGalaxParser() {
    super("GALAX", "VA");  
    setupCallList(CALL_SET);
    setupMultiWordStreets(
        "BURNING BUSH",
        "COULSON CHURCH",
        "CROOKED OAK",
        "DAVID RIDGE",
        "ELK HORN",
        "EXCELSIOR SCHOOL",
        "FISHERS GAP",
        "FOREST OAK",
        "FROZEN LAKE",
        "GRANGE HALL",
        "GROUNDHOG MTN",
        "HARRISON RIDGE",
        "HAWK LANDING",
        "HIDDEN VALLEY",
        "HIRAM STANLEY",
        "HONEYCUTT DAM",
        "JEB STUART",
        "JOY RANCH",
        "LAUREL VALLEY",
        "LITTLE BIT",
        "MAROON TIDE",
        "MT ZION",
        "PEAR TREE",
        "PINE MTN",
        "PIPERS GAP",
        "POPLAR HILL",
        "POPLAR KNOB",
        "RED HILL",
        "RUSSELL'S LAKE",
        "SNAKE CREEK",
        "STEVENS CREEK",
        "STONE MOUNTAIN",
        "TEN MILLS",
        "TERRY'S MILL",
        "THUNDER RIDGE",
        "TRADING POST",
        "VILLAGE VIEW",
        "WARDS MILL"
    );
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@GalaxVa.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }

  private static final CodeSet CALL_SET = new CodeSet(
      "ALARM-BUSINESS",
      "ALARM-RESIDENCE",
      "ASSIST EMS",
      "ASSIST FIRE",
      "E*MEDICAL DEVICE - TUBES, LINE",
      "EMS - ABDOMINAL DISTRESS",
      "EMS - ALARM",
      "EMS - ALLERGIC REACTION",
      "EMS - ASTHMA RELATED",
      "EMS - ASSAULT INJURY",
      "EMS - BLOOD PRESSURE",
      "EMS - BLEEDING",
      "EMS - BREATHING DIFFICULTY",
      "EMS - CARDIAC",
      "EMS - BACK PAIN / INJURY",
      "EMS - BITE/STING",
      "EMS - DIABETIC",
      "EMS - DISORIENTED",
      "EMS - DOA - UNKNOWN",
      "EMS - FAINTING",
      "EMS - FAINTING / SYNCOPE",
      "EMS - FALL",
      "EMS - FEVER",
      "EMS - FRACTURE",
      "EMS - HEAD INJURY",
      "EMS - HEADACHE",
      "EMS - INTERFACILITY TRANSPORT",
      "EMS - LACERATION",
      "EMS - NAUSEA / VOMITING",
      "EMS - NO INFORMATION ON PATIEN",
      "EMS - NUMBNESS",
      "EMS - PAIN",
      "EMS - SEIZURE",
      "EMS - STROKE",
      "EMS - TRAUMA/INJURY",
      "EMS - RETURN TRIP",
      "EMS - UNRESPONSIVE",
      "EMS - WEAKNESS",
      "EMS - INFECTIOUS ILLNESS",
      "FIRE - BRUSH",
      "FIRE - STRUCTURE",
      "FIRE - UTILITY",
      "FIRE - VEHICLE",
      "GAS LEAK",
      "MENTAL / EMOTIONAL/PSYC",
      "MOTOR VEHICLE CRASH",
      "OVERDOSE",
      "SMOKE REPORT",
      "TESTING - ONLY!",
      "TRANSPORT CRIMINAL / NOT MENTA",
      "WANTED PERSON",
      "WELFARE CHECK"
  );
}