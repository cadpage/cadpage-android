package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOStLouisCountyCParser extends FieldProgramParser {
  
  private static final Pattern BAD_MSG_PTN = Pattern.compile(".* AT .* BUS:.*Units:");
  private static final Pattern BAD_CH_PTN = Pattern.compile("(?:TAC: *)?(?:CC911 )?(?:SO - S|NO - N) MAIN F");
  private static final Pattern DUP_ALERT_PTN = Pattern.compile("(.*?(?: \\[ | Units:) *[^ ]*).*(?: \\[ | Units:) *[^ ]*(.*)");
  private static final Pattern ID_PTN = Pattern.compile(" +(\\d{2}-\\d+)$");
  private static final Pattern TIME_PTN = Pattern.compile(" +(\\d\\d:\\d\\d)$");
  private static final Pattern LAT_LONG_PTN = Pattern.compile("(38)(\\d{6}) +(\\d{2})(\\d{6})$");
  private static final Pattern SRC_UNIT_PTN = Pattern.compile(" *(?:FD: *)?(\\d\\d\\b|(?:Affton|Brentwood|City of St Loui|Crestwood FD|Eureka|Fenton|Franklin|Jefferson|Kirkwood|Ladue|Lemay|Mehlville|Olivette|Shrewsbury|St Charles|St Louis City|St Louis|Webster Groves)(?: FPD)?)(?: *(?:\\[ |Units: )? *((?:(?:(?:STL )?[A-Za-z0-9]+|AB \\d+|GTWY \\d+|\\d+ DUTY|NEED (?:AMB|EMS|MED) \\d+)\\b,?)+))?$");
  private static final Pattern MAP_PTN = Pattern.compile("(?: +| *(?:TAC|CHL): *)((?:CC911 +)?(?:NORTH|CENTRAL|SOUTH|SO - [FS])(?: MAIN| DISP)?(?: F)?)$");
  private static final Pattern TAC_PTN = Pattern.compile(" *(?:TAC *)?(?<!\\bI |\\bHWY |\\bHIGHWAY )\\b(\\d{1,2})$");
  private static final Pattern BAD_AT_PTN = Pattern.compile("(.*?[a-z ])AT(.*)");

  public MOStLouisCountyCParser() {
    super("ST LOUIS COUNTY", "MO", 
        "CALL! AT:ADDR! APT:APT? BUS:PLACE? XST:X");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@cce911.org,paging@cce911.org,93001";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (BAD_MSG_PTN.matcher(body).matches()) return false;
    
    // Don't know what this is, but we are better off without it
    body = BAD_CH_PTN.matcher(body).replaceAll("");
    
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

    // Parse out channel, map, and source/unit from end of body
    // Channel and map are optional, map can occur before or after the source/unit
    match = MAP_PTN.matcher(body);
    if (match.find()) {
      data.strMap = match.group(1);
      body = body.substring(0,match.start());
      match = TAC_PTN.matcher(body);
      if (match.find()) {
        data.strChannel = match.group(1);
        body = body.substring(0,match.start());
      }
    }
    
    match = SRC_UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1);
    data.strUnit = getOptGroup(match.group(2)).replace(' ', '_');
    body = body.substring(0,match.start()).trim();

    if (data.strMap.length() == 0) {
      match = MAP_PTN.matcher(body);
      if (match.find()) {
        data.strMap = match.group(1);
        body = body.substring(0,match.start());
      }
    }
    
    if (data.strChannel.length() == 0) {
      match = TAC_PTN.matcher(body);
      if (match.find()) {
        data.strChannel = match.group(1);
        body = body.substring(0,match.start());
      }
      if (data.strMap.length() == 0) {
        match = MAP_PTN.matcher(body);
        if (match.find()) {
          data.strMap = match.group(1);
          body = body.substring(0,match.start());
        }
      }
    }

    
    // Make sure there is a blank in front of the AT keyword
    // And a colon behind it
    int pt = body.indexOf("AT:");
    if (pt >= 0) {
      body = body.substring(0,pt) + ' ' + body.substring(pt);
    } else if (substring(body, 30,32).equals("AT")) {
      body = body.substring(0,30) + " AT:" + body.substring(32);
    } else {
      pt = body.indexOf(" BUS:");
      if (pt < 0) pt = body.indexOf(" XST:");
      if (pt < 0) pt = body.length();
      match = BAD_AT_PTN.matcher(body.substring(0,pt));
      if (!match.matches()) return false;
      body = match.group(1) + " AT:" + match.group(2) + body.substring(pt);
    }
    
    body = body.replace("TAC:", " TAC:");

    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " CH MAP SRC UNIT GPS TIME ID";
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
      field = stripFieldEnd(field, " QD");
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
