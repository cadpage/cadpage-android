package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OHHamiltonCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("HC:(.*) \\*\\*? (.*?) \\*\\*( .*?)??(?: (\\d{1,2}:\\d\\d)( .*)?)?");
 
  public OHHamiltonCountyParser() {
    super(CITY_CODES, "HAMILTON COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "hc@hamilton-co.org,9300,messaging@iamresponding.com,6245";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(StartType.START_SKIP, match.group(1).trim(), data);
    data.strAddress = data.strAddress.replace("DE SOTO", "DESOTO");
    String sPlace = getLeft();
    if (sPlace.startsWith("APT ")) {
      Parser p = new Parser(sPlace.substring(4).trim());
      data.strApt = p.get(' ');
      sPlace = p.get();
    }
    data.strPlace = sPlace;
    data.strCall = match.group(2).trim();
    data.strSupp = getOptGroup(match.group(3));
    data.strTime = getOptGroup(match.group(4));
    Parser p = new Parser(getOptGroup(match.group(5)));
    String x2 = p.getLastOptional(" XST2:");
    String x1 = p.getLastOptional(" XST:");
    data.strUnit = p.get();
    data.strCross = append(x1, " & ", x2);
    
    return true;
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ADDY", "ADDYSTON",
      "AMBR", "AMBERLY VILLAGE",
      "ANDR", "ANDERSON TWP",
      "ARLN", "ARLINGTON HEIGHTS",
      "BLUE", "BLUE ASH",
      "CHEV", "CHEVIOT",
      "CLVS", "CLEVES",
      "COTP", "COLERAIN TWP",
      "COLM", "COLUMBIA TWP",
      "CROS", "CROSBY TWP",
      "DRPK", "DEER PARK",
      "DLHI", "DELHI TWP",
      "ELMW", "ELMWOOD PLACE",
      "EVEN", "EVENDALE",
      "FRFX", "FAIRFAX",
      "FRPK", "FOREST PARK",
      "GLEN", "GLENDALE",
      "GOLF", "GOLF MANOR",
      "GRTP", "GREEN TWP",
      "GREN", "GREENHILLS",
      "HRTP", "HARRISON TWP",
      "HARR", "HARRISON",
      "INDN", "INDIAN HILL",
      "LINC", "LINCOLN HEIGHTS",
      "LOCK", "LOCKLAND",
      "LOVE", "LOVELAND",
      "MDRA", "MADEIRA",
      "MRMT", "MARIEMONT",
      "MIAC", "MIAMI TWP",
      "MIAM", "MIAMI TWP",
      "MILF", "MILFORD",
      "MONT", "MONTGOMERY",
      "MTHL", "MOUNT HEALTHY",
      "NEWT", "NEWTOWN",
      "NORW", "NORWOOD",
      "NRBN", "NORTH BEND",
      "NCHL", "NORTH COLLEGE HILL",
      "READ", "READING",
      "SHRN", "SHARONVILLE",
      "SPDL", "SPRINGDALE",
      "SPTP", "SPRINGFIELD TWP",
      "STBN", "SAINT BERNARD",
      "SYCM", "SYCAMORE TWP",
      "SYMM", "SYMMES TWP",
      "TERR", "TERRACE PARK",
      "UNTC", "UNION TWP",
      "WWTR", "WHITEWATER TWP",
      "WOOD", "WOODLAWN",
      "WYOM", "WYOMING"
  });
}
