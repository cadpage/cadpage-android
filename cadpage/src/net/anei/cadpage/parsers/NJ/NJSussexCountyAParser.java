package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NJSussexCountyAParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[A-Z]{1,5}-[A-Z]?\\d{4}-?\\d{6}");
  private static final Pattern MASTER_PTN = 
    Pattern.compile("([-A-Z0-9 ]+) @ ([^,]+?) *, ([^-]*) -(?: (.*))?"); 
  
  public NJSussexCountyAParser() {
    super("SUSSEX COUNTY", "NJ");
    setFieldList("ID CODE CALL ADDR APT CITY INFO");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! SUBJECT_PTN.matcher(subject).matches()) return false;
    data.strCallId = subject;
    body = body.replace('\n', ' ');
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim();
    String call = CALL_CODES.getProperty(data.strCall);
    if (call != null) {
      data.strCode = data.strCall;
      data.strCall = call;
    }
    
    parseAddress(match.group(2).trim(), data);
    data.strCity = match.group(3).trim();
    String sInfo = getOptGroup(match.group(4));
    if (data.strAddress.equals("OUT OF TOWN")) {
      data.strAddress = "";
      parseAddress(StartType.START_ADDR, sInfo, data);
      data.strSupp = getLeft();
      data.defCity = "";
      data.defState = "";
    } else {
      data.strSupp = sInfo;
    }
    return true;
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      // "1045F",    "1045F",
      "ALARMF",   "FIRE ALARM",
      "ALMCO",    "FIRE ALARM CO",
      "ALMCOM",   "FIRE ALARM CO",
      "ALMRES",   "FIRE ALARM RES",
      // "BURN-F",   "BURN-F",
      // "ASSIST-F", "ASSIST-F",
      "FDPLANE",  "FIRE AIRCRAFT",
      // "FFIRA",    "FFIRA",
      // "FIREPD",   "FIREPD",
      "FUEL",     "FUEL SPILL",   
      // "HAZODR",   "HAZODR",
      "MED",      "MEDICAL",
      // "MEDALS",   "MEDALS",
      "MVA-F",    "MV CRASH W/INJURY",
      "MVAINJ",   "MV CRASH W/INJURY",
      "PUBAST",   "PUBLIC ASSIST",
      // "PUMP",     "PUMP",
      "TRANSF",   "TRANSFER",
      
      "FALARM",   "FIRE ALARM",
      "FALCO",    "FIRE ALARM CO",
      "FBRSH",    "FIRE BRUSH",
      "FBRUSH",   "FIRE BRUSH",
      "FGAS",     "FIRE GAS LEAK",
      "FIRE",     "FIRE",                   // Was FIRE LANDING ZONE ???
      "FMA",      "FIRE MUTUAL AID",
      "FOTHER",   "FIRE OTHER",
      "FSMKCOND", "SMOKE CONDITION",
      "FSTRUC",   "STRUCTURE FIRE",
      "FSTRUCT",  "FIRE STRUCTURE",
      "FVEHICLE", "FIRE VEHICLE",
      "MDSTB",    "MEDICAL STAND BY",
      "MEDEM",    "MEDICAL EMERGENCY",
      "MEDMA",    "MEDICAL MUTUAL AID",
      "MGAS",     "EMS GAS LEAK",
      "MVCIEMS",  "MV CRASH W/INJURY",
      "MVCIFD",   "MV CRASH W/INJURY"
      
  });
}
