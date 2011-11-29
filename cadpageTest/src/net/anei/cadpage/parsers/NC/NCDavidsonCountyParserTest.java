package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NC.NCDavidsonCountyParser;

import org.junit.Test;


public class NCDavidsonCountyParserTest extends BaseParserTest {
  
  public NCDavidsonCountyParserTest() {
    setParser(new NCDavidsonCountyParser(), "DAVIDSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:50PD-MOTOR VEH/PD ONLY;3248 FRIENDSHIP LEDFORD RD;2010024643;SADDLECHASE LN;MOTSINGER RD;OIL AND FLUIDS ON ROADWAY [12/17/10 11:05:24 BHUGHES] UDTS:",
        "ID:2010024643",
        "CALL:50PD-MOTOR VEH/PD ONLY",
        "ADDR:3248 FRIENDSHIP LEDFORD RD",
        "X:SADDLECHASE LN & MOTSINGER RD",
        "INFO:OIL AND FLUIDS ON ROADWAY / UDTS:");
    
    doTest("T2",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 S/MM 99;2010024707;[Medical Priority Info] PROBLEM: traffic accident # PATS: 1 AGE: Unknown Range SEX: Unknown CONSCIOU",
        "ID:2010024707",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:I 85 S & MM 99",
        "INFO:traffic accident # PATS: 1 AGE: Unknown Range SEX: Unknown CONSCIOU"
        );
    doTest("T3",
        "CAD:HOUSE/SINGLE DWELLING;3637 BECKS CHURCH RD;2010024363;HUCKLE PL;NC HWY 47;[Fire Priority Info] PROBLEM: KITCHEN FIRE [12/14/10 18:25:04 BPOOLE] [Fire P",
        "ID:2010024363",
        "CALL:HOUSE/SINGLE DWELLING",
        "ADDR:3637 BECKS CHURCH RD",
        "X:HUCKLE PL & NC HWY 47",
        "INFO:KITCHEN FIRE"
        );
    doTest("T4",
        "CAD:P26-SICK-DELTA;4970 REID RD;2010024356;EASTVIEW DR;[Medical Priority Info] PROBLEM: SICK # PATS: 1 AGE: 78 Years SEX: Female CONSCIOUS: Yes BREATHING:",
        "ID:2010024356",
        "CALL:P26-SICK-DELTA",
        "ADDR:4970 REID RD",
        "X:EASTVIEW DR",
        "INFO:SICK # PATS: 1 AGE: 78 Years SEX: Female CONSCIOUS: Yes BREATHING:"
        );
    doTest("T5",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 S/MM 96;2010025333;unk on inj, near mm97 [12/26/10 09:57:18 CHUFF] JUST NORTH OF THE 96....UKN INJ",
        "ID:2010025333",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:I 85 S & MM 96",
        "INFO:unk on inj, near mm97 / JUST NORTH OF THE 96....UKN INJ"
        );
    
    doTest("T6",
        "CAD:SMOKE INVESTIGATION;JOHNSONTOWN RD/TAFT HEDRICK RD;2010025211;no need for dispatch [12/25/2010 14:19:26 ASTILL]",
        "ID:2010025211",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:JOHNSONTOWN RD & TAFT HEDRICK RD",
        "INFO:no need for dispatch"
        );
    
    doTest("T7",
        "CAD:P29-TRAFFIC ACCIDENT-BRAVO;I 85 N/MM 98;2010025251;[Medical Priority Info] PROBLEM: 10-50 # PATS: 255 AGE: Unknown Range SEX: Unkn",
        "ID:2010025251",
        "CALL:P29-TRAFFIC ACCIDENT-BRAVO",
        "ADDR:I 85 N & MM 98",
        "INFO:10-50 # PATS: 255 AGE: Unknown Range SEX: Unkn"
        );

    doTest("T20",
        "CAD:CANCEL;2006 JOHNSONTOWN RD; THA",
        "CALL:CANCEL",
        "ADDR:2006 JOHNSONTOWN RD");
    
    doTest("T21",
        "CAD:Co Fire TAC4 for call;I 85 S/MM 96; LEX;4075477164",
        "CALL:Co Fire TAC4 for call",
        "ADDR:I 85 S & MM 96",
        "ID:4075477164");
    
    doTest("T22",
        "CAD:Co Fire Tac3 for call;3136 MOCK RD; HP",
        "CALL:Co Fire Tac3 for call",
        "ADDR:3136 MOCK RD");
        
    doTest("T23",
        "  / CAD:Fire Under Control;N COUNTY HOME RD/BRIAR PATCH DR; LEX;3473996166\n",
        "CALL:Fire Under Control",
        "ADDR:N COUNTY HOME RD & BRIAR PATCH DR",
        "ID:3473996166");

    doTest("T24",
        "  / CAD:Co Fire Tac5 for call;I 85 S/MM 96; LEX;3367062145",
        "CALL:Co Fire Tac5 for call",
        "ADDR:I 85 S & MM 96",
        "ID:3367062145");

    doTest("T25",
        "TREE DOWN/FIRE;LICK CREEK CHURCH RD/NC HWY 8;2011016908;big tree plum across the road [08/20/11 08:28:05 JEVERHART] 2048 en route [08/20/11 08:33:44 JEVERH",
        "CALL:TREE DOWN/FIRE",
        "ADDR:LICK CREEK CHURCH RD & NC HWY 8",
        "MADDR:LICK CREEK CHURCH RD & NC 8",
        "ID:2011016908",
        "INFO:big tree plum across the road / 2048 en route");

    doTest("T26",
        "BCAD:P10-CHEST PAINS-CHARLIE;1125 WEAVER RD;2011018228;FROG POND DR;MEADOWVIEW RD;[Medical Priority Info] PROBLEM: CHEST PAIN 76YOM # PATS: 1 AGE: 76 SEX: M",
        "CALL:BCAD:P10-CHEST PAINS-CHARLIE",
        "ADDR:1125 WEAVER RD",
        "ID:2011018228",
        "X:FROG POND DR & MEADOWVIEW RD",
        "INFO:CHEST PAIN 76YOM # PATS: 1 AGE: 76 SEX: M");

    doTest("T27",
        "CAD:P6-BREATHING PROBLEMS-DELTA;2570 RIVERVIEW RD;2011020042;BLUE WATER PT;RIVERHOUSE RD;[Medical Priority Info] PROBLEM: DIFF BREATHING # PATS: 1 AGE: 72",
        "CALL:P6-BREATHING PROBLEMS-DELTA",
        "ADDR:2570 RIVERVIEW RD",
        "ID:2011020042",
        "INFO:BLUE WATER PT / RIVERHOUSE RD / DIFF BREATHING # PATS: 1 AGE: 72");
 }
  
  public static void main(String[] args) {
    new NCDavidsonCountyParserTest().generateTests("T26");
  }
}




/*

CAD:Co Fire Tac3 for call;I 85 S/MM 99; THA;7703351053
CAD:cancel further response;I 85 S/MM 99; THA;7703351053
CAD:CANCEL;2006 JOHNSONTOWN RD; THA
CAD:Co Fire TAC4 for call;I 85 S/MM 96; LEX;4075477164
*/