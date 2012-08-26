package net.anei.cadpage.parsers.IL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/*
Medstar IL (Medical only in Randolf, Clinton, and St Clair counties)
Contact: l.keirstead@yahoo.com,6154407605@vzwpix.com
Sender: emsdispatch@medstarems.net
System: ProQA
[- part 1 of 1]  RC:Run# 34870/64 WEST BOUND//across from weight station/////male subj white car hit by a truck isp en route/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34859/505 LEMANS WAY///SCC PG 15/FAIRVIEW HEIGHTS///55yof unc diff b possible overdose on pills - adavan tramadol/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34577/20 KINDER ST//cah/SCC PG 11/EAST SAINT LOUIS///31f c/b chest and back px cardiac hx  ProQA comments: chest px/10D04
[- part 1 of 1]  RC:Run# 34384/1308 CORLISS//westinghouse and n greenmount//SHILO///38m c/b rapid heart rate/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34620/13 LOISEL DR///SCC PG 14/EAST SAINT LOUIS///70 M C/B CONFUSED ProQA comments: UNK/31D03
(- part 1 of 1) RC:Run# 35456/STATE HWY 157 & STATE HWY 15//Centerville/SCC PG 13/EAST SAINT LOUIS///pedestian struck/<PROQA_DET>
(- part 1 of 1) RC:Run# 35411/St Elizabeths B'vll/IN PATIENT/634 1/SCC PG 26/BELLEVILLE/119 KENSINGTON HEIGHTS RD//f extreme weakness unable to support s

Contact: Scott Fry <emtbasic12@gmail.com>
1 of 2\nFRM:emsdispatch@medstarems.net\nSUBJ:- part 1 of 1\nMSG:RC:Run# 17158/St Elizabeths B'vll/IN PATIENT/347-2/SCC PG26/BELLEVILLE/429 S MAIN\n(Con't) 2 of 2\nST//CONFUSED POSS COMBATIVE NSE PCS AND FACESHEET REQ ***MEDICARE****\n(End)

Contact: Mark Bearth <mark.bearth@gmail.com>
RC:Run# 17411/451 3RD ST////BECKEMEYER///ST ANTHONY'S CHURCH  75YOM UNC/BREATHING NURSE ON SCENE ProQA comme

Contact: Active911
[- part 1 of 1] RC:Run# 23121/ATRIUM HEALTHCARE & REHAB//ROOM 2-3/SCC PG 23/CAHOKIA///Psychiatric/Suicide Attempt/40 YOF C/B PYSCH HX DID NOT RESPOND TO HALDAL/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23123/64 EAST BOUND AT 25TH ST////EAST SAINT LOUIS///Traffic Accidents/F PT C/B ROCK WENT THROUGH WINDOW/ GLASS IN MOUTH/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23124/502 S 17TH ST///SCC PG 26/BELLEVILLE///Psychiatric/Suicide Attempt/50 YOM C/B TOOK HANDFUL OF VICODEN PD ON SCENE/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23124/502 S 17TH ST///SCC PG 26/BELLEVILLE///Psychiatric/Suicide Attempt/50 YOM C/B TOOK HANDFUL OF VICODEN PD ON SCENE/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23126/1307 POTOMAC DR///SCC PG 27/BELLEVILLE///Breathing Problems/22 YOF PT C/SOB POSS ETOH/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23127/Red Bud Regional Hosp/ER DEPT/5//RED BUD/Touchette Reg Hosp/IN PATIENT//38 YOM C/B PSYCH EVAL/ SUICIDAL/ NSE/ PCS AND FACE SHEET REQUESTED/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23128/S 27TH ST & TRENDLEY AVE///SCC PG 12/EAST SAINT LOUIS///Unknown Problem (Man Down)/f subj slump over the wheel been there for more than an hour/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23129/Cedar Ridge//E-13-B/SCC PG 18/LEBANON///Transfer/Interfacility/Palliative Care/79YOF C/DIFF BREATHING ELEVATED B/P CODE LEVEL FULL/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23130/PD BELLEVILLE///SCC PG 26/BELLEVILLE///Assault/Rape/20YOM C/B FACIAL INJURIES FROM 10-1O/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23131/S 13TH ST & TUDOR AVE///SCC PG 12/EAST SAINT LOUIS///Traffic Accidents/10-50 ROLLOVER WITH ENTRAPMENT/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23132/3117 W BLVD////BELLEVILLE///Falls/Back Injuries (Traumatic)/PD ON SCENE 23 YOM C/B FELL DOWN STAIRS/ UNK INJ/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23134/Charles Gardens//ROOM 14/SCC PG 15/FAIRVIEW HEIGHTS///Hemorrhage/Lacerations/83 YOM C/B RECTAL BLEED/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23135/631 N 85TH ST///SCC PG 14/EAST SAINT LOUIS///Assault/Rape/28YOF C/B ASSAULTED PD 10-76 SUBJ STRUCK IN THE HEAD/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23136/804 N 33RD ST///SCC PG 3/EAST SAINT LOUIS///Sick Person (Specific Diagnosis)/47YOM C/B UNABLE TO GET UP/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23137/BELLEVILLE HEALTHCARE AND REHAB//404-2/SCC PG 26/BELLEVILLE///Transfer/Interfacility/Palliative Care/90YOF UNRESPONSIVE/B UNK PROBLEM CODE LEVELFULL/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23138/324 N JACKSON ST///SCC PG 26/BELLEVILLE///Unconscious/Fainting (Non-traumatic)/22YOF UNC/B UNK PROBLEM PD 10-76/<PROQA_DET>\r\n\r\n\n
[- part 1 of 1] RC:Run# 23139/N 21ST ST & SAINT CLAIR AVE///SCC PG 2/EAST SAINT LOUIS///Traumatic Injuries (Specific)/PD 10-23 WINDOWS BUSTED OUT GLASS HIT BABY/<PROQA_DET>\r\n\r\n\n

 */


public class ILMedstarParser extends DispatchProQAParser {
  
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "SCC", "ST CLAIR COUNTY"
  });
  
  private static final Pattern MAP_PAT = Pattern.compile("(.*?) +PG *(\\d+)");
  private static final Pattern APT_PAT = Pattern.compile("(?:RM|ROOM|APT|SUITE) .*|[-\\d ]+", Pattern.CASE_INSENSITIVE);
  private static final Pattern CROSS_PAT = Pattern.compile(".*(?:&| AND ).*", Pattern.CASE_INSENSITIVE);
  
  public ILMedstarParser() {
    super(COUNTY_CODES, "", "IL", null);
  }
  
  @Override
  public String getFilter() {
    return "emsdispatch@medstarems.net";
  }
  
  @Override
  public boolean parseFields(String[] fields, Data data) {
    
    if (fields.length < 3) return false;
    
    // First line is always the address
    int ndx = 1;
    for (String fld : fields) {
      switch (ndx) {
      
      // Line 1 is always the address
      case 1:
        parseAddress(fld, data);
        ndx++;
        break;
        
      // After that things get complicated  
      case 2:
        
        // See if it has a room signature
        if (APT_PAT.matcher(fld).matches()) {
          data.strApt = fld;
          break;
        }
        
        // Short 3 character fields are asssumed to be dispatcher initials
        // and ignored
        if (fld.length() <= 3) break;
        
        // Anything with a ' PG ' in it should be a county code and map page number
        Matcher match = MAP_PAT.matcher(fld);
        if (match.matches()) {
          data.strCity = convertCodes(match.group(1), COUNTY_CODES);
          data.strMap = match.group(2);
          break;
        }
        
        // Anything consisting of blanks and upper case letters is assumed to be a city
        // Any regular text lines found up to know become cross streets
        if (CITY_SET.contains(fld.toUpperCase())) {
          if (fld.equalsIgnoreCase("SHILO")) fld = "SHILOH";
          data.strCity = fld;
          fld = append(data.strCall, " / ", data.strSupp);
          if (CROSS_PAT.matcher(data.strCall).matches()) {
            data.strCross = fld;
          } else {
            data.strPlace = fld;
          }
          data.strCall = data.strSupp = "";
          ndx++;
          break;
        }
        
        // Otherwise fall through case and treat as call or info text
      case 3:
        if (fld.equals("<PROQA_DET>")) break;
        if (data.strCall.length() == 0) {
          data.strCall = fld;
        } else if (data.strSupp.length() > 0) {
          data.strSupp = data.strSupp + " / " + fld;
        } else if (isCallExtend(data.strCall, fld)) {
          data.strCall = data.strCall + "/" + fld;
        } else {
          data.strSupp = fld;
        }
        break;
      }
    }
    return true;
  }
  
  private boolean isCallExtend(String call, String info) {
    call = call.toUpperCase();
    info = info.toUpperCase();
    if (call.endsWith(" C") && info.startsWith("B ")) return true;
    if (call.endsWith(" Y") && info.startsWith("O ")) return true;
    if (info.equals("SUICIDE ATTEMPT")) return true;
    if (info.equals("RAPE")) return true;
    if (info.startsWith("BACK INJURIES")) return true;
    if (info.startsWith("LACERATIONS")) return true;
    if (info.startsWith("FAINTING")) return true;
    return false;
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      // Clinton County
      
      // Cities
      "BREESE",
      "CARLYLE",
      "CENTRALIA",
      "TRENTON",
      // Villages
      "ALBERS",
      "AVISTON",
      "BARTELSO",
      "BECKEMEYER",
      "DAMIANSVILLE",
      "GERMANTOWN",
      "HOFFMAN",
      "KEYESPORT",
      "HUEY",
      "NEW BADEN",
      "ST ROSE",
      // Townships
      "BREESE",
      "BROOKSIDE",
      "CARLYLE",
      "CLEMENT",
      "EAST FORK",
      "GERMANTOWN",
      "IRISHTOWN",
      "LAKE",
      "LOOKING GLASS",
      "MERIDIAN",
      "SAINT ROSE",
      "SANTA FE",
      "SUGAR CREEK",
      "WADE",
      "WHEATFIELD",
      
      // St Clair County
      
      // Cities and Towns
      "ALORTON",
      "BELLEVILLE",
      "BROOKLYN",
      "CAHOKIA",
      "CASEYVILLE",
      "CENTREVILLE",
      "COLLINSVILLE",
      "DUPO",
      "EAST CARONDELET",
      "EAST ST LOUIS",
      "EAST SAINT LOUIS",
      "FAIRMONT CITY",
      "FAIRVIEW HEIGHTS",
      "FAYETTEVILLE",
      "FREEBURG",
      "LEBANON",
      "LENZBURG",
      "MARISSA",
      "MASCOUTAH",
      "MILLSTADT",
      "NEW ATHENS",
      "O'FALLON",
      "SAUGET",
      "SCOTT AFB",
      "SHILOH",
      "SHILO",    // Dispatch typo
      "SMITHTON",
      "ST. LIBORY",
      "SUMMERFIELD",
      "SWANSEA",
      "WASHINGTON PARK",
      // Townships
      "BELLEVILLE",
      "CANTEEN",
      "CASEYVILLE",
      "CENTREVILLE",
      "ENGELMANN",
      "FAYETTEVILLE",
      "FREEBURG",
      "LEBANON",
      "LENZBURG",
      "MARISSA",
      "MASCOUTAH",
      "MILLSTADT",
      "NEW ATHENS",
      "O'FALLON",
      "PRAIRIE DU LONG",
      "ST CLAIR",
      "SHILOH VALLEY",
      "SMITHTON",
      "STITES",
      "STOOKEY",
      "SUGARLOAF",
      
      // Randolf County
      
      // Cities and Towns
      "BALDWIN",
      "CHESTER",
      "COULTERVILLE",
      "ELLIS GROVE",
      "EVANSVILLE",
      "KASKASKIA",
      "PERCY",
      "PRAIRIE DU ROCHER",
      "RED BUD",
      "ROCKWOOD",
      "RUMA",
      "SPARTA",
      "STEELEVILLE",
      "TILDEN",
      // Unincorprated communities
      "GLENN",
      "GRIGG",
      "MENARD",
      "MODOC",
      "SCHULINE",
      "WALSH",
      "WELGE",
      "WINE HILL"
  }));
}
