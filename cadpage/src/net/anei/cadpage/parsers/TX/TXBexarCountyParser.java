package net.anei.cadpage.parsers.TX;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Bexar County, TX
 */
public class TXBexarCountyParser extends FieldProgramParser {
  
  private static final String MAP_PATTERN = "(?:\\d{3}[A-Z]\\d|SA\\d{3}(?:/[A-Z]\\d?)?)";
  private static final Pattern SEMI_DELIM = Pattern.compile("(?<= ) *; ");
  private static final Pattern DASH_DELIM_PTN = Pattern.compile(" +- ");
  private static final Pattern PROTECT_KEYWORD = Pattern.compile("(?<=:)  +(?=[^ ])");
  private static final Pattern BLANK_DELIM_PTN = Pattern.compile(" {4,}");
  private static final Pattern SHORT_BLANK_DELIM_PTN = Pattern.compile("(?<![ -])  +(?![ -])");
  private static final Pattern MAP_BLANK_DELIM_PTN = Pattern.compile(" " + MAP_PATTERN + " +(?=[^ -])");
  private static final Pattern COLON_MAP_PTN = Pattern.compile(":( " + MAP_PATTERN + ")");
  private static final Pattern DELIM_PTN = Pattern.compile(" -(?= )| \\*\\*");
  
  private static final Set<String> CALL_PREFIX_SET = new HashSet<String>(Arrays.asList(new String[]{
      "Alarm", "Assist", "Fire", "Med", "MED", "Rescue", "RESCUE"
  }));
  
  private boolean dashStyle;
  
  public TXBexarCountyParser() {
    super("BEXAR COUNTY", "TX",
          "DATETIME? CALL CALL2? ADDR XAPT+? MAP ID? INFO+");
  }
  
  public String getFilter() {
    return "visinet.command@sanantonio.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // New main format is semicolon delimted.  So let's give that a try
    body = body.replace(" ;Apt", " ; Apt");
    String flds[] = SEMI_DELIM.split(body);
    
    // If we don't get enough fields, fall back to using the old ugly logic
    dashStyle = false;
    if (flds.length < 5) {
      dashStyle = true;
      
      // The main format is usually dash delimited, but occasionally drops the dashes in favor on
      // long strings of blanks, which we will turn in regular dash delimiters
      // And then, they occasionally leave a single space delimiter after the Map field
      body = DASH_DELIM_PTN.matcher(body).replaceAll(" - ");
      body = PROTECT_KEYWORD.matcher(body).replaceAll(" ");
      body = BLANK_DELIM_PTN.matcher(body).replaceAll(" - ");
      body = MAP_BLANK_DELIM_PTN.matcher(body).replaceFirst("$0 - ");
      body = COLON_MAP_PTN.matcher(body).replaceFirst("$1");
      
      int pt = body.lastIndexOf(" - ");
      if (pt < 0) return false;
      body = SHORT_BLANK_DELIM_PTN.matcher(body.substring(0,pt)).replaceAll(" - ") + body.substring(pt);
      body = body.replace("-Case", " - Case");
      flds = DELIM_PTN.split(body);
    }
    return parseFields(flds, data);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d )?(\\d\\d:\\d\\d(?: [ap]m)?)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("KK:mm aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strDate = getOptGroup(match.group(1));
      String time = match.group(2);
      if (time.endsWith("m")) {
        setTime(TIME_FMT, time, data);
      } else {
        data.strTime = time;
      }
      return true;
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("*")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyCall2Field extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {

      // The whole point it to correct for dashes in data field that got
      // confused with field delimiters, if we aren't using dash field
      // delimiters, there is no point
      if (!dashStyle) return false;
      
      // A numeric field is assumed to be part of a street range that will
      // be prepended to the address that is coming up next
      if (NUMERIC.matcher(field).matches()) {
        data.strAddress = field;
        return true;
      }
      
      // Otherwise see if the previous call description was one of the short keywords that
      // we expect to be followed by a second call description
      // If it is, and this field doesn't start with zero, append it to the 
      // previous call description
      if (!CALL_PREFIX_SET.contains(data.strCall)) return false;
      if (field.length() == 0) return false;
      if (Character.isDigit(field.charAt(0))) return false;
      
      data.strCall = append(data.strCall, " - ", field);
      return true;
    }
  }
  
  private static final Pattern IH_PTN = Pattern.compile("\\bIh\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String prefix = data.strAddress;
      data.strAddress = "";
      field = IH_PTN.matcher(field).replaceAll("I");
      super.parse(field, data);
      data.strAddress = append(prefix, "-", data.strAddress);
    }
  }
  
  private static final Pattern APT_PTN = Pattern.compile("(?:Apt|RM|#) *(.*)|(SUITE.*)");
  private static final Pattern TIME_PTN = Pattern.compile("\\d\\d:\\d\\d");
  private class MyCrossAptField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) {
        String apt = match.group(1);
        if (apt == null) apt = match.group(2);
        data.strApt = append(data.strApt, " - ", apt);
      }
      else if (CITY_SET.contains(field)) {
        data.strCity = field;
      } else if (TIME_PTN.matcher(field).matches()) {
        if (data.strTime.length() == 0) data.strTime = field;
      } else if (field.length() > 5) {
        data.strCross = append(data.strCross, " & ", field);
      } else {
        data.strApt = append(data.strApt, " - ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CITY X APT TIME";
    }
  }
  
  private class MyMapField extends MapField {
    
    public MyMapField() {
      super(MAP_PATTERN + "|Case", true);
    }
    
    public boolean canFail() {
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.equals("Case")) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("([A-Z]{3,4}-\\d{4}-\\d{6,})(?: +Dept[ -](.*))?");
  private class MyIdField extends IdField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = ID_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strCallId = match.group(1);
      data.strUnit = getOptGroup(match.group(2));
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  // Info field tries to clean up some of the more useless information
  private static final Pattern INFO_DEPT_PTN = Pattern.compile("^Dept[ -]([^ ]+?)(?: |$)");
  private static final Pattern ACADIAN_PTN = Pattern.compile("(?:\\bACADIAN:|\\[ProQA Script\\]) *");
  private static final Pattern SPEC_INFO_PTN = Pattern.compile("(?<=^|,) *Unit: *([^ ]+)\\b|" +                                // Unit:
                                                                  "(?<=^|,) *Dispatch code: *([^ ]+)\\b|" +                       // Dispatch code:
                                                                  "(?:(?:^|,)[^,]*?)?\\b([A-Z]{3,4}-\\d{4}-\\d{6,})\\b[^,]*");    // Call ID
  private static final Pattern TRASH_PTN = Pattern.compile("(?:^|,) *(?:A cellular re-bid |check the ANI/ALI |Invalid address received:|Automatic Case |\\[ProQA Session Aborted\\]|Transferred incident:|Acknowledgement Received |Reference Number:|status change to |This incident [-A-Z0-9]+ has been sent to |ACADIAN HAS CHANGED )[^,]*");
  private static final Pattern TRIM_PTN = Pattern.compile("^[, \\.]+|[, \\.]+$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_DEPT_PTN.matcher(field);
      if (match.find()) {
        data.strUnit = append(data.strUnit, " ", match.group(1));
        field = field.substring(match.end()).trim();
      }
      field = ACADIAN_PTN.matcher(field).replaceAll("");
      match = SPEC_INFO_PTN.matcher(field);
      StringBuffer sb = new StringBuffer();
      while (match.find()) {
        if (match.group(1) != null) {
          data.strUnit = append(data.strUnit, " ", match.group(1));
        } else if (match.group(2) != null) {
          data.strCode = match.group(2);
        } else {
          if (data.strCallId.length() == 0) data.strCallId = match.group(3);
        }
        match.appendReplacement(sb, "");
      }
      match.appendTail(sb);
      field = sb.toString();
      field = TRASH_PTN.matcher(field).replaceAll("");
      field = field.replace("[Shared]", "");
      field = TRIM_PTN.matcher(field).replaceAll("");
      data.strSupp = append(data.strSupp, " - ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CODE ID INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.startsWith("T") && name.length()==2) return new SkipField(name, true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("CALL2")) return new MyCall2Field();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("XAPT")) return new MyCrossAptField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "ALAMO HEIGHTS",
      "BALCONES HEIGHTS",
      "CASTLE HILLS",
      "CIBOLO",
      "CHINA GROVE",
      "CONVERSE",
      "CROSS MOUNTAIN",
      "ELMENDORF",
      "FAIR OAKS RANCH",
      "GREY FOREST",
      "HELOTES",
      "HILL COUNTRY VILLAGE",
      "HOLLYWOOD PARK",
      "KIRBY",
      "LEON SPRINGS",
      "LEON VALLEY",
      "LIVE OAK",
      "LYTLE",
      "OLMOS PARK",
      "SAN ANTONIO",
      "SCHERTZ",
      "SCENIC OAKS",
      "SELMA",
      "SHAVANO PARK",
      "SOMERSET",
      "ST. HEDWIG",
      "TERRELL HILLS",
      "TIMBERWOOD PARK",
      "UNIVERSAL CITY",
      "VON ORMY",
      "WINDCREST"
  }));
}
