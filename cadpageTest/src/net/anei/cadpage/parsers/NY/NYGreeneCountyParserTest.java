package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYGreeneCountyParser;

import org.junit.Test;

/*
Greene County NY (or Athens FD)
Contact: 8456569957@mms.att.net
Sender: 200-200-0004
GREENE 911:WIRES >WIRES DOWN / ARCING 117 RIVER RD ATHENS BRAUMULLER, HELENE Map: Grids:0,0 Cad: 2010-0000033052
GREENE 911:ALARMF>FIRE ALARM 558 SLEEPY HOLLOW RD ATHENS ADT SECURITY-OP ANDREA- Map:62 Grids:0,0 Cad: 2010-0000033344

Contact: Stephen Quick <stephen.d.quick@gmail.com>
GREENE 911:SMOKE >SMOKE INVESTIGATION 2ND ST VENTE JOEAN Cad: 2010-0000034969
GREENE 911:PIAA >MVA WITH INJURIES MARKET ST ATHENS BUCHAKIAN,DAVID Cad: 2010-0000033852
GREENE 911:STRUCT>STRUCTURE FIRE 408 W BRIDGE ST CATSKILL LAIRD, JACQUELYNN Cad: 2010-0000034875
GREENE 911:ALARMF>FIRE ALARM 341 W MAIN ST CATSKILL VILLAGE #401 Map: Grids:, Cad: 2011-0000011139
FRM:GREENE911@thinkgreene.us\nMSG:GREENE911:STRUCT>STRUCTURE FIRE SLEEPY HOLLOW RD & LAKE VIEW D ATHENS BARBARA Cad: 2012-0000002596

Contact: Neil Kellegher <kellegher@yahoo.com>
Sender: GREENE911@thinkgreene.us
FRM:GREENE911@thinkgreene.us\nMSG:GREENE911:VEHICL>VEHICLE FIRE\nROUTE 23\nDURHAM\nJAEGER, JEAN\nMap: Grids:,\nCad: 2013-0000005477

Contact: npk2017@gmail.com <npk2017@gmail.com>
Sender: GREENE911@thinkgreene.us
FRM:GREENE911@thinkgreene.us\nMSG:GREENE911:PIAA  >MVA WITH INJURIES\n12 SUNSIDE RD\nDURHAM\nTIERNEY,CECILIA\nMap: Grids:,\nCad: 2013-0000020603

*/

public class NYGreeneCountyParserTest extends BaseParserTest {
  
  public NYGreeneCountyParserTest() {
    setParser(new NYGreeneCountyParser(), "GREENE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "GREENE 911:WIRES >WIRES DOWN / ARCING 117 RIVER RD ATHENS BRAUMULLER, HELENE Map: Grids:0,0 Cad: 2010-0000033052",
        "CODE:WIRES",
        "CALL:WIRES DOWN / ARCING",
        "ADDR:117 RIVER RD",
        "CITY:ATHENS",
        "NAME:BRAUMULLER, HELENE",
        "ID:2010-0000033052");
    
    doTest("T2",
        "GREENE 911:ALARMF>FIRE ALARM 558 SLEEPY HOLLOW RD ATHENS ADT SECURITY-OP ANDREA- Map:62 Grids:0,0 Cad: 2010-0000033344",
        "CODE:ALARMF",
        "CALL:FIRE ALARM",
        "ADDR:558 SLEEPY HOLLOW RD",
        "CITY:ATHENS",
        "NAME:ADT SECURITY-OP ANDREA-",
        "MAP:62",
        "ID:2010-0000033344");
    
    doTest("T3",
        "GREENE 911:SMOKE >SMOKE INVESTIGATION 2ND ST VENTE JOEAN Cad: 2010-0000034969",
        "CODE:SMOKE",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:2ND ST",
        "NAME:VENTE JOEAN",
        "ID:2010-0000034969");
    
    doTest("T4",
        "GREENE 911:PIAA >MVA WITH INJURIES MARKET ST ATHENS BUCHAKIAN,DAVID Cad: 2010-0000033852",
        "CODE:PIAA",
        "CALL:MVA WITH INJURIES",
        "ADDR:MARKET ST",
        "CITY:ATHENS",
        "NAME:BUCHAKIAN,DAVID",
        "ID:2010-0000033852");
    
    doTest("T5",
        "GREENE 911:STRUCT>STRUCTURE FIRE 408 W BRIDGE ST CATSKILL LAIRD, JACQUELYNN Cad: 2010-0000034875",
        "CODE:STRUCT",
        "CALL:STRUCTURE FIRE",
        "ADDR:408 W BRIDGE ST",
        "CITY:CATSKILL",
        "NAME:LAIRD, JACQUELYNN",
        "ID:2010-0000034875");

    doTest("T6",
        "GREENE 911:ALARMF>FIRE ALARM 341 W MAIN ST CATSKILL VILLAGE #401 Map: Grids:, Cad: 2011-0000011139",
        "CODE:ALARMF",
        "CALL:FIRE ALARM",
        "ADDR:341 W MAIN ST",
        "CITY:CATSKILL",
        "NAME:VILLAGE #401",
        "ID:2011-0000011139");

    doTest("T7",
        "FRM:GREENE911@thinkgreene.us\n" +
        "MSG:GREENE911:STRUCT>STRUCTURE FIRE SLEEPY HOLLOW RD & LAKE VIEW D ATHENS BARBARA Cad: 2012-0000002596",

        "CODE:STRUCT",
        "CALL:STRUCTURE FIRE",
        "ADDR:SLEEPY HOLLOW RD & LAKE VIEW D",
        "CITY:ATHENS",
        "NAME:BARBARA",
        "ID:2012-0000002596");
   
  }
  
  @Test
  public void testNeilKellegher() {

    doTest("T1",
        "FRM:GREENE911@thinkgreene.us\nMSG:GREENE911:VEHICL>VEHICLE FIRE\nROUTE 23\nDURHAM\nJAEGER, JEAN\nMap: Grids:,\nCad: 2013-0000005477",
        "CODE:VEHICL",
        "CALL:VEHICLE FIRE",
        "ADDR:ROUTE 23",
        "CITY:DURHAM",
        "NAME:JAEGER, JEAN",
        "ID:2013-0000005477");

  }
  
  @Test
  public void testnpk2017() {

    doTest("T1",
        "FRM:GREENE911@thinkgreene.us\n" +
        "MSG:GREENE911:PIAA  >MVA WITH INJURIES\n" +
        "12 SUNSIDE RD\n" +
        "DURHAM\n" +
        "TIERNEY,CECILIA\n" +
        "Map: Grids:,\n" +
        "Cad: 2013-0000020603",

        "CODE:PIAA",
        "CALL:MVA",
        "ADDR:WITH INJURIES 12 SUNSIDE RD",
        "CITY:DURHAM",
        "NAME:TIERNEY,CECILIA",
        "ID:2013-0000020603");
   
  }
  
  public static void main(String[] args) {
    new NYGreeneCountyParserTest().generateTests("T1");
  }
}