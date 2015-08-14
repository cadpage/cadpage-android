package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Oroville, CA
 */
public class CAOrovilleParser extends DispatchA20Parser {
  
  public CAOrovilleParser() {
    super(CALL_CODES, "OROVILLE", "CA");
  }
  
  @Override
  public String getFilter() {
    return "@OROPD.ORG";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  private static final Pattern ALPHA_UNIT_PTN = Pattern.compile("[A-Z]+");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    
    // If dispatch name sneaks into unit field, destroy t
    if (ALPHA_UNIT_PTN.matcher(data.strUnit).matches()) data.strUnit = "";
    return true;
  }

  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "FDASSIST", "PUBLIC ASSIST",
      "FDFIRE1",  "VEHICLE/OTHER FIRE",
      "FDFIRE2",  "VEHICLE FIRE (OCCUPIED)",
      "FDFIRE3",  "VEGETATION",
      "FDFIRE4",  "STRUCTURE",
      "FDFIRE5",  "COMMERCIAL STRUCTURE",
      "FDGEN",    "LEVEL 1 STAFFING",
      "FDHAZD3",  "FLOODING",
      "FDHAZMA1", "MINOR HAZMAT",
      "FDHAZMA2", "MAJOR HAZMAT",
      "FDHAZMAT", "HAZARDOUS CONDITION",
      "FDINVEST", "ALARM SOUNDING/SMOKE CHECK/FIREWORKS",
      "FDMED",    "MEDICAL",
      "FDMED2",   "MEDICAL (CPR)",
      "FDRESCUE", "TECHNICAL RESCUE",
      "FDTC1",    "T/C",
      "FDTC2",    "T/C POSSIBLE MCI",
      "FDW/ALAR", "WATER FLOW ALARM",
      "FDWATER",  "WATER RESCUE"
  });
}
