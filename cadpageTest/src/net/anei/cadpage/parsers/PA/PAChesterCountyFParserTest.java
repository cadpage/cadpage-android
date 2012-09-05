package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyFParserTest extends BaseParserTest {
  
  public PAChesterCountyFParserTest() {
    setParser(new PAChesterCountyFParser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testBad() {
    doBadTest("(MFC) GSHF ** 01:19 ** RESPIRATORY DIFFICULTY - ALS * ** 317 DEVON WY ,53 ** - ** DEVON LA & DEVON WY ** 5684 ** EGOSHN ** 60/F - HAVING ANXIETY, SOB\n\nDETAILS TO FOLLOW\n\n **");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(Dispatch) ACCIDENT - PEDESTRIAN STRUCK * ** WB LANCASTER PK EO BETHEL RD ,56   (V) ** LWROXF **  **  ** - ** VEH VS MALE\nDETAILS TO FOLLOW\n",
        "CALL:ACCIDENT - PEDESTRIAN STRUCK",
        "ADDR:WB LANCASTER PK EO BETHEL RD",
        "MADDR:LANCASTER PIKE & BETHEL RD",
        "CITY:LOWER OXFORD TWP",
        "INFO:VEH VS MALE");

    doTest("T2",
        "(Dispatch) CARDIAC/RESP ARREST - ALS * ** 167 MOUNT PLEASANT RD ,69 ** ENOTT **  ** GRANT ST & COOPER LA ** - ** 48/F--LIPS BLUE\nDETAILS TO FOLLOW\n**",
        "CALL:CARDIAC/RESP ARREST - ALS",
        "ADDR:167 MOUNT PLEASANT RD",
        "CITY:EAST NOTTINGHAM TWP",
        "X:GRANT ST & COOPER LA",
        "INFO:48/F--LIPS BLUE");

    doTest("T3",
        "(Dispatch) ALARM - FIRE * ** 117 HYACINTH DR ,71 ** NEWLON ** THUNDER HILL ** RIDGE DR & MCBERTY CT ** - ** SMOKE ALARM GOING OFF - NO VIS SMOKE - 2ND FLO\nOR **",
        "CALL:ALARM - FIRE",
        "ADDR:117 HYACINTH DR",
        "CITY:NEW LONDON TWP",
        "PLACE:THUNDER HILL",
        "X:RIDGE DR & MCBERTY CT",
        "INFO:SMOKE ALARM GOING OFF - NO VIS SMOKE - 2ND FLO OR");

    doTest("T4",
        "(Dispatch) BUILDING FIRE * ** 110 E MAIN ST, 87   (NV) **   **  **  ** APT A- ** ENG21 AND LAD21\n**",
        "CALL:BUILDING FIRE",
        "ADDR:110 E MAIN ST",
        "APT:A",
        "INFO:ENG21 AND LAD21");

    doTest("T5",
        "(Dispatch) ELECTRICAL FIRE INSIDE * ** 325 S BROOKSIDE DR ,06 ** OXFORD ** BROOKSIDE ESTATES ** MCLEOD DR & SEBASTIAN DR ** - ** ELECTIRCAL SPARKED - SMOKED COMI",
        "CALL:ELECTRICAL FIRE INSIDE",
        "ADDR:325 S BROOKSIDE DR",
        "CITY:OXFORD",
        "PLACE:BROOKSIDE ESTATES",
        "X:MCLEOD DR & SEBASTIAN DR",
        "INFO:ELECTIRCAL SPARKED - SMOKED COMI");

    doTest("T6",
        "(Dispatch) FIRE POLICE REQUEST * ** EB UNION SCHOOL RD EO CREAM RD ,56   (V) ** LWROXF **  **  ** - ** ASSIST PSP WITH A TRAFFIC CONTROL\n**",
        "CALL:FIRE POLICE REQUEST",
        "ADDR:EB UNION SCHOOL RD EO CREAM RD",
        "MADDR:UNION SCHOOL RD & CREAM RD",
        "CITY:LOWER OXFORD TWP",
        "INFO:ASSIST PSP WITH A TRAFFIC CONTROL");

    doTest("T7",
        "(Dispatch) ACCIDENT - UNKNOWN INJURIES * ** OLD BALTIMORE PK/VILLAGE RD ,57    (V) **  **  **  ** - ** 2 VEH/BLKG ROADWAY/\n**",
        "CALL:ACCIDENT - UNKNOWN INJURIES",
        "ADDR:OLD BALTIMORE PK & VILLAGE RD",
        "MADDR:OLD BALTIMORE PIKE & VILLAGE RD",
        "INFO:2 VEH/BLKG ROADWAY/");

    doTest("T8",
        "(Dispatch) CHIMNEY FIRE * ** 3064 LIMESTONE RD ,44 ** WFALLO **  ** HOSTETTER RD & HIGHVIEW D ** - ** CHIMNEY\n" +
        "DETAILS TO FOLLOW\n" +
        "**",

        "CALL:CHIMNEY FIRE",
        "ADDR:3064 LIMESTONE RD",
        "CITY:WEST FALLOWFIELD TWP",
        "X:HOSTETTER RD & HIGHVIEW D",
        "INFO:CHIMNEY");

    doTest("T9",
        "(Dispatch) CHIMNEY FIRE * ** 3064 LIMESTONE RD ,44 ** WFALLO **  ** HOSTETTER RD & HIGHVIEW D ** - ** CHIMNEY\n" +
        "DETAILS TO FOLLOW\n" +
        "**",

        "CALL:CHIMNEY FIRE",
        "ADDR:3064 LIMESTONE RD",
        "CITY:WEST FALLOWFIELD TWP",
        "X:HOSTETTER RD & HIGHVIEW D",
        "INFO:CHIMNEY");

  }
  
  @Test
  public void testParse2() {

    doTest("T1",
        "CHIMNEY FIRE * ** 451 DONOFRIO DR ,11 ** - ** SPARKS FROM CHIMNEY\nDETAILS TO FOLLOW\n ** DNGTWN ** JOHNSONTOWN **",
        "CALL:CHIMNEY FIRE",
        "ADDR:451 DONOFRIO DR",
        "CITY:DOWNINGTOWN",
        "INFO:SPARKS FROM CHIMNEY",
        "PLACE:JOHNSONTOWN");

    doTest("T2",
        "EMOTIONAL DISORDER - BLS * ** 282 W CHURCH ST ,11 ** - ** PER PD O/S --\nSCENE IS SECURE\n ** DNGTWN **",
        "CALL:EMOTIONAL DISORDER - BLS",
        "ADDR:282 W CHURCH ST",
        "CITY:DOWNINGTOWN",
        "INFO:PER PD O/S -- SCENE IS SECURE");

    doTest("T3",
        "OVERDOSE - BLS * ** 10 W LANCASTER AV ,11 ** -11PD ** ALCOHOL OD ** DNGTWN **  ** E LANCASTER AV & MANOR AV *",
        "CALL:OVERDOSE - BLS",
        "ADDR:10 W LANCASTER AV",
        "MADDR:10 W LANCASTER AVE",
        "APT:11PD",
        "CITY:DOWNINGTOWN",
        "INFO:ALCOHOL OD");

    doTest("T4",
        "1 of 2\n" +
        " FRM:paging@minquas.org\n" +
        " SUBJ:21 WILLIAMS WY ,39\n" +
        " MSG:EMOTIONAL DISORDER - BLS * ** 21 WILLIAMS WY ,39 ** - **  ** CALN ** HUMPTON FARMS **\n" +
        "(Con't) 2 of 2\n" +
        "LYNN BL & HUMPTON RD ** (End)",

        "CALL:EMOTIONAL DISORDER - BLS",
        "ADDR:21 WILLIAMS WY",
        "CITY:CALN TWP",
        "PLACE:HUMPTON FARMS");

    doTest("T5",
        "1 of 2\n" +
        "FRM:paging@minquas.org\n" +
        "SUBJ:21 WILLIAMS WY ,39\n" +
        "MSG:EMOTIONAL DISORDER - BLS * ** 21 WILLIAMS WY ,39 ** - **  ** CALN ** HUMPTON FARMS **\n" +
        "(Con't) 2 of 2\n" +
        "LYNN BL & HUMPTON RD ** (End)",

        "CALL:EMOTIONAL DISORDER - BLS",
        "ADDR:21 WILLIAMS WY",
        "CITY:CALN TWP",
        "PLACE:HUMPTON FARMS");

    doTest("T6",
        "Fwd:  1 of 2\n" +
        "FRM:paging@minquas.org\n" +
        "SUBJ:517 WASHINGTON AV ,11\n" +
        "MSG:HEMORRHAGING - ALS * ** 517 WASHINGTON AV ,11 ** - ** 73/M - BLEEDINGFROM\n" +
        "(Con't) 2 of 2\n" +
        "RECTUM\r\n" +
        "DETAILS TO FOLLOW\r\n" +
        "** DNGTWN **  ** WHITELAND AV & WAGNER AV ** (End)",

        "CALL:HEMORRHAGING - ALS",
        "ADDR:517 WASHINGTON AV",
        "MADDR:517 WASHINGTON AVE",
        "CITY:DOWNINGTOWN",
        "INFO:73/M - BLEEDINGFROM RECTUM");

    doTest("T7",
        " 1 of 2\n" +
        "FRM:paging@minquas.org\n" +
        "SUBJ:150 E PENNSYLVANIA AV ,1\n" +
        "MSG:ABDOMINAL PAIN - ALS * ** 150 E PENNSYLVANIA AV ,11 ** DOCTORS EXPRESS-- ROOM\n" +
        "(Con't) 2 of 2\n" +
        "1-BRAN ** 60'S/M\r\n" +
        "DETAILS TO FOLLOW\r\n" +
        "** DNGTWN **  ** WALLACE AV & GREEN ST ** (End)",

        "CALL:ABDOMINAL PAIN - ALS",
        "ADDR:150 E PENNSYLVANIA AV",
        "MADDR:150 E PENNSYLVANIA AVE",
        "PLACE:DOCTORS EXPRESS-- ROOM 1-BRAN",
        "CITY:DOWNINGTOWN",
        "INFO:60'S/M");
   
  }
  
  public static void main(String[] args) {
    new PAChesterCountyFParserTest().generateTests("T1");
  }
}
