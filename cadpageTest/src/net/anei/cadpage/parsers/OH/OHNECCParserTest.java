package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
NECC, OH
Contact: Jon Frye <jfrye@safety-center.org>
Sender; Dispatcher@safety-center.org,rc.340@c-msg.net

(NECC) [F] LV:1 ALARM CARBON MONOXIDE NO SYMPTOMS\n/\n1619 W LOVELAND AV\n(LV)\nXS: S LEBANON RD & HEIDELBURG DR\n\nRCVD AS Phone\n\nCOM:\nALARM ACTIVATED
[NECC]  [F] LV:1 ALARM FIRE\n/\nCHILI'S GRILL & BAR\n11329<tel:11329> MONTGOMERY RD\n(SY)\nXS: HARPERSPOINTE DR & E KEMPER RD\n\nRCVD AS Phone\n\nCOM:\nF28 FIRE DUCT ALARM\nE9
(NECC) [F] LV:1 AUTO ACCIDENT INJURY\n/\nFIELDS ERTEL RD/UNION CEMETERY RD\n(SY)\nXS: UNION CEMETERY RD & GREEN ARBORS LN\n\nRCVD AS Phone\n\nCOM:
(NECC) [F] LV:1 AUTO ACCIDENT VEHICLE FIRE\n/\nBECKER\n9695 LOVELAND MADEIRA RD\n(SY)\nXS: HUMPHREY RD & MORGANS TRACE\n\nRCVD AS Phone

Contact: Nate Ritchey <nwritchey911@gmail.com>
Subject:NECC\n[E] LV:1 EMS SUICIDAL SUBJECT\n/\n11645 THISTLEHILL DR\n(SY)\nXS: HEIDLEBERG DR & SYMBOLA DR\n\nRCVD AS Phone\n\nCOM:\nC\nALLED IN 3RD PARTY-BY THE PATIENTS COUNSELOR -\nJENNIFER REDWITZ - 685.9344\nSHE STATED THAT THE 26-F @ THIS ADDRESS IS \n

Contact:  Matt Fox <mattfox79@gmail.com>
Sender: rc.340@c-msg.net
rc.340@c-msg.net\nSUBJ:NECC\nMSG:\n[E] LV:1 EMS UNK ILL/INJ\r\n/\r\n3056 STRATFORD CT\r\n(LV)\r\nXS: ENYART RD & N/A\r\n\r\n\r\n\r\nCOM:\r\n\r\n\r\n
rc.340@c-msg.net\nSUBJ:NECC\nMSG:\n[E] LV:1 EMS CHEST PAIN/HEART\r\n/\r\nVAN\r\n8500 GOVERNORS HILL DR\r\n(SY)\r\nXS: MASON RD & N/A\r\n\r\n\r\n\r\nCOM:\r\nF/OLDER\r\n\r\n

*/

public class OHNECCParserTest extends BaseParserTest {
  
  public OHNECCParserTest() {
    setParser(new OHNECCParser(), "", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(NECC) [F] LV:1 ALARM CARBON MONOXIDE NO SYMPTOMS\n/\n1619 W LOVELAND AV\n(LV)\nXS: S LEBANON RD & HEIDELBURG DR\n\nRCVD AS Phone\n\nCOM:\nALARM ACTIVATED",
        "CALL:ALARM CARBON MONOXIDE NO SYMPTOMS",
        "ADDR:1619 W LOVELAND AV",
        "MADDR:1619 W LOVELAND AVE",
        "CITY:LOVELAND",
        "X:S LEBANON RD & HEIDELBURG DR",
        "INFO:ALARM ACTIVATED");

    doTest("T2",
        "[NECC]  [F] LV:1 ALARM FIRE\n/\nCHILI'S GRILL & BAR\n11329<tel:11329> MONTGOMERY RD\n(SY)\nXS: HARPERSPOINTE DR & E KEMPER RD\n\nRCVD AS Phone\n\nCOM:\nF28 FIRE DUCT ALARM\nE9",
        "CALL:ALARM FIRE",
        "PLACE:CHILI'S GRILL & BAR",
        "PHONE:11329",
        "ADDR:11329 MONTGOMERY RD",
        "CITY:SYMMES",
        "X:HARPERSPOINTE DR & E KEMPER RD",
        "INFO:F28 FIRE DUCT ALARM / E9");

    doTest("T3",
        "(NECC) [F] LV:1 AUTO ACCIDENT INJURY\n/\nFIELDS ERTEL RD/UNION CEMETERY RD\n(SY)\nXS: UNION CEMETERY RD & GREEN ARBORS LN\n\nRCVD AS Phone\n\nCOM:",
        "CALL:AUTO ACCIDENT INJURY",
        "ADDR:FIELDS ERTEL RD & UNION CEMETERY RD",
        "CITY:SYMMES",
        "X:UNION CEMETERY RD & GREEN ARBORS LN");

    doTest("T4",
        "(NECC) [F] LV:1 AUTO ACCIDENT VEHICLE FIRE\n/\nBECKER\n9695 LOVELAND MADEIRA RD\n(SY)\nXS: HUMPHREY RD & MORGANS TRACE\n\nRCVD AS Phone",
        "CALL:AUTO ACCIDENT VEHICLE FIRE",
        "PLACE:BECKER",
        "ADDR:9695 LOVELAND MADEIRA RD",
        "CITY:SYMMES",
        "X:HUMPHREY RD & MORGANS TRACE");

    doTest("T5",
        "Subject:NECC\n[E] LV:1 EMS SUICIDAL SUBJECT\n/\n11645 THISTLEHILL DR\n(SY)\nXS: HEIDLEBERG DR & SYMBOLA DR\n\nRCVD AS Phone\n\nCOM:\nC\nALLED IN 3RD PARTY-BY THE PATIENTS COUNSELOR -\nJENNIFER REDWITZ - 685.9344\nSHE STATED THAT THE 26-F @ THIS ADDRESS IS \n",
        "CALL:EMS SUICIDAL SUBJECT",
        "ADDR:11645 THISTLEHILL DR",
        "CITY:SYMMES",
        "X:HEIDLEBERG DR & SYMBOLA DR",
        "INFO:C / ALLED IN 3RD PARTY-BY THE PATIENTS COUNSELOR - / JENNIFER REDWITZ - 685.9344 / SHE STATED THAT THE 26-F @ THIS ADDRESS IS");

    doTest("T6",
        "rc.340@c-msg.net\nSUBJ:NECC\nMSG:\n[E] LV:1 EMS UNK ILL/INJ\r\n/\r\n3056 STRATFORD CT\r\n(LV)\r\nXS: ENYART RD & N/A\r\n\r\n\r\n\r\nCOM:\r\n\r\n\r\n",
        "CALL:EMS UNK ILL/INJ",
        "ADDR:3056 STRATFORD CT",
        "CITY:LOVELAND",
        "X:ENYART RD & N/A");

    doTest("T7",
        "rc.340@c-msg.net\n" +
        "SUBJ:NECC\n" +
        "MSG:\n" +
        "[E] LV:1 EMS CHEST PAIN/HEART\r\n" +
        "/\r\n" +
        "VAN\r\n" +
        "8500 GOVERNORS HILL DR\r\n" +
        "(SY)\r\n" +
        "XS: MASON RD & N/A\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "F/OLDER\r\n" +
        "\r\n",

        "CALL:EMS CHEST PAIN/HEART",
        "PLACE:VAN",
        "ADDR:8500 GOVERNORS HILL DR",
        "CITY:SYMMES",
        "X:MASON RD & N/A",
        "INFO:F/OLDER");
     
  }
  
  public static void main(String[] args) {
    new OHNECCParserTest().generateTests("T8");
  }
}