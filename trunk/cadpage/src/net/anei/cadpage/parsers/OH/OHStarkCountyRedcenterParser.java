package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/*
Stark County, OH (Redcenter)
Contact: support@active911.com
Sender: RED@sssnet.com

RED:[02]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 5830 MANCHEST ER AV NW LAWRENCE TWP BETWEEN PATTERSON / GADDIS ACCESS BY NORTH LAWRENCE FIRE COMMENTS: MENTAL HEALTH EVAL ON STATIO N
RED:[43]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 80 TfHOMAS BL NW LAWRENCE TWP BETWEEN NICHOLAS / CARMELLA ACCESS BY 40 C ORNERS TRAILER PARK COMMENTS: COMPLICATIONS WITH PANCREATITI S
RED:[02]- NATURE: PUBLIC SERVICE-SQUAD LOCATION: 8757 SPRING GRO VE AV NW LAWRENCE TWP BETWEEN GLENCOE / GENEVA COMMENTS: LI FT ASSIST GARAGE ENTRANCE
RED:[02]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 14602 ARCADIA ST NW LAWRENCE TWP BETWEEN HAMMOCK / ALABAMA COMMENTS: FEM ALE ILLNESS
RED:[02]- NATURE: ACCIDENT - INJURY LOCATION: 5950 DEERFIELD AV NW LAWRENCE TWP BETWEEN ORRVILLE / ARCADIA ACCESS BY NORTH LAWRENCE FIRE COMMENTS: ROLL OVER
RED:[RC68]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 10751 JOHNS TON ST NW LAWRENCE TWP BETWEEN AKRON / HIGHMILL COMMENTS: N URSE ON SCENE DRIVEWAY IS A FORK- STAY TO THE LEFT ALTERED LOC
RED:[02]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 5622 CUTTEN A V NW LAWRENCE TWP BETWEEN SOUSA / WEYGANDT ACCESS BY NORTH LAWRENCE FIRE COMMENTS: FEMALE HIP PAIN
RED:[07]- NATURE: ACCIDENT - INJURY LOCATION: 3971 MANCHESTER AV NW LAWRENCE TWP BETWEEN YOUTH / ORRVILLE ACCESS BY NORTH LAWRENCE FIRE COMMENTS: CAR OVER GUARDRAIL
RED:[11]- NATURE: STRUCTURE FIRE LOCATION: 3283 YOUNG AV NW LAWR ENCE TWP BETWEEN ORRVILLE / NORTH TO END ACCESS BY NORTH L AWRENCE FIRE COMMENTS: SMOKE IN THE BASEMENT TONED 1339
RED:[11]- NATURE: PUBLIC SERVICE-FIRE LOCATION: 1641 ARAPAHOE AV SE MASSILLON BETWEEN SHAWNEE RD / 16TH ST COMMENTS: RESIDE NTIAL LOCKOUT
RED:[11]- NATURE: STRUCTURE FIRE LOCATION: 3283 YOUNG AV NW LAWR ENCE TWP BETWEEN ORRVILLE / NORTH TO END ACCESS BY NORTH L AWRENCE FIRE COMMENTS: SMOKE IN THE BASEMENT TONED 1339
RED:[07]- NATURE: AUTO ALARM LOCATION: 10405 STRAUSSER ST NW LAW RENCE TWP BETWEEN MC TAGGART / AKRON COMMENTS: 1ST FLR SMOK ES 854 1004
RED:[02]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 5830 MANCHEST ER AV NW LAWRENCE TWP BETWEEN PATTERSON / GADDIS ACCESS BY NORTH LAWRENCE FIRE COMMENTS: MENTAL HEALTH EVAL ON STATIO N
RED:[43]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 80 THOMAS BL NW LAWRENCE TWP BETWEEN NICHOLAS / CARMELLA ACCESS BY 40 C ORNERS TRAILER PARK COMMENTS: COMPLICATIONS WITH PANCREATITI S
RED:[RC63]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 10388 STONE ACRE ST NW LAWRENCE TWP BETWEEN ARTHUR / MC TAGGART COMMENT S: UNKNOWN ILLNESS
RED:[32]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 8 MICHAEL CIR LAWRENCE TWP BETWEEN THOMAS BLVD / DEAD END CIRCLE ACCESS BY NORTH LAWRENCE FIRE COMMENTS: MOTHER IN LAW IS SHAKY & N OT FEELING WELL
RED:[13]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 8871 MANCHEST ER AV NW LAWRENCE TWP BETWEEN BAPST / COUNTY LINE COMMENTS: 85 YOF FALL VICTIM HIP INJURY
RED:[28]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 10438 MAPLEVI EW ST NW LAWRENCE TWP BETWEEN AKRON / ELMVIEW COMMENTS: BEH IND THE CALLER, LAWN TRACTOR TIPPED OVER ON HIM CALLER WILL FLAG YOU DOWN AT THIS ADDRESS
RED:[02]- NATURE: PUBLIC SERVICE-SQUAD LOCATION: 8757 SPRING GRO VE AV NW LAWRENCE TWP BETWEEN GLENCOE / GENEVA COMMENTS: LI FT ASSIST GARAGE ENTRANCE
RED:[02]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 10382 STRAUSS ER ST NW LAWRENCE TWP BETWEEN ARTHUR / MC TAGGART COMMENTS: NOSE BLEED

[LTFD] RED:[07]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 6331 BOATMAN DR NW LAWRENCE TWP BETWEEN PATROON / PACKETS COMMENTS: DIAB ETIC\n
[LTFD] RED:[24]- NATURE: STILL ALARM LOCATION: 8600 GREENMEADOW AV NW L AWRENCE TWP BETWEEN THE END / SUNSET VALLEY COMMENTS: GRY H OUSE WITH TAN CHEVY PICK UP IN DRIVEWAY 4TH HOUSE FROM THE LAST ON THE DEADEND PART ON GREENMEADOW FIRE LIT WITH GA\n
[LTFD] RED:[RC63]- NATURE: STILL ALARM LOCATION: 8579 ELMFIELD AV NW LA WRENCE TWP BETWEEN GLENCOE / SKYLINE COMMENTS: TREES/ AND S HRUBS/ CALLING BECAUSE THEY CALL ON THEM ALL THE TIME OPE N BURN\n
[LTFD] RED:[RC63]- NATURE: STRUCTURE FIRE LOCATION: 6596 IVYHILL DR NW LAWRENCE TWP BETWEEN CHILTERN / DEAD END COMMENTS: SMOKE IN BASEMENT\n
[LTFD] RED:[36]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 7375 STONEHIL L ST NW LAWRENCE TWP BETWEEN BLUFFTON / NORTH TO THE END CO MMENTS: 29 YOM / CHEST PAIN\n
[LTFD] RED:[RC63]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 13190 PATTE RSON ST NW LAWRENCE TWP BETWEEN PENBROOK / MANCHESTER (RT 93) ACCESS BY NORTH LAWRENCE FIRE COMMENTS: WILLOW FLATS U NKNOWN ILLNESS LOT 2\n
[LTFD] RED:[08]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 13190 PATTERS ON ST NW LAWRENCE TWP BETWEEN PENBROOK / MANCHESTER (RT 93 ) ACCESS BY NORTH LAWRENCE FIRE COMMENTS: ASTHMA - 93 GATE\n
[LTFD] RED:[08]- NATURE: STILL ALARM LOCATION: 21 NW / BUTTERBRIDGE RD NW LAWRENCE TWP COMMENTS: SOUTH BOUND ON 21\n
[LTFD] RED:[02]- NATURE: MISSING JUVENILE LOCATION: 13190 PATTERSON ST NW LAWRENCE TWP BETWEEN PENBROOK / MANCHESTER (RT 93) ACC ESS BY NORTH LAWRENCE FIRE COMMENTS: WATER PARK GATE/ MISSIN G CHILD\n
[LTFD] RED:[02]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 15644 MARSHAL LVILLE ST NW LAWRENCE TWP BETWEEN RT 21 M / DEERFIELD COMME NTS: UNKNOWN MEDICAL EMERGENCY\n
[LTFD] RED:[02]- NATURE: STILL ALARM LOCATION: 4995 MANCHESTER AV NW LA WRENCE TWP BETWEEN SOUSA / PATTERSON ACCESS BY NORTH LAWRE NCE FIRE COMMENTS: LINE ON FIRE TREE ON FIRE SOUTH OF THIS ADDRESS\n
[LTFD] RED:[51]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 8543 ELMFIELD AV NW LAWRENCE TWP BETWEEN GLENCOE / SKYLINE COMMENTS: POS S HEART\n
[LTFD] RED:[43]- NATURE: EMERGENCY MEDICAL CALL LOCATION: 11866 PACKETS ST NW LAWRENCE TWP BETWEEN DEAD END / BOATMAN COMMENTS: BI T BY NEIGHBORS DOG 5 MIN AGO DOG STILL ON SCENE/ ELE FENCE\n

 */


public class OHStarkCountyRedcenterParser extends DispatchEmergitechParser {
  
  public OHStarkCountyRedcenterParser() {
    super("RED:", 64, CITY_LIST, "STARK COUNTY", "OH");
  }
  
  @Override
  public int getMapFlags() {
    
    // Suppressing the LA -> LN translation fixes problems when LAWRENCE is split wrong
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  public String getFilter() {
    return "RED@sssnet.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    // Cities
    "ALLIANCE",
    "CANAL FULTON",
    "CANTON",
    "LOUISVILLE",
    "MASSILLON",
    "NORTH CANTON",
    
    // Villages
    "BEACH CITY",
    "BREWSTER",
    "EAST CANTON",
    "EAST SPARTA",
    "HARTVILLE",
    "HILLS AND DALES",
    "LIMAVILLE",
    "MAGNOLIA",
    "MINERVA",
    "MEYERS LAKE",
    "NAVARRE",
    "WAYNESBURG",
    "WILMOT",
    
    // Townships
    "BETHLEHEM TWP",
    "CANTON TWP",
    "JACKSON TWP",
    "LAKE TWP",
    "LAWRENCE TWP",
    "LEXINGTON TWP",
    "MARLBORO TWP",
    "NIMISHILLEN TWP",
    "OSNABURG TWP",
    "PARIS TWP",
    "PERRY TWP",
    "PIKE TWP",
    "PLAIN TWP",
    "SANDY TWP",
    "SUGAR CREEK TWP",
    "TUSCARAWAS TWP",
    "WASHINGTON TWP",
    
    // Census-designated places
    "GREENTOWN",
    "PERRY HEIGHTS",
    "UNIONTOWN",
    
    // Other localities
    "AVONDALE",
    "CAIRO",
    "MARCHAND",
    "MAXIMO",
    "MIDDLEBRANCH",
    "NEW FRANKLIN",
    "NORTH INDUSTRY",
    "NORTH LAWRENCE",
    "PARIS",
    "RICHVILLE",
    "ROBERTSVILLE",
    "WACO"
  };
}
