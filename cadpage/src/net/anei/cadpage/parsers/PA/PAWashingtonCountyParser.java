package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Washington County, PA
Contact: James Chabalie <jchabalie@cecil3fire.net>
Sender: company10paging
Location: 116 GRANT ST MCDO Xstreet: NORTH ST STATION ST TYPE: STRUCTURE FIRE TIME: 23:42:41 Comments: IN THE BACK POSS 112 OR 114
Location: 50 STONECREST LN CECI Xstreet: MCCONNELL RD DEAD END TYPE: FIRE TIME: 23:40:09 Comments:
Location: 1647 MILLERS RUN RD MTPL: @KEEPSAKE ARABIANS Xstreet: PLEASANT RD FORT CHERRY RD TYPE: FIRE ALARM TIME: 22:31:54 Comments:
Location: 22 2ND ST CECI Xstreet: SCHOOL ST BOYCE ST TYPE: STRUCTURE FIRE TIME: 22:40:10 Comments:
Location: 345 SOUTHPOINTE BLVD CECI: @LOCAL 23 UFCW Xstreet: SOUTHPOINTE BLVD NB SOUTHPOINTE BLVD NB TYPE: FIRE ALARM TIME: 11:39:27 Comments:
Xstreet: REISSING RD SR 50 TYPE: GRASS OR FIELD FIRE TIME: 15:07:34 Comments: ON REISSING NEAR SR 50
Xstreet: REISSING RD TAYLOR DR TYPE: VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIME: 05:36:10 Comments:
Xstreet: SR 980 HIGHLAND DR TYPE: VEHICLE ACCIDENT WITH INJURIES TIME: 14:17:43 Comments: JUST PASSED HIGHLAND HEADED TOWARD CECIL

Contact: Brad Simpson <bradsimpson301@gmail.com>
Sender: 7247471210
(911) Location: 200 TANDEM VILLAGE RD NSTR: @PCH 48 CONSULATE BLDG 2 Xstreet: LINDEN CREEK RD DEAD END TYPE: FIRE ALAR
(911) Location: 100 MEDICAL BLVD NSTR: @CANONSBURG HOSPITAL Xstreet: BOONE AVE HILL CHURCH HOUSTON RD TYPE: FIRE ALARM

Contact: Victor & Traci Fedrick <chief40@zoominternet.net>,7247975596@messaging.sprintpcs.com
Subject:911\nLocation: 213 EXPRESS WAY LONG: EST Xstreet: EXPRESS WAY EB DALLY RD TYPE: VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIM
Subject:911\nLocation: 6 RAILROAD ST ALLE Xstreet: FRANKLIN ST HAMILTON ST TYPE: MUTUAL AID REQUEST TIME: 11:34:09 Comments:
Subject:911\nLocation: 213 EXPRESS WAY LONG: EST Xstreet: EXPRESS WAY EB DALLY RD TYPE: VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIM
Subject:911\nLocation: 3 HIGH RD ROSC: EST Xstreet: MOUNT TABOR RD LATTA HOLLOW RD TYPE: UNCONSCIOUS PT / IS BREATHING TIME: 03:21

Contact: Charles Wood <charlesrwood@gmail.com>
Sender: WashCo911
1 of 2\nFRM:WashCo911 \nSUBJ:911\nMSG:Location: 791 LOCUST AVE EX SSTR: @PCH 44 HAWTHORNE WOODS ASSISTED LIVING Xstreet: BERRY RD VERONA DR TYPE:\n(Con't) 2 of 2\nUNCONSCIOUS PT / IS BREATHING TIME: 08:26:06 Comments: 1ST FLOOR HEALTH ROOM\n(End)

Victor Fedrick <v_a_fedrick@yahoo.com>
Sender: WashCo911 <WashCo911@co.washington.pa.us>
Subject:911\nLocation: 2 WHEELING PITTSBURGH STEEL DR ALLE: @AMROX Xstreet: MILL RD J F KENNEDY ST TYPE: FIRE TIME: 15:07:31 Comments: at the wheeling pittsburgh plant
Subject:911\nLocation: 5 CENTER ST ALLE Xstreet: ANDERSON ST SR 88 TYPE: ODOR OF NATURAL GAS TIME: 21:39:50 Comments:
Subject:911\nLocation: 1850 MAIN ST ALLE: @FD 40 ALLENPORT Xstreet: MALLARD ST WASHINGTON ST TYPE: VEHICLE ACCIDENT NO INJURIES TIME: 16:33:09 Comments:
Subject:911\nLocation: 446 BOW ST STOC Xstreet: LOCUST ST WALNUT ST TYPE: STRUCTURE FIRE TIME: 08:56:53 Comments:
Subject:911\nLocation: 1859 MAIN ST ALLE Xstreet: WASHINGTON ST BRIDGE ST TYPE: STRUCTURE FIRE TIME: 15:19:45 Comments:
Subject:911\nLocation: 214 DALLY RD LONG Xstreet: ROCK DR CREST DR TYPE: FIRE ALARM TIME: 20:32:03 Comments: WAGNER/MACK RES - 412-716-7984

Contact: Janis Miller <janis.lakus@gmail.com>
Sender: WashCo911@co.washington.pa.us
(911) Loc: 36 LYNNCREST CIR CECI Xsts: HILLCREST DR DEAD END Type: ALMED Time: 15:36:27 Loc Com: KOSANOVICH RES//7247462905

Contact: "mark181@windstream.net" <mark181@windstream.net>
Sender: station15+bncCLyug7vZGRD0nqL9BBoET_-1zg@googlegroups.com
(911) Loc: 75 BEATTY LN NBET Xsts: GARRETT RD FARM LN Type: FIRST Time: 23:13:21 Loc Com:

Contact: support@active911.com
[] (911) Loc: 323 MUSE BISHOP RD CECI: EST Xsts: CIAFFONI RD BURNSIDE RD Type: RDCLS Time: 22:14:11 Loc Com:\n
[] (911) Xsts: WEAVERTOWN LN MILLERS RUN RD Type: ACCIN Time: 12:17:20 Loc Com:\n
[] (911) Loc: 52 CARLISLE ST CECI Xsts: 2ND ST 3RD ST Type: MUTAF Time: 15:49:08 Loc Com:\n
[] (911) Location: 307 ROSEWOOD DR CECI Xstreet: RIDGEWOOD DR RIDGEWOOD DR TYPE: FIRE ALARM TIME: 14:59:51 Comments: SHAWN KELLY\n
[] (911) Loc: 27 HIGHLAND DR CECI Xsts: SR 980 PROFIO RD Type: FIRAL Time: 13:58:32 Loc Com: MARKOVIC RES 724-9262427\n
[] (911) Xstreet: MORGANZA RD DEAD END TYPE: STRUCTURE FIRE TIME: 22:27:03 Comments:\n
[] (911) Location: 232 RAILROAD ST CECI Xstreet: JOHNSTON ST DEAD END TYPE: UNCONSCIOUS PT / IS BREATHING TIME: 22:36:33 Comments:\n
[] (911) Location: 3351 MILLERS RUN RD CECI: @FD 10 CECIL Xstreet: NUGENT ST COLEMAN RD TYPE: MUTUAL AID REQUEST TIME: 16:25:10 Comments:\n
[] (911) Location: 3351 MILLERS RUN RD CECI: @FD 10 CECIL Xstreet: NUGENT ST COLEMAN RD TYPE: MUTUAL AID REQUEST TIME: 16:25:10 Comments:\n
[] (911) Location: 1000 CORPORATE DR CECI: @HILTON GARDEN INN Xstreet: KLINGER RD DEAD END TYPE: FIRE ALARM TIME: 06:57:37 Comments:\n
[] (911) Location: 1029 MAYFAIR DR CECI Xstreet: GREENFIELD DR FIELDSTONE DR TYPE: FIRE ALARM TIME: 09:01:11 Comments:\n
[] (911) Location: 11 HICKORY GRADE RD CECI Xstreet: CECIL HENDERSON RD ANDREIS LN TYPE: ODOR OF NATURAL GAS TIME: 13:11:16 Comments:\n
[] (911) Loc: 323 MUSE BISHOP RD CECI: EST Xsts: CIAFFONI RD BURNSIDE RD Type: RDCLS Time: 22:14:11 Loc Com:\n
[] (911) Loc: 545 MUSE BISHOP RD CECI Xsts: CUMER RD MCCONNELL RD Type: ACCUN Time: 20:41:52 Loc Com:\n
[] (911) Location: 307 ROSEWOOD DR CECI Xstreet: RIDGEWOOD DR RIDGEWOOD DR TYPE: FIRE ALARM TIME: 14:59:51 Comments: SHAWN KELLY\n
[] (911) Loc: 27 HIGHLAND DR CECI Xsts: SR 980 PROFIO RD Type: FIRAL Time: 13:58:32 Loc Com: MARKOVIC RES 724-9262427\n
[] (911) Xsts: WEAVERTOWN LN MILLERS RUN RD Type: ACCIN Time: 12:17:20 Loc Com:\n
[] (911) Xsts: CUMER RD BERNARDI LN Type: FIRE Time: 11:45:58 Loc Com: ON CUMER...1/2MI FROM MUSE BISHOP\n
[] (911) Loc: 1000 CORPORATE DR CECI: @HILTON GARDEN INN Xsts: KLINGER RD DEAD END Type: FIRAL Time: 17:58:17 Loc Com:\n
[] (911) Loc: 27 HIGHLAND DR CECI Xsts: SR 980 PROFIO RD Type: FIRAL Time: 13:58:32 Loc Com: MARKOVIC RES 724-9262427\n
[] (911) Loc: 1000 CORPORATE DR CECI: @HILTON GARDEN INN Xsts: KLINGER RD DEAD END Type: FIRAL Time: 17:58:17 Loc Com:\n
[911] Xsts: SLATEMORE DR MILLERS RUN RD Type: ACCIN Time: 17:48:51 Loc Com:\n

** Missing address - not parsed
FRM:WashCo911 \nSUBJ:911\nMSG:Xstreet:   TYPE: MUTUAL AID REQUEST TIME: 09:10:04 Comments: BETWEEN SANITARUM RD/WAYNESBURG RD & 79\n

*/

public class PAWashingtonCountyParser extends FieldProgramParser {
  
  public PAWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "PA",
           "Loc:ADDR/S? Xsts:X? Type:CALL! Time:TIME Loc_Com:INFO Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "company10paging,WashCo911";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Regular parseMsg processing, but return failure if we didn't get an address
    // from either a Location or Xstreet
    body = body.replace("Location:", "Loc:").replace("Xstreet:", "Xsts:").replace("TYPE:", "Type:").replace("TIME:", "Time:");
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0)  return false;
    return true;
  }
  
  // Call description field parser
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = convertCodes(field, CALL_CODES);
      super.parse(field, data);
    }
  }
  
  // Address field parser
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String fld, Data data) {
      Parser p = new Parser(fld);
      data.strPlace = p.getLastOptional(":");
      if (data.strPlace.startsWith("@")) data.strPlace = data.strPlace.substring(1).trim(); 
      data.strCity = convertCodes(p.getLast(' '), CITY_CODES); 
      fld = p.get();
      super.parse(fld, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE";
    }
  }
  
  // Cross street field
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      String saveAddr = data.strAddress;
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT, field, data);
      if (saveAddr.length() > 0) {
        data.strCross = data.strAddress;
        data.strAddress = saveAddr;
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALLE", "ALLENPORT",
      "AMWE", "AMWELL TWP",
      "BEAL", "BEALLSVILLE",
      "BENT", "BENTLEYVILLE",
      "BLAN", "BLAINE TWP",
      "BUFF", "BUFFALO TWP",
      "BURG", "BURGETTSTOWN",
      "CALI", "CALIFORNIA",
      "CANO", "CANONSBURG",
      "CANT", "CANTON TWP",
      "CARR", "CARROLL TWP",
      "CECI", "CECIL TWP",
      "CENT", "CENTERVILLE",
      "CHRT", "CHARTIERS TWP",
      "CLAY", "CLAYSVILLE",
      "COAL", "COAL CENTER",
      "COKE", "COKEBURG",
      "CROI", "CHARLEROI",
      "CROS", "CROSS CREEK TWP",
      "DEEM", "DEEMSTON",
      "DONE", "DONEGAL TWP",
      "DONO", "DONORA",
      "DUNL", "DUNLEVY",
      "EBET", "EAST BETHLEHEM TWP",
      "EFIN", "EAST FINLEY TWP",
      "ELCO", "ELCO",
      "ELLS", "ELLSWORTH",
      "EWAS", "EAST WASHINGTON",
      "FALL", "FALLOWFIELD TWP",
      "FINL", "FINLEYVILLE",
      "GREE", "GREEN HILLS",
      "HANO", "HANOVER TWP",
      "HOPE", "HOPEWELL TWP",
      "HOUS", "HOUSTON",
      "INDP", "INDEPENDENCE TWP",
      "JEFF", "JEFFERSON TWP",
      "LONG", "LONG BRANCH",
      "MARI", "MARIANNA",
      "MCDO", "MCDONALD",
      "MIDW", "MIDWAY",
      "MONO", "MONONGAHELA",
      "MORR", "MORRIS TWP",
      "MTPL", "MT PLEASANT TWP",
      "NBET", "NORTH BETHLEHEM TWP",
      "NCHA", "NORTH CHARLEROI",
      "NEWE", "NEW EAGLE",
      "NFRA", "NORTH FRANKLIN TWP",
      "NOTT", "NOTTINGHAM TWP",
      "NSTR", "NORTH STRABANE TWP",
      "PETE", "PETERS TWP",
      "ROBI", "ROBINSON TWP",
      "ROSC", "ROSCOE",
      "SFRA", "SOUTH FRANKLIN TWP",
      "SMIT", "SMITH TWP",
      "SOME", "SOMERSET TWP",
      "SPEE", "SPEERS",
      "SSTR", "SOUTH STRABANE TWP",
      "STOC", "STOCKDALE",
      "TWIL", "TWILIGHT",
      "UNIO", "UNION TWP",
      "WALE", "WEST ALEXANDER",
      "WASH", "WASHINGTON",
      "WBET", "WEST BETHLEHEM TWP",
      "WBRO", "WEST BROWNSVILLE",
      "WFIN", "WEST FINLEY TWP",
      "WMID", "WEST MIDDLETOWN",
      "WPIK", "WEST PIKE RUN TWP"
  });
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
                  
      "ACC",     "ACCIDENT",
      "ACCEN",   "ACCIDENT W/ENTRAPMENT",
      "ACCFA",   "ACCIDENT W/FATALITY",
      "ACCIN",   "ACCIDENT W/INJURIES",
      "ACCRB",   "ACCIDENT BLKG RDWY",
      "ACCUN",   "ACCIDENT W/UNK INJURIES",
      "AIR",     "AIRCRAFT INCIDENT",
      "ALSPK",   "SPRINKLER ALARM",
      "BOAT",    "BOAT EMERGENCY",
      "BOMB",    "EXPLOSIVE DEVICE",
      "CARMO",   "CO ALARM",
      "CAVE",    "CAVE IN",
      "CHO",     "CHOKING",
      "COL",     "COLLAPSE",
      "DRWN",    "DROWNING",
      "ELEEM",   "ELEVATOR EMERGENCY",
      "EXPLO",   "EXPLOSION",
      "FIRAL",   "FIRE ALARM",
      "FIRCH",   "CHEMICAL FIRE",
      "FIRE",    "FIRE",
      "FIREN",   "STRUCTURE FIRE W/ ENTRAPMENT",
      "FIRGR",   "BRUSH FIRE",
      "FIRST",   "STRUCTURE FIRE",
      "FIRVE",   "VEHICLE FIRE",
      "FLOOD",   "FLOODING",
      "GASOD",   "NATURAL GAS ODOR",
      "HAZMA",   "HAZMAT INCIDENT",
      "LZ",      "LANDING ZONE",
      "MANDN",   "MAN DOWN",
      "MASCA",   "MCI INCIDENT",
      "MINAC",   "MINE ACCIDENT",
      "MUTAF",   "MUTUAL AID REQUEST",
      "NUCIN",   "NUCLEAR INCIDENT",
      "OOS",     "OUT OF SERVICE",
      "PRI",     "PRIORITY DISPATCH",
      "PUB",     "PUBLIC SERVICE",
      "RDCLS",   "ROAD CLOSURE",
      "SMOKE",   "SMOKE INVESTIGATION",
      "SPILL",   "CONTAINMENT DETAIL",
      "SR",      "SEARCH DETAIL",
      "WEATH",   "WEATHER ADVISORY",
      "WIRES",   "DOWNED/LOW HANGING WIRES",

  });
}
