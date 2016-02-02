package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INMarionCountyParser extends MsgParser {
  
  public INMarionCountyParser() {
    super("MARION COUNTY", "IN");
    setFieldList("ADDR CITY APT MAP CALL UNIT INFO ID INFO");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pager.mecagov.org,CAD@page.indy.gov,777,888";
  }
  
  private static final Pattern EX_PTN = Pattern.compile("\\bEX\\b", Pattern.CASE_INSENSITIVE);
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = EX_PTN.matcher(addr).replaceAll("EXPW");
    return super.adjustMapAddress(addr);
  }
  
  private static final Pattern MARKER = Pattern.compile("COI PUBLIC SAFETY CAD:|PUBLIC SAFETY CAD:? CAD:|CAD:");
  private static final String APT_PTN = "(?:#(?:APT|RM|ROOM|SUIT|UNIT)? *((?![NS]\\d{5}\\b)[^ ]+)? )";
  private static final String MAP_PTN = "(?:([NS]\\d{5} [EW]\\d{5}|[NS] +[EW]|SHENDR EHENDR) )";
  private static final Pattern MASTER1 = Pattern.compile("([^,]+), *([A-Z]{3}) " + APT_PTN + "?" + MAP_PTN + "?(.*)");
  private static final Pattern MASTER2 = Pattern.compile("([^,]+?) " + APT_PTN + "?" + MAP_PTN + "(.*)");
  private static final Pattern CALL_ID_PTN = Pattern.compile("\\b(I\\d{5})\\.?$");
  private static final Pattern UNIT_PTN = Pattern.compile("\\b((?:(?:[A-Z]+[0-9]+[A-Z]?|\\d+CIV|\\d+FF|\\d+GRP|[A-Z]+GRP|\\d+TN|[A-Z]+FYI|[A-Z]{2}FD|[A-Z]{3}ADM|[A-Z]{2}TF|ALS|AMO|BKCREG|BKCRMD|COMM|COMVAN|DHS|FYI[A-Z]+|HMEDIA|IFDEDO|INDOT|IPAGE|IUPAGE|MEDIA|CMND|IFSPOP|STI|WPAGE|WRKFIR|XLFCHF|XLMCOR|(?:IFD|PIK)[A-Z]{1,3})\\b *)+)[\\., ]*(.*)");
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    Matcher match = MARKER.matcher(body);
    if (match.lookingAt()) body = body.substring(match.end()).trim();
    
    if (subject.endsWith(" MAJOR PAGE FYI")) {
      data.strSupp = body;
      body = subject.substring(0,subject.length()-15).trim();
    }
    
    else {
      pt = body.lastIndexOf('@');
      if (pt >= 0) {
        data.strSupp = body.substring(pt+1).trim();
        body = body.substring(0,pt).trim();
      }
    }
    
    match = MASTER1.matcher(body);
    String sAddr, sApt, sMap, sExtra;
    if (match.matches()) {
      sAddr = match.group(1);
      data.strCity = convertCodes(match.group(2), CITY_CODES);
      sApt = match.group(3);
      sMap = match.group(4);
      sExtra = match.group(5);
    }
    
    else if ((match = MASTER2.matcher(body)).matches()) {
      sAddr = match.group(1);
      sApt = match.group(2);
      sMap = match.group(3);
      sExtra = match.group(4);
    }
    
    else return false;
    
    parseAddress(sAddr.trim(), data);
    data.strApt = append(data.strApt, "-", getOptGroup(sApt));
    data.strMap = getOptGroup(sMap).replaceAll("  +", " ");
    sExtra = stripFieldStart(sExtra.trim(), "*");
    
    match = CALL_ID_PTN.matcher(sExtra);
    if (match.find()) {
      data.strCallId = match.group(1);
      sExtra = sExtra.substring(0,match.start()).trim();
    }

    String call = CODE_SET.getCode(sExtra);
    if (call != null) {
      data.strCall = call;
      sExtra = sExtra.substring(call.length()).trim();
      match = UNIT_PTN.matcher(sExtra);
      if (match.matches()) {
        data.strUnit = match.group(1).trim();
        sExtra = match.group(2);
      }
    } else {
      match = UNIT_PTN.matcher(sExtra);
      if (match.find()) {
        data.strCall = sExtra.substring(0,match.start()).trim();
        data.strUnit = match.group(1).trim();
        sExtra = match.group(2);
      } else {
        Parser p = new Parser(sExtra);
        data.strCall = p.get(' ');
        sExtra = p.get();
      }
    }
    match = UNIT_PTN.matcher(sExtra);
    if (match.matches()) {
      data.strUnit = match.group(1).trim();
      sExtra = match.group(2);
    }
    data.strSupp = append(sExtra, " / ", data.strSupp);
    return true;
  }
  
  @Override
  public CodeSet getCallList() {
    return CODE_SET;
  }

  private static final CodeSet CODE_SET = new CodeSet(
      "ABDOMIN/BACK PN",
      "ALLERGIC REACTIO",
      "APARTMENT",
      "APARTMNT/WORKI",
      "APT ALARM",
      "APT/ENTRAPMENT",
      "ASLT/TRM/UNSECUR",
      "ASSAULT/TRAUMA",
      "ASSAULT/TRAUMA-C",
      "ASSIST PERSON",
      "BLEED/NONTRAU-C",
      "BLDG/HR/WORKING",
      "BLEEDING/NONTRAU",
      "BUILD ALARM",
      "BUILDING",
      "BUILDING/WORKI",
      "BURNED PERSON",
      "CARD/ARREST/WRKG",
      "CARDIAC ARREST",
      "CHEMICAL SPILL",
      "CHEST PAIN/HRT",
      "CIV/FATALITY",
      "CIV/SLIGHT/INJ",
      "CO DETECTOR",
      "DBL RES/ENTR/WRK",
      "DEPT VEH ACCIDNT",
      "DET",
      "DIABETIC",
      "DIFF BREATHING",
      "DOUBL RES/ENTRAP",
      "DOUBLE RESI/WRK",
      "DROWN/RESCUE",
      "ELEVATOR",
      "EMER TRANSFER",
      "EMS/UNKNOWN",
      "EXPLOSION",
      "FF/SLIGHT/INJ",
      "FF/TRANSPORTED",
      "FIELD",
      "FLULIKE SYMPTOMS",
      "GARAGE",
      "GARAGE/WORKI",
      "GAS MAIN RUPTU",
      "GAS ODOR/BUILD",
      "GAS ODOR/OUTSIDE",
      "GRASS/LEAVES",
      "GUNSHOT",
      "GUNSHOT/UNSECURE",
      "GYNECOLOGY",
      "HAZ-MAT WORK",
      "HEADACHE",
      "HOSP/NUR HM/WORK",
      "HOSP/NUR HR/ALRM",
      "INJ/CIV/TRANSP",
      "INJ/FF/TRANSP",
      "INJURED/EXTRICAT",
      "INJURED PERSON",
      "INJURED PERSON-C",
      "INVERTED VEHICLE",
      "INVESTIGATE",
      "LARGE SPILL",
      "MASS CASUALTY 1",
      "MEDICAL ALARM",
      "MEET THE POLICE",
      "MENT/ILL/UNSECUR",
      "MENTAL ILLNESS",
      "MINOR PI",
      "MOD STRUC/COLLPS",
      "MOTORCYCLE PI",
      "NEURO/HEAD INJ",
      "OB/CHILDBIRTH",
      "OVERDOSE",
      "OVERDOSE/UNSECUR",
      "PEDESTRN STRUCK",
      "PERS LOCKED/VEH",
      "PERSON CHOKING",
      "PI TACTICAL",
      "PI/TACTICAL",
      "PI TACTICAL/WORK",
      "PI W/ENTRAPMENT",
      "PI W/ ENTRAPMENT",
      "PI W/EXTRAPMENT",
      "PI WORK/ENTRAP",
      "POWER LINES DOWN",
      "PROJ LF/SVR SRCH",
      "REACTION",
      "REQUEST ASSIST",
      "RESID ALARM",
      "RESIDENCE",
      "RES ENTRAP/WRK",
      "RES ENTRAPMNT",
      "RESIDENCE/WORKIN",
      "ROPE RESCUE",
      "S E PI W/ENTRAPMENT",
      "SCHOOL ALARM",
      "SCHOOL/WORKING",
      "SEIZURE",
      "SEMI/RV/MOTHM",
      "SICK AND DIZZY",
      "SICK PERSON",
      "SICK PERSON-C",
      "SMALL SPILL",
      "SMALL SPILL/WRK",
      "SMELL OF SMOKE",
      "STABBING",
      "STABBING/UNSECUR",
      "STANDBY",
      "STR/COLLAPSE/WRK",
      "STROKE/CVA",
      "STRUCT/COLLAPSE",
      "TEST INCIDENT",
      "TRAILOR/MOBIL HM",
      "TRASH",
      "UNCON PERSON",
      "UNCONSCIOUS PERS",
      "UNKNOWN SUBST",
      "UNRESPONSIVE",
      "URBAN SEARCH",
      "UTILITY POLE",
      "VEHICL/ACCIDENT",
      "VEHICLE FIRE",
      
      // WTF???
      "F",
      "N"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{

      "AIR", "Indianapolis",
      "AVN", "Avon",
      "BBG", "Brownsburg",
      "BGR", "Beech Grove",
      "CAM", "Camby",
      "CAR", "Cartersburg",
      "CLR", "Clermont",
      "CLY", "Clayton",
      "CTV", "Clayton",
      "DAN", "Danville",
      "HOM", "Homecroft",
      "IND", "Indianapolis",
      "LAW", "Lawrence",
      "LIZ", "Lizton",
      "MOV", "Monrovia",
      "PIT", "Pittsboro",
      "PLF", "Plainfield",


      "DEC", "Decatur TWP",
      "FRA", "Franklin Township",
      "LWR", "Lawrence TWP",
      "PER", "Perry TWP",
      "PIK", "Pike TWP",
      "SPD", "Speedway",
      "WAR", "Warren TWP",
      "WAS", "Washington TWP",
      "WAY", "Wayne TWP",
      
      "HAM", "Hamilton County"
      

      
  });
}
