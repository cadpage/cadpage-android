package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Montgomery County, TX (MCHD EMS)
 */
public class TXMontgomeryCountyBParser extends DispatchProQAParser {
  
  private static final String FIELD_LIST1 = "UNIT ID ADDR APT CITY CALL BOX MAP SRC CH";
  private static final String FIELD_LIST2 = "CODE CALL BOX ADDR APT CITY SRC MAP UNIT";
  
  private static final Pattern MASTER1 = Pattern.compile("(?:(\\d+?)?(\\d{2,4}-\\d{6,7}) +)?(.*?)(?: *(\\d\\d[A-Z]-[A-Z]))? +(\\d{2,3}[A-Za-z])(?: +(F[DG]\\d+(?: +F[DG]\\d+)*)(?: +(?:North|East|South|West))?)?(?: +([A-Z]+\\d+(?: +[A-Z]+\\d+)*))?(?: +(TAC +\\d+))?");
  private static final Pattern MASTER2 = Pattern.compile("(?:([A-Z0-9]+)-)?(.*?) *(\\d\\d[A-Z]-[A-Z]) +(.*?) +(F[DG]\\d+(?: +F[DG]\\d+)*) +(\\d{2,3}[A-Za-z])(?: +(.*))?");
  
  private static final Pattern ADDRESS_RANGE_PTN = Pattern.compile("\\b(\\d+) *- *(\\d+)\\b");
  
  private static final Pattern NOTIFICATION_PTN = Pattern.compile("(\\d\\d-\\d{6} - \\d+)\\) (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) [\\d:]+\\.000-\\[\\d+\\] \\[Notification\\] +(.*?)(?: +\\[Shared\\])?");
  private static final Pattern RUN_REPORT_PTN = 
      Pattern.compile("(\\d{4}-\\d{6}) +,?((?:Time Canceled:|Time Call Complete:|Assigned|Time at Destination:|Priority Change:|Call Canceled Reason:).*)");
  
  public TXMontgomeryCountyBParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "TX",
           "ID UNIT! Priority:PRI! CALL MAP ADDR/S! INFO+");
    setFieldList(FIELD_LIST1);
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
  protected boolean parseMsg(String subject, String body, Data data) {
    
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
      if (parseFields(body.split(","), data)) return true;
      data.initialize(this);
    }
    
    // Foo.  Now we have to do this the hard way
    
    match = MASTER2.matcher(body);
    if (match.matches()) {
      setFieldList(FIELD_LIST2);
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
      setFieldList(FIELD_LIST1);
      data.strUnit = getOptGroup(match.group(1));
      data.strCallId = getOptGroup(match.group(2));
      String addr = match.group(3).trim();
      addr = ADDRESS_RANGE_PTN.matcher(addr).replaceAll("$1-$2");
      parseAddress(StartType.START_ADDR, addr, data);
      data.strCall = getLeft();
      if (data.strCall.equals("Out of County Respon")) data.defCity = "";
      if (data.strCall.length() == 0) return false;
      data.strBox = getOptGroup(match.group(4));
      data.strMap = match.group(5);
      data.strSource = getOptGroup(match.group(6));
      data.strUnit = append(data.strUnit, " ", getOptGroup(match.group(7)));
      data.strChannel = getOptGroup(match.group(8));
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
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{6}", true);
    if (name.equals("PRI")) return new PriorityField("\\d");
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
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
