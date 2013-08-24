package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Mecklenburg County, NC

Run reports
(Cad email) 06282013-407     Received:  19:47    Assigned:  19:47    Enroute:            Arrived:            Pt Contact:         Cancelled: 20:08       INC # - 06282013-071037\r\n
(Cad email) 06212013-055     Received:  05:12    Assigned:  05:12    Enroute:            Arrived:            Pt Contact:         Cancelled: 05:39       INC # - 06212013-067798\r\n
(Cad email) 06212013-055     Received:  05:12    Assigned:  05:12    Enroute:            Arrived:            Pt Contact:         Cancelled: 05:39       INC # - 06212013-067798\r\n

New Run reports
(CAD email) 07192013-448     Received:22:28Assigned:22:28Enroute:     Arrived:     Pt Contact:     Cancelled:22:40INC # -07192013-079438
(CAD email) 07192013-239     Received:13:50Assigned:13:50Enroute:13:52Arrived:14:00Pt Contact:     Cancelled:14:06INC # -07192013-079245
(CAD email) 07192013-241     Received:13:50Assigned:13:50Enroute:13:52Arrived:14:00Pt Contact:     Cancelled:14:06INC # -07192013-079245
(CAD email) 07182013-508     Received:22:16Assigned:22:16Enroute:     Arrived:22:23Pt Contact:22:24Cancelled:23:07INC # -07182013-079018
(CAD email) 07182013-116     Received:09:33Assigned:09:33Enroute:09:34Arrived:     Pt Contact:     Cancelled:09:37INC # -07182013-078692
(CAD email) 07182013-088     Received:08:01Assigned:08:01Enroute:08:02Arrived:08:10Pt Contact:     Cancelled:08:10INC # -07182013-078661
(CAD email) 07172013-197     Received:  13:58    Assigned:  13:58    Enroute:            Arrived:            Pt Contact:         Cancelled: 14:26       INC # - 07172013-078387

Contact: Rick <very.orange@gmail.com>
Sender: paging@rcscom.com
System: TriTech VisiCAD

Subject:Text Page\n18758 Silver Quay Dr                                                  Charlie                       17- Falls/Back injur
Subject:Text Page\n03172011-073     Received:  08:42    Assigned:  08:43    Enroute:   08:45    Arrived:   08:48    Pt Contact:         Can
Subject:Text Page\n19485 Old Jetton Rd           ste 100   Lakeside Familty Physicians anDelta                         31- Unconsciousness/
Subject:Text Page\n03172011-239     Received:  16:59    Assigned:  16:59    Enroute:   17:01    Arrived:   17:02    Pt Contact:         Can

Contact: Tucker Sizemore <tsizemore@gmail.com>
Sender: @huntersvillefd.com
(Text Page) 04022011-202     Received:  15:29    Assigned:  15:29    Enroute:            Arrived:            Pt Contact:
(Text Page) 16710 Northcross Dr                                                   Fire -  Emergency             59-Fuel Spi
(Text Page) 04022011-238     Received:  16:50    Assigned:  16:50    Enroute:   16:51    Arrived:   16:59    Pt Contact:
(Text Page) 19180-19209 Coachmans Trace             GLENRIDGE                     Fire -  Emergency             69-Structure Fire             Meadow Crossing L

Contact: John Stroup <jbstroup3@gmail.com>
Subject:Incoming Message\n16738 Amberside Rd East                 Alexander Chase Condos        Fire -  Emergency             52F-Alarm-FIRE

Contact: David Fuller <firefighter19163@netscape.com>
Subject:Incoming Message\n9150 Lawyers Rd                         McDonalds - Mint Hill         Charlie                       06- Breathing Pr
Subject:Incoming Message\n10043 Idlewild Rd             126       Willow Grove Retirement       Charlie                       06- Breathing Pr

Contact: David Boyd <rookiefire14@gmail.com>
(Incoming Message) 19432 Fridley Ln                        medical alarm .. no pt info ..Charlie                       32- Unknown problem (man down)Denae Lynn

Contact: Michael Filliben <mfillibene16@gmail.com>
Sender: Group_Page_Notification@archwireless.net
9120 Willow Ridge Rd          307A      Regency Retirement            Charlie                       26- Sick person               Goodsell
12463 Stratfield Place Cr               CAROLINA CROSSING SUBD        Delta                         31- Unconsciousness/Fainting  Stineway Ct/Sam Meeks Rd                                    PINR3     Map - 405405/J9 07302011-086
1010 Lakeview Dr              30-B      Pvl Rehab & Living Ctr  *SNF* Charlie                       06- Breathing Problems        Eden Cr/B

Contact: Ben Reagan <breagan@eastlincolnfd.org>
(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F
(Incoming Message) 13000-blk Hidcote Ct                    BURNING BRUSH                 Fire -  Emergency             67-
(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F
(Incoming Message) 14341 Salem Ridge Rd                    residential fire alarm        Fire -  Emergency             52F
(Incoming Message) 12019 Verhoeff Dr                       Huntersville Oaks Nursing *SNFFire -  Emergency             52F
(Incoming Message) Beatties Ford Rd & Mcilwaine R          TREE DOWN BLOCKING ONE LANE   Fire -  Emergency             53-

Contact: Mark Scheible <scheible_mark@yahoo.com>
Sender: s01page+bncCMiZ9YPHFxClpLL-BBoErtV5Mg@huntersvillefd.com
(Incoming Message) 12903 Thistlebrook Ln                                                 Bravo-BLS COLD
(Incoming Message) 11530 Beatties Ford Rd        MAIN ENTR Hopewell High School AED      Charlie       

** NOT IMPLEMENTED **
Contact: John Stroup <j.stroup@northmeckrescue.org>
Subject:Incoming Message\n15503 N Old Statesville Rd North Meck Rescue Charlie 12- Convulsion/Seizure 60 Foot St/Unnamed St Nmr1 Map - 266266/
Subject:Incoming Message\n15503 N Old Statesville Rd North Meck Rescue Charlie 12- Convulsion/Seizure 60 Foot St/Unnamed St Nmr2 Map - 266266/

16902 Harbor Master Cove                                              Fire -  Emergency             52F
1010 Lakeview Dr              30-B      Pvl Rehab & Living Ctr  *SNF* Charlie                       06- Breathing Problems        Eden Cr/B


Contact: Active911
Agency name: Pineville Fire Department
Location: Pineville, NC, United States
Sender: Group_Page_Notification@archwireless.net

10262012-151     Received:  10:24    Assigned:  10:24    Enroute:   10:26    Arrived:   10:27    Pt Contact:         Cancelled: 10:56       INC # - 10262012-117497 [20]\r\n
10262012-159     Received:  10:35    Assigned:  10:35    Enroute:   10:37    Arrived:   10:39    Pt Contact:         Cancelled: 10:46       INC # - 10262012-117503 [19]\r\n
9705 Leitner Dr               laundry rmfour points                   Delta                         31- Unconsciousness/Fainting  Centrum Py/Pineville-Matthews Rd                            PINR4     Map - 405405/K6 10262012-159 [18]\r\n
9120 Willow Ridge Rd          313       Regency Retirement            Bravo-BLS COLD                26BC-Sick person              Goodsell Ct/WILLOW BEND CR                                  PINR3     Map - 406406/A5 10262012-151 [17]\r\n
10262012-138     Received:  09:59    Assigned:  10:04    Enroute:   10:04    Arrived:   10:08    Pt Contact:         Cancelled: 10:18       INC # - 10262012-117482 [16]\r\n
Pineville-matthews Rd & Blue H                                        Delta                         29e Traffic accident/Entrapmnt                                                            PINF2     Map - 406406/B6 10262012-138 [15]\r\n
10262012-030     Received:  02:21    Assigned:  02:21    Enroute:   02:24    Arrived:   02:27    Pt Contact:         Cancelled: 02:49       INC # - 10262012-117393 [14]\r\n
401 Towne Centre Bv                     Hampton Inn-lobby//29F Code 60Charlie                       04- Assault                   Towne Center Bv/S Polk St                                   PINR3     Map - 405405/J7 10262012-030 [13]\r\n
10252012-341     Received:  18:34    Assigned:  18:34    Enroute:   18:38    Arrived:   18:41    Pt Contact:         Cancelled: 19:13       INC # - 10252012-117278 [12]\r\n
12900 Meadow Creek Ln         308                                     Charlie                       26- Sick person               Dead End/S Lancaster Hy                                     PINR1     Map - 405405/H8 10252012-341 [11]\r\n
10252012-238     Received:  14:07    Assigned:  14:07    Enroute:   14:12    Arrived:   14:12    Pt Contact:         Cancelled: 14:18       INC # - 10252012-117180 [10]\r\n
8422 Hollow Glen Pl           g         MEDICAL ALARM                 Charlie                       32- Unknown problem (man down)Dead End/Kettering Dr                                       PINR1     Map - 406406/B6 10252012-238 [09]\r\n
10252012-204     Received:  13:35    Assigned:  13:36    Enroute:   13:37    Arrived:   13:40    Pt Contact:         Cancelled: 13:47       INC # - 10252012-117157 [08]\r\n
320 Main St                             Bookstore in Moore/           Charlie                       28- Stroke/CVA                Johnston Dr/Dover St                                        PINR3     Map - 405405/H7 10252012-204 [07]\r\n
10252012-163     Received:  12:20    Assigned:  12:20    Enroute:   12:22    Arrived:   12:29    Pt Contact:         Cancelled: 12:32       INC # - 10252012-117126 [06]\r\n
13150 Dorman Rd                         The Haven/                    Fire -  Emergency             52F-Alarm-FIRE                Pineturn Ln/Dead End                                        PINF1     Map - 405405/J1010252012-163 [05]\r\n
10242012-449     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:   21:45    Pt Contact:         Cancelled: 21:55       INC # - 10242012-116945 [04]\r\n
13180 Dorman Rd               D 108     THE LAU                       Charlie                       30- Traumatic injuries,specifcCarolina Blossom Ln/Dead End                                PINR3     Map - 405405/J1010242012-449 [03]\r\n
10242012-407     Received:  19:34    Assigned:  19:34    Enroute:   19:37    Arrived:   19:40    Pt Contact:         Cancelled: 19:50       INC # - 10242012-116910 [02]\r\n
601 N Polk St                           Sky High Sports, 27yom,       Bravo-BLS COLD                30BC-Traumatic injuries,spec  Morrow Av/Commerce Dr                                       PINR3     Map - 405405/J6 10242012-407 [01]\r\n
10242012-258     Received:  14:33    Assigned:  14:33    Enroute:   14:35    Arrived:   14:38    Pt Contact:         Cancelled: 15:12       INC # - 10242012-116780 [99]\r\n
13180 Dorman Rd               A211      the Laurels                   Charlie                       17- Falls/Back injury(traumtc)Carolina Blossom Ln/Dead End                                PINR1     Map - 405405/J1010242012-258 [98]\r\n
10242012-198     Received:  12:23    Assigned:  12:23    Enroute:   12:24    Arrived:   12:29    Pt Contact:         Cancelled: 12:37       INC # - 10242012-116722 [97]\r\n
12920 Dorman Rd               ACTIVITY  Dorchester,                   Charlie                       31- Unconsciousness/Fainting  Pineturn Ln/Dead End                                        PINR4     Map - 405405/J1010242012-198 [96]\r\n
10242012-160     Received:  11:03    Assigned:  11:03    Enroute:   11:05    Arrived:   11:09    Pt Contact:         Cancelled: 11:27       INC # - 10242012-116682 [95]\r\n
12632 Sabal Park Dr           207                                     Charlie                       28- Stroke/CVA                Sam Meeks Rd/Sam Meeks Rd                                   PINR4     Map - 405405/J9 10242012-160 [94]\r\n
10232012-443     Received:  23:17    Assigned:  23:17    Enroute:   23:21    Arrived:   23:24    Pt Contact:         Cancelled: 23:40       INC # - 10232012-116528 [93]\r\n
9421 Pineville-matthews Rd              olive garden                  Fire -  Emergency             52F-Alarm-FIRE                I-485 Ramp/Centrum Py                                       PINF2     Map - 405405/K7 10232012-443 [92]\r\n
10232012-436     Received:  22:53    Assigned:  22:53    Enroute:   22:55    Arrived:   22:58    Pt Contact:23:00    Cancelled: 23:03       INC # - 10232012-116523 [91]\r\n
12920 Dorman Rd               LOBBY     Dorchester                    Charlie                       01- Abdominal Pain            Pineturn Ln/Dead End                                        PINR1     Map - 405405/J1010232012-436 [90]\r\n
10232012-424     Received:  21:57    Assigned:  21:57    Enroute:   21:58    Arrived:   22:01    Pt Contact:         Cancelled: 22:22       INC # - 10232012-116513 [89]\r\n
12640 Sabal Park Dr           304                                     Charlie                       19- Heart problems            Sam Meeks Rd/Sam Meeks Rd                                   PINR3     Map - 405405/J9 10232012-424 [88]\r\n
10232012-414     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:            Pt Contact:         Cancelled: 21:41       INC # - 10232012-116505 [86]\r\n
10232012-413     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:            Pt Contact:         Cancelled: 21:41       INC # - 10232012-116505 [87]\r\n
10232012-405     Received:  21:21    Assigned:  21:21    Enroute:   21:25    Arrived:   21:34    Pt Contact:         Cancelled: 21:40       INC # - 10232012-116498 [85]\r\n
12640-12641 Sabal Park Dr               phase 2 plot 9-1-1 hang up unkFire - Routine                911 Hang Up                   Sam Meeks Rd/Sam Meeks Rd                                   PINF1     Map - 405405/J9 10232012-414 [83]\r\n
W I-485 Inner Hy                        shp on scene w/ red dodge, pt Charlie                       05- Back pain (non-traumatic) I-485 Ramp/I-485 Ramp                                       PINR3     Map - 405405/K5 10232012-405 [82]\r\n
10232012-289     Received:  16:10    Assigned:  16:10    Enroute:   16:11    Arrived:   16:15    Pt Contact:         Cancelled: 16:16       INC # - 10232012-116389 [81]\r\n
10232012-282     Received:  15:55    Assigned:  15:55    Enroute:   15:56    Arrived:   16:01    Pt Contact:         Cancelled: 16:12       INC # - 10232012-116383 [80]\r\n
10628 Park Rd                           CMC - Pineville Hospital      Charlie                       17- Falls/Back injury(traumtc)Willow Ridge Rd/PINEVILLE-MATTHEWS RD                       PINR3     Map - 406406/A6 10232012-289 [79]\r\n
12415 Hampton Row Dr                                                  Delta                         10- Chest Pain                Old Compton Ct/Bishops Gate Bv                              PINR4     Map - 405405/H1010232012-282 [78]\r\n
10232012-134     Received:  10:18    Assigned:  10:18    Enroute:   10:20    Arrived:   10:23    Pt Contact:         Cancelled: 10:35       INC # - 10232012-116248 [77]\r\n
10650 Park Rd                           OUTSIDE ORTHO CAROLINA        Charlie                       17- Falls/Back injury(traumtc)Willow Ridge Rd/PINEVILLE-MATTHEWS RD                       PINR4     Map - 406406/A6 10232012-134 [76]\r\n
10232012-050     Received:  05:16    Assigned:  05:17    Enroute:   05:20    Arrived:   05:29    Pt Contact:05:29    Cancelled: 05:52       INC # - 10232012-116174 [75]\r\n
12930 Dorman Rd               361       Dorchester # 361//            Charlie                       26- Sick person               Pineturn Ln/Bishops Gate Bv                                 PINR1     Map - 405405/J1010232012-050 [74]\r\n
10232012-004     Received:  00:23    Assigned:  00:23    Enroute:   00:26    Arrived:   00:28    Pt Contact:         Cancelled: 00:34       INC # - 10232012-116131 [73]\r\n
1010 Lakeview Dr                        64B   COMPLEX - 92 yof  askingCharlie                       32- Unknown problem (man down)Eden Cr/Boatright Rd                                        PINR3     Map - 405405/G8 10232012-004 [72]\r\n
10222012-372     Received:  20:15    Assigned:  20:16    Enroute:   20:19    Arrived:   20:20    Pt Contact:         Cancelled: 20:28       INC # - 10222012-116070 [71]\r\n
10628 Park Rd                           CMC - Pineville Hospital      Bravo                         42- Fire/Police support       Willow Ridge Rd/PINEVILLE-MATTHEWS RD                       PINR4     Map - 406406/A6 10222012-372 [70]\r\n

*/

public class NCMecklenburgCountyAParserTest extends BaseParserTest {
  
  public NCMecklenburgCountyAParserTest() {
    setParser(new NCMecklenburgCountyAParser(), "MECKLENBURG COUNTY", "NC");
  }
  
  @Test
  public void testCancelRunReport() {

    doTest("T1",
        "(Cad email) 06282013-407     Received:  19:47    Assigned:  19:47    Enroute:            Arrived:            Pt Contact:         Cancelled: 20:08       INC # - 06282013-071037\r\n",
        "CALL:RUN REPORT",
        "PLACE:06282013-407     Received:  19:47    Assigned:  19:47    Enroute:            Arrived:            Pt Contact:         Cancelled: 20:08       INC # - 06282013-071037");

    doTest("T2",
        "(Cad email) 06212013-055     Received:  05:12    Assigned:  05:12    Enroute:            Arrived:            Pt Contact:         Cancelled: 05:39       INC # - 06212013-067798\r\n",
        "CALL:RUN REPORT",
        "PLACE:06212013-055     Received:  05:12    Assigned:  05:12    Enroute:            Arrived:            Pt Contact:         Cancelled: 05:39       INC # - 06212013-067798");

    doTest("T3",
        "(Cad email) 06212013-055     Received:  05:12    Assigned:  05:12    Enroute:            Arrived:            Pt Contact:         Cancelled: 05:39       INC # - 06212013-067798\r\n",
        "CALL:RUN REPORT",
        "PLACE:06212013-055     Received:  05:12    Assigned:  05:12    Enroute:            Arrived:            Pt Contact:         Cancelled: 05:39       INC # - 06212013-067798");
   
  }
  
  @Test
  public void testNewRunReport() {

    doTest("T1",
        "(CAD email) 07192013-448     Received:22:28Assigned:22:28Enroute:     Arrived:     Pt Contact:     Cancelled:22:40INC # -07192013-079438",
        "CALL:RUN REPORT",
        "PLACE:07192013-448     Received:22:28Assigned:22:28Enroute:     Arrived:     Pt Contact:     Cancelled:22:40INC # -07192013-079438");

    doTest("T2",
        "(CAD email) 07192013-239     Received:13:50Assigned:13:50Enroute:13:52Arrived:14:00Pt Contact:     Cancelled:14:06INC # -07192013-079245",
        "CALL:RUN REPORT",
        "PLACE:07192013-239     Received:13:50Assigned:13:50Enroute:13:52Arrived:14:00Pt Contact:     Cancelled:14:06INC # -07192013-079245");

    doTest("T3",
        "(CAD email) 07192013-241     Received:13:50Assigned:13:50Enroute:13:52Arrived:14:00Pt Contact:     Cancelled:14:06INC # -07192013-079245",
        "CALL:RUN REPORT",
        "PLACE:07192013-241     Received:13:50Assigned:13:50Enroute:13:52Arrived:14:00Pt Contact:     Cancelled:14:06INC # -07192013-079245");

    doTest("T4",
        "(CAD email) 07182013-508     Received:22:16Assigned:22:16Enroute:     Arrived:22:23Pt Contact:22:24Cancelled:23:07INC # -07182013-079018",
        "CALL:RUN REPORT",
        "PLACE:07182013-508     Received:22:16Assigned:22:16Enroute:     Arrived:22:23Pt Contact:22:24Cancelled:23:07INC # -07182013-079018");

    doTest("T5",
        "(CAD email) 07182013-116     Received:09:33Assigned:09:33Enroute:09:34Arrived:     Pt Contact:     Cancelled:09:37INC # -07182013-078692",
        "CALL:RUN REPORT",
        "PLACE:07182013-116     Received:09:33Assigned:09:33Enroute:09:34Arrived:     Pt Contact:     Cancelled:09:37INC # -07182013-078692");

    doTest("T6",
        "(CAD email) 07182013-088     Received:08:01Assigned:08:01Enroute:08:02Arrived:08:10Pt Contact:     Cancelled:08:10INC # -07182013-078661",
        "CALL:RUN REPORT",
        "PLACE:07182013-088     Received:08:01Assigned:08:01Enroute:08:02Arrived:08:10Pt Contact:     Cancelled:08:10INC # -07182013-078661");

    doTest("T7",
        "(CAD email) 07172013-197     Received:  13:58    Assigned:  13:58    Enroute:            Arrived:            Pt Contact:         Cancelled: 14:26       INC # - 07172013-078387",
        "CALL:RUN REPORT",
        "PLACE:07172013-197     Received:  13:58    Assigned:  13:58    Enroute:            Arrived:            Pt Contact:         Cancelled: 14:26       INC # - 07172013-078387");
  
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:Text Page\n18758 Silver Quay Dr                                                  Charlie                       17- Falls/Back injur",
        "ADDR:18758 Silver Quay Dr",
        "INFO:Charlie",
        "CODE:17",
        "CALL:Falls/Back injuries");

    doTest("T2",
        "Subject:Text Page\n19485 Old Jetton Rd           ste 100   Lakeside Familty Physicians anDelta                         31- Unconsciousness/",
        "ADDR:19485 Old Jetton Rd",
        "APT:ste 100",
        "PLACE:Lakeside Familty Physicians an",
        "INFO:Delta",
        "CODE:31",
        "CALL:Unconsciousness/Fainting");

    doTest("T3",
        "(Text Page) 16710 Northcross Dr                                                   Fire -  Emergency             59-Fuel Spi",
        "ADDR:16710 Northcross Dr",
        "INFO:Fire -  Emergency",
        "CODE:59",
        "CALL:Fuel Spill");

    doTest("T4",
        "(Text Page) 19180-19209 Coachmans Trace             GLENRIDGE                     Fire -  Emergency             69-Structure Fire             Meadow Crossing L",
        "ADDR:19180-19209 Coachmans Trace",
        "MADDR:19180 Coachmans Trace",
        "PLACE:GLENRIDGE",
        "INFO:Fire -  Emergency",
        "CODE:69",
        "CALL:Structure Fire",
        "X:Meadow Crossing L");

    doTest("T5",
        "Subject:Incoming Message\n16738 Amberside Rd East                 Alexander Chase Condos        Fire -  Emergency             52F-Alarm-FIRE",
        "ADDR:16738 Amberside Rd East",
        "PLACE:Alexander Chase Condos",
        "INFO:Fire -  Emergency",
        "CODE:52F",
        "CALL:Alarm-FIRE");

    doTest("T6",
        "Subject:Incoming Message\n9150 Lawyers Rd                         McDonalds - Mint Hill         Charlie                       06- Breathing Pr",
        "ADDR:9150 Lawyers Rd",
        "PLACE:McDonalds - Mint Hill",
        "INFO:Charlie",
        "CODE:06",
        "CALL:Breathing Problems");

    doTest("T7",
        "Subject:Incoming Message\n10043 Idlewild Rd             126       Willow Grove Retirement       Charlie                       06- Breathing Pr",
        "ADDR:10043 Idlewild Rd",
        "APT:126",
        "PLACE:Willow Grove Retirement",
        "INFO:Charlie",
        "CODE:06",
        "CALL:Breathing Problems");

    doTest("T8",
        "(Incoming Message) 19432 Fridley Ln                        medical alarm .. no pt info ..Charlie                       32- Unknown problem (man down)Denae Lynn",
        "ADDR:19432 Fridley Ln",
        "PLACE:medical alarm .. no pt info ..",
        "INFO:Charlie",
        "CODE:32",
        "CALL:Unknown problem (man down)",
        "X:Denae Lynn");

    doTest("T9",
        "9120 Willow Ridge Rd          307A      Regency Retirement            Charlie                       26- Sick person               Goodsell",
        "ADDR:9120 Willow Ridge Rd",
        "APT:307A",
        "PLACE:Regency Retirement",
        "INFO:Charlie",
        "CODE:26",
        "CALL:Sick person",
        "X:Goodsell");

    doTest("T10",
        "12463 Stratfield Place Cr               CAROLINA CROSSING SUBD        Delta                         31- Unconsciousness/Fainting  Stineway Ct/Sam Meeks Rd                                    PINR3     Map - 405405/J9 07302011-086",
        "ADDR:12463 Stratfield Place Cr",
        "MADDR:12463 Stratfield Place Cir",
        "PLACE:CAROLINA CROSSING SUBD",
        "INFO:Delta",
        "CODE:31",
        "CALL:Unconsciousness/Fainting",
        "X:Stineway Ct/Sam Meeks Rd",
        "CH:PINR3",
        "MAP:405405/J9",
        "ID:07302011-086");

    doTest("T10",
        "1010 Lakeview Dr              30-B      Pvl Rehab & Living Ctr  *SNF* Charlie                       06- Breathing Problems        Eden Cr/B",
        "ADDR:1010 Lakeview Dr",
        "APT:30-B",
        "PLACE:Pvl Rehab & Living Ctr  *SNF*",
        "INFO:Charlie",
        "CODE:06",
        "CALL:Breathing Problems",
        "X:Eden Cr/B");
  }
  
  @Test
  public void parserTest2() {

    doTest("T1",
        "(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F",
        "ADDR:16902 Harbor Master Cove",
        "INFO:Fire -  Emergency",
        "CODE:52F",
        "CALL:Alarm-FIRE");

    doTest("T2",
        "(Incoming Message) 13000-blk Hidcote Ct                    BURNING BRUSH                 Fire -  Emergency             67-",
        "ADDR:13000-blk Hidcote Ct",
        "MADDR:13000 Hidcote Ct",
        "PLACE:BURNING BRUSH",
        "CALL:Fire -  Emergency",
        "CODE:67");

    doTest("T3",
        "(Incoming Message) 16902 Harbor Master Cove                                              Fire -  Emergency             52F",
        "ADDR:16902 Harbor Master Cove",
        "INFO:Fire -  Emergency",
        "CODE:52F",
        "CALL:Alarm-FIRE");

    doTest("T4",
        "(Incoming Message) 14341 Salem Ridge Rd                    residential fire alarm        Fire -  Emergency             52F",
        "ADDR:14341 Salem Ridge Rd",
        "PLACE:residential fire alarm",
        "INFO:Fire -  Emergency",
        "CODE:52F",
        "CALL:Alarm-FIRE");

    doTest("T5",
        "(Incoming Message) 12019 Verhoeff Dr                       Huntersville Oaks Nursing *SNFFire -  Emergency             52F",
        "ADDR:12019 Verhoeff Dr",
        "PLACE:Huntersville Oaks Nursing *SNF",
        "INFO:Fire -  Emergency",
        "CODE:52F",
        "CALL:Alarm-FIRE");

    doTest("T6",
        "(Incoming Message) Beatties Ford Rd & Mcilwaine R          TREE DOWN BLOCKING ONE LANE   Fire -  Emergency             53-",
        "ADDR:Beatties Ford Rd & Mcilwaine R",
        "PLACE:TREE DOWN BLOCKING ONE LANE",
        "CALL:Fire -  Emergency",
        "CODE:53");

  }
  
  @Test
  public void testMarkScheible() {

    doTest("1",
        "(Incoming Message) 12903 Thistlebrook Ln                                                 Bravo-BLS COLD",
        "ADDR:12903 Thistlebrook Ln",
        "CALL:Bravo-BLS COLD");

    doTest("2",
        "(Incoming Message) 11530 Beatties Ford Rd        MAIN ENTR Hopewell High School AED      Charlie       ",
        "ADDR:11530 Beatties Ford Rd",
        "APT:MAIN ENTR",
        "PLACE:Hopewell High School AED",
        "CALL:Charlie");
    
  }
  
  @Test
  public void testPinevilleFire() {

    doTest("T1",
        "10262012-151     Received:  10:24    Assigned:  10:24    Enroute:   10:26    Arrived:   10:27    Pt Contact:         Cancelled: 10:56       INC # - 10262012-117497 [20]\r\n",
        "PLACE:10262012-151     Received:  10:24    Assigned:  10:24    Enroute:   10:26    Arrived:   10:27    Pt Contact:         Cancelled: 10:56       INC # - 10262012-117497 [20]",
        "CALL:RUN REPORT");

    doTest("T2",
        "10262012-159     Received:  10:35    Assigned:  10:35    Enroute:   10:37    Arrived:   10:39    Pt Contact:         Cancelled: 10:46       INC # - 10262012-117503 [19]\r\n",
        "PLACE:10262012-159     Received:  10:35    Assigned:  10:35    Enroute:   10:37    Arrived:   10:39    Pt Contact:         Cancelled: 10:46       INC # - 10262012-117503 [19]",
        "CALL:RUN REPORT");

    doTest("T3",
        "9705 Leitner Dr               laundry rmfour points                   Delta                         31- Unconsciousness/Fainting  Centrum Py/Pineville-Matthews Rd                            PINR4     Map - 405405/K6 10262012-159 [18]\r\n",
        "ADDR:9705 Leitner Dr",
        "APT:laundry rm",
        "PLACE:four points",
        "INFO:Delta",
        "CODE:31",
        "CALL:Unconsciousness/Fainting",
        "X:Centrum Py/Pineville-Matthews Rd",
        "CH:PINR4",
        "MAP:405405/K6",
        "ID:10262012-159 [18]");

    doTest("T4",
        "9120 Willow Ridge Rd          313       Regency Retirement            Bravo-BLS COLD                26BC-Sick person              Goodsell Ct/WILLOW BEND CR                                  PINR3     Map - 406406/A5 10262012-151 [17]\r\n",
        "ADDR:9120 Willow Ridge Rd",
        "APT:313",
        "PLACE:Regency Retirement",
        "INFO:Bravo-BLS COLD",
        "CODE:26BC",
        "CALL:Sick person",
        "X:Goodsell Ct/WILLOW BEND CR",
        "CH:PINR3",
        "MAP:406406/A5",
        "ID:10262012-151 [17]");

    doTest("T5",
        "10262012-138     Received:  09:59    Assigned:  10:04    Enroute:   10:04    Arrived:   10:08    Pt Contact:         Cancelled: 10:18       INC # - 10262012-117482 [16]\r\n",
        "PLACE:10262012-138     Received:  09:59    Assigned:  10:04    Enroute:   10:04    Arrived:   10:08    Pt Contact:         Cancelled: 10:18       INC # - 10262012-117482 [16]",
        "CALL:RUN REPORT");

    doTest("T6",
        "Pineville-matthews Rd & Blue H                                        Delta                         29e Traffic accident/Entrapmnt                                                            PINF2     Map - 406406/B6 10262012-138 [15]\r\n",
        "ADDR:Pineville-matthews Rd & Blue H",
        "INFO:Delta",
        "CALL:29e Traffic accident/Entrapmnt",
        "CH:PINF2",
        "MAP:406406/B6",
        "ID:10262012-138 [15]");

    doTest("T7",
        "10262012-030     Received:  02:21    Assigned:  02:21    Enroute:   02:24    Arrived:   02:27    Pt Contact:         Cancelled: 02:49       INC # - 10262012-117393 [14]\r\n",
        "PLACE:10262012-030     Received:  02:21    Assigned:  02:21    Enroute:   02:24    Arrived:   02:27    Pt Contact:         Cancelled: 02:49       INC # - 10262012-117393 [14]",
        "CALL:RUN REPORT");

    doTest("T8",
        "401 Towne Centre Bv                     Hampton Inn-lobby//29F Code 60Charlie                       04- Assault                   Towne Center Bv/S Polk St                                   PINR3     Map - 405405/J7 10262012-030 [13]\r\n",
        "ADDR:401 Towne Centre Bv",
        "PLACE:Hampton Inn-lobby//29F Code 60",
        "INFO:Charlie",
        "CODE:04",
        "CALL:Assault",
        "X:Towne Center Bv/S Polk St",
        "CH:PINR3",
        "MAP:405405/J7",
        "ID:10262012-030 [13]");

    doTest("T9",
        "10252012-341     Received:  18:34    Assigned:  18:34    Enroute:   18:38    Arrived:   18:41    Pt Contact:         Cancelled: 19:13       INC # - 10252012-117278 [12]\r\n",
        "PLACE:10252012-341     Received:  18:34    Assigned:  18:34    Enroute:   18:38    Arrived:   18:41    Pt Contact:         Cancelled: 19:13       INC # - 10252012-117278 [12]",
        "CALL:RUN REPORT");

    doTest("T10",
        "12900 Meadow Creek Ln         308                                     Charlie                       26- Sick person               Dead End/S Lancaster Hy                                     PINR1     Map - 405405/H8 10252012-341 [11]\r\n",
        "ADDR:12900 Meadow Creek Ln",
        "APT:308",
        "INFO:Charlie",
        "CODE:26",
        "CALL:Sick person",
        "X:Dead End/S Lancaster Hy",
        "CH:PINR1",
        "MAP:405405/H8",
        "ID:10252012-341 [11]");

    doTest("T11",
        "10252012-238     Received:  14:07    Assigned:  14:07    Enroute:   14:12    Arrived:   14:12    Pt Contact:         Cancelled: 14:18       INC # - 10252012-117180 [10]\r\n",
        "PLACE:10252012-238     Received:  14:07    Assigned:  14:07    Enroute:   14:12    Arrived:   14:12    Pt Contact:         Cancelled: 14:18       INC # - 10252012-117180 [10]",
        "CALL:RUN REPORT");

    doTest("T12",
        "8422 Hollow Glen Pl           g         MEDICAL ALARM                 Charlie                       32- Unknown problem (man down)Dead End/Kettering Dr                                       PINR1     Map - 406406/B6 10252012-238 [09]\r\n",
        "ADDR:8422 Hollow Glen Pl",
        "APT:g",
        "PLACE:MEDICAL ALARM",
        "INFO:Charlie",
        "CODE:32",
        "CALL:Unknown problem (man down)",
        "X:Dead End/Kettering Dr",
        "CH:PINR1",
        "MAP:406406/B6",
        "ID:10252012-238 [09]");

    doTest("T13",
        "10252012-204     Received:  13:35    Assigned:  13:36    Enroute:   13:37    Arrived:   13:40    Pt Contact:         Cancelled: 13:47       INC # - 10252012-117157 [08]\r\n",
        "PLACE:10252012-204     Received:  13:35    Assigned:  13:36    Enroute:   13:37    Arrived:   13:40    Pt Contact:         Cancelled: 13:47       INC # - 10252012-117157 [08]",
        "CALL:RUN REPORT");

    doTest("T14",
        "320 Main St                             Bookstore in Moore/           Charlie                       28- Stroke/CVA                Johnston Dr/Dover St                                        PINR3     Map - 405405/H7 10252012-204 [07]\r\n",
        "ADDR:320 Main St",
        "PLACE:Bookstore in Moore/",
        "INFO:Charlie",
        "CODE:28",
        "CALL:Stroke/CVA",
        "X:Johnston Dr/Dover St",
        "CH:PINR3",
        "MAP:405405/H7",
        "ID:10252012-204 [07]");

    doTest("T15",
        "10252012-163     Received:  12:20    Assigned:  12:20    Enroute:   12:22    Arrived:   12:29    Pt Contact:         Cancelled: 12:32       INC # - 10252012-117126 [06]\r\n",
        "PLACE:10252012-163     Received:  12:20    Assigned:  12:20    Enroute:   12:22    Arrived:   12:29    Pt Contact:         Cancelled: 12:32       INC # - 10252012-117126 [06]",
        "CALL:RUN REPORT");

    doTest("T16",
        "13150 Dorman Rd                         The Haven/                    Fire -  Emergency             52F-Alarm-FIRE                Pineturn Ln/Dead End                                        PINF1     Map - 405405/J1010252012-163 [05]\r\n",
        "ADDR:13150 Dorman Rd",
        "PLACE:The Haven/",
        "INFO:Fire -  Emergency",
        "CODE:52F",
        "CALL:Alarm-FIRE",
        "X:Pineturn Ln/Dead End",
        "CH:PINF1",
        "MAP:405405/J10",
        "ID:10252012-163 [05]");

    doTest("T17",
        "10242012-449     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:   21:45    Pt Contact:         Cancelled: 21:55       INC # - 10242012-116945 [04]\r\n",
        "PLACE:10242012-449     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:   21:45    Pt Contact:         Cancelled: 21:55       INC # - 10242012-116945 [04]",
        "CALL:RUN REPORT");

    doTest("T18",
        "13180 Dorman Rd               D 108     THE LAU                       Charlie                       30- Traumatic injuries,specifcCarolina Blossom Ln/Dead End                                PINR3     Map - 405405/J1010242012-449 [03]\r\n",
        "ADDR:13180 Dorman Rd",
        "APT:D 108",
        "PLACE:THE LAU",
        "INFO:Charlie",
        "CODE:30",
        "CALL:Traumatic injuries,specifc",
        "X:Carolina Blossom Ln/Dead End",
        "CH:PINR3",
        "MAP:405405/J10",
        "ID:10242012-449 [03]");

    doTest("T19",
        "10242012-407     Received:  19:34    Assigned:  19:34    Enroute:   19:37    Arrived:   19:40    Pt Contact:         Cancelled: 19:50       INC # - 10242012-116910 [02]\r\n",
        "PLACE:10242012-407     Received:  19:34    Assigned:  19:34    Enroute:   19:37    Arrived:   19:40    Pt Contact:         Cancelled: 19:50       INC # - 10242012-116910 [02]",
        "CALL:RUN REPORT");

    doTest("T20",
        "601 N Polk St                           Sky High Sports, 27yom,       Bravo-BLS COLD                30BC-Traumatic injuries,spec  Morrow Av/Commerce Dr                                       PINR3     Map - 405405/J6 10242012-407 [01]\r\n",
        "ADDR:601 N Polk St",
        "PLACE:Sky High Sports, 27yom,",
        "INFO:Bravo-BLS COLD",
        "CODE:30BC",
        "CALL:Traumatic injuries,spec",
        "X:Morrow Av/Commerce Dr",
        "CH:PINR3",
        "MAP:405405/J6",
        "ID:10242012-407 [01]");

    doTest("T21",
        "10242012-258     Received:  14:33    Assigned:  14:33    Enroute:   14:35    Arrived:   14:38    Pt Contact:         Cancelled: 15:12       INC # - 10242012-116780 [99]\r\n",
        "PLACE:10242012-258     Received:  14:33    Assigned:  14:33    Enroute:   14:35    Arrived:   14:38    Pt Contact:         Cancelled: 15:12       INC # - 10242012-116780 [99]",
        "CALL:RUN REPORT");

    doTest("T22",
        "13180 Dorman Rd               A211      the Laurels                   Charlie                       17- Falls/Back injury(traumtc)Carolina Blossom Ln/Dead End                                PINR1     Map - 405405/J1010242012-258 [98]\r\n",
        "ADDR:13180 Dorman Rd",
        "APT:A211",
        "PLACE:the Laurels",
        "INFO:Charlie",
        "CODE:17",
        "CALL:Falls/Back injury(traumtc)",
        "X:Carolina Blossom Ln/Dead End",
        "CH:PINR1",
        "MAP:405405/J10",
        "ID:10242012-258 [98]");

    doTest("T23",
        "10242012-198     Received:  12:23    Assigned:  12:23    Enroute:   12:24    Arrived:   12:29    Pt Contact:         Cancelled: 12:37       INC # - 10242012-116722 [97]\r\n",
        "PLACE:10242012-198     Received:  12:23    Assigned:  12:23    Enroute:   12:24    Arrived:   12:29    Pt Contact:         Cancelled: 12:37       INC # - 10242012-116722 [97]",
        "CALL:RUN REPORT");

    doTest("T24",
        "12920 Dorman Rd               ACTIVITY  Dorchester,                   Charlie                       31- Unconsciousness/Fainting  Pineturn Ln/Dead End                                        PINR4     Map - 405405/J1010242012-198 [96]\r\n",
        "ADDR:12920 Dorman Rd",
        "APT:ACTIVITY",
        "PLACE:Dorchester,",
        "INFO:Charlie",
        "CODE:31",
        "CALL:Unconsciousness/Fainting",
        "X:Pineturn Ln/Dead End",
        "CH:PINR4",
        "MAP:405405/J10",
        "ID:10242012-198 [96]");

    doTest("T25",
        "10242012-160     Received:  11:03    Assigned:  11:03    Enroute:   11:05    Arrived:   11:09    Pt Contact:         Cancelled: 11:27       INC # - 10242012-116682 [95]\r\n",
        "PLACE:10242012-160     Received:  11:03    Assigned:  11:03    Enroute:   11:05    Arrived:   11:09    Pt Contact:         Cancelled: 11:27       INC # - 10242012-116682 [95]",
        "CALL:RUN REPORT");

    doTest("T26",
        "12632 Sabal Park Dr           207                                     Charlie                       28- Stroke/CVA                Sam Meeks Rd/Sam Meeks Rd                                   PINR4     Map - 405405/J9 10242012-160 [94]\r\n",
        "ADDR:12632 Sabal Park Dr",
        "APT:207",
        "INFO:Charlie",
        "CODE:28",
        "CALL:Stroke/CVA",
        "X:Sam Meeks Rd/Sam Meeks Rd",
        "CH:PINR4",
        "MAP:405405/J9",
        "ID:10242012-160 [94]");

    doTest("T27",
        "10232012-443     Received:  23:17    Assigned:  23:17    Enroute:   23:21    Arrived:   23:24    Pt Contact:         Cancelled: 23:40       INC # - 10232012-116528 [93]\r\n",
        "PLACE:10232012-443     Received:  23:17    Assigned:  23:17    Enroute:   23:21    Arrived:   23:24    Pt Contact:         Cancelled: 23:40       INC # - 10232012-116528 [93]",
        "CALL:RUN REPORT");

    doTest("T28",
        "9421 Pineville-matthews Rd              olive garden                  Fire -  Emergency             52F-Alarm-FIRE                I-485 Ramp/Centrum Py                                       PINF2     Map - 405405/K7 10232012-443 [92]\r\n",
        "ADDR:9421 Pineville-matthews Rd",
        "PLACE:olive garden",
        "INFO:Fire -  Emergency",
        "CODE:52F",
        "CALL:Alarm-FIRE",
        "X:I-485 Ramp/Centrum Py",
        "CH:PINF2",
        "MAP:405405/K7",
        "ID:10232012-443 [92]");

    doTest("T29",
        "10232012-436     Received:  22:53    Assigned:  22:53    Enroute:   22:55    Arrived:   22:58    Pt Contact:23:00    Cancelled: 23:03       INC # - 10232012-116523 [91]\r\n",
        "PLACE:10232012-436     Received:  22:53    Assigned:  22:53    Enroute:   22:55    Arrived:   22:58    Pt Contact:23:00    Cancelled: 23:03       INC # - 10232012-116523 [91]",
        "CALL:RUN REPORT");

    doTest("T30",
        "12920 Dorman Rd               LOBBY     Dorchester                    Charlie                       01- Abdominal Pain            Pineturn Ln/Dead End                                        PINR1     Map - 405405/J1010232012-436 [90]\r\n",
        "ADDR:12920 Dorman Rd",
        "APT:LOBBY",
        "PLACE:Dorchester",
        "INFO:Charlie",
        "CODE:01",
        "CALL:Abdominal Pain",
        "X:Pineturn Ln/Dead End",
        "CH:PINR1",
        "MAP:405405/J10",
        "ID:10232012-436 [90]");

    doTest("T31",
        "10232012-424     Received:  21:57    Assigned:  21:57    Enroute:   21:58    Arrived:   22:01    Pt Contact:         Cancelled: 22:22       INC # - 10232012-116513 [89]\r\n",
        "PLACE:10232012-424     Received:  21:57    Assigned:  21:57    Enroute:   21:58    Arrived:   22:01    Pt Contact:         Cancelled: 22:22       INC # - 10232012-116513 [89]",
        "CALL:RUN REPORT");

    doTest("T32",
        "12640 Sabal Park Dr           304                                     Charlie                       19- Heart problems            Sam Meeks Rd/Sam Meeks Rd                                   PINR3     Map - 405405/J9 10232012-424 [88]\r\n",
        "ADDR:12640 Sabal Park Dr",
        "APT:304",
        "INFO:Charlie",
        "CODE:19",
        "CALL:Heart problems",
        "X:Sam Meeks Rd/Sam Meeks Rd",
        "CH:PINR3",
        "MAP:405405/J9",
        "ID:10232012-424 [88]");

    doTest("T33",
        "10232012-414     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:            Pt Contact:         Cancelled: 21:41       INC # - 10232012-116505 [86]\r\n",
        "PLACE:10232012-414     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:            Pt Contact:         Cancelled: 21:41       INC # - 10232012-116505 [86]",
        "CALL:RUN REPORT");

    doTest("T34",
        "10232012-413     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:            Pt Contact:         Cancelled: 21:41       INC # - 10232012-116505 [87]\r\n",
        "PLACE:10232012-413     Received:  21:39    Assigned:  21:39    Enroute:   21:41    Arrived:            Pt Contact:         Cancelled: 21:41       INC # - 10232012-116505 [87]",
        "CALL:RUN REPORT");

    doTest("T35",
        "10232012-405     Received:  21:21    Assigned:  21:21    Enroute:   21:25    Arrived:   21:34    Pt Contact:         Cancelled: 21:40       INC # - 10232012-116498 [85]\r\n",
        "PLACE:10232012-405     Received:  21:21    Assigned:  21:21    Enroute:   21:25    Arrived:   21:34    Pt Contact:         Cancelled: 21:40       INC # - 10232012-116498 [85]",
        "CALL:RUN REPORT");

    doTest("T36",
        "12640-12641 Sabal Park Dr               phase 2 plot 9-1-1 hang up unkFire - Routine                911 Hang Up                   Sam Meeks Rd/Sam Meeks Rd                                   PINF1     Map - 405405/J9 10232012-414 [83]\r\n",
        "ADDR:12640-12641 Sabal Park Dr",
        "MADDR:12640 Sabal Park Dr",
        "PLACE:phase 2 plot 9-1-1 hang up unk",
        "INFO:Fire - Routine",
        "CALL:911 Hang Up",
        "X:Sam Meeks Rd/Sam Meeks Rd",
        "CH:PINF1",
        "MAP:405405/J9",
        "ID:10232012-414 [83]");

    doTest("T37",
        "W I-485 Inner Hy                        shp on scene w/ red dodge, pt Charlie                       05- Back pain (non-traumatic) I-485 Ramp/I-485 Ramp                                       PINR3     Map - 405405/K5 10232012-405 [82]\r\n",
        "ADDR:W I-485 Inner Hy",
        "MADDR:W I 485 Inner Hwy & I 485 Ramp",
        "PLACE:shp on scene w/ red dodge, pt",
        "INFO:Charlie",
        "CODE:05",
        "CALL:Back pain (non-traumatic)",
        "X:I-485 Ramp/I-485 Ramp",
        "CH:PINR3",
        "MAP:405405/K5",
        "ID:10232012-405 [82]");

    doTest("T38",
        "10232012-289     Received:  16:10    Assigned:  16:10    Enroute:   16:11    Arrived:   16:15    Pt Contact:         Cancelled: 16:16       INC # - 10232012-116389 [81]\r\n",
        "PLACE:10232012-289     Received:  16:10    Assigned:  16:10    Enroute:   16:11    Arrived:   16:15    Pt Contact:         Cancelled: 16:16       INC # - 10232012-116389 [81]",
        "CALL:RUN REPORT");

    doTest("T39",
        "10232012-282     Received:  15:55    Assigned:  15:55    Enroute:   15:56    Arrived:   16:01    Pt Contact:         Cancelled: 16:12       INC # - 10232012-116383 [80]\r\n",
        "PLACE:10232012-282     Received:  15:55    Assigned:  15:55    Enroute:   15:56    Arrived:   16:01    Pt Contact:         Cancelled: 16:12       INC # - 10232012-116383 [80]",
        "CALL:RUN REPORT");

    doTest("T40",
        "10628 Park Rd                           CMC - Pineville Hospital      Charlie                       17- Falls/Back injury(traumtc)Willow Ridge Rd/PINEVILLE-MATTHEWS RD                       PINR3     Map - 406406/A6 10232012-289 [79]\r\n",
        "ADDR:10628 Park Rd",
        "PLACE:CMC - Pineville Hospital",
        "INFO:Charlie",
        "CODE:17",
        "CALL:Falls/Back injury(traumtc)",
        "X:Willow Ridge Rd/PINEVILLE-MATTHEWS RD",
        "CH:PINR3",
        "MAP:406406/A6",
        "ID:10232012-289 [79]");

    doTest("T41",
        "12415 Hampton Row Dr                                                  Delta                         10- Chest Pain                Old Compton Ct/Bishops Gate Bv                              PINR4     Map - 405405/H1010232012-282 [78]\r\n",
        "ADDR:12415 Hampton Row Dr",
        "INFO:Delta",
        "CODE:10",
        "CALL:Chest Pain",
        "X:Old Compton Ct/Bishops Gate Bv",
        "CH:PINR4",
        "MAP:405405/H10",
        "ID:10232012-282 [78]");

    doTest("T42",
        "10232012-134     Received:  10:18    Assigned:  10:18    Enroute:   10:20    Arrived:   10:23    Pt Contact:         Cancelled: 10:35       INC # - 10232012-116248 [77]\r\n",
        "PLACE:10232012-134     Received:  10:18    Assigned:  10:18    Enroute:   10:20    Arrived:   10:23    Pt Contact:         Cancelled: 10:35       INC # - 10232012-116248 [77]",
        "CALL:RUN REPORT");

    doTest("T43",
        "10650 Park Rd                           OUTSIDE ORTHO CAROLINA        Charlie                       17- Falls/Back injury(traumtc)Willow Ridge Rd/PINEVILLE-MATTHEWS RD                       PINR4     Map - 406406/A6 10232012-134 [76]\r\n",
        "ADDR:10650 Park Rd",
        "PLACE:OUTSIDE ORTHO CAROLINA",
        "INFO:Charlie",
        "CODE:17",
        "CALL:Falls/Back injury(traumtc)",
        "X:Willow Ridge Rd/PINEVILLE-MATTHEWS RD",
        "CH:PINR4",
        "MAP:406406/A6",
        "ID:10232012-134 [76]");

    doTest("T44",
        "10232012-050     Received:  05:16    Assigned:  05:17    Enroute:   05:20    Arrived:   05:29    Pt Contact:05:29    Cancelled: 05:52       INC # - 10232012-116174 [75]\r\n",
        "PLACE:10232012-050     Received:  05:16    Assigned:  05:17    Enroute:   05:20    Arrived:   05:29    Pt Contact:05:29    Cancelled: 05:52       INC # - 10232012-116174 [75]",
        "CALL:RUN REPORT");

    doTest("T45",
        "12930 Dorman Rd               361       Dorchester # 361//            Charlie                       26- Sick person               Pineturn Ln/Bishops Gate Bv                                 PINR1     Map - 405405/J1010232012-050 [74]\r\n",
        "ADDR:12930 Dorman Rd",
        "APT:361",
        "PLACE:Dorchester # 361//",
        "INFO:Charlie",
        "CODE:26",
        "CALL:Sick person",
        "X:Pineturn Ln/Bishops Gate Bv",
        "CH:PINR1",
        "MAP:405405/J10",
        "ID:10232012-050 [74]");

    doTest("T46",
        "10232012-004     Received:  00:23    Assigned:  00:23    Enroute:   00:26    Arrived:   00:28    Pt Contact:         Cancelled: 00:34       INC # - 10232012-116131 [73]\r\n",
        "PLACE:10232012-004     Received:  00:23    Assigned:  00:23    Enroute:   00:26    Arrived:   00:28    Pt Contact:         Cancelled: 00:34       INC # - 10232012-116131 [73]",
        "CALL:RUN REPORT");

    doTest("T47",
        "1010 Lakeview Dr                        64B   COMPLEX - 92 yof  askingCharlie                       32- Unknown problem (man down)Eden Cr/Boatright Rd                                        PINR3     Map - 405405/G8 10232012-004 [72]\r\n",
        "ADDR:1010 Lakeview Dr",
        "PLACE:64B   COMPLEX - 92 yof  asking",
        "INFO:Charlie",
        "CODE:32",
        "CALL:Unknown problem (man down)",
        "X:Eden Cr/Boatright Rd",
        "CH:PINR3",
        "MAP:405405/G8",
        "ID:10232012-004 [72]");

    doTest("T48",
        "10222012-372     Received:  20:15    Assigned:  20:16    Enroute:   20:19    Arrived:   20:20    Pt Contact:         Cancelled: 20:28       INC # - 10222012-116070 [71]\r\n",
        "PLACE:10222012-372     Received:  20:15    Assigned:  20:16    Enroute:   20:19    Arrived:   20:20    Pt Contact:         Cancelled: 20:28       INC # - 10222012-116070 [71]",
        "CALL:RUN REPORT");

    doTest("T49",
        "10628 Park Rd                           CMC - Pineville Hospital      Bravo                         42- Fire/Police support       Willow Ridge Rd/PINEVILLE-MATTHEWS RD                       PINR4     Map - 406406/A6 10222012-372 [70]\r\n",
        "ADDR:10628 Park Rd",
        "PLACE:CMC - Pineville Hospital",
        "INFO:Bravo",
        "CODE:42",
        "CALL:Fire/Police support",
        "X:Willow Ridge Rd/PINEVILLE-MATTHEWS RD",
        "CH:PINR4",
        "MAP:406406/A6",
        "ID:10222012-372 [70]");

  }
  

  public static void main(String[] args) {
    new NCMecklenburgCountyAParserTest().generateTests("T1");
  }
}
