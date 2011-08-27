package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*    
THIS PARSER HAS BEEN REPLACED

Alleghany County, MD
Contact: Joseph Hoffman <Jphoffman0@frostburg.edu>
Sender: unpredicatable
FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100110-96\nMSG:UNCONCIOUS/UNRESPONSIVE 91 S BROADWAY\nUnits: A53 CO16
FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100710-102\nMSG:AUTOMATIC HOUSE ALARM 106 SUNSET DR\nUnits: CO2 ENG9 A52 TR16
FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 101310-67\nMSG:HOUSE FIRE           147 ORMAND ST\nUnits: ENG16 TR16 ENG17
FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 101510-80\nMSG:HOUSE FIRE           72 HOSPITAL ROAD\nUnits: ENG16 TR16 ENG17
FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100210-88\nMSG:SMOKE INVESTIGATION  U:LOWER CONSEL RD\nUnits: CO16

WARNING!!  Sending the following message crashes the emulator
FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 110510-132\nMSG:AUTOMATIC HOUSE ALARM 150 MAPLE ST\x09Units: ENG16 TR16 ENG17

That is how everything looks when it is received.  After running through the
descrambler, what gets to the parser is
Sender: LogiSYSCAD
CAD Page for CFS 100110-96
  UNCONCIOUS/UNRESPONSIVE 91 S BROADWAY\nUnits: A53 CO16
CAD Page for CFS 100710-102
  AUTOMATIC HOUSE ALARM 106 SUNSET DR\nUnits: CO2 ENG9 A52 TR16
CAD Page for CFS 101310-67
  HOUSE FIRE           147 ORMAND ST\nUnits: ENG16 TR16 ENG17
CAD Page for CFS 101510-80
  HOUSE FIRE           72 HOSPITAL ROAD\nUnits: ENG16 TR16 ENG17
CAD Page for CFS 100210-88
  SMOKE INVESTIGATION  U:LOWER CONSEL RD\nUnits: CO16
CAD Page for CFS 110510-132
  AUTOMATIC HOUSE ALARM 150 MAPLE ST\x09Units: ENG16 TR16 ENG17
 
Contact: Chris Green <mediccgreen@gmail.com>
Sender: LogiSYS  
LogiSYSCAD S:CAD Page for CFS 051211-55 M:SERVICE CALL NOT LISTED NEW CREEK                                       Units: A50     \n
LogiSYS  S:CAD Page for CFS 060811-52 M:CHEST PAINS/HEART PROBLEMS 81 E MECHANIC ST                                Units: 355     \n\n
  
*/

public class MDAlleganyCountyOldParser extends FieldProgramParser {
  
  public MDAlleganyCountyOldParser() {
    super("ALLEGANY COUNTY", "MD",
           "ADDR/SC Units:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "LogiSYS";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("CAD Page for CFS ")) return false;
    data.strCallId = subject.substring(17).trim();
    
    body = body.replaceAll("\\s+", " ");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      // Address may be separated by a U: marker
      int pt = field.indexOf(" U:");
      if (pt >= 0) {
        data.strCall = field.substring(0, pt).trim();
        parseAddress(field.substring(pt+3).trim(), data);;
      }
      
      // Otherwise invoke the smart parser to split the call from the address
      else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
