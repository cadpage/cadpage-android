package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDWashingtonCountyParserTest extends BaseParserTest {
  
  public MDWashingtonCountyParserTest() {
    setParser(new MDWashingtonCountyParser(), "WASHINGTON COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MAPLEVILLE RD / CHEWSVILLE RD - PIC, PERS INJURY COLLISION - CO16,RSQE7,R79,SO20 - 1106957 15:38",
        "ADDR:MAPLEVILLE RD & CHEWSVILLE RD",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO16,RSQE7,R79,SO20",
        "ID:1106957");

    doTest("T2",
        "73 S MAIN ST - FALLS,BACK INJURIES - R79 - 1106940 12:07 2nd ALERT!",
        "ADDR:73 S MAIN ST",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:R79",
        "ID:1106940",
        "INFO:2nd ALERT!");

    doTest("T3",
        "14518 MARYLAND AVE - STROKE - FAA4,R79,CO9 - 1106937 11:31",
        "ADDR:14518 MARYLAND AVE",
        "CALL:STROKE",
        "UNIT:FAA4,R79,CO9",
        "ID:1106937");

    doTest("T4",
        "13730 MAUGANSVILLE RD, MAUGANSVILLE FIRE COMPANY - TRANSFER OF UNIT, - CO26,CO9 - 1106889 16:55",
        "ADDR:13730 MAUGANSVILLE RD",
        "PLACE:MAUGANSVILLE FIRE COMPANY",
        "CALL:TRANSFER OF UNIT,",
        "UNIT:CO26,CO9",
        "ID:1106889");

    doTest("T5",
        "LEHMANS MILL RD - WATER RESCUE - - CO9,RS13,R75,BT20,SO20,RS2001,D20,M753,RSQE91,DC9,R79 - 1106823 23:27 2nd ALERT!",
        "ADDR:LEHMANS MILL RD",
        "CALL:WATER RESCUE",
        "UNIT:CO9,RS13,R75,BT20,SO20,RS2001,D20,M753,RSQE91,DC9,R79",
        "ID:1106823",
        "INFO:2nd ALERT!");

    doTest("T6",
        "FRE CO, N FRANKLINVILLE RD/RT15 - THURMONT - WATER RESCUE - - RSQE7 - TAC 30 1106797 21:01",
        "ADDR:N FRANKLINVILLE RD & RT15",
        "CITY:THURMONT",
        "CALL:WATER RESCUE",
        "UNIT:RSQE7",
        "ID:1106797",
        "INFO:TAC 30");

    doTest("T7",
        "FRE CO, 15204 QUIRAUK SCHOOL RD - NAT GAS LEAK - CO7,R79,P791,RSQE7 - FIRE 60 1106779 19:49",
        "ADDR:15204 QUIRAUK SCHOOL RD",
        "CITY:FREDERICK COUNTY",
        "CALL:NAT GAS LEAK",
        "UNIT:CO7,R79,P791,RSQE7",
        "ID:1106779",
        "INFO:FIRE 60");

    doTest("T8",
        "21348 OLD FORGE RD, ST PETERS BEARD LUTHERAN CHURCH - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - CO9 - 1106753 16:45",
        "ADDR:21348 OLD FORGE RD",
        "PLACE:ST PETERS BEARD LUTHERAN CHURCH",
        "CALL:AUTOMATIC FIRE ALARM",
        "UNIT:CO9",
        "ID:1106753",
        "INFO:COMMERCIAL , IND");

    doTest("T9",
        "INTERSTATE 70, EXIT35 I70 EB - PIC, PERS INJURY COLLISION - CO16,CO10,R75,R79,E101,P791,P751,SUP160,DC10,RS10,E161,CA75 - 1106746 16:21",
        "ADDR:INTERSTATE 70",
        "PLACE:EXIT35 I70 EB",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO16,CO10,R75,R79,E101,P791,P751,SUP160,DC10,RS10,E161,CA75",
        "ID:1106746");

    doTest("T10",
        "22507 JEFFERSON BLVD, AC&T SMITHSBURG - EYE PROBLEMS,INJURIES - R79 - 1106670 16:20",
        "ADDR:22507 JEFFERSON BLVD",
        "PLACE:AC&T SMITHSBURG",
        "CALL:EYE PROBLEMS,INJURIES",
        "UNIT:R79",
        "ID:1106670");

    doTest("T11",
        "20354 LEITERSBURG PIKE, PEN MAR TRAILER SALES INC - NAT GAS ODOR - CO9 - 1106635 00:13",
        "ADDR:20354 LEITERSBURG PIKE",
        "PLACE:PEN MAR TRAILER SALES INC",
        "CALL:NAT GAS ODOR",
        "UNIT:CO9",
        "ID:1106635");

    doTest("T12",
        "LEITERSBURG PIKE / MILLERS CHURCH RD - PIC, PERS INJURY COLLISION - CO9,R75,P753,R79 - 1106553 22:22",
        "ADDR:LEITERSBURG PIKE & MILLERS CHURCH RD",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO9,R75,P753,R79",
        "ID:1106553");

    doTest("T13",
        "MAPLEVILLE RD / JEFFERSON BLVD - PIC, PERS INJURY COLLISION - CO7,R79,M791,SUP70,P792,C79,RSQE7 - 1106339 12:40",
        "ADDR:MAPLEVILLE RD & JEFFERSON BLVD",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO7,R79,M791,SUP70,P792,C79,RSQE7",
        "ID:1106339");
    
  }
  
  public static void main(String[] args) {
    new MDWashingtonCountyParserTest().generateTests("T1", "ADDR PLACE CITY ST CALL UNIT ID INFO");
  }
}
