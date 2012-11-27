package net.anei.cadpage.parsers.TN;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TNKnoxCountyParser extends FieldProgramParser {
  
  private static final Pattern TRAILER_PTN = Pattern.compile(" \\[\\d+\\]$");
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("^RUN# (\\d+),  ");
  private static final Pattern PREPOSITION_PTN = Pattern.compile("(.*?) +((?:PLEASE|INSERVICE) POST) +(.*)");
  private static final Pattern CANCEL_PTN = Pattern.compile("(.*?) +CALL AT +(.*)? +IS CANCELLED , .*");
  
  public TNKnoxCountyParser() {
    super(CITY_CODES, "KNOX COUNTY", "TN",
           "UNIT ID ADDR/y APTPRI PATCOND MAP X ADDLOC PLACE DEST");
  }
  
  @Override
  public String getFilter() {
    return "CC_Message_Notification@usamobility.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Everything has a trailing sequence number that needs to be removed
    Matcher match = TRAILER_PTN.matcher(body);
    if (!match.find()) return false;
    body = body.substring(0,match.start()).trim();
    
    // Check for run report
    match = RUN_REPORT_PTN.matcher(body);
    if (match.find()) {
      data.strCall = "RUN REPORT";
      data.strCallId = match.group(1);
      data.strPlace = body.substring(match.end()).trim();
      return true;
    }
    
    // Check for preposition posting
    match = PREPOSITION_PTN.matcher(body);
    if (match.matches()) {
      data.strUnit = match.group(1);
      data.strCall = match.group(2);
      parseAddress(match.group(3), data);
      return true;
    }
    
    // Check for Cancel notice
    match = CANCEL_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "CANCEL";
      data.strUnit = match.group(1);
      parseAddressCity(match.group(2), data);
      return true;
    }
    
    // Otherwise, treat as standard page message
    data.strCall = "ALERT";
    if (!parseFields(body.split(","), data)) return false;
    
    // Some city names are really Knoxville subdivisions that Google does not recognize
    if (KNOXVILLE_SUBDIVISIONS.contains(data.strCity)) {
      data.strPlace = append(data.strCity, " - ", data.strPlace);
      data.strCity = "KNOXVILLE";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
  
  private static final Pattern APT_PRI_PTN = Pattern.compile("APT +(.*?) +PRI (.*)");
  private class MyAptPriorityField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = APT_PRI_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strApt = match.group(1);
      data.strPriority = match.group(2);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "APT PRI";
    }
  }
  
  private class MyInfoField extends InfoField {
    
    private String prefix;
    
    public MyInfoField(String prefix) {
      this.prefix = prefix;
    }
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith(prefix)) return false;
      if (field.length() > prefix.length()) {
        super.parse(field, data);
      }
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("INC# (\\d+)");
    if (name.equals("ADDR")) return new AddressField("LOC +(.*)", true);
    if (name.equals("APTPRI")) return new MyAptPriorityField();
    if (name.equals("PATCOND")) return new MyInfoField("PAT.COND");
    if (name.equals("MAP")) return new MapField("MAP\\b *(.*)", true);
    if (name.equals("X")) return new CrossField("X1\\b *(.*)", true);
    if (name.equals("ADDLOC")) return new InfoField("ADDLOC\\b *(.*)", true);
    if (name.equals("PLACE")) return new PlaceField("BLDG\\b *(.*)", true);
    if (name.equals("DEST")) return new MyInfoField("DEST");
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "FARR", "FARRAGUT",
      "GALL", "GALL",
      "GIBB", "GIBBS",
      "HALL", "HALLS CROSSROADS",
      "KNOX", "KNOXVILLE",
      "POWL", "POWELL",
      "SVFD", "SVFD"
  });
  
  private static final Set<String> KNOXVILLE_SUBDIVISIONS = new HashSet<String>(Arrays.asList(new String[]{
      "GALL", "GIBBS", "SVFD"
  }));
}
