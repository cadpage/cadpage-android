package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Trumbull County, OH
Contact: George Beck <hfd130.gb@gmail.com>
System: Vision Air
Sender: 911no@co.trumbull.oh.us
FRM:911no@co.trumbull.oh.us\nMSG:*2350 NILES CORTLAND RD SE, HOWLAND TWP, OH***FIRE INFORMATION***STA30***//**ALARM SYSTEM OFF LINE TILL  0900 TOMORROW
FRM:911no@co.trumbull.oh.us\nMSG:*8164 CHERRY HILL DR NE, HOWLAND TWP, OH***GENERAL ILLNESS***STA30***ELMWOOD AVE NE//CRANBROOK AVE\n(Con't) 2 of 2\nNE**PAIN IN SIDE AND HEADACHE//  63 YOF(End)
1 of 3\nFRM:911no@co.trumbull.oh.us\nMSG:*8235 FAIRHILL DR NE, HOWLAND TWP, OH***EMS UNKNOWN PROBLEM/UNCLASSIFIED***STA30***LONGVIEW DR\n(Con't) 2 of 3\nNE//TIMBERLANE ST NE**80 YOF THAT HAS DEMENTIA HAS BEEN BATTLING CALLER ALL NITE.DOES NOT HAVE ANY MEDICATIONS TO CALM HER  PER DR  REQ\n(Con't) 3 of 3\nTRANSPORTED(End)

Contact: Active911
[] *902 S IRVINE AVE SE, BROOKFIELD TWP, OH***ELECTRICAL FIRE***STA18***ROBERTS ST SE//S IRVINE AVE SE**CALLER ADV LIGHTNING JUST STRUCK THE TELEPHONE POLE NEAR THE CIRCLE K ON 62 AND THE TRANSFORMER EXPLODED // UNK IF ON FIRE\r\n\r\n\r\n
[] *YOUNGSTOWN CONNEAUT RD/KING GRAVES RD NE, YANKEE LAKE***TRAFFIC REGULATION COMPLAINT***STA18***//**KINGS GRAVES W ST RTE 7 FOR BRANCH IN RDWAY\r\n\r\n\r\n
[] *6567 KING GRAVES RD NE, HARTFORD TWP, OH***FALL***STA18***NORTH ALBRIGHT MCKAY RD NE//**89YOM FELL IN THE BATHROOM AN HOUR AGO AND IS STILL DOWN// SAYS BACK HURTS\r\n\r\n\r\n
[] *6034 MERWIN CHASE RD NE, BROOKFIELD TWP, OH***EMS UNKNOWN PROBLEM/UNCLASSIFIED***STA18***WARNER RD NE//NORTH ALBRIGHT MCKAY RD NE**79 YOF WITH SHARP IN RIGHT   SIDE..\r\n\r\n\r\n
[] *6812 WARREN SHARON RD, BROOKFIELD TWP, OH***DIABETIC***STA18***SEABORN ST SE//ST RTE 7 SE**46 YOM DIABETIC PROBLEM\r\n\r\n\r\n
[] *8055 ADDISON RD SE, BROOKFIELD TWP, OH***EMERGENCY MEDICAL ASSISTANCE***STA18***ST RTE 82//HILLTOP GARDENS APARTMENTS**\r\n\r\n\r\n

*/

public class OHTrumbullCountyParser extends FieldProgramParser {
  
  public OHTrumbullCountyParser() {
    super("TRUMBULL COUNTY", "OH", 
           "ADDR APT EMPTY+? CALL! EMPTY+? SRC EMPTY+? X EMPTY+? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911no@co.trumbull.oh.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("*")) return false;
    return parseFields(body.substring(1).trim().split("\\*"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (city.equals("OH")) city = p.getLastOptional(',');
      if (city.length() == 0) abort();
      data.strCity = city;
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "/");
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
