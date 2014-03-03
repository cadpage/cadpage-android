package net.anei.cadpage.parsers.NH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NHHanoverParser extends FieldProgramParser {
  
  public NHHanoverParser() {
    super(CITY_LIST, "HANOVER","NH",
           "CALL PLACE? ADDR/Z CITY! INFO+? DATETIME INFO+");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@HANOVER.PD,HDISPATCH@HOLLISNH.ORG,messaging@iamresponding.com.hanoverpaging@hanovernh.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("_")) data.strSource = subject;
    if (!parseFields(body.split("\n"), 3, data)) return false;
    if (VT_CITIES.contains(data.strCity)) data.defState = "VT";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyCityField extends CityField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // Sometimes the city and info fields are combined into one
      // field separated by a slash :(
      String info = null;
      int pt = field.indexOf('/');
      if (pt >= 0) {
        info = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      if (!super.checkParse(field, data)) return false;
      if (info != null) data.strSupp = append(data.strSupp, " / ", info);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "CITY INFO";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("District:")) {
        data.strMap = field.substring(9).trim();
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d{1,2}/\\d{1,2}/\\d{4} \\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Grafton County
    "ALEXANDRIA",
    "ASHLAND",
    "BATH",
    "MOUNTAIN LAKES",
    "BENTON",
    "BETHLEHEM",
    "BRIDGEWATER",
    "BRISTOL",
    "CAMPTON",
    "CANAAN",
    "DORCHESTER",
    "EASTON",
    "ELLSWORTH",
    "ENFIELD",
    "ENFIELD CENTER",
    "MONTCALM",
    "FRANCONIA",
    "GRAFTON",
    "GROTON",
    "HANOVER",
    "ETNA",
    "HAVERHILL",
    "MOUNTAIN LAKES",
    "NORTH HAVERHILL",
    "PIKE",
    "WOODSVILLE",
    "HEBRON",
    "EAST HEBRON",
    "HOLDERNESS",
    "LANDAFF",
    "LEBANON",
    "WEST LEBANON",
    "LINCOLN",
    "LISBON",
    "LITTLETON",
    "LIVERMORE",
    "LYMAN",
    "LYME",
    "LYME CENTER",
    "MONROE",
    "ORANGE",
    "ORFORD",
    "PIERMONT",
    "PLYMOUTH",
    "RUMNEY",
    "STINSON LAKE",
    "SUGAR HILL",
    "THORNTON",
    "WARREN",
    "GLENCLIFF",
    "WATERVILLE VALLEY",
    "WENTWORTH",
    "WOODSTOCK",
    "NORTH WOODSTOCK",
    
    // Hillsborough COunty
    "AMHERST",
    "ANTRIM",
    "BEDFORD",
    "BENNINGTON",
    "BROOKLINE",
    "DEERING",
    "FRANCESTOWN",
    "GOFFSTOWN",
    "GRASMERE",
    "PINARDVILLE",
    "GREENFIELD",
    "GREENVILLE",
    "HANCOCK",
    "HILLSBOROUGH",
    "HOLLIS",
    "HUDSON",
    "LITCHFIELD",
    "LYNDEBOROUGH",
    "MANCHESTER",
    "MASON",
    "MERRIMACK",
    "EAST MERRIMACK",
    "MILFORD",
    "MONT VERNON",
    "NASHUA",
    "NEW BOSTON",
    "NEW IPSWICH",
    "PELHAM",
    "PETERBOROUGH",
    "WEST PETERBOROUGH",
    "SHARON",
    "TEMPLE",
    "WEARE",
    "WILTON",
    "WINDSOR",
    
    // Merrimack County
    "ALLENSTOWN",
    "SUNCOOK",
    "ANDOVER",
    "EAST ANDOVER",
    "BOSCAWEN",
    "BOW",
    //  "BRADFORD",  (duplicates entry in Orange County VT)
    "CANTERBURY",
    "CHICHESTER",
    "CONCORD",
    "PENACOOK",
    "DANBURY",
    "DUNBARTON",
    "EPSOM",
    "FRANKLIN",
    "HENNIKER",
    "HILL",
    "HOOKSETT",
    "SOUTH HOOKSETT",
    "HOPKINTON",
    "CONTOOCOOK",
    "LOUDON",
    "NEW LONDON",
    "ELKINS",
    "NEWBURY",
    "BLODGETT LANDING",
    "SOUTH NEWBURY",
    "NORTHFIELD",
    "PEMBROKE",
    "SUNCOOK",
    "PITTSFIELD",
    "SALISBURY",
    "SUTTON",
    "NORTH SUTTON",
    "SOUTH SUTTON",
    "WARNER",
    "WEBSTER",
    "WILMOT",
    
    // Orange County (VT)
    "BRADFORD",
    
    // Windsor County (VT)
    "NORWICH"

  };
  
  private static final Set<String> VT_CITIES = new HashSet<String>(Arrays.asList(
    "BRADFORD",
    "NORWICH"
  ));
}
