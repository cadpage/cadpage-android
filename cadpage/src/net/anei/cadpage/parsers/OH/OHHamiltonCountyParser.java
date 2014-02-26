package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OHHamiltonCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("HC:(.*?)(?: \\*\\*? (.*?) \\*\\*( .*?)??)?(?: (\\d{1,2}:\\d\\d)( .*)?)?");
  private static final Pattern APT_PTN = Pattern.compile("(.*?) +APT: *([^ ]+) +(.*)");
 
  public OHHamiltonCountyParser() {
    super(CITY_CODES, "HAMILTON COUNTY", "OH");
    setFieldList("ADDR CITY APT PLACE CALL INFO TIME UNIT X");
  }
  
  @Override
  public String getFilter() {
    return "hc@hamilton-co.org,9300,messaging@iamresponding.com,6245";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    String addr = match.group(1).trim();
    String call = match.group(2);
    String info = match.group(3);
    String time = match.group(4);
    String extra = match.group(5);
    
    // Old format had an asterisk delimited call field with a place
    // name in front of it and a info field behind.  There is another
    // call description in front of the address that duplicates the
    // asterisk delimited field so we just skip it
    if (call != null) {
      parseAddress(StartType.START_OTHER, addr, data);
      String sPlace = getLeft();
      if (sPlace.startsWith("APT ")) {
        Parser p = new Parser(sPlace.substring(4).trim());
        data.strApt = p.get(' ');
        sPlace = p.get();
      }
      data.strPlace = sPlace;
      data.strCall = call.trim();
      data.strSupp = getOptGroup(info);
      if (data.strSupp.startsWith("Original Location :")) data.strSupp = "";
    }
    
    // New format just has one field with a call description, address, and additional information
    else {
      
      // Sometimes the put an APT: label and field between the call and address
      // which makes things easier
      StartType st = StartType.START_CALL;
      int flags = FLAG_START_FLD_REQ;
      match = APT_PTN.matcher(addr);
      if (match.matches()) {
        st = StartType.START_ADDR;
        flags = 0;
        data.strCall = match.group(1);
        data.strApt = match.group(2);
        addr = match.group(3);
      }
      
      // otherwise we have to do this the hard way.
      
      parseAddress(st, flags, addr, data);
      info = getLeft();
      if (info.startsWith("LOC:")) {
        info = info.substring(4).trim();
        int pt = info.indexOf(" Original Location :");
        if (pt >= 0) info = info.substring(0,pt).trim();
        data.strPlace = info;
      } else {
        int pt = info.indexOf(" Original Location :");
        if (pt >= 0) {
          String place = info.substring(pt+20).trim();
          if (!data.strAddress.contains(place)) {
            data.strPlace = place;
          }
          info = info.substring(0,pt).trim();
        }
        data.strSupp = info;
      }
    }

    // Fix some Dispatch address typos
    data.strAddress = data.strAddress.replace("DE SOTO", "DESOTO");
    
    // Process time if present
    if (time  != null) data.strTime = time;

    // Process leftover stuff
    if (extra != null) {
      Parser p = new Parser(extra.trim());
      String x2 = p.getLastOptional(" XST2:");
      String x1 = p.getLastOptional(" XST:");
      data.strUnit = p.get();
      data.strCross = append(x1, " & ", x2);
    }
    
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
