package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOStLouisCountyCParser extends FieldProgramParser {
  
  private static final Pattern BAD_MSG_PTN = Pattern.compile(".* AT .* BUS:.*Units:");
  private static final Pattern DUP_ALERT_PTN = Pattern.compile("(.*?(?: \\[ | Units:) *[^ ]*).*(?: \\[ | Units:) *[^ ]*(.*)");
  private static final Pattern ID_PTN = Pattern.compile(" +(\\d{2}-\\d+)$");
  private static final Pattern TIME_PTN = Pattern.compile(" +(\\d\\d:\\d\\d)$");
  private static final Pattern LAT_LONG_PTN = Pattern.compile("(38)(\\d{6}) +(\\d{2})(\\d{6})$");
  private static final Pattern SRC_UNIT_PTN = Pattern.compile("(?:((?:NORTH|CENTRAL|SOUTH) MAIN) +)?(\\d\\d|(?:Affton|Brentwood|Eureka|Fenton|Kirkwood|Ladue|Lemay|Mehlville|St Louis City|St Louis|Olivette|Shrewsbury|Webster Groves)(?: FPD)?)(?: *(?:\\[ |Units: )? *((?:\\b(?:(?:STL )?[A-Za-z0-9]+|GTWY \\d+|\\d+ DUTY|NEED AMB \\d+)\\b,?)+))?$");
  private static final Pattern BAD_AT_PTN = Pattern.compile("(.*[a-z ])AT((?: |[0-9]|[A-Z][a-z ]).*)");

  public MOStLouisCountyCParser() {
    super("ST LOUIS COUNTY", "MO", 
        "CALL! AT:ADDR! BUS:PLACE? XST:X");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@cce911.org,paging@cce911.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CCE911 Page") && !subject.equals("CAD Paging")) return false;
    
    if (BAD_MSG_PTN.matcher(body).matches()) return false;
    
    // Occasionally calls are duplicated and we need to cut out the duplicated content :(
    Matcher match = DUP_ALERT_PTN.matcher(body);
    if (match.matches())  body = match.group(1) + match.group(2);
    
    match =  ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(0,match.start());
    }

    match =  TIME_PTN.matcher(body);
    if (match.find()) {
      data.strTime = match.group(1);
      body = body.substring(0,match.start());
    }
    
    match = LAT_LONG_PTN.matcher(body);
    if (match.find()) {
      setGPSLoc(match.group(1)+'.'+match.group(2)+','+match.group(3)+'.'+match.group(4), data);
      body = body.substring(0,match.start()).trim();
    }

    /// Parse out source and unit from end of body
    match = SRC_UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    body = body.substring(0,match.start()).trim();
    data.strMap =  getOptGroup(match.group(1));
    data.strSource = match.group(2);
    data.strUnit = getOptGroup(match.group(3)).replace(' ', '_');
    
    // Make sure there is a blank in front of the AT keyword
    // And a colon behind it
    int pt = body.indexOf("AT:");
    if (pt >= 0) {
      body = body.substring(0,pt) + ' ' + body.substring(pt);
    } else {
      
      pt = body.indexOf(" BUS:");
      if (pt < 0) pt = body.indexOf(" XST:");
      if (pt < 0) pt = body.length();
      match = BAD_AT_PTN.matcher(body.substring(0,pt));
      if (!match.matches()) return false;
      body = match.group(1) + " AT:" + match.group(2) + body.substring(pt);
    }

    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " MAP SRC UNIT GPS TIME ID";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
  private static final Pattern COMMENT_PTN = Pattern.compile("Comment: *(.*), *(.*)");
  private static final Pattern CALL_CODE_PTN = Pattern.compile("(\\d{2}(?:[A-Z]\\d)?) +(.*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      
      Matcher match = COMMENT_PTN.matcher(field);
      if (match.matches()) {
        data.strSupp = match.group(1).trim();
        field = match.group(2).trim();
      }
      
      match = CALL_CODE_PTN.matcher(field);
      if (match.matches()) {
        data.strCode = match.group(1);
        field = match.group(2);
      }
      if (field.endsWith(" QD")) field = field.substring(0,field.length()-3).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO CODE CALL";
    }
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return DE_MERVILLE_PTN.matcher(addr).replaceAll("$1$2");
  }
  private static final Pattern DE_MERVILLE_PTN = Pattern.compile("\\b(De) +(Merville)\\b", Pattern.CASE_INSENSITIVE);
}
