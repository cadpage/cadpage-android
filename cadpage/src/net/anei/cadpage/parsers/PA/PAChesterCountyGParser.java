package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;




public class PAChesterCountyGParser extends PAChesterCountyBaseParser {
  
  public PAChesterCountyGParser() {
    super(null);
  }
  
  @Override
  public String getFilter() {
    return "gallison39@comcast.net,messaging@iamresponding.com";
  }
  
  private static final Pattern TERMINATOR_PTN = Pattern.compile("\nPRIOR PREMISE HISTORY");
  private static final Pattern SOFT_BREAK_PTN = Pattern.compile("\n(?=[^/ ])");
  
  private static final Pattern ID_PTN = Pattern.compile("Inc History #([A-Z]+\\d+) ");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\n *Dispatched  +(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d:\\d\\d) +");
  private static final Pattern CALL_PTN = Pattern.compile(" Final Type: (.*?)\n");
  private static final Pattern BOX_PTN = Pattern.compile("\n *Police BOX: [A-Z0-9]*  Fire BOX: (\\d*)  EMS BOX: (\\d*) *(?=\r?\n)");
  private static final Pattern MAP_PTN = Pattern.compile(" Map: ([A-Z0-9]*) +X:");
  private static final Pattern ADDR_PTN = Pattern.compile("\n *Loc: *(.*?) *(?=\r?\n)");
  private static final Pattern PLACE_CITY_PTN = Pattern.compile("\n *AKA: +(.*?) +Municipality: *(.*?) +Dev:");
  private static final Pattern NAME_PHONE_PTN = Pattern.compile("\n *Name: +(.*?) +Addr: +(.*?) +PH: *(.*?) *\r?\n");
  private static final Pattern NEXT_LINE_PTN = Pattern.compile("(.*?)(?:(\r?\n)|$)");
  
  private static final Pattern ENTRY_MARK_PTN = Pattern.compile("^/\\d++\\?? ");
  private static final Pattern CONT_MARK_PTN = Pattern.compile("^ {30}"); 
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!isVariantGMsg(body)) return false;
    
    Matcher match = TERMINATOR_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    body = SOFT_BREAK_PTN.matcher(body).replaceAll(" ");
    
    Parser p = new Parser(body);
    
    match = p.getMatcher(ID_PTN);
    if (match == null) return false;
    data.strCallId = match.group(1);
    
    match = p.getMatcher(DATE_TIME_PTN);
    if (match == null) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    
    match = p.getMatcher(CALL_PTN);
    if (match == null) return false;
    data.strCall = match.group(1).trim();
    
    match = p.getMatcher(BOX_PTN);
    if (match == null) return false;
    String fireBox = match.group(1);
    if (fireBox.length() > 0) fireBox = "F:" + fireBox;
    String emsBox = match.group(2);
    if (emsBox.length() > 0) emsBox = "E:" + emsBox;
    data.strBox = append(fireBox, " ", emsBox);
    
    match = p.getMatcher(MAP_PTN);
    if (match == null) return false;
    data.strMap = match.group(1);
    
    match = p.getMatcher(ADDR_PTN);
    if (match == null) return false;
    parseAddressA7(match.group(1).trim(), data);
    
    match = p.getMatcher(PLACE_CITY_PTN);
    if (match == null) return false;
    data.strPlace = append(data.strPlace, " - ", match.group(1).trim());
    data.strCity = convertCityCode(match.group(2).trim());
    
    match = p.getMatcher(NAME_PHONE_PTN);
    if (match == null) return false;
    data.strName = match.group(1).trim();
    String sAddr = match.group(2).trim();
    if (sAddr.length() > 0 && !sAddr.equals(data.strAddress)) {
      data.strName = data.strName + " (" + sAddr + ")";
    }
    data.strPhone = match.group(3).trim();
    
    boolean entry = false;
    while (true) {
      match = p.getMatcher(NEXT_LINE_PTN);
      if (match == null) break;
      String line = match.group(1);
      if (line.trim().length() == 0) continue;
      if (line.length() < 23) break;
      if (ENTRY_MARK_PTN.matcher(line).find()) {
        String type = line.substring(17,23).trim();
        entry = type.equals("ENTRY") || type.equals("COPY") || type.equals("SUPP");
        if (entry && line.length() > 34) {
          line = line.substring(34).trim();
          if (line.startsWith("TXT:")) line = line.substring(4).trim();
          data.strSupp = append(data.strSupp, "\n", line);
        }
        else if (type.equals("DISP") || type.equals("ASST")) {
          data.strUnit = append(data.strUnit, " ", substring(line,26,33).trim());
        }
      }
      else if (CONT_MARK_PTN.matcher(line).find()) {
        if (entry && line.length() > 33) {
          line = line.substring(33).trim();
          if (line.startsWith("TXT:")) {
            data.strSupp = append(data.strSupp, "\n", line.substring(4).trim());
          } else {
            data.strSupp = append(data.strSupp, " ", line);
          }
        }
      }
      else break;
      if (match.group(2) == null) break;
    }
    
    return true;
  }
} 
