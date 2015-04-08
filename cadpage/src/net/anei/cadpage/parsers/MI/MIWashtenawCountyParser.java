package net.anei.cadpage.parsers.MI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MIWashtenawCountyParser extends FieldProgramParser {

  public MIWashtenawCountyParser() {
    super("WASHTENAW COUNTY", "MI", "ADDR CITY_ST_ZIP APT! XY:GPS! PRI Cross:X! INFO+");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  private static Pattern DELIM = Pattern.compile(" /(?= )");
  private static Pattern RUN_REPORT = Pattern.compile("(\\d+) / (.+)");
  private static Pattern CODE_CALL = Pattern.compile("(\\d{2}[A-Z]\\d[A-Z]?|CBC)-(.*)");
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    //parse run reports (CALL) ID? PLACE
    if (subject.equals("Message from Dispatch")) {
      data.strCall = "RUN REPORT";
      Matcher mat = RUN_REPORT.matcher(body);
      if (mat.matches()) {
        data.strCallId = mat.group(1);
        data.strPlace = mat.group(2);
      } else {
        data.strPlace = body;
      }
      return true;
    }
    
    //check subject, trim Nature: tag
    if (!subject.startsWith("Nature:")) return false;
    String field = subject.substring(7).trim();
    //parse CODE-CALL or just CALL
    Matcher mat = CODE_CALL.matcher(field);
    if (mat.matches()) {
      data.strCode = mat.group(1);
      data.strCall = mat.group(2);
    } else data.strCall = field;
    //prepare body to be split
    body = body.replace("Cross:/", "Cross: /"); //in case the / is actually meant to be a delim
    if (body.endsWith("/")) body += " ";
    //save outcome, fail if !TIME, return outcome
    boolean verdict = parseFields(DELIM.split(body), data);
    verdict &= data.strTime.length() != 0; //return false if no TIME parsed
    return verdict;
  }
  
  @Override
  public String getProgram() {
    return "CODE CALL " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("CITY_ST_ZIP")) return new MyCSZField();
    if (name.equals("PRI")) return new PriorityField("\\d");
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static Pattern ADDR_MAP = Pattern.compile("(.+?)-([A-Z]{1,2})?");
  public class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      //sometimes field matches ADDR_MAP/ADDR_MAP. if it does we split and parse both
      int si = field.indexOf("/");
      if (si != -1) {
        
        //parse -XX from each, append second XX if ", " if non redundant
        String head = field.substring(0, si).trim();
        Matcher mat = ADDR_MAP.matcher(head);
        if (mat.matches()) {
          head = mat.group(1).trim();
          data.strMap = getOptGroup(mat.group(2));
        } //tail
        String tail = field.substring(si+1).trim();
        mat = ADDR_MAP.matcher(tail);
        if (mat.matches()) {
          tail = mat.group(1).trim();
          String map = mat.group(2);
          //if map isn't null or redundant, append
          if (map != null && !data.strMap.contains(map)) data.strMap = append(data.strMap, "-", map);
        }
        
        //now we can parse the intersection normally
        super.parse(head+"/"+tail, data);
        return;
      }

      //if no "/", just parse ADDR-MAP
      Matcher mat = ADDR_MAP.matcher(field);
      if (mat.matches()) {
        field = mat.group(1).trim();
        data.strMap = getOptGroup(mat.group(2));
      } super.parse(field, data);
    }

    @Override
    public String getFieldNames() { return super.getFieldNames() + " MAP"; }
  }
  
  public class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      //remove leading 0
      field = stripFieldStart(field, "0 ");
      //parse X-MAP
      Matcher mat = ADDR_MAP.matcher(field);
      if (mat.matches()) {
        field = mat.group(1);
        //append map if neither null nor redundant
        String map = mat.group(2);
        if (map != null && !data.strMap.contains(map)) data.strMap = append(data.strMap, "-", map);
      } //parse normally
      super.parse(field, data);
    }
  }
  
  private static Pattern CITY_STATE_ZIP = Pattern.compile("(.+), ([A-Z]{2}), \\d{5}");
  public class MyCSZField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher mat = CITY_STATE_ZIP.matcher(field);
      if (!mat.matches()) abort();
      //CITY ST
      data.strCity = mat.group(1).trim();
      data.strState = mat.group(2);
    }

    @Override
    public String getFieldNames() { return "CITY ST"; }
  }
  
  private static Pattern TIME = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
  public class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      //if strTime empty, check for a TIME field
      if (data.strTime.length() == 0) {
        Matcher mat = TIME.matcher(field);
        if (mat.matches()) {
          //parse as TIME instead
          data.strTime = field;
          return;
        }
      } //if not, parse as info
      super.parse(field, data); 
    }

    @Override
    public String getFieldNames() { return "INFO TIME"; }
  }
}
