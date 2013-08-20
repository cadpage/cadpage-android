package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Franklin County, VA
 */
public class VAFranklinCountyParser extends DispatchDAPROParser {
  
  public VAFranklinCountyParser() {
    super(CITY_CODE_TABLE, "FRANKLIN COUNTY", "VA");
    setupCallList(CALL_SET);
  }
      
  
  @Override
  public String getFilter() {
    return "mailbox@franklincountyva.org";
  }
  
  private static final CodeSet CALL_SET = new CodeSet(
      "911 HANG UP",
      "ABDOMINAL PAIN",
      "ACCIDENT-INJURY",
      "ASSAULT",
      "DRUNK DRIVER",
      "EMS-ALLERGIC REACTION",
      "EMS-CARDIAC",
      "EMS-CHEST PAIN",
      "EMS-DIABETIC",
      "EMS-DIFFICULTY BREATHING",
      "EMS-DOA",
      "EMS-HEAD INJURY",
      "EMS-HIGH BLOOD PRESSURE",
      "EMS-LACERATION",
      "EMS-MENTAL",
      "EMS-OTHER/DEFINE",
      "EMS-PATIENT FALLEN",
      "EMS-PATIENT IN PAIN",
      "EMS-SEIZURE",
      "EMS-STROKE",
      "EMS-UNCONSCIOUS",
      "FIRE-ALARM COMMERCIAL",
      "FIRE-STRUCTURE",
      "WELLBEING CHECK"
  );
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
      "BML", "Boones Mill", 
      "CAL", "Callaway",
      "FER", "Ferrum",
      "GLA", "Glade Hill",
      "HEN", "Henry",
      "PEN", "Penhook",   
      "RMT", "Rocky Mount",
      "UHL", "Union Hall",
      "WIR", "Wirtz",   
      "BAS", "Bassett",   
      "HAR", "Hardy",
      "MAR", "Martinsville",
      "MON", "Moneta"   
    });

}