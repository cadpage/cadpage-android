package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class MDGarrettCountyParser extends SmartAddressParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("CAD:([^ ]+) +(.*)");
  private static final Pattern MASTER_PTN = Pattern.compile("(\\d\\d?:\\d\\d?:\\d\\d?) +(.*?) +DUE: *([A-Z0-9]+) +([A-Z]{2}\\d{10})(?: +(.*))?");
  private static final Pattern CALL_ADDR_PTN = Pattern.compile("(.*?) (?:@!|[^\\p{ASCII}] |(\\d{2,3}[A-Z]\\d{2}[A-Z]?|\\d{5}) )(.*)");
  
  public MDGarrettCountyParser() {
    super("GARRETT COUNTY", "MD");
    setupCallList(CALL_LIST);
    setFieldList("TIME CALL CODE ADDR APT PLACE UNIT ID INFO");
  }
  
  @Override
  public String getFilter() {
    return "garrettco911@garrettcounty.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.startsWith("Times - ")) {
      data.strCall = "RUN REPORT";
      data.strUnit = subject.substring(8).trim();
      data.strPlace = body;
   		Matcher match = RUN_REPORT_PTN.matcher(body);
   		if (match.matches()) {
   		  data.strCallId = match.group(1);
   		  data.strPlace = match.group(2);
   		}
   		return true;
    }
    
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strTime = match.group(1);
    String sCallAddr = match.group(2).trim();
    data.strUnit = match.group(3).trim();
    data.strCallId = match.group(4);
    data.strSupp = getOptGroup(match.group(5));
    
    Parser p = new Parser(sCallAddr);
    data.strPlace = p.getLastOptional("[@");
    String apt = p.getLastOptional("[APT ");
    sCallAddr = p.get();
    
    match = CALL_ADDR_PTN.matcher(sCallAddr);
    if (match.matches()) {
      data.strCall = match.group(1);
      data.strCode =  getOptGroup(match.group(2));
      parseAddress(match.group(3), data);
    }
    else {
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, sCallAddr, data);
    }
    data.strApt = append(data.strApt, "-", apt);
    return true;
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL PAIN",
      "ALLERGIC REACTION",
      "BACK PAIN",
      "BLEEDING",
      "CARDIAC ARREST",
      "CHOKING",
      "CHEST PAIN",
      "DIABETIC EMERGENCY",
      "DIFFICULTY BREATHING",
      "DISTURBANCE / NUISANCE",
      "DOMESTIC DISTURBANCE",
      "FALL INJURY",
      "FIRE ALARM/COMMERCIAL",
      "LIFT ASSIST NON EMERG",
      "MEDIC ASSIST",
      "MEDICAL ALARM",
      "MEDICAL EMERGENCY",
      "MVC",
      "MVC INJURIES",
      "MVC ROLLOVER",
      "MVC UNK INJURIES",
      "OVERDOSE",
      "SEIZURES",
      "STROKE / CVA",
      "TRANSPORT",
      "TRAUMA / INJURIES",
      "TREE DOWN",
      "UNCONSCIOUS/FAINTING"
  );
}
