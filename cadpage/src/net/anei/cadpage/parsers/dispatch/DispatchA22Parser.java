package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
 * Klamath County, OR
 * Similar to, possible merge with Crook County, OR
 */

abstract public class DispatchA22Parser extends FieldProgramParser {
  
  private static Pattern KEYWORD_PTN1 = Pattern.compile("(?<=\n(?:UNITS|EVENT #|PRIORITY|LOCATION|CITY|APT|PREMISE|COMMENT))(?!:)");
  private static String[] KEYWORD_LIST = new String[]{"UNITS", "EVENT #", "PRIORITY", "LOCATION", "CITY", "APT", "PREMISE", "COMMENT"};
  
  private Pattern sourcePtn = null;
  
  public DispatchA22Parser(String defCity, String defState) {
    this(null, defCity, defState, null);
  }
  
  public DispatchA22Parser(String defCity, String defState, String sourcePtn) {
    this(null, defCity, defState, sourcePtn);
  }
  
  public DispatchA22Parser(Properties cityCodes, String defCity, String defState) {
    this(cityCodes, defCity, defState, null);
  }
  
  public DispatchA22Parser(Properties cityCodes, String defCity, String defState, String sourcePtn) {
    super(cityCodes, defCity, defState,
          "DATETIME! UNITS:UNIT? ( EVENT_#:IDSRC! | SRC ) CALL! PRIORITY:PRI? ( LOCATION:ADDR! CITY:CITY APT:APT PREMISE:PLACE? COMMENT:INFO | ADDR CITY! APT:APT ) INFO+");
    if (sourcePtn != null) {
      this.sourcePtn = Pattern.compile(" (" + sourcePtn + ") ");
    }
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = stripFieldStart(body, "INCIDENT NEW ");
    
    // The standard format has line breaks between each field.  On some occasions these are replaced with
    // blanks and have to be manually restored.  Which requires the use of a source pattern to identify
    // the the missing line break following the source field :(
    if (body.indexOf('\n') >= 0) {
      body = KEYWORD_PTN1.matcher(body).replaceAll(":");
    } else {
      if (sourcePtn == null) return false;
      body = fixMissingBreaks(body);
      body = sourcePtn.matcher(body).replaceFirst(" $1\n");
    }
    return parseFields(body.split("\n"), data);
  }
  
  private String fixMissingBreaks(String body) {
    StringBuilder sb = new StringBuilder();
    body = body + ' ';
    int pos = body.length();
    for (int ndx = KEYWORD_LIST.length-1; ndx>= 0; ndx--) {
      String keyword = KEYWORD_LIST[ndx];
      String keyword2 = ' ' + keyword + ':';
      String keyword3 = ' ' + keyword + ' ';
      int p1 = body.lastIndexOf(keyword2, pos);
      if (p1 < 0) {
        if (keyword.equals("LOCATION")) p1 = body.substring(0,pos).indexOf(keyword3);
        else p1 = body.lastIndexOf(keyword3, pos);
      }
      if (p1 >= 0) {
        sb.insert(0, body.substring(p1 + keyword2.length(), pos));
        sb.insert(0, '\n'+keyword+':');
        
        // oversearch in case leading space is also next keyword trailing space
        pos = p1 + 1;
      }
    }
    sb.insert(0, body.substring(0,pos));
    return sb.toString().trim();
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{4})");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      String time = match.group(2);
      data.strTime = time.substring(0,2) + ':' + time.substring(2,4);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("IDSRC")) return new MyIdSourceField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern ID_SRC_PTN = Pattern.compile("(\\d{10}) (.*)");
  private class MyIdSourceField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_SRC_PTN.matcher(field);
      if (!match.matches()) abort();
      
      data.strCallId = match.group(1).trim();
      data.strSource =  match.group(2).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ID SRC";
    }
  }
  
  private static final Pattern INFO_GPS_PTN = Pattern.compile("[-+]\\d{2,3}\\.\\d{6}[, ]+[-+]\\d{2,3}\\.\\d{6}");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match= INFO_GPS_PTN.matcher(field);
      if (match.matches()) {
        setGPSLoc(field, data);
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " GPS";
    }
  }
}