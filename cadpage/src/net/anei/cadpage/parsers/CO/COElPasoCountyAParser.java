package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class COElPasoCountyAParser extends MsgParser {
  
  private static final Pattern MASTER = 
      Pattern.compile("\\[([-A-Z0-9 ]+): *([^\\]]+?)\\] *([^~]+?)~([^~]+?)~([^#]+?)\\.?#([^~]*?)~([^~]*?)~(?:x:([^~]*?)(?:   +~?|~))?(?:ALRM:([\\d ])~)?(?:CMD:([^~]*)~?)?(?:([-A-Z0-9]+))?(?: +[A-Z0-9]+)? *~*");
  
  private static final Pattern MASTER2 =
      Pattern.compile("INFO from EPSO: (.*?)  (.*?)  (.*?)  (.*?)  +(?:JURIS: )?(.*?)(?:  ALRM: (\\d*))?(?: *CMD:(.*))?");
  
  private static final Pattern MASTER3 = 
      Pattern.compile("([ A-Z]+) - (.*?)  +(.*?) - (.*)");
  
  public COElPasoCountyAParser() {
    super("EL PASO COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Square bracket got turned into a subject and needs to be turned back
    if (subject.length() > 0) body = '[' + subject + "] " + body;
    
    // STrip off extra trailer
    body = stripFieldStart(body,  "Txt:");
    int pt = body.indexOf("\n\n");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // Not everyone is using it, but see if this is the new standard dispatch format
    Matcher match = MASTER.matcher(body);
    if (match.matches()) {
      setFieldList("SRC MAP UNIT CALL ADDR APT PLACE X PRI INFO ID");
      data.strSource = match.group(1).trim();
      data.strMap = match.group(2).trim();
      data.strUnit = match.group(3).trim();
      data.strCall = match.group(4).trim();
      String addr = match.group(5).trim();
      if (addr.startsWith("0 ")) addr =  addr.substring(2).trim();
      parseAddress(addr, data);
      data.strApt = match.group(6).trim();
      data.strPlace = match.group(7).trim();
      data.strCross = getOptGroup(match.group(8));
      data.strPriority = getOptGroup(match.group(9));
      data.strSupp = getOptGroup(match.group(10));
      data.strCallId = getOptGroup(match.group(11));
      return true;
    }
    
    match = MASTER2.matcher(body);
    if (match.matches()) {
      setFieldList("CALL ADDR APT PLACE SRC PRI UNIT");
      data.strCall = match.group(1).trim();
      parseAddress(match.group(2).trim(), data);
      data.strApt = match.group(3).trim();
      data.strPlace = match.group(4).trim();
      data.strSource = match.group(5).trim();
      data.strPriority = getOptGroup(match.group(6));
      data.strUnit = getOptGroup(match.group(7));
      return true;
    }
    
    match = MASTER3.matcher(body + ' ');
    if (match.matches()) {
      setFieldList("SRC CALL ADDR APT INFO NAME PHONE");
      data.strSource = match.group(1);
      data.strCall = match.group(2);
      parseAddress(match.group(3).trim(), data);
      Parser p = new Parser(' ' + match.group(4));
      data.strPhone = p.getLastOptional(" PH ");
      data.strName = p.getLastOptional(" RP ");
      data.strSupp = p.get();
      return true;
      
    }
    
    FParser p = new FParser(body);
    if (p.check("From EPSO -")) {
      setFieldList("CALL ADDR APT INFO");
      data.strCall = p.get(24);
      if (!p.check(" ") || p.check(" ")) return false;
      parseAddress(p.get(50), data);
      if (!p.check("  ") || p.check(" ")) return false;
      data.strSupp = p.get();
      return true;
    }
    
    if (p.check("FCFES : ~")) {
      setFieldList("CALL ADDR APT INFO");
      data.strCall = p.get(40);
      if (!p.check("~")) return false;
      parseAddress(p.get(30), data);
      data.strApt = p.get(5);
      if (!p.check("~")) return false;
      data.strSupp = p.get();
      return true;
    }
    
    return false;
  }
}
