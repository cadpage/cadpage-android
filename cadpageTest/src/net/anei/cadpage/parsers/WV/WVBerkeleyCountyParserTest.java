package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Berkeley County, WV
Contact: Keith Baker <keithbakerwv@gmail.com>
Sender: alert@berkeleywv.org

Subject:Alert\nDescription:FUEL CON SM\nAddress: 14000 I-81 \nMARTINSBURG\n\n

Contact: stcmfd1 <stcmfd1@hotmail.com>
Sender: alert@berkeleywv.org
S:AlertM:Description:ALRM HL/HR\nAddress: 703 PORTER AVE \nMARTINSBURG
S:AlertM:Description:ALRM HL/HR\nAddress: 200 E STEPHEN ST \nMARTINSBURG\n\n
S:Alert M:Description:FIRE\nAddress: 116 E KING ST \nMARTINSBURG\n\n

Contact: Active911
Agency name: South Berkeley VFC
Location: Inwood, WV, United States
Sender: alert@berkeleywv.org

(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 58 HAPPY SCHOOL AVE \nBUNKER HILL\r\n\r\n\r\n
(Alert) Description:MUTAID S H\nAddress: 2718 WELLTOWN RD \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 246 RETAIL COMMONS PKWY \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:TRAFAC UNK\nAddress: 379 LEVITICUS DR \nINWOOD\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:MUTAID M H\nAddress: 146 WOODBINE RD \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:STR SM NOD\nAddress: 13301 APPLE HARVEST DR \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:TRAFAC UNK\nAddress: 5000 I-81 \nBUNKER HILL\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 4925 TABLER STATION RD \nMARTINSBURG\r\n\r\n\r\n

Contact: Active911
Agency name: Bedington VFD
Location: Martinsburg, WV, United States
Sender: alert@berkeleywv.org

(Alert) Description:ALRM CO/IN\nAddress: 5680 HAMMONDS MILL RD \nHEDGESVILLE\r\n\r\n\r\n
(Alert) Description:WIRE DWN N\nAddress: 158 BELVIEW DR \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:MEDICAL\nAddress: 301 ROPP DR \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:UNK FIRE\nAddress: 891 AUTO PARTS PL \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:FIRE\nAddress: 138 GREENSBURG RD \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:TRAFAC ALS\nAddress: DISTRICT WAY // EDWIN MILLER BLVD \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:FIRE\nAddress: 146 NOZZLE DR \nFALLING WATERS\r\n\r\n\r\n
(Alert) Description:TRAFAC NO\nAddress: BROWN RD // WILLIAMSPORT PIKE \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 121 ADMINISTRATIVE DR \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 9455 WILLIAMSPORT PIKE \nFALLING WATERS\r\n\r\n\r\n

Contact: Active911
Agency name: Baker Heights
Location: Martinsburg, WV, United States
Sender: alert@berkeleywv.org

(Alert) Description:OUTSDE BRU\nAddress: TUSCARORA PIK // SALEM CHURCH RD \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:BREATH ALS\nAddress: 264 HEDRICK AVE \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:BACK BLS\nAddress: 366 RICHWOOD HALL RD \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:FALL BLS\nAddress: 14 JOY CT \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:MUTAID S H\nAddress: 200 S PRINCESS ST \nSHEPHERDSTOWN\r\n\r\n\r\n
(Alert) Description:MUTAID M H\nAddress: 172 SUNDANCE LN \nKEARNEYSVILLE\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 246 RETAIL COMMONS PKWY \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:MUTAID FILL\nAddress: CO 1 \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n

Contact: Active911
Agency name: Hedgesville Fire Department
Location: Hedgesville, WV, United States
Sender: alert@berkeleywv.org

(Alert) Description:DIABET ALS\nAddress: 3718 ALLENSVILLE RD \nHEDGESVILLE\r\n\r\n\r\n
(Alert) Description:ALRM CO/IN\nAddress: 5680 HAMMONDS MILL RD \nHEDGESVILLE\r\n\r\n\r\n
(Alert) Description:SICK ALS\nAddress: 99 TAVERN RD  (PROPERTY) \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:ABDOM BLS\nAddress: 341 DUCHESS WAY \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:CARDIAC AR\nAddress: 5 FRAGRANCE LN \nHEDGESVILLE\r\n\r\n\r\n
(Alert) Description:MEDICAL\nAddress: 161 RIDGE RD N \nHEDGESVILLE\r\n\r\n\r\n
(Alert) Description:OUTSDE BRU\nAddress: 583 GETAWAY RD \nHEDGESVILLE\r\n\r\n\r\n
(Alert) Description:OUTSDE BRU\nAddress: 6700 TUSCARORA PIKE \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:UNK FIRE\nAddress: 891 AUTO PARTS PL \nMARTINSBURG\r\n\r\n\r\n
(Alert) Description:CHOKE BLS\nAddress: 8326 HEDGESVILLE RD \nHEDGESVILLE\r\n\r\n\r\n

*/

public class WVBerkeleyCountyParserTest extends BaseParserTest {
  
  public WVBerkeleyCountyParserTest() {
    setParser(new WVBerkeleyCountyParser(), "BERKELEY COUNTY", "WV");
  }
  
  @Test
  public void testKeithBaker() {

    doTest("T1",
        "Subject:Alert\nDescription:FUEL CON SM\nAddress: 14000 I-81 \nMARTINSBURG\n\n",
        "CALL:SMALL CONTAINED FUEL SPILL",
        "ADDR:14000 I-81",
        "MADDR:14000 I 81",
        "CITY:MARTINSBURG");

  }
  
  @Test
  public void teststmcfd1() {

    doTest("T1",
        "S:AlertM:Description:ALRM HL/HR\nAddress: 703 PORTER AVE \nMARTINSBURG",
        "CALL:HIGH RISE FIRE ALARM",
        "ADDR:703 PORTER AVE",
        "CITY:MARTINSBURG");

    doTest("T2",
        "S:AlertM:Description:ALRM HL/HR\nAddress: 200 E STEPHEN ST \nMARTINSBURG\n\n",
        "CALL:HIGH RISE FIRE ALARM",
        "ADDR:200 E STEPHEN ST",
        "CITY:MARTINSBURG");

    doTest("T3",
        "S:Alert M:Description:FIRE\nAddress: 116 E KING ST \nMARTINSBURG\n\n",
        "CALL:FIRE ALARM",
        "ADDR:116 E KING ST",
        "CITY:MARTINSBURG");
  
  }
  
  @Test
  public void testSouthBerkeleyFire() {

    doTest("T1",
        "(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:5550 WINCHESTER AVE",
        "CITY:MARTINSBURG");

    doTest("T2",
        "(Alert) Description:ALRM CO/IN\nAddress: 58 HAPPY SCHOOL AVE \nBUNKER HILL\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:58 HAPPY SCHOOL AVE",
        "CITY:BUNKER HILL");

    doTest("T3",
        "(Alert) Description:MUTAID S H\nAddress: 2718 WELLTOWN RD \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:MUTUAL AID TO INCIDENT HOT",
        "ADDR:2718 WELLTOWN RD",
        "CITY:MARTINSBURG");

    doTest("T4",
        "(Alert) Description:ALRM CO/IN\nAddress: 246 RETAIL COMMONS PKWY \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:246 RETAIL COMMONS PKWY",
        "CITY:MARTINSBURG");

    doTest("T5",
        "(Alert) Description:TRAFAC UNK\nAddress: 379 LEVITICUS DR \nINWOOD\r\n\r\n\r\n",
        "CALL:TRAFFIC ACCIDENT UNK INJURIES",
        "ADDR:379 LEVITICUS DR",
        "CITY:INWOOD");

    doTest("T6",
        "(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:5550 WINCHESTER AVE",
        "CITY:MARTINSBURG");

    doTest("T7",
        "(Alert) Description:MUTAID M H\nAddress: 146 WOODBINE RD \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:MUTUAL AID TO INCIDENT HOT",
        "ADDR:146 WOODBINE RD",
        "CITY:MARTINSBURG");

    doTest("T8",
        "(Alert) Description:STR SM NOD\nAddress: 13301 APPLE HARVEST DR \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:SMALL SHED FIRE",
        "ADDR:13301 APPLE HARVEST DR",
        "CITY:MARTINSBURG");

    doTest("T9",
        "(Alert) Description:TRAFAC UNK\nAddress: 5000 I-81 \nBUNKER HILL\r\n\r\n\r\n",
        "CALL:TRAFFIC ACCIDENT UNK INJURIES",
        "ADDR:5000 I-81",
        "MADDR:5000 I 81",
        "CITY:BUNKER HILL");

    doTest("T10",
        "(Alert) Description:ALRM CO/IN\nAddress: 4925 TABLER STATION RD \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:4925 TABLER STATION RD",
        "CITY:MARTINSBURG");

  }
  
  @Test
  public void testBeddingtonFire() {

    doTest("T1",
        "(Alert) Description:ALRM CO/IN\nAddress: 5680 HAMMONDS MILL RD \nHEDGESVILLE\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:5680 HAMMONDS MILL RD",
        "CITY:HEDGESVILLE");

    doTest("T2",
        "(Alert) Description:WIRE DWN N\nAddress: 158 BELVIEW DR \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:WIRES DOWN NO ARCING",
        "ADDR:158 BELVIEW DR",
        "CITY:MARTINSBURG");

    doTest("T3",
        "(Alert) Description:MEDICAL\nAddress: 301 ROPP DR \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:MEDICAL",
        "ADDR:301 ROPP DR",
        "CITY:MARTINSBURG");

    doTest("T4",
        "(Alert) Description:UNK FIRE\nAddress: 891 AUTO PARTS PL \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:UNKNOWN FIRE INVESTIGATION",
        "ADDR:891 AUTO PARTS PL",
        "CITY:MARTINSBURG");

    doTest("T5",
        "(Alert) Description:FIRE\nAddress: 138 GREENSBURG RD \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM",
        "ADDR:138 GREENSBURG RD",
        "CITY:MARTINSBURG");

    doTest("T6",
        "(Alert) Description:TRAFAC ALS\nAddress: DISTRICT WAY // EDWIN MILLER BLVD \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:TRAFFIC ACCIDENT WITH INJURY ALS",
        "ADDR:DISTRICT WAY & EDWIN MILLER BLVD",
        "CITY:MARTINSBURG");

    doTest("T7",
        "(Alert) Description:FIRE\nAddress: 146 NOZZLE DR \nFALLING WATERS\r\n\r\n\r\n",
        "CALL:FIRE ALARM",
        "ADDR:146 NOZZLE DR",
        "CITY:FALLING WATERS");

    doTest("T8",
        "(Alert) Description:TRAFAC NO\nAddress: BROWN RD // WILLIAMSPORT PIKE \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:PROPERTY DAMAGE ACCIDENT NO INJURY",
        "ADDR:BROWN RD & WILLIAMSPORT PIKE",
        "CITY:MARTINSBURG");

    doTest("T9",
        "(Alert) Description:ALRM CO/IN\nAddress: 121 ADMINISTRATIVE DR \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:121 ADMINISTRATIVE DR",
        "CITY:MARTINSBURG");

    doTest("T10",
        "(Alert) Description:ALRM CO/IN\nAddress: 9455 WILLIAMSPORT PIKE \nFALLING WATERS\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:9455 WILLIAMSPORT PIKE",
        "CITY:FALLING WATERS");

  }
  
  @Test
  public void testBakerHeights() {

    doTest("T1",
        "(Alert) Description:OUTSDE BRU\nAddress: TUSCARORA PIK // SALEM CHURCH RD \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:GRASS FIRE BRUSH FIRE",
        "ADDR:TUSCARORA PIK & SALEM CHURCH RD",
        "MADDR:TUSCARORA PIKE & SALEM CHURCH RD",
        "CITY:MARTINSBURG");

    doTest("T2",
        "(Alert) Description:BREATH ALS\nAddress: 264 HEDRICK AVE \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:BREATHING PROBLEM ALS",
        "ADDR:264 HEDRICK AVE",
        "CITY:MARTINSBURG");

    doTest("T3",
        "(Alert) Description:BACK BLS\nAddress: 366 RICHWOOD HALL RD \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:BACK PAIN NO TRAUMA BLS",
        "ADDR:366 RICHWOOD HALL RD",
        "CITY:MARTINSBURG");

    doTest("T4",
        "(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:5550 WINCHESTER AVE",
        "CITY:MARTINSBURG");

    doTest("T5",
        "(Alert) Description:FALL BLS\nAddress: 14 JOY CT \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FALL TRAUMATIC INJURY BLS",
        "ADDR:14 JOY CT",
        "CITY:MARTINSBURG");

    doTest("T6",
        "(Alert) Description:MUTAID S H\nAddress: 200 S PRINCESS ST \nSHEPHERDSTOWN\r\n\r\n\r\n",
        "CALL:MUTUAL AID TO INCIDENT HOT",
        "ADDR:200 S PRINCESS ST",
        "CITY:SHEPHERDSTOWN");

    doTest("T7",
        "(Alert) Description:MUTAID M H\nAddress: 172 SUNDANCE LN \nKEARNEYSVILLE\r\n\r\n\r\n",
        "CALL:MUTUAL AID TO INCIDENT HOT",
        "ADDR:172 SUNDANCE LN",
        "CITY:KEARNEYSVILLE");

    doTest("T8",
        "(Alert) Description:ALRM CO/IN\nAddress: 246 RETAIL COMMONS PKWY \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:246 RETAIL COMMONS PKWY",
        "CITY:MARTINSBURG");

    doTest("T9",
        "(Alert) Description:MUTAID FILL\nAddress: CO 1 \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:STATION FILL MUTUAL AID",
        "ADDR:CO 1",
        "MADDR:COUNTY ROAD 1",
        "CITY:MARTINSBURG");

    doTest("T10",
        "(Alert) Description:ALRM CO/IN\nAddress: 5550 WINCHESTER AVE \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:5550 WINCHESTER AVE",
        "CITY:MARTINSBURG");

  }
  
  @Test
  public void testHedgesvilleFire() {

    doTest("T1",
        "(Alert) Description:DIABET ALS\nAddress: 3718 ALLENSVILLE RD \nHEDGESVILLE\r\n\r\n\r\n",
        "CALL:DIABETIC PROBLEM ALS",
        "ADDR:3718 ALLENSVILLE RD",
        "CITY:HEDGESVILLE");

    doTest("T2",
        "(Alert) Description:ALRM CO/IN\nAddress: 5680 HAMMONDS MILL RD \nHEDGESVILLE\r\n\r\n\r\n",
        "CALL:FIRE ALARM COMMERICAL BUILDING",
        "ADDR:5680 HAMMONDS MILL RD",
        "CITY:HEDGESVILLE");

    doTest("T3",
        "(Alert) Description:SICK ALS\nAddress: 99 TAVERN RD  (PROPERTY) \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:SICK PERSON ALS",
        "ADDR:99 TAVERN RD  (PROPERTY)",
        "MADDR:99 TAVERN RD",
        "CITY:MARTINSBURG");

    doTest("T4",
        "(Alert) Description:ABDOM BLS\nAddress: 341 DUCHESS WAY \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:ABDOMINAL PAIN BLS",
        "ADDR:341 DUCHESS WAY",
        "CITY:MARTINSBURG");

    doTest("T5",
        "(Alert) Description:CARDIAC AR\nAddress: 5 FRAGRANCE LN \nHEDGESVILLE\r\n\r\n\r\n",
        "CALL:CARDIAC ARREST WITH C.P.R.",
        "ADDR:5 FRAGRANCE LN",
        "CITY:HEDGESVILLE");

    doTest("T6",
        "(Alert) Description:MEDICAL\nAddress: 161 RIDGE RD N \nHEDGESVILLE\r\n\r\n\r\n",
        "CALL:MEDICAL",
        "ADDR:161 RIDGE RD N",
        "CITY:HEDGESVILLE");

    doTest("T7",
        "(Alert) Description:OUTSDE BRU\nAddress: 583 GETAWAY RD \nHEDGESVILLE\r\n\r\n\r\n",
        "CALL:GRASS FIRE BRUSH FIRE",
        "ADDR:583 GETAWAY RD",
        "CITY:HEDGESVILLE");

    doTest("T8",
        "(Alert) Description:OUTSDE BRU\nAddress: 6700 TUSCARORA PIKE \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:GRASS FIRE BRUSH FIRE",
        "ADDR:6700 TUSCARORA PIKE",
        "CITY:MARTINSBURG");

    doTest("T9",
        "(Alert) Description:UNK FIRE\nAddress: 891 AUTO PARTS PL \nMARTINSBURG\r\n\r\n\r\n",
        "CALL:UNKNOWN FIRE INVESTIGATION",
        "ADDR:891 AUTO PARTS PL",
        "CITY:MARTINSBURG");

    doTest("T10",
        "(Alert) Description:CHOKE BLS\nAddress: 8326 HEDGESVILLE RD \nHEDGESVILLE\r\n\r\n\r\n",
        "CALL:CHOKING BLS OBJECT DISLODGED",
        "ADDR:8326 HEDGESVILLE RD",
        "CITY:HEDGESVILLE");

  }
  
  public static void main(String[] args) {
    new WVBerkeleyCountyParserTest().generateTests("T1");
  }
}