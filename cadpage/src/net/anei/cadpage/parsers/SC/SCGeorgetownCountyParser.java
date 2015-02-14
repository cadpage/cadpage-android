package net.anei.cadpage.parsers.SC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA52Parser;

/**
 * Georgetown County, SC
 */
public class SCGeorgetownCountyParser extends DispatchA52Parser {
  
  public SCGeorgetownCountyParser() {
    super(CALL_CODES, "GEORGETOWN COUNTY", "SC");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (body.startsWith("DIRECT:")) body = body.substring(7).trim();
    else if (body.startsWith(":")) body = body.substring(1).trim();
    
    return super.parseMsg(subject, body, data);
  }

  @Override
  public String adjustMapAddress(String addr) {
    return addr.replace("BY-PASS",  "BYPASS");
  }
  
  private static final Properties CALL_CODES =  buildCodeTable(new String[]{
      "GABD",   "Abdominal Pain",
      "GALARM", "Fire Alarm",
      "GALLER", "Allergies",
      "GALRMC", "General Fire Alarm (Commercial)",
      "GAMBU",  "Amputation",
      "GANA",   "Anaphylactic Shock",
      "GASSEX", "Sexual Assault",
      "GASSLT", "Assault",
      "GATSUI", "Attempted Suicide",
      "GAUTOA", "Auto/Mutual Aid",
      "GBITEA", "Bite (Animal)",
      "GBITEI", "Bite (Insect)",
      "GBITEM", "Bite (Marine)",
      "GBKPN",  "Back Pain",
      "GBOAT",  "Boat/Marine",
      "GBOMB",  "Bomb Threat",
      "GBRUSH", "Brush/Woods Fire",
      "GBURN",  "Burn Victim",
      "GCANCE", "Cancer Patient",
      "GCARDA", "Cardiac Arrest",
      "GCHOK",  "Choking",
      "GCHSPN", "Chest Pain",
      "GCKBRN", "Check Burn Site",
      "GCOALM", "Carbon Monoxide Alarm",
      "GCODE",  "Fire Code Violation",
      "GCOLD",  "Cold/Flu",
      "GCOLL",  "Building Collapse ",
      "GCONSP", "Confined Space",
      "GCOPOS", "CO Poisoning",
      "GCRUSH", "Crushing",
      "GCSAI",  "Cond Sim to Alcohol Imp",
      "GDIAB",  "Diabetic Problems",
      "GDIALY", "Dialysis Patient",
      "GDISLO", "Dislocation",
      "GDOME",  "Domestic Assault",
      "GDROWN", "Drowning",
      "GDUMP",  "Dumpster Fire",
      "GEDUCA", "Educational Truck Event",
      "GELECT", "Electrocution",
      "GELEV",  "Elevator Entrapment",
      "GEXPO",  "Heat/Cold Exposure",
      "GEYE",   "Eye Injury",
      "GFAINT", "Fainting",
      "GFALL1", "Fall Victim <10ft",
      "GFALL2", "Fall Victim >10ft",
      "GFEVER", "Fever",
      "GFRAC",  "Fracture",
      "GFUEL",  "Fuel Spill",
      "GGAS",   "Propane Emergency",
      "GGI",    "GI Problems",
      "GGU",    "GU Problems",
      "GHAZ",   "HazMat",
      "GHEADA", "Headache",
      "GHEADI", "Head Injury",
      "GHEART", "Heart Problems",
      "GHEM",   "Hemorrhage/Laceration",
      "GHIANG", "High Angle Rescue",
      "GHYPER", "Hypertension",
      "GHYPO",  "Hypotension",
      "GLACER", "Laceration",
      "GLIFTA", "Lift Assist",
      "GLZ",    "Landing Zone",
      "GMALAR", "Medical Alarm",
      "GMASS",  "Mass Casualty Incident",
      "GMEDDF", "Medical Device Failure",
      "GMENTA", "Mentally Unstable",
      "GMPL",   "Missing Person (Land)",
      "GMPW",   "Missing Person (Water)",
      "GMVA",   "MVA w/Injuries",
      "GMVABO", "MVA Involving Boat",
      "GMVAEN", "MVA w/entrapment",
      "GMVAMC", "MVA w/motorcycle",
      "GMVAPD", "MVA w/pedestrian",
      "GMVAUNK","MVA w/unknown Injury",
      "GNOBRN", "Unauthorized Burn",
      "GOBGYN", "OB/GYN/Pregnancy",
      "GOVERD", "Overdose/Poisoning",
      "GPAIN",  "General Pain",
      "GPLNE1", "Plane Crash (Small Frame)",
      "GPLNE2", "Place Crash (Large Frame)",
      "GPOISO", "Poisoning",
      "GPSYCH", "Psychiatric",
      "GPUBS",  "Public Service",
      "GSDECT", "Smoke Detector Install",
      "GSEIZ",  "Seizure",
      "GSMKIN", "Smoke Invest Outdoor",
      "GSMOKE", "Smell of Smoke in Structure",
      "GSOB",   "Breathing Problems",
      "GSTAND", "Stand by Units",
      "GSTBGS", "Stabbing/Gunshot",
      "GSTEMI", "Inter-Facility",
      "GSTRHR", "Structure Fire (High Rise)",
      "GSTRO",  "Structure Fire (Other)",
      "GSTROKE","Stroke",
      "GSTRS",  "Structure Fire (Single Family)",
      "GSUICI", "Confirmed Suicide",
      "GSWMDO", "Swimmer In Distress (Ocean)",
      "GSWMDR", "Swimmer In Distress (River)",
      "GTRAPT", "Pt Trapped (Non-Vehicle)",
      "GTRAUM", "Trauma",
      "GTREE",  "Tree Down",
      "GUNCON", "Unconscious",
      "GUNK",   "Unknown Problems",
      "GUNREP", "Unresponsive",
      "GUTIL",  "Utility Emergency",
      "GVEH",   "Vehicle Fire ",
      "GVEHC",  "Commercial Vehicle Fire ",
      "GVOMIT", "Vomiting",
      "GWEAKN", "Weakness/Dizziness"
  });
}
