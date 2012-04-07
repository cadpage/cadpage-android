package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Parser for ProQA Dispatch software

Longview, TX
RC:Run# 30209/ *Non Life Emergency P/2/ Sick Person (Specific Diagnosis)/ 1102 FRANCIS/ EASTON/ 18:21/ <Unknown>/ bp issues-- dizzy spells-- P
RC:Run# 30209/*Non Life Emergency P/1/Sick Person (Specific Diagnosis)/1102 FRANCIS///EASTON/18:21/////<Unknown>/bp issues-- dizzy spells--
RC:Run# 29907/PR Event/Public Service/CRYSTAL FARMS RD///TATUM/19:15/////PR EVENT/ TATUM/Tatum vs Harmony////
RC:Run# 29793/*Non Life Emergency P/1/Falls/301 B FORREST ACRES///TATUM/22:18/////<Unknown>/////
RC:Run# 29764/*Non Life Emergency P/1/Overdose / Poisoning (Ingestion)/1100 S ADAMS ST//Panola Apts: 32/CARTHAGE/17:23/////<Unknown>/////

 
Northglenn EMS, CO
- part 1 of 1 / RC:Run# 10174/6211 OLIVE ST///Pregnancy / Childbirth/
- part 1 of 1 / RC:Run# 9913/5541 E 67TH AVE//med alarm/Not Available/
- part 1 of 1 / RC:Run# 9911/7373 BIRCH ST///Unconscious / Fainting/
- part 1 of 1 / RC:Run# 10172/8810 E 88TH AVE///Assault/
- part 1 of 1 / RC:Run# 10119/E 60TH AVE & DAHLIA ST//./Unconscious / Fainting/
Subject:- part 1 of 1\nRC:Run# 3769/3015 CALIFORNIA ST//out of control child hit head/Not Known//\n
Subject:- part 1 of 1\nRun# 5678/ 1301 PONTIAC ST/ Fall Victim\n

Medstar SW IL
[- part 1 of 1]  RC:Run# 34870/64 WEST BOUND//across from weight station/////male subj white car hit by a truck isp en route/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34859/505 LEMANS WAY///SCC PG 15/FAIRVIEW HEIGHTS///55yof unc diff b possible overdose on pills - adavan tramadol/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34577/20 KINDER ST//cah/SCC PG 11/EAST SAINT LOUIS///31f c/b chest and back px cardiac hx  ProQA comments: chest px/10D04
[- part 1 of 1]  RC:Run# 34384/1308 CORLISS//westinghouse and n greenmount//SHILO///38m c/b rapid heart rate/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34620/13 LOISEL DR///SCC PG 14/EAST SAINT LOUIS///70 M C/B CONFUSED ProQA comments: UNK/31D03

Mobile Medical Response, MI 
Subject:<CAD> - part 1 of 1\nRC:Run# 17656/11775 N ISABELLA RD/P-2 Emergency No Lights//Chest Pain (Non-Traumatic)/herrick and pere marquette
Subject:<CAD> - part 1 of 1\nRC:Run# 17612/7800 LUDINGTON DR/P-3 Downgrade  (No Lts/Sirens)//Falls/x gibson and lake station ave on 
Subject:<CAD> - part 1 of 1\nRC:Run# 16888/7181 N CLARE/P-1 Life Threatening Emergency//Cardiac or Respiratory Arrest/Death/x forres
Subject:<CAD> - part 1 of 1\nRC:Run# 17723/600 SE 4TH ST/P-1 Life Threatening Emergency/nurses station/Sick Person (Specific Diagnos
Subject:<CAD> - part 1 of 1\nRC:Run# 17923/10197 S CLARE AVE/P-2 Emergency No Lights//Chest Pain (Non-Traumatic)/dept corrections bu
Subject:<CAD> - part 1 of 1\nRC:Run# 17874/521 S SCOTT DR/P-1 Life Threatening Emergency//Breathing Problems/was in ER Saturday/ dx 
Subject:<CAD> - part 1 of 1\nRC:Run# 17991/391 MILL ST/P-2 Emergency No Lights/D/Sick Person (Specific Diagnosis)/pt had knee replac
Subject:<CAD> - part 1 of 1\nRC:Run# 17893/235 GATEWAY DR/P-1 Life Threatening Emergency/105/Breathing Problems//ALS/CLARE///<Unknow
Subject:<CAD> - part 1 of 1\nRC:Run# 17970/602 BEECH ST/P-5 Local Transport/2ND FLOOR 205-A MED SURG/Int-Sick Person-Specify in Comm

Atlanticare EMS, NJ (Atlantic & Cape May Counties)
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54365/LINWOOD-EMS/199 NEW RD/law office in central square/LINWOOD/11:14/////////<Unknown>
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54353/MICU/42 ROUTE 50/X KRUK TERRACE/OCEAN VIEW/10:16///////SEAVILLE//<Unknown>
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54345/MICU/117 HARRISON AVE/x new rd/PLEASANTVILLE/09:36/////////<Unknown>
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54374/MICU/301 W  DELILAH RD/U7/PLEASANTVILLE/12:08/////////<Unknown>

*/

public class DispatchProQAParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("\\bRun# ");
  
  protected DispatchProQAParser(String defCity, String defState, String program) {
    super(defCity, defState, program);
  }
  
  protected DispatchProQAParser(Properties cityCodes, String defCity, String defState, String program) {
    super(cityCodes, defCity, defState, program);
  }
  
  protected DispatchProQAParser(String[] cityList, String defCity, String defState, String program) {
    super(cityList, defCity, defState, program);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Parse run number from first field
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    int pt = match.end();
    int pt2 = body.indexOf("/", pt);
    if (pt2 < 0) return false;
    
    data.strCallId = body.substring(pt, pt2).trim();

    body = body.substring(pt2+1);
    pt = body.indexOf("ProQA comments:");
    if (pt >= 0) body = body.substring(0,pt).trim();

    // Everything else is variable
    String[] lines = body.split("/+");
    return parseFields(lines, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("<PROQA_DET>")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new BaseInfoField();
    return super.getField(name);
  }
}
