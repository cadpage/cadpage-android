package net.anei.cadpage.parsers.MN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * This class parses messages from some as yet unidentified CAD software vendor
 **/

/*
Hennepin county, MN
Contact: basarajoseph@gmail.com <basarajoseph@gmail.com>
Sender: sheriff@cadpaging.co.hennepin.mm.us

NAME-KENDRA;  LOC-4001 STINSON BLVD NE [#404;  EVTYPE-STROKE;  COMMENTS-POSSIBLE STROKE --- USE MAIN ENTRANCE TO THE 4TH FL
NAME-BRINATTE,HELEN;  LOC-2626 KENZIE TER [#114 [@WALKER ON KENZIE APT;  EVTYPE-ILL;  COMMENTS-2626 KENZIE TER : cross stre
NAME-;  LOC-2600 39TH AVE NE [#100 [@SILVER LAKE CLINIC;  EVTYPE-BREATH;  COMMENTS-2600 39TH AVE NE : cross streets : SILVE
NAME-MRS SILGE;  LOC-3804 HIGHCREST RD [#109 [@LAKEHILL APT;  EVTYPE-ASTFIR;  COMMENTS-3804 HIGHCREST RD : cross streets : 
NAME-areson, dale;  LOC-2512 SILVER LA [#204 [@EQUINOX APT;  EVTYPE-FALL;  COMMENTS-2512 SILVER LA : cross streets : SILVER
NAME-SARAH;  LOC-3701 CHANDLER DR [#312 [@CHANDLER PLACE APT;  EVTYPE-ILL;  COMMENTS-3701 CHANDLER DR : cross streets : DIA
NAME-;  LOC-3700 FOSS RD [#152;  EVTYPE-ILL;  COMMENTS-3700 FOSS RD : cross streets : CHANDLER DR  75 YO FEMALE - ILL
NAME-STANLEY SEC;  LOC-2804 29TH AVE NE;  EVTYPE-ALMHSE;  COMMENTS-2804 29TH AVE NE: cross streets : COOLIDGE ST NE & WILSO
NAME-DIANE;  LOC-2600 KENZIE TER [@AUTUMN WOODS APT#208;  EVTYPE-FALL;  COMMENTS-2600 KENZIE TER : cross streets : LOWRY GR
NAME-ERIC;  LOC-3201 DIAMOND EIGHT TER [#106 [@DIAMOND EIGHT TERRACE APT;  EVTYPE-CHOKE;  COMMENTS-3201 DIAMOND EIGHT TER :
NAME-;  LOC-3114 RANKIN RD;  EVTYPE-ALLERG;  COMMENTS-3114 RANKIN RD : cross streets : 32ND AVE NE & TOWNVIEW AVE  thinks s
NAME-PEKAREK;  LOC-3008 RANKIN RD;  EVTYPE-HEART;  COMMENTS-3008 RANKIN RD : cross streets : EAST GATE RD & CROFT DR  43 YO

Contact: Active911
[] NAME-SIMPLEX;  LOC-8201 45TH AVE N [@NORTH PARK PLAZA APT;  EVTYPE-ALMAPT;  COMMENTS-8201 45TH AVE N : cross streets : WINNETKA AVE N & XYLON AVE N\r\nSMOKE DETECTOR BY 313 IN THE CORADOR,  763 535 6794\r\n\r\n\r\n\r\n
[] NAME-SHEILA NESS;  LOC-8000 BASS LAKE RD [@ST THERESE NURSING HOME;  EVTYPE-HEART;  COMMENTS-8000 BASS LAKE RD : cross streets : WINNETKA AVE N & WISCONSIN AVE N\r\nEMPLOYEE ...3 EAST CHEST PAIN AND NUMBNESS IN HER LEFT ARM\r\n\r\n\r\n\r\n
[] NAME-ANON;  LOC-6608 CORVALLIS AVE N;  EVTYPE-CKBURN;  COMMENTS-6608 CORVALLIS AVE N: cross streets : FLORIDA AVE N & HAMPSHIRE AVE N\r\nBACK YARD FIRE PIT HAS BEEN UNATTENDED AND BURNING SINCE 10 LAST NIGHT,\r\n\r\n\r\n\r\n
[] NAME-cindy cummings;  LOC-6017 QUEBEC AVE N;  EVTYPE-CKBURN;  COMMENTS-6017 QUEBEC AVE N: cross streets : 61ST AVE N & 60TH AVE N\r\ncheck on the res in the wht house behind this rps res because she is burning garbage\r\n\r\n\r\n\r\n
[] NAME-REBECCA;  LOC-5500 BOONE AVE N [@NORTH RIDGE APT [@NORTH RIDGE CARE CENTER 3;  EVTYPE-HEART;  COMMENTS-5500 BOONE AVE N : cross streets : RESEARCH CENTER RD E & 54TH AVE N\r\nIN THE LOBBY .....PARTY WITH IRREGULAR HEART BEAT...RP IS NOT WITH PARTY CURRENTLY\r\n\r\n\r\n\r\n
[] NAME-EMERGENCY POLICE LINE;  LOC-RAILROAD TRKS & WEST BROADWAY;  EVTYPE-INFO;  COMMENTS-TRAIN BLOCKING CROSSING FOR MOST OF MORNING.....\r\nWEST BROADWAY, DOUGLAS DR, AND BOONE AV, WINNETKA AV,\r\nWORK TRAIN ON TRACKS AND BLOCKING STREETS MOST OF THE MORNING.....\r\nIF ACCESS IS NEEDED CALL THIS EMERGENCY NUMBER.... 1-800-716-9132\r\nWILL CALL BACK WHEN CLEAR PER DISPATCHER 516\r\nDISPATCH NOTIFYING AMBULANCE AND FIRE DISPATCH TO NOTIFY THEIR FIRE DEPTS...\r\n\r\n\r\n\r\n
[] NAME-matt-northwest asphalt;  LOC-4801 EDGEWOOD AVE N;  EVTYPE-GASO;  COMMENTS-4801 EDGEWOOD AVE N: cross streets : FAIRVIEW AVE N & 48TH AVE N\r\nhit serv line to the res... 1/4 inch... is pinched off\r\n\r\n\r\n\r\n
[] NAME-APRIL;  LOC-6610 MARKWOOD DR N;  EVTYPE-WIREA;  COMMENTS-6610 MARKWOOD DR N : cross streets : GEORGIA AVE N & HAMPSHIRE AVE N\r\nNW CORNER IN THE BACK POWER LINES IN THE TREES SPARKING\r\n\r\n\r\n\r\n
[] NAME-41IN1;  LOC-4251 XYLON AVE N [#1X [@FIRE 41 ST 3;  EVTYPE-HEART;  COMMENTS-4251 XYLON AVE N : cross streets : 45TH AVE N & 42ND AVE N\r\nNO SQUADS NEEDED\r\n\r\n\r\n\r\n
[] NAME-EVANS, JUANITA;  LOC-6001 56TH AVE N [@CRYSTAL COURTS APT;  EVTYPE-ALMAPT;  COMMENTS-6001 56TH AVE N : cross streets : BRUNSWICK AVE N & ADAIR AVE N\r\nALARM GOING OFF ON 2ND FLOOR HALL\r\nNO FIRE SEEN OR SMOKE SMELL\r\n\r\n\r\n\r\n
[] NAME-GELLERMAN, EVELYN;  LOC-5700 BOONE AVE N [#531 [@CHARDON COURT APT;  EVTYPE-HEART;  COMMENTS-5700 BOONE AVE N : cross streets : 56TH AVE N & BASS LAKE RD\r\nDIZZY / HEART BEATING FAST\r\nDOOR WILL BE UNLOCKED\r\n\r\n\r\n\r\n
[] NAME-ANONYMOUS;  LOC-3556 QUAIL AVE N;  EVTYPE-CKBURN;  COMMENTS-3556 QUAIL AVE N: cross streets : 35TH AVE N & 36TH AVE N\r\nNEIGHBOR BURNING WOOD FROM GARAGE W/PAINT ON IT\r\n\r\n\r\n\r\n
[] NAME-LORIELLE;  LOC-5701 QUEBEC AVE N [#103A [@CRYSTAL TOWERS APT;  EVTYPE-HEART;  COMMENTS-5701 QUEBEC AVE N : cross streets : 58TH AVE N & 56TH AVE N\r\nCHEST PAINS..HX..GAVE ONE 1 NITRO\r\n\r\n\r\n\r\n
[] NAME-JIM;  LOC-5600 HWY 169 [@LIBERTY DIVERSIFIED;  EVTYPE-HEART;  COMMENTS-5600 HWY 169 : cross streets : BASS LAKE RD & RAILROAD TRKS\r\nDOCK #4\r\n\r\n\r\n\r\n
[] NAME-HARMON;  LOC-5430 BOONE AVE N [@NORTH RIDGE CARE CENTER 3;  EVTYPE-DRILL;  COMMENTS-5430 BOONE AVE N : cross streets : RESEARCH CENTER RD E & 54TH AVE N\r\nFROM NOW FOR ABOUT 15 MINUTES....WILL CALL BACK WHEN FINISHED....\r\n\r\n\r\n\r\n
[] NAME-HASTINGS, BRANDY;  LOC-6721 45TH PL N;  EVTYPE-ALMCO;  COMMENTS-6721 45TH PL N : cross streets : JERSEY AVE N\r\nGENERAL CO ALRM - BATTERY OPERATED\r\nRP JUST HAD HER FURNACE/WTR HEATER AND DUCTS TODAY\r\nCLEANERS LEFT 1 HRS AGO ...\r\n*** CO ALRM SOUNDING FOR LAST 5 MIN .. NO READING **\r\nNO ONE FEELING ILL\r\n\r\n\r\n\r\n
[] NAME-JOHNATHAN;  LOC-5732 WINNETKA AVE N [#204 [@WINCREST APT;  EVTYPE-HEART;  COMMENTS-5732 WINNETKA AVE N : cross streets : BASS LAKE RD & 59TH AVE N\r\nFEMALE- HEART RACING,, HARD TIME BREATHING\r\n\r\n\r\n\r\n
[] NAME-LAURA CARLSON;  LOC-7934 51ST AVE N;  EVTYPE-ALMCO;  COMMENTS-7934 51ST AVE N: cross streets : WISCONSIN AVE N & WINNETKA AVE N\r\nCO ALM SOUNDING ... NO ONE ILL , NO READING ON THE ALM\r\n\r\n\r\n\r\n
[] NAME-SHANE SAUNDERS;  LOC-4748 GEORGIA AVE N;  EVTYPE-GASO;  COMMENTS-4748 GEORGIA AVE N: cross streets : 47TH AVE N & 48TH AVE N\r\nSMELLS NATURAL GAS WHILE SITTING AT THE BONFIRE IN BACK YARD\r\nMEET RP IN FRONT YARD\r\n\r\n\r\n\r\n
[] NAME-GRANLUND, PAULA;  LOC-7717 45TH HALF AVE N;  EVTYPE-CKBURN;  COMMENTS-7717 45TH HALF AVE N: cross streets : WINNETKA AVE N & RHODE ISLAND AVE N\r\nTWO HOUSES DOWN TWRD WINNETKA\r\nCK ON OPEN FIRE .. NOT ALWAYS ATTENDED .. LOTS OF SMOKE\r\n\r\n\r\n\r\n
[] NAME-7634127755;  LOC-5336 PENNSYLVANIA AVE N;  EVTYPE-HOUSE;  COMMENTS-FIRE IN THE BATHROOM FAN ..\r\nFLAMES SEEN ..\r\nADVSED TO EVAC\r\nE3 CREW/2\r\nE6 CREW/2\r\nPER 3245 ON SCENE AND PARTY THERE STATED NO FIRE\r\nNEED TO CONFIRM ADDRESS\r\nSINGLE FAMILY, NOTHING SHOWIN, P2 IC\r\nPER 3224 SLOW FIRE\r\n5336 PENNSYLVANIA AVE N: cross streets : SAINT RAPHAEL DR & 53RD AVE N\r\nCORRECTED ADDRESS IS 5336 PENNYSLVANIA\r\nCALLED RP BACK STATED FLAMES OUT .. ELECTRICAL FIRE\r\nCANCEL BKC FIRE\r\nPER 4113 FIRE OUT ... LOTS OF SMOKE\r\nNORTH CANCELLED\r\nPER COMMAND, FIRE CONTROLLED.\r\nEvent transferred to dgroup: 32P\r\nCH11 TO E11\r\n\r\n\r\n\r\n
[] NAME-PROTECTION ONE;  LOC-5913 HAMPSHIRE AVE N;  EVTYPE-ALMCO;  COMMENTS-5913 HAMPSHIRE AVE N: cross streets : 60TH AVE N & 59TH AVE N\r\nRESIDENTIAL / AUDIBLE\r\nCOVERS CARBON MONOXIDE DETECTOR\r\nALRM CO REC'D ALRM AT 1820 HRS\r\nNAM/OHM, BILLY\r\nINSIDE 763 537 6482\r\nALRM ATTEMPTED TO CALL NO ANSWR\r\n\r\n\r\n\r\n

*/

public class MNHennepinCountyParser extends FieldProgramParser {
  
  private static final Pattern FIELD_PTN = Pattern.compile("; *([A-Z]+)-");
  
  public MNHennepinCountyParser() {
    super("HENNEPIN COUNTY", "MN",
          "NAME LOC:ADDR APT:APT PLACE:PLACE EVTYPE:CALL COMMENTS:INFO cross_streets:X");
  }
  
  @Override
  public String getFilter() {
    return "sheriff.cadpaging@co.hennepin.mn.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("NAME-")) return false;
    body = body.substring(5).trim();
    
    // Convert wierd field delimiters to standard colon terminated keywords
    body = FIELD_PTN.matcher(body).replaceAll(" $1: ");
    body = body.replace(" [#", " APT:").replace(" [@", " PLACE:").replace("cross streets :", "cross streets:");
    return super.parseMsg(body, data);
  }
  
  // Ignore info field if same as address
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(":")) field = field.substring(0,field.length()-1).trim();
      if (field.equals(data.strAddress)) return;
      super.parse(field, data);
    }
  }
  
  // Cross stree field may have more info at end separated by double blanks
  private static final Pattern CROSS_BREAK = Pattern.compile("  |\n");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CROSS_BREAK.matcher(field);
      if (match.find()) {
        data.strSupp = append(data.strSupp, "\n", field.substring(match.end()).trim());
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}