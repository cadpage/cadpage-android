package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class VASmythCountyParser extends DispatchSouthernParser {
  
  public VASmythCountyParser() {
    super(CALL_LIST, CITY_LIST, "SMYTH COUNTY", "VA", DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE);
  }

  @Override
  public String getFilter() {
    return "@smythcounty.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (! super.parseMsg(body, data)) return false;
    
    // Check for a missing call that we just did not recognize
    if (data.strCall.length() == 0) {
      Matcher match = CODE_CALL_PTN.matcher(data.strSupp);
      if (match.matches()) {
        data.strCall = match.group(1);
        data.strSupp = match.group(2);
      }
    }
    return true;
  }
  private static final Pattern CODE_CALL_PTN = Pattern.compile("([A-Z]+ - [A-Z]+)\\b *(.*)");

  private static final CodeSet CALL_LIST = new CodeSet(
      "AC - TRAFFIC ACCIDENT",
      "AGE - AGENCY ASSISTANCE",
      "AL - ALARM",
      "ALE - ALERGIC REACTION",
      "BL - BLEEDING",
      "BOM - BOMB THREAT",
      "CAR - CARDIAC CALL",
      "CHO - CHOKING",
      "DEH - DEHYDRATED",
      "DIA - DIABETIC",
      "DIF - DIFFICULTY IN BREATHING",
      "DIZ - DIZZY",
      "DOA - DEAD ON ARRIVAL",
      "DOM - DOMESTIC",
      "DST - DISTURBANCE",
      "DUP - DUPLICATE CALL",
      "FAL - FALL",
      "FEV - FEVER",
      "FIR - FIRE ALL TYPES",
      "HAN - 911 HANG UP",
      "INV - INVESTIGATION",
      "JUV - JUVENILE",
      "OV - OVERDOSE",
      "PAI - PAIN",
      "RAP - RAPE",
      "RES - RESCUE",
      "SEI - SEIZURE",
      "SIC - SICK",
      "SMO - SMOKE REPORT",
      "STR - STROKE",
      "SUI - SUICIDE",
      "TRA - TRANSPORT",
      "TRH - TRAFFIC HAZARD PC",
      "UNK - UNKNOWN NATURE OF CALL",
      "UNR - UNRESPONSIVE",
      "UT - UTILITIES",
      "WEL - WELFARE CHECK"
  );
  
  private static final String[] CITY_LIST = new String[]{
    "CHILHOWIE",
    "MARION",
    "SALTVILLE",
    
    "ADWOLF",
    "ATKINS",
    "SEVEN MILE FORD",
    "SUGAR GROVE"
  }; 
}
