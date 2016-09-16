package net.anei.cadpage.parsers.NC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.MsgType;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCMecklenburgCountyAParser extends MsgParser {
  
  public NCMecklenburgCountyAParser() {
    super("MECKLENBURG COUNTY", "NC");
    setFieldList("ADDR APT PLACE INFO CODE CALL X UNIT MAP ID");
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
  }
  
  @Override
  public String getFilter() {
    return "paging@rcscom.com,@huntersvillefd.com,Group_Page_Notification@archwireless.net,@huntersvillefd.com,cadmail@medic911.com";
  }
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("([-0-9]+) +(Received: *\\d\\d:\\d\\d *Assigned: *\\d\\d:\\d\\d *Enroute: *.*?) *INC #.*");
  private static final Pattern RUN_REPORT_DELIM_PTN = Pattern.compile("(?<! ) *(?=Assigned:|Enroute:|Arrived:|Pt Contact:|Pt Cont:|Depart:|Hospital:|Available:|Cancelled:)");
  private static final Pattern PREFIX_PTN = Pattern.compile("Fire threatening Structure\\.");
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    int pt = body.indexOf("\n\n");
    if (pt >= 0) body = body.substring(0,pt).trim();

    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.msgType = MsgType.RUN_REPORT;
      data.strCallId = match.group(1);
      data.strSupp = RUN_REPORT_DELIM_PTN.matcher(match.group(2).trim()).replaceAll("\n");
      return true;
    }
    if (body.length() < 74) return false;
    
    String prefix = null;
    FParser fp = new FParser(body);
    if (PREFIX_PTN.matcher(body).lookingAt()) prefix = fp.get(33);
    parseAddress(fp.get(30), data);
    data.strApt = fp.get(10);
    data.strPlace = fp.get(30);
    fp.setOptional();
    data.strSupp = fp.get(30);
    data.strCall = fp.get(30);
    data.strCross = fp.get(60);
    data.strUnit = fp.get(10);
    if (!fp.check("Map -")) return false;
    data.strMap = fp.get(10);
    data.strCallId = fp.get();

    String check = data.strSupp;
    pt = check.indexOf('-');
    if (pt >= 0) check = check.substring(0,pt).trim();
    if (!PRI_VALUES.contains(check)) return false;
    
    pt = data.strCall.indexOf('-');
    if (pt < 0) pt = data.strCall.length();
    if (pt >=2 && pt<=5) {
      data.strCode = data.strCall.substring(0,pt).trim();
      if (pt == data.strCall.length()) data.strCall = "";
      else data.strCall = data.strCall.substring(pt+1).trim();
      String callDesc = CALL_CODES.getProperty(data.strCode);
      if (callDesc != null && callDesc.startsWith(data.strCall)) data.strCall = callDesc;
    }
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
    }
    if (prefix != null) data.strSupp = append(prefix, "\n", data.strSupp);
    return true;
  }
  
  @Override
  protected String adjustGpsLookupAddress(String address) {
    return address.toUpperCase();
  }

  private static Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "2700 ROYAL COMMONS LN",      "35.117028,-80.691764"
  });
  
  @Override
  public String adjustMapAddress(String addr) {
    return PK_PTN.matcher(addr).replaceAll("PKWY");
  }
  private static final Pattern PK_PTN = Pattern.compile("\\bPK\\b", Pattern.CASE_INSENSITIVE);
  
  private static final Set<String> PRI_VALUES = new HashSet<String>(Arrays.asList(new String[]{
      "Alpha", 
      "Bravo", 
      "Campus ALS",
      "Charlie", 
      "Delta",
      "Demo/Public Relations",
      "Demo",
      "ECHO",
      "Fire", 
      "Scheduled",
      "Scheduled BLS",
      "unkFire"
  }));

  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "06", "Breathing Problems",
      "10", "Chest Pain",
      "12", "Convulsion/Seizure",
      "17", "Falls/Back injuries",
      "23", "Overdose/Ingestion/Poison",
      "26", "Sick person", 
      "28", "Stroke/CVA",
      "29", "Traffic accident",
      "30", "Traumatic injuries",
      "31", "Unconsciousness/Fainting",
      "32", "Unknown problem",
      "42", "Fire/Police support",
      "52F", "Alarm-FIRE",
      "59", "Fuel Spill",
      "69", "Structure Fire",
  });
}
