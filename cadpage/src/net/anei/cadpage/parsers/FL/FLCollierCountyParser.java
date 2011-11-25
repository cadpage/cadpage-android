package net.anei.cadpage.parsers.FL;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/*
Collier County, FL
Contact: StedmanDavid <DavidStedman@colliergov.net>

FCC111115005334 TYP: MEDICAL CALL BLD: NW S AD: COLLIER BLVD&IMMOKALEE RD MAP: 376 LOC: PUBLIX CMT1: S02 - DIFF BREATHING
FCC111115005335 TYP: MEDICAL CALL AD: 1234 35TH AVE NE MAP: 333 CMT1: CE: 52 YEAR OLD FEMALE CONSCIOUS BREATHING CALLER
FCC111115005332 TYP: UNK PROBLEM BLD: COIN AD: PINE RIDGE RD&I 75 MAP: 571 LOC: VINEYARDS AMOCO CMT1: 71U/MALE LAYING UND
FCC111117005608 TYP: TRAUMATIC INJURIES AD: 3300 THOMASSON DR MAP: 944 LOC: AVALON ELEM CMT1: CE: 5 YEAR OLD MALE CONSCIO
FCC111117005599 TYP: MEDICAL CALL APT: 105 AD: 600 MISTY PINES CIR MAP: 583 CMT1: CE: 1 MONTH OLD FEMALE CONSCIOUS BREATH

 */

public class FLCollierCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern MARKER = Pattern.compile("^FCC\\d{12} TYP: ");
  
  public FLCollierCountyParser() {
    super("COLLIER COUNTY", "FL");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!MARKER.matcher(body).find()) return false;
    return super.parseMsg("INC:" + body, data);
  }
}
