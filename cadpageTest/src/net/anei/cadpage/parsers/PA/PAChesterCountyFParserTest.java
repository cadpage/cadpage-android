package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyFParserTest extends BaseParserTest {
  
  public PAChesterCountyFParserTest() {
    setParser(new PAChesterCountyFParser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(Dispatch) ACCIDENT - PEDESTRIAN STRUCK * ** WB LANCASTER PK EO BETHEL RD ,56   (V) ** LWROXF **  **  ** - ** VEH VS MALE\nDETAILS TO FOLLOW\n",
        "CALL:ACCIDENT - PEDESTRIAN STRUCK",
        "ADDR:WB LANCASTER PK EO BETHEL RD",
        "MADDR:LANCASTER PIKE & BETHEL RD",
        "CITY:LOWER OXFORD TWP",
        "INFO:VEH VS MALE DETAILS TO FOLLOW");

    doTest("T2",
        "(Dispatch) CARDIAC/RESP ARREST - ALS * ** 167 MOUNT PLEASANT RD ,69 ** ENOTT **  ** GRANT ST & COOPER LA ** - ** 48/F--LIPS BLUE\nDETAILS TO FOLLOW\n**",
        "CALL:CARDIAC/RESP ARREST - ALS",
        "ADDR:167 MOUNT PLEASANT RD",
        "CITY:EAST NOTINGHAM TWP",
        "X:GRANT ST & COOPER LA",
        "INFO:48/F--LIPS BLUE DETAILS TO FOLLOW");

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
        "INFO:CHIMNEY DETAILS TO FOLLOW");

  }
  
  public static void main(String[] args) {
    new PAChesterCountyFParserTest().generateTests("T1");
  }
}
