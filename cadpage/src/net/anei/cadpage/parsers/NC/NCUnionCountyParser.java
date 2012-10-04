package net.anei.cadpage.parsers.NC;

/**
 * Union County, NC
 */
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCUnionCountyParser extends DispatchOSSIParser {
  
  public NCUnionCountyParser() {
    super(CITY_LIST, "UNION COUNTY", "NC",
           "( CANCEL ADDR CITY? | FYI? ADDR CITY? CALL ) SRC? UNIT? INFO+? DATETIME PLACE");
  }
  
  @Override
  public String getFilter() {
    return "cad@uc.co.union.nc.us,cad@webmail.co.union.nc.us,cad@co.union.nc.us";
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (checkAddress(field) > 0) {
        data.strCross = append(data.strCross, " & ", field);
      } else if (data.strPlace.length() == 0) {
        data.strPlace = field;
      } else {
        data.strSupp = append(data.strSupp, " / ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X PLACE INFO";
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("CANCEL")) return new CallField("CANCEL");
    if (name.equals("SRC")) return new SourceField("[A-Z0-9]{2,4}", true);
    if (name.equals("UNIT")) return new UnitField("[A-Z0-9]{2,4}(?:-[A-Z0-9]{1,4})?", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d");
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FAIRVIEW",
    "HEMBY BRIDGE",
    "INDIAN TRAIL",
    "LAKE PARK",
    "MARSHVILLE",
    "MARVIN",
    "MINERAL SPRINGS",
    "MONROE",
    "STALLINGS",
    "UNIONVILLE",
    "WAXHAW",
    "WEDDINGTON",
    "WESLEY CHAPEL",
    "WINGATE"
  };
}
