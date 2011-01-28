package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/***
 * 
CAD:50PD-MOTOR VEH/PD ONLY;3248 FRIENDSHIP LEDFORD RD;2010024643;SADDLECHASE LN;MOTSINGER RD;OIL AND FLUIDS ON ROADWAY [12/17/10 11:05:24 BHUGHES] UDTS: 
CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 S/MM 99;2010024707;[Medical Priority Info] PROBLEM: traffic accident # PATS: 1 AGE: Unknown Range SEX: Unknown CONSCIOU
CAD:HOUSE/SINGLE DWELLING;3637 BECKS CHURCH RD;2010024363;HUCKLE PL;NC HWY 47;[Fire Priority Info] PROBLEM: KITCHEN FIRE [12/14/10 18:25:04 BPOOLE] [Fire P
CAD:P26-SICK-DELTA;4970 REID RD;2010024356;EASTVIEW DR;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 78 Years SEX: Female CONSCIOUS: Yes BREATHING:
CAD:Co Fire Tac3 for call;I 85 S/MM 99; THA;7703351053
CAD:cancel further response;I 85 S/MM 99; THA;7703351053
***/

public class NCDavidsonCountyParser extends SmsMsgParser {


  public NCDavidsonCountyParser() {
    super("DAVIDSON COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "cad@davidsoncountync.gov";
  }

  private static final Pattern DATE_MARK = Pattern.compile("\\[\\d\\d/\\d\\d/\\d\\d");

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains("CAD:")) return false;
    
    Matcher match = DATE_MARK.matcher(body);
    if (match.find()) {
      body = body.substring(0,match.end()-9);
    }
    // Needs some massaging before it can be run through the standard parser
    body = body.replace("CAD:", "CAD;");
    body = body.replace("PROBLEM:", "PROBLEM;");
    Properties props = parseMessage(body, ";", new String[]{"CAD","Call","Addr","ID","Cross","ExtraCross","Info","Junk"});
    data.strCall = props.getProperty("Call", "");
    parseAddress(props.getProperty("Addr", ""), data);
    data.strCross = props.getProperty("Cross", "");
    if (data.strCross.contains("[") && data.strCross.contains("]") || data.strCross.contains(",") ||isLower(data.strCross)) data.strCross = "";
    data.strCallId = props.getProperty("ID","");
    data.strSupp = props.getProperty("Info","");
    //data.strCity= props.getProperty("City", "");
    if (body.contains("PROBLEM;")){
      int idx = body.indexOf("PROBLEM;") +8;
      if (idx > 1 && (idx+8 < body.length())){ data.strSupp = body.substring(idx); data.strSupp=data.strSupp.trim();}
    }
    if (data.strSupp.length() < 1) {
      data.strSupp = body.substring(body.lastIndexOf(";")+1).trim();
    }

    return true;
  }
  
  public boolean isLower(String word)
  {
  char[] charArray;
  charArray = word.toCharArray();
  if (Character.isUpperCase(charArray[0]))
  return false;
  else
  return true;
  }
}
