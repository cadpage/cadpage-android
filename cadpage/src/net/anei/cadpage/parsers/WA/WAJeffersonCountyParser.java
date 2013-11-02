package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class WAJeffersonCountyParser extends FieldProgramParser {
  
  private static final Pattern MASTER = Pattern.compile("(.*?)((?: [A-Z]*\\d+)*)  (?:(.*?) )?Quadrant: (?:(.*?) )?(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) Narrative ?:(.*?)");
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("\\bE911 Info .*|\\bCall Number \\d+ was ceated from Call Number \\d+|\\([^\\(]+ \\d\\d?:\\d\\d[AP]M\\)");
  
  public WAJeffersonCountyParser() {
    super("JEFFERSON COUNTY", "WA",
           "CALL UNIT PLACE ADDR CITY X DATETIME! NARRATIVE INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com,messaging@emergencysmc.com,dispatch@jcpsn.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    data.strSource = subject;
    String[] flds = body.split(" : ");
    if (flds.length >= 7) {
      return parseFields(body.split(" : "), 7, data);
    }
    
    // New format drops all of the colon delimiters :(
    setFieldList("CALL UNIT ADDR APT MAP DATE TIME INFO");
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strCall = match.group(1).trim();
    data.strUnit = match.group(2).trim();
    String addr = getOptGroup(match.group(3));
    data.strMap = getOptGroup(match.group(4));
    data.strDate = match.group(5);
    data.strTime =  match.group(6);
    String info = match.group(7).trim();
    
    int pt = addr.indexOf("BK=");
    if (pt >= 0) addr = addr.substring(0,pt).trim();
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END | FLAG_RECHECK_APT, addr, data);
    
    info = INFO_JUNK_PTN.matcher(info).replaceAll("").trim();
    data.strSupp = info;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class NarrativeField extends SkipField {
    @Override
    public void parse(String field, Data data) {
      if (!"Narrative".startsWith(field)) abort();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NARRATIVE")) return new NarrativeField();
    return super.getField(name);
  }
}
