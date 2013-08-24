package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kenton County, KY.

Contact: Steven Antrobus <chobie919@gmail.com>
Sender: dispatch@kentoncounty.org

Subject:From KCECC\nNon-Responsive   1188 FAR HILLS DR 22 / 2013-00006025 Park Hills  unconcious unk if breathing  male found in the b
Subject:From KCECC\nPump Basement   809 ARLINGTON RD / 2013-00000515 Park Hills  BASEMENT FLOODING  ABERDEEN RD / DIXIE HW
Subject:From KCECC\nFire - Structure Fire    1072 LAWTON RD / 2013-00000102 Park Hills  in the basement  HILLCREST LN / AUDUBON RD
Subject:From KCECC\nPump Basement   1414 AMSTERDAM RD / 2013-00000103 Park Hills  SLEEPY HOLLOW RD / ALTAVIA AV
Subject:From KCECC\nPump Basement   822 ARLINGTON RD / 2013-00000104 Park Hills  ABERDEEN RD / OLD STATE RD
Subject:From KCECC\nPump Basement   1048 AMSTERDAM RD / 2013-00000105 Park Hills  sewage is backed up and basement flooded  PARKVALE L
Subject:From KCECC\nPump Basement   814 ST JAMES AVE / 2013-00000106 Park Hills  ADVISED  2-3 FEET OF WATER IN BASEMENT  No Cross Stre
Subject:From KCECC\nIll / Non-Specific   1112 OLD STATE RD / 2013-00000509 Park Hills  ELDERLY FEMALE   POSS BLOOD CLOT  E911 Info - C
Subject:From KCECC\nPump Basement   505 ST JOSEPH LN 77 / 2013-00000099 Park Hills  bathroom sink leaking - flooding downstairs apt -
Subject:From KCECC\nChest Injury / Pains   1055 ALTAVIA AVE / 2013-00000510 Park Hills  MALE PATIEN 86YOA  RESPOND TO FRONT DOOR  HAS
Subject:From KCECC\nIll / Non-Specific   517 ST JOSEPH LN / 2013-00000499 Park Hills  UNK WHAT IS WRONG WITH HER  HAS NOT BEEN EATING
Subject:From KCECC\nChest Injury / Pains FORT MITCHELL GARAGE  1420 DIXIE HWY / 2013-00000496 Park Hills  55 yo male  chest pain and t
Subject:From KCECC\nIll / Non-Specific   1032 LAWTON RD / 2013-00000497 Park Hills  82 yo female stuck standing up and cant move her l
Subject:From KCECC\nFire - Structure Fire  WALMART  3450 VALLEYPLAZA PKWY / 2013-00000490 Fort Wright  THIS PER 751  ACTIVE GAS LEAK I

Contact: Active911
Agency name: Independence Fire District
Location: Independence, KY, United States
Sender: dispatch@kentoncounty.org

(From KCECC) Seizure   3923 RICHARDSON RD 32 / 2013-00001389 Independence  18 mos olds  GEORGE STEINFORD RD / THOMAS DR
(From KCECC) Choking   10351 PETERSBURG CT / 2013-00001388 Independence  has a trach  DEAD END / CODY RD
(From KCECC) Fire - Alarm   10708 MARSHALL RD / 2013-00001387 Kenton County  male on scene but phone keeps disconnecting  basement smoke STEEP CREEK RD / MANOR HILL
(From KCECC) Chest Injury / Pains   8984 SUPREME CT / 2013-00001386 Independence  TAKES ASPIRIN  POSS HEART ATTACK  60 YO FEMALE  DIFF BREATH DEAD END / INDEPENDENCE RD
(From KCECC) Fall   5224 MILLCREEK CIR / 2013-00018243 Independence  Dispatch received by unit IP27  91 f fell struck head on fl No Cross Streets Found
(From KCECC) Chest Injury / Pains   12025 SOUTHRIDGE DR / 2013-00001384 Kenton County  use front door  just had abdominal surgery still has drains DEAD END / WALTON NICHOLSON PI
(From KCECC) Fall   10320 CHARLESTON LN / 2013-00018232 Independence  no adult there caller is 16 yo  alert and holding a towel o DEAD END / TROOPERS XING, SHARPSBURG DR
(From KCECC) Difficulty Breathing   6696 FRONTIER DR / 2013-00001382 Independence  46 yoa female asthma, copd  DEAD END / STEPHENS RD
(From KCECC) Abdominal/Stomach Pain   4226 BIRNAM DR / 2013-00001381 Independence  fem subj - req silent approach  stomach pains - poss pancre BRIARWOOD DR / BOXWOOD LN
(From KCECC) Fire - Alarm CAMCO CHEMICALS  8150 HOLTON DR / 2013-00001380 Independence  SOUTH POLE STATION AND TROBLE THROUGH BUILDING     7273200  UNKNOWN / INDUSTRIAL RD
(From KCECC) Difficulty Breathing   4919 OPEN MEADOW DR / 2013-00001379 Kenton County  5 yoa with croup  HARVEST HILL DR / CORNUCOPIA CT
(From KCECC) Dizzy   3939 RICHARDSON RD / 2013-00001378 Independence  apt  21  front building    dizzy 68 yo f  GEORGE STEINFORD RD / THOMAS DR
(From KCECC) Fall   4241 BRIARWOOD DR / 2013-00001377 Independence  DEAD END / BOXWOOD LN
(From KCECC) Fall   5191 MADISON PI / 2013-00001376 Independence  FACIAL LACERATION  FRONT DOOR UNLOCKED  FEMALE 94 YOA  FELL MCMILLAN DR / INDEPENDENCE STATION RD
(From KCECC) Difficulty Breathing   5420 FOWLER CREEK RD / 2013-00001375 Independence  copd 69 yo female  COX RD, OLIVER RD / STEPHENS RD
(From KCECC) Chest Injury / Pains INDIAN RIDGE APARTMENTS  711 CHEROKEE DR 9 / 2013-00001374 Independence  MALE HAS SEVERE NERVE DAMAGE/ LIVER CANCER /  TAYLOR MILL RD, SKYWAY DR / SHAWNEE CT
(From KCECC) Chest Injury / Pains   5333 MADISON PI / 2013-00001373 Independence  FEM POSS HEART ATTACK  HARTLAND BL / LOCUST LN
(From KCECC) Emotional Crisis   477 FOREST RD / 2013-00001371 Kenton County  that comp advise are harmless  there is sliding glass doors TWIN LAKES DR / CLUB HOUSE DR
(From KCECC) Stroke   490 WALNUT RD / 2013-00001370 Kenton County  48 YOA MALE SUBJ POSS STROKE  HILLTOP RD / DEAD END
(From KCECC) Chest Injury / Pains REGENCY MANOR  11725 MADISON PIKE / 2013-00001368 Kenton County  FEM CHEST PAINS AND DIFF BREATHING  ROOM 2  No Cross Streets Found
(From KCECC) Chest Injury / Pains   11732 WILSON RD / 2013-00001367 Kenton County  male chest pains and poss alergic reaction  BRAMLAGE RD / WALTON NICHOLSON PI
(From KCECC) Difficulty Breathing SIMON KENTON HIGH SCHOOL  11132 MADISON PIKE / 2013-00001366 Independence  paractice gym  17 yoa m wrestler took a knee to the chest   No Cross Streets Found
(From KCECC) Fire - Alarm   4810 WILDWOOD DR / 2013-00001365 Independence  WOODMEADOW DR / WOODCREST DR
(From KCECC) Fire - Alarm   455 RIDGEVIEW DR / 2013-00001364 Independence  opr uxx  hallway zone 7 smoke detectors  longo res  DEAD END / THOMAS DR
(From KCECC) Seizure   14 FLEMING DR / 2013-00001360 Independence  HX OF SEIZURE  18 YO FEM  FEM IN SEIZURE  MADISON PI / FOUNDERS LN
(From KCECC) Accident - W / Injuries   932 BRISTOW RD / 2013-00017803 Independence  Dispatch received by unit IP18  Dispatch received by unit I TIMBER LN / BEECHGROVE DR
(From KCECC) Fire - Alarm   663 COLTON CT / 2013-00001357 Independence  matt and robin averbeck 8595259066   fire zone 095  not spe DEAD END / GLENHURST DR
(From KCECC) Ill / Non-Specific INDEPENDENCE URGENT CARE  2025 DECLARATION DR / 2013-00001356 Independence  65M DIZZY AND HOT  EKG SYSTEMATIC AFIB  E911 Info - Class o CENTENNIAL BL / DELAWARE XING
(From KCECC) Ill / Non-Specific   714 CHEROKEE DR / 2013-00001355 Independence  TAYLOR MILL RD, SKYWAY DR / SHAWNEE CT
(From KCECC) Difficulty Breathing   5420 FOWLER CREEK RD / 2013-00017756 Independence  turn left onto fowler creek  first drive on the left  from  COX RD, OLIVER RD / STEPHENS RD

Contact: Active911
Agency name: Ludlow Fire Department
Location: Ludlow, KY, United States
Sender: dispatch@kentoncounty.org

(From KCECC) Chest Injury / Pains LUDLOW BROMLEY SWIM CLUB  330 STOKESAY ST / 2013-00000380 Ludlow  46 yoa   female diff breathing  ADELA AV / LAUREL ST
(From KCECC) DOA - Death Investigation   707 ELM ST / 2013-00000379 Ludlow  DEVERILL ST / HELEN ST
(From KCECC) Difficulty Breathing   250 PARK AV / 2013-00000378 Ludlow  28 YO M DIF BREATHING VOMITING  LAUREL ST / CEDAR ALY
(From KCECC) Seizure   242 GLENWOOD ST / 2013-00000377 Ludlow  beverly hummel 44 yo female seizure  EUCLID ST / BUTLER ST
(From KCECC) Difficulty Breathing   223 ELM ST / 2013-00000376 Ludlow  FEMALE 66 YO FEAMLE  ENTER THRU THE ALLEY BEHIND BUFFALO BA EUCLID ST / CARNEAL ST
(From KCECC) Fire - Investigation   232 DEVERILL ST / 2013-00000375 Ludlow  THEY WOULD LIKE THE RESDIENCE CHECKED  KITCHEN WINDOW  WITH CEDAR ALY / LAUREL ST
(From KCECC) Fall   346 HAZEN ST / 2013-00000374 Ludlow  NOT INJURED  76 YO MALE   FALLEN   NEEDING ASSISTANCE  RIVERSBREEZE DR / DEAD END
(From KCECC) Fall   628 OAK ST / 2013-00000373 Ludlow  87m fell  is conscious left side ribs,head  E911 Info - Cla LUDFORD ST / HELEN ST
(From KCECC) Fire - Gas Spill/Leak   702 OAK ST / 2013-00000372 Ludlow  FUEL SPILL--HAVE 1 PUMPER RESPOND TO SPREAD STAYDRY ON OIL  LUDFORD ST / STOKESAY ST
(From KCECC) Ill / Non-Specific   301 OAK ST 1 / 2013-00000371 Ludlow  female is ill  DAVIES ST / KENNER ST
(From KCECC) Non-Responsive   47 ASH ST / 2013-00002444 Ludlow  SEND A SQUAD PER LD03  UNK IF IT IS POSSIBLY AN OVERDOSE  M LOCUST ST / TRAVERSE ST, RIVER RD
(From KCECC) Ill / Non-Specific HIGH POINT APARTMENTS  110 HAY ST 309 / 2013-00000369 Ludlow  states has liver and kidney problems  45yoa female with hea LOCUST ST / CARNEAL ST
(From KCECC) Overdose / Drug   50 ELM ST / 2013-00000368 Ludlow  LOCUST ST / ALY
(From KCECC) Chest Injury / Pains ONE CARE  1 SANDBANK RD / 2013-00000367 Ludlow  in the break room  male  employee having chest pains, mid 2 ADELA AV / DEAD END
(From KCECC) Dizzy   222 ADELA AVE / 2013-00002374 Ludlow  says shes home alone with her 4 children    oldest is 14  3 No Cross Streets Found
(From KCECC) Fire - Trash / Dumpster   OAK ST DEVERILL ST / 2013-00000365 Ludlow  mattress is smoldering  alley runs e-e  bromley firefighter
(From KCECC) Fall   218 ADELA AVE / 2013-00000364 Ludlow  SUBJ 859-835-1000 EUGENE WAGONER  CALLER IS 3RD PARTY  70 Y No Cross Streets Found
(From KCECC) Signal 500 4th Alarm KCPD  11777 MADISON PIKE / 2013-00000055 Kenton County  No Cross Streets Found
(From KCECC) Difficulty Breathing MIDDENDORF BULLOCK FUNERAL HOME LDPD  461 ELM ST / 2013-00000362 Ludlow  86 yo f   dif breathing    is down stairs will be waiting  OLDHAM ST / ADELA AV
(From KCECC) Abdominal/Stomach Pain   23 ASH ST / 2013-00000361 Ludlow  rib  pain  Call Number 543 was created from Call Number 532 TRAVERSE ST, RIVER RD / LOCUST ST
(From KCECC) Seizure LDFD  234 OAK ST / 2013-00000360 Ludlow  AT THE STATION NOW  1 YO CHILD HAVING A SIEZURE  COMING TO  DAVIES ST / CARNEAL ST
(From KCECC) Fire - Investigation   MONTAGUE RD SLEEPY HOLLOW RD / 2013-00000358 Ludlow  truck needs to respond 
(From KCECC) Accident - W / Injuries   HIGHWAY AV TRAVERSE ST / 2013-00000359 Ludlow  SUV UNDER BRIDGE, UNK IF ANYONE IN VEHICLE 
(From KCECC) Fire - Investigation   MONTAGUE RD SLEEPY HOLLOW RD / 2013-00000358 Ludlow  truck needs to respond 
(From KCECC) Fall   809 OAK ST 1 / 2013-00002299 Ludlow  FEMALE IS A PRIOR STROKE  48 YO FEMALE  Dispatch received b PARK AV / DEVERILL ST
(From KCECC) Ill / Non-Specific   211 DEVERILL ST / 2013-00000356 Ludlow  REQUESTING SILENT APPROACH  87YO FEMALE VOMITTING FOR A DAY CEDAR ALY / LAUREL ST
(From KCECC) Ill / Non-Specific   346 HAZEN ST / 2013-00000354 Ludlow  Dispatch received by unit LD08  MALE SUBJ WEAK NEEDING TRAN RIVERSBREEZE DR / DEAD END
(From KCECC) Overdose / Drug   1211 SCOTT ST 3 / 2013-00005477 Covington  Dispatch received by unit 1C25  Dispatch received by unit 1 TREVOR ST / E MARTIN LUTHER KING JR BL
(From KCECC) Ill / Non-Specific   346 HAZEN ST / 2013-00000354 Ludlow  MALE SUBJ WEAK NEEDING TRANSPORT  RIVERSBREEZE DR / DEAD END
(From KCECC) Chest Injury / Pains   126 ELM ST / 2013-00000353 Ludlow  59 yr old male chest pains--ludlow primary care  CARNEAL ST / ALY

*/

public class KYKentonCountyParserTest extends BaseParserTest {
  
  public KYKentonCountyParserTest() {
    setParser(new KYKentonCountyParser(), "KENTON COUNTY", "KY");
  }
  
  @Test
  public void testStevenAntrobus() {

    doTest("T1",
        "Subject:From KCECC\n" +
        "Non-Responsive   1188 FAR HILLS DR 22 / 2013-00006025 Park Hills  unconcious unk if breathing  male found in the b",

        "CALL:Non-Responsive",
        "ADDR:1188 FAR HILLS DR",  // Not mapping
        "APT:22",
        "ID:2013-00006025",
        "CITY:Park Hills",
        "INFO:unconcious unk if breathing  male found in the b");

    doTest("T2",
        "Subject:From KCECC\nPump Basement   809 ARLINGTON RD / 2013-00000515 Park Hills  BASEMENT FLOODING  ABERDEEN RD / DIXIE HW",
        "CALL:Pump Basement",
        "ADDR:809 ARLINGTON RD",
        "ID:2013-00000515",
        "CITY:Park Hills",
        "INFO:BASEMENT FLOODING",
        "X:ABERDEEN RD / DIXIE HW");

    doTest("T3",
        "Subject:From KCECC\nFire - Structure Fire    1072 LAWTON RD / 2013-00000102 Park Hills  in the basement  HILLCREST LN / AUDUBON RD",
        "CALL:Fire - Structure Fire",
        "ADDR:1072 LAWTON RD",
        "ID:2013-00000102",
        "CITY:Park Hills",
        "INFO:in the basement",
        "X:HILLCREST LN / AUDUBON RD");

    doTest("T4",
        "Subject:From KCECC\nPump Basement   1414 AMSTERDAM RD / 2013-00000103 Park Hills  SLEEPY HOLLOW RD / ALTAVIA AV",
        "CALL:Pump Basement",
        "ADDR:1414 AMSTERDAM RD",
        "ID:2013-00000103",
        "CITY:Park Hills",
        "INFO:SLEEPY",
        "X:HOLLOW RD / ALTAVIA AV");

    doTest("T5",
        "Subject:From KCECC\nPump Basement   822 ARLINGTON RD / 2013-00000104 Park Hills  ABERDEEN RD / OLD STATE RD",
        "CALL:Pump Basement",
        "ADDR:822 ARLINGTON RD",
        "ID:2013-00000104",
        "CITY:Park Hills",
        "X:ABERDEEN RD / OLD STATE RD");

    doTest("T6",
        "Subject:From KCECC\n" +
        "Pump Basement   1048 AMSTERDAM RD / 2013-00000105 Park Hills  sewage is backed up and basement flooded  PARKVALE L",

        "CALL:Pump Basement",
        "ADDR:1048 AMSTERDAM RD",
        "ID:2013-00000105",
        "CITY:Park Hills",
        "INFO:sewage is backed up and basement flooded  PARKVALE L");

    doTest("T7",
        "Subject:From KCECC\n" +
        "Pump Basement   814 ST JAMES AVE / 2013-00000106 Park Hills  ADVISED  2-3 FEET OF WATER IN BASEMENT  No Cross Stre",

        "CALL:Pump Basement",
        "ADDR:814 ST JAMES AVE",
        "ID:2013-00000106",
        "CITY:Park Hills",
        "INFO:ADVISED  2-3 FEET OF WATER IN BASEMENT");

    doTest("T8",
        "Subject:From KCECC\n" +
        "Ill / Non-Specific   1112 OLD STATE RD / 2013-00000509 Park Hills  ELDERLY FEMALE   POSS BLOOD CLOT  E911 Info - C",

        "CALL:Ill / Non-Specific",
        "ADDR:1112 OLD STATE RD",
        "ID:2013-00000509",
        "CITY:Park Hills",
        "INFO:ELDERLY FEMALE   POSS BLOOD CLOT  E911 Info  C");

    doTest("T9",
        "Subject:From KCECC\n" +
        "Pump Basement   505 ST JOSEPH LN 77 / 2013-00000099 Park Hills  bathroom sink leaking - flooding downstairs apt -",

        "CALL:Pump Basement",
        "ADDR:505 ST JOSEPH LN",
        "APT:77",
        "ID:2013-00000099",
        "CITY:Park Hills",
        "INFO:bathroom sink leaking - flooding downstairs apt");

    doTest("T10",
        "Subject:From KCECC\n" +
        "Chest Injury / Pains   1055 ALTAVIA AVE / 2013-00000510 Park Hills  MALE PATIEN 86YOA  RESPOND TO FRONT DOOR  HAS",

        "CALL:Chest Injury / Pains",
        "ADDR:1055 ALTAVIA AVE",
        "ID:2013-00000510",
        "CITY:Park Hills",
        "INFO:MALE PATIEN 86YOA  RESPOND TO FRONT DOOR  HAS");

    doTest("T11",
        "Subject:From KCECC\n" +
        "Ill / Non-Specific   517 ST JOSEPH LN / 2013-00000499 Park Hills  UNK WHAT IS WRONG WITH HER  HAS NOT BEEN EATING",

        "CALL:Ill / Non-Specific",
        "ADDR:517 ST JOSEPH LN",
        "ID:2013-00000499",
        "CITY:Park Hills",
        "INFO:UNK WHAT IS WRONG WITH HER  HAS NOT BEEN EATING");

    doTest("T12",
        "Subject:From KCECC\n" +
        "Chest Injury / Pains FORT MITCHELL GARAGE  1420 DIXIE HWY / 2013-00000496 Park Hills  55 yo male  chest pain and t",

        "CALL:Chest Injury / Pains",
        "PLACE:FORT MITCHELL GARAGE",
        "ADDR:1420 DIXIE HWY",
        "ID:2013-00000496",
        "CITY:Park Hills",
        "INFO:55 yo male  chest pain and t");

    doTest("T13",
        "Subject:From KCECC\n" +
        "Ill / Non-Specific   1032 LAWTON RD / 2013-00000497 Park Hills  82 yo female stuck standing up and cant move her l",

        "CALL:Ill / Non-Specific",
        "ADDR:1032 LAWTON RD",
        "ID:2013-00000497",
        "CITY:Park Hills",
        "INFO:82",
        "X:yo female stuck standing up and cant move her l");

    doTest("T14",
        "Subject:From KCECC\n" +
        "Fire - Structure Fire  WALMART  3450 VALLEYPLAZA PKWY / 2013-00000490 Fort Wright  THIS PER 751  ACTIVE GAS LEAK I",

        "CALL:Fire - Structure Fire",
        "PLACE:WALMART",
        "ADDR:3450 VALLEYPLAZA PKWY",
        "ID:2013-00000490",
        "CITY:Fort Wright",
        "INFO:THIS PER 751  ACTIVE GAS LEAK I");

  }
  
  @Test
  public void testIndependentFireDistrict() {

    doTest("T1",
        "(From KCECC) Seizure   3923 RICHARDSON RD 32 / 2013-00001389 Independence  18 mos olds  GEORGE STEINFORD RD / THOMAS DR",
        "CALL:Seizure",
        "ADDR:3923 RICHARDSON RD",
        "APT:32",
        "ID:2013-00001389",
        "CITY:Independence",
        "INFO:18 mos olds",
        "X:GEORGE STEINFORD RD / THOMAS DR");

    doTest("T2",
        "(From KCECC) Choking   10351 PETERSBURG CT / 2013-00001388 Independence  has a trach  DEAD END / CODY RD",
        "CALL:Choking",
        "ADDR:10351 PETERSBURG CT",
        "ID:2013-00001388",
        "CITY:Independence",
        "INFO:has a trach",
        "X:DEAD END / CODY RD");

    doTest("T3",
        "(From KCECC) Fire - Alarm   10708 MARSHALL RD / 2013-00001387 Kenton County  male on scene but phone keeps disconnecting  basement smoke STEEP CREEK RD / MANOR HILL",
        "CALL:Fire - Alarm",
        "ADDR:10708 MARSHALL RD",
        "ID:2013-00001387",
        "CITY:Kenton County",
        "INFO:male on scene but phone keeps disconnecting  basement smoke",
        "X:STEEP CREEK RD / MANOR HILL");

    doTest("T4",
        "(From KCECC) Chest Injury / Pains   8984 SUPREME CT / 2013-00001386 Independence  TAKES ASPIRIN  POSS HEART ATTACK  60 YO FEMALE  DIFF BREATH DEAD END / INDEPENDENCE RD",
        "CALL:Chest Injury / Pains",
        "ADDR:8984 SUPREME CT",
        "ID:2013-00001386",
        "CITY:Independence",
        "INFO:TAKES ASPIRIN  POSS HEART ATTACK  60 YO FEMALE  DIFF BREATH",
        "X:DEAD END / INDEPENDENCE RD");

    doTest("T5",
        "(From KCECC) Fall   5224 MILLCREEK CIR / 2013-00018243 Independence  Dispatch received by unit IP27  91 f fell struck head on fl No Cross Streets Found",
        "CALL:Fall",
        "ADDR:5224 MILLCREEK CIR",
        "ID:2013-00018243",
        "CITY:Independence",
        "UNIT:IP27",
        "INFO:91 f fell struck head on fl");

    doTest("T6",
        "(From KCECC) Chest Injury / Pains   12025 SOUTHRIDGE DR / 2013-00001384 Kenton County  use front door  just had abdominal surgery still has drains DEAD END / WALTON NICHOLSON PI",
        "CALL:Chest Injury / Pains",
        "ADDR:12025 SOUTHRIDGE DR",
        "ID:2013-00001384",
        "CITY:Kenton County",
        "INFO:use front door  just had abdominal surgery still has drains",
        "X:DEAD END / WALTON NICHOLSON PI");

    doTest("T7",
        "(From KCECC) Fall   10320 CHARLESTON LN / 2013-00018232 Independence  no adult there caller is 16 yo  alert and holding a towel o DEAD END / TROOPERS XING, SHARPSBURG DR",
        "CALL:Fall",
        "ADDR:10320 CHARLESTON LN",
        "ID:2013-00018232",
        "CITY:Independence",
        "INFO:no adult there caller is 16 yo  alert and holding a towel o  DEAD END / TROOPERS XING,",
        "X:SHARPSBURG DR");

    doTest("T8",
        "(From KCECC) Difficulty Breathing   6696 FRONTIER DR / 2013-00001382 Independence  46 yoa female asthma, copd  DEAD END / STEPHENS RD",
        "CALL:Difficulty Breathing",
        "ADDR:6696 FRONTIER DR",
        "ID:2013-00001382",
        "CITY:Independence",
        "INFO:46 yoa female asthma, copd",
        "X:DEAD END / STEPHENS RD");

    doTest("T9",
        "(From KCECC) Abdominal/Stomach Pain   4226 BIRNAM DR / 2013-00001381 Independence  fem subj - req silent approach  stomach pains - poss pancre BRIARWOOD DR / BOXWOOD LN",
        "CALL:Abdominal/Stomach Pain",
        "ADDR:4226 BIRNAM DR",
        "ID:2013-00001381",
        "CITY:Independence",
        "INFO:fem subj - req silent approach  stomach pains - poss pancre",
        "X:BRIARWOOD DR / BOXWOOD LN");

    doTest("T10",
        "(From KCECC) Fire - Alarm CAMCO CHEMICALS  8150 HOLTON DR / 2013-00001380 Independence  SOUTH POLE STATION AND TROBLE THROUGH BUILDING     7273200  UNKNOWN / INDUSTRIAL RD",
        "CALL:Fire - Alarm",
        "PLACE:CAMCO CHEMICALS",
        "ADDR:8150 HOLTON DR",
        "ID:2013-00001380",
        "CITY:Independence",
        "INFO:SOUTH POLE STATION AND TROBLE THROUGH BUILDING     7273200",
        "X:UNKNOWN / INDUSTRIAL RD");

    doTest("T11",
        "(From KCECC) Difficulty Breathing   4919 OPEN MEADOW DR / 2013-00001379 Kenton County  5 yoa with croup  HARVEST HILL DR / CORNUCOPIA CT",
        "CALL:Difficulty Breathing",
        "ADDR:4919 OPEN MEADOW DR",
        "ID:2013-00001379",
        "CITY:Kenton County",
        "INFO:5 yoa with croup",
        "X:HARVEST HILL DR / CORNUCOPIA CT");

    doTest("T12",
        "(From KCECC) Dizzy   3939 RICHARDSON RD / 2013-00001378 Independence  apt  21  front building    dizzy 68 yo f  GEORGE STEINFORD RD / THOMAS DR",
        "CALL:Dizzy",
        "ADDR:3939 RICHARDSON RD",
        "ID:2013-00001378",
        "CITY:Independence",
        "INFO:apt  21  front building    dizzy 68 yo f",
        "X:GEORGE STEINFORD RD / THOMAS DR");

    doTest("T13",
        "(From KCECC) Fall   4241 BRIARWOOD DR / 2013-00001377 Independence  DEAD END / BOXWOOD LN",
        "CALL:Fall",
        "ADDR:4241 BRIARWOOD DR",
        "ID:2013-00001377",
        "CITY:Independence",
        "X:DEAD END / BOXWOOD LN");

    doTest("T14",
        "(From KCECC) Fall   5191 MADISON PI / 2013-00001376 Independence  FACIAL LACERATION  FRONT DOOR UNLOCKED  FEMALE 94 YOA  FELL MCMILLAN DR / INDEPENDENCE STATION RD",
        "CALL:Fall",
        "ADDR:5191 MADISON PI",
        "MADDR:5191 MADISON PIKE",
        "ID:2013-00001376",
        "CITY:Independence",
        "INFO:FACIAL LACERATION  FRONT DOOR UNLOCKED  FEMALE 94 YOA  FELL",
        "X:MCMILLAN DR / INDEPENDENCE STATION RD");

    doTest("T15",
        "(From KCECC) Difficulty Breathing   5420 FOWLER CREEK RD / 2013-00001375 Independence  copd 69 yo female  COX RD, OLIVER RD / STEPHENS RD",
        "CALL:Difficulty Breathing",
        "ADDR:5420 FOWLER CREEK RD",
        "ID:2013-00001375",
        "CITY:Independence",
        "INFO:copd 69 yo female  COX RD,",
        "X:OLIVER RD / STEPHENS RD");

    doTest("T16",
        "(From KCECC) Chest Injury / Pains INDIAN RIDGE APARTMENTS  711 CHEROKEE DR 9 / 2013-00001374 Independence  MALE HAS SEVERE NERVE DAMAGE/ LIVER CANCER /  TAYLOR MILL RD, SKYWAY DR / SHAWNEE CT",
        "CALL:Chest Injury / Pains",
        "PLACE:INDIAN RIDGE APARTMENTS",
        "ADDR:711 CHEROKEE DR",
        "APT:9",
        "ID:2013-00001374",
        "CITY:Independence",
        "INFO:MALE HAS SEVERE NERVE DAMAGE/ LIVER CANCER /  TAYLOR MILL RD,",
        "X:SKYWAY DR / SHAWNEE CT");

    doTest("T17",
        "(From KCECC) Chest Injury / Pains   5333 MADISON PI / 2013-00001373 Independence  FEM POSS HEART ATTACK  HARTLAND BL / LOCUST LN",
        "CALL:Chest Injury / Pains",
        "ADDR:5333 MADISON PI",
        "MADDR:5333 MADISON PIKE",
        "ID:2013-00001373",
        "CITY:Independence",
        "INFO:FEM POSS HEART ATTACK",
        "X:HARTLAND BL / LOCUST LN");

    doTest("T18",
        "(From KCECC) Emotional Crisis   477 FOREST RD / 2013-00001371 Kenton County  that comp advise are harmless  there is sliding glass doors TWIN LAKES DR / CLUB HOUSE DR",
        "CALL:Emotional Crisis",
        "ADDR:477 FOREST RD",
        "ID:2013-00001371",
        "CITY:Kenton County",
        "INFO:that comp advise are harmless  there is sliding glass doors",
        "X:TWIN LAKES DR / CLUB HOUSE DR");

    doTest("T19",
        "(From KCECC) Stroke   490 WALNUT RD / 2013-00001370 Kenton County  48 YOA MALE SUBJ POSS STROKE  HILLTOP RD / DEAD END",
        "CALL:Stroke",
        "ADDR:490 WALNUT RD",
        "ID:2013-00001370",
        "CITY:Kenton County",
        "INFO:48 YOA MALE SUBJ POSS STROKE",
        "X:HILLTOP RD / DEAD END");

    doTest("T20",
        "(From KCECC) Chest Injury / Pains REGENCY MANOR  11725 MADISON PIKE / 2013-00001368 Kenton County  FEM CHEST PAINS AND DIFF BREATHING  ROOM 2  No Cross Streets Found",
        "CALL:Chest Injury / Pains",
        "PLACE:REGENCY MANOR",
        "ADDR:11725 MADISON PIKE",
        "ID:2013-00001368",
        "CITY:Kenton County",
        "INFO:FEM CHEST PAINS AND DIFF BREATHING  ROOM 2");

    doTest("T21",
        "(From KCECC) Chest Injury / Pains   11732 WILSON RD / 2013-00001367 Kenton County  male chest pains and poss alergic reaction  BRAMLAGE RD / WALTON NICHOLSON PI",
        "CALL:Chest Injury / Pains",
        "ADDR:11732 WILSON RD",
        "ID:2013-00001367",
        "CITY:Kenton County",
        "INFO:male chest pains and poss alergic reaction",
        "X:BRAMLAGE RD / WALTON NICHOLSON PI");

    doTest("T22",
        "(From KCECC) Difficulty Breathing SIMON KENTON HIGH SCHOOL  11132 MADISON PIKE / 2013-00001366 Independence  paractice gym  17 yoa m wrestler took a knee to the chest   No Cross Streets Found",
        "CALL:Difficulty Breathing",
        "PLACE:SIMON KENTON HIGH SCHOOL",
        "ADDR:11132 MADISON PIKE",
        "ID:2013-00001366",
        "CITY:Independence",
        "INFO:paractice gym  17 yoa m wrestler took a knee to the chest");

    doTest("T23",
        "(From KCECC) Fire - Alarm   4810 WILDWOOD DR / 2013-00001365 Independence  WOODMEADOW DR / WOODCREST DR",
        "CALL:Fire - Alarm",
        "ADDR:4810 WILDWOOD DR",
        "ID:2013-00001365",
        "CITY:Independence",
        "X:WOODMEADOW DR / WOODCREST DR");

    doTest("T24",
        "(From KCECC) Fire - Alarm   455 RIDGEVIEW DR / 2013-00001364 Independence  opr uxx  hallway zone 7 smoke detectors  longo res  DEAD END / THOMAS DR",
        "CALL:Fire - Alarm",
        "ADDR:455 RIDGEVIEW DR",
        "ID:2013-00001364",
        "CITY:Independence",
        "INFO:opr uxx  hallway zone 7 smoke detectors  longo res",
        "X:DEAD END / THOMAS DR");

    doTest("T25",
        "(From KCECC) Seizure   14 FLEMING DR / 2013-00001360 Independence  HX OF SEIZURE  18 YO FEM  FEM IN SEIZURE  MADISON PI / FOUNDERS LN",
        "CALL:Seizure",
        "ADDR:14 FLEMING DR",
        "ID:2013-00001360",
        "CITY:Independence",
        "INFO:HX OF SEIZURE  18 YO FEM  FEM IN SEIZURE",
        "X:MADISON PI / FOUNDERS LN");

    doTest("T26",
        "(From KCECC) Accident - W / Injuries   932 BRISTOW RD / 2013-00017803 Independence  Dispatch received by unit IP18  Dispatch received by unit I TIMBER LN / BEECHGROVE DR",
        "CALL:Accident - W / Injuries",
        "ADDR:932 BRISTOW RD",
        "ID:2013-00017803",
        "CITY:Independence",
        "UNIT:IP18 I",
        "X:TIMBER LN / BEECHGROVE DR");

    doTest("T27",
        "(From KCECC) Fire - Alarm   663 COLTON CT / 2013-00001357 Independence  matt and robin averbeck 8595259066   fire zone 095  not spe DEAD END / GLENHURST DR",
        "CALL:Fire - Alarm",
        "ADDR:663 COLTON CT",
        "ID:2013-00001357",
        "CITY:Independence",
        "INFO:matt and robin averbeck 8595259066   fire zone 095  not spe",
        "X:DEAD END / GLENHURST DR");

    doTest("T28",
        "(From KCECC) Ill / Non-Specific INDEPENDENCE URGENT CARE  2025 DECLARATION DR / 2013-00001356 Independence  65M DIZZY AND HOT  EKG SYSTEMATIC AFIB  E911 Info - Class o CENTENNIAL BL / DELAWARE XING",
        "CALL:Ill / Non-Specific",
        "PLACE:INDEPENDENCE URGENT CARE",
        "ADDR:2025 DECLARATION DR",
        "ID:2013-00001356",
        "CITY:Independence",
        "INFO:65M DIZZY AND HOT  EKG SYSTEMATIC AFIB  E911 Info - Class o",
        "X:CENTENNIAL BL / DELAWARE XING");

    doTest("T29",
        "(From KCECC) Ill / Non-Specific   714 CHEROKEE DR / 2013-00001355 Independence  TAYLOR MILL RD, SKYWAY DR / SHAWNEE CT",
        "CALL:Ill / Non-Specific",
        "ADDR:714 CHEROKEE DR",
        "ID:2013-00001355",
        "CITY:Independence",
        "INFO:TAYLOR MILL RD,",
        "X:SKYWAY DR / SHAWNEE CT");

    doTest("T30",
        "(From KCECC) Difficulty Breathing   5420 FOWLER CREEK RD / 2013-00017756 Independence  turn left onto fowler creek  first drive on the left  from  COX RD, OLIVER RD / STEPHENS RD",
        "CALL:Difficulty Breathing",
        "ADDR:5420 FOWLER CREEK RD",
        "ID:2013-00017756",
        "CITY:Independence",
        "INFO:turn left onto fowler creek  first drive on the left  from  COX RD,",
        "X:OLIVER RD / STEPHENS RD");
 
  }
  
  @Test
  public void testLudlowFireDept() {

    doTest("T1",
        "(From KCECC) Chest Injury / Pains LUDLOW BROMLEY SWIM CLUB  330 STOKESAY ST / 2013-00000380 Ludlow  46 yoa   female diff breathing  ADELA AV / LAUREL ST",
        "CALL:Chest Injury / Pains",
        "PLACE:LUDLOW BROMLEY SWIM CLUB",
        "ADDR:330 STOKESAY ST",
        "ID:2013-00000380",
        "CITY:Ludlow",
        "INFO:46 yoa   female diff breathing",
        "X:ADELA AV / LAUREL ST");

    doTest("T2",
        "(From KCECC) DOA - Death Investigation   707 ELM ST / 2013-00000379 Ludlow  DEVERILL ST / HELEN ST",
        "CALL:DOA - Death Investigation",
        "ADDR:707 ELM ST",
        "ID:2013-00000379",
        "CITY:Ludlow",
        "X:DEVERILL ST / HELEN ST");

    doTest("T3",
        "(From KCECC) Difficulty Breathing   250 PARK AV / 2013-00000378 Ludlow  28 YO M DIF BREATHING VOMITING  LAUREL ST / CEDAR ALY",
        "CALL:Difficulty Breathing",
        "ADDR:250 PARK AV",
        "MADDR:250 PARK AVE",
        "ID:2013-00000378",
        "CITY:Ludlow",
        "INFO:28 YO M DIF BREATHING VOMITING",
        "X:LAUREL ST / CEDAR ALY");

    doTest("T4",
        "(From KCECC) Seizure   242 GLENWOOD ST / 2013-00000377 Ludlow  beverly hummel 44 yo female seizure  EUCLID ST / BUTLER ST",
        "CALL:Seizure",
        "ADDR:242 GLENWOOD ST",
        "ID:2013-00000377",
        "CITY:Ludlow",
        "INFO:beverly hummel 44 yo female seizure",
        "X:EUCLID ST / BUTLER ST");

    doTest("T5",
        "(From KCECC) Difficulty Breathing   223 ELM ST / 2013-00000376 Ludlow  FEMALE 66 YO FEAMLE  ENTER THRU THE ALLEY BEHIND BUFFALO BA EUCLID ST / CARNEAL ST",
        "CALL:Difficulty Breathing",
        "ADDR:223 ELM ST",
        "ID:2013-00000376",
        "CITY:Ludlow",
        "INFO:FEMALE 66 YO FEAMLE  ENTER THRU THE ALLEY BEHIND BUFFALO BA",
        "X:EUCLID ST / CARNEAL ST");

    doTest("T6",
        "(From KCECC) Fire - Investigation   232 DEVERILL ST / 2013-00000375 Ludlow  THEY WOULD LIKE THE RESDIENCE CHECKED  KITCHEN WINDOW  WITH CEDAR ALY / LAUREL ST",
        "CALL:Fire - Investigation",
        "ADDR:232 DEVERILL ST",
        "ID:2013-00000375",
        "CITY:Ludlow",
        "INFO:THEY WOULD LIKE THE RESDIENCE CHECKED  KITCHEN WINDOW  WITH",
        "X:CEDAR ALY / LAUREL ST");

    doTest("T7",
        "(From KCECC) Fall   346 HAZEN ST / 2013-00000374 Ludlow  NOT INJURED  76 YO MALE   FALLEN   NEEDING ASSISTANCE  RIVERSBREEZE DR / DEAD END",
        "CALL:Fall",
        "ADDR:346 HAZEN ST",
        "ID:2013-00000374",
        "CITY:Ludlow",
        "INFO:NOT INJURED  76 YO MALE   FALLEN   NEEDING ASSISTANCE",
        "X:RIVERSBREEZE DR / DEAD END");

    doTest("T8",
        "(From KCECC) Fall   628 OAK ST / 2013-00000373 Ludlow  87m fell  is conscious left side ribs,head  E911 Info - Cla LUDFORD ST / HELEN ST",
        "CALL:Fall",
        "ADDR:628 OAK ST",
        "ID:2013-00000373",
        "CITY:Ludlow",
        "INFO:87m fell  is conscious left side ribs,head  E911 Info - Cla",
        "X:LUDFORD ST / HELEN ST");

    doTest("T9",
        "(From KCECC) Fire - Gas Spill/Leak   702 OAK ST / 2013-00000372 Ludlow  FUEL SPILL--HAVE 1 PUMPER RESPOND TO SPREAD STAYDRY ON OIL  LUDFORD ST / STOKESAY ST",
        "CALL:Fire - Gas Spill/Leak",
        "ADDR:702 OAK ST",
        "ID:2013-00000372",
        "CITY:Ludlow",
        "INFO:FUEL SPILL--HAVE 1 PUMPER RESPOND TO SPREAD STAYDRY ON OIL",
        "X:LUDFORD ST / STOKESAY ST");

    doTest("T10",
        "(From KCECC) Ill / Non-Specific   301 OAK ST 1 / 2013-00000371 Ludlow  female is ill  DAVIES ST / KENNER ST",
        "CALL:Ill / Non-Specific",
        "ADDR:301 OAK ST",
        "APT:1",
        "ID:2013-00000371",
        "CITY:Ludlow",
        "INFO:female is ill",
        "X:DAVIES ST / KENNER ST");

    doTest("T11",
        "(From KCECC) Non-Responsive   47 ASH ST / 2013-00002444 Ludlow  SEND A SQUAD PER LD03  UNK IF IT IS POSSIBLY AN OVERDOSE  M LOCUST ST / TRAVERSE ST, RIVER RD",
        "CALL:Non-Responsive",
        "ADDR:47 ASH ST",
        "ID:2013-00002444",
        "CITY:Ludlow",
        "INFO:SEND A SQUAD PER LD03  UNK IF IT IS POSSIBLY AN OVERDOSE  M",
        "X:LOCUST ST / TRAVERSE ST RIVER RD");

    doTest("T12",
        "(From KCECC) Ill / Non-Specific HIGH POINT APARTMENTS  110 HAY ST 309 / 2013-00000369 Ludlow  states has liver and kidney problems  45yoa female with hea LOCUST ST / CARNEAL ST",
        "CALL:Ill / Non-Specific",
        "PLACE:HIGH POINT APARTMENTS",
        "ADDR:110 HAY ST",
        "APT:309",
        "ID:2013-00000369",
        "CITY:Ludlow",
        "INFO:states has liver and kidney problems  45yoa female with hea",
        "X:LOCUST ST / CARNEAL ST");

    doTest("T13",
        "(From KCECC) Overdose / Drug   50 ELM ST / 2013-00000368 Ludlow  LOCUST ST / ALY",
        "CALL:Overdose / Drug",
        "ADDR:50 ELM ST",
        "ID:2013-00000368",
        "CITY:Ludlow",
        "X:LOCUST ST / ALY");

    doTest("T14",
        "(From KCECC) Chest Injury / Pains ONE CARE  1 SANDBANK RD / 2013-00000367 Ludlow  in the break room  male  employee having chest pains, mid 2 ADELA AV / DEAD END",
        "CALL:Chest Injury / Pains",
        "PLACE:ONE CARE",
        "ADDR:1 SANDBANK RD",
        "ID:2013-00000367",
        "CITY:Ludlow",
        "INFO:in the break room  male  employee having chest pains, mid  2",
        "X:ADELA AV / DEAD END");

    doTest("T15",
        "(From KCECC) Dizzy   222 ADELA AVE / 2013-00002374 Ludlow  says shes home alone with her 4 children    oldest is 14  3 No Cross Streets Found",
        "CALL:Dizzy",
        "ADDR:222 ADELA AVE",
        "ID:2013-00002374",
        "CITY:Ludlow",
        "INFO:says shes home alone with her 4 children    oldest is 14  3");

    doTest("T16",
        "(From KCECC) Fire - Trash / Dumpster   OAK ST DEVERILL ST / 2013-00000365 Ludlow  mattress is smoldering  alley runs e-e  bromley firefighter",
        "CALL:Fire - Trash / Dumpster",
        "ADDR:OAK ST & DEVERILL ST",
        "ID:2013-00000365",
        "CITY:Ludlow",
        "INFO:mattress is smoldering  alley runs e-e  bromley firefighter");

    doTest("T17",
        "(From KCECC) Fall   218 ADELA AVE / 2013-00000364 Ludlow  SUBJ 859-835-1000 EUGENE WAGONER  CALLER IS 3RD PARTY  70 Y No Cross Streets Found",
        "CALL:Fall",
        "ADDR:218 ADELA AVE",
        "ID:2013-00000364",
        "CITY:Ludlow",
        "INFO:SUBJ 859-835-1000 EUGENE WAGONER  CALLER IS 3RD PARTY  70 Y");

    doTest("T18",
        "(From KCECC) Signal 500 4th Alarm KCPD  11777 MADISON PIKE / 2013-00000055 Kenton County  No Cross Streets Found",
        "CALL:Signal 500 4th Alarm",
        "PLACE:KCPD",
        "ADDR:11777 MADISON PIKE",
        "ID:2013-00000055",
        "CITY:Kenton County");

    doTest("T19",
        "(From KCECC) Difficulty Breathing MIDDENDORF BULLOCK FUNERAL HOME LDPD  461 ELM ST / 2013-00000362 Ludlow  86 yo f   dif breathing    is down stairs will be waiting  OLDHAM ST / ADELA AV",
        "CALL:Difficulty Breathing",
        "PLACE:MIDDENDORF BULLOCK FUNERAL HOME LDPD",
        "ADDR:461 ELM ST",
        "ID:2013-00000362",
        "CITY:Ludlow",
        "INFO:86 yo f   dif breathing    is down stairs will be waiting",
        "X:OLDHAM ST / ADELA AV");

    doTest("T20",
        "(From KCECC) Abdominal/Stomach Pain   23 ASH ST / 2013-00000361 Ludlow  rib  pain  Call Number 543 was created from Call Number 532 TRAVERSE ST, RIVER RD / LOCUST ST",
        "CALL:Abdominal/Stomach Pain",
        "ADDR:23 ASH ST",
        "ID:2013-00000361",
        "CITY:Ludlow",
        "INFO:rib  pain  Call Number 543 was created from Call Number  532 TRAVERSE ST,",
        "X:RIVER RD / LOCUST ST");

    doTest("T21",
        "(From KCECC) Seizure LDFD  234 OAK ST / 2013-00000360 Ludlow  AT THE STATION NOW  1 YO CHILD HAVING A SIEZURE  COMING TO  DAVIES ST / CARNEAL ST",
        "CALL:Seizure",
        "PLACE:LDFD",
        "ADDR:234 OAK ST",
        "ID:2013-00000360",
        "CITY:Ludlow",
        "INFO:AT THE STATION NOW  1 YO CHILD HAVING A SIEZURE  COMING TO",
        "X:DAVIES ST / CARNEAL ST");

    doTest("T22",
        "(From KCECC) Fire - Investigation   MONTAGUE RD SLEEPY HOLLOW RD / 2013-00000358 Ludlow  truck needs to respond ",
        "CALL:Fire - Investigation",
        "ADDR:MONTAGUE RD & SLEEPY HOLLOW RD",
        "ID:2013-00000358",
        "CITY:Ludlow",
        "INFO:truck needs to respond");

    doTest("T23",
        "(From KCECC) Accident - W / Injuries   HIGHWAY AV TRAVERSE ST / 2013-00000359 Ludlow  SUV UNDER BRIDGE, UNK IF ANYONE IN VEHICLE ",
        "CALL:Accident - W / Injuries",
        "ADDR:HIGHWAY AV & TRAVERSE ST",
        "MADDR:HIGHWAY AVE & TRAVERSE ST",
        "ID:2013-00000359",
        "CITY:Ludlow",
        "INFO:SUV UNDER BRIDGE",
        "X:UNK IF ANYONE IN VEHICLE");

    doTest("T24",
        "(From KCECC) Fire - Investigation   MONTAGUE RD SLEEPY HOLLOW RD / 2013-00000358 Ludlow  truck needs to respond ",
        "CALL:Fire - Investigation",
        "ADDR:MONTAGUE RD & SLEEPY HOLLOW RD",
        "ID:2013-00000358",
        "CITY:Ludlow",
        "INFO:truck needs to respond");

    doTest("T25",
        "(From KCECC) Fall   809 OAK ST 1 / 2013-00002299 Ludlow  FEMALE IS A PRIOR STROKE  48 YO FEMALE  Dispatch received b PARK AV / DEVERILL ST",
        "CALL:Fall",
        "ADDR:809 OAK ST",
        "APT:1",
        "ID:2013-00002299",
        "CITY:Ludlow",
        "INFO:FEMALE IS A PRIOR STROKE  48 YO FEMALE  Dispatch received b",
        "X:PARK AV / DEVERILL ST");

    doTest("T26",
        "(From KCECC) Ill / Non-Specific   211 DEVERILL ST / 2013-00000356 Ludlow  REQUESTING SILENT APPROACH  87YO FEMALE VOMITTING FOR A DAY CEDAR ALY / LAUREL ST",
        "CALL:Ill / Non-Specific",
        "ADDR:211 DEVERILL ST",
        "ID:2013-00000356",
        "CITY:Ludlow",
        "INFO:REQUESTING SILENT APPROACH  87YO FEMALE VOMITTING FOR A DAY",
        "X:CEDAR ALY / LAUREL ST");

    doTest("T27",
        "(From KCECC) Ill / Non-Specific   346 HAZEN ST / 2013-00000354 Ludlow  Dispatch received by unit LD08  MALE SUBJ WEAK NEEDING TRAN RIVERSBREEZE DR / DEAD END",
        "CALL:Ill / Non-Specific",
        "ADDR:346 HAZEN ST",
        "ID:2013-00000354",
        "CITY:Ludlow",
        "UNIT:LD08",
        "INFO:MALE SUBJ WEAK NEEDING TRAN",
        "X:RIVERSBREEZE DR / DEAD END");

    doTest("T28",
        "(From KCECC) Overdose / Drug   1211 SCOTT ST 3 / 2013-00005477 Covington  Dispatch received by unit 1C25  Dispatch received by unit 1 TREVOR ST / E MARTIN LUTHER KING JR BL",
        "CALL:Overdose / Drug",
        "ADDR:1211 SCOTT ST",
        "APT:3",
        "ID:2013-00005477",
        "CITY:Covington",
        "UNIT:1C25 1",
        "X:TREVOR ST / E MARTIN LUTHER KING JR BL");

    doTest("T29",
        "(From KCECC) Ill / Non-Specific   346 HAZEN ST / 2013-00000354 Ludlow  MALE SUBJ WEAK NEEDING TRANSPORT  RIVERSBREEZE DR / DEAD END",
        "CALL:Ill / Non-Specific",
        "ADDR:346 HAZEN ST",
        "ID:2013-00000354",
        "CITY:Ludlow",
        "INFO:MALE SUBJ WEAK NEEDING TRANSPORT",
        "X:RIVERSBREEZE DR / DEAD END");

    doTest("T30",
        "(From KCECC) Chest Injury / Pains   126 ELM ST / 2013-00000353 Ludlow  59 yr old male chest pains--ludlow primary care  CARNEAL ST / ALY",
        "CALL:Chest Injury / Pains",
        "ADDR:126 ELM ST",
        "ID:2013-00000353",
        "CITY:Ludlow",
        "INFO:59 yr old male chest pains--ludlow primary care",
        "X:CARNEAL ST / ALY");
   
  }
  
  public static void main(String[] args) {
    new KYKentonCountyParserTest().generateTests("T1");
  }
}