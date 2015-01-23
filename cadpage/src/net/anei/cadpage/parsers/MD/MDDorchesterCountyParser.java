package net.anei.cadpage.parsers.MD;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MDDorchesterCountyParser extends FieldProgramParser {

  public MDDorchesterCountyParser(){
    super(CITY_CODE_TABLE, "DORCHESTER COUNTY", "MD",
           "CT:ADDR/S0L! BOX:BOX! DUE:UNIT!");
    addNauticalTerms();
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "CABIN CREEK HURLOCK",
        "CASTLE HAVEN",
        "CHURCH CREEK",
        "DORCHESTER SQUARE",
        "EDLON PARK",
        "GLORIA RICHARDSON",
        "GOLDEN HILL",
        "HOOPERS ISLAND",
        "PALMERS MILL",
        "PINE TOP",
        "ROBBINS FARM",
        "ROLLING ACRES",
        "SANDY ACRES",
        "SANDY HILL",
        "SCHOOL HOUSE",
        "SHILOH CHURCH HURLOC",
        "WEST VIEW"
    );
  }
  
  public String getFilter() {
    return "dor911@docogonet.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("DOR911:")) {
      body = body.substring(7).trim();
      if (!body.startsWith("CT:")) body = "CT:" + body;
    }
    if (body.endsWith(":DC")) body = body.substring(0,body.length()-3).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return addr.replace("DORCHESTER SQUARE MALL", "DORCHESTER SQUARE");
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "911 TEST CALL",
      "ABDOMINAL PAINS",
      "ASSAULT/SEXUAL ASSLT",
      "BACK PAIN-NONTRAUMA",
      "BOAT UNK DISTRESS",
      "BREATHING PROBLEMS",
      "CHEST PAIN",
      "CHEST PAINS",
      "CHOKING",
      "COMMERCIAL BUILDING",
      "COMMERCIAL FIRE ALAR",
      "CONVULSIONS/SEIZURES",
      "DIABETIC PROBLEMS",
      "EYE PROBLEM/INJURY",
      "FALLS",
      "GAS LEAK OUTSIDE",
      "HEADACHE",
      "HEART PROBLEMS",
      "MEDICAL ASSIST",
      "MOTOR VEH. COLLISION",
      "OVERDOSE/POISONING",
      "PAGER TEST",
      "PREG/CHILDBIRTH/MATR",
      "RESIDENTIAL FIRE ALA",
      "SICK PERSON",
      "SINKING VEHICLE",
      "(SMALL) FUEL SPILL",
      "STAB/GUNSHOT/PENETRA",
      "STANDBY",
      "STROKE (CVA)",
      "STRUCTURE FIRE",
      "TRANSFER",
      "UNCONSCIOUS/FAINTING",
      "UNKNOWN PROBLEM",
      "VEHICLE FIRE HARDEES"
  );
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
        "CAMB", "CAMBRIDGE",
        "CHUR", "CHURCH CREEK",
        "FEDE", "FEDERALSBURG",
        "HURL", "HURLOCK",
        "LINK", "LINKWOOD",
        "SECR", "SECRETARY",
        "VIEN", "VIENNA"
    });
}