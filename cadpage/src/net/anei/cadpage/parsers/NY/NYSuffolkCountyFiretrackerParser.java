package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Suffolk County, NY (Alternate)
Contact: Devin McGuinness <radio5390@aol.com>
Sender: dispatch@firetracker.net 
System: Firetracker

(FirePage) ** MASTIC BEACH VAC ** [7-A-2 FI] 340 W DOGWOOD RD Mastic Beach C/S:LYNBROOK DR AND WOODSIDE DR Add't Info: Responde
(FirePage) ** MASTIC BEACH VAC ** [6-C-1 AB] 154 BAYVIEW DR Mastic Beach C/S:MAPLE RD W AND NARCISSUS RD W Add't Info: ........
(FirePage) ** MASTIC BEACH VAC ** [29-D-2M ] ORCHID DR Mastic Beach C/S:ORCHID DR AND CEDAR RD E Add't Info: MVA Number of pati
(FirePage) ** MASTIC BEACH VAC ** [17-B-1 P] 69 ARGYLE DR Shirley C/S:SB WILLIAM FLOYD PKWY AND PINETREE DR Add't Info: 53 YOM 
(FirePage) ** MASTIC BEACH VAC ** [9-E-1 NO] 241 BAYVIEW DR Mastic Beach C/S:CEDAR RD W AND VICTORIA PL Add't Info: AF CARDIAC 
(FirePage) ** MASTIC BEACH VAC ** [26-A-1 N] GRANDVIEW DR Shirley C/S:WESTMINSTER DR AND ARGYLE DR Add't Info: SCPD ECO # 894 5
(FirePage) ** MASTIC BEACH VAC ** [4-B-3A U] 197 LONGFELLOW DR Mastic Beach C/S:PINE RD Add't Info: VICTIM OF AN ASSAULT Number
(FirePage) ** MASTIC BEACH VAC ** [17-D-3 N] 1631 MONTAUK HWY Mastic Beach C/S:GUNTER PL AND ETNA PL Add't Info: AM FELL DOWN S

*/
public class NYSuffolkCountyFiretrackerParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\*\\* ([A-Z ]+) \\*\\* \\[([- A-Z0-9]+)\\] ");
  
  public NYSuffolkCountyFiretrackerParser() {
    super(CITY_LIST, "SUFFOLK COUNTY", "NY", 
           "ADDR/S! C/S:X! Add't_Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@firetracker.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("FirePage")) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1).trim();
    data.strCall = match.group(2).trim();
    body = body.substring(match.end()).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC CALL " + super.getProgram();
  }
  
  private static final String[] CITY_LIST = new String[]{
    "MASTIC BEACH",
    "SHIRLEY"
  };
}
