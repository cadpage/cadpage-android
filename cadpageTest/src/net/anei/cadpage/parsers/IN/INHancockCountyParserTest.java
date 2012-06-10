package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class INHancockCountyParserTest extends BaseParserTest {
  
  public INHancockCountyParserTest() {
    setParser(new INHancockCountyParser(), "HANCOCK COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Vehicle Accident - PI/4100 N 600W GREENFIELD & W AIRPORT BLV/52/ E71 M71 FG1 BCFP1/gate 2A",
        "CALL:Vehicle Accident - PI",
        "ADDR:4100 N 600W",
        "CITY:GREENFIELD",
        "X:W AIRPORT BLV",
        "MAP:52",
        "UNIT:E71 M71 FG1 BCFP1",
        "INFO:gate 2A");

    doTest("T2",
        "Structure #ALARM#/7935 W 600N MCCORDSVILLE R12B12089 OAKLANDON/N 700W & N 800W/52/ E71 E72 L71 M71 FG1 BCFP1/General fire alarm",
        "CALL:Structure #ALARM#",
        "ADDR:7935 W 600N",
        "CITY:MCCORDSVILLE",
        "PLACE:R12B12089 OAKLANDON",
        "X:N 700W & N 800W",
        "MAP:52",
        "UNIT:E71 E72 L71 M71 FG1 BCFP1",
        "INFO:General fire alarm");

    doTest("T3",
        "Vehicle Accident - PI/3600 N 600W GREENFIELD/W 350N & W STONER DR/17/ E71 M71 FG3 BCFP1",
        "CALL:Vehicle Accident - PI",
        "ADDR:3600 N 600W",
        "CITY:GREENFIELD",
        "X:W 350N & W STONER DR",
        "MAP:17",
        "UNIT:E71 M71 FG3 BCFP1");

    doTest("T4",
        "Sick / Ill Person/2500 N 700W GREENFIELD/W 200N & W 300N/53/ E71 M71 FG1 BCFP1/LE on traffic stop; requesting check out",
        "CALL:Sick / Ill Person",
        "ADDR:2500 N 700W",
        "CITY:GREENFIELD",
        "X:W 200N & W 300N",
        "MAP:53",
        "UNIT:E71 M71 FG1 BCFP1",
        "INFO:LE on traffic stop; requesting check out");

    doTest("T5",
        "Aircraft Down/5881 W AIRPORT BLV GREENFIELD FUEL DEPOT/N AVIATION WAY & N 600W/18/ T71 BCFP1/Aircraft into a cart; Vietest building",
        "CALL:Aircraft Down",
        "ADDR:5881 W AIRPORT BLV",
        "MADDR:5881 W AIRPORT BLVD",
        "CITY:GREENFIELD",
        "PLACE:FUEL DEPOT",
        "X:N AVIATION WAY & N 600W",
        "MAP:18",
        "UNIT:T71 BCFP1",
        "INFO:Aircraft into a cart; Vietest building");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "((59389) Investigate Gas Fumes/8023 N 600W STE.103 MCCORDSVILLE FARMERS INS / MCCORDSVILL) Investigate Gas Fumes/8023 N 600W STE.103 MCCORDSVILLE FARMERS INS / MCCORDSVILLE/W 800N & W 900N/40/ E31 FFDP1/caller adv he struck a gas main",
        "CALL:Investigate Gas Fumes",
        "ADDR:8023 N 600W",
        "APT:103",
        "INFO:caller adv he struck a gas main",
        "CITY:MCCORDSVILLE",
        "PLACE:FARMERS INS",
        "X:W 800N & W 900N",
        "MAP:40",
        "UNIT:E31 FFDP1");

    doTest("T2",
        "((59620) Sick / Ill Person/453 E ILLINOIS ST FORTVILLE/N CENTER ST & N MADISON ST/21/ R39) Sick / Ill Person/453 E ILLINOIS ST FORTVILLE/N CENTER ST & N MADISON ST/21/ R39 S39 M5227 FFDP1/said male had shock therapy today and can t remember",
        "CALL:Sick / Ill Person",
        "ADDR:453 E ILLINOIS ST",
        "INFO:said male had shock therapy today and can t remember",
        "CITY:FORTVILLE",
        "X:N CENTER ST & N MADISON ST",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T3",
        "((60655) Allergic Reaction/9567 CAMPFIRE-MADISON CO// FFDP1/brittany taylor 22yof - unkno) Allergic Reaction/9567 CAMPFIRE-MADISON CO// FFDP1/brittany taylor 22yof - unknown new medication for",
        "CALL:Allergic Reaction",
        "ADDR:9567 CAMPFIRE",   // Can't find this one
        "INFO:brittany taylor 22yof - unknown new medication for",
        "CITY:MADISON COUNTY",
        "UNIT:FFDP1");

    doTest("T4",
        "((61517) Difficulty Breathing/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDE) Difficulty Breathing/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDEN DR/21/ R39 S39 M5227 FFDP1/Conc and breathing; 91 yoa female",
        "CALL:Difficulty Breathing",
        "ADDR:704 N MADISON ST",
        "APT:2",
        "INFO:Conc and breathing; 91 yoa female",
        "CITY:FORTVILLE",
        "PLACE:APT 2",
        "X:E HAMILTON ST & ALDEN DR",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T5",
        "((61823) Abdominal/610 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S39 M5) Abdominal/610 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S39 M5227 FFDP1/27yo female",
        "CALL:Abdominal",
        "ADDR:610 N SCHOOL ST",
        "INFO:27yo female",
        "CITY:FORTVILLE",
        "X:E MICHIGAN ST & E CAROLINA ST",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T6",
        "((62910) Injured Person/7792 W 1050S FORTVILLE/S 750W & S LEE ST/310041/ S39 FFDP1/13 YEA) Injured Person/7792 W 1050S FORTVILLE/S 750W & S LEE ST/310041/ S39 FFDP1/13 YEAR OLD MALE",
        "CALL:Injured Person",
        "ADDR:7792 W 1050S",
        "INFO:13 YEAR OLD MALE",
        "CITY:FORTVILLE",
        "X:S 750W & S LEE ST",
        "MAP:310041",
        "UNIT:S39 FFDP1");

    doTest("T7",
        "((63109) Assist Police or Sheriff/211 W RAILROAD ST FORTVILLE/S MCCARTY ST & DEAD END/21/) Assist Police or Sheriff/211 W RAILROAD ST FORTVILLE/S MCCARTY ST & DEAD END/21/ R39 FG1 FFDP1/NEEDING SCBA S FOR POSSIBLE DECEASED SUBJ",
        "CALL:Assist Police or Sheriff",
        "ADDR:211 W RAILROAD ST",
        "INFO:NEEDING SCBA S FOR POSSIBLE DECEASED SUBJ",
        "CITY:FORTVILLE",
        "X:S MCCARTY ST & DEAD END",
        "MAP:21",
        "UNIT:R39 FG1 FFDP1");

    doTest("T8",
        "((63246) Sick / Ill Person/418 E STAAT ST FORTVILLE/N LELAND ST & E OHIO ST/21/ R39 S39 M) Sick / Ill Person/418 E STAAT ST FORTVILLE/N LELAND ST & E OHIO ST/21/ R39 S39 M5227 FFDP1/1 week old baby",
        "CALL:Sick / Ill Person",
        "ADDR:418 E STAAT ST",
        "INFO:1 week old baby",
        "CITY:FORTVILLE",
        "X:N LELAND ST & E OHIO ST",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T9",
        "((64109) Sick / Ill Person/503 THOMAS POINT DR FORTVILLE/DEAD END & BEACON POINT LN/21/ R) Sick / Ill Person/503 THOMAS POINT DR FORTVILLE/DEAD END & BEACON POINT LN/21/ R39 S39 M5227 FFDP1/CHECK OUT ON A FEMALE THAT HAS BEEN DRINKING",
        "CALL:Sick / Ill Person",
        "ADDR:503 THOMAS POINT DR",
        "INFO:CHECK OUT ON A FEMALE THAT HAS BEEN DRINKING",
        "CITY:FORTVILLE",
        "X:DEAD END & BEACON POINT LN",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T10",
        "((65273) Injured Person/425 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S) Injured Person/425 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S39 M5227 FFDP1",
        "CALL:Injured Person",
        "ADDR:425 N SCHOOL ST",
        "CITY:FORTVILLE",
        "X:E MICHIGAN ST & E CAROLINA ST",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T11",
        "((1090) Difficulty Breathing/885 E BROADWAY ST RM.4 FORTVILLE COLONIAL MOTEL/LINDA DR &) Difficulty Breathing/885 E BROADWAY ST RM.4 FORTVILLE COLONIAL MOTEL/LINDA DR & MOTEL DR/22/ R39 S39 M5227 FFDP1",
        "CALL:Difficulty Breathing",
        "ADDR:885 E BROADWAY ST",
        "APT:4",
        "CITY:FORTVILLE",
        "PLACE:COLONIAL MOTEL",
        "X:LINDA DR & MOTEL DR",
        "MAP:22",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T12",
        "((1384) Difficulty Breathing/936 E BROADWAY ST FORTVILLE/MOTEL DR & EMERSON DR/22/ R39 S) Difficulty Breathing/936 E BROADWAY ST FORTVILLE/MOTEL DR & EMERSON DR/22/ R39 S39 M5227 FFDP1",
        "CALL:Difficulty Breathing",
        "ADDR:936 E BROADWAY ST",
        "CITY:FORTVILLE",
        "X:MOTEL DR & EMERSON DR",
        "MAP:22",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T13",
        "((1639) Lifting Assistance/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDEN) Lifting Assistance/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDEN DR/21/ S39 M5227 FG1 FFDP1",
        "CALL:Lifting Assistance",
        "ADDR:704 N MADISON ST",
        "APT:2",
        "CITY:FORTVILLE",
        "PLACE:APT 2",
        "X:E HAMILTON ST & ALDEN DR",
        "MAP:21",
        "UNIT:S39 M5227 FG1 FFDP1");

  }
  
  public static void main(String[] args) {
    new INHancockCountyParserTest().generateTests("T1");
  }
}