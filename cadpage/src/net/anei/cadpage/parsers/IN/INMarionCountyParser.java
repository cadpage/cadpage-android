package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INMarionCountyParser extends MsgParser {
  
  private static final Pattern MARKER = Pattern.compile("COI PUBLIC SAFETY CAD:|PUBLIC SAFETY CAD:? CAD:|CAD:");
  private static final Pattern MASTER = Pattern.compile("([^,]+), *([A-Z]{3}) (?:#(?:APT|RM|ROOM|SUIT|UNIT)? *((?![NS]\\d{5}\\b)[^ ]+)? )?(?:([NS]\\d{5} [EW]\\d{5}|[NS] [EW]) )?(.*)");
  private static final Pattern CALL_ID_PTN = Pattern.compile("\\b(I\\d{5})\\.?$");
  private static final Pattern UNIT_PTN = Pattern.compile("((?:(?:[A-Z]+[0-9]+|\\d+GRP|ALS|INDOT|IPAGE|MEDIA|CMND|CSTF|EXTF|IFSPOP|WPAGE|(?:IFD|PIK)[A-Z]{1,3}) *)+)[\\., ]*(.*)");
  
  public INMarionCountyParser() {
    super("MARION COUNTY", "IN");
    setFieldList("ADDR CITY APT MAP CALL UNIT INFO ID INFO");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pager.mecagov.org,CAD@page.indy.gov,777,888";
  }
  
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
    
    match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    data.strCity = convertCodes(match.group(2), CITY_CODES);
    data.strApt = append(data.strApt, "-", getOptGroup(match.group(3)));
    data.strMap = getOptGroup(match.group(4));
    String sExtra = match.group(5).trim();
    sExtra = stripFieldStart(sExtra, "*");
    String call = CODE_SET.getCode(sExtra);
    if (call != null) {
      data.strCall = call;
      sExtra = sExtra.substring(call.length()).trim();
    } else {
      Parser p = new Parser(sExtra);
      data.strCall = p.get(' ');
      sExtra = p.get();
    }
    match = CALL_ID_PTN.matcher(sExtra);
    if (match.find()) {
      data.strCallId = match.group(1);
      sExtra = sExtra.substring(0,match.start()).trim();
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
      "APT/ENTRAPMENT",
      "ASLT/TRM/UNSECUR",
      "ASSAULT/TRAUMA-C",
      "ASSIST PERSON",
      "BLDG/HR/WORKING",
      "BLEEDING/NONTRAU",
      "BUILD ALARM",
      "BUILDING",
      "BUILDING/WORKI",
      "BURNED PERSON",
      "CARD/ARREST/WRKG",
      "CARDIAC ARREST",
      "CHEST PAIN/HRT",
      "CIV/FATALITY",
      "CIV/SLIGHT/INJ",
      "CO DETECTOR",
      "DET",
      "DIABETIC",
      "DIFF BREATHING",
      "DOUBLE RESI/WRK",
      "DROWN/RESCUE",
      "EMER TRANSFER",
      "EMS/UNKNOWN",
      "EXPLOSION",
      "FF/SLIGHT/INJ",
      "FIELD",
      "GARAGE/WORKI",
      "GAS MAIN RUPTU",
      "GUNSHOT",
      "GUNSHOT/UNSECURE",
      "HEADACHE",
      "INJURED/EXTRICAT",
      "INJURED PERSON",
      "INJURED PERSON-C",
      "INVESTIGATE",
      "LARGE SPILL",
      "MASS CASUALTY 1",
      "MEDICAL ALARM",
      "MENT/ILL/UNSECUR",
      "MENTAL ILLNESS",
      "MINOR PI",
      "OVERDOSE",
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
      "RESID ALARM",
      "RESIDENCE",
      "RESIDENCE/WORKIN",
      "S E PI W/ENTRAPMENT",
      "SEIZURE",
      "SEMI/RV/MOTHM",
      "SICK PERSON",
      "SMALL SPILL/WRK",
      "SMELL OF SMOKE",
      "STABBING",
      "STABBING/UNSECUR",
      "STROKE/CVA",
      "STRUCT/COLLAPSE",
      "TEST INCIDENT",
      "TRAILOR/MOBIL HM",
      "UNCONSCIOUS PERS",
      "UNKNOWN SUBST",
      "VEHICL/ACCIDENT"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BGR", "Beech Grove",
      "HOM", "Homecroft",
      "IND", "Indianapolis",
      "PLF", "Plainfield",
      "LAW", "Lawrence",
      
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
