package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class TXWilliamsonCountyBParser extends DispatchOSSIParser {

  public TXWilliamsonCountyBParser() {
    super(CITY_LIST, "WILLIAMSON COUNTY", "TX", 
          "( CANCEL! | FYI? CALL! ) ADDR/S CITY! PLACE_MAP? UNIT");
  }
  
  @Override protected boolean parseMsg(String subject, String body, Data data) {
    if (parseGMATMsg(body, data)) return true;
    
    if (subject.equals("Message Forwarded by PageGate") &&
        !body.startsWith("CAD:")) body = "CAD:" + body;
    return super.parseMsg(body, data);
  }

  private static final Pattern GMAT_MASTER = Pattern.compile("CAD:ATTN GMAT: (.*?) (?:(?:RESPOND ON|RESPONSE TAKE) +)?(C ?(?:MED|FIRE) ?\\d)\\b.*");
  private static final Pattern GMAT_MAP_PTN = Pattern.compile("(.*) MAPSCO ([A-Z0-9]+)");
  private static final Pattern GMAT_CITY_PTN = Pattern.compile("(.*) IN ([A-Z]+)(?: (.*))?");
  private static final Pattern GMAT_CALL_ADDR_PTN = Pattern.compile("(.*)(?:: | \\.\\. )(.*)");
  private boolean parseGMATMsg(String body, Data data) {
    Matcher match = GMAT_MASTER.matcher(body);
    if (!match.matches()) return false;
    setFieldList("CALL ADDR APT CITY PLACE MAP CH");
    body =  match.group(1).trim();
    data.strChannel= match.group(2).replace(" ", "");
    
    body = stripFieldEnd(body, ",");
    body = stripFieldEnd(body, ".");
    match = GMAT_MAP_PTN.matcher(body);
    if (match.matches()) {
      body = match.group(1).trim();
      data.strMap = match.group(2);
    }
    
    body = stripFieldEnd(body, ",");
    body = stripFieldEnd(body, ".");
    match =  GMAT_CITY_PTN.matcher(body);
    if (match.matches()) {
      body = match.group(1);
      data.strCity = match.group(2);
      data.strPlace = getOptGroup(match.group(3));
    }
    body = stripFieldEnd(body, ",");
    
    match = GMAT_CALL_ADDR_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = match.group(1).trim();
      body = match.group(2).trim();
    }
    
    StartType st = StartType.START_ADDR;
    int flags = 0;
    
    int pt = body.indexOf(',');
    if (pt > 0) {
      parseAddress(body.substring(0,pt).trim(), data);
      data.strCall = body.substring(pt+1).trim();
    }
    
    else {
      if (data.strCall.length() == 0) {
        st = StartType.START_CALL;
        flags |= FLAG_START_FLD_REQ;
      }
      if (data.strCity.length() > 0) {
        flags |= FLAG_ANCHOR_END | FLAG_NO_CITY;
      }
      parseAddress(st, flags, body, data);
      data.strPlace = getLeft();
    }
    
    return true;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("PLACE_MAP")) return new MyPlaceMapField();
    return super.getField(name);
  }
  
  // Normally the default city field would do this, but we had to pass the city list
  // to the base class, so we have to to handle the code table here
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      data.strCity = CITY_CODES.getProperty(field);
      if (data.strCity == null) abort();
    }
  }
  
  private static Pattern PLACE_MAP_PAT = Pattern.compile("(?:\\(S\\)(.*?) )?\\(N\\)(.*?)");
  private class MyPlaceMapField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher mat = PLACE_MAP_PAT.matcher(field);
      if (!mat.matches()) return false;
      data.strPlace = getOptGroup(mat.group(1));
      data.strMap = mat.group(2).trim();
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "PLACE MAP";
    }
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return PVR_PTN.matcher(addr).replaceAll("PVT RD");
  }
  private static final Pattern PVR_PTN = Pattern.compile("\\bPVR\\b", Pattern.CASE_INSENSITIVE);

  
  // We need a city code set for the regular call format and a city list for the
  // specialized formats, and the address parse cannot do both.  Solution is that we
  // will pass the city list to the base class and do the city code processing
  // ourself.
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AU",      "AUSTIN",
      "EL",      "ELGIN",
      "LE",      "LEANDER",
      "LH",      "LIBERTY HILL",
      "JA",      "JARRELL",
      "GR",      "GRANGER",
      "GT",      "GEORGETOWN",
      "HU",      "HUTO",
      "FL",      "FLORENCE",
      "RR",      "ROUND ROCK",
      "TA",      "TAYLOR",
      "TH",      "THRALL",
      "WR",      "WEIR"
  });

  private static final String[] CITY_LIST = new String[]{
    "AUSTIN",
    "ELGIN",
    "LEANDER",
    "LIBERTY HILL",
    "JARRELL",
    "GRANGER",
    "GEORGETOWN",
    "HUTO",
    "FLORENCE",
    "ROUND ROCK",
    "TAYLOR",
    "THRALL",
    "WEIR"
  };
}
