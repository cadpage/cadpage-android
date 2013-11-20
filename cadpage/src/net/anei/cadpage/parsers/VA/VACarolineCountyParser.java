package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class VACarolineCountyParser extends DispatchB2Parser {
  
  private static final Pattern CALL_ADDR_PTN = Pattern.compile("(.* (?:ALPHA|BRAVO|CHARLIE?|DELTA)) +(.*)", Pattern.CASE_INSENSITIVE);
  
  public VACarolineCountyParser() {
    super("911-CENTER:",CITY_LIST, "CAROLINE COUNTY", "VA");
  }
  
 
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BOR")) data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
    return true;
  }

  @Override
  protected Pattern getCallPattern() {
    return CALL_ADDR_PTN;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // incorporated Towns
    "BOWLING GREEN",
    "PORT ROYAL",

// Unincorporated communities 
    "ACORS CORNER",
    "ANN WRIGHTS CORNER",
    "ANTIOCH FORK",
    "ATHENS ",
    "BAGBY ",
    "BAGDAD ",
    "BALTY",
    "BAYLORTOWN",
    "BLANTONS",
    "BOWERSVILLE",
    "BRANDYWINE",
    "BROADDUS ",
    "BROADUS CORNER",
    "BULLOCKS CORNER",
    "BURRUSS CORNER",
    "BUTLERS FORK",
    "CAMDEN",
    "CAMPBELL CORNER",
    "CAMPBELLS CORNER",
    "CAROLINE PINES",
    "CARTERS CORNER ",
    "CASH CORNER",
    "CEDAR FORK",
    "CEDON",
    "CENTRAL POINT",
    "CHANDLER CROSSING",
    "CHENAULTS SHOP ",
    "CHILESBURG ",
    "CHRISTOPHER FORK",
    "CLAIBORNE ",
    "COFFEY CORNER",
    "COLEMANS MILL CROSSING",
    "COLLINS CROSSING",
    "CORBIN",
    "COVINGSTON CORNER",
    "DALTONS",
    "DANIEL CORNER",
    "DAVIS CORNER",
    "DEJARNETTE",
    "DELOS ",
    "DOGGETTS FORK",
    "EDGAR ",
    "ELEVON ",
    "ETTA",
    "EUBANK CORNER",
    "FEATHERSTONE FORK",
    "FLIPPOS CORNER",
    "GETHER ",
    "GOLANSVILLE ",
    "GOLDMANS CORNER",
    "GUINEA ",
    "HALEYS CORNER",
    "HARD CORNER",
    "HART CORNER",
    "HAYMOUNT",
    "HAZELWOOD",
    "HICKORY FORK",
    "HICKS MILL",
    "HOUSTONS CORNER",
    "HOWARDS CORNER",
    "JONES CORNER",
    "KEMP CORNER ",
    "KIDDS FORK",
    "LADYSMITH",
    "LAURAVILLE",
    "LENT",
    "LIBERTY",
    "LIBERTY FORK",
    "LOCKS CORNER",
    "LONG BRANCH",
    "LORNE",
    "LOVING FORK",
    "MARTINS CORNER",
    "MARYTON",
    "MCBRYANT CORNER",
    "MCDUFF",
    "MICA ",
    "MILFORD",
    "MONCURE CORNER",
    "MONROE CORNER",
    "MOSS NECK",
    "NANCY WRIGHTS CORNER",
    "NAULAKLA ",
    "NEW LONDON",
    "OAK CORNER",
    "OLIVE",
    "OLNEY CORNER",
    "PAIGE ",
    "PATERSONS CORNER",
    "PEATROSS ",
    "PENNY CORNER",
    "PENOLA",
    "POORHOUSE CORNER",
    "POPLAR",
    "PORT ROYAL CROSS ROADS",
    "PORTOBAGO",
    "PULLERS CORNER",
    "RAINES CORNER",
    "RANGE CORNER",
    "RAPPAHANNOCK ACADEMY",
    "RAPPAHANNOCK CORNER",
    "RAYMONDS FORK",
    "REEDY MILL",
    "RIXEY",
    "RUTHER GLEN",
    "RYLAND CORNER",
    "SALES CORNER",
    "SAMUELS CORNER",
    "SHUMANSVILLE",
    "SIGNBOARD",
    "SKINKERS CORNER",
    "SMOOTS",
    "SORRELL",
    "SPARTA",
    "STUART CORNER",
    "SWANS CORNER",
    "TAYLORS CORNER ",
    "TIGNOR",
    "TRAVIS MILL",
    "UPPER ZION",
    "VALLEYVIEW CORNER",
    "VILLBORO ",
    "WALLERS CORNER",
    "WASHINGTON CORNER ",
    "WAVERLY ",
    "WELCHS",
    "WOODFORD",
    "WRIGHTS CORNER",
    "WRIGHTS FORK",
    "WRIGHTSVILLE",
    "YOUNG CORNER"
  };
}
