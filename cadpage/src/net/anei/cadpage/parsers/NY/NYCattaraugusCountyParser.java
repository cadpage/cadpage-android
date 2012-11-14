package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYCattaraugusCountyParser extends FieldProgramParser {
  
  private static Pattern TRAIL_COMMA_PAT = Pattern.compile("[ ,]+$");
  private static Pattern LOCATION_PAT = Pattern.compile(".* COUNTY", Pattern.CASE_INSENSITIVE);
  
  private String address;
  
  public NYCattaraugusCountyParser() {
    super(CITY_CODES, "CATTARAUGUS COUNTY", "NY",
           "Unit:UNIT! Loc:ADDR! Between:X! CN:PLACE CTV:CITY Type:CALL Date:SKIP Time:SKIP Info:INFO Caller:NAME Inc:ID%");
  }
  
  @Override
  public String getFilter() {
    return "911@cattco.org,777,888";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
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
    return true;
  }
  
  // Address field just remembers the address field
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      address = field;
      super.parse(field, data);
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

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
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
	