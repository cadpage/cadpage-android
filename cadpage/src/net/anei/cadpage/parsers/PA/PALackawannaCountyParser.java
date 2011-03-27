package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Lackawanna County, PA
Contact: greg rhodes <grhodes908@gmail.com>
Sender: aegispage@lackawannacounty.org

14 - Covington TWP
53 - Spring Brook TWP

(Dispatch) Unit:14-9 Status:Dispatched Location:524 DEACON ST, 14 Call Type:BLS Call Time:12/7/2010 6:22:58 AM Call Number:245 Quadrant:F14 District:
(Dispatch) Unit:14-9 Status:Dispatched Location:132 UNION MILL RD WINSHIP RD / LANGAN RD, VAN BRUNT ST, 14 Call Type:ALS Call Time:12/11/2010 11:27:5
(Dispatch) Unit:CH53 Status:Dispatched Location:0 ASTON MOUNTAIN RD, 53 Call Type:ACCI Call Time:12/11/2010 1:12:10 PM Call Number:446 Quadrant:F53 D
(Dispatch) Unit:ch14 Status:Dispatched Location:0 LEHIGH RD, 14 Call Type:BRSH Call Time:12/12/2010 9:01:17 AM Call Number:872 Quadrant:F14 District:
(Dispatch) Unit:14-9 Status:Dispatched Location:298 1ST AVE DEAD END / DRINKER TPKE, 14 Common Name:DIAPERS COM Call Type:BLS Call Time:12/12/2010 5:
(Dispatch) Unit:CH53 Status:Dispatched Location:RT 690 / BOWENS RD, 53 Call Type:ACCI Call Time:12/17/2010 11:04:51 PM Call Number:413 Quadrant:F53 D
   in Spring Brook TWP
[Dispatch]  Unit:ch14 Status:Dispatched Location:662 DRINKER TPKE AM HUGHES BLVD / ROSS DR, 14 Call Type:ACCI Call Time:12/18/2010 6:05:58 AM Call Num
   Covington TWP, PA
(Dispatch) Unit:T14 Status:Dispatched Location:SCRANTON POCONO HWY / DRINKER TPKE, 14 Call Type:AFA Call Time:12/21/2010 8:56:18 AM Call Number:802 Q
    Dual dispatch of 53 spring brook two pa and 14 daleville pa  
 */


public class PALackawannaCountyParser extends SmartAddressParser {

  private static final String[] KEYWORDS = 
    new String[]{"Unit", "Status", "Location", "Common Name", "Call Type", "Call Time", 
                 "Call Number", "Quadrant", "District"};
  
//  private static final Properties CITY_CODES = buildCodeTable(new String[]{
//     "14", "COVINGTON TWP",
//     "53", "SPRING BROOK TWP"
//  });
  
  public PALackawannaCountyParser() {
    super("LACKAWANNA COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "aegispage@lackawannacounty.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("Dispatch")) return false;
    
    Properties props = parseMessage(body, KEYWORDS);
    data.strUnit = props.getProperty("Unit", "");
    String sAddr = props.getProperty("Location");
    if (sAddr == null) return false;
    Parser p = new Parser(sAddr);
    p.getLastOptional(',');
    sAddr = p.get();
    if (sAddr.startsWith("0 ")) sAddr = sAddr.substring(2);
    parseAddress(StartType.START_ADDR, sAddr, data);
    data.strCross = getLeft();
    data.strPlace = props.getProperty("Common Name", "");
    data.strCall = props.getProperty("Call Type", "");
    data.strCallId = props.getProperty("Call Number", "");
    data.strMap = props.getProperty("Quadrant", "");
    
    return true;
  }
}
