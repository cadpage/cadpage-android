package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*  
Mifflin County, PA
Contact: Eric Moist <emoist@ymail.com>
Sender: cmessages@co.mifflin.pa.us and cadmessages@co.mifflin.pa.us 

(CAD Page for CFS 111710-43) ALS - Uncon/Syncope\n1 DERRY PARK DR\nApt:\nBURNHAM\nCross Streets : 400-412  S LOGAN BLVD
(CAD Page for CFS 111710-42) URG - Ment/Emot/Psych\n41 INDUSTRIAL PARK RD\nApt: A\nGRANVILLE\nCross Streets : 708-924  LOOP RD * 2120-2456 MIDDLE RD
(CAD Page for CFS 111710-37) ALS - Breathing Difficulty\n27 ANDERSON ST\nApt:\nBRATTON\nCross Streets : 1-19  MATTAWANA BLVD
(CAD Page for CFS 111710-2) ALS - Motor Vehicle Accident\nROSEWOOD AVE and US HIGHWAY 522 NORTH\nApt: //\nDERRY\nCross Streets : 1-24  ROSEWOOD AVE
(CAD Page for CFS 111610-52) ALS - Breathing Difficulty\n163 SUMMIT DR\nApt:\nDERRY\nCross Streets : 400-406  SIXTH ST * 1-14 CASTLE CT
(CAD Page for CFS 111510-56) ALS - Diabetic\n7 MAPLE ST\nApt: ////\nKISTLER\nCross Streets : 150-198  N RIVERSIDE DR * 142-148 PARK RD

Contact: justin trego <jtrego77@gmail.com>
FRM:cmessages@co.mifflin.pa.us<Body%3AFRM%3Acmessages@co.mifflin.pa.us>\nSUBJ:CAD Page for CFS 013011-1\nMSG:Residential Fire\n56 RED SHALE LN\nApt:\nBRATTON\nCross Streets : 26-92  CARLISLE GAP RD
*/

public class PAMifflinCountyParser extends SmsMsgParser {

  private static final String[] FIXED_KEYS = new String[]{"CALL", "LOC", "TOWN"};
  private static final MatchList TOWNSHIPS = new MatchList(new String[]{
      "ARMAGH", "BRATTON", "BROWN", "DECATUR", "DERRY", "GRANVILLE", "MENNO", "OLIVER", "UNION", "WAYNE"
  });
  
  public PAMifflinCountyParser() {
    super("MIFFLIN COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "cmessages@co.mifflin.pa.us,cadmessages@co.mifflin.pa.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.startsWith("CAD Page for CFS ")) return false;
    data.strCallId = subject.substring(17).trim();
    
    Properties props = parseMessage(body, "\n", FIXED_KEYS);
    
    data.strCall = props.getProperty("CALL");
    if (data.strCall == null) return false;
    
    String sAddr = props.getProperty("LOC");
    if (sAddr == null) return false;
    parseAddress(sAddr, data);
    
    data.strCity = props.getProperty("TOWN", "");
    if (TOWNSHIPS.contains(data.strCity)) data.strCity += " TWP"; 
    
    data.strApt = props.getProperty("Apt", "").replaceAll("/", "");
    data.strCross = props.getProperty("Cross Streets", "");
    
    return true;
  }
}
