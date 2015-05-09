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
      "BOMB",     "BOMB THREAT",
      "CALARM",   "COMMERCIAL FIRE ALARM",
      "CGAS",     "COMMERCIAL GAS LEAK",
      "CO",       "CARBON MONIXIDE ALARM",
      "CSTRUC",   "COMMERCIAL STRUCT FIRE",
      "CSTRUH",   "COMMERCIAL STRUCTURE FIRE - HIGH",
      "CSTRUL",   "COMMERCIAL STRUCTURE FIRE – LOW",
      "FINV",     "FINV",
      "FLOOD",    "FLOODING INCIDENT",
      "FTEST",    "FIRE TEST INCIDENT",
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
      "POLICE",   "POLICE ASSIST",
      "RALARM",   "RESIDENTIAL FIRE ALARM",
      "RESCUE",   "TECHNICIAL RESCUE",
      "RGAS",     "RESIDENTIAL GAS LEAK",
      "RSTRUCT",  "RESIDENTIAL STRUCT FIRE",
      "RSTRUH",   "RESIDENTIAL STRUCTURE FIRE - HIGH",
      "RSTRUL",   "RESIDENTIAL STRUCTURE FIRE - LOW",
      "RWATER",   "WATER RESCUE",
      "STRIKE",   "STRIKE TEAM REQ",
      "TRAIN",    "TRAIN WRECK",
      "VAF",      "VEHICLE ACC (HIGH)",
      "VAH",      "VEHICLE ACCIDENT - HIGH",
      "VAL",      "VEHICLE ACC (LOW)",
      "VEGHI",    "VEGETATION FIRE - HIGH"
  });
}
