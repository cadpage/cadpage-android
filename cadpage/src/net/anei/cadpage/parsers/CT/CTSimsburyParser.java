package net.anei.cadpage.parsers.CT;


import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Simsbury, CT
Contact: Andrew Gaines <againes128@gmail.com>
System: Inforad
From: 93001001 - 93001050

8 ROSWELL RD Suite: 1 TYPE:SF new oven making noises smells like burning rubber
530 BUSHY HILL RD Suite: 03 TYPE:FA
235 FARMS VILLAGE RD TYPE:VA 2 CAR MVA WITH FLUIDS
BUSHY HILL RD&OVERLOOK TER TYPE:VR. REPORTED PARTY ENTRAPT
57 WEST MOUNTAIN RD TYPE:VA CAR OFF ROAD INTO TREE. POLICE ON SCENE REQ FD
7 WHITNEY LA TYPE:SA smell of smoke in area - can see "film" in air
HOPMEADOW ST&WOODLAND ST TYPE:PA Truck hit telephone pole south of Woodland Street across from DB breaking the guide wire. Police re quest FD check pole.
4 BROOK RIDGE TYPE:FA CALLED IN BY ALARM COMPANY
12 CRANE PL TYPE:LS life star, end of cul de sac
BUSHY HILL RD&ALBANY TNPK TYPE:VR mva rollover w/extrication

*/

public class CTSimsburyParser extends FieldProgramParser {
  
  public CTSimsburyParser() {
    super("SIMSBURY", "CT",
          "ADDR! Suite:APT? TYPE:CALL!");
  }

  @Override
  public String getFilter() {
    return "93001";
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String code = p.get(' ');
      if (code.endsWith(".")) code = code.substring(0,code.length()-1);
      String call = CALL_CODES.getProperty(code);
      if (call != null) {
        data.strCode = code;
        data.strCall = call;
        data.strSupp = p.get();
      } else { 
        data.strCall = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "BF",    "Brush Fire",
      "CO",    "Carbon Monoxide",
      "DW",    "Down Wires",
      "FA",    "Fire Alarm",
      "HMSM",  "Hazmat Small",
      "HMLG",  "Hazmat Large",
      "LS",    "Lift Star",
      "MR",    "Mountain Rescue",
      "MA",    "Mutual Aid",
      "OG",    "Odor of Gas",
      "PA",    "Police Assist",
      "RF",    "Rubbish Fire",
      "SA",    "Smoke Alarm",
      "SF",    "Structure Fire",
      "VA",    "Vehicle Accident",
      "VR",    "Vehicle Rescue",
      "WB",    "Water in Building",
      "WR",    "Water Rescue",
  });
}
