package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/*    
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
*/

public class MDAlleganyCountyParser extends SmartAddressParser {
  
  public MDAlleganyCountyParser() {
    super("ALLEGANY COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "LogiSYSCAD";
  }
  
  @Override
  protected boolean parseSubject(String subject, Data data) {
    if (! subject.startsWith("CAD Page for CFS ")) return false;
    data.strCallId = subject.substring(17).trim();
    return true;
  }
  
  

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    body = body.replaceAll("\t", "\n");
    Properties props = parseMessage("MSG:" + body, "\n");
    
    // MSG: line contains call description and address.
    // The separator can be several different things
    String line = props.getProperty("MSG", "");
    
    // Address may be separated by a U: marker
    int pt = line.indexOf(" U:");
    if (pt >= 0) {
      data.strCall = line.substring(0, pt).trim();
      parseAddress(line.substring(pt+3).trim(), data);;
    }
    
    // Otherwise invoke the smart parser to split the call from the address
    else {
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, line, data);
    }
    
    // UNITS: line contains the units
    data.strUnit = props.getProperty("Units", "");
    return true;
  }
}
