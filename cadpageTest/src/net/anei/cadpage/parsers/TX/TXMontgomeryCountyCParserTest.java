package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Montgomery County, TX

Variant B messages should fail
(CAD Message) 13-008215 - 7) 04/13/2013 17:47:59 17:47:59.000-[7] [Notification] [Montgomery County Hosp Dist]-21 YOF FELL APPROX 4 FEET OFF LADDER. WILL HAVE A LEAD IN OUT FRONT [Shared]
(CAD Message) 13-008209 29115 Cullen Child Locked in a Ve18A-T 214Z FD2 E182
(CAD Message) 13-008200 6910 South Trace Dr Medical Priority 2 18A-T 185Y FD3 MR186

Contact: Active911
Agency name: City of Conroe Fire Department
Location: Conroe, TX, United States
Sender: tritechcad@mchd-tx.org

(CAD Message) ID:13-003873 ;UNIT:E1 CALL:Choking ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H
(CAD Message) ID#:13-003861 ; Unit:E2 ; AC - Assignment Complete ; Disp:10:15; Enrt:10:16; On Scene:10:25; Avail:10:29
(CAD Message) ID:13-003861 ;UNIT:E2 CALL:Difficulty Breathing ;PLACE: ;ADDR:39 Silver Creek Dr ;CITY:CONROE ;MAP:157U
(CAD Message) ID:13-003854 ;UNIT:E2 CALL:Traumatic Injury ;PLACE: ;ADDR:2406 N Frazier St ;CITY:CONROE ;MAP:157R
(CAD Message) ID#:13-003843 ; Unit:E4 ; AC - Assignment Complete ; Disp:07:33; Enrt:07:35; On Scene:07:40; Avail:07:50
(CAD Message) ID:13-003843 ;UNIT:E4 CALL:Unconscious/Fainting ;PLACE: ;ADDR:11 Marlowe Way ;CITY:CONROE ;MAP:217M
(CAD Message) ID#:13-003839 ; Unit:E3 ; AC - Assignment Complete ; Disp:06:41; Enrt:06:42; On Scene:06:45; Avail:07:05
(CAD Message) ID:13-003839 ;UNIT:E3 CALL:Seizures ;PLACE: ;ADDR:1822 S 3rd St ;CITY:CONROE ;MAP:188J
(CAD Message) ID#:13-003836 ; Unit:E3 ; AC - Assignment Complete ; Disp:06:16; Enrt:06:17; On Scene:06:20; Avail:06:34
(CAD Message) ID:13-003836 ;UNIT:E3 CALL:Unconscious/Fainting ;PLACE: ;ADDR:304 Avenue E ;CITY:CONROE ;MAP:188A
(CAD Message) ID#:13-003832 ; Unit:E3 ; AC - Assignment Complete ; Disp:05:09; Enrt:05:11; On Scene:05:16; Avail:05:51
(CAD Message) ID:13-003832 ;UNIT:E3 CALL:Fall ;PLACE: ;ADDR:1300 Silverdale Dr ;CITY:CONROE ;MAP:188C
(CAD Message) ID#:13-003830 ; Unit:E2 ; AC - Assignment Complete ; Disp:03:25; Enrt:03:28; On Scene:03:33; Avail:03:38
(CAD Message) ID:13-003830 ;UNIT:E2 CALL:Chest Pain ;PLACE: ;ADDR:1101 Wilson Rd ;CITY:CONROE ;MAP:157U
(CAD Message) ID#:13-003822 ; Unit:E3 ; AC - Assignment Complete ; Disp:01:19; Enrt:01:21; On Scene:01:25; Avail:01:29
(CAD Message) ID:13-003822 ;UNIT:E3 CALL:67B01-SMALL OUTSIDE FIRE ;PLACE: ;ADDR:S Main St / Mill Ave ;CITY:CONROE ;MAP:187D
(CAD Message) ID#:13-003818 ; Unit:E1 ; AC - Assignment Complete ; Disp:22:13; Enrt:22:15; On Scene:22:24; Avail:22:37
(CAD Message) ID:13-003818 ;UNIT:E1 CALL:Difficulty Breathing ;PLACE: ;ADDR:403 S Rivershire Dr ;CITY:CONROE ;MAP:187L
(CAD Message) ID#:13-003816 ; Unit:E1 ; AC - Assignment Complete ; Disp:21:19; Enrt:21:21; On Scene:21:24; Avail:21:27
(CAD Message) ID:13-003816 ;UNIT:E1 CALL:Sick Person ;PLACE: ;ADDR:907 W Davis St ;CITY:CONROE ;MAP:157Z
(CAD Message) ID#:13-003815 ; Unit:E4 ; AC - Assignment Complete ; Disp:21:10; Enrt:21:12; On Scene: ; Avail:21:18
(CAD Message) ID:13-003815 ;UNIT:E4 CALL:68A01-LIGHT SMOKE OUTSIDE ;PLACE: ;ADDR:545 Fm 1488 ;CITY:CONROE ;MAP:217G
(CAD Message) ID#:13-003803 ; Unit:E5 ; AC - Assignment Complete ; Disp:19:08; Enrt:19:13; On Scene:19:15; Avail:19:29
(CAD Message) ID:13-003803 ;UNIT:E5 CALL:MVA ;PLACE: ;ADDR:Highway 105 W / Blake Rd ;CITY:CONROE ;MAP:156N
(CAD Message) ID#:13-003792 ; Unit:E4 ; AC - Assignment Complete ; Disp:18:04; Enrt:18:06; On Scene: ; Avail:18:09
(CAD Message) ID:13-003792 ;UNIT:E4 CALL:68A01-LIGHT SMOKE OUTSIDE ;PLACE: ;ADDR:Fm 1488 / Peoples Rd ;CITY:CONROE ;MAP:217G
(CAD Message) ID#:13-003788 ; Unit:E1 ; AC - Assignment Complete ; Disp:17:39; Enrt:17:40; On Scene:17:44; Avail:17:56
(CAD Message) ID:13-003788 ;UNIT:E1 CALL:Unconscious/Fainting ;PLACE: ;ADDR:104 Interstate 45 N ;CITY:CONROE ;MAP:187D
(CAD Message) ID#:13-003781 ; Unit:E3 ; AC - Assignment Complete ; Disp:16:04; Enrt:16:06; On Scene:16:09; Avail:16:19
(CAD Message) ID:13-003781 ;UNIT:E3 CALL:Chest Pain ;PLACE: ;ADDR:1101 S 7th St ;CITY:CONROE ;MAP:188B
(CAD Message) ID#:13-003779 ; Unit:E3 ; AC - Assignment Complete ; Disp:15:34; Enrt:15:35; On Scene: ; Avail:15:38
(CAD Message) ID:13-003779 ;UNIT:E3 CALL:52C01-ALARM HIGH LIFE HAZARD ;PLACE: ;ADDR:100 Kids R Kids Dr ;CITY:CONROE ;MAP:187M
(CAD Message) ID#:13-003771 ; Unit:E3 ; AC - Assignment Complete ; Disp:14:33; Enrt:14:34; On Scene:14:39; Avail:15:04
(CAD Message) ID:13-003771 ;UNIT:E3 CALL:Difficulty Breathing ;PLACE: ;ADDR:1712 Hazelwood Dr ;CITY:CONROE ;MAP:188C
(CAD Message) ID#:13-003765 ; Unit:E3 ; AC - Assignment Complete ; Disp:13:52; Enrt:13:54; On Scene: ; Avail:13:57
(CAD Message) ID:13-003765 ;UNIT:E3 CALL:Chest Pain ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H
(CAD Message) ID:13-003765 ;UNIT:E1 CALL:Chest Pain ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H
(CAD Message) ID#:13-003742 ; Unit:E5 ; AC - Assignment Complete ; Disp:11:26; Enrt:11:28; On Scene:11:35; Avail:11:57
(CAD Message) ID:13-003742 ;UNIT:E5 CALL:MVA ;PLACE: ;ADDR:N Frazier St / Fm 830 ;CITY:CONROE ;MAP:127U
(CAD Message) ID#:13-003735 ; Unit:E3 ; AC - Assignment Complete ; Disp:10:56; Enrt:10:57; On Scene:11:02; Avail:11:10
(CAD Message) ID:13-003738 ;UNIT:E2 CALL:Unconscious/Fainting ;PLACE: ;ADDR:1300 Silverdale Dr ;CITY:CONROE ;MAP:188C
(CAD Message) ID:13-003735 ;UNIT:E3 CALL:Headache ;PLACE: ;ADDR:1101 S 7th St ;CITY:CONROE ;MAP:188B
(CAD Message) ID#:13-003726 ; Unit:E3 ; AC - Assignment Complete ; Disp:09:29; Enrt:09:30; On Scene:09:34; Avail:09:52
(CAD Message) ID:13-003726 ;UNIT:E3 CALL:69C02-EXTINGUISHED FIRE ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H
(CAD Message) ID:13-003726 ;UNIT:E1 CALL:69C02-EXTINGUISHED FIRE ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H
(CAD Message) ID:13-003726 ;UNIT:BC1 CALL:69C02-EXTINGUISHED FIRE ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H
(CAD Message) ID#:13-003724 ; Unit:E3 ; AC - Assignment Complete ; Disp:09:22; Enrt: ; On Scene: ; Avail:09:24
(CAD Message) ID:13-003724 ;UNIT:E3 CALL:52C01W-HIGH LIFE HAZARD ALARM ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H
(CAD Message) ID#:13-003705 ; Unit:E1 ; AC - Assignment Complete ; Disp:01:11; Enrt:01:14; On Scene: ; Avail:01:19
(CAD Message) ID:13-003705 ;UNIT:E1 CALL:Fall ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H
(CAD Message) ID#:13-003691 ; Unit:E1 ; AC - Assignment Complete ; Disp:21:14; Enrt:21:15; On Scene:21:19; Avail:21:32
(CAD Message) ID:13-003691 ;UNIT:E1 CALL:Fall ;PLACE: ;ADDR:903 Longmire Rd ;CITY:CONROE ;MAP:157T
(CAD Message) ID#:13-003690 ; Unit:E1 ; AC - Assignment Complete ; Disp:20:39; Enrt:20:41; On Scene:20:45; Avail:21:00
(CAD Message) ID#:13-003689 ; Unit:E3 ; AC - Assignment Complete ; Disp:20:30; Enrt:20:31; On Scene:20:34; Avail:20:43
(CAD Message) ID:13-003690 ;UNIT:E1 CALL:52C03W-COMMERCIAL WATERFLOW ;PLACE: ;ADDR:1645 Interstate 45 N ;CITY:CONROE ;MAP:157U
(CAD Message) ID:13-003689 ;UNIT:E3 CALL:Sick Person ;PLACE: ;ADDR:304 Avenue E ;CITY:CONROE ;MAP:188A
(CAD Message) ID#:13-003670 ; Unit:E2 ; AC - Assignment Complete ; Disp:17:37; Enrt:17:38; On Scene:17:44; Avail:18:03
(CAD Message) ID:13-003670 ;UNIT:E2 CALL:Traumatic Injury ;PLACE: ;ADDR:1111 Irish Dr ;CITY:CONROE ;MAP:157U
(CAD Message) ID#:13-003665 ; Unit:E2 ; AC - Assignment Complete ; Disp:17:03; Enrt:17:04; On Scene:17:06; Avail:17:23
(CAD Message) ID:13-003665 ;UNIT:E2 CALL:MVA ;PLACE: ;ADDR:N Frazier St / Hildred Ave ;CITY:CONROE ;MAP:157R
(CAD Message) ID#:13-003656 ; Unit:E3 ; AC - Assignment Complete ; Disp:16:18; Enrt:16:19; On Scene:16:23; Avail:16:35
(CAD Message) ID:13-003656 ;UNIT:E3 CALL:MVA ;PLACE: ;ADDR:Ih45 S / Crighton Rd ;CITY:CONROE ;MAP:187V
(CAD Message) ID#:13-003654 ; Unit:E3 ; AC - Assignment Complete ; Disp:16:03; Enrt:16:05; On Scene:16:11; Avail:16:16
(CAD Message) ID:13-003656 ;UNIT:E4 CALL:MVA ;PLACE: ;ADDR:Ih45 S / Crighton Rd ;CITY:CONROE ;MAP:187V
(CAD Message) ID:13-003654 ;UNIT:E3 CALL:Traumatic Injury ;PLACE: ;ADDR:304 Avenue E ;CITY:CONROE ;MAP:188A
(CAD Message) ID#:13-003644 ; Unit:E5 ; AC - Assignment Complete ; Disp:15:16; Enrt:15:17; On Scene:15:30; Avail:15:59
(CAD Message) ID#:13-003643 ; Unit:E2 ; AC - Assignment Complete ; Disp:15:10; Enrt:15:11; On Scene:15:14; Avail:15:27
(CAD Message) ID:13-003644 ;UNIT:E5 CALL:MVA ;PLACE: ;ADDR:Interstate 45 N / Fm 830 ;CITY:CONROE ;MAP:127T
(CAD Message) ID:13-003643 ;UNIT:E2 CALL:Unconscious/Fainting ;PLACE: ;ADDR:212 Conroe Dr ;CITY:CONROE ;MAP:157Z
(CAD Message) ID#:13-003640 ; Unit:E2 ; AC - Assignment Complete ; Disp:14:50; Enrt:14:51; On Scene:14:56; Avail:15:08
(CAD Message) ID:13-003640 ;UNIT:E2 CALL:Fall ;PLACE: ;ADDR:219 N Loop 336 E ;CITY:CONROE ;MAP:158N
(CAD Message) ID:13-003638 ;UNIT:E3 CALL:Abdominal Pain ;PLACE: ;ADDR:3601 S Loop 336 E ;CITY:CONROE ;MAP:189E
(CAD Message) ID#:13-003625 ; Unit:E1 ; AC - Assignment Complete ; Disp:12:53; Enrt:12:55; On Scene:13:00; Avail:13:26
(CAD Message) ID:13-003632 ;UNIT:E5 CALL:Diabetic Problems ;PLACE: ;ADDR:Ih45 Nb Entrance Fm830 / Ih45 Nb Ex;CITY:CONROE ;MAP:127T
(CAD Message) ID:13-003630 ;UNIT:E2 CALL:52C03-COMMERCIAL ALARM ;PLACE: ;ADDR:500 W Conroe Park Dr ;CITY:CONROE ;MAP:158E
(CAD Message) ID#:13-003624 ; Unit:E2 ; AC - Assignment Complete ; Disp:12:47; Enrt:12:48; On Scene:12:54; Avail:12:59
(CAD Message) ID:13-003625 ;UNIT:E1 CALL:Stroke ;PLACE: ;ADDR:401 Gay Dr ;CITY:CONROE ;MAP:157V
(CAD Message) ID:13-003624 ;UNIT:E2 CALL:MVA ;PLACE: ;ADDR:2500 Interstate 45 N ;CITY:CONROE ;MAP:157Q
(CAD Message) ID#:13-003622 ; Unit:E1 ; AC - Assignment Complete ; Disp:12:11; Enrt:12:11; On Scene:12:15; Avail:12:23
(CAD Message) ID:13-003622 ;UNIT:E1 CALL:Chest Pain ;PLACE: ;ADDR:2123 W Davis St ;CITY:CONROE ;MAP:157Y
(CAD Message) ID#:13-003620 ; Unit:E1 ; AC - Assignment Complete ; Disp:11:48; Enrt:11:50; On Scene:11:54; Avail:12:11
(CAD Message) ID:13-003620 ;UNIT:E1 CALL:Stroke ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H
(CAD Message) ID#:13-003613 ; Unit:E3 ; AC - Assignment Complete ; Disp:11:05; Enrt:11:06; On Scene:11:10; Avail:11:21
(CAD Message) ID#:13-003608 ; Unit:E5 ; AC - Assignment Complete ; Disp:10:41; Enrt:10:42; On Scene:10:47; Avail:11:20
(CAD Message) ID#:13-003610 ; Unit:E1 ; AC - Assignment Complete ; Disp:10:54; Enrt:10:56; On Scene:10:59; Avail:11:15
(CAD Message) ID:13-003613 ;UNIT:E3 CALL:Unconscious/Fainting ;PLACE: ;ADDR:104 York Ave Ave ;CITY:CONROE ;MAP:188A
(CAD Message) ID:13-003611 ;UNIT:E3 CALL:Stroke ;PLACE: ;ADDR:920 Interstate 45 S ;CITY:CONROE ;MAP:187H
(CAD Message) ID:13-003610 ;UNIT:E3 CALL:60C01-GAS LEAK INSIDE RES ;PLACE: ;ADDR:200 Summer Pine Ct ;CITY:CONROE ;MAP:187A
(CAD Message) ID:13-003610 ;UNIT:E2 CALL:60C01-GAS LEAK INSIDE RES ;PLACE: ;ADDR:200 Summer Pine Ct ;CITY:CONROE ;MAP:187A
(CAD Message) ID:13-003610 ;UNIT:E1 CALL:60C01-GAS LEAK INSIDE RES ;PLACE: ;ADDR:200 Summer Pine Ct ;CITY:CONROE ;MAP:187A
(CAD Message) ID:13-003608 ;UNIT:BC1 CALL:MVA ;PLACE: ;ADDR:Ih45 S / League Line Rd ;CITY:CONROE ;MAP:157B
(CAD Message) ID:13-003608 ; UNIT:E5 CALL:MVA ; PLACE: ; ADDR:Ih45 S / League Line Rd ; CITY:CONROE ; MAP:157B
(CAD Message) ID#:13-003606 ; Unit:E1 ; AC - Assignment Complete ; Disp:10:27; Enrt:10:27; On Scene:10:33; Avail:10:37
(CAD Message) ID:13-003606 ; UNIT:E1 CALL:Gas - Smell in a Res; PLACE: ; ADDR:200 Summer Pine Ct ; CITY:CONROE ; MAP:187A
(CAD Message) ID#:13-003602 ; Unit:E5 ; AC - Assignment Complete ; Disp:10:02; Enrt:10:04; On Scene:10:09; Avail:10:20
(CAD Message) ID#:13-003603 ; Unit:E1 ; AC - Assignment Complete ; Disp:10:03; Enrt:10:05; On Scene:10:09; Avail:10:16
(CAD Message) ID:13-003603 ; UNIT:E1 CALL:Unconscious/Fainting; PLACE: ; ADDR:1000 N Thompson St ; CITY:CONROE ; MAP:157Z
(CAD Message) ID:13-003602 ; UNIT:E5 CALL:Fall ; PLACE: ; ADDR:2225 Trey Rogillios Way ; CITY:CONROE ; MAP:156D

 */

public class TXMontgomeryCountyCParserTest extends BaseParserTest {
  
  public TXMontgomeryCountyCParserTest() {
    setParser(new TXMontgomeryCountyCParser(), "MONTGOMERY COUNTY", "TX");
  }
  
  @Test
  public void testVariantB() {
    doBadTest("(CAD Message) 13-008215 - 7) 04/13/2013 17:47:59 17:47:59.000-[7] [Notification] [Montgomery County Hosp Dist]-21 YOF FELL APPROX 4 FEET OFF LADDER. WILL HAVE A LEAD IN OUT FRONT [Shared]");
    doBadTest("(CAD Message) 13-008209 29115 Cullen Child Locked in a Ve18A-T 214Z FD2 E182");
    doBadTest("(CAD Message) 13-008200 6910 South Trace Dr Medical Priority 2 18A-T 185Y FD3 MR186");
  }
  
  @Test
  public void testConroeFire() {

    doTest("T1",
        "(CAD Message) ID:13-003873 ;UNIT:E1 CALL:Choking ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H",
        "ID:13-003873",
        "UNIT:E1 CALL:Choking",
        "ADDR:450 N Rivershire Dr",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T2",
        "(CAD Message) ID#:13-003861 ; Unit:E2 ; AC - Assignment Complete ; Disp:10:15; Enrt:10:16; On Scene:10:25; Avail:10:29",
        "CALL:RUN REPORT",
        "ID:13-003861",
        "UNIT:E2",
        "PLACE:AC - Assignment Complete ; Disp:10:15; Enrt:10:16; On Scene:10:25; Avail:10:29");

    doTest("T3",
        "(CAD Message) ID:13-003861 ;UNIT:E2 CALL:Difficulty Breathing ;PLACE: ;ADDR:39 Silver Creek Dr ;CITY:CONROE ;MAP:157U",
        "ID:13-003861",
        "UNIT:E2 CALL:Difficulty Breathing",
        "ADDR:39 Silver Creek Dr",
        "CITY:CONROE",
        "MAP:157U");

    doTest("T4",
        "(CAD Message) ID:13-003854 ;UNIT:E2 ;CALL:Traumatic Injury ;PLACE: ;ADDR:2406 N Frazier St ;CITY:CONROE ;MAP:157R",
        "ID:13-003854",
        "UNIT:E2",
        "CALL:Traumatic Injury",
        "ADDR:2406 N Frazier St",
        "CITY:CONROE",
        "MAP:157R");

    doTest("T5",
        "(CAD Message) ID#:13-003843 ; Unit:E4 ; AC - Assignment Complete ; Disp:07:33; Enrt:07:35; On Scene:07:40; Avail:07:50",
        "CALL:RUN REPORT",
        "ID:13-003843",
        "UNIT:E4",
        "PLACE:AC - Assignment Complete ; Disp:07:33; Enrt:07:35; On Scene:07:40; Avail:07:50");

    doTest("T6",
        "(CAD Message) ID:13-003843 ;UNIT:E4 CALL:Unconscious/Fainting ;PLACE: ;ADDR:11 Marlowe Way ;CITY:CONROE ;MAP:217M",
        "ID:13-003843",
        "UNIT:E4 CALL:Unconscious/Fainting",
        "ADDR:11 Marlowe Way",
        "CITY:CONROE",
        "MAP:217M");

    doTest("T7",
        "(CAD Message) ID#:13-003839 ; Unit:E3 ; AC - Assignment Complete ; Disp:06:41; Enrt:06:42; On Scene:06:45; Avail:07:05",
        "CALL:RUN REPORT",
        "ID:13-003839",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:06:41; Enrt:06:42; On Scene:06:45; Avail:07:05");

    doTest("T8",
        "(CAD Message) ID:13-003839 ;UNIT:E3 CALL:Seizures ;PLACE: ;ADDR:1822 S 3rd St ;CITY:CONROE ;MAP:188J",
        "ID:13-003839",
        "UNIT:E3 CALL:Seizures",
        "ADDR:1822 S 3rd St",
        "CITY:CONROE",
        "MAP:188J");

    doTest("T9",
        "(CAD Message) ID#:13-003836 ; Unit:E3 ; AC - Assignment Complete ; Disp:06:16; Enrt:06:17; On Scene:06:20; Avail:06:34",
        "CALL:RUN REPORT",
        "ID:13-003836",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:06:16; Enrt:06:17; On Scene:06:20; Avail:06:34");

    doTest("T10",
        "(CAD Message) ID:13-003836 ;UNIT:E3 CALL:Unconscious/Fainting ;PLACE: ;ADDR:304 Avenue E ;CITY:CONROE ;MAP:188A",
        "ID:13-003836",
        "UNIT:E3 CALL:Unconscious/Fainting",
        "ADDR:304 Avenue E",
        "CITY:CONROE",
        "MAP:188A");

    doTest("T11",
        "(CAD Message) ID#:13-003832 ; Unit:E3 ; AC - Assignment Complete ; Disp:05:09; Enrt:05:11; On Scene:05:16; Avail:05:51",
        "CALL:RUN REPORT",
        "ID:13-003832",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:05:09; Enrt:05:11; On Scene:05:16; Avail:05:51");

    doTest("T12",
        "(CAD Message) ID:13-003832 ;UNIT:E3 CALL:Fall ;PLACE: ;ADDR:1300 Silverdale Dr ;CITY:CONROE ;MAP:188C",
        "ID:13-003832",
        "UNIT:E3 CALL:Fall",
        "ADDR:1300 Silverdale Dr",
        "CITY:CONROE",
        "MAP:188C");

    doTest("T13",
        "(CAD Message) ID#:13-003830 ; Unit:E2 ; AC - Assignment Complete ; Disp:03:25; Enrt:03:28; On Scene:03:33; Avail:03:38",
        "CALL:RUN REPORT",
        "ID:13-003830",
        "UNIT:E2",
        "PLACE:AC - Assignment Complete ; Disp:03:25; Enrt:03:28; On Scene:03:33; Avail:03:38");

    doTest("T14",
        "(CAD Message) ID:13-003830 ;UNIT:E2 CALL:Chest Pain ;PLACE: ;ADDR:1101 Wilson Rd ;CITY:CONROE ;MAP:157U",
        "ID:13-003830",
        "UNIT:E2 CALL:Chest Pain",
        "ADDR:1101 Wilson Rd",
        "CITY:CONROE",
        "MAP:157U");

    doTest("T15",
        "(CAD Message) ID#:13-003822 ; Unit:E3 ; AC - Assignment Complete ; Disp:01:19; Enrt:01:21; On Scene:01:25; Avail:01:29",
        "CALL:RUN REPORT",
        "ID:13-003822",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:01:19; Enrt:01:21; On Scene:01:25; Avail:01:29");

    doTest("T16",
        "(CAD Message) ID:13-003822 ;UNIT:E3 CALL:67B01-SMALL OUTSIDE FIRE ;PLACE: ;ADDR:S Main St / Mill Ave ;CITY:CONROE ;MAP:187D",
        "ID:13-003822",
        "UNIT:E3 CALL:67B01-SMALL OUTSIDE FIRE",
        "ADDR:S Main St & Mill Ave",
        "CITY:CONROE",
        "MAP:187D");

    doTest("T17",
        "(CAD Message) ID#:13-003818 ; Unit:E1 ; AC - Assignment Complete ; Disp:22:13; Enrt:22:15; On Scene:22:24; Avail:22:37",
        "CALL:RUN REPORT",
        "ID:13-003818",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:22:13; Enrt:22:15; On Scene:22:24; Avail:22:37");

    doTest("T18",
        "(CAD Message) ID:13-003818 ;UNIT:E1 CALL:Difficulty Breathing ;PLACE: ;ADDR:403 S Rivershire Dr ;CITY:CONROE ;MAP:187L",
        "ID:13-003818",
        "UNIT:E1 CALL:Difficulty Breathing",
        "ADDR:403 S Rivershire Dr",
        "CITY:CONROE",
        "MAP:187L");

    doTest("T19",
        "(CAD Message) ID#:13-003816 ; Unit:E1 ; AC - Assignment Complete ; Disp:21:19; Enrt:21:21; On Scene:21:24; Avail:21:27",
        "CALL:RUN REPORT",
        "ID:13-003816",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:21:19; Enrt:21:21; On Scene:21:24; Avail:21:27");

    doTest("T20",
        "(CAD Message) ID:13-003816 ;UNIT:E1 CALL:Sick Person ;PLACE: ;ADDR:907 W Davis St ;CITY:CONROE ;MAP:157Z",
        "ID:13-003816",
        "UNIT:E1 CALL:Sick Person",
        "ADDR:907 W Davis St",
        "CITY:CONROE",
        "MAP:157Z");

    doTest("T21",
        "(CAD Message) ID#:13-003815 ; Unit:E4 ; AC - Assignment Complete ; Disp:21:10; Enrt:21:12; On Scene: ; Avail:21:18",
        "CALL:RUN REPORT",
        "ID:13-003815",
        "UNIT:E4",
        "PLACE:AC - Assignment Complete ; Disp:21:10; Enrt:21:12; On Scene: ; Avail:21:18");

    doTest("T22",
        "(CAD Message) ID:13-003815 ;UNIT:E4 CALL:68A01-LIGHT SMOKE OUTSIDE ;PLACE: ;ADDR:545 Fm 1488 ;CITY:CONROE ;MAP:217G",
        "ID:13-003815",
        "UNIT:E4 CALL:68A01-LIGHT SMOKE OUTSIDE",
        "ADDR:545 Fm 1488",
        "CITY:CONROE",
        "MAP:217G");

    doTest("T23",
        "(CAD Message) ID#:13-003803 ; Unit:E5 ; AC - Assignment Complete ; Disp:19:08; Enrt:19:13; On Scene:19:15; Avail:19:29",
        "CALL:RUN REPORT",
        "ID:13-003803",
        "UNIT:E5",
        "PLACE:AC - Assignment Complete ; Disp:19:08; Enrt:19:13; On Scene:19:15; Avail:19:29");

    doTest("T24",
        "(CAD Message) ID:13-003803 ;UNIT:E5 CALL:MVA ;PLACE: ;ADDR:Highway 105 W / Blake Rd ;CITY:CONROE ;MAP:156N",
        "ID:13-003803",
        "UNIT:E5 CALL:MVA",
        "ADDR:Highway 105 W & Blake Rd",
        "CITY:CONROE",
        "MAP:156N");

    doTest("T25",
        "(CAD Message) ID#:13-003792 ; Unit:E4 ; AC - Assignment Complete ; Disp:18:04; Enrt:18:06; On Scene: ; Avail:18:09",
        "CALL:RUN REPORT",
        "ID:13-003792",
        "UNIT:E4",
        "PLACE:AC - Assignment Complete ; Disp:18:04; Enrt:18:06; On Scene: ; Avail:18:09");

    doTest("T26",
        "(CAD Message) ID:13-003792 ;UNIT:E4 CALL:68A01-LIGHT SMOKE OUTSIDE ;PLACE: ;ADDR:Fm 1488 / Peoples Rd ;CITY:CONROE ;MAP:217G",
        "ID:13-003792",
        "UNIT:E4 CALL:68A01-LIGHT SMOKE OUTSIDE",
        "ADDR:Fm 1488 & Peoples Rd",
        "CITY:CONROE",
        "MAP:217G");

    doTest("T27",
        "(CAD Message) ID#:13-003788 ; Unit:E1 ; AC - Assignment Complete ; Disp:17:39; Enrt:17:40; On Scene:17:44; Avail:17:56",
        "CALL:RUN REPORT",
        "ID:13-003788",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:17:39; Enrt:17:40; On Scene:17:44; Avail:17:56");

    doTest("T28",
        "(CAD Message) ID:13-003788 ;UNIT:E1 CALL:Unconscious/Fainting ;PLACE: ;ADDR:104 Interstate 45 N ;CITY:CONROE ;MAP:187D",
        "ID:13-003788",
        "UNIT:E1 CALL:Unconscious/Fainting",
        "ADDR:104 Interstate 45 N",
        "CITY:CONROE",
        "MAP:187D");

    doTest("T29",
        "(CAD Message) ID#:13-003781 ; Unit:E3 ; AC - Assignment Complete ; Disp:16:04; Enrt:16:06; On Scene:16:09; Avail:16:19",
        "CALL:RUN REPORT",
        "ID:13-003781",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:16:04; Enrt:16:06; On Scene:16:09; Avail:16:19");

    doTest("T30",
        "(CAD Message) ID:13-003781 ;UNIT:E3 CALL:Chest Pain ;PLACE: ;ADDR:1101 S 7th St ;CITY:CONROE ;MAP:188B",
        "ID:13-003781",
        "UNIT:E3 CALL:Chest Pain",
        "ADDR:1101 S 7th St",
        "CITY:CONROE",
        "MAP:188B");

    doTest("T31",
        "(CAD Message) ID#:13-003779 ; Unit:E3 ; AC - Assignment Complete ; Disp:15:34; Enrt:15:35; On Scene: ; Avail:15:38",
        "CALL:RUN REPORT",
        "ID:13-003779",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:15:34; Enrt:15:35; On Scene: ; Avail:15:38");

    doTest("T32",
        "(CAD Message) ID:13-003779 ;UNIT:E3 CALL:52C01-ALARM HIGH LIFE HAZARD ;PLACE: ;ADDR:100 Kids R Kids Dr ;CITY:CONROE ;MAP:187M",
        "ID:13-003779",
        "UNIT:E3 CALL:52C01-ALARM HIGH LIFE HAZARD",
        "ADDR:100 Kids R Kids Dr",
        "CITY:CONROE",
        "MAP:187M");

    doTest("T33",
        "(CAD Message) ID#:13-003771 ; Unit:E3 ; AC - Assignment Complete ; Disp:14:33; Enrt:14:34; On Scene:14:39; Avail:15:04",
        "CALL:RUN REPORT",
        "ID:13-003771",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:14:33; Enrt:14:34; On Scene:14:39; Avail:15:04");

    doTest("T34",
        "(CAD Message) ID:13-003771 ;UNIT:E3 CALL:Difficulty Breathing ;PLACE: ;ADDR:1712 Hazelwood Dr ;CITY:CONROE ;MAP:188C",
        "ID:13-003771",
        "UNIT:E3 CALL:Difficulty Breathing",
        "ADDR:1712 Hazelwood Dr",
        "CITY:CONROE",
        "MAP:188C");

    doTest("T35",
        "(CAD Message) ID#:13-003765 ; Unit:E3 ; AC - Assignment Complete ; Disp:13:52; Enrt:13:54; On Scene: ; Avail:13:57",
        "CALL:RUN REPORT",
        "ID:13-003765",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:13:52; Enrt:13:54; On Scene: ; Avail:13:57");

    doTest("T36",
        "(CAD Message) ID:13-003765 ;UNIT:E3 CALL:Chest Pain ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H",
        "ID:13-003765",
        "UNIT:E3 CALL:Chest Pain",
        "ADDR:450 N Rivershire Dr",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T37",
        "(CAD Message) ID:13-003765 ;UNIT:E1 CALL:Chest Pain ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H",
        "ID:13-003765",
        "UNIT:E1 CALL:Chest Pain",
        "ADDR:450 N Rivershire Dr",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T38",
        "(CAD Message) ID#:13-003742 ; Unit:E5 ; AC - Assignment Complete ; Disp:11:26; Enrt:11:28; On Scene:11:35; Avail:11:57",
        "CALL:RUN REPORT",
        "ID:13-003742",
        "UNIT:E5",
        "PLACE:AC - Assignment Complete ; Disp:11:26; Enrt:11:28; On Scene:11:35; Avail:11:57");

    doTest("T39",
        "(CAD Message) ID:13-003742 ;UNIT:E5 CALL:MVA ;PLACE: ;ADDR:N Frazier St / Fm 830 ;CITY:CONROE ;MAP:127U",
        "ID:13-003742",
        "UNIT:E5 CALL:MVA",
        "ADDR:N Frazier St & Fm 830",
        "CITY:CONROE",
        "MAP:127U");

    doTest("T40",
        "(CAD Message) ID#:13-003735 ; Unit:E3 ; AC - Assignment Complete ; Disp:10:56; Enrt:10:57; On Scene:11:02; Avail:11:10",
        "CALL:RUN REPORT",
        "ID:13-003735",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:10:56; Enrt:10:57; On Scene:11:02; Avail:11:10");

    doTest("T41",
        "(CAD Message) ID:13-003738 ;UNIT:E2 CALL:Unconscious/Fainting ;PLACE: ;ADDR:1300 Silverdale Dr ;CITY:CONROE ;MAP:188C",
        "ID:13-003738",
        "UNIT:E2 CALL:Unconscious/Fainting",
        "ADDR:1300 Silverdale Dr",
        "CITY:CONROE",
        "MAP:188C");

    doTest("T42",
        "(CAD Message) ID:13-003735 ;UNIT:E3 CALL:Headache ;PLACE: ;ADDR:1101 S 7th St ;CITY:CONROE ;MAP:188B",
        "ID:13-003735",
        "UNIT:E3 CALL:Headache",
        "ADDR:1101 S 7th St",
        "CITY:CONROE",
        "MAP:188B");

    doTest("T43",
        "(CAD Message) ID#:13-003726 ; Unit:E3 ; AC - Assignment Complete ; Disp:09:29; Enrt:09:30; On Scene:09:34; Avail:09:52",
        "CALL:RUN REPORT",
        "ID:13-003726",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:09:29; Enrt:09:30; On Scene:09:34; Avail:09:52");

    doTest("T44",
        "(CAD Message) ID:13-003726 ;UNIT:E3 CALL:69C02-EXTINGUISHED FIRE ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H",
        "ID:13-003726",
        "UNIT:E3 CALL:69C02-EXTINGUISHED FIRE",
        "ADDR:500 Hickerson St",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T45",
        "(CAD Message) ID:13-003726 ;UNIT:E1 CALL:69C02-EXTINGUISHED FIRE ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H",
        "ID:13-003726",
        "UNIT:E1 CALL:69C02-EXTINGUISHED FIRE",
        "ADDR:500 Hickerson St",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T46",
        "(CAD Message) ID:13-003726 ;UNIT:BC1 CALL:69C02-EXTINGUISHED FIRE ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H",
        "ID:13-003726",
        "UNIT:BC1 CALL:69C02-EXTINGUISHED FIRE",
        "ADDR:500 Hickerson St",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T47",
        "(CAD Message) ID#:13-003724 ; Unit:E3 ; AC - Assignment Complete ; Disp:09:22; Enrt: ; On Scene: ; Avail:09:24",
        "CALL:RUN REPORT",
        "ID:13-003724",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:09:22; Enrt: ; On Scene: ; Avail:09:24");

    doTest("T48",
        "(CAD Message) ID:13-003724 ;UNIT:E3 CALL:52C01W-HIGH LIFE HAZARD ALARM ;PLACE: ;ADDR:500 Hickerson St ;CITY:CONROE ;MAP:187H",
        "ID:13-003724",
        "UNIT:E3 CALL:52C01W-HIGH LIFE HAZARD ALARM",
        "ADDR:500 Hickerson St",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T49",
        "(CAD Message) ID#:13-003705 ; Unit:E1 ; AC - Assignment Complete ; Disp:01:11; Enrt:01:14; On Scene: ; Avail:01:19",
        "CALL:RUN REPORT",
        "ID:13-003705",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:01:11; Enrt:01:14; On Scene: ; Avail:01:19");

    doTest("T50",
        "(CAD Message) ID:13-003705 ;UNIT:E1 CALL:Fall ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H",
        "ID:13-003705",
        "UNIT:E1 CALL:Fall",
        "ADDR:450 N Rivershire Dr",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T51",
        "(CAD Message) ID#:13-003691 ; Unit:E1 ; AC - Assignment Complete ; Disp:21:14; Enrt:21:15; On Scene:21:19; Avail:21:32",
        "CALL:RUN REPORT",
        "ID:13-003691",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:21:14; Enrt:21:15; On Scene:21:19; Avail:21:32");

    doTest("T52",
        "(CAD Message) ID:13-003691 ;UNIT:E1 CALL:Fall ;PLACE: ;ADDR:903 Longmire Rd ;CITY:CONROE ;MAP:157T",
        "ID:13-003691",
        "UNIT:E1 CALL:Fall",
        "ADDR:903 Longmire Rd",
        "CITY:CONROE",
        "MAP:157T");

    doTest("T53",
        "(CAD Message) ID#:13-003690 ; Unit:E1 ; AC - Assignment Complete ; Disp:20:39; Enrt:20:41; On Scene:20:45; Avail:21:00",
        "CALL:RUN REPORT",
        "ID:13-003690",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:20:39; Enrt:20:41; On Scene:20:45; Avail:21:00");

    doTest("T54",
        "(CAD Message) ID#:13-003689 ; Unit:E3 ; AC - Assignment Complete ; Disp:20:30; Enrt:20:31; On Scene:20:34; Avail:20:43",
        "CALL:RUN REPORT",
        "ID:13-003689",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:20:30; Enrt:20:31; On Scene:20:34; Avail:20:43");

    doTest("T55",
        "(CAD Message) ID:13-003690 ;UNIT:E1 CALL:52C03W-COMMERCIAL WATERFLOW ;PLACE: ;ADDR:1645 Interstate 45 N ;CITY:CONROE ;MAP:157U",
        "ID:13-003690",
        "UNIT:E1 CALL:52C03W-COMMERCIAL WATERFLOW",
        "ADDR:1645 Interstate 45 N",
        "CITY:CONROE",
        "MAP:157U");

    doTest("T56",
        "(CAD Message) ID:13-003689 ;UNIT:E3 CALL:Sick Person ;PLACE: ;ADDR:304 Avenue E ;CITY:CONROE ;MAP:188A",
        "ID:13-003689",
        "UNIT:E3 CALL:Sick Person",
        "ADDR:304 Avenue E",
        "CITY:CONROE",
        "MAP:188A");

    doTest("T57",
        "(CAD Message) ID#:13-003670 ; Unit:E2 ; AC - Assignment Complete ; Disp:17:37; Enrt:17:38; On Scene:17:44; Avail:18:03",
        "CALL:RUN REPORT",
        "ID:13-003670",
        "UNIT:E2",
        "PLACE:AC - Assignment Complete ; Disp:17:37; Enrt:17:38; On Scene:17:44; Avail:18:03");

    doTest("T58",
        "(CAD Message) ID:13-003670 ;UNIT:E2 CALL:Traumatic Injury ;PLACE: ;ADDR:1111 Irish Dr ;CITY:CONROE ;MAP:157U",
        "ID:13-003670",
        "UNIT:E2 CALL:Traumatic Injury",
        "ADDR:1111 Irish Dr",
        "CITY:CONROE",
        "MAP:157U");

    doTest("T59",
        "(CAD Message) ID#:13-003665 ; Unit:E2 ; AC - Assignment Complete ; Disp:17:03; Enrt:17:04; On Scene:17:06; Avail:17:23",
        "CALL:RUN REPORT",
        "ID:13-003665",
        "UNIT:E2",
        "PLACE:AC - Assignment Complete ; Disp:17:03; Enrt:17:04; On Scene:17:06; Avail:17:23");

    doTest("T60",
        "(CAD Message) ID:13-003665 ;UNIT:E2 CALL:MVA ;PLACE: ;ADDR:N Frazier St / Hildred Ave ;CITY:CONROE ;MAP:157R",
        "ID:13-003665",
        "UNIT:E2 CALL:MVA",
        "ADDR:N Frazier St & Hildred Ave",
        "CITY:CONROE",
        "MAP:157R");

    doTest("T61",
        "(CAD Message) ID#:13-003656 ; Unit:E3 ; AC - Assignment Complete ; Disp:16:18; Enrt:16:19; On Scene:16:23; Avail:16:35",
        "CALL:RUN REPORT",
        "ID:13-003656",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:16:18; Enrt:16:19; On Scene:16:23; Avail:16:35");

    doTest("T62",
        "(CAD Message) ID:13-003656 ;UNIT:E3 CALL:MVA ;PLACE: ;ADDR:Ih45 S / Crighton Rd ;CITY:CONROE ;MAP:187V",
        "ID:13-003656",
        "UNIT:E3 CALL:MVA",
        "ADDR:Ih45 S & Crighton Rd",
        "CITY:CONROE",
        "MAP:187V");

    doTest("T63",
        "(CAD Message) ID#:13-003654 ; Unit:E3 ; AC - Assignment Complete ; Disp:16:03; Enrt:16:05; On Scene:16:11; Avail:16:16",
        "CALL:RUN REPORT",
        "ID:13-003654",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:16:03; Enrt:16:05; On Scene:16:11; Avail:16:16");

    doTest("T64",
        "(CAD Message) ID:13-003656 ;UNIT:E4 CALL:MVA ;PLACE: ;ADDR:Ih45 S / Crighton Rd ;CITY:CONROE ;MAP:187V",
        "ID:13-003656",
        "UNIT:E4 CALL:MVA",
        "ADDR:Ih45 S & Crighton Rd",
        "CITY:CONROE",
        "MAP:187V");

    doTest("T65",
        "(CAD Message) ID:13-003654 ;UNIT:E3 CALL:Traumatic Injury ;PLACE: ;ADDR:304 Avenue E ;CITY:CONROE ;MAP:188A",
        "ID:13-003654",
        "UNIT:E3 CALL:Traumatic Injury",
        "ADDR:304 Avenue E",
        "CITY:CONROE",
        "MAP:188A");

    doTest("T66",
        "(CAD Message) ID#:13-003644 ; Unit:E5 ; AC - Assignment Complete ; Disp:15:16; Enrt:15:17; On Scene:15:30; Avail:15:59",
        "CALL:RUN REPORT",
        "ID:13-003644",
        "UNIT:E5",
        "PLACE:AC - Assignment Complete ; Disp:15:16; Enrt:15:17; On Scene:15:30; Avail:15:59");

    doTest("T67",
        "(CAD Message) ID#:13-003643 ; Unit:E2 ; AC - Assignment Complete ; Disp:15:10; Enrt:15:11; On Scene:15:14; Avail:15:27",
        "CALL:RUN REPORT",
        "ID:13-003643",
        "UNIT:E2",
        "PLACE:AC - Assignment Complete ; Disp:15:10; Enrt:15:11; On Scene:15:14; Avail:15:27");

    doTest("T68",
        "(CAD Message) ID:13-003644 ;UNIT:E5 CALL:MVA ;PLACE: ;ADDR:Interstate 45 N / Fm 830 ;CITY:CONROE ;MAP:127T",
        "ID:13-003644",
        "UNIT:E5 CALL:MVA",
        "ADDR:Interstate 45 N & Fm 830",
        "CITY:CONROE",
        "MAP:127T");

    doTest("T69",
        "(CAD Message) ID:13-003643 ;UNIT:E2 CALL:Unconscious/Fainting ;PLACE: ;ADDR:212 Conroe Dr ;CITY:CONROE ;MAP:157Z",
        "ID:13-003643",
        "UNIT:E2 CALL:Unconscious/Fainting",
        "ADDR:212 Conroe Dr",
        "CITY:CONROE",
        "MAP:157Z");

    doTest("T70",
        "(CAD Message) ID#:13-003640 ; Unit:E2 ; AC - Assignment Complete ; Disp:14:50; Enrt:14:51; On Scene:14:56; Avail:15:08",
        "CALL:RUN REPORT",
        "ID:13-003640",
        "UNIT:E2",
        "PLACE:AC - Assignment Complete ; Disp:14:50; Enrt:14:51; On Scene:14:56; Avail:15:08");

    doTest("T71",
        "(CAD Message) ID:13-003640 ;UNIT:E2 CALL:Fall ;PLACE: ;ADDR:219 N Loop 336 E ;CITY:CONROE ;MAP:158N",
        "ID:13-003640",
        "UNIT:E2 CALL:Fall",
        "ADDR:219 N Loop 336 E",
        "CITY:CONROE",
        "MAP:158N");

    doTest("T72",
        "(CAD Message) ID:13-003638 ;UNIT:E3 CALL:Abdominal Pain ;PLACE: ;ADDR:3601 S Loop 336 E ;CITY:CONROE ;MAP:189E",
        "ID:13-003638",
        "UNIT:E3 CALL:Abdominal Pain",
        "ADDR:3601 S Loop 336 E",
        "CITY:CONROE",
        "MAP:189E");

    doTest("T73",
        "(CAD Message) ID#:13-003625 ; Unit:E1 ; AC - Assignment Complete ; Disp:12:53; Enrt:12:55; On Scene:13:00; Avail:13:26",
        "CALL:RUN REPORT",
        "ID:13-003625",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:12:53; Enrt:12:55; On Scene:13:00; Avail:13:26");

    doTest("T74",
        "(CAD Message) ID:13-003632 ;UNIT:E5 CALL:Diabetic Problems ;PLACE: ;ADDR:Ih45 Nb Entrance Fm830 / Ih45 Nb Ex;CITY:CONROE ;MAP:127T",
        "ID:13-003632",
        "UNIT:E5 CALL:Diabetic Problems",
        "ADDR:Ih45 Nb Entrance Fm830 & Ih45 Nb Ex",
        "MADDR:Ih45 Entrance Fm 830 & Ih45",
        "CITY:CONROE",
        "MAP:127T");

    doTest("T75",
        "(CAD Message) ID:13-003630 ;UNIT:E2 CALL:52C03-COMMERCIAL ALARM ;PLACE: ;ADDR:500 W Conroe Park Dr ;CITY:CONROE ;MAP:158E",
        "ID:13-003630",
        "UNIT:E2 CALL:52C03-COMMERCIAL ALARM",
        "ADDR:500 W Conroe Park Dr",
        "CITY:CONROE",
        "MAP:158E");

    doTest("T76",
        "(CAD Message) ID#:13-003624 ; Unit:E2 ; AC - Assignment Complete ; Disp:12:47; Enrt:12:48; On Scene:12:54; Avail:12:59",
        "CALL:RUN REPORT",
        "ID:13-003624",
        "UNIT:E2",
        "PLACE:AC - Assignment Complete ; Disp:12:47; Enrt:12:48; On Scene:12:54; Avail:12:59");

    doTest("T77",
        "(CAD Message) ID:13-003625 ;UNIT:E1 CALL:Stroke ;PLACE: ;ADDR:401 Gay Dr ;CITY:CONROE ;MAP:157V",
        "ID:13-003625",
        "UNIT:E1 CALL:Stroke",
        "ADDR:401 Gay Dr",
        "CITY:CONROE",
        "MAP:157V");

    doTest("T78",
        "(CAD Message) ID:13-003624 ;UNIT:E2 CALL:MVA ;PLACE: ;ADDR:2500 Interstate 45 N ;CITY:CONROE ;MAP:157Q",
        "ID:13-003624",
        "UNIT:E2 CALL:MVA",
        "ADDR:2500 Interstate 45 N",
        "CITY:CONROE",
        "MAP:157Q");

    doTest("T79",
        "(CAD Message) ID#:13-003622 ; Unit:E1 ; AC - Assignment Complete ; Disp:12:11; Enrt:12:11; On Scene:12:15; Avail:12:23",
        "CALL:RUN REPORT",
        "ID:13-003622",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:12:11; Enrt:12:11; On Scene:12:15; Avail:12:23");

    doTest("T80",
        "(CAD Message) ID:13-003622 ;UNIT:E1 CALL:Chest Pain ;PLACE: ;ADDR:2123 W Davis St ;CITY:CONROE ;MAP:157Y",
        "ID:13-003622",
        "UNIT:E1 CALL:Chest Pain",
        "ADDR:2123 W Davis St",
        "CITY:CONROE",
        "MAP:157Y");

    doTest("T81",
        "(CAD Message) ID#:13-003620 ; Unit:E1 ; AC - Assignment Complete ; Disp:11:48; Enrt:11:50; On Scene:11:54; Avail:12:11",
        "CALL:RUN REPORT",
        "ID:13-003620",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:11:48; Enrt:11:50; On Scene:11:54; Avail:12:11");

    doTest("T82",
        "(CAD Message) ID:13-003620 ;UNIT:E1 CALL:Stroke ;PLACE: ;ADDR:450 N Rivershire Dr ;CITY:CONROE ;MAP:187H",
        "ID:13-003620",
        "UNIT:E1 CALL:Stroke",
        "ADDR:450 N Rivershire Dr",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T83",
        "(CAD Message) ID#:13-003613 ; Unit:E3 ; AC - Assignment Complete ; Disp:11:05; Enrt:11:06; On Scene:11:10; Avail:11:21",
        "CALL:RUN REPORT",
        "ID:13-003613",
        "UNIT:E3",
        "PLACE:AC - Assignment Complete ; Disp:11:05; Enrt:11:06; On Scene:11:10; Avail:11:21");

    doTest("T84",
        "(CAD Message) ID#:13-003608 ; Unit:E5 ; AC - Assignment Complete ; Disp:10:41; Enrt:10:42; On Scene:10:47; Avail:11:20",
        "CALL:RUN REPORT",
        "ID:13-003608",
        "UNIT:E5",
        "PLACE:AC - Assignment Complete ; Disp:10:41; Enrt:10:42; On Scene:10:47; Avail:11:20");

    doTest("T85",
        "(CAD Message) ID#:13-003610 ; Unit:E1 ; AC - Assignment Complete ; Disp:10:54; Enrt:10:56; On Scene:10:59; Avail:11:15",
        "CALL:RUN REPORT",
        "ID:13-003610",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:10:54; Enrt:10:56; On Scene:10:59; Avail:11:15");

    doTest("T86",
        "(CAD Message) ID:13-003613 ;UNIT:E3 CALL:Unconscious/Fainting ;PLACE: ;ADDR:104 York Ave Ave ;CITY:CONROE ;MAP:188A",
        "ID:13-003613",
        "UNIT:E3 CALL:Unconscious/Fainting",
        "ADDR:104 York Ave Ave",
        "CITY:CONROE",
        "MAP:188A");

    doTest("T87",
        "(CAD Message) ID:13-003611 ;UNIT:E3 CALL:Stroke ;PLACE: ;ADDR:920 Interstate 45 S ;CITY:CONROE ;MAP:187H",
        "ID:13-003611",
        "UNIT:E3 CALL:Stroke",
        "ADDR:920 Interstate 45 S",
        "CITY:CONROE",
        "MAP:187H");

    doTest("T88",
        "(CAD Message) ID:13-003610 ;UNIT:E3 CALL:60C01-GAS LEAK INSIDE RES ;PLACE: ;ADDR:200 Summer Pine Ct ;CITY:CONROE ;MAP:187A",
        "ID:13-003610",
        "UNIT:E3 CALL:60C01-GAS LEAK INSIDE RES",
        "ADDR:200 Summer Pine Ct",
        "CITY:CONROE",
        "MAP:187A");

    doTest("T89",
        "(CAD Message) ID:13-003610 ;UNIT:E2 CALL:60C01-GAS LEAK INSIDE RES ;PLACE: ;ADDR:200 Summer Pine Ct ;CITY:CONROE ;MAP:187A",
        "ID:13-003610",
        "UNIT:E2 CALL:60C01-GAS LEAK INSIDE RES",
        "ADDR:200 Summer Pine Ct",
        "CITY:CONROE",
        "MAP:187A");

    doTest("T90",
        "(CAD Message) ID:13-003610 ;UNIT:E1 CALL:60C01-GAS LEAK INSIDE RES ;PLACE: ;ADDR:200 Summer Pine Ct ;CITY:CONROE ;MAP:187A",
        "ID:13-003610",
        "UNIT:E1 CALL:60C01-GAS LEAK INSIDE RES",
        "ADDR:200 Summer Pine Ct",
        "CITY:CONROE",
        "MAP:187A");

    doTest("T91",
        "(CAD Message) ID:13-003608 ;UNIT:BC1 CALL:MVA ;PLACE: ;ADDR:Ih45 S / League Line Rd ;CITY:CONROE ;MAP:157B",
        "ID:13-003608",
        "UNIT:BC1 CALL:MVA",
        "ADDR:Ih45 S & League Line Rd",
        "CITY:CONROE",
        "MAP:157B");

    doTest("T92",
        "(CAD Message) ID:13-003608 ; UNIT:E5 CALL:MVA ; PLACE: ; ADDR:Ih45 S / League Line Rd ; CITY:CONROE ; MAP:157B",
        "ID:13-003608",
        "UNIT:E5 CALL:MVA",
        "ADDR:Ih45 S & League Line Rd",
        "CITY:CONROE",
        "MAP:157B");

    doTest("T93",
        "(CAD Message) ID#:13-003606 ; Unit:E1 ; AC - Assignment Complete ; Disp:10:27; Enrt:10:27; On Scene:10:33; Avail:10:37",
        "CALL:RUN REPORT",
        "ID:13-003606",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:10:27; Enrt:10:27; On Scene:10:33; Avail:10:37");

    doTest("T94",
        "(CAD Message) ID:13-003606 ; UNIT:E1 CALL:Gas - Smell in a Res; PLACE: ; ADDR:200 Summer Pine Ct ; CITY:CONROE ; MAP:187A",
        "ID:13-003606",
        "UNIT:E1 CALL:Gas - Smell in a Res",
        "ADDR:200 Summer Pine Ct",
        "CITY:CONROE",
        "MAP:187A");

    doTest("T95",
        "(CAD Message) ID#:13-003602 ; Unit:E5 ; AC - Assignment Complete ; Disp:10:02; Enrt:10:04; On Scene:10:09; Avail:10:20",
        "CALL:RUN REPORT",
        "ID:13-003602",
        "UNIT:E5",
        "PLACE:AC - Assignment Complete ; Disp:10:02; Enrt:10:04; On Scene:10:09; Avail:10:20");

    doTest("T96",
        "(CAD Message) ID#:13-003603 ; Unit:E1 ; AC - Assignment Complete ; Disp:10:03; Enrt:10:05; On Scene:10:09; Avail:10:16",
        "CALL:RUN REPORT",
        "ID:13-003603",
        "UNIT:E1",
        "PLACE:AC - Assignment Complete ; Disp:10:03; Enrt:10:05; On Scene:10:09; Avail:10:16");

    doTest("T97",
        "(CAD Message) ID:13-003603 ; UNIT:E1 CALL:Unconscious/Fainting; PLACE: ; ADDR:1000 N Thompson St ; CITY:CONROE ; MAP:157Z",
        "ID:13-003603",
        "UNIT:E1 CALL:Unconscious/Fainting",
        "ADDR:1000 N Thompson St",
        "CITY:CONROE",
        "MAP:157Z");

    doTest("T98",
        "(CAD Message) ID:13-003602 ; UNIT:E5 CALL:Fall ; PLACE: ; ADDR:2225 Trey Rogillios Way ; CITY:CONROE ; MAP:156D",
        "ID:13-003602",
        "UNIT:E5 CALL:Fall",
        "ADDR:2225 Trey Rogillios Way",
        "CITY:CONROE",
        "MAP:156D");

  }
  
  public static void main(String[] args) {
    new TXMontgomeryCountyCParserTest().generateTests("T1");
  }
}
