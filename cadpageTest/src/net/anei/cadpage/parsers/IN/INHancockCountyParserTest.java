package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Hancock County, IN
Contact: Brandon Wilch <bwilch@bctfd.org>
Vehicle Accident - PI/4100 N 600W GREENFIELD & W AIRPORT BLV/52/ E71 M71 FG1 BCFP1/gate 2A
Structure #ALARM#/7935 W 600N MCCORDSVILLE R12B12089 OAKLANDON/N 700W & N 800W/52/ E71 E72 L71 M71 FG1 BCFP1/General fire alarm
Vehicle Accident - PI/3600 N 600W GREENFIELD/W 350N & W STONER DR/17/ E71 M71 FG3 BCFP1
Sick / Ill Person/2500 N 700W GREENFIELD/W 200N & W 300N/53/ E71 M71 FG1 BCFP1/LE on traffic stop; requesting check out
Aircraft Down/5881 W AIRPORT BLV GREENFIELD FUEL DEPOT/N AVIATION WAY & N 600W/18/ T71 BCFP1/Aircraft into a cart; Vietest building

Contact: "dustin dishman fun jumps llc" <funjumpsllc@funjumpsllc.com>
Sender: 3172237965 <user phone>
Lifting Assistance/1549 S JEANNE CT NEW PALESTINE/DEAD END & S FOX COVE BLV/88/ E42 M42 FG2 SCFP1/75 yo male

Contact: jbegovich <jbegovich@sugarcreektwp.com>
Sender: 777
Vehicle Accident - PD W/Airbags/5000 W 200S NEW PALESTINE & S 500W/SC3/ E42 R21 M42 FG2 SCFP1

Contact: Active911
Agency name: Sugar Creek Twp. Fire Department
Location: New Palestine, IN, United States
Sender: mplus@hancockcoingov.org

((33421) Barn Fire/ SENOUR & PENTICOST-MARION CO// SCFP1/ENGINE ONLY) Barn Fire/ SENOUR & PENTICOST-MARION CO// SCFP1/ENGINE ONLY
((33254) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW D) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW DR & W 200S/SC1/ E42 M42 SCFP1
((33122) Lifting Assistance/3012 S 300W GREENFIELD R4B155 GREENFIELD/W 300S & W 400S/SC4/) Lifting Assistance/3012 S 300W GREENFIELD R4B155 GREENFIELD/W 300S & W 400S/SC4/ R45 M42 SCFP10
((33073) Injured Person/3810 W ALLEN DR NEW PALESTINE/DEAD END & S ALLEN DR/SC4/ E45 M45) Injured Person/3810 W ALLEN DR NEW PALESTINE/DEAD END & S ALLEN DR/SC4/ E45 M45 SCFP1/40 year old male, missed a step, possibly broke his leg
((32946) Vehicle Accident - PD W/Airbags/5000 W 200S NEW PALESTINE & S 500W/SC3/ E42 R21) Vehicle Accident - PD W/Airbags/5000 W 200S NEW PALESTINE & S 500W/SC3/ E42 R21 M42 FG2 SCFP1
((32210) Difficulty Breathing/3303 W US40 LOT 63 GREENFIELD PHILLY ESTATES/N 300W & N 350) Difficulty Breathing/3303 W US40 LOT 63 GREENFIELD PHILLY ESTATES/N 300W & N 350W/SC3/ E42 M42 SCFP1
((31563) Difficulty Breathing/5318 W US40 LOT 28 GREENFIELD EAST 40 TRAILER PARK/N 525W &) Difficulty Breathing/5318 W US40 LOT 28 GREENFIELD EAST 40 TRAILER PARK/N 525W & N 600W/SC1/ E42 M42 SCFP1
((31336) Sick / Ill Person/3859 W 200S NEW PALESTINE R2B163 NEW PALESTINE/S JACOBI RD & S) Sick / Ill Person/3859 W 200S NEW PALESTINE R2B163 NEW PALESTINE/S JACOBI RD & S 400W/SC4/ E45 M45 SCFP1
((31287) Abdominal/4437 W LAKE POTOMAC VW APT.H GREENFIELD/S POTOMAC BLV & W POTOMAC DR/7) Abdominal/4437 W LAKE POTOMAC VW APT.H GREENFIELD/S POTOMAC BLV & W POTOMAC DR/71/ E42 M42 SCFP1/SEVER PAIN IN STOMACH AND LOWER BACK
((31014) Vehicle Accident - TU/3100 W US52 NEW PALESTINE & S 300W/SC4/ E45 R12 M45 FG2 SC) Vehicle Accident - TU/3100 W US52 NEW PALESTINE & S 300W/SC4/ E45 R12 M45 FG2 SCFP1

Contact: Active911
Agency name: FortvilleVernon Township Fire Department
Location: Fortville, In, United States
Sender: mplus@hancockcoingov.org

((33216) Injured Person/1481 W 950N FORTVILLE R1B400 FORTVILLE/N 125W & N FORTVILLE PK/42) Injured Person/1481 W 950N FORTVILLE R1B400 FORTVILLE/N 125W & N FORTVILLE PK/42/ R39 S39 M5227 FFDP1/90 yr old female fell from standing position, says her hip
((31388) Medical Alarm/226 N SCHOOL ST FORTVILLE/FOOT BRIDGE & E OHIO ST/21/ S39 M5227 FF) Medical Alarm/226 N SCHOOL ST FORTVILLE/FOOT BRIDGE & E OHIO ST/21/ S39 M5227 FFDP1/no pt info no contact
((30942) Investigate Gas Fumes/8780 N 200W FORTVILLE R1B445 FORTVILLE/W SR234 & W ORCHARD) Investigate Gas Fumes/8780 N 200W FORTVILLE R1B445 FORTVILLE/W SR234 & W ORCHARD DR/42/ E32 FG1 FFDP1
((30643) Code/610 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/21/ R39 S39 M5) Code/610 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/21/ R39 S39 M5227 FFDP1
((30449) Abdominal/1901 W 1000N FORTVILLE R2B4 FORTVILLE/N BALFER W DR & N 300W/42/ R39 S) Abdominal/1901 W 1000N FORTVILLE R2B4 FORTVILLE/N BALFER W DR & N 300W/42/ R39 S39 M5227 FFDP10/52 yr old male with ulcer - severe pain
((30423) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 40) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 400S/NP1/ FFDP1/working residence
((30345) Injured Person/426 E BROADWAY ST FORTVILLE BROADWAY DINER/S WALNUT ST & S ELM ST) Injured Person/426 E BROADWAY ST FORTVILLE BROADWAY DINER/S WALNUT ST & S ELM ST/21/ R39 S39 M5227 FFDP1
((29834) Heart / Chest Pain/8394 S SHADY TRAIL DR PENDLETON/S PADDLEBOAT LN & S RISING SU) Heart / Chest Pain/8394 S SHADY TRAIL DR PENDLETON/S PADDLEBOAT LN & S RISING SUN DR/310041/SUMRLAKE/ R39 M5227 FFDP1
((29613) Difficulty Breathing/310 E MILL ST FORTVILLE/S POPLAR ST & S WALNUT ST/21/ R39 S) Difficulty Breathing/310 E MILL ST FORTVILLE/S POPLAR ST & S WALNUT ST/21/ R39 S39 M5227 FFDP1/85 yr old male has been sick for a week
((28623) Heart / Chest Pain/609 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/) Heart / Chest Pain/609 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/21/ R39 S39 M5227 FFDP1

Contact: Active911
Agency name: Buck Creek Twp Fire Dept Station 71
Location: Greenfield, IN, United States
Sender: mplus@hancockcoingov.org

((33756) Sick / Ill Person/2290 N 600W GREENFIELD MCDONALDS / MT COMFORT RD/W JOHN L MODG) Sick / Ill Person/2290 N 600W GREENFIELD MCDONALDS / MT COMFORT RD/W JOHN L MODGLIN DR & W I70/BC2/ E71 M72 BCFP1/.
((33417) Sick / Ill Person/6984 W 100N GREENFIELD/N MAIELLEN DR & N 700W/BC2/ E71 M72 BCF) Sick / Ill Person/6984 W 100N GREENFIELD/N MAIELLEN DR & N 700W/BC2/ E71 M72 BCFP1/NASUA STOMACH HURTS
((33357) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW D) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW DR & W 200S/SC1/ BCFP1/55YO MALE.
((32314) Medic Transfer/801 N STATE ST GREENFIELD HANCOCK REGIONAL HOSPITAL/E BOYD AVE &) Medic Transfer/801 N STATE ST GREENFIELD HANCOCK REGIONAL HOSPITAL/E BOYD AVE & ELLIS DR/GF1/ BCFP1/going to heart center need als unit
((32162) Vehicle Accident - TU/6000 W I70 GREENFIELD MM96/N 600W & N 700W/86/ E71 M71 FG1) Vehicle Accident - TU/6000 W I70 GREENFIELD MM96/N 600W & N 700W/86/ E71 M71 FG1 BCFP1/WB
((32051) Medical Alarm/730 N 525W GREENFIELD R9B264A GREENFIELD/W US40 & W 100N/BC2/ E71) Medical Alarm/730 N 525W GREENFIELD R9B264A GREENFIELD/W US40 & W 100N/BC2/ E71 M72 BCFP1/medical emergency 88yo female fell an cant get up
((31279) Code/3211 W SHARON DR GREENFIELD R9B226 GREENFIELD/N WELKER DR & DEAD END/BC2/ E) Code/3211 W SHARON DR GREENFIELD R9B226 GREENFIELD/N WELKER DR & DEAD END/BC2/ E71 M72 BCFP1/MALE SUBJ COLD UNRESPONSIVE
((31219) Vehicle Accident - TU/4000 W I70 GREENFIELD MM98/N 400W & N 500W/69/ E71 M71 FG1) Vehicle Accident - TU/4000 W I70 GREENFIELD MM98/N 400W & N 500W/69/ E71 M71 FG1 BCFP10/EB, CAR IN THE MEDIAN,
((31119) Difficulty Breathing/601 N SUNSET CT GREENFIELD/W SUNSET N DR & DEAD END/BC2/ E7) Difficulty Breathing/601 N SUNSET CT GREENFIELD/W SUNSET N DR & DEAD END/BC2/ E71 M72 BCFP1/77 YR OLD FEMALE
((30587) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 40) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 400S/NP1/ FTFDP1 GFDP1 BCFP1/working residence

Contact: Active911
Agency name: Greenfield Fire Dept
Location: Greenfield, IN, United States
Sender: <mplus@hancockcoingov.org>

((49872) Medical Alarm/375 SHADOW CREEK PASS GREENFIELD/BRANDYWINE RIDGE & DEAD END/GF1/R) Medical Alarm/375 SHADOW CREEK PASS GREENFIELD/BRANDYWINE RIDGE & DEAD END/GF1/RIDGES/ M21 GFDP1/ALARM ACTIVATED, NO OTHER DETAILS AVAILABLE
((49695) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.
((49576) Medic Assist/10450 E US40 CHARLOTTESVILLE STATION 6/S EAST ST & N 1050E/JT4/ GFD) Medic Assist/10450 E US40 CHARLOTTESVILLE STATION 6/S EAST ST & N 1050E/JT4/ GFDP1
((49430) Stroke/430 W NORTH ST GREENFIELD/N NOBLE ST & SCHOOL ST/GF1/ E21 M22 GFDP1/Conc) Stroke/430 W NORTH ST GREENFIELD/N NOBLE ST & SCHOOL ST/GF1/ E21 M22 GFDP1/Conc and breathing; 92 yoa female
((49378) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private num) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private number, alot of background noise
((49255) Injured Person/710 BROOK ST LOT 15 GREENFIELD WILFONG TRAILER COURT/TAGUE ST & D) Injured Person/710 BROOK ST LOT 15 GREENFIELD WILFONG TRAILER COURT/TAGUE ST & DEAD END/GF1/ M21 GFDP1/elderly male and female fell they state that they are in
((49152) Structure ALARM/210 W MAIN ST GREENFIELD BRADLEY METHODIST CHURCH/S PENNSYLVAN) Structure ALARM/210 W MAIN ST GREENFIELD BRADLEY METHODIST CHURCH/S PENNSYLVANIA ST & RILEY AVE/GF1/ E21 TOW21 M22 FG2 GFDP1/no key holder
((49100) Difficulty Breathing/270 N MERIDIAN RD GREENFIELD/WINFIELD PARK DR & W LIBERTY L) Difficulty Breathing/270 N MERIDIAN RD GREENFIELD/WINFIELD PARK DR & W LIBERTY LN/GF1/ E21 M21 GFDP1/69
((49003) Unconscious Person/2488 E EDEN RD GREENFIELD R5B152 GREENFIELD/N SR9 & N 250E/GT) Unconscious Person/2488 E EDEN RD GREENFIELD R5B152 GREENFIELD/N SR9 & N 250E/GT1/ GFDP1/male subj passed out
((48927) Carbon Monoxide Alarm/2222 N HICKORY BLV GREENFIELD/E NEW RD & E HILL DR/CT5/ E2) Carbon Monoxide Alarm/2222 N HICKORY BLV GREENFIELD/E NEW RD & E HILL DR/CT5/ E22 M22 GFDP1/CALLED IN BY STATION 22

((49378) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private num) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private number, alot of background noise
((51027) Unconscious Person/205 WHITE ST SHIRLEY/SOUTH ST & CENTER ST/SF1/ GFDP1/possible) Unconscious Person/205 WHITE ST SHIRLEY/SOUTH ST & CENTER ST/SF1/ GFDP1/possible unconscious subject on the floor in the house,
((49695) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.
((49378) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private num) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private number, alot of background noise

*/

public class INHancockCountyParserTest extends BaseParserTest {
  
  public INHancockCountyParserTest() {
    setParser(new INHancockCountyParser(), "HANCOCK COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Vehicle Accident - PI/4100 N 600W GREENFIELD & W AIRPORT BLV/52/ E71 M71 FG1 BCFP1/gate 2A",
        "CALL:Vehicle Accident - PI",
        "ADDR:4100 N 600W",
        "CITY:GREENFIELD",
        "X:W AIRPORT BLV",
        "MAP:52",
        "UNIT:E71 M71 FG1 BCFP1",
        "INFO:gate 2A");

    doTest("T2",
        "Structure #ALARM#/7935 W 600N MCCORDSVILLE R12B12089 OAKLANDON/N 700W & N 800W/52/ E71 E72 L71 M71 FG1 BCFP1/General fire alarm",
        "CALL:Structure #ALARM#",
        "ADDR:7935 W 600N",
        "CITY:MCCORDSVILLE",
        "PLACE:R12B12089 OAKLANDON",
        "X:N 700W & N 800W",
        "MAP:52",
        "UNIT:E71 E72 L71 M71 FG1 BCFP1",
        "INFO:General fire alarm");

    doTest("T3",
        "Vehicle Accident - PI/3600 N 600W GREENFIELD/W 350N & W STONER DR/17/ E71 M71 FG3 BCFP1",
        "CALL:Vehicle Accident - PI",
        "ADDR:3600 N 600W",
        "CITY:GREENFIELD",
        "X:W 350N & W STONER DR",
        "MAP:17",
        "UNIT:E71 M71 FG3 BCFP1");

    doTest("T4",
        "Sick / Ill Person/2500 N 700W GREENFIELD/W 200N & W 300N/53/ E71 M71 FG1 BCFP1/LE on traffic stop; requesting check out",
        "CALL:Sick / Ill Person",
        "ADDR:2500 N 700W",
        "CITY:GREENFIELD",
        "X:W 200N & W 300N",
        "MAP:53",
        "UNIT:E71 M71 FG1 BCFP1",
        "INFO:LE on traffic stop; requesting check out");

    doTest("T5",
        "Aircraft Down/5881 W AIRPORT BLV GREENFIELD FUEL DEPOT/N AVIATION WAY & N 600W/18/ T71 BCFP1/Aircraft into a cart; Vietest building",
        "CALL:Aircraft Down",
        "ADDR:5881 W AIRPORT BLV",
        "MADDR:5881 W AIRPORT BLVD",
        "CITY:GREENFIELD",
        "PLACE:FUEL DEPOT",
        "X:N AVIATION WAY & N 600W",
        "MAP:18",
        "UNIT:T71 BCFP1",
        "INFO:Aircraft into a cart; Vietest building");

    doTest("T6",
        "Lifting Assistance/1549 S JEANNE CT NEW PALESTINE/DEAD END & S FOX COVE BLV/88/ E42 M42 FG2 SCFP1/75 yo male",
        "CALL:Lifting Assistance",
        "ADDR:1549 S JEANNE CT",
        "INFO:75 yo male",
        "CITY:NEW PALESTINE",
        "X:DEAD END & S FOX COVE BLV",
        "MAP:88",
        "UNIT:E42 M42 FG2 SCFP1");
  }
  
  @Test
  public void testJbegovich() {

    doTest("T1",
        "Vehicle Accident - PD W/Airbags/5000 W 200S NEW PALESTINE & S 500W/SC3/ E42 R21 M42 FG2 SCFP1",
        "CALL:Vehicle Accident - PD W / Airbags",
        "ADDR:5000 W 200S",
        "CITY:NEW PALESTINE",
        "X:S 500W",
        "MAP:SC3",
        "UNIT:E42 R21 M42 FG2 SCFP1");
    
  }
  
  @Test
  public void testSugarCreekTwpFire() {

    doTest("T1",
        "((33421) Barn Fire/ SENOUR & PENTICOST-MARION CO// SCFP1/ENGINE ONLY) Barn Fire/ SENOUR & PENTICOST-MARION CO// SCFP1/ENGINE ONLY",
        "CALL:Barn Fire",
        "ADDR:SENOUR & PENTICOST",
        "CITY:MARION COUNTY",
        "INFO:ENGINE ONLY",
        "UNIT:SCFP1");

    doTest("T2",
        "((33254) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW D) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW DR & W 200S/SC1/ E42 M42 SCFP1",
        "CALL:Diabetic Problem",
        "ADDR:1258 S 600W",
        "CITY:NEW PALESTINE",
        "PLACE:R1B354 NEW PALESTINE",
        "X:W BROKEN ARROW DR & W 200S",
        "MAP:SC1",
        "UNIT:E42 M42 SCFP1");

    doTest("T3",
        "((33122) Lifting Assistance/3012 S 300W GREENFIELD R4B155 GREENFIELD/W 300S & W 400S/SC4/) Lifting Assistance/3012 S 300W GREENFIELD R4B155 GREENFIELD/W 300S & W 400S/SC4/ R45 M42 SCFP10",
        "CALL:Lifting Assistance",
        "ADDR:3012 S 300W",
        "CITY:GREENFIELD",
        "PLACE:R4B155 GREENFIELD",
        "X:W 300S & W 400S",
        "MAP:SC4",
        "UNIT:R45 M42 SCFP10");

    doTest("T4",
        "((33073) Injured Person/3810 W ALLEN DR NEW PALESTINE/DEAD END & S ALLEN DR/SC4/ E45 M45) Injured Person/3810 W ALLEN DR NEW PALESTINE/DEAD END & S ALLEN DR/SC4/ E45 M45 SCFP1/40 year old male, missed a step, possibly broke his leg",
        "CALL:Injured Person",
        "ADDR:3810 W ALLEN DR",
        "CITY:NEW PALESTINE",
        "X:DEAD END & S ALLEN DR",
        "MAP:SC4",
        "UNIT:E45 M45 SCFP1",
        "INFO:40 year old male, missed a step, possibly broke his leg");

    doTest("T5",
        "((32946) Vehicle Accident - PD W/Airbags/5000 W 200S NEW PALESTINE & S 500W/SC3/ E42 R21) Vehicle Accident - PD W/Airbags/5000 W 200S NEW PALESTINE & S 500W/SC3/ E42 R21 M42 FG2 SCFP1",
        "CALL:Vehicle Accident - PD W / Airbags",
        "ADDR:5000 W 200S",
        "CITY:NEW PALESTINE",
        "X:S 500W",
        "MAP:SC3",
        "UNIT:E42 R21 M42 FG2 SCFP1");

    doTest("T6",
        "((32210) Difficulty Breathing/3303 W US40 LOT 63 GREENFIELD PHILLY ESTATES/N 300W & N 350) Difficulty Breathing/3303 W US40 LOT 63 GREENFIELD PHILLY ESTATES/N 300W & N 350W/SC3/ E42 M42 SCFP1",
        "CALL:Difficulty Breathing",
        "ADDR:3303 W US40",
        "MADDR:3303 W US 40",
        "APT:63",
        "CITY:GREENFIELD",
        "PLACE:PHILLY ESTATES",
        "X:N 300W & N 350W",
        "MAP:SC3",
        "UNIT:E42 M42 SCFP1");

    doTest("T7",
        "((31563) Difficulty Breathing/5318 W US40 LOT 28 GREENFIELD EAST 40 TRAILER PARK/N 525W &) Difficulty Breathing/5318 W US40 LOT 28 GREENFIELD EAST 40 TRAILER PARK/N 525W & N 600W/SC1/ E42 M42 SCFP1",
        "CALL:Difficulty Breathing",
        "ADDR:5318 W US40",
        "MADDR:5318 W US 40",
        "APT:28",
        "CITY:GREENFIELD",
        "PLACE:EAST 40 TRAILER PARK",
        "X:N 525W & N 600W",
        "MAP:SC1",
        "UNIT:E42 M42 SCFP1");

    doTest("T8",
        "((31336) Sick / Ill Person/3859 W 200S NEW PALESTINE R2B163 NEW PALESTINE/S JACOBI RD & S) Sick / Ill Person/3859 W 200S NEW PALESTINE R2B163 NEW PALESTINE/S JACOBI RD & S 400W/SC4/ E45 M45 SCFP1",
        "CALL:Sick / Ill Person",
        "ADDR:3859 W 200S",
        "CITY:NEW PALESTINE",
        "PLACE:R2B163 NEW PALESTINE",
        "X:S JACOBI RD & S 400W",
        "MAP:SC4",
        "UNIT:E45 M45 SCFP1");

    doTest("T9",
        "((31287) Abdominal/4437 W LAKE POTOMAC VW APT.H GREENFIELD/S POTOMAC BLV & W POTOMAC DR/7) Abdominal/4437 W LAKE POTOMAC VW APT.H GREENFIELD/S POTOMAC BLV & W POTOMAC DR/71/ E42 M42 SCFP1/SEVER PAIN IN STOMACH AND LOWER BACK",
        "CALL:Abdominal",
        "ADDR:4437 W LAKE POTOMAC VW",
        "APT:H",
        "CITY:GREENFIELD",
        "X:S POTOMAC BLV & W POTOMAC DR",
        "MAP:71",
        "UNIT:E42 M42 SCFP1",
        "INFO:SEVER PAIN IN STOMACH AND LOWER BACK");

    doTest("T10",
        "((31014) Vehicle Accident - TU/3100 W US52 NEW PALESTINE & S 300W/SC4/ E45 R12 M45 FG2 SC) Vehicle Accident - TU/3100 W US52 NEW PALESTINE & S 300W/SC4/ E45 R12 M45 FG2 SCFP1",
        "CALL:Vehicle Accident - TU",
        "ADDR:3100 W US52",
        "MADDR:3100 W US 52",
        "CITY:NEW PALESTINE",
        "X:S 300W",
        "MAP:SC4",
        "UNIT:E45 R12 M45 FG2 SCFP1");

  }
  
  @Test
  public void testFortvilleVernonTownshipFire() {

    doTest("T1",
        "((33216) Injured Person/1481 W 950N FORTVILLE R1B400 FORTVILLE/N 125W & N FORTVILLE PK/42) Injured Person/1481 W 950N FORTVILLE R1B400 FORTVILLE/N 125W & N FORTVILLE PK/42/ R39 S39 M5227 FFDP1/90 yr old female fell from standing position, says her hip",
        "CALL:Injured Person",
        "ADDR:1481 W 950N",
        "CITY:FORTVILLE",
        "PLACE:R1B400 FORTVILLE",
        "X:N 125W & N FORTVILLE PK",
        "MAP:42",
        "UNIT:R39 S39 M5227 FFDP1",
        "INFO:90 yr old female fell from standing position, says her hip");

    doTest("T2",
        "((31388) Medical Alarm/226 N SCHOOL ST FORTVILLE/FOOT BRIDGE & E OHIO ST/21/ S39 M5227 FF) Medical Alarm/226 N SCHOOL ST FORTVILLE/FOOT BRIDGE & E OHIO ST/21/ S39 M5227 FFDP1/no pt info no contact",
        "CALL:Medical Alarm",
        "ADDR:226 N SCHOOL ST",
        "CITY:FORTVILLE",
        "X:FOOT BRIDGE & E OHIO ST",
        "MAP:21",
        "UNIT:S39 M5227 FFDP1",
        "INFO:no pt info no contact");

    doTest("T3",
        "((30942) Investigate Gas Fumes/8780 N 200W FORTVILLE R1B445 FORTVILLE/W SR234 & W ORCHARD) Investigate Gas Fumes/8780 N 200W FORTVILLE R1B445 FORTVILLE/W SR234 & W ORCHARD DR/42/ E32 FG1 FFDP1",
        "CALL:Investigate Gas Fumes",
        "ADDR:8780 N 200W",
        "CITY:FORTVILLE",
        "PLACE:R1B445 FORTVILLE",
        "X:W SR234 & W ORCHARD DR",
        "MAP:42",
        "UNIT:E32 FG1 FFDP1");

    doTest("T4",
        "((30643) Code/610 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/21/ R39 S39 M5) Code/610 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/21/ R39 S39 M5227 FFDP1",
        "CALL:Code",
        "ADDR:610 LIGHTHOUSE DR",
        "CITY:FORTVILLE",
        "X:BEACON POINT LN & SANDY POINT LN",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T5",
        "((30449) Abdominal/1901 W 1000N FORTVILLE R2B4 FORTVILLE/N BALFER W DR & N 300W/42/ R39 S) Abdominal/1901 W 1000N FORTVILLE R2B4 FORTVILLE/N BALFER W DR & N 300W/42/ R39 S39 M5227 FFDP10/52 yr old male with ulcer - severe pain",
        "CALL:Abdominal",
        "ADDR:1901 W 1000N",
        "CITY:FORTVILLE",
        "PLACE:R2B4 FORTVILLE",
        "X:N BALFER W DR & N 300W",
        "MAP:42",
        "UNIT:R39 S39 M5227 FFDP10",
        "INFO:52 yr old male with ulcer - severe pain");

    doTest("T6",
        "((30423) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 40) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 400S/NP1/ FFDP1/working residence",
        "CALL:Structure",
        "ADDR:3906 S 450W",
        "CITY:NEW PALESTINE",
        "PLACE:R2B376 NEW PALESTINE",
        "X:W CORNERSTONE DR & W 400S",
        "MAP:NP1",
        "UNIT:FFDP1",
        "INFO:working residence");

    doTest("T7",
        "((30345) Injured Person/426 E BROADWAY ST FORTVILLE BROADWAY DINER/S WALNUT ST & S ELM ST) Injured Person/426 E BROADWAY ST FORTVILLE BROADWAY DINER/S WALNUT ST & S ELM ST/21/ R39 S39 M5227 FFDP1",
        "CALL:Injured Person",
        "ADDR:426 E BROADWAY ST",
        "CITY:FORTVILLE",
        "PLACE:BROADWAY DINER",
        "X:S WALNUT ST & S ELM ST",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

    doTest("T8",
        "((29834) Heart / Chest Pain/8394 S SHADY TRAIL DR PENDLETON/S PADDLEBOAT LN & S RISING SU) Heart / Chest Pain/8394 S SHADY TRAIL DR PENDLETON/S PADDLEBOAT LN & S RISING SUN DR/310041/SUMRLAKE/ R39 M5227 FFDP1",
        "CALL:Heart / Chest Pain",
        "ADDR:8394 S SHADY TRAIL DR",
        "CITY:PENDLETON",
        "X:S PADDLEBOAT LN & S RISING SUN DR",
        "MAP:310041",
        "UNIT:SUMRLAKE",
        "INFO:R39 M5227 FFDP1");

    doTest("T9",
        "((29613) Difficulty Breathing/310 E MILL ST FORTVILLE/S POPLAR ST & S WALNUT ST/21/ R39 S) Difficulty Breathing/310 E MILL ST FORTVILLE/S POPLAR ST & S WALNUT ST/21/ R39 S39 M5227 FFDP1/85 yr old male has been sick for a week",
        "CALL:Difficulty Breathing",
        "ADDR:310 E MILL ST",
        "CITY:FORTVILLE",
        "X:S POPLAR ST & S WALNUT ST",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1",
        "INFO:85 yr old male has been sick for a week");

    doTest("T10",
        "((28623) Heart / Chest Pain/609 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/) Heart / Chest Pain/609 LIGHTHOUSE DR FORTVILLE/BEACON POINT LN & SANDY POINT LN/21/ R39 S39 M5227 FFDP1",
        "CALL:Heart / Chest Pain",
        "ADDR:609 LIGHTHOUSE DR",
        "CITY:FORTVILLE",
        "X:BEACON POINT LN & SANDY POINT LN",
        "MAP:21",
        "UNIT:R39 S39 M5227 FFDP1");

  }
  
  @Test
  public void testBuckCreekTwpFire() {

    doTest("T1",
        "((33756) Sick / Ill Person/2290 N 600W GREENFIELD MCDONALDS / MT COMFORT RD/W JOHN L MODG) Sick / Ill Person/2290 N 600W GREENFIELD MCDONALDS / MT COMFORT RD/W JOHN L MODGLIN DR & W I70/BC2/ E71 M72 BCFP1/.",
        "CALL:Sick / Ill Person",
        "ADDR:2290 N 600W",
        "CITY:GREENFIELD",
        "PLACE:MCDONALDS",
        "X:MT COMFORT RD & W JOHN L MODGLIN DR & W I70",
        "MAP:BC2",
        "UNIT:E71 M72 BCFP1",
        "INFO:.");

    doTest("T2",
        "((33417) Sick / Ill Person/6984 W 100N GREENFIELD/N MAIELLEN DR & N 700W/BC2/ E71 M72 BCF) Sick / Ill Person/6984 W 100N GREENFIELD/N MAIELLEN DR & N 700W/BC2/ E71 M72 BCFP1/NASUA STOMACH HURTS",
        "CALL:Sick / Ill Person",
        "ADDR:6984 W 100N",
        "CITY:GREENFIELD",
        "X:N MAIELLEN DR & N 700W",
        "MAP:BC2",
        "UNIT:E71 M72 BCFP1",
        "INFO:NASUA STOMACH HURTS");

    doTest("T3",
        "((33357) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW D) Diabetic Problem/1258 S 600W NEW PALESTINE R1B354 NEW PALESTINE/W BROKEN ARROW DR & W 200S/SC1/ BCFP1/55YO MALE.",
        "CALL:Diabetic Problem",
        "ADDR:1258 S 600W",
        "CITY:NEW PALESTINE",
        "PLACE:R1B354 NEW PALESTINE",
        "X:W BROKEN ARROW DR & W 200S",
        "MAP:SC1",
        "UNIT:BCFP1",
        "INFO:55YO MALE.");

    doTest("T4",
        "((32314) Medic Transfer/801 N STATE ST GREENFIELD HANCOCK REGIONAL HOSPITAL/E BOYD AVE &) Medic Transfer/801 N STATE ST GREENFIELD HANCOCK REGIONAL HOSPITAL/E BOYD AVE & ELLIS DR/GF1/ BCFP1/going to heart center need als unit",
        "CALL:Medic Transfer",
        "ADDR:801 N STATE ST",
        "CITY:GREENFIELD",
        "PLACE:HANCOCK REGIONAL HOSPITAL",
        "X:E BOYD AVE & ELLIS DR",
        "MAP:GF1",
        "UNIT:BCFP1",
        "INFO:going to heart center need als unit");

    doTest("T5",
        "((32162) Vehicle Accident - TU/6000 W I70 GREENFIELD MM96/N 600W & N 700W/86/ E71 M71 FG1) Vehicle Accident - TU/6000 W I70 GREENFIELD MM96/N 600W & N 700W/86/ E71 M71 FG1 BCFP1/WB",
        "CALL:Vehicle Accident - TU",
        "ADDR:6000 W I70",
        "MADDR:6000 W I 70",
        "CITY:GREENFIELD",
        "PLACE:MM96",
        "X:N 600W & N 700W",
        "MAP:86",
        "UNIT:E71 M71 FG1 BCFP1",
        "INFO:WB");

    doTest("T6",
        "((32051) Medical Alarm/730 N 525W GREENFIELD R9B264A GREENFIELD/W US40 & W 100N/BC2/ E71) Medical Alarm/730 N 525W GREENFIELD R9B264A GREENFIELD/W US40 & W 100N/BC2/ E71 M72 BCFP1/medical emergency 88yo female fell an cant get up",
        "CALL:Medical Alarm",
        "ADDR:730 N 525W",
        "CITY:GREENFIELD",
        "PLACE:R9B264A GREENFIELD",
        "X:W US40 & W 100N",
        "MAP:BC2",
        "UNIT:E71 M72 BCFP1",
        "INFO:medical emergency 88yo female fell an cant get up");

    doTest("T7",
        "((31279) Code/3211 W SHARON DR GREENFIELD R9B226 GREENFIELD/N WELKER DR & DEAD END/BC2/ E) Code/3211 W SHARON DR GREENFIELD R9B226 GREENFIELD/N WELKER DR & DEAD END/BC2/ E71 M72 BCFP1/MALE SUBJ COLD UNRESPONSIVE",
        "CALL:Code",
        "ADDR:3211 W SHARON DR",
        "CITY:GREENFIELD",
        "PLACE:R9B226 GREENFIELD",
        "X:N WELKER DR & DEAD END",
        "MAP:BC2",
        "UNIT:E71 M72 BCFP1",
        "INFO:MALE SUBJ COLD UNRESPONSIVE");

    doTest("T8",
        "((31219) Vehicle Accident - TU/4000 W I70 GREENFIELD MM98/N 400W & N 500W/69/ E71 M71 FG1) Vehicle Accident - TU/4000 W I70 GREENFIELD MM98/N 400W & N 500W/69/ E71 M71 FG1 BCFP10/EB, CAR IN THE MEDIAN,",
        "CALL:Vehicle Accident - TU",
        "ADDR:4000 W I70",
        "MADDR:4000 W I 70",
        "CITY:GREENFIELD",
        "PLACE:MM98",
        "X:N 400W & N 500W",
        "MAP:69",
        "UNIT:E71 M71 FG1 BCFP10",
        "INFO:EB, CAR IN THE MEDIAN,");

    doTest("T9",
        "((31119) Difficulty Breathing/601 N SUNSET CT GREENFIELD/W SUNSET N DR & DEAD END/BC2/ E7) Difficulty Breathing/601 N SUNSET CT GREENFIELD/W SUNSET N DR & DEAD END/BC2/ E71 M72 BCFP1/77 YR OLD FEMALE",
        "CALL:Difficulty Breathing",
        "ADDR:601 N SUNSET CT",
        "CITY:GREENFIELD",
        "X:W SUNSET N DR & DEAD END",
        "MAP:BC2",
        "UNIT:E71 M72 BCFP1",
        "INFO:77 YR OLD FEMALE");

    doTest("T10",
        "((30587) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 40) Structure/3906 S 450W NEW PALESTINE R2B376 NEW PALESTINE/W CORNERSTONE DR & W 400S/NP1/ FTFDP1 GFDP1 BCFP1/working residence",
        "CALL:Structure",
        "ADDR:3906 S 450W",
        "CITY:NEW PALESTINE",
        "PLACE:R2B376 NEW PALESTINE",
        "X:W CORNERSTONE DR & W 400S",
        "MAP:NP1",
        "UNIT:FTFDP1 GFDP1 BCFP1",
        "INFO:working residence");
   
  }
  
  @Test
  public void testGreenfieldFireDepartment() {

    doTest("T1",
        "((49872) Medical Alarm/375 SHADOW CREEK PASS GREENFIELD/BRANDYWINE RIDGE & DEAD END/GF1/R) Medical Alarm/375 SHADOW CREEK PASS GREENFIELD/BRANDYWINE RIDGE & DEAD END/GF1/RIDGES/ M21 GFDP1/ALARM ACTIVATED, NO OTHER DETAILS AVAILABLE",
        "CALL:Medical Alarm",
        "ADDR:375 SHADOW CREEK PASS",
        "CITY:GREENFIELD",
        "X:BRANDYWINE RIDGE & DEAD END",
        "MAP:GF1",
        "UNIT:RIDGES",
        "INFO:M21 GFDP1 / ALARM ACTIVATED, NO OTHER DETAILS AVAILABLE");

    doTest("T2",
        "((49695) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.",
        "CALL:Heart / Chest Pain",
        "ADDR:100 FIRST APT 204",
        "UNIT:GFDP1",
        "INFO:.");

    doTest("T3",
        "((49576) Medic Assist/10450 E US40 CHARLOTTESVILLE STATION 6/S EAST ST & N 1050E/JT4/ GFD) Medic Assist/10450 E US40 CHARLOTTESVILLE STATION 6/S EAST ST & N 1050E/JT4/ GFDP1",
        "CALL:Medic Assist",
        "ADDR:10450 E US-40",
        "MADDR:10450 E US 40",
        "PLACE:CHARLOTTESVILLE STATION 6",
        "X:S EAST ST & N 1050E",
        "MAP:JT4",
        "UNIT:GFDP1");

    doTest("T4",
        "((49430) Stroke/430 W NORTH ST GREENFIELD/N NOBLE ST & SCHOOL ST/GF1/ E21 M22 GFDP1/Conc) Stroke/430 W NORTH ST GREENFIELD/N NOBLE ST & SCHOOL ST/GF1/ E21 M22 GFDP1/Conc and breathing; 92 yoa female",
        "CALL:Stroke",
        "ADDR:430 W NORTH ST",
        "CITY:GREENFIELD",
        "X:N NOBLE ST & SCHOOL ST",
        "MAP:GF1",
        "UNIT:E21 M22 GFDP1",
        "INFO:Conc and breathing; 92 yoa female");

    doTest("T5",
        "((49378) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private num) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private number, alot of background noise",
        "CALL:Stroke",
        "ADDR:8659 E 150S",
        "CITY:GREENFIELD",
        "X:S 850E & S 900E",
        "MAP:BR4",
        "UNIT:GFDP1",
        "INFO:transfered, private number, alot of background noise");

    doTest("T6",
        "((49255) Injured Person/710 BROOK ST LOT 15 GREENFIELD WILFONG TRAILER COURT/TAGUE ST & D) Injured Person/710 BROOK ST LOT 15 GREENFIELD WILFONG TRAILER COURT/TAGUE ST & DEAD END/GF1/ M21 GFDP1/elderly male and female fell they state that they are in",
        "CALL:Injured Person",
        "ADDR:710 BROOK ST",
        "APT:15",
        "CITY:GREENFIELD",
        "PLACE:WILFONG TRAILER COURT",
        "X:TAGUE ST & DEAD END",
        "MAP:GF1",
        "UNIT:M21 GFDP1",
        "INFO:elderly male and female fell they state that they are in");

    doTest("T7",
        "((49152) Structure ALARM/210 W MAIN ST GREENFIELD BRADLEY METHODIST CHURCH/S PENNSYLVAN) Structure ALARM/210 W MAIN ST GREENFIELD BRADLEY METHODIST CHURCH/S PENNSYLVANIA ST & RILEY AVE/GF1/ E21 TOW21 M22 FG2 GFDP1/no key holder",
        "CALL:Structure ALARM",
        "ADDR:210 W MAIN ST",
        "CITY:GREENFIELD",
        "PLACE:BRADLEY METHODIST CHURCH",
        "X:S PENNSYLVANIA ST & RILEY AVE",
        "MAP:GF1",
        "UNIT:E21 TOW21 M22 FG2 GFDP1",
        "INFO:no key holder");

    doTest("T8",
        "((49100) Difficulty Breathing/270 N MERIDIAN RD GREENFIELD/WINFIELD PARK DR & W LIBERTY L) Difficulty Breathing/270 N MERIDIAN RD GREENFIELD/WINFIELD PARK DR & W LIBERTY LN/GF1/ E21 M21 GFDP1/69",
        "CALL:Difficulty Breathing",
        "ADDR:270 N MERIDIAN RD",
        "CITY:GREENFIELD",
        "X:WINFIELD PARK DR & W LIBERTY LN",
        "MAP:GF1",
        "UNIT:E21 M21 GFDP1",
        "INFO:69");

    doTest("T9",
        "((49003) Unconscious Person/2488 E EDEN RD GREENFIELD R5B152 GREENFIELD/N SR9 & N 250E/GT) Unconscious Person/2488 E EDEN RD GREENFIELD R5B152 GREENFIELD/N SR9 & N 250E/GT1/ GFDP1/male subj passed out",
        "CALL:Unconscious Person",
        "ADDR:2488 E EDEN RD",
        "CITY:GREENFIELD",
        "PLACE:R5B152 GREENFIELD",
        "X:N SR9 & N 250E",
        "MAP:GT1",
        "UNIT:GFDP1",
        "INFO:male subj passed out");

    doTest("T10",
        "((48927) Carbon Monoxide Alarm/2222 N HICKORY BLV GREENFIELD/E NEW RD & E HILL DR/CT5/ E2) Carbon Monoxide Alarm/2222 N HICKORY BLV GREENFIELD/E NEW RD & E HILL DR/CT5/ E22 M22 GFDP1/CALLED IN BY STATION 22",
        "CALL:Carbon Monoxide Alarm",
        "ADDR:2222 N HICKORY BLV",
        "MADDR:2222 N HICKORY BLVD",
        "CITY:GREENFIELD",
        "X:E NEW RD & E HILL DR",
        "MAP:CT5",
        "UNIT:E22 M22 GFDP1",
        "INFO:CALLED IN BY STATION 22");

    doTest("T11",
        "((49378) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private num) Stroke/8659 E 150S GREENFIELD/S 850E & S 900E/BR4/ GFDP1/transfered, private number, alot of background noise",
        "CALL:Stroke",
        "ADDR:8659 E 150S",
        "CITY:GREENFIELD",
        "X:S 850E & S 900E",
        "MAP:BR4",
        "UNIT:GFDP1",
        "INFO:transfered, private number, alot of background noise");

    doTest("T12",
        "((51027) Unconscious Person/205 WHITE ST SHIRLEY/SOUTH ST & CENTER ST/SF1/ GFDP1/possible) Unconscious Person/205 WHITE ST SHIRLEY/SOUTH ST & CENTER ST/SF1/ GFDP1/possible unconscious subject on the floor in the house,",
        "CALL:Unconscious Person",
        "ADDR:205 WHITE ST",
        "CITY:SHIRLEY",
        "X:SOUTH ST & CENTER ST",
        "MAP:SF1",
        "UNIT:GFDP1",
        "INFO:possible unconscious subject on the floor in the house,");

    doTest("T13",
        "((49695) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.) Heart / Chest Pain/100 FIRST APT.204// GFDP1/.",
        "CALL:Heart / Chest Pain",
        "ADDR:100 FIRST APT 204",
        "UNIT:GFDP1",
        "INFO:.");

  }
  
  public static void main(String[] args) {
    new INHancockCountyParserTest().generateTests("T1");
  }
}