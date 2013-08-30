package net.anei.cadpage.parsers.ZNZ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class ZNZNewZealandParser extends SmartAddressParser {

  private static final Pattern END_PAGE_BREAK = Pattern.compile("#F\\d+(?=\n)");
  private static final Pattern MASTER =
      Pattern.compile("\\(([A-Z0-9, ]+)\\) *([A-Z0-9]+-[A-Z]+) (?:\\((Alarm Type [-A-Z0-9/ ]+)\\) *)?(?:\\(Box ([-A-Z0-9 &]+)\\) *)?(?:(AK\\d+ .*? > [A-Z]+\\)) +(?:AK\\d+ +)?)?([-A-Za-z0-9\\(\\)\\?\\\\ ]+?) *\\. +(?:([- A-Z0-9:]+)\\. +)?(?:((?:NEAR|OFF) [- A-Z0-9\\?]+)\\. *)?(?:\\(XStr +([-A-Z0-9/ ]*)\\) *)?(?:\\.([-A-Z0-9@,\\? /\\.:]+)\\. *)?(?:\\(x-(\\d+) y-(\\d+)\\) *)?#(F\\d+)");
  private static final Pattern UNKNNNNN = Pattern.compile("\\bUNKN\\d{4}\\b");
  private static final Pattern DOUBLED_ADDRESS = Pattern.compile("(\\d+) .* (\\1\\b.*)");

  public ZNZNewZealandParser() {
    super(CITY_LIST, "", "", CountryCode.NZ);
    setupMultiWordStreets(
        "GREAT NORTH"
    );
    setFieldList("UNIT CODE BOX PLACE ADDR APT CITY X CALL GPS ID");
  }
  
  @Override
  public String getFilter() {
    return "silv@vodafone.co.nz,pager@firehouse.co.nz";
  }

  @Override
  public String getLocName() {
    return "New Zealand";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() > 0) body = '(' + subject + ") " + body;
    Matcher match = END_PAGE_BREAK.matcher(body);
    if (match.find()) body = body.substring(0,match.end());
    body = body.replace('\n', ' ');
    match = MASTER.matcher(body);
    if (!match.matches()) return false;

    int ndx = 1;
    data.strUnit = match.group(ndx++).trim();
    data.strCode = match.group(ndx++).trim();
    data.strCall = getOptGroup(match.group(ndx++));
    data.strBox = getOptGroup(match.group(ndx++));
    data.strPlace = getOptGroup(match.group(ndx++));
    String sAddr = match.group(ndx++).trim();
    sAddr = UNKNNNNN.matcher(sAddr).replaceAll("@");
    StartType st = (data.strPlace.length() > 0 ? StartType.START_ADDR : StartType.START_PLACE);
    parseAddress(st, FLAG_ANCHOR_END, sAddr, data);
    String tmp = match.group(ndx++);
    if (tmp != null && !tmp.startsWith("CNR ")) {
      if (tmp.startsWith("RP:")) {
        data.strApt = append(data.strApt, "-", tmp.substring(3).trim());
      } else {
        data.strPlace = append(data.strPlace, " ", tmp.trim());
      }
    }
    data.strPlace = append(data.strPlace, " ", getOptGroup(match.group(ndx++)));
    String cross = getOptGroup(match.group(ndx++));
    if (cross.endsWith("/")) cross = cross.substring(0,cross.length()-1).trim();
    data.strCross = cross;
    data.strCall = append(data.strCall, " / ", getOptGroup(match.group(ndx++)));
    String x = match.group(ndx++);
    String y = match.group(ndx++);
    if (x != null) data.strGPSLoc = INT2WGS84(Double.parseDouble(x), Double.parseDouble(y));
    data.strCallId = match.group(ndx++);
    
    // Sometimes an intersection is reported as a cross street. 
    if (data.strAddress.length() == 0) {
      parseAddress(data.strCross, data);
      data.strCross = "";
    }
    
    // See if we can eliminate doubled addresses
    match = DOUBLED_ADDRESS.matcher(data.strAddress);
    if (match.matches()) data.strAddress = match.group(2);
    
    return true;
  }
  

  /**
   * Convert Intergraph x/y coordinates to WGS84 lat/long string
   *
   * Intergraph uses a XY coordinate that is easily converted into NZTM.
   * The real work here is converting NZTM into a lat/lon value.
   * Math from http://www.linz.govt.nz/geodetic/conversion-coordinates/projection-conversions/transverse-mercator-preliminary-computations
   * @param xcoord the Intergraph X value (like 372512333)
   * @param ycoord the Intergraph Y value (like 238469543)
   * @return String containing a GPS pair like "-34.00,179.23"
   */
  static String INT2WGS84(double xcoord, double ycoord) {
  
    // Convert Intergraph format into NZTM (New Zealand Transverse Mercator)
    double e=(2147483647d-xcoord)/1000;
    double n=(6147483647d-ycoord)/1000;
    
    // For testing purposes, E=1808171 and N=5588209 should result in lat/lon ~ (-39.83063056,175.43261389)
    // FWIW, these are not the actual results, which doesn't sound very promising
    
    // double e=1808171; 
    // double n=5588209;
    
    double n_=n-N0;
    double e_=e-E0;
    double m_=M0+n_/K0;
    double sigma=(m_*Math.PI)/(180*G);
    double phi_=sigma+((3*NN/2)-(27*Math.pow(NN,3)/32))*Math.sin(2*sigma)+((21*Math.pow(NN,2)/16)-(55*Math.pow(NN,4)/32))*Math.sin(4*sigma)+(151*Math.pow(NN,3)/96)*Math.sin(6*sigma)+(1097*Math.pow(NN,4)/512)*Math.sin(8*sigma);
    double rho_=(A*(1-E_SQUARED))/Math.pow((1-(E_SQUARED*Math.pow(Math.sin(phi_),2))),(3/2));
    double nu_=A/Math.sqrt(1-(E_SQUARED*Math.pow(Math.sin(phi_),2)));
    double psi_=nu_/rho_;
    double t_=Math.tan(phi_);
    double x=e_/(K0*nu_);
    
    // Calculate latitude
    double t1=(t_*e_*x)/(K0*rho_*2);
    double t2=((t_*e_*Math.pow(x,3))/(K0*rho_*24))*((-4*Math.pow(psi_,2))+(9*psi_*(1-Math.pow(t_,2)))+(12*Math.pow(t_,2)));
    double t3=((t_*e_*Math.pow(x,5))/(K0*rho_*720))*((8*Math.pow(psi_,4)*(11-(24*Math.pow(t_,2))))-(12*Math.pow(psi_,3)*(21-71*Math.pow(t_,2)))+(15*Math.pow(psi_,2)*(15-98*Math.pow(t_,2)+15*Math.pow(t_,4)))+(180*psi_*(5*Math.pow(t_,2)-3*Math.pow(t_,4)))+(360*Math.pow(t_,4)));
    double t4=((t_*e_*Math.pow(x,7))/(K0*rho_*40320))*(1385-3633*Math.pow(t_,2)+4095*Math.pow(t_,4)+1575*Math.pow(t_,6));
    double lat=(180/Math.PI)*(phi_-t1+t2-t3+t4);
    
    // Calculate longitude
    t1=x*(1d/Math.cos(phi_));
    t2=((Math.pow(x,3)*(1d/Math.cos(phi_)))/6)*(phi_+2*Math.pow(t_,2));
    t3=((Math.pow(x,5)*(1d/Math.cos(phi_)))/120)*((-4*Math.pow(psi_,3)*(1-6*Math.pow(t_,2)))+(Math.pow(psi_,2)*(9-68*Math.pow(t_,2)))+(72*psi_*Math.pow(t_,2))+(24*Math.pow(t_,4)));
    t4=((Math.pow(x,7)*(1d/Math.cos(phi_)))/5040)*(61+662*Math.pow(t_,2)+1320*Math.pow(t_,4)+720*Math.pow(t_,6));
    double lon=(180/Math.PI)*(l0+t1-t2+t3-t4);
    
    // And convert the result to a GPS string
    return String.format("%+8.6f,%+8.6f", lat, lon);
  }
  
  // Build projection constants
  private static final double K0=0.9996;       // Scale
  private static final double A=6378137;       // Semimajor axis
  private static final double F=(1/298.257222101d);  // Flattening
  private static final double N0=10000000;       // False Northing
  private static final double E0=1600000;        // False Easting
  private static final double l0=173*(Math.PI/180);  // Origin longitude 173 degrees... I found this emperically
  private static final double B=A*(1-F);
  private static final double E_SQUARED=(2*F)-Math.pow(F,2);
  private static final double NN=(A-B)/(A+B);
  private static final double G=A*(1-NN)*(1-Math.pow(NN,2))*(1+(9*Math.pow(NN,2)/4)+(225*Math.pow(NN,4)/64))*(Math.PI/180);
  
  /* The following is not necessary since phi0 (origin latitude) is zero.  We just set m0=0 instead.  
  double A0=1-(e_squared/4)-(3*Math.pow(e_squared,2)/64)-(5*Math.pow(e_squared,4)/256);
  double A2=(3/8)*(e_squared+(Math.pow(e_squared,2)/4)+(15*Math.pow(e_squared,4)/128));
  double A4=(15/256)*(Math.pow(e_squared,2)+(3*Math.pow(e_squared,4)/4));
  double A6=35*Math.pow(e_squared,4)/3072;
  */
  private static final double M0=0;
  


  private static final String[] CITY_LIST = new String[]{
    
    // Towns of new Zealand
    "AHAURA",
    "AHIPARA",
    "AHITITI",
    "AHUROA",
    "AKAROA",
    "AKITIO",
    "ALBANY",
    "ALBERT TOWN",
    "ALBURY",
    "ALEXANDRA",
    "ALLANTON",
    "AMBERLEY",
    "ANAKIWA",
    "ARANGA",
    "ARAMOANA",
    "ARAPOHUE",
    "ARMY BAY",
    "ARROWTOWN",
    "ARUNDEL",
    "ASHBURTON",
    "ASHHURST",
    "ASHLEY",
    "AUCKLAND",
    "AUROA",
    "AWANUI",
    "BALCLUTHA",
    "BALFOUR",
    "BARRYTOWN",
    "BEACHLANDS",
    "BEAUMONT",
    "BELL BLOCK",
    "BENHAR",
    "BENNEYDALE",
    "BLACKBALL",
    "BLENHEIM",
    "BLUFF",
    "BRIGHTON",
    "BRIGHTWATER",
    "BROADWOOD",
    "BULLS",
    "BUNNYTHORPE",
    "CAMBRIDGE",
    "CANVASTOWN",
    "CARTERTON",
    "CHEVIOT",
    "CHRISTCHURCH",
    "CLARKSVILLE",
    "CLINTON",
    "CLIVE",
    "CLYDE",
    "COATESVILLE",
    "COLLINGWOOD",
    "COLVILLE",
    "COROGLEN",
    "COROMANDEL",
    "CROMWELL",
    "CULVERDEN",
    "CUST",
    "DAIRY FLAT",
    "DANNEVIRKE",
    "DARFIELD",
    "DARGAVILLE",
    "DOBSON",
    "DRURY",
    "DUNEDIN",
    "DUNTROON",
    "EASTBOURNE",
    "EDENDALE",
    "EDGECUMBE",
    "EGMONT VILLAGE",
    "EKETAHUNA",
    "ELTHAM",
    "ETTRICK",
    "FAIRHALL",
    "FAIRLIE",
    "FEATHERSTON",
    "FEILDING",
    "FLAXMERE",
    "FOX GLACIER",
    "FOXTON",
    "FOXTON BEACH",
    "FRANKTON",
    "FRANKTON",
    "FRANZ JOSEF",
    "GERALDINE",
    "GISBORNE",
    "GLENORCHY",
    "GORE",
    "GRANITY",
    "GREYMOUTH",
    "GREYTOWN",
    "GROVETOWN",
    "GULF HARBOUR",
    "HAAST",
    "HAKATARAMEA",
    "HALCOMBE",
    "HAMILTON",
    "HAMPDEN",
    "HANMER SPRINGS",
    "HARI HARI",
    "HASTINGS",
    "HAUPIRI",
    "HAVELOCK",
    "HAVELOCK NORTH",
    "HAWEA",
    "HAWERA",
    "HELENSVILLE",
    "HENLEY",
    "HERBERT",
    "HEREKINO",
    "HIKUAI",
    "HIKURANGI",
    "HIKUTAIA",
    "HINUERA",
    "HOKITIKA",
    "HOPE",
    "HOREKE",
    "HOUHORA",
    "HOWICK",
    "HUAPAI",
    "HUIAKAMA",
    "HUIRANGI",
    "HUKERENUI",
    "HUNTERVILLE",
    "HUNTLY",
    "HURLEYVILLE",
    "INANGAHUA JUNCTION",
    "INGLEWOOD",
    "INVERCARGILL",
    "JACOBS RIVER",
    "KAIAPOI",
    "KAIHU",
    "KAIKOHE",
    "KAIKOURA",
    "KAIMATA",
    "KAINGAROA",
    "KAKANUI",
    "KAIPARA FLATS",
    "KAITAIA",
    "KAITANGATA",
    "KAIWAKA",
    "KAKARAMEA",
    "KANIERE",
    "KAPONGA",
    "KARAMEA",
    "KARETU",
    "KARITANE",
    "KATIKATI",
    "KAUKAPAKAPA",
    "KAURI",
    "KAWAKAWA",
    "KAWERAU",
    "KENNEDY BAY",
    "KERIKERI",
    "KIHIKIHI",
    "KINLOCH",
    "KINGSTON",
    "KOKATAHI",
    "KOKOPU",
    "KOROMIKO",
    "KUMARA",
    "KUMEU",
    "KUROW",
    "LAWRENCE",
    "LEESTON",
    "LEIGH",
    "LEPPERTON",
    "LEVIN",
    "LINCOLN",
    "LINKWATER",
    "LITTLE RIVER",
    "LOWER HUTT",
    "LUGGATE",
    "LUMSDEN",
    "LYTTELTON",
    "MAKAHU",
    "MANAIA",
    "MANAIA",
    "MANAKAU",
    "MANAPOURI",
    "MANGAKINO",
    "MANGAMUKA",
    "MANGATOKI",
    "MANGAWHAI",
    "MANLY",
    "MANUKAU",
    "MANUREWA",
    "MANUTAHI",
    "MAPUA",
    "MARAETAI",
    "MARCO",
    "MAROMAKU",
    "MARSDEN BAY",
    "MARTINBOROUGH",
    "MARTON",
    "MARUIA",
    "MASTERTON",
    "MATAKANA",
    "MATAKOHE",
    "MATAMATA",
    "MATAPU",
    "MATARANGI",
    "MATARAU",
    "MATATA",
    "MATAURA",
    "MATIHETIHE",
    "MAUNGAKARAMEA",
    "MAUNGATAPERE",
    "MAUNGATUROTO",
    "MAYFIELD",
    "MEREMERE",
    "METHVEN",
    "MIDDLEMARCH",
    "MIDHIRST",
    "MILLERS FLAT",
    "MILTON",
    "MIMI",
    "MOANA",
    "MOENUI",
    "MOERAKI",
    "MOEREWA",
    "MOKAU",
    "MOKOIA",
    "MORRINSVILLE",
    "MOSGIEL",
    "MOSSBURN",
    "MOTATAU",
    "MOTUEKA",
    "MOUNT MAUNGANUI",
    "MOUNT SOMERS",
    "MURCHISON",
    "MURUPARA",
    "NAPIER",
    "NASEBY",
    "NELSON",
    "NEW BRIGHTON",
    "NEW PLYMOUTH",
    "NORMANBY",
    "NGAERE",
    "NGAMATAPOURI",
    "NGAPARA",
    "NGARUAWAHIA",
    "NGATAKI",
    "NGONGOTAHA",
    "NGUNGURU",
    "NIGHTCAPS",
    "NORFOLK",
    "OAKURA",
    "OAMARU",
    "OBAN",
    "OHAKUNE",
    "OHAEAWAI",
    "OHANGAI",
    "OHOKA",
    "OHOPE BEACH",
    "OHURA",
    "OKAIHAU",
    "OKATO",
    "OMANAIA",
    "OMARAMA",
    "OMATA",
    "OMOKOROA",
    "ONEWHERO",
    "OPONONI",
    "OPOTIKI",
    "OPUA",
    "OPUNAKE",
    "ORATIA",
    "OREWA",
    "OROMAHOE",
    "ORUAITI",
    "OTAIKA",
    "OTAKI",
    "OTAKOU",
    "OTAUTAU",
    "OTIRIA",
    "OTOROHANGA",
    "OWAKA",
    "OXFORD",
    "PAPARORE",
    "PAEKAKARIKI",
    "PAEROA",
    "PAHIATUA",
    "PAIHIA",
    "PAKARAKA",
    "PAKIRI",
    "PAKOTAI",
    "PALMERSTON",
    "PALMERSTON NORTH",
    "PAMAPURIA",
    "PANGURU",
    "PAPAKURA",
    "PAPAMOA",
    "PAPAROA",
    "PAPATOETOE",
    "PARAKAI",
    "PARAPARAUMU",
    "PAREMOREMO",
    "PAREORA",
    "PAROA",
    "PARUA BAY",
    "PATEA",
    "PAUANUI",
    "PAUATAHANUI",
    "PEKA PEKA",
    "PEMBROKE",
    "PERIA",
    "PETONE",
    "PICTON",
    "PIOPIO",
    "PIPIWAI",
    "PIRONGIA",
    "PLEASANT POINT",
    "PLIMMERTON",
    "PORIRUA",
    "PORTLAND",
    "POROTI",
    "PORT CHALMERS",
    "PORTOBELLO",
    "PUKEKOHE",
    "PUKERUA BAY",
    "PUKEURI",
    "PUKEPOTO",
    "PURUA",
    "PUTARURU",
    "QUEENSTOWN",
    "RAETIHI",
    "RAGLAN",
    "RAHOTU",
    "RAI VALLEY",
    "RAMARAMA",
    "RANFURLY",
    "RANGIORA",
    "RAPAURA",
    "RATAPIKO",
    "RAUMATI",
    "RAWENE",
    "RAWHITIROA",
    "REEFTON",
    "RENWICK",
    "RICHMOND",
    "RIVERHEAD",
    "RIVERLANDS",
    "RIVERSDALE BEACH",
    "RIVERTON",
    "RIWAKA",
    "ROLLESTON",
    "ROSS",
    "ROTORUA",
    "ROXBURGH",
    "RUATORIA",
    "RUAWAI",
    "RUNANGA",
    "RUSSELL",
    "SAINT ANDREWS CANTERBURY",
    "SAINT ARNAUD",
    "SAINT BATHANS",
    "SANSON",
    "SEACLIFF",
    "SEDDON",
    "SEDDONVILLE",
    "SHEFFIELD",
    "SHANNON",
    "SILVERDALE",
    "SNELLS BEACH",
    "SPRINGFIELD",
    "SPRINGSTON",
    "SPRING CREEK",
    "STANMORE BAY",
    "STIRLING",
    "STRATFORD",
    "TAHAROA",
    "TAIERI MOUTH",
    "TAIHAPE",
    "TAIPA-MANGONUI",
    "TAIRUA",
    "TAKAKA",
    "TANGITERORIA",
    "TAPANUI",
    "TAPU",
    "TANGOWAHINE",
    "TAPAWERA",
    "TAPORA",
    "TARADALE",
    "TAUHOA",
    "TAUMARUNUI",
    "TAUPAKI",
    "TAUPO",
    "TAURANGA",
    "TAURAROA",
    "TAUTORO",
    "TE ANAU",
    "TE ARAI",
    "TE AROHA",
    "TE AWAMUTU",
    "TE HAPUA",
    "TE HORO",
    "TE KAO",
    "TE KOPURU",
    "TE KUITI",
    "TE POI",
    "TE PUKE",
    "TE PURU",
    "TEMUKA",
    "TE RERENGA",
    "THAMES",
    "TIKORANGI",
    "TIMARU",
    "TINOPAI",
    "TINWALD",
    "TIRAU",
    "TITOKI",
    "TOKARAHI",
    "TOKO",
    "TOKANUI",
    "TOKOROA",
    "TOLAGA BAY",
    "TOMARATA",
    "TOWAI",
    "TUAKAU",
    "TUAMARINA",
    "TUATAPERE",
    "TURANGI",
    "TWIZEL",
    "UMAWERA",
    "UPPER HUTT",
    "UPPER MOUTERE",
    "URENUI",
    "URUTI",
    "WADDINGTON",
    "WAIHEKE ISLAND",
    "WAHAROA",
    "WAIHARARA",
    "WAIHI",
    "WAIHI BEACH",
    "WAIHOLA",
    "WAIKANAE",
    "WAIKAWA",
    "WAIKAWA",
    "WAIKOUAITI",
    "WAIMA",
    "WAIMANGAROA",
    "WAIMATE",
    "WAIMATE NORTH",
    "WAIMAUKU",
    "WAINUI",
    "WAINUIOMATA",
    "WAIONEKE",
    "WAIOURU",
    "WAIOTIRA",
    "WAIPAWA",
    "WAIPUKURAU",
    "WAIRAKEI",
    "WAIRAU VALLEY",
    "WAIROA",
    "WAITAHUNA",
    "WAIKOUAITI",
    "WAIKUKU",
    "WAITARA",
    "WAITARIA BAY",
    "WAITATI",
    "WAITOA",
    "WAITOKI",
    "WAITORIKI",
    "WAITOTARA",
    "WAIUKU",
    "WAIWERA",
    "WAKEFIELD",
    "WALLACETOWN",
    "WALTON",
    "WAVERLEY",
    "WANAKA",
    "WARD",
    "WARDVILLE",
    "WARRINGTON",
    "WARKWORTH",
    "WELLINGTON",
    "WELLSFORD",
    "WESTPORT",
    "WESTON",
    "WHAKATANE",
    "WHAKAMARU",
    "WHANANAKI",
    "WHANGAMATA",
    "WHANGAMOMONA",
    "WHANGANUI",
    "WHANGAREI",
    "WHANGAREI HEADS",
    "WHANGARURU",
    "WHATAROA",
    "WHATUWHIWHI",
    "WHENUAKITE",
    "WHENUAKURA",
    "WHIRITOA",
    "WHITFORD",
    "WHITBY",
    "WHITIANGA",
    "WILLOWBY",
    "WIMBLEDON",
    "WINCHESTER",
    "WINDSOR",
    "WINDWHISTLE",
    "WINSCOMBE",
    "WINTON",
    "WOODEND",
    "WOODHILL",
    "WOODVILLE",
    "WYNDHAM",
    
    // Suburbs of Auckland
    // Auckland Isthamus
    "ARCH HILL",
    "AUCKLAND CENTRAL",
    "AVONDALE",
    "BLOCKHOUSE BAY",
    "BALMORAL",
    "EDEN TERRACE",
    "EDEN VALLEY",
    "ELLERSLIE",
    "EPSOM",
    "FREEMANS BAY",
    "GLENDOWIE",
    "GLEN INNES",
    "GRAFTON",
    "GREENLANE",
    "GREENWOODS CORNER",
    "GREY LYNN",
    "HERNE BAY",
    "HILLSBOROUGH",
    "KINGSLAND",
    "KOHIMARAMA",
    "LYNFIELD",
    "MEADOWBANK",
    "MISSION BAY",
    "MORNINGSIDE",
    "MOUNT ALBERT",
    "MOUNT EDEN",
    "MOUNT ROSKILL",
    "MOUNT WELLINGTON",
    "NEWMARKET",
    "NEWTON",
    "NEW WINDSOR",
    "ONEHUNGA",
    "ONE TREE HILL",
    "ORAKEI",
    "ORANGA",
    "OTAHUHU",
    "OWAIRAKA",
    "PANMURE",
    "PARNELL",
    "PENROSE",
    "POINT ENGLAND",
    "POINT CHEVALIER",
    "PONSONBY",
    "REMUERA",
    "ROYAL OAK",
    "SAINT HELIERS",
    "SAINT JOHNS",
    "SAINT MARY’S BAY",
    "SANDRINGHAM",
    "TAMAKI",
    "TE PAPAPA",
    "THREE KINGS",
    "WAIKOWHAI",
    "WATERVIEW",
    "WESTFIELD",
    "WESTMERE",
    
    // North Shore
    "ALBANY",
    "BAYSWATER",
    "BEACH HAVEN",
    "BELMONT",
    "BIRKDALE",
    "BIRKENHEAD",
    "BROWNS BAY",
    "CAMPBELLS BAY",
    "CASTOR BAY",
    "CHATSWOOD",
    "CROWN HILL",
    "CUTHILL",
    "DEVONPORT",
    "FAIRVIEW",
    "FORREST HILL",
    "GLENFIELD",
    "GLENVAR",
    "GREENHITHE",
    "HIGHBURY",
    "HILLCREST",
    "LONG BAY",
    "MAIRANGI BAY",
    "MARLBOROUGH",
    "MEADOWOOD",
    "MILFORD",
    "MURRAYS BAY",
    "NORTHCOTE",
    "NORTHCOTE CENTRAL",
    "NORTHCOTE POINT",
    "NORTH HARBOUR",
    "ROSEDALE",
    "ROTHESAY BAY",
    "OTEHA",
    "PINEHILL",
    "SUNNYNOOK",
    "TAKAPUNA",
    "TORBAY",
    "WAIAKE",
    "WAIRAU VALLEY",
    "WESTLAKE",
    "WINDSOR PARK",
    "UNSWORTH HEIGHTS",

    // South Auckland and Eastern Suburbs
    "AIRPORT OAKS",
    "BEACHLANDS",
    "BROOKBY",
    "BUCKLANDS BEACH",
    "CHAPEL DOWNS",
    "CLENDON",
    "CLEVEDON",
    "CLOVER PARK",
    "COCKLE BAY",
    "DANNEMORA",
    "EAST TAMAKI",
    "EASTERN BEACH",
    "FARM COVE",
    "FLAMBORO HEIGHTS",
    "FLAT BUSH",
    "GOLFLANDS",
    "GOODWOOD HEIGHTS",
    "GREENMEADOWS",
    "HALF MOON BAY",
    "HERON POINT",
    "HIGHLAND PARK",
    "HILL PARK",
    "HOWICK",
    "MAHIA PARK",
    "MANGERE",
    "MANGERE BRIDGE",
    "MANGERE EAST",
    "MANUKAU",
    "MANUKAU HEIGHTS",
    "MANUREWA",
    "MARAETAI",
    "MEADOWLANDS",
    "MELLONS BAY",
    "MIDDLEMORE",
    "MURPHYS HEIGHTS",
    "NORTH PARK",
    "ORERE POINT",
    "OTARA",
    "PAKURANGA",
    "PAPATOETOE",
    "PORCHESTER PARK",
    "PUHINUI",
    "RANDWICK PARK",
    "REDOUBT PARK",
    "RICHMOND PARK",
    "SETTLERS COVE",
    "SHELLY PARK",
    "SILKWOOD HEIGHTS",
    "SOMMERVILLE",
    "TE ATTU SOUTH",
    "THE GARDENS",
    "TOTARA HEIGHTS",
    "TUSCANY ESTATE",
    "WAIMAHIA LANDING",
    "WATTLE COVE",
    "WATTLE DOWNS",
    "WEYMOUTH",
    "WHITFORD",
    "WIRI",

    // Papakura
    "ALFRISTON",
    "ARDMORE",
    "CONIFER GROVE",
    "LONGFORD PARK",
    "MANUREWA EAST",
    "PAHUREHURE",
    "PAPAKURA",
    "OPAHEKE",
    "RED HILL",
    "ROSEHILL",
    "TAKANINI",

    // West Auckland
    "GLEN EDEN",
    "GLENDENE",
    "GREEN BAY",
    "HENDERSON",
    "HOBSONVILLE",
    "KELSTON",
    "KONINI",
    "LAINGHOLM",
    "MASSEY",
    "NEW LYNN",
    "ORATIA",
    "PIHA",
    "RANUI",
    "SUNNYVALE",
    "SWANSON",
    "TE ATATU",
    "TE ATATU PENINSULA",
    "TE ATATU SOUTH",
    "TITIRANGI",
    "WAIATARUA",
    "WAITAKERE",
    "WEST HARBOUR",
    "WHENUAPAI",
    
    // Whangarei suburbs
    "KAMO",
    "STANLEY BAY",
    "TIKIPUNGA",
    "WAIHOU",
  };
}
