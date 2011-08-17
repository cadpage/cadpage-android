package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Hamilton County, OH
Contact: Brian Fels <bfels.fd@northcollegehill.org>
Contact: "Jim Klems" <JimK@forestpark.org
Sender: hc@hamilton-co.org

HC:STRUCTURE FIRE 8877 DE SOTO DR SPTP NEISHA COOK/NGHBR ** STRUCTURE FIRE ** INV REF.. SMOKE & FLAMES VISIBLE FROM THE ROOF.. RESD POSS UNOCC, COMPL A 22:43 HFE75 HFE74 HFQ79 HFQ78 HFR79 HFS26 HFRAT97 HFFG3 HFIMAT79 XST: 1331 ANGELA AV XST
HC:STRUCTURE FIRE 12135 SPALDING DR COTP MATT GITTERMAN ** STRUCTURE FIRE ** ODOR OF PLASTIC BURNING LIGHT SMOKE FROM AN ATTIC VENT...CEILING IN THE K 06:47 HFE109 HFE102 HFE42 HFL25 HFL42 HFS25 HFRAT25 HFFG3 HFIMAT25 XST: 12037 WESTERLY DR
HC:STRUCTURE FIRE W CRESCENTVILLE RD&SPRINGFIELD SPDL PLANT MAINT ENG WIRELESS-VERIZON WIR ** STRUCTURE FIRE ** ROOF VENT ON FIRE 14:10 HFE90 HFE43 HFT90 HFT86 HFM90 HFFRFDM32 HFRAT96 HFFG5
HC:A/A - INJURY LEMONTREE DR&MILL RD FRPK INTERSECTION T-MOBILE USA, INC. ** AUTO ACCIDENT / PERSON INJURED ** INV FOR A 2 VEH, MC VS A VEH 14:53 HFM242 HFE42 HFL42 HFFG2
HC:PSYCHIATRIC EMER 5 BELKNAP PL GREN DOROTHY, MOM ** PSYCHIATRIC EMERGENCY ** C C REF 5 YO BEHAVING VIOLENTLY, ACTING OUT. HX OF BEHAVIORAL ISSUES. 16:59 HFS48 XST: 14 BACHMAN ST XST2: 26 BACHMAN ST
HC:FIRE ALARM 1086 PENNINGTON CT FRPK CHRISTINE ** FIRE ALARM ** INV...NOTHING SHOWING..COMP BELIEVES IT COULD BE A MALFUNTION WITH ALARM. 09:08 HFE43 HFL42 HFFG3 XST2: 11551 PROMENADE DR
HC:NON-BREATHER 37 GAMBIER CR GREN MICHEAL MARCUM ** NON-BREATHER / CARDIAC ARREST ** M/70'S, COMP CAN SEE M SUBJ LAYING ON THE FLOOR OF THE RESD THRU A WINDOW 20:29 HFS48 HFQ48 HFFG5 XST: 300 INGRAM RD XST2: 300 INGRAM RD
HC:UNCONSCIOUS PERSON 22 JEWEL LN GREN TIM SHEEIN ** PERSON UNCONSCIOUS / NON-RESPONSIVE ** F/46 DISORIENTED, POSS REACTION TO MEDS FOR MIGRANES 20:33 HFM242 HFGRES XST: 158 JUNEFIELD AV XST2: 168 JUNEDALE DR
HC:APPLIANCE FIRE 616 DEWDROP CR FRPK APT C CHRISTINA ** APPLIANCE FIRE ** GREASE FIRE ON THE STOVE 21:03 HFE43 HFE296 HFE97 HFE45 HFT90 HFL97 HFS97 HFRAT79 HFFG2 XST: 599 ASHBURN RD XST2: 601 DINSMORE DR
HC:STRUCTURE FIRE 70 DAMON RD GREN ALOIS ALZHEIMER CTR STEPHANIE ** STRUCTURE FIRE ** INVS SMOKE FILLING HALLS 05:05 HFQ48 HFE42 HFE109 HFE75 HFR78 HFL42 HFM96 HFRAT74 HFFG2 HFIMAT48 XST: 1200 SPRINGDALE RD XST2: 48 CROMWELL RD


*/

public class OHHamiltonCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("HC:(.*) \\*\\* (.*) \\*\\* (.*) \\d\\d:\\d\\d (.*)");
 
  public OHHamiltonCountyParser() {
    super(CITY_CODES, "HAMILTON COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "hc@hamilton-co.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(StartType.START_SKIP, match.group(1).trim(), data);
    data.strAddress = data.strAddress.replace("DE SOTO", "DESOTO");
    String sName = getLeft();
    if (sName.startsWith("APT ")) {
      Parser p = new Parser(sName.substring(4).trim());
      data.strApt = p.get(' ');
      sName = p.get();
    }
    data.strName = sName;
    data.strCall = match.group(2).trim();
    data.strSupp = match.group(3).trim();
    Parser p = new Parser(match.group(4).trim());
    String x2 = p.getLastOptional(" XST2:");
    String x1 = p.getLastOptional(" XST:");
    data.strUnit = p.get();
    data.strCross = append(x1, " & ", x2);
    
    return true;
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "COTP", "COLERAIN TWP",
      "FRPK", "FOREST PARK",
      "GREN", "GREENHILLS",
      "SPDL", "SPRINGDALE",
      "SPTP", "SPRINGFIELD TWP",
      
      "AMBF", "AMBERLEY",
      "ANDF", "ANDERSON TWP",
      "BLUF", "BLUE ASH",
      "DRPF", "DEER PARK",
      "EVEF", "EVENDALE",
      "GLEF", "GLENDALE",
      "GOLI", "GOLF MANOR",
      "LINF", "LINCOLN HEIGHTS",
      "LMFD", "LITTLE MIAMI",
      "LOCF", "LOCKLAND",
      "LOVF", "LOVELAND SYMMES TWP",
      "MDRF", "MADEIRA-INDIAN HILL",
      "MRMF", "MARIEMONT",
      "MILI", "MILFORD",
      "MONF", "MONTGOMERY",
      "REAF", "READING",
      "SHRF", "SHARONVILLE",
      "SPDF", "SPRINGDALE",
      "SYCF", "SYCAMORE TWP",
      "TERF", "TERRACE PARK",
      "WOOF", "WOODLAWN",
      "WYOF", "WYOMING",
      
      "CHEF", "CHEVIOT",
      "CLVF", "CLEVES",
      "COTF", "COLERAIN TWP",
      "CROF", "CROSBY TWP",
      "DLHF", "DELHI TWP",
      "ELMF", "ELMWOOD PLACE",
      "FRPF", "FOREST PARK",
      "GRTF", "GREEN TWP",
      "GREF", "GREENHILLS",
      "HARF", "HARRISON",
      "MITF", "MIAMI TWP",
      "NCHF", "NORTH COLLEGE HILL",
      "SPTF", "SPRINTFIELD TWP",
      "STBF", "ST BERNARD",
      "WWTF", "WHITEWATER TWP"
  });
}
