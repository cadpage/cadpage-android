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
  private static final Pattern PREPOSITION_PTN1 = Pattern.compile("((?:MEDIC )?[A-Z0-9]+) +((?:PLEASE|INSERVICE) POST|(?:EXCEPTION |FROM [A-Z0-9]+ )?TO) +(.*?)");
  private static final Pattern PREPOSITION_PTN2 = Pattern.compile("(.*\\bEXCEPTION) ([A-Z0-9]+) +TO +(.*?)");
  private static final Pattern PREPOSITION_PTN3 = Pattern.compile("#\\d+ +([A-Z0-9]+) +TO +(.*?) +FROM +(.*)");
  private static final Pattern CANCEL_PTN = Pattern.compile("(.*?) +CALL AT +(.*)? +IS CANCELLED , .*");
  
  public TNKnoxCountyParser() {
    super(CITY_CODES, "KNOX COUNTY", "TN",
           "( GRID LOC:ADDR/y! APT:APT! ADD_LOC:INFO! X1:X! NAT:CALL! UNITS:UNIT! INC#:ID! NOTES:NOTES! | UNIT ID1 ADDR1/y APTPRI PATCOND MAP1 X1 ADDLOC PLACE1 DEST! )");
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
    
    // Check for preposition postings
    // Which come in at least 3 different forms
    match = PREPOSITION_PTN1.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT CALL ADDR APT INFO");
      data.strUnit = match.group(1);
      data.strCall = match.group(2);
      parsePrepositionAddress(match.group(3), data);
      return true;
    }
    
    // Check for preposition posting
    match = PREPOSITION_PTN2.matcher(body);
    if (match.matches()) {
      setFieldList("CALL UNIT ADDR APT INFO");
      data.strCall = match.group(1) + " TO";
      data.strUnit = match.group(2);
      parsePrepositionAddress(match.group(3), data);
      return true;
    }
    
    // Check for preposition posting
    match = PREPOSITION_PTN3.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT ADDR APT INFO");
      data.strUnit = match.group(1);
      parseAddress(StartType.START_ADDR, FLAG_NO_CITY | FLAG_RECHECK_APT | FLAG_ANCHOR_END, match.group(2), data);
      data.strCall = match.group(3);
      return true;
    }
    
    // Check for Cancel notice
    match = CANCEL_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("CALL UNIT ADDR APT CITY");
      data.strCall = "CANCEL";
      data.strUnit = match.group(1);
      parseAddressCity(match.group(2), data);
      data.strCity = convertCodes(data.strCity, CITY_CODES);
    }
    
    // Process  Grid type page
    else if (body.startsWith("GRID ")) {
      body = body.replace(" INC# ", " INC#: ").replace(" NOTES ", " NOTES: ");
      if (!super.parseMsg(body, data)) return false; 
    }
    
    // Otherwise, treat as standard page message
    else {
      data.strCall = "ALERT";
      if (!parseFields(body.split(","), data)) {
        data.parseGeneralAlert(this, body);
        return true;
      }
    }
    
    // Some city names are really Knoxville subdivisions that Google does not recognize
    if (KNOXVILLE_SUBDIVISIONS.contains(data.strCity)) {
      data.strPlace = append(data.strCity, " - ", data.strPlace);
      data.strCity = "KNOXVILLE";
    }
    return true;
  }
  
  private void parsePrepositionAddress(String address, Data data) {
    Matcher match = PREPOSITION_TRAIL_PTN.matcher(address);
    if (match.matches()) {
      address = match.group(1);
      data.strSupp = match.group(2);
    }
    parseAddress(StartType.START_ADDR, FLAG_NO_CITY | FLAG_RECHECK_APT | FLAG_ANCHOR_END, address, data);
  }
  private static final Pattern PREPOSITION_TRAIL_PTN = Pattern.compile("(.*?) *(?:, | - |(?=FROM |DISTANCE))(.*)");

  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("GRID")) return new MapField("GRID +(.*)", true);
    if (name.equals("ID2")) return new IdField("\\d+");
    if (name.equals("NOTES")) return new MyNotesField();
    
    if (name.equals("ID1")) return new IdField("INC# (\\d+)");
    if (name.equals("ADDR1")) return new AddressField("LOC +(.*)", true);
    if (name.equals("APTPRI")) return new MyAptPriorityField();
    if (name.equals("PATCOND")) return new MyInfoField("PAT.COND");
    if (name.equals("MAP1")) return new MapField("MAP\\b *(.*)", true);
    if (name.equals("X1")) return new CrossField("X1\\b *(.*)", true);
    if (name.equals("ADDLOC")) return new InfoField("ADDLOC\\b *(.*)", true);
    if (name.equals("PLACE1")) return new PlaceField("BLDG\\b *(.*)", true);
    if (name.equals("DEST")) return new MyInfoField("DEST");
    return super.getField(name);
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
  
  private static final Pattern NOTE_IGNORE_PTN = Pattern.compile("^(?:\\*CITY:|FULL ADDR:|\\*Fire service incident|Ambulance service incident).*");
  private static final Pattern NOTE_PLACE_PTN = Pattern.compile("(?:\\*SUBDIVISION -|\\*LOC CN:) *(.*)");
  private static final Pattern NOTE_INFO_PTN = Pattern.compile("Nature: *(.*)");
  private class MyNotesField extends Field {
    @Override
    public void parse(String field, Data data) {
      for (String part : field.split(",")) {
        part = part.trim();
        if (NOTE_IGNORE_PTN.matcher(part).matches()) continue;
        if ("*Fire service incident".startsWith(part)) continue;
        if ("Ambulance service incident".startsWith(part)) continue;
        Matcher match = NOTE_PLACE_PTN.matcher(part);
        if (match.matches()) {
          String place = match.group(1);
          if (place.equals("!!!")) continue;
          data.strPlace = append(data.strPlace, " - ", place);
          continue;
        }
        match = NOTE_INFO_PTN.matcher(part);
        if (match.matches()) part = match.group(1);
        data.strSupp = append(data.strSupp, ", ", part);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE INFO";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BAKE", "BAKE",
      "FARR", "FARRAGUT",
      "GAL",  "GAL",
      "GALL", "GALL",
      "GIBB", "GIBBS",
      "HALL", "HALLS CROSSROADS",
      "KARN", "KARNS",
      "KNOX", "KNOXVILLE",
      "KVFD", "KVFD",
      "MART", "MART",
      "PELL", "PELL",
      "POWL", "POWELL",
      "SVFD", "SVFD",
      "THOR", "THORN GROVE"
  });
  
  private static final Set<String> KNOXVILLE_SUBDIVISIONS = new HashSet<String>(Arrays.asList(new String[]{
      "BAKE",
      "GAL",
      "HALLS CROSSROADS",
      "KARNS",
      "KVFD",
      "MART", 
      "GALL", 
      "GIBBS", 
      "PELL",
      "POWELL",
      "SVFD",
      "THORN GROVE"
  }));
}
