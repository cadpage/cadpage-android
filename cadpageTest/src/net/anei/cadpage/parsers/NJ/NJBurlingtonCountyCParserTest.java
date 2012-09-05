package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJBurlingtonCountyCParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyCParserTest() {
    setParser(new NJBurlingtonCountyCParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000242                    ORI: E179          Station:  \n" +
        "Incident Type  . :  129 E AccInjry             Priority: 1  \n" +
        "Incident Location: RT206                                                Venue: Southamptn  \n" +
        "  Cross Street . : BUDDTOWN RD \n\n" +
        "Call Time- 18:55:19                                Date- 03/08/2012  \n" +
        "Dispatch - 18:56:59     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  M16              Quadrant: 1710         District: 1710 \n\n" +
        "Phone Number: (609) 731-1906                Call Source:  911 \n\n" +
        "Caller. . . : ALICE LISTON \n\n" +
        "Units sent  :  \n" +
        " 03171       F1710                03171       F1712  \n" +
        " E178        E1782                E179        E1791 \n\n" +
        "Nature of Call : 2 VEH MVA// ONE FEMALE WITH A HEAD INJURY//NO \n\n" +
        "Additional Info  \n" +
        "  WPH2:  \n" +
        "   OTHER HAZARDS \n\n" +
        "Additional Inc#s:  \n" +
        " E178        201200000257             03171       201200000084 \n\n" +
        "The Call Taker is MCCORMACK KENNETH J  \n" +
        "The Dispatcher is ENDRES ANTHONY G",

        "ID:2012-00000242",
        "CALL:129 E AccInjry",
        "PRI:1",
        "ADDR:RT206",
        "MADDR:RT 206 & BUDDTOWN RD",
        "CITY:Southampton",
        "X:BUDDTOWN RD",
        "TIME:18:55:19",
        "DATE:03/08/2012",
        "MAP:1710/1710/1/1700",
        "PHONE:(609) 731-1906",
        "NAME:ALICE LISTON",
        "UNIT:03171 F1710 03171 F1712 E178 E1782 E179 E1791",
        "INFO:2 VEH MVA// ONE FEMALE WITH A HEAD INJURY//NO");

    doTest("T2",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000242                    ORI: E179          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: RT206                                                Venue: Southamptn  \n" +
        "  Cross Street . : BUDDTOWN RD \n\n" +
        "Call Time- 18:55:19                                Date- 03/08/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  M16              Quadrant: 1710         District: 1710 \n\n" +
        "Phone Number: (609) 731-1906                Call Source:  911 \n\n" +
        "Caller. . . : ALICE LISTON \n\n" +
        "Nature of Call : 2 VEH MVA// INJURIES \n\n" +
        "Additional Info  \n" +
        "  WPH2: \n\n" +
        "Additional Inc#s:  \n" +
        " 03171       201200000084 \n\n" +
        "The Call Taker is MCCORMACK KENNETH J  \n" +
        "The Dispatcher is ENDRES ANTHONY G",

        "ID:2012-00000242",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:RT206",
        "MADDR:RT 206 & BUDDTOWN RD",
        "CITY:Southampton",
        "X:BUDDTOWN RD",
        "TIME:18:55:19",
        "DATE:03/08/2012",
        "MAP:1710/1710/1/1700",
        "PHONE:(609) 731-1906",
        "NAME:ALICE LISTON",
        "INFO:2 VEH MVA// INJURIES");

    doTest("T3",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000083                    ORI: 03171         Station:  \n" +
        "Incident Type  . :   16 F Alarms               Priority: 1  \n" +
        "Incident Location: 511 MEADOWYCK LA                                     Venue: Southamptn  \n" +
        "Located Between  : CHURCH RD/EAYRESTOWN RD \n\n" +
        "Call Time- 12:53:11                                Date- 03/08/2012  \n" +
        "Dispatch - 12:53:24     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  K14              Quadrant: 1700         District: 1700 \n\n" +
        "Phone Number: (718) 494-6414                Call Source:  TEL \n\n" +
        "Caller. . . : STATE WIDE ALARMS  \n" +
        "Complaintant: OP 401 \n\n" +
        "Units sent  :  \n" +
        " 03171       F171                 03171       F1710  \n" +
        " 03172       F172 \n\n" +
        "Nature of Call : CO ALARM / 609-801-1503- \n\n" +
        "Additional Info  \n" +
        "  TWIN OAKS \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s:  \n" +
        " 03172       201200000056 \n\n" +
        "The Call Taker is KINNEY DAVID R  \n" +
        "The Dispatcher is KNOTT VINCENT M",

        "ID:2012-00000083",
        "CALL:16 F Alarms",
        "PRI:1",
        "ADDR:511 MEADOWYCK LA",
        "MADDR:511 MEADOWYCK LN",
        "CITY:Southampton",
        "X:CHURCH RD/EAYRESTOWN RD",
        "TIME:12:53:11",
        "DATE:03/08/2012",
        "MAP:1700/1700/1/1700",
        "PHONE:(718) 494-6414",
        "NAME:STATE WIDE ALARMS Complaintant: OP 401",
        "UNIT:03171 F171 03171 F1710 03172 F172",
        "INFO:CO ALARM / 609-801-1503-");

    doTest("T4",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000238                    ORI: E179          Station:  \n" +
        "Incident Type  . :  117 E Falls                Priority: 1  \n" +
        "Incident Location: 311 RED LION RD                                      Venue: Southamptn  \n" +
        "Located Between  : NEW FREEDOM RD/HILLIARDS BRIDGE RD \n\n" +
        "Call Time- 17:14:29                                Date- 03/07/2012  \n" +
        "Dispatch - 17:20:28     En-route-              On-scene- 17:20:28     Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  L16              Quadrant: 1712         District: 1712 \n\n" +
        "Phone Number: (856) 498-4915                Call Source:  911 \n\n" +
        "Caller. . . : RYAN SUSANNE \n\n" +
        "Units sent  :  \n" +
        " E159        E1593                03171       F171  \n" +
        " 03171       F1710                03171       F1712  \n" +
        " 03172       F172                 E178        E1782  \n" +
        " E179        E179 \n\n" +
        "Nature of Call : 16/F THROWN FROM HORSE BACK AND HEAD PAIN \n\n" +
        "Additional Info  \n" +
        "  WPH1:  RADIUS 01 MILES  \n" +
        "  HX BACK PROBLEM \n\n" +
        "Additional Inc#s:  \n" +
        " E159        201200004136             E178        201200000252  \n" +
        " 03171       201200000082             03172       201200000054 \n\n" +
        "The Call Taker is TAYL0R BONNIE J  \n" +
        "The Dispatcher is JOHNSON THOMAS",

        "ID:2012-00000238",
        "CALL:117 E Falls",
        "PRI:1",
        "ADDR:311 RED LION RD",
        "CITY:Southampton",
        "X:NEW FREEDOM RD/HILLIARDS BRIDGE RD",
        "TIME:17:14:29",
        "DATE:03/07/2012",
        "MAP:1712/1712/1/1700",
        "PHONE:(856) 498-4915",
        "NAME:RYAN SUSANNE",
        "UNIT:E159 E1593 03171 F171 03171 F1710 03171 F1712 03172 F172 E178 E1782 E179 E179",
        "INFO:16/F THROWN FROM HORSE BACK AND HEAD PAIN");

    doTest("T5",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000238                    ORI: E179          Station:  \n" +
        "Incident Type  . :  117 E Falls                Priority: 1  \n" +
        "Incident Location: 311 RED LION RD                                      Venue: Southamptn  \n" +
        "Located Between  : NEW FREEDOM RD/HILLIARDS BRIDGE RD \n\n" +
        "Call Time- 17:14:29                                Date- 03/07/2012  \n" +
        "Dispatch - 17:20:28     En-route-              On-scene- 17:20:28     Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  L16              Quadrant: 1712         District: 1712 \n\n" +
        "Phone Number: (856) 498-4915                Call Source:  911 \n\n" +
        "Caller. . . : RYAN SUSANNE \n\n" +
        "Units sent  :  \n" +
        " E159        E1593                03171       F171  \n" +
        " 03171       F1710                E178        E1782  \n" +
        " E179        E179 \n\n" +
        "Nature of Call : 16/F THROWN FROM HORSE BACK AND HEAD PAIN \n\n" +
        "Additional Info  \n" +
        "  WPH1:  RADIUS 01 MILES  \n" +
        "  HX BACK PROBLEM \n\n" +
        "Additional Inc#s:  \n" +
        " E159        201200004136             E178        201200000252  \n" +
        " 03171       201200000082 \n\n" +
        "The Call Taker is TAYL0R BONNIE J  \n" +
        "The Dispatcher is JOHNSON THOMAS",

        "ID:2012-00000238",
        "CALL:117 E Falls",
        "PRI:1",
        "ADDR:311 RED LION RD",
        "CITY:Southampton",
        "X:NEW FREEDOM RD/HILLIARDS BRIDGE RD",
        "TIME:17:14:29",
        "DATE:03/07/2012",
        "MAP:1712/1712/1/1700",
        "PHONE:(856) 498-4915",
        "NAME:RYAN SUSANNE",
        "UNIT:E159 E1593 03171 F171 03171 F1710 E178 E1782 E179 E179",
        "INFO:16/F THROWN FROM HORSE BACK AND HEAD PAIN");

    doTest("T6",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000234                    ORI: E179          Station:  \n" +
        "Incident Type  . : 129F E Mva/Fire             Priority: 1  \n" +
        "Incident Location: 2063 RT206                                           Venue: Southamptn  \n" +
        "Located Between  : RIDGE RD/RETREAT RD  \n" +
        "Common Name. . . : HAGERTHEY REPAIR SHOP \n\n" +
        "Call Time- 08:42:10                                Date- 03/07/2012  \n" +
        "Dispatch - 08:44:01     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  L16              Quadrant: 1712         District: 1712 \n\n" +
        "Phone Number: (609) 584-5000                Call Source:  TEL \n\n" +
        "Caller. . . : DISP 1614  \n" +
        "Complaintant: NJSP-RED LION \n\n" +
        "Units sent  :  \n" +
        " E179        E179                 03171       F171  \n" +
        " 03172       F172                 E178        E1781  \n" +
        " E179        E1791 \n\n" +
        "Nature of Call : MVA DRIVER WITH HEAD LAC//NJSP ON LOC \n\n" +
        "Additional Info  \n" +
        "  IAO \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s:  \n" +
        " E178        201200000247             03171       201200000081  \n" +
        " 03172       201200000053 \n\n" +
        "The Call Taker is MURRAY SHAKIRA  \n" +
        "The Dispatcher is YERKES WAYNE D",

        "ID:2012-00000234",
        "CALL:129F E Mva/Fire",
        "PRI:1",
        "ADDR:2063 RT206",
        "MADDR:2063 RT 206",
        "CITY:Southampton",
        "X:RIDGE RD/RETREAT RD",
        "PLACE:HAGERTHEY REPAIR SHOP",
        "TIME:08:42:10",
        "DATE:03/07/2012",
        "MAP:1712/1712/1/1700",
        "PHONE:(609) 584-5000",
        "NAME:DISP 1614 Complaintant: NJSP-RED LION",
        "UNIT:E179 E179 03171 F171 03172 F172 E178 E1781 E179 E1791",
        "INFO:MVA DRIVER WITH HEAD LAC//NJSP ON LOC");

    doTest("T7",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000083                    ORI: 03171         Station:  \n" +
        "Incident Type  . : FIRE F Fire Call            Priority: 1  \n" +
        "Incident Location: 511 MEADOWYCK LA                                     Venue: Southamptn  \n" +
        "Located Between  : CHURCH RD/EAYRESTOWN RD \n\n" +
        "Call Time- 12:53:11                                Date- 03/08/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  K14              Quadrant: 1700         District: 1700 \n\n" +
        "Phone Number: (718) 494-6414                Call Source:  TEL \n\n" +
        "Caller. . . : STATE WIDE ALARMS  \n" +
        "Complaintant: OP 401 \n\n" +
        "Nature of Call : CO ALARM / 609-801-1503- \n\n" +
        "Additional Info  \n" +
        "  TWIN OAKS \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is KINNEY DAVID R  \n" +
        "The Dispatcher is KNOTT VINCENT M",

        "ID:2012-00000083",
        "CALL:FIRE F Fire Call",
        "PRI:1",
        "ADDR:511 MEADOWYCK LA",
        "MADDR:511 MEADOWYCK LN",
        "CITY:Southampton",
        "X:CHURCH RD/EAYRESTOWN RD",
        "TIME:12:53:11",
        "DATE:03/08/2012",
        "MAP:1700/1700/1/1700",
        "PHONE:(718) 494-6414",
        "NAME:STATE WIDE ALARMS Complaintant: OP 401",
        "INFO:CO ALARM / 609-801-1503-");

    doTest("T8",
        "S: Automatic R&amp;R Notification\n" +
        "  \n" +
        "Incident Number  : 2012-00000234                    ORI: E179          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 2063 RT206                                           Venue: Southamptn  \n" +
        "Located Between  : RIDGE RD/RETREAT RD  \n" +
        "Common Name. . . : HAGERTHEY REPAIR SHOP \n\n" +
        "Call Time- 08:42:10                                Date- 03/07/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1700              Section :    1         Beat  . : 1790        Map . . :  \n" +
        "Grid:  L16              Quadrant: 1712         District: 1712 \n\n" +
        "Phone Number: (609) 584-5000                Call Source:  TEL \n\n" +
        "Caller. . . : DISP 1614  \n" +
        "Complaintant: NJSP-RED LION \n\n" +
        "Units sent  :  \n" +
        " E179        E179                 E178        E1781  \n" +
        " E179        E1791 \n\n" +
        "Nature of Call : MVA DRIVER WITH HEAD LAC//NJSP ON LOC \n\n" +
        "Additional Info  \n" +
        "  IAO \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s:  \n" +
        " E178        201200000247             03171       201200000081 \n\n" +
        "The Call Taker is MURRAY SHAKIRA  \n" +
        "The Dispatcher is YERKES WAYNE D",

        "ID:2012-00000234",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:2063 RT206",
        "MADDR:2063 RT 206",
        "CITY:Southampton",
        "X:RIDGE RD/RETREAT RD",
        "PLACE:HAGERTHEY REPAIR SHOP",
        "TIME:08:42:10",
        "DATE:03/07/2012",
        "MAP:1712/1712/1/1700",
        "PHONE:(609) 584-5000",
        "NAME:DISP 1614 Complaintant: NJSP-RED LION",
        "UNIT:E179 E179 E178 E1781 E179 E1791",
        "INFO:MVA DRIVER WITH HEAD LAC//NJSP ON LOC");
  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00001892                    ORI: E180          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 6 DONOMA ST                                          Venue: Pembtn Twp  \n" +
        "Located Between  : HANOVER BV/E LAKESHORE DR  \n" +
        "Common Name. . . : ALLIES GROUP HOME 18 \n\n" +
        "Call Time- 12:53:05                                Date- 08/16/2012  \n" +
        "Dispatch - 12:53:15     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1801              Section :   25         Beat  . : 1801        Map . . :  \n" +
        "Grid:                   Quadrant: 1813         District: 1811 \n\n" +
        "Phone Number: (856) 340-3129                Call Source:  TEL \n\n" +
        "Caller. . . : NICHELLE MURCHINSON \n\n" +
        "Units sent  :  \n" +
        " E189        E189                 E199        E199 \n\n" +
        "Nature of Call : FALL VICTIM \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s:  \n" +
        " E189        201200000530             E199        201200000319 \n\n" +
        "The Call Taker is REEVES MARY L  \n" +
        "The Dispatcher is RUGGIANO EDWARD C",

        "ID:2012-00001892",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:6 DONOMA ST",
        "CITY:Pemberton Twp",
        "X:HANOVER BV/E LAKESHORE DR",
        "PLACE:ALLIES GROUP HOME 18",
        "TIME:12:53:05",
        "DATE:08/16/2012",
        "MAP:1811/1813/25/1801",
        "PHONE:(856) 340-3129",
        "NAME:NICHELLE MURCHINSON",
        "UNIT:E189 E189 E199 E199",
        "INFO:FALL VICTIM");

    doTest("T2",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00001897                    ORI: E180          Station:  \n" +
        "Incident Type  . :  124 E Pregnant             Priority: 1  \n" +
        "Incident Location: 630 PEMBERTON BROWNS MILLS RD                        Venue: Pembtn Twp  \n" +
        "Located Between  : FOUR MILE RD/PEMBERTON BP  \n" +
        "Common Name. . . : MINIMUM SECURITY \n\n" +
        "Call Time- 02:15:48                                Date- 08/17/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1804              Section :   15         Beat  . : 1804        Map . . :  \n" +
        "Grid:                   Quadrant: 1855         District: 1855 \n\n" +
        "Phone Number: (609) 894-4877                Call Source:  911 \n\n" +
        "Caller. . . : COUNTY OF BURLINGTON \n\n" +
        "Units sent  :  \n" +
        " E186        E1862 \n\n" +
        "Nature of Call : 23F 9 MTHS PREGNANT WATER BROKE \n\n" +
        "Additional Info  \n" +
        "  K WING \n\n" +
        "Address Checks \n\n" +
        "Resident Name - DAVIS,DENISE,J,,  \n" +
        " Suspect in Case: 201100023948  \n" +
        " Suspect in Case: 201000017520 \n\n" +
        "Resident Name - THOMPSON,DAVID,,,  \n" +
        " Suspect in Case: 201100023948 \n\n" +
        "Resident Name - GRUPICO,FRANCESCO,,,  \n" +
        " Suspect in Case: 201100023948 \n\n" +
        "Resident Name - MCLEOD,ROY,,,  \n" +
        " Suspect in Case: 201100023948 \n\n" +
        "Additional Inc#s:  \n" +
        " E186        201200001890             E199        201200000320 \n\n" +
        "The Call Taker is KURTS-BURG SUSAN E  \n" +
        "The Dispatcher is FRIEDRICH JOSHUA",

        "ID:2012-00001897",
        "CALL:124 E Pregnant",
        "PRI:1",
        "ADDR:630 PEMBERTON BROWNS MILLS RD",
        "CITY:Pemberton Twp",
        "X:FOUR MILE RD/PEMBERTON BP",
        "PLACE:MINIMUM SECURITY",
        "TIME:02:15:48",
        "DATE:08/17/2012",
        "MAP:1855/1855/15/1804",
        "PHONE:(609) 894-4877",
        "NAME:COUNTY OF BURLINGTON",
        "UNIT:E186 E1862",
        "INFO:23F 9 MTHS PREGNANT WATER BROKE");

    doTest("T3",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00001904                    ORI: E180          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 84 DICKINSON CT                                      Venue: Pembtn Twp  \n" +
        "Located Between  : COLLEGE DR/YALE RD \n\n" +
        "Call Time- 21:40:32                                Date- 08/17/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1803              Section :   32         Beat  . : 1803        Map . . :  \n" +
        "Grid:                   Quadrant: 1851         District: 1851 \n\n" +
        "Phone Number: (609) 894-0477                Call Source:  911 \n\n" +
        "Caller. . . : ANGEL COLON  \n" +
        "Complaintant: 84 DICKINSON CT \n\n" +
        "Nature of Call : FEMALE FALL VICTIM \n\n" +
        "Additional Info  \n" +
        "  RESD: \n\n" +
        "Address Checks \n\n" +
        "Resident Name - DONNELLY,WILLIAM,,,  \n" +
        " Suspect in Case: 198900001053 \n\n" +
        "Additional Inc#s:  \n" +
        " E199        201200000321 \n\n" +
        "The Call Taker is FRITZ DANIEL J  \n" +
        "The Dispatcher is HARRIS THOMAS",

        "ID:2012-00001904",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:84 DICKINSON CT",
        "CITY:Pemberton Twp",
        "X:COLLEGE DR/YALE RD",
        "TIME:21:40:32",
        "DATE:08/17/2012",
        "MAP:1851/1851/32/1803",
        "PHONE:(609) 894-0477",
        "NAME:ANGEL COLON Complaintant: 84 DICKINSON CT",
        "INFO:FEMALE FALL VICTIM");

    doTest("T4",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00001904                    ORI: E180          Station:  \n" +
        "Incident Type  . :  117 E Falls                Priority: 1  \n" +
        "Incident Location: 84 DICKINSON CT                                      Venue: Pembtn Twp  \n" +
        "Located Between  : COLLEGE DR/YALE RD \n\n" +
        "Call Time- 21:40:32                                Date- 08/17/2012  \n" +
        "Dispatch - 21:41:04     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1803              Section :   32         Beat  . : 1803        Map . . :  \n" +
        "Grid:                   Quadrant: 1851         District: 1851 \n\n" +
        "Phone Number: (609) 894-0477                Call Source:  911 \n\n" +
        "Caller. . . : ANGEL COLON  \n" +
        "Complaintant: 84 DICKINSON CT \n\n" +
        "Units sent  :  \n" +
        " E199        E199                 E199        E1991 \n\n" +
        "Nature of Call : FEMALE FALL VICTIM \n\n" +
        "Additional Info  \n" +
        "  RESD: \n\n" +
        "Address Checks \n\n" +
        "Resident Name - DONNELLY,WILLIAM,,,  \n" +
        " Suspect in Case: 198900001053 \n\n" +
        "Additional Inc#s:  \n" +
        " E199        201200000321 \n\n" +
        "The Call Taker is FRITZ DANIEL J  \n" +
        "The Dispatcher is HARRIS THOMAS",

        "ID:2012-00001904",
        "CALL:117 E Falls",
        "PRI:1",
        "ADDR:84 DICKINSON CT",
        "CITY:Pemberton Twp",
        "X:COLLEGE DR/YALE RD",
        "TIME:21:40:32",
        "DATE:08/17/2012",
        "MAP:1851/1851/32/1803",
        "PHONE:(609) 894-0477",
        "NAME:ANGEL COLON Complaintant: 84 DICKINSON CT",
        "UNIT:E199 E199 E199 E1991",
        "INFO:FEMALE FALL VICTIM");

  }
  
  @Test
  public void testActive911C() {

    doTest("T1",
        "(Automatic R&R Notification) Incident Number  : 2012-00002441                    ORI: E239          Station:\n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1\n" +
        "Incident Location: 3109 BRIDGEBORO RD                                   Venue: Delran\n" +
        "Located Between  : LOWDEN ST/HARTFORD RD\n\n" +
        "Call Time- 19:01:40                                Date- 09/04/2012\n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-\n" +
        "Arrive 2 -              Depart 2-              In-statn-\n\n" +
        "Area: 2302              Section :  S29         Beat  . : 2391        Map . . :\n" +
        "Grid:   G4              Quadrant: 2311         District: 2311\n\n" +
        "Phone Number: (856) 676-1378                Call Source:  911\n\n" +
        "Caller. . . :  BRITTANY STEHO\n\n" +
        "Nature of Call : WANTS TO KILL HERSELF/HAS TRIED IN THE PAST\n\n" +
        "Additional Info\n" +
        "  WPH1:\n\n" +
        "Address Checks\n\n" +
        "Building-GEO : Officer Safety\n" +
        "  Last Update   :    6-9-2011\n" +
        "  Date of Entry:     9-3-2006 / P2363\n" +
        "  Residence Name:    STEHL\n" +
        "  Residence Phn#:    856-461-2885\n" +
        "  Hazard Info:       SEND AT LEAST 2 PATROLS-BRITTANY IS VIOLENT & SUICIDAL\n\n" +
        "Resident Name - STEHL,BRITTANY,BRIANNA,,\n" +
        " Suspect in Case: 201000003152\n" +
        " Suspect in Case: 201000003539\n" +
        " Suspect in Case: 201000003453\n\n" +
        "Resident Name - STEHL,BRITTANY,BRIANNA,,\n" +
        " Suspect in Case: 200400012713\n\n" +
        "Resident Name - STEHL,CHARLES,EDWARD,,\n" +
        " Suspect in Case: 200500008557\n" +
        " Suspect in Case: 200500008557\n\n" +
        "Resident Name - STEHL,SHARON,M,,\n" +
        " Suspect in Case: 200600010272\n" +
        " Suspect in Case: 200600010117\n" +
        " Suspect in Case: 200600010272\n\n" +
        "Resident Name - STEHL,BRITTANY,BRIANNA,,\n" +
        " Suspect in Case: 200800000979\n" +
        " Suspect in Case: 200800001190\n" +
        " Suspect in Case: 200700011674\n" +
        " Suspect in Case: 200700011775\n" +
        " Suspect in Case: 200900005995\n" +
        " Suspect in Case: 201000009501\n" +
        " Suspect in Case: 201000009107\n" +
        " Suspect in Case: 200800000979\n" +
        " Suspect in Case: 200800001190\n\n" +
        "Resident Name - STEHL,BRITTANY,BRIANNA,,\n" +
        " Suspect in Case: 201100013667\n\n" +
        "Additional Inc#s:\n\n" +
        "The Call Taker is DWYER DECLAN\n" +
        "The Dispatcher is GILBERT CHRISTINE MFrom: <LDYE@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002441",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:3109 BRIDGEBORO RD",
        "CITY:Delran",
        "X:LOWDEN ST/HARTFORD RD",
        "TIME:19:01:40",
        "DATE:09/04/2012",
        "MAP:2311/2311/S29/2302",
        "PHONE:(856) 676-1378",
        "NAME:BRITTANY STEHO",
        "INFO:WANTS TO KILL HERSELF/HAS TRIED IN THE PAST");

    doTest("T2",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00002442                    ORI: E239          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 1341 FAIRVIEW BV                                     Venue: Delran  \n" +
        "Located Between  : N RT130/HARTFORD RD  \n" +
        "Common Name. . . : STAPLES 23 \n\n" +
        "Call Time- 19:56:53                                Date- 09/04/2012  \n" +
        "Dispatch - 19:57:21     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 2302              Section :  S17         Beat  . : 2390        Map . . :  \n" +
        "Grid:   G3              Quadrant: 2312         District: 2312 \n\n" +
        "Phone Number: (856) 764-2923                Call Source:  TEL \n\n" +
        "Caller. . . : P2385 \n\n" +
        "Units sent  :  \n" +
        " E239        E2391 \n\n" +
        "Nature of Call : SQUAD FOR FEMALE COMPLAINING OF PACEMAKER PRO \n\n" +
        "Additional Info  \n" +
        "  BLEMS \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is HAYS DARRELL W  \n" +
        "The Dispatcher is GILBERT CHRISTINE MFrom: <LDYE@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002442",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:1341 FAIRVIEW BV",  // Fairview ST instead of Fairview BV
        "CITY:Delran",
        "X:N RT130/HARTFORD RD",
        "PLACE:STAPLES 23",
        "TIME:19:56:53",
        "DATE:09/04/2012",
        "MAP:2312/2312/S17/2302",
        "PHONE:(856) 764-2923",
        "NAME:P2385",
        "UNIT:E239 E2391",
        "INFO:SQUAD FOR FEMALE COMPLAINING OF PACEMAKER PRO");

    doTest("T3",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00002442                    ORI: E239          Station:  \n" +
        "Incident Type  . :  119 E Heart                Priority: 1  \n" +
        "Incident Location: 1341 FAIRVIEW BV                                     Venue: Delran  \n" +
        "Located Between  : N RT130/HARTFORD RD  \n" +
        "Common Name. . . : STAPLES 23 \n\n" +
        "Call Time- 19:56:53                                Date- 09/04/2012  \n" +
        "Dispatch - 19:57:21     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 2302              Section :  S17         Beat  . : 2390        Map . . :  \n" +
        "Grid:   G3              Quadrant: 2312         District: 2312 \n\n" +
        "Phone Number: (856) 764-2923                Call Source:  TEL \n\n" +
        "Caller. . . : P2385 \n\n" +
        "Units sent  :  \n" +
        " E159        E1592                E239        E2391  \n" +
        " E239        E2396 \n\n" +
        "Nature of Call : SQUAD FOR FEMALE COMPLAINING OF PACEMAKER PRO \n\n" +
        "Additional Info  \n" +
        "  BLEMS \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s:  \n" +
        " E159        201200014954 \n\n" +
        "The Call Taker is HAYS DARRELL W  \n" +
        "The Dispatcher is GILBERT CHRISTINE MFrom: <LDYE@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002442",
        "CALL:119 E Heart",
        "PRI:1",
        "ADDR:1341 FAIRVIEW BV",
        "CITY:Delran",
        "X:N RT130/HARTFORD RD",
        "PLACE:STAPLES 23",
        "TIME:19:56:53",
        "DATE:09/04/2012",
        "MAP:2312/2312/S17/2302",
        "PHONE:(856) 764-2923",
        "NAME:P2385",
        "UNIT:E159 E1592 E239 E2391 E239 E2396",
        "INFO:SQUAD FOR FEMALE COMPLAINING OF PACEMAKER PRO");

    doTest("T4",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00000157                    ORI: 03701         Station:  \n" +
        "Incident Type  . : FIRE F Fire Call            Priority: 1  \n" +
        "Incident Location: 208 HOOKER ST                                        Venue: Riverside  \n" +
        "Located Between  : PINE ST/HOOKER ST \n\n" +
        "Call Time- 22:13:29                                Date- 09/04/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 7001              Section :   06         Beat  . : 7091        Map . . :  \n" +
        "Grid:   G2              Quadrant: 7002         District: 7001 \n\n" +
        "Phone Number: (856) 764-4760                Call Source:  911 \n\n" +
        "Caller. . . : K & GOGLIUZZA \n\n" +
        "Units sent  :  \n" +
        " 03701       F701 \n\n" +
        "Nature of Call : CO DETECTOR ACTIVATION \n\n" +
        "Additional Info  \n" +
        "  RESD: \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002443 \n\n" +
        "The Call Taker is HAINES WILLIAM  \n" +
        "The Dispatcher is GILBERT CHRISTINE MFrom: <LDYE@CO.BURLINGTON.NJ.US>",

        "ID:2012-00000157",
        "CALL:FIRE F Fire Call",
        "PRI:1",
        "ADDR:208 HOOKER ST",
        "CITY:Riverside",
        "X:PINE ST/HOOKER ST",
        "TIME:22:13:29",
        "DATE:09/04/2012",
        "MAP:7001/7002/06/7001",
        "PHONE:(856) 764-4760",
        "NAME:K & GOGLIUZZA",
        "UNIT:03701 F701",
        "INFO:CO DETECTOR ACTIVATION");

    doTest("T5",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00002444                    ORI: E239          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 4004 N RT130                                         Venue: Delran  \n" +
        "Located Between  : SUBURBAN BV/HAINES MILL RD  \n" +
        "Common Name. . . : TARGET 23 \n\n" +
        "Call Time- 00:23:31                                Date- 09/05/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 2302              Section :  S16         Beat  . : 2391        Map . . :  \n" +
        "Grid:   F3              Quadrant: 2316         District: 2316 \n\n" +
        "Phone Number: (215) 313-3435                Call Source:  911 \n\n" +
        "Caller. . . : CHARLES LONG \n\n" +
        "Nature of Call : CHEST PAINS \n\n" +
        "Additional Info  \n" +
        "  PARKING LOT \n\n" +
        "Address Checks \n\n" +
        "Building-GEO : Commercial Property  \n" +
        "  Date of Entry:     5-9-2009 / P2363  \n" +
        "  Common Name:       TARGET STORE  \n" +
        "  Hazard Info:       TO REACH SOMEONE INSIDE AFTER HOURS,CALL BUS#,AFTER AUTO-  \n" +
        "  Other:             MATED MESSAGE PLAYS,STAY ON LINE & AN EMPLOYEE WILL ANSWER \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is SMITH MARY T  \n" +
        "The Dispatcher is CIEMNOLONSKI MICHAEL WFrom: <LDYE@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002444",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:4004 N RT130",
        "MADDR:4004 N RT 130",
        "CITY:Delran",
        "X:SUBURBAN BV/HAINES MILL RD",
        "PLACE:TARGET 23",
        "TIME:00:23:31",
        "DATE:09/05/2012",
        "MAP:2316/2316/S16/2302",
        "PHONE:(215) 313-3435",
        "NAME:CHARLES LONG",
        "INFO:CHEST PAINS");

    doTest("T6",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00000409                    ORI: E119          Station:  \n" +
        "Incident Type  . :  105 E BackPain             Priority: 7  \n" +
        "Incident Location: 1000 COOPERTOWN RD                                   Venue: Delanco  \n" +
        "Located Between  : TUNGSTEN DR/EDGEWATER PARK TWP LINE  \n" +
        "Common Name. . . : DIETZ & WATSON WAREHOUSE \n\n" +
        "Call Time- 01:03:33                                Date- 09/05/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1104              Section :   16         Beat  . : 1100        Map . . :  \n" +
        "Grid:   I2              Quadrant: 1102         District: 1102 \n\n" +
        "Phone Number: (856) 898-0200                Call Source:  911 \n\n" +
        "Caller. . . : TED SISHOLTZ  \n" +
        "Complaintant: EXT 5252 \n\n" +
        "Units sent  :  \n" +
        " E119        E119 \n\n" +
        "Nature of Call : 35YOM LOWER ABD PAIN SUDDEN ONSET \n\n" +
        "Additional Info  \n" +
        "  SHIPPING OFFICE AREA  \n" +
        "  RADIATING TO BACK \n\n" +
        "Address Checks \n\n" +
        "Building-GEO : Commercial Property  \n" +
        "  Date of Entry:     12/09/11 PER F1101  \n" +
        "  Common Name:       DIETZ & WATSON WAREHOUSE  \n" +
        "  Residence Phn#:    856-461-2201  \n" +
        "  Hazard Info:       SOLAR PANELS ON ROOF \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002445 \n\n" +
        "The Call Taker is SMITH MARY T  \n" +
        "The Dispatcher is CIEMNOLONSKI MICHAEL WFrom: <mciemnolonski@CO.BURLINGTON.NJ.US>",

        "ID:2012-00000409",
        "CALL:105 E BackPain",
        "PRI:7",
        "ADDR:1000 COOPERTOWN RD",
        "CITY:Delanco",
        "X:TUNGSTEN DR/EDGEWATER PARK TWP LINE",
        "PLACE:DIETZ & WATSON WAREHOUSE",
        "TIME:01:03:33",
        "DATE:09/05/2012",
        "MAP:1102/1102/16/1104",
        "PHONE:(856) 898-0200",
        "NAME:TED SISHOLTZ Complaintant: EXT 5252",
        "UNIT:E119 E119",
        "INFO:35YOM LOWER ABD PAIN SUDDEN ONSET");

    doTest("T7",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00000580                    ORI: E709          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 611 FILMORE ST                                       Venue: Riverside  \n" +
        "Located Between  : BURKE ST/LAYCOCK ST \n\n" +
        "Call Time- 01:34:33                                Date- 09/05/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 7001              Section :   07         Beat  . : 7091        Map . . :  \n" +
        "Grid:   H2              Quadrant: 7002         District: 7001 \n\n" +
        "Phone Number: (267) 581-6583                Call Source:  911 \n\n" +
        "Caller. . . : LOU ROSSO \n\n" +
        "Nature of Call : DAUGHTER HAVING SEIZURES/FEMALE 26 \n\n" +
        "Additional Info  \n" +
        "  WPH1: \n\n" +
        "Address Checks \n\n" +
        "Building-GEO : Officer Safety  \n" +
        "  Date of Entry:     6-14-2003  \n" +
        "  Residence Name:    RUSSO  \n" +
        "  Residence Phn#:    856-764-3210  \n" +
        "  Hazard Info:       DANIELLE RUSSO AGE 16-MENTALLY CHALLENGED,SHORT BROWN HAIR \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002446 \n\n" +
        "The Call Taker is DWYER DECLAN  \n" +
        "The Dispatcher is CIEMNOLONSKI MICHAEL WFrom: <LDYE@CO.BURLINGTON.NJ.US>",

        "ID:2012-00000580",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:611 FILMORE ST",
        "CITY:Riverside",
        "X:BURKE ST/LAYCOCK ST",
        "TIME:01:34:33",
        "DATE:09/05/2012",
        "MAP:7001/7002/07/7001",
        "PHONE:(267) 581-6583",
        "NAME:LOU ROSSO",
        "INFO:DAUGHTER HAVING SEIZURES/FEMALE 26");

    doTest("T8",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00002488                    ORI: E169          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 12 CLEARWATER DR                                     Venue: Willingbor  \n" +
        "Located Between  : CLUB HOUSE DR/CLUB RIDGE LA \n\n" +
        "Call Time- 07:13:43                                Date- 09/05/2012  \n" +
        "Dispatch - 07:15:10     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1604              Section : 1617         Beat  . : 1604        Map . . :  \n" +
        "Grid:   I5              Quadrant: 1604         District: 1604 \n\n" +
        "Phone Number: (856) 278-8379                Call Source:  911 \n\n" +
        "Caller. . . : DENISE HILL \n\n" +
        "Units sent  :  \n" +
        " E169        E169                 E239        E2391 \n\n" +
        "Nature of Call : 37YOM DIZZY, CANT SEE \n\n" +
        "Additional Info  \n" +
        "  WPH2:  SE \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002447 \n\n" +
        "The Call Taker is MAKANOFF NATHAN  \n" +
        "The Dispatcher is JOHNSON THOMASFrom: <wyerkes@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002488",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:12 CLEARWATER DR",
        "CITY:Willingboro",
        "X:CLUB HOUSE DR/CLUB RIDGE LA",
        "TIME:07:13:43",
        "DATE:09/05/2012",
        "MAP:1604/1604/1617/1604",
        "PHONE:(856) 278-8379",
        "NAME:DENISE HILL",
        "UNIT:E169 E169 E239 E2391",
        "INFO:37YOM DIZZY, CANT SEE");

    doTest("T9",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00002488                    ORI: E169          Station:  \n" +
        "Incident Type  . :  132 E UnkMedEmrg           Priority: 1  \n" +
        "Incident Location: 12 CLEARWATER DR                                     Venue: Willingbor  \n" +
        "Located Between  : CLUB HOUSE DR/CLUB RIDGE LA \n\n" +
        "Call Time- 07:13:43                                Date- 09/05/2012  \n" +
        "Dispatch - 07:15:10     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1604              Section : 1617         Beat  . : 1604        Map . . :  \n" +
        "Grid:   I5              Quadrant: 1604         District: 1604 \n\n" +
        "Phone Number: (856) 278-8379                Call Source:  911 \n\n" +
        "Caller. . . : DENISE HILL \n\n" +
        "Units sent  :  \n" +
        " E169        E169                 E239        E2391  \n" +
        " E239        E2396 \n\n" +
        "Nature of Call : 37YOM DIZZY, CANT SEE \n\n" +
        "Additional Info  \n" +
        "  WPH2:  SE \n\n" +
        "Address Checks \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002447 \n\n" +
        "The Call Taker is MAKANOFF NATHAN  \n" +
        "The Dispatcher is JOHNSON THOMASFrom: <vknott@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002488",
        "CALL:132 E UnkMedEmrg",
        "PRI:1",
        "ADDR:12 CLEARWATER DR",
        "CITY:Willingboro",
        "X:CLUB HOUSE DR/CLUB RIDGE LA",
        "TIME:07:13:43",
        "DATE:09/05/2012",
        "MAP:1604/1604/1617/1604",
        "PHONE:(856) 278-8379",
        "NAME:DENISE HILL",
        "UNIT:E169 E169 E239 E2391 E239 E2396",
        "INFO:37YOM DIZZY, CANT SEE");

    doTest("T10",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00002493                    ORI: E169          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: BEVERLY RANCOCAS RD                                  Venue: Willingbor  \n" +
        "  Cross Street . : PRIMROSE LA \n\n" +
        "Call Time- 12:50:11                                Date- 09/05/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1604              Section : 1610         Beat  . : 1604        Map . . :  \n" +
        "Grid:   I5              Quadrant: 1604         District: 1604 \n\n" +
        "Phone Number: (000) 000-0000                Call Source:  TEL \n\n" +
        "Caller. . . : P16174 \n\n" +
        "Units sent  :  \n" +
        " E169        E169 \n\n" +
        "Nature of Call : MVA LEG PAIN/AIR BAG / SECOND SQUAD GENERAL \n\n" +
        "Additional Info  \n" +
        "  PAIN \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002449 \n\n" +
        "The Call Taker is BERARDI FRANK J  \n" +
        "The Dispatcher is KNOTT VINCENT MFrom: <vknott@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002493",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:BEVERLY RANCOCAS RD",
        "MADDR:BEVERLY RANCOCAS RD & PRIMROSE LN",
        "CITY:Willingboro",
        "X:PRIMROSE LA",
        "TIME:12:50:11",
        "DATE:09/05/2012",
        "MAP:1604/1604/1610/1604",
        "NAME:P16174",
        "UNIT:E169 E169",
        "INFO:MVA LEG PAIN/AIR BAG / SECOND SQUAD GENERAL");

    doTest("T11",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00002493                    ORI: E169          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: BEVERLY RANCOCAS RD                                  Venue: Willingbor  \n" +
        "  Cross Street . : PRIMROSE LA \n\n" +
        "Call Time- 12:50:11                                Date- 09/05/2012  \n" +
        "Dispatch - 12:50:44     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1604              Section : 1610         Beat  . : 1604        Map . . :  \n" +
        "Grid:   I5              Quadrant: 1604         District: 1604 \n\n" +
        "Phone Number: (000) 000-0000                Call Source:  TEL \n\n" +
        "Caller. . . : P16174 \n\n" +
        "Units sent  :  \n" +
        " E169        E169                 E239        E2391  \n" +
        " E239        E2396 \n\n" +
        "Nature of Call : MVA LEG PAIN/AIR BAG / SECOND SQUAD GENERAL \n\n" +
        "Additional Info  \n" +
        "  PAIN \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002449 \n\n" +
        "The Call Taker is BERARDI FRANK J  \n" +
        "The Dispatcher is KNOTT VINCENT MFrom: <aendres@CO.BURLINGTON.NJ.US>",

        "ID:2012-00002493",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:BEVERLY RANCOCAS RD",
        "MADDR:BEVERLY RANCOCAS RD & PRIMROSE LN",
        "CITY:Willingboro",
        "X:PRIMROSE LA",
        "TIME:12:50:11",
        "DATE:09/05/2012",
        "MAP:1604/1604/1610/1604",
        "NAME:P16174",
        "UNIT:E169 E169 E239 E2391 E239 E2396",
        "INFO:MVA LEG PAIN/AIR BAG / SECOND SQUAD GENERAL");

    doTest("T12",
        "(Automatic R&R Notification) \n" +
        "  \n" +
        "Incident Number  : 2012-00000581                    ORI: E709          Station:  \n" +
        "Incident Type  . :  EMS E EMS Call             Priority: 1  \n" +
        "Incident Location: 1 SCOTT ST                                           Venue: Riverside  \n" +
        "Located Between  : S PAVILION AV/FAIRVIEW ST  \n" +
        "Common Name. . . : STA 700 \n\n" +
        "Call Time- 15:57:34                                Date- 09/05/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 7001              Section :   01         Beat  . : 7091        Map . . :  \n" +
        "Grid:   G2              Quadrant: 7004         District: 7001 \n\n" +
        "Phone Number: (856) 461-3434                Call Source:  TEL \n\n" +
        "Nature of Call : MALE EAR ACHE \n\n" +
        "Address Checks \n\n" +
        "Resident Name - FISHER,LT,,,  \n" +
        " Suspect in Case: 200900001480 \n\n" +
        "Resident Name - RIVERSIDE TOWNSHIP,,,,  \n" +
        " Suspect in Case: 200600003224  \n" +
        " Suspect in Case: 200700000168  \n" +
        " Suspect in Case: 200800000448  \n" +
        " Suspect in Case: 201100003724  \n" +
        " Suspect in Case: 201100004736  \n" +
        " Suspect in Case: 201100005469  \n" +
        " Suspect in Case: 201200003625  \n" +
        " Suspect in Case: 201200003936  \n" +
        " Suspect in Case: 201200005113 \n\n" +
        "Resident Name - RIVERSIDE MUNICIPAL COURT,,,,  \n" +
        " Suspect in Case: 200800006375 \n\n" +
        "Resident Name - TOWNSHIP OF RIVERSIDE,,,,  \n" +
        " Suspect in Case: 200800004503  \n" +
        " Suspect in Case: 200700004829  \n" +
        " Suspect in Case: 201000001903  \n" +
        " Suspect in Case: 201100005780 \n\n" +
        "Resident Name - GOFFREDO,PHILLIP,,,  \n" +
        " Suspect in Case: 200600003935 \n\n" +
        "Resident Name - CI-12-007,,,,  \n" +
        " Suspect in Case: 201200003249 \n\n" +
        "Resident Name - PARSON,JASON,,,  \n" +
        " Gun Permit: 000124473   Type: Purchase     Status: CCH Reqd \n\n" +
        "Additional Inc#s:  \n" +
        " E239        201200002451 \n\n" +
        "The Call Taker is KURTZ LEAHE L  \n" +
        "The Dispatcher is ENDRES ANTHONY GFrom: <tjohnson@CO.BURLINGTON.NJ.US>",

        "ID:2012-00000581",
        "CALL:EMS E EMS Call",
        "PRI:1",
        "ADDR:1 SCOTT ST",
        "CITY:Riverside",
        "X:S PAVILION AV/FAIRVIEW ST",
        "PLACE:STA 700",
        "TIME:15:57:34",
        "DATE:09/05/2012",
        "MAP:7001/7004/01/7001",
        "PHONE:(856) 461-3434",
        "INFO:MALE EAR ACHE");
  
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyCParserTest().generateTests("T1");
  }
}