package net.anei.cadpage.parsers.WV;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Berkeley County, WV
 */
public class WVBerkeleyCountyParser extends FieldProgramParser {
  
  public WVBerkeleyCountyParser() {
    super("BERKELEY COUNTY", "WV",
           "Description:CALL! Address:ADDR! CITY!");
  }
  
  @Override
  public String getFilter() {
    return "alert@berkeleywv.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Alert")) return false;
    return parseFields(body.split("\n"), 3, data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      super.parse(convertCodes(field, CALL_CODES), data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" // ", " & ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = PAREN_PTN.matcher(addr).replaceFirst("").trim();
    return addr;
  }
  private static final Pattern PAREN_PTN = Pattern.compile("\\(.*\\)$");
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
    "AIRCRFT BD",   "AIRCRAFT INTO A BUILDING",
    "AIRCRFT EM",   "AIRCRAFT EMERGENCY",
    "AIRCRFT RO",   "AIRCRAFT FIRE RECOVERY",
    "FLGHT UNKN",   "AIRCRAFT FLIGHT EMERGENCY",
    "AIRCRFT LD",   "AIRCRAFT CRASH",
    "ALRM APRT",    "FIRE ALARM APARTMENT BUIDING",
    "ALRM CO/IN",   "FIRE ALARM COMMERICAL BUILDING",
    "ALRM HL/HR",   "HIGH RISE FIRE ALARM",
    "ALRM MOB",     "FIRE ALARM MOBILE HOME",
    "ALRM NONDW",   "GARAGE FIRE ALARM",
    "ALRM RES S",   "RESIDENTIAL FIRE ALARM",
    "ALRM UNKN",    "FIRE ALARM UNKNOWN SITUATION",
    "SERV/AC",      "ANIMAL RESCUE",
    "SERV/FIRE",    "SERVICE CALL",
    "UNLOCK BLD",   "BUILDING LOCK IN",
    "UNLOCK EMG",   "EMERGENCY LOCK IN/OUT",
    "SERV/WATER",   "ELECTRICAL HAZARD WITH WATER",
    "CS ENTR HZ",   "CONFINED SPACE ENTRAPMENT HAZMAT",
    "CS ENTR UN",   "CONFINED SPACE UNK ENTRAPMENT",
    "CS ENTRAP",    "CONFINED SPACE ENTRAPMENT",
    "CS UNKN HZ",   "CONFINED SPACE UNK ENTRAPMENT",
    "ELEC ARCNG",   "ELECTRICAL ARCING",
    "ELEC HAZWTR",  "ELECTRICAL HAZARD WITH WATER",
    "ELEC ODOR",    "ELECTRICAL ODOR OF BURNING",
    "WIREDWN ARC",  "WIRES DOWN WITH ARCING",
    "WIREDWN NO",   "WIRES DOWN NO ARCING",
    "APPL NO OD",   "APPLIANCE FIRE NO ODOR",
    "APPL W/ODOR",  "APPLIANCE FIRE WITH ODOR",
    "UNK FIRE",     "UNKNOWN FIRE INVESTIGATION",
    "TRANS FIRE",   "TRANSFORMER FIRE",
    "ELEV ACC",     "ELEVATOR ACCIDENT",
    "ELEV O MED",   "MEDICAL SITUATION IN ELEVATOR",
    "ELEVMALF O",   "ELEVATOR  MALFUNCATION WITH OCCUP",
    "ELEVMAL NO",   "ELEVATOR MALFUNCATION",
    "ESC ENTINJ",   "ESCULATOR ENTRAPMENT",
    "ESC CAUGHT",   "ESCULATOR ACCIDENT WITH NO INJURIES",
    "ESC INCID",    "ESCULATOR INCIDENT",
    "EXPL CO/IN",   "COMMERICAL EXPLOSION",
    "EXPL HL/HR",   "HIGH RISE EXPLOSION",
    "EXPL LF VEH",  "EXPLOSION HIGH FIRE LOAD VEHICLE",
    "EXPL MOB",     "MOBILE HOME EXPLOSION",
    "EXPL OTHER",   "EXPLOSION OTHER",
    "EXPL RES M",   "EXPLOSION MULITPLE RESIDENCES",
    "EXPL UNKN",    "EXPLOSION INVESTIGATION",
    "EXPL VEH",     "VEHICLE EXPLOSION",
    "EXPLCOMVEH",   "COMMERICAL VEHICLE EXPLOSION",
    "EXPLNO-DWL",   "LARGE BARN/STORAGE BUILDING EXPLOSION",
    "EXPLNO-DWS",   "SMALL DETACHED BUILDING EXPLOSION",
    "EXPL RES S",   " SINGLE FAMILY HOME EXPLOSION",
    "ENTRP NO-P",   "ENTRAPMENT NON PERIPHERAL",
    "EXTRP W/P",    "ENTRAPMENT WITH PERIPHERAL",
    "FUEL CON LG",  "LARGE CONTAINED FUEL SPILL",
    "FUEL CON SM",  "SMALL CONTAINED FUEL SPILL",
    "FUEL UNC LG",  "UNCONTAINED LARGE FUEL SPILL",
    "FUEL UN SM",   "UNCONTAINED SMALL FUEL SPILL",
    "FUEL WATER",   "FUEL SPILL IN/NEAR WATER",
    "GAS COM/IN",   "COMMERICAL BUILDING GAS LEAK",
    "GAS HL/HR",    "HIGH RISE GAS LEAK",
    "GAS OUTCOT",   "OUTSIDE COMMERICAL GAS LINE LEAK",
    "GAS OUT O",    "OUTSIDE ODOR OF GAS",
    "GAS OUTRLT",   "RESIDENTIAL OUTSIDE GAS LEAK",
    "GAS RES M",    "MULTIPLE RESIDENTAIL GAS LEAK",
    "GAS RES S",    "SINGLE RESIDENTAIL GAS LEAK",
    "HAZ CON",      "HAZMAT CONTAINED",
    "HAZ CON DL",   "HAZMAT CONTAINED ILLEGAL DRUG LAB",
    "HAZ SP SM",    "HAZMAT SMALL SPILL > 5 GALS",
    "HAZ UNC DL",   "HAZMAT UNCONTAINED ILLEGAL DRUG LAB",
    "HAZMAT UNCON", "UNCONTAINED HAZMAT",
    "HAZMAT WASTE", "HAZMAT ABANDONED WASTE",
    "HIGH ANG R",   "HIGH ANGLE RESCUE",
    "HIGH ANGRS",   "HIGH ANGLE RESCUE SUICIDAL PERSON",
    "LGT HL/HR",    "LIGHTNING STRIKE HIGH RISE",
    "LGT COM/IN",   "COMMERICAL BUILDING LIGHTNING STRIKE",
    "LGT RES M",    "LIGHTNING STRIKE MULT. RESIDENTIAL",
    "LGT RES S",    "LIGHTENING STRIKE RESIDENTAIL HOME",
    "LGT NODW L",   "LIGHTENING STRIKE LARGE BARN SHED",
    "LGT NODW S",   "LIGHTENING STRIKE SMALL SHED",
    "LGT MOB",      "LIGHTENING STRIKE MOBILE HOME",
    "LGT OUT",      "LIGHTENING STRIKE OUTSIDE",
    "MUTAID FS",    "MUTIAL AID STATION FILL",
    "MUTAID M C",   "MUTUAL AID TO INCIDENT COLD",
    "MUTAID M H",   "MUTUAL AID TO INCIDENT HOT",
    "MUTAID S H",   "MUTUAL AID TO INCIDENT HOT",
    "MUTOUT M C",   "MUTUAL AID TO OUTSIDE AGENCY COLD",
    "MUTOUT M H",   "MUTUAL AID TO OUTSIDE AGENCY HOT",
    "MUTOUT S C",   "MUTUAL AID TO OUTSIDE AGENCY COLD",
    "MUTOUT S H",   "MUTUAL AID TO OUTSIDE AGENCY HOT",
    "MUTSTAGE",     "MUTUAL AID TO STAGING AREA",
    "ODOR IN P",    "INSIDE ODOR WITH PATIENTS",
    "ODOR OUT P",   "OUTSIDE ODOR WITH PATIENTS",
    "ODOR INS",     "STRANGE ODOR INSIDE",
    "ODOR OUT",     "STRANGE ODOR OUTSIDE",
    "OUT LG HAZ",   "LARGE HAZMAT FIRE OUTSIDE",
    "OUT SM HAZ",   "SMALL HAZMAT FIRE OUTSIDE",
    "OUT TRANS",    "TRANSFORMER FIRE",
    "OUTSDE BRU",   "GRASS FIRE BRUSH FIRE",
    "OUTSDE EXT",   "OUTSIDE EXTINGUISHED FIRE",
    "OUTSDE MTN",   "MOUTAIN FIRE/FOREST FIRE",
    "OUTSDE POF",   "OUTSIDE PERSON ON FIRE",
    "OUTSDE RTF",   "OUTSIDE FUEL STORAGE TANKER FIRE",
    "OUTSDE WDS",   "WILDLAND  OR WOODS FIRE",
    "OUTSDE SM",    "SMALL OUTSIDE FIRE",
    "SMOKE HVY",    "HEAVY OUTSIDE SMOKE INVESTIGATION",
    "SMOKE LGT",    "LIGHT OUTSIDE SMOKE INVESTIGATION",
    "SMOKE ODOR",   "ODOR OF SMOKE OUTSIDE",
    "STRU CO-IN",   "COMMERICAL BUILDING FIRE",
    "STRU HL/HR",   "HIGH RISE BUILDING FIRE HIGH LIFE",
    "STRU MOB",     "MOBILE HOME FIRE",
    "STRU RES M",   "RESIDENTAIL STRUCTURE FIRE MULTIPLE",
    "STRU RES S",   "RESIDENTAIL STRUCTURE FIRE SINGLE",
    "STRUCT EXT",   "STRUCTURE FIRE EXTINGUISHED",
    "STRUCT POF",   "STRUCTURE FIRE/PERSON ON FIRE",
    "STR APL CON",  "APPLIANCE FIRE CONTAINED",
    "CHMNY FIRE",   "CHIMNEY FIRE",
    "STR COINHZ",   "COMMERICAL BUILDING  FIRE W/ HAZMAT MAT.",
    "STR LG NODW",  "BARN FIRE/LARGE STORAGE BUILDING",
    "STR SM NODW",  "SMALL SHED FIRE/ DETACHED GARAGE",
    "TRAIN CDAG",   "TRAIN DERAILMENT ABOVE GROUND LEVEL",
    "TRAIN CDAT",   "TRAIN DERAILMENT AT GROUND LEVEL",
    "TRAIN CDBG",   "TRAIN DERAILMENT BELOW GROUND",
    "TRAIN CDBS",   "TRAIN DERAILMENT INTO BUILDING",
    "TRAIN CDBT",   "TRAIN DERAILMENT WITH BRIDGE",
    "TRAIN CDTU",   "TRAIN DERAILMENT IN TUNNEL",
    "TRAIN CDVE",   "TRAIN COLLISION WITH VEHCILE",
    "TRAIN CVOT",   "COMMERICAL VEHICLE ON THE TRACKS",
    "TRAIN OVOT",   "VEHICLE ON THE TRACKS",
    "TRAIN PTRP",   "PERSONN TRAPPED BY TRAIN NO DETRAIL",
    "TRAIN LFFL",   "LARGE FUEL FIRE LOAD ON TRACKS",
    "TRAIN UNK",    "UNKNOWN SITUATION W/ TRAIN",
    "VEH BDG TH",   "VEHICLE FIRE CLOSE TO BUILDING",
    "VEH COMM",     "COMMRICAL TRUCK FIRE NO HAZMAT",
    "VEH EXT",      "CAR/PICK UP TRUCK EXTINGUISHED",
    "VEH FIRE",     "VEHICLE FIRE",
    "VEH FIREOT",   "VEHICLE FIRE WITH ENTRAPMENT",
    "VEH LG EXT",   "COMMERICAL VEHICLE EXTINGUISHED",
    "VEH LG FFL",   "LARGE FUEL LOAD VEHICLE FIRE",
    "VEH NOSTR",    "VEHICLE FIRE NO STRUCTURE THREATEN",
    "VEH PRKGAR",   "VEHICLE FIRE IN PARKING GARAGE",
    "VEH TUNNEL",   "VEHICLE FIRE IN TUNNEL",
    "WTRRES AR",    "ANIMAL RESCUE IN WATER",
    "WTRRES BR",    "BODY RECOVERY IN WATER",
    "WTRRES COA",   "WATER RESCUE COSTAL",
    "WTRRES ICE",   "WATER RESCUE IN ICE",
    "WTRRES INL",   "WATER RESCUE INLAND WATER",
    "WTRRES LGF",   "WATER RESCUE LARGE FLOOD",
    "WTRRES OCE",   "OCEAN RESCUE",
    "WTRRES POO",   "SWIMMING POOL ACCIDENT",
    "WTRRES QUI",   "WATER RESCUE QUICK SAND MUD",
    "WTRRES SCU",   "SCUBA DIVE ACCIDENT",
    "WTRRES SIN",   "WATER RESCUE SINKING VEHICLE",
    "WTRRES SMG",   "WATER RESCUE SMALL FLOOD",
    "WTRRES STR",   "WATER RESCUE STRAINED MOTORIST",
    "WTRRES SWI",   "SWIFT WATER RESCUE",
    "WTRRES UNK",   "WATER RESCUE UNK SITUATION",
    "SUSP PKG",     "SUSPICIOUS PACKAGE",
    "SUSP PKG R",   "SUSPICIOUS PACKAGE AT HOUSE",
    "SUSP PKG LR",  "SUSPICIOUS PACKAGE LEAK NO INJURIES",
    "SUSP LRSI",    "SUSPICIOUS PACKAGE LEAK W. INJURIES",
    "SUSPK OESI",   "SUSPICIOUS PACKAGE EXPL. W. INJURIES",
    "SUSPKG S/I",   "SUSPICIOUS PACKAGE WITH INJURIES",
    "BOMB THRET",   "BOMB THREAT",
    "BOMB TH SC",   "BOMB THREAT SUSPECT CALLER",
    "SUSPK OE",     "SUSPICIOUS PACKAGE EXPLOSIVES",
    "T-RAIL FAG",   "TRAIN RAIL FIRE ABOVE GROUND",
    "T-RAIL FAT",   "TRAIN RAIL FIRE AT GROUND LEVEL",
    "T-RAIL FBG",   "TRAIN RAIL FIRE BELOW GROUND",
    "T-RAIL FBS",   "TRAIN RAIL FIRE WITH STRUCTURES",
    "T-RAIL FBT",   "TRAIN RAIL FIRE WITH  BRIDGE",
    "T-RAIL FTU",   "TRAIN RAIL FIRE IN TUNNEL",
    "T-RAIL FVE",   "TRAIN RAIL FIRE W/ VEHICLES",
    "T-RAIL MOV",   "TRAIN RAIL FIRE MOVING",
    "T-RAIL UNK",   "TRAIN RAIL FIRE INVESTIGATION"
  });
}
