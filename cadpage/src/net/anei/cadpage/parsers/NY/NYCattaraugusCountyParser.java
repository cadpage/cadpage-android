package net.anei.cadpage.parsers.NY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYCattaraugusCountyParser extends FieldProgramParser {
  
  private String address;
  
  public NYCattaraugusCountyParser() {
    super(CITY_CODES, "CATTARAUGUS COUNTY", "NY",
           "Unit:UNIT? Loc:ADDRCITY/S6! Between:X! CN:PLACE CTV:CITY Type:CALL Date:DATE Time:TIME Info:INFO Caller:NAME Inc:ID%");
  }
  
  @Override
  public String getFilter() {
    return "911@cattco.org,777,888";
  }
  
  private static Pattern MARKER = Pattern.compile("CATTARAUGUS COUNTY SHERIFF:? *");
  private static Pattern TRAIL_COMMA_PAT = Pattern.compile("[ ,]+$");
  private static Pattern LOCATION_PAT = Pattern.compile(".* COUNTY", Pattern.CASE_INSENSITIVE);
  private static final Pattern CALL_DATE_TIME_PTN = Pattern.compile("(.*) (\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (match.lookingAt()) {
      body = body.substring(match.end());
      if (body.startsWith("(")) {
        int parenCnt = 1;
        int pt = 1;
        for (; parenCnt > 0 && pt < body.length(); pt++) {
          char chr = body.charAt(pt);
          if (chr == '(') parenCnt++;
          else if (chr == ')') parenCnt--;
        }
        body = body.substring(pt).trim();
      }
    }
    
    body = body.replace(" Inc#:", " Inc:");
    address = null;
    if (!super.parseMsg(body, data)) return false;
    
    // A city code of OUTS -> OUTSIDE the county means we know nothing
    // about the county or state where this incident occurs :(
    if (data.strCity.equals("OUTSIDE")) {
      data.strCity = data.defCity = data.defState = "";
      
      // See if info field contains the entered address.  If it does, assume
      // that whatever follows the address is really a city name
      int pt = data.strSupp.indexOf(address);
      if (pt > 0) {
        data.strCity = data.strSupp.substring(pt + address.length()).trim();
      }
      
      // Otherwise, see if the name field contains a county or city name
      else if (LOCATION_PAT.matcher(data.strName).matches()) {
        data.strCity = data.strName;
        data.strName = "";
      }
    }
    
    // See if call field contains date/time
    if (data.strTime.length() == 0) {
      match = CALL_DATE_TIME_PTN.matcher(data.strCall);
      if (match.matches()) {
        data.strCall = match.group(1).trim();
        data.strDate = match.group(2);
        setTime(TIME_FMT, match.group(3), data);
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CALL", "CALL DATE TIME");
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
  }
  
  // Address field just remembers the address field
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      address = field;
      super.parse(field, data);
    }
  }
  
  private static final Pattern CITY_PLACE_PTN = Pattern.compile("(.*[a-z]) +([A-Z][^a-z]+)");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("No Cross Streets Found")) return;
      super.parse(field, data);
      if (data.strCity.length() > 0) {
        Matcher match = CITY_PLACE_PTN.matcher(data.strCity);
        if (match.matches()) {
          data.strCity = match.group(1);
          data.strPlace = match.group(2);
        }
        data.strCity = stripFieldEnd(data.strCity, " Town");
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  // Name field needs to remove trailing commas
  private class MyNameField extends NameField {

    @Override
    public void parse(String field, Data data) {
      
      Matcher match = TRAIL_COMMA_PAT.matcher(field);
      if (match.find()) {
        field = field.substring(0, match.start());
      }
      super.parse(field, data);
    }
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
     "ALLT","ALLEGANY",
     "ALLV","ALLEGANY",
     "ASHF","ASHFORD",
     "CARR","CARROLLTON",
     "CATT","CATTARAUGUS",
     "CLAR","CLARKSVILLE",
     "COLC","COLLINS CENTER",
     "COLD","COLDSPRING",
     "COLL","COLLINS",
     "CONE","CONEWANGO",
     "DAYT","DAYTON",
     "DELE","DELEVAN",
     "DELEVN","DELEVAN",
     "ELLI","ELLICOTTVILLE",
     "ELLT","ELLICOTTVILLE",
     "ELLV","ELLICOTTVILLE",
     "EOTT","EAST OTTO",
     "ERAN","EAST RANDOLPH",
     "FARM","FARMERSVILLE",
     "FRAT","FRANKLINVILLE",
     "FRAV","FRANKLINVILLE",
     "FREE","FREEDOM",
     "GENE","GENESEE",
     "GOWA","GOWANDA",
     "GVAL","GREAT VALLEY",
     "HINS","HINSDALE",
     "HUMP","HUMPHREY",
     "ISCH","ISCHUA",
     "LEON","LEON",
     "LIME","LIMESTONE",
     "LVLT","LITTLE VALLEY",
     "LVLV","LITTLE VALLEY",
     "LYND","LYNDON",
     "MACH","MACHIAS",
     "MANS","MANSFIELD",
     "NALB","NEW ALBION",
     "NAPO","NAPOLI",
     "OLEC","OLEAN CITY",
     "OLET","OLEAN",
     "OTTO","OTTO",
     "OUTS","OUTSIDE",
     "PERS","PERSIA",
     "PERT","PERRYSBURG",
     "PERV","PERRYSBURG",
     "PORT","PORTVILLE",
     "PORV","PORTVILLE",
     "RANT","RANDOLPH",
     "RANV","RANDOLPH",
     "REDH","RED HOUSE",
     "SALC","SALAMANCA CITY",
     "SALT","SALAMANCA",
     "SDAY","SOUTH DAYTON",
     "SPRGVLL","SPRINGVILLE",
     "SVAL","SOUTH VALLEY",
     "VILL","VILLENOVA",
     "YORK","YORKSHIRE"
  });
}
	