package net.anei.cadpage.parsers.OH;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Shelby County, OH
Contact: "Sgt Michael Wick" <mike.wick@shelbycountysheriff.com>
Sender: cad@shelbycountysheriff.com
System: CivicaCMI, Inc
11-005105|28 - DRO|CAR CRASHED INTO WATER@11 WATER ST
11-008684|11:09:00|:28 - SF|MICROWAVE ON FIRE @ 301 ELIZABETH ST RUSSIA BETW FIRST ST & CUL DE SAC|PHLIPOT
11-008838|05:35:00|:28 - MIS|UKNOWN TYPE FIRE ON EAST SIDE OF ROAD NORTH OF CARDO NEAR LOY RD @ 8000-B SR 66 FT LORAMIE BETW LOY RD & BASINBURG RD|
11-009441|21:37:00|:29 - EMS|ELDERLY FEMALE FALL VICTIM  NO INJURY NEEDS HELP  GETTING UP @ 7533 HOYING RD ANNA BETW WRIGHT PUTHOFF RD & THAMAN RD|PLAS
11-009690|05:32:00|:58 - EMS|SHOT HIMSELF IN THE HEAD, HE IS GONE @ 18590 SR 29 NEW KNOXVILLE BETW BOTKINS RD & WIERWILLE RD|
11-009558|23:34:00|:29 - EMS|FEMALE WITH AN ALLERGIC REACTION @ 202 S VANDEMARK RD SIDNEY BETW SHAWNEE DR & APACHE DR|SAUNDERS

Contact: "Jerry Ahrns" <jahrns3000@yahoo.com>
Sender: cad@shelbycountysheriff.com
(CAD Page) 12-003898|18:00:00|28-MIS|THERE IS A POWER POLE THAT IS ON FIRE @ 6053 DAWSON RD, HOUSTON X OF  STOKER RD &  SR 47|BROWN
(CAD Page) 12-003885|15:23:00|4-AWI|CAR/MOTORCYCLE @  EILERMAN RD@ FT LORAMIE SWANDERS RD, FT LORAMIE X OF  & |
(CAD Page) 12-003671|04:29:00|28-MIS|HAD A FIRE IN OUR GARAGE, NEED @ 9011 GREENVILLE RD, SIDNEY X OF  HARDIN WAPAKONETA RD &  PATTERSON HALPIN RD|YOUNG

Contact: Shirley Johns <shirley.johns.sj@gmail.com>
Sender: CAD@shelbycountysheriff.com
(CAD Page) 12-009303|05:27:56|29-EMS|MEDICAL CALL 76 YO MALE NOT FEELING HAVEING STOMACH PAINS  @ 151 S LIBERTY WAY UNIT B, FT LORAMIE X OF ELM ST & CUL

Contact: support@active911.com
Sender: CAD@shelbycountysheriff.com
(CAD Page) 12-003681|12:48:00|29-EMS|76 YOF CHEST PAINS @ 404 W MAIN ST UNIT 3, ANNA X OF  CSX RAILROAD &amp;  BROOKSIDE DR|BEERS
(CAD Page) 12-003677|10:19:00|29-|MALE CARDIAC DISTRESS @ 3003 CISCO RD, SIDNEY X OF  KUTHER RD &amp;  SR 29|DOROTHY LOVE
(CAD Page) 12-003680|12:00:00|29-|FEMALE FALL @ 2500 N KUTHER RD UNIT COM, SIDNEY X OF  RUSSELL RD &amp;  CISCO RD|DOROTHY LOVE APTS
(CAD Page) 12-003665|03:43:00|9-|NEIGHBORS ARE RUNNING A DIRT B @ 3989 RUSSIA HOUSTON RD, RUSSIA X OF  RANGELINE RD &amp;  SR 48|MAGOTO
(CAD Page) 12-003667|04:02:00|9-|THERE IS A MALE HERE THAT IS DRUNK, REFUSING TO LEAVE @ 215 JAMES ST, JACKSON CENTER X OF S OHIO ST &amp;  ELDER ST|HUDSON
(CAD Page) 12-003668|04:20:00|9-|THERE IS A LARGE DISTURBANCE OUTSIDE, ITS SOUNDS PRETTY HEATED @ 215 JAMES ST, JACKSON CENTER X OF S OHIO ST &amp;  ELDER ST|HUDSON
(CAD Page) 12-003670|04:23:00|29-EMS|50 YOF - PASSED OUT - HX OF CRONES AND VOMITING @ 2433 LORAMIE WASHINGTON RD, HOUSTON X OF  FESSLER BUXTON RD &amp;  TAYLOR RD|KAUFFMAN
(CAD Page) 12-003671|04:29:00|28-|HAD A FIRE IN OUR GARAGE, NEED @ 9011 GREENVILLE RD, SIDNEY X OF  HARDIN WAPAKONETA RD &amp;  PATTERSON HALPIN RD|YOUNG 
(CAD Page) 12-003636|16:03:00|28-FF|GRASS FIRE  @ 3000-B SR 48, HOUSTON X OF  RUSSIA VERSAILLES RD &amp;  RUSSIA HOUSTON RD|
(CAD Page) 12-003639|16:59:00|9-|PROBLEMS WITH JUVENILES IN PARK  @ 800 E PIKE ST, JACKSON CENTER X OF  PARKVIEW ST &amp;  CORP LIMITS|JACKSON CENTER SWIMMING POOL
(CAD Page) 12-003642|17:20:00|9-|ATV RACING AROUND TOWN  WHI YAMAHA WENT TO 21444 MAPLEWOOD RD  @ 6 EXTRA, MAPLEWOOD X OF  CITY &amp;  CITY|VILLAGE OF MAPLEWOOD
(CAD Page) 12-003648|20:14:00|9-|CAR SMOKING DRIVING DOWN ROAD  @ 18000-B SR 47, SIDNEY X OF  CORP LIMITS &amp;  HERRING RD|18000-B SR 47
(CAD Page) 12-003634|13:34:00|9-|REF ID THEFT @ ,  X OF  &amp; |
(CAD Page) 12-003562|20:16:00|9-|MALE IN THE LOBBY REQUESTING TO TALK WITH A DEPUTY ABOUT HIS 34 @ 18288 HERRING RD, SIDNEY X OF  RIVERVIEW PL &amp;  BAKER RD|
(CAD Page) 12-003535||9-|INMATE CHAIRED @ 555 GEARHART RD, SIDNEY X OF  CHILDRENS HOME RD &amp;  DOORLEY RD|SHERIFF'S OFFICE
(CAD Page) 12-003540||29-EMS|24 YOM, SHOULDER IS OUT OF PLACE @ 10291 TAWAWA MAPLEWOOD RD, MAPLEWOOD X OF  SR 47 &amp;  LEFEVRE RD|KUCK
(CAD Page) 12-003530||9-|SON IS TEARING UP MY HOUSE @ 5920 SMITH RD, HOUSTON X OF  JEROME DR &amp;  FOSTER RD|LEE
(CAD Page) 12-003558||29-EMS|MALE CALLED AND ADVISED THAT HE WAS TOLD TO EVACUATE @ 601 N STOLLE AV, SIDNEY X OF  GLEASON ST &amp;  CUL DE SAC|FRESHWAY FOODS
(CAD Page) 12-003526||29-| @ 260 OAKWOOD DR, FT LORAMIE X OF  SIOUX ST &amp;  MIAMI ST|BEHR
(CAD Page) 12-003508|06:47:00|28-SR|NEIGHBORS HOUSE IS ON FIRE@17000-B FT LORAMIE SWANDERS RD SIDNEY BETW LOCAHRD RD &amp; AILES RD|
(CAD Page) 12-003513|08:35:00|:9 - |1 MALE FOR CT\n@ 56 EXTRA TROY BETW  CITY &amp;  CITY|WEST CENTRAL JDC
(CAD Page) 12-003508|06:47:00|:28-SF|NEIGHBORS HOUSE IN ON FIRE @ 17000-B FT LORAMIE SWANDERS RD SIDNEY BETWE LOCHARD RD &amp; AILES RD|
(CAD Page) 12-003620|07:19:00|29-EMS|BE OUT ON A 29 CALL @ 205 FIRST ST, RUSSIA X OF  ELIZABETH ST &amp;  DEADEND|MONNIN
(CAD Page) 12-003619|06:45:00|29-EMS|50 YOM THROWING UP SHORTNESS OF BREATH @ 3012 SR 66, HOUSTON X OF  SMITH RD &amp;  STILLWATER RD|GOINGS
(CAD Page) 12-003607|22:29:00|9-|DEBRIE @  SR 29@ WELLS RD, ANNA X OF  &amp; |
(CAD Page) 12-003614|00:02:00|9-|OUT WITH TWO VEH ON LANE ST. AT THE PARK @ 7 EXTRA, FT LORAMIE X OF  CITY &amp;  CITY|VILLAGE OF FT LORAMIE
(CAD Page) 12-003598|19:29:00|9-| @ 404 W STATE ST, BOTKINS X OF  OAK ST &amp; N ELM ST|KING
(CAD Page) 12-003604|21:45:00|9-|BUILDING CHECK  @ 401 S PIKE ST, ANNA X OF  YOUNG ST &amp;  DIAMOND DR|ANNA STORE &amp; LOCK
(CAD Page) 12-003593|15:54:00|29-EMS|SERIOUS INSULIN REACTION  65 YOA FEMALE @ 10377 AMSTERDAM RD, BOTKINS X OF  HARDIN WAPAKONETA RD &amp;  STALEY RD|NOLTE
(CAD Page) 12-003585|12:00:00|29-EMS|63 SOB, DISORIENTED @ 22013 LOCK TWO RD, JACKSON CENTER X OF  MORRIS ROSE RD &amp;  COUNTY LINE|MYERS
(CAD Page) 12-003575|05:01:00|9-| @ 2100 MICHIGAN ST, SIDNEY X OF  FOLKERTH AV &amp; N VANDEMARK RD|KROGERS
(CAD Page) 12-003569|23:49:00|9-|EUGENE GOINGS IS HERE CAUSING  @ 3855 LINDSEY RD, SIDNEY X OF  SCHENK RD &amp;  MILLCREEK RD|
(CAD Page) 12-003574|04:52:00|9-| @ 5881 SR 29, SIDNEY X OF  SR 706 &amp;  CSX RAILROAD|PASCO GROCERY
(CAD Page) 12-003566|21:41:00|9-|PAST COUPLE NIGHTS HAVE BEEN H @ 15435 MORRIS ROSE RD, JACKSON CENTER X OF  WISE RD &amp;  LINKER RD|WEAVER

 */


public class OHShelbyCountyParser extends FieldProgramParser {
  
  public OHShelbyCountyParser() {
    super(CITY_LIST, "SHELBY COUNTY", "OH",
           "ID TIME? CALL ADDR/S PLACENAME");
  }
  
  @Override
  public String getFilter() {
    return "cad@shelbycountysheriff.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\\|"), data);
  }
  
  private class MyCallField extends CallField {
    
    public MyCallField() {
      setPattern(Pattern.compile(":?\\d\\d? ?- ?[A-Z]*"), true);
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(":")) field = field.substring(1);
      super.parse(field, data);
    }
  }
  
  private static final Pattern X_MARK_PTN = Pattern.compile(" BETWE? | X OF ");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strSupp = p.getOptional('@');
      String sAddr = p.get(X_MARK_PTN);
      data.strCross = p.get().replaceAll("  +", " ");
      if (data.strCross.equals("&")) data.strCross = "";
      sAddr = sAddr.replace("@", "&");
      int pt = sAddr.lastIndexOf(',');
      if (pt >= 0) {
        parseAddress(sAddr.substring(0,pt).trim(), data);
        data.strCity = sAddr.substring(pt+1).trim();
      } else {
        super.parse(sAddr, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "INFO " + super.getFieldNames() + " X";
    }
  }
  
  @Override
  protected boolean checkPlace(String name) {
    // If it has more than two blanks, consider it to be a place
    return (PLACE_PTN.matcher(name).matches());
  }
  private static final Pattern PLACE_PTN = Pattern.compile("[^ ]+ +[^ ]+ .*");

  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d\\d-\\d{6}", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d|", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "SIDNEY",
    "ANNA",
    "BOTKINS",
    "FT LORAMIE",
    "JACKSON CENTER",
    "KETTLERSVILLE",
    "LOCKINGTON",
    "PORT JEFFERSON",
    "RUSSIA",
    "CLINTON TWP",
    "CYNTHIAN TWP",
    "DINSMORE TWP",
    "FRANKLIN TWP",
    "GREEN TWP",
    "JACKSON TWP",
    "LORAMIE TWP",
    "MCLEAN TWP",
    "ORANGE TWP",
    "PERRY TWP",
    "SALEM TWP",
    "SIDNEY",
    "TURTLE CREEK TWP",
    "VAN BUREN TWP",
    "WASHINGTON TWP",
    "NEWPORT",
    "HOUSTON",
    "KIRKWOOD",
    "MAPLEWOOD",
    "MCCARTYVILLE",
    "MONTRA",
    "MOUNT JEFFERSON",
    "PEMBERTON",
    "ST PATRICK",
    "SWANDERS",
    "TAWAWA",
    "TROY",
    "NEW KNOXVILLE"
  };
}
