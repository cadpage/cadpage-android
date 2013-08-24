package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Avon Town, CT (in Hartford County)
Contact: Keith Lee <klee@avonvfd.org>  (keithlee5@gmail.com)
Sender: messaging@iamresponding.com

FD STILL ALARM 00004 ORCHARD FARMS LN Cross:  ORCHARD ST/MICHELLE LN  E7  E10
FD Limited Assignment 00023 FOX DEN RD Cross:  SAW MILL LN/SLEEPY HOLLOW RD  E14  E9  L12  R8  T5  1247
FD Full Assignment W MAIN ST/DALE RD   L12  T5  R8  B15  1252  TK16  TK6  E9 E10  E14  E7  E11
FD Full Assignment 00255  AVON MOUNTAIN RD DEERCLIFF RD/EAST MAIN ST L12  T5  R8  B15  269  TK16  TK6  E9  E10  E14  E7  E11
FD STILL ALARM BEVERLY DR/ WOODMONT NA   E14  E9
FD Full Assignment E MAIN ST/ MOUNTAIN VIEW AVE   L12  T5  R8  B15  237  TK16 TK6  E9  E14  E10  E7  E11  AV26
FD STILL ALARM 00081 CHEVAS RD Cross:  GLEN HOLLOW DR/HUCKLEBERRY HILL RD  E7  E10
FD Full Assignment 00002  WHISPERING PINES NA LARKSPUR LN  L12  T5  R8 B15  1068  TK16  TK6  E9  E10  E14  E7  E11  AV26
FD Full Assignment 00020  SECURITY DR DARLING DR/ARCH RD  L12  T5  R8 B15  250  TK16  TK6  E9  E10  E14  E7  E11

AVFD / \nFD Full Assignment TALCOTT NOTCH RD/BAYBERRY HILL RD   L12  T5  R8  B15  237  TK16  TK6  E9  E14  E10  E7  E11 \n\n\n
AVFD / \nFD Limited Assignment AVON MOUNTAIN RD/DEERCLIFF RD   AV 1 \n\n\n

*/

public class CTHartfordCountyAvonParserTest extends BaseParserTest {
  
  public CTHartfordCountyAvonParserTest() {
    setParser(new CTHartfordCountyAvonParser(), "AVON", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FD STILL ALARM 00004 ORCHARD FARMS LN Cross:  ORCHARD ST/MICHELLE LN  E7  E10",
        "CALL:FD STILL ALARM",
        "ADDR:4 ORCHARD FARMS LN",
        "X:ORCHARD ST/MICHELLE LN",
        "UNIT:E7 E10");

    doTest("T2",
        "FD Limited Assignment 00023 FOX DEN RD Cross:  SAW MILL LN/SLEEPY HOLLOW RD  E14  E9  L12  R8  T5  1247",
        "CALL:FD Limited Assignment",
        "ADDR:23 FOX DEN RD",
        "X:SAW MILL LN/SLEEPY HOLLOW RD",
        "UNIT:E14 E9 L12 R8 T5 1247");

    doTest("T3",
        "FD Full Assignment W MAIN ST/DALE RD   L12  T5  R8  B15  1252  TK16  TK6  E9 E10  E14  E7  E11",
        "CALL:FD Full Assignment",
        "ADDR:W MAIN ST & DALE RD",
        "UNIT:L12 T5 R8 B15 1252 TK16 TK6 E9 E10 E14 E7 E11");

    doTest("T4",
        "FD Full Assignment 00255  AVON MOUNTAIN RD DEERCLIFF RD/EAST MAIN ST L12  T5  R8  B15  269  TK16  TK6  E9  E10  E14  E7  E11",
        "CALL:FD Full Assignment",
        "ADDR:255 AVON MOUNTAIN RD",
        "X:DEERCLIFF RD/EAST MAIN ST",
        "UNIT:L12 T5 R8 B15 269 TK16 TK6 E9 E10 E14 E7 E11");

    doTest("T5",
        "FD STILL ALARM BEVERLY DR/ WOODMONT NA   E14  E9",
        "CALL:FD STILL ALARM",
        "ADDR:BEVERLY DR & WOODMONT",
        "UNIT:E14 E9");

    doTest("T6",
        "FD Full Assignment E MAIN ST/ MOUNTAIN VIEW AVE   L12  T5  R8  B15  237  TK16 TK6  E9  E14  E10  E7  E11  AV26",
        "CALL:FD Full Assignment",
        "ADDR:E MAIN ST & MOUNTAIN VIEW AVE",
        "UNIT:L12 T5 R8 B15 237 TK16 TK6 E9 E14 E10 E7 E11 AV26");

    doTest("T7",
        "FD STILL ALARM 00081 CHEVAS RD Cross:  GLEN HOLLOW DR/HUCKLEBERRY HILL RD  E7  E10",
        "CALL:FD STILL ALARM",
        "ADDR:81 CHEVAS RD",
        "X:GLEN HOLLOW DR/HUCKLEBERRY HILL RD",
        "UNIT:E7 E10");

    doTest("T8",
        "FD Full Assignment 00002  WHISPERING PINES NA LARKSPUR LN  L12  T5  R8 B15  1068  TK16  TK6  E9  E10  E14  E7  E11  AV26",
        "CALL:FD Full Assignment",
        "ADDR:2 WHISPERING PINES",
        "X:LARKSPUR LN",
        "UNIT:L12 T5 R8 B15 1068 TK16 TK6 E9 E10 E14 E7 E11 AV26");

    doTest("T9",
        "FD Full Assignment 00020  SECURITY DR DARLING DR/ARCH RD  L12  T5  R8 B15  250  TK16  TK6  E9  E10  E14  E7  E11",
        "CALL:FD Full Assignment",
        "ADDR:20 SECURITY DR",
        "X:DARLING DR/ARCH RD",
        "UNIT:L12 T5 R8 B15 250 TK16 TK6 E9 E10 E14 E7 E11");


    doTest("T10",
        "AVFD / \nFD Full Assignment TALCOTT NOTCH RD/BAYBERRY HILL RD   L12  T5  R8  B15  237  TK16  TK6  E9  E14  E10  E7  E11 \n\n\n",
        "SRC:AVFD",
        "CALL:FD Full Assignment",
        "ADDR:TALCOTT NOTCH RD & BAYBERRY HILL RD",
        "UNIT:L12 T5 R8 B15 237 TK16 TK6 E9 E14 E10 E7 E11");

    doTest("T11",
        "AVFD / \nFD Limited Assignment AVON MOUNTAIN RD/DEERCLIFF RD   AV 1 \n\n\n",
        "SRC:AVFD",
        "CALL:FD Limited Assignment AVON",
        "ADDR:MOUNTAIN RD & DEERCLIFF RD",
        "UNIT:AV 1");
  }
  
  public static void main(String[] args) {
    new CTHartfordCountyAvonParserTest().generateTests("T1");
  }
}