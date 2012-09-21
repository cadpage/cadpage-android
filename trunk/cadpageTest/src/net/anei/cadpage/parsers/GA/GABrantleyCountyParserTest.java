package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GABrantleyCountyParserTest extends BaseParserTest {
  
  public GABrantleyCountyParserTest() {
    setParser(new GABrantleyCountyParser(), "BRANTLEY COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Disp CVFD Case # 2011-2-92 Call # 22763) 2/2/2011 14:51:00 /1070 /52 /SAMANTHA LN /YARD FIRE / STRUCTURE IN DANGER",
        "SRC:CVFD",
        "ID:22763",
        "DATE:2/2/2011",
        "TIME:14:51:00",
        "CALL:1070",
        "ADDR:52 SAMANTHA LN",
        "INFO:YARD FIRE / STRUCTURE IN DANGER");

    doTest("T2",
        "[Disp CVFD Case # 2011-1-1473 Call # 22262]  1/25/2011 0:55:31 /1070 /9513 /HWY 121 /BRUSH BEHIND HUMPTEY DUMPTEY",
        "SRC:CVFD",
        "ID:22262",
        "DATE:1/25/2011",
        "TIME:0:55:31",
        "CALL:1070",
        "ADDR:9513 HWY 121",
        "INFO:BRUSH BEHIND HUMPTEY DUMPTEY");

    doTest("T3",
        "[Disp CVFD Case # 2011-1-1452 Call # 22241]  1/24/2011 17:06:14 /1070 /602 /WARE COUNTY LINE RD /WOODS FIRE",
        "SRC:CVFD",
        "ID:22241",
        "DATE:1/24/2011",
        "TIME:17:06:14",
        "CALL:1070",
        "ADDR:602 WARE COUNTY LINE RD",
        "INFO:WOODS FIRE");

    doTest("T4",
        "[Disp CVFD Case # 2011-1-1317 Call # 22106]  1/22/2011 17:02:58 /1070 /2074 /MATTIE SHUMAN RD /CONTROL BURN",
        "SRC:CVFD",
        "ID:22106",
        "DATE:1/22/2011",
        "TIME:17:02:58",
        "CALL:1070",
        "ADDR:2074 MATTIE SHUMAN RD",
        "INFO:CONTROL BURN");

    doTest("T5",
        "[Disp CVFD Case # 2011-1-1260 Call # 22049]  1/21/2011 15:23:22 /1052 /5013 /WHITEHALL CHURCH RD /62 YOM SICK; HOME HEALTH NURSE IS AT THE RESIDENCE AN",
        "SRC:CVFD",
        "ID:22049",
        "DATE:1/21/2011",
        "TIME:15:23:22",
        "CALL:1052",
        "ADDR:5013 WHITEHALL CHURCH RD",
        "INFO:62 YOM SICK; HOME HEALTH NURSE IS AT THE RESIDENCE AN");

    doTest("T6",
        "[Disp CVFD Case # 2011-1-841 Call # 21630]  1/15/2011 13:53:32 /1070 /132 /SADDLE CLUB RD /FIELD ON FIRE",
        "SRC:CVFD",
        "ID:21630",
        "DATE:1/15/2011",
        "TIME:13:53:32",
        "CALL:1070",
        "ADDR:132 SADDLE CLUB RD",
        "INFO:FIELD ON FIRE");

    doTest("T7",
        "Subject:Disp EMS1 Case # 2011-10-633 Call # 3967\n10/10/2011 07:44:22 /1050 /449 /EAGLES NEST RD /EAST BOUND / 1 MILE WEST OF BCHS - IN",
        "SRC:EMS1",
        "ID:3967",
        "DATE:10/10/2011",
        "TIME:07:44:22",
        "CALL:1050",
        "ADDR:449 EAGLES NEST RD",
        "INFO:EAST BOUND / 1 MILE WEST OF BCHS - IN");

    doTest("T8",
        "Subject:Disp WVFD Case # 2011-11-164 Call # 4122\n11/3/2011 11:54:24 /1070 /HWY 32 E /TRACTOR ON FIRE",
        "SRC:WVFD",
        "ID:4122",
        "DATE:11/3/2011",
        "TIME:11:54:24",
        "CALL:1070",
        "ADDR:HWY 32 E",
        "INFO:TRACTOR ON FIRE");
   
  }
  
  public static void main(String[] args) {
    new GABrantleyCountyParserTest().generateTests("T1");
  }
}
