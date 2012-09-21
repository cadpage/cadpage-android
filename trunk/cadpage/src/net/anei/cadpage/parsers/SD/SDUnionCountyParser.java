package net.anei.cadpage.parsers.SD;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Union County, SD
Contact: Active911
Agency name: North Sioux City Fire Rescue Location: North SIoux City, SD 
Sender: WCICC3@sioux-city.org

(J:SICK PERSON/212 E SAWGRASS TRL DAKOTA DUNES/DAKOTA DUNES BLVD & PEBBLE BEACH DR/) SICK PERSON/212 E SAWGRASS TRL DAKOTA DUNES/DAKOTA DUNES BLVD & PEBBLE BEACH DR/DDUNES/ 72EMS9/CANCER PATIENT--58YR FEMALE
(J:FIRE ALARM/663 W SAWGRASS TRL DAKOTA DUNES/FIRETHORN TRL & SPYGLASS CIR/DDUNES/) FIRE ALARM/663 W SAWGRASS TRL DAKOTA DUNES/FIRETHORN TRL & SPYGLASS CIR/DDUNES/ 72E5/HOUSE SMOKE DETECTORS---HESSE RES
(J:GRASS FIRE/1 UNKNOWN ST NORTH SIOUX UNKNS/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q) GRASS FIRE/1 UNKNOWN ST NORTH SIOUX UNKNS/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/COUNTY RD 23  IN 2 DIFF SPOTS FIRE S THAT ARE 200SQ FT
(J:CHEST PAIN/23 COTTS DR NORTH SIOUX/RIVER DR &/NSIOUX/ 72EMS9/CHEST PAINS SINCE A) CHEST PAIN/23 COTTS DR NORTH SIOUX/RIVER DR &/NSIOUX/ 72EMS9/CHEST PAINS SINCE ABOUT 0630  OPEN HEART SURG IN 1999
(J:CHEST PAIN/575 SIOUX POINT RD DAKOTA DUNES CNOS/DAKOTA DUNES BLVD & W ANCHOR DR/) CHEST PAIN/575 SIOUX POINT RD DAKOTA DUNES CNOS/DAKOTA DUNES BLVD & W ANCHOR DR/DDUNES/ 72EMS9/USE BACK DOOR
(J:FIRE ALARM/573 MONTEREY TRL DAKOTA DUNES/W PINEHURST TRL & DEAD END ST/DDUNES/ 7) FIRE ALARM/573 MONTEREY TRL DAKOTA DUNES/W PINEHURST TRL & DEAD END ST/DDUNES/ 72F7 72E5/HEATHER & TODD JOHNSON RES, COVERS POOL EQUIPMENT ROOM
(J:FIRE ALARM/705 SIOUX POINT RD DAKOTA DUNES PRODIGY LEARNING CENTER/W ANCHOR DR &) FIRE ALARM/705 SIOUX POINT RD DAKOTA DUNES PRODIGY LEARNING CENTER/W ANCHOR DR & W FLURIE RD/DDUNES/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/GENERAL FIRE ALARM
(J:FIRE ALARM/915 WILLOW CIR DAKOTA DUNES/DDUNES/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 7) FIRE ALARM/915 WILLOW CIR DAKOTA DUNES/DDUNES/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/NORTH SIOUX CITY    DR ROBERT ZIMMERMAN RES  BASEMENT SMOKE
(J:FIRE ALARM/509 PRAIRIE PASS DAKOTA DUNES/SUNSET DR & DEAD END/DDUNES/ 72B1 72EMS) FIRE ALARM/509 PRAIRIE PASS DAKOTA DUNES/SUNSET DR & DEAD END/DDUNES/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/2ND FLOOR SMOKE     CHUCK LONG RES
(J:CHEST PAIN/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITARY) CHEST PAIN/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITARY RD/NSIOUX/ 72EMS9/Using ProQA Medical
(J:INJURED/FALL/67 NORTHSHORE DR NORTH SIOUX/PENROSE DR & WESTWOOD LN/NSIOUX/ 72EMS) INJURED/FALL/67 NORTHSHORE DR NORTH SIOUX/PENROSE DR & WESTWOOD LN/NSIOUX/ 72EMS9/82YR FEMALE UNABLE TO GET UP FROM THE RECLINER--PAST FALL
(J:CONVULSIONS/SEIZURES/367 LAKESHORE DR NORTH SIOUX/WYCOFF DR & ALCOMA DR/NSIOUX/) CONVULSIONS/SEIZURES/367 LAKESHORE DR NORTH SIOUX/WYCOFF DR & ALCOMA DR/NSIOUX/ 72EMS9/10MO CHILD
(J:CHEST PAIN/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72EMS9/N OF WATER TOWER M HAVI) CHEST PAIN/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72EMS9/N OF WATER TOWER M HAVING HEART ATTACK 65YO M NOT CONS
(J:FIRE SM VEHICLE/4 I29 .2 NORTH SIOUX EXIT 4 MCCOOK LAKE/NORTHSHORE DR &/NSIOUX/) FIRE SM VEHICLE/4 I29 .2 NORTH SIOUX EXIT 4 MCCOOK LAKE/NORTHSHORE DR &/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/SMOKE FROM ENGINE.
(J:INJURED/FALL/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITA) INJURED/FALL/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITARY RD/NSIOUX/ 72EMS9/Using ProQA Medical
(J:HEAT/COLD EXPOSURE/80 NORTHSHORE DR NORTH SIOUX DAKOTA VALLEY ELEMENTARY/WESTWOO) HEAT/COLD EXPOSURE/80 NORTHSHORE DR NORTH SIOUX DAKOTA VALLEY ELEMENTARY/WESTWOOD LN & SUNCOAST DR/NSIOUX/ 72EMS9/Using ProQA Medical
(J:FIRE OTHER/300 N MERRILL AVE NORTH SIOUX & MALLARD DR/NSIOUX/ 72B1 72EMS9 72E4 7) FIRE OTHER/300 N MERRILL AVE NORTH SIOUX & MALLARD DR/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/IN THE BACK BY THE DUMPSTER IS ON FIRE
(J:GRASS FIRE/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q) GRASS FIRE/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/312 W PELLA DAKOTA DUNES GRASS FIRE. SPREADING QUICKLY.
(J:GRASS FIRE/100 DORAL LN DAKOTA DUNES/DDUNES/ 72B1 72F7/GRASS FIRE IN THE DITCH) GRASS FIRE/100 DORAL LN DAKOTA DUNES/DDUNES/ 72B1 72F7/GRASS FIRE IN THE DITCH
(J:GRASS FIRE/851 E SAWGRASS TRL DAKOTA DUNES/DAKOTA DUNES BLVD & PEBBLE BEACH DR/D) GRASS FIRE/851 E SAWGRASS TRL DAKOTA DUNES/DAKOTA DUNES BLVD & PEBBLE BEACH DR/DDUNES/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/FIRE IN TREE
(J:GRASS FIRE/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72E5/BY STARS AND STRIPES FIRE) GRASS FIRE/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72E5/BY STARS AND STRIPES FIREWORKS GRASS ON FIRE
(J:GRASS FIRE/1150 NORTHSHORE DR NORTH SIOUX DAKOTA VALLEY HIGH SCHOOL/SUNCOAST DR) GRASS FIRE/1150 NORTHSHORE DR NORTH SIOUX DAKOTA VALLEY HIGH SCHOOL/SUNCOAST DR & WESTSHORE DR/NSIOUX/ 72B1/BY DEER RUN   GRASS FIRE   JUST WEST OF THE HIGH SCHOOL
(J:GRASS FIRE/1 NORTHSHORE DR NORTH SIOUX & HIGHWAY 105/NSIOUX/ 72B1/BY LANTIS AGAI) GRASS FIRE/1 NORTHSHORE DR NORTH SIOUX & HIGHWAY 105/NSIOUX/ 72B1/BY LANTIS AGAIN NORTHSHORE AND HWY 105
(J:FIRE/463 PRAIRIE PASS DAKOTA DUNES/SUNSET DR & DEAD END/DDUNES/ 72B1 72EMS9 72E4) FIRE/463 PRAIRIE PASS DAKOTA DUNES/SUNSET DR & DEAD END/DDUNES/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/ROOF IS ON FIRE THEY HAVE WOOD SHINGLES
(J:GRASS FIRE/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q) GRASS FIRE/3 UNKNOWN ST NORTH SIOUX UNK72/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/BY THE MCCOOK EXIT ... FIREWORKS STAND .. HUGE FIRE HERE
(J:FIRE/1120 WASHINGTON ST NORTH SIOUX/PEARL ST & MILITARY RD/NSIOUX/ 72B1 72EMS9 7) FIRE/1120 WASHINGTON ST NORTH SIOUX/PEARL ST & MILITARY RD/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/REKINDLING, RES IS SMOKING
(J:FIRE OTHER/105 S DERBY LN NORTH SIOUX PRONTO EXPRESS/RIVER DR &/NSIOUX/ 72B1 72E) FIRE OTHER/105 S DERBY LN NORTH SIOUX PRONTO EXPRESS/RIVER DR &/NSIOUX/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/NEED ASSISTANCE
(J:INJURED/FALL/400 RIVER DR NORTH SIOUX & LLOYD AVE/NSIOUX/ 72EMS9/Using ProQA Med) INJURED/FALL/400 RIVER DR NORTH SIOUX & LLOYD AVE/NSIOUX/ 72EMS9/Using ProQA Medical
(J:INJURED/FALL/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITA) INJURED/FALL/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITARY RD/NSIOUX/ 72EMS9/62 YO FEMALE
(J:CONVULSIONS/SEIZURES/367 LAKESHORE DR NORTH SIOUX/WYCOFF DR & ALCOMA DR/NSIOUX/) CONVULSIONS/SEIZURES/367 LAKESHORE DR NORTH SIOUX/WYCOFF DR & ALCOMA DR/NSIOUX/ 72EMS9/Using ProQA Medical
(J:LIFELINE/79 NORTHSHORE DR NORTH SIOUX/WESTWOOD LN & SUNCOAST DR/NSIOUX/ 72EMS9/S) LIFELINE/79 NORTHSHORE DR NORTH SIOUX/WESTWOOD LN & SUNCOAST DR/NSIOUX/ 72EMS9/SPOKE TO ELEANOR CANTRELL, ALOT OF PAIN IN LEFT ARM, DIZZY
(J:HEART PROBLEMS/120 MERRILL AVE NORTH SIOUX/RIVER DR & CAMPBELL ST/NSIOUX/ 72EMS9) HEART PROBLEMS/120 MERRILL AVE NORTH SIOUX/RIVER DR & CAMPBELL ST/NSIOUX/ 72EMS9/Using ProQA Medical
(J:LIFT ASSISTANCE/301 DAKOTA DUNES BLVD APT24 DAKOTA DUNES STONEYBROOK SUITES/SIOU) LIFT ASSISTANCE/301 DAKOTA DUNES BLVD APT24 DAKOTA DUNES STONEYBROOK SUITES/SIOUX POINT RD & COURTYARD DR/DDUNES/ 72EMS9/REFUSING MEDICAL
(J:CHEST PAIN/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITARY) CHEST PAIN/1 DEVILSFOOD DR NORTH SIOUX INTERBAKE FOODS INC/N DERBY LN & MILITARY RD/NSIOUX/ 72EMS9/STABBIGN PAIN IN L SHOULDER ARM
(J:FIRE ALARM/575 SIOUX POINT RD DAKOTA DUNES CNOS/DAKOTA DUNES BLVD & W ANCHOR DR/) FIRE ALARM/575 SIOUX POINT RD DAKOTA DUNES CNOS/DAKOTA DUNES BLVD & W ANCHOR DR/DDUNES/ 72B1 72EMS9 72E4 72E5 72F7 72Q6 72R8/575 NORTH SIOUX POINT RD.COVERING GENERAL.NO CONTACT
(J:INJURED/FALL/220 S DERBY LN LOT57 NORTH SIOUX COTTONWOOD TRAILER COURT/NSIOUX/ 7) INJURED/FALL/220 S DERBY LN LOT57 NORTH SIOUX COTTONWOOD TRAILER COURT/NSIOUX/ 72EMS9/Using ProQA Medical
(J:UNCONSCIOUS/FAINTING/675 STREETER DR NORTH SIOUX KOA CAMPGROUND/NSIOUX/ 72EMS9/F) UNCONSCIOUS/FAINTING/675 STREETER DR NORTH SIOUX KOA CAMPGROUND/NSIOUX/ 72EMS9/F FEEL OFF BIKE ON BIKE PATH. UNCON & UNK BREATHIN
(J:SICK PERSON/1300 RIVER DR NORTH SIOUX SUPER 8 MOTEL/STREETER DR & SODRAC DR/NSIO) SICK PERSON/1300 RIVER DR NORTH SIOUX SUPER 8 MOTEL/STREETER DR & SODRAC DR/NSIOUX/ 72EMS9/JUV FEMALE OUT OF CONTROL & PD WANTS HER CK D OUT

*/

public class SDUnionCountyParser extends FieldProgramParser {
  
  public SDUnionCountyParser() {
    super(CITY_LIST, "UNION COUNTY", "SD",
           "CALL+? ADDR/SXP X/Z? SRC UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "WCICC3@sioux-city.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("J:")) return false;
    return super.parseFields(body.split("/"), 5, data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "/", field);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("&")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      String city = STATION_CODES.getProperty(field);
      if (city == null) return false;
      data.strSource = field;
      if (data.strCity.length() == 0) data.strCity = city;
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALCESTER",
    "ALSEN",
    "BERESFORD",
    "DAKOTA DUNES",
    "ELK POINT",
    "GARRYOWEN",
    "JEFFERSON",
    "NORA",
    "NORTH SIOUX",
    "RICHLAND",
    "SPINK"
  };
  
  private static final Properties STATION_CODES = buildCodeTable(new String[]{
      "DDUNES", "DAKOTA DUNES",
      "NSIOUX", "NORTH SIOUX"
  });
}
