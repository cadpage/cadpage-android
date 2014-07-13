package net.anei.cadpage.parsers.OR;


import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Linn County, OR
 */
public class ORLinnCountyParser extends FieldProgramParser {
  
  private static final String[] MARKERS = new String[]{
    "ICOM/400 notification,",
    "LINN 911 (!) ",
    "LINN 911 (ICOM/400 notification)"
  };
  
  private boolean intersection;
  
  public ORLinnCountyParser() {
    super(CITY_LIST, "LINN COUNTY", "OR",
           "UNIT1? ( CALL_PREFIX CALL CALL2+? ADDR CITY? INFO+? ID | CALL CALL2+? ( DATE TIME PLACE_X | ADDR/S! ( CITY! | DATE TIME! | PLACE_X+? MAP! ) ) UNIT? INFO+? UNIT )");
  }
  
  @Override
  public String getFilter() {
    return "linn911@le.linn.or.us,linn911@linnsheriff.org,777";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    for (String marker : MARKERS) {
      if (body.startsWith(marker)) {
        body = body.substring(marker.length()).trim();
        break;
      }
    }
    
    // Now call the regular parsing logic
    intersection = false;
    if (!parseFields(body.split("/"), 2, data)) return false;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT1")) return new UnitField("[A-Z]+\\d+", true);
    if (name.equals("CALL_PREFIX")) return new MyCallPrefixField(); 
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("CALL2")) return new MyCall2Field();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INTERSECT")) return new MyIntersectField();
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("PLACE_X")) return new MyPlaceCrossField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("ID")) return new IdField("\\d{6,}", true);
    return super.getField(name);
  }
  
  private static final Pattern CALL_PREFIX_PTN = Pattern.compile("Recall Alarm|(?:1st|2nd|3rd|4th|5th) Alr Incd");
  private class MyCallPrefixField extends CallField {
    public MyCallPrefixField() {
      setPattern(CALL_PREFIX_PTN, true);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      String call = field;
      String result = field;
      int pt = 0;
      while (true) {
        SortedSet<String> tailSet = CALL_LIST.tailSet(call);
        if (tailSet.isEmpty()) break;
        String tmp = tailSet.first();
        if (call.equals(tmp)) {
          result = call;
          break;
        }
        if (!tmp.startsWith(call)) break;
        tmp = getRelativeField(++pt);
        if (tmp.length() == 0) break;
        call = call + '/' + tmp;
      }
      data.strCall = append(data.strCall, " - ", result);
    }
  }
  
  private class MyCall2Field extends SkipField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return data.strCall.contains(field);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      intersection = field.endsWith(" INTERSECTN");
      if (intersection) field = field.substring(0,field.length()-11).trim();
      super.parse(field, data);
    }
  }
  
  private class MyIntersectField extends CrossField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!intersection) return false;
      super.parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  
  private class MyDateField extends DateField {
    public MyDateField() {
      super("\\d\\d-\\d\\d-\\d\\d", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("-", "/");
      super.parse(field, data);
    }
  }
  
  private class MyPlaceCrossField extends Field {

    @Override
    public void parse(String field, Data data) {
      field = stripFieldEnd(field, "&");
      if (checkAddress(field) >= STATUS_STREET_NAME) {
        data.strCross = append(data.strCross, " & ", field);
      } else {
        data.strPlace = append(data.strPlace, "/", field);
      }
    }

    @Override
    public String getFieldNames() {
      return "PLACE X";
    }
    
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("(\\d{4,6}[A-Z]{0,2})(\\d\\d\\*?[A-Z]{0,2}\\d\\d|[A-Z]\\d{2}[A-Z]{1,2}|)");
  private class MyMapField extends MapField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return true;
      Matcher match = MAP_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strMap = match.group(1);
      data.strUnit = match.group(2);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "MAP UNIT";
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z0-9 ]+");
  private class MyUnitField extends UnitField {
    MyUnitField() {
      setPattern(UNIT_PTN, true);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "/", field);
    }
  }
  
  boolean isValidCall(String call) {
    int pt = call.indexOf(" - ");
    if (pt >= 0) {
      if (CALL_PREFIX_PTN.matcher(call.substring(0,pt)).matches()) {
        call = call.substring(pt+3);
      }
    }
    return CALL_LIST.contains(call);
  }

  private static final TreeSet<String> CALL_LIST = new TreeSet<String>(Arrays.asList(new String[]{
      "1ST ALARM GRASS FIRE",
      "1st Alarm Incident",
      "ABDOM PAIN/PROB",
      "ALARM-FIRE",
      "ALLRGY/HIVES/MED REACT/STING",
      "ANIMAL BITES/ATTACKS",
      "APARTMENT FIRE",
      "ASSLT/RAPE",
      "BACK PAIN",
      "BREATH PROB",
      "BRUSH FIRE",
      "BURN COMPL",
      "BURNS/EXPLOSION",
      "CARDIAC/RESP ARREST",
      "CAR FIRE",
      "CHEST PAIN",
      "CHOKING",
      "CONVUL/SEIZURES",
      "DIABETIC PROB",
      "Dispatch Status",
      "EMERGENCY TRANSFER",
      "EYE PROB/INJURIES",
      "FALLS/BACK INJURIES",
      "GRASS FIRE",
      "HAZMAT INCIDENT",
      "HEART PROB",
      "HEMORRHAGE/LACERATIONS",
      "HOUSE FIRE",
      "UNCONC/FAINTING",
      "MEDICAL TRANSFER",
      "MOVE UP (MUTUAL AID)",
      "MUTUAL AID TO SCENE",
      "OB/CHILD BIRTH",                                                                                                                        
      "O D/INGESTION/POISONING",                                                                                                               
      "ODOR INVEST",                                                                                                                           
      "OTH STRCT FIRE",                                                                                                                        
      "POST FIRE INVEST",                                                                                                                      
      "PSYC/SUICIDE ATTEMPT",                                                                                                                  
      "PUBLIC ASSISTANCE",                                                                                                                     
      "SICK PERSON",                                                                                                                           
      "SMALL FIRE",                                                                                                                            
      "SMOKE INVEST",                                                                                                                          
      "STANDBY",                                                                                                                               
      "STROKE/CVA",                                                                                                                            
      "TRAF COLLISION",                                                                                                                        
      "TRAUMA INJ",                                                                                                                            
      "TRUCK FIRE",                                                                                                                            
      "UNCONC/FAINTING",                                                                                                                       
      "UNK PROB (man down)",   
      "WATER RESCUE",
      "WIRE DOWN"                                                                                                                                 
  }));
  
  private static final String[] CITY_LIST = new String[]{
    "LINN COUNTY",
    "ALBANY",
    "BROWNSVILLE",
    "GATES",
    "HALSEY",
    "HARRISBURG",
    "IDANHA",
    "LEBANON",
    "LYONS",
    "MILL CITY",
    "MILLERSBURG",
    "SCIO",
    "SODAVILLE",
    "SWEET HOME",
    "TANGENT",
    "WATERLOO",
    "CASCADIA",
    "CRABTREE",
    "CRAWFORDSVILLE",
    "MARION FORKS",
    "SHEDD",
    "SOUTH LEBANON",
    
    // Benton County
    "CORVALLIS"
  };
}
