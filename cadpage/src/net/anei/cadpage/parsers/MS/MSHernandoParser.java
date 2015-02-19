package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class MSHernandoParser extends DispatchB2Parser {

  public MSHernandoParser() {
    super("E-911:", MSDeSotoCountyAParser.CITY_LIST, "HERNANDO", "MS");
    setupCallList(CALL_LIST);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      
      "ABDOMINAL PAIN",
      "ACCIDENT UNKOWN INJURIES",
      "ACCIDENT W/INJURIES",
      "ACCIDENT W/INJURIES NB",
      "ACCIDENT W/INJURIES SB",
      "ALL OTHER FIRE",
      "BREATHING DIFFICULTIES",
      "CARBON MONOXIDE DETECTOR",
      "CHEST PAINS-MI",
      "COMPLAINT-RECKLESS DRIVING N/B",
      "FALLS",
      "FIRE ALARM RESIDENCE",
      "HEADACHE",
      "SICK CALL PERSON",
      "UNCONSCIOUS/FAINTING",
      "WELFARE CONCERN NB"
          
  );
}
