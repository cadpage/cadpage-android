package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Montgomery County, TX (MCHD EMS)
 */
public class TXMontgomeryCountyBParser extends DispatchProQAParser {
  
  private static final Pattern MASTER1 = Pattern.compile("(?:(\\d+?)?(\\d{2,4}-\\d{6,7}) +)?(.*?)(?: *(\\d\\d[A-Z]-?[A-Z]))? *((?:WOODLA)?\\d{2,4}[A-Za-z])(?: +(F[DG]\\d+(?: +F[DG]\\d+)*)(?: +(?:North|East|South|West))?)?(?: +((?:[A-Z]+\\d+|Lake Rescue)(?: +[A-Z]+\\d+)*))?(?: +(TAC +\\d+))?");
  private static final Pattern MASTER2 = Pattern.compile("(?:([A-Z0-9]+)-)?(.*?) *(\\d\\d[A-Z]-[A-Z]) +(.*?) +(F[DG]\\d+(?: +F[DG]\\d+)*) +(\\d{2,3}[A-Za-z])(?: +(.*))?");
  private static final Pattern MASTER3 = Pattern.compile("([^\\d].*?)(0BH \\d|\\d\\d[A-Z]{2}\\b)(.*?)(?: (F[DG]\\d))? (\\d{2,3}[A-Z]) (.*)");
  
  private static final Pattern ADDRESS_RANGE_PTN = Pattern.compile("\\b(\\d+) *- *(\\d+)\\b");
  
  private static final Pattern NOTIFICATION_PTN = Pattern.compile("(\\d\\d-\\d{6} - \\d+)\\) (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) [\\d:]+\\.000-\\[\\d+\\] \\[Notification\\] +(.*?)(?: +\\[Shared\\])?");
  private static final Pattern RUN_REPORT_PTN = 
      Pattern.compile("(\\d{4}-\\d{6}) +,?((?:Time Canceled:|Time Call Complete:|Assigned|Time at Destination:|Priority Change:|Call Canceled Reason:).*)");
  private static final Pattern MISSING_BLANK_PTN = Pattern.compile("(?<=[a-z])(?=[A-Z])|(?<= [A-Z])(?=[A-Z][a-z])");
  
  public TXMontgomeryCountyBParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "TX",
           "ID UNIT! Priority:PRI! CALL MAP ADDR/S! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "tritechcad@mchd-tx.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public CodeSet getCallList() {
    return CALL_SET;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (body.startsWith("ID:") || body.startsWith("ID#:")) return false;
    
    if (!subject.equals("CAD Message")) return false;
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strCallId = match.group(1);
      data.strPlace = match.group(2);
      return true;
    }
    
    match = NOTIFICATION_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "GENERAL ALERT";
      data.strCallId = match.group(1);
      data.strDate = match.group(2);
      data.strTime = match.group(3);
      data.strPlace = match.group(4);
      return true;
    }
    
    // See if we can use the regular comma delimited form
    // Sometimes a long list of comma separated unit numbers will return more
    // than 5 fields even if this is not a legitimate comma delimited form, so
    // we have to recover and try again if the parse call fails
    String[] flds = body.split(",");
    if (flds.length >= 5) {
      if (parseFields(flds, data)) return true;
      data.initialize(this);
    }
    
    // Foo.  Now we have to do this the hard way
    match = MASTER3.matcher(body);
    if (match.matches()) {
      setFieldList("CALL MAP ADDR APT SRC UNIT");
      data.strCall = match.group(1).trim();
      data.strMap = match.group(2).trim();
      parseAddress(match.group(3).trim(), data);
      data.strSource = getOptGroup(match.group(4));
      data.strUnit = match.group(5);
      return true;
    }
    
    match = MASTER2.matcher(body);
    if (match.matches()) {
      setFieldList("CODE CALL BOX ADDR APT CITY SRC MAP UNIT");
      data.strCode = getOptGroup(match.group(1));
      data.strCall = match.group(2).trim();
      if (data.strCall.equals("Out of County Respon")) data.defCity = "";
      data.strBox = match.group(3);
      parseAddress(match.group(4).trim(), data);
      data.strSource = match.group(5);
      data.strMap = match.group(6);
      data.strUnit = getOptGroup(match.group(7));
      return true;
    }

    match = MASTER1.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT ID ADDR APT CITY CALL BOX MAP SRC CH");
      data.strUnit = getOptGroup(match.group(1));
      data.strCallId = getOptGroup(match.group(2));
      String addr = match.group(3).trim();
      addr = ADDRESS_RANGE_PTN.matcher(addr).replaceAll("$1-$2");
      data.strBox = getOptGroup(match.group(4));
      data.strMap = match.group(5);
      data.strSource = getOptGroup(match.group(6));
      data.strUnit = append(data.strUnit, " ", getOptGroup(match.group(7)));
      data.strChannel = getOptGroup(match.group(8));
      
      // What we have is an address followed by a call, with no consistent
      // way to identify the break.
      // Start by looking it up in a reverse call list
      boolean found = false;
      String call = CALL_SET.getCode(addr);
      if (call != null) {
        found = true;
        data.strCall = call;
        addr = addr.substring(0,addr.length()-call.length());
      }
      
      // No luck, try looking for a signature lower case letter followed by
      // an upper case character
      else if ((match = MISSING_BLANK_PTN.matcher(addr)).find()) {
        found = true;
        pt = match.start();
        data.strCall = addr.substring(pt);
        addr = addr.substring(0,pt);
      }
      
      // If either of those worked, the address may be truncated, in which 
      // case we will try to complete common road suffixes
      if (found) {
        if (addr.endsWith(" ")) {
          addr = addr.trim();
        } else {
          pt = addr.lastIndexOf(' ');
          if (pt >= 0) {
            pt++;
            String lastWord = addr.substring(pt);
            if ("Av".startsWith(lastWord)) addr = addr.substring(0,pt) + "Ave";
            if ("Ci".startsWith(lastWord)) addr = addr.substring(0,pt) + "Cir";
            if ("D".startsWith(lastWord)) addr = addr.substring(0,pt) + "Dr";
            if ("Loo".startsWith(lastWord)) addr = addr.substring(0,pt) + "Loop";
            if ("R".startsWith(lastWord)) addr = addr.substring(0,pt) + "Rd";
          }
        }
        parseAddress(addr, data);
      }
      
      // If neither approach found the break, we will have to count on the
      // smart address parser, which is none to reliable in this county.  There
      // are too many street names that really lack an identifiable suffix
      else {
        parseAddress(StartType.START_ADDR, addr, data);
        data.strCall = getLeft();
        if (data.strCall.length() == 0) return false;
      }
      
      // If call is out of county response, zap the default county
      if (data.strCall.startsWith("Out of County Respon")) data.defCity = "";
      
      return true;
    }

    return false;
  }

  private static final Pattern CALL_PTN = Pattern.compile("([^-]+?) *-?- +(.*)");
  private class MyCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_PTN.matcher(field);
      if (match.matches()) {
        data.strCode = match.group(1);
        field = match.group(2);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private static final Pattern ZIP_CODE_PTN = Pattern.compile(" +(\\d{5})$");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String zip = null;
      Matcher match = ZIP_CODE_PTN.matcher(field);
      if (match.find()) {
        zip = match.group(1);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
      if (zip != null && data.strCity.length() == 0) data.strCity = zip;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{2,4}-\\d{6}", true);
    if (name.equals("PRI")) return new PriorityField("\\d");
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final ReverseCodeSet CALL_SET = new ReverseCodeSet(
      "#CFD AIRCRAFT EMERGENCY PA",
      "51D01-ALERT III ON L",
      "Abdominal Pain",
      "Alarm",
      "Alarm - Carbon Monox",
      "Alarm - Fire",
      "Alarm - Pull Station",
      "Alarm - Water Flow",
      "Allergic Reaction",
      "Animal Bite",
      "Assault",
      "Assist Law Enforceme",
      "Back Pain",
      "Burn Patient",
      "Cardiac Arrest",
      "Chest Pain",
      "Child Locked in a Ve",
      "Choking",
      "DRILL ONLY - TEST",
      "Diabetic Problems",
      "Difficulty Breathing",
      "Drowning",
      "Electrical Hazard -",
      "Electrical Hazard - Live Wires",
      "Eye Problems/Injury",
      "Fall",
      "Fluid Spill",
      "Gas - Cut Line Outsi",
      "Gas - Smell in Area",
      "Gas - Smell in a Bui",
      "Gas - Smell in a Res",
      "Headache",
      "Heart Problems",
      "Hemorrhage/Laceratio",
      "Hemorrhage/Laceration",
      "Lightning - To a Str",
      "MVA",
      "MVA - Entrapment",
      "MVA - Fire",
      "Medical Priority 1",
      "Medical Priority 2",
      "Out of County Respon",
      "Outside - Check For",
      "Outside - Check For Fire",
      "Outside - Controlled Burn",
      "Outside - Controlled",
      "Outside - Dumpster F",
      "Outside - Grass/Wood",
      "Outside - Grass/Woods Fire",
      "Outside - Illegal Bu",
      "Outside - Illegal Burn",
      "Outside - Small Fire",
      "Outside - Trash Fire",
      "Overdose/Ingestion",
      "Pregnancy/Miscarriag",
      "Pregnancy/Miscarriage",
      "Psychiatric/Suicide",
      "Seizures",
      "Service Call",
      "Sick Person",
      "Smoke - In a Bldg Co",
      "Smoke - In a Bldg Commercial",
      "Smoke - In a Residen",
      "Smoke - In a Residence",
      "Smoke - In the Area",
      "Smoke - Smell in a R",
      "Smoke - Smell in the Area",
      "Smoke - Smell in the",
      "Stab/GSW/Penetrating Trauma",
      "Stab/GSW/Penetrating",
      "Stroke",
      "Structure - Apartmen",
      "Structure - Commerci",
      "Structure - Extingui",
      "Structure - Resident",
      "Structure - Residential",
      "Structure - Small Building",
      "Structure Fire",
      "Traumatic Injury",
      "Unconscious/Fainting",
      "Unknown Problem/Man",
      "Unknown Problem/Man Down",
      "Vehicle Fire - Comme",
      "Vehicle Fire",
      "Water Rescue - Motor"

  );
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "CONROE",
    "CUT AND SHOOT",
    "HOUSTON",
    "MAGNOLIA",
    "MONTGOMERY",
    "OAK RIDGE NORTH",
    "PANORAMA VILLAGE",
    "PATTON VILLAGE",
    "ROMAN FOREST",
    "SHENANDOAH",
    "SPLENDORA",
    "STAGECOACH",
    "WOODBRANCH",
    "WOODLOCH",
    "WILLIS",

    // Census designated places
    "PINEHURST",
    "PORTER HEIGHTS",
    "THE WOODLANDS",

    // Unincorporated areas
    "DOBBIN",
    "DECKER PRAIRIE",
    "IMPERIAL OAKS",
    "NEW CANEY",
    "PORTER",
    "RIVER PLANTATION",
    "TAMINA",
    "THE WOODLANDS",
    
    // Harris County
    "SPRING"
  };
}
