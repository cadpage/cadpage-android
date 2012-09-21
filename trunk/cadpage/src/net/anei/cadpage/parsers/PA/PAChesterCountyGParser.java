package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;


/* 
Chester County, PA (variant G - The long form)
Contact: "jtgff72@aol.com" <jtgff72@aol.com>
Sender: wgfc22@comcast.net

Inc History #NCCF12000028           \n                      \n Entered      04/17/12  13:15:35  BY FD16     135    \n Dispatched   04/17/12  13:15:42  BY FD16     135    \n\n Initial Type: RELOCAT    Final Type: RELOCAT (RELOCATE FIRE/EMS UNITS)\n Initial Priority: 3      Final Priority: 3 \n Initial Alarm Level: 1   Final Alarm Level: 1\n Disposition:        Source: T    Primary Unit: ENG22       Rsp: 0099  \n Police BOX:   Fire BOX:   EMS BOX:  \n Group: C88F          Section:   Map:          X: 0000000  Y: 0000000\n\n Loc: NCC STA19   (NV)\n AKA:   Municipality:        Dev: \n Name: NCC ENG19               Addr:                         PH:                \n\n/1315  (135   )  ENTRY            NO FURTHER INFORMATION\n/1315            DISP    ENG242    #ENG242 ENG242 MDT \n/1323           $PREMPT  ENG242   \n/1323           $DISP    ENG22     #ENG22  ENG22 MDT \n/1323            EXCH    ENG242   ENG22    \nPRIOR PREMISE HISTORY FOR: NCC STA19                                         \n\nNo Prior Premise History found for the Location
Inc History #WGRF12000543  Xref: #58PJ12000321\n\n Entered      04/26/12  06:09:05  BY CT09     693\n Dispatched   04/26/12  06:09:53  BY FD16     157\n Initial Type: ACCENT     Final Type: ACCENT  (ACCIDENT - ENTRAPMENT *)\n Initial Priority: E      Final Priority: E\n Initial Alarm Level: 1   Final Alarm Level: 1\n Disposition:        Source: T    Primary Unit: RES22       Rsp: 0002\n Police BOX: 5802  Fire BOX: 2204  EMS BOX: 2204\n Group: 22FD          Section: 22     Map:          X: 7586988  Y: 3982389\n Loc: OLD BALTIMORE PK/RT 796 ,58    (V)\n AKA:                            Municipality: PENN\nDev:\n Name:                         Addr:                         PH:\n610-633-8998C\n/0609  (693   )  ENTRY            2 VEHS -- HEAD ON COLLISION -- ENTRAPMENT\n/0609            ENTRY            DETAILS TO FOLLOW\n/0609  (157   )  DTSEEN           INFO SEEN\n/0609            DISP    RES22     #RES22  RES22 MDT\n/0609            ASST    ENG22     #ENG22  ENG22 MDT\n/0609            ASST    AMB221    #AMB221 AMB221 MDT\n/0609            ASST    MED941    #MED941 MED941 MDT\n/0609            ASST    ENG12     #ENG12  ENG12 MDT\n/0609            ASST    AMB222    #AMB222 AMB222 MDT\n/0609            ASST    ENG32     #ENG32  ENG32 MDT\nPRIOR PREMISE HISTORY FOR: OLD BALTIMORE PK/RT 796\n,58\nNo Prior Premise History found for the Location\n*** List of closest hydrants\n***\n Inc #WGRF12000543 Type: ACCENT  Loc: OLD BALTIMORE PK/RT 796 ,58\n ID   STAT  GPM   LOCATION\n58-014      0      835 W BALTIMORE PK, 58\n\n58-013      0      835 W BALTIMORE PK, 58\n\n58-012      0      835 W BALTIMORE PK, 58\n\n58-011      0      835 W BALTIMORE PK, 58
 Inc History #WGRF12000549  Xref: #59PJ12000174\n\n Entered      04/27/12  23:31:33  BY CT08     663\n Dispatched   04/27/12  23:32:07  BY FD16     135\n\n Initial Type: INVOUT     Final Type: INVOUT  (SMOKE/ODOR INVEST (OUTSIDE)\n*)\n Initial Priority: 1      Final Priority: 1\n Initial Alarm Level: 1   Final Alarm Level: 1\n Disposition:        Source: T    Primary Unit: ENG22       Rsp: 0026\n Police BOX: 59BP  Fire BOX: 2202  EMS BOX: 2202\n Group: 22FD          Section: 22     Map: 45D7     X: 7580925  Y: 3983699\n\n Loc: 160 SB RT 1 BP ,59  btwn CHATHAM RD & BAKER STATION RD (V)\n AKA: KENNETT OXFORD BP  Municipality: LGROVE Dev:\n Name: WERTZ, JONATHON         Addr: 343 LEA DR              PH:\n610-812-0021\n\n/2331  (663   )  ENTRY            LOOKED LIKE WHAREHOUSE MIGHT HAVE BEEN ON\nFIRE\n                                   ONLY SAW WHITE COLORED SMOKE WHILE\nDRIVING BY\n/2332  (135   )  DISP    ENG22     #ENG22  ENG22 MDT\n/2332            ASST    LAD22     #LAD22  LAD22 MDT\n/2332            ASST    ENG12     #ENG12  ENG12 MDT\n/2332            ASST    ENG32     #ENG32  ENG32 MDT\nPRIOR PREMISE HISTORY FOR: 160 SB RT 1 BP\n,59\n\nNo Prior Premise History found for the Location

 */


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
