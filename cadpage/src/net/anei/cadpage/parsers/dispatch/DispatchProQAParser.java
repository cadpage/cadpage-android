package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

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

Medstar SW IL
[- part 1 of 1]  RC:Run# 34870/64 WEST BOUND//across from weight station/////male subj white car hit by a truck isp en route/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34859/505 LEMANS WAY///SCC PG 15/FAIRVIEW HEIGHTS///55yof unc diff b possible overdose on pills - adavan tramadol/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34577/20 KINDER ST//cah/SCC PG 11/EAST SAINT LOUIS///31f c/b chest and back px cardiac hx  ProQA comments: chest px/10D04
[- part 1 of 1]  RC:Run# 34384/1308 CORLISS//westinghouse and n greenmount//SHILO///38m c/b rapid heart rate/<PROQA_DET>
[- part 1 of 1]  RC:Run# 34620/13 LOISEL DR///SCC PG 14/EAST SAINT LOUIS///70 M C/B CONFUSED ProQA comments: UNK/31D03

*/

public class DispatchProQAParser extends FieldProgramParser {
  
  protected DispatchProQAParser(String defCity, String defState, String program) {
    super(defCity, defState, program);
  }
  
  protected DispatchProQAParser(Properties cityCodes, String defCity, String defState, String program) {
    super(cityCodes, defCity, defState, program);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Parse run number from first field
    int pt = body.indexOf("RC:Run# ");
    if (pt < 0) return false;
    pt += 8;
    int pt2 = body.indexOf("/", pt);
    if (pt2 < 0) return false;
    
    data.strCallId = body.substring(pt, pt2).trim();

    body = body.substring(pt2+1);
    pt = body.indexOf("/<PROQA_DET>");
    if (pt >= 0) body = body.substring(0,pt).trim();
    pt = body.indexOf("ProQA comments:");
    if (pt >= 0) body = body.substring(0,pt).trim();

    // Everything else is variable
    String[] lines = body.split("/+");
    for (int ndx = 0; ndx < lines.length; ndx++) {
      lines[ndx] = lines[ndx].trim();
    }
    return parseFields(lines, data);
  }
}
