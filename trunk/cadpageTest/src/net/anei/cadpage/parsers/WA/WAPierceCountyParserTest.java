package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class WAPierceCountyParserTest extends BaseParserTest {
  
  public WAPierceCountyParserTest() {
    setParser(new WAPierceCountyParser(), "PIERCE COUNTY", "WA");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "(- part 1 of 1)RC:0038-A/Run#36872/CALL:03:32/DISP:03:32/ENR:03:33/ATS:03:37/TRA:03:45/ATD:0 3:53/PUZIP:98408/DO:St Joseph Hospital",
        "CALL:RUN REPORT",
        "PLACE:RC:0038-A/Run#36872/CALL:03:32/DISP:03:32/ENR:03:33/ATS:03:37/TRA:03:45/ATD:0 3:53/PUZIP:98408/DO:St Joseph Hospital");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(- part 1 of 1) RC:Run# 36872/Sick Person/<Unknown>/S 56TH ST & PACIFIC AVE///X=56th&55th/TACOMA// AVE//606//TACOMA/773 G5/\r\n" +
        "\r\n" +
        "This is a confidential/proprietary communication intended for the add",

        "ID:36872",
        "CALL:Sick Person",
        "ADDR:S 56TH ST & PACIFIC AVE",
        "X:56th&55th",
        "UNIT:606",
        "CITY:TACOMA",
        "MAP:773 G5",
        "INFO:AVE / TACOMA");

    doTest("T2",
        "(- part 1 of 1) RC:Run# 45146/Unconscious/<Unknown>/6TH AVE & N STEVENS ST//behind 76 station/X=N Verde St&N Stevens St/TACOMA//\r\n" +
        "\r\n" +
        "This is a confidential/propri",

        "ID:45146",
        "CALL:Unconscious",
        "ADDR:6TH AVE & N STEVENS ST",
        "X:N Verde St&N Stevens St",
        "CITY:TACOMA",
        "INFO:behind 76 station");

    doTest("T3",
        "(- part 1 of 1) RC:Run# 46137/Unknown/<Unknown>/6016 N HIGHLANDS PKWY//371//TACOMA/772 J4/\r\n" +
        "\r\n" +
        "This is a confidential/proprietary communication intended for the a",

        "ID:46137",
        "CALL:Unknown",
        "ADDR:6016 N HIGHLANDS PKWY",
        "UNIT:371",
        "CITY:TACOMA",
        "MAP:772 J4");

    doTest("T4",
        "(- part 1 of 1) RC:Run# 45014/Sick Person/<Unknown>/919 FAWCETT AVE//606//TACOMA/773 G5/\r\n" +
        "\r\n" +
        "This is a confidential/proprietary communication intended for the add",

        "ID:45014",
        "CALL:Sick Person",
        "ADDR:919 FAWCETT AVE",
        "UNIT:606",
        "CITY:TACOMA",
        "MAP:773 G5");

    doTest("T5",
        "(- part 1 of 1) RC:Run# 46129/Trauma/<Unknown>/2018 E WRIGHT AVE///X=E Roosevelt Ave/TACOMA//\r\n" +
        "\r\n" +
        "This is a confidential/proprietary communication intended for th",

        "ID:46129",
        "CALL:Trauma",
        "ADDR:2018 E WRIGHT AVE",
        "X:E Roosevelt Ave",
        "CITY:TACOMA");

    doTest("T6",
        "(- part 1 of 1) RC:Run# 46173/Unknown/<Unknown>/6316 S 12TH ST///X=Unknown Street with ID 1319802&S Whitman St/TACOMA//\r\n" +
        "\r\n" +
        "This is a confidential/proprietary com",

        "ID:46173",
        "CALL:Unknown",
        "ADDR:6316 S 12TH ST",
        "X:Unknown Street with ID 1319802&S Whitman St",
        "CITY:TACOMA");

    doTest("T7",
        "(- part 1 of 1) RC:Run# 46237/MVA/<Unknown>/4215 S 30TH ST///X=S Tyler St/TACOMA//\r\n" +
        "\r\n" +
        "This is a confidential/proprietary communication intended for the addressee",

        "ID:46237",
        "CALL:MVA",
        "ADDR:4215 S 30TH ST",
        "X:S Tyler St",
        "CITY:TACOMA");

  }
  
  public static void main(String[] args) {
    new WAPierceCountyParserTest().generateTests("T1");
  }
}