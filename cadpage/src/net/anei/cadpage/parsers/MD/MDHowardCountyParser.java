package net.anei.cadpage.parsers.MD;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*    
Howard County, MD
Contact: "Committee, Equipment" <equipment@fdvfd.com>
Contact: "McNeece, John" <jmcneece@mfri.org>
Sender: Rc.261@c-msg.net

[CAD] RT 32/LINDEN CHURCH RD WS CLK TYPE: RESCUE--UNKNOW @ 23:29:39 BEAT/BOX: 032119
[CAD] 14470 TRIADELPHIA MILL RD DYTN TYPE: WIRES-WIRES @ 13:52:21 BEAT/BOX: 0540
[CAD] 6005 DAYBREAK CIR CLK: @RIVER HILL VC TYPE: LOCKV-ANIMAL @ 12:13:57 BEAT/BOX: 0501
[CAD] 6348 MORNING TIME LN WCOL TYPE: MEDICAL-BLS-COLD @ 13:59:49 BEAT/BOX: 0561
[CAD] RT 32/ROSEMARY LN ECW TYPE: RESCUE--UNKNOW @ 06:03:24 BEAT/BOX: 032145
[CAD] 12700 HALL SHOP RD HIGH: @SAINT MARKS EPISCOPAL CHURCH TYPE: GASLEAK-OUTSIDE/FIRE @ 01:28:32 BEAT/BOX: 0564
[CAD] 5764 STEVENS FOREST RD ECOL,111: @GRANDE POINT APARTMENTS TYPE: SMOKE-INSIDE/HIGHOCC @ 23:28:39 BEAT/BOX: 0908
[CAD] 14101 HOWARD RD DYTN: @SMITH RESIDENCE TYPE: MEDICAL-*********** @ 08:30:53 BEAT/BOX: 0545
(CAD) [CAD] EVENT: F11023456 7110 MINSTREL WAY ECOL: @BRIGHTON GARDENS TYPE: SMOKE-INSIDE/HIGHOCC @ 10:38:22 BEAT/BOX: 1034
(CAD) [CAD] EVENT: F11023457 RT 29 SB/RIVERS EDGE RD SCOL TYPE: RESCUE--UNKNOW @ 10:56:54 BEAT/BOX: 029086
 
*/

public class MDHowardCountyParser extends FieldProgramParser {
  
  public MDHowardCountyParser() {
    super(CITY_CODES, "HOWARD COUNTY", "MD",
           "ADDR/S! TYPE:CALL! BEAT/BOX:BOX!");
  }
  
  @Override
  public String getFilter() {
    return "Rc.261@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("CAD")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      boolean id = field.startsWith("EVENT: ");
      if (id) field = field.substring(7).trim();
      Parser p = new Parser(field);
      if (id) data.strCallId = p.get(' ');
      data.strPlace = p.getLastOptional(": @");
      data.strApt = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ID " + super.getFieldNames() + " APT PLACE";
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('@');
      if (pt < 0) abort();
      field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ANNJ", "ANNAPOLIS JUNCTION",
      "BWI",  "BWI AIRPORT",
      "CLK",  "CLARKSVILLE",
      "COOK", "COOKSVILLE",
      "DYTN", "DAYTON",
      "EC",   "ELLICOTT CITY",
      "ECOL", "COLUMBIA",
      "ECW",  "ELLICOTT CITY",
      "ELK",  "ELKRIDGE",
      "FULT", "FULTON",
      "GLNG", "GLENELG",
      "GLWD", "GLENWOOD",
      "HANR", "HANOVER",
      "HIGH", "HIGHLAND",
      "JSSP", "JESSUP",
      "LAUR", "LAUREL",
      "MARR", "MARRIOTTSVILLE",
      "MTAR", "MOUNT AIRY",
      "SAVG", "SAVAGE",
      "SCOL", "COLUMBIA",
      "SYKE", "SYKESVILLE",
      "WCOL", "COLUMBIA",
      "WDBN", "WOODBINE",
      "WDSK", "WOODSTOCK",
      "WF",   "WEST FRIENDSHIP",
     
  });
}
