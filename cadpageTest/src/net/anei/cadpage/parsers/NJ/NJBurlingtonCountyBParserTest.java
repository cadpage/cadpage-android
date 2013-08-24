package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Burlington County, NJ 
Contact: Robert Allen <rallen7779@gmail.com>
Sender: chief1300@comcast.net

Messenger 911 / [Update]\n18:43:42\n133 E TrfcEntp\n5010\nSOUTH AV\nPINE ST\nPINE ST\n
Messenger 911 / 18:43:42\n129 E AccInjry\n5010\nSOUTH AV\nPINE ST\nPINE ST\n
Messenger 911 / [Update]\n22:39:55\n16 F Alarms\n1321\n691 EAYRESTOWN RD\nMUNICIPAL DR/RT38\n609.267.1224/GENERAL ALARM
Messenger 911 / 14:29:55\n132 E UnkMedEmrg\n1310\n4 HEMSING DR\nMAIN ST/ESTATE RD\nMALE WITH FOOT INJURY\nWPH2:
Messenger 911 / [Update]\n14:57:17\n129F E Mva/Fire\n1311\n1740 E RT38\nEAYRESTOWN RD/SMITHVILLE RD\n1 VEH OVERTURNED//OCCUPANTS ST\nIFO\n
Messenger 911 / [Update]\n10:34:13\n129F E Mva/Fire\n1340\nE RT38\nMT HOLLY BP\nWHI PICKUP TRUCK FLIPPED OVER \nWRLS:  PCS/WIRELESS DEFAULT\n

*/

public class NJBurlingtonCountyBParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyBParserTest() {
    setParser(new NJBurlingtonCountyBParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Messenger 911 / [Update]\n18:43:42\n133 E TrfcEntp\n5010\nSOUTH AV\nPINE ST\nPINE ST\n",
        "TIME:18:43:42",
        "CALL:133 E TrfcEntp",
        "UNIT:5010",
        "ADDR:SOUTH AV",
        "MADDR:SOUTH AVE & PINE ST",
        "X:PINE ST & PINE ST");

    doTest("T2",
        "Messenger 911 / 18:43:42\n129 E AccInjry\n5010\nSOUTH AV\nPINE ST\nPINE ST\n",
        "TIME:18:43:42",
        "CALL:129 E AccInjry",
        "UNIT:5010",
        "ADDR:SOUTH AV",
        "MADDR:SOUTH AVE & PINE ST",
        "X:PINE ST & PINE ST");

    doTest("T3",
        "Messenger 911 / [Update]\n22:39:55\n16 F Alarms\n1321\n691 EAYRESTOWN RD\nMUNICIPAL DR/RT38\n609.267.1224/GENERAL ALARM",
        "TIME:22:39:55",
        "CALL:16 F Alarms",
        "UNIT:1321",
        "ADDR:691 EAYRESTOWN RD",
        "X:MUNICIPAL DR/RT38 & 609.267.1224/GENERAL ALARM");

    doTest("T4",
        "Messenger 911 / 14:29:55\n132 E UnkMedEmrg\n1310\n4 HEMSING DR\nMAIN ST/ESTATE RD\nMALE WITH FOOT INJURY\nWPH2:",
        "TIME:14:29:55",
        "CALL:132 E UnkMedEmrg",
        "UNIT:1310",
        "ADDR:4 HEMSING DR",
        "X:MAIN ST/ESTATE RD & MALE WITH FOOT INJURY",
        "INFO:WPH2:");

    doTest("T5",
        "Messenger 911 / [Update]\n" +
        "14:57:17\n" +
        "129F E Mva/Fire\n" +
        "1311\n" +
        "1740 E RT38\n" +
        "EAYRESTOWN RD/SMITHVILLE RD\n" +
        "1 VEH OVERTURNED//OCCUPANTS ST\n" +
        "IFO\n",

        "TIME:14:57:17",
        "CALL:129F E Mva/Fire",
        "UNIT:1311",
        "ADDR:1740 E RT38",
        "MADDR:1740 E RT 38",
        "X:EAYRESTOWN RD/SMITHVILLE RD & 1 VEH OVERTURNED//OCCUPANTS ST",
        "INFO:IFO");

    doTest("T6",
        "Messenger 911 / [Update]\n" +
        "10:34:13\n" +
        "129F E Mva/Fire\n" +
        "1340\n" +
        "E RT38\n" +
        "MT HOLLY BP\n" +
        "WHI PICKUP TRUCK FLIPPED OVER \n" +
        "WRLS:  PCS/WIRELESS DEFAULT\n",

        "TIME:10:34:13",
        "CALL:129F E Mva/Fire",
        "UNIT:1340",
        "ADDR:E RT38",
        "MADDR:E RT 38 & MT HOLLY BYPASS",
        "X:MT HOLLY BP & WHI PICKUP TRUCK FLIPPED OVER",
        "INFO:WRLS:  PCS/WIRELESS DEFAULT");
 
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyBParserTest().generateTests("T1");
  }
}