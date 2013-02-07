package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Montgomery County, TX (MCHD EMS)
 */
public class TXMontgomeryCountyBParser extends DispatchProQAParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:(\\d{4})(\\d{4}-\\d{7}) +)?(.*?) *(\\d\\d[A-Z]-[A-Z]) +(\\d{3}[A-Z])(?: +(F[DG]\\d+(?: +F[DG]\\d+)*))?(?: +(TAC +\\d+))?");
  
  private static final Pattern RUN_REPORT_PTN = 
      Pattern.compile("(\\d{4}-\\d{6}) +,?((?:Time Canceled:|Time Call Complete:|Assigned|Time at Destination:|Priority Change:|Call Canceled Reason:).*)");
  
  public TXMontgomeryCountyBParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "TX",
           "ID UNIT! Priority:PRI! CALL MAP ADDR/S! INFO+");
    setFieldList("UNIT ID ADDR APT CALL CODE MAP SRC");
  }
  
  @Override
  public String getFilter() {
    return "tritechcad@mchd-tx.org";
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
    
    // See if we can use the regular comma delimited form
    String[] flds = body.split(",");
    if (flds.length >= 5) return parseFields(body.split(","), data);
    
    // Foo.  Now we have to do this the hard way
    match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = getOptGroup(match.group(1));
    data.strCallId = getOptGroup(match.group(2));
    parseAddress(StartType.START_ADDR, match.group(3), data);
    data.strCall = getLeft();
    if (data.strCall.length() == 0) return false;
    data.strCode = match.group(4);
    data.strMap = match.group(5);
    data.strSource = getOptGroup(match.group(6));
    data.strChannel = getOptGroup(match.group(7));
    return true;
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
