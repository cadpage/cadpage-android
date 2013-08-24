package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Delaware County, PA
Contact: Ed Kline <edkline51@gmail.com>
Sender: dispatch@southmediafire.com

FRM:dispatch@southmediafire.com\nMSG:[Update]*04/10/2013*414 SCOTT LN*15:17*BEAUMONT DR*COOPER DR*ALARM*ACCIDENTAL TRIP OF F
FRM:dispatch@southmediafire.com\nMSG:04/10/2013*414 SCOTT LN*15:06*BEAUMONT DR*COOPER DR*ALARM*ACCIDENTAL TRIP OF F*652/SD51/655/651/ENG51
FRM:dispatch@southmediafire.com\nMSG:[Update]*04/09/2013*610 W WILTSHIRE DR*13:43*MOORE RD*E WILTSHIRE DR*FIRE-BLD*BUILDING FIRE, RES/D
FRM:dispatch@southmediafire.com\nMSG:04/09/2013*610 W WILTSHIRE DR*13:08*MOORE RD*E WILTSHIRE DR*FIRE-BLD*BUILDING FIRE,\n(Con't) 2 of 2\nRES/D*652/M23/SD51/655/RE51/651/237/ENG51/RIT23(End)
FRM:dispatch@southmediafire.com\nMSG:[Update]*04/09/2013*115 S PROVIDENCE RD*01:43*E BROOKHAVEN RD*HICKORY LN*ALARM*AUTOMATIC FIRE ALARM
FRM:dispatch@southmediafire.com\nMSG:04/08/2013*113 LOMBARDY DR*17:59*GOVERNORS DR*CANTERBURY DR*ALARM*CARBON MONOXIDE ALAR*652/SD51/655/651/ENG51
FRM:dispatch@southmediafire.com\nMSG:[Update]*04/05/2013*I476 SB TO I95 SB*14:58*RAMP*CSX PHILADELPHIA SUB*ACC*WITH INJURY REPORTED
FRM:dispatch@southmediafire.com\nMSG:04/03/2013*705 MADISON CT*17:14*NEW JERSEY AV*NEW JERSEY AV*ALARM*CARBON MONOXIDE ALAR*652/SD51/655/651/ENG51
FRM:dispatch@southmediafire.com\nMSG:04/02/2013*DOVER CT & PENNSYLVA*16:05*DOVER CT*PENNSYLVANIA AV*FIRE-NON*VEHICLE FIRE*652/SD51/651/ENG51
FRM:dispatch@southmediafire.com\nMSG:[Update]*04/02/2013*1 TANGLEWOOD CIR*13:32*FORESTVIEW RD*FORESTVIEW RD*FIRE-BLD*BUILDING FIRE, RES/D

*/

public class PADelawareCountyFParserTest extends BaseParserTest {
  
  public PADelawareCountyFParserTest() {
    setParser(new PADelawareCountyFParser(), "DELAWARE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FRM:dispatch@southmediafire.com\nMSG:[Update]*04/10/2013*414 SCOTT LN*15:17*BEAUMONT DR*COOPER DR*ALARM*ACCIDENTAL TRIP OF F",
        "DATE:04/10/2013",
        "ADDR:414 SCOTT LN",
        "TIME:15:17",
        "X:BEAUMONT DR & COOPER DR",
        "CODE:ALARM",
        "CALL:ACCIDENTAL TRIP OF F");

    doTest("T2",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:04/10/2013*414 SCOTT LN*15:06*BEAUMONT DR*COOPER DR*ALARM*ACCIDENTAL TRIP OF F*652/SD51/655/651/ENG51",

        "DATE:04/10/2013",
        "ADDR:414 SCOTT LN",
        "TIME:15:06",
        "X:BEAUMONT DR & COOPER DR",
        "CODE:ALARM",
        "CALL:ACCIDENTAL TRIP OF F",
        "UNIT:652/SD51/655/651/ENG51");

    doTest("T3",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:[Update]*04/09/2013*610 W WILTSHIRE DR*13:43*MOORE RD*E WILTSHIRE DR*FIRE-BLD*BUILDING FIRE, RES/D",

        "DATE:04/09/2013",
        "ADDR:610 W WILTSHIRE DR",
        "TIME:13:43",
        "X:MOORE RD & E WILTSHIRE DR",
        "CODE:FIRE-BLD",
        "CALL:BUILDING FIRE, RES/D");

    doTest("T4",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:04/09/2013*610 W WILTSHIRE DR*13:08*MOORE RD*E WILTSHIRE DR*FIRE-BLD*BUILDING FIRE,\n" +
        "(Con't) 2 of 2\n" +
        "RES/D*652/M23/SD51/655/RE51/651/237/ENG51/RIT23(End)",

        "DATE:04/09/2013",
        "ADDR:610 W WILTSHIRE DR",
        "TIME:13:08",
        "X:MOORE RD & E WILTSHIRE DR",
        "CODE:FIRE-BLD",
        "CALL:BUILDING FIRE, RES/D",
        "UNIT:652/M23/SD51/655/RE51/651/237/ENG51/RIT23");

    doTest("T5",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:[Update]*04/09/2013*115 S PROVIDENCE RD*01:43*E BROOKHAVEN RD*HICKORY LN*ALARM*AUTOMATIC FIRE ALARM",

        "DATE:04/09/2013",
        "ADDR:115 S PROVIDENCE RD",
        "TIME:01:43",
        "X:E BROOKHAVEN RD & HICKORY LN",
        "CODE:ALARM",
        "CALL:AUTOMATIC FIRE ALARM");

    doTest("T6",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:04/08/2013*113 LOMBARDY DR*17:59*GOVERNORS DR*CANTERBURY DR*ALARM*CARBON MONOXIDE ALAR*652/SD51/655/651/ENG51",

        "DATE:04/08/2013",
        "ADDR:113 LOMBARDY DR",
        "TIME:17:59",
        "X:GOVERNORS DR & CANTERBURY DR",
        "CODE:ALARM",
        "CALL:CARBON MONOXIDE ALAR",
        "UNIT:652/SD51/655/651/ENG51");

    doTest("T7",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:[Update]*04/05/2013*I476 SB TO I95 SB*14:58*RAMP*CSX PHILADELPHIA SUB*ACC*WITH INJURY REPORTED",

        "DATE:04/05/2013",
        "ADDR:I476 SB TO I95 SB",
        "MADDR:I 476 TO I 95 & RAMP",
        "TIME:14:58",
        "X:RAMP & CSX PHILADELPHIA SUB",
        "CODE:ACC",
        "CALL:WITH INJURY REPORTED");

    doTest("T8",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:04/03/2013*705 MADISON CT*17:14*NEW JERSEY AV*NEW JERSEY AV*ALARM*CARBON MONOXIDE ALAR*652/SD51/655/651/ENG51",

        "DATE:04/03/2013",
        "ADDR:705 MADISON CT",
        "TIME:17:14",
        "X:NEW JERSEY AV & NEW JERSEY AV",
        "CODE:ALARM",
        "CALL:CARBON MONOXIDE ALAR",
        "UNIT:652/SD51/655/651/ENG51");

    doTest("T9",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:04/02/2013*DOVER CT & PENNSYLVA*16:05*DOVER CT*PENNSYLVANIA AV*FIRE-NON*VEHICLE FIRE*652/SD51/651/ENG51",

        "DATE:04/02/2013",
        "ADDR:DOVER CT & PENNSYLVA",
        "TIME:16:05",
        "X:DOVER CT & PENNSYLVANIA AV",
        "CODE:FIRE-NON",
        "CALL:VEHICLE FIRE",
        "UNIT:652/SD51/651/ENG51");

    doTest("T10",
        "FRM:dispatch@southmediafire.com\n" +
        "MSG:[Update]*04/02/2013*1 TANGLEWOOD CIR*13:32*FORESTVIEW RD*FORESTVIEW RD*FIRE-BLD*BUILDING FIRE, RES/D",

        "DATE:04/02/2013",
        "ADDR:1 TANGLEWOOD CIR",
        "TIME:13:32",
        "X:FORESTVIEW RD & FORESTVIEW RD",
        "CODE:FIRE-BLD",
        "CALL:BUILDING FIRE, RES/D");

  }
  
  public static void main(String[] args) {
    new PADelawareCountyFParserTest().generateTests("T1");
  }
}
