package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.ReverseCodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CTWindhamCountyAParser extends SmartAddressParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("([ A-Za-z0-9]+?)  +");
  private static final Pattern CHANNEL_PTN = Pattern.compile("(UHF-\\d|\\d\\d\\.\\d\\d|\\d{3}|\\b(?:EKONK|KILLINGLY|UNION|THOMPSON) \\d{3}|HIGH-BAND) +");
  private static final Pattern PRIORITY_PTN = Pattern.compile("^PRI +(\\d) +");
  private static final Pattern TIME_PTN = Pattern.compile("\\d\\d:\\d\\d");
  private static final Pattern RESERVE_CALL_PTN = Pattern.compile(".*(?:CALL FROM|ALERT|ALARM|APPLIANCE FIRE|FALL INJURY|INJURED PERSON|LIFT ASSIST|VEHICLE ACCIDENT)\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|APARTMENT|ROOM|RM|UNIT|LOT)[- ]*(.*)|\\d{1,5}|[A-Z]|[A-Z]-?\\d{1,5}|.* (?:FLR|FLOOR)|WING .*", Pattern.CASE_INSENSITIVE);
      

  public CTWindhamCountyAParser() {
    super("WINDHAM COUNTY", "CT");
    setFieldList("SRC UNIT CH PRI CALL ADDR PLACE APT CITY X TIME");
    setupMultiWordStreets(MWORD_STREET_LIST);
    addRoadSuffixTerms("DRIVE");
    removeWords("BUS");
  }
  
  @Override
  public String getFilter() {
    return "qvecpaging@qvec.org,messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() != 0) {
      subject = stripFieldEnd(subject, " Page");
      data.strSource = subject;
    }
    
    Matcher  match = UNIT_PTN.matcher(body);
    if (!match.lookingAt()) return false;
    data.strUnit = match.group(1);
    body = body.substring(match.end());
    
    match = CHANNEL_PTN.matcher(body);
    if (match.lookingAt()) {
      data.strChannel = match.group(1);
      body = body.substring(match.end());
    }
    
    match = PRIORITY_PTN.matcher(body);
    if (match.lookingAt()) {
      data.strPriority = match.group(1);
      body = body.substring(match.end()).trim();
    }
    
    Parser p = new Parser(body);
    String sAddr = p.get("(X-STS ");
    data.strCross = p.get(')');
    String sTime = p.get();
    if (TIME_PTN.matcher(sTime).matches()) data.strTime = sTime;
    
    // New format > call * address * place city
    // old format > call address / place city
    sAddr = stripFieldStart(sAddr, "/");
    String sPlaceCity;
    String[] flds = sAddr.split(" \\* ");
    if (flds.length == 3) {
      data.strCall = flds[0].trim();
      parseAddress(flds[1].trim(), data);
      sPlaceCity = flds[2].trim();
    }
    
    else {
      int pt = sAddr.lastIndexOf(" / ");
      if (pt < 0) return false;
      sPlaceCity = sAddr.substring(pt+3).trim();
      sAddr = sAddr.substring(0,pt).trim();
      
      // There has been a problem with some call descriptions that contains things that look like
      // an address, so we try to identify and parser those out.
      String reserveCall = "";
      int flags = FLAG_START_FLD_REQ;
      match = RESERVE_CALL_PTN.matcher(sAddr);
      if (match.lookingAt()) {
        reserveCall = match.group();
        sAddr = sAddr.substring(match.end()).trim();
        flags = 0;
      }
      parseAddress(StartType.START_CALL, flags | FLAG_IGNORE_AT | FLAG_ANCHOR_END, sAddr, data);
      if (reserveCall.length() > 0 && data.strAddress.length() == 0) {
        parseAddress(data.strCall, data);
        data.strCall = "";
      }
      data.strCall = append(reserveCall, " ", data.strCall);
    }
    data.strCall = data.strCall.replaceAll("  +", " ");
    
    String city = CITY_SET.getCode(sPlaceCity.toUpperCase(), true);
    if (city != null) {
      int pt = sPlaceCity.length()-city.length();
      data.strCity = sPlaceCity.substring(pt);
      sPlaceCity = sPlaceCity.substring(0,pt).trim();
    }
    if (sPlaceCity.length() > 0) {
      
      // Intersections sometimes bleed into the place name :(
      if (checkAddress(data.strAddress) == STATUS_STREET_NAME) {
        Result res = parseAddress(StartType.START_ADDR, sPlaceCity);
        if (res.getStatus() == STATUS_STREET_NAME) {
          String tmp = data.strAddress;
          data.strAddress = "";
          res.getData(data);
          data.strAddress = append(tmp, " & ", data.strAddress);
          sPlaceCity = res.getLeft();
        }
      }
      match = APT_PTN.matcher(sPlaceCity);
      if (match.matches()) {
        String tmp = match.group(1);
        if (tmp == null) tmp = sPlaceCity;
        data.strApt = append(data.strApt, "-", tmp);
      } else {
        int pt = sPlaceCity.lastIndexOf('/');
        if (pt >= 0) {
          String tmp = sPlaceCity.substring(pt+1).trim();
          match = APT_PTN.matcher(tmp);
          if (match.matches()) {
            String tmp2 = match.group(1);
            if (tmp2 == null) tmp2 = tmp;
            data.strApt = append(data.strApt, "-", tmp2);
            sPlaceCity = sPlaceCity.substring(0,pt).trim();
          }
        }
        data.strPlace = sPlaceCity;
      }
    }
    return true;
  }
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "ALL HALLOWS",
    "ALLEN HILL",
    "ASHFORD CENTER",
    "BAILEY HILL",
    "BARBER HILL",
    "BARLOW CEMETERY",
    "BARTLETT MEADOW",
    "BEAVER DAM",
    "BLACK ROCK",
    "BLACKMER DOWNS",
    "BRAATEN HILL",
    "BRANDY HILL",
    "BREAKNECK HILL",
    "BREAULTS LANDING",
    "BUCK HILL",
    "BULL HILL",
    "BUNGAY HILL",
    "CAMP YANKEE",
    "CENTRE PIKE",
    "CHENEY MILL",
    "CHESTNUT HILL",
    "CHRISTIAN HILL",
    "CLEAR VIEW",
    "CONNECTICUT MILLS",
    "COOK HILL",
    "COTTON BRIDGE",
    "COUNTRY CLUB",
    "COUNTY HOME",
    "CRYSTAL POND",
    "DEER MEADOW",
    "DEWING SCHOOL",
    "DOG HILL",
    "ENGLISH NEIGHBORHOOD",
    "FABYAN WOODSTOCK",
    "FIRE TOWER",
    "FOUR SEASONS",
    "GENERAL LYON",
    "GRAND VIEW",
    "GREEN ACRES",
    "INDIAN SPRINGS",
    "KILLINGLY COMMONS",
    "LAKE VIEW",
    "LAUREL HILL",
    "LAUREL POINT",
    "LITTLE BUNGEE HILL",
    "LOUISA VIENS",
    "LOWELL DAVIS",
    "MARGARET HENRY",
    "MASON HILL",
    "MILL BRIDGE",
    "MOOSUP POND",
    "OLEAROS HILL",
    "PAINE DISTRICT",
    "PARENT HILL",
    "PINE CREST",
    "PLEASANT VIEW",
    "PORTER PLAIN",
    "PROVIDENCE PIKE BAILEY HILL",
    "QUADDICK MOUNTAIN",
    "QUADDICK TOWN FARM",
    "RILEY CHASE",
    "ROCKY HILL",
    "SAND DAM",
    "SAW MILL HILL",
    "SHEPARD HILL",
    "SNAKE MEADOW",
    "SPRAGUE HILL",
    "SPRING HILL",
    "STERLING HILL",
    "SUMNER HILL",
    "SUNSET HILL",
    "THOMPSON HILL",
    "TUCKER DISTRICT",
    "TUFT HILL",
    "VALLEY VIEW",
    "WHIP POOR WILL"
    
  };
  
  private static final ReverseCodeSet CITY_SET = new ReverseCodeSet(
      "ASHFORD",
      "BROOKLYN",
         "EAST BROOKLYN",
      "CANTERBURY",
      "CHAPLIN",
      "EASTFORD",
      "HAMPTON",
      "KILLINGLY",
         "DANIELSON",
      "PLAINFIELD",
         "CENTRAL VILLAGE",
         "MOOSUP",
         "PLAINFIELD VILLAGE",
         "WAUREGAN",
      "POMFRET",
      "PUTNAM",
         "PUTNAM DISTRICT",
      "SCOTLAND",
      "STERLING",
         "ONECO",
      "THOMPSON",
         "NORTH GROSVENOR DALE",
         "QUINEBAUG",
      "WINDHAM",
         "SOUTH WINDHAM",
         "WILLIMANTIC",
      "WOODSTOCK",
         "SOUTH WOODSTOCK",
      
      // New London County
      "LISBON"
  );
}
