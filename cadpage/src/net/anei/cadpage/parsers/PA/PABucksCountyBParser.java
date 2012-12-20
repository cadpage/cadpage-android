  package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Bucks County, PA
 */

public class PABucksCountyBParser extends PABucksCountyBaseParser {
  
  public PABucksCountyBParser() {
    super(null);
  }
  
  @Override
  public String getFilter() {
    return "8276,@bnn.us,iamresponding.com,Bucks RSAN,@alert.bucksema.org";
  }
  
  private static final Pattern TERMINATOR_PTN = Pattern.compile("\n+--");
  private static final Pattern SOFT_BREAK_PTN = Pattern.compile("\n(?=[^/ ])");
  
  private static final Pattern SRC_PTN = Pattern.compile("TO INT1 FROM [A-Z0-9]+ +: +(?:\n(?=/))?(.*?)(?=\n)");
  private static final Pattern ID_PTN = Pattern.compile("\n *Inc History for: #([A-Z]{2}\\d+)\\b");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\n *Dispatched  +(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d:\\d\\d) +");
  private static final Pattern CALL_PTN = Pattern.compile("\n *Final Type: (.*?) Pri:");
  private static final Pattern BOX_MAP_PTN = Pattern.compile("\n *EMS Blk: +(\\d*) +Fire Blk: +(\\d*) +Police Blk: +\\d* +Map Page: *([A-Z0-9]*) *(?=\r?\n)");
  private static final Pattern ADDR_PTN = Pattern.compile("\n *Loc: *(.*?) *(?=\r?\n)");
  private static final Pattern PLACE_NAME_PHONE_PTN = Pattern.compile("\n *Loc Info: *(.*?)\r?\n *Name: +(.*?) +Addr: +(.*?) +Phone: *(.*?) *\r?\n");
  private static final Pattern NEXT_LINE_PTN = Pattern.compile("(.*?)(?:(\r?\n)|$)");
  
  private static final Pattern ENTRY_MARK_PTN = Pattern.compile("^/\\d++\\?? ");
  private static final Pattern CONT_MARK_PTN = Pattern.compile("^ {30}"); 
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = TERMINATOR_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    body = SOFT_BREAK_PTN.matcher(body).replaceAll(" ");
    
    Parser p = new Parser(body);
    
    match = p.getMatcher(SRC_PTN);
    if (match == null) return false;
    data.strSource = match.group(1).trim();
    
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
    
    match = p.getMatcher(BOX_MAP_PTN);
    if (match == null) return false;
    String fireBox = match.group(2);
    if (fireBox.length() > 0) fireBox = "F:" + fireBox;
    String emsBox = match.group(1);
    if (emsBox.length() > 0) emsBox = "E:" + emsBox;
    data.strBox = append(fireBox, " ", emsBox);
    data.strMap = match.group(3);
    
    match = p.getMatcher(ADDR_PTN);
    if (match == null) return false;
    parseAddressA7(match.group(1).trim(), data);
    
    match = p.getMatcher(PLACE_NAME_PHONE_PTN);
    if (match == null) return false;
    data.strPlace = append(data.strPlace, " - ", match.group(1).trim());
    data.strName = match.group(2).trim();
    String sAddr = match.group(3).trim();
    if (sAddr.length() > 0 && !sAddr.equals(data.strAddress)) {
      data.strName = data.strName + " (" + sAddr + ")";
    }
    data.strPhone = match.group(4).trim();
    
    boolean entry = false;
    while (true) {
      match = p.getMatcher(NEXT_LINE_PTN);
      if (match == null) break;
      String line = match.group(1);
      if (line.trim().length() == 0) continue;
      if (line.length() < 27) break;
      if (ENTRY_MARK_PTN.matcher(line).find()) {
        String type = line.substring(19,25).trim();
        entry = type.equals("ENTRY:") || type.equals("COPY") || type.equals("SUPP");
        if (entry && line.length() > 33) {
          line = line.substring(33).trim();
          if (line.startsWith("TXT:")) line = line.substring(4).trim();
          data.strSupp = append(data.strSupp, "\n", line);
        }
        else if (type.equals("DISP") || type.equals("ADD")) {
          data.strUnit = append(data.strUnit, " ", substring(line,27,33).trim());
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
