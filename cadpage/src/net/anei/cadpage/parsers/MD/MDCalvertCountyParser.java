package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MDCalvertCountyParser extends SmartAddressParser {
  
  private static final Pattern TIME_DATE_PTN = Pattern.compile("\\b(\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d\\d)\\b");
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(?:[BETSRAM]\\d{1,3}|TN\\d|NDC|NMED|COM)\\b");
  private static final Pattern PRIORITY_PTN = Pattern.compile("M Priority (\\d) +(.*)");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{4}-\\d{8}\\b");
  private static final Pattern INFO_BREAK_PTN = Pattern.compile("^[-A-Z ]+?(\\b)(?:$|[A-Z]*[a-z0-9])");
  
  public MDCalvertCountyParser() {
    super(CITY_LIST, "CALVERT COUNTY", "MD");
    setFieldList("TIME DATE PRI CALL UNIT BOX ADDR PLACE CITY ID CODE INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.cal.md.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher timeDateMatch = TIME_DATE_PTN.matcher(body);
    if (! timeDateMatch.find()) return false;
    data.strTime = timeDateMatch.group(1);
    data.strDate = timeDateMatch.group(2);
    
    String strCall = body.substring(0,timeDateMatch.start()).trim();
    Matcher unitMatch = UNIT_PTN.matcher(strCall);
    if (unitMatch.find()) {
      data.strUnit = strCall.substring(unitMatch.start());
      strCall = strCall.substring(0,unitMatch.start()).trim();
    }
    Matcher priMatch = PRIORITY_PTN.matcher(strCall);
    if (priMatch.matches()) {
      data.strPriority = priMatch.group(1);
      strCall = priMatch.group(2);
    }
    data.strCall = strCall;
    
    String addr = body.substring(timeDateMatch.end()).trim();
    Parser p = new Parser(addr);
    if (p.get(' ').equalsIgnoreCase("BOX")) {
      data.strBox = p.get(' ');
      addr = p.get();
    }
    
    String left;
    Matcher idMatch = ID_PTN.matcher(addr);
    if (idMatch.find()) {
      data.strCallId = idMatch.group();
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, addr.substring(0,idMatch.start()).trim(), data);
      left = addr.substring(idMatch.end()).trim();
    } else {
      parseAddress(StartType.START_ADDR, addr, data);
      left = getLeft();
    }
    
    // We pretty much always expect to find a place name.  If we didn't, see
    // if we can parse it from the front of the leftover stuff
    if (data.strCity.length() == 0) {
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, left, data);
      left = getLeft();
    }
    
    // What is left is either a place name or supplemental info.  
    // And there is no consistent way to separate them
    int brk = 0;
    Matcher match = INFO_BREAK_PTN.matcher(left);
    if (match.find()) {
      brk = match.start(1);
      if (brk > 35) brk = 0;
    }
    data.strPlace = left.substring(0,brk).trim();
    left = left.substring(brk);
    
    if (left.length() > 0) {
      int start = left.length();
      start = stripPattern(left, start, INFO_CODE_PTN, INFO_CODE_PROC, data);
      start = stripPattern(left, start, INFO_CALL_PTN2, INFO_CALL_PROC, data);
      start = stripPattern(left, start, INFO_CALL_PTN1, INFO_CALL_PROC, data);
      start = stripPattern(left, start, INFO_SKIP_PTN);
      left = left.substring(0,start).trim();
    }

    data.strSupp = left;
    
    // Special case
    if (data.strPlace.equals("MARYS") && data.strAddress.endsWith(" ST")) {
      data.strPlace = "ST MARYS";
      data.strAddress = data.strAddress.substring(0, data.strAddress.length()-3).trim();
    }
    return true;
  }
  
  private static final Pattern INFO_CODE_PTN = Pattern.compile("\\bDispatch Code: +([^ ]+)");
  private static Processor INFO_CODE_PROC = new Processor(){
    public void process(Matcher match, Data data) {
      String code = match.group(1);
      if (!code.equals("--:")) data.strCode = match.group(1);
    }
  };
  
  private static final Pattern INFO_CALL_PTN1 = Pattern.compile("\\bProblem: (.*?)\\.  Patient Info:"); 
  private static final Pattern INFO_CALL_PTN2 = Pattern.compile("\\bCaller Statement: (.*?)\\."); 
  private static Processor INFO_CALL_PROC = new Processor(){
    public void process(Matcher match, Data data) {
      data.strCall = match.group(1);
    }
  };
  
  private static final Pattern INFO_SKIP_PTN = 
      Pattern.compile("\\bProQA (?:Medical|Fire|Police) |\\bE911 Info - |\\bYou are responding to ");
  
  private int stripPattern(String info, int start, Pattern ptn) {
    return stripPattern(info, start, ptn, null, null);
  }
  
  private int stripPattern(String info, int start, Pattern ptn, Processor proc, Data data) {
    Matcher match = ptn.matcher(info);
    if (!match.find()) return start;
    if (proc != null) proc.process(match,  data);
    return Math.min(start, match.start());
  }
  
  private static interface Processor {
    public void process(Matcher match, Data data);
  }
  
  private static final String[] CITY_LIST = new String[] {
    "CHESAPEAKE BEACH", 
    "NORTH BEACH", 
    "DUNKIRK", 
    "HUNTINGTOWN", 
    "LUSBY",
    "OWINGS", 
    "PRINCE FREDERICK", 
    "SAINT LEONARD",
    "ST LEONARD", 
    "SOLOMONS",
    "BARSTOW", 
    "BROOMES ISLAND", 
    "DARES BEACH", 
    "DOWELL", 
    "LOWER MARLBORO", 
    "PORT REPUBLIC", 
    "SUNDERLAND"
  };
}
