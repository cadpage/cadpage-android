package net.anei.cadpage.parsers.NC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCMecklenburgCountyAParser extends MsgParser {
  
  private static final Set<String> PRI_VALUES = new HashSet<String>(Arrays.asList(new String[]{"Charlie", "Delta", "Fire - Emergency"}));
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
  
  public NCMecklenburgCountyAParser() {
    super("MECKLENBURG COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "paging@rcscom.com,@huntersvillefd.com,Group_Page_Notification@archwireless.net,@huntersvillefd.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(body.length() < 74) return false;
    if (body.contains("Received:")) return false;
    
    boolean good = subject.equals("Text Page") || subject.equals("Incoming Message");
    
    parseAddress(substring(body,0,30), data);
    data.strApt = substring(body,30,40);
    data.strPlace = substring(body,40,70);
    data.strSupp = substring(body,70,100);
    data.strCall = substring(body,100,130);
    data.strCross = substring(body,130,190);
    data.strChannel = substring(body,190,200);
    data.strMap = substring(body,206,216);
    data.strCallId = substring(body,216);

    if (!good && !PRI_VALUES.contains(data.strSupp)) return false;
    
    int pt = data.strCall.indexOf('-');
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
    return true;
  }
}
