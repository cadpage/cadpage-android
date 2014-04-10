package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYSuffolkCountyAParser extends SmartAddressParser {

  private static final String[] KEYWORDS = new String[]{"TYPE", "LOC", "CROSS", "CODE", "TIME"};
  
  private static final Pattern APT_PTN = Pattern.compile("(.*)[: ](?:APT|ROOM|UNIT|STE) +#?([^ ]+)");
  private static final Pattern PLACE_MARK_PTN = Pattern.compile(": ?@|@|:|;");
  private static final Pattern ADDR_CROSS_PTN = Pattern.compile("(.*)[ :][SC]/S(?: ?=)?(.*)");
  private static final Pattern SPECIAL_PTN = Pattern.compile("(.*)(\\*\\*\\*_[_A-Z]+_\\*\\*\\*):?(.*)");
  
  public NYSuffolkCountyAParser() {
    super(CITY_TABLE, "SUFFOLK COUNTY", "NY");
    setFieldList("CALL ADDR CITY PLACE APT X CODE INFO TIME");
  }
  
  @Override
  public String getFilter() {
    return "paging@scfres.com,@communityamb.org,FRES CAD";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Anything starting with 3 asterisks is the similar but different (B) variant
    if (body.startsWith("***")) return false;

    // Some formats cut the initial TYPE: code
    if (body.startsWith("FWD:")) body = body.substring(4).trim();
    if (!body.startsWith("TYPE:")) body = "TYPE:" + body;

    Properties props = parseMessage(body, KEYWORDS);
    
    data.strCall = props.getProperty("TYPE");
    if (data.strCall == null) return false;

    data.strCross = stripFieldEnd(props.getProperty("CROSS", ""), "/");;
    
    String sAddress = props.getProperty("LOC");
    if (sAddress == null) {
      if (data.strCross.length() == 0) return false;
      parseAddress(data.strCross, data);
      data.strCross = "";
    } else {
      Matcher match = APT_PTN.matcher(sAddress);
      if (match.matches()) {
        sAddress = match.group(1).trim();
        data.strApt = match.group(2).trim();
      }
      
      match = ADDR_CROSS_PTN.matcher(sAddress);
      if (match.matches()) {
        sAddress = match.group(1).trim();
        data.strCross = append(match.group(2).trim(), " / ", data.strCross);
      }
      
      match = SPECIAL_PTN.matcher(sAddress);
      if (match.matches()) {
        sAddress = match.group(1).trim();
        data.strSupp = append(match.group(2).trim(), "\n", match.group(3).trim());
      }

      String[] addrFlds = PLACE_MARK_PTN.split(sAddress, 3);
      if (addrFlds.length > 1) {
        sAddress = addrFlds[0].trim();
        String place = addrFlds[1].trim();
        if (NUMERIC.matcher(place).matches()) {
          data.strApt = append(place, "-", data.strApt);
        } else {
          data.strPlace = place;
        }
        if (addrFlds.length > 2) data.strSupp = append(data.strSupp, "\n", addrFlds[2].trim());
        match = APT_PTN.matcher(sAddress);
        if (match.matches()) {
          sAddress = match.group(1).trim();
          data.strApt = append(match.group(2).trim(), "-", data.strApt);
        }
      }
      parseAddress(StartType.START_ADDR, sAddress, data);
      data.strPlace = append(getLeft(), " - ", data.strPlace);
    }
    
    data.strCode = props.getProperty("CODE", "");
    if (data.strCode.equals("default")) data.strCode = "";
    
    data.strCity = convertCodes(data.strCity, CITY_TABLE);
    String sTime = props.getProperty("TIME", "");
    if (sTime.length() > 5 && sTime.length() < 8) sTime = sTime.substring(0,5);
    if (sTime.length() >= 5) data.strTime = sTime;
    
    return true;
  }

  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "AMAGAN",  "AMAGANSETT",
      "AMITYV",  "AMITYVILLE",
      "AQUEBO",  "AQUEBOGUE",
      "ASHARO",  "ASHAROKEN",
      "ATLANT",  "ATLANTIQUE",
      "BABYLO",  "BABYLON",
      "BAITIH",  "BAITING HOLLOW",
      "BARRET",  "BARRET HOLLOW",
      "BAYPOR",  "BAYPORT",
      "BAYSHO",  "BAY SHORE",
      "BAYVIL",  "BAYVILLE",
      "BAYWOO",  "BAYWOOD",
      "BELLET",  "BELLE TERRE",
      "BELLMO",  "BELLMORE",
      "BELLPO",  "BELLPORT",
      "BETHPA",  "BETHPAGE",
      "BLUEPB",  "BLUE POINT BEACH",
      "BLUEPO",  "BLUE POINT",
      "BOHEMI",  "BOHEMIA",
      "BRENTW",  "BRENTWOOD",
      "BRIDGE",  "BRIDGEHAMPTON",
      "BRIGHT",  "BRIGHTWATERS",
      "BROOKH",  "BROOKHAVEN",
      "CALVER",  "CALVERTON",
      "CAPTRE",  "CAPTREE",
      "CENTEM",  "CENTER MORICHES",
      "CENTPO",  "CENTERPORT",
      "CENTRE",  "CENTEREACH",
      "CENTRI",  "CENTRAL ISLIP",
      "CHERRG",  "CHERRY GROVE",
      "COLDSH",  "COLD SPRING HARBOR",
      "COMMAC",  "COMMACK",
      "COPIAG",  "COPIAGUE",
      "CORAM",   "CORAM",
      "CORNEE",  "CORNEILLE ESTATES",
      "CUTCHO",  "CUTCHOGUE",
      "DAVISP",  "DAVIS PARK",
      "DEERPA",  "DEER PARK",
      "DERINH",  "DERING HARBOR",
      "DIXHIL",  "DIX HILLS",
      "DUNEWO",  "DUNEWOOD",
      "EASTPO",  "EASTPORT",
      "EATONN",  "EATONS  NECK",
      "EFARMI",  "EAST FARMINGDALE",
      "EFIREI",  "EAST FIRE ISLAND",
      "EHAMPT",  "EAST HAMPTON",
      "EHAMPV",  "EAST HAMPTION VILLAGE",
      "EISLIP",  "EAST ISLIP",
      "ELWOOD",  "ELWOOD",
      "EMARIO",  "EAST MARION",
      "EMORIC",  "EAST MORICHES",
      "ENORTH",  "EAST NORTHPORT",
      "EPATCH",  "EAST PATCHOGUE",
      "EQUOGU",  "EAST QUOGUE",
      "ESHORE",  "EAST SHOREHAM",
      "FAIRHA",  "FAIR HARBOR",
      "FARMDA",  "FARMINGDALE",
      "FARMVI",  "FARMINGVILLE",
      "FINS",    "FI NATIONAL SEASHORE",
      "FIREIP",  "FIRE ISLAND PINES",
      "FISHEI",  "FISHER ISLAND",
      "FLANDE",  "FLANDERS",
      "FORTSA",  "FORT SALONGA",
      "GARDII",  "GARDINERS ISLAND",
      "GILGOB",  "GILGO BEACH",
      "GORDOH",  "GORDON HEIGHTS",
      "GRANGI",  "GRAND GULL ISLAND",
      "GREATR",  "GREAT RIVER",
      "GREENL",  "GREENLAWN",
      "GREENP",  "GREENPORT",
      "GREENW",  "GREENPORT WEST",
      "HALESI",  "HALESITE",
      "HAMPTB",  "HAMPTON BAYS",
      "HAUPPA",  "HAUPPAUGE",
      "HEADHA",  "HEAD OF THE HARBOR",
      "HICKSV",  "HICKSVILLE",
      "HOLBRO",  "HOLBROOK",
      "HOLTSV",  "HOLTSVILLE",
      "HUNTIB",  "HUNTINGTON BAY",
      "HUNTIN",  "HUNTINGTON",
      "HUNTIS",  "HUNTINGTON STATION",
      "ISLAND",  "ISLANDIA",
      "ISLIP",   "ISLIP",
      "ISLIPT",  "ISLIP TERRACE",
      "JAMESP",  "JAMESPORT",
      "JONESB",  "JONES BEACH",
      "KINGPP",  "KINGS PARK PSYCHIATRIC",
      "KINGSP",  "KINGS PARK",
      "KISMET",  "KISMET",
      "LAKEGR",  "LAKE GROVE",
      "LAKERO",  "LAKE RONKONKOMA",
      "LAUREL",  "LAUREL HOLLOW",
      "LEVITT",  "LEVIGTTOWN",
      "LINDEN",  "LINDENHURST",
      "LITTGI",  "LITTLE GULL ISLAND",
      "LLOYDH",  "LLOYD HARBOR",
      "LONELY",  "LONELYVILLE",
      "MANORV",  "MANORVILLE",
      "MASSAP",  "MASSAPEQUA",
      "MASSPA",  "MASSAPEQUA PARK",
      "MASTIB",  "MASTIC BEACH",
      "MASTIC",  "MASTIC",
      "MATTIT",  "MATTITUCK",
      "MEDFOR",  "MEDFORD",
      "MELVIL",  "MELVILLE",
      "MIDDLI",  "MIDDLE ISLAND",
      "MILLEP",  "MILLER PLACE",
      "MILLNE",  "MILL NECK",
      "MONTAU",  "MO NTAUK",
      "MORICH",  "MORICHES",
      "MOUNTS",  "MT SINAI",
      "NAMITY",  "NORTH AMITYVILLE",
      "NAPEAG",  "NAPEAGUE",
      "NBABYL",  "NORTH BABYLON",
      "NBAYSH",  "NORTH BAY SHORE",
      "NBELLP",  "NORTH BELLPORT",
      "NESCON",  "NESCONSET",
      "NEWSUF",  "NEW SUFFOLK",
      "NGREAR",  "NORTH GREAT RIVER",
      "NHAVEN",  "NORTH HAVEN",
      "NISSEQQ",  "NISSEQUOGUE",
      "NLINDE",  "NORTH LINDENHURST",
      "NORTHP",  "NORTHPORT",
      "NORTHV",  "NORTHVILLE",
      "NORTVH",  "NORTHPORT VA",
      "NOYACK",  "NOYACK",
      "NPATCH",  "NORTH PATCHOGUE",
      "NSEA",    "NORTH SEA",
      "NWHARB",  "NORTH WEST HARBOR",
      "OAKBEA",  "OAK BEACH",
      "OAKDAL",  "OAKDALE",
      "OAKISL",  "OAK ISLAND",
      "OAKLEY",  "OAKLEYVILLE",
      "OCEABE",  "OCEAN BEACH",
      "OCEABP",  "OCEAN BAY PARK",
      "OCEANR",  "OCEAN RIDGE",
      "OLDBET",  "OLD BETHPAGE",
      "OLDFIE",  "OLD FIELD",
      "ORIENT",  "ORIENT",
      "OYSTERB",  "OYSTER BAY",
      "PATCHO",  "PATCHOGUE",
      "PECONI",  "PECONIC",
      "PILGRP",  "PILGRIM PSYCHIATRIC",
      "PLAINV",  "PLAINVIEW",
      "PLUMIS",  "PLUM ISLAND",
      "POINTO",  "POINT O’WOODS",
      "POOSIR",  "POOSPATUCK INDIAN RESERVATION",
      "POQUOT",  "POQUOTT",
      "PORTJE",  "PORT JEFFERSON",
      "PORTJS",  "PORT JEFFERSON STATION",
      "QUIOGU",  "QUIOGUE",
      "QUOGUE",  "QUOGUE",
      "REMSEN",  "REMSENBERG-SPEONK",
      "RIDGE",   "RIDGE",
      "RIVERH",  "RIVERHEAD",
      "RIVERS",  "RIVERSIDE",
      "ROBBII",  "ROBBINS ISLAND",
      "ROBBIR",  "ROBBINS REST",
      "ROBERM",  "ROBERT MOSES PARK",
      "ROCKYP",  "ROCKY POINT",
      "RONKON",  "RONKONKOMA",
      "SAGAPO",  "SAGAPONACK",
      "SAHGAR",  "SAG HARBOR",
      "SAILOH",  "SAILORS HAVEN",
      "SAINTJ",  "ST JAMES",
      "SALTAI",  "SALTAIRE",
      "SAYVIL",  "SAYVILLE",
      "SEAFOR",  "SEAFORD",
      "SEAVIE",  "SEAVIEW",
      "SELDEN",  "SELDEN",
      "SETAES",  "SETAKET-EAST SETAUKET",
      "SHELIH",  "SHELTHER ISLAND HEIGHTS",
      "SHELTI",  "SHELTER ISLAND",
      "SHINIR",  "SHINNECOCK INDIAN RESERVATION",
      "SHINNH",  "SHINNECOCK HILLS",
      "SHIRLE",  "SHIRLEY",
      "SHOREH",  "SHOREHAM",
      "SHUNTI",  "SOUTH HUNTINGTON",
      "SMITHP",  "SMITH POINT",
      "SMITHT",  "SMITHTOWN",
      "SOUNDB",  "SOUND BEACH",
      "SOUTHA",  "SOUTHAMPTON",
      "SOUTHO",  "SOUTHOLD",
      "SOUTHV",  "SOUTHAMPTON VILLAGE",
      "SPRING",  "SPRINGS",
      "STONYB",  "STONY BROOK",
      "SUFFDC",  "SUFFOLK DEVELOPMENTAL CENTER",
      "SUNKEF",  "SUNKEN FOREST",
      "SUNYFA",  "SUNY FARMINGDALE",
      "SUNYSB",  "SUNY STONY BROOK",
      "SYOSSE",  "SYOSSET",
      "TALISM",  "TALISMAN",
      "TERRYV",  "TERRYVILLE",
      "TOBAY",  "TOBAY",
      "UPTON",  "UPTON",
      "USCGST",  "US COAST GUARD STATION",
      "VILLAB",  "VILLAGE OF THE BRANCH",
      "WADINR",  "WADING RIVER",
      "WAINSC",  "WAINSCOTT",
      "WANTAG",  "WANTAGH",
      "WATCHH",  "WATCH HILL",
      "WATERI",  "WATER ISLAND",
      "WATERM",  "WATER MILL",
      "WBABYL",  "WEST BABYLON",
      "WBAYSH",  "WEST BAY SHORE",
      "WFIREI",  "WEST FIRE ISLAND",
      "WHAMPB",  "WESTHAMPTON BEACH",
      "WHAMPD",  "WESTHAMPTON DUNES",
      "WHAMPT",  "WESTHAMPTON",
      "WHEATH",  "WHEATLEY HEIGHTS",
      "WHILLS",  "WEST HILLS",
      "WISLIP",  "WEST ISLIP",
      "WOODBU",  "WOODBURY",
      "WSAYVI",  "WEST SAYVILLE",
      "WYANDA",  "WYANDANCH",
      "YAPHAN",  "YAPHANK"

  });
}
