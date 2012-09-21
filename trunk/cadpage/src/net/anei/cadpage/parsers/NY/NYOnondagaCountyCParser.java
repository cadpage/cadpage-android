package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA8Parser;


/*
Onondaga County, NY (Variant C)
Sender: wavescalls@me.com

(Dispatch) Dispatch ** 07:06:07 ** E-PERSONAL INJURY ** 916 STATE FAIR BLVD ** SNOWBIRDS LANDING II-NEAR THE **  ** (315) 460-0168 **  **  ** MALE FELL APPEARS UNSTABLE\nNumber of patients: 1\nResponder script: 86 year old, Male, Conscious, Breathing. Falls. Caller\nStatement: MALE FELL APPEARS UNSTABLE .\nMALE FELL APPEARS UNSTABLE\nRespon ** 05/26/12 ** PINJ ** WVE128700889 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-26-2012  07:06:07\nAgency: GBE \n    Event: E12052600040\n\nCase Number: WVE128700889\nEvent Type Code: PINJ PERSONAL INJURY\nEvent Subtype Code:         \n\nAddress:\nSNOWBIRDS LANDING II\n916  STATE FAIR BLVD \nLocation Info: NEAR THE ST IFO THIS LOCATION \n\nMunicipality: TGD\nCross Street: CONKLIN ST AND SENECA ST\n\nCaller Information:\n\n  Caller Name: \n  Caller Phone Number: (315) 460-0168\n  Caller Address: \n\nResponding Units:\n\n  87A3  WVE1  EMS\n ** TGD **  ** GB **  ** CONKLIN ST AND SENECA ST **  ** A3, ** 
(Dispatch) Dispatch ** 12:02:25 ** E-DIFFICULTY BREATHING ** 700 EAGLE LN ** -APT 9 ** TOLBERT,SHAVON ** (315) 876-1934 **  **  ** TIGHTNESS IN CHEST\nNumber of patients: 1\nResponder script: 30 year old, Female, Conscious, Breathing. Breathing Problems.\nCaller Statement: TIGHTNESS IN CHEST .\nSAYS SHE HAS ASTHMA\nSCRATCHY THROA ** 05/26/12 ** DIFB ** WVE128700893 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-26-2012  12:02:25\nAgency: WVE \n    Event: E12052600094\n\nCase Number: WVE128700893\nEvent Type Code: DIFB DIFFICULTY BREATHING\nEvent Subtype Code:         \n\nAddress:\n\n700  EAGLE LN \nLocation Info: APT 9 \n\nMunicipality: TCM\nCross Street: ARLINGTON SQ AND ARLINGTON SQ\n\nCaller Information:\n\n  Caller Name: TOLBERT,SHAVON\n  Caller Phone Number: (315) 876-1934\n  Caller Address: \n\nResponding Units:\n\n  87A4  WVE1  EMS\n  \n\nEvent Comments:\nTIGHT ** TCM **  ** WV **  ** ARLINGTON SQ AND ARLINGTO **  ** A4, ** 
(Dispatch) Dispatch ** 22:11:48 ** E-DIABETIC EMERGENCY ** 2 WALLACE AVE ** - ** NARUSKY, ROBERT J ** (315) 672-3455 **  **  ** NARUSKY, ROBERT J RESD 05/26 22:09:55\nLOW BLOOD SUGAR\nLOW BLOOD SUGAR OF 73\nNumber of patients: 1\nResponder script: 86 year old, Male, Conscious, Breathing. Diabetic Problems.\nCaller Statement: L ** 05/26/12 ** DIAB ** WVE128700894 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  22:11:48\nAgency: WVE \n    Event: E12052600217\n\nCase Number: WVE128700894\nEvent Type Code: DIAB DIABETIC EMERGENCY\nEvent Subtype Code:         \n\nAddress:\n\n2  WALLACE AVE \nLocation Info: \n\nMunicipality: VCM\nCross Street: ELDERKIN AVE AND KASTOR AVE\n\nCaller Information:\n\n  Caller Name: NARUSKY, ROBERT J\n  Caller Phone Number: (315) 672-3455\n  Caller Address: 2 WALLACE AV CAMILLUS_VILLAGE\n\nResponding Units:\n\n  87A4  WVE1  EMS\n  \n\n ** VCM **  ** WV **  ** ELDERKIN AVE AND KASTOR A **  ** A4, ** 
(Dispatch) Dispatch ** 11:23:30 ** E-DIABETIC EMERGENCY ** 4611 W GENESEE ST ** FAIRMOUNT FD- **  **  **  **  ** PER 19 BASE\n ** 05/26/12 ** DIAB ** WVE128700892 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-26-2012  11:23:30\nAgency: WVE \n    Event: E12052600088\n\nCase Number: WVE128700892\nEvent Type Code: DIAB DIABETIC EMERGENCY\nEvent Subtype Code:         \n\nAddress:\nFAIRMOUNT FD\n4611 W GENESEE ST \nLocation Info: \n\nMunicipality: TCM\nCross Street: MALE AVE AND TURNER AVE\n\nCaller Information:\n\n  Caller Name: \n  Caller Phone Number: \n  Caller Address: \n\nResponding Units:\n\n  87A4  WVE1  EMS\n  \n\nEvent Comments:\nPER 19 BASE\n** Case number SHP ** TCM **  ** WV **  ** MALE AVE AND TURNER AVE **  ** A4, ** 
(Dispatch) Dispatch ** 11:00:32 ** E-CHEST PAIN POSSIBLE HEART ** 5101 W GENESEE ST ** -ST. JOSEPH DYALIS UNIT ** VELANTI,ELIZABETH ** (315) 488-2979 **  **  ** ST JOSEPH'S HOSPITAL HEALTH PBXb 05/26 10:55:50\nSPECIAL ADDRESS COMMENT:\nThis record created by the CADAVU (Address Verification Utility) program.\nIRREGULAR HEART RATE\nNumber of patients: 1\nRespo ** 05/26/12 ** CARD ** WVE128700891 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  11:00:32\nAgency: WVE \n    Event: E12052600082\n\nCase Number: WVE128700891\nEvent Type Code: CARD CHEST PAIN-POSS HEART\nEvent Subtype Code:         \n\nAddress:\n\n5101 W GENESEE ST \nLocation Info: ST. JOSEPH DYALIS UNIT\n\nMunicipality: TCM\nCross Street: DUNNING DR AND STONEHEDGE RD\n\nCaller Information:\n\n  Caller Name: VELANTI,ELIZABETH\n  Caller Phone Number: (315) 488-2979\n  Caller Address: 5101 W GENESEE CAMILLUS_TOWN\n\nResponding Un ** TCM **  ** WV **  ** DUNNING DR AND STONEHEDGE **  ** A3, ** 
(Dispatch) Dispatch ** 10:07:49 ** E-MOTOR VEHICLE COLLISION-WITH INJURIES ** 5399 W GENESEE ST ** WALMART- **  ** (315) 406-0904 **  **  ** SPECIAL ADDRESS COMMENT:\nCROSS STREETS ARE VANIDA DR AND KASSON RD\nM911 CC IS EMPLOYEE SAYS 60'S FEMALE HIT A LIGHT POLE IN LOT-STATES NO INJ BUT\nAPPEARS SHAKEN\n ** 05/26/12 ** MVC-I ** WVE128700890 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  10:07:49\nAgency: WVE \n    Event: E12052600068\n\nCase Number: WVE128700890\nEvent Type Code: MVC  MOTOR VEHICLE COLLISION\nEvent Subtype Code: IB        INJURIES PRESENTED\n\nAddress:\nWALMART\n5399 W GENESEE ST \nLocation Info: \n\nMunicipality: TCM\nCross Street: VANIDA DR AND CAMILLUS COMMONS\n\nCaller Information:\n\n  Caller Name: \n  Caller Phone Number: (315) 406-0904\n  Caller Address: \n\nResponding Units:\n\n  87A3  WVE1  EMS\n  \n\nEvent Co ** TCM **  ** WV **  ** VANIDA DR AND CAMILLUS CO **  ** A3, ** 
(Dispatch) Dispatch ** 22:00:39 ** E-EXPOSURE TO HEAT-Heat ** 1500 ELM CIR ** -APT 10 , ELM HILL ESTATES ** LAMONTAGNE,REIS ** (315) 382-6668 **  **  ** N SECTOR -076.270115 043.050849 CAUTION: WIRELESS CALL 05/27 21:57:20\nHEART WAS RACING,SHAKY,LITTLE DISO\nNumber of patients: 1\nResponder script: 27 year old, Male, Conscious, Breathing. Heat / Cold ** 05/27/12 ** EXPO-H ** WVE128700897 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-27-2012  22:00:39\nAgency: WVE \n    Event: E12052700172\n\nCase Number: WVE128700897\nEvent Type Code: EXPO EXPOSURE\nEvent Subtype Code: H       Heat\n\nAddress:\n\n1500  ELM CIR \nLocation Info: APT 10 , ELM HILL ESTATES \n\nMunicipality: TCM\nCross Street: ARLINGTON SQ \n\nCaller Information:\n\n  Caller Name: LAMONTAGNE,REIS\n  Caller Phone Number: (315) 382-6668\n  Caller Address: \n\nResponding Units:\n\n  87A3  WVE1  EMS\n  \n\nEvent Comments:\nN SECTO ** TCM **  ** WV **  ** ARLINGTON SQ **  ** A3, ** 
(Dispatch) Dispatch ** 10:35:32 ** E-GENERAL ILLNESS ** 401 ANSONIA CT ** -OFF W GENESEE ** MCINTYRE MARTHA ** (315) 399-4889 **  **  ** TWCBL MCINTYRE MARTHA VOIP 05/27 10:30:15\nDRUG WITHDRAWEL\nNumber of patients: 1\nResponder script: 62 year old, Female, Conscious, Breathing. Sick Person\n(Specific Diagnosis). Caller Statement: DRU ** 05/27/12 ** GILL ** WVE128700896 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-27-2012  10:35:32\nAgency: WVE \n    Event: E12052700064\n\nCase Number: WVE128700896\nEvent Type Code: GILL GENERAL ILLNESS\nEvent Subtype Code:         \n\nAddress:\n\n401  ANSONIA CT \nLocation Info: OFF W GENESEE\n\nMunicipality: TCM\nCross Street: VANTAGE DR \n\nCaller Information:\n\n  Caller Name: MCINTYRE MARTHA\n  Caller Phone Number: (315) 399-4889\n  Caller Address: 401 ANSONIA CT CAMILLUS_TOWN\n\nResponding Units:\n\n  87A3  WVE1  EMS\n  \n\nEvent C ** TCM **  ** WV **  ** VANTAGE DR **  ** A3, ** 
(Dispatch) Dispatch ** 23:34:07 ** E-PERSONAL INJURY ** 5731 NORTH ST ** - ** GENDRON, DONALD ** (315) 345-9566 **  **  ** - DISORIENTED -\nNumber of patients: 1\nResponder script: 91 year old, Female, Conscious, Breathing. Falls. Caller\nStatement: - DISORIENTED - .\n- DISORIENTED -\nResponse text: Delta\nResponder scrip ** 05/26/12 ** PINJ ** WVE128700895 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  23:34:07\nAgency: WVE \n    Event: E12052600232\n\nCase Number: WVE128700895\nEvent Type Code: PINJ PERSONAL INJURY\nEvent Subtype Code:         \n\nAddress:\n\n5731  NORTH ST \nLocation Info: \n\nMunicipality: TCM\nCross Street: RYAN WAY \n\nCaller Information:\n\n  Caller Name: GENDRON, DONALD\n  Caller Phone Number: (315) 345-9566\n  Caller Address: \n\nResponding Units:\n\n  87A4  WVE1  EMS\n  \n\nEvent Comments:\n- DISORIENTED -\nNumber of patient ** TCM **  ** WV **  ** RYAN WAY **  ** A4, ** 
(Dispatch) Dispatch ** 02:15:19 ** E-DIFFICULTY BREATHING ** 133 EAGLE CREST DR ** - ** GRECCO, JAMES ** (315) 672-9739 **  **  ** TWCBL GRECCO, JAMES VOIP 05/28 02:13:59\nDIFB\nNumber of patients: 1\nResponder script: 14 year old, Male, Conscious, Breathing. Breathing Problems.\nCaller Statement: DIFB.\nResponse text: Delta\nRes ** 05/28/12 ** DIFB ** WVE128700898 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-28-2012  02:15:19\nAgency: WVE \n    Event: E12052800019\n\nCase Number: WVE128700898\nEvent Type Code: DIFB DIFFICULTY BREATHING\nEvent Subtype Code:         \n\nAddress:\n\n133  EAGLE CREST DR \nLocation Info: \n\nMunicipality: TCM\nCross Street: IKE DIXON RD AND RAIL FENCE RD\n\nCaller Information:\n\n  Caller Name: GRECCO, JAMES\n  Caller Phone Number: (315) 672-9739\n  Caller Address: 133 EAGLE CREST DR CAMILLUS_TOWN\n\nResponding Units:\n\n  87A3  WVE1   ** TCM **  ** WV **  ** IKE DIXON RD AND RAIL FEN **  ** A3, ** 

*/


public class NYOnondagaCountyCParser extends DispatchA8Parser {

  public NYOnondagaCountyCParser() {
    super("ONONDAGA COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "wavescalls@me.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf('\n');
    String sExtra = "";
    if (pt >= 0) {
      sExtra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
    }
    if (! super.parseMsg(body, data)) return false;
    
    Parser p = new Parser(sExtra);
    data.strSource = getPatternValue(p, AGENCY_PTN);
    data.strCity = convertCodes(getPatternValue(p, MUNICIPALITY_PTN), CITY_CODES);
    data.strCross = getPatternValue(p, CROSS_STREET_PTN);
    data.strUnit = getPatternValue(p, UNIT_PTN);
    
    return true;
  }
  
  private static final Pattern AGENCY_PTN = Pattern.compile("\n *Agency: *(.*)(?=\n)");
  private static final Pattern MUNICIPALITY_PTN = Pattern.compile("\n *Municipality: *([A-Z]+)(?=\n)");
  private static final Pattern CROSS_STREET_PTN = Pattern.compile("\n *Cross Street: *(.*)(?=\n)");
  private static final Pattern UNIT_PTN = Pattern.compile("\n *Responding Units: *\n* *(.*?)(?=\n|\\*\\*|$)");
  
  private String getPatternValue(Parser p, Pattern ptn) {
    Matcher match = p.getMatcher(ptn);
    return (match == null ? "" : match.group(1).trim());
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " SRC CITY X UNIT";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "TCM", "CAMILLUS",
      "TGD", "GEDDES",
      "VCM", "CAMILLUS",
  });
}
	