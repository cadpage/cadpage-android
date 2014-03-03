package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Rocklin, CA
 */
public class CARocklinParser extends DispatchA20Parser {
  
  public CARocklinParser() {
    super(CALL_CODES, "ROCKLIN", "CA");
  }
  
  @Override
  public String getFilter() {
    return "@rocklin.ca.us";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "CALARM",   "COMMERCIAL FIRE ALARM",
      "CGAS",     "COMMERCIAL GAS LEAK",
      "CSTRUC",   "COMMERCIAL STRUCT FIRE",
      "FINV",     "FINV",
      "FTRASH",   "TRASH FIRE",
      
      
      "FVEH",     "VEHICLE FIRE",
      "FVSUMM",   "VEG FIRE SUMMER",
      "FVWIN",    "VEG FIRE WINTER",
      "HWIRE",    "HAZARDOUS WIRES",
      "HZH",      "CONTAINED HZ HIGH",
      "HZL",      "CONTAINED HZ LOW",
      "LAND",     "LANDING ZONE",
      "MAID",     "MEDICAL AID",
      "MDOWN",    "PERSON DOWN",
      "MUTAID",   "MUTUAL AID REQ",
      "PAST",     "PUBLIC ASSIST",
      "PLANE",    "PLANE CRASH",
      "POLICE",   "LAW ASSIST",
      "RALARM",   "RESIDENTIAL FIRE ALARM",
      "RGAS",     "RESIDENTIAL GAS LEAK",
      "RSTRUCT",  "RESIDENTIAL STRUCT FIRE",
      "RWATER",   "WATER RESCUE",
      "STRIKE",   "STRIKE TEAM REQ",
      "TRAIN",    "TRAIN WRECK",
      "VAF",      "VEHICLE ACC (HIGH)",
      "VAL",      "VEHICLE ACC (LOW)"
  });
}
