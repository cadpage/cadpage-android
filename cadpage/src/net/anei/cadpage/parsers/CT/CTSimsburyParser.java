package net.anei.cadpage.parsers.CT;


import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CTSimsburyParser extends FieldProgramParser {
  
  public CTSimsburyParser() {
    super("SIMSBURY", "CT",
          "ADDR! Suite:APT? TYPE:CALL!");
  }

  @Override
  public String getFilter() {
    return "93001,6245";
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
      "SA",    "Smoke in Area",
      "SF",    "Structure Fire",
      "VA",    "Vehicle Accident",
      "VR",    "Vehicle Rescue",
      "WB",    "Water in Building",
      "WR",    "Water Rescue",
  });
}
